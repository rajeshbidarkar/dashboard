package com.spring.controller;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.spring.constants.Constant;
import com.spring.models.SOWMaster;
import com.spring.service.AuthenticateService;
import com.spring.service.SOWService;
import io.jsonwebtoken.Jwts;
import javassist.tools.rmi.ObjectNotFoundException;

@Controller
public class SOWController {
	private Set<SOWMaster> sowList = new HashSet<SOWMaster>();
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private SOWService sowService;
	
	@Autowired
	AuthenticateService authenticateService;
	
	@Autowired
	Util util;

	
	public SOWController(){
	}
	
				   
	@RequestMapping(value = "/data/saveSOW", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,String> save(@RequestBody SOWMaster sow, HttpServletRequest request) {
		Map<String,String> saved = new HashMap<String, String>();
		boolean isAlreadyExist = false; //sowService.isExist(sow.getId());
		String message = "already exist";
		if(!isAlreadyExist) {
			String token = request.getHeader("authorization");
			String userid = Jwts.parser().setSigningKey(Constant.KEY).parseClaimsJws(token).getBody().get("jti").toString();
			sow.setUser(userid);
			SOWMaster savedSOW = sowService.create(sow);
			message = "saved";
			if(savedSOW==null)
				message = "unable to save";			
		}
		saved.put("data", message);
		return saved;
	}
	
	
	@RequestMapping(value = "/data/updateSOW", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,String> update(@RequestBody SOWMaster sow, HttpServletRequest request) {
		Map<String,String> saved = new HashMap<String, String>();
		String message = "updated";
		String token = request.getHeader("authorization");
		String userid = Jwts.parser().setSigningKey(Constant.KEY).parseClaimsJws(token).getBody().get("jti").toString();			
		sow.setUser(userid);
		SOWMaster savedSOW = sowService.create(sow);
		if(savedSOW==null)
			message = "unable to update";			
		saved.put("data", message);
		return saved;
	}
	
	
	@RequestMapping(value = "/data/deleteSOW", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,String> delete(@RequestBody SOWMaster sow) throws ObjectNotFoundException {		
		Map<String,String> returnStatus = new HashMap<String, String>();
	    returnStatus.put("data", "deleted");
	    sowService.delete(sow.getId());
		return returnStatus;
	}

	@RequestMapping(value = "/data/getSOW", method = RequestMethod.GET)
	@ResponseBody
	public List<SOWMaster> getSOWs(HttpServletRequest request) {
		String token = request.getHeader("authorization");		
		List<SOWMaster> sows = sowService.findByUserId(Jwts.parser().setSigningKey(Constant.KEY).parseClaimsJws(token).getBody().get("jti").toString());
		return sows;
	}
	
	@RequestMapping(value = "/data/getSOWForChart", method = RequestMethod.GET)
	@ResponseBody
	public List getchartData(HttpServletRequest request) {
		String token = request.getHeader("authorization"); 
		List list = util.getEntityManagerFactory().createEntityManager().createNativeQuery("SELECT SOWMaster.wastatus,(COUNT(*) / "
				+ "(SELECT COUNT(*) FROM SOWMaster)) * 100 "
	    		+ "AS Percentage FROM SOWMaster GROUP BY SOWMaster.wastatus").getResultList();
		return list;		
	}
	
	@RequestMapping(value = "/data/getSowExpireData", method = RequestMethod.GET)
	@ResponseBody
	public List getListOfSowWhichGoingToExpire(HttpServletRequest request) {
		String token = request.getHeader("authorization"); 
		List list = util.getEntityManagerFactory().
				createEntityManager().createNativeQuery("SELECT * FROM SOWMaster WHERE "
						+ "expirydate BETWEEN '"+util.getTodayDate()
						+"' AND '"+util.getLastDateOfMonth()+"'").getResultList();		
		return list;		
	}
	
	
	
}

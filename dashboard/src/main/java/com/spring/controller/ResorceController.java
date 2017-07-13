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
import com.spring.models.MResource;
import com.spring.service.AuthenticateService;
import com.spring.service.ResourceService;
import io.jsonwebtoken.Jwts;
import javassist.tools.rmi.ObjectNotFoundException;

@Controller
public class ResorceController {
	private Set<MResource> resourceList = new HashSet<MResource>();
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private ResourceService resourceService;
	
	@Autowired
	AuthenticateService authenticateService;
	
	@Autowired
	Util util;

	
	public ResorceController(){
	}
	
				   
	@RequestMapping(value = "/data/saveResource", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,String> save(@RequestBody MResource resource, HttpServletRequest request) {
		Map<String,String> saved = new HashMap<String, String>();
		boolean isAlreadyExist = resource.getId()!=null ? resourceService.isExist(resource.getId()) : false;
		String message = "already exist";
		if(!isAlreadyExist) {
			String token = request.getHeader("authorization");
			String userid = Jwts.parser().setSigningKey(Constant.KEY).parseClaimsJws(token).getBody().get("jti").toString();			
			resource.setUser(userid);
			MResource savedResource = resourceService.create(resource);
			message = "saved";
			if(savedResource==null)
				message = "unable to save";			
		}
		saved.put("data", message);
		return saved;
	}
	
	
	@RequestMapping(value = "/data/updateResource", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,String> update(@RequestBody MResource resource, HttpServletRequest request) {
		Map<String,String> saved = new HashMap<String, String>();
		String message = "updated";
		String token = request.getHeader("authorization");
		String userid = Jwts.parser().setSigningKey(Constant.KEY).parseClaimsJws(token).getBody().get("jti").toString();			
		resource.setUser(userid);
		MResource savedResource = resourceService.create(resource);
		if(savedResource==null)
			message = "unable to update";			
		saved.put("data", message);
		return saved;
	}
	
	
	@RequestMapping(value = "/data/deleteResource", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,String> delete(@RequestBody MResource resource) throws ObjectNotFoundException {		
		Map<String,String> returnStatus = new HashMap<String, String>();
	    returnStatus.put("data", "deleted");	    
	    resourceService.delete(resource.getId());
		return returnStatus;
	}

	@RequestMapping(value = "/data/getResource", method = RequestMethod.GET)
	@ResponseBody
	public List<MResource> getResources(HttpServletRequest request) {
		String token = request.getHeader("authorization");		
		List<MResource> resources = resourceService.findByUserId(Jwts.parser().setSigningKey(Constant.KEY).parseClaimsJws(token).getBody().get("jti").toString());
		return resources;
	}
	
	@RequestMapping(value = "/data/getResourceForChart", method = RequestMethod.GET)
	@ResponseBody
	public List getchartData(HttpServletRequest request) {
		String token = request.getHeader("authorization");
		List list = util.getEntityManagerFactory().createEntityManager().createNativeQuery("SELECT MResource.status,(COUNT(*) / "
				+ "(SELECT COUNT(*) FROM MResource)) * 100 "
	    		+ "AS Percentage FROM MResource GROUP BY MResource.status").getResultList();		
		System.out.println("::::::::::::::::::::::"+list);
		return list;		
	}
}

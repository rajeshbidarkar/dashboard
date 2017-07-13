import java.util.Arrays;

public class Factorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String abs = "//div[text(),'RONUM_curID']";
		
		for(int row=0;row<5;row++){
			abs = "//div[text(),'RONUM_curID']";
			abs = abs.replace
					("RONUM",""+row);
			System.out.println(abs);
		}
		
		
		
		/*System.out.println(fact(5));
		
		try {
			Class c1 = Class.forName("");
			c1.newInstance();
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(reverseString("RAJESH"));*/
	}
	
	private static int fact(int num){
		if(num==1)
			return 1;
		return num * (fact(num-1));		
	} 
	
	public static String reverseString(String s){
	    if (s.length() == 0) 
	         return s;
	    return reverseString(s.substring(1)) + s.charAt(0);
	}
}

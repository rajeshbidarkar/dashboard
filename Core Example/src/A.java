
public class A <T>{
	
	public A(String a){
		
	}
	private static int count = 0;

	static {
		
		System.out.println("STATIC");
	}
	
	{
		System.out.println("IN IT");
		
	}
	
	public static int getCount()
	{
	  return count;
	}
	public static void setCount(int i){
		count = i;
	}
	
	public void abc(){
		
	}
	public static void xyz(){
		System.out.println("XYZ");
	}
	
	public void abc(String a){
		System.out.println(""+a);
	}
	
	public void abc(Object a){
		System.out.println("OB"+a);
	}
	
	public void b(T t){
		abc(t);
	}
	{
		System.out.println("IN IT 2");
	}
	public static void main(String []args){
		new A("").b("RAJESH");
		
		Z a = new Z();
		System.out.println(a.getCount());
		a.setCount(10);
		System.out.println(a.getCount());
		new A("").b("RAJESH");
	}

}

class Z {
	private static int count = 0;
	public static int getCount()
	{
	  return count;
	}
	public static void setCount(int i){
		count = i;
	}
}

import java.util.HashMap;

public class Main {
	public static void main(String []args){
			A a = new B(null);
			a.abc();
			
			Object ob = new Object();
			System.out.println(ob.toString());
			
			int v = 'A';
			
			try {
				Thread.sleep(50000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println(v);

			String aX = new String("RAJ");
			String aY = new String("RAJ");
			if(aX==aY)
			System.out.println("RAJESH"+10+20+30);
			HashMap map = new HashMap();
			map.put(null, null);
			
			
			
			
	}
}

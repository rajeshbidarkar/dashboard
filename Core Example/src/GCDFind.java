import java.util.Scanner;

public class GCDFind {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        System.out.print("Enter the First no : ");
        int n1=sc.nextInt();
        System.out.print("Enter the Second no : ");
        int n2=sc.nextInt();
         
        while(n1 != n2)
        {
            if(n1 > n2)
                n1 = n1-n2;
            else
                n2 = n2-n1;
        }
        System.out.println(findGCD(n1,n2));
        System.out.print("GCD = "+n1);
        
	}
	
	public static int findGCD(int n1, int n2){		
		if(n2 == 0){ 
			return n1; 
		} 
		return findGCD(n2, n1%n2);
	}
}

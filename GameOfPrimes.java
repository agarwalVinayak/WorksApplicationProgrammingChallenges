import java.util.Scanner;

public class GameOfPrimes{

	public static void main(String[] args)
	{
		Scanner in=new Scanner(System.in);
		System.out.println("Enter the Lower Limit , Upper Limit and Index : \t");
		
		int upperLimit,lowerLimit,index;

		try
        	{
            		
			lowerLimit = in.nextInt();
			upperLimit = in.nextInt();
			index = in.nextInt();
        		int count=0;

        	
			if(lowerLimit>upperLimit || lowerLimit<=0 || upperLimit<=0 || index<=0 )
			{
				System.out.println("Invalid Input");
			
			}
		
			if(lowerLimit==1)
				lowerLimit++;
			int m=0;
			boolean found=false;
			for (int n= lowerLimit ; n<=upperLimit ; n++)
			{
				boolean isPrime = true;			
	    			for(int i=2;i<=Math.sqrt(n);i++) {
					if((n%i==0)){
						isPrime=false;
						break;
					}
				}
				if (isPrime){
					
					m = sumSqDigits(n);
					while(m!=1 && m!=4)
					{
						m = sumSqDigits(m);
						
					}
					if(m==1)
					 count++;
					if(count==index)		
					{
						System.out.println("At index : "+index +" the magic number is : \t"+n);
						found=true;
						break;
					}
				}
		    }
		    if(!found)
			System.out.println("No number is present at this index");
		}
		catch (java.util.InputMismatchException e)
        	{
            		System.out.println("Invalid Input");
            		
        	}
    		
			
	}
	public static int sumSqDigits(int n){
		int sum=0;
		while(n>=1){
			int digit=n%10;
			sum=sum+digit*digit;
			n=n/10;
		}
		
		return sum;

	} 
}

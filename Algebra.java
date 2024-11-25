
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) 
	{
		int sum = x1;
		if (x2 >= 0)
		{
			for (int i = 0; x2 > i; i++)
			{
				sum++;
			}

		}
		if (x2 < 0 )
		{
			for (int z = 0; z > x2; z--) {
				sum--;
			}
		}
		return sum;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2)
	{
		int sum = x1;
		if (x2 >= 0)
		{
			for (int i = 0; x2 > i; i++)
			{
				sum--;
			}
		}
		if (x2 < 0)
		{
			for (int z = 0; z > x2; z--) {
				sum++;
			}
		}

		return sum;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		int sum = 0;
		if (x2 == 0)
		{
			sum = 0;
			return sum;
		}
		if (x2 > 0)
		{
			while (x2 > 0)
			{
				sum = plus(sum,  x1);
				x2 --;
			}
		}
		if (x2 < 0)
		{
			
			return	minus(0, times(x1, -x2));

		}
		return sum;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		int sum = 1;
		if (x == 0)
		{
			sum = 0;
			return sum;
		}
		else
		{
			while (n > 0)
			{
				sum = times (sum, x);
				n --;
			}
		}
	
		return sum;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		boolean isNegative = (x1 < 0) ^ (x2 < 0);
		int zero = 0;
		if (x1 < 0)
		{
			x1 = minus(zero, x1);

		}
		if (x2 < 0)
		{
			x2 = minus(zero, x2);

		}
		int div = 0;
		while (x1 >= x2) {
			x1 = minus(x1, x2);
			div++;
		}
		if (isNegative == true)
		{
			div = minus(zero, div);
		}
		return div;
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		int mod = x1;
		while (mod >= x2)
		{
			mod = minus(mod, x2);
		}
		return mod;
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		int sqrt = 0;
		double epsilon = 0.01;
		double g = x;
		while (Math.abs(g * g - x) > epsilon) 
		{
		g = g - (g * g - x) / (2 * g);
		}
		sqrt = (int) g;
		return sqrt;
	}	  	  
}
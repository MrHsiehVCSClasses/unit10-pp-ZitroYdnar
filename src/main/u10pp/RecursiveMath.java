package u10pp;
import java.math.BigInteger;
class RecursiveMath{
    public static double pow(double base, int exponent){
      double n = Math.pow(base,exponent);
      if(exponent >= 0){
        return n;
      }
      else{
        return -1;
      }
    }
    public static BigInteger getFactorial(int n){
      BigInteger f = new BigInteger("1");
      if(n >= 0){
        for (int i = 2; i <= n; i++){
          f = f.multiply(BigInteger.valueOf(i));
        }
        return f;
      }
      else{
        return f;
      }
      
    }
    public static long getFibonacciNumber(int n){
        // Base Case
        if (n <= 1){
            return n;
          }
        // Recursive call
        return getFibonacciNumber(n - 1)+ getFibonacciNumber(n - 2);
    }
  
}
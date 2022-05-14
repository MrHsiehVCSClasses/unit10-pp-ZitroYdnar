package u10pp;
 class RecursivePalindromeChecker{
  public static boolean isPalindrome(String s){
    String phraseReverseString = "";
        String ithLetter;   
        boolean here;
        s = s.replaceAll("[^A-Za-z]+", "");
        s = s.toLowerCase();
            for(int i=0; i < s.length(); i++) {
                ithLetter = s.substring(i,i+1);
                phraseReverseString = ithLetter + phraseReverseString;
            }
            if (s.equals(phraseReverseString)){
                here = true;
            }
            else{
                here = false;
            }
            return here;
        }
    
  }
  


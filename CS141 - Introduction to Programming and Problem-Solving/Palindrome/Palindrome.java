public class Palindrome
{
   public static void main(String[]args)
   {
      System.out.println("\nModified Palindrome...\n");
      String str;
       str = "Able was I ere I saw Elba";       
       checkPalindrome(str);
       System.out.println('"' + str + '"' + " is " + (checkPalindrome(str) ? "" : "NOT ") + "a palindrome.");
       
       str = "Four score and seven years ago";       
       checkPalindrome(str);
       System.out.println('"' + str + '"' + " is " + (checkPalindrome(str) ? "" : "NOT ") + "a palindrome.");

       str = "Now is the time for all good men";       
       checkPalindrome(str);
       System.out.println('"' + str + '"' + " is " + (checkPalindrome(str) ? "" : "NOT ") + "a palindrome.");

       str = "A man, a plan, a canal, Panama";       
       checkPalindrome(str);
       System.out.println('"' + str + '"' + " is " + (checkPalindrome(str) ? "" : "NOT ") + "a palindrome.");

       str = "Madam, I'm Adam";       
       checkPalindrome(str);
       System.out.println('"' + str + '"' + " is " + (checkPalindrome(str) ? "" : "NOT ") + "a palindrome.");
      
       str = "Desserts I stressed";       
       checkPalindrome(str);
       System.out.println('"' + str + '"' + " is " + (checkPalindrome(str) ? "" : "NOT ") + "a palindrome.");
       
       str = "Ask not what your country can do for you";           
       checkPalindrome(str);
       System.out.println('"' + str + '"' + " is " + (checkPalindrome(str) ? "" : "NOT ") + "a palindrome.");

       str = "Kayak";       
       checkPalindrome(str);
       System.out.println('"' + str + '"' + " is " + (checkPalindrome(str) ? "" : "NOT ") + "a palindrome.");

       str = "A Toyota! Race fast... safe car: a Toyota";       
       checkPalindrome(str);
       System.out.println('"' + str + '"' + " is " + (checkPalindrome(str) ? "" : "NOT ") + "a palindrome.");

       str = "Satan, oscillate my metallic sonatas!";       
       checkPalindrome(str);
       System.out.println('"' + str + '"' + " is " + (checkPalindrome(str) ? "" : "NOT ") + "a palindrome.");

       str = "Ah, Satan see Natasha";       
       checkPalindrome(str);
       System.out.println('"' + str + '"' + " is " + (checkPalindrome(str) ? "" : "NOT ") + "a palindrome.");

       str = "Dennis sinned";       
       checkPalindrome(str);
       System.out.println('"' + str + '"' + " is " + (checkPalindrome(str) ? "" : "NOT ") + "a palindrome.");

       str = "Rats lives on no evil star";       
       checkPalindrome(str);
       System.out.println('"' + str + '"' + " is " + (checkPalindrome(str) ? "" : "NOT ") + "a palindrome.");

   }
   
   public static boolean checkPalindrome(String s)
   {
      String letters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
      if(s.length() == 0 || s.length() == 1)
      {
         return true;
      }
     
      String tail = s.substring(s.length() - 1, s.length());  
      if(letters.indexOf(tail) < 0)
      { 
         return checkPalindrome(s.substring(0, s.length() - 1));
      }
      else
      {
      String head = s.substring(0, 1);
         if(letters.indexOf(head) < 0)
         {
            return checkPalindrome(s.substring(1, s.length()));
         }
         else
         {
            if(tail.toLowerCase().equals(head.toLowerCase()))
            {
               return checkPalindrome(s.substring(1, s.length() - 1));
            }
            else
            {
               return false;
            }
         }
      }
   }
}
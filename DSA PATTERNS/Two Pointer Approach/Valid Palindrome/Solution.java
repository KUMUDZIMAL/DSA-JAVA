class Solution {
    public boolean isPalindrome(String s) {
        int n=s.length();
        int j=n-1;
        int i=0;
        while(i<j){
      while(i<j && !Character.isLetterOrDigit(s.charAt(i))){
        i++;
      }
      while(i<j && !Character.isLetterOrDigit(s.charAt(j))){
        j--;
      }
   if(Character.toLowerCase(s.charAt(i))!=Character.toLowerCase(s.charAt(j))){
                return false;
            }
            j=j-1;
            i=i+1;
        }
        return true;
    }
}
import java.util.*;
class StockSpanner {

    // Brute Force

//  List<Integer> L =new ArrayList<>();
// public int next(int price){
//       int count=0;
//       L.add(price);
//     for(int i=L.size()-1;i>=0;i--){
//         if(L.get(i)<=price){
//             count++;
//         }
//         else{
//             break;
//         }

//     }
//     return count;
// }

// Optimal 
 
 class Pair{
    int ind;
    int val;
    Pair(int index,int value){
        ind=index;
        val=value;
    }
   }
   Stack<Pair> s =new Stack<>();
   int ind=-1;
 
    
    public int next(int price) {
        ind=ind+1;
       while (!s.isEmpty() && s.peek().val <= price) {
           s.pop();
       }

        int ans=ind-(!s.isEmpty()?s.peek().ind:-1);
        s.push(new Pair(ind,price));
        return ans;
    }

}
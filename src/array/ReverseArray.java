package array;

public class ReverseArray {
     public static void main(String[] args){
         int[] intArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
         System.out.println(Thread.currentThread());
         reverse(intArray);

     }

     static  void reverse(int[] a){

         for (int i=0 ; i<a.length/2; i++){
             int first = a[i];
             int last = a[a.length-1-i];
             a[i]=last;
             a[a.length-1-i]= first;
         }

         for (int j : a) {
             System.out.print(j + " ");
         }
     }
}

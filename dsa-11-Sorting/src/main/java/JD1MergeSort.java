public class JD1MergeSort {
   public static void mergeSort(int[] array){
       if (array.length<2) return;// if you have an array with one element STOP
       int mid=array.length/2;
       int[] leftArray=new int[mid];
       for (int i = 0; i <mid ; i++) leftArray[i]=array[i];
       int[] rightArray=new int[array.length-mid];
       for (int i = mid; i < array.length ; i++) rightArray[i-mid]=array[i];
       mergeSort(leftArray);
       mergeSort(rightArray);
       //And then I'm going to combine these left and right solutions.
       merge(leftArray, rightArray, array);


   }
    public static void merge(int[] left, int[] right, int[] result){
       //So I need 3 pointers,one for the left array, one for the right array one for the result.
        // Because I'm going to combine these 2 arrays and come up with the result,and I need one pointer for each.
        int i=0,j=0,k=0;
        //So what I will do is first. I will start to compare the left array and the write-ring
        //And if the element on the left array is less than the element on the right array.
        // I'm going to pick up the element from the left array, and I'm going to increase the pointer on the left array
       while(i<left.length && j<right.length){// this while loop is for checking. If I am at one of the end of the list.

           if (left[i]<=right[j]) result[k++]=left[i++];
           else result[k++]=right[j++];
       }
       while(i<left.length) result[k++]=left[i++];
       while(j<right.length) result[k++]=right[j++];
    }
}

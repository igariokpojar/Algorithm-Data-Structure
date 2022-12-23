public class JD1QuickSort {
    public static void qSort(int[] array, int start, int end){
        //So I have 2 pointers start and end. Okay,
        //if the left pointer exceeds the right pointer. This means that I'm at the end. Okay.
       if (start>=end) return; //termination
        //Partition is the place where I divide or split the array in two pieces.
       int boundary=partition(array, start, end);
       qSort(array, start, boundary-1);// call qSort for left part
       qSort(array,boundary+1, end);// call qSort for right part

    }

    public static int partition(int[] array, int start, int end){
        int pivot=array[end];
        int boundary=start;
        for (int i = start; i <=end ; i++) {
            if(array[i]<=pivot) swap(array, i, boundary++);
        }
        return boundary-1;
    }
    public static void swap(int[] array, int idx1, int idx2){
        int temp=array[idx1];
        array[idx1]=array[idx2];
        array[idx2]=temp;
    }
}

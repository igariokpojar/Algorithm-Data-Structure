public class InsertionSort {
    public static int[] insertionSort(int[] array){
        for (int i = 1; i < array.length ; i++) {
            //And inside this one, I'm: going to pick up the element from the all sorts. But okay.
            int toBeInserted=array[i]; // temp var toBeInserted
            //I need to compare this element with the last element of the sort of part
            int j=i-1;// this is predecessor
            // start shifting operation here
            //Okay. So for the shifting cooperation, i'm going to use while loop. Okay, while J. Is not less than 0,
            // and also the current Lms is less than the array. J: this means that I need to move. Left. Okay, I will.
            // I will assign the current element to the next one, and then I will create a space for the new element to be inserted. Okay.
            while(j>=0 && toBeInserted<array[j]){
                //And now in this one I'm: going to assign a J to the next element. Okay
                array[j+1]=array[j];
                j--;
            }
            // Why, J. Plus one? Because after this operation I decreased the
            //variable J. By one, and I need to insert it into the J plus. One. Okay.
            //is equal to what? toBeInserted.
            array[j+1]=toBeInserted;
        }
        return array;
    }
}

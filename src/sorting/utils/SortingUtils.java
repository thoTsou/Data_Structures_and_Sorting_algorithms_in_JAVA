package sorting.utils;

public final class SortingUtils {

    private SortingUtils() {
        throw new IllegalStateException("Cannot be instantiated");
    }

    public static void mergeSort(int[] arrayToSort) {
        int arrayToSortLength = arrayToSort.length;

        if (arrayToSortLength < 2) {
            return;
        }

        int midIndex = arrayToSortLength / 2;
        int[] leftHalfArray = new int[midIndex];
        int[] rightHalfArray = new int[arrayToSortLength - midIndex];

        for (int i=0 ; i<midIndex; i++){
            leftHalfArray[i] = arrayToSort[i];
        }
        for (int i=midIndex ; i<arrayToSortLength; i++){
            rightHalfArray[i - midIndex] = arrayToSort[i];
        }

        mergeSort(leftHalfArray);
        mergeSort(rightHalfArray);
        merge(arrayToSort, leftHalfArray, rightHalfArray);
    }

    public static void bubbleShort(int[] arrayToSort) {
        boolean swapHappened = true;
        while (swapHappened) {
            swapHappened = false;

            for (int i=0; i<arrayToSort.length - 1; i++) {
                if (arrayToSort[i] > arrayToSort[i+1]) {
                    int temp = arrayToSort[i];
                    arrayToSort[i] = arrayToSort[i+1];
                    arrayToSort[i+1] = temp;
                    swapHappened = true;
                }
            }
        }
    }

    public static void heapSort(int[] arrayToSort) {
        int arrayToSortLength = arrayToSort.length;

        // create max-heap DS from given arrayToSort
        // start process from bottom - up
        for (int i = (arrayToSortLength / 2) - 1; i >= 0; i--) {
            heapifyArray(arrayToSort, arrayToSortLength, i);
        }

        for (int i = arrayToSortLength - 1; i > 0; i--) {
            // swap root with last element
            int temp = arrayToSort[i];
            arrayToSort[i] = arrayToSort[0];
            arrayToSort[0] = temp;

            // heapify tree's new root
            heapifyArray(arrayToSort, i, 0);
        }
    }

    // Best O(n), avg O(n^2)
    public static void insertionSort(int[] arrayToSort) {
        for (int i=1 ; i<arrayToSort.length; i++) {
            int key = arrayToSort[i];
            int j = i - 1;

            while (j>=0 && arrayToSort[j] > key) {
             arrayToSort[j+1] = arrayToSort[j];
             j--;
            }
            arrayToSort[j+1] = key;
        }
    }

    //Avg O(n^2)
    public static void selectionSort(int[] arrayToSort) {
        for (int i=0; i<arrayToSort.length - 1; i++) {
            int minArrayValueIndex = i;

            for (int j= i+1; j<arrayToSort.length; j++) {
                if (arrayToSort[j] < arrayToSort[minArrayValueIndex]) {
                    minArrayValueIndex = j;
                }
            }

            int temp = arrayToSort[i];
            arrayToSort[i] = arrayToSort[minArrayValueIndex];
            arrayToSort[minArrayValueIndex] = temp;
        }
    }

    private static void heapifyArray(int [] arrayToHeapify, int arrayToHeapifyLength, int rootIndex) {
        int indexWithBiggestValue = rootIndex;
        int leftNodeOfRootIndex = indexWithBiggestValue * 2 + 1;
        int rightIndexOfRootIndex = indexWithBiggestValue * 2 + 2;

        if (leftNodeOfRootIndex<arrayToHeapifyLength &&
                arrayToHeapify[leftNodeOfRootIndex] > arrayToHeapify[indexWithBiggestValue]) {
            indexWithBiggestValue = leftNodeOfRootIndex;
        }

        if (rightIndexOfRootIndex<arrayToHeapifyLength &&
                arrayToHeapify[rightIndexOfRootIndex] > arrayToHeapify[indexWithBiggestValue]) {
            indexWithBiggestValue = rightIndexOfRootIndex;
        }

        if (indexWithBiggestValue != rootIndex) {
            int temp = arrayToHeapify[indexWithBiggestValue];
            arrayToHeapify[indexWithBiggestValue] = arrayToHeapify[rootIndex];
            arrayToHeapify[rootIndex] = temp;

            // Recursively heapify the affected sub-tree
            heapifyArray(arrayToHeapify, arrayToHeapifyLength, indexWithBiggestValue);
        }
    }

    private static void merge(int[] arrayToSort, int[] leftHalfArray, int[] rightHalfArray) {
        int leftHalfArrayLength = leftHalfArray.length;
        int rightHalfArrayLength = rightHalfArray.length;

        int i=0, j=0, k=0;

        while (i<leftHalfArrayLength && j<rightHalfArrayLength) {
            if (leftHalfArray[i] <= rightHalfArray[j]) {
                arrayToSort[k] = leftHalfArray[i];
                i++;
            } else {
                arrayToSort[k] = rightHalfArray[j];
                j++;
            }
            k++;
        }

        while (i<leftHalfArrayLength) {
            arrayToSort[k] = leftHalfArray[i];
            k++;
            i++;
        }
        while (j<rightHalfArrayLength) {
            arrayToSort[k] = rightHalfArray[j];
            k++;
            j++;
        }
    }

}

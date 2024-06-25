import sorting.utils.SortingUtils;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random ran = new Random();
        int[] randomIntsArray = new int[100];
        for (int i=0 ; i<randomIntsArray.length; i++){
            randomIntsArray[i] = ran.nextInt(1000);
        }

//        Merge Sort driver code
//        performs at O(n log (n)) in the best, average, and worst case.
//        printArray(randomIntsArray, "array before merge sorting");
//        sorting.utils.SortingUtils.mergeSort(randomIntsArray);
//        printArray(randomIntsArray, "array after merge sorting");

//        Bubble-Sort driver code
//        Avg=> Θ(n^2), worst=> O(n^2)
//        printArray(randomIntsArray, "array before bubble sorting");
//        sorting.utils.SortingUtils.bubbleShort(randomIntsArray);
//        printArray(randomIntsArray, "array after bubble sorting");

//        Custom Linked List driver code
//        LinkedList myLinkedList = new LinkedList();
//        myLinkedList.displayElementsData();
//        myLinkedList.insertAtEnd(55);
//        myLinkedList.insertAtEnd(56);
//        myLinkedList.insertAtEnd(57);
//        myLinkedList.insertAtStart(5);
//        myLinkedList.insertAt(3, 105);
//        myLinkedList.displayElementsData();
//        myLinkedList.deleteAt(1);
//        myLinkedList.displayElementsData();

//        Heap Sort => Average, Worst case time O(n * lgn), Best case time O(n)
//        printArray(randomIntsArray, "array before heap sorting");
//        sorting.utils.SortingUtils.heapSort(randomIntsArray);
//        printArray(randomIntsArray, "array after heap sorting");

        printArray(randomIntsArray, "array before selection sorting");
        SortingUtils.selectionSort(randomIntsArray);
        printArray(randomIntsArray, "array after selection sorting");
    }

    public static void printArray(int [] numbersArray, String messageToPrint) {
        System.out.println(messageToPrint);
        for (int number : numbersArray) {
            System.out.println(number);
        }
    }

}
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BinarySearch {
    public  static void main(String[] args){
        Scanner scanner=new Scanner(System.in);

        Integer n = 0;
        try {
            System.out.print("Enter the number of elements in the array: ");
            n = scanner.nextInt();
            if (n <= 0) {
                System.out.println("Array size should be positive Integer and greater than 0 .");
                return;
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid integer.");
            return;
        }
        Integer[] arr = new Integer[n];
        try {
            System.out.println("Enter the elements of the array :");
            for (Integer i = 0; i < n; i++) {

                Integer arElem = scanner.nextInt();// array element variable
                if (arElem < 0) {
                    System.out.println("Array elements must be non-negative. Please enter a non-negative integer.");
                    return;
                }
                arr[i] = arElem;

            }
            Arrays.sort(arr);
            System.out.println("Array Values:   "+Arrays.toString(arr));
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter valid integers.");
            return;
        }
        Integer target = 0;
        try {
            System.out.print("Enter the element to search for: ");
            target = scanner.nextInt();
            if (target < 0) {
                System.out.println("The Target should be non negative value ");
                return;
            }

        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid integer.");
            return;
        }
        scanner.close();
        Integer left = 0, right = arr.length - 1;
        Integer result = binarySearch(arr, target,left,right);
        if (result == -1) {
            System.out.println("Element not found");
        }
        else {
            System.out.println("Element found at index " + result);
        }

    }
     public static Integer binarySearch(Integer[] arr, Integer target,Integer left, Integer right)
    {

        // Checking element in whole array
        while (left <= right) {
            Integer mid = left + (right) / 2;//find the midle value of array
            if (arr[mid].equals(target)) // Check if target is found at midle value index
                return mid;
            // If target greater, ignore left half
            if (arr[mid] < target){
                return binarySearch(arr, target, mid + 1, right);// Search in right half
            }
            // If target smaller, ignore right half
            return binarySearch(arr, target, left, mid - 1);// Search in left half
        }
        return -1;
    }
}

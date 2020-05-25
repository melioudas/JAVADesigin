package other.math.二分查找;

import java.util.Scanner;

/**
 * 二分查找实践
 */
public class Main {

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 6, 7, 8, 12, 43, 56, 77, 88, 99};
        System.out.println("输入：");
        Scanner scanner = new Scanner(System.in);
        int read = scanner.nextInt();
        System.out.println(  search(arr,read));
    }
    public static int search(int[] arr, int key) {
          int start = 0;
          int end = arr.length - 1;
          while (start <= end) {
              int middle = (start + end) / 2;
              if (key < arr[middle]) {
                  end = middle - 1;
              } else if (key > arr[middle]) {
                  start = middle + 1;
              } else {
                  return middle;
              }
              System.out.println(start+"+"+end);
          }
          return -1;
      }
}

public class SecondLargestDay1 {

    public int getSecondLargest(int[] arr) {
        int max = arr[0];
        int sec = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                sec = max;
                max = arr[i];
            } else if (arr[i] > sec && arr[i] < max) {
                sec = arr[i];
            }
        }
        return sec;
    }

    public static void main(String[] args) {
        SecondLargestDay1 finder = new SecondLargestDay1();
        int arr[] = { 12, 35, 1, 10, 34, 1 };

        System.out.println("The second largest element is: " + finder.getSecondLargest(arr));
    }
}

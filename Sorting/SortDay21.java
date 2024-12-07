class SortDay21 {

    public void swap(int[] arr, int start, int end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }

    public void sort012(int[] arr) {
        // Implementing the Dutch National Flag Algorithm
        int n = arr.length;
        int low = 0;
        int high = n - 1;
        int mid = 0;

        while (mid <= high) {
            if (arr[mid] == 0) {
                swap(arr, low, mid);
                low++;
                mid++;
            } else if (arr[mid] == 1) {
                mid++;
            } else {
                swap(arr, mid, high);
                high--;
            }
        }
    }

    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String args[]) {
        SortDay21 sorter = new SortDay21();
        int[] arr = { 2, 0, 2, 1, 1, 0 };
        System.out.println("Original array:");
        printArray(arr);

        sorter.sort012(arr);

        System.out.println("Sorted array:");
        printArray(arr);
    }
}

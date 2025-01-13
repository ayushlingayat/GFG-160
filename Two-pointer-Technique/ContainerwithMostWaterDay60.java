public class ContainerwithMostWaterDay60 {
    public int maxWater(int arr[]) {
        int left = 0;
        int right = arr.length - 1;
        int maxWater = 0;

        while (left < right) {
            int width = right - left;
            int height = Math.min(arr[left], arr[right]);
            int currentWater = width * height;
            maxWater = Math.max(maxWater, currentWater);

            if (arr[left] < arr[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxWater;
    }

    public static void main(String args[]) {
        ContainerwithMostWaterDay60 container = new ContainerwithMostWaterDay60();
        int arr[] = {1, 8, 6, 2, 5, 4, 8, 3, 7};

        int result = container.maxWater(arr);
        System.out.println("Maximum water that can be contained: " + result);
    }
}

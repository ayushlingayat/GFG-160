class Solution {
    public int findDuplicate(int[] arr) {
        // code here
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int length = arr.length - 1;
        long totalSum = ((long)length * ((long)(length + 1))) / 2;
        long currentSum = 0;
        for (int index = 0; index <= length; index++) {
            currentSum += arr[index];
        }
        return (int)(currentSum - totalSum);
    }
}
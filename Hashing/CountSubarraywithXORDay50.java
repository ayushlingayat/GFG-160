import java.util.HashMap;

public class CountSubarraywithXORDay50 {
    // Function to count the number of subarrays with a given XOR
    public long subarrayXor(int arr[], int m) {
        HashMap<Long, Integer> mp = new HashMap<>();
        long count = 0;
        long sum = 0;
        
        for (int i = 0; i < arr.length; i++) {
            // Calculate the XOR sum up to the current element
            sum ^= arr[i];
            
            // If the XOR sum matches the desired value, increment the count
            if (sum == m) {
                count++;
            }
            
            // Find the XOR value needed to form the desired XOR
            long toFind = sum ^ m;
            
            // If the needed XOR exists in the map, add its frequency to the count
            if (mp.containsKey(toFind)) {
                count += mp.get(toFind);
            }
            
            // Update the map with the current XOR sum frequency
            mp.put(sum, mp.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        // Test the function
        CountSubarraywithXORDay50 obj = new CountSubarraywithXORDay50();
        
        int arr[] = {4, 2, 2, 6, 4};
        int m = 6; // Target XOR value
        
        // Calling the method and printing the result
        long result = obj.subarrayXor(arr, m);
        System.out.println("Number of subarrays with XOR " + m + ": " + result);
    }
}

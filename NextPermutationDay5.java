import java.util.Arrays;
import java.util.Iterator;
import java.util.TreeMap;

class NextPermutationDay5 {

    void nextPermutation(int[] arr) {
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        boolean isEnter = false;
        int n = arr.length;

        // Traverse the array from the end
        for (int i = n - 1; i >= 0; i--) {
            tm.put(arr[i], tm.getOrDefault(arr[i], 0) + 1);

            // Find the next greater element
            Integer key = tm.higherKey(arr[i]);
            if (key != null) {
                isEnter = true;
                arr[i] = key;
                copy(arr, tm, i + 1, key, n);
                break;
            }
        }

        // If no valid next permutation, sort the array to get the smallest permutation
        if (!isEnter) {
            Arrays.sort(arr);
        }
    }

    void copy(int[] arr, TreeMap<Integer, Integer> tm, int i, int d, int n) {
        Iterator<Integer> itr = tm.keySet().iterator();

        while (itr.hasNext() && i < n) {
            Integer key = itr.next();
            if (key != d) {
                for (int j = 0; j < tm.get(key); j++) {
                    arr[i] = key;
                    i++;
                }
            } else if (key == d && tm.get(key) > 1) {
                for (int j = 0; j < tm.get(key) - 1; j++) {
                    arr[i] = key;
                    i++;
                }
            }
        }
    }

    public static void main(String[] args) {
        NextPermutationDay5 obj = new NextPermutationDay5();

        int[] arr = {1, 2, 3};
        System.out.println("Original Array: " + Arrays.toString(arr));

        obj.nextPermutation(arr);
        System.out.println("Next Permutation: " + Arrays.toString(arr));

        int[] arr2 = {3, 2, 1};
        System.out.println("Original Array: " + Arrays.toString(arr2));

        obj.nextPermutation(arr2);
        System.out.println("Next Permutation: " + Arrays.toString(arr2));

        int[] arr3 = {1, 1, 5};
        System.out.println("Original Array: " + Arrays.toString(arr3));

        obj.nextPermutation(arr3);
        System.out.println("Next Permutation: " + Arrays.toString(arr3));
    }
}

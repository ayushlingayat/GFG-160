class EquilibriumPointDay61 {

    public static int findEquilibrium(int arr[]) {
        int LSum = 0;
        int RSum = 0;
        
        // Calculate the total sum of the array
        for(int i = 0; i < arr.length; i++) {
            RSum += arr[i];
        }
        
        // Traverse the array to find the equilibrium point
        for(int i = 0; i < arr.length; i++) {
            RSum -= arr[i]; // Subtract the current element from the right sum
            
            if(LSum == RSum) {
                return i; // Equilibrium point found
            }
            
            LSum += arr[i]; // Add the current element to the left sum
        }
        
        return -1; // No equilibrium point found
    }

    public static void main(String[] args) {
        int arr[] = {1, 3, 5, 2, 2};
        
        int equilibriumIndex = findEquilibrium(arr);
        
        if(equilibriumIndex != -1) {
            System.out.println("Equilibrium point found at index: " + equilibriumIndex);
        } else {
            System.out.println("No equilibrium point found.");
        }
    }
}

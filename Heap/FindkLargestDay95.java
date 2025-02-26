public ArrayList<Integer> kLargest(int[] arr, int k) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(Arrays.stream(arr).boxed().toArray(Integer[]::new)));
        Collections.sort(list, Collections.reverseOrder());
        return new ArrayList<>(list.subList(0, k));
    }
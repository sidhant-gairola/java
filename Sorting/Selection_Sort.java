public class Selection_Sort {
    //printing function  
    public static void print(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    // Sorting function
    public static void sort(int arr[],int length) {
        for (int i = 0; i < arr.length - 1; i++) {
            int smallest = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[smallest] > arr[j]) {
                    smallest = j;
                }
            }
            //swapping
            int temp = arr[smallest];
            arr[smallest] = arr[i];
            arr[i] = temp;
        }
    }
    
    public static void main(String[] args) {
        //selection sort
        int arr[] = { 7, 8, 3, 1, 2 };
        System.out.print("Array before sorting : ");
        print(arr);
        sort(arr,arr.length);
        System.out.print("\nArray after sorting : ");
        print(arr);
    }
}
  
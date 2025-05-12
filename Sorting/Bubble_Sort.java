public class Bubble_Sort {
    //  function to print array
    public static void print(int arr[]) {
        for(int i=0;i<arr.length;i++) {
            System.out.print(arr[i]+" ");
        }
    }

    public static void main(String[] args) {
        //  Bubble sort
        int arr[] = {7,8,3,1,2};
        System.out.print("\nArray before sorting : ");
        print(arr);
        for(int i=0;i<arr.length-1;i++) {
            for(int j = 0 ; j <arr.length-i-1 ; j++) {
                if(arr[j]>arr[j+1]) {
                    //  Swap
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                } 
            }
        }
        System.out.print("\nArray after sorting : ");
        print(arr);
    }
}

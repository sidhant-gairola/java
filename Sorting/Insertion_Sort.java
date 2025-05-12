public class Insertion_Sort {
    //printing function
public static void print(int arr[]) {
    for(int i=0;i<arr.length;i++) {
    System.out.print(arr[i]+" ");
    }
}

public static void main(String[] args) {
//insertion sort
    int arr[] = {7,8,3,1,2};
    System.out.print("Array before sorting : ");
    print(arr);
    for(int i=1;i<arr.length;i++ ) {
    int current = arr[i];
    int j=i-1;
    while(j>=0 && (current<arr[j])) {
    //swap
        arr[j+1] = arr[j];
        arr[j] = current;
        j--;
    }
    }
    System.out.print("\nArray after sorting : ");
    print(arr);
    }
}
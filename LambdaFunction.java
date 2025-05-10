import java.util.*;
import java.util.function.Consumer;         //for single or more than 2 elements
import java.util.function.BiConsumer;       //for two elements

public class LambdaFunction {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // for single element
        System.out.println("Enter a number : ");
        int x = sc.nextInt();
        Consumer<Integer> cons1 = (n) -> {
            System.out.println(n*n);
        };
        cons1.accept(x);
        
        // for two elements
        System.out.println("Enter two number : ");
        int first = sc.nextInt();
        int second = sc.nextInt();
        BiConsumer<Integer,Integer> cons2 = (a,b) -> {
            System.out.println(a+b);
        };
        cons2.accept(first,second);
        
        
        // for more than two elements
        List<Integer> list  = new ArrayList<>();
        System.out.println("Enter list size : ");
        int size = sc.nextInt();
        System.out.println("Enter list elements : ");
        for(int i=0;i<size;i++) {
            System.out.println("Enter "+ (i+1) +" element : ");
            int element = sc.nextInt();
            list.add(element);
        }
        
        Consumer<List<Integer>> cons3 = (list2) -> {
            for(int num : list2) {
                if(num%2==0) System.out.println(num);
            }
        };
        cons3.accept(list);
    }
}
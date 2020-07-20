import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        ArrayList<Integer> list1 = readArrayList(scanner);
        ArrayList<Integer> list2 = new ArrayList<>();
        
        Integer s_int = (Integer) scanner.nextInt();
        Integer distance = Integer.MAX_VALUE;
        
        for(int i=0; i<list1.size(); i++){
            if (Math.abs(s_int-list1.get(i))<distance){
                list2.clear();
                distance = Math.abs(s_int-list1.get(i));
                list2.add(list1.get(i));
            }else if (Math.abs(s_int-list1.get(i))==distance){
                list2.add(list1.get(i));
            }
        }
        Collections.sort(list2);
        for(Integer i : list2){
            System.out.print(i+" ");
        }
    }
    private static ArrayList<Integer> readArrayList(Scanner scanner) {
        return Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayList::new));
    }
}

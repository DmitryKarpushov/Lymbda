import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Дмитрий Карпушов 26.09.2022
 */
public class Test2 {
    public static void main(String[] args) {
        int[] arr1 = new int[10];
        List<Integer> list1 = new ArrayList<>();

        fillArr(arr1);
        fillList(list1);

        System.out.println("list = " + list1);
        System.out.println("============================================");
        System.out.println("Arr = " + Arrays.toString(arr1));
        System.out.println("============================================");

        /**
         * "Map" method
         */
        arr1 = Arrays.stream(arr1).map(a -> a * 2).toArray();
        list1 = list1.stream().map(a -> a * 2).collect(Collectors.toList());

        arr1 = Arrays.stream(arr1).map(a -> 3).toArray();
        arr1 = Arrays.stream(arr1).map(a -> a + 1).toArray();

        System.out.println("list = " + list1);
        System.out.println("============================================");
        System.out.println("Arr = " + Arrays.toString(arr1));
        System.out.println("============================================");

        /**
         * "filter" method
         */
        int[] arr2 = new int[10];
        List<Integer> list2 = new ArrayList<>();
        fillArr(arr2);
        fillList(list2);

        arr2 = Arrays.stream(arr2).filter(a -> a % 2 == 0).toArray();
        list2 = list2.stream().filter(a -> a % 2 == 0).collect(Collectors.toList());

        System.out.println("list = " + list2);
        System.out.println("============================================");
        System.out.println("Arr = " + Arrays.toString(arr2));
        System.out.println("============================================");

        /**
         * Вывод
         */
        Arrays.stream(arr2).forEach(System.out::println);
        list2.stream().forEach(a -> System.out.println(a));

        /**
         * reduce метод
         */

        int[] arr3 = new int[10];
        List<Integer> list3 = new ArrayList<>();
        fillArr(arr3);
        fillList(list3);

        int sum1 = Arrays.stream(arr3).reduce((acc, b) -> acc + b).getAsInt();
        int sum2 = list3.stream().reduce((acc, b) -> acc * b).get();

        System.out.println("3)list = " + list3 + " sum2 = " + sum2);
        System.out.println("============================================");
        System.out.println("3)Arr = " + Arrays.toString(arr3) + " sum1 = " + sum1);
        System.out.println("============================================");


        int[] arr4 = new int[10];
        fillArr(arr4);

        int[] ARR4 = Arrays.stream(arr4).filter(a -> a % 2 != 0).map(a -> a * 2).toArray();
        System.out.println(Arrays.toString(ARR4));
        System.out.println("============================================");
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(5);
        System.out.println("1)set = " + set);
        set = set.stream().map(a->a*3).collect(Collectors.toSet());
        System.out.println("2)set = " + set);

    }

    private static void fillList(List<Integer> list) {
        for (int i = 0; i < 10; i++) {
            list.add(i + 1);
        }
    }

    private static void fillArr(int[] arr) {
        for (int i = 0; i < 10; i++) {
            arr[i] = i + 1;
        }
    }
}

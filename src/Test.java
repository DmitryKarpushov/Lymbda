import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author Дмитрий Карпушов 26.09.2022
 */

interface Executable {
    int execute(int x, int y);
}

class Runner {
    public void run(Executable e) {
        int a = e.execute(10, 15);
        System.out.println(a);
    }
}

/**
 * class ExecutableImplementation implements Executable{
 *
 * @Override public void execute() {
 * System.out.println("Hello");
 * }
 * }
 */

public class Test {
    public static void main(String[] args) {
        /**
         * Лямбда функция(выражение) - метод без названия или анонимный метод.
         */
        Runner runner = new Runner();
        //1 Один и тот же результат
        /** runner.run(new ExecutableImplementation());*/
        int b = 99;
        //2 Один и тот же результат (Это анонимный класс)
        runner.run(new Executable() {
            @Override
            public int execute(int x, int y) {
                System.out.println("Hello");
                System.out.println("Buy");
                int b = 99;
                return x + 555 + y;
            }
        });
        //3 Один и тот же результат
        runner.run((int x, int y) -> {
            System.out.println("Hello");
            System.out.println("Buy");
            return x + 5 + y;
        });
        System.out.println("------------скобки когда несколько аргументов------------------------");
        runner.run((int x, int y) -> x + 10 + y);
        System.out.println("--------------1)один аргумент----------------------");
        runner.run((x, y) -> x + 666);
        System.out.println("--------------2)один аргумент----------------------");
        int a = 77777; // должна быть final или const, но неявно.
        runner.run((x, y) -> x + 666 + y + a);
        /**
         * Сортировка list
         * */
        System.out.println("----------------------------------------------------------");
        System.out.println("----------------------------------------------------------");
        List<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("GOOOOOOOOOOG");
        list.add("a");
        list.add("asd");

//        list.sort(new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                if (o1.length() > o2.length()){
//                    return 1;
//                } else if (o1.length() < o2.length()) {
//                    return -1;
//                } else{
//                    return 0;
//                }
//            }
//        });

        Comparator<String> comparator =(s1, s2) -> {
            if (s1.length() > s2.length()) return 1;
            else if (s1.length() < s2.length()) return -1;
            else return 0;
        };
        System.out.println(list);
        System.out.println("----------------------------------------------------------");
        System.out.println("----------------------------------------------------------");
        list.sort((s1, s2) -> {
            if (s1.length() > s2.length()) return 1;
            else if (s1.length() < s2.length()) return -1;
            else return 0;
        });
        list.sort(comparator);
        System.out.println(list);
    }
}

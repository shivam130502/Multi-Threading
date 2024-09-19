import java.util.Arrays;
import java.util.List;
//import java.util.stream.Stream;

public class App {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1,2,3,4);

        list.stream().filter(n -> n/2 != 0).forEach(n -> System.out.println(n));

        //s.filter(n -> n/2 == 0);

        //s.forEach(x -> System.out.println(x));

    }
}

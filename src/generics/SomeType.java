package generics;

import java.util.Collection;
import java.util.List;

/**
 * Created by YONA on 27.04.2018.
 */
public class SomeType<T> {

    public <E> void test( Collection<E> collection ) {
        for (E e : collection) {
            System.out.println(e);
        }
    }

    public void test( List<Integer> integerList ) {
        for ( Integer integer : integerList) {
            System.out.println(integer);
        }
    }


}

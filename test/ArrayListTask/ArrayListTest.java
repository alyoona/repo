package ArrayListTask;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;


public class ArrayListTest {

    ArrayList listWithZeroElements;
    ArrayList listWithThreeElements;
    ArrayList listWithTenElements;

    @Before
    public void before() {
        listWithThreeElements = new ArrayList();
        listWithTenElements = new ArrayList();
        for (int i = 0; i < 3; i++) {
            listWithThreeElements.add(i);
        }

        for (int i = 0; i < 10; i++) {
            listWithTenElements.add(i);
        }
    }


    @Test
    public void testGet() {
        assertEquals(3, listWithThreeElements.size());

        for (int i = 0; i < listWithThreeElements.size(); i++) {
            Object actual = listWithThreeElements.get(i);
            assertEquals(i, actual);
        }
    }

    @Test
    public void testRemove() {
        assertEquals(3, listWithThreeElements.size());

        Object removedElement = listWithThreeElements.remove(1);

        assertEquals(2, listWithThreeElements.size());
        assertEquals(0, listWithThreeElements.get(0));
        assertEquals(1, removedElement);
        assertEquals(2, listWithThreeElements.get(1));

    }
}

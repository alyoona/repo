package ArrayListTask;

import org.junit.Before;
import org.junit.Test;


import static junit.framework.TestCase.assertEquals;


public class ArrayListTest {

    ArrayList listWithZeroElements;
    ArrayList listWithThreeElements;
    ArrayList listWithTenElements;


    @Before
    public void before() {

    }

    @Test
    public void testAddValue(){
        ArrayList list = new ArrayList(2);
        list.add(1);
        assertEquals(1,  list.array[0]);
        list.add(2);
        list.add(3);
        assertEquals(3,  list.array[2]);
    }

    @Test
    public void testAddValueByIndex(){

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

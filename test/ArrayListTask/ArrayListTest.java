package ArrayListTask;

import org.junit.*;


import static junit.framework.TestCase.assertEquals;


public class ArrayListTest {

    ArrayList listWithZeroElements;
    ArrayList listWithThreeElements;
    ArrayList listWithTenElements;
    Object expected;
    Object actual;


    @Before
    public void before() {

    }

    @Test
    public void testAddValue(){
        ArrayList list = new ArrayList(2);
        //step1
        list.add(1);
        actual = list.array[0];
        expected = 1;
        assertEquals(expected, actual);
        //step2
        list.add(2);
        list.add(3);
        actual = list.array[2];
        expected = 3;
        assertEquals(expected, actual);
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

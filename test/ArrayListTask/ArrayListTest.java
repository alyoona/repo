package ArrayListTask;

import org.junit.*;
import org.junit.rules.ExpectedException;

import static junit.framework.Assert.assertNull;
import static junit.framework.Assert.fail;
import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.core.IsEqual.equalTo;


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
        Object beforeAdding = list.array[list.size];
        assertNull(beforeAdding);
        Object shouldBeInserted = 1;
        int sizeShouldBeIncremented = list.size + 1;
        list.add(shouldBeInserted);
        Object inserted = list.array[list.size - 1];
        int sizeIncremented = list.size;
        assertEquals(shouldBeInserted, inserted);
        assertEquals(sizeShouldBeIncremented, sizeIncremented);
        //step2
        Object previousElementBeforeAdding = list.array[list.size - 1];
        shouldBeInserted = 2;
        sizeShouldBeIncremented = list.size + 1;
        list.add(shouldBeInserted);
        Object previousElementAfterAdding = list.size - 2;
        inserted = list.size - 1;
        sizeIncremented = list.size;
        assertEquals(previousElementBeforeAdding, previousElementAfterAdding);
        assertEquals(shouldBeInserted, inserted);
        assertEquals(sizeShouldBeIncremented, sizeIncremented);
        //step3
        assertEquals(list.size, list.array.length);
    }

    @Test
    public void testAddValueByIndex() throws IndexOutOfBoundsException{
        ArrayList list = new ArrayList(2);
        list.add(1);
        list.add(2);
        list.add(3);
        //step1 adding into first cell
        int index = 0;
        Object shouldBeInserted = "a";
        Object shouldBeShifted = list.array[index];
        int sizeShouldBeIncremented = list.size + 1;
        list.add(shouldBeInserted,index);
        Object inserted = list.array[index];
        Object shifted = list.array[index + 1];
        int sizeIncremented = list.size;
        assertEquals(shouldBeInserted, inserted);
        assertEquals(shouldBeShifted, shifted);
        assertEquals(sizeShouldBeIncremented,sizeIncremented);
        //step2 adding into last cell
        index = list.size - 1;
        shouldBeInserted = "a";
        shouldBeShifted = list.array[index];
        list.add(shouldBeInserted,index);
        inserted = list.array[index];
        shifted = list.array[index + 1];
        assertEquals(shouldBeInserted, inserted);
        assertEquals(shouldBeShifted, shifted);
        //step3
        try {
            list.add("b",-1);
            Assert.fail("Index should start at zero");
        } catch (IndexOutOfBoundsException thrown) {
            Assert.assertNotEquals("", thrown.getMessage());
        }
        //step4
        try {
            list.add("b",list.size);
            Assert.fail("Index should be less count of elements");
        } catch (IndexOutOfBoundsException thrown) {
            Assert.assertNotEquals("", thrown.getMessage());
        }
        //step5
        try {
            list.add("b",list.size + 1);
            Assert.fail("Index should be less count of elements");
        } catch (IndexOutOfBoundsException thrown) {
            Assert.assertNotEquals("", thrown.getMessage());
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

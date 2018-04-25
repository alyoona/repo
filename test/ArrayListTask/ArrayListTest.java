package ArrayListTask;

import org.junit.*;
import org.junit.rules.ExpectedException;

import static junit.framework.Assert.assertNull;
import static junit.framework.Assert.fail;
import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.core.IsEqual.equalTo;


public class ArrayListTest {
    Object expected;
    Object actual;
    ArrayList list;

    @Before
    public void before() {

    }

    @Test
    public void testAddByValueIntoEmptyArrayList() {
        list = new ArrayList(1);
        assertNull(list.array[list.size]);
        Object shouldBeInserted = "some value";
        list.add(shouldBeInserted);
        Object insertedValue = list.array[list.size - 1];
        assertEquals(shouldBeInserted, insertedValue);
    }

    @Test
    public void testAddByValueCheckIncrementingListSize() {
        list = new ArrayList(1);
        expected = list.size + 1;
        list.add(null);
        actual = list.size;
        assertEquals(expected, actual);
    }

    @Test
    public void testAddByValueIntoEndOfArrayList(){
        list = new ArrayList(2);
        list.add(null);
        Object currentElementBeforeAdding = list.array[list.size - 1];
        Object shouldBeInserted = "some value";
        list.add(shouldBeInserted);
        Object previousElementAfterAdding = list.array[list.size - 2];
        Object inserted = list.array[list.size - 1];
        assertEquals(currentElementBeforeAdding, previousElementAfterAdding);
        assertEquals(shouldBeInserted, inserted);
    }
    @Test
    public void testAddByValueCheckGrowingOfList(){
        list = new ArrayList(1);
        list.add(1);
        assertEquals(list.size, list.array.length);
        expected = list.array.length + 1;
        list.add(2);
        actual = list.array.length;
        assertEquals(expected, actual);
    }

    @Test
    public void testAddValueByIndexNegative() throws IndexOutOfBoundsException {
        list = new ArrayList(2);
        //step1
        try {
            list.add("b",-1);
            Assert.fail("Index should start at zero");
        } catch (IndexOutOfBoundsException thrown) {
            Assert.assertNotEquals("", thrown.getMessage());
        }
        //step2
        try {
            list.add("b",list.size);
            Assert.fail("Index should be less count of elements");
        } catch (IndexOutOfBoundsException thrown) {
            Assert.assertNotEquals("", thrown.getMessage());
        }
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

    }

}

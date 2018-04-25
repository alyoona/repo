package ArrayListTask;

import org.junit.*;
import org.junit.rules.ExpectedException;

import java.util.NoSuchElementException;

import static junit.framework.Assert.assertNull;
import static junit.framework.Assert.fail;
import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertNotEquals;


public class ArrayListTest {
    Object expected;
    Object actual;
    ArrayList list;

    @Test
    public void testAddByValueIntoEmptyArrayList() {
        list = new ArrayList(1);
        assertNull(list.array[list.size()]);
        Object shouldBeInserted = "some value";
        list.add(shouldBeInserted);
        Object insertedValue = list.array[list.size() - 1];
        assertEquals(shouldBeInserted, insertedValue);
    }

    @Test
    public void testAddByValueCheckIncrementingListSize() {
        list = new ArrayList(1);
        expected = list.size() + 1;
        list.add(null);
        actual = list.size();
        assertEquals(expected, actual);
    }

    @Test
    public void testAddByValueIntoEndOfArrayList() {
        list = new ArrayList(2);
        list.add(null);
        Object currentElementBeforeAdding = list.array[list.size() - 1];
        Object shouldBeInserted = "some value";
        list.add(shouldBeInserted);
        Object previousElementAfterAdding = list.array[list.size() - 2];
        Object inserted = list.array[list.size() - 1];
        assertEquals(currentElementBeforeAdding, previousElementAfterAdding);
        assertEquals(shouldBeInserted, inserted);
    }

    @Test
    public void testAddByValueCheckGrowingOfList() {
        list = new ArrayList(1);
        list.add(1);
        assertEquals(list.size(), list.array.length);
        expected = list.array.length + 1;
        list.add(2);
        actual = list.array.length;
        assertEquals(expected, actual);
    }

    @Test
    public void testAddByIndex() {
        list = new ArrayList(2);
        list.add(1);
        int index = 0;
        Object shouldBeInserted = "a";
        Object shouldBeShifted = list.array[index];
        list.add(shouldBeInserted, index);
        Object inserted = list.array[index];
        Object shifted = list.array[index + 1];
        assertEquals(shouldBeInserted, inserted);
        assertEquals(shouldBeShifted, shifted);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddByIndexNegativeBeforeStartIndex() {
        list = new ArrayList(2);
        list.add("b", -1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddByIndexNegativeAfterEndIndex() {
        list = new ArrayList(2);
        list.add("b", list.size());
    }

    @Test
    public void testGet() {
        list = new ArrayList(1);
        expected = "some value";
        list.add(expected);
        actual = list.get(list.size() - 1);
        assertEquals(expected, actual);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetNegativeBeforeStartIndex() {
        list = new ArrayList(1);
        list.get(-1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetNegativeAfterEndIndex() {
        list = new ArrayList(1);
        list.add(1);
        list.get(list.size());
    }

    @Test
    public void testSet() {
        list = new ArrayList(1);
        list.add(1);
        Object beforeUpdate = list.get(0);
        expected = "updated value";
        list.set(expected, 0);
        actual = list.get(0);
        assertNotEquals(beforeUpdate, actual);
        assertEquals(expected, actual);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetNegativeBeforeStartIndex() {
        list = new ArrayList(1);
        list.set("", -1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetNegativeAfterEndIndex() {
        list = new ArrayList(1);
        list.add(1);
        list.set("", list.size());
    }

    @Test
    public void testClear() {
        list = new ArrayList(1);
        list.add(1);
        assertEquals(1, list.size());
        list.clear();
        assertEquals(0, list.size());
    }

    @Test
    public void testSize() {
        list = new ArrayList(1);
        list.add(1);
        assertEquals(1, list.size());
        list.add(1);
        assertEquals(2, list.size());
    }

    @Test
    public void testIsEmpty() {
        list = new ArrayList(1);
        assertEquals(true, list.isEmpty());
        list.add(1);
        assertEquals(false, list.isEmpty());
    }

    @Test
    public void testContains() {
        list = new ArrayList(1);
        assertEquals(false, list.contains("some value"));
        list.add("some value");
        assertEquals(true, list.contains("some value"));
    }

    @Test
    public void testIndexOf() {
        list = new ArrayList(1);
        list.add("some value");
        list.add("some value");
        assertEquals(0, list.indexOf("some value"));
        assertNotEquals(1, list.indexOf("some value"));
    }

    @Test(expected = NoSuchElementException.class)
    public void testIndexOfNegative() {
        list = new ArrayList(1);
        list.add("1");
        list.indexOf("some value");
    }

    @Test
    public void testLastIndexOf() {
        list = new ArrayList(1);
        list.add("some value");
        list.add("some value");
        assertEquals(1, list.lastIndexOf("some value"));
        assertNotEquals(0, list.lastIndexOf("some value"));
    }

    @Test(expected = NoSuchElementException.class)
    public void testLastIndexOfNegative(){
        list = new ArrayList(1);
        list.add("1");
        list.lastIndexOf("some value");
    }

    @Test
    public void testRemove() {
        list = new ArrayList(1);
        list.add("for remove");
        list.add("some value");
        int size = list.size();
        Object removing = list.get(0);
        Object nextAfterRemoving = list.get(1);
        Object removed = list.remove(0);
        Object current = list.get(0);
        assertEquals(removing, removed);
        assertEquals(current, nextAfterRemoving);
        assertEquals(size - 1, list.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveNegativeBeforeStartIndex() {
        list = new ArrayList(1);
        list.remove( -1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveNegativeAfterEndIndex() {
        list = new ArrayList(1);
        list.add(1);
        list.remove(list.size());
    }

    @Test
    public void testToString() {
        list = new ArrayList(1);
        list.add("A");
        list.add("B");
        list.add("C");
        expected = "[A, B, C]";
        actual = list.toString();
        assertEquals(expected, actual);
    }

}

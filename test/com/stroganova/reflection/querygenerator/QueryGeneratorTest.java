package com.stroganova.reflection.querygenerator;

import org.junit.*;

import static org.junit.Assert.assertEquals;

public class QueryGeneratorTest {
    private QueryGenerator queryGenerator;
    private Person newPerson;

    @Before
    public void before() {
        queryGenerator = new QueryGenerator();
        newPerson = new Person();
        newPerson.setId(156);
        newPerson.setName("Ivanov");
        newPerson.setSalary(200.0);
    }

    @Test
    public void testGetAll() {
        String expected = "SELECT person_id, name, person_salary FROM Persons;";
        assertEquals(expected, queryGenerator.getAll(newPerson.getClass()));
    }

    @Test
    public void testInsert() {
        String expected = "INSERT INTO Persons (person_id, name, person_salary) VALUES (156, 'Ivanov', 200.0);";
        assertEquals(expected, queryGenerator.insert(newPerson));
    }

    @Test
    public void testUpdate() {
        String expected = "UPDATE Persons SET name = 'Ivanov', person_salary = 200.0 WHERE person_id = 156;";
        assertEquals(expected, queryGenerator.update(newPerson));
    }

    @Test
    public void testGetById() {
        String expected = "SELECT person_id, name, person_salary FROM Persons WHERE person_id = 15;";
        assertEquals(expected, queryGenerator.getById(newPerson.getClass(), 15));
    }

    @Test
    public void testDelete() {
        String expected = "DELETE FROM Persons WHERE person_id = 16;";
        assertEquals(expected, queryGenerator.delete(newPerson.getClass(), 16));
    }
}

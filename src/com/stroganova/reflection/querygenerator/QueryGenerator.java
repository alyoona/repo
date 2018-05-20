package com.stroganova.reflection.querygenerator;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.StringJoiner;

public class QueryGenerator {
    public String getAll(Class clazz) {
        Annotation annotation = clazz.getAnnotation(Table.class);
        if (annotation == null) {
            throw new IllegalArgumentException("Annotation @Table is not present");
        }

        Table tableAnnotation = (Table) annotation;
        String tableName = tableAnnotation.name().isEmpty() ?
                clazz.getName() : tableAnnotation.name();

        StringBuilder query = new StringBuilder("SELECT ");

        StringJoiner columnNames = new StringJoiner(", ");
        for (Field field : clazz.getDeclaredFields()) {
            Column columnAnnotation = field.getAnnotation(Column.class);
            if (columnAnnotation != null) {
                String columnName = columnAnnotation.name().isEmpty() ?
                        field.getName() : columnAnnotation.name();
                columnNames.add(columnName);
            }
        }

        query.append(columnNames);

        query.append(" FROM ");
        query.append(tableName);
        query.append(";");


        return query.toString();
    }

    public String insert(Object value) {
        return null;
    }

    public String update(Object value) {
        return null;
    }

    public String getById(Class clazz, Object id) {
        return null;
    }

    public String delete(Class clazz, Object id) {
        return null;
    }
}
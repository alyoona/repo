package com.stroganova.reflection.querygenerator;

import java.util.Iterator;
import java.util.List;
import java.util.StringJoiner;

/**
 * Created by YONA on 25.05.2018.
 */
public class Review {

//
//    public class InnerQueryGenerator {
//        public String getAll(Class clazz) {
//            StringBuilder query = new StringBuilder("SELECT ");
//            query.append(getPKName(clazz));
//            query.append(", ");
//            query.append(getColumnNames(clazz));
//            query.append(" FROM ");
//            query.append(getTableName(clazz));
//            query.append(";");
//            return query.toString();
//        }
//
//        public String insert(Object obj) {
//            List<String>[] array = columnNamesAndValues(obj);
//            StringBuilder query = new StringBuilder("INSERT INTO ");
//            query.append(getTableName(obj.getClass()));
//            query.append(" (");
//            query.append(getColumnNames(array[0]));
//            query.append(")");
//            query.append(" VALUES (");
//            query.append(getValues(array[1]));
//            query.append(");");
//            return query.toString();
//        }
//
//        public String update(Object obj) {
//            List<String>[] array = columnNamesAndValues(obj);
//            String pkName = getPKName(array[0]);
//            String pkValue = getPKValue(array[1]);
//            String setClause = getSETClause(array);
//            StringBuilder query = new StringBuilder("UPDATE ");
//            query.append(getTableName(obj.getClass()));
//            query.append(" SET ");
//            query.append(setClause);
//            query.append(" WHERE ");
//            query.append(pkName);
//            query.append(" = ");
//            query.append(pkValue);
//            query.append(";");
//            return query.toString();
//        }
//
//        public String getById(Class clazz, Object id) {
//            StringBuilder query = new StringBuilder();
//            query.append(getAll(clazz));
//            query.deleteCharAt(query.indexOf(";"));
//            query.append(" WHERE ");
//            query.append(getPKName(clazz));
//            query.append(" = ");
//            query.append(id);
//            query.append(";");
//            return query.toString();
//        }
//
//        public String delete(Class clazz, Object id) {
//            StringBuilder query = new StringBuilder("DELETE FROM ");
//            query.append(getTableName(clazz));
//            query.append(" WHERE ");
//            query.append(getPKName(clazz));
//            query.append(" = ");
//            query.append(id);
//            query.append(";");
//            return query.toString();
//        }
//
//        private String getTableName(Class clazz) {
//            Annotation annotation = clazz.getAnnotation(Table.class);
//            if (annotation == null) {
//                throw new IllegalArgumentException("Annotation @Table is not present");
//            }
//            Table tableAnnotation = (Table) annotation;
//            return tableAnnotation.name().isEmpty() ? clazz.getName() : tableAnnotation.name();
//        }
//
//        private String getPKName(Class clazz) {
//            return columns(clazz).get(0);
//        }
//
//        private String getColumnNames(Class clazz) {
//            List<String> listColumns = columns(clazz);
//            listColumns.remove(0);
//            return getColumnNames(listColumns);
//        }
//
//        private List<String> columns(Class clazz) {
//            List<String> list = new ArrayList<>();
//            for (Field field : clazz.getDeclaredFields()) {
//                Column columnAnnotation = field.getAnnotation(Column.class);
//                if (columnAnnotation != null) {
//                    String columnName = columnAnnotation.name().isEmpty() ?
//                            field.getName() : columnAnnotation.name();
//                    if (columnAnnotation.isPK()) {
//                        list.add(0, columnName);
//                    } else {
//                        list.add(columnName);
//                    }
//                }
//            }
//            return list;
//        }
//
//        static class ColumnsAndValues {
//            List<String> listColumns;
//            List<String> listValues;
//            String idName;
//            Object idValue;
//
//            public ColumnsAndValues(List<String> listColumns, List<String> listValues) {
//                this.listColumns = listColumns;
//                this.listValues = listValues;
//            }
//        }
//
//        private ColumnsAndValues columnNamesAndValues(Object obj) {
//            ColumnsAndValues columnsAndValues = new ColumnsAndValues();
//            Class clazz = obj.getClass();
//            List<String> listColumns = new ArrayList<>();
//            List<String> listValues = new ArrayList<>();
//            for (Field field : clazz.getDeclaredFields()) {
//                Column columnAnnotation = field.getAnnotation(Column.class);
//                if (columnAnnotation != null) {
//                    try {
//                        String columnName = columnAnnotation.name().isEmpty() ?
//                                field.getName() : columnAnnotation.name();
//                        field.setAccessible(true);
//                        // @Id
//                        if (columnAnnotation.isPK()) {
//                            columnsAndValues.idName = columnName;
//                            columnsAndValues.idValue = getValue(field, object);
//                        } else {
//                            listColumns.add(columnName);
//                            listValues.add(getValue(field, object););
//                        }
//
//                        field.setAccessible(false);
//                    } catch (IllegalAccessException e) {
//                        throw new RuntimeException("IllegalAccess: ", e);
//                    }
//                }
//            }
//            List<String>[] array = (ArrayList<String>[]) new ArrayList[2];
//            array[0] = listColumns;
//            array[1] = listValues;
//            return array;
//        }
//
//        private String getValue(Field field, Object obj) {
//            if (!field.getType().isPrimitive()) {
//                listValues.add(0, wrap(obj));
//            } else {
//                listValues.add(0, String.valueOf(obj));
//            }
//            return value;
//        }
//
//        private String wrap(Object obj, Field field) throws IllegalAccessException {
//            return "'" + field.get(obj) + "'";
//        }
//
//        private String getColumnNames(List<String> list) {
//            return String.join(", ", list);
//        }
//
//        private String getValues(List<String> list) {
//            return String.join(", ", list);
//        }
//
//        private String getPKName(List<String> list) {
//            return list.get(0);
//        }
//
//        private String getPKValue(List<String> list) {
//            return list.get(0);
//        }
//
//        private String getSETClause(List<String>[] array) {
//            List<String> columns = array[0];
//            columns.remove(0);
//            List<String> values = array[1];
//            values.remove(0);
//            Iterator columnIterator = columns.iterator();
//            Iterator valueIterator = values.iterator();
//            StringJoiner joiner = new StringJoiner(", ");
//            while (columnIterator.hasNext()) {
//                StringBuilder builder = new StringBuilder();
//                builder.append(columnIterator.next());
//                builder.append(" = ");
//                builder.append(valueIterator.next());
//                joiner.add(builder);
//            }
//            return joiner.toString();
//        }
//    }
}

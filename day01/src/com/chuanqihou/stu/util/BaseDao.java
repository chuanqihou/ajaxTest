package com.chuanqihou.stu.util;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 传奇后
 * @date 2023/3/14 17:13
 * @description
 */
public class BaseDao {
    //Connection con = DBUtil.getConnectionByDruid();
    Connection con = DBUtil.getConnection();

    public int insertDeleteUpdate(String sql,Object... args) {
        try {
            if (sql == null || "".equals(sql)) {
                return 0;
            }
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            for (int i = 0; args!=null && i < args.length; i++) {
                preparedStatement.setObject(i+1,args[i]);
            }
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public <T> T queryOne(String sql, Class<T> objectType, Object... args) {
        T obj = null;
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            for (int i = 0; args != null && i < args.length; i++) {
                preparedStatement.setObject(i + 1, args[i]);
            }
            ResultSet resultSet = preparedStatement.executeQuery();
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            if (resultSet.next()) {
                obj = objectType.newInstance();
                for (int i = 1; i <= columnCount; i++) {
                    String columnName = metaData.getColumnName(i);
                    Object columnValue = resultSet.getObject(columnName);
                    Field field = objectType.getDeclaredField(toCamelCase(columnName));
                    field.setAccessible(true);
                    field.set(obj, columnValue);
                }
            }
        } catch (SQLException | NoSuchFieldException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
        return obj;
    }

    /**
     * 查询方法，返回多条记录
     * @param sql
     * @param objectType
     * @param args
     * @param <T>
     * @return
     */
    public <T> List<T> query(String sql, Class<T> objectType, Object... args) {
        T obj = null;
        ArrayList<T> list = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            for (int i = 0; args != null && i < args.length; i++) {
                preparedStatement.setObject(i + 1, args[i]);
            }
            ResultSet resultSet = preparedStatement.executeQuery();
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            while (resultSet.next()) {
                obj = objectType.newInstance();
                for (int i = 1; i <= columnCount; i++) {
                    String columnName = metaData.getColumnName(i);
                    Object columnValue = resultSet.getObject(columnName);
                    Field field = objectType.getDeclaredField(toCamelCase(columnName));
                    field.setAccessible(true);
                    field.set(obj, columnValue);
                }
                list.add(obj);
            }
        } catch (SQLException | NoSuchFieldException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
        return list;
    }

    public <T> List<T> queryByAnnotation(String sql, Class<T> objectType, Object... args) {

        ArrayList<T> list = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            for (int i = 0; args != null && i < args.length; i++) {
                preparedStatement.setObject(i + 1, args[i]);
            }
            ResultSet resultSet = preparedStatement.executeQuery();
            Field[] fields = objectType.getDeclaredFields();
            while (resultSet.next()) {
                T obj = objectType.newInstance();
                for (Field field : fields) {
                    Column annotation = field.getAnnotation(Column.class);
                    if (annotation != null) {
                        String columnName = annotation.value();
                        Object object = resultSet.getObject(columnName);
                        field.setAccessible(true);
                        field.set(obj, object);
                    }
                }
                list.add(obj);
            }
        } catch (SQLException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        //System.out.println("list----"+list.size());
        return list;
    }

    public <T> T queryOneByAnnotation(String sql, Class<T> objectType, Object... args) {
        T obj = null;
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            for (int i = 0; args != null && i < args.length; i++) {
                preparedStatement.setObject(i + 1, args[i]);
            }
            ResultSet resultSet = preparedStatement.executeQuery();
            Field[] fields = objectType.getDeclaredFields();
            if (resultSet.next()) {
                obj = objectType.newInstance();
                for (Field field : fields) {
                    Column annotation = field.getAnnotation(Column.class);
                    if (annotation != null) {
                        String columnName = annotation.value();
                        Object object = resultSet.getObject(columnName);
                        field.setAccessible(true);
                        field.set(obj, object);
                    }
                }
            }
        } catch (SQLException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return obj;
    }

    /**
     * 驼峰式命名法 例如：user_name->userName
     * 将数据库字段名称  转为  Java实体类字段属性
     */
    public static String toCamelCase(String s) {
        if (s == null) {
            return null;
        }
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder(s.length());
        boolean upperCase = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '_') {
                upperCase = true;
            } else if (upperCase) {
                sb.append(Character.toUpperCase(c));
                upperCase = false;
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

}

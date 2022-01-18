package org.bo.annotation.example.processor;

import org.bo.annotation.example.Init;
import org.bo.annotation.example.JsonAttribute;
import org.bo.annotation.example.processor.exception.JsonSerializerException;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public class JsonSerializer {

    public static void initializeObject(Object object) {
        if (Objects.isNull(object)) throw new JsonSerializerException("Object to serialize do not can be null");

        Method[] methods = object.getClass().getDeclaredMethods();
        Arrays.stream(methods)
                .filter(method -> method.isAnnotationPresent(Init.class))
                .forEach(method -> {
                    method.setAccessible(true);
                    try {
                        method.invoke(object);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        throw new JsonSerializerException("Cannot be initialize the object: " + e.getMessage());
                    }
                });
    }

    public static String convertJson(Object object) {
        if (Objects.isNull(object)) throw new JsonSerializerException("Object to serialize do not can be null");

        initializeObject(object);
        Field[] fields = object.getClass().getDeclaredFields();
        String json = Arrays.stream(fields)
                .filter(field -> field.isAnnotationPresent(JsonAttribute.class))
                .map(f -> {
                    f.setAccessible(true);
                    String name = f.getAnnotation(JsonAttribute.class).name().equals("")
                            ? f.getName() : f.getAnnotation(JsonAttribute.class).name();
                    try {
                        Object value = f.get(object);
                        if (f.getAnnotation(JsonAttribute.class).capitalize() && value instanceof String) {
                            String newValue = (String) value;
                            String[] splitNewValue = newValue.split(" ");
                            newValue = Arrays.stream(splitNewValue)
                                    .map(element -> element.substring(0, 1).toUpperCase() + element.substring(1).toLowerCase())
                                    .collect(Collectors.joining(" "));
//                            newValue = newValue.substring(0, 1).toUpperCase() + newValue.substring(1).toLowerCase();
                            f.set(object, newValue);
                        }
                        return "\"" + name + "\" : \"" + f.get(object) + "\"";
                    } catch (IllegalAccessException e) {
                        throw new JsonSerializerException("Error to serialize the json: " + e.getMessage());
                    }
                })
                .reduce("{", (a, b) -> {
                    if ("{".equals(a)) {
                        return a + b;
                    }
                    return a + ", " + b;
                }).concat("}");
        return json;
    }

}

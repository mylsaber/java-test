package com.mylsaber.reflect;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.*;

/**
 * @author jfw
 */
public class MainTest {
    Class<Animal> aClass;

    @Before
    public void before() {
        aClass = Animal.class;
    }

    @Test
    public void Test1() throws ClassNotFoundException {
//        Class三种获取方式
        final Animal animal = new Animal(1, "狮子");
        final Class<? extends Animal> aClass = animal.getClass();
        final Class<Animal> animalClass = Animal.class;
        final Class<?> aClass1 = Class.forName("com.mylsaber.reflect.Animal");
        System.out.println(aClass);
        System.out.println(animalClass);
        System.out.println(aClass1);
    }

    @Test
    public void Test2() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        System.out.println("----------获取public构造方法----------");

        final Constructor<?>[] constructors = aClass.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);
        }

        System.out.println("----------获取所有构造方法----------");

        final Constructor<?>[] declaredConstructors = aClass.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println(declaredConstructor);
        }

        System.out.println("----------根据参数获取public构造方法----------");

        final Constructor<Animal> constructor = aClass.getConstructor(Integer.class, String.class);
        System.out.println(constructor);

        System.out.println("----------根据参数获取public构造方法----------");
        final Constructor<Animal> constructor1 = aClass.getConstructor(null);
        System.out.println(constructor1);

        System.out.println("--------根据参数获取所有构造方法------------");

        final Constructor<Animal> declaredConstructor = aClass.getDeclaredConstructor(String.class);
        System.out.println(declaredConstructor);

        System.out.println("----------相关方法-----------");
        final Animal animal = constructor1.newInstance(null);
        System.out.println(animal);
        declaredConstructor.setAccessible(true);
        final Animal monkey = declaredConstructor.newInstance("猴子");
        System.out.println(monkey);
        final int modifiers = declaredConstructor.getModifiers();
        System.out.println(modifiers);
        System.out.println("------parameterTypes-----------");
        final Class<?>[] parameterTypes = declaredConstructor.getParameterTypes();
        for (Class<?> parameterType : parameterTypes) {
            System.out.println(parameterType);
        }
        System.out.println("-----------parameters------------");
        final Parameter[] parameters = declaredConstructor.getParameters();
        for (Parameter parameter : parameters) {
            System.out.println(parameter);
        }
    }


    @Test
    public void test3() throws NoSuchFieldException, IllegalAccessException {
        System.out.println("----------获取所有public成员变量----------------");
        final Field[] fields = aClass.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        System.out.println("---------获取所有成员变量-----------------");
        final Field[] declaredFields = aClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }
        System.out.println("-------------根据名称获取public成员变量-------------");
        final Field name = aClass.getField("name");
        System.out.println(name);
        System.out.println("-------------根据名称获取所有成员变量-------------");
        final Field id = aClass.getDeclaredField("id");
        System.out.println(id);

        System.out.println("---------设置属性值--------------");
        final Animal animal = new Animal();
        System.out.println(animal);
        name.set(animal, "狮子");
        System.out.println("--------设置私有变量需要设置访问权限---------");
        id.setAccessible(true);
        id.set(animal, 1);
        System.out.println(animal);
        System.out.println("--------相关方法---------");
        final String name1 = name.getName();
        System.out.println(name1);
        final Class<?> type = name.getType();
        System.out.println(type);
        final int modifiers = name.getModifiers();
        System.out.println(modifiers);
        final Object o = name.get(animal);
        System.out.println(o);
    }

    @Test
    public void test4() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        System.out.println("--------获取所有public,包含继承方法-----------");
        final Method[] methods = aClass.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
        System.out.println("--------获取所有方法，不包含继承-----------");
        final Method[] declaredMethods = aClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod);
        }
        System.out.println("--------根据方法名，参数获取public方法-----------");
        final Method setId = aClass.getMethod("setId", Integer.class);
        System.out.println(setId);
        System.out.println("--------根据方法名，参数获取方法-----------");
        final Method getName = aClass.getDeclaredMethod("getName");
        System.out.println(getName);
        System.out.println("--------相关方法-----------");
        final Method setName = aClass.getMethod("setName", String.class);
        System.out.println(setName.getModifiers());
        System.out.println(setName.getName());
        System.out.println(setName.getParameterCount());
        System.out.println(setName.getReturnType());
        final Animal animal = new Animal();
        setName.invoke(animal, "invokeName");
        System.out.println(animal);
    }
}

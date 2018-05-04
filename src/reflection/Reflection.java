package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Reflection {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        // java.lang.Class
        // Class unknownClass = Class.forName(nameOfClass); - динамически формируем обращение к классу
        // но это медленно и небезопасно
        Class unknownClass = Class.forName(args[0]);
        System.out.println(unknownClass);
        System.out.println(unknownClass.getName());
        System.out.println(unknownClass.getSimpleName());

        // Получить модификатор
        int mod = unknownClass.getModifiers(); // битовый флаг
        System.out.println(mod);
        // Modifier.isAbstract(int mod);
        // MOdifier.isFinal(int mod);
        // Modifier.isNative(int mod);
        // и тд, узнаем о модификаторе все все все

        // Получение информации о пакете
        Package apack = unknownClass.getPackage();
        System.out.println(apack);

        // Получение суперкласса
        Class superClass = unknownClass.getSuperclass();
        System.out.println(superClass);

        // Получение реализованных интерфейсов
        Class[] interfeces = unknownClass.getInterfaces();
        System.out.println(Arrays.toString(interfeces));

        // Получение информации о конструкторах
        Constructor[] constructors = unknownClass.getConstructors();
        System.out.println(Arrays.toString(constructors));

        Class[] paramTypes = constructors[0].getParameterTypes();
        System.out.println(Arrays.toString(paramTypes));

        Constructor constructor = unknownClass.getConstructor(int.class, String.class);
        System.out.println(constructor);

        Object tstObj = constructor.newInstance(3, "kokoko");
        System.out.println(tstObj.toString());


        // получение атрибутов класса
        Field[] fields = unknownClass.getFields();
        System.out.println(Arrays.toString(fields));  // возвращает только публичные поля
         Field field = unknownClass.getField("tstField");  //- передаем название поля
         Object fieldType = field.getType();
         Object fieldName = field.getName();

         Object vsl = field.get(tstObj); // получаем значение поля
         field.set(tstObj, "kokoko"); //- устанавливаем какое-то значение полю
        System.out.println(vsl);

        // получение информации о методах
        Method[] methods = unknownClass.getMethods();
        Method method = unknownClass.getMethod("getStrData", null);
        // Получить тип возвращаемого значения
        Class returnType = method.getReturnType();
        System.out.println(method.invoke(tstObj, null)); // вызов метода объекта
        // method.invoke(null, null); // для вызова статических методов

        // доступ к приватным полям
        // Class.getDeclaredFields() и Class.getDeclaredField(name)
        // и методоам
        Method privateMethod = unknownClass.getDeclaredMethod("callPrivate");
        Method[] privateMethods = unknownClass.getDeclaredMethods();
        System.out.println(privateMethod);
        privateMethod.setAccessible(true); // включаем доступ для рефлексии
        privateMethod.invoke(tstObj, null);


    }
}

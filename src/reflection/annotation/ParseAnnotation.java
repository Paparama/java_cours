package reflection.annotation;

import reflection.TstClass;

import java.lang.reflect.Field;

public class ParseAnnotation {
    public static void main(String[] args) throws NoSuchFieldException {
        Class aclass = TstClass.class;
        Field field = aclass.getDeclaredField("tstField");
        UserAnnotation userAnnotation = field.getAnnotation(UserAnnotation.class);
        Field field2 = aclass.getDeclaredField("strData");
        UserAnnotation userAnnotation2 = field2.getAnnotation(UserAnnotation.class);
        System.out.println(userAnnotation.authorName());
        System.out.println(userAnnotation2.authorName());  // NPE
    }
}

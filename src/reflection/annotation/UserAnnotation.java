package reflection.annotation;


import java.lang.annotation.*;
import java.lang.reflect.Method;

// могут иметь Метоанатацию
@Target(ElementType.FIELD) // Сообщает, к каким частям кода будет применяться наша анатация
@Retention(RetentionPolicy.RUNTIME)  // говорит о том, как долго сохраняются эти аннотации
@Inherited // автоматически передается аннотация по наследству
public @interface UserAnnotation {
// @Override
// @Deprecated

    // методы не должны иметь параметров
    String authorName() default "Me"; // не должен иметь параметров, могут возвращать только примитивы, стринг и перечисления
    // могут быть значения по умолчанию, как сверху, а могут и не быть


}

package mySpring;

import lombok.SneakyThrows;

import java.lang.reflect.Field;
import java.util.Random;

public class InjectRandomIntObjectConfig implements ObjectConfig {
    private Random random = new Random();

    @SneakyThrows
    @Override
    public <T> void invoke(T o) {
        Field[] fields = o.getClass().getDeclaredFields();
        for (Field field : fields) {
            InjectRandomInt annotation = field.getAnnotation(InjectRandomInt.class);
            if (annotation != null) {
                int min = annotation.min();
                int max = annotation.max();
                int randomIntValue = random.nextInt(max - min) + min;
                field.setAccessible(true);
                field.set(o, randomIntValue);

            }
        }
    }
}

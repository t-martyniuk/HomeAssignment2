package mySpring;

import lombok.SneakyThrows;
import org.reflections.Reflections;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class ObjectFactory {
    private static ObjectFactory ourInstance = new ObjectFactory();
    private Config config = new JavaConfig();
    private Random random = new Random();
    private List<ObjectConfig> objectConfigs = new ArrayList<>();
    public static ObjectFactory getInstance() {
        return ourInstance;
    }

    @SneakyThrows
    private ObjectFactory() {
        //Scanning all the configurations and adding them to the list.
        Reflections scanner = new Reflections("mySpring");
        Set<Class<? extends ObjectConfig>> classes = scanner.getSubTypesOf(ObjectConfig.class);
        for (Class<? extends ObjectConfig> aClass : classes) {
            if (!Modifier.isAbstract(aClass.getModifiers())) {
                objectConfigs.add(aClass.newInstance());
            }
        }

    }

    @SneakyThrows
    public <T> T createObject(Class<T> type) {
        if (type.isInterface()) {
           type =  config.getImpl(type);
        }
        T o = type.newInstance();

        for (ObjectConfig objectConfig:objectConfigs) {
            objectConfig.invoke(o);
        }

        return o;
    }
}

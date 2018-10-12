package base.badmoviesql.util;

import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Modifier;
import java.util.HashSet;
import java.util.Set;

/**
 * The ClassScanner utilizes the google Reflections library to scan certain packages looking for classes or interfaces
 * which are children of a given type.  This can be used to substantially speed up the performance of reflection as you
 * can eliminate the need for scanning with the default classloader, but you also have the ability to search for members
 * of a particular package which is used to add the Aliases for MyBatis in the DataConfig class.
 */
public class ClassScanner {
    private static Logger logger = LoggerFactory.getLogger(ClassScanner.class);

    public static <T> Set<T> getInstances(Class<T> type, String packageName) {
        Set<Class<? extends T>> types = getClasses(type, packageName, false);
        Set<T> instances = new HashSet<>();
        try {
            for (Class<? extends T> classType : types) {
                if (type.isAssignableFrom(classType)) {
                    instances.add(classType.newInstance());
                }
            }
        } catch (IllegalAccessException iae) {
            logger.error("Unable to access class + " + type.toString() + " for instantiation", iae);
        } catch (InstantiationException ie) {
            logger.error("Error when instantiating class + " + type.toString(), ie);
        }

        return instances;
    }

    public static Set<Class<? extends Object>> getClasses(String packageName) {
        return getClasses(Object.class, packageName, false);
    }

    public static Set<Class<? extends Object>> getClasses(String packageName, Class clazz) {
        return getClasses(clazz, packageName, false);
    }

    private static <T> Set<Class<? extends T>> getClasses(Class clazz, String packageName, boolean isInterface) {
        Reflections reflections = new Reflections(packageName, new SubTypesScanner(false));
        Set<Class<? extends T>> types = reflections.getSubTypesOf(clazz);

        return filterTypes(types, isInterface);
    }

    private static <T> Set<Class<? extends T>> filterTypes(Set<Class<? extends T>> allTypes, boolean isInterface) {
        Set<Class<? extends T>> types = new HashSet<>();

        for (Class<? extends T> type : allTypes) {
            if (type.isInterface() == isInterface && (isInterface || !Modifier.isAbstract((type.getModifiers())))) {
                types.add(type);
            }
        }
        return types;
    }
}
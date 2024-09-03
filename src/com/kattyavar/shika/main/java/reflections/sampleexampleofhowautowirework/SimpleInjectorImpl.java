package com.kattyavar.shika.main.java.reflections.sampleexampleofhowautowirework;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class SimpleInjectorImpl {

  private final Map<Class<?>, Object> instances = new HashMap<>();

  public SimpleInjectorImpl() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {


    register(MyController.class);
    register(MyService.class);
    //Now inject
    injectDependencies();

  }

  public <T> void register(Class<T> clazz) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
    T instance = clazz.getDeclaredConstructor().newInstance();
    instances.put(clazz, instance);
  }

  private void injectDependencies() throws IllegalAccessException {
    for (Object instance : instances.values()) {
      Class<?> clazz = instance.getClass();
      for (Field field : clazz.getDeclaredFields()) {
        if (field.isAnnotationPresent(Inject.class)) {
          field.setAccessible(true);
          Class<?> fieldType = field.getType();
          Object dependency = instances.get(fieldType);
          if (dependency != null) {
            field.set(instance, dependency);
          }
        }
      }
    }
  }

  public <T> T getInstance(Class<T> clazz) {
    return clazz.cast(instances.get(clazz));
  }

  public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
    withInjectorExample();
  }

  static void thisWillNotWork() {

    //As MyController  private MyService myService. We need myService object. As this is null this will not work.
    MyController controller = new MyController();

    controller.printMessage();
  }


  static void withInjectorExample() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
    SimpleInjectorImpl injector = new SimpleInjectorImpl();
    MyController controller = injector.getInstance(MyController.class);

    controller.printMessage();

    System.out.println(injector.instances.toString());
  }

}

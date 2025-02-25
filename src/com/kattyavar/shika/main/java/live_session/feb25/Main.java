package com.kattyavar.shika.main.java.live_session.feb25;

public class Main {
  public static void main(String[] args) {
    ModuleLayer layer = ModuleLayer.boot();
    System.out.println(String.format("%-30s -> %-20s", "Module", "loaded by"));

    layer.modules()
      .forEach(module -> {
        ClassLoader classLoader = module.getClassLoader();

        String classLoaderName;
        if(classLoader == null){
          classLoaderName = "bootstrap";
        } else {
          classLoaderName = classLoader.getClass().getName();
        }

       // System.out.println("Module\t\t-> " + module.getName() + "\t\tloaded by\t-> " + classLoaderName);
// Just use String.format() with fixed widths for columns
        System.out.println(String.format("%-30s -> %-20s", module.getName(), classLoaderName));

      });


  }
}

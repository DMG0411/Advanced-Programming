package org.example;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.*;

public class ClassLoader{
    public static void main(String[] args) {
        String filePath = "C:/Users/m2bob/Documents/IntelliJProjects/PA_Lab11/src/main/java/com/example/demo/controllers/GameController.class";

        // Load the specified class
        try {
            File file = new File(filePath);
            URL url = file.toURI().toURL();
            URLClassLoader classLoader = new URLClassLoader(new URL[]{url});
            String className = getClassName(filePath);
            Class<?> loadedClass = classLoader.loadClass(className);

            // Get the package dynamically
            Package classPackage = loadedClass.getPackage();
            if (classPackage != null) {
                String packageName = classPackage.getName();
                System.out.println("Package: " + packageName);
            }

            // Extract information about the class (e.g., methods)
            System.out.println("Class: " + loadedClass.getSimpleName());

            // Get methods
            System.out.println("Methods:");
            List<String> testMethods = new ArrayList<>();
            for (java.lang.reflect.Method method : loadedClass.getDeclaredMethods()) {
                System.out.println(method.getName());
                // Check if the method is annotated with @Test and is static
                if (method.isAnnotationPresent(Test.class) && java.lang.reflect.Modifier.isStatic(method.getModifiers())) {
                    testMethods.add(method.getName());
                }
            }

            // Invoke the static methods annotated with @Test
            System.out.println("Invoking @Test methods:");
            for (String methodName : testMethods) {
                try {
                    java.lang.reflect.Method method = loadedClass.getDeclaredMethod(methodName);
                    method.invoke(null);
                    System.out.println("Invoked method: " + methodName);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String getClassName(String filePath) {
        String className = null;
        try {
            className = filePath.substring(filePath.lastIndexOf("/") + 1, filePath.lastIndexOf("."));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return className;
    }
}

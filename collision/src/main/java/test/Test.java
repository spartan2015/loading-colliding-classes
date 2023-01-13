package test;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class Test {

    public static void main(String[] args) throws Exception {
        invokeFromJar("package1/target/package1-1.0-SNAPSHOT.jar");
        invokeFromJar("package2/target/package2-1.0-SNAPSHOT.jar");
    }

    private static void invokeFromJar(String package1) throws MalformedURLException, ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        URL url = new File(package1).toURL();
        System.out.println(
                url
        );
        URLClassLoader cl = new URLClassLoader(new URL[]{url});
        Class<?> aClass = cl.loadClass("package1.MyClass");
        Object o = aClass.newInstance();
        aClass.getMethod("echo").invoke(o);
    }
}

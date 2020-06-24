package com.bridgelabz.annotations;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class AnnotationsTest {
    @Override
    @MethodInfo(author = "Haritha", comments = "Main Method", date = "23 June 2020", revision = 1)
    public String toString() {
        return "Overridden toString Method";
    }

    @Deprecated
    @MethodInfo(comments = "deprecated method", date = "23 June 2020")
    public static void oldMethod() {
        System.out.println("old method,don't use it");
    }

    public static void main(String[] args) {
        try {
            for (Method method : AnnotationsTest.class.getMethods()) {
                //checks if MethodInfo annotation is present for the method
                if (method.isAnnotationPresent(MethodInfo.class)) {
                    try {
                        //iterates all the annotations available in the method
                        for (Annotation anno : method.getDeclaredAnnotations()) {
                            System.out.println("Annotation in method '" + method + "' : " + anno);
                        }
                        MethodInfo methodInfo = method.getAnnotation(MethodInfo.class);
                        if (methodInfo.revision() == 1) {
                            System.out.println("Method with revision no 1 = " + method);
                        }
                    } catch (Throwable throwable) {
                        throwable.printStackTrace();
                    }
                }
            }
        } catch (SecurityException securityException) {
            securityException.printStackTrace();
        }
    }
}
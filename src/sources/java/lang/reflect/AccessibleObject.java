package java.lang.reflect;

import java.lang.annotation.Annotation;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class AccessibleObject implements AnnotatedElement {
    boolean override;

    public static void setAccessible(AccessibleObject[] array, boolean flag) throws SecurityException {
        for (AccessibleObject accessibleObject : array) {
            setAccessible0(accessibleObject, flag);
        }
    }

    public void setAccessible(boolean flag) throws SecurityException {
        setAccessible0(this, flag);
    }

    private static void setAccessible0(AccessibleObject obj, boolean flag) throws SecurityException {
        if ((obj instanceof Constructor) && flag) {
            Constructor<?> c4 = (Constructor) obj;
            Class<?> clazz = c4.getDeclaringClass();
            if (clazz == Class.class) {
                throw new SecurityException("Can not make a java.lang.Class constructor accessible");
            }
            if (clazz == Method.class) {
                throw new SecurityException("Can not make a java.lang.reflect.Method constructor accessible");
            }
            if (clazz == Field.class) {
                throw new SecurityException("Can not make a java.lang.reflect.Field constructor accessible");
            }
        }
        obj.override = flag;
    }

    public boolean isAccessible() {
        return this.override;
    }

    @Override // java.lang.reflect.AnnotatedElement
    public <T extends Annotation> T getAnnotation(Class<T> annotationClass) {
        throw new AssertionError((Object) "All subclasses should override this method");
    }

    @Override // java.lang.reflect.AnnotatedElement
    public boolean isAnnotationPresent(Class<? extends Annotation> annotationClass) {
        return super.isAnnotationPresent(annotationClass);
    }

    @Override // java.lang.reflect.AnnotatedElement
    public <T extends Annotation> T[] getAnnotationsByType(Class<T> annotationClass) {
        throw new AssertionError((Object) "All subclasses should override this method");
    }

    @Override // java.lang.reflect.AnnotatedElement
    public Annotation[] getAnnotations() {
        return getDeclaredAnnotations();
    }

    @Override // java.lang.reflect.AnnotatedElement
    public <T extends Annotation> T getDeclaredAnnotation(Class<T> cls) {
        return (T) getAnnotation(cls);
    }

    @Override // java.lang.reflect.AnnotatedElement
    public <T extends Annotation> T[] getDeclaredAnnotationsByType(Class<T> cls) {
        return (T[]) getAnnotationsByType(cls);
    }

    @Override // java.lang.reflect.AnnotatedElement
    public Annotation[] getDeclaredAnnotations() {
        throw new AssertionError((Object) "All subclasses should override this method");
    }
}

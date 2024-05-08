package java.lang.reflect;

import dalvik.annotation.optimization.FastNative;
import java.lang.annotation.Annotation;
import java.lang.reflect.Executable;
import java.util.Comparator;
import libcore.util.EmptyArray;
import sun.reflect.CallerSensitive;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class Constructor<T> extends Executable {
    private static final Comparator<Method> ORDER_BY_SIGNATURE = null;
    private final Class<?> serializationClass;
    private final Class<?> serializationCtor;

    @FastNative
    private native T newInstance0(Object... objArr) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;

    @FastNative
    private static native Object newInstanceFromSerialization(Class<?> cls, Class<?> cls2) throws InstantiationException, IllegalArgumentException, InvocationTargetException;

    @Override // java.lang.reflect.Executable
    @FastNative
    public native Class<?>[] getExceptionTypes();

    private Constructor() {
        this(null, null);
    }

    private Constructor(Class<?> serializationCtor, Class<?> serializationClass) {
        this.serializationCtor = serializationCtor;
        this.serializationClass = serializationClass;
    }

    public Constructor<T> serializationCopy(Class<?> ctor, Class<?> cl) {
        return new Constructor<>(ctor, cl);
    }

    @Override // java.lang.reflect.Executable
    boolean hasGenericInformation() {
        return super.hasGenericInformationInternal();
    }

    @Override // java.lang.reflect.Executable, java.lang.reflect.Member
    public Class<T> getDeclaringClass() {
        return (Class<T>) super.getDeclaringClassInternal();
    }

    @Override // java.lang.reflect.Executable, java.lang.reflect.Member
    public String getName() {
        return getDeclaringClass().getName();
    }

    @Override // java.lang.reflect.Executable, java.lang.reflect.Member
    public int getModifiers() {
        return super.getModifiersInternal();
    }

    @Override // java.lang.reflect.Executable, java.lang.reflect.GenericDeclaration
    public TypeVariable<Constructor<T>>[] getTypeParameters() {
        Executable.GenericInfo info = getMethodOrConstructorGenericInfoInternal();
        return (TypeVariable[]) info.formalTypeParameters.clone();
    }

    @Override // java.lang.reflect.Executable
    public Class<?>[] getParameterTypes() {
        Class<?>[] paramTypes = super.getParameterTypesInternal();
        if (paramTypes == null) {
            return EmptyArray.CLASS;
        }
        return paramTypes;
    }

    @Override // java.lang.reflect.Executable
    public int getParameterCount() {
        return super.getParameterCountInternal();
    }

    @Override // java.lang.reflect.Executable
    public Type[] getGenericParameterTypes() {
        return super.getGenericParameterTypes();
    }

    @Override // java.lang.reflect.Executable
    public Type[] getGenericExceptionTypes() {
        return super.getGenericExceptionTypes();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof Constructor)) {
            Constructor<?> other = (Constructor) obj;
            if (getDeclaringClass() == other.getDeclaringClass()) {
                return equalParamTypes(getParameterTypes(), other.getParameterTypes());
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        return getDeclaringClass().getName().hashCode();
    }

    public String toString() {
        return sharedToString(Modifier.constructorModifiers(), false, getParameterTypes(), getExceptionTypes());
    }

    @Override // java.lang.reflect.Executable
    void specificToStringHeader(StringBuilder sb2) {
        sb2.append(getDeclaringClass().getTypeName());
    }

    @Override // java.lang.reflect.Executable
    public String toGenericString() {
        return sharedToGenericString(Modifier.constructorModifiers(), false);
    }

    @Override // java.lang.reflect.Executable
    void specificToGenericStringHeader(StringBuilder sb2) {
        specificToStringHeader(sb2);
    }

    @CallerSensitive
    public T newInstance(Object... objArr) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Class<?> cls = this.serializationClass;
        if (cls == null) {
            return newInstance0(objArr);
        }
        return (T) newInstanceFromSerialization(this.serializationCtor, cls);
    }

    @Override // java.lang.reflect.Executable
    public boolean isVarArgs() {
        return super.isVarArgs();
    }

    @Override // java.lang.reflect.Executable, java.lang.reflect.Member
    public boolean isSynthetic() {
        return super.isSynthetic();
    }

    /* JADX WARN: Incorrect return type in method signature: <T::Ljava/lang/annotation/Annotation;>(Ljava/lang/Class<TT;>;)TT; */
    @Override // java.lang.reflect.Executable, java.lang.reflect.AccessibleObject, java.lang.reflect.AnnotatedElement
    public Annotation getAnnotation(Class cls) {
        return super.getAnnotation(cls);
    }

    @Override // java.lang.reflect.Executable, java.lang.reflect.AccessibleObject, java.lang.reflect.AnnotatedElement
    public Annotation[] getDeclaredAnnotations() {
        return super.getDeclaredAnnotations();
    }

    @Override // java.lang.reflect.Executable
    public Annotation[][] getParameterAnnotations() {
        return super.getParameterAnnotationsInternal();
    }
}

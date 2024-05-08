package java.lang.reflect;

import dalvik.annotation.optimization.FastNative;
import java.lang.annotation.Annotation;
import java.lang.reflect.Executable;
import java.util.Comparator;
import libcore.reflect.Types;
import libcore.util.EmptyArray;
import sun.reflect.CallerSensitive;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class Method extends Executable {
    public static final Comparator<Method> ORDER_BY_SIGNATURE = new Comparator<Method>() { // from class: java.lang.reflect.Method.1
        @Override // java.util.Comparator
        public int compare(Method a10, Method b4) {
            if (a10 == b4) {
                return 0;
            }
            int comparison = a10.getName().compareTo(b4.getName());
            if (comparison == 0) {
                int comparison2 = a10.compareMethodParametersInternal(b4);
                if (comparison2 == 0) {
                    Class<?> aReturnType = a10.getReturnType();
                    Class<?> bReturnType = b4.getReturnType();
                    if (aReturnType == bReturnType) {
                        return 0;
                    }
                    return aReturnType.getName().compareTo(bReturnType.getName());
                }
                return comparison2;
            }
            return comparison;
        }
    };

    @FastNative
    public native Object getDefaultValue();

    @Override // java.lang.reflect.Executable
    @FastNative
    public native Class<?>[] getExceptionTypes();

    @FastNative
    @CallerSensitive
    public native Object invoke(Object obj, Object... objArr) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException;

    private Method() {
    }

    @Override // java.lang.reflect.Executable
    boolean hasGenericInformation() {
        return super.hasGenericInformationInternal();
    }

    @Override // java.lang.reflect.Executable, java.lang.reflect.Member
    public Class<?> getDeclaringClass() {
        return super.getDeclaringClassInternal();
    }

    @Override // java.lang.reflect.Executable, java.lang.reflect.Member
    public String getName() {
        return getMethodNameInternal();
    }

    @Override // java.lang.reflect.Executable, java.lang.reflect.Member
    public int getModifiers() {
        return super.getModifiersInternal();
    }

    @Override // java.lang.reflect.Executable, java.lang.reflect.GenericDeclaration
    public TypeVariable<Method>[] getTypeParameters() {
        Executable.GenericInfo info = getMethodOrConstructorGenericInfoInternal();
        return (TypeVariable[]) info.formalTypeParameters.clone();
    }

    public Class<?> getReturnType() {
        return getMethodReturnTypeInternal();
    }

    public Type getGenericReturnType() {
        return Types.getType(getMethodOrConstructorGenericInfoInternal().genericReturnType);
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
        if (obj != null && (obj instanceof Method)) {
            Method other = (Method) obj;
            if (getDeclaringClass() != other.getDeclaringClass() || getName() != other.getName() || !getReturnType().equals(other.getReturnType())) {
                return false;
            }
            return equalParamTypes(getParameterTypes(), other.getParameterTypes());
        }
        return false;
    }

    public int hashCode() {
        return getDeclaringClass().getName().hashCode() ^ getName().hashCode();
    }

    public String toString() {
        return sharedToString(Modifier.methodModifiers(), isDefault(), getParameterTypes(), getExceptionTypes());
    }

    @Override // java.lang.reflect.Executable
    void specificToStringHeader(StringBuilder sb2) {
        sb2.append(getReturnType().getTypeName()).append(' ');
        sb2.append(getDeclaringClass().getTypeName()).append('.');
        sb2.append(getName());
    }

    @Override // java.lang.reflect.Executable
    public String toGenericString() {
        return sharedToGenericString(Modifier.methodModifiers(), isDefault());
    }

    @Override // java.lang.reflect.Executable
    void specificToGenericStringHeader(StringBuilder sb2) {
        Type genRetType = getGenericReturnType();
        sb2.append(genRetType.getTypeName()).append(' ');
        sb2.append(getDeclaringClass().getTypeName()).append('.');
        sb2.append(getName());
    }

    public boolean isBridge() {
        return super.isBridgeMethodInternal();
    }

    @Override // java.lang.reflect.Executable
    public boolean isVarArgs() {
        return super.isVarArgs();
    }

    @Override // java.lang.reflect.Executable, java.lang.reflect.Member
    public boolean isSynthetic() {
        return super.isSynthetic();
    }

    public boolean isDefault() {
        return super.isDefaultMethodInternal();
    }

    @Override // java.lang.reflect.Executable, java.lang.reflect.AccessibleObject, java.lang.reflect.AnnotatedElement
    public <T extends Annotation> T getAnnotation(Class<T> cls) {
        return (T) super.getAnnotation(cls);
    }

    @Override // java.lang.reflect.Executable, java.lang.reflect.AccessibleObject, java.lang.reflect.AnnotatedElement
    public Annotation[] getDeclaredAnnotations() {
        return super.getDeclaredAnnotations();
    }

    @Override // java.lang.reflect.Executable
    public Annotation[][] getParameterAnnotations() {
        return super.getParameterAnnotationsInternal();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean equalNameAndParameters(Method m10) {
        return equalNameAndParametersInternal(m10);
    }
}

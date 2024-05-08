package java.lang.reflect;

import dalvik.annotation.optimization.FastNative;
import java.lang.annotation.Annotation;
import java.util.Objects;
import libcore.reflect.AnnotatedElements;
import libcore.reflect.GenericSignatureParser;
import sun.reflect.CallerSensitive;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class Field extends AccessibleObject implements Member {
    private int accessFlags;
    private int artFieldIndex;
    private Class<?> declaringClass;
    private int offset;
    private Class<?> type;

    @FastNative
    private native <A extends Annotation> A getAnnotationNative(Class<A> cls);

    @FastNative
    private native String getNameInternal();

    @FastNative
    private native String[] getSignatureAnnotation();

    @FastNative
    private native boolean isAnnotationPresentNative(Class<? extends Annotation> cls);

    @FastNative
    @CallerSensitive
    public native Object get(Object obj) throws IllegalArgumentException, IllegalAccessException;

    @FastNative
    public native long getArtField();

    @FastNative
    @CallerSensitive
    public native boolean getBoolean(Object obj) throws IllegalArgumentException, IllegalAccessException;

    @FastNative
    @CallerSensitive
    public native byte getByte(Object obj) throws IllegalArgumentException, IllegalAccessException;

    @FastNative
    @CallerSensitive
    public native char getChar(Object obj) throws IllegalArgumentException, IllegalAccessException;

    @Override // java.lang.reflect.AccessibleObject, java.lang.reflect.AnnotatedElement
    @FastNative
    public native Annotation[] getDeclaredAnnotations();

    @FastNative
    @CallerSensitive
    public native double getDouble(Object obj) throws IllegalArgumentException, IllegalAccessException;

    @FastNative
    @CallerSensitive
    public native float getFloat(Object obj) throws IllegalArgumentException, IllegalAccessException;

    @FastNative
    @CallerSensitive
    public native int getInt(Object obj) throws IllegalArgumentException, IllegalAccessException;

    @FastNative
    @CallerSensitive
    public native long getLong(Object obj) throws IllegalArgumentException, IllegalAccessException;

    @FastNative
    @CallerSensitive
    public native short getShort(Object obj) throws IllegalArgumentException, IllegalAccessException;

    @FastNative
    @CallerSensitive
    public native void set(Object obj, Object obj2) throws IllegalArgumentException, IllegalAccessException;

    @FastNative
    @CallerSensitive
    public native void setBoolean(Object obj, boolean z10) throws IllegalArgumentException, IllegalAccessException;

    @FastNative
    @CallerSensitive
    public native void setByte(Object obj, byte b4) throws IllegalArgumentException, IllegalAccessException;

    @FastNative
    @CallerSensitive
    public native void setChar(Object obj, char c4) throws IllegalArgumentException, IllegalAccessException;

    @FastNative
    @CallerSensitive
    public native void setDouble(Object obj, double d10) throws IllegalArgumentException, IllegalAccessException;

    @FastNative
    @CallerSensitive
    public native void setFloat(Object obj, float f10) throws IllegalArgumentException, IllegalAccessException;

    @FastNative
    @CallerSensitive
    public native void setInt(Object obj, int i10) throws IllegalArgumentException, IllegalAccessException;

    @FastNative
    @CallerSensitive
    public native void setLong(Object obj, long j10) throws IllegalArgumentException, IllegalAccessException;

    @FastNative
    @CallerSensitive
    public native void setShort(Object obj, short s2) throws IllegalArgumentException, IllegalAccessException;

    private Field() {
    }

    @Override // java.lang.reflect.Member
    public Class<?> getDeclaringClass() {
        return this.declaringClass;
    }

    @Override // java.lang.reflect.Member
    public String getName() {
        if (this.declaringClass.isProxy()) {
            if ((getModifiers() & 8) == 0) {
                throw new AssertionError((Object) ("Invalid modifiers for proxy field: " + getModifiers()));
            }
            switch (this.artFieldIndex) {
                case 0:
                    return "interfaces";
                case 1:
                    return "throws";
                default:
                    throw new AssertionError((Object) ("Invalid index for proxy: " + this.artFieldIndex));
            }
        }
        return getNameInternal();
    }

    @Override // java.lang.reflect.Member
    public int getModifiers() {
        return this.accessFlags & 65535;
    }

    public boolean isEnumConstant() {
        return (getModifiers() & 16384) != 0;
    }

    @Override // java.lang.reflect.Member
    public boolean isSynthetic() {
        return Modifier.isSynthetic(getModifiers());
    }

    public Class<?> getType() {
        return this.type;
    }

    public Type getGenericType() {
        String signatureAttribute = getSignatureAttribute();
        ClassLoader cl = this.declaringClass.getClassLoader();
        GenericSignatureParser parser = new GenericSignatureParser(cl);
        parser.parseForField(this.declaringClass, signatureAttribute);
        Type genericType = parser.fieldType;
        if (genericType == null) {
            return getType();
        }
        return genericType;
    }

    String getSignatureAttribute() {
        String[] annotation = getSignatureAnnotation();
        if (annotation == null) {
            return null;
        }
        StringBuilder result = new StringBuilder();
        for (String s2 : annotation) {
            result.append(s2);
        }
        return result.toString();
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Field)) {
            return false;
        }
        Field other = (Field) obj;
        return getDeclaringClass() == other.getDeclaringClass() && getName() == other.getName() && getType() == other.getType();
    }

    public int hashCode() {
        return getDeclaringClass().getName().hashCode() ^ getName().hashCode();
    }

    public String toString() {
        int mod = getModifiers();
        return (mod == 0 ? "" : Modifier.toString(mod) + " ") + getType().getTypeName() + " " + getDeclaringClass().getTypeName() + "." + getName();
    }

    public String toGenericString() {
        int mod = getModifiers();
        Type fieldType = getGenericType();
        return (mod == 0 ? "" : Modifier.toString(mod) + " ") + fieldType.getTypeName() + " " + getDeclaringClass().getTypeName() + "." + getName();
    }

    @Override // java.lang.reflect.AccessibleObject, java.lang.reflect.AnnotatedElement
    public <T extends Annotation> T getAnnotation(Class<T> cls) {
        Objects.requireNonNull(cls);
        return (T) getAnnotationNative(cls);
    }

    @Override // java.lang.reflect.AccessibleObject, java.lang.reflect.AnnotatedElement
    public <T extends Annotation> T[] getAnnotationsByType(Class<T> cls) {
        return (T[]) AnnotatedElements.getDirectOrIndirectAnnotationsByType(this, cls);
    }

    @Override // java.lang.reflect.AccessibleObject, java.lang.reflect.AnnotatedElement
    public boolean isAnnotationPresent(Class<? extends Annotation> annotationType) {
        if (annotationType == null) {
            throw new NullPointerException("annotationType == null");
        }
        return isAnnotationPresentNative(annotationType);
    }

    public int getOffset() {
        return this.offset;
    }
}

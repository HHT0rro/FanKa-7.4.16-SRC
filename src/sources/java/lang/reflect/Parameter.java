package java.lang.reflect;

import dalvik.annotation.optimization.FastNative;
import java.lang.annotation.Annotation;
import java.util.Objects;
import libcore.reflect.AnnotatedElements;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class Parameter implements AnnotatedElement {
    private final Executable executable;
    private final int index;
    private final int modifiers;
    private final String name;
    private volatile transient Class<?> parameterClassCache = null;
    private volatile transient Type parameterTypeCache;

    @FastNative
    private static native <A extends Annotation> A getAnnotationNative(Executable executable, int i10, Class<A> cls);

    /* JADX INFO: Access modifiers changed from: package-private */
    public Parameter(String name, int modifiers, Executable executable, int index) {
        this.name = name;
        this.modifiers = modifiers;
        this.executable = executable;
        this.index = index;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Parameter)) {
            return false;
        }
        Parameter other = (Parameter) obj;
        return other.executable.equals(this.executable) && other.index == this.index;
    }

    public int hashCode() {
        return this.executable.hashCode() ^ this.index;
    }

    public boolean isNamePresent() {
        return this.executable.hasRealParameterData() && this.name != null;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        Type type = getParameterizedType();
        String typename = type.getTypeName();
        sb2.append(Modifier.toString(getModifiers()));
        if (this.modifiers != 0) {
            sb2.append(' ');
        }
        if (isVarArgs()) {
            sb2.append(typename.replaceFirst("\\[\\]$", "..."));
        } else {
            sb2.append(typename);
        }
        sb2.append(' ');
        sb2.append(getName());
        return sb2.toString();
    }

    public Executable getDeclaringExecutable() {
        return this.executable;
    }

    public int getModifiers() {
        return this.modifiers;
    }

    public String getName() {
        String str = this.name;
        if (str == null || str.equals("")) {
            return "arg" + this.index;
        }
        return this.name;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getRealName() {
        return this.name;
    }

    public Type getParameterizedType() {
        Type tmp = this.parameterTypeCache;
        if (tmp == null) {
            Type tmp2 = this.executable.getAllGenericParameterTypes()[this.index];
            this.parameterTypeCache = tmp2;
            return tmp2;
        }
        return tmp;
    }

    public Class<?> getType() {
        Class<?> tmp = this.parameterClassCache;
        if (tmp == null) {
            Class<?> tmp2 = this.executable.getParameterTypes()[this.index];
            this.parameterClassCache = tmp2;
            return tmp2;
        }
        return tmp;
    }

    public boolean isImplicit() {
        return Modifier.isMandated(getModifiers());
    }

    public boolean isSynthetic() {
        return Modifier.isSynthetic(getModifiers());
    }

    public boolean isVarArgs() {
        return this.executable.isVarArgs() && this.index == this.executable.getParameterCount() - 1;
    }

    @Override // java.lang.reflect.AnnotatedElement
    public <T extends Annotation> T getAnnotation(Class<T> cls) {
        Objects.requireNonNull(cls);
        return (T) getAnnotationNative(this.executable, this.index, cls);
    }

    @Override // java.lang.reflect.AnnotatedElement
    public <T extends Annotation> T[] getAnnotationsByType(Class<T> cls) {
        return (T[]) AnnotatedElements.getDirectOrIndirectAnnotationsByType(this, cls);
    }

    @Override // java.lang.reflect.AnnotatedElement
    public Annotation[] getDeclaredAnnotations() {
        return this.executable.getParameterAnnotations()[this.index];
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
    public Annotation[] getAnnotations() {
        return getDeclaredAnnotations();
    }
}

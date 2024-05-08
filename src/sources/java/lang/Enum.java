package java.lang;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.Enum;
import java.lang.constant.ClassDesc;
import java.lang.constant.ConstantDesc;
import java.lang.constant.ConstantDescs;
import java.lang.constant.DynamicConstantDesc;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;
import libcore.util.BasicLruCache;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class Enum<E extends Enum<E>> implements Comparable<E>, Serializable {
    private static final BasicLruCache<Class<? extends Enum>, Object[]> sharedConstantsCache = new BasicLruCache<Class<? extends Enum>, Object[]>(64) { // from class: java.lang.Enum.1
        /* JADX INFO: Access modifiers changed from: protected */
        public Object[] create(Class<? extends Enum> enumType) {
            return Enum.enumValues(enumType);
        }
    };
    private final String name;
    private final int ordinal;

    public final String name() {
        return this.name;
    }

    public final int ordinal() {
        return this.ordinal;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Enum(String name, int ordinal) {
        this.name = name;
        this.ordinal = ordinal;
    }

    public String toString() {
        return this.name;
    }

    public final boolean equals(Object other) {
        return this == other;
    }

    public final int hashCode() {
        return super.hashCode();
    }

    protected final Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    @Override // java.lang.Comparable
    public final int compareTo(E o10) {
        if (getClass() == o10.getClass() || getDeclaringClass() == o10.getDeclaringClass()) {
            return this.ordinal - o10.ordinal;
        }
        throw new ClassCastException();
    }

    public final Class<E> getDeclaringClass() {
        Class<E> cls = (Class<E>) getClass();
        Class superclass = cls.getSuperclass();
        return superclass == Enum.class ? cls : superclass;
    }

    public static <T extends Enum<T>> T valueOf(Class<T> cls, String str) {
        Objects.requireNonNull(cls, "enumClass == null");
        Objects.requireNonNull(str, "name == null");
        Enum[] sharedConstants = getSharedConstants(cls);
        if (sharedConstants == null) {
            throw new IllegalArgumentException(cls.toString() + " is not an enum type.");
        }
        for (int length = sharedConstants.length - 1; length >= 0; length--) {
            T t2 = (T) sharedConstants[length];
            if (str.equals(t2.name())) {
                return t2;
            }
        }
        throw new IllegalArgumentException("No enum constant " + cls.getCanonicalName() + "." + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object[] enumValues(Class<? extends Enum> clazz) {
        if (!clazz.isEnum()) {
            return null;
        }
        try {
            Method valueMethod = clazz.getDeclaredMethod("values", new Class[0]);
            return (Object[]) valueMethod.invoke(null, new Object[0]);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }

    public static <T extends Enum<T>> T[] getSharedConstants(Class<T> cls) {
        return (T[]) ((Enum[]) sharedConstantsCache.get(cls));
    }

    protected final void finalize() {
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        throw new InvalidObjectException("can't deserialize enum");
    }

    private void readObjectNoData() throws ObjectStreamException {
        throw new InvalidObjectException("can't deserialize enum");
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class EnumDesc<E extends Enum<E>> extends DynamicConstantDesc<E> {
        private EnumDesc(ClassDesc constantClass, String constantName) {
            super(ConstantDescs.BSM_ENUM_CONSTANT, (String) Objects.requireNonNull(constantName), (ClassDesc) Objects.requireNonNull(constantClass), new ConstantDesc[0]);
        }

        public static <E extends Enum<E>> EnumDesc<E> of(ClassDesc enumClass, String constantName) {
            return new EnumDesc<>(enumClass, constantName);
        }

        @Override // java.lang.constant.DynamicConstantDesc, java.lang.constant.ConstantDesc
        public E resolveConstantDesc(MethodHandles.Lookup lookup) throws ReflectiveOperationException {
            return (E) Enum.valueOf((Class) constantType().resolveConstantDesc(lookup), constantName());
        }

        @Override // java.lang.constant.DynamicConstantDesc
        public String toString() {
            return String.format("EnumDesc[%s.%s]", constantType().displayName(), constantName());
        }
    }
}

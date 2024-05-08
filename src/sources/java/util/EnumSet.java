package java.util;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.lang.Enum;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class EnumSet<E extends Enum<E>> extends AbstractSet<E> implements Cloneable, Serializable {
    private static final long serialVersionUID = 1009687484059888093L;
    final transient Class<E> elementType;
    final transient Enum<?>[] universe;

    abstract void addAll();

    abstract void addRange(E e2, E e10);

    abstract void complement();

    /* JADX INFO: Access modifiers changed from: package-private */
    public EnumSet(Class<E> elementType, Enum<?>[] universe) {
        this.elementType = elementType;
        this.universe = universe;
    }

    public static <E extends Enum<E>> EnumSet<E> noneOf(Class<E> elementType) {
        Enum<?>[] universe = getUniverse(elementType);
        if (universe == null) {
            throw new ClassCastException(((Object) elementType) + " not an enum");
        }
        if (universe.length <= 64) {
            return new RegularEnumSet(elementType, universe);
        }
        return new JumboEnumSet(elementType, universe);
    }

    public static <E extends Enum<E>> EnumSet<E> allOf(Class<E> elementType) {
        EnumSet<E> result = noneOf(elementType);
        result.addAll();
        return result;
    }

    public static <E extends Enum<E>> EnumSet<E> copyOf(EnumSet<E> s2) {
        return s2.clone();
    }

    public static <E extends Enum<E>> EnumSet<E> copyOf(Collection<E> c4) {
        if (c4 instanceof EnumSet) {
            return ((EnumSet) c4).clone();
        }
        if (c4.isEmpty()) {
            throw new IllegalArgumentException("Collection is empty");
        }
        Iterator<E> i10 = c4.iterator2();
        E first = i10.next();
        EnumSet<E> result = of((Enum) first);
        while (i10.hasNext()) {
            result.add(i10.next());
        }
        return result;
    }

    public static <E extends Enum<E>> EnumSet<E> complementOf(EnumSet<E> s2) {
        EnumSet<E> result = copyOf((EnumSet) s2);
        result.complement();
        return result;
    }

    public static <E extends Enum<E>> EnumSet<E> of(E e2) {
        EnumSet<E> result = noneOf(e2.getDeclaringClass());
        result.add(e2);
        return result;
    }

    public static <E extends Enum<E>> EnumSet<E> of(E e12, E e2) {
        EnumSet<E> result = noneOf(e12.getDeclaringClass());
        result.add(e12);
        result.add(e2);
        return result;
    }

    public static <E extends Enum<E>> EnumSet<E> of(E e12, E e2, E e32) {
        EnumSet<E> result = noneOf(e12.getDeclaringClass());
        result.add(e12);
        result.add(e2);
        result.add(e32);
        return result;
    }

    public static <E extends Enum<E>> EnumSet<E> of(E e12, E e2, E e32, E e42) {
        EnumSet<E> result = noneOf(e12.getDeclaringClass());
        result.add(e12);
        result.add(e2);
        result.add(e32);
        result.add(e42);
        return result;
    }

    public static <E extends Enum<E>> EnumSet<E> of(E e12, E e2, E e32, E e42, E e52) {
        EnumSet<E> result = noneOf(e12.getDeclaringClass());
        result.add(e12);
        result.add(e2);
        result.add(e32);
        result.add(e42);
        result.add(e52);
        return result;
    }

    @SafeVarargs
    public static <E extends Enum<E>> EnumSet<E> of(E first, E... rest) {
        EnumSet<E> result = noneOf(first.getDeclaringClass());
        result.add(first);
        for (E e2 : rest) {
            result.add(e2);
        }
        return result;
    }

    public static <E extends Enum<E>> EnumSet<E> range(E from, E to) {
        if (from.compareTo(to) > 0) {
            throw new IllegalArgumentException(((Object) from) + " > " + ((Object) to));
        }
        EnumSet<E> result = noneOf(from.getDeclaringClass());
        result.addRange(from, to);
        return result;
    }

    @Override // 
    public EnumSet<E> clone() {
        try {
            return (EnumSet) super.clone();
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void typeCheck(E e2) {
        Class<?> eClass = e2.getClass();
        if (eClass != this.elementType && eClass.getSuperclass() != this.elementType) {
            throw new ClassCastException(((Object) eClass) + " != " + ((Object) this.elementType));
        }
    }

    private static <E extends Enum<E>> E[] getUniverse(Class<E> elementType) {
        return elementType.getEnumConstantsShared();
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    private static class SerializationProxy<E extends Enum<E>> implements Serializable {
        private static final Enum<?>[] ZERO_LENGTH_ENUM_ARRAY = new Enum[0];
        private static final long serialVersionUID = 362491234563181265L;
        private final Class<E> elementType;
        private final Enum<?>[] elements;

        SerializationProxy(EnumSet<E> set) {
            this.elementType = set.elementType;
            this.elements = (Enum[]) set.toArray(ZERO_LENGTH_ENUM_ARRAY);
        }

        private Object readResolve() {
            EnumSet<E> result = EnumSet.noneOf(this.elementType);
            for (Enum<?> e2 : this.elements) {
                result.add(e2);
            }
            return result;
        }
    }

    Object writeReplace() {
        return new SerializationProxy(this);
    }

    private void readObject(ObjectInputStream s2) throws InvalidObjectException {
        throw new InvalidObjectException("Proxy required");
    }

    private void readObjectNoData() throws InvalidObjectException {
        throw new InvalidObjectException("Proxy required");
    }
}

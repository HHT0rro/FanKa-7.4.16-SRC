package java.util;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public interface Enumeration<E> {
    boolean hasMoreElements();

    E nextElement();

    default Iterator<E> asIterator() {
        return new Iterator<E>() { // from class: java.util.Enumeration.1
            @Override // java.util.Iterator
            public boolean hasNext() {
                return Enumeration.this.hasMoreElements();
            }

            @Override // java.util.Iterator
            public E next() {
                return (E) Enumeration.this.nextElement();
            }
        };
    }
}

package java.util;

import java.lang.reflect.Array;
import jdk.internal.util.ArraysSupport;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class AbstractCollection<E> implements Collection<E> {
    @Override // java.util.Collection, java.lang.Iterable
    public abstract Iterator<E> iterator();

    @Override // java.util.Collection, java.util.Set
    public abstract int size();

    @Override // java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return size() == 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0025, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0018, code lost:
    
        if (r0.hasNext() == false) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0022, code lost:
    
        if (r4.equals(r0.next()) == false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0024, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:?, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:2:0x0005, code lost:
    
        if (r4 == null) goto L4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x000b, code lost:
    
        if (r0.hasNext() == false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0011, code lost:
    
        if (r0.next() != null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0013, code lost:
    
        return true;
     */
    @Override // java.util.Collection, java.util.Set
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean contains(java.lang.Object r4) {
        /*
            r3 = this;
            java.util.Iterator r0 = r3.iterator()
            r1 = 1
            if (r4 != 0) goto L14
        L7:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L25
            java.lang.Object r2 = r0.next()
            if (r2 != 0) goto L7
            return r1
        L14:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L25
            java.lang.Object r2 = r0.next()
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L14
            return r1
        L25:
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.AbstractCollection.contains(java.lang.Object):boolean");
    }

    @Override // java.util.Collection, java.util.Set
    public Object[] toArray() {
        Object[] r10 = new Object[size()];
        Iterator<E> it = iterator();
        for (int i10 = 0; i10 < r10.length; i10++) {
            if (!it.hasNext()) {
                return Arrays.copyOf(r10, i10);
            }
            r10[i10] = it.next();
        }
        return it.hasNext() ? finishToArray(r10, it) : r10;
    }

    @Override // java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        int size = size();
        Object[] objArr = tArr.length >= size ? tArr : (Object[]) Array.newInstance(tArr.getClass().getComponentType(), size);
        Iterator<E> it = iterator();
        for (int i10 = 0; i10 < objArr.length; i10++) {
            if (!it.hasNext()) {
                if (tArr == objArr) {
                    objArr[i10] = null;
                } else {
                    if (tArr.length < i10) {
                        return (T[]) Arrays.copyOf(objArr, i10);
                    }
                    System.arraycopy(objArr, 0, tArr, 0, i10);
                    if (tArr.length > i10) {
                        tArr[i10] = null;
                    }
                }
                return tArr;
            }
            objArr[i10] = it.next();
        }
        return it.hasNext() ? (T[]) finishToArray(objArr, it) : (T[]) objArr;
    }

    private static <T> T[] finishToArray(T[] tArr, Iterator<?> it) {
        int length = tArr.length;
        int i10 = length;
        while (it.hasNext()) {
            if (i10 == length) {
                length = ArraysSupport.newLength(length, 1, (length >> 1) + 1);
                tArr = (T[]) Arrays.copyOf(tArr, length);
            }
            tArr[i10] = it.next();
            i10++;
        }
        return i10 == length ? tArr : (T[]) Arrays.copyOf(tArr, i10);
    }

    @Override // java.util.Collection, java.util.Set
    public boolean add(E e2) {
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x002b, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x001b, code lost:
    
        if (r0.hasNext() == false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0025, code lost:
    
        if (r4.equals(r0.next()) == false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0027, code lost:
    
        r0.remove();
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x002a, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:?, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:2:0x0005, code lost:
    
        if (r4 == null) goto L4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x000b, code lost:
    
        if (r0.hasNext() == false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0011, code lost:
    
        if (r0.next() != null) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0013, code lost:
    
        r0.remove();
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0016, code lost:
    
        return true;
     */
    @Override // java.util.Collection, java.util.Set
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean remove(java.lang.Object r4) {
        /*
            r3 = this;
            java.util.Iterator r0 = r3.iterator()
            r1 = 1
            if (r4 != 0) goto L17
        L7:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L2b
            java.lang.Object r2 = r0.next()
            if (r2 != 0) goto L7
            r0.remove()
            return r1
        L17:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L2b
            java.lang.Object r2 = r0.next()
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L17
            r0.remove()
            return r1
        L2b:
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.AbstractCollection.remove(java.lang.Object):boolean");
    }

    @Override // java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> c4) {
        for (Object e2 : c4) {
            if (!contains(e2)) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends E> c4) {
        boolean modified = false;
        for (E e2 : c4) {
            if (add(e2)) {
                modified = true;
            }
        }
        return modified;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean removeAll(Collection<?> c4) {
        Objects.requireNonNull(c4);
        boolean modified = false;
        Iterator<E> it = iterator();
        while (it.hasNext()) {
            if (c4.contains(it.next())) {
                it.remove();
                modified = true;
            }
        }
        return modified;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean retainAll(Collection<?> c4) {
        Objects.requireNonNull(c4);
        boolean modified = false;
        Iterator<E> it = iterator();
        while (it.hasNext()) {
            if (!c4.contains(it.next())) {
                it.remove();
                modified = true;
            }
        }
        return modified;
    }

    @Override // java.util.Collection, java.util.Set
    public void clear() {
        Iterator<E> it = iterator();
        while (it.hasNext()) {
            it.next();
            it.remove();
        }
    }

    public String toString() {
        Iterator<E> it = iterator();
        if (!it.hasNext()) {
            return "[]";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append('[');
        while (true) {
            E e2 = it.next();
            sb2.append(e2 == this ? "(this Collection)" : e2);
            if (!it.hasNext()) {
                return sb2.append(']').toString();
            }
            sb2.append(',').append(' ');
        }
    }
}

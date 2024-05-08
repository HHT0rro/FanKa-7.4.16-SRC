package org.greenrobot.greendao.identityscope;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public interface IdentityScope<K, T> {
    void clear();

    boolean detach(K k10, T t2);

    T get(K k10);

    T getNoLock(K k10);

    void lock();

    void put(K k10, T t2);

    void putNoLock(K k10, T t2);

    void remove(Iterable<K> iterable);

    void remove(K k10);

    void reserveRoom(int i10);

    void unlock();
}

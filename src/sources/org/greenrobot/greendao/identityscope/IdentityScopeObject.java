package org.greenrobot.greendao.identityscope;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class IdentityScopeObject<K, T> implements IdentityScope<K, T> {
    private final HashMap<K, Reference<T>> map = new HashMap<>();
    private final ReentrantLock lock = new ReentrantLock();

    @Override // org.greenrobot.greendao.identityscope.IdentityScope
    public void clear() {
        this.lock.lock();
        try {
            this.map.clear();
        } finally {
            this.lock.unlock();
        }
    }

    @Override // org.greenrobot.greendao.identityscope.IdentityScope
    public boolean detach(K k10, T t2) {
        boolean z10;
        this.lock.lock();
        try {
            if (get(k10) != t2 || t2 == null) {
                z10 = false;
            } else {
                remove((IdentityScopeObject<K, T>) k10);
                z10 = true;
            }
            return z10;
        } finally {
            this.lock.unlock();
        }
    }

    @Override // org.greenrobot.greendao.identityscope.IdentityScope
    public T get(K k10) {
        this.lock.lock();
        try {
            Reference<T> reference = this.map.get(k10);
            if (reference != null) {
                return reference.get();
            }
            return null;
        } finally {
            this.lock.unlock();
        }
    }

    @Override // org.greenrobot.greendao.identityscope.IdentityScope
    public T getNoLock(K k10) {
        Reference<T> reference = this.map.get(k10);
        if (reference != null) {
            return reference.get();
        }
        return null;
    }

    @Override // org.greenrobot.greendao.identityscope.IdentityScope
    public void lock() {
        this.lock.lock();
    }

    @Override // org.greenrobot.greendao.identityscope.IdentityScope
    public void put(K k10, T t2) {
        this.lock.lock();
        try {
            this.map.put(k10, new WeakReference(t2));
        } finally {
            this.lock.unlock();
        }
    }

    @Override // org.greenrobot.greendao.identityscope.IdentityScope
    public void putNoLock(K k10, T t2) {
        this.map.put(k10, new WeakReference(t2));
    }

    @Override // org.greenrobot.greendao.identityscope.IdentityScope
    public void remove(K k10) {
        this.lock.lock();
        try {
            this.map.remove(k10);
        } finally {
            this.lock.unlock();
        }
    }

    @Override // org.greenrobot.greendao.identityscope.IdentityScope
    public void reserveRoom(int i10) {
    }

    @Override // org.greenrobot.greendao.identityscope.IdentityScope
    public void unlock() {
        this.lock.unlock();
    }

    @Override // org.greenrobot.greendao.identityscope.IdentityScope
    public void remove(Iterable<K> iterable) {
        this.lock.lock();
        try {
            Iterator<K> iterator2 = iterable.iterator2();
            while (iterator2.hasNext()) {
                this.map.remove(iterator2.next());
            }
        } finally {
            this.lock.unlock();
        }
    }
}

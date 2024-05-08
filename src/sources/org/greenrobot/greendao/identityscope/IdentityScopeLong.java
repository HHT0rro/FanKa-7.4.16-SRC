package org.greenrobot.greendao.identityscope;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.locks.ReentrantLock;
import org.greenrobot.greendao.internal.LongHashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class IdentityScopeLong<T> implements IdentityScope<Long, T> {
    private final LongHashMap<Reference<T>> map = new LongHashMap<>();
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

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.greenrobot.greendao.identityscope.IdentityScope
    public /* bridge */ /* synthetic */ boolean detach(Long l10, Object obj) {
        return detach2(l10, (Long) obj);
    }

    public T get2(long j10) {
        this.lock.lock();
        try {
            Reference<T> reference = this.map.get(j10);
            if (reference != null) {
                return reference.get();
            }
            return null;
        } finally {
            this.lock.unlock();
        }
    }

    public T get2NoLock(long j10) {
        Reference<T> reference = this.map.get(j10);
        if (reference != null) {
            return reference.get();
        }
        return null;
    }

    @Override // org.greenrobot.greendao.identityscope.IdentityScope
    public void lock() {
        this.lock.lock();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.greenrobot.greendao.identityscope.IdentityScope
    public /* bridge */ /* synthetic */ void put(Long l10, Object obj) {
        put3(l10, (Long) obj);
    }

    public void put2(long j10, T t2) {
        this.lock.lock();
        try {
            this.map.put(j10, new WeakReference(t2));
        } finally {
            this.lock.unlock();
        }
    }

    public void put2NoLock(long j10, T t2) {
        this.map.put(j10, new WeakReference(t2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.greenrobot.greendao.identityscope.IdentityScope
    public /* bridge */ /* synthetic */ void putNoLock(Long l10, Object obj) {
        putNoLock2(l10, (Long) obj);
    }

    @Override // org.greenrobot.greendao.identityscope.IdentityScope
    public void reserveRoom(int i10) {
        this.map.reserveRoom(i10);
    }

    @Override // org.greenrobot.greendao.identityscope.IdentityScope
    public void unlock() {
        this.lock.unlock();
    }

    /* renamed from: detach, reason: avoid collision after fix types in other method */
    public boolean detach2(Long l10, T t2) {
        boolean z10;
        this.lock.lock();
        try {
            if (get(l10) != t2 || t2 == null) {
                z10 = false;
            } else {
                remove(l10);
                z10 = true;
            }
            return z10;
        } finally {
            this.lock.unlock();
        }
    }

    @Override // org.greenrobot.greendao.identityscope.IdentityScope
    public T get(Long l10) {
        return get2(l10.longValue());
    }

    @Override // org.greenrobot.greendao.identityscope.IdentityScope
    public T getNoLock(Long l10) {
        return get2NoLock(l10.longValue());
    }

    /* renamed from: put, reason: avoid collision after fix types in other method */
    public void put3(Long l10, T t2) {
        put2(l10.longValue(), t2);
    }

    /* renamed from: putNoLock, reason: avoid collision after fix types in other method */
    public void putNoLock2(Long l10, T t2) {
        put2NoLock(l10.longValue(), t2);
    }

    @Override // org.greenrobot.greendao.identityscope.IdentityScope
    public void remove(Long l10) {
        this.lock.lock();
        try {
            this.map.remove(l10.longValue());
        } finally {
            this.lock.unlock();
        }
    }

    @Override // org.greenrobot.greendao.identityscope.IdentityScope
    public void remove(Iterable<Long> iterable) {
        this.lock.lock();
        try {
            Iterator<Long> iterator2 = iterable.iterator2();
            while (iterator2.hasNext()) {
                this.map.remove(iterator2.next().longValue());
            }
        } finally {
            this.lock.unlock();
        }
    }
}

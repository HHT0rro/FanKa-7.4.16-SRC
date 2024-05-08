package org.greenrobot.greendao.query;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.query.AbstractQuery;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class AbstractQueryData<T, Q extends AbstractQuery<T>> {
    public final AbstractDao<T, ?> dao;
    public final String[] initialValues;
    public final Map<Long, WeakReference<Q>> queriesForThreads = new HashMap();
    public final String sql;

    public AbstractQueryData(AbstractDao<T, ?> abstractDao, String str, String[] strArr) {
        this.dao = abstractDao;
        this.sql = str;
        this.initialValues = strArr;
    }

    public abstract Q createQuery();

    public Q forCurrentThread(Q q10) {
        if (Thread.currentThread() == q10.ownerThread) {
            String[] strArr = this.initialValues;
            System.arraycopy(strArr, 0, q10.parameters, 0, strArr.length);
            return q10;
        }
        return forCurrentThread();
    }

    public void gc() {
        synchronized (this.queriesForThreads) {
            Iterator<Map.Entry<Long, WeakReference<Q>>> iterator2 = this.queriesForThreads.entrySet().iterator2();
            while (iterator2.hasNext()) {
                if (iterator2.next().getValue().get() == null) {
                    iterator2.remove();
                }
            }
        }
    }

    public Q forCurrentThread() {
        Q q10;
        long id2 = Thread.currentThread().getId();
        synchronized (this.queriesForThreads) {
            WeakReference<Q> weakReference = this.queriesForThreads.get(Long.valueOf(id2));
            q10 = weakReference != null ? weakReference.get() : null;
            if (q10 == null) {
                gc();
                q10 = createQuery();
                this.queriesForThreads.put(Long.valueOf(id2), new WeakReference<>(q10));
            } else {
                String[] strArr = this.initialValues;
                System.arraycopy(strArr, 0, q10.parameters, 0, strArr.length);
            }
        }
        return q10;
    }
}

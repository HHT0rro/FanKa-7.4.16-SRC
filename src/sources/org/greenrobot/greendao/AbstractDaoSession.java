package org.greenrobot.greendao;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import org.greenrobot.greendao.annotation.apihint.Experimental;
import org.greenrobot.greendao.async.AsyncSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.query.QueryBuilder;
import org.greenrobot.greendao.rx.RxTransaction;
import rx.schedulers.Schedulers;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class AbstractDaoSession {

    /* renamed from: db, reason: collision with root package name */
    private final Database f52440db;
    private final Map<Class<?>, AbstractDao<?, ?>> entityToDao = new HashMap();
    private volatile RxTransaction rxTxIo;
    private volatile RxTransaction rxTxPlain;

    public AbstractDaoSession(Database database) {
        this.f52440db = database;
    }

    public <V> V callInTx(Callable<V> callable) throws Exception {
        this.f52440db.beginTransaction();
        try {
            V call = callable.call();
            this.f52440db.setTransactionSuccessful();
            return call;
        } finally {
            this.f52440db.endTransaction();
        }
    }

    public <V> V callInTxNoException(Callable<V> callable) {
        this.f52440db.beginTransaction();
        try {
            try {
                V call = callable.call();
                this.f52440db.setTransactionSuccessful();
                return call;
            } catch (Exception e2) {
                throw new DaoException("Callable failed", e2);
            }
        } finally {
            this.f52440db.endTransaction();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> void delete(T t2) {
        getDao(t2.getClass()).delete(t2);
    }

    public <T> void deleteAll(Class<T> cls) {
        getDao(cls).deleteAll();
    }

    public Collection<AbstractDao<?, ?>> getAllDaos() {
        return Collections.unmodifiableCollection(this.entityToDao.values());
    }

    public AbstractDao<?, ?> getDao(Class<? extends Object> cls) {
        AbstractDao<?, ?> abstractDao = this.entityToDao.get(cls);
        if (abstractDao != null) {
            return abstractDao;
        }
        throw new DaoException("No DAO registered for " + ((Object) cls));
    }

    public Database getDatabase() {
        return this.f52440db;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> long insert(T t2) {
        return getDao(t2.getClass()).insert(t2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> long insertOrReplace(T t2) {
        return getDao(t2.getClass()).insertOrReplace(t2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T, K> T load(Class<T> cls, K k10) {
        return (T) getDao(cls).load(k10);
    }

    public <T, K> List<T> loadAll(Class<T> cls) {
        return (List<T>) getDao(cls).loadAll();
    }

    public <T> QueryBuilder<T> queryBuilder(Class<T> cls) {
        return (QueryBuilder<T>) getDao(cls).queryBuilder();
    }

    public <T, K> List<T> queryRaw(Class<T> cls, String str, String... strArr) {
        return (List<T>) getDao(cls).queryRaw(str, strArr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> void refresh(T t2) {
        getDao(t2.getClass()).refresh(t2);
    }

    public <T> void registerDao(Class<T> cls, AbstractDao<T, ?> abstractDao) {
        this.entityToDao.put(cls, abstractDao);
    }

    public void runInTx(Runnable runnable) {
        this.f52440db.beginTransaction();
        try {
            runnable.run();
            this.f52440db.setTransactionSuccessful();
        } finally {
            this.f52440db.endTransaction();
        }
    }

    @Experimental
    public RxTransaction rxTx() {
        if (this.rxTxIo == null) {
            this.rxTxIo = new RxTransaction(this, Schedulers.io());
        }
        return this.rxTxIo;
    }

    @Experimental
    public RxTransaction rxTxPlain() {
        if (this.rxTxPlain == null) {
            this.rxTxPlain = new RxTransaction(this);
        }
        return this.rxTxPlain;
    }

    public AsyncSession startAsyncSession() {
        return new AsyncSession(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> void update(T t2) {
        getDao(t2.getClass()).update(t2);
    }
}

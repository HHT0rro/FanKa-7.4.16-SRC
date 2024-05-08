package org.greenrobot.greendao;

import android.database.CrossProcessCursor;
import android.database.Cursor;
import android.database.CursorWindow;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import org.greenrobot.greendao.annotation.apihint.Experimental;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.identityscope.IdentityScope;
import org.greenrobot.greendao.identityscope.IdentityScopeLong;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.internal.TableStatements;
import org.greenrobot.greendao.query.Query;
import org.greenrobot.greendao.query.QueryBuilder;
import org.greenrobot.greendao.rx.RxDao;
import rx.schedulers.Schedulers;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class AbstractDao<T, K> {
    public final DaoConfig config;

    /* renamed from: db, reason: collision with root package name */
    public final Database f52438db;
    public final IdentityScope<K, T> identityScope;
    public final IdentityScopeLong<T> identityScopeLong;
    public final boolean isStandardSQLite;
    public final int pkOrdinal;
    private volatile RxDao<T, K> rxDao;
    private volatile RxDao<T, K> rxDaoPlain;
    public final AbstractDaoSession session;
    public final TableStatements statements;

    public AbstractDao(DaoConfig daoConfig) {
        this(daoConfig, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void deleteByKeyInsideSynchronized(K k10, DatabaseStatement databaseStatement) {
        if (k10 instanceof Long) {
            databaseStatement.bindLong(1, ((Long) k10).longValue());
        } else if (k10 != 0) {
            databaseStatement.bindString(1, k10.toString());
        } else {
            throw new DaoException("Cannot delete entity, key is null");
        }
        databaseStatement.execute();
    }

    private void deleteInTxInternal(Iterable<T> iterable, Iterable<K> iterable2) {
        ArrayList arrayList;
        IdentityScope<K, T> identityScope;
        assertSinglePk();
        DatabaseStatement deleteStatement = this.statements.getDeleteStatement();
        this.f52438db.beginTransaction();
        try {
            synchronized (deleteStatement) {
                IdentityScope<K, T> identityScope2 = this.identityScope;
                if (identityScope2 != null) {
                    identityScope2.lock();
                    arrayList = new ArrayList();
                } else {
                    arrayList = null;
                }
                if (iterable != null) {
                    try {
                        Iterator<T> iterator2 = iterable.iterator2();
                        while (iterator2.hasNext()) {
                            K keyVerified = getKeyVerified(iterator2.next());
                            deleteByKeyInsideSynchronized(keyVerified, deleteStatement);
                            if (arrayList != null) {
                                arrayList.add(keyVerified);
                            }
                        }
                    } catch (Throwable th) {
                        IdentityScope<K, T> identityScope3 = this.identityScope;
                        if (identityScope3 != null) {
                            identityScope3.unlock();
                        }
                        throw th;
                    }
                }
                if (iterable2 != null) {
                    for (K k10 : iterable2) {
                        deleteByKeyInsideSynchronized(k10, deleteStatement);
                        if (arrayList != null) {
                            arrayList.add(k10);
                        }
                    }
                }
                IdentityScope<K, T> identityScope4 = this.identityScope;
                if (identityScope4 != null) {
                    identityScope4.unlock();
                }
            }
            this.f52438db.setTransactionSuccessful();
            if (arrayList != null && (identityScope = this.identityScope) != null) {
                identityScope.remove((Iterable) arrayList);
            }
        } finally {
            this.f52438db.endTransaction();
        }
    }

    private long executeInsert(T t2, DatabaseStatement databaseStatement, boolean z10) {
        long insertInsideTx;
        if (this.f52438db.isDbLockedByCurrentThread()) {
            insertInsideTx = insertInsideTx(t2, databaseStatement);
        } else {
            this.f52438db.beginTransaction();
            try {
                insertInsideTx = insertInsideTx(t2, databaseStatement);
                this.f52438db.setTransactionSuccessful();
            } finally {
                this.f52438db.endTransaction();
            }
        }
        if (z10) {
            updateKeyAfterInsertAndAttach(t2, insertInsideTx, true);
        }
        return insertInsideTx;
    }

    private void executeInsertInTx(DatabaseStatement databaseStatement, Iterable<T> iterable, boolean z10) {
        this.f52438db.beginTransaction();
        try {
            synchronized (databaseStatement) {
                IdentityScope<K, T> identityScope = this.identityScope;
                if (identityScope != null) {
                    identityScope.lock();
                }
                try {
                    if (this.isStandardSQLite) {
                        SQLiteStatement sQLiteStatement = (SQLiteStatement) databaseStatement.getRawStatement();
                        for (T t2 : iterable) {
                            bindValues(sQLiteStatement, (SQLiteStatement) t2);
                            if (z10) {
                                updateKeyAfterInsertAndAttach(t2, sQLiteStatement.executeInsert(), false);
                            } else {
                                sQLiteStatement.execute();
                            }
                        }
                    } else {
                        for (T t10 : iterable) {
                            bindValues(databaseStatement, (DatabaseStatement) t10);
                            if (z10) {
                                updateKeyAfterInsertAndAttach(t10, databaseStatement.executeInsert(), false);
                            } else {
                                databaseStatement.execute();
                            }
                        }
                    }
                } finally {
                    IdentityScope<K, T> identityScope2 = this.identityScope;
                    if (identityScope2 != null) {
                        identityScope2.unlock();
                    }
                }
            }
            this.f52438db.setTransactionSuccessful();
        } finally {
            this.f52438db.endTransaction();
        }
    }

    private long insertInsideTx(T t2, DatabaseStatement databaseStatement) {
        synchronized (databaseStatement) {
            if (this.isStandardSQLite) {
                SQLiteStatement sQLiteStatement = (SQLiteStatement) databaseStatement.getRawStatement();
                bindValues(sQLiteStatement, (SQLiteStatement) t2);
                return sQLiteStatement.executeInsert();
            }
            bindValues(databaseStatement, (DatabaseStatement) t2);
            return databaseStatement.executeInsert();
        }
    }

    private void loadAllUnlockOnWindowBounds(Cursor cursor, CursorWindow cursorWindow, List<T> list) {
        int startPosition = cursorWindow.getStartPosition() + cursorWindow.getNumRows();
        int i10 = 0;
        while (true) {
            list.add(loadCurrent(cursor, 0, false));
            int i11 = i10 + 1;
            if (i11 >= startPosition) {
                CursorWindow moveToNextUnlocked = moveToNextUnlocked(cursor);
                if (moveToNextUnlocked == null) {
                    return;
                } else {
                    startPosition = moveToNextUnlocked.getStartPosition() + moveToNextUnlocked.getNumRows();
                }
            } else if (!cursor.moveToNext()) {
                return;
            }
            i10 = i11 + 1;
        }
    }

    private CursorWindow moveToNextUnlocked(Cursor cursor) {
        this.identityScope.unlock();
        try {
            return cursor.moveToNext() ? ((CrossProcessCursor) cursor).getWindow() : null;
        } finally {
            this.identityScope.lock();
        }
    }

    public void assertSinglePk() {
        if (this.config.pkColumns.length == 1) {
            return;
        }
        throw new DaoException(((Object) this) + " (" + this.config.tablename + ") does not have a single-column primary key");
    }

    public void attachEntity(T t2) {
    }

    public final void attachEntity(K k10, T t2, boolean z10) {
        attachEntity(t2);
        IdentityScope<K, T> identityScope = this.identityScope;
        if (identityScope == null || k10 == null) {
            return;
        }
        if (z10) {
            identityScope.put(k10, t2);
        } else {
            identityScope.putNoLock(k10, t2);
        }
    }

    public abstract void bindValues(SQLiteStatement sQLiteStatement, T t2);

    public abstract void bindValues(DatabaseStatement databaseStatement, T t2);

    public long count() {
        return this.statements.getCountStatement().simpleQueryForLong();
    }

    public void delete(T t2) {
        assertSinglePk();
        deleteByKey(getKeyVerified(t2));
    }

    public void deleteAll() {
        this.f52438db.execSQL("DELETE FROM '" + this.config.tablename + "'");
        IdentityScope<K, T> identityScope = this.identityScope;
        if (identityScope != null) {
            identityScope.clear();
        }
    }

    public void deleteByKey(K k10) {
        assertSinglePk();
        DatabaseStatement deleteStatement = this.statements.getDeleteStatement();
        if (this.f52438db.isDbLockedByCurrentThread()) {
            synchronized (deleteStatement) {
                deleteByKeyInsideSynchronized(k10, deleteStatement);
            }
        } else {
            this.f52438db.beginTransaction();
            try {
                synchronized (deleteStatement) {
                    deleteByKeyInsideSynchronized(k10, deleteStatement);
                }
                this.f52438db.setTransactionSuccessful();
            } finally {
                this.f52438db.endTransaction();
            }
        }
        IdentityScope<K, T> identityScope = this.identityScope;
        if (identityScope != null) {
            identityScope.remove((IdentityScope<K, T>) k10);
        }
    }

    public void deleteByKeyInTx(Iterable<K> iterable) {
        deleteInTxInternal(null, iterable);
    }

    public void deleteInTx(Iterable<T> iterable) {
        deleteInTxInternal(iterable, null);
    }

    public boolean detach(T t2) {
        if (this.identityScope == null) {
            return false;
        }
        return this.identityScope.detach(getKeyVerified(t2), t2);
    }

    public void detachAll() {
        IdentityScope<K, T> identityScope = this.identityScope;
        if (identityScope != null) {
            identityScope.clear();
        }
    }

    public String[] getAllColumns() {
        return this.config.allColumns;
    }

    public Database getDatabase() {
        return this.f52438db;
    }

    public abstract K getKey(T t2);

    public K getKeyVerified(T t2) {
        K key = getKey(t2);
        if (key != null) {
            return key;
        }
        Objects.requireNonNull(t2, "Entity may not be null");
        throw new DaoException("Entity has no key");
    }

    public String[] getNonPkColumns() {
        return this.config.nonPkColumns;
    }

    public String[] getPkColumns() {
        return this.config.pkColumns;
    }

    public Property getPkProperty() {
        return this.config.pkProperty;
    }

    public Property[] getProperties() {
        return this.config.properties;
    }

    public AbstractDaoSession getSession() {
        return this.session;
    }

    public TableStatements getStatements() {
        return this.config.statements;
    }

    public String getTablename() {
        return this.config.tablename;
    }

    public abstract boolean hasKey(T t2);

    public long insert(T t2) {
        return executeInsert(t2, this.statements.getInsertStatement(), true);
    }

    public void insertInTx(Iterable<T> iterable) {
        insertInTx(iterable, isEntityUpdateable());
    }

    public long insertOrReplace(T t2) {
        return executeInsert(t2, this.statements.getInsertOrReplaceStatement(), true);
    }

    public void insertOrReplaceInTx(Iterable<T> iterable, boolean z10) {
        executeInsertInTx(this.statements.getInsertOrReplaceStatement(), iterable, z10);
    }

    public long insertWithoutSettingPk(T t2) {
        return executeInsert(t2, this.statements.getInsertOrReplaceStatement(), false);
    }

    public abstract boolean isEntityUpdateable();

    public T load(K k10) {
        T t2;
        assertSinglePk();
        if (k10 == null) {
            return null;
        }
        IdentityScope<K, T> identityScope = this.identityScope;
        return (identityScope == null || (t2 = identityScope.get(k10)) == null) ? loadUniqueAndCloseCursor(this.f52438db.rawQuery(this.statements.getSelectByKey(), new String[]{k10.toString()})) : t2;
    }

    public List<T> loadAll() {
        return loadAllAndCloseCursor(this.f52438db.rawQuery(this.statements.getSelectAll(), null));
    }

    public List<T> loadAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.List<T> loadAllFromCursor(android.database.Cursor r7) {
        /*
            r6 = this;
            int r0 = r7.getCount()
            if (r0 != 0) goto Lc
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            return r7
        Lc:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>(r0)
            r2 = 0
            boolean r3 = r7 instanceof android.database.CrossProcessCursor
            r4 = 0
            if (r3 == 0) goto L4d
            r2 = r7
            android.database.CrossProcessCursor r2 = (android.database.CrossProcessCursor) r2
            android.database.CursorWindow r2 = r2.getWindow()
            if (r2 == 0) goto L4d
            int r3 = r2.getNumRows()
            if (r3 != r0) goto L2d
            org.greenrobot.greendao.internal.FastCursor r7 = new org.greenrobot.greendao.internal.FastCursor
            r7.<init>(r2)
            r3 = 1
            goto L4e
        L2d:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r5 = "Window vs. result size: "
            r3.append(r5)
            int r5 = r2.getNumRows()
            r3.append(r5)
            java.lang.String r5 = "/"
            r3.append(r5)
            r3.append(r0)
            java.lang.String r3 = r3.toString()
            org.greenrobot.greendao.DaoLog.d(r3)
        L4d:
            r3 = 0
        L4e:
            boolean r5 = r7.moveToFirst()
            if (r5 == 0) goto L8a
            org.greenrobot.greendao.identityscope.IdentityScope<K, T> r5 = r6.identityScope
            if (r5 == 0) goto L60
            r5.lock()
            org.greenrobot.greendao.identityscope.IdentityScope<K, T> r5 = r6.identityScope
            r5.reserveRoom(r0)
        L60:
            if (r3 != 0) goto L6c
            if (r2 == 0) goto L6c
            org.greenrobot.greendao.identityscope.IdentityScope<K, T> r0 = r6.identityScope     // Catch: java.lang.Throwable -> L81
            if (r0 == 0) goto L6c
            r6.loadAllUnlockOnWindowBounds(r7, r2, r1)     // Catch: java.lang.Throwable -> L81
            goto L79
        L6c:
            java.lang.Object r0 = r6.loadCurrent(r7, r4, r4)     // Catch: java.lang.Throwable -> L81
            r1.add(r0)     // Catch: java.lang.Throwable -> L81
            boolean r0 = r7.moveToNext()     // Catch: java.lang.Throwable -> L81
            if (r0 != 0) goto L6c
        L79:
            org.greenrobot.greendao.identityscope.IdentityScope<K, T> r7 = r6.identityScope
            if (r7 == 0) goto L8a
            r7.unlock()
            goto L8a
        L81:
            r7 = move-exception
            org.greenrobot.greendao.identityscope.IdentityScope<K, T> r0 = r6.identityScope
            if (r0 == 0) goto L89
            r0.unlock()
        L89:
            throw r7
        L8a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.greenrobot.greendao.AbstractDao.loadAllFromCursor(android.database.Cursor):java.util.List");
    }

    public T loadByRowId(long j10) {
        return loadUniqueAndCloseCursor(this.f52438db.rawQuery(this.statements.getSelectByRowId(), new String[]{Long.toString(j10)}));
    }

    public final T loadCurrent(Cursor cursor, int i10, boolean z10) {
        if (this.identityScopeLong != null) {
            if (i10 != 0 && cursor.isNull(this.pkOrdinal + i10)) {
                return null;
            }
            long j10 = cursor.getLong(this.pkOrdinal + i10);
            IdentityScopeLong<T> identityScopeLong = this.identityScopeLong;
            T t2 = z10 ? identityScopeLong.get2(j10) : identityScopeLong.get2NoLock(j10);
            if (t2 != null) {
                return t2;
            }
            T readEntity = readEntity(cursor, i10);
            attachEntity(readEntity);
            if (z10) {
                this.identityScopeLong.put2(j10, readEntity);
            } else {
                this.identityScopeLong.put2NoLock(j10, readEntity);
            }
            return readEntity;
        }
        if (this.identityScope != null) {
            K readKey = readKey(cursor, i10);
            if (i10 != 0 && readKey == null) {
                return null;
            }
            IdentityScope<K, T> identityScope = this.identityScope;
            T noLock = z10 ? identityScope.get(readKey) : identityScope.getNoLock(readKey);
            if (noLock != null) {
                return noLock;
            }
            T readEntity2 = readEntity(cursor, i10);
            attachEntity(readKey, readEntity2, z10);
            return readEntity2;
        }
        if (i10 != 0 && readKey(cursor, i10) == null) {
            return null;
        }
        T readEntity3 = readEntity(cursor, i10);
        attachEntity(readEntity3);
        return readEntity3;
    }

    public final <O> O loadCurrentOther(AbstractDao<O, ?> abstractDao, Cursor cursor, int i10) {
        return abstractDao.loadCurrent(cursor, i10, true);
    }

    public T loadUnique(Cursor cursor) {
        if (!cursor.moveToFirst()) {
            return null;
        }
        if (cursor.isLast()) {
            return loadCurrent(cursor, 0, true);
        }
        throw new DaoException("Expected unique result, but count was " + cursor.getCount());
    }

    public T loadUniqueAndCloseCursor(Cursor cursor) {
        try {
            return loadUnique(cursor);
        } finally {
            cursor.close();
        }
    }

    public QueryBuilder<T> queryBuilder() {
        return QueryBuilder.internalCreate(this);
    }

    public List<T> queryRaw(String str, String... strArr) {
        return loadAllAndCloseCursor(this.f52438db.rawQuery(this.statements.getSelectAll() + str, strArr));
    }

    public Query<T> queryRawCreate(String str, Object... objArr) {
        return queryRawCreateListArgs(str, Arrays.asList(objArr));
    }

    public Query<T> queryRawCreateListArgs(String str, Collection<Object> collection) {
        return Query.internalCreate(this, this.statements.getSelectAll() + str, collection.toArray());
    }

    public abstract T readEntity(Cursor cursor, int i10);

    public abstract void readEntity(Cursor cursor, T t2, int i10);

    public abstract K readKey(Cursor cursor, int i10);

    public void refresh(T t2) {
        assertSinglePk();
        K keyVerified = getKeyVerified(t2);
        Cursor rawQuery = this.f52438db.rawQuery(this.statements.getSelectByKey(), new String[]{keyVerified.toString()});
        try {
            if (rawQuery.moveToFirst()) {
                if (rawQuery.isLast()) {
                    readEntity(rawQuery, t2, 0);
                    attachEntity(keyVerified, t2, true);
                    return;
                } else {
                    throw new DaoException("Expected unique result, but count was " + rawQuery.getCount());
                }
            }
            throw new DaoException("Entity does not exist in the database anymore: " + ((Object) t2.getClass()) + " with key " + ((Object) keyVerified));
        } finally {
            rawQuery.close();
        }
    }

    @Experimental
    public RxDao<T, K> rx() {
        if (this.rxDao == null) {
            this.rxDao = new RxDao<>(this, Schedulers.io());
        }
        return this.rxDao;
    }

    @Experimental
    public RxDao<T, K> rxPlain() {
        if (this.rxDaoPlain == null) {
            this.rxDaoPlain = new RxDao<>(this);
        }
        return this.rxDaoPlain;
    }

    public void save(T t2) {
        if (hasKey(t2)) {
            update(t2);
        } else {
            insert(t2);
        }
    }

    public void saveInTx(T... tArr) {
        saveInTx(Arrays.asList(tArr));
    }

    public void update(T t2) {
        assertSinglePk();
        DatabaseStatement updateStatement = this.statements.getUpdateStatement();
        if (this.f52438db.isDbLockedByCurrentThread()) {
            synchronized (updateStatement) {
                if (this.isStandardSQLite) {
                    updateInsideSynchronized((AbstractDao<T, K>) t2, (SQLiteStatement) updateStatement.getRawStatement(), true);
                } else {
                    updateInsideSynchronized((AbstractDao<T, K>) t2, updateStatement, true);
                }
            }
            return;
        }
        this.f52438db.beginTransaction();
        try {
            synchronized (updateStatement) {
                updateInsideSynchronized((AbstractDao<T, K>) t2, updateStatement, true);
            }
            this.f52438db.setTransactionSuccessful();
        } finally {
            this.f52438db.endTransaction();
        }
    }

    public void updateInTx(Iterable<T> iterable) {
        DatabaseStatement updateStatement = this.statements.getUpdateStatement();
        this.f52438db.beginTransaction();
        try {
            synchronized (updateStatement) {
                IdentityScope<K, T> identityScope = this.identityScope;
                if (identityScope != null) {
                    identityScope.lock();
                }
                try {
                    if (this.isStandardSQLite) {
                        SQLiteStatement sQLiteStatement = (SQLiteStatement) updateStatement.getRawStatement();
                        Iterator<T> iterator2 = iterable.iterator2();
                        while (iterator2.hasNext()) {
                            updateInsideSynchronized((AbstractDao<T, K>) iterator2.next(), sQLiteStatement, false);
                        }
                    } else {
                        Iterator<T> iterator22 = iterable.iterator2();
                        while (iterator22.hasNext()) {
                            updateInsideSynchronized((AbstractDao<T, K>) iterator22.next(), updateStatement, false);
                        }
                    }
                } finally {
                    IdentityScope<K, T> identityScope2 = this.identityScope;
                    if (identityScope2 != null) {
                        identityScope2.unlock();
                    }
                }
            }
            this.f52438db.setTransactionSuccessful();
        } catch (RuntimeException e2) {
            e = e2;
            try {
                this.f52438db.endTransaction();
            } catch (RuntimeException e10) {
                DaoLog.w("Could not end transaction (rethrowing initial exception)", e10);
                throw e;
            }
        } catch (Throwable th) {
            try {
                this.f52438db.endTransaction();
                throw th;
            } catch (RuntimeException e11) {
                throw e11;
            }
        }
        try {
            this.f52438db.endTransaction();
            e = null;
            if (e != null) {
                throw e;
            }
        } catch (RuntimeException e12) {
            throw e12;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void updateInsideSynchronized(T t2, DatabaseStatement databaseStatement, boolean z10) {
        bindValues(databaseStatement, (DatabaseStatement) t2);
        int length = this.config.allColumns.length + 1;
        Object key = getKey(t2);
        if (key instanceof Long) {
            databaseStatement.bindLong(length, ((Long) key).longValue());
        } else if (key != null) {
            databaseStatement.bindString(length, key.toString());
        } else {
            throw new DaoException("Cannot update entity without key - was it inserted before?");
        }
        databaseStatement.execute();
        attachEntity(key, t2, z10);
    }

    public abstract K updateKeyAfterInsert(T t2, long j10);

    public void updateKeyAfterInsertAndAttach(T t2, long j10, boolean z10) {
        if (j10 != -1) {
            attachEntity(updateKeyAfterInsert(t2, j10), t2, z10);
        } else {
            DaoLog.w("Could not insert row (executeInsert returned -1)");
        }
    }

    public AbstractDao(DaoConfig daoConfig, AbstractDaoSession abstractDaoSession) {
        this.config = daoConfig;
        this.session = abstractDaoSession;
        Database database = daoConfig.f52441db;
        this.f52438db = database;
        this.isStandardSQLite = database.getRawDatabase() instanceof SQLiteDatabase;
        IdentityScopeLong<T> identityScopeLong = (IdentityScope<K, T>) daoConfig.getIdentityScope();
        this.identityScope = identityScopeLong;
        if (identityScopeLong instanceof IdentityScopeLong) {
            this.identityScopeLong = identityScopeLong;
        } else {
            this.identityScopeLong = null;
        }
        this.statements = daoConfig.statements;
        Property property = daoConfig.pkProperty;
        this.pkOrdinal = property != null ? property.ordinal : -1;
    }

    public void deleteByKeyInTx(K... kArr) {
        deleteInTxInternal(null, Arrays.asList(kArr));
    }

    public void deleteInTx(T... tArr) {
        deleteInTxInternal(Arrays.asList(tArr), null);
    }

    public void insertInTx(T... tArr) {
        insertInTx(Arrays.asList(tArr), isEntityUpdateable());
    }

    public void saveInTx(Iterable<T> iterable) {
        Iterator<T> iterator2 = iterable.iterator2();
        int i10 = 0;
        int i11 = 0;
        while (iterator2.hasNext()) {
            if (hasKey(iterator2.next())) {
                i10++;
            } else {
                i11++;
            }
        }
        if (i10 <= 0 || i11 <= 0) {
            if (i11 > 0) {
                insertInTx(iterable);
                return;
            } else {
                if (i10 > 0) {
                    updateInTx(iterable);
                    return;
                }
                return;
            }
        }
        ArrayList arrayList = new ArrayList(i10);
        ArrayList arrayList2 = new ArrayList(i11);
        for (T t2 : iterable) {
            if (hasKey(t2)) {
                arrayList.add(t2);
            } else {
                arrayList2.add(t2);
            }
        }
        this.f52438db.beginTransaction();
        try {
            updateInTx(arrayList);
            insertInTx(arrayList2);
            this.f52438db.setTransactionSuccessful();
        } finally {
            this.f52438db.endTransaction();
        }
    }

    public void insertInTx(Iterable<T> iterable, boolean z10) {
        executeInsertInTx(this.statements.getInsertStatement(), iterable, z10);
    }

    public void insertOrReplaceInTx(Iterable<T> iterable) {
        insertOrReplaceInTx(iterable, isEntityUpdateable());
    }

    public void insertOrReplaceInTx(T... tArr) {
        insertOrReplaceInTx(Arrays.asList(tArr), isEntityUpdateable());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void updateInsideSynchronized(T t2, SQLiteStatement sQLiteStatement, boolean z10) {
        bindValues(sQLiteStatement, (SQLiteStatement) t2);
        int length = this.config.allColumns.length + 1;
        Object key = getKey(t2);
        if (key instanceof Long) {
            sQLiteStatement.bindLong(length, ((Long) key).longValue());
        } else if (key != null) {
            sQLiteStatement.bindString(length, key.toString());
        } else {
            throw new DaoException("Cannot update entity without key - was it inserted before?");
        }
        sQLiteStatement.execute();
        attachEntity(key, t2, z10);
    }

    public void updateInTx(T... tArr) {
        updateInTx(Arrays.asList(tArr));
    }
}

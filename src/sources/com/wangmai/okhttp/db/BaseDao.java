package com.wangmai.okhttp.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Pair;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.Lock;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public abstract class BaseDao<T> {
    public static String TAG;
    public SQLiteDatabase database;
    public SQLiteOpenHelper helper;
    public Lock lock;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface Action {
        void call(SQLiteDatabase sQLiteDatabase);
    }

    public BaseDao(SQLiteOpenHelper sQLiteOpenHelper) {
        TAG = getClass().getSimpleName();
        this.lock = DBHelper.lock;
        this.helper = sQLiteOpenHelper;
        this.database = openWriter();
    }

    public final void closeDatabase(SQLiteDatabase sQLiteDatabase, Cursor cursor) {
        if (cursor != null && !cursor.isClosed()) {
            cursor.close();
        }
        if (sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
            return;
        }
        sQLiteDatabase.close();
    }

    public boolean delete(String str, String[] strArr) {
        System.currentTimeMillis();
        this.lock.lock();
        try {
            this.database.beginTransaction();
            this.database.delete(getTableName(), str, strArr);
            this.database.setTransactionSuccessful();
            this.database.endTransaction();
            this.lock.unlock();
            return true;
        } catch (Throwable th) {
            try {
                th.printStackTrace();
                this.database.endTransaction();
                this.lock.unlock();
                return false;
            } catch (Throwable th2) {
                this.database.endTransaction();
                this.lock.unlock();
                throw th2;
            }
        }
    }

    public boolean deleteAll() {
        return delete(null, null);
    }

    public boolean deleteList(List<Pair<String, String[]>> list) {
        System.currentTimeMillis();
        this.lock.lock();
        try {
            this.database.beginTransaction();
            for (Pair<String, String[]> pair : list) {
                this.database.delete(getTableName(), (String) pair.first, (String[]) pair.second);
            }
            this.database.setTransactionSuccessful();
            this.database.endTransaction();
            this.lock.unlock();
            return true;
        } catch (Throwable th) {
            try {
                th.printStackTrace();
                this.database.endTransaction();
                this.lock.unlock();
                return false;
            } catch (Throwable th2) {
                this.database.endTransaction();
                this.lock.unlock();
                throw th2;
            }
        }
    }

    public abstract ContentValues getContentValues(T t2);

    public abstract String getTableName();

    public boolean insert(T t2) {
        if (t2 == null) {
            return false;
        }
        System.currentTimeMillis();
        this.lock.lock();
        try {
            this.database.beginTransaction();
            this.database.insert(getTableName(), null, getContentValues(t2));
            this.database.setTransactionSuccessful();
            this.database.endTransaction();
            this.lock.unlock();
            return true;
        } catch (Throwable th) {
            try {
                th.printStackTrace();
                return false;
            } finally {
                this.database.endTransaction();
                this.lock.unlock();
            }
        }
    }

    public SQLiteDatabase openReader() {
        return this.helper.getReadableDatabase();
    }

    public SQLiteDatabase openWriter() {
        return this.helper.getWritableDatabase();
    }

    public abstract T parseCursorToBean(Cursor cursor);

    public List<T> query(SQLiteDatabase sQLiteDatabase, String str, String[] strArr) {
        return query(sQLiteDatabase, null, str, strArr, null, null, null, null);
    }

    public List<T> queryAll(SQLiteDatabase sQLiteDatabase) {
        return query(sQLiteDatabase, null, null);
    }

    public T queryOne(SQLiteDatabase sQLiteDatabase, String str, String[] strArr) {
        List<T> query = query(sQLiteDatabase, null, str, strArr, null, null, null, "1");
        if (query.size() > 0) {
            return query.get(0);
        }
        return null;
    }

    public boolean replace(T t2) {
        if (t2 == null) {
            return false;
        }
        System.currentTimeMillis();
        this.lock.lock();
        try {
            this.database.beginTransaction();
            this.database.replace(getTableName(), null, getContentValues(t2));
            this.database.setTransactionSuccessful();
            this.database.endTransaction();
            this.lock.unlock();
            return true;
        } catch (Throwable th) {
            try {
                th.printStackTrace();
                return false;
            } finally {
                this.database.endTransaction();
                this.lock.unlock();
            }
        }
    }

    public void startTransaction(Action action) {
        this.lock.lock();
        try {
            this.database.beginTransaction();
            action.call(this.database);
            this.database.setTransactionSuccessful();
        } catch (Throwable th) {
            try {
                th.printStackTrace();
            } finally {
                this.database.endTransaction();
                this.lock.unlock();
            }
        }
    }

    public abstract void unInit();

    public boolean update(T t2, String str, String[] strArr) {
        if (t2 == null) {
            return false;
        }
        System.currentTimeMillis();
        this.lock.lock();
        try {
            this.database.beginTransaction();
            this.database.update(getTableName(), getContentValues(t2), str, strArr);
            this.database.setTransactionSuccessful();
            this.database.endTransaction();
            this.lock.unlock();
            return true;
        } catch (Throwable th) {
            try {
                th.printStackTrace();
                return false;
            } finally {
                this.database.endTransaction();
                this.lock.unlock();
            }
        }
    }

    public long deleteAll(SQLiteDatabase sQLiteDatabase) {
        return delete(sQLiteDatabase, null, null);
    }

    public List<T> query(SQLiteDatabase sQLiteDatabase, String[] strArr, String str, String[] strArr2, String str2, String str3, String str4, String str5) {
        Cursor cursor;
        ArrayList arrayList = new ArrayList();
        try {
            cursor = sQLiteDatabase.query(getTableName(), strArr, str, strArr2, str2, str3, str4, str5);
            while (!cursor.isClosed() && cursor.moveToNext()) {
                try {
                    arrayList.add(parseCursorToBean(cursor));
                } catch (Throwable th) {
                    th = th;
                    try {
                        th.printStackTrace();
                        return arrayList;
                    } finally {
                        closeDatabase(null, cursor);
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
        }
        return arrayList;
    }

    public List<T> queryAll() {
        return query(null, null);
    }

    public T queryOne(String str, String[] strArr) {
        System.currentTimeMillis();
        List<T> query = query(null, str, strArr, null, null, null, "1");
        if (query.size() > 0) {
            return query.get(0);
        }
        return null;
    }

    public List<T> query(String str, String[] strArr) {
        return query(null, str, strArr, null, null, null, null);
    }

    public List<T> query(String[] strArr, String str, String[] strArr2, String str2, String str3, String str4, String str5) {
        Cursor cursor;
        System.currentTimeMillis();
        this.lock.lock();
        ArrayList arrayList = new ArrayList();
        try {
            this.database.beginTransaction();
            cursor = this.database.query(getTableName(), strArr, str, strArr2, str2, str3, str4, str5);
            while (!cursor.isClosed() && cursor.moveToNext()) {
                try {
                    arrayList.add(parseCursorToBean(cursor));
                } catch (Throwable th) {
                    th = th;
                    try {
                        th.printStackTrace();
                        return arrayList;
                    } finally {
                        closeDatabase(null, cursor);
                        this.database.endTransaction();
                        this.lock.unlock();
                    }
                }
            }
            this.database.setTransactionSuccessful();
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
        }
        return arrayList;
    }

    public long delete(SQLiteDatabase sQLiteDatabase, String str, String[] strArr) {
        return sQLiteDatabase.delete(getTableName(), str, strArr);
    }

    public long insert(SQLiteDatabase sQLiteDatabase, T t2) {
        return sQLiteDatabase.insert(getTableName(), null, getContentValues(t2));
    }

    public long replace(SQLiteDatabase sQLiteDatabase, T t2) {
        return sQLiteDatabase.replace(getTableName(), null, getContentValues(t2));
    }

    public long update(SQLiteDatabase sQLiteDatabase, T t2, String str, String[] strArr) {
        return sQLiteDatabase.update(getTableName(), getContentValues(t2), str, strArr);
    }

    public boolean insert(List<T> list) {
        if (list == null) {
            return false;
        }
        System.currentTimeMillis();
        this.lock.lock();
        try {
            this.database.beginTransaction();
            Iterator<T> iterator2 = list.iterator2();
            while (iterator2.hasNext()) {
                this.database.insert(getTableName(), null, getContentValues(iterator2.next()));
            }
            this.database.setTransactionSuccessful();
            this.database.endTransaction();
            this.lock.unlock();
            return true;
        } catch (Throwable th) {
            try {
                th.printStackTrace();
                return false;
            } finally {
                this.database.endTransaction();
                this.lock.unlock();
            }
        }
    }

    public boolean replace(ContentValues contentValues) {
        System.currentTimeMillis();
        this.lock.lock();
        try {
            this.database.beginTransaction();
            this.database.replace(getTableName(), null, contentValues);
            this.database.setTransactionSuccessful();
            this.database.endTransaction();
            this.lock.unlock();
            return true;
        } catch (Throwable th) {
            try {
                th.printStackTrace();
                this.database.endTransaction();
                this.lock.unlock();
                return false;
            } catch (Throwable th2) {
                this.database.endTransaction();
                this.lock.unlock();
                throw th2;
            }
        }
    }

    public boolean update(ContentValues contentValues, String str, String[] strArr) {
        System.currentTimeMillis();
        this.lock.lock();
        try {
            this.database.beginTransaction();
            this.database.update(getTableName(), contentValues, str, strArr);
            this.database.setTransactionSuccessful();
            this.database.endTransaction();
            this.lock.unlock();
            return true;
        } catch (Throwable th) {
            try {
                th.printStackTrace();
                this.database.endTransaction();
                this.lock.unlock();
                return false;
            } catch (Throwable th2) {
                this.database.endTransaction();
                this.lock.unlock();
                throw th2;
            }
        }
    }

    public long replace(SQLiteDatabase sQLiteDatabase, ContentValues contentValues) {
        return sQLiteDatabase.replace(getTableName(), null, contentValues);
    }

    public long update(SQLiteDatabase sQLiteDatabase, ContentValues contentValues, String str, String[] strArr) {
        return sQLiteDatabase.update(getTableName(), contentValues, str, strArr);
    }

    public boolean insert(SQLiteDatabase sQLiteDatabase, List<T> list) {
        try {
            Iterator<T> iterator2 = list.iterator2();
            while (iterator2.hasNext()) {
                sQLiteDatabase.insert(getTableName(), null, getContentValues(iterator2.next()));
            }
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean replace(List<T> list) {
        if (list == null) {
            return false;
        }
        System.currentTimeMillis();
        this.lock.lock();
        try {
            this.database.beginTransaction();
            Iterator<T> iterator2 = list.iterator2();
            while (iterator2.hasNext()) {
                this.database.replace(getTableName(), null, getContentValues(iterator2.next()));
            }
            this.database.setTransactionSuccessful();
            this.database.endTransaction();
            this.lock.unlock();
            return true;
        } catch (Throwable th) {
            try {
                th.printStackTrace();
                return false;
            } finally {
                this.database.endTransaction();
                this.lock.unlock();
            }
        }
    }

    public boolean replace(SQLiteDatabase sQLiteDatabase, List<T> list) {
        try {
            Iterator<T> iterator2 = list.iterator2();
            while (iterator2.hasNext()) {
                sQLiteDatabase.replace(getTableName(), null, getContentValues(iterator2.next()));
            }
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }
}

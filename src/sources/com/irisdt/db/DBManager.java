package com.irisdt.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import androidx.annotation.Nullable;
import com.mobile.auth.BuildConfig;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class DBManager {
    private static final String LOG_TAG = "DBManager";
    private int uploadBatchSize;
    private int uploadIntervalSeconds;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class InstanceHolder {
        private static final DBManager INSTANCE = new DBManager();

        private InstanceHolder() {
        }
    }

    public static DBManager getInstance() {
        return InstanceHolder.INSTANCE;
    }

    public synchronized long count(String str) {
        long j10;
        j10 = 0;
        try {
            Cursor rawQuery = DBHelper.getInstance().getDatabase().rawQuery("select count(1) from " + str, null);
            try {
                rawQuery.moveToNext();
                j10 = rawQuery.getLong(0);
                rawQuery.close();
            } finally {
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return j10;
    }

    public synchronized void delete(String str, Set<Long> set) {
        if (set != null) {
            if (!set.isEmpty()) {
                try {
                    String replaceAll = set.toString().replaceAll("\\[", "").replaceAll("]", "");
                    DBHelper.getInstance().getDatabase().delete(str, "id in (" + replaceAll + ")", null);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    public synchronized void deleteById(String str, long j10) {
        try {
            DBHelper.getInstance().getDatabase().delete(str, "id =" + j10, null);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void init(@Nullable Context context) {
        DBHelper.open(context);
        new Thread(new UploadRunner(this.uploadBatchSize, this.uploadIntervalSeconds)).start();
    }

    public synchronized void insert(String str, Entity entity) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(BuildConfig.FLAVOR_type, entity.getBlob());
            int i10 = (DBHelper.getInstance().getDatabase().insert(str, null, contentValues) > (-1L) ? 1 : (DBHelper.getInstance().getDatabase().insert(str, null, contentValues) == (-1L) ? 0 : -1));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public synchronized Map<Long, Entity> query(String str) {
        HashMap hashMap;
        String str2 = "select * from " + str;
        hashMap = new HashMap();
        try {
            Cursor rawQuery = DBHelper.getInstance().getDatabase().rawQuery(str2, null);
            while (rawQuery.moveToNext()) {
                try {
                    Entity entity = new Entity();
                    entity.setId(rawQuery.getInt(0));
                    entity.setBlob(rawQuery.getBlob(1));
                    hashMap.put(Long.valueOf(entity.getId()), entity);
                } finally {
                }
            }
            rawQuery.close();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return hashMap;
    }

    public boolean tabIsExist(String str) {
        if (str == null) {
            return false;
        }
        try {
            Cursor rawQuery = DBHelper.getInstance().getDatabase().rawQuery("select count(*) from sqlite_master where type ='table' and name ='" + str.trim() + "' ", null);
            if (rawQuery.moveToNext()) {
                return rawQuery.getInt(0) > 0;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    private DBManager() {
        this.uploadBatchSize = 30;
        this.uploadIntervalSeconds = 5;
    }

    public synchronized Map<Long, Entity> query(String str, int i10) {
        HashMap hashMap;
        String str2 = "select * from " + str + " limit " + i10;
        hashMap = new HashMap();
        try {
            Cursor rawQuery = DBHelper.getInstance().getDatabase().rawQuery(str2, null);
            while (rawQuery.moveToNext()) {
                try {
                    Entity entity = new Entity();
                    entity.setId(rawQuery.getInt(0));
                    entity.setBlob(rawQuery.getBlob(1));
                    hashMap.put(Long.valueOf(entity.getId()), entity);
                } finally {
                }
            }
            rawQuery.close();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return hashMap;
    }
}

package com.wangmai.okhttp.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class DBUtils {
    public static boolean isFieldExists(SQLiteDatabase sQLiteDatabase, String str, String str2) {
        boolean z10 = false;
        if (str == null || sQLiteDatabase == null || str2 == null || !sQLiteDatabase.isOpen()) {
            return false;
        }
        Cursor cursor = null;
        try {
            cursor = sQLiteDatabase.rawQuery("SELECT * FROM " + str + " LIMIT 0", null);
            if (cursor != null) {
                if (cursor.getColumnIndex(str2) != -1) {
                    z10 = true;
                }
            }
            return z10;
        } catch (Throwable th) {
            try {
                th.printStackTrace();
                if (cursor != null) {
                    cursor.close();
                }
                return false;
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
            }
        }
    }

    public static boolean isNeedUpgradeTable(SQLiteDatabase sQLiteDatabase, TableEntity tableEntity) {
        if (!isTableExists(sQLiteDatabase, tableEntity.tableName)) {
            return true;
        }
        Cursor rawQuery = sQLiteDatabase.rawQuery("select * from " + tableEntity.tableName, null);
        if (rawQuery == null) {
            return false;
        }
        try {
            int columnCount = tableEntity.getColumnCount();
            if (columnCount != rawQuery.getColumnCount()) {
                return true;
            }
            for (int i10 = 0; i10 < columnCount; i10++) {
                if (tableEntity.getColumnIndex(rawQuery.getColumnName(i10)) == -1) {
                    return true;
                }
            }
            return false;
        } finally {
            rawQuery.close();
        }
    }

    public static boolean isTableExists(SQLiteDatabase sQLiteDatabase, String str) {
        int i10;
        if (str == null || sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
            return false;
        }
        Cursor cursor = null;
        try {
            cursor = sQLiteDatabase.rawQuery("SELECT COUNT(*) FROM sqlite_master WHERE type = ? AND name = ?", new String[]{"table", str});
        } catch (Throwable th) {
            try {
                th.printStackTrace();
                i10 = 0;
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
            }
        }
        if (!cursor.moveToFirst()) {
            cursor.close();
            return false;
        }
        i10 = cursor.getInt(0);
        return i10 > 0;
    }
}

package com.wangmai.okhttp.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.wangmai.okhttp.cookie.SerializableCookie;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class CookieManager extends BaseDao<SerializableCookie> {
    public static Context context;
    public static volatile CookieManager instance;

    public CookieManager() {
        super(new DBHelper(context));
    }

    public static CookieManager getInstance() {
        if (instance == null) {
            synchronized (CookieManager.class) {
                if (instance == null) {
                    instance = new CookieManager();
                }
            }
        }
        return instance;
    }

    public static void init(Context context2) {
        context = context2;
    }

    @Override // com.wangmai.okhttp.db.BaseDao
    public String getTableName() {
        return "cookie";
    }

    @Override // com.wangmai.okhttp.db.BaseDao
    public void unInit() {
    }

    @Override // com.wangmai.okhttp.db.BaseDao
    public ContentValues getContentValues(SerializableCookie serializableCookie) {
        return SerializableCookie.getContentValues(serializableCookie);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.wangmai.okhttp.db.BaseDao
    public SerializableCookie parseCursorToBean(Cursor cursor) {
        return SerializableCookie.parseCursorToBean(cursor);
    }
}

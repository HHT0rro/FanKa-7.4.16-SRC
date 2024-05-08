package com.huawei.hms.mlsdk.common.provider;

import android.app.Application;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import com.huawei.hms.ml.common.utils.ActivityMgr;
import com.huawei.hms.ml.common.utils.SmartLog;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class MLInitializerProvider extends ContentProvider {
    private static final String TAG = MLInitializerProvider.class.getSimpleName();

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        try {
            ActivityMgr.INST.init((Application) getContext().getApplicationContext());
            SmartLog.e(TAG, "MLInitializerProvider Done");
            return false;
        } catch (Throwable th) {
            SmartLog.e(TAG, "MLInitializerProvider e: " + th);
            return false;
        }
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}

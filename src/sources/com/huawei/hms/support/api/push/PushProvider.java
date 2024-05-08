package com.huawei.hms.support.api.push;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import com.huawei.hms.support.log.HMSLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Objects;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class PushProvider extends ContentProvider {
    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        if (uri == null || !uri.toString().endsWith(".xml")) {
            return null;
        }
        return "xml";
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return false;
    }

    @Override // android.content.ContentProvider
    public ParcelFileDescriptor openFile(Uri uri, String str) throws FileNotFoundException {
        HMSLog.i("PushProvider", "use sdk PushProvider openFile");
        if ("xml".equals(getType(uri))) {
            if (Build.VERSION.SDK_INT >= 24) {
                StringBuilder sb2 = new StringBuilder();
                Context context = getContext();
                Objects.requireNonNull(context);
                sb2.append((Object) context.createDeviceProtectedStorageContext().getDataDir());
                sb2.append("/shared_prefs/push_notify_flag.xml");
                File file = new File(sb2.toString());
                if (file.exists()) {
                    return ParcelFileDescriptor.open(file, 268435456);
                }
                File file2 = new File(((Object) getContext().getDataDir()) + "/shared_prefs/push_notify_flag.xml");
                if (file2.exists()) {
                    return ParcelFileDescriptor.open(file2, 268435456);
                }
            } else {
                String str2 = ((Object) getContext().getFilesDir()) + "";
                if (!TextUtils.isEmpty(str2)) {
                    File file3 = new File(str2.substring(0, str2.length() - 6) + "/shared_prefs/push_notify_flag.xml");
                    if (file3.exists()) {
                        return ParcelFileDescriptor.open(file3, 268435456);
                    }
                }
            }
            throw new FileNotFoundException(uri.getPath());
        }
        HMSLog.w("PushProvider", "Incorrect file uri");
        throw new FileNotFoundException(uri.getPath());
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

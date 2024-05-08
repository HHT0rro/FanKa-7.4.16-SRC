package com.zego.ve;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.t;
import java.io.FileNotFoundException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class FileMediaDataSource {
    private static final String TAG = "FileMediaDataSource";
    private int uriFd = -1;

    private String getAppDataPath(Context context) {
        return context.getApplicationInfo().dataDir;
    }

    private int initDataSource(Context context, String str, boolean z10) throws FileNotFoundException {
        Log.d(TAG, "initDataSource enter, uri: " + str);
        Uri parse = Uri.parse(str);
        String scheme = parse.getScheme();
        String str2 = z10 ? t.f36226k : "rw";
        if (!TextUtils.isEmpty(scheme) && !scheme.equalsIgnoreCase("content") && !scheme.equalsIgnoreCase("file")) {
            Log.e(TAG, "Invalid path:  " + str);
            return -2;
        }
        try {
            this.uriFd = context.getContentResolver().openFileDescriptor(parse, str2).detachFd();
            Log.d(TAG, "Open file: " + parse.getPath() + " successful, get fd " + this.uriFd);
            return this.uriFd;
        } catch (FileNotFoundException e2) {
            Log.d(TAG, "Open file: " + parse.getPath() + " failed with exception: " + e2.getMessage());
            return -1;
        }
    }
}

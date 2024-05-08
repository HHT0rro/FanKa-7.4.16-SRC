package io.flutter.util;

import android.content.Context;
import android.os.Build;
import androidx.annotation.NonNull;
import com.wangmai.okhttp.db.DBHelper;
import java.io.File;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class PathUtils {
    @NonNull
    public static String getCacheDirectory(@NonNull Context context) {
        File codeCacheDir = context.getCodeCacheDir();
        if (codeCacheDir == null) {
            codeCacheDir = context.getCacheDir();
        }
        if (codeCacheDir == null) {
            codeCacheDir = new File(getDataDirPath(context), DBHelper.TABLE_CACHE);
        }
        return codeCacheDir.getPath();
    }

    private static String getDataDirPath(Context context) {
        if (Build.VERSION.SDK_INT >= 24) {
            return context.getDataDir().getPath();
        }
        return context.getApplicationInfo().dataDir;
    }

    @NonNull
    public static String getDataDirectory(@NonNull Context context) {
        File dir = context.getDir("flutter", 0);
        if (dir == null) {
            dir = new File(getDataDirPath(context), "app_flutter");
        }
        return dir.getPath();
    }

    @NonNull
    public static String getFilesDir(@NonNull Context context) {
        File filesDir = context.getFilesDir();
        if (filesDir == null) {
            filesDir = new File(getDataDirPath(context), "files");
        }
        return filesDir.getPath();
    }
}

package pb;

import android.content.Context;
import android.os.Environment;
import com.kuaishou.weapon.p0.g;
import com.wangmai.okhttp.db.DBHelper;
import java.io.File;
import java.io.IOException;

/* compiled from: StorageUtils.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class f {
    public static File a(Context context) {
        return b(context, true);
    }

    public static File b(Context context, boolean z10) {
        String str = "";
        try {
            str = Environment.getExternalStorageState();
        } catch (IncompatibleClassChangeError | NullPointerException unused) {
        }
        File c4 = (z10 && "mounted".equals(str) && f(context)) ? c(context) : null;
        if (c4 == null) {
            c4 = context.getCacheDir();
        }
        if (c4 != null) {
            return c4;
        }
        String str2 = "/data/data/" + context.getPackageName() + "/cache/";
        d.f("Can't define system cache directory! '%s' will be used.", str2);
        return new File(str2);
    }

    public static File c(Context context) {
        File file = new File(new File(new File(new File(Environment.getExternalStorageDirectory(), "Android"), "data"), context.getPackageName()), DBHelper.TABLE_CACHE);
        if (!file.exists()) {
            if (!file.mkdirs()) {
                d.f("Unable to create external cache directory", new Object[0]);
                return null;
            }
            try {
                new File(file, ".nomedia").createNewFile();
            } catch (IOException unused) {
                d.d("Can't create \".nomedia\" file in application external cache directory", new Object[0]);
            }
        }
        return file;
    }

    public static File d(Context context) {
        return e(context, "uil-images");
    }

    public static File e(Context context, String str) {
        File a10 = a(context);
        File file = new File(a10, str);
        return (file.exists() || file.mkdir()) ? file : a10;
    }

    public static boolean f(Context context) {
        return context.checkCallingOrSelfPermission(g.f36124j) == 0;
    }
}

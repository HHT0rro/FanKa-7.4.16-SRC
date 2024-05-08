package yc;

import android.app.Activity;
import android.os.Build;

/* compiled from: ActivityCompat.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class a extends d {
    public static boolean c(Activity activity, String str) {
        if (Build.VERSION.SDK_INT >= 23) {
            return activity.shouldShowRequestPermissionRationale(str);
        }
        return false;
    }
}

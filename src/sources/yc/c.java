package yc;

import android.app.AppOpsManager;
import android.content.Context;

/* compiled from: AppOpsManagerCompat23.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class c {
    public static int a(Context context, String str, String str2) {
        return ((AppOpsManager) context.getSystemService(AppOpsManager.class)).noteProxyOp(str, str2);
    }

    public static String b(String str) {
        return AppOpsManager.permissionToOp(str);
    }
}

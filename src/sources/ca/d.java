package ca;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class d {
    public static String a(Context context) {
        String str;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            if (packageInfo != null) {
                return packageInfo.versionName;
            }
        } catch (PackageManager.NameNotFoundException unused) {
            str = "can not get client version NameNotFoundException.";
            fa.a.c("PkgUtil", str);
            return "";
        } catch (Exception unused2) {
            str = "can not get client version Exception.";
            fa.a.c("PkgUtil", str);
            return "";
        }
        return "";
    }
}

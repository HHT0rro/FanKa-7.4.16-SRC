package za;

import android.content.Context;
import android.content.pm.PackageManager;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    public static final String f55044a = "f";

    public static String a(String str) {
        Context a10 = b.a();
        if (a10 == null) {
            return "";
        }
        try {
            return a10.getPackageManager().getPackageInfo(str, 0).versionName;
        } catch (PackageManager.NameNotFoundException e2) {
            f.d(f55044a, "getVersion NameNotFoundException : " + e2.getMessage());
            return "";
        } catch (Exception e10) {
            f.d(f55044a, "getVersion: " + e10.getMessage());
            return "";
        } catch (Throwable unused) {
            f.d(f55044a, "throwable");
            return "";
        }
    }
}

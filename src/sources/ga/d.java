package ga;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public static String f49425a = "";

    /* renamed from: b, reason: collision with root package name */
    public static final Object f49426b = new Object();

    public static String a() {
        String b4 = ca.a.b();
        return TextUtils.isEmpty(b4) ? "other" : b4;
    }

    public static String b(Context context) {
        String str;
        String str2;
        String str3;
        synchronized (f49426b) {
            if (TextUtils.isEmpty(f49425a)) {
                String str4 = ("InstallSDK##11.5.1.300##" + a()) + "##" + ca.a.i();
                try {
                    String packageName = context.getPackageName();
                    str4 = str4 + "##" + packageName;
                    str3 = str4 + "##" + context.getPackageManager().getPackageInfo(packageName, 0).versionName;
                } catch (PackageManager.NameNotFoundException e2) {
                    e = e2;
                    str = "UserAgentUtils";
                    str2 = "get package error";
                    fa.a.b(str, str2, e);
                    str3 = str4;
                    f49425a = str3;
                    return f49425a;
                } catch (Exception e10) {
                    e = e10;
                    str = "UserAgentUtils";
                    str2 = "get package Exception";
                    fa.a.b(str, str2, e);
                    str3 = str4;
                    f49425a = str3;
                    return f49425a;
                }
                f49425a = str3;
            }
        }
        return f49425a;
    }
}

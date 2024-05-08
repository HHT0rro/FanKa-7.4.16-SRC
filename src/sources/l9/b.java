package l9;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;

/* compiled from: MetaDataUtil.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class b {
    public static int a(Context context, String str) {
        ApplicationInfo applicationInfo;
        int i10 = 0;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 128);
            if (packageInfo != null && (applicationInfo = packageInfo.applicationInfo) != null) {
                Bundle bundle = applicationInfo.metaData;
                i10 = (bundle == null || !bundle.containsKey("agd_ad")) ? -1 : new wa.b(bundle).a("agd_ad");
            }
            j9.a.f50348d.i("MetaDataUtil", "getMetaDataIntValue| " + str + ": value=" + i10);
            return i10;
        } catch (PackageManager.NameNotFoundException | RuntimeException unused) {
            j9.a.f50348d.w("MetaDataUtil", "getMetaDataIntValue| can not found packageName:" + str);
            return 0;
        }
    }
}

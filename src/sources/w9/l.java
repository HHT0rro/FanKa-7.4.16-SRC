package w9;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class l {
    public static boolean a(PackageInfo packageInfo) {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        return ((packageInfo == null || (applicationInfo = packageInfo.applicationInfo) == null || (bundle = applicationInfo.metaData) == null || !bundle.containsKey("sdk_install_issupport")) ? 0 : new wa.b(bundle).a("sdk_install_issupport")) == 1;
    }
}

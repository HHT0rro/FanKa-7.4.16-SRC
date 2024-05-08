package k2;

import android.os.Build;

/* compiled from: FocusStrategyFactory.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class c {
    public static b a() {
        String str = Build.MANUFACTURER;
        if (str != null && (str.compareToIgnoreCase("Samsung") == 0 || str.compareToIgnoreCase("meizu") == 0)) {
            return new a();
        }
        return new d();
    }
}

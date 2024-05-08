package b0;

import android.content.Context;
import com.kuaishou.weapon.p0.bq;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static a f1231a = new a();

    public static a a() {
        return f1231a;
    }

    public static String b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 16).versionName;
        } catch (Exception unused) {
            return bq.f35867e;
        }
    }
}

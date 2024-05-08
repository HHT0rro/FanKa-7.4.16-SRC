package g7;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public static SharedPreferences f49415a;

    public static SharedPreferences a(Context context) throws Exception {
        SharedPreferences sharedPreferences;
        synchronized (SharedPreferences.class) {
            if (f49415a == null) {
                f49415a = (SharedPreferences) j7.c.a(new k(context));
            }
            sharedPreferences = f49415a;
        }
        return sharedPreferences;
    }
}

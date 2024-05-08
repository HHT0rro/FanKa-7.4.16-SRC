package kc;

import android.content.Context;
import android.net.Uri;
import android.provider.Settings;
import com.hailiang.advlib.core.ADEvent;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class q {

    /* renamed from: c, reason: collision with root package name */
    public static q f50847c;

    /* renamed from: a, reason: collision with root package name */
    public Context f50848a;

    /* renamed from: b, reason: collision with root package name */
    public int f50849b = 0;

    public q(Context context) {
        this.f50848a = context.getApplicationContext();
    }

    public static q c(Context context) {
        if (f50847c == null) {
            f50847c = new q(context);
        }
        return f50847c;
    }

    public int a() {
        int i10 = this.f50849b;
        if (i10 != 0) {
            return i10;
        }
        try {
            this.f50849b = Settings.Global.getInt(this.f50848a.getContentResolver(), "device_provisioned", 0);
        } catch (Exception unused) {
        }
        return this.f50849b;
    }

    public Uri b() {
        return Settings.Global.getUriFor("device_provisioned");
    }

    public boolean d() {
        String str = com.xiaomi.push.e.f47186a;
        return str.contains("xmsf") || str.contains(ADEvent.XIAOMI) || str.contains("miui");
    }
}

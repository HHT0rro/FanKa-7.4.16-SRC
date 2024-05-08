package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.service.XMPushService;
import java.io.File;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class i6 implements XMPushService.l {

    /* renamed from: d, reason: collision with root package name */
    public static boolean f47531d;

    /* renamed from: a, reason: collision with root package name */
    public Context f47532a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f47533b;

    /* renamed from: c, reason: collision with root package name */
    public int f47534c;

    public i6(Context context) {
        this.f47532a = context;
    }

    public static void c(boolean z10) {
        f47531d = z10;
    }

    public final String a(String str) {
        return "com.xiaomi.xmsf".equals(str) ? "1000271" : this.f47532a.getSharedPreferences("pref_registered_pkg_names", 0).getString(str, null);
    }

    @Override // com.xiaomi.push.service.XMPushService.l
    public void a() {
        b(this.f47532a);
        if (this.f47533b && d()) {
            fc.c.i("TinyData TinyDataCacheProcessor.pingFollowUpAction ts:" + System.currentTimeMillis());
            m6 b4 = l6.a(this.f47532a).b();
            if (e(b4)) {
                f47531d = true;
                j6.b(this.f47532a, b4);
            } else {
                fc.c.i("TinyData TinyDataCacheProcessor.pingFollowUpAction !canUpload(uploader) ts:" + System.currentTimeMillis());
            }
        }
    }

    public final void b(Context context) {
        this.f47533b = kc.j.d(context).i(hv.TinyDataUploadSwitch.a(), true);
        int a10 = kc.j.d(context).a(hv.TinyDataUploadFrequency.a(), 7200);
        this.f47534c = a10;
        this.f47534c = Math.max(60, a10);
    }

    public final boolean d() {
        return Math.abs((System.currentTimeMillis() / 1000) - this.f47532a.getSharedPreferences("mipush_extra", 4).getLong("last_tiny_data_upload_timestamp", -1L)) > ((long) this.f47534c);
    }

    public final boolean e(m6 m6Var) {
        if (!j0.p(this.f47532a) || m6Var == null || TextUtils.isEmpty(a(this.f47532a.getPackageName())) || !new File(this.f47532a.getFilesDir(), "tiny_data.data").exists() || f47531d) {
            return false;
        }
        return !kc.j.d(this.f47532a).i(hv.ScreenOnOrChargingTinyDataUploadSwitch.a(), false) || n6.l(this.f47532a) || n6.r(this.f47532a);
    }
}

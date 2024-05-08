package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.inno.innosdk.pb.InnoMain;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class d0 implements x {

    /* renamed from: d, reason: collision with root package name */
    public static volatile d0 f47165d;

    /* renamed from: b, reason: collision with root package name */
    public x f47166b;

    /* renamed from: c, reason: collision with root package name */
    public int f47167c = c0.f47148a;

    public d0(Context context) {
        this.f47166b = c0.a(context);
        fc.c.i("create id manager is: " + this.f47167c);
    }

    public static d0 a(Context context) {
        if (f47165d == null) {
            synchronized (d0.class) {
                if (f47165d == null) {
                    f47165d = new d0(context.getApplicationContext());
                }
            }
        }
        return f47165d;
    }

    @Override // com.xiaomi.push.x
    public String a() {
        return b(this.f47166b.a());
    }

    @Override // com.xiaomi.push.x
    /* renamed from: a */
    public boolean mo2931a() {
        return this.f47166b.mo2931a();
    }

    @Override // com.xiaomi.push.x
    public String b() {
        return b(this.f47166b.b());
    }

    public final String b(String str) {
        return str == null ? "" : str;
    }

    @Override // com.xiaomi.push.x
    public String c() {
        return b(this.f47166b.c());
    }

    public void c(Map<String, String> map) {
        if (map == null) {
            return;
        }
        String a10 = a();
        if (!TextUtils.isEmpty(a10)) {
            map.put("udid", a10);
        }
        String b4 = b();
        if (!TextUtils.isEmpty(b4)) {
            map.put(InnoMain.INNO_KEY_OAID, b4);
        }
        String c4 = c();
        if (!TextUtils.isEmpty(c4)) {
            map.put("vaid", c4);
        }
        String d10 = d();
        if (!TextUtils.isEmpty(d10)) {
            map.put("aaid", d10);
        }
        map.put("oaid_type", String.valueOf(this.f47167c));
    }

    @Override // com.xiaomi.push.x
    public String d() {
        return b(this.f47166b.d());
    }

    public final String d(String str) {
        return TextUtils.isEmpty(str) ? "" : str.length() > 5 ? str.substring(str.length() - 5) : str;
    }

    public String e() {
        return "t:" + this.f47167c + " s:" + mo2931a() + " d:" + d(a()) + " | " + d(b()) + " | " + d(c()) + " | " + d(d());
    }
}

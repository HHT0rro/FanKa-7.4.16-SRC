package ca;

import android.text.TextUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class b {

    /* renamed from: c, reason: collision with root package name */
    public static b f1588c;

    /* renamed from: a, reason: collision with root package name */
    public int f1589a;

    /* renamed from: b, reason: collision with root package name */
    public String f1590b;

    public b() {
        this.f1589a = 0;
        this.f1590b = "";
        this.f1589a = e.a("ro.build.hw_emui_api_level", 0);
        this.f1590b = b(d());
    }

    public static synchronized b e() {
        b bVar;
        synchronized (b.class) {
            if (f1588c == null) {
                f1588c = new b();
            }
            bVar = f1588c;
        }
        return bVar;
    }

    public int a() {
        return this.f1589a;
    }

    public final String b(String str) {
        if (!TextUtils.isEmpty(str)) {
            String[] split = str.split("_");
            if (split.length == 2) {
                return split[1];
            }
        }
        return "";
    }

    public String c() {
        return this.f1590b;
    }

    public final String d() {
        return e.c("ro.build.version.emui", "");
    }
}

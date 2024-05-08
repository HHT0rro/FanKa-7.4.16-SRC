package com.huawei.hms.hatool;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.huawei.hms.ads.jsb.constant.Constant;
import java.util.UUID;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class j {

    /* renamed from: b, reason: collision with root package name */
    private static j f30137b;

    /* renamed from: a, reason: collision with root package name */
    private Context f30138a;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class a extends e0 {

        /* renamed from: a, reason: collision with root package name */
        public String f30139a;

        /* renamed from: b, reason: collision with root package name */
        public String f30140b;

        public a(String str, String str2) {
            this.f30139a = str;
            this.f30140b = str2;
        }

        @Override // com.huawei.hms.hatool.e0
        public String a() {
            return z.d(this.f30139a, this.f30140b);
        }

        @Override // com.huawei.hms.hatool.e0
        public String a(String str) {
            return ta.b.b(str);
        }

        @Override // com.huawei.hms.hatool.e0
        public String b() {
            return z.g(this.f30139a, this.f30140b);
        }

        @Override // com.huawei.hms.hatool.e0
        public String c() {
            return z.j(this.f30139a, this.f30140b);
        }

        @Override // com.huawei.hms.hatool.e0
        public int d() {
            return (z.k(this.f30139a, this.f30140b) ? 4 : 0) | 0 | (z.e(this.f30139a, this.f30140b) ? 2 : 0) | (z.h(this.f30139a, this.f30140b) ? 1 : 0);
        }
    }

    public static j a() {
        j jVar;
        synchronized (j.class) {
            if (f30137b == null) {
                f30137b = new j();
            }
            jVar = f30137b;
        }
        return jVar;
    }

    public String a(String str, String str2) {
        return i0.a(this.f30138a, str, str2);
    }

    public String a(boolean z10) {
        if (!z10) {
            return "";
        }
        String e2 = q0.e();
        if (TextUtils.isEmpty(e2)) {
            e2 = d.a(this.f30138a, "global_v2", Constant.MAP_KEY_UUID, "");
            if (TextUtils.isEmpty(e2)) {
                e2 = UUID.randomUUID().toString().replace("-", "");
                d.b(this.f30138a, "global_v2", Constant.MAP_KEY_UUID, e2);
            }
            q0.h(e2);
        }
        return e2;
    }

    public void a(Context context) {
        if (this.f30138a == null) {
            this.f30138a = context;
        }
    }

    public String b(String str, String str2) {
        return i0.b(this.f30138a, str, str2);
    }

    public i c(String str, String str2) {
        return new a(str, str2).a(this.f30138a);
    }

    public String d(String str, String str2) {
        return f1.b(str, str2);
    }

    public Pair<String, String> e(String str, String str2) {
        if (!z.f(str, str2)) {
            return new Pair<>("", "");
        }
        String p10 = s.c().b().p();
        String q10 = s.c().b().q();
        if (!TextUtils.isEmpty(p10) && !TextUtils.isEmpty(q10)) {
            return new Pair<>(p10, q10);
        }
        Pair<String, String> e2 = x0.e(this.f30138a);
        s.c().b().k((String) e2.first);
        s.c().b().l((String) e2.second);
        return e2;
    }

    public String f(String str, String str2) {
        return f1.a(str, str2);
    }
}

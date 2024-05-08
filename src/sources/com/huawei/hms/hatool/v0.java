package com.huawei.hms.hatool;

import android.content.Context;
import android.util.Pair;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class v0 implements g {

    /* renamed from: a, reason: collision with root package name */
    private Context f30238a = q0.i();

    /* renamed from: b, reason: collision with root package name */
    private String f30239b;

    /* renamed from: c, reason: collision with root package name */
    private String f30240c;

    /* renamed from: d, reason: collision with root package name */
    private String f30241d;

    public v0(String str, String str2, String str3) {
        this.f30239b = str;
        this.f30240c = str2;
        this.f30241d = str3;
    }

    private void a(String str, List<b1> list) {
        Pair<String, String> a10 = n1.a(str);
        new u(list, (String) a10.first, (String) a10.second, this.f30241d).a();
    }

    @Override // java.lang.Runnable
    public void run() {
        Map<String, List<b1>> a10;
        v.c("hmsSdk", "eventReportTask is running");
        boolean a11 = c0.a(this.f30238a);
        if (a11) {
            v.c("hmsSdk", "workKey is refresh,begin report all data");
            this.f30240c = "alltype";
        }
        try {
            try {
                a10 = c1.a(this.f30238a, this.f30239b, this.f30240c);
            } catch (IllegalArgumentException e2) {
                v.e("hmsSdk", "readEventRecords handData IllegalArgumentException:" + e2.getMessage());
                if ("alltype".equals(this.f30240c)) {
                    d.a(this.f30238a, "stat_v2_1", new String[0]);
                    d.a(this.f30238a, "cached_v2_1", new String[0]);
                } else {
                    String a12 = n1.a(this.f30239b, this.f30240c);
                    d.a(this.f30238a, "stat_v2_1", a12);
                    d.a(this.f30238a, "cached_v2_1", a12);
                }
            } catch (Exception e10) {
                v.e("hmsSdk", "readEventRecords handData Exception:" + e10.getMessage());
                if ("alltype".equals(this.f30240c)) {
                    d.a(this.f30238a, "stat_v2_1", new String[0]);
                    d.a(this.f30238a, "cached_v2_1", new String[0]);
                } else {
                    String a13 = n1.a(this.f30239b, this.f30240c);
                    d.a(this.f30238a, "stat_v2_1", a13);
                    d.a(this.f30238a, "cached_v2_1", a13);
                }
            }
            if (a10.size() == 0) {
                v.b("hmsSdk", "no have events to report: tag:%s : type:%s", this.f30239b, this.f30240c);
                if ("alltype".equals(this.f30240c)) {
                    d.a(this.f30238a, "stat_v2_1", new String[0]);
                    d.a(this.f30238a, "cached_v2_1", new String[0]);
                    return;
                } else {
                    String a14 = n1.a(this.f30239b, this.f30240c);
                    d.a(this.f30238a, "stat_v2_1", a14);
                    d.a(this.f30238a, "cached_v2_1", a14);
                    return;
                }
            }
            for (Map.Entry<String, List<b1>> entry : a10.entrySet()) {
                a(entry.getKey(), entry.getValue());
            }
            if ("alltype".equals(this.f30240c)) {
                d.a(this.f30238a, "stat_v2_1", new String[0]);
                d.a(this.f30238a, "cached_v2_1", new String[0]);
            } else {
                String a15 = n1.a(this.f30239b, this.f30240c);
                d.a(this.f30238a, "stat_v2_1", a15);
                d.a(this.f30238a, "cached_v2_1", a15);
            }
            if (a11) {
                v.c("hmsSdk", "refresh local key");
                o0.d().b();
            }
        } catch (Throwable th) {
            if ("alltype".equals(this.f30240c)) {
                d.a(this.f30238a, "stat_v2_1", new String[0]);
                d.a(this.f30238a, "cached_v2_1", new String[0]);
            } else {
                String a16 = n1.a(this.f30239b, this.f30240c);
                d.a(this.f30238a, "stat_v2_1", a16);
                d.a(this.f30238a, "cached_v2_1", a16);
            }
            throw th;
        }
    }
}

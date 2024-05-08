package com.huawei.hms.scankit.p;

import android.os.Bundle;
import com.google.android.material.datepicker.UtcDates;
import com.huawei.hms.feature.DynamicModuleInitializer;
import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.quickcard.base.code.AbilityCode;
import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;
import java.util.TimeZone;
import java.util.UUID;

/* compiled from: HaLog60000.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class v3 extends u3 {

    /* renamed from: o, reason: collision with root package name */
    private static String f31607o = "AiDetect";

    /* renamed from: p, reason: collision with root package name */
    private static String f31608p = "defaultDetect";

    /* renamed from: h, reason: collision with root package name */
    private int f31609h;

    /* renamed from: i, reason: collision with root package name */
    public String f31610i;

    /* renamed from: j, reason: collision with root package name */
    public String f31611j;

    /* renamed from: k, reason: collision with root package name */
    public long f31612k;

    /* renamed from: l, reason: collision with root package name */
    public long f31613l;

    /* renamed from: m, reason: collision with root package name */
    public long f31614m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f31615n;

    /* compiled from: HaLog60000.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class a extends SimpleDateFormat {
        public a(String str) {
            super(str);
            setTimeZone(TimeZone.getTimeZone(UtcDates.UTC));
        }
    }

    /* compiled from: HaLog60000.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class b extends LinkedHashMap<String, String> {
        public b() {
            v3.this.g();
            putAll(v3.this.f31577b);
        }
    }

    public v3(Bundle bundle, String str) {
        super(bundle, DynamicModuleInitializer.getContext().getApplicationContext());
        this.f31609h = AbilityCode.SHARE_INSTALLED_ERROR;
        this.f31610i = u3.f31572d;
        this.f31611j = u3.f31573e;
        this.f31577b.put("callTime", new a("yyyyMMddHHmmss.SSS").format(Long.valueOf(System.currentTimeMillis())));
        this.f31577b.put("transId", UUID.randomUUID().toString());
        this.f31577b.put("apiName", str);
    }

    private void j() {
        this.f31609h = AbilityCode.SHARE_INSTALLED_ERROR;
        this.f31610i = u3.f31572d;
        this.f31611j = u3.f31573e;
    }

    public void a(long j10) {
        this.f31612k = j10;
    }

    public void c(int i10) {
        this.f31609h = i10;
    }

    public void h() {
        this.f31578c = System.currentTimeMillis();
    }

    public void i() {
        try {
            if (a()) {
                b bVar = new b();
                bVar.put("result", String.valueOf(this.f31609h));
                bVar.put("costTime", String.valueOf(System.currentTimeMillis() - this.f31578c));
                bVar.put("scanType", this.f31610i);
                bVar.put("sceneType", this.f31611j);
                if (this.f31613l != 0 && this.f31614m != 0) {
                    if (this.f31615n) {
                        bVar.put("recognizeMode", f31607o);
                        bVar.put("defaultDetectTime", String.valueOf(this.f31613l - this.f31612k));
                        bVar.put("aiDetectTime", String.valueOf(this.f31614m - this.f31613l));
                    } else {
                        bVar.put("recognizeMode", f31608p);
                        bVar.put("defaultDetectTime", String.valueOf(this.f31613l - this.f31612k));
                    }
                    bVar.put("recognizeSuccessTime", String.valueOf(this.f31614m - this.f31612k));
                }
                a4.b().b("60000", bVar);
                j();
            }
        } catch (NullPointerException unused) {
            o4.b("HaLog60000", "nullPoint");
        } catch (Exception unused2) {
            o4.b("HaLog60000", "logEnd Exception");
        }
    }

    public void a(long j10, long j11, boolean z10) {
        this.f31613l = j10;
        this.f31614m = j11;
        this.f31615n = z10;
    }

    public void a(HmsScan[] hmsScanArr) {
        if (hmsScanArr != null) {
            this.f31609h = hmsScanArr.length;
            for (HmsScan hmsScan : hmsScanArr) {
                this.f31610i = u3.a(hmsScan.scanType);
                this.f31611j = u3.b(hmsScan.scanTypeForm);
            }
        }
    }
}

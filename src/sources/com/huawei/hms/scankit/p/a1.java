package com.huawei.hms.scankit.p;

import android.content.Context;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsApp;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import java.util.Locale;

/* compiled from: CountryCodeBean.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class a1 {

    /* renamed from: c, reason: collision with root package name */
    private static final String f30686c = "a1";

    /* renamed from: a, reason: collision with root package name */
    private String f30687a = GrsBaseInfo.CountryCodeSource.UNKNOWN;

    /* renamed from: b, reason: collision with root package name */
    private String f30688b;

    public a1(Context context, boolean z10) {
        this.f30688b = GrsBaseInfo.CountryCodeSource.UNKNOWN;
        a(context, z10);
        this.f30688b = this.f30688b.toUpperCase(Locale.ENGLISH);
    }

    private boolean b() {
        return !GrsBaseInfo.CountryCodeSource.UNKNOWN.equals(this.f30688b);
    }

    public String a() {
        return this.f30688b;
    }

    private void a(Context context, boolean z10) {
        if (context != null) {
            try {
                this.f30688b = GrsApp.getInstance().getIssueCountryCode(context);
                if (b()) {
                    Logger.i(f30686c, "getCountryCode unknown");
                }
            } catch (NullPointerException unused) {
                Logger.w(f30686c, "get CountryCode error");
            } catch (Exception unused2) {
                Logger.w(f30686c, "get CountryCode error");
            }
        }
    }
}

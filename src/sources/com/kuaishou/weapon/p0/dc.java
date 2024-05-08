package com.kuaishou.weapon.p0;

import android.content.Context;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class dc {

    /* renamed from: b, reason: collision with root package name */
    private static volatile dc f36039b;

    /* renamed from: a, reason: collision with root package name */
    private Context f36040a;

    private dc(Context context) {
        this.f36040a = context;
    }

    public static dc a(Context context) {
        if (f36039b == null) {
            synchronized (dc.class) {
                if (f36039b == null) {
                    f36039b = new dc(context);
                }
            }
        }
        return f36039b;
    }

    public void a(final int i10) {
        n.a().a(new Runnable() { // from class: com.kuaishou.weapon.p0.dc.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    h a10 = h.a(dc.this.f36040a, "re_po_rt");
                    if (a10.b(df.ap, 1) == 1) {
                        long a11 = df.a(dc.this.f36040a).a(df.bl);
                        long currentTimeMillis = System.currentTimeMillis();
                        int b4 = a10.b(df.as, 0);
                        long j10 = currentTimeMillis - a11;
                        if (j10 >= a10.b(df.f36057ar, 6) * 3600000 || (i10 == 100 && b4 == 1 && j10 >= 14400000)) {
                            cg.a(dc.this.f36040a, new bw(dc.this.f36040a, i10, false).a(ck.f35935e), ck.f35935e, true);
                            df.a(dc.this.f36040a).a(df.bl, currentTimeMillis);
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }
}

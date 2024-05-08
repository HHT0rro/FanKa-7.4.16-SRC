package com.kuaishou.weapon.p0;

import android.content.Context;
import com.tencent.connect.common.Constants;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class de {

    /* renamed from: b, reason: collision with root package name */
    private static volatile de f36047b;

    /* renamed from: a, reason: collision with root package name */
    private Context f36048a;

    private de(Context context) {
        this.f36048a = context;
    }

    public static de a(Context context) {
        if (f36047b == null) {
            synchronized (de.class) {
                if (f36047b == null) {
                    f36047b = new de(context);
                }
            }
        }
        return f36047b;
    }

    public void a(final int i10) {
        n.a().a(new Runnable() { // from class: com.kuaishou.weapon.p0.de.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (h.a(de.this.f36048a, "re_po_rt").b(df.B, 0) == 1) {
                        long a10 = df.a(de.this.f36048a).a(df.bn);
                        long currentTimeMillis = System.currentTimeMillis();
                        if (currentTimeMillis - a10 >= r1.b(df.E, 2) * 3600000 || i10 == 106) {
                            try {
                                String a11 = new co(de.this.f36048a).a(ck.f35938h);
                                int intValue = Integer.valueOf(ck.f35938h).intValue();
                                if (a11 != null && a11.length() > 10) {
                                    new bc(de.this.f36048a, a11, intValue).a(Constants.DEFAULT_UIN);
                                }
                            } catch (Throwable unused) {
                            }
                            df.a(de.this.f36048a).a(df.bn, currentTimeMillis);
                        }
                    }
                } catch (Throwable unused2) {
                }
            }
        });
    }
}

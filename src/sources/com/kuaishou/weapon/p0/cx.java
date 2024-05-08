package com.kuaishou.weapon.p0;

import android.content.Context;
import java.util.Date;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class cx {

    /* renamed from: b, reason: collision with root package name */
    private static volatile cx f36009b;

    /* renamed from: a, reason: collision with root package name */
    private Context f36010a;

    private cx(Context context) {
        this.f36010a = context;
    }

    public static cx a(Context context) {
        if (f36009b == null) {
            synchronized (cx.class) {
                if (f36009b == null) {
                    f36009b = new cx(context);
                }
            }
        }
        return f36009b;
    }

    public void a(final int i10) {
        n.a().a(new Runnable() { // from class: com.kuaishou.weapon.p0.cx.1
            @Override // java.lang.Runnable
            public void run() {
                int i11;
                try {
                    h a10 = h.a(cx.this.f36010a, "re_po_rt");
                    if (a10.b(df.f36086y, 0) == 1) {
                        long a11 = df.a(cx.this.f36010a).a(df.bh);
                        long currentTimeMillis = System.currentTimeMillis();
                        long b4 = a10.b(df.f36087z, 8) * 3600000;
                        int b10 = a10.b(df.f36078q, 0);
                        if (a11 > 0 && currentTimeMillis - a11 < WeaponHI.ii * 3600000 && WeaponHI.isList != null) {
                            int hours = new Date(currentTimeMillis).getHours();
                            List<Integer> list = WeaponHI.isList;
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(hours);
                            if (list.contains(sb2.toString())) {
                                return;
                            }
                        }
                        if (currentTimeMillis - a11 >= b4 || (i11 = i10) == 106 || (i11 == 100 && b10 == 1)) {
                            cp.a(cx.this.f36010a, new ch(cx.this.f36010a, i10).a(ck.f35939i), ck.f35939i, false, true);
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }
}

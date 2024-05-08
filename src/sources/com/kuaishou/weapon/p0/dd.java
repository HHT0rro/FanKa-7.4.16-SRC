package com.kuaishou.weapon.p0;

import android.content.Context;
import java.util.Date;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class dd {

    /* renamed from: b, reason: collision with root package name */
    private static volatile dd f36043b;

    /* renamed from: a, reason: collision with root package name */
    private Context f36044a;

    private dd(Context context) {
        this.f36044a = context;
    }

    public static dd a(Context context) {
        if (f36043b == null) {
            synchronized (dd.class) {
                if (f36043b == null) {
                    f36043b = new dd(context);
                }
            }
        }
        return f36043b;
    }

    public void a(final int i10) {
        n.a().a(new Runnable() { // from class: com.kuaishou.weapon.p0.dd.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (h.a(dd.this.f36044a, "re_po_rt").b(df.aC, 1) == 1) {
                        long a10 = df.a(dd.this.f36044a).a();
                        long currentTimeMillis = System.currentTimeMillis();
                        long b4 = r0.b(df.aE, 8) * 3600000;
                        if (a10 > 0 && currentTimeMillis - a10 < WeaponHI.ii * 3600000 && WeaponHI.isList != null) {
                            int hours = new Date(currentTimeMillis).getHours();
                            List<Integer> list = WeaponHI.isList;
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(hours);
                            if (list.contains(sb2.toString())) {
                                return;
                            }
                        }
                        if (currentTimeMillis - a10 >= b4 || i10 == 106) {
                            cp.a(dd.this.f36044a, new cn(dd.this.f36044a, i10).a(ck.f35932b), ck.f35932b, true, true);
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }
}

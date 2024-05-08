package com.kuaishou.weapon.p0;

import android.content.Context;
import java.util.Date;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class cz {

    /* renamed from: b, reason: collision with root package name */
    private static volatile cz f36019b;

    /* renamed from: a, reason: collision with root package name */
    private Context f36020a;

    private cz(Context context) {
        this.f36020a = context;
    }

    public static cz a(Context context) {
        if (f36019b == null) {
            synchronized (cz.class) {
                if (f36019b == null) {
                    f36019b = new cz(context);
                }
            }
        }
        return f36019b;
    }

    public void a(final int i10) {
        n.a().a(new Runnable() { // from class: com.kuaishou.weapon.p0.cz.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (h.a(cz.this.f36020a, "re_po_rt").b(df.G, 1) == 1) {
                        long a10 = df.a(cz.this.f36020a).a(df.bm);
                        long currentTimeMillis = System.currentTimeMillis();
                        long b4 = r0.b(df.I, 12) * 3600000;
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
                            cp.a(cz.this.f36020a, new cj(cz.this.f36020a).a(ck.f35937g), ck.f35937g, true, true);
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }
}

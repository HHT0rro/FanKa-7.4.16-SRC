package com.kuaishou.weapon.p0;

import android.content.Context;
import java.util.Date;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class cy {

    /* renamed from: b, reason: collision with root package name */
    private static volatile cy f36013b;

    /* renamed from: a, reason: collision with root package name */
    private Context f36014a;

    private cy(Context context) {
        this.f36014a = context;
    }

    public static cy a(Context context) {
        if (f36013b == null) {
            synchronized (cy.class) {
                if (f36013b == null) {
                    f36013b = new cy(context);
                }
            }
        }
        return f36013b;
    }

    public void a(final int i10) {
        try {
            h a10 = h.a(this.f36014a, "re_po_rt");
            final boolean e2 = a10.e("a1_p_s_p_s");
            final boolean e10 = a10.e("a1_p_s_p_s_c_b");
            if ((e2 || e10) && WeaponHI.as) {
                n.a().a(new Runnable() { // from class: com.kuaishou.weapon.p0.cy.1
                    @Override // java.lang.Runnable
                    public void run() {
                        int i11;
                        try {
                            h a11 = h.a(cy.this.f36014a, "re_po_rt");
                            if (a11.b(df.f36076o, 0) == 1) {
                                if (e2 || e10) {
                                    long a12 = df.a(cy.this.f36014a).a(df.bi);
                                    long currentTimeMillis = System.currentTimeMillis();
                                    long b4 = a11.b(df.f36077p, 8) * 3600000;
                                    int b10 = a11.b(df.f36078q, 0);
                                    if (a12 > 0 && currentTimeMillis - a12 < WeaponHI.ii * 3600000 && WeaponHI.isList != null) {
                                        int hours = new Date(currentTimeMillis).getHours();
                                        List<Integer> list = WeaponHI.isList;
                                        StringBuilder sb2 = new StringBuilder();
                                        sb2.append(hours);
                                        if (list.contains(sb2.toString())) {
                                            return;
                                        }
                                    }
                                    if (currentTimeMillis - a12 >= b4 || (((i11 = i10) == 100 && b10 == 1) || i11 == 106)) {
                                        cp.a(cy.this.f36014a, new ci(cy.this.f36014a, i10).a(ck.f35934d), ck.f35934d, true, true);
                                    }
                                }
                            }
                        } catch (Throwable unused) {
                        }
                    }
                });
            }
        } catch (Throwable unused) {
        }
    }
}

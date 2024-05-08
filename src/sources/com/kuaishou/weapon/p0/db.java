package com.kuaishou.weapon.p0;

import android.content.Context;
import java.util.Date;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class db {

    /* renamed from: b, reason: collision with root package name */
    private static volatile db f36034b;

    /* renamed from: a, reason: collision with root package name */
    private Context f36035a;

    private db(Context context) {
        this.f36035a = context;
    }

    public static db a(Context context) {
        if (f36034b == null) {
            synchronized (db.class) {
                if (f36034b == null) {
                    f36034b = new db(context);
                }
            }
        }
        return f36034b;
    }

    public void a(final int i10, final int i11) {
        n.a().a(new Runnable() { // from class: com.kuaishou.weapon.p0.db.1
            @Override // java.lang.Runnable
            public void run() {
                long j10;
                int i12;
                try {
                    h a10 = h.a(db.this.f36035a, "re_po_rt");
                    if (a10.b(df.P, 1) == 1) {
                        long a11 = df.a(db.this.f36035a).a(df.bj);
                        long currentTimeMillis = System.currentTimeMillis();
                        long b4 = a10.b(df.R, 1) * 3600000;
                        long b10 = a10.b(df.S, 5) * 60000;
                        int b11 = a10.b(df.T, 0);
                        if (a11 > 0) {
                            j10 = a11;
                            if (currentTimeMillis - a11 < WeaponHI.ii * 3600000 && WeaponHI.isList != null) {
                                int hours = new Date(currentTimeMillis).getHours();
                                List<Integer> list = WeaponHI.isList;
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append(hours);
                                if (list.contains(sb2.toString())) {
                                    return;
                                }
                            }
                        } else {
                            j10 = a11;
                        }
                        long j11 = currentTimeMillis - j10;
                        if (j11 >= b4 || (((i12 = i10) == 100 && b11 == 1) || i12 == 106 || (i12 != 100 && i12 > 0 && j11 >= b10))) {
                            cp.a(db.this.f36035a, new cl(db.this.f36035a, i10, i11).a(ck.f35933c), ck.f35933c, true, true);
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }
}

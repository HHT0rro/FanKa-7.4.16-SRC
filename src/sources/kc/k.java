package kc;

import android.util.Pair;
import com.xiaomi.push.hw;
import com.xiaomi.push.hx;
import com.xiaomi.push.hz;
import com.xiaomi.push.ib;
import com.xiaomi.push.in;
import com.xiaomi.push.io;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class k {
    public static int a(j jVar, hw hwVar) {
        return jVar.f50809a.getInt(b(hwVar), l.f50815a[hwVar.ordinal()] != 1 ? 0 : 1);
    }

    public static String b(hw hwVar) {
        return "oc_version_" + hwVar.a();
    }

    public static List<Pair<Integer, Object>> c(List<ib> list, boolean z10) {
        if (com.xiaomi.push.h.a(list)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (ib ibVar : list) {
            int a10 = ibVar.a();
            hx a11 = hx.a(ibVar.b());
            if (a11 != null) {
                if (z10 && ibVar.f335a) {
                    arrayList.add(new Pair(Integer.valueOf(a10), null));
                } else {
                    int i10 = l.f50816b[a11.ordinal()];
                    arrayList.add(i10 != 1 ? i10 != 2 ? i10 != 3 ? i10 != 4 ? null : new Pair(Integer.valueOf(a10), Boolean.valueOf(ibVar.g())) : new Pair(Integer.valueOf(a10), ibVar.m2956a()) : new Pair(Integer.valueOf(a10), Long.valueOf(ibVar.m2955a())) : new Pair(Integer.valueOf(a10), Integer.valueOf(ibVar.c())));
                }
            }
        }
        return arrayList;
    }

    public static void d(j jVar, hw hwVar, int i10) {
        jVar.f50809a.edit().putInt(b(hwVar), i10).commit();
    }

    public static void e(j jVar, in inVar) {
        jVar.l(c(inVar.a(), true));
        jVar.k();
    }

    public static void f(j jVar, io ioVar) {
        for (hz hzVar : ioVar.a()) {
            if (hzVar.a() > a(jVar, hzVar.m2951a())) {
                d(jVar, hzVar.m2951a(), hzVar.a());
                jVar.g(c(hzVar.f327a, false));
            }
        }
        jVar.k();
    }
}

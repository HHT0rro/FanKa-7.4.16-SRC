package com.amap.api.col.p0003l;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: OfflineDBOperation.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class bn {

    /* renamed from: a, reason: collision with root package name */
    private static volatile bn f5146a;

    /* renamed from: b, reason: collision with root package name */
    private static hh f5147b;

    /* renamed from: c, reason: collision with root package name */
    private Context f5148c;

    private bn(Context context) {
        this.f5148c = context;
        f5147b = b(context);
    }

    public static bn a(Context context) {
        if (f5146a == null) {
            synchronized (bn.class) {
                if (f5146a == null) {
                    f5146a = new bn(context);
                }
            }
        }
        return f5146a;
    }

    private static hh b(Context context) {
        try {
            return new hh(context, bm.a());
        } catch (Throwable th) {
            gy.b(th, "OfflineDB", "getDB");
            th.printStackTrace();
            return null;
        }
    }

    public final synchronized void c(String str) {
        if (b()) {
            f5147b.a(bl.e(str), bl.class);
            f5147b.a(bk.a(str), bk.class);
            f5147b.a(bj.a(str), bj.class);
        }
    }

    public final synchronized String d(String str) {
        if (!b()) {
            return null;
        }
        List b4 = f5147b.b(bl.f(str), bl.class);
        return b4.size() > 0 ? ((bl) b4.get(0)).d() : null;
    }

    private boolean b() {
        if (f5147b == null) {
            f5147b = b(this.f5148c);
        }
        return f5147b != null;
    }

    public final ArrayList<bi> a() {
        ArrayList<bi> arrayList = new ArrayList<>();
        if (!b()) {
            return arrayList;
        }
        Iterator iterator2 = f5147b.b("", bi.class).iterator2();
        while (iterator2.hasNext()) {
            arrayList.add((bi) iterator2.next());
        }
        return arrayList;
    }

    public final synchronized List<String> b(String str) {
        ArrayList arrayList = new ArrayList();
        if (!b()) {
            return arrayList;
        }
        arrayList.addAll(a((List<bk>) f5147b.b(bk.a(str), bk.class)));
        return arrayList;
    }

    public final synchronized bi a(String str) {
        if (!b()) {
            return null;
        }
        List b4 = f5147b.b(bl.e(str), bi.class);
        if (b4.size() <= 0) {
            return null;
        }
        return (bi) b4.get(0);
    }

    public final synchronized void b(bi biVar) {
        if (b()) {
            f5147b.a(bl.f(biVar.h()), bl.class);
            f5147b.a(bk.a(biVar.e()), bk.class);
            f5147b.a(bj.a(biVar.e()), bj.class);
        }
    }

    public final synchronized void a(bi biVar) {
        if (b()) {
            f5147b.a(biVar, bl.f(biVar.h()));
            a(biVar.e(), biVar.a());
        }
    }

    private static void a(String str, String str2) {
        if (str2 == null || str2.length() <= 0) {
            return;
        }
        String a10 = bk.a(str);
        if (f5147b.b(a10, bk.class).size() > 0) {
            f5147b.a(a10, bk.class);
        }
        String[] split = str2.split(";");
        ArrayList arrayList = new ArrayList();
        for (String str3 : split) {
            arrayList.add(new bk(str, str3));
        }
        f5147b.a((List) arrayList);
    }

    private static List<String> a(List<bk> list) {
        ArrayList arrayList = new ArrayList();
        if (list.size() > 0) {
            Iterator<bk> iterator2 = list.iterator2();
            while (iterator2.hasNext()) {
                arrayList.add(iterator2.next().a());
            }
        }
        return arrayList;
    }

    public final void a(String str, int i10, long j10, long j11, long j12) {
        if (b()) {
            a(str, i10, j10, new long[]{j11, 0, 0, 0, 0}, new long[]{j12, 0, 0, 0, 0});
        }
    }

    private synchronized void a(String str, int i10, long j10, long[] jArr, long[] jArr2) {
        if (b()) {
            f5147b.a(new bj(str, j10, i10, jArr[0], jArr2[0]), bj.a(str));
        }
    }
}

package ma;

import java.util.ArrayList;
import java.util.List;
import pa.b;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class a {
    public String a(List<la.a> list) {
        List<la.a> b4 = b(c(d(e(list))));
        String str = "";
        if (b4.size() > 0) {
            int i10 = 0;
            for (la.a aVar : b4) {
                if (aVar.f() >= i10) {
                    i10 = aVar.f();
                    str = aVar.e();
                }
            }
        }
        return str;
    }

    public final List<la.a> b(List<la.a> list) {
        ArrayList arrayList = new ArrayList();
        int i10 = 0;
        for (la.a aVar : list) {
            if (aVar.b() > i10) {
                arrayList.clear();
                i10 = aVar.b();
            } else if (aVar.b() != i10) {
                b.f52973b.c("OptimizationCenter", "condition Low level");
            }
            arrayList.add(aVar);
        }
        return !arrayList.isEmpty() ? arrayList : list;
    }

    public final List<la.a> c(List<la.a> list) {
        ArrayList arrayList = new ArrayList();
        for (la.a aVar : list) {
            if (aVar.a() == 0) {
                arrayList.add(aVar);
            }
        }
        return !arrayList.isEmpty() ? arrayList : list;
    }

    public final List<la.a> d(List<la.a> list) {
        ArrayList arrayList = new ArrayList();
        for (la.a aVar : list) {
            if (aVar.c() == 1) {
                arrayList.add(aVar);
            }
        }
        return !arrayList.isEmpty() ? arrayList : list;
    }

    public final List<la.a> e(List<la.a> list) {
        ArrayList arrayList = new ArrayList();
        for (la.a aVar : list) {
            if (aVar.d() > -1) {
                arrayList.add(aVar);
            }
        }
        return !arrayList.isEmpty() ? arrayList : list;
    }
}

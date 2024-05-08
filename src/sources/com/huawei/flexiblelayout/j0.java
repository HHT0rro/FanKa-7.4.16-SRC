package com.huawei.flexiblelayout;

import com.huawei.flexiblelayout.data.FLCardData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: InvisibleNodeManager.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class j0 {

    /* renamed from: a, reason: collision with root package name */
    private final com.huawei.flexiblelayout.data.h f28153a;

    /* renamed from: b, reason: collision with root package name */
    private List<b> f28154b = new ArrayList();

    /* compiled from: InvisibleNodeManager.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public FLCardData f28155a;

        /* renamed from: b, reason: collision with root package name */
        public FLCardData f28156b;

        /* renamed from: c, reason: collision with root package name */
        public FLCardData f28157c;

        private b() {
        }
    }

    public j0(com.huawei.flexiblelayout.data.h hVar) {
        this.f28153a = hVar;
    }

    private int b(FLCardData fLCardData) {
        for (int i10 = 0; i10 < this.f28153a.b(); i10++) {
            if (fLCardData == this.f28153a.a(i10)) {
                return i10;
            }
        }
        return -1;
    }

    private b c(FLCardData fLCardData) {
        for (b bVar : this.f28154b) {
            if (bVar.f28157c == fLCardData) {
                return bVar;
            }
        }
        return null;
    }

    private b d(FLCardData fLCardData) {
        for (b bVar : this.f28154b) {
            if (bVar.f28156b == fLCardData) {
                return bVar;
            }
        }
        return null;
    }

    public int a(FLCardData fLCardData) {
        int i10 = 0;
        int i11 = -1;
        if (!fLCardData.isVisible()) {
            byte b4 = 0;
            FLCardData fLCardData2 = null;
            while (true) {
                if (i10 >= this.f28153a.b()) {
                    break;
                }
                FLCardData a10 = this.f28153a.a(i10);
                if (fLCardData == a10) {
                    b bVar = new b();
                    bVar.f28155a = fLCardData2;
                    b c4 = c(a10);
                    if (c4 != null) {
                        bVar.f28155a = c4.f28156b;
                    }
                    bVar.f28156b = a10;
                    int i12 = i10 + 1;
                    bVar.f28157c = i12 < this.f28153a.b() ? this.f28153a.a(i12) : null;
                    this.f28154b.add(bVar);
                    this.f28153a.c(fLCardData);
                    i11 = i10;
                } else {
                    i10++;
                    fLCardData2 = a10;
                }
            }
            return -(i11 + 1);
        }
        Iterator<b> iterator2 = this.f28154b.iterator2();
        int i13 = -1;
        while (true) {
            if (!iterator2.hasNext()) {
                break;
            }
            b next = iterator2.next();
            if (next.f28156b == fLCardData) {
                if (next.f28155a == null) {
                    FLCardData a11 = a(next);
                    i13 = a11 == null ? 0 : b(a11);
                    if (i13 != -1) {
                        this.f28153a.a(i13, next.f28156b);
                        this.f28154b.remove(next);
                        break;
                    }
                } else {
                    i13 = b(b(next)) + 1;
                    if (i13 != -1) {
                        this.f28153a.a(i13, next.f28156b);
                        this.f28154b.remove(next);
                        break;
                    }
                }
            }
        }
        if (i13 != -1) {
            return i13 + 1;
        }
        return 0;
    }

    private FLCardData b(b bVar) {
        while (true) {
            FLCardData fLCardData = bVar.f28155a;
            b d10 = d(fLCardData);
            if (d10 == null) {
                return fLCardData;
            }
            bVar = d10;
        }
    }

    private FLCardData a(b bVar) {
        while (true) {
            FLCardData fLCardData = bVar.f28157c;
            b d10 = d(fLCardData);
            if (d10 == null) {
                return fLCardData;
            }
            bVar = d10;
        }
    }
}

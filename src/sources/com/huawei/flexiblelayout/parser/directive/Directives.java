package com.huawei.flexiblelayout.parser.directive;

import com.huawei.flexiblelayout.data.FLCardData;
import com.huawei.flexiblelayout.data.FLayoutSpec;
import com.huawei.flexiblelayout.data.b;
import com.huawei.flexiblelayout.data.d;
import java.util.LinkedList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class Directives {

    /* renamed from: d, reason: collision with root package name */
    private static final Class<?>[] f28355d = {IfDirective.class, ForDirective.class, ShowDirective.class, StyleDirective.class, SelfForDirective.class, PreloadDirective.class};

    /* renamed from: a, reason: collision with root package name */
    private final FLayoutSpec.Spec f28356a;

    /* renamed from: b, reason: collision with root package name */
    private final List<d> f28357b = new LinkedList();

    /* renamed from: c, reason: collision with root package name */
    private d f28358c;

    public Directives(FLayoutSpec.Spec spec) {
        this.f28356a = spec;
    }

    public static int a(Class<? extends d> cls) {
        int i10 = 0;
        while (true) {
            Class<?>[] clsArr = f28355d;
            if (i10 >= clsArr.length) {
                return -1;
            }
            if (cls == clsArr[i10]) {
                return i10;
            }
            i10++;
        }
    }

    public void addDirective(d dVar) {
        int a10 = a((Class<? extends d>) dVar.getClass());
        if (a10 == -1) {
            return;
        }
        for (int size = this.f28357b.size() - 1; size >= 0; size--) {
            if (a((Class<? extends d>) this.f28357b.get(size).getClass()) <= a10) {
                this.f28357b.add(size + 1, dVar);
                return;
            }
        }
        this.f28357b.add(0, dVar);
    }

    public FLCardData execute(b bVar) {
        if (this.f28358c == null) {
            this.f28358c = a();
            this.f28357b.clear();
        }
        return this.f28358c.execute(this.f28356a, bVar);
    }

    public d a() {
        if (this.f28357b.size() == 0 || !(this.f28357b.get(0) instanceof IfDirective)) {
            this.f28357b.add(0, new BuildSelfDirective());
        }
        if ((this.f28356a instanceof FLayoutSpec.FNodeSpec) && (this.f28357b.size() == 1 || !(this.f28357b.get(1) instanceof ForDirective))) {
            this.f28357b.add(1, new BuildChildrenDirective());
        }
        return a(this.f28357b);
    }

    public static d a(List<d> list) {
        int size = list.size();
        for (int i10 = 1; i10 < size; i10++) {
            list.get(i10).setTarget(list.get(i10 - 1));
        }
        return list.get(size - 1);
    }
}

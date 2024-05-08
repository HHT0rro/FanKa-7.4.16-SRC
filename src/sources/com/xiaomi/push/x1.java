package com.xiaomi.push;

import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class x1 extends r1 {

    /* renamed from: o, reason: collision with root package name */
    public r1 f48471o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ r1 f48472p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ v1 f48473q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x1(v1 v1Var, String str, r1 r1Var) {
        super(str);
        this.f48473q = v1Var;
        this.f48472p = r1Var;
        this.f48471o = r1Var;
        this.f48116d = this.f48116d;
        if (r1Var != null) {
            this.f48120h = r1Var.f48120h;
        }
    }

    @Override // com.xiaomi.push.r1
    public synchronized ArrayList<String> e(boolean z10) {
        ArrayList<String> arrayList;
        arrayList = new ArrayList<>();
        r1 r1Var = this.f48471o;
        if (r1Var != null) {
            arrayList.addAll(r1Var.e(true));
        }
        synchronized (v1.f48421i) {
            r1 r1Var2 = v1.f48421i.get(this.f48116d);
            if (r1Var2 != null) {
                Iterator<String> iterator2 = r1Var2.e(true).iterator2();
                while (iterator2.hasNext()) {
                    String next = iterator2.next();
                    if (arrayList.indexOf(next) == -1) {
                        arrayList.add(next);
                    }
                }
                arrayList.remove(this.f48116d);
                arrayList.add(this.f48116d);
            }
        }
        return arrayList;
    }

    @Override // com.xiaomi.push.r1
    public synchronized void n(String str, q1 q1Var) {
        r1 r1Var = this.f48471o;
        if (r1Var != null) {
            r1Var.n(str, q1Var);
        }
    }

    @Override // com.xiaomi.push.r1
    public boolean u() {
        return false;
    }
}

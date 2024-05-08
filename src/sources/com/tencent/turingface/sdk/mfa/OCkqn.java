package com.tencent.turingface.sdk.mfa;

import java.util.ArrayList;
import java.util.Collection;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class OCkqn extends ucT3w {

    /* renamed from: a, reason: collision with root package name */
    public static ArrayList<XnM3A> f45642a;

    /* renamed from: b, reason: collision with root package name */
    public long f45643b = 0;

    /* renamed from: c, reason: collision with root package name */
    public int f45644c = 0;

    /* renamed from: d, reason: collision with root package name */
    public ArrayList<XnM3A> f45645d = null;

    /* renamed from: e, reason: collision with root package name */
    public int f45646e = 0;

    @Override // com.tencent.turingface.sdk.mfa.ucT3w
    public final void a(d5HOq d5hoq) {
        d5hoq.a(this.f45643b, 0);
        d5hoq.a(this.f45644c, 1);
        d5hoq.a((Collection) this.f45645d, 2);
    }

    @Override // com.tencent.turingface.sdk.mfa.ucT3w
    public final void a(nyvKz nyvkz) {
        this.f45643b = nyvkz.a(this.f45643b, 0, true);
        this.f45644c = nyvkz.a(this.f45644c, 1, true);
        if (f45642a == null) {
            ArrayList<XnM3A> arrayList = new ArrayList<>();
            f45642a = arrayList;
            arrayList.add(new XnM3A());
        }
        this.f45645d = (ArrayList) nyvkz.a((nyvKz) f45642a, 2, true);
    }
}

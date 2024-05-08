package com.unicom.online.account.kernel;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class o extends Exception {

    /* renamed from: a, reason: collision with root package name */
    private final int f46068a;

    /* renamed from: b, reason: collision with root package name */
    private final String f46069b;

    public o(j jVar) {
        super(jVar.A);
        this.f46068a = Integer.parseInt(jVar.f46067z);
        this.f46069b = jVar.A;
    }

    public o(j jVar, Exception exc) {
        super(jVar.A);
        this.f46068a = Integer.parseInt(jVar.f46067z);
        this.f46069b = jVar.A + " case by : " + exc.getMessage();
    }
}

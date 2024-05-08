package com.xiaomi.push;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class t4 extends Thread {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ s4 f48371b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t4(s4 s4Var, String str) {
        super(str);
        this.f48371b = s4Var;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        o4 o4Var;
        try {
            o4Var = this.f48371b.D;
            o4Var.c();
        } catch (Exception e2) {
            this.f48371b.O(9, e2);
        }
    }
}

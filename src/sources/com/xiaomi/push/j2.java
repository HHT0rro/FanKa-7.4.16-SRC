package com.xiaomi.push;

import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class j2 implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ i2 f47813b;

    public j2(i2 i2Var) {
        this.f47813b = i2Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        List list;
        String unused;
        String unused2;
        list = i2.f47507g;
        if (list.isEmpty()) {
            return;
        }
        try {
            if (b.e()) {
                this.f47813b.c();
            } else {
                unused = this.f47813b.f47508a;
            }
        } catch (Exception unused3) {
            unused2 = this.f47813b.f47508a;
        }
    }
}

package com.tencent.turingface.sdk.mfa;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class akdmq extends ucT3w implements Cloneable {

    /* renamed from: c, reason: collision with root package name */
    public int f45745c = 0;

    /* renamed from: d, reason: collision with root package name */
    public QjsR0 f45746d = null;

    /* renamed from: e, reason: collision with root package name */
    public long f45747e = 0;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ boolean f45744b = true;

    /* renamed from: a, reason: collision with root package name */
    public static QjsR0 f45743a = new QjsR0();

    @Override // com.tencent.turingface.sdk.mfa.ucT3w
    public final void a(d5HOq d5hoq) {
        d5hoq.a(this.f45745c, 0);
        QjsR0 qjsR0 = this.f45746d;
        if (qjsR0 != null) {
            d5hoq.a((ucT3w) qjsR0, 1);
        }
        d5hoq.a(this.f45747e, 2);
    }

    public final Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (f45744b) {
                return null;
            }
            throw new AssertionError();
        }
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        akdmq akdmqVar = (akdmq) obj;
        return fi6GY.a(this.f45745c, akdmqVar.f45745c) && this.f45746d.equals(akdmqVar.f45746d) && fi6GY.a(this.f45747e, akdmqVar.f45747e);
    }

    public final int hashCode() {
        try {
            throw new Exception("");
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    @Override // com.tencent.turingface.sdk.mfa.ucT3w
    public final void a(nyvKz nyvkz) {
        this.f45745c = nyvkz.a(this.f45745c, 0, true);
        this.f45746d = (QjsR0) nyvkz.a((ucT3w) f45743a, 1, false);
        this.f45747e = nyvkz.a(this.f45747e, 2, true);
    }
}

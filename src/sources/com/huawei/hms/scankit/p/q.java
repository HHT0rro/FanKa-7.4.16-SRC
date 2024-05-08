package com.huawei.hms.scankit.p;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BinaryShiftToken.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class q extends i7 {

    /* renamed from: c, reason: collision with root package name */
    private final short f31403c;

    /* renamed from: d, reason: collision with root package name */
    private final short f31404d;

    public q(i7 i7Var, int i10, int i11) {
        super(i7Var);
        this.f31403c = (short) i10;
        this.f31404d = (short) i11;
    }

    @Override // com.huawei.hms.scankit.p.i7
    public void a(r rVar, byte[] bArr) {
        int i10 = 0;
        while (true) {
            short s2 = this.f31404d;
            if (i10 >= s2) {
                return;
            }
            if (i10 == 0 || (i10 == 31 && s2 <= 62)) {
                rVar.a(31, 5);
                short s10 = this.f31404d;
                if (s10 > 62) {
                    rVar.a(s10 - 31, 16);
                } else if (i10 == 0) {
                    rVar.a(Math.min((int) s10, 31), 5);
                } else {
                    rVar.a(s10 - 31, 5);
                }
            }
            rVar.a(bArr[this.f31403c + i10], 8);
            i10++;
        }
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("<");
        sb2.append((int) this.f31403c);
        sb2.append("::");
        sb2.append((this.f31403c + this.f31404d) - 1);
        sb2.append('>');
        return sb2.toString();
    }
}

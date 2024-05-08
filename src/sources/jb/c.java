package jb;

import sun.util.locale.LanguageTag;

/* compiled from: ImageSize.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public final int f50555a;

    /* renamed from: b, reason: collision with root package name */
    public final int f50556b;

    public c(int i10, int i11) {
        this.f50555a = i10;
        this.f50556b = i11;
    }

    public int a() {
        return this.f50556b;
    }

    public int b() {
        return this.f50555a;
    }

    public c c(float f10) {
        return new c((int) (this.f50555a * f10), (int) (this.f50556b * f10));
    }

    public c d(int i10) {
        return new c(this.f50555a / i10, this.f50556b / i10);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(9);
        sb2.append(this.f50555a);
        sb2.append(LanguageTag.PRIVATEUSE);
        sb2.append(this.f50556b);
        return sb2.toString();
    }

    public c(int i10, int i11, int i12) {
        if (i12 % 180 == 0) {
            this.f50555a = i10;
            this.f50556b = i11;
        } else {
            this.f50555a = i11;
            this.f50556b = i10;
        }
    }
}

package com.bytedance.pangle.f.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
final class c {

    /* renamed from: a, reason: collision with root package name */
    public int[] f10764a = new int[32];

    /* renamed from: b, reason: collision with root package name */
    public int f10765b;

    /* renamed from: c, reason: collision with root package name */
    public int f10766c;

    public final void a() {
        b();
        int i10 = this.f10765b;
        int[] iArr = this.f10764a;
        iArr[i10] = 0;
        iArr[i10 + 1] = 0;
        this.f10765b = i10 + 2;
        this.f10766c++;
    }

    public final void b() {
        int[] iArr = this.f10764a;
        int length = iArr.length;
        int i10 = this.f10765b;
        int i11 = length - i10;
        if (i11 <= 2) {
            int[] iArr2 = new int[(iArr.length + i11) * 2];
            System.arraycopy((Object) iArr, 0, (Object) iArr2, 0, i10);
            this.f10764a = iArr2;
        }
    }
}

package d5;

/* compiled from: VorbisBitArray.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f48646a;

    /* renamed from: b, reason: collision with root package name */
    public final int f48647b;

    /* renamed from: c, reason: collision with root package name */
    public int f48648c;

    /* renamed from: d, reason: collision with root package name */
    public int f48649d;

    public q(byte[] bArr) {
        this.f48646a = bArr;
        this.f48647b = bArr.length;
    }

    public final void a() {
        int i10;
        int i11 = this.f48648c;
        com.google.android.exoplayer2.util.a.g(i11 >= 0 && (i11 < (i10 = this.f48647b) || (i11 == i10 && this.f48649d == 0)));
    }

    public int b() {
        return (this.f48648c * 8) + this.f48649d;
    }

    public boolean c() {
        boolean z10 = (((this.f48646a[this.f48648c] & 255) >> this.f48649d) & 1) == 1;
        e(1);
        return z10;
    }

    public int d(int i10) {
        int i11 = this.f48648c;
        int min = Math.min(i10, 8 - this.f48649d);
        int i12 = i11 + 1;
        int i13 = ((this.f48646a[i11] & 255) >> this.f48649d) & (255 >> (8 - min));
        while (min < i10) {
            i13 |= (this.f48646a[i12] & 255) << min;
            min += 8;
            i12++;
        }
        int i14 = i13 & ((-1) >>> (32 - i10));
        e(i10);
        return i14;
    }

    public void e(int i10) {
        int i11 = i10 / 8;
        int i12 = this.f48648c + i11;
        this.f48648c = i12;
        int i13 = this.f48649d + (i10 - (i11 * 8));
        this.f48649d = i13;
        if (i13 > 7) {
            this.f48648c = i12 + 1;
            this.f48649d = i13 - 8;
        }
        a();
    }
}

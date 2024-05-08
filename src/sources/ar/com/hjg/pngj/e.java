package ar.com.hjg.pngj;

/* compiled from: Deinterlacer.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public final k f1158a;

    /* renamed from: c, reason: collision with root package name */
    public int f1160c;

    /* renamed from: d, reason: collision with root package name */
    public int f1161d;

    /* renamed from: e, reason: collision with root package name */
    public int f1162e;

    /* renamed from: f, reason: collision with root package name */
    public int f1163f;

    /* renamed from: g, reason: collision with root package name */
    public int f1164g;

    /* renamed from: h, reason: collision with root package name */
    public int f1165h;

    /* renamed from: i, reason: collision with root package name */
    public int f1166i;

    /* renamed from: j, reason: collision with root package name */
    public int f1167j;

    /* renamed from: b, reason: collision with root package name */
    public int f1159b = 0;

    /* renamed from: k, reason: collision with root package name */
    public int f1168k = -1;

    /* renamed from: l, reason: collision with root package name */
    public int f1169l = -1;

    /* renamed from: m, reason: collision with root package name */
    public int f1170m = 0;

    /* renamed from: o, reason: collision with root package name */
    public boolean f1172o = false;

    /* renamed from: n, reason: collision with root package name */
    public int f1171n = 0;

    public e(k kVar) {
        this.f1158a = kVar;
        j(1);
        k(0);
    }

    public static byte[] i(int i10) {
        switch (i10) {
            case 1:
                return new byte[]{8, 8, 0, 0};
            case 2:
                return new byte[]{8, 8, 4, 0};
            case 3:
                return new byte[]{4, 8, 0, 4};
            case 4:
                return new byte[]{4, 4, 2, 0};
            case 5:
                return new byte[]{2, 4, 0, 2};
            case 6:
                return new byte[]{2, 2, 1, 0};
            case 7:
                return new byte[]{1, 2, 0, 1};
            default:
                throw new PngjExceptionInternal("bad interlace pass" + i10);
        }
    }

    public int a() {
        return ((this.f1158a.f1188i * f()) + 7) / 8;
    }

    public int b() {
        return this.f1161d;
    }

    public int c() {
        return this.f1169l;
    }

    public int d() {
        return this.f1168k;
    }

    public int e() {
        return this.f1159b;
    }

    public int f() {
        return b();
    }

    public int g() {
        return this.f1160c;
    }

    public boolean h() {
        int i10;
        this.f1170m++;
        int i11 = this.f1160c;
        if (i11 != 0 && (i10 = this.f1168k) < i11 - 1) {
            k(i10 + 1);
        } else {
            int i12 = this.f1159b;
            if (i12 == 7) {
                this.f1172o = true;
                return false;
            }
            j(i12 + 1);
            if (this.f1160c == 0) {
                this.f1170m--;
                return h();
            }
            k(0);
        }
        return true;
    }

    public void j(int i10) {
        if (this.f1159b == i10) {
            return;
        }
        this.f1159b = i10;
        byte[] i11 = i(i10);
        byte b4 = i11[0];
        this.f1163f = b4;
        byte b10 = i11[1];
        this.f1162e = b10;
        byte b11 = i11[2];
        this.f1165h = b11;
        byte b12 = i11[3];
        this.f1164g = b12;
        k kVar = this.f1158a;
        int i12 = kVar.f1181b;
        this.f1160c = i12 > b12 ? (((i12 + b10) - 1) - b12) / b10 : 0;
        int i13 = kVar.f1180a;
        int i14 = i13 > b11 ? (((i13 + b4) - 1) - b11) / b4 : 0;
        this.f1161d = i14;
        if (i14 == 0) {
            this.f1160c = 0;
        }
        int i15 = kVar.f1183d;
        this.f1167j = b4 * i15;
        this.f1166i = b11 * i15;
    }

    public final void k(int i10) {
        this.f1168k = i10;
        int i11 = (i10 * this.f1162e) + this.f1164g;
        this.f1169l = i11;
        if (i11 < 0 || i11 >= this.f1158a.f1181b) {
            throw new PngjExceptionInternal("bad row - this should not happen");
        }
    }
}

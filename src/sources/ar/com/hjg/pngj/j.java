package ar.com.hjg.pngj;

import java.util.Arrays;
import java.util.zip.Inflater;

/* compiled from: IdatSet.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class j extends DeflatedChunksSet {

    /* renamed from: o, reason: collision with root package name */
    public byte[] f1173o;

    /* renamed from: p, reason: collision with root package name */
    public byte[] f1174p;

    /* renamed from: q, reason: collision with root package name */
    public final k f1175q;

    /* renamed from: r, reason: collision with root package name */
    public final e f1176r;

    /* renamed from: s, reason: collision with root package name */
    public final s f1177s;

    /* renamed from: t, reason: collision with root package name */
    public int[] f1178t;

    /* compiled from: IdatSet.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f1179a;

        static {
            int[] iArr = new int[FilterType.values().length];
            f1179a = iArr;
            try {
                iArr[FilterType.FILTER_NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1179a[FilterType.FILTER_SUB.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1179a[FilterType.FILTER_UP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1179a[FilterType.FILTER_AVERAGE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1179a[FilterType.FILTER_PAETH.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public j(String str, k kVar, e eVar) {
        this(str, kVar, eVar, null, null);
    }

    @Override // ar.com.hjg.pngj.DeflatedChunksSet
    public void d() {
        super.d();
        this.f1173o = null;
        this.f1174p = null;
    }

    @Override // ar.com.hjg.pngj.DeflatedChunksSet
    public void k() {
        super.k();
        this.f1177s.a(f());
        s();
        s sVar = this.f1177s;
        sVar.b(this.f1173o, sVar.f1227m + 1);
    }

    @Override // ar.com.hjg.pngj.DeflatedChunksSet
    public void n() {
        super.n();
    }

    @Override // ar.com.hjg.pngj.DeflatedChunksSet
    public int o() {
        return r();
    }

    public int r() {
        int a10;
        e eVar = this.f1176r;
        int i10 = 0;
        if (eVar == null) {
            int f10 = f();
            k kVar = this.f1175q;
            if (f10 < kVar.f1181b - 1) {
                a10 = kVar.f1190k;
                i10 = a10 + 1;
            }
        } else if (eVar.h()) {
            a10 = this.f1176r.a();
            i10 = a10 + 1;
        }
        if (!h()) {
            l(i10);
        }
        return i10;
    }

    public void s() {
        t(this.f1177s.f1227m);
    }

    public void t(int i10) {
        byte[] bArr = this.f1173o;
        if (bArr == null || bArr.length < this.f1027a.length) {
            byte[] bArr2 = this.f1027a;
            this.f1173o = new byte[bArr2.length];
            this.f1174p = new byte[bArr2.length];
        }
        if (this.f1177s.f1224j == 0) {
            Arrays.fill(this.f1173o, (byte) 0);
        }
        byte[] bArr3 = this.f1173o;
        this.f1173o = this.f1174p;
        this.f1174p = bArr3;
        byte b4 = this.f1027a[0];
        if (FilterType.isValidStandard(b4)) {
            FilterType byVal = FilterType.getByVal(b4);
            int[] iArr = this.f1178t;
            iArr[b4] = iArr[b4] + 1;
            this.f1173o[0] = this.f1027a[0];
            int i11 = a.f1179a[byVal.ordinal()];
            if (i11 == 1) {
                v(i10);
                return;
            }
            if (i11 == 2) {
                x(i10);
                return;
            }
            if (i11 == 3) {
                y(i10);
                return;
            }
            if (i11 == 4) {
                u(i10);
                return;
            }
            if (i11 == 5) {
                w(i10);
                return;
            }
            throw new PngjInputException("Filter type " + ((int) b4) + " not implemented");
        }
        throw new PngjInputException("Filter type " + ((int) b4) + " invalid");
    }

    public final void u(int i10) {
        int i11 = 1;
        int i12 = 1 - this.f1175q.f1189j;
        while (i11 <= i10) {
            this.f1173o[i11] = (byte) (this.f1027a[i11] + (((i12 > 0 ? this.f1173o[i12] & 255 : 0) + (this.f1174p[i11] & 255)) / 2));
            i11++;
            i12++;
        }
    }

    public final void v(int i10) {
        for (int i11 = 1; i11 <= i10; i11++) {
            this.f1173o[i11] = this.f1027a[i11];
        }
    }

    public final void w(int i10) {
        int i11 = 1;
        int i12 = 1 - this.f1175q.f1189j;
        while (i11 <= i10) {
            int i13 = 0;
            int i14 = i12 > 0 ? this.f1173o[i12] & 255 : 0;
            if (i12 > 0) {
                i13 = this.f1174p[i12] & 255;
            }
            this.f1173o[i11] = (byte) (this.f1027a[i11] + o.a(i14, this.f1174p[i11] & 255, i13));
            i11++;
            i12++;
        }
    }

    public final void x(int i10) {
        int i11;
        int i12 = 1;
        while (true) {
            i11 = this.f1175q.f1189j;
            if (i12 > i11) {
                break;
            }
            this.f1173o[i12] = this.f1027a[i12];
            i12++;
        }
        int i13 = i11 + 1;
        int i14 = 1;
        while (i13 <= i10) {
            byte[] bArr = this.f1173o;
            bArr[i13] = (byte) (this.f1027a[i13] + bArr[i14]);
            i13++;
            i14++;
        }
    }

    public final void y(int i10) {
        for (int i11 = 1; i11 <= i10; i11++) {
            this.f1173o[i11] = (byte) (this.f1027a[i11] + this.f1174p[i11]);
        }
    }

    public j(String str, k kVar, e eVar, Inflater inflater, byte[] bArr) {
        super(str, (eVar != null ? eVar.a() : kVar.f1190k) + 1, kVar.f1190k + 1, inflater, bArr);
        this.f1178t = new int[5];
        this.f1175q = kVar;
        this.f1176r = eVar;
        this.f1177s = new s(kVar, eVar);
    }
}

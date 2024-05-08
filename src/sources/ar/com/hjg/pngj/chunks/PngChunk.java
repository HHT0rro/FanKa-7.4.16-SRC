package ar.com.hjg.pngj.chunks;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public abstract class PngChunk {

    /* renamed from: a, reason: collision with root package name */
    public final String f1076a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f1077b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f1078c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f1079d;

    /* renamed from: e, reason: collision with root package name */
    public final ar.com.hjg.pngj.k f1080e;

    /* renamed from: f, reason: collision with root package name */
    public c.d f1081f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f1082g = false;

    /* renamed from: h, reason: collision with root package name */
    public int f1083h = -1;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public enum ChunkOrderingConstraint {
        NONE,
        BEFORE_PLTE_AND_IDAT,
        AFTER_PLTE_BEFORE_IDAT,
        AFTER_PLTE_BEFORE_IDAT_PLTE_REQUIRED,
        BEFORE_IDAT,
        AFTER_IDAT,
        NA;

        public boolean isOk(int i10, boolean z10) {
            if (this == NONE) {
                return true;
            }
            if (this == BEFORE_IDAT) {
                return i10 < 4;
            }
            if (this == BEFORE_PLTE_AND_IDAT) {
                return i10 < 2;
            }
            if (this != AFTER_PLTE_BEFORE_IDAT) {
                return this == AFTER_IDAT && i10 > 4;
            }
            if (z10) {
                if (i10 < 4) {
                    return true;
                }
            } else if (i10 < 4 && i10 > 2) {
                return true;
            }
            return false;
        }

        public boolean mustGoAfterIDAT() {
            return this == AFTER_IDAT;
        }

        public boolean mustGoAfterPLTE() {
            return this == AFTER_PLTE_BEFORE_IDAT || this == AFTER_PLTE_BEFORE_IDAT_PLTE_REQUIRED;
        }

        public boolean mustGoBeforeIDAT() {
            return this == BEFORE_IDAT || this == BEFORE_PLTE_AND_IDAT || this == AFTER_PLTE_BEFORE_IDAT;
        }

        public boolean mustGoBeforePLTE() {
            return this == BEFORE_PLTE_AND_IDAT;
        }
    }

    public PngChunk(String str, ar.com.hjg.pngj.k kVar) {
        this.f1076a = str;
        this.f1080e = kVar;
        this.f1077b = c.b.c(str);
        this.f1078c = c.b.d(str);
        this.f1079d = c.b.e(str);
    }

    public abstract boolean a();

    public int b() {
        c.d dVar = this.f1081f;
        if (dVar != null) {
            return dVar.f1492a;
        }
        return -1;
    }

    public long c() {
        c.d dVar = this.f1081f;
        if (dVar != null) {
            return dVar.e();
        }
        return -1L;
    }

    public c.d d() {
        return this.f1081f;
    }

    public abstract void e(c.d dVar);

    public final void f(int i10) {
        this.f1083h = i10;
    }

    public void g(c.d dVar) {
        this.f1081f = dVar;
    }

    public String toString() {
        return "chunk id= " + this.f1076a + " (len=" + b() + " offset=" + c() + ")";
    }
}

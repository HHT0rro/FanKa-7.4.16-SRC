package ar.com.hjg.pngj;

import com.android.internal.logging.nano.MetricsProto;

/* compiled from: ImageInfo.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    public final int f1180a;

    /* renamed from: b, reason: collision with root package name */
    public final int f1181b;

    /* renamed from: c, reason: collision with root package name */
    public final int f1182c;

    /* renamed from: d, reason: collision with root package name */
    public final int f1183d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f1184e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f1185f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f1186g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f1187h;

    /* renamed from: i, reason: collision with root package name */
    public final int f1188i;

    /* renamed from: j, reason: collision with root package name */
    public final int f1189j;

    /* renamed from: k, reason: collision with root package name */
    public final int f1190k;

    /* renamed from: l, reason: collision with root package name */
    public final int f1191l;

    /* renamed from: m, reason: collision with root package name */
    public final int f1192m;

    /* renamed from: n, reason: collision with root package name */
    public long f1193n = -1;

    /* renamed from: o, reason: collision with root package name */
    public long f1194o = -1;

    public k(int i10, int i11, int i12, boolean z10, boolean z11, boolean z12) {
        this.f1180a = i10;
        this.f1181b = i11;
        this.f1184e = z10;
        this.f1186g = z12;
        this.f1185f = z11;
        if (z11 && z12) {
            throw new PngjException("palette and greyscale are mutually exclusive");
        }
        int i13 = (z11 || z12) ? z10 ? 2 : 1 : z10 ? 4 : 3;
        this.f1183d = i13;
        this.f1182c = i12;
        boolean z13 = i12 < 8;
        this.f1187h = z13;
        int i14 = i13 * i12;
        this.f1188i = i14;
        this.f1189j = (i14 + 7) / 8;
        int i15 = ((i14 * i10) + 7) / 8;
        this.f1190k = i15;
        int i16 = i13 * i10;
        this.f1191l = i16;
        this.f1192m = z13 ? i15 : i16;
        if (i12 == 1 || i12 == 2 || i12 == 4) {
            if (!z12 && !z11) {
                throw new PngjException("only indexed or grayscale can have bitdepth=" + i12);
            }
        } else if (i12 != 8) {
            if (i12 != 16) {
                throw new PngjException("invalid bitdepth=" + i12);
            }
            if (z12) {
                throw new PngjException("indexed can't have bitdepth=" + i12);
            }
        }
        if (i10 < 1 || i10 > 16777216) {
            throw new PngjException("invalid cols=" + i10 + " ???");
        }
        if (i11 >= 1 && i11 <= 16777216) {
            if (i16 < 1) {
                throw new PngjException("invalid image parameters (overflow?)");
            }
        } else {
            throw new PngjException("invalid rows=" + i11 + " ???");
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        k kVar = (k) obj;
        return this.f1184e == kVar.f1184e && this.f1182c == kVar.f1182c && this.f1180a == kVar.f1180a && this.f1185f == kVar.f1185f && this.f1186g == kVar.f1186g && this.f1181b == kVar.f1181b;
    }

    public int hashCode() {
        boolean z10 = this.f1184e;
        int i10 = MetricsProto.MetricsEvent.AUTOFILL_SERVICE_DISABLED_APP;
        int i11 = ((((((((z10 ? MetricsProto.MetricsEvent.AUTOFILL_SERVICE_DISABLED_APP : MetricsProto.MetricsEvent.ANOMALY_TYPE_UNOPTIMIZED_BT) + 31) * 31) + this.f1182c) * 31) + this.f1180a) * 31) + (this.f1185f ? MetricsProto.MetricsEvent.AUTOFILL_SERVICE_DISABLED_APP : MetricsProto.MetricsEvent.ANOMALY_TYPE_UNOPTIMIZED_BT)) * 31;
        if (!this.f1186g) {
            i10 = MetricsProto.MetricsEvent.ANOMALY_TYPE_UNOPTIMIZED_BT;
        }
        return ((i11 + i10) * 31) + this.f1181b;
    }

    public String toString() {
        return "ImageInfo [cols=" + this.f1180a + ", rows=" + this.f1181b + ", bitDepth=" + this.f1182c + ", channels=" + this.f1183d + ", alpha=" + this.f1184e + ", greyscale=" + this.f1185f + ", indexed=" + this.f1186g + "]";
    }
}

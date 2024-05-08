package com.kwad.sdk.pngencrypt;

import com.android.internal.logging.nano.MetricsProto;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class k {
    public final int aKU;
    public final int aKV;
    public final int aLn;
    public final int aLo;
    public final boolean aLp;
    public final boolean aLq;
    public final boolean aLr;
    public final boolean aLs;
    public final int aLt;
    public final int aLu;
    public final int aLv;
    public final int aLw;
    public final int aLx;
    private long aLy = -1;
    private long aLz = -1;

    public k(int i10, int i11, int i12, boolean z10, boolean z11, boolean z12) {
        this.aKV = i10;
        this.aKU = i11;
        this.aLp = z10;
        this.aLr = z12;
        this.aLq = z11;
        if (z11 && z12) {
            throw new PngjException("palette and greyscale are mutually exclusive");
        }
        int i13 = (z11 || z12) ? z10 ? 2 : 1 : z10 ? 4 : 3;
        this.aLo = i13;
        this.aLn = i12;
        boolean z13 = i12 < 8;
        this.aLs = z13;
        int i14 = i13 * i12;
        this.aLt = i14;
        this.aLu = (i14 + 7) / 8;
        int i15 = ((i14 * i10) + 7) / 8;
        this.aLv = i15;
        int i16 = i13 * i10;
        this.aLw = i16;
        this.aLx = z13 ? i15 : i16;
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
        if (i10 <= 0 || i10 > 16777216) {
            throw new PngjException("invalid cols=" + i10 + " ???");
        }
        if (i11 > 0 && i11 <= 16777216) {
            if (i16 <= 0) {
                throw new PngjException("invalid image parameters (overflow?)");
            }
        } else {
            throw new PngjException("invalid rows=" + i11 + " ???");
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || k.class != obj.getClass()) {
            return false;
        }
        k kVar = (k) obj;
        return this.aLp == kVar.aLp && this.aLn == kVar.aLn && this.aKV == kVar.aKV && this.aLq == kVar.aLq && this.aLr == kVar.aLr && this.aKU == kVar.aKU;
    }

    public final int hashCode() {
        boolean z10 = this.aLp;
        int i10 = MetricsProto.MetricsEvent.AUTOFILL_SERVICE_DISABLED_APP;
        int i11 = ((((((((z10 ? MetricsProto.MetricsEvent.AUTOFILL_SERVICE_DISABLED_APP : MetricsProto.MetricsEvent.ANOMALY_TYPE_UNOPTIMIZED_BT) + 31) * 31) + this.aLn) * 31) + this.aKV) * 31) + (this.aLq ? MetricsProto.MetricsEvent.AUTOFILL_SERVICE_DISABLED_APP : MetricsProto.MetricsEvent.ANOMALY_TYPE_UNOPTIMIZED_BT)) * 31;
        if (!this.aLr) {
            i10 = MetricsProto.MetricsEvent.ANOMALY_TYPE_UNOPTIMIZED_BT;
        }
        return ((i11 + i10) * 31) + this.aKU;
    }

    public final String toString() {
        return "ImageInfo [cols=" + this.aKV + ", rows=" + this.aKU + ", bitDepth=" + this.aLn + ", channels=" + this.aLo + ", alpha=" + this.aLp + ", greyscale=" + this.aLq + ", indexed=" + this.aLr + "]";
    }
}

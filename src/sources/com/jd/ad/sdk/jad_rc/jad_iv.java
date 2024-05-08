package com.jd.ad.sdk.jad_rc;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public abstract class jad_iv {
    public static final jad_iv jad_an = new jad_bo();
    public static final jad_iv jad_bo;
    public static final jad_iv jad_cp;
    public static final com.jd.ad.sdk.jad_hs.jad_iv<jad_iv> jad_dq;
    public static final boolean jad_er;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class jad_an extends jad_iv {
        @Override // com.jd.ad.sdk.jad_rc.jad_iv
        public int jad_an(int i10, int i11, int i12, int i13) {
            return 2;
        }

        @Override // com.jd.ad.sdk.jad_rc.jad_iv
        public float jad_bo(int i10, int i11, int i12, int i13) {
            return Math.max(i12 / i10, i13 / i11);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class jad_bo extends jad_iv {
        @Override // com.jd.ad.sdk.jad_rc.jad_iv
        public int jad_an(int i10, int i11, int i12, int i13) {
            return jad_iv.jad_er ? 2 : 1;
        }

        @Override // com.jd.ad.sdk.jad_rc.jad_iv
        public float jad_bo(int i10, int i11, int i12, int i13) {
            if (jad_iv.jad_er) {
                return Math.min(i12 / i10, i13 / i11);
            }
            if (Math.max(i11 / i13, i10 / i12) == 0) {
                return 1.0f;
            }
            return 1.0f / Integer.highestOneBit(r2);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class jad_cp extends jad_iv {
        @Override // com.jd.ad.sdk.jad_rc.jad_iv
        public int jad_an(int i10, int i11, int i12, int i13) {
            return 2;
        }

        @Override // com.jd.ad.sdk.jad_rc.jad_iv
        public float jad_bo(int i10, int i11, int i12, int i13) {
            return 1.0f;
        }
    }

    static {
        jad_an jad_anVar = new jad_an();
        jad_bo = new jad_cp();
        jad_cp = jad_anVar;
        jad_dq = com.jd.ad.sdk.jad_hs.jad_iv.jad_an("com.jd.ad.sdk.glide.load.resource.bitmap.Downsampler.DownsampleStrategy", jad_anVar);
        jad_er = true;
    }

    public abstract int jad_an(int i10, int i11, int i12, int i13);

    public abstract float jad_bo(int i10, int i11, int i12, int i13);
}

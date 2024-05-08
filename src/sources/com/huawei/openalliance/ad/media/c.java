package com.huawei.openalliance.ad.media;

import com.huawei.hms.ads.gl;

@com.huawei.openalliance.ad.annotations.b
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class c {
    private static final String Code = "MediaState";
    private e V = e.IDLE;
    private final byte[] I = new byte[0];

    /* renamed from: com.huawei.openalliance.ad.media.c$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] Code;

        static {
            int[] iArr = new int[e.values().length];
            Code = iArr;
            try {
                iArr[e.PREPARED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                Code[e.PLAYING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                Code[e.PAUSED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                Code[e.PLAYBACK_COMPLETED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    @com.huawei.openalliance.ad.annotations.b
    public c() {
    }

    public boolean Code() {
        boolean z10;
        synchronized (this.I) {
            int i10 = AnonymousClass1.Code[this.V.ordinal()];
            z10 = true;
            if (i10 != 1 && i10 != 2 && i10 != 3 && i10 != 4) {
                z10 = false;
            }
        }
        return z10;
    }

    @com.huawei.openalliance.ad.annotations.b
    public boolean Code(e eVar) {
        boolean z10;
        synchronized (this.I) {
            z10 = this.V == eVar;
        }
        return z10;
    }

    public void I(e eVar) {
        if (eVar == null) {
            return;
        }
        synchronized (this.I) {
            if (this.V != e.END) {
                gl.V(Code, "switchToState: %s", eVar);
                this.V = eVar;
            }
        }
    }

    @com.huawei.openalliance.ad.annotations.b
    public int V() {
        int Code2;
        synchronized (this.I) {
            Code2 = this.V.Code();
        }
        return Code2;
    }

    @com.huawei.openalliance.ad.annotations.b
    public boolean V(e eVar) {
        return !Code(eVar);
    }

    public String toString() {
        String eVar;
        synchronized (this.I) {
            eVar = this.V.toString();
        }
        return eVar;
    }
}

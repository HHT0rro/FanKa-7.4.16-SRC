package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.hms.ads.ir;
import com.iab.omid.library.huawei.adsession.AdEvents;
import com.iab.omid.library.huawei.adsession.AdSession;
import com.iab.omid.library.huawei.adsession.media.InteractionType;
import com.iab.omid.library.huawei.adsession.media.MediaEvents;
import com.iab.omid.library.huawei.adsession.media.PlayerState;
import com.iab.omid.library.huawei.adsession.media.VastProperties;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class in extends im implements ik {
    public static final int Code = 200;
    private static boolean I = false;
    private static final String V = "VideoEventAgent";
    private ir C;
    private final List<MediaEvents> Z = new ArrayList();
    private final List<AdEvents> B = new ArrayList();
    private boolean S = false;
    private int F = 0;
    private float D = 0.0f;
    private boolean L = false;

    static {
        I = ip.Code("com.iab.omid.library.huawei.adsession.media.MediaEvents") && ip.Code(ip.f29309e);
    }

    public static boolean C() {
        return I;
    }

    private String D() {
        return V + hashCode();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F() {
        if (gl.Code()) {
            gl.Code(D(), "volumeChangeInner %s", Boolean.valueOf(this.S));
        }
        V(this.S ? 0.0f : 1.0f);
    }

    @Override // com.huawei.hms.ads.im
    public void B() {
        if (this.B.isEmpty()) {
            gl.I(D(), "impressionOccurred, mAdEventList isEmpty");
            return;
        }
        try {
            Iterator<AdEvents> iterator2 = this.B.iterator2();
            while (iterator2.hasNext()) {
                iterator2.next().impressionOccurred();
            }
        } catch (IllegalStateException unused) {
            gl.V(D(), "impressionOccurred, fail");
        }
    }

    @Override // com.huawei.hms.ads.im
    public void Code() {
        if (this.Z.isEmpty()) {
            gl.I(D(), "firstQuartile, mVideoEventsList isEmpty");
            return;
        }
        try {
            for (MediaEvents mediaEvents : this.Z) {
                if (mediaEvents != null) {
                    gl.V(D(), com.huawei.openalliance.ad.constant.cj.V);
                    mediaEvents.firstQuartile();
                }
            }
        } catch (IllegalStateException unused) {
            gl.V(D(), "firstQuartile, fail");
        }
    }

    @Override // com.huawei.hms.ads.jj
    public void Code(float f10) {
        int Code2 = iq.Code(this.D, f10);
        if (gl.Code()) {
            gl.Code(D(), "onProgress %s", Integer.valueOf(Code2));
        }
        if (Code2 == 25) {
            this.D = Code2;
            Code();
        } else if (Code2 == 50) {
            this.D = Code2;
            I();
        } else {
            if (Code2 != 75) {
                return;
            }
            this.D = Code2;
            Z();
        }
    }

    @Override // com.huawei.hms.ads.im
    public void Code(float f10, float f11) {
        if (this.Z.isEmpty()) {
            return;
        }
        try {
            for (MediaEvents mediaEvents : this.Z) {
                if (mediaEvents != null) {
                    if (gl.Code()) {
                        gl.Code(D(), "start，duration %s", Float.valueOf(f10));
                    }
                    mediaEvents.start(f10, f11);
                }
            }
        } catch (IllegalStateException unused) {
            gl.V(D(), "start, fail");
        }
    }

    @Override // com.huawei.hms.ads.jj
    public void Code(float f10, boolean z10) {
        this.F = 1;
        this.S = z10;
        Code(f10, z10 ? 0.0f : 1.0f);
    }

    @Override // com.huawei.hms.ads.ik
    public void Code(iz izVar) {
        String D;
        String str;
        if (I) {
            if ((izVar instanceof id) && C()) {
                id idVar = (id) izVar;
                Context I2 = idVar.I();
                if (I2 != null) {
                    gl.V(D(), "Set VolumeChange observer");
                    ir irVar = new ir(I2);
                    this.C = irVar;
                    irVar.Code(new ir.b() { // from class: com.huawei.hms.ads.in.1
                        @Override // com.huawei.hms.ads.ir.b
                        public void Code() {
                            in.this.F();
                        }
                    });
                }
                List<AdSession> V2 = idVar.V();
                if (!V2.isEmpty()) {
                    for (AdSession adSession : V2) {
                        if (adSession != null) {
                            if (gl.Code()) {
                                gl.Code(D(), "setAdSessionAgent, add mVideoEventsList ");
                            }
                            this.Z.add(MediaEvents.createMediaEvents(adSession));
                            this.B.add(AdEvents.createAdEvents(adSession));
                        }
                    }
                    return;
                }
                D = D();
                str = "adSessionList is empty";
            } else {
                D = D();
                str = "adsessionAgent is null";
            }
            gl.V(D, str);
        }
    }

    @Override // com.huawei.hms.ads.im, com.huawei.hms.ads.jj
    public void Code(jk jkVar) {
        InteractionType Code2;
        if (!jk.Code() || (Code2 = jk.Code(jkVar)) == null) {
            return;
        }
        Code(Code2);
    }

    @Override // com.huawei.hms.ads.jj
    public void Code(jl jlVar) {
        PlayerState Code2;
        if (!jl.Code() || (Code2 = jl.Code(jlVar)) == null) {
            return;
        }
        if (gl.Code()) {
            gl.Code(D(), "playerStateChange %s", jlVar.toString());
        }
        Code(Code2);
    }

    @Override // com.huawei.hms.ads.im, com.huawei.hms.ads.jj
    public void Code(jn jnVar) {
        VastProperties V2;
        if (jnVar == null || !jn.Code() || (V2 = jnVar.V()) == null) {
            return;
        }
        Code(V2);
    }

    @Override // com.huawei.hms.ads.im
    public void Code(InteractionType interactionType) {
        if (this.Z.isEmpty()) {
            return;
        }
        try {
            for (MediaEvents mediaEvents : this.Z) {
                if (mediaEvents != null) {
                    if (gl.Code()) {
                        gl.Code(D(), "adUserInteraction ");
                    }
                    mediaEvents.adUserInteraction(interactionType);
                }
            }
        } catch (IllegalStateException unused) {
            gl.V(D(), "adUserInteraction, fail");
        }
    }

    @Override // com.huawei.hms.ads.im
    public void Code(PlayerState playerState) {
        if (this.Z.isEmpty()) {
            return;
        }
        try {
            for (MediaEvents mediaEvents : this.Z) {
                if (mediaEvents != null) {
                    mediaEvents.playerStateChange(PlayerState.COLLAPSED);
                }
            }
        } catch (IllegalStateException unused) {
            gl.V(D(), "playerStateChange, fail");
        }
    }

    @Override // com.huawei.hms.ads.im
    public void Code(VastProperties vastProperties) {
        if (this.B.isEmpty()) {
            return;
        }
        try {
            for (AdEvents adEvents : this.B) {
                if (adEvents != null) {
                    if (gl.Code()) {
                        gl.Code(D(), "loaded ");
                    }
                    adEvents.loaded(vastProperties);
                }
            }
        } catch (IllegalStateException unused) {
            gl.V(D(), "loaded, fail");
        }
    }

    @Override // com.huawei.hms.ads.im
    public void I() {
        if (this.Z.isEmpty()) {
            gl.I(D(), "midpoint, mVideoEventsList isEmpty");
            return;
        }
        try {
            for (MediaEvents mediaEvents : this.Z) {
                if (mediaEvents != null) {
                    gl.V(D(), "midpoint ");
                    mediaEvents.midpoint();
                }
            }
        } catch (IllegalStateException unused) {
            gl.V(D(), "midpoint, fail");
        }
    }

    public ir S() {
        return this.C;
    }

    @Override // com.huawei.hms.ads.ik
    public void V() {
        if (gl.Code()) {
            gl.Code(D(), "release ");
        }
        this.F = 0;
        ir irVar = this.C;
        if (irVar != null) {
            irVar.V();
        }
        com.huawei.openalliance.ad.utils.ba.Code(new Runnable() { // from class: com.huawei.hms.ads.in.2
            @Override // java.lang.Runnable
            public void run() {
                in.this.Z.clear();
                in.this.B.clear();
            }
        }, 200L);
    }

    @Override // com.huawei.hms.ads.im, com.huawei.hms.ads.jj
    public void V(float f10) {
        ir irVar;
        gl.V(D(), "volumeChange %s", Float.valueOf(f10));
        this.S = Math.abs(f10 - 0.0f) < 1.0E-8f;
        if (this.Z.isEmpty() || this.F != 1) {
            return;
        }
        try {
            for (MediaEvents mediaEvents : this.Z) {
                if (mediaEvents != null && (irVar = this.C) != null) {
                    if (f10 == -1.0f) {
                        mediaEvents.volumeChange(irVar.Code(this.S));
                    } else {
                        mediaEvents.volumeChange(f10);
                    }
                }
            }
        } catch (IllegalStateException unused) {
            gl.V(D(), "volumeChange, fail");
        }
    }

    @Override // com.huawei.hms.ads.jj
    public void V(boolean z10) {
        this.L = z10;
    }

    @Override // com.huawei.hms.ads.im
    public void Z() {
        if (this.Z.isEmpty()) {
            gl.I(D(), "thirdQuartile, mVideoEventsList isEmpty");
            return;
        }
        try {
            for (MediaEvents mediaEvents : this.Z) {
                if (mediaEvents != null) {
                    gl.V(D(), "thirdQuartile ");
                    mediaEvents.thirdQuartile();
                }
            }
        } catch (IllegalStateException unused) {
            gl.V(D(), "thirdQuartile, fail");
        }
    }

    @Override // com.huawei.hms.ads.im, com.huawei.hms.ads.jj
    public void a() {
        this.D = 0.0f;
        this.F = 0;
        if (this.Z.isEmpty()) {
            return;
        }
        try {
            for (MediaEvents mediaEvents : this.Z) {
                if (mediaEvents != null) {
                    if (gl.Code()) {
                        gl.Code(D(), "complete ");
                    }
                    mediaEvents.complete();
                }
            }
        } catch (IllegalStateException unused) {
            gl.V(D(), "complete, fail");
        }
    }

    @Override // com.huawei.hms.ads.im, com.huawei.hms.ads.jj
    public void b() {
        if (this.Z.isEmpty()) {
            return;
        }
        try {
            for (MediaEvents mediaEvents : this.Z) {
                if (mediaEvents != null) {
                    if (gl.Code()) {
                        gl.Code(D(), "bufferStart ");
                    }
                    mediaEvents.bufferStart();
                }
            }
        } catch (IllegalStateException unused) {
            gl.V(D(), "bufferStart, fail");
        }
    }

    @Override // com.huawei.hms.ads.im, com.huawei.hms.ads.jj
    public void c() {
        if (this.Z.isEmpty()) {
            return;
        }
        try {
            for (MediaEvents mediaEvents : this.Z) {
                if (mediaEvents != null) {
                    if (gl.Code()) {
                        gl.Code(D(), "bufferFinish ");
                    }
                    mediaEvents.bufferFinish();
                }
            }
        } catch (IllegalStateException unused) {
            gl.V(D(), "bufferFinish, fail");
        }
    }

    @Override // com.huawei.hms.ads.im, com.huawei.hms.ads.jj
    public void d() {
        if (!this.L) {
            this.F = 0;
        }
        if (this.Z.isEmpty()) {
            gl.I(D(), "skipped, mVideoEventsList isEmpty");
            return;
        }
        try {
            for (MediaEvents mediaEvents : this.Z) {
                if (mediaEvents != null) {
                    if (gl.Code()) {
                        gl.Code(D(), "skipped ");
                    }
                    mediaEvents.skipped();
                }
            }
        } catch (IllegalStateException unused) {
            gl.V(D(), "skipped, fail");
        }
    }

    @Override // com.huawei.hms.ads.im, com.huawei.hms.ads.jj
    public void e() {
        if (this.Z.isEmpty() || 1 != this.F) {
            return;
        }
        try {
            this.F = 2;
            for (MediaEvents mediaEvents : this.Z) {
                if (mediaEvents != null) {
                    if (gl.Code()) {
                        gl.Code(D(), "pause ");
                    }
                    mediaEvents.pause();
                }
            }
        } catch (IllegalStateException unused) {
            gl.V(D(), "pause, fail");
        }
    }

    @Override // com.huawei.hms.ads.im, com.huawei.hms.ads.jj
    public void f() {
        this.F = 1;
        if (this.Z.isEmpty()) {
            gl.I(D(), "resume, mVideoEventsList isEmpty");
            return;
        }
        try {
            for (MediaEvents mediaEvents : this.Z) {
                if (mediaEvents != null) {
                    if (gl.Code()) {
                        gl.Code(D(), "resume ");
                    }
                    mediaEvents.resume();
                }
            }
        } catch (IllegalStateException unused) {
            gl.V(D(), "resume, fail");
        }
    }
}

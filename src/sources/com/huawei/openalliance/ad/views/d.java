package com.huawei.openalliance.ad.views;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import com.huawei.hms.ads.fl;
import com.huawei.hms.ads.fp;
import com.huawei.hms.ads.ly;
import com.huawei.openalliance.ad.utils.s;
import java.lang.ref.WeakReference;
import java.util.Set;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class d {
    private fp B;
    private SurfaceTexture C;
    private final Set<WeakReference<ly>> D;
    private Surface F;
    private fl I;
    private SurfaceTexture.OnFrameAvailableListener L;
    private int S;
    private final s V;
    private com.huawei.openalliance.ad.media.b Z;

    public synchronized SurfaceTexture B() {
        return this.C;
    }

    public synchronized fp C() {
        return this.B;
    }

    public synchronized void Code() {
        try {
        } finally {
        }
        if (this.B != null) {
            return;
        }
        fp fpVar = new fp();
        this.B = fpVar;
        this.S = fpVar.V();
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.S);
        this.C = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(this.L);
        Surface surface = new Surface(this.C);
        this.F = surface;
        this.Z.Code(surface);
    }

    public void Code(Runnable runnable) {
        this.V.Code(runnable);
    }

    public void D() {
        fp fpVar = this.B;
        if (fpVar != null) {
            fpVar.Code();
            this.B = null;
        }
        fl flVar = this.I;
        if (flVar != null) {
            flVar.V();
            this.I.Code();
            this.I = null;
        }
        SurfaceTexture surfaceTexture = this.C;
        if (surfaceTexture != null) {
            surfaceTexture.release();
        }
    }

    public synchronized Surface I() {
        return this.F;
    }

    public synchronized fl S() {
        return this.I;
    }

    public synchronized void V() {
        if (this.I != null) {
            return;
        }
        this.I = new fl();
    }

    public void V(ly lyVar) {
        WeakReference<ly> weakReference = null;
        for (WeakReference<ly> weakReference2 : this.D) {
            if (weakReference2.get() == lyVar) {
                weakReference = weakReference2;
            }
        }
        if (weakReference != null) {
            this.D.remove(weakReference);
        }
    }

    public synchronized int Z() {
        return this.S;
    }

    public void finalize() {
        super.finalize();
        this.V.V();
    }
}

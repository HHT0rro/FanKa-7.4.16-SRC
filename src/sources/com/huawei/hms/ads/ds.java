package com.huawei.hms.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import com.huawei.hms.ads.dynamic.ObjectWrapper;
import com.huawei.openalliance.ad.constant.bg;
import com.huawei.openalliance.ad.media.b;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class ds extends b implements gv, gy {
    private static final String Code = "MediaPlayerAgentProxy";
    private gy I;
    private com.huawei.hms.ads.uiengine.a V;
    private gv Z;

    public ds(Context context, com.huawei.hms.ads.uiengine.a aVar) {
        super(context);
        this.V = aVar;
    }

    @Override // com.huawei.openalliance.ad.media.b
    public void Code() {
        try {
            this.V.V();
        } catch (Throwable th) {
            gl.V(Code, "stop err: %s", th.getClass().getSimpleName());
        }
    }

    @Override // com.huawei.hms.ads.gy
    public void Code(int i10, int i11) {
        gy gyVar = this.I;
        if (gyVar != null) {
            gyVar.Code(i10, i11);
        }
    }

    @Override // com.huawei.openalliance.ad.media.b
    public void Code(gv gvVar) {
        this.Z = gvVar;
        try {
            Bundle bundle = new Bundle();
            bundle.putBinder(bg.e.f32299p, (IBinder) ObjectWrapper.wrap(this));
            this.V.V(bundle);
        } catch (Throwable th) {
            gl.V(Code, "addMediaErrorListener err: %s", th.getClass().getSimpleName());
        }
    }

    @Override // com.huawei.openalliance.ad.media.b
    public void Code(gy gyVar) {
        this.I = gyVar;
        try {
            Bundle bundle = new Bundle();
            bundle.putBinder(bg.e.f32299p, (IBinder) ObjectWrapper.wrap(this));
            this.V.Code(bundle);
        } catch (Throwable th) {
            gl.V(Code, "addMediaStateListener err: %s", th.getClass().getSimpleName());
        }
    }

    @Override // com.huawei.hms.ads.gy
    public void Code(b bVar, int i10) {
        gy gyVar = this.I;
        if (gyVar != null) {
            gyVar.Code(this, i10);
        }
    }

    @Override // com.huawei.hms.ads.gv
    public void Code(b bVar, int i10, int i11, int i12) {
        gv gvVar = this.Z;
        if (gvVar != null) {
            gvVar.Code(this, i10, i11, i12);
        }
    }

    @Override // com.huawei.openalliance.ad.media.b
    public void Code(String str) {
        try {
            this.V.Code(str);
        } catch (Throwable th) {
            gl.V(Code, "playWhenUrlMatchs err: %s", th.getClass().getSimpleName());
        }
    }

    @Override // com.huawei.hms.ads.gy
    public void I(b bVar, int i10) {
        gy gyVar = this.I;
        if (gyVar != null) {
            gyVar.I(this, i10);
        }
    }

    @Override // com.huawei.openalliance.ad.media.b
    public void I(String str) {
        try {
            this.V.I(str);
        } catch (Throwable th) {
            gl.V(Code, "pauseWhenUrlMatchs er: %s", th.getClass().getSimpleName());
        }
    }

    @Override // com.huawei.openalliance.ad.media.b
    public void V(gv gvVar) {
        try {
            Bundle bundle = new Bundle();
            bundle.putBinder(bg.e.f32299p, (IBinder) ObjectWrapper.wrap(this));
            this.V.Z(bundle);
        } catch (Throwable th) {
            gl.V(Code, "removeMediaErrorListener err: %s", th.getClass().getSimpleName());
        }
    }

    @Override // com.huawei.openalliance.ad.media.b
    public void V(gy gyVar) {
        try {
            Bundle bundle = new Bundle();
            bundle.putBinder(bg.e.f32299p, (IBinder) ObjectWrapper.wrap(this));
            this.V.I(bundle);
        } catch (Throwable th) {
            gl.V(Code, "removeMediaErrorListener err: %s", th.getClass().getSimpleName());
        }
    }

    @Override // com.huawei.hms.ads.gy
    public void V(b bVar, int i10) {
        gy gyVar = this.I;
        if (gyVar != null) {
            gyVar.V(this, i10);
        }
    }

    @Override // com.huawei.openalliance.ad.media.b
    public void V(String str) {
        try {
            this.V.V(str);
        } catch (Throwable th) {
            gl.V(Code, "stopWhenUrlMatchs err: %s", th.getClass().getSimpleName());
        }
    }

    @Override // com.huawei.hms.ads.gy
    public void Z(b bVar, int i10) {
        gy gyVar = this.I;
        if (gyVar != null) {
            gyVar.Z(this, i10);
        }
    }
}

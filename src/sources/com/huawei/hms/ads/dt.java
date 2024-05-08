package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.hms.ads.uiengine.b;
import com.huawei.openalliance.ad.media.IMultiMediaPlayingManager;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class dt extends b.AbstractBinderC0318b {
    private static final byte[] D = new byte[0];
    private static dt F = null;
    private static final String S = "MultiMPlayingManagerPro";
    private Context L;

    /* renamed from: a, reason: collision with root package name */
    private IMultiMediaPlayingManager f29076a;

    /* renamed from: b, reason: collision with root package name */
    private final Map<Long, ds> f29077b = new HashMap();

    private dt(Context context) {
        this.L = context;
    }

    public static dt Code(Context context) {
        return V(context);
    }

    private Long I(com.huawei.hms.ads.uiengine.a aVar) {
        if (aVar == null) {
            return null;
        }
        try {
            return Long.valueOf(aVar.Code());
        } catch (Throwable th) {
            gl.V(S, "get id err: %s", th.getClass().getSimpleName());
            return null;
        }
    }

    private static dt V(Context context) {
        dt dtVar;
        synchronized (D) {
            if (F == null) {
                F = new dt(context);
            }
            dtVar = F;
        }
        return dtVar;
    }

    private ds Z(com.huawei.hms.ads.uiengine.a aVar) {
        ds dsVar;
        try {
            long Code = aVar.Code();
            if (this.f29077b.containsKey(Long.valueOf(Code))) {
                dsVar = this.f29077b.get(Long.valueOf(Code));
            } else {
                ds dsVar2 = new ds(this.L, aVar);
                this.f29077b.put(Long.valueOf(Code), dsVar2);
                dsVar = dsVar2;
            }
            if (gl.Code()) {
                gl.Code(S, "getProxy = %s, proxy = %s", Long.valueOf(Code), dsVar);
            }
            return dsVar;
        } catch (Throwable th) {
            gl.V(S, "getProxy err: %s", th.getClass().getSimpleName());
            return null;
        }
    }

    @Override // com.huawei.hms.ads.uiengine.b
    public void Code(com.huawei.hms.ads.uiengine.a aVar) {
        Long I = I(aVar);
        gl.V(S, "removeAgent %s", I);
        IMultiMediaPlayingManager iMultiMediaPlayingManager = this.f29076a;
        if (iMultiMediaPlayingManager != null) {
            iMultiMediaPlayingManager.Code(Z(aVar));
        }
        if (I != null) {
            this.f29077b.remove(I);
        }
    }

    public void Code(IMultiMediaPlayingManager iMultiMediaPlayingManager) {
        this.f29076a = iMultiMediaPlayingManager;
    }

    @Override // com.huawei.hms.ads.uiengine.b
    public void Code(String str, com.huawei.hms.ads.uiengine.a aVar) {
        gl.V(S, "autoPlay %s", I(aVar));
        IMultiMediaPlayingManager iMultiMediaPlayingManager = this.f29076a;
        if (iMultiMediaPlayingManager != null) {
            iMultiMediaPlayingManager.Code(str, Z(aVar));
        }
    }

    @Override // com.huawei.hms.ads.uiengine.b
    public void I(String str, com.huawei.hms.ads.uiengine.a aVar) {
        gl.V(S, "stop %s", I(aVar));
        IMultiMediaPlayingManager iMultiMediaPlayingManager = this.f29076a;
        if (iMultiMediaPlayingManager != null) {
            iMultiMediaPlayingManager.I(str, Z(aVar));
        }
    }

    @Override // com.huawei.hms.ads.uiengine.b
    public void V(com.huawei.hms.ads.uiengine.a aVar) {
        gl.V(S, "removeListeners %s", I(aVar));
        ds Z = Z(aVar);
        IMultiMediaPlayingManager iMultiMediaPlayingManager = this.f29076a;
        if (iMultiMediaPlayingManager != null) {
            iMultiMediaPlayingManager.V(Z);
        }
    }

    @Override // com.huawei.hms.ads.uiengine.b
    public void V(String str, com.huawei.hms.ads.uiengine.a aVar) {
        gl.V(S, "manualPlay %s", I(aVar));
        IMultiMediaPlayingManager iMultiMediaPlayingManager = this.f29076a;
        if (iMultiMediaPlayingManager != null) {
            iMultiMediaPlayingManager.V(str, Z(aVar));
        }
    }

    @Override // com.huawei.hms.ads.uiengine.b
    public void Z(String str, com.huawei.hms.ads.uiengine.a aVar) {
        gl.V(S, "pause %s", I(aVar));
        IMultiMediaPlayingManager iMultiMediaPlayingManager = this.f29076a;
        if (iMultiMediaPlayingManager != null) {
            iMultiMediaPlayingManager.Z(str, Z(aVar));
        }
    }
}

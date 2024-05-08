package com.tencent.liteav.videobase.egl;

import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videobase.utils.OpenGlUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final /* synthetic */ class d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final c f43425a;

    private d(c cVar) {
        this.f43425a = cVar;
    }

    public static Runnable a(c cVar) {
        return new d(cVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        c cVar = this.f43425a;
        EGLCore eGLCore = cVar.f43423d;
        if (eGLCore != null) {
            try {
                eGLCore.makeCurrent();
                OpenGlUtils.deleteShaderId(cVar.f43421b.getAndSet(-1));
            } catch (f e2) {
                LiteavLog.i("EGLContextChecker", "release EGLCore failed.", e2);
            }
            EGLCore.destroy(cVar.f43423d);
            cVar.f43423d = null;
        }
    }
}

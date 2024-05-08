package com.amap.api.col.p0003l;

import com.autonavi.base.amap.api.mapcore.IGLSurfaceView;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;

/* compiled from: GlesUtility.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class dj {

    /* compiled from: GlesUtility.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class b extends di {
        @Override // com.amap.api.col.p0003l.di, android.opengl.GLSurfaceView.EGLContextFactory, com.amap.api.col.3l.y.f
        public final EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            try {
                return egl10.eglCreateContext(eGLDisplay, eGLConfig, EGL10.EGL_NO_CONTEXT, new int[]{12440, 2, 12344});
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }

        @Override // com.amap.api.col.p0003l.di, android.opengl.GLSurfaceView.EGLContextFactory, com.amap.api.col.3l.y.f
        public final void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            egl10.eglDestroyContext(eGLDisplay, eGLContext);
        }
    }

    public static void a(IGLSurfaceView iGLSurfaceView) {
        iGLSurfaceView.setEGLContextFactory(new b());
        iGLSurfaceView.setEGLConfigChooser(new a());
    }

    /* compiled from: GlesUtility.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class a extends dh {

        /* renamed from: g, reason: collision with root package name */
        private static int f5344g = 4;

        /* renamed from: h, reason: collision with root package name */
        private int[] f5351h = new int[1];

        /* renamed from: a, reason: collision with root package name */
        public int f5345a = 5;

        /* renamed from: b, reason: collision with root package name */
        public int f5346b = 6;

        /* renamed from: c, reason: collision with root package name */
        public int f5347c = 5;

        /* renamed from: d, reason: collision with root package name */
        public int f5348d = 0;

        /* renamed from: e, reason: collision with root package name */
        public int f5349e = 16;

        /* renamed from: f, reason: collision with root package name */
        public int f5350f = 8;

        private int[] a(boolean z10) {
            return new int[]{12324, this.f5345a, 12323, this.f5346b, 12322, this.f5347c, 12321, this.f5348d, 12325, this.f5349e, 12326, this.f5350f, 12338, z10 ? 1 : 0, 12352, f5344g, 12344};
        }

        @Override // com.amap.api.col.p0003l.dh, android.opengl.GLSurfaceView.EGLConfigChooser, com.amap.api.col.3l.y.e
        public final EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr;
            int[] iArr2;
            c a10 = a(egl10, eGLDisplay);
            if (a10 == null || (iArr = a10.f5352a) == null) {
                return null;
            }
            int[] iArr3 = a10.f5353b;
            EGLConfig[] eGLConfigArr = new EGLConfig[iArr3[0]];
            egl10.eglChooseConfig(eGLDisplay, iArr, eGLConfigArr, iArr3[0], iArr3);
            EGLConfig a11 = a(egl10, eGLDisplay, eGLConfigArr);
            if (a11 != null) {
                return a11;
            }
            this.f5345a = 8;
            this.f5346b = 8;
            this.f5347c = 8;
            c a12 = a(egl10, eGLDisplay);
            if (a12 == null || (iArr2 = a12.f5352a) == null) {
                return a11;
            }
            int[] iArr4 = a12.f5353b;
            EGLConfig[] eGLConfigArr2 = new EGLConfig[iArr4[0]];
            egl10.eglChooseConfig(eGLDisplay, iArr2, eGLConfigArr2, iArr4[0], iArr4);
            return a(egl10, eGLDisplay, eGLConfigArr2);
        }

        private c a(EGL10 egl10, EGLDisplay eGLDisplay) {
            c cVar = new c((byte) 0);
            int[] a10 = a(true);
            cVar.f5352a = a10;
            egl10.eglChooseConfig(eGLDisplay, a10, null, 0, cVar.f5353b);
            if (cVar.f5353b[0] <= 0) {
                int[] a11 = a(false);
                cVar.f5352a = a11;
                egl10.eglChooseConfig(eGLDisplay, a11, null, 0, cVar.f5353b);
                if (cVar.f5353b[0] <= 0) {
                    return null;
                }
            }
            return cVar;
        }

        private EGLConfig a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
            for (EGLConfig eGLConfig : eGLConfigArr) {
                int a10 = a(egl10, eGLDisplay, eGLConfig, 12325);
                int a11 = a(egl10, eGLDisplay, eGLConfig, 12326);
                if (a10 >= this.f5349e && a11 >= this.f5350f) {
                    int a12 = a(egl10, eGLDisplay, eGLConfig, 12324);
                    int a13 = a(egl10, eGLDisplay, eGLConfig, 12323);
                    int a14 = a(egl10, eGLDisplay, eGLConfig, 12322);
                    int a15 = a(egl10, eGLDisplay, eGLConfig, 12321);
                    if (a12 == this.f5345a && a13 == this.f5346b && a14 == this.f5347c && a15 == this.f5348d) {
                        return eGLConfig;
                    }
                }
            }
            return null;
        }

        private int a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i10) {
            if (egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i10, this.f5351h)) {
                return this.f5351h[0];
            }
            return 0;
        }
    }

    /* compiled from: GlesUtility.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public int[] f5352a;

        /* renamed from: b, reason: collision with root package name */
        public int[] f5353b;

        private c() {
            this.f5352a = null;
            this.f5353b = new int[1];
        }

        public /* synthetic */ c(byte b4) {
            this();
        }
    }
}

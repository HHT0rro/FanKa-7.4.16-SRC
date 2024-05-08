package com.tencent.liteav.videoproducer.preprocessor;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.Rotation;
import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videobase.egl.EGLCore;
import com.tencent.liteav.videobase.frame.PixelFrame;
import com.tencent.liteav.videobase.utils.OpenGlUtils;
import com.tencent.liteav.videobase.videobase.IVideoReporter;
import com.tencent.liteav.videobase.videobase.d;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class h implements com.tencent.liteav.videobase.base.a {

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final IVideoReporter f44782b;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final BeautyProcessor f44786f;

    /* renamed from: k, reason: collision with root package name */
    public EGLCore f44791k;

    /* renamed from: l, reason: collision with root package name */
    public Object f44792l;

    /* renamed from: m, reason: collision with root package name */
    public com.tencent.liteav.videobase.frame.j f44793m;

    /* renamed from: n, reason: collision with root package name */
    public com.tencent.liteav.videobase.frame.e f44794n;

    /* renamed from: o, reason: collision with root package name */
    public com.tencent.liteav.videobase.a.a f44795o;

    /* renamed from: q, reason: collision with root package name */
    public com.tencent.liteav.videobase.videobase.d f44797q;

    /* renamed from: t, reason: collision with root package name */
    @NonNull
    private final Context f44800t;

    /* renamed from: a, reason: collision with root package name */
    public final String f44781a = "GPUPreprocessor_" + hashCode();

    /* renamed from: u, reason: collision with root package name */
    @NonNull
    private final com.tencent.liteav.videobase.a.b[] f44801u = new com.tencent.liteav.videobase.a.b[b.a().length];

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final com.tencent.liteav.videobase.utils.d f44785e = new com.tencent.liteav.videobase.utils.d();

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final com.tencent.liteav.videobase.a.h f44787g = new com.tencent.liteav.videobase.a.h();

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final com.tencent.liteav.base.b.b f44788h = new com.tencent.liteav.base.b.b();

    /* renamed from: i, reason: collision with root package name */
    public int f44789i = 128;

    /* renamed from: j, reason: collision with root package name */
    public int f44790j = 128;

    /* renamed from: p, reason: collision with root package name */
    @NonNull
    public final com.tencent.liteav.videobase.videobase.d f44796p = new com.tencent.liteav.videobase.videobase.d();

    /* renamed from: r, reason: collision with root package name */
    @NonNull
    public final List<c> f44798r = new ArrayList();

    /* renamed from: s, reason: collision with root package name */
    public final List<c> f44799s = new ArrayList();

    /* renamed from: v, reason: collision with root package name */
    private Boolean f44802v = null;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final FloatBuffer f44783c = OpenGlUtils.createNormalCubeVerticesBuffer();

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final FloatBuffer f44784d = OpenGlUtils.createTextureCoordsBuffer(Rotation.NORMAL, false, false);

    /* renamed from: com.tencent.liteav.videoproducer.preprocessor.h$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f44803a;

        static {
            int[] iArr = new int[b.a().length];
            f44803a = iArr;
            try {
                iArr[b.f44809e - 1] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f44803a[b.f44806b - 1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f44803a[b.f44807c - 1] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f44803a[b.f44808d - 1] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class a extends com.tencent.liteav.videobase.a.a {

        /* renamed from: b, reason: collision with root package name */
        private final com.tencent.liteav.videobase.videobase.d f44804b;

        public a(com.tencent.liteav.videobase.videobase.d dVar) {
            this.f44804b = dVar;
        }

        @Override // com.tencent.liteav.videobase.a.a
        public final com.tencent.liteav.videobase.frame.d a(long j10, com.tencent.liteav.videobase.frame.d dVar) {
            com.tencent.liteav.videobase.videobase.d dVar2 = this.f44804b;
            if (dVar2 != null) {
                dVar2.a(j10, dVar);
            }
            return dVar;
        }
    }

    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public static final int f44805a = 1;

        /* renamed from: b, reason: collision with root package name */
        public static final int f44806b = 2;

        /* renamed from: c, reason: collision with root package name */
        public static final int f44807c = 3;

        /* renamed from: d, reason: collision with root package name */
        public static final int f44808d = 4;

        /* renamed from: e, reason: collision with root package name */
        public static final int f44809e = 5;

        /* renamed from: f, reason: collision with root package name */
        private static final /* synthetic */ int[] f44810f = {1, 2, 3, 4, 5};

        public static int[] a() {
            return (int[]) f44810f.clone();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class c implements d.a {

        /* renamed from: a, reason: collision with root package name */
        public int f44811a;

        /* renamed from: b, reason: collision with root package name */
        public com.tencent.liteav.videobase.videobase.a f44812b;

        /* renamed from: c, reason: collision with root package name */
        public GLConstants.PixelBufferType f44813c;

        /* renamed from: d, reason: collision with root package name */
        public GLConstants.PixelFormatType f44814d;

        /* renamed from: e, reason: collision with root package name */
        public ah f44815e;

        public c(int i10, com.tencent.liteav.videobase.videobase.a aVar, GLConstants.PixelBufferType pixelBufferType, GLConstants.PixelFormatType pixelFormatType, ah ahVar) {
            this.f44811a = i10;
            this.f44812b = aVar;
            this.f44814d = pixelFormatType;
            this.f44813c = pixelBufferType;
            this.f44815e = ahVar;
        }

        @Override // com.tencent.liteav.videobase.videobase.d.a
        public final void a(int i10, PixelFrame pixelFrame) {
            ah ahVar = this.f44815e;
            if (ahVar == null || h.this.f44791k == null) {
                return;
            }
            ahVar.a(i10, pixelFrame);
            h.this.d();
        }
    }

    public h(@NonNull Context context, @NonNull BeautyProcessor beautyProcessor, @NonNull IVideoReporter iVideoReporter) {
        this.f44800t = context.getApplicationContext();
        this.f44786f = beautyProcessor;
        this.f44782b = iVideoReporter;
        beautyProcessor.setAIDetectListener(this);
    }

    public final void a(int i10, int i11) {
        if (this.f44789i == i10 && this.f44790j == i11) {
            return;
        }
        this.f44789i = i10;
        this.f44790j = i11;
        LiteavLog.i(this.f44781a, "process size update to %dx%d", Integer.valueOf(i10), Integer.valueOf(i11));
        if (d()) {
            com.tencent.liteav.videobase.frame.j jVar = this.f44793m;
            if (jVar != null) {
                jVar.a();
                this.f44793m = null;
            }
            com.tencent.liteav.videobase.frame.e eVar = this.f44794n;
            if (eVar != null) {
                eVar.a();
            }
            this.f44787g.onOutputSizeChanged(i10, i11);
        }
    }

    public final <T> T b(int i10) {
        return (T) this.f44801u[i10 - 1];
    }

    public final void c(int i10) {
        com.tencent.liteav.videobase.a.b bVar;
        com.tencent.liteav.videobase.a.b[] bVarArr = this.f44801u;
        int i11 = i10 - 1;
        if (bVarArr[i11] == null || (bVar = bVarArr[i11]) == null) {
            return;
        }
        bVarArr[i11] = null;
        bVar.uninitialize();
        b();
    }

    public final boolean d() {
        try {
            EGLCore eGLCore = this.f44791k;
            if (eGLCore != null) {
                eGLCore.makeCurrent();
                return true;
            }
        } catch (com.tencent.liteav.videobase.egl.f e2) {
            LiteavLog.e(this.f44788h.a("makeCurrent"), this.f44781a, "makeCurrent failed. ".concat(String.valueOf(e2)), new Object[0]);
        }
        return false;
    }

    public final void b() {
        this.f44787g.removeAllFilterAndInterceptor();
        this.f44787g.uninitialize();
        c();
        for (int i10 : b.a()) {
            if (i10 == b.f44809e) {
                this.f44787g.addInterceptor(this.f44795o);
                this.f44787g.addInterceptor(new a(this.f44797q));
            }
            if (i10 == b.f44805a) {
                this.f44787g.addFilter(this.f44786f);
            } else {
                this.f44787g.addFilter(this.f44801u[i10 - 1]);
            }
        }
        this.f44787g.addInterceptor(new a(this.f44796p));
        this.f44787g.initialize(this.f44794n);
        this.f44787g.onOutputSizeChanged(this.f44789i, this.f44790j);
    }

    public final void c() {
        if (d()) {
            if (this.f44801u[b.f44809e - 1] != null) {
                if (this.f44797q == null) {
                    com.tencent.liteav.videobase.videobase.d dVar = new com.tencent.liteav.videobase.videobase.d();
                    this.f44797q = dVar;
                    dVar.a(this.f44794n);
                }
                for (c cVar : this.f44798r) {
                    this.f44796p.a(cVar.f44811a, cVar);
                    this.f44797q.a(cVar.f44812b, cVar.f44813c, cVar.f44814d, cVar.f44811a, cVar);
                }
            } else {
                for (c cVar2 : this.f44798r) {
                    com.tencent.liteav.videobase.videobase.d dVar2 = this.f44797q;
                    if (dVar2 != null) {
                        dVar2.a(cVar2.f44811a, cVar2);
                    }
                    this.f44796p.a(cVar2.f44812b, cVar2.f44813c, cVar2.f44814d, cVar2.f44811a, cVar2);
                }
                com.tencent.liteav.videobase.videobase.d dVar3 = this.f44797q;
                if (dVar3 != null) {
                    dVar3.a();
                    this.f44797q = null;
                }
            }
            for (c cVar3 : this.f44799s) {
                this.f44796p.a(cVar3.f44812b, cVar3.f44813c, cVar3.f44814d, cVar3.f44811a, cVar3);
            }
        }
    }

    public final void a(float f10, Bitmap bitmap, float f11, Bitmap bitmap2, float f12) {
        this.f44785e.a(n.a(this, bitmap, bitmap2, f10, f11, f12));
    }

    public final void a() {
        if (d()) {
            this.f44796p.a();
            com.tencent.liteav.videobase.videobase.d dVar = this.f44797q;
            if (dVar != null) {
                dVar.a();
                this.f44797q = null;
            }
            this.f44786f.uninitialize();
            com.tencent.liteav.videobase.frame.e eVar = this.f44794n;
            if (eVar != null) {
                eVar.a();
                this.f44794n.b();
                this.f44794n = null;
            }
            com.tencent.liteav.videobase.frame.j jVar = this.f44793m;
            if (jVar != null) {
                jVar.a();
                this.f44793m = null;
            }
            this.f44787g.uninitialize();
            EGLCore.destroy(this.f44791k);
            this.f44791k = null;
            LiteavLog.i(this.f44788h.a("uninitGL"), this.f44781a, "uninitialize opengl components", new Object[0]);
        }
    }

    public final <T> T a(int i10) {
        Object obj;
        Object[] objArr = this.f44801u;
        int i11 = i10 - 1;
        if (objArr[i11] != null) {
            return (T) objArr[i11];
        }
        int i12 = AnonymousClass1.f44803a[i11];
        if (i12 == 1) {
            obj = (T) new com.tencent.liteav.beauty.b.n();
        } else if (i12 == 2) {
            obj = (T) new com.tencent.liteav.beauty.b.f(0.8f);
        } else if (i12 == 3) {
            obj = (T) new com.tencent.liteav.beauty.b.i();
        } else if (i12 == 4) {
            obj = (T) new com.tencent.liteav.beauty.b.h(this.f44800t);
        } else {
            throw new RuntimeException("unknown filter type");
        }
        ((com.tencent.liteav.videobase.a.b) obj).initialize(this.f44794n);
        ((com.tencent.liteav.videobase.a.b) obj).onOutputSizeChanged(this.f44789i, this.f44790j);
        this.f44801u[i11] = obj;
        b();
        return (T) obj;
    }

    public static void a(c cVar, List<c> list) {
        for (c cVar2 : list) {
            if (cVar2.f44811a == cVar.f44811a && cVar2.f44815e == cVar.f44815e) {
                return;
            }
        }
        list.add(cVar);
    }

    public static c a(int i10, ah ahVar, List<c> list) {
        for (int i11 = 0; i11 < list.size(); i11++) {
            c cVar = list.get(i11);
            if (cVar.f44811a == i10 && cVar.f44815e == ahVar) {
                list.remove(i11);
                return cVar;
            }
        }
        return null;
    }
}

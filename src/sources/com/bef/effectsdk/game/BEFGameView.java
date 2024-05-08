package com.bef.effectsdk.game;

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import com.android.internal.logging.nano.MetricsProto;
import com.bef.effectsdk.OpenGLUtils;
import com.bef.effectsdk.game.NativeInterface;
import java.nio.Buffer;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.opengles.GL10;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class BEFGameView extends GLSurfaceView implements GLSurfaceView.Renderer, NativeInterface.NativeMessageListener {

    /* renamed from: b, reason: collision with root package name */
    public long f10460b;

    /* renamed from: c, reason: collision with root package name */
    public String f10461c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f10462d;

    /* renamed from: e, reason: collision with root package name */
    public long f10463e;

    /* renamed from: f, reason: collision with root package name */
    public long f10464f;

    /* renamed from: g, reason: collision with root package name */
    public long f10465g;

    /* renamed from: h, reason: collision with root package name */
    public long f10466h;

    /* renamed from: i, reason: collision with root package name */
    public double f10467i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f10468j;

    /* renamed from: k, reason: collision with root package name */
    public int f10469k;

    /* renamed from: l, reason: collision with root package name */
    public int f10470l;

    /* renamed from: m, reason: collision with root package name */
    public int f10471m;

    /* renamed from: n, reason: collision with root package name */
    public int f10472n;

    /* renamed from: o, reason: collision with root package name */
    public int f10473o;

    /* renamed from: p, reason: collision with root package name */
    public int f10474p;

    /* renamed from: q, reason: collision with root package name */
    public int f10475q;

    /* renamed from: r, reason: collision with root package name */
    public int f10476r;

    /* renamed from: s, reason: collision with root package name */
    public float[] f10477s;

    /* renamed from: t, reason: collision with root package name */
    public HashSet<Object> f10478t;

    /* renamed from: u, reason: collision with root package name */
    public Queue<Runnable> f10479u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f10480v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f10481w;

    /* renamed from: x, reason: collision with root package name */
    public int[] f10482x;

    /* renamed from: y, reason: collision with root package name */
    public float[] f10483y;

    /* renamed from: z, reason: collision with root package name */
    public float[] f10484z;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public class a implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int[] f10485b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ float[] f10486c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ float[] f10487d;

        public a(int[] iArr, float[] fArr, float[] fArr2) {
            this.f10485b = iArr;
            this.f10486c = fArr;
            this.f10487d = fArr2;
        }

        @Override // java.lang.Runnable
        public void run() {
            NativeInterface.i(BEFGameView.this.f10460b, this.f10485b, this.f10486c, this.f10487d);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public class b implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f10489b;

        public b(String str) {
            this.f10489b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (BEFGameView.this.f10461c.equals(this.f10489b)) {
                return;
            }
            BEFGameView bEFGameView = BEFGameView.this;
            bEFGameView.f10461c = this.f10489b;
            if (bEFGameView.getNativeInited()) {
                NativeInterface.f(BEFGameView.this.f10460b, this.f10489b);
                BEFGameView.this.f10480v = true;
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public class c implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int[] f10491b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ float[] f10492c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ float[] f10493d;

        public c(int[] iArr, float[] fArr, float[] fArr2) {
            this.f10491b = iArr;
            this.f10492c = fArr;
            this.f10493d = fArr2;
        }

        @Override // java.lang.Runnable
        public void run() {
            NativeInterface.h(BEFGameView.this.f10460b, this.f10491b, this.f10492c, this.f10493d);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public class d implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int[] f10495b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ float[] f10496c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ float[] f10497d;

        public d(int[] iArr, float[] fArr, float[] fArr2) {
            this.f10495b = iArr;
            this.f10496c = fArr;
            this.f10497d = fArr2;
        }

        @Override // java.lang.Runnable
        public void run() {
            NativeInterface.h(BEFGameView.this.f10460b, this.f10495b, this.f10496c, this.f10497d);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public class e implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int[] f10499b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ float[] f10500c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ float[] f10501d;

        public e(int[] iArr, float[] fArr, float[] fArr2) {
            this.f10499b = iArr;
            this.f10500c = fArr;
            this.f10501d = fArr2;
        }

        @Override // java.lang.Runnable
        public void run() {
            NativeInterface.j(BEFGameView.this.f10460b, this.f10499b, this.f10500c, this.f10501d);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public class f implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int[] f10503b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ float[] f10504c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ float[] f10505d;

        public f(int[] iArr, float[] fArr, float[] fArr2) {
            this.f10503b = iArr;
            this.f10504c = fArr;
            this.f10505d = fArr2;
        }

        @Override // java.lang.Runnable
        public void run() {
            NativeInterface.j(BEFGameView.this.f10460b, this.f10503b, this.f10504c, this.f10505d);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public class g implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int[] f10507b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ float[] f10508c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ float[] f10509d;

        public g(int[] iArr, float[] fArr, float[] fArr2) {
            this.f10507b = iArr;
            this.f10508c = fArr;
            this.f10509d = fArr2;
        }

        @Override // java.lang.Runnable
        public void run() {
            NativeInterface.i(BEFGameView.this.f10460b, this.f10507b, this.f10508c, this.f10509d);
        }
    }

    public BEFGameView(Context context) {
        super(context);
        this.f10460b = 0L;
        this.f10461c = "";
        this.f10468j = false;
        this.f10477s = new float[16];
        this.f10480v = true;
        this.f10481w = true;
        this.f10482x = new int[10];
        this.f10483y = new float[10];
        this.f10484z = new float[10];
        setEGLContextClientVersion(2);
        setPreserveEGLContextOnPause(true);
        setEGLConfigChooser(8, 8, 8, 8, 16, 0);
        getHolder().setFormat(-3);
        setZOrderMediaOverlay(true);
        setEGLContextFactory(new h(this, null));
        setRenderer(this);
        setRenderMode(1);
        this.f10478t = new HashSet<>();
        this.f10479u = new LinkedList();
        setFps(60L);
    }

    public void b(float[] fArr, float[] fArr2, int i10) {
        float width = getWidth();
        float f10 = ((width * 1.0f) / 720.0f) * 1280.0f;
        float height = getHeight() - f10;
        for (int i11 = 0; i11 < i10; i11++) {
            float f11 = fArr[i11];
            float f12 = fArr2[i11];
            fArr[i11] = ((f11 * 2.0f) / width) - 1.0f;
            fArr2[i11] = 1.0f - (((f12 - height) * 2.0f) / f10);
        }
    }

    public void c() {
        GLES20.glDeleteTextures(1, new int[]{this.f10470l}, 0);
        GLES20.glDeleteTextures(1, new int[]{this.f10469k}, 0);
        GLES20.glDeleteBuffers(1, new int[]{this.f10471m}, 0);
    }

    public void d() {
        int loadProgram = OpenGLUtils.loadProgram("attribute vec2 attUV;\nattribute vec2 attPosition;\nvarying vec2 textureCoord;\nuniform mat4 mvpMatrix;\n\nvoid main() {\n    gl_Position  = mvpMatrix * vec4(attPosition, 0.,1.);\n    textureCoord = attUV;\n}\n", "precision highp float;\n\nuniform sampler2D uTexture;\nvarying vec2 textureCoord;\nvoid main() {\n    gl_FragColor = texture2D(uTexture, textureCoord);\n}\n");
        this.f10472n = loadProgram;
        this.f10473o = GLES20.glGetAttribLocation(loadProgram, "attUV");
        this.f10474p = GLES20.glGetAttribLocation(this.f10472n, "attPosition");
        this.f10475q = GLES20.glGetUniformLocation(this.f10472n, "mvpMatrix");
        this.f10476r = GLES20.glGetUniformLocation(this.f10472n, "uTexture");
        getWidth();
        getHeight();
        this.f10470l = com.bef.effectsdk.game.a.a(MetricsProto.MetricsEvent.ACTION_PERMISSION_DENIED_RECEIVE_WAP_PUSH, 1280);
        this.f10469k = com.bef.effectsdk.game.a.a(MetricsProto.MetricsEvent.ACTION_PERMISSION_DENIED_RECEIVE_WAP_PUSH, 1280);
        int[] iArr = new int[1];
        GLES20.glGenFramebuffers(1, iArr, 0);
        int i10 = iArr[0];
        this.f10471m = i10;
        GLES20.glBindFramebuffer(36160, i10);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.f10469k, 0);
        GLES20.glBindFramebuffer(36160, 0);
    }

    public void e(double d10) {
        NativeInterface.g(this.f10460b, MetricsProto.MetricsEvent.ACTION_PERMISSION_DENIED_RECEIVE_WAP_PUSH, 1280);
        f(d10);
        g();
    }

    public void f(double d10) {
        GLES20.glBindFramebuffer(36160, this.f10471m);
        GLES20.glViewport(0, 0, MetricsProto.MetricsEvent.ACTION_PERMISSION_DENIED_RECEIVE_WAP_PUSH, 1280);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glClear(16384);
        NativeInterface.e(this.f10460b, this.f10470l, this.f10469k, d10);
        GLES20.glBindFramebuffer(36160, 0);
    }

    public void g() {
        GLES20.glBindFramebuffer(36160, 0);
        int width = getWidth();
        int height = getHeight();
        GLES20.glViewport(0, 0, width, height);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glClear(16384);
        GLES20.glUseProgram(this.f10472n);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, this.f10469k);
        GLES20.glUniform1i(this.f10476r, 0);
        Matrix.setIdentityM(this.f10477s, 0);
        GLES20.glUniformMatrix4fv(this.f10475q, 1, false, this.f10477s, 0);
        GLES20.glEnableVertexAttribArray(this.f10474p);
        float f10 = height / 2.0f;
        GLES20.glVertexAttribPointer(this.f10474p, 2, 5126, false, 0, (Buffer) com.bef.effectsdk.game.a.d(-1.0f, 1.0f, ((((width * 1.0f) / 720.0f) * 1280.0f) - f10) / f10, -1.0f));
        GLES20.glEnableVertexAttribArray(this.f10473o);
        GLES20.glVertexAttribPointer(this.f10473o, 2, 5126, false, 0, (Buffer) com.bef.effectsdk.game.a.c());
        GLES20.glDrawArrays(5, 0, 4);
    }

    public synchronized double getCurrentFps() {
        return this.f10467i;
    }

    public synchronized boolean getNativeInited() {
        return this.f10462d;
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(GL10 gl10) {
        if (!getNativeInited() || this.f10461c.isEmpty()) {
            return;
        }
        if (this.f10480v) {
            this.f10466h = System.nanoTime();
            this.f10465g = System.nanoTime();
        }
        if (!this.f10480v) {
            while (!this.f10479u.isEmpty()) {
                this.f10479u.poll().run();
            }
        }
        e((System.nanoTime() - this.f10466h) / 1.0E9d);
        if (System.nanoTime() - this.f10465g < this.f10464f) {
            try {
                Thread.sleep((long) (((r4 - r0) * 1.0d) / 1000000.0d));
            } catch (Exception unused) {
            }
        }
        double nanoTime = 1.0d / (((System.nanoTime() - this.f10465g) * 1.0d) / 1.0E9d);
        this.f10467i = nanoTime;
        long j10 = this.f10463e;
        if (nanoTime >= j10) {
            this.f10467i = j10;
        }
        this.f10465g = System.nanoTime();
        this.f10480v = false;
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 gl10, int i10, int i11) {
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        this.f10466h = System.nanoTime();
        this.f10465g = System.nanoTime();
        long[] jArr = new long[2];
        NativeInterface.b(jArr);
        long j10 = jArr[0];
        this.f10460b = j10;
        NativeInterface.d(j10, MetricsProto.MetricsEvent.ACTION_PERMISSION_DENIED_RECEIVE_WAP_PUSH, 1280);
        NativeInterface.a(this.f10460b, this);
        d();
        setNativeInited(true);
        if (this.f10461c.isEmpty()) {
            return;
        }
        NativeInterface.f(this.f10460b, this.f10461c);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        if (pointerCount > 10) {
            pointerCount = 10;
        }
        for (int i10 = 0; i10 < pointerCount; i10++) {
            this.f10482x[i10] = motionEvent.getPointerId(i10);
            this.f10483y[i10] = motionEvent.getX(i10);
            this.f10484z[i10] = motionEvent.getY(i10);
        }
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            b(this.f10483y, this.f10484z, 1);
            queueEvent(new d(new int[]{this.f10482x[0]}, new float[]{this.f10483y[0]}, new float[]{this.f10484z[0]}));
            return true;
        }
        if (action != 1) {
            if (action == 2) {
                b(this.f10483y, this.f10484z, pointerCount);
                if (this.f10481w) {
                    for (int i11 = 0; i11 < pointerCount; i11++) {
                        queueEvent(new f(new int[]{this.f10482x[i11]}, new float[]{this.f10483y[i11]}, new float[]{this.f10484z[i11]}));
                    }
                    return true;
                }
                queueEvent(new e(new int[]{this.f10482x[0]}, new float[]{this.f10483y[0]}, new float[]{this.f10484z[0]}));
            } else if (action == 5) {
                int action2 = motionEvent.getAction() >> 8;
                if (this.f10481w || action2 == 0) {
                    b(this.f10483y, this.f10484z, pointerCount);
                    queueEvent(new c(new int[]{this.f10482x[action2]}, new float[]{this.f10483y[action2]}, new float[]{this.f10484z[action2]}));
                    return true;
                }
            } else if (action == 6) {
                int action3 = motionEvent.getAction() >> 8;
                if (this.f10481w || action3 == 0) {
                    b(this.f10483y, this.f10484z, pointerCount);
                    queueEvent(new g(new int[]{this.f10482x[action3]}, new float[]{this.f10483y[action3]}, new float[]{this.f10484z[action3]}));
                    return true;
                }
            }
            return this.f10468j;
        }
        b(this.f10483y, this.f10484z, 1);
        queueEvent(new a(new int[]{this.f10482x[0]}, new float[]{this.f10483y[0]}, new float[]{this.f10484z[0]}));
        return true;
    }

    public void setFps(long j10) {
        if (j10 >= 60) {
            this.f10463e = 60L;
        } else {
            this.f10463e = j10;
        }
        this.f10467i = this.f10463e;
        this.f10464f = (1.0f / ((float) r4)) * 1.0E9f;
    }

    public void setGameBundlePath(String str) {
        queueEvent(new b(str));
    }

    public void setNativeInited(boolean z10) {
        this.f10462d = z10;
    }

    public void setSwallowTouches(boolean z10) {
        this.f10468j = z10;
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        super.surfaceDestroyed(surfaceHolder);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public class h implements GLSurfaceView.EGLContextFactory {

        /* renamed from: a, reason: collision with root package name */
        public int f10511a;

        public h() {
            this.f10511a = 12440;
        }

        @Override // android.opengl.GLSurfaceView.EGLContextFactory
        public EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            return egl10.eglCreateContext(eGLDisplay, eGLConfig, EGL10.EGL_NO_CONTEXT, new int[]{this.f10511a, 2, 12344});
        }

        @Override // android.opengl.GLSurfaceView.EGLContextFactory
        public void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            if (!egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("BEFGame error: display:");
                sb2.append((Object) eGLDisplay);
                sb2.append(" context: ");
                sb2.append((Object) eGLContext);
            }
            if (BEFGameView.this.getNativeInited()) {
                BEFGameView.this.setNativeInited(false);
                NativeInterface.c(BEFGameView.this.f10460b);
                BEFGameView.this.c();
            }
        }

        public /* synthetic */ h(BEFGameView bEFGameView, b bVar) {
            this();
        }
    }
}

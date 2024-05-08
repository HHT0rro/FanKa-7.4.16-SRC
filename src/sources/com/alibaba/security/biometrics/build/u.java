package com.alibaba.security.biometrics.build;

import android.content.Context;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsParams;
import com.alibaba.security.common.beauty.IBeautyRender;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* compiled from: CameraRender.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class u implements GLSurfaceView.Renderer {

    /* renamed from: d, reason: collision with root package name */
    private static final String f2374d = "CameraRender";

    /* renamed from: e, reason: collision with root package name */
    private static final float[] f2375e = {1.0f, 1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, -1.0f, -1.0f, 1.0f, -1.0f};

    /* renamed from: f, reason: collision with root package name */
    private static final float[] f2376f = {1.0f, 1.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};

    /* renamed from: s, reason: collision with root package name */
    private static final String f2377s = "attribute vec4 avVertex;                                              \nattribute vec4 avVertexCoordinate;                                    \nuniform mat4 umTransformMatrix;                                       \nvarying vec2 vvTextureCoordinate;                                     \nvoid main() {                                                         \n    vvTextureCoordinate= (umTransformMatrix * avVertexCoordinate).xy; \n    gl_Position = avVertex;                                           \n}                                                                     \n";

    /* renamed from: t, reason: collision with root package name */
    private static final String f2378t = "#extension GL_OES_EGL_image_external : require                       \nprecision mediump float;                                             \nuniform samplerExternalOES usTextureOes;                             \nvarying vec2 vvTextureCoordinate;                                    \nvoid main() {                                                        \n    vec4 vCameraColor = texture2D(usTextureOes, vvTextureCoordinate);\n    gl_FragColor = vCameraColor;                                     \n}                                                                    \n";

    /* renamed from: a, reason: collision with root package name */
    public int f2379a;

    /* renamed from: b, reason: collision with root package name */
    public IBeautyRender f2380b;

    /* renamed from: c, reason: collision with root package name */
    public SurfaceTexture f2381c;

    /* renamed from: g, reason: collision with root package name */
    private final Context f2382g;

    /* renamed from: h, reason: collision with root package name */
    private final d f2383h;

    /* renamed from: i, reason: collision with root package name */
    private int f2384i;

    /* renamed from: j, reason: collision with root package name */
    private int f2385j;

    /* renamed from: k, reason: collision with root package name */
    private int f2386k;

    /* renamed from: l, reason: collision with root package name */
    private int f2387l;

    /* renamed from: m, reason: collision with root package name */
    private int f2388m;

    /* renamed from: n, reason: collision with root package name */
    private int f2389n;

    /* renamed from: o, reason: collision with root package name */
    private int f2390o;

    /* renamed from: p, reason: collision with root package name */
    private float[] f2391p = new float[16];

    /* renamed from: q, reason: collision with root package name */
    private FloatBuffer f2392q;

    /* renamed from: r, reason: collision with root package name */
    private FloatBuffer f2393r;

    public u(Context context, d dVar, ALBiometricsParams aLBiometricsParams) {
        this.f2382g = context;
        this.f2383h = dVar;
        if (aLBiometricsParams.isBeautyOpen) {
            try {
                this.f2380b = (IBeautyRender) Class.forName("com.alibaba.security.plugin.beauty.BeautyRenderManager").newInstance();
            } catch (Throwable unused) {
            }
        }
    }

    private void a() {
        float[] fArr = f2375e;
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(fArr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.f2392q = asFloatBuffer;
        asFloatBuffer.put(fArr).position(0);
        float[] fArr2 = f2376f;
        FloatBuffer put = ByteBuffer.allocateDirect(fArr2.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer().put(fArr2);
        this.f2393r = put;
        put.position(0);
        this.f2384i = GLES20.glCreateProgram();
        int a10 = a(35633, f2377s);
        this.f2385j = a10;
        GLES20.glAttachShader(this.f2384i, a10);
        int a11 = a(35632, f2378t);
        this.f2386k = a11;
        GLES20.glAttachShader(this.f2384i, a11);
        GLES20.glLinkProgram(this.f2384i);
    }

    private void b() {
        SurfaceTexture surfaceTexture = this.f2381c;
        if (surfaceTexture != null) {
            surfaceTexture.updateTexImage();
            this.f2381c.getTransformMatrix(this.f2391p);
        }
        GLES20.glClearColor(1.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glClear(16384);
        GLES20.glUseProgram(this.f2384i);
        this.f2387l = GLES20.glGetAttribLocation(this.f2384i, "avVertex");
        this.f2390o = GLES20.glGetAttribLocation(this.f2384i, "avVertexCoordinate");
        this.f2388m = GLES20.glGetUniformLocation(this.f2384i, "umTransformMatrix");
        this.f2389n = GLES20.glGetUniformLocation(this.f2384i, "usTextureOes");
        GLES20.glVertexAttribPointer(this.f2387l, 2, 5126, false, 8, (Buffer) this.f2392q);
        GLES20.glVertexAttribPointer(this.f2390o, 2, 5126, false, 8, (Buffer) this.f2393r);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, this.f2379a);
        GLES20.glUniform1i(this.f2389n, 0);
        GLES20.glUniformMatrix4fv(this.f2388m, 1, false, this.f2391p, 0);
        GLES20.glEnableVertexAttribArray(this.f2387l);
        GLES20.glEnableVertexAttribArray(this.f2390o);
        GLES20.glDrawArrays(4, 0, 6);
        GLES20.glDisableVertexAttribArray(this.f2387l);
        GLES20.glDisableVertexAttribArray(this.f2390o);
    }

    private void c() {
        SurfaceTexture surfaceTexture = this.f2381c;
        if (surfaceTexture != null) {
            surfaceTexture.release();
            this.f2381c = null;
        }
        this.f2379a = -1;
        IBeautyRender iBeautyRender = this.f2380b;
        if (iBeautyRender != null) {
            iBeautyRender.release();
        }
    }

    private static int d() {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        GLES20.glBindTexture(36197, iArr[0]);
        GLES20.glTexParameterf(36197, 10241, 9728.0f);
        GLES20.glTexParameterf(36197, 10240, 9729.0f);
        GLES20.glTexParameterf(36197, 10242, 33071.0f);
        GLES20.glTexParameterf(36197, 10243, 33071.0f);
        GLES20.glBindTexture(36197, 0);
        return iArr[0];
    }

    private SurfaceTexture e() {
        return this.f2381c;
    }

    private void f() {
        IBeautyRender iBeautyRender = this.f2380b;
        if (iBeautyRender != null) {
            iBeautyRender.draw(this.f2383h.h(), this.f2391p);
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public final void onDrawFrame(GL10 gl10) {
        SurfaceTexture surfaceTexture = this.f2381c;
        if (surfaceTexture != null) {
            surfaceTexture.updateTexImage();
            this.f2381c.getTransformMatrix(this.f2391p);
        }
        GLES20.glClearColor(1.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glClear(16384);
        GLES20.glUseProgram(this.f2384i);
        this.f2387l = GLES20.glGetAttribLocation(this.f2384i, "avVertex");
        this.f2390o = GLES20.glGetAttribLocation(this.f2384i, "avVertexCoordinate");
        this.f2388m = GLES20.glGetUniformLocation(this.f2384i, "umTransformMatrix");
        this.f2389n = GLES20.glGetUniformLocation(this.f2384i, "usTextureOes");
        GLES20.glVertexAttribPointer(this.f2387l, 2, 5126, false, 8, (Buffer) this.f2392q);
        GLES20.glVertexAttribPointer(this.f2390o, 2, 5126, false, 8, (Buffer) this.f2393r);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, this.f2379a);
        GLES20.glUniform1i(this.f2389n, 0);
        GLES20.glUniformMatrix4fv(this.f2388m, 1, false, this.f2391p, 0);
        GLES20.glEnableVertexAttribArray(this.f2387l);
        GLES20.glEnableVertexAttribArray(this.f2390o);
        GLES20.glDrawArrays(4, 0, 6);
        GLES20.glDisableVertexAttribArray(this.f2387l);
        GLES20.glDisableVertexAttribArray(this.f2390o);
        IBeautyRender iBeautyRender = this.f2380b;
        if (iBeautyRender != null) {
            iBeautyRender.draw(this.f2383h.h(), this.f2391p);
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public final void onSurfaceChanged(GL10 gl10, int i10, int i11) {
        GLES20.glViewport(0, 0, i10, i11);
        IBeautyRender iBeautyRender = this.f2380b;
        if (iBeautyRender != null) {
            iBeautyRender.onChanged(i10, i11);
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public final void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        IBeautyRender iBeautyRender;
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        GLES20.glBindTexture(36197, iArr[0]);
        GLES20.glTexParameterf(36197, 10241, 9728.0f);
        GLES20.glTexParameterf(36197, 10240, 9729.0f);
        GLES20.glTexParameterf(36197, 10242, 33071.0f);
        GLES20.glTexParameterf(36197, 10243, 33071.0f);
        GLES20.glBindTexture(36197, 0);
        this.f2379a = iArr[0];
        this.f2381c = new SurfaceTexture(this.f2379a);
        float[] fArr = f2375e;
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(fArr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.f2392q = asFloatBuffer;
        asFloatBuffer.put(fArr).position(0);
        float[] fArr2 = f2376f;
        FloatBuffer put = ByteBuffer.allocateDirect(fArr2.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer().put(fArr2);
        this.f2393r = put;
        put.position(0);
        this.f2384i = GLES20.glCreateProgram();
        int a10 = a(35633, f2377s);
        this.f2385j = a10;
        GLES20.glAttachShader(this.f2384i, a10);
        int a11 = a(35632, f2378t);
        this.f2386k = a11;
        GLES20.glAttachShader(this.f2384i, a11);
        GLES20.glLinkProgram(this.f2384i);
        Point g3 = this.f2383h.g();
        if (g3 == null || (iBeautyRender = this.f2380b) == null) {
            return;
        }
        iBeautyRender.onCreated(this.f2382g, g3.x, g3.y, this.f2383h.i(), this.f2379a);
    }

    private static int a(int i10, String str) {
        int glCreateShader = GLES20.glCreateShader(i10);
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        return glCreateShader;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0085 A[Catch: IOException -> 0x0081, TryCatch #5 {IOException -> 0x0081, blocks: (B:47:0x007d, B:38:0x0085, B:40:0x008a), top: B:46:0x007d }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x008a A[Catch: IOException -> 0x0081, TRY_LEAVE, TryCatch #5 {IOException -> 0x0081, blocks: (B:47:0x007d, B:38:0x0085, B:40:0x008a), top: B:46:0x007d }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x007d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r5v0, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v6, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r5v9, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r6v0, types: [int] */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.io.InputStreamReader] */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r6v9, types: [java.io.Reader, java.io.InputStreamReader] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String a(android.content.Context r5, int r6) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r1 = 0
            android.content.res.Resources r5 = r5.getResources()     // Catch: java.lang.Throwable -> L52 java.io.IOException -> L56
            java.io.InputStream r5 = r5.openRawResource(r6)     // Catch: java.lang.Throwable -> L52 java.io.IOException -> L56
            java.io.InputStreamReader r6 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L49 java.io.IOException -> L4d
            r6.<init>(r5)     // Catch: java.lang.Throwable -> L49 java.io.IOException -> L4d
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L41 java.io.IOException -> L44
            r2.<init>(r6)     // Catch: java.lang.Throwable -> L41 java.io.IOException -> L44
        L18:
            java.lang.String r1 = r2.readLine()     // Catch: java.io.IOException -> L3f java.lang.Throwable -> L79
            if (r1 == 0) goto L33
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.io.IOException -> L3f java.lang.Throwable -> L79
            r3.<init>()     // Catch: java.io.IOException -> L3f java.lang.Throwable -> L79
            r3.append(r1)     // Catch: java.io.IOException -> L3f java.lang.Throwable -> L79
            java.lang.String r1 = "\n"
            r3.append(r1)     // Catch: java.io.IOException -> L3f java.lang.Throwable -> L79
            java.lang.String r1 = r3.toString()     // Catch: java.io.IOException -> L3f java.lang.Throwable -> L79
            r0.append(r1)     // Catch: java.io.IOException -> L3f java.lang.Throwable -> L79
            goto L18
        L33:
            if (r5 == 0) goto L38
            r5.close()     // Catch: java.io.IOException -> L64
        L38:
            r6.close()     // Catch: java.io.IOException -> L64
            r2.close()     // Catch: java.io.IOException -> L64
            goto L74
        L3f:
            r1 = move-exception
            goto L5b
        L41:
            r0 = move-exception
            r2 = r1
            goto L7a
        L44:
            r2 = move-exception
            r4 = r2
            r2 = r1
            r1 = r4
            goto L5b
        L49:
            r0 = move-exception
            r6 = r1
            r2 = r6
            goto L7a
        L4d:
            r6 = move-exception
            r2 = r1
            r1 = r6
            r6 = r2
            goto L5b
        L52:
            r0 = move-exception
            r6 = r1
            r2 = r6
            goto L7b
        L56:
            r5 = move-exception
            r6 = r1
            r2 = r6
            r1 = r5
            r5 = r2
        L5b:
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L79
            if (r5 == 0) goto L66
            r5.close()     // Catch: java.io.IOException -> L64
            goto L66
        L64:
            r5 = move-exception
            goto L71
        L66:
            if (r6 == 0) goto L6b
            r6.close()     // Catch: java.io.IOException -> L64
        L6b:
            if (r2 == 0) goto L74
            r2.close()     // Catch: java.io.IOException -> L64
            goto L74
        L71:
            r5.printStackTrace()
        L74:
            java.lang.String r5 = r0.toString()
            return r5
        L79:
            r0 = move-exception
        L7a:
            r1 = r5
        L7b:
            if (r1 == 0) goto L83
            r1.close()     // Catch: java.io.IOException -> L81
            goto L83
        L81:
            r5 = move-exception
            goto L8e
        L83:
            if (r6 == 0) goto L88
            r6.close()     // Catch: java.io.IOException -> L81
        L88:
            if (r2 == 0) goto L91
            r2.close()     // Catch: java.io.IOException -> L81
            goto L91
        L8e:
            r5.printStackTrace()
        L91:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.security.biometrics.build.u.a(android.content.Context, int):java.lang.String");
    }
}

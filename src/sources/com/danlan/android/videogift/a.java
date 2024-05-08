package com.danlan.android.videogift;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.view.Surface;
import com.android.internal.logging.nano.MetricsProto;
import com.danlan.android.videogift.GLTextureView;
import com.huawei.openalliance.ad.constant.u;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.Locale;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* compiled from: VideoRenderer.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class a implements GLTextureView.n, SurfaceTexture.OnFrameAvailableListener {

    /* renamed from: w, reason: collision with root package name */
    public static int f19134w = 36197;

    /* renamed from: b, reason: collision with root package name */
    public final float[] f19135b;

    /* renamed from: c, reason: collision with root package name */
    public FloatBuffer f19136c;

    /* renamed from: j, reason: collision with root package name */
    public int f19143j;

    /* renamed from: k, reason: collision with root package name */
    public int f19144k;

    /* renamed from: l, reason: collision with root package name */
    public int f19145l;

    /* renamed from: m, reason: collision with root package name */
    public int f19146m;

    /* renamed from: n, reason: collision with root package name */
    public int f19147n;

    /* renamed from: o, reason: collision with root package name */
    public int f19148o;

    /* renamed from: p, reason: collision with root package name */
    public SurfaceTexture f19149p;

    /* renamed from: r, reason: collision with root package name */
    public InterfaceC0178a f19151r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f19152s;

    /* renamed from: d, reason: collision with root package name */
    public final String f19137d = "uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n  gl_Position = uMVPMatrix * aPosition;\n  vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n";

    /* renamed from: e, reason: collision with root package name */
    public final String f19138e = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvarying mediump float text_alpha_out;\nvoid main() {\n  vec4 color = texture2D(sTexture, vTextureCoord);\n  float red = %f;\n  float green = %f;\n  float blue = %f;\n  float accuracy = %f;\n  if (abs(color.r - red) <= accuracy && abs(color.g - green) <= accuracy && abs(color.b - blue) <= accuracy) {\n      gl_FragColor = vec4(color.r, color.g, color.b, 0.0);\n  } else {\n      gl_FragColor = vec4(color.r, color.g, color.b, 1.0);\n  }\n}\n";

    /* renamed from: f, reason: collision with root package name */
    public double f19139f = 0.95d;

    /* renamed from: g, reason: collision with root package name */
    public String f19140g = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvarying mediump float text_alpha_out;\nvoid main() {\n  vec4 color = texture2D(sTexture, vTextureCoord);\n  float red = %f;\n  float green = %f;\n  float blue = %f;\n  float accuracy = %f;\n  if (abs(color.r - red) <= accuracy && abs(color.g - green) <= accuracy && abs(color.b - blue) <= accuracy) {\n      gl_FragColor = vec4(color.r, color.g, color.b, 0.0);\n  } else {\n      gl_FragColor = vec4(color.r, color.g, color.b, 1.0);\n  }\n}\n";

    /* renamed from: h, reason: collision with root package name */
    public float[] f19141h = new float[16];

    /* renamed from: i, reason: collision with root package name */
    public float[] f19142i = new float[16];

    /* renamed from: q, reason: collision with root package name */
    public boolean f19150q = false;

    /* renamed from: t, reason: collision with root package name */
    public float f19153t = 0.0f;

    /* renamed from: u, reason: collision with root package name */
    public float f19154u = 1.0f;

    /* renamed from: v, reason: collision with root package name */
    public float f19155v = 0.0f;

    /* compiled from: VideoRenderer.java */
    /* renamed from: com.danlan.android.videogift.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface InterfaceC0178a {
        void a(Surface surface);
    }

    public a() {
        float[] fArr = {-1.0f, -1.0f, 0.0f, 0.0f, 0.0f, 1.0f, -1.0f, 0.0f, 1.0f, 0.0f, -1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f};
        this.f19135b = fArr;
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(fArr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.f19136c = asFloatBuffer;
        asFloatBuffer.put(fArr).position(0);
        Matrix.setIdentityM(this.f19142i, 0);
    }

    public final void a(String str) {
        int glGetError = GLES20.glGetError();
        if (glGetError == 0) {
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(": glError ");
        sb2.append(glGetError);
        throw new RuntimeException(str + ": glError " + glGetError);
    }

    public final int b(String str, String str2) {
        int c4;
        int c10 = c(35633, str);
        if (c10 == 0 || (c4 = c(35632, str2)) == 0) {
            return 0;
        }
        int glCreateProgram = GLES20.glCreateProgram();
        if (glCreateProgram != 0) {
            GLES20.glAttachShader(glCreateProgram, c10);
            a("glAttachShader");
            GLES20.glAttachShader(glCreateProgram, c4);
            a("glAttachShader");
            GLES20.glLinkProgram(glCreateProgram);
            int[] iArr = new int[1];
            GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
            if (iArr[0] != 1) {
                GLES20.glGetProgramInfoLog(glCreateProgram);
                GLES20.glDeleteProgram(glCreateProgram);
                return 0;
            }
        }
        return glCreateProgram;
    }

    public final int c(int i10, String str) {
        int glCreateShader = GLES20.glCreateShader(i10);
        if (glCreateShader == 0) {
            return glCreateShader;
        }
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] != 0) {
            return glCreateShader;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Could not compile shader ");
        sb2.append(i10);
        sb2.append(u.bD);
        GLES20.glGetShaderInfoLog(glCreateShader);
        GLES20.glDeleteShader(glCreateShader);
        return 0;
    }

    public final void d() {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        int i10 = iArr[0];
        this.f19144k = i10;
        GLES20.glBindTexture(f19134w, i10);
        a("glBindTexture textureID");
        GLES20.glTexParameterf(f19134w, 10241, 9728.0f);
        GLES20.glTexParameterf(f19134w, 10240, 9729.0f);
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.f19144k);
        this.f19149p = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(this);
        this.f19151r.a(new Surface(this.f19149p));
        synchronized (this) {
            this.f19150q = false;
        }
    }

    public final String e() {
        return this.f19152s ? this.f19140g : String.format(Locale.ENGLISH, "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvarying mediump float text_alpha_out;\nvoid main() {\n  vec4 color = texture2D(sTexture, vTextureCoord);\n  float red = %f;\n  float green = %f;\n  float blue = %f;\n  float accuracy = %f;\n  if (abs(color.r - red) <= accuracy && abs(color.g - green) <= accuracy && abs(color.b - blue) <= accuracy) {\n      gl_FragColor = vec4(color.r, color.g, color.b, 0.0);\n  } else {\n      gl_FragColor = vec4(color.r, color.g, color.b, 1.0);\n  }\n}\n", Float.valueOf(this.f19153t), Float.valueOf(this.f19154u), Float.valueOf(this.f19155v), Double.valueOf(1.0d - this.f19139f));
    }

    public void f(String str) {
        this.f19152s = true;
        this.f19140g = str;
    }

    public void g(InterfaceC0178a interfaceC0178a) {
        this.f19151r = interfaceC0178a;
    }

    @Override // com.danlan.android.videogift.GLTextureView.n
    public void onDrawFrame(GL10 gl10) {
        synchronized (this) {
            if (this.f19150q) {
                this.f19149p.updateTexImage();
                this.f19149p.getTransformMatrix(this.f19142i);
                this.f19150q = false;
            }
        }
        GLES20.glClear(16640);
        GLES20.glEnable(3042);
        GLES20.glBlendFunc(MetricsProto.MetricsEvent.APP_SPECIAL_PERMISSION_APPDRAW_ALLOW, MetricsProto.MetricsEvent.APP_SPECIAL_PERMISSION_APPDRAW_DENY);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glUseProgram(this.f19143j);
        a("glUseProgram");
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(f19134w, this.f19144k);
        this.f19136c.position(0);
        GLES20.glVertexAttribPointer(this.f19147n, 3, 5126, false, 20, (Buffer) this.f19136c);
        a("glVertexAttribPointer maPosition");
        GLES20.glEnableVertexAttribArray(this.f19147n);
        a("glEnableVertexAttribArray aPositionHandle");
        this.f19136c.position(3);
        GLES20.glVertexAttribPointer(this.f19148o, 3, 5126, false, 20, (Buffer) this.f19136c);
        a("glVertexAttribPointer aTextureHandle");
        GLES20.glEnableVertexAttribArray(this.f19148o);
        a("glEnableVertexAttribArray aTextureHandle");
        Matrix.setIdentityM(this.f19141h, 0);
        GLES20.glUniformMatrix4fv(this.f19145l, 1, false, this.f19141h, 0);
        GLES20.glUniformMatrix4fv(this.f19146m, 1, false, this.f19142i, 0);
        GLES20.glDrawArrays(5, 0, 4);
        a("glDrawArrays");
        GLES20.glFinish();
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public synchronized void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.f19150q = true;
    }

    @Override // com.danlan.android.videogift.GLTextureView.n
    public void onSurfaceChanged(GL10 gl10, int i10, int i11) {
        GLES20.glViewport(0, 0, i10, i11);
    }

    @Override // com.danlan.android.videogift.GLTextureView.n
    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        int b4 = b("uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n  gl_Position = uMVPMatrix * aPosition;\n  vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n", e());
        this.f19143j = b4;
        if (b4 == 0) {
            return;
        }
        this.f19147n = GLES20.glGetAttribLocation(b4, "aPosition");
        a("glGetAttribLocation aPosition");
        if (this.f19147n != -1) {
            this.f19148o = GLES20.glGetAttribLocation(this.f19143j, "aTextureCoord");
            a("glGetAttribLocation aTextureCoord");
            if (this.f19148o != -1) {
                this.f19145l = GLES20.glGetUniformLocation(this.f19143j, "uMVPMatrix");
                a("glGetUniformLocation uMVPMatrix");
                if (this.f19145l != -1) {
                    this.f19146m = GLES20.glGetUniformLocation(this.f19143j, "uSTMatrix");
                    a("glGetUniformLocation uSTMatrix");
                    if (this.f19146m != -1) {
                        d();
                        return;
                    }
                    throw new RuntimeException("Could not get attrib location for uSTMatrix");
                }
                throw new RuntimeException("Could not get attrib location for uMVPMatrix");
            }
            throw new RuntimeException("Could not get attrib location for aTextureCoord");
        }
        throw new RuntimeException("Could not get attrib location for aPosition");
    }
}

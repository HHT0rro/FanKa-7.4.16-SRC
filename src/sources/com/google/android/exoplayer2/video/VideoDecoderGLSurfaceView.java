package com.google.android.exoplayer2.video;

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.i;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.util.concurrent.atomic.AtomicReference;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import q6.f;
import q6.g;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class VideoDecoderGLSurfaceView extends GLSurfaceView implements g {

    /* renamed from: b, reason: collision with root package name */
    public final a f23056b;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a implements GLSurfaceView.Renderer {

        /* renamed from: l, reason: collision with root package name */
        public static final float[] f23057l = {1.164f, 1.164f, 1.164f, 0.0f, -0.392f, 2.017f, 1.596f, -0.813f, 0.0f};

        /* renamed from: m, reason: collision with root package name */
        public static final float[] f23058m = {1.164f, 1.164f, 1.164f, 0.0f, -0.213f, 2.112f, 1.793f, -0.533f, 0.0f};

        /* renamed from: n, reason: collision with root package name */
        public static final float[] f23059n = {1.168f, 1.168f, 1.168f, 0.0f, -0.188f, 2.148f, 1.683f, -0.652f, 0.0f};

        /* renamed from: o, reason: collision with root package name */
        public static final String[] f23060o = {"y_tex", "u_tex", "v_tex"};

        /* renamed from: p, reason: collision with root package name */
        public static final FloatBuffer f23061p = i.f(new float[]{-1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f, -1.0f});

        /* renamed from: b, reason: collision with root package name */
        public final GLSurfaceView f23062b;

        /* renamed from: c, reason: collision with root package name */
        public final int[] f23063c = new int[3];

        /* renamed from: d, reason: collision with root package name */
        public final int[] f23064d = new int[3];

        /* renamed from: e, reason: collision with root package name */
        public final int[] f23065e = new int[3];

        /* renamed from: f, reason: collision with root package name */
        public final int[] f23066f = new int[3];

        /* renamed from: g, reason: collision with root package name */
        public final AtomicReference<f> f23067g = new AtomicReference<>();

        /* renamed from: h, reason: collision with root package name */
        public final FloatBuffer[] f23068h = new FloatBuffer[3];

        /* renamed from: i, reason: collision with root package name */
        public int f23069i;

        /* renamed from: j, reason: collision with root package name */
        public int f23070j;

        /* renamed from: k, reason: collision with root package name */
        public f f23071k;

        public a(GLSurfaceView gLSurfaceView) {
            this.f23062b = gLSurfaceView;
            for (int i10 = 0; i10 < 3; i10++) {
                int[] iArr = this.f23065e;
                this.f23066f[i10] = -1;
                iArr[i10] = -1;
            }
        }

        public void a(f fVar) {
            f andSet = this.f23067g.getAndSet(fVar);
            if (andSet != null) {
                andSet.p();
            }
            this.f23062b.requestRender();
        }

        public final void b() {
            GLES20.glGenTextures(3, this.f23063c, 0);
            for (int i10 = 0; i10 < 3; i10++) {
                GLES20.glUniform1i(GLES20.glGetUniformLocation(this.f23069i, f23060o[i10]), i10);
                GLES20.glActiveTexture(33984 + i10);
                GLES20.glBindTexture(3553, this.f23063c[i10]);
                GLES20.glTexParameterf(3553, 10241, 9729.0f);
                GLES20.glTexParameterf(3553, 10240, 9729.0f);
                GLES20.glTexParameterf(3553, 10242, 33071.0f);
                GLES20.glTexParameterf(3553, 10243, 33071.0f);
            }
            i.b();
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            f andSet = this.f23067g.getAndSet(null);
            if (andSet == null && this.f23071k == null) {
                return;
            }
            if (andSet != null) {
                f fVar = this.f23071k;
                if (fVar != null) {
                    fVar.p();
                }
                this.f23071k = andSet;
            }
            f fVar2 = (f) com.google.android.exoplayer2.util.a.e(this.f23071k);
            float[] fArr = f23058m;
            int i10 = fVar2.f53090i;
            if (i10 == 1) {
                fArr = f23057l;
            } else if (i10 == 3) {
                fArr = f23059n;
            }
            GLES20.glUniformMatrix3fv(this.f23070j, 1, false, fArr, 0);
            int[] iArr = (int[]) com.google.android.exoplayer2.util.a.e(fVar2.f53089h);
            ByteBuffer[] byteBufferArr = (ByteBuffer[]) com.google.android.exoplayer2.util.a.e(fVar2.f53088g);
            int i11 = 0;
            while (i11 < 3) {
                int i12 = i11 == 0 ? fVar2.f53087f : (fVar2.f53087f + 1) / 2;
                GLES20.glActiveTexture(33984 + i11);
                GLES20.glBindTexture(3553, this.f23063c[i11]);
                GLES20.glPixelStorei(3317, 1);
                GLES20.glTexImage2D(3553, 0, 6409, iArr[i11], i12, 0, 6409, 5121, byteBufferArr[i11]);
                i11++;
            }
            int i13 = (r3[0] + 1) / 2;
            int[] iArr2 = {fVar2.f53086e, i13, i13};
            for (int i14 = 0; i14 < 3; i14++) {
                if (this.f23065e[i14] != iArr2[i14] || this.f23066f[i14] != iArr[i14]) {
                    com.google.android.exoplayer2.util.a.g(iArr[i14] != 0);
                    float f10 = iArr2[i14] / iArr[i14];
                    this.f23068h[i14] = i.f(new float[]{0.0f, 0.0f, 0.0f, 1.0f, f10, 0.0f, f10, 1.0f});
                    GLES20.glVertexAttribPointer(this.f23064d[i14], 2, 5126, false, 0, (Buffer) this.f23068h[i14]);
                    this.f23065e[i14] = iArr2[i14];
                    this.f23066f[i14] = iArr[i14];
                }
            }
            GLES20.glClear(16384);
            GLES20.glDrawArrays(5, 0, 4);
            i.b();
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i10, int i11) {
            GLES20.glViewport(0, 0, i10, i11);
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            int c4 = i.c("varying vec2 interp_tc_y;\nvarying vec2 interp_tc_u;\nvarying vec2 interp_tc_v;\nattribute vec4 in_pos;\nattribute vec2 in_tc_y;\nattribute vec2 in_tc_u;\nattribute vec2 in_tc_v;\nvoid main() {\n  gl_Position = in_pos;\n  interp_tc_y = in_tc_y;\n  interp_tc_u = in_tc_u;\n  interp_tc_v = in_tc_v;\n}\n", "precision mediump float;\nvarying vec2 interp_tc_y;\nvarying vec2 interp_tc_u;\nvarying vec2 interp_tc_v;\nuniform sampler2D y_tex;\nuniform sampler2D u_tex;\nuniform sampler2D v_tex;\nuniform mat3 mColorConversion;\nvoid main() {\n  vec3 yuv;\n  yuv.x = texture2D(y_tex, interp_tc_y).r - 0.0625;\n  yuv.y = texture2D(u_tex, interp_tc_u).r - 0.5;\n  yuv.z = texture2D(v_tex, interp_tc_v).r - 0.5;\n  gl_FragColor = vec4(mColorConversion * yuv, 1.0);\n}\n");
            this.f23069i = c4;
            GLES20.glUseProgram(c4);
            int glGetAttribLocation = GLES20.glGetAttribLocation(this.f23069i, "in_pos");
            GLES20.glEnableVertexAttribArray(glGetAttribLocation);
            GLES20.glVertexAttribPointer(glGetAttribLocation, 2, 5126, false, 0, (Buffer) f23061p);
            this.f23064d[0] = GLES20.glGetAttribLocation(this.f23069i, "in_tc_y");
            GLES20.glEnableVertexAttribArray(this.f23064d[0]);
            this.f23064d[1] = GLES20.glGetAttribLocation(this.f23069i, "in_tc_u");
            GLES20.glEnableVertexAttribArray(this.f23064d[1]);
            this.f23064d[2] = GLES20.glGetAttribLocation(this.f23069i, "in_tc_v");
            GLES20.glEnableVertexAttribArray(this.f23064d[2]);
            i.b();
            this.f23070j = GLES20.glGetUniformLocation(this.f23069i, "mColorConversion");
            i.b();
            b();
            i.b();
        }
    }

    public VideoDecoderGLSurfaceView(Context context) {
        this(context, null);
    }

    @Deprecated
    public g getVideoDecoderOutputBufferRenderer() {
        return this;
    }

    public void setOutputBuffer(f fVar) {
        this.f23056b.a(fVar);
    }

    public VideoDecoderGLSurfaceView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a aVar = new a(this);
        this.f23056b = aVar;
        setPreserveEGLContextOnPause(true);
        setEGLContextClientVersion(2);
        setRenderer(aVar);
        setRenderMode(0);
    }
}

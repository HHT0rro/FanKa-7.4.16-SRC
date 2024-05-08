package com.google.android.exoplayer2.video.spherical;

import android.opengl.GLES20;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.video.spherical.Projection;
import java.nio.Buffer;
import java.nio.FloatBuffer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class ProjectionRenderer {

    /* renamed from: j, reason: collision with root package name */
    public static final String[] f23081j = {"uniform mat4 uMvpMatrix;", "uniform mat3 uTexMatrix;", "attribute vec4 aPosition;", "attribute vec2 aTexCoords;", "varying vec2 vTexCoords;", "void main() {", "  gl_Position = uMvpMatrix * aPosition;", "  vTexCoords = (uTexMatrix * vec3(aTexCoords, 1)).xy;", com.alipay.sdk.util.i.f4738d};

    /* renamed from: k, reason: collision with root package name */
    public static final String[] f23082k = {"#extension GL_OES_EGL_image_external : require", "precision mediump float;", "uniform samplerExternalOES uTexture;", "varying vec2 vTexCoords;", "void main() {", "  gl_FragColor = texture2D(uTexture, vTexCoords);", com.alipay.sdk.util.i.f4738d};

    /* renamed from: l, reason: collision with root package name */
    public static final float[] f23083l = {1.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 1.0f, 1.0f};

    /* renamed from: m, reason: collision with root package name */
    public static final float[] f23084m = {1.0f, 0.0f, 0.0f, 0.0f, -0.5f, 0.0f, 0.0f, 0.5f, 1.0f};

    /* renamed from: n, reason: collision with root package name */
    public static final float[] f23085n = {1.0f, 0.0f, 0.0f, 0.0f, -0.5f, 0.0f, 0.0f, 1.0f, 1.0f};

    /* renamed from: o, reason: collision with root package name */
    public static final float[] f23086o = {0.5f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 1.0f, 1.0f};

    /* renamed from: p, reason: collision with root package name */
    public static final float[] f23087p = {0.5f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.5f, 1.0f, 1.0f};

    /* renamed from: a, reason: collision with root package name */
    public int f23088a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public MeshData f23089b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public MeshData f23090c;

    /* renamed from: d, reason: collision with root package name */
    public int f23091d;

    /* renamed from: e, reason: collision with root package name */
    public int f23092e;

    /* renamed from: f, reason: collision with root package name */
    public int f23093f;

    /* renamed from: g, reason: collision with root package name */
    public int f23094g;

    /* renamed from: h, reason: collision with root package name */
    public int f23095h;

    /* renamed from: i, reason: collision with root package name */
    public int f23096i;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class MeshData {
        private final int drawMode;
        private final FloatBuffer textureBuffer;
        private final FloatBuffer vertexBuffer;
        private final int vertexCount;

        public MeshData(Projection.SubMesh subMesh) {
            this.vertexCount = subMesh.a();
            this.vertexBuffer = com.google.android.exoplayer2.util.i.f(subMesh.f23078c);
            this.textureBuffer = com.google.android.exoplayer2.util.i.f(subMesh.f23079d);
            int i10 = subMesh.f23077b;
            if (i10 == 1) {
                this.drawMode = 5;
            } else if (i10 != 2) {
                this.drawMode = 4;
            } else {
                this.drawMode = 6;
            }
        }
    }

    public static boolean c(Projection projection) {
        Projection.a aVar = projection.f23072a;
        Projection.a aVar2 = projection.f23073b;
        return aVar.b() == 1 && aVar.a(0).f23076a == 0 && aVar2.b() == 1 && aVar2.a(0).f23076a == 0;
    }

    public void a(int i10, float[] fArr, boolean z10) {
        float[] fArr2;
        MeshData meshData = z10 ? this.f23090c : this.f23089b;
        if (meshData == null) {
            return;
        }
        GLES20.glUseProgram(this.f23091d);
        com.google.android.exoplayer2.util.i.b();
        GLES20.glEnableVertexAttribArray(this.f23094g);
        GLES20.glEnableVertexAttribArray(this.f23095h);
        com.google.android.exoplayer2.util.i.b();
        int i11 = this.f23088a;
        if (i11 == 1) {
            fArr2 = z10 ? f23085n : f23084m;
        } else if (i11 == 2) {
            fArr2 = z10 ? f23087p : f23086o;
        } else {
            fArr2 = f23083l;
        }
        GLES20.glUniformMatrix3fv(this.f23093f, 1, false, fArr2, 0);
        GLES20.glUniformMatrix4fv(this.f23092e, 1, false, fArr, 0);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, i10);
        GLES20.glUniform1i(this.f23096i, 0);
        com.google.android.exoplayer2.util.i.b();
        GLES20.glVertexAttribPointer(this.f23094g, 3, 5126, false, 12, (Buffer) meshData.vertexBuffer);
        com.google.android.exoplayer2.util.i.b();
        GLES20.glVertexAttribPointer(this.f23095h, 2, 5126, false, 8, (Buffer) meshData.textureBuffer);
        com.google.android.exoplayer2.util.i.b();
        GLES20.glDrawArrays(meshData.drawMode, 0, meshData.vertexCount);
        com.google.android.exoplayer2.util.i.b();
        GLES20.glDisableVertexAttribArray(this.f23094g);
        GLES20.glDisableVertexAttribArray(this.f23095h);
    }

    public void b() {
        int d10 = com.google.android.exoplayer2.util.i.d(f23081j, f23082k);
        this.f23091d = d10;
        this.f23092e = GLES20.glGetUniformLocation(d10, "uMvpMatrix");
        this.f23093f = GLES20.glGetUniformLocation(this.f23091d, "uTexMatrix");
        this.f23094g = GLES20.glGetAttribLocation(this.f23091d, "aPosition");
        this.f23095h = GLES20.glGetAttribLocation(this.f23091d, "aTexCoords");
        this.f23096i = GLES20.glGetUniformLocation(this.f23091d, "uTexture");
    }

    public void d(Projection projection) {
        if (c(projection)) {
            this.f23088a = projection.f23074c;
            MeshData meshData = new MeshData(projection.f23072a.a(0));
            this.f23089b = meshData;
            if (!projection.f23075d) {
                meshData = new MeshData(projection.f23073b.a(0));
            }
            this.f23090c = meshData;
        }
    }
}

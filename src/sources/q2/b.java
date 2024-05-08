package q2;

import android.graphics.Point;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.widget.ImageView;
import com.effectsar.labcv.effectsdk.EffectsSDKEffectConstants;

/* compiled from: ImageUtil.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public int[] f53019a;

    /* renamed from: b, reason: collision with root package name */
    public int[] f53020b;

    /* renamed from: c, reason: collision with root package name */
    public int f53021c = 1;

    /* renamed from: d, reason: collision with root package name */
    public Point f53022d;

    /* renamed from: e, reason: collision with root package name */
    public o2.c f53023e;

    /* compiled from: ImageUtil.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public float[] f53024a;

        /* renamed from: b, reason: collision with root package name */
        public int f53025b = 0;

        public a() {
            float[] fArr = new float[16];
            this.f53024a = fArr;
            Matrix.setIdentityM(fArr, 0);
        }

        public a a(ImageView.ScaleType scaleType, int i10, int i11, int i12, int i13, int i14) {
            if (i10 % 180 == 90) {
                o2.a.g(this.f53024a, scaleType, i12, i11, i13, i14);
            } else {
                o2.a.g(this.f53024a, scaleType, i11, i12, i13, i14);
            }
            return this;
        }

        public a b(boolean z10, boolean z11) {
            o2.a.e(this.f53024a, z10, z11);
            return this;
        }

        public int c() {
            return this.f53025b % 360;
        }

        public float[] d() {
            return this.f53024a;
        }

        public a e(float f10) {
            this.f53025b = (int) (this.f53025b + f10);
            o2.a.i(this.f53024a, f10);
            return this;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            for (float f10 : this.f53024a) {
                sb2.append(f10);
                sb2.append("  ");
            }
            return sb2.toString();
        }
    }

    public final void a(int i10, int i11, int i12, int i13) {
        GLES20.glBindTexture(3553, i10);
        GLES20.glTexImage2D(3553, 0, 6408, i12, i13, 0, 6408, 5121, null);
        GLES20.glTexParameterf(3553, 10240, 9729.0f);
        GLES20.glTexParameterf(3553, 10241, 9729.0f);
        GLES20.glTexParameterf(3553, 10242, 33071.0f);
        GLES20.glTexParameterf(3553, 10243, 33071.0f);
        GLES20.glBindFramebuffer(36160, i11);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, i10, 0);
        GLES20.glBindTexture(3553, 0);
        GLES20.glBindFramebuffer(36160, 0);
    }

    public final void b() {
        int[] iArr = this.f53020b;
        if (iArr != null) {
            GLES20.glDeleteTextures(this.f53021c, iArr, 0);
            this.f53020b = null;
        }
        int[] iArr2 = this.f53019a;
        if (iArr2 != null) {
            GLES20.glDeleteFramebuffers(this.f53021c, iArr2, 0);
            this.f53019a = null;
        }
    }

    public void c(int i10, EffectsSDKEffectConstants.TextureFormat textureFormat, int i11, int i12, float[] fArr) {
        if (this.f53023e == null) {
            this.f53023e = new o2.c();
        }
        this.f53023e.a(textureFormat).d(i10, i11, i12, fArr);
    }

    public final void d(int i10, int i11) {
        Point point = this.f53022d;
        boolean z10 = true;
        boolean z11 = (point != null && point.x == i10 && point.y == i11) ? false : true;
        if (this.f53019a != null && this.f53020b != null) {
            z10 = z11;
        }
        if (z10) {
            b();
            int i12 = this.f53021c;
            int[] iArr = new int[i12];
            this.f53019a = iArr;
            this.f53020b = new int[i12];
            GLES20.glGenFramebuffers(i12, iArr, 0);
            GLES20.glGenTextures(this.f53021c, this.f53020b, 0);
            for (int i13 = 0; i13 < this.f53021c; i13++) {
                a(this.f53020b[i13], this.f53019a[i13], i10, i11);
            }
            this.f53022d = new Point(i10, i11);
        }
    }

    public int e(int i10, int i11) {
        d(i10, i11);
        return this.f53020b[0];
    }

    public void f() {
        b();
        o2.c cVar = this.f53023e;
        if (cVar != null) {
            cVar.b();
        }
    }

    public int g(int i10, EffectsSDKEffectConstants.TextureFormat textureFormat, EffectsSDKEffectConstants.TextureFormat textureFormat2, int i11, int i12, a aVar) {
        if (textureFormat2 != EffectsSDKEffectConstants.TextureFormat.Texure2D) {
            c.b("the inputTexture is not supported,please use Texure2D as output texture format");
            return -1;
        }
        if (this.f53023e == null) {
            this.f53023e = new o2.c();
        }
        boolean z10 = aVar.c() % 180 == 90;
        o2.b a10 = this.f53023e.a(textureFormat);
        int i13 = z10 ? i12 : i11;
        if (!z10) {
            i11 = i12;
        }
        return a10.c(i10, i13, i11, aVar.d());
    }
}

package o2;

import android.graphics.Point;
import android.opengl.GLES20;
import com.cupidapp.live.liveshow.beauty.databeauty.opengl.Drawable2d;

/* compiled from: Program.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public abstract class b {

    /* renamed from: g, reason: collision with root package name */
    public static final String f52256g = a.f52251a;

    /* renamed from: a, reason: collision with root package name */
    public int f52257a;

    /* renamed from: c, reason: collision with root package name */
    public int[] f52259c;

    /* renamed from: d, reason: collision with root package name */
    public int[] f52260d;

    /* renamed from: f, reason: collision with root package name */
    public Point f52262f;

    /* renamed from: e, reason: collision with root package name */
    public int f52261e = 1;

    /* renamed from: b, reason: collision with root package name */
    public Drawable2d f52258b = e();

    public b(String str, String str2) {
        this.f52257a = a.d(str, str2);
        f();
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
        int[] iArr = this.f52260d;
        if (iArr != null) {
            GLES20.glDeleteTextures(this.f52261e, iArr, 0);
            this.f52260d = null;
        }
        int[] iArr2 = this.f52259c;
        if (iArr2 != null) {
            GLES20.glDeleteFramebuffers(this.f52261e, iArr2, 0);
            this.f52259c = null;
        }
    }

    public abstract int c(int i10, int i11, int i12, float[] fArr);

    public abstract void d(int i10, int i11, int i12, float[] fArr);

    public abstract Drawable2d e();

    public abstract void f();

    public void g(int i10, int i11) {
        Point point = this.f52262f;
        boolean z10 = true;
        boolean z11 = (point != null && point.x == i10 && point.y == i11) ? false : true;
        if (this.f52259c != null && this.f52260d != null) {
            z10 = z11;
        }
        if (z10) {
            b();
            int i12 = this.f52261e;
            int[] iArr = new int[i12];
            this.f52259c = iArr;
            this.f52260d = new int[i12];
            GLES20.glGenFramebuffers(i12, iArr, 0);
            GLES20.glGenTextures(this.f52261e, this.f52260d, 0);
            for (int i13 = 0; i13 < this.f52261e; i13++) {
                a(this.f52260d[i13], this.f52259c[i13], i10, i11);
            }
            this.f52262f = new Point(i10, i11);
        }
    }

    public void h() {
        b();
        GLES20.glDeleteProgram(this.f52257a);
        this.f52257a = -1;
    }
}

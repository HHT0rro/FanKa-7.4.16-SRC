package o2;

import android.opengl.GLES20;
import android.opengl.Matrix;
import android.widget.ImageView;
import com.huawei.openalliance.ad.constant.u;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* compiled from: GlUtil.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final String f52251a = "a";

    /* renamed from: b, reason: collision with root package name */
    public static float f52252b = 1.0f;

    /* renamed from: c, reason: collision with root package name */
    public static float f52253c = 1.0f;

    /* renamed from: d, reason: collision with root package name */
    public static final float[] f52254d;

    /* compiled from: GlUtil.java */
    /* renamed from: o2.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static /* synthetic */ class C0798a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f52255a;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            f52255a = iArr;
            try {
                iArr[ImageView.ScaleType.CENTER_CROP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f52255a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f52255a[ImageView.ScaleType.FIT_START.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f52255a[ImageView.ScaleType.FIT_END.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    static {
        float[] fArr = new float[16];
        f52254d = fArr;
        Matrix.setIdentityM(fArr, 0);
    }

    public static void a(String str) {
        int glGetError = GLES20.glGetError();
        if (glGetError != 0) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append(": glError 0x");
            sb2.append(Integer.toHexString(glGetError));
        }
    }

    public static void b(int i10, String str) {
        if (i10 < 0) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Unable to locate '");
            sb2.append(str);
            sb2.append("' in program");
        }
    }

    public static FloatBuffer c(float[] fArr) {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(fArr.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
        asFloatBuffer.put(fArr);
        asFloatBuffer.position(0);
        return asFloatBuffer;
    }

    public static int d(String str, String str2) {
        int h10;
        int h11 = h(35633, str);
        int i10 = 0;
        if (h11 == 0 || (h10 = h(35632, str2)) == 0) {
            return 0;
        }
        int glCreateProgram = GLES20.glCreateProgram();
        a("glCreateProgram");
        GLES20.glAttachShader(glCreateProgram, h11);
        a("glAttachShader");
        GLES20.glAttachShader(glCreateProgram, h10);
        a("glAttachShader");
        GLES20.glLinkProgram(glCreateProgram);
        int[] iArr = new int[1];
        GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
        if (iArr[0] != 1) {
            GLES20.glGetProgramInfoLog(glCreateProgram);
            GLES20.glDeleteProgram(glCreateProgram);
        } else {
            i10 = glCreateProgram;
        }
        GLES20.glDeleteShader(h11);
        GLES20.glDeleteShader(h10);
        return i10;
    }

    public static float[] e(float[] fArr, boolean z10, boolean z11) {
        if (z10 || z11) {
            Matrix.scaleM(fArr, 0, z10 ? -1.0f : 1.0f, z11 ? -1.0f : 1.0f, 1.0f);
        }
        return fArr;
    }

    public static int f() {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        GLES20.glBindTexture(36197, iArr[0]);
        GLES20.glTexParameterf(36197, 10241, 9729.0f);
        GLES20.glTexParameterf(36197, 10240, 9729.0f);
        GLES20.glTexParameteri(36197, 10242, 33071);
        GLES20.glTexParameteri(36197, 10243, 33071);
        return iArr[0];
    }

    public static void g(float[] fArr, ImageView.ScaleType scaleType, int i10, int i11, int i12, int i13) {
        if (i11 <= 0 || i10 <= 0 || i12 <= 0 || i13 <= 0) {
            return;
        }
        float[] fArr2 = new float[16];
        float[] fArr3 = new float[16];
        if (scaleType == ImageView.ScaleType.FIT_XY) {
            Matrix.orthoM(fArr2, 0, -1.0f, 1.0f, -1.0f, 1.0f, 1.0f, 3.0f);
            Matrix.setLookAtM(fArr3, 0, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f);
            Matrix.multiplyMM(fArr, 0, fArr2, 0, fArr3, 0);
        }
        float f10 = i12 / i13;
        float f11 = i10 / i11;
        if (f11 > f10) {
            int i14 = C0798a.f52255a[scaleType.ordinal()];
            if (i14 == 1) {
                Matrix.orthoM(fArr2, 0, (-f10) / f11, f10 / f11, -1.0f, 1.0f, 1.0f, 3.0f);
                Matrix.scaleM(fArr2, 0, f52252b, f52253c, 1.0f);
            } else if (i14 == 2) {
                Matrix.orthoM(fArr2, 0, -1.0f, 1.0f, (-f11) / f10, f11 / f10, 1.0f, 3.0f);
            } else if (i14 == 3) {
                Matrix.orthoM(fArr2, 0, -1.0f, 1.0f, 1.0f - ((f11 * 2.0f) / f10), 1.0f, 1.0f, 3.0f);
            } else if (i14 == 4) {
                Matrix.orthoM(fArr2, 0, -1.0f, 1.0f, -1.0f, ((f11 * 2.0f) / f10) - 1.0f, 1.0f, 3.0f);
            }
        } else {
            int i15 = C0798a.f52255a[scaleType.ordinal()];
            if (i15 == 1) {
                Matrix.orthoM(fArr2, 0, -1.0f, 1.0f, (-f11) / f10, f11 / f10, 1.0f, 3.0f);
                Matrix.scaleM(fArr2, 0, f52252b, f52253c, 1.0f);
            } else if (i15 == 2) {
                Matrix.orthoM(fArr2, 0, (-f10) / f11, f10 / f11, -1.0f, 1.0f, 1.0f, 3.0f);
            } else if (i15 == 3) {
                Matrix.orthoM(fArr2, 0, -1.0f, ((f10 * 2.0f) / f11) - 1.0f, -1.0f, 1.0f, 1.0f, 3.0f);
            } else if (i15 == 4) {
                Matrix.orthoM(fArr2, 0, 1.0f - ((f10 * 2.0f) / f11), 1.0f, -1.0f, 1.0f, 1.0f, 3.0f);
            }
        }
        Matrix.setLookAtM(fArr3, 0, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f);
        Matrix.multiplyMM(fArr, 0, fArr2, 0, fArr3, 0);
    }

    public static int h(int i10, String str) {
        int glCreateShader = GLES20.glCreateShader(i10);
        a("glCreateShader type=" + i10);
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
        StringBuilder sb3 = new StringBuilder();
        sb3.append(" ");
        sb3.append(GLES20.glGetShaderInfoLog(glCreateShader));
        GLES20.glDeleteShader(glCreateShader);
        return 0;
    }

    public static float[] i(float[] fArr, float f10) {
        Matrix.rotateM(fArr, 0, f10, 0.0f, 0.0f, 1.0f);
        return fArr;
    }
}

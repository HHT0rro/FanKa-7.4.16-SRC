package com.tencent.liteav.beauty.b;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import com.android.internal.logging.nano.MetricsProto;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.Size;
import com.tencent.liteav.videobase.utils.OpenGlUtils;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import java.util.Arrays;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class n extends com.tencent.liteav.videobase.a.b {

    /* renamed from: a, reason: collision with root package name */
    public static final short[] f43086a;

    /* renamed from: b, reason: collision with root package name */
    public static final FloatBuffer f43087b;

    /* renamed from: c, reason: collision with root package name */
    public static final ShortBuffer f43088c;

    /* renamed from: h, reason: collision with root package name */
    private static final float[] f43089h = new float[8];

    /* renamed from: i, reason: collision with root package name */
    private static final float[] f43090i;

    /* renamed from: d, reason: collision with root package name */
    public a[] f43091d;

    /* renamed from: e, reason: collision with root package name */
    public List<o> f43092e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f43093f;

    /* renamed from: g, reason: collision with root package name */
    public int f43094g;

    /* renamed from: j, reason: collision with root package name */
    private a f43095j;

    /* renamed from: k, reason: collision with root package name */
    private int f43096k;

    /* renamed from: l, reason: collision with root package name */
    private o f43097l;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class a {

        /* renamed from: b, reason: collision with root package name */
        public Bitmap f43099b;

        /* renamed from: a, reason: collision with root package name */
        public FloatBuffer f43098a = null;

        /* renamed from: c, reason: collision with root package name */
        public int f43100c = -1;

        public final void a() {
            this.f43099b = null;
            OpenGlUtils.deleteTexture(this.f43100c);
            this.f43100c = -1;
        }
    }

    static {
        short[] sArr = {1, 2, 0, 2, 0, 3};
        f43086a = sArr;
        float[] fArr = {0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 0.0f};
        f43090i = fArr;
        f43087b = (FloatBuffer) ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder()).asFloatBuffer().put(fArr).asReadOnlyBuffer().position(0);
        f43088c = (ShortBuffer) ByteBuffer.allocateDirect(sArr.length * 2).order(ByteOrder.nativeOrder()).asShortBuffer().put(sArr).asReadOnlyBuffer().position(0);
    }

    public n() {
        this(com.tencent.liteav.videobase.a.b.NO_FILTER_VERTEX_SHADER, com.tencent.liteav.videobase.a.b.NO_FILTER_FRAGMENT_SHADER);
    }

    public final void a() {
        this.f43093f = true;
    }

    @Override // com.tencent.liteav.videobase.a.b
    public final void afterDrawArrays() {
        super.afterDrawArrays();
        if (!this.f43093f) {
            return;
        }
        GLES20.glEnable(3042);
        GLES20.glBlendFunc(this.f43094g, MetricsProto.MetricsEvent.APP_SPECIAL_PERMISSION_APPDRAW_DENY);
        int i10 = 0;
        while (true) {
            a[] aVarArr = this.f43091d;
            if (i10 < aVarArr.length) {
                if (aVarArr[i10] != null) {
                    GLES20.glActiveTexture(33984);
                    GLES20.glBindTexture(3553, this.f43091d[i10].f43100c);
                    GLES20.glUniform1i(this.mGLUniformTexture, 0);
                    GLES20.glVertexAttribPointer(this.mGLAttribPosition, 2, 5126, false, 8, (Buffer) this.f43091d[i10].f43098a);
                    GLES20.glEnableVertexAttribArray(this.mGLAttribPosition);
                    GLES20.glVertexAttribPointer(this.mGLAttribTextureCoord, 2, 5126, false, 0, (Buffer) f43087b);
                    GLES20.glEnableVertexAttribArray(this.mGLAttribTextureCoord);
                    GLES20.glDrawElements(4, f43086a.length, 5123, f43088c);
                    GLES20.glDisableVertexAttribArray(this.mGLAttribPosition);
                    GLES20.glDisableVertexAttribArray(this.mGLAttribTextureCoord);
                }
                i10++;
            } else {
                GLES20.glDisable(3042);
                return;
            }
        }
    }

    @Override // com.tencent.liteav.videobase.a.b
    public final void onInit(com.tencent.liteav.videobase.frame.e eVar) {
        super.onInit(eVar);
        o oVar = this.f43097l;
        if (oVar != null) {
            a(oVar.f43101a, oVar.f43102b, oVar.f43103c, oVar.f43104d);
        }
        List<o> list = this.f43092e;
        if (list != null) {
            a(list);
        }
    }

    @Override // com.tencent.liteav.videobase.a.b
    public final void onOutputSizeChanged(int i10, int i11) {
        Bitmap bitmap;
        Bitmap bitmap2;
        LiteavLog.i("TXCGPUWatermarkFilter", "onOutputSizeChanged,width=%d,height=%d", Integer.valueOf(i10), Integer.valueOf(i11));
        super.onOutputSizeChanged(i10, i11);
        if (this.f43091d == null) {
            return;
        }
        o oVar = this.f43097l;
        if (oVar != null && (bitmap2 = oVar.f43101a) != null) {
            int width = bitmap2.getWidth();
            int height = this.f43097l.f43101a.getHeight();
            o oVar2 = this.f43097l;
            a(width, height, oVar2.f43102b, oVar2.f43103c, oVar2.f43104d, 0);
        }
        if (this.f43092e == null) {
            return;
        }
        for (int i12 = 0; i12 < this.f43092e.size(); i12++) {
            o oVar3 = this.f43092e.get(i12);
            if (oVar3 != null && (bitmap = oVar3.f43101a) != null) {
                a(bitmap.getWidth(), oVar3.f43101a.getHeight(), oVar3.f43102b, oVar3.f43103c, oVar3.f43104d, i12 + this.f43096k);
            }
        }
    }

    @Override // com.tencent.liteav.videobase.a.b
    public final void onUninit() {
        super.onUninit();
        a[] aVarArr = this.f43091d;
        if (aVarArr == null || aVarArr.length == 0) {
            return;
        }
        int i10 = 0;
        while (true) {
            a[] aVarArr2 = this.f43091d;
            if (i10 < aVarArr2.length) {
                if (aVarArr2[i10] != null) {
                    aVarArr2[i10].a();
                    this.f43091d[i10] = null;
                }
                i10++;
            } else {
                this.f43091d = null;
                return;
            }
        }
    }

    private n(String str, String str2) {
        super(str, str2);
        this.f43091d = null;
        this.f43095j = null;
        this.f43092e = null;
        this.f43093f = false;
        this.f43094g = 1;
        this.f43096k = 1;
        this.f43097l = null;
    }

    private void a(Bitmap bitmap, float f10, float f11, float f12, int i10) {
        Bitmap bitmap2;
        a[] aVarArr = this.f43091d;
        if (aVarArr == null || i10 >= aVarArr.length || aVarArr[i10] == null) {
            LiteavLog.e("TXCGPUWatermarkFilter", "index is too large for mRenderObjects!");
            return;
        }
        if (bitmap == null) {
            LiteavLog.i("TXCGPUWatermarkFilter", "release %d watermark!", Integer.valueOf(i10));
            this.f43091d[i10].a();
            this.f43091d[i10] = null;
            return;
        }
        a(bitmap.getWidth(), bitmap.getHeight(), f10, f11, f12, i10);
        a aVar = this.f43091d[i10];
        Bitmap bitmap3 = aVar.f43099b;
        if (bitmap3 == null || !bitmap3.equals(bitmap)) {
            if (aVar.f43100c != -1 && (bitmap2 = aVar.f43099b) != null && (bitmap2.getWidth() != bitmap.getWidth() || aVar.f43099b.getHeight() != bitmap.getHeight())) {
                OpenGlUtils.deleteTexture(aVar.f43100c);
                aVar.f43100c = -1;
            }
            aVar.f43100c = OpenGlUtils.loadTexture(bitmap, aVar.f43100c, false);
        }
        aVar.f43099b = bitmap;
    }

    public final void a(Bitmap bitmap, float f10, float f11, float f12) {
        if (this.f43091d == null) {
            this.f43091d = new a[1];
        }
        a[] aVarArr = this.f43091d;
        if (aVarArr[0] == null) {
            aVarArr[0] = new a();
        }
        a(bitmap, f10, f11, f12, 0);
        this.f43095j = this.f43091d[0];
        if (bitmap == null) {
            this.f43097l = null;
            return;
        }
        if (this.f43097l == null) {
            this.f43097l = new o();
        }
        o oVar = this.f43097l;
        oVar.f43101a = bitmap;
        oVar.f43102b = f10;
        oVar.f43103c = f11;
        oVar.f43104d = f12;
    }

    private void a(int i10, int i11, float f10, float f11, float f12, int i12) {
        a[] aVarArr = this.f43091d;
        if (aVarArr != null && i12 < aVarArr.length && aVarArr[i12] != null) {
            a aVar = aVarArr[i12];
            float[] fArr = f43089h;
            aVar.f43098a = ByteBuffer.allocateDirect(fArr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
            float[] fArr2 = new float[fArr.length];
            fArr2[0] = (f10 * 2.0f) - 1.0f;
            fArr2[1] = 1.0f - (f11 * 2.0f);
            fArr2[2] = fArr2[0];
            float f13 = (i11 / i10) * f12;
            Size size = this.mOutputSize;
            fArr2[3] = fArr2[1] - (((f13 * size.width) / size.height) * 2.0f);
            fArr2[4] = fArr2[0] + (f12 * 2.0f);
            fArr2[5] = fArr2[3];
            fArr2[6] = fArr2[4];
            fArr2[7] = fArr2[1];
            for (int i13 = 1; i13 <= 7; i13 += 2) {
                fArr2[i13] = fArr2[i13] * (-1.0f);
            }
            this.f43091d[i12].f43098a.put(fArr2).position(0);
            return;
        }
        LiteavLog.e("TXCGPUWatermarkFilter", "calculateOffsetMatrix,index[%d],mRenderObjects=%s", Integer.valueOf(i12), Arrays.toString(this.f43091d));
    }

    public final void a(List<o> list) {
        List<o> list2 = this.f43092e;
        if (list2 != null && a(list2, list)) {
            LiteavLog.i("TXCGPUWatermarkFilter", "Same markList");
            return;
        }
        this.f43092e = list;
        if (this.f43091d != null) {
            int i10 = this.f43096k;
            while (true) {
                a[] aVarArr = this.f43091d;
                if (i10 >= aVarArr.length) {
                    break;
                }
                OpenGlUtils.deleteTexture(aVarArr[i10].f43100c);
                this.f43091d[i10].f43100c = -1;
                i10++;
            }
        }
        a[] aVarArr2 = new a[list.size() + this.f43096k];
        this.f43091d = aVarArr2;
        aVarArr2[0] = this.f43095j;
        for (int i11 = 0; i11 < list.size(); i11++) {
            o oVar = list.get(i11);
            if (oVar != null) {
                this.f43091d[this.f43096k + i11] = new a();
                a(oVar.f43101a, oVar.f43102b, oVar.f43103c, oVar.f43104d, i11 + this.f43096k);
            }
        }
    }

    private static boolean a(List<o> list, List<o> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i10 = 0; i10 < list.size(); i10++) {
            o oVar = list.get(i10);
            o oVar2 = list2.get(i10);
            if (!oVar.f43101a.equals(oVar2.f43101a) || oVar.f43102b != oVar2.f43102b || oVar.f43103c != oVar2.f43103c || oVar.f43104d != oVar2.f43104d) {
                return false;
            }
        }
        return true;
    }
}

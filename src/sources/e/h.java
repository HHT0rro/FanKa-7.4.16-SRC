package e;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.annotation.Nullable;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.i0;
import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.android.internal.logging.nano.MetricsProto;

/* compiled from: GradientStrokeContent.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class h extends a {
    public final f.a<PointF, PointF> A;

    @Nullable
    public f.q B;

    /* renamed from: r, reason: collision with root package name */
    public final String f48776r;

    /* renamed from: s, reason: collision with root package name */
    public final boolean f48777s;

    /* renamed from: t, reason: collision with root package name */
    public final LongSparseArray<LinearGradient> f48778t;

    /* renamed from: u, reason: collision with root package name */
    public final LongSparseArray<RadialGradient> f48779u;

    /* renamed from: v, reason: collision with root package name */
    public final RectF f48780v;

    /* renamed from: w, reason: collision with root package name */
    public final GradientType f48781w;

    /* renamed from: x, reason: collision with root package name */
    public final int f48782x;

    /* renamed from: y, reason: collision with root package name */
    public final f.a<j.c, j.c> f48783y;

    /* renamed from: z, reason: collision with root package name */
    public final f.a<PointF, PointF> f48784z;

    public h(LottieDrawable lottieDrawable, BaseLayer baseLayer, com.airbnb.lottie.model.content.a aVar) {
        super(lottieDrawable, baseLayer, aVar.a().toPaintCap(), aVar.f().toPaintJoin(), aVar.h(), aVar.j(), aVar.l(), aVar.g(), aVar.b());
        this.f48778t = new LongSparseArray<>();
        this.f48779u = new LongSparseArray<>();
        this.f48780v = new RectF();
        this.f48776r = aVar.i();
        this.f48781w = aVar.e();
        this.f48777s = aVar.m();
        this.f48782x = (int) (lottieDrawable.J().d() / 32.0f);
        f.a<j.c, j.c> a10 = aVar.d().a();
        this.f48783y = a10;
        a10.a(this);
        baseLayer.i(a10);
        f.a<PointF, PointF> a11 = aVar.k().a();
        this.f48784z = a11;
        a11.a(this);
        baseLayer.i(a11);
        f.a<PointF, PointF> a12 = aVar.c().a();
        this.A = a12;
        a12.a(this);
        baseLayer.i(a12);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // e.a, h.d
    public <T> void a(T t2, @Nullable o.c<T> cVar) {
        super.a(t2, cVar);
        if (t2 == i0.L) {
            f.q qVar = this.B;
            if (qVar != null) {
                this.f48708f.G(qVar);
            }
            if (cVar == null) {
                this.B = null;
                return;
            }
            f.q qVar2 = new f.q(cVar);
            this.B = qVar2;
            qVar2.a(this);
            this.f48708f.i(this.B);
        }
    }

    @Override // e.a, e.d
    public void d(Canvas canvas, Matrix matrix, int i10) {
        Shader m10;
        if (this.f48777s) {
            return;
        }
        b(this.f48780v, matrix, false);
        if (this.f48781w == GradientType.LINEAR) {
            m10 = l();
        } else {
            m10 = m();
        }
        m10.setLocalMatrix(matrix);
        this.f48711i.setShader(m10);
        super.d(canvas, matrix, i10);
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String getName() {
        return this.f48776r;
    }

    public final int[] j(int[] iArr) {
        f.q qVar = this.B;
        if (qVar != null) {
            Integer[] numArr = (Integer[]) qVar.h();
            int i10 = 0;
            if (iArr.length == numArr.length) {
                while (i10 < iArr.length) {
                    iArr[i10] = numArr[i10].intValue();
                    i10++;
                }
            } else {
                iArr = new int[numArr.length];
                while (i10 < numArr.length) {
                    iArr[i10] = numArr[i10].intValue();
                    i10++;
                }
            }
        }
        return iArr;
    }

    public final int k() {
        int round = Math.round(this.f48784z.f() * this.f48782x);
        int round2 = Math.round(this.A.f() * this.f48782x);
        int round3 = Math.round(this.f48783y.f() * this.f48782x);
        int i10 = round != 0 ? MetricsProto.MetricsEvent.DIALOG_SUPPORT_PHONE * round : 17;
        if (round2 != 0) {
            i10 = i10 * 31 * round2;
        }
        return round3 != 0 ? i10 * 31 * round3 : i10;
    }

    public final LinearGradient l() {
        long k10 = k();
        LinearGradient linearGradient = this.f48778t.get(k10);
        if (linearGradient != null) {
            return linearGradient;
        }
        PointF h10 = this.f48784z.h();
        PointF h11 = this.A.h();
        j.c h12 = this.f48783y.h();
        LinearGradient linearGradient2 = new LinearGradient(h10.x, h10.y, h11.x, h11.y, j(h12.c()), h12.d(), Shader.TileMode.CLAMP);
        this.f48778t.put(k10, linearGradient2);
        return linearGradient2;
    }

    public final RadialGradient m() {
        long k10 = k();
        RadialGradient radialGradient = this.f48779u.get(k10);
        if (radialGradient != null) {
            return radialGradient;
        }
        PointF h10 = this.f48784z.h();
        PointF h11 = this.A.h();
        j.c h12 = this.f48783y.h();
        int[] j10 = j(h12.c());
        float[] d10 = h12.d();
        RadialGradient radialGradient2 = new RadialGradient(h10.x, h10.y, (float) Math.hypot(h11.x - r7, h11.y - r8), j10, d10, Shader.TileMode.CLAMP);
        this.f48779u.put(k10, radialGradient2);
        return radialGradient2;
    }
}

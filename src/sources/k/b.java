package k;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.e0;
import com.airbnb.lottie.i0;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.model.layer.Layer;
import f.q;
import n.h;

/* compiled from: ImageLayer.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class b extends BaseLayer {
    public final Paint D;
    public final Rect E;
    public final Rect F;

    @Nullable
    public final e0 G;

    @Nullable
    public f.a<ColorFilter, ColorFilter> H;

    @Nullable
    public f.a<Bitmap, Bitmap> I;

    public b(LottieDrawable lottieDrawable, Layer layer) {
        super(lottieDrawable, layer);
        this.D = new d.a(3);
        this.E = new Rect();
        this.F = new Rect();
        this.G = lottieDrawable.P(layer.m());
    }

    @Nullable
    public final Bitmap O() {
        Bitmap h10;
        f.a<Bitmap, Bitmap> aVar = this.I;
        if (aVar != null && (h10 = aVar.h()) != null) {
            return h10;
        }
        Bitmap H = this.f2023p.H(this.f2024q.m());
        if (H != null) {
            return H;
        }
        e0 e0Var = this.G;
        if (e0Var != null) {
            return e0Var.a();
        }
        return null;
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer, h.d
    public <T> void a(T t2, @Nullable o.c<T> cVar) {
        super.a(t2, cVar);
        if (t2 == i0.K) {
            if (cVar == null) {
                this.H = null;
                return;
            } else {
                this.H = new q(cVar);
                return;
            }
        }
        if (t2 == i0.N) {
            if (cVar == null) {
                this.I = null;
            } else {
                this.I = new q(cVar);
            }
        }
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer, e.d
    public void b(RectF rectF, Matrix matrix, boolean z10) {
        super.b(rectF, matrix, z10);
        if (this.G != null) {
            float e2 = h.e();
            rectF.set(0.0f, 0.0f, this.G.e() * e2, this.G.c() * e2);
            this.f2022o.mapRect(rectF);
        }
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer
    public void t(@NonNull Canvas canvas, Matrix matrix, int i10) {
        Bitmap O = O();
        if (O == null || O.isRecycled() || this.G == null) {
            return;
        }
        float e2 = h.e();
        this.D.setAlpha(i10);
        f.a<ColorFilter, ColorFilter> aVar = this.H;
        if (aVar != null) {
            this.D.setColorFilter(aVar.h());
        }
        canvas.save();
        canvas.concat(matrix);
        this.E.set(0, 0, O.getWidth(), O.getHeight());
        if (this.f2023p.Q()) {
            this.F.set(0, 0, (int) (this.G.e() * e2), (int) (this.G.c() * e2));
        } else {
            this.F.set(0, 0, (int) (O.getWidth() * e2), (int) (O.getHeight() * e2));
        }
        canvas.drawBitmap(O, this.E, this.F, this.D);
        canvas.restore();
    }
}

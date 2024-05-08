package e;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.i0;
import com.airbnb.lottie.model.content.ShapeStroke;
import com.airbnb.lottie.model.layer.BaseLayer;

/* compiled from: StrokeContent.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class s extends a {

    /* renamed from: r, reason: collision with root package name */
    public final BaseLayer f48840r;

    /* renamed from: s, reason: collision with root package name */
    public final String f48841s;

    /* renamed from: t, reason: collision with root package name */
    public final boolean f48842t;

    /* renamed from: u, reason: collision with root package name */
    public final f.a<Integer, Integer> f48843u;

    /* renamed from: v, reason: collision with root package name */
    @Nullable
    public f.a<ColorFilter, ColorFilter> f48844v;

    public s(LottieDrawable lottieDrawable, BaseLayer baseLayer, ShapeStroke shapeStroke) {
        super(lottieDrawable, baseLayer, shapeStroke.a().toPaintCap(), shapeStroke.d().toPaintJoin(), shapeStroke.f(), shapeStroke.h(), shapeStroke.i(), shapeStroke.e(), shapeStroke.c());
        this.f48840r = baseLayer;
        this.f48841s = shapeStroke.g();
        this.f48842t = shapeStroke.j();
        f.a<Integer, Integer> a10 = shapeStroke.b().a();
        this.f48843u = a10;
        a10.a(this);
        baseLayer.i(a10);
    }

    @Override // e.a, h.d
    public <T> void a(T t2, @Nullable o.c<T> cVar) {
        super.a(t2, cVar);
        if (t2 == i0.f1913b) {
            this.f48843u.n(cVar);
            return;
        }
        if (t2 == i0.K) {
            f.a<ColorFilter, ColorFilter> aVar = this.f48844v;
            if (aVar != null) {
                this.f48840r.G(aVar);
            }
            if (cVar == null) {
                this.f48844v = null;
                return;
            }
            f.q qVar = new f.q(cVar);
            this.f48844v = qVar;
            qVar.a(this);
            this.f48840r.i(this.f48843u);
        }
    }

    @Override // e.a, e.d
    public void d(Canvas canvas, Matrix matrix, int i10) {
        if (this.f48842t) {
            return;
        }
        this.f48711i.setColor(((f.b) this.f48843u).p());
        f.a<ColorFilter, ColorFilter> aVar = this.f48844v;
        if (aVar != null) {
            this.f48711i.setColorFilter(aVar.h());
        }
        super.d(canvas, matrix, i10);
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String getName() {
        return this.f48841s;
    }
}

package k;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.model.layer.Layer;
import j.i;
import java.util.Collections;
import java.util.List;
import m.j;

/* compiled from: ShapeLayer.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class d extends BaseLayer {
    public final e.c D;
    public final com.airbnb.lottie.model.layer.a E;

    public d(LottieDrawable lottieDrawable, Layer layer, com.airbnb.lottie.model.layer.a aVar, LottieComposition lottieComposition) {
        super(lottieDrawable, layer);
        this.E = aVar;
        e.c cVar = new e.c(lottieDrawable, this, new i("__container", layer.n(), false), lottieComposition);
        this.D = cVar;
        cVar.f(Collections.emptyList(), Collections.emptyList());
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer
    public void H(h.c cVar, int i10, List<h.c> list, h.c cVar2) {
        this.D.h(cVar, i10, list, cVar2);
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer, e.d
    public void b(RectF rectF, Matrix matrix, boolean z10) {
        super.b(rectF, matrix, z10);
        this.D.b(rectF, this.f2022o, z10);
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer
    public void t(@NonNull Canvas canvas, Matrix matrix, int i10) {
        this.D.d(canvas, matrix, i10);
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer
    @Nullable
    public j.a v() {
        j.a v2 = super.v();
        return v2 != null ? v2 : this.E.v();
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer
    @Nullable
    public j x() {
        j x10 = super.x();
        return x10 != null ? x10 : this.E.x();
    }
}

package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.i0;
import com.airbnb.lottie.model.layer.Layer;
import f.q;
import h.c;
import i.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import n.h;

/* compiled from: CompositionLayer.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class a extends BaseLayer {

    @Nullable
    public f.a<Float, Float> D;
    public final List<BaseLayer> E;
    public final RectF F;
    public final RectF G;
    public final Paint H;
    public boolean I;

    /* compiled from: CompositionLayer.java */
    /* renamed from: com.airbnb.lottie.model.layer.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static /* synthetic */ class C0029a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f2060a;

        static {
            int[] iArr = new int[Layer.MatteType.values().length];
            f2060a = iArr;
            try {
                iArr[Layer.MatteType.ADD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2060a[Layer.MatteType.INVERT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public a(LottieDrawable lottieDrawable, Layer layer, List<Layer> list, LottieComposition lottieComposition) {
        super(lottieDrawable, layer);
        int i10;
        BaseLayer baseLayer;
        this.E = new ArrayList();
        this.F = new RectF();
        this.G = new RectF();
        this.H = new Paint();
        this.I = true;
        b u10 = layer.u();
        if (u10 != null) {
            f.a<Float, Float> a10 = u10.a();
            this.D = a10;
            i(a10);
            this.D.a(this);
        } else {
            this.D = null;
        }
        LongSparseArray longSparseArray = new LongSparseArray(lottieComposition.k().size());
        int size = list.size() - 1;
        BaseLayer baseLayer2 = null;
        while (true) {
            if (size < 0) {
                break;
            }
            Layer layer2 = list.get(size);
            BaseLayer u11 = BaseLayer.u(this, layer2, lottieDrawable, lottieComposition);
            if (u11 != null) {
                longSparseArray.put(u11.y().d(), u11);
                if (baseLayer2 != null) {
                    baseLayer2.I(u11);
                    baseLayer2 = null;
                } else {
                    this.E.add(0, u11);
                    int i11 = C0029a.f2060a[layer2.h().ordinal()];
                    if (i11 == 1 || i11 == 2) {
                        baseLayer2 = u11;
                    }
                }
            }
            size--;
        }
        for (i10 = 0; i10 < longSparseArray.size(); i10++) {
            BaseLayer baseLayer3 = (BaseLayer) longSparseArray.get(longSparseArray.keyAt(i10));
            if (baseLayer3 != null && (baseLayer = (BaseLayer) longSparseArray.get(baseLayer3.y().j())) != null) {
                baseLayer3.K(baseLayer);
            }
        }
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer
    public void H(c cVar, int i10, List<c> list, c cVar2) {
        for (int i11 = 0; i11 < this.E.size(); i11++) {
            this.E.get(i11).h(cVar, i10, list, cVar2);
        }
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer
    public void J(boolean z10) {
        super.J(z10);
        Iterator<BaseLayer> iterator2 = this.E.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().J(z10);
        }
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer
    public void L(@FloatRange(from = 0.0d, to = 1.0d) float f10) {
        super.L(f10);
        if (this.D != null) {
            f10 = ((this.D.h().floatValue() * this.f2024q.b().i()) - this.f2024q.b().p()) / (this.f2023p.J().e() + 0.01f);
        }
        if (this.D == null) {
            f10 -= this.f2024q.r();
        }
        if (this.f2024q.v() != 0.0f && !"__container".equals(this.f2024q.i())) {
            f10 /= this.f2024q.v();
        }
        for (int size = this.E.size() - 1; size >= 0; size--) {
            this.E.get(size).L(f10);
        }
    }

    public void O(boolean z10) {
        this.I = z10;
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer, h.d
    public <T> void a(T t2, @Nullable o.c<T> cVar) {
        super.a(t2, cVar);
        if (t2 == i0.E) {
            if (cVar == null) {
                f.a<Float, Float> aVar = this.D;
                if (aVar != null) {
                    aVar.n(null);
                    return;
                }
                return;
            }
            q qVar = new q(cVar);
            this.D = qVar;
            qVar.a(this);
            i(this.D);
        }
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer, e.d
    public void b(RectF rectF, Matrix matrix, boolean z10) {
        super.b(rectF, matrix, z10);
        for (int size = this.E.size() - 1; size >= 0; size--) {
            this.F.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.E.get(size).b(this.F, this.f2022o, true);
            rectF.union(this.F);
        }
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer
    public void t(Canvas canvas, Matrix matrix, int i10) {
        com.airbnb.lottie.c.a("CompositionLayer#draw");
        this.G.set(0.0f, 0.0f, this.f2024q.l(), this.f2024q.k());
        matrix.mapRect(this.G);
        boolean z10 = this.f2023p.e0() && this.E.size() > 1 && i10 != 255;
        if (z10) {
            this.H.setAlpha(i10);
            h.m(canvas, this.G, this.H);
        } else {
            canvas.save();
        }
        if (z10) {
            i10 = 255;
        }
        for (int size = this.E.size() - 1; size >= 0; size--) {
            if (((!this.I && "__container".equals(this.f2024q.i())) || this.G.isEmpty()) ? true : canvas.clipRect(this.G)) {
                this.E.get(size).d(canvas, matrix, i10);
            }
        }
        canvas.restore();
        com.airbnb.lottie.c.b("CompositionLayer#draw");
    }
}

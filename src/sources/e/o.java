package e;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.i0;
import com.airbnb.lottie.model.layer.BaseLayer;
import f.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

/* compiled from: RepeaterContent.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class o implements d, l, i, a.b, j {

    /* renamed from: a, reason: collision with root package name */
    public final Matrix f48819a = new Matrix();

    /* renamed from: b, reason: collision with root package name */
    public final Path f48820b = new Path();

    /* renamed from: c, reason: collision with root package name */
    public final LottieDrawable f48821c;

    /* renamed from: d, reason: collision with root package name */
    public final BaseLayer f48822d;

    /* renamed from: e, reason: collision with root package name */
    public final String f48823e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f48824f;

    /* renamed from: g, reason: collision with root package name */
    public final f.a<Float, Float> f48825g;

    /* renamed from: h, reason: collision with root package name */
    public final f.a<Float, Float> f48826h;

    /* renamed from: i, reason: collision with root package name */
    public final f.p f48827i;

    /* renamed from: j, reason: collision with root package name */
    public c f48828j;

    public o(LottieDrawable lottieDrawable, BaseLayer baseLayer, j.f fVar) {
        this.f48821c = lottieDrawable;
        this.f48822d = baseLayer;
        this.f48823e = fVar.b();
        this.f48824f = fVar.e();
        f.a<Float, Float> a10 = fVar.a().a();
        this.f48825g = a10;
        baseLayer.i(a10);
        a10.a(this);
        f.a<Float, Float> a11 = fVar.c().a();
        this.f48826h = a11;
        baseLayer.i(a11);
        a11.a(this);
        f.p a12 = fVar.d().a();
        this.f48827i = a12;
        a12.a(baseLayer);
        a12.b(this);
    }

    @Override // h.d
    public <T> void a(T t2, @Nullable o.c<T> cVar) {
        if (this.f48827i.c(t2, cVar)) {
            return;
        }
        if (t2 == i0.f1932u) {
            this.f48825g.n(cVar);
        } else if (t2 == i0.f1933v) {
            this.f48826h.n(cVar);
        }
    }

    @Override // e.d
    public void b(RectF rectF, Matrix matrix, boolean z10) {
        this.f48828j.b(rectF, matrix, z10);
    }

    @Override // e.i
    public void c(ListIterator<Content> listIterator) {
        if (this.f48828j != null) {
            return;
        }
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        ArrayList arrayList = new ArrayList();
        while (listIterator.hasPrevious()) {
            arrayList.add(listIterator.previous());
            listIterator.remove();
        }
        Collections.reverse(arrayList);
        this.f48828j = new c(this.f48821c, this.f48822d, "Repeater", this.f48824f, arrayList, null);
    }

    @Override // e.d
    public void d(Canvas canvas, Matrix matrix, int i10) {
        float floatValue = this.f48825g.h().floatValue();
        float floatValue2 = this.f48826h.h().floatValue();
        float floatValue3 = this.f48827i.i().h().floatValue() / 100.0f;
        float floatValue4 = this.f48827i.e().h().floatValue() / 100.0f;
        for (int i11 = ((int) floatValue) - 1; i11 >= 0; i11--) {
            this.f48819a.set(matrix);
            float f10 = i11;
            this.f48819a.preConcat(this.f48827i.g(f10 + floatValue2));
            this.f48828j.d(canvas, this.f48819a, (int) (i10 * n.g.i(floatValue3, floatValue4, f10 / floatValue)));
        }
    }

    @Override // f.a.b
    public void e() {
        this.f48821c.invalidateSelf();
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public void f(List<Content> list, List<Content> list2) {
        this.f48828j.f(list, list2);
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String getName() {
        return this.f48823e;
    }

    @Override // e.l
    public Path getPath() {
        Path path = this.f48828j.getPath();
        this.f48820b.reset();
        float floatValue = this.f48825g.h().floatValue();
        float floatValue2 = this.f48826h.h().floatValue();
        for (int i10 = ((int) floatValue) - 1; i10 >= 0; i10--) {
            this.f48819a.set(this.f48827i.g(i10 + floatValue2));
            this.f48820b.addPath(path, this.f48819a);
        }
        return this.f48820b;
    }

    @Override // h.d
    public void h(h.c cVar, int i10, List<h.c> list, h.c cVar2) {
        n.g.k(cVar, i10, list, cVar2, this);
        for (int i11 = 0; i11 < this.f48828j.j().size(); i11++) {
            Content content = this.f48828j.j().get(i11);
            if (content instanceof j) {
                n.g.k(cVar, i10, list, cVar2, (j) content);
            }
        }
    }
}

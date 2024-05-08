package e;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.layer.BaseLayer;
import f.a;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ContentGroup.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class c implements d, l, a.b, h.d {

    /* renamed from: a, reason: collision with root package name */
    public final Paint f48723a;

    /* renamed from: b, reason: collision with root package name */
    public final RectF f48724b;

    /* renamed from: c, reason: collision with root package name */
    public final Matrix f48725c;

    /* renamed from: d, reason: collision with root package name */
    public final Path f48726d;

    /* renamed from: e, reason: collision with root package name */
    public final RectF f48727e;

    /* renamed from: f, reason: collision with root package name */
    public final String f48728f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f48729g;

    /* renamed from: h, reason: collision with root package name */
    public final List<Content> f48730h;

    /* renamed from: i, reason: collision with root package name */
    public final LottieDrawable f48731i;

    /* renamed from: j, reason: collision with root package name */
    @Nullable
    public List<l> f48732j;

    /* renamed from: k, reason: collision with root package name */
    @Nullable
    public f.p f48733k;

    public c(LottieDrawable lottieDrawable, BaseLayer baseLayer, j.i iVar, LottieComposition lottieComposition) {
        this(lottieDrawable, baseLayer, iVar.b(), iVar.c(), c(lottieDrawable, lottieComposition, baseLayer, iVar.a()), i(iVar.a()));
    }

    public static List<Content> c(LottieDrawable lottieDrawable, LottieComposition lottieComposition, BaseLayer baseLayer, List<ContentModel> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (int i10 = 0; i10 < list.size(); i10++) {
            Content content = list.get(i10).toContent(lottieDrawable, lottieComposition, baseLayer);
            if (content != null) {
                arrayList.add(content);
            }
        }
        return arrayList;
    }

    @Nullable
    public static i.l i(List<ContentModel> list) {
        for (int i10 = 0; i10 < list.size(); i10++) {
            ContentModel contentModel = list.get(i10);
            if (contentModel instanceof i.l) {
                return (i.l) contentModel;
            }
        }
        return null;
    }

    @Override // h.d
    public <T> void a(T t2, @Nullable o.c<T> cVar) {
        f.p pVar = this.f48733k;
        if (pVar != null) {
            pVar.c(t2, cVar);
        }
    }

    @Override // e.d
    public void b(RectF rectF, Matrix matrix, boolean z10) {
        this.f48725c.set(matrix);
        f.p pVar = this.f48733k;
        if (pVar != null) {
            this.f48725c.preConcat(pVar.f());
        }
        this.f48727e.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (int size = this.f48730h.size() - 1; size >= 0; size--) {
            Content content = this.f48730h.get(size);
            if (content instanceof d) {
                ((d) content).b(this.f48727e, this.f48725c, z10);
                rectF.union(this.f48727e);
            }
        }
    }

    @Override // e.d
    public void d(Canvas canvas, Matrix matrix, int i10) {
        if (this.f48729g) {
            return;
        }
        this.f48725c.set(matrix);
        f.p pVar = this.f48733k;
        if (pVar != null) {
            this.f48725c.preConcat(pVar.f());
            i10 = (int) (((((this.f48733k.h() == null ? 100 : this.f48733k.h().h().intValue()) / 100.0f) * i10) / 255.0f) * 255.0f);
        }
        boolean z10 = this.f48731i.e0() && m() && i10 != 255;
        if (z10) {
            this.f48724b.set(0.0f, 0.0f, 0.0f, 0.0f);
            b(this.f48724b, this.f48725c, true);
            this.f48723a.setAlpha(i10);
            n.h.m(canvas, this.f48724b, this.f48723a);
        }
        if (z10) {
            i10 = 255;
        }
        for (int size = this.f48730h.size() - 1; size >= 0; size--) {
            Content content = this.f48730h.get(size);
            if (content instanceof d) {
                ((d) content).d(canvas, this.f48725c, i10);
            }
        }
        if (z10) {
            canvas.restore();
        }
    }

    @Override // f.a.b
    public void e() {
        this.f48731i.invalidateSelf();
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public void f(List<Content> list, List<Content> list2) {
        ArrayList arrayList = new ArrayList(list.size() + this.f48730h.size());
        arrayList.addAll(list);
        for (int size = this.f48730h.size() - 1; size >= 0; size--) {
            Content content = this.f48730h.get(size);
            content.f(arrayList, this.f48730h.subList(0, size));
            arrayList.add(content);
        }
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String getName() {
        return this.f48728f;
    }

    @Override // e.l
    public Path getPath() {
        this.f48725c.reset();
        f.p pVar = this.f48733k;
        if (pVar != null) {
            this.f48725c.set(pVar.f());
        }
        this.f48726d.reset();
        if (this.f48729g) {
            return this.f48726d;
        }
        for (int size = this.f48730h.size() - 1; size >= 0; size--) {
            Content content = this.f48730h.get(size);
            if (content instanceof l) {
                this.f48726d.addPath(((l) content).getPath(), this.f48725c);
            }
        }
        return this.f48726d;
    }

    @Override // h.d
    public void h(h.c cVar, int i10, List<h.c> list, h.c cVar2) {
        if (cVar.g(getName(), i10) || "__container".equals(getName())) {
            if (!"__container".equals(getName())) {
                cVar2 = cVar2.a(getName());
                if (cVar.c(getName(), i10)) {
                    list.add(cVar2.i(this));
                }
            }
            if (cVar.h(getName(), i10)) {
                int e2 = i10 + cVar.e(getName(), i10);
                for (int i11 = 0; i11 < this.f48730h.size(); i11++) {
                    Content content = this.f48730h.get(i11);
                    if (content instanceof h.d) {
                        ((h.d) content).h(cVar, e2, list, cVar2);
                    }
                }
            }
        }
    }

    public List<Content> j() {
        return this.f48730h;
    }

    public List<l> k() {
        if (this.f48732j == null) {
            this.f48732j = new ArrayList();
            for (int i10 = 0; i10 < this.f48730h.size(); i10++) {
                Content content = this.f48730h.get(i10);
                if (content instanceof l) {
                    this.f48732j.add((l) content);
                }
            }
        }
        return this.f48732j;
    }

    public Matrix l() {
        f.p pVar = this.f48733k;
        if (pVar != null) {
            return pVar.f();
        }
        this.f48725c.reset();
        return this.f48725c;
    }

    public final boolean m() {
        int i10 = 0;
        for (int i11 = 0; i11 < this.f48730h.size(); i11++) {
            if ((this.f48730h.get(i11) instanceof d) && (i10 = i10 + 1) >= 2) {
                return true;
            }
        }
        return false;
    }

    public c(LottieDrawable lottieDrawable, BaseLayer baseLayer, String str, boolean z10, List<Content> list, @Nullable i.l lVar) {
        this.f48723a = new d.a();
        this.f48724b = new RectF();
        this.f48725c = new Matrix();
        this.f48726d = new Path();
        this.f48727e = new RectF();
        this.f48728f = str;
        this.f48731i = lottieDrawable;
        this.f48729g = z10;
        this.f48730h = list;
        if (lVar != null) {
            f.p a10 = lVar.a();
            this.f48733k = a10;
            a10.a(baseLayer);
            this.f48733k.b(this);
        }
        ArrayList arrayList = new ArrayList();
        for (int size = list.size() - 1; size >= 0; size--) {
            Content content = list.get(size);
            if (content instanceof i) {
                arrayList.add((i) content);
            }
        }
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            ((i) arrayList.get(size2)).c(list.listIterator(list.size()));
        }
    }
}

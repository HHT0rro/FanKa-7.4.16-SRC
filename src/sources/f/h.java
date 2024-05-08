package f;

import android.graphics.Path;
import com.airbnb.lottie.model.content.Mask;
import com.airbnb.lottie.model.content.ShapeData;
import java.util.ArrayList;
import java.util.List;

/* compiled from: MaskKeyframeAnimation.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    public final List<a<ShapeData, Path>> f49047a;

    /* renamed from: b, reason: collision with root package name */
    public final List<a<Integer, Integer>> f49048b;

    /* renamed from: c, reason: collision with root package name */
    public final List<Mask> f49049c;

    public h(List<Mask> list) {
        this.f49049c = list;
        this.f49047a = new ArrayList(list.size());
        this.f49048b = new ArrayList(list.size());
        for (int i10 = 0; i10 < list.size(); i10++) {
            this.f49047a.add(list.get(i10).b().a());
            this.f49048b.add(list.get(i10).c().a());
        }
    }

    public List<a<ShapeData, Path>> a() {
        return this.f49047a;
    }

    public List<Mask> b() {
        return this.f49049c;
    }

    public List<a<Integer, Integer>> c() {
        return this.f49048b;
    }
}

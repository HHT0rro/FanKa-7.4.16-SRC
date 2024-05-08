package i;

import android.graphics.PointF;
import java.util.List;

/* compiled from: AnimatablePathValue.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class e implements m<PointF, PointF> {

    /* renamed from: a, reason: collision with root package name */
    public final List<o.a<PointF>> f49656a;

    public e(List<o.a<PointF>> list) {
        this.f49656a = list;
    }

    @Override // i.m
    public f.a<PointF, PointF> a() {
        if (this.f49656a.get(0).i()) {
            return new f.k(this.f49656a);
        }
        return new f.j(this.f49656a);
    }

    @Override // i.m
    public List<o.a<PointF>> b() {
        return this.f49656a;
    }

    @Override // i.m
    public boolean c() {
        return this.f49656a.size() == 1 && this.f49656a.get(0).i();
    }
}

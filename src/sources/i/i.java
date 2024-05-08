package i;

import android.graphics.PointF;
import java.util.List;

/* compiled from: AnimatableSplitDimensionPathValue.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class i implements m<PointF, PointF> {

    /* renamed from: a, reason: collision with root package name */
    public final b f49657a;

    /* renamed from: b, reason: collision with root package name */
    public final b f49658b;

    public i(b bVar, b bVar2) {
        this.f49657a = bVar;
        this.f49658b = bVar2;
    }

    @Override // i.m
    public f.a<PointF, PointF> a() {
        return new f.n(this.f49657a.a(), this.f49658b.a());
    }

    @Override // i.m
    public List<o.a<PointF>> b() {
        throw new UnsupportedOperationException("Cannot call getKeyframes on AnimatableSplitDimensionPathValue.");
    }

    @Override // i.m
    public boolean c() {
        return this.f49657a.c() && this.f49658b.c();
    }
}

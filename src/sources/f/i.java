package f;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieComposition;

/* compiled from: PathKeyframe.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class i extends o.a<PointF> {

    /* renamed from: q, reason: collision with root package name */
    @Nullable
    public Path f49050q;

    /* renamed from: r, reason: collision with root package name */
    public final o.a<PointF> f49051r;

    public i(LottieComposition lottieComposition, o.a<PointF> aVar) {
        super(lottieComposition, aVar.f52211b, aVar.f52212c, aVar.f52213d, aVar.f52214e, aVar.f52215f, aVar.f52216g, aVar.f52217h);
        this.f49051r = aVar;
        j();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void j() {
        T t2;
        T t10;
        T t11 = this.f52212c;
        boolean z10 = (t11 == 0 || (t10 = this.f52211b) == 0 || !((PointF) t10).equals(((PointF) t11).x, ((PointF) t11).y)) ? false : true;
        T t12 = this.f52211b;
        if (t12 == 0 || (t2 = this.f52212c) == 0 || z10) {
            return;
        }
        o.a<PointF> aVar = this.f49051r;
        this.f49050q = n.h.d((PointF) t12, (PointF) t2, aVar.f52224o, aVar.f52225p);
    }

    @Nullable
    public Path k() {
        return this.f49050q;
    }
}

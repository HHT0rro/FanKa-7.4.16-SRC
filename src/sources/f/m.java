package f;

import android.graphics.Path;
import androidx.annotation.Nullable;
import com.airbnb.lottie.model.content.ShapeData;
import e.r;
import java.util.List;

/* compiled from: ShapeKeyframeAnimation.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class m extends a<ShapeData, Path> {

    /* renamed from: i, reason: collision with root package name */
    public final ShapeData f49058i;

    /* renamed from: j, reason: collision with root package name */
    public final Path f49059j;

    /* renamed from: k, reason: collision with root package name */
    public List<r> f49060k;

    public m(List<o.a<ShapeData>> list) {
        super(list);
        this.f49058i = new ShapeData();
        this.f49059j = new Path();
    }

    @Override // f.a
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public Path i(o.a<ShapeData> aVar, float f10) {
        this.f49058i.interpolateBetween(aVar.f52211b, aVar.f52212c, f10);
        ShapeData shapeData = this.f49058i;
        List<r> list = this.f49060k;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                shapeData = this.f49060k.get(size).g(shapeData);
            }
        }
        n.g.h(shapeData, this.f49059j);
        return this.f49059j;
    }

    public void q(@Nullable List<r> list) {
        this.f49060k = list;
    }
}

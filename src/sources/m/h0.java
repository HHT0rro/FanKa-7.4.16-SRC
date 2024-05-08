package m;

import android.graphics.PointF;
import com.airbnb.lottie.model.CubicCurveData;
import com.airbnb.lottie.model.content.ShapeData;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: ShapeDataParser.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class h0 implements n0<ShapeData> {

    /* renamed from: a, reason: collision with root package name */
    public static final h0 f51737a = new h0();

    /* renamed from: b, reason: collision with root package name */
    public static final JsonReader.a f51738b = JsonReader.a.a("c", com.kuaishou.weapon.p0.t.f36218c, com.kuaishou.weapon.p0.t.f36220e, "o");

    @Override // m.n0
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ShapeData a(JsonReader jsonReader, float f10) throws IOException {
        if (jsonReader.w() == JsonReader.Token.BEGIN_ARRAY) {
            jsonReader.b();
        }
        jsonReader.d();
        List<PointF> list = null;
        List<PointF> list2 = null;
        List<PointF> list3 = null;
        boolean z10 = false;
        while (jsonReader.i()) {
            int y10 = jsonReader.y(f51738b);
            if (y10 == 0) {
                z10 = jsonReader.j();
            } else if (y10 == 1) {
                list = s.f(jsonReader, f10);
            } else if (y10 == 2) {
                list2 = s.f(jsonReader, f10);
            } else if (y10 != 3) {
                jsonReader.z();
                jsonReader.A();
            } else {
                list3 = s.f(jsonReader, f10);
            }
        }
        jsonReader.f();
        if (jsonReader.w() == JsonReader.Token.END_ARRAY) {
            jsonReader.e();
        }
        if (list != null && list2 != null && list3 != null) {
            if (list.isEmpty()) {
                return new ShapeData(new PointF(), false, Collections.emptyList());
            }
            int size = list.size();
            PointF pointF = list.get(0);
            ArrayList arrayList = new ArrayList(size);
            for (int i10 = 1; i10 < size; i10++) {
                PointF pointF2 = list.get(i10);
                int i11 = i10 - 1;
                arrayList.add(new CubicCurveData(n.g.a(list.get(i11), list3.get(i11)), n.g.a(pointF2, list2.get(i10)), pointF2));
            }
            if (z10) {
                PointF pointF3 = list.get(0);
                int i12 = size - 1;
                arrayList.add(new CubicCurveData(n.g.a(list.get(i12), list3.get(i12)), n.g.a(pointF3, list2.get(0)), pointF3));
            }
            return new ShapeData(pointF, z10, arrayList);
        }
        throw new IllegalArgumentException("Shape data was missing information.");
    }
}

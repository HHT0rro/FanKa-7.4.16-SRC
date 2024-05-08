package m;

import android.graphics.PointF;
import com.airbnb.lottie.model.DocumentData;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* compiled from: DocumentDataParser.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class i implements n0<DocumentData> {

    /* renamed from: a, reason: collision with root package name */
    public static final i f51739a = new i();

    /* renamed from: b, reason: collision with root package name */
    public static final JsonReader.a f51740b = JsonReader.a.a("t", "f", com.kuaishou.weapon.p0.t.f36222g, "j", "tr", "lh", "ls", "fc", "sc", "sw", "of", "ps", "sz");

    @Override // m.n0
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public DocumentData a(JsonReader jsonReader, float f10) throws IOException {
        DocumentData.Justification justification = DocumentData.Justification.CENTER;
        jsonReader.d();
        DocumentData.Justification justification2 = justification;
        String str = null;
        String str2 = null;
        PointF pointF = null;
        PointF pointF2 = null;
        float f11 = 0.0f;
        int i10 = 0;
        float f12 = 0.0f;
        float f13 = 0.0f;
        int i11 = 0;
        int i12 = 0;
        float f14 = 0.0f;
        boolean z10 = true;
        while (jsonReader.i()) {
            switch (jsonReader.y(f51740b)) {
                case 0:
                    str = jsonReader.r();
                    break;
                case 1:
                    str2 = jsonReader.r();
                    break;
                case 2:
                    f11 = (float) jsonReader.k();
                    break;
                case 3:
                    int l10 = jsonReader.l();
                    justification2 = DocumentData.Justification.CENTER;
                    if (l10 <= justification2.ordinal() && l10 >= 0) {
                        justification2 = DocumentData.Justification.values()[l10];
                        break;
                    }
                    break;
                case 4:
                    i10 = jsonReader.l();
                    break;
                case 5:
                    f12 = (float) jsonReader.k();
                    break;
                case 6:
                    f13 = (float) jsonReader.k();
                    break;
                case 7:
                    i11 = s.d(jsonReader);
                    break;
                case 8:
                    i12 = s.d(jsonReader);
                    break;
                case 9:
                    f14 = (float) jsonReader.k();
                    break;
                case 10:
                    z10 = jsonReader.j();
                    break;
                case 11:
                    jsonReader.b();
                    PointF pointF3 = new PointF(((float) jsonReader.k()) * f10, ((float) jsonReader.k()) * f10);
                    jsonReader.e();
                    pointF = pointF3;
                    break;
                case 12:
                    jsonReader.b();
                    PointF pointF4 = new PointF(((float) jsonReader.k()) * f10, ((float) jsonReader.k()) * f10);
                    jsonReader.e();
                    pointF2 = pointF4;
                    break;
                default:
                    jsonReader.z();
                    jsonReader.A();
                    break;
            }
        }
        jsonReader.f();
        return new DocumentData(str, str2, f11, justification2, i10, f12, f13, i11, i12, f14, z10, pointF, pointF2);
    }
}

package m;

import android.graphics.Color;
import android.graphics.PointF;
import androidx.annotation.ColorInt;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import sun.util.locale.LanguageTag;

/* compiled from: JsonUtils.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class s {

    /* renamed from: a, reason: collision with root package name */
    public static final JsonReader.a f51770a = JsonReader.a.a(LanguageTag.PRIVATEUSE, "y");

    /* compiled from: JsonUtils.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f51771a;

        static {
            int[] iArr = new int[JsonReader.Token.values().length];
            f51771a = iArr;
            try {
                iArr[JsonReader.Token.NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f51771a[JsonReader.Token.BEGIN_ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f51771a[JsonReader.Token.BEGIN_OBJECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static PointF a(JsonReader jsonReader, float f10) throws IOException {
        jsonReader.b();
        float k10 = (float) jsonReader.k();
        float k11 = (float) jsonReader.k();
        while (jsonReader.w() != JsonReader.Token.END_ARRAY) {
            jsonReader.A();
        }
        jsonReader.e();
        return new PointF(k10 * f10, k11 * f10);
    }

    public static PointF b(JsonReader jsonReader, float f10) throws IOException {
        float k10 = (float) jsonReader.k();
        float k11 = (float) jsonReader.k();
        while (jsonReader.i()) {
            jsonReader.A();
        }
        return new PointF(k10 * f10, k11 * f10);
    }

    public static PointF c(JsonReader jsonReader, float f10) throws IOException {
        jsonReader.d();
        float f11 = 0.0f;
        float f12 = 0.0f;
        while (jsonReader.i()) {
            int y10 = jsonReader.y(f51770a);
            if (y10 == 0) {
                f11 = g(jsonReader);
            } else if (y10 != 1) {
                jsonReader.z();
                jsonReader.A();
            } else {
                f12 = g(jsonReader);
            }
        }
        jsonReader.f();
        return new PointF(f11 * f10, f12 * f10);
    }

    @ColorInt
    public static int d(JsonReader jsonReader) throws IOException {
        jsonReader.b();
        int k10 = (int) (jsonReader.k() * 255.0d);
        int k11 = (int) (jsonReader.k() * 255.0d);
        int k12 = (int) (jsonReader.k() * 255.0d);
        while (jsonReader.i()) {
            jsonReader.A();
        }
        jsonReader.e();
        return Color.argb(255, k10, k11, k12);
    }

    public static PointF e(JsonReader jsonReader, float f10) throws IOException {
        int i10 = a.f51771a[jsonReader.w().ordinal()];
        if (i10 == 1) {
            return b(jsonReader, f10);
        }
        if (i10 == 2) {
            return a(jsonReader, f10);
        }
        if (i10 == 3) {
            return c(jsonReader, f10);
        }
        throw new IllegalArgumentException("Unknown point starts with " + ((Object) jsonReader.w()));
    }

    public static List<PointF> f(JsonReader jsonReader, float f10) throws IOException {
        ArrayList arrayList = new ArrayList();
        jsonReader.b();
        while (jsonReader.w() == JsonReader.Token.BEGIN_ARRAY) {
            jsonReader.b();
            arrayList.add(e(jsonReader, f10));
            jsonReader.e();
        }
        jsonReader.e();
        return arrayList;
    }

    public static float g(JsonReader jsonReader) throws IOException {
        JsonReader.Token w3 = jsonReader.w();
        int i10 = a.f51771a[w3.ordinal()];
        if (i10 == 1) {
            return (float) jsonReader.k();
        }
        if (i10 == 2) {
            jsonReader.b();
            float k10 = (float) jsonReader.k();
            while (jsonReader.i()) {
                jsonReader.A();
            }
            jsonReader.e();
            return k10;
        }
        throw new IllegalArgumentException("Unknown value for token of type " + ((Object) w3));
    }
}

package g5;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.extractor.d;
import com.google.android.exoplayer2.extractor.flv.TagPayloadReader;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: ScriptTagPayloadReader.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class c extends TagPayloadReader {

    /* renamed from: b, reason: collision with root package name */
    public long f49386b;

    /* renamed from: c, reason: collision with root package name */
    public long[] f49387c;

    /* renamed from: d, reason: collision with root package name */
    public long[] f49388d;

    public c() {
        super(new d());
        this.f49386b = -9223372036854775807L;
        this.f49387c = new long[0];
        this.f49388d = new long[0];
    }

    public static Boolean g(ParsableByteArray parsableByteArray) {
        return Boolean.valueOf(parsableByteArray.D() == 1);
    }

    @Nullable
    public static Object h(ParsableByteArray parsableByteArray, int i10) {
        if (i10 == 0) {
            return j(parsableByteArray);
        }
        if (i10 == 1) {
            return g(parsableByteArray);
        }
        if (i10 == 2) {
            return n(parsableByteArray);
        }
        if (i10 == 3) {
            return l(parsableByteArray);
        }
        if (i10 == 8) {
            return k(parsableByteArray);
        }
        if (i10 == 10) {
            return m(parsableByteArray);
        }
        if (i10 != 11) {
            return null;
        }
        return i(parsableByteArray);
    }

    public static Date i(ParsableByteArray parsableByteArray) {
        Date date = new Date((long) j(parsableByteArray).doubleValue());
        parsableByteArray.Q(2);
        return date;
    }

    public static Double j(ParsableByteArray parsableByteArray) {
        return Double.valueOf(Double.longBitsToDouble(parsableByteArray.w()));
    }

    public static HashMap<String, Object> k(ParsableByteArray parsableByteArray) {
        int H = parsableByteArray.H();
        HashMap<String, Object> hashMap = new HashMap<>(H);
        for (int i10 = 0; i10 < H; i10++) {
            String n10 = n(parsableByteArray);
            Object h10 = h(parsableByteArray, o(parsableByteArray));
            if (h10 != null) {
                hashMap.put(n10, h10);
            }
        }
        return hashMap;
    }

    public static HashMap<String, Object> l(ParsableByteArray parsableByteArray) {
        HashMap<String, Object> hashMap = new HashMap<>();
        while (true) {
            String n10 = n(parsableByteArray);
            int o10 = o(parsableByteArray);
            if (o10 == 9) {
                return hashMap;
            }
            Object h10 = h(parsableByteArray, o10);
            if (h10 != null) {
                hashMap.put(n10, h10);
            }
        }
    }

    public static ArrayList<Object> m(ParsableByteArray parsableByteArray) {
        int H = parsableByteArray.H();
        ArrayList<Object> arrayList = new ArrayList<>(H);
        for (int i10 = 0; i10 < H; i10++) {
            Object h10 = h(parsableByteArray, o(parsableByteArray));
            if (h10 != null) {
                arrayList.add(h10);
            }
        }
        return arrayList;
    }

    public static String n(ParsableByteArray parsableByteArray) {
        int J = parsableByteArray.J();
        int e2 = parsableByteArray.e();
        parsableByteArray.Q(J);
        return new String(parsableByteArray.d(), e2, J);
    }

    public static int o(ParsableByteArray parsableByteArray) {
        return parsableByteArray.D();
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    public boolean b(ParsableByteArray parsableByteArray) {
        return true;
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    public boolean c(ParsableByteArray parsableByteArray, long j10) {
        if (o(parsableByteArray) != 2 || !"onMetaData".equals(n(parsableByteArray)) || o(parsableByteArray) != 8) {
            return false;
        }
        HashMap<String, Object> k10 = k(parsableByteArray);
        Object obj = k10.get("duration");
        if (obj instanceof Double) {
            double doubleValue = ((Double) obj).doubleValue();
            if (doubleValue > ShadowDrawableWrapper.COS_45) {
                this.f49386b = (long) (doubleValue * 1000000.0d);
            }
        }
        Object obj2 = k10.get("keyframes");
        if (obj2 instanceof Map) {
            Map map = (Map) obj2;
            Object obj3 = map.get("filepositions");
            Object obj4 = map.get("times");
            if ((obj3 instanceof List) && (obj4 instanceof List)) {
                List list = (List) obj3;
                List list2 = (List) obj4;
                int size = list2.size();
                this.f49387c = new long[size];
                this.f49388d = new long[size];
                for (int i10 = 0; i10 < size; i10++) {
                    Object obj5 = list.get(i10);
                    Object obj6 = list2.get(i10);
                    if ((obj6 instanceof Double) && (obj5 instanceof Double)) {
                        this.f49387c[i10] = (long) (((Double) obj6).doubleValue() * 1000000.0d);
                        this.f49388d[i10] = ((Double) obj5).longValue();
                    } else {
                        this.f49387c = new long[0];
                        this.f49388d = new long[0];
                        break;
                    }
                }
            }
        }
        return false;
    }

    public long d() {
        return this.f49386b;
    }

    public long[] e() {
        return this.f49388d;
    }

    public long[] f() {
        return this.f49387c;
    }
}

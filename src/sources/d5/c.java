package d5;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ts.g0;
import com.google.android.exoplayer2.extractor.ts.z;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: DefaultExtractorsFactory.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class c implements i {

    /* renamed from: m, reason: collision with root package name */
    public static final int[] f48620m = {5, 4, 12, 8, 3, 10, 9, 11, 6, 2, 0, 1, 7, 14};

    /* renamed from: n, reason: collision with root package name */
    @Nullable
    public static final Constructor<? extends Extractor> f48621n;

    /* renamed from: b, reason: collision with root package name */
    public boolean f48622b;

    /* renamed from: c, reason: collision with root package name */
    public int f48623c;

    /* renamed from: d, reason: collision with root package name */
    public int f48624d;

    /* renamed from: e, reason: collision with root package name */
    public int f48625e;

    /* renamed from: f, reason: collision with root package name */
    public int f48626f;

    /* renamed from: g, reason: collision with root package name */
    public int f48627g;

    /* renamed from: h, reason: collision with root package name */
    public int f48628h;

    /* renamed from: i, reason: collision with root package name */
    public int f48629i;

    /* renamed from: k, reason: collision with root package name */
    public int f48631k;

    /* renamed from: j, reason: collision with root package name */
    public int f48630j = 1;

    /* renamed from: l, reason: collision with root package name */
    public int f48632l = 112800;

    static {
        Constructor<? extends Extractor> constructor = null;
        try {
            if (Boolean.TRUE.equals(Class.forName("com.google.android.exoplayer2.ext.flac.FlacLibrary").getMethod("isAvailable", new Class[0]).invoke(null, new Object[0]))) {
                constructor = Class.forName("com.google.android.exoplayer2.ext.flac.FlacExtractor").asSubclass(Extractor.class).getConstructor(Integer.TYPE);
            }
        } catch (ClassNotFoundException unused) {
        } catch (Exception e2) {
            throw new RuntimeException("Error instantiating FLAC extension", e2);
        }
        f48621n = constructor;
    }

    @Override // d5.i
    public synchronized Extractor[] a(Uri uri, Map<String, List<String>> map) {
        ArrayList arrayList;
        arrayList = new ArrayList(14);
        int b4 = com.google.android.exoplayer2.util.h.b(map);
        if (b4 != -1) {
            c(b4, arrayList);
        }
        int c4 = com.google.android.exoplayer2.util.h.c(uri);
        if (c4 != -1 && c4 != b4) {
            c(c4, arrayList);
        }
        for (int i10 : f48620m) {
            if (i10 != b4 && i10 != c4) {
                c(i10, arrayList);
            }
        }
        return (Extractor[]) arrayList.toArray(new Extractor[arrayList.size()]);
    }

    @Override // d5.i
    public synchronized Extractor[] b() {
        return a(Uri.EMPTY, new HashMap());
    }

    public final void c(int i10, List<Extractor> list) {
        switch (i10) {
            case 0:
                list.add(new com.google.android.exoplayer2.extractor.ts.b());
                return;
            case 1:
                list.add(new com.google.android.exoplayer2.extractor.ts.e());
                return;
            case 2:
                list.add(new com.google.android.exoplayer2.extractor.ts.h(this.f48623c | (this.f48622b ? 1 : 0)));
                return;
            case 3:
                list.add(new e5.b(this.f48624d | (this.f48622b ? 1 : 0)));
                return;
            case 4:
                Constructor<? extends Extractor> constructor = f48621n;
                if (constructor != null) {
                    try {
                        list.add(constructor.newInstance(Integer.valueOf(this.f48625e)));
                        return;
                    } catch (Exception e2) {
                        throw new IllegalStateException("Unexpected error creating FLAC extractor", e2);
                    }
                }
                list.add(new f5.d(this.f48625e));
                return;
            case 5:
                list.add(new g5.b());
                return;
            case 6:
                list.add(new i5.e(this.f48626f));
                return;
            case 7:
                list.add(new j5.f(this.f48629i | (this.f48622b ? 1 : 0)));
                return;
            case 8:
                list.add(new com.google.android.exoplayer2.extractor.mp4.f(this.f48628h));
                list.add(new com.google.android.exoplayer2.extractor.mp4.j(this.f48627g));
                return;
            case 9:
                list.add(new com.google.android.exoplayer2.extractor.ogg.d());
                return;
            case 10:
                list.add(new z());
                return;
            case 11:
                list.add(new g0(this.f48630j, this.f48631k, this.f48632l));
                return;
            case 12:
                list.add(new l5.b());
                return;
            case 13:
            default:
                return;
            case 14:
                list.add(new h5.a());
                return;
        }
    }
}

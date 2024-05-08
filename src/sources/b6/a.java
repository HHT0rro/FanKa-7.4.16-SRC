package b6;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.j0;
import com.google.common.collect.ImmutableMap;
import java.util.HashMap;
import java.util.Map;

/* compiled from: MediaDescription.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final String f1271a;

    /* renamed from: b, reason: collision with root package name */
    public final int f1272b;

    /* renamed from: c, reason: collision with root package name */
    public final String f1273c;

    /* renamed from: d, reason: collision with root package name */
    public final int f1274d;

    /* renamed from: e, reason: collision with root package name */
    public final int f1275e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public final String f1276f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    public final String f1277g;

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    public final String f1278h;

    /* renamed from: i, reason: collision with root package name */
    public final ImmutableMap<String, String> f1279i;

    /* renamed from: j, reason: collision with root package name */
    public final c f1280j;

    /* compiled from: MediaDescription.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final String f1281a;

        /* renamed from: b, reason: collision with root package name */
        public final int f1282b;

        /* renamed from: c, reason: collision with root package name */
        public final String f1283c;

        /* renamed from: d, reason: collision with root package name */
        public final int f1284d;

        /* renamed from: e, reason: collision with root package name */
        public final HashMap<String, String> f1285e = new HashMap<>();

        /* renamed from: f, reason: collision with root package name */
        public int f1286f = -1;

        /* renamed from: g, reason: collision with root package name */
        @Nullable
        public String f1287g;

        /* renamed from: h, reason: collision with root package name */
        @Nullable
        public String f1288h;

        /* renamed from: i, reason: collision with root package name */
        @Nullable
        public String f1289i;

        public b(String str, int i10, String str2, int i11) {
            this.f1281a = str;
            this.f1282b = i10;
            this.f1283c = str2;
            this.f1284d = i11;
        }

        public b i(String str, String str2) {
            this.f1285e.put(str, str2);
            return this;
        }

        public a j() {
            try {
                com.google.android.exoplayer2.util.a.g(this.f1285e.containsKey("rtpmap"));
                return new a(this, ImmutableMap.copyOf((Map) this.f1285e), c.a((String) j0.j(this.f1285e.get("rtpmap"))));
            } catch (ParserException e2) {
                throw new IllegalStateException(e2);
            }
        }

        public b k(int i10) {
            this.f1286f = i10;
            return this;
        }

        public b l(String str) {
            this.f1288h = str;
            return this;
        }

        public b m(String str) {
            this.f1289i = str;
            return this;
        }

        public b n(String str) {
            this.f1287g = str;
            return this;
        }
    }

    /* compiled from: MediaDescription.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public final int f1290a;

        /* renamed from: b, reason: collision with root package name */
        public final String f1291b;

        /* renamed from: c, reason: collision with root package name */
        public final int f1292c;

        /* renamed from: d, reason: collision with root package name */
        public final int f1293d;

        public c(int i10, String str, int i11, int i12) {
            this.f1290a = i10;
            this.f1291b = str;
            this.f1292c = i11;
            this.f1293d = i12;
        }

        public static c a(String str) throws ParserException {
            String[] N0 = j0.N0(str, " ");
            com.google.android.exoplayer2.util.a.a(N0.length == 2);
            int e2 = com.google.android.exoplayer2.source.rtsp.h.e(N0[0]);
            String[] M0 = j0.M0(N0[1].trim(), "/");
            com.google.android.exoplayer2.util.a.a(M0.length >= 2);
            return new c(e2, M0[0], com.google.android.exoplayer2.source.rtsp.h.e(M0[1]), M0.length == 3 ? com.google.android.exoplayer2.source.rtsp.h.e(M0[2]) : -1);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || c.class != obj.getClass()) {
                return false;
            }
            c cVar = (c) obj;
            return this.f1290a == cVar.f1290a && this.f1291b.equals(cVar.f1291b) && this.f1292c == cVar.f1292c && this.f1293d == cVar.f1293d;
        }

        public int hashCode() {
            return ((((((217 + this.f1290a) * 31) + this.f1291b.hashCode()) * 31) + this.f1292c) * 31) + this.f1293d;
        }
    }

    public ImmutableMap<String, String> a() {
        String str = this.f1279i.get("fmtp");
        if (str == null) {
            return ImmutableMap.of();
        }
        String[] N0 = j0.N0(str, " ");
        com.google.android.exoplayer2.util.a.b(N0.length == 2, str);
        String[] split = N0[1].split(";\\s?", 0);
        ImmutableMap.b bVar = new ImmutableMap.b();
        for (String str2 : split) {
            String[] N02 = j0.N0(str2, "=");
            bVar.g(N02[0], N02[1]);
        }
        return bVar.a();
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || a.class != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        return this.f1271a.equals(aVar.f1271a) && this.f1272b == aVar.f1272b && this.f1273c.equals(aVar.f1273c) && this.f1274d == aVar.f1274d && this.f1275e == aVar.f1275e && this.f1279i.equals(aVar.f1279i) && this.f1280j.equals(aVar.f1280j) && j0.c(this.f1276f, aVar.f1276f) && j0.c(this.f1277g, aVar.f1277g) && j0.c(this.f1278h, aVar.f1278h);
    }

    public int hashCode() {
        int hashCode = (((((((((((((217 + this.f1271a.hashCode()) * 31) + this.f1272b) * 31) + this.f1273c.hashCode()) * 31) + this.f1274d) * 31) + this.f1275e) * 31) + this.f1279i.hashCode()) * 31) + this.f1280j.hashCode()) * 31;
        String str = this.f1276f;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f1277g;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f1278h;
        return hashCode3 + (str3 != null ? str3.hashCode() : 0);
    }

    public a(b bVar, ImmutableMap<String, String> immutableMap, c cVar) {
        this.f1271a = bVar.f1281a;
        this.f1272b = bVar.f1282b;
        this.f1273c = bVar.f1283c;
        this.f1274d = bVar.f1284d;
        this.f1276f = bVar.f1287g;
        this.f1277g = bVar.f1288h;
        this.f1275e = bVar.f1286f;
        this.f1278h = bVar.f1289i;
        this.f1279i = immutableMap;
        this.f1280j = cVar;
    }
}

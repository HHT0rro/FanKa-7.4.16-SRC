package b6;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.j0;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.util.HashMap;
import java.util.Map;

/* compiled from: SessionDescription.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class z {

    /* renamed from: a, reason: collision with root package name */
    public final ImmutableMap<String, String> f1377a;

    /* renamed from: b, reason: collision with root package name */
    public final ImmutableList<b6.a> f1378b;

    /* renamed from: c, reason: collision with root package name */
    public final String f1379c;

    /* renamed from: d, reason: collision with root package name */
    public final String f1380d;

    /* renamed from: e, reason: collision with root package name */
    public final String f1381e;

    /* renamed from: f, reason: collision with root package name */
    public final int f1382f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    public final Uri f1383g;

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    public final String f1384h;

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    public final String f1385i;

    /* renamed from: j, reason: collision with root package name */
    @Nullable
    public final String f1386j;

    /* renamed from: k, reason: collision with root package name */
    @Nullable
    public final String f1387k;

    /* renamed from: l, reason: collision with root package name */
    @Nullable
    public final String f1388l;

    /* compiled from: SessionDescription.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final HashMap<String, String> f1389a = new HashMap<>();

        /* renamed from: b, reason: collision with root package name */
        public final ImmutableList.a<b6.a> f1390b = new ImmutableList.a<>();

        /* renamed from: c, reason: collision with root package name */
        public int f1391c = -1;

        /* renamed from: d, reason: collision with root package name */
        @Nullable
        public String f1392d;

        /* renamed from: e, reason: collision with root package name */
        @Nullable
        public String f1393e;

        /* renamed from: f, reason: collision with root package name */
        @Nullable
        public String f1394f;

        /* renamed from: g, reason: collision with root package name */
        @Nullable
        public Uri f1395g;

        /* renamed from: h, reason: collision with root package name */
        @Nullable
        public String f1396h;

        /* renamed from: i, reason: collision with root package name */
        @Nullable
        public String f1397i;

        /* renamed from: j, reason: collision with root package name */
        @Nullable
        public String f1398j;

        /* renamed from: k, reason: collision with root package name */
        @Nullable
        public String f1399k;

        /* renamed from: l, reason: collision with root package name */
        @Nullable
        public String f1400l;

        public b m(String str, String str2) {
            this.f1389a.put(str, str2);
            return this;
        }

        public b n(b6.a aVar) {
            this.f1390b.a(aVar);
            return this;
        }

        public z o() {
            if (this.f1392d != null && this.f1393e != null && this.f1394f != null) {
                return new z(this);
            }
            throw new IllegalStateException("One of more mandatory SDP fields are not set.");
        }

        public b p(int i10) {
            this.f1391c = i10;
            return this;
        }

        public b q(String str) {
            this.f1396h = str;
            return this;
        }

        public b r(String str) {
            this.f1399k = str;
            return this;
        }

        public b s(String str) {
            this.f1397i = str;
            return this;
        }

        public b t(String str) {
            this.f1393e = str;
            return this;
        }

        public b u(String str) {
            this.f1400l = str;
            return this;
        }

        public b v(String str) {
            this.f1398j = str;
            return this;
        }

        public b w(String str) {
            this.f1392d = str;
            return this;
        }

        public b x(String str) {
            this.f1394f = str;
            return this;
        }

        public b y(Uri uri) {
            this.f1395g = uri;
            return this;
        }
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || z.class != obj.getClass()) {
            return false;
        }
        z zVar = (z) obj;
        return this.f1382f == zVar.f1382f && this.f1377a.equals(zVar.f1377a) && this.f1378b.equals(zVar.f1378b) && this.f1380d.equals(zVar.f1380d) && this.f1379c.equals(zVar.f1379c) && this.f1381e.equals(zVar.f1381e) && j0.c(this.f1388l, zVar.f1388l) && j0.c(this.f1383g, zVar.f1383g) && j0.c(this.f1386j, zVar.f1386j) && j0.c(this.f1387k, zVar.f1387k) && j0.c(this.f1384h, zVar.f1384h) && j0.c(this.f1385i, zVar.f1385i);
    }

    public int hashCode() {
        int hashCode = (((((((((((217 + this.f1377a.hashCode()) * 31) + this.f1378b.hashCode()) * 31) + this.f1380d.hashCode()) * 31) + this.f1379c.hashCode()) * 31) + this.f1381e.hashCode()) * 31) + this.f1382f) * 31;
        String str = this.f1388l;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        Uri uri = this.f1383g;
        int hashCode3 = (hashCode2 + (uri == null ? 0 : uri.hashCode())) * 31;
        String str2 = this.f1386j;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f1387k;
        int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.f1384h;
        int hashCode6 = (hashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.f1385i;
        return hashCode6 + (str5 != null ? str5.hashCode() : 0);
    }

    public z(b bVar) {
        this.f1377a = ImmutableMap.copyOf((Map) bVar.f1389a);
        this.f1378b = bVar.f1390b.k();
        this.f1379c = (String) j0.j(bVar.f1392d);
        this.f1380d = (String) j0.j(bVar.f1393e);
        this.f1381e = (String) j0.j(bVar.f1394f);
        this.f1383g = bVar.f1395g;
        this.f1384h = bVar.f1396h;
        this.f1382f = bVar.f1391c;
        this.f1385i = bVar.f1397i;
        this.f1386j = bVar.f1399k;
        this.f1387k = bVar.f1400l;
        this.f1388l = bVar.f1398j;
    }
}

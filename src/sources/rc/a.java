package rc;

import com.tanx.exposer.achieve.AdMonitorType;
import java.util.Arrays;
import java.util.List;

/* compiled from: AdMonitorConfig.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final int f53353a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f53354b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f53355c;

    /* renamed from: d, reason: collision with root package name */
    public final int f53356d;

    /* renamed from: e, reason: collision with root package name */
    public final List<AdMonitorType> f53357e;

    /* renamed from: f, reason: collision with root package name */
    public final vc.b f53358f;

    /* renamed from: g, reason: collision with root package name */
    public final md.a f53359g;

    /* renamed from: h, reason: collision with root package name */
    public final tc.a f53360h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f53361i;

    /* renamed from: j, reason: collision with root package name */
    public final String f53362j;

    /* renamed from: k, reason: collision with root package name */
    public final String f53363k;

    /* compiled from: AdMonitorConfig.java */
    /* renamed from: rc.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class C0814a {

        /* renamed from: f, reason: collision with root package name */
        public final vc.a f53369f;

        /* renamed from: g, reason: collision with root package name */
        public final uc.a f53370g;

        /* renamed from: h, reason: collision with root package name */
        public tc.a f53371h;

        /* renamed from: j, reason: collision with root package name */
        public String f53373j;

        /* renamed from: k, reason: collision with root package name */
        public String f53374k;

        /* renamed from: l, reason: collision with root package name */
        public boolean f53375l;

        /* renamed from: a, reason: collision with root package name */
        public int f53364a = md.b.f51991a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f53365b = true;

        /* renamed from: c, reason: collision with root package name */
        public boolean f53366c = true;

        /* renamed from: d, reason: collision with root package name */
        public int f53367d = 5;

        /* renamed from: e, reason: collision with root package name */
        public List<AdMonitorType> f53368e = Arrays.asList(AdMonitorType.CLICK, AdMonitorType.EXPOSE, AdMonitorType.INTERACT);

        /* renamed from: i, reason: collision with root package name */
        public boolean f53372i = false;

        public C0814a(vc.a aVar, uc.a aVar2) {
            this.f53369f = aVar;
            this.f53370g = aVar2;
        }

        public C0814a a(int i10) {
            this.f53364a = i10;
            return this;
        }

        public C0814a b(String str, String str2) {
            this.f53373j = str;
            this.f53374k = str2;
            return this;
        }

        public C0814a c(boolean z10) {
            this.f53365b = z10;
            return this;
        }

        public a d() {
            return new a(this);
        }

        public C0814a f(boolean z10) {
            this.f53375l = z10;
            return this;
        }

        public C0814a h(boolean z10) {
            this.f53366c = z10;
            return this;
        }
    }

    public a(C0814a c0814a) {
        int i10 = c0814a.f53364a;
        this.f53353a = i10;
        this.f53354b = c0814a.f53365b;
        this.f53355c = c0814a.f53366c;
        this.f53356d = c0814a.f53367d;
        this.f53357e = c0814a.f53368e;
        this.f53358f = new vc.b(c0814a.f53369f);
        this.f53359g = new md.a(c0814a.f53370g);
        this.f53360h = c0814a.f53371h;
        this.f53361i = c0814a.f53372i;
        this.f53362j = c0814a.f53373j;
        this.f53363k = c0814a.f53374k;
        b.f53376a = c0814a.f53375l;
        md.b.f51991a = i10;
    }

    public List<AdMonitorType> a() {
        return this.f53357e;
    }

    public boolean b() {
        return this.f53361i;
    }

    public String c() {
        return this.f53362j;
    }

    public boolean d() {
        return this.f53354b;
    }

    public String e() {
        return this.f53363k;
    }

    public int f() {
        return this.f53356d;
    }

    public boolean g() {
        return this.f53355c;
    }

    public vc.a h() {
        return this.f53358f;
    }

    public md.a i() {
        return this.f53359g;
    }

    public tc.a j() {
        return this.f53360h;
    }
}

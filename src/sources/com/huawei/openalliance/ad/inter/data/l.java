package com.huawei.openalliance.ad.inter.data;

import com.huawei.hms.ads.AdvertiserInfo;
import com.huawei.openalliance.ad.beans.metadata.MetaData;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class l extends c implements f {
    private int B;
    private int C;
    private String D;
    private int E;
    private MetaData F;
    private List<Integer> G;
    private boolean H;
    private String J;
    private String K;
    private String L;
    private String Q;
    private boolean R;
    private String S;
    private String T;
    private boolean W;

    /* renamed from: aa, reason: collision with root package name */
    private boolean f32446aa;

    /* renamed from: ab, reason: collision with root package name */
    private String f32447ab;

    /* renamed from: ad, reason: collision with root package name */
    private String f32448ad;

    /* renamed from: b, reason: collision with root package name */
    private int f32449b;

    /* renamed from: c, reason: collision with root package name */
    private String f32450c;

    /* renamed from: d, reason: collision with root package name */
    private String f32451d;

    /* renamed from: e, reason: collision with root package name */
    private String f32452e;

    /* renamed from: f, reason: collision with root package name */
    private int f32453f;

    /* renamed from: g, reason: collision with root package name */
    private int f32454g;

    /* renamed from: h, reason: collision with root package name */
    private String f32455h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f32456i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f32457j;

    /* renamed from: k, reason: collision with root package name */
    private int f32458k;

    /* renamed from: m, reason: collision with root package name */
    private String f32459m;

    /* renamed from: n, reason: collision with root package name */
    private String f32460n;

    /* renamed from: r, reason: collision with root package name */
    private String f32461r;

    /* renamed from: s, reason: collision with root package name */
    private long f32462s;

    /* renamed from: t, reason: collision with root package name */
    private int f32463t;

    /* renamed from: u, reason: collision with root package name */
    private String f32464u;

    /* renamed from: v, reason: collision with root package name */
    private String f32465v;

    /* renamed from: w, reason: collision with root package name */
    private v f32466w;

    /* renamed from: x, reason: collision with root package name */
    private List<String> f32467x;

    /* renamed from: y, reason: collision with root package name */
    private List<String> f32468y;

    /* renamed from: z, reason: collision with root package name */
    private AppInfo f32469z;

    public l(AdContentData adContentData) {
        super(adContentData);
        this.f32456i = false;
        this.f32457j = false;
        this.H = false;
        this.R = false;
        this.W = false;
        this.f32446aa = false;
    }

    public void B(int i10) {
        this.f32463t = i10;
    }

    public void B(String str) {
        this.f32455h = str;
    }

    public void B(boolean z10) {
        this.R = z10;
    }

    public v C() {
        return this.f32466w;
    }

    public void C(int i10) {
        this.E = i10;
    }

    public void C(String str) {
        this.f32451d = str;
    }

    public void Code(int i10) {
        this.f32449b = i10;
    }

    public void Code(MetaData metaData) {
        this.F = metaData;
    }

    public void Code(AdContentData adContentData) {
        this.Code = adContentData;
    }

    public void Code(AppInfo appInfo) {
        this.f32469z = appInfo;
    }

    public void Code(v vVar) {
        this.f32466w = vVar;
    }

    public void Code(boolean z10) {
        this.f32456i = z10;
    }

    @Override // com.huawei.openalliance.ad.inter.data.c, com.huawei.openalliance.ad.inter.data.d
    public String D() {
        return this.S;
    }

    public void D(String str) {
        this.f32459m = str;
    }

    @Override // com.huawei.openalliance.ad.inter.data.c, com.huawei.openalliance.ad.inter.data.d
    public String F() {
        return this.D;
    }

    public void F(int i10) {
        this.C = i10;
    }

    public void I(int i10) {
        this.f32454g = i10;
    }

    @Override // com.huawei.openalliance.ad.inter.data.c
    public void I(String str) {
        this.V = str;
    }

    public void I(List<String> list) {
        this.f32468y = list;
    }

    public boolean I() {
        return this.f32456i;
    }

    public void L(String str) {
        this.f32460n = str;
    }

    @Override // com.huawei.openalliance.ad.inter.data.c
    public String N() {
        return this.V;
    }

    public void S(int i10) {
        this.B = i10;
    }

    public void S(String str) {
        this.f32452e = str;
    }

    public void S(boolean z10) {
        this.f32446aa = z10;
    }

    public String T() {
        return this.f32455h;
    }

    public void V(int i10) {
        this.f32453f = i10;
    }

    public void V(long j10) {
        this.f32462s = j10;
    }

    public void V(List<String> list) {
        this.f32467x = list;
    }

    public void V(boolean z10) {
        this.f32457j = z10;
    }

    public void Z(int i10) {
        this.f32458k = i10;
    }

    public void Z(String str) {
        this.f32450c = str;
    }

    public void Z(List<Integer> list) {
        this.G = list;
    }

    public void Z(boolean z10) {
        this.H = z10;
    }

    @Override // com.huawei.openalliance.ad.inter.data.c, com.huawei.openalliance.ad.inter.data.d
    public int a() {
        return this.C;
    }

    public void a(String str) {
        this.f32461r = str;
    }

    public List<AdvertiserInfo> aA() {
        AdContentData adContentData = this.Code;
        if (adContentData == null) {
            return null;
        }
        return adContentData.aG();
    }

    public String af() {
        return this.f32464u;
    }

    public String ag() {
        return this.f32465v;
    }

    public boolean ak() {
        return this.H;
    }

    public boolean ap() {
        return this.R;
    }

    public boolean av() {
        return this.f32446aa;
    }

    public AdContentData ax() {
        return this.Code;
    }

    public void b(String str) {
        this.f32464u = str;
    }

    @Override // com.huawei.openalliance.ad.inter.data.c, com.huawei.openalliance.ad.inter.data.d
    public String c() {
        return this.L;
    }

    public void c(String str) {
        this.f32465v = str;
    }

    public void e(String str) {
        this.J = str;
    }

    public void f(String str) {
        this.K = str;
    }

    public void i(String str) {
        this.Q = str;
    }

    public void j(String str) {
        this.T = str;
    }

    @Override // com.huawei.openalliance.ad.inter.data.c
    public MetaData k() {
        return this.F;
    }

    @Override // com.huawei.openalliance.ad.inter.data.c, com.huawei.openalliance.ad.inter.data.d
    public String m() {
        return this.Q;
    }

    public void m(String str) {
        this.f32447ab = str;
    }

    public void n(String str) {
        this.S = str;
    }

    @Override // com.huawei.openalliance.ad.inter.data.c
    public String o() {
        return this.f32447ab;
    }

    public void o(String str) {
        this.D = str;
    }

    public void p(String str) {
        this.L = str;
    }

    public void q(String str) {
        this.f32448ad = str;
    }

    @Override // com.huawei.openalliance.ad.inter.data.c, com.huawei.openalliance.ad.inter.data.d
    public long r() {
        return this.f32462s;
    }

    @Override // com.huawei.openalliance.ad.inter.data.c, com.huawei.openalliance.ad.inter.data.d
    public int s() {
        return this.f32463t;
    }

    @Override // com.huawei.openalliance.ad.inter.data.c, com.huawei.openalliance.ad.inter.data.d
    public AppInfo v() {
        return this.f32469z;
    }

    @Override // com.huawei.openalliance.ad.inter.data.c
    public String z() {
        return this.K;
    }
}

package ar.com.hjg.pngj;

/* compiled from: RowInfo.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class s {

    /* renamed from: a, reason: collision with root package name */
    public final k f1215a;

    /* renamed from: b, reason: collision with root package name */
    public final e f1216b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f1217c;

    /* renamed from: d, reason: collision with root package name */
    public int f1218d;

    /* renamed from: e, reason: collision with root package name */
    public int f1219e;

    /* renamed from: f, reason: collision with root package name */
    public int f1220f;

    /* renamed from: g, reason: collision with root package name */
    public int f1221g;

    /* renamed from: h, reason: collision with root package name */
    public int f1222h;

    /* renamed from: i, reason: collision with root package name */
    public int f1223i;

    /* renamed from: j, reason: collision with root package name */
    public int f1224j;

    /* renamed from: k, reason: collision with root package name */
    public int f1225k;

    /* renamed from: l, reason: collision with root package name */
    public int f1226l;

    /* renamed from: m, reason: collision with root package name */
    public int f1227m;

    /* renamed from: n, reason: collision with root package name */
    public int f1228n;

    /* renamed from: o, reason: collision with root package name */
    public byte[] f1229o;

    /* renamed from: p, reason: collision with root package name */
    public int f1230p;

    public s(k kVar, e eVar) {
        this.f1215a = kVar;
        this.f1216b = eVar;
        this.f1217c = eVar != null;
    }

    public void a(int i10) {
        this.f1222h = i10;
        if (this.f1217c) {
            this.f1228n = this.f1216b.e();
            e eVar = this.f1216b;
            this.f1219e = eVar.f1163f;
            this.f1218d = eVar.f1162e;
            this.f1221g = eVar.f1165h;
            this.f1220f = eVar.f1164g;
            this.f1223i = eVar.c();
            this.f1224j = this.f1216b.d();
            this.f1225k = this.f1216b.g();
            int b4 = this.f1216b.b();
            this.f1226l = b4;
            this.f1227m = ((this.f1215a.f1188i * b4) + 7) / 8;
            return;
        }
        this.f1228n = 1;
        this.f1218d = 1;
        this.f1219e = 1;
        this.f1220f = 0;
        this.f1221g = 0;
        this.f1224j = i10;
        this.f1223i = i10;
        k kVar = this.f1215a;
        this.f1225k = kVar.f1181b;
        this.f1226l = kVar.f1180a;
        this.f1227m = kVar.f1190k;
    }

    public void b(byte[] bArr, int i10) {
        this.f1229o = bArr;
        this.f1230p = i10;
    }
}

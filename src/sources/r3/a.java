package r3;

/* compiled from: DimensionStatus.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class a {

    /* renamed from: c, reason: collision with root package name */
    public static final a f53246c;

    /* renamed from: d, reason: collision with root package name */
    public static final a f53247d;

    /* renamed from: e, reason: collision with root package name */
    public static final a f53248e;

    /* renamed from: f, reason: collision with root package name */
    public static final a f53249f;

    /* renamed from: g, reason: collision with root package name */
    public static final a f53250g;

    /* renamed from: h, reason: collision with root package name */
    public static final a f53251h;

    /* renamed from: i, reason: collision with root package name */
    public static final a f53252i;

    /* renamed from: j, reason: collision with root package name */
    public static final a f53253j;

    /* renamed from: k, reason: collision with root package name */
    public static final a f53254k;

    /* renamed from: l, reason: collision with root package name */
    public static final a f53255l;

    /* renamed from: m, reason: collision with root package name */
    public static final a f53256m;

    /* renamed from: n, reason: collision with root package name */
    public static final a f53257n;

    /* renamed from: o, reason: collision with root package name */
    public static final a[] f53258o;

    /* renamed from: a, reason: collision with root package name */
    public final int f53259a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f53260b;

    static {
        a aVar = new a(0, false);
        f53246c = aVar;
        a aVar2 = new a(1, true);
        f53247d = aVar2;
        a aVar3 = new a(2, false);
        f53248e = aVar3;
        a aVar4 = new a(3, true);
        f53249f = aVar4;
        a aVar5 = new a(4, false);
        f53250g = aVar5;
        a aVar6 = new a(5, true);
        f53251h = aVar6;
        a aVar7 = new a(6, false);
        f53252i = aVar7;
        a aVar8 = new a(7, true);
        f53253j = aVar8;
        a aVar9 = new a(8, false);
        f53254k = aVar9;
        a aVar10 = new a(9, true);
        f53255l = aVar10;
        a aVar11 = new a(10, false);
        f53256m = aVar11;
        a aVar12 = new a(10, true);
        f53257n = aVar12;
        f53258o = new a[]{aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7, aVar8, aVar9, aVar10, aVar11, aVar12};
    }

    public a(int i10, boolean z10) {
        this.f53259a = i10;
        this.f53260b = z10;
    }

    public boolean a(a aVar) {
        int i10 = this.f53259a;
        int i11 = aVar.f53259a;
        return i10 < i11 || ((!this.f53260b || f53255l == this) && i10 == i11);
    }

    public a b() {
        return !this.f53260b ? f53258o[this.f53259a + 1] : this;
    }

    public a c() {
        if (!this.f53260b) {
            return this;
        }
        a aVar = f53258o[this.f53259a - 1];
        return !aVar.f53260b ? aVar : f53246c;
    }
}

package com.huawei.hms.scankit.p;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: DataMask.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
abstract class g1 {

    /* renamed from: a, reason: collision with root package name */
    public static final g1 f31015a;

    /* renamed from: b, reason: collision with root package name */
    public static final g1 f31016b;

    /* renamed from: c, reason: collision with root package name */
    public static final g1 f31017c;

    /* renamed from: d, reason: collision with root package name */
    public static final g1 f31018d;

    /* renamed from: e, reason: collision with root package name */
    public static final g1 f31019e;

    /* renamed from: f, reason: collision with root package name */
    public static final g1 f31020f;

    /* renamed from: g, reason: collision with root package name */
    public static final g1 f31021g;

    /* renamed from: h, reason: collision with root package name */
    public static final g1 f31022h;

    /* renamed from: i, reason: collision with root package name */
    private static final /* synthetic */ g1[] f31023i;

    /* compiled from: DataMask.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public enum a extends g1 {
        public a(String str, int i10) {
            super(str, i10, null);
        }

        @Override // com.huawei.hms.scankit.p.g1
        public boolean a(int i10, int i11) {
            return ((i10 + i11) & 1) == 0;
        }
    }

    static {
        a aVar = new a("DATA_MASK_000", 0);
        f31015a = aVar;
        g1 g1Var = new g1("DATA_MASK_001", 1) { // from class: com.huawei.hms.scankit.p.g1.b
            {
                a aVar2 = null;
            }

            @Override // com.huawei.hms.scankit.p.g1
            public boolean a(int i10, int i11) {
                return (i10 & 1) == 0;
            }
        };
        f31016b = g1Var;
        g1 g1Var2 = new g1("DATA_MASK_010", 2) { // from class: com.huawei.hms.scankit.p.g1.c
            {
                a aVar2 = null;
            }

            @Override // com.huawei.hms.scankit.p.g1
            public boolean a(int i10, int i11) {
                return i11 % 3 == 0;
            }
        };
        f31017c = g1Var2;
        g1 g1Var3 = new g1("DATA_MASK_011", 3) { // from class: com.huawei.hms.scankit.p.g1.d
            {
                a aVar2 = null;
            }

            @Override // com.huawei.hms.scankit.p.g1
            public boolean a(int i10, int i11) {
                return (i10 + i11) % 3 == 0;
            }
        };
        f31018d = g1Var3;
        g1 g1Var4 = new g1("DATA_MASK_100", 4) { // from class: com.huawei.hms.scankit.p.g1.e
            {
                a aVar2 = null;
            }

            @Override // com.huawei.hms.scankit.p.g1
            public boolean a(int i10, int i11) {
                return (((i10 / 2) + (i11 / 3)) & 1) == 0;
            }
        };
        f31019e = g1Var4;
        g1 g1Var5 = new g1("DATA_MASK_101", 5) { // from class: com.huawei.hms.scankit.p.g1.f
            {
                a aVar2 = null;
            }

            @Override // com.huawei.hms.scankit.p.g1
            public boolean a(int i10, int i11) {
                return (i10 * i11) % 6 == 0;
            }
        };
        f31020f = g1Var5;
        g1 g1Var6 = new g1("DATA_MASK_110", 6) { // from class: com.huawei.hms.scankit.p.g1.g
            {
                a aVar2 = null;
            }

            @Override // com.huawei.hms.scankit.p.g1
            public boolean a(int i10, int i11) {
                return (i10 * i11) % 6 < 3;
            }
        };
        f31021g = g1Var6;
        g1 g1Var7 = new g1("DATA_MASK_111", 7) { // from class: com.huawei.hms.scankit.p.g1.h
            {
                a aVar2 = null;
            }

            @Override // com.huawei.hms.scankit.p.g1
            public boolean a(int i10, int i11) {
                return (((i10 + i11) + ((i10 * i11) % 3)) & 1) == 0;
            }
        };
        f31022h = g1Var7;
        f31023i = new g1[]{aVar, g1Var, g1Var2, g1Var3, g1Var4, g1Var5, g1Var6, g1Var7};
    }

    private g1(String str, int i10) {
    }

    public static g1 valueOf(String str) {
        return (g1) Enum.valueOf(g1.class, str);
    }

    public static g1[] values() {
        return (g1[]) f31023i.clone();
    }

    public final void a(s sVar, int i10) {
        for (int i11 = 0; i11 < i10; i11++) {
            for (int i12 = 0; i12 < i10; i12++) {
                if (a(i11, i12)) {
                    sVar.a(i12, i11);
                }
            }
        }
    }

    public abstract boolean a(int i10, int i11);

    public /* synthetic */ g1(String str, int i10, a aVar) {
        this(str, i10);
    }
}

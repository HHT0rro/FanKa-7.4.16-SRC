package com.huawei.hms.scankit.p;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: DataMask.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
abstract class f1 {

    /* renamed from: a, reason: collision with root package name */
    public static final f1 f30964a;

    /* renamed from: b, reason: collision with root package name */
    public static final f1 f30965b;

    /* renamed from: c, reason: collision with root package name */
    public static final f1 f30966c;

    /* renamed from: d, reason: collision with root package name */
    public static final f1 f30967d;

    /* renamed from: e, reason: collision with root package name */
    public static final f1 f30968e;

    /* renamed from: f, reason: collision with root package name */
    public static final f1 f30969f;

    /* renamed from: g, reason: collision with root package name */
    public static final f1 f30970g;

    /* renamed from: h, reason: collision with root package name */
    public static final f1 f30971h;

    /* renamed from: i, reason: collision with root package name */
    private static final /* synthetic */ f1[] f30972i;

    /* compiled from: DataMask.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public enum a extends f1 {
        public a(String str, int i10) {
            super(str, i10, null);
        }

        @Override // com.huawei.hms.scankit.p.f1
        public boolean a(int i10, int i11) {
            return ((i10 + i11) & 1) == 0;
        }
    }

    static {
        a aVar = new a("DATA_MASK_000", 0);
        f30964a = aVar;
        f1 f1Var = new f1("DATA_MASK_001", 1) { // from class: com.huawei.hms.scankit.p.f1.b
            {
                a aVar2 = null;
            }

            @Override // com.huawei.hms.scankit.p.f1
            public boolean a(int i10, int i11) {
                return (i10 & 1) == 0;
            }
        };
        f30965b = f1Var;
        f1 f1Var2 = new f1("DATA_MASK_010", 2) { // from class: com.huawei.hms.scankit.p.f1.c
            {
                a aVar2 = null;
            }

            @Override // com.huawei.hms.scankit.p.f1
            public boolean a(int i10, int i11) {
                return i11 % 3 == 0;
            }
        };
        f30966c = f1Var2;
        f1 f1Var3 = new f1("DATA_MASK_011", 3) { // from class: com.huawei.hms.scankit.p.f1.d
            {
                a aVar2 = null;
            }

            @Override // com.huawei.hms.scankit.p.f1
            public boolean a(int i10, int i11) {
                return (i10 + i11) % 3 == 0;
            }
        };
        f30967d = f1Var3;
        f1 f1Var4 = new f1("DATA_MASK_100", 4) { // from class: com.huawei.hms.scankit.p.f1.e
            {
                a aVar2 = null;
            }

            @Override // com.huawei.hms.scankit.p.f1
            public boolean a(int i10, int i11) {
                return (((i10 / 2) + (i11 / 3)) & 1) == 0;
            }
        };
        f30968e = f1Var4;
        f1 f1Var5 = new f1("DATA_MASK_101", 5) { // from class: com.huawei.hms.scankit.p.f1.f
            {
                a aVar2 = null;
            }

            @Override // com.huawei.hms.scankit.p.f1
            public boolean a(int i10, int i11) {
                return (i10 * i11) % 6 == 0;
            }
        };
        f30969f = f1Var5;
        f1 f1Var6 = new f1("DATA_MASK_110", 6) { // from class: com.huawei.hms.scankit.p.f1.g
            {
                a aVar2 = null;
            }

            @Override // com.huawei.hms.scankit.p.f1
            public boolean a(int i10, int i11) {
                return (i10 * i11) % 6 < 3;
            }
        };
        f30970g = f1Var6;
        f1 f1Var7 = new f1("DATA_MASK_111", 7) { // from class: com.huawei.hms.scankit.p.f1.h
            {
                a aVar2 = null;
            }

            @Override // com.huawei.hms.scankit.p.f1
            public boolean a(int i10, int i11) {
                return (((i10 + i11) + ((i10 * i11) % 3)) & 1) == 0;
            }
        };
        f30971h = f1Var7;
        f30972i = new f1[]{aVar, f1Var, f1Var2, f1Var3, f1Var4, f1Var5, f1Var6, f1Var7};
    }

    private f1(String str, int i10) {
    }

    public static f1 valueOf(String str) {
        return (f1) Enum.valueOf(f1.class, str);
    }

    public static f1[] values() {
        return (f1[]) f30972i.clone();
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

    public /* synthetic */ f1(String str, int i10, a aVar) {
        this(str, i10);
    }
}

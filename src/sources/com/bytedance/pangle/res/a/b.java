package com.bytedance.pangle.res.a;

import java.io.IOException;
import java.util.HashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class b {

    /* renamed from: c, reason: collision with root package name */
    public g f10908c;

    /* renamed from: i, reason: collision with root package name */
    private final h f10914i;

    /* renamed from: j, reason: collision with root package name */
    private final byte[] f10915j;

    /* renamed from: l, reason: collision with root package name */
    private int[] f10917l;

    /* renamed from: n, reason: collision with root package name */
    private boolean f10919n;

    /* renamed from: o, reason: collision with root package name */
    private int f10920o;

    /* renamed from: p, reason: collision with root package name */
    private int[] f10921p;

    /* renamed from: q, reason: collision with root package name */
    private int f10922q;

    /* renamed from: a, reason: collision with root package name */
    public HashMap<Integer, Integer> f10906a = new HashMap<>();

    /* renamed from: b, reason: collision with root package name */
    public boolean f10907b = false;

    /* renamed from: k, reason: collision with root package name */
    private boolean f10916k = false;

    /* renamed from: m, reason: collision with root package name */
    private final a f10918m = new a();

    /* renamed from: d, reason: collision with root package name */
    public int f10909d = 0;

    /* renamed from: e, reason: collision with root package name */
    public int f10910e = 1;

    /* renamed from: f, reason: collision with root package name */
    public int f10911f = 2;

    /* renamed from: g, reason: collision with root package name */
    public int f10912g = 3;

    /* renamed from: h, reason: collision with root package name */
    public int f10913h = 4;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public int[] f10923a = new int[32];

        /* renamed from: b, reason: collision with root package name */
        public int f10924b;

        /* renamed from: c, reason: collision with root package name */
        public int f10925c;

        public final void a() {
            b();
            int i10 = this.f10924b;
            int[] iArr = this.f10923a;
            iArr[i10] = 0;
            iArr[i10 + 1] = 0;
            this.f10924b = i10 + 2;
            this.f10925c++;
        }

        public final void b() {
            int[] iArr = this.f10923a;
            int length = iArr.length;
            int i10 = this.f10924b;
            int i11 = length - i10;
            if (i11 > 2) {
                return;
            }
            int[] iArr2 = new int[(iArr.length + i11) * 2];
            System.arraycopy((Object) iArr, 0, (Object) iArr2, 0, i10);
            this.f10923a = iArr2;
        }
    }

    public b(byte[] bArr, h hVar) {
        this.f10914i = hVar;
        this.f10915j = bArr;
        c();
    }

    private void c() {
        this.f10920o = -1;
        this.f10921p = null;
        this.f10922q = -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:118:0x0294, code lost:
    
        throw new java.io.IOException("Invalid chunk type (" + r6 + ").");
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x012b, code lost:
    
        throw new java.io.IOException("Invalid resource ids size (" + r6 + ").");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void d() {
        /*
            Method dump skipped, instructions count: 661
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.res.a.b.d():void");
    }

    public final void a() {
        if (this.f10916k) {
            this.f10916k = false;
            this.f10908c = null;
            this.f10917l = null;
            a aVar = this.f10918m;
            aVar.f10924b = 0;
            aVar.f10925c = 0;
            c();
        }
    }

    public final int b() {
        if (this.f10908c != null) {
            try {
                d();
                return this.f10920o;
            } catch (IOException e2) {
                a();
                throw e2;
            }
        }
        throw new RuntimeException("Parser is not opened.");
    }
}

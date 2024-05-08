package kotlin.random;

import java.io.Serializable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: XorWowRandom.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class XorWowRandom extends Random implements Serializable {

    @NotNull
    private static final a Companion = new a(null);
    private static final long serialVersionUID = 0;
    private int addend;

    /* renamed from: v, reason: collision with root package name */
    private int f51049v;

    /* renamed from: w, reason: collision with root package name */
    private int f51050w;

    /* renamed from: x, reason: collision with root package name */
    private int f51051x;

    /* renamed from: y, reason: collision with root package name */
    private int f51052y;

    /* renamed from: z, reason: collision with root package name */
    private int f51053z;

    /* compiled from: XorWowRandom.kt */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public XorWowRandom(int i10, int i11, int i12, int i13, int i14, int i15) {
        this.f51051x = i10;
        this.f51052y = i11;
        this.f51053z = i12;
        this.f51050w = i13;
        this.f51049v = i14;
        this.addend = i15;
        int i16 = i10 | i11 | i12 | i13 | i14;
        if (!(i16 != 0)) {
            throw new IllegalArgumentException("Initial state must have at least one non-zero element.".toString());
        }
        for (int i17 = 0; i17 < 64; i17++) {
            nextInt();
        }
    }

    @Override // kotlin.random.Random
    public int nextBits(int i10) {
        return d.f(nextInt(), i10);
    }

    @Override // kotlin.random.Random
    public int nextInt() {
        int i10 = this.f51051x;
        int i11 = i10 ^ (i10 >>> 2);
        this.f51051x = this.f51052y;
        this.f51052y = this.f51053z;
        this.f51053z = this.f51050w;
        int i12 = this.f51049v;
        this.f51050w = i12;
        int i13 = ((i11 ^ (i11 << 1)) ^ i12) ^ (i12 << 4);
        this.f51049v = i13;
        int i14 = this.addend + 362437;
        this.addend = i14;
        return i13 + i14;
    }

    public XorWowRandom(int i10, int i11) {
        this(i10, i11, 0, 0, ~i10, (i10 << 10) ^ (i11 >>> 4));
    }
}

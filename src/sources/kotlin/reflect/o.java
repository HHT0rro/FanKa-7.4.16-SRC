package kotlin.reflect;

import com.huawei.appgallery.agd.common.utils.StringUtils;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: KTypeProjection.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class o {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f51057c = new a(null);

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final o f51058d = new o(null, null);

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    public final KVariance f51059a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public final n f51060b;

    /* compiled from: KTypeProjection.kt */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: KTypeProjection.kt */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f51061a;

        static {
            int[] iArr = new int[KVariance.values().length];
            try {
                iArr[KVariance.INVARIANT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[KVariance.IN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[KVariance.OUT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f51061a = iArr;
        }
    }

    public o(@Nullable KVariance kVariance, @Nullable n nVar) {
        String str;
        this.f51059a = kVariance;
        this.f51060b = nVar;
        if ((kVariance == null) == (nVar == null)) {
            return;
        }
        if (kVariance == null) {
            str = "Star projection must have no type specified.";
        } else {
            str = "The projection variance " + ((Object) kVariance) + " requires type to be specified.";
        }
        throw new IllegalArgumentException(str.toString());
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        return this.f51059a == oVar.f51059a && s.d(this.f51060b, oVar.f51060b);
    }

    public int hashCode() {
        KVariance kVariance = this.f51059a;
        int hashCode = (kVariance == null ? 0 : kVariance.hashCode()) * 31;
        n nVar = this.f51060b;
        return hashCode + (nVar != null ? nVar.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        KVariance kVariance = this.f51059a;
        int i10 = kVariance == null ? -1 : b.f51061a[kVariance.ordinal()];
        if (i10 == -1) {
            return StringUtils.NO_PRINT_CODE;
        }
        if (i10 == 1) {
            return String.valueOf(this.f51060b);
        }
        if (i10 == 2) {
            return "in " + ((Object) this.f51060b);
        }
        if (i10 != 3) {
            throw new NoWhenBranchMatchedException();
        }
        return "out " + ((Object) this.f51060b);
    }
}

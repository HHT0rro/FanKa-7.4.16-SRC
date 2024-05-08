package ce;

import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: PrimitiveRanges.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class l extends j implements g<Long> {

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public static final a f1624f = new a(null);

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public static final l f1625g = new l(1, 0);

    /* compiled from: PrimitiveRanges.kt */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public l(long j10, long j11) {
        super(j10, j11, 1L);
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof l) {
            if (!isEmpty() || !((l) obj).isEmpty()) {
                l lVar = (l) obj;
                if (b() != lVar.b() || c() != lVar.c()) {
                }
            }
            return true;
        }
        return false;
    }

    public boolean g(long j10) {
        return b() <= j10 && j10 <= c();
    }

    @Override // ce.g
    @NotNull
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public Long getEndInclusive() {
        return Long.valueOf(c());
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (int) ((31 * (b() ^ (b() >>> 32))) + (c() ^ (c() >>> 32)));
    }

    @Override // ce.g
    @NotNull
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public Long getStart() {
        return Long.valueOf(b());
    }

    public boolean isEmpty() {
        return b() > c();
    }

    @NotNull
    public String toString() {
        return b() + ".." + c();
    }
}

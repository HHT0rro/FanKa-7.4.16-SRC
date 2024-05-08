package ce;

import kotlin.collections.f0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: Progressions.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class j implements Iterable<Long>, zd.a {

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public static final a f1616e = new a(null);

    /* renamed from: b, reason: collision with root package name */
    public final long f1617b;

    /* renamed from: c, reason: collision with root package name */
    public final long f1618c;

    /* renamed from: d, reason: collision with root package name */
    public final long f1619d;

    /* compiled from: Progressions.kt */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public j(long j10, long j11, long j12) {
        if (j12 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (j12 != Long.MIN_VALUE) {
            this.f1617b = j10;
            this.f1618c = ud.c.d(j10, j11, j12);
            this.f1619d = j12;
            return;
        }
        throw new IllegalArgumentException("Step must be greater than Long.MIN_VALUE to avoid overflow on negation.");
    }

    public final long b() {
        return this.f1617b;
    }

    public final long c() {
        return this.f1618c;
    }

    @Override // java.lang.Iterable
    @NotNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public f0 iterator2() {
        return new k(this.f1617b, this.f1618c, this.f1619d);
    }
}

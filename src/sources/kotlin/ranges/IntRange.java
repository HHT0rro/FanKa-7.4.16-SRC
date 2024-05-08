package kotlin.ranges;

import ce.g;
import ce.h;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: PrimitiveRanges.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class IntRange extends h implements g<Integer> {

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public static final a f51055f = new a(null);

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public static final IntRange f51056g = new IntRange(1, 0);

    /* compiled from: PrimitiveRanges.kt */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final IntRange a() {
            return IntRange.f51056g;
        }
    }

    public IntRange(int i10, int i11) {
        super(i10, i11, 1);
    }

    @Override // ce.h
    public boolean equals(@Nullable Object obj) {
        if (obj instanceof IntRange) {
            if (!isEmpty() || !((IntRange) obj).isEmpty()) {
                IntRange intRange = (IntRange) obj;
                if (b() != intRange.b() || c() != intRange.c()) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // ce.h
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (b() * 31) + c();
    }

    public boolean i(int i10) {
        return b() <= i10 && i10 <= c();
    }

    @Override // ce.h
    public boolean isEmpty() {
        return b() > c();
    }

    @Override // ce.g
    @NotNull
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public Integer getEndInclusive() {
        return Integer.valueOf(c());
    }

    @Override // ce.g
    @NotNull
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public Integer getStart() {
        return Integer.valueOf(b());
    }

    @Override // ce.h
    @NotNull
    public String toString() {
        return b() + ".." + c();
    }
}

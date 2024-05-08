package ce;

import kotlin.collections.e0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Progressions.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class h implements Iterable<Integer>, zd.a {

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public static final a f1608e = new a(null);

    /* renamed from: b, reason: collision with root package name */
    public final int f1609b;

    /* renamed from: c, reason: collision with root package name */
    public final int f1610c;

    /* renamed from: d, reason: collision with root package name */
    public final int f1611d;

    /* compiled from: Progressions.kt */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final h a(int i10, int i11, int i12) {
            return new h(i10, i11, i12);
        }
    }

    public h(int i10, int i11, int i12) {
        if (i12 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i12 != Integer.MIN_VALUE) {
            this.f1609b = i10;
            this.f1610c = ud.c.c(i10, i11, i12);
            this.f1611d = i12;
            return;
        }
        throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
    }

    public final int b() {
        return this.f1609b;
    }

    public final int c() {
        return this.f1610c;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof h) {
            if (!isEmpty() || !((h) obj).isEmpty()) {
                h hVar = (h) obj;
                if (this.f1609b != hVar.f1609b || this.f1610c != hVar.f1610c || this.f1611d != hVar.f1611d) {
                }
            }
            return true;
        }
        return false;
    }

    public final int f() {
        return this.f1611d;
    }

    @Override // java.lang.Iterable
    @NotNull
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public e0 iterator2() {
        return new i(this.f1609b, this.f1610c, this.f1611d);
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.f1609b * 31) + this.f1610c) * 31) + this.f1611d;
    }

    public boolean isEmpty() {
        if (this.f1611d > 0) {
            if (this.f1609b > this.f1610c) {
                return true;
            }
        } else if (this.f1609b < this.f1610c) {
            return true;
        }
        return false;
    }

    @NotNull
    public String toString() {
        StringBuilder sb2;
        int i10;
        if (this.f1611d > 0) {
            sb2 = new StringBuilder();
            sb2.append(this.f1609b);
            sb2.append("..");
            sb2.append(this.f1610c);
            sb2.append(" step ");
            i10 = this.f1611d;
        } else {
            sb2 = new StringBuilder();
            sb2.append(this.f1609b);
            sb2.append(" downTo ");
            sb2.append(this.f1610c);
            sb2.append(" step ");
            i10 = -this.f1611d;
        }
        sb2.append(i10);
        return sb2.toString();
    }
}

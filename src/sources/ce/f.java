package ce;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Ranges.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class f implements g {

    /* renamed from: b, reason: collision with root package name */
    public final float f1606b;

    /* renamed from: c, reason: collision with root package name */
    public final float f1607c;

    @Override // ce.g
    @NotNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Float getEndInclusive() {
        return Float.valueOf(this.f1607c);
    }

    @Override // ce.g
    @NotNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Float getStart() {
        return Float.valueOf(this.f1606b);
    }

    public boolean c() {
        return this.f1606b > this.f1607c;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof f) {
            if (c() && ((f) obj).c()) {
                return true;
            }
            f fVar = (f) obj;
            if (this.f1606b == fVar.f1606b) {
                if (this.f1607c == fVar.f1607c) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        if (c()) {
            return -1;
        }
        return (Float.floatToIntBits(this.f1606b) * 31) + Float.floatToIntBits(this.f1607c);
    }

    @NotNull
    public String toString() {
        return this.f1606b + ".." + this.f1607c;
    }
}

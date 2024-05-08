package ce;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Ranges.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class e implements g {

    /* renamed from: b, reason: collision with root package name */
    public final double f1604b;

    /* renamed from: c, reason: collision with root package name */
    public final double f1605c;

    @Override // ce.g
    @NotNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Double getEndInclusive() {
        return Double.valueOf(this.f1605c);
    }

    @Override // ce.g
    @NotNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Double getStart() {
        return Double.valueOf(this.f1604b);
    }

    public boolean c() {
        return this.f1604b > this.f1605c;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof e) {
            if (c() && ((e) obj).c()) {
                return true;
            }
            e eVar = (e) obj;
            if (this.f1604b == eVar.f1604b) {
                if (this.f1605c == eVar.f1605c) {
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
        return (d.a(this.f1604b) * 31) + d.a(this.f1605c);
    }

    @NotNull
    public String toString() {
        return this.f1604b + ".." + this.f1605c;
    }
}

package kotlin.text;

import kotlin.jvm.internal.s;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Regex.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public final String f51115a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final IntRange f51116b;

    public f(@NotNull String value, @NotNull IntRange range) {
        s.i(value, "value");
        s.i(range, "range");
        this.f51115a = value;
        this.f51116b = range;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return s.d(this.f51115a, fVar.f51115a) && s.d(this.f51116b, fVar.f51116b);
    }

    public int hashCode() {
        return (this.f51115a.hashCode() * 31) + this.f51116b.hashCode();
    }

    @NotNull
    public String toString() {
        return "MatchGroup(value=" + this.f51115a + ", range=" + ((Object) this.f51116b) + ')';
    }
}

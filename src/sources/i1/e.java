package i1;

import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: TextManager.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final int f49682a;

    /* renamed from: b, reason: collision with root package name */
    public final double f49683b;

    /* renamed from: c, reason: collision with root package name */
    public final double f49684c;

    /* renamed from: d, reason: collision with root package name */
    public final char f49685d;

    /* renamed from: e, reason: collision with root package name */
    public final float f49686e;

    public e(int i10, double d10, double d11, char c4, float f10) {
        this.f49682a = i10;
        this.f49683b = d10;
        this.f49684c = d11;
        this.f49685d = c4;
        this.f49686e = f10;
    }

    public final double a() {
        return this.f49684c;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return this.f49682a == eVar.f49682a && Double.compare(this.f49683b, eVar.f49683b) == 0 && Double.compare(this.f49684c, eVar.f49684c) == 0 && this.f49685d == eVar.f49685d && Float.compare(this.f49686e, eVar.f49686e) == 0;
    }

    public int hashCode() {
        return (((((((this.f49682a * 31) + ce.d.a(this.f49683b)) * 31) + ce.d.a(this.f49684c)) * 31) + this.f49685d) * 31) + Float.floatToIntBits(this.f49686e);
    }

    @NotNull
    public String toString() {
        return "PreviousProgress(currentIndex=" + this.f49682a + ", offsetPercentage=" + this.f49683b + ", progress=" + this.f49684c + ", currentChar=" + this.f49685d + ", currentWidth=" + this.f49686e + ")";
    }

    public /* synthetic */ e(int i10, double d10, double d11, char c4, float f10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(i10, d10, d11, (i11 & 8) != 0 ? (char) 0 : c4, (i11 & 16) != 0 ? 0.0f : f10);
    }
}

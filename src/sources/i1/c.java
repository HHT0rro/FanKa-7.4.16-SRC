package i1;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: TextManager.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final int f49679a;

    /* renamed from: b, reason: collision with root package name */
    public final double f49680b;

    /* renamed from: c, reason: collision with root package name */
    public final double f49681c;

    public c(int i10, double d10, double d11) {
        this.f49679a = i10;
        this.f49680b = d10;
        this.f49681c = d11;
    }

    public final int a() {
        return this.f49679a;
    }

    public final double b() {
        return this.f49680b;
    }

    public final double c() {
        return this.f49681c;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.f49679a == cVar.f49679a && Double.compare(this.f49680b, cVar.f49680b) == 0 && Double.compare(this.f49681c, cVar.f49681c) == 0;
    }

    public int hashCode() {
        return (((this.f49679a * 31) + ce.d.a(this.f49680b)) * 31) + ce.d.a(this.f49681c);
    }

    @NotNull
    public String toString() {
        return "NextProgress(currentIndex=" + this.f49679a + ", offsetPercentage=" + this.f49680b + ", progress=" + this.f49681c + ")";
    }
}

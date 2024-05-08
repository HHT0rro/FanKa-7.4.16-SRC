package d5;

import androidx.annotation.Nullable;

/* compiled from: SeekPoint.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class o {

    /* renamed from: c, reason: collision with root package name */
    public static final o f48643c = new o(0, 0);

    /* renamed from: a, reason: collision with root package name */
    public final long f48644a;

    /* renamed from: b, reason: collision with root package name */
    public final long f48645b;

    public o(long j10, long j11) {
        this.f48644a = j10;
        this.f48645b = j11;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || o.class != obj.getClass()) {
            return false;
        }
        o oVar = (o) obj;
        return this.f48644a == oVar.f48644a && this.f48645b == oVar.f48645b;
    }

    public int hashCode() {
        return (((int) this.f48644a) * 31) + ((int) this.f48645b);
    }

    public String toString() {
        long j10 = this.f48644a;
        long j11 = this.f48645b;
        StringBuilder sb2 = new StringBuilder(60);
        sb2.append("[timeUs=");
        sb2.append(j10);
        sb2.append(", position=");
        sb2.append(j11);
        sb2.append("]");
        return sb2.toString();
    }
}

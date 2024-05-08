package n4;

import androidx.annotation.NonNull;
import java.util.Arrays;
import java.util.Objects;

/* compiled from: EncodedPayload.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final com.google.android.datatransport.a f52108a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f52109b;

    public d(@NonNull com.google.android.datatransport.a aVar, @NonNull byte[] bArr) {
        Objects.requireNonNull(aVar, "encoding is null");
        Objects.requireNonNull(bArr, "bytes is null");
        this.f52108a = aVar;
        this.f52109b = bArr;
    }

    public byte[] a() {
        return this.f52109b;
    }

    public com.google.android.datatransport.a b() {
        return this.f52108a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        if (this.f52108a.equals(dVar.f52108a)) {
            return Arrays.equals(this.f52109b, dVar.f52109b);
        }
        return false;
    }

    public int hashCode() {
        return ((this.f52108a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f52109b);
    }

    public String toString() {
        return "EncodedPayload{encoding=" + ((Object) this.f52108a) + ", bytes=[...]}";
    }
}

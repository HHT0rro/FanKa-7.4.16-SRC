package o4;

import androidx.annotation.Nullable;
import com.google.android.datatransport.runtime.EventInternal;
import java.util.Arrays;
import java.util.Objects;
import o4.e;

/* compiled from: AutoValue_BackendRequest.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class a extends e {

    /* renamed from: a, reason: collision with root package name */
    public final Iterable<EventInternal> f52266a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f52267b;

    /* compiled from: AutoValue_BackendRequest.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b extends e.a {

        /* renamed from: a, reason: collision with root package name */
        public Iterable<EventInternal> f52268a;

        /* renamed from: b, reason: collision with root package name */
        public byte[] f52269b;

        @Override // o4.e.a
        public e a() {
            String str = "";
            if (this.f52268a == null) {
                str = " events";
            }
            if (str.isEmpty()) {
                return new a(this.f52268a, this.f52269b);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // o4.e.a
        public e.a b(Iterable<EventInternal> iterable) {
            Objects.requireNonNull(iterable, "Null events");
            this.f52268a = iterable;
            return this;
        }

        @Override // o4.e.a
        public e.a c(@Nullable byte[] bArr) {
            this.f52269b = bArr;
            return this;
        }
    }

    @Override // o4.e
    public Iterable<EventInternal> b() {
        return this.f52266a;
    }

    @Override // o4.e
    @Nullable
    public byte[] c() {
        return this.f52267b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        if (this.f52266a.equals(eVar.b())) {
            if (Arrays.equals(this.f52267b, eVar instanceof a ? ((a) eVar).f52267b : eVar.c())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((this.f52266a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f52267b);
    }

    public String toString() {
        return "BackendRequest{events=" + ((Object) this.f52266a) + ", extras=" + Arrays.toString(this.f52267b) + com.alipay.sdk.util.i.f4738d;
    }

    public a(Iterable<EventInternal> iterable, @Nullable byte[] bArr) {
        this.f52266a = iterable;
        this.f52267b = bArr;
    }
}

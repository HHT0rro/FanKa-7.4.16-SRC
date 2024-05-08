package n4;

import com.google.android.datatransport.Event;
import com.google.android.datatransport.runtime.TransportContext;
import java.util.Objects;
import n4.h;

/* compiled from: AutoValue_SendRequest.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class a extends h {

    /* renamed from: a, reason: collision with root package name */
    public final TransportContext f52098a;

    /* renamed from: b, reason: collision with root package name */
    public final String f52099b;

    /* renamed from: c, reason: collision with root package name */
    public final Event<?> f52100c;

    /* renamed from: d, reason: collision with root package name */
    public final com.google.android.datatransport.b<?, byte[]> f52101d;

    /* renamed from: e, reason: collision with root package name */
    public final com.google.android.datatransport.a f52102e;

    /* compiled from: AutoValue_SendRequest.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b extends h.a {

        /* renamed from: a, reason: collision with root package name */
        public TransportContext f52103a;

        /* renamed from: b, reason: collision with root package name */
        public String f52104b;

        /* renamed from: c, reason: collision with root package name */
        public Event<?> f52105c;

        /* renamed from: d, reason: collision with root package name */
        public com.google.android.datatransport.b<?, byte[]> f52106d;

        /* renamed from: e, reason: collision with root package name */
        public com.google.android.datatransport.a f52107e;

        @Override // n4.h.a
        public h a() {
            String str = "";
            if (this.f52103a == null) {
                str = " transportContext";
            }
            if (this.f52104b == null) {
                str = str + " transportName";
            }
            if (this.f52105c == null) {
                str = str + " event";
            }
            if (this.f52106d == null) {
                str = str + " transformer";
            }
            if (this.f52107e == null) {
                str = str + " encoding";
            }
            if (str.isEmpty()) {
                return new a(this.f52103a, this.f52104b, this.f52105c, this.f52106d, this.f52107e);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // n4.h.a
        public h.a b(com.google.android.datatransport.a aVar) {
            Objects.requireNonNull(aVar, "Null encoding");
            this.f52107e = aVar;
            return this;
        }

        @Override // n4.h.a
        public h.a c(Event<?> event) {
            Objects.requireNonNull(event, "Null event");
            this.f52105c = event;
            return this;
        }

        @Override // n4.h.a
        public h.a d(com.google.android.datatransport.b<?, byte[]> bVar) {
            Objects.requireNonNull(bVar, "Null transformer");
            this.f52106d = bVar;
            return this;
        }

        @Override // n4.h.a
        public h.a e(TransportContext transportContext) {
            Objects.requireNonNull(transportContext, "Null transportContext");
            this.f52103a = transportContext;
            return this;
        }

        @Override // n4.h.a
        public h.a f(String str) {
            Objects.requireNonNull(str, "Null transportName");
            this.f52104b = str;
            return this;
        }
    }

    @Override // n4.h
    public com.google.android.datatransport.a b() {
        return this.f52102e;
    }

    @Override // n4.h
    public Event<?> c() {
        return this.f52100c;
    }

    @Override // n4.h
    public com.google.android.datatransport.b<?, byte[]> e() {
        return this.f52101d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return this.f52098a.equals(hVar.f()) && this.f52099b.equals(hVar.g()) && this.f52100c.equals(hVar.c()) && this.f52101d.equals(hVar.e()) && this.f52102e.equals(hVar.b());
    }

    @Override // n4.h
    public TransportContext f() {
        return this.f52098a;
    }

    @Override // n4.h
    public String g() {
        return this.f52099b;
    }

    public int hashCode() {
        return ((((((((this.f52098a.hashCode() ^ 1000003) * 1000003) ^ this.f52099b.hashCode()) * 1000003) ^ this.f52100c.hashCode()) * 1000003) ^ this.f52101d.hashCode()) * 1000003) ^ this.f52102e.hashCode();
    }

    public String toString() {
        return "SendRequest{transportContext=" + ((Object) this.f52098a) + ", transportName=" + this.f52099b + ", event=" + ((Object) this.f52100c) + ", transformer=" + ((Object) this.f52101d) + ", encoding=" + ((Object) this.f52102e) + com.alipay.sdk.util.i.f4738d;
    }

    public a(TransportContext transportContext, String str, Event<?> event, com.google.android.datatransport.b<?, byte[]> bVar, com.google.android.datatransport.a aVar) {
        this.f52098a = transportContext;
        this.f52099b = str;
        this.f52100c = event;
        this.f52101d = bVar;
        this.f52102e = aVar;
    }
}

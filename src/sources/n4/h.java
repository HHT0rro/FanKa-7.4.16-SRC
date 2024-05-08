package n4;

import com.google.android.datatransport.Event;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.auto.value.AutoValue;
import n4.a;

/* compiled from: SendRequest.java */
@AutoValue
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public abstract class h {

    /* compiled from: SendRequest.java */
    @AutoValue.Builder
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static abstract class a {
        public abstract h a();

        public abstract a b(com.google.android.datatransport.a aVar);

        public abstract a c(Event<?> event);

        public abstract a d(com.google.android.datatransport.b<?, byte[]> bVar);

        public abstract a e(TransportContext transportContext);

        public abstract a f(String str);
    }

    public static a a() {
        return new a.b();
    }

    public abstract com.google.android.datatransport.a b();

    public abstract Event<?> c();

    public byte[] d() {
        return e().apply(c().getPayload());
    }

    public abstract com.google.android.datatransport.b<?, byte[]> e();

    public abstract TransportContext f();

    public abstract String g();
}

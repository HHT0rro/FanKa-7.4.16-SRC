package n4;

import com.google.android.datatransport.runtime.TransportContext;
import java.util.Set;

/* compiled from: TransportFactoryImpl.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class i implements com.google.android.datatransport.d {

    /* renamed from: a, reason: collision with root package name */
    public final Set<com.google.android.datatransport.a> f52113a;

    /* renamed from: b, reason: collision with root package name */
    public final TransportContext f52114b;

    /* renamed from: c, reason: collision with root package name */
    public final l f52115c;

    public i(Set<com.google.android.datatransport.a> set, TransportContext transportContext, l lVar) {
        this.f52113a = set;
        this.f52114b = transportContext;
        this.f52115c = lVar;
    }

    @Override // com.google.android.datatransport.d
    public <T> com.google.android.datatransport.c<T> a(String str, Class<T> cls, com.google.android.datatransport.a aVar, com.google.android.datatransport.b<T, byte[]> bVar) {
        if (this.f52113a.contains(aVar)) {
            return new k(this.f52114b, str, aVar, bVar, this.f52115c);
        }
        throw new IllegalArgumentException(String.format("%s is not supported byt this factory. Supported encodings are: %s.", aVar, this.f52113a));
    }
}

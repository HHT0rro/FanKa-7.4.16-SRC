package s4;

import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.backends.BackendResponse;
import t4.a;

/* compiled from: Uploader.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final /* synthetic */ class f implements a.InterfaceC0823a {

    /* renamed from: a, reason: collision with root package name */
    public final i f53589a;

    /* renamed from: b, reason: collision with root package name */
    public final BackendResponse f53590b;

    /* renamed from: c, reason: collision with root package name */
    public final Iterable f53591c;

    /* renamed from: d, reason: collision with root package name */
    public final TransportContext f53592d;

    /* renamed from: e, reason: collision with root package name */
    public final int f53593e;

    public f(i iVar, BackendResponse backendResponse, Iterable iterable, TransportContext transportContext, int i10) {
        this.f53589a = iVar;
        this.f53590b = backendResponse;
        this.f53591c = iterable;
        this.f53592d = transportContext;
        this.f53593e = i10;
    }

    public static a.InterfaceC0823a a(i iVar, BackendResponse backendResponse, Iterable iterable, TransportContext transportContext, int i10) {
        return new f(iVar, backendResponse, iterable, transportContext, i10);
    }

    @Override // t4.a.InterfaceC0823a
    public Object execute() {
        return i.c(this.f53589a, this.f53590b, this.f53591c, this.f53592d, this.f53593e);
    }
}

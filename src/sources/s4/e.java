package s4;

import com.google.android.datatransport.runtime.TransportContext;
import t4.a;

/* compiled from: Uploader.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final /* synthetic */ class e implements a.InterfaceC0823a {

    /* renamed from: a, reason: collision with root package name */
    public final i f53587a;

    /* renamed from: b, reason: collision with root package name */
    public final TransportContext f53588b;

    public e(i iVar, TransportContext transportContext) {
        this.f53587a = iVar;
        this.f53588b = transportContext;
    }

    public static a.InterfaceC0823a a(i iVar, TransportContext transportContext) {
        return new e(iVar, transportContext);
    }

    @Override // t4.a.InterfaceC0823a
    public Object execute() {
        Iterable t2;
        t2 = this.f53587a.f53600c.t(this.f53588b);
        return t2;
    }
}

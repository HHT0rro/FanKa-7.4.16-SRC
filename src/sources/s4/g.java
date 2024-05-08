package s4;

import t4.a;

/* compiled from: Uploader.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final /* synthetic */ class g implements a.InterfaceC0823a {

    /* renamed from: a, reason: collision with root package name */
    public final com.google.android.datatransport.runtime.scheduling.persistence.b f53594a;

    public g(com.google.android.datatransport.runtime.scheduling.persistence.b bVar) {
        this.f53594a = bVar;
    }

    public static a.InterfaceC0823a a(com.google.android.datatransport.runtime.scheduling.persistence.b bVar) {
        return new g(bVar);
    }

    @Override // t4.a.InterfaceC0823a
    public Object execute() {
        return Integer.valueOf(this.f53594a.cleanUp());
    }
}

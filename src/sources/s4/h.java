package s4;

import com.google.android.datatransport.runtime.TransportContext;
import t4.a;

/* compiled from: Uploader.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final /* synthetic */ class h implements a.InterfaceC0823a {

    /* renamed from: a, reason: collision with root package name */
    public final i f53595a;

    /* renamed from: b, reason: collision with root package name */
    public final TransportContext f53596b;

    /* renamed from: c, reason: collision with root package name */
    public final int f53597c;

    public h(i iVar, TransportContext transportContext, int i10) {
        this.f53595a = iVar;
        this.f53596b = transportContext;
        this.f53597c = i10;
    }

    public static a.InterfaceC0823a a(i iVar, TransportContext transportContext, int i10) {
        return new h(iVar, transportContext, i10);
    }

    @Override // t4.a.InterfaceC0823a
    public Object execute() {
        return i.d(this.f53595a, this.f53596b, this.f53597c);
    }
}

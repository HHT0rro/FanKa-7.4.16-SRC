package s4;

import com.google.android.datatransport.runtime.TransportContext;

/* compiled from: Uploader.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final /* synthetic */ class d implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final i f53583b;

    /* renamed from: c, reason: collision with root package name */
    public final TransportContext f53584c;

    /* renamed from: d, reason: collision with root package name */
    public final int f53585d;

    /* renamed from: e, reason: collision with root package name */
    public final Runnable f53586e;

    public d(i iVar, TransportContext transportContext, int i10, Runnable runnable) {
        this.f53583b = iVar;
        this.f53584c = transportContext;
        this.f53585d = i10;
        this.f53586e = runnable;
    }

    public static Runnable a(i iVar, TransportContext transportContext, int i10, Runnable runnable) {
        return new d(iVar, transportContext, i10, runnable);
    }

    @Override // java.lang.Runnable
    public void run() {
        i.e(this.f53583b, this.f53584c, this.f53585d, this.f53586e);
    }
}

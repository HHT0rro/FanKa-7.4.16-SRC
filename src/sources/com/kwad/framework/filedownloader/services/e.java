package com.kwad.framework.filedownloader.services;

import android.app.Notification;
import android.os.IBinder;
import com.kwad.framework.filedownloader.c.b;
import com.kwad.framework.filedownloader.n;
import java.lang.ref.WeakReference;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class e extends b.a implements i {
    private final g ahY;
    private final WeakReference<FileDownloadServiceProxy> ahZ;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface a {
        void a(e eVar);

        void onDisconnected();
    }

    public e(WeakReference<FileDownloadServiceProxy> weakReference, g gVar) {
        this.ahZ = weakReference;
        this.ahY = gVar;
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final void a(com.kwad.framework.filedownloader.c.a aVar) {
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final void b(com.kwad.framework.filedownloader.c.a aVar) {
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final void b(String str, String str2, boolean z10, int i10, int i11, int i12, boolean z11, com.kwad.framework.filedownloader.d.b bVar, boolean z12) {
        this.ahY.b(str, str2, z10, i10, i11, i12, z11, bVar, z12);
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final boolean bd(int i10) {
        return this.ahY.bd(i10);
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final byte be(int i10) {
        return this.ahY.be(i10);
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final boolean bf(int i10) {
        return this.ahY.bf(i10);
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final boolean bx(int i10) {
        return this.ahY.bx(i10);
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final long by(int i10) {
        return this.ahY.bJ(i10);
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final long bz(int i10) {
        return this.ahY.bz(i10);
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final boolean isIdle() {
        return this.ahY.isIdle();
    }

    @Override // com.kwad.framework.filedownloader.services.i
    public final void onDestroy() {
        n.uN().onDisconnected();
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final void pauseAllTasks() {
        this.ahY.wE();
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final void startForeground(int i10, Notification notification) {
        WeakReference<FileDownloadServiceProxy> weakReference = this.ahZ;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.ahZ.get().context.startForeground(i10, notification);
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final void stopForeground(boolean z10) {
        WeakReference<FileDownloadServiceProxy> weakReference = this.ahZ;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.ahZ.get().context.stopForeground(z10);
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final boolean u(String str, String str2) {
        return this.ahY.y(str, str2);
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final void vV() {
        this.ahY.vV();
    }

    @Override // com.kwad.framework.filedownloader.services.i
    public final void wB() {
        n.uN().a(this);
    }

    @Override // com.kwad.framework.filedownloader.services.i
    public final IBinder wC() {
        return null;
    }
}

package com.kwad.components.core.g;

import android.os.Handler;
import androidx.annotation.Nullable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class a implements Runnable {
    private long LA = 1000;
    private boolean LB = true;
    private long LC = 0;
    private InterfaceC0462a LD;

    @Nullable
    private volatile Handler fS;

    /* renamed from: com.kwad.components.core.g.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface InterfaceC0462a {
        void y(long j10);
    }

    public a(Handler handler) {
        this.fS = handler;
    }

    public final void a(InterfaceC0462a interfaceC0462a) {
        this.LD = interfaceC0462a;
    }

    public final void destroy() {
        stop();
        this.fS = null;
    }

    public final void pause() {
        this.LB = true;
    }

    public final void resume() {
        this.LB = false;
    }

    @Override // java.lang.Runnable
    public final synchronized void run() {
        InterfaceC0462a interfaceC0462a;
        if (this.fS != null) {
            if (!this.LB && (interfaceC0462a = this.LD) != null) {
                interfaceC0462a.y(this.LC);
                this.LC += this.LA;
            }
            if (this.fS != null) {
                this.fS.postDelayed(this, this.LA);
            }
        }
    }

    public final void start() {
        this.LB = false;
        if (this.fS != null) {
            this.fS.post(this);
        }
    }

    public final void stop() {
        if (this.fS != null) {
            this.fS.removeCallbacks(this);
        }
    }
}

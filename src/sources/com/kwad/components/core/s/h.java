package com.kwad.components.core.s;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class h {
    private long Bm;
    private a Te;
    private long Tc = 100;
    private long Td = 0;
    private boolean LB = false;

    @Nullable
    private Handler Tf = new Handler(Looper.getMainLooper());
    private Runnable Tg = new Runnable() { // from class: com.kwad.components.core.s.h.1
        @Override // java.lang.Runnable
        public final void run() {
            if (h.this.Tf == null) {
                return;
            }
            if (h.this.LB) {
                h.this.Tf.postDelayed(this, h.this.Tc / 2);
                return;
            }
            h.this.rd();
            if (h.this.Tf != null) {
                h.this.Tf.postDelayed(this, h.this.Tc);
            }
        }
    };

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface a {
        void onProgress(long j10, long j11);
    }

    public h(long j10) {
        this.Bm = j10;
    }

    public final void pause() {
        this.LB = true;
    }

    public final void rd() {
        a aVar = this.Te;
        if (aVar != null) {
            long j10 = this.Bm;
            long j11 = j10 - this.Td;
            aVar.onProgress(j11, j10);
            if (j11 <= 0) {
                stop();
            }
        }
        this.Td += this.Tc;
    }

    public final void resume() {
        this.LB = false;
    }

    public final void start() {
        Handler handler = this.Tf;
        if (handler == null) {
            return;
        }
        handler.post(this.Tg);
    }

    public final void stop() {
        Handler handler = this.Tf;
        if (handler != null) {
            handler.removeCallbacks(this.Tg);
            this.Tf = null;
        }
    }

    public final void a(a aVar) {
        this.Te = aVar;
    }
}

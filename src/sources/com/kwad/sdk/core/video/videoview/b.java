package com.kwad.sdk.core.video.videoview;

import android.content.Context;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public abstract class b extends RelativeLayout {
    private Runnable TR;

    @NonNull
    public final c aBE;

    public b(Context context, @NonNull c cVar) {
        super(context);
        this.aBE = cVar;
    }

    public void n(int i10, int i11) {
    }

    public abstract void onPlayStateChanged(int i10);

    public abstract void reset();

    public abstract void rq();

    public final void rw() {
        rx();
        if (this.TR == null) {
            this.TR = new Runnable() { // from class: com.kwad.sdk.core.video.videoview.b.1
                @Override // java.lang.Runnable
                public final void run() {
                    b.this.rq();
                    if (b.this.TR != null) {
                        b bVar = b.this;
                        bVar.postDelayed(bVar.TR, 1000L);
                    }
                }
            };
        }
        post(this.TR);
    }

    public final void rx() {
        Runnable runnable = this.TR;
        if (runnable != null) {
            removeCallbacks(runnable);
            this.TR = null;
        }
    }
}

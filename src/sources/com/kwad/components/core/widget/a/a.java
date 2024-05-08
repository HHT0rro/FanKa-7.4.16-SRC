package com.kwad.components.core.widget.a;

import android.os.Message;
import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.h.c;
import com.kwad.sdk.utils.ah;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.bn;
import com.kwad.sdk.utils.br;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public abstract class a implements com.kwad.sdk.core.h.a, br.a {
    private Set<c> acv;
    private final int acw;
    private final View mRootView;
    private final AtomicBoolean acu = new AtomicBoolean(false);
    public final br hh = new br(this);

    public a(@NonNull View view, int i10) {
        this.mRootView = view;
        this.acw = i10;
    }

    private void aZ(boolean z10) {
        Set<c> set = this.acv;
        if (set == null) {
            return;
        }
        for (c cVar : set) {
            if (cVar != null) {
                if (z10) {
                    cVar.aM();
                } else {
                    cVar.aN();
                }
            }
        }
    }

    private void iY() {
        if (this.acu.getAndSet(true)) {
            return;
        }
        aZ(true);
    }

    private void tv() {
        if (dW()) {
            iY();
        } else {
            ty();
        }
    }

    private void ty() {
        if (this.acu.getAndSet(false)) {
            aZ(false);
        }
    }

    @Override // com.kwad.sdk.utils.br.a
    public final void a(Message message) {
        if (message.what == 666) {
            tv();
            this.hh.sendEmptyMessageDelayed(666, 500L);
        }
    }

    @Override // com.kwad.sdk.core.h.a
    @MainThread
    public final void b(c cVar) {
        Set<c> set;
        ah.checkUiThread();
        if (cVar == null || (set = this.acv) == null) {
            return;
        }
        set.remove(cVar);
    }

    public abstract boolean dW();

    @Override // com.kwad.sdk.core.h.a
    @CallSuper
    public final void release() {
        tx();
        Set<c> set = this.acv;
        if (set != null) {
            set.clear();
        }
    }

    public final void tw() {
        this.hh.removeMessages(666);
        this.hh.sendEmptyMessage(666);
    }

    public final void tx() {
        tv();
        this.hh.removeCallbacksAndMessages(null);
    }

    @Override // com.kwad.sdk.core.h.a
    @MainThread
    public final boolean tz() {
        return this.acu.get();
    }

    @Override // com.kwad.sdk.core.h.a
    @MainThread
    public final void a(final c cVar) {
        ah.checkUiThread();
        if (cVar == null) {
            return;
        }
        bn.postOnUiThread(new ay() { // from class: com.kwad.components.core.widget.a.a.1
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                if (a.this.dW()) {
                    cVar.aM();
                } else {
                    cVar.aN();
                }
            }
        });
        if (this.acv == null) {
            this.acv = new HashSet();
        }
        this.acv.add(cVar);
    }
}

package com.kwad.components.core.widget;

import android.content.Context;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import com.kwad.sdk.utils.bq;
import com.kwad.sdk.utils.br;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class c extends View implements br.a {
    private View UI;
    private final AtomicBoolean UJ;
    private final int abA;
    private boolean abe;
    private boolean abf;
    private a aby;
    private boolean abz;
    private final br hh;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface a {
        void eq();
    }

    public c(Context context, View view) {
        super(context);
        this.hh = new br(this);
        this.UJ = new AtomicBoolean(true);
        this.abA = (int) (com.kwad.sdk.core.config.d.Cl() * 100.0f);
        this.UI = view;
        setLayoutParams(new ViewGroup.LayoutParams(0, 0));
    }

    private void tg() {
        if (this.abf) {
            this.hh.removeCallbacksAndMessages(null);
            this.abf = false;
        }
    }

    private void th() {
        if (!this.abz || this.abf) {
            return;
        }
        this.abf = true;
        this.hh.sendEmptyMessage(1);
    }

    private void tl() {
        this.UJ.getAndSet(false);
    }

    private void tm() {
        this.UJ.getAndSet(true);
    }

    @Override // com.kwad.sdk.utils.br.a
    public final void a(Message message) {
        a aVar;
        int i10 = message.what;
        if (i10 != 1) {
            if (i10 != 2) {
                return;
            }
            if (!bq.a(this.UI, this.abA, false)) {
                if (this.abe) {
                    return;
                }
                setNeedCheckingShow(true);
                return;
            } else {
                if (message.arg1 == 1000 && (aVar = this.aby) != null) {
                    aVar.eq();
                }
                this.hh.sendEmptyMessageDelayed(2, 500L);
                return;
            }
        }
        com.kwad.sdk.core.e.c.d("EmptyView", "handleMsg MSG_CHECKING");
        if (this.abf) {
            if (bq.a(this.UI, this.abA, false)) {
                tg();
                Message obtainMessage = this.hh.obtainMessage();
                obtainMessage.what = 2;
                obtainMessage.arg1 = 1000;
                this.hh.sendMessageDelayed(obtainMessage, 1000L);
                return;
            }
            this.hh.sendEmptyMessageDelayed(1, 500L);
        }
    }

    @Override // android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.kwad.sdk.core.e.c.d("EmptyView", "onAttachedToWindow:" + ((Object) this));
        th();
        this.abe = false;
        tl();
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.kwad.sdk.core.e.c.d("EmptyView", "onDetachedFromWindow" + ((Object) this));
        tg();
        this.abe = true;
        tm();
    }

    @Override // android.view.View
    public final void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        com.kwad.sdk.core.e.c.d("EmptyView", "onFinishTemporaryDetach:" + ((Object) this.UI.getParent()));
        tl();
    }

    @Override // android.view.View
    public final void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        com.kwad.sdk.core.e.c.d("EmptyView", "onStartTemporaryDetach:" + ((Object) this.UI.getParent()));
        tm();
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z10) {
        super.onWindowFocusChanged(z10);
        com.kwad.sdk.core.e.c.d("EmptyView", "onWindowFocusChanged hasWindowFocus:" + z10);
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int i10) {
        super.onWindowVisibilityChanged(i10);
        com.kwad.sdk.core.e.c.d("EmptyView", "onWindowVisibilityChanged visibility:" + i10);
    }

    public final void setNeedCheckingShow(boolean z10) {
        this.abz = z10;
        if (!z10 && this.abf) {
            tg();
        } else {
            if (!z10 || this.abf) {
                return;
            }
            th();
        }
    }

    public final void setViewCallback(a aVar) {
        this.aby = aVar;
    }
}

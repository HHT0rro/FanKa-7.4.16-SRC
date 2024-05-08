package com.kwad.components.core.widget;

import android.content.Context;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import com.kwad.sdk.utils.bq;
import com.kwad.sdk.utils.br;
import com.kwad.sdk.widget.KSFrameLayout;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class a extends KSFrameLayout implements br.a {
    private final View UI;
    private InterfaceC0490a abd;
    private boolean abe;
    private boolean abf;
    private int abg;
    private boolean abh;
    private long abi;
    private boolean abj;
    private final float abk;
    private final int abl;
    private final br hh;

    /* renamed from: com.kwad.components.core.widget.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface InterfaceC0490a {
        void ac();

        void ad();

        void ep();

        void k(View view);
    }

    public a(Context context, View view) {
        super(context, view);
        this.hh = new br(this);
        this.abg = 5;
        this.UI = view;
        setLayoutParams(new ViewGroup.LayoutParams(1, 1));
        float Cl = com.kwad.sdk.core.config.d.Cl();
        this.abk = Cl;
        setVisiblePercent(Cl);
        float Cm = com.kwad.sdk.core.config.d.Cm();
        this.abl = (int) ((Cm < 0.0f ? 1.0f : Cm) * 1000.0f);
    }

    private void tf() {
        InterfaceC0490a interfaceC0490a;
        if (this.abl == 0 && (interfaceC0490a = this.abd) != null) {
            interfaceC0490a.k(this.UI);
            return;
        }
        Message obtainMessage = this.hh.obtainMessage();
        obtainMessage.what = 2;
        this.hh.sendMessageDelayed(obtainMessage, this.abl);
    }

    private void tg() {
        this.hh.removeCallbacksAndMessages(null);
        this.abf = false;
    }

    private void th() {
        if (this.abf) {
            return;
        }
        this.abf = true;
        this.hh.sendEmptyMessage(1);
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout, com.kwad.sdk.widget.i
    public final void A(View view) {
        InterfaceC0490a interfaceC0490a;
        InterfaceC0490a interfaceC0490a2;
        super.A(view);
        if (this.abl == 0 && (interfaceC0490a2 = this.abd) != null) {
            interfaceC0490a2.k(view);
            return;
        }
        if (!this.abh) {
            this.abh = true;
            this.abi = System.currentTimeMillis();
            tg();
            tf();
            return;
        }
        if (System.currentTimeMillis() - this.abi <= this.abl || (interfaceC0490a = this.abd) == null) {
            return;
        }
        interfaceC0490a.k(view);
        tg();
    }

    @Override // com.kwad.sdk.utils.br.a
    public final void a(Message message) {
        if (this.abe) {
            return;
        }
        int i10 = message.what;
        if (i10 != 1) {
            if (i10 != 2) {
                return;
            }
            if (bq.a(this.UI, (int) (this.abk * 100.0f), false)) {
                InterfaceC0490a interfaceC0490a = this.abd;
                if (interfaceC0490a != null) {
                    interfaceC0490a.k(this.UI);
                    return;
                }
                return;
            }
            this.abg = 5;
            this.hh.sendEmptyMessage(1);
            return;
        }
        if (bq.a(this.UI, (int) (this.abk * 100.0f), false)) {
            tg();
            if (this.abh) {
                InterfaceC0490a interfaceC0490a2 = this.abd;
                if (interfaceC0490a2 != null) {
                    interfaceC0490a2.k(this.UI);
                }
            } else {
                this.abh = true;
                this.abi = System.currentTimeMillis();
                tf();
            }
            this.abj = false;
            br brVar = this.hh;
            int i11 = this.abg;
            this.abg = i11 - 1;
            brVar.sendEmptyMessageDelayed(1, i11 <= 0 ? 500L : 100L);
            return;
        }
        InterfaceC0490a interfaceC0490a3 = this.abd;
        if (interfaceC0490a3 != null && !this.abj) {
            interfaceC0490a3.ep();
        }
        this.abj = true;
        br brVar2 = this.hh;
        int i12 = this.abg;
        this.abg = i12 - 1;
        brVar2.sendEmptyMessageDelayed(1, i12 <= 0 ? 500L : 100L);
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void ac() {
        super.ac();
        this.abg = 5;
        this.abe = false;
        this.abh = false;
        th();
        InterfaceC0490a interfaceC0490a = this.abd;
        if (interfaceC0490a != null) {
            interfaceC0490a.ac();
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void ad() {
        super.ad();
        tg();
        this.abg = 0;
        this.abi = 0L;
        this.abe = true;
        InterfaceC0490a interfaceC0490a = this.abd;
        if (interfaceC0490a != null) {
            interfaceC0490a.ad();
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout, android.view.View
    public final void onWindowFocusChanged(boolean z10) {
        super.onWindowFocusChanged(z10);
        com.kwad.sdk.core.e.c.d("AdExposureView", "onWindowFocusChanged hasWindowFocus:" + z10);
    }

    public final void setViewCallback(InterfaceC0490a interfaceC0490a) {
        this.abd = interfaceC0490a;
    }

    public final void ti() {
        th();
    }
}

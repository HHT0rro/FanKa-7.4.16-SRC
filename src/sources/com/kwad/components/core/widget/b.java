package com.kwad.components.core.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.widget.a;
import com.kwad.components.core.widget.c;
import com.kwad.components.model.FeedType;
import com.kwad.sdk.core.adlog.a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.n.l;
import com.kwad.sdk.utils.bm;
import com.kwad.sdk.widget.KSFrameLayout;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public abstract class b<T extends AdResultData, R extends AdTemplate> extends KSFrameLayout implements DialogInterface.OnDismissListener, DialogInterface.OnShowListener, com.kwad.sdk.core.h.c {
    public a abm;
    private long abn;
    private com.kwad.components.core.widget.a.b bQ;
    private com.kwad.sdk.core.h.b bT;
    public AdInfo mAdInfo;

    @NonNull
    public T mAdResultData;

    @NonNull
    public R mAdTemplate;

    @NonNull
    public Context mContext;
    private bm mTimerHelper;
    public boolean ms;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface a {
        void onAdClicked();

        void onAdShow();

        void onDislikeClicked();

        void onDownloadTipsDialogDismiss();

        void onDownloadTipsDialogShow();
    }

    public b(@NonNull Context context) {
        this(context, null);
    }

    public static void c(ViewGroup viewGroup) {
        for (int i10 = 0; i10 < viewGroup.getChildCount(); i10++) {
            View childAt = viewGroup.getChildAt(i10);
            if (childAt instanceof com.kwad.components.core.widget.a) {
                viewGroup.removeView(childAt);
            }
        }
    }

    private void initView() {
        l.inflate(this.mContext, getLayoutId(), this);
        setRatio(getHWRatio());
        bc();
        this.bQ = new com.kwad.components.core.widget.a.b(this, 70);
    }

    public final void aL(int i10) {
        com.kwad.sdk.core.adlog.c.a(this.mAdTemplate, i10, getTouchCoords());
        a aVar = this.abm;
        if (aVar != null) {
            aVar.onAdClicked();
        }
    }

    public void aM() {
    }

    public void aN() {
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public void ac() {
        super.ac();
        this.bQ.a(this);
        this.bQ.a(this.bT);
        this.bQ.tw();
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public void ad() {
        super.ad();
        this.bQ.tx();
        this.bQ.b(this);
        bf();
    }

    public void b(@NonNull T t2) {
        this.mAdResultData = t2;
        R r10 = (R) com.kwad.sdk.core.response.b.c.n(t2);
        this.mAdTemplate = r10;
        this.mAdInfo = com.kwad.sdk.core.response.b.e.dQ(r10);
        a((ViewGroup) this);
    }

    public abstract void bc();

    public void bf() {
    }

    public void bv() {
        a aVar;
        if (!this.mAdTemplate.mPvReported && (aVar = this.abm) != null) {
            aVar.onAdShow();
        }
        com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
        a.C0516a c0516a = new a.C0516a();
        FeedType fromInt = FeedType.fromInt(this.mAdTemplate.type);
        if (fromInt == FeedType.FEED_TYPE_TEXT_NEW) {
            fromInt = FeedType.FEED_TYPE_TEXT_BELOW;
        }
        c0516a.templateId = String.valueOf(fromInt.getType());
        bVar.b(c0516a);
        bVar.v(getHeight(), getWidth());
        com.kwad.components.core.s.b.qY().a(this.mAdTemplate, null, bVar);
    }

    public float getHWRatio() {
        return 0.0f;
    }

    public abstract int getLayoutId();

    public long getStayTime() {
        return this.abn + getTimerHelper().getTime();
    }

    public bm getTimerHelper() {
        if (this.mTimerHelper == null) {
            this.mTimerHelper = new bm();
        }
        return this.mTimerHelper;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        a aVar = this.abm;
        if (aVar != null) {
            aVar.onDownloadTipsDialogDismiss();
        }
    }

    @Override // android.content.DialogInterface.OnShowListener
    public void onShow(DialogInterface dialogInterface) {
        a aVar = this.abm;
        if (aVar != null) {
            aVar.onDownloadTipsDialogShow();
        }
    }

    public void setInnerAdInteractionListener(a aVar) {
        this.abm = aVar;
    }

    public void setMargin(int i10) {
        setPadding(i10, i10, i10, i10);
        setBackgroundColor(-1);
    }

    public void setPageExitListener(com.kwad.sdk.core.h.b bVar) {
        this.bT = bVar;
    }

    public final void tj() {
        a aVar = this.abm;
        if (aVar != null) {
            aVar.onAdClicked();
        }
    }

    public final void tk() {
        com.kwad.sdk.core.adlog.c.bE(this.mAdTemplate);
        a aVar = this.abm;
        if (aVar != null) {
            aVar.onDislikeClicked();
        }
    }

    public b(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public b(@NonNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.mContext = context;
        initView();
    }

    private void a(ViewGroup viewGroup) {
        if (!com.kwad.sdk.core.config.d.Cn() && com.kwad.sdk.core.config.d.Cm() >= 0.0f) {
            c(viewGroup);
            com.kwad.components.core.widget.a aVar = new com.kwad.components.core.widget.a(viewGroup.getContext(), viewGroup);
            viewGroup.addView(aVar);
            aVar.setViewCallback(new a.InterfaceC0490a() { // from class: com.kwad.components.core.widget.b.1
                @Override // com.kwad.components.core.widget.a.InterfaceC0490a
                public final void ac() {
                }

                @Override // com.kwad.components.core.widget.a.InterfaceC0490a
                public final void ad() {
                    if (b.this.mAdTemplate.mPvReported) {
                        b bVar = b.this;
                        if (bVar.ms) {
                            long Nq = bVar.getTimerHelper().Nq();
                            b.this.abn += Nq;
                            com.kwad.sdk.core.adlog.c.a(b.this.mAdTemplate, Nq, (JSONObject) null);
                            b.this.ms = false;
                        }
                    }
                }

                @Override // com.kwad.components.core.widget.a.InterfaceC0490a
                public final void ep() {
                    if (b.this.mAdTemplate.mPvReported) {
                        b bVar = b.this;
                        if (bVar.ms) {
                            long Nq = bVar.getTimerHelper().Nq();
                            b.this.abn += Nq;
                            com.kwad.sdk.core.adlog.c.a(b.this.mAdTemplate, Nq, (JSONObject) null);
                            b.this.ms = false;
                        }
                    }
                }

                @Override // com.kwad.components.core.widget.a.InterfaceC0490a
                public final void k(View view) {
                    if (!b.this.mAdTemplate.mPvReported) {
                        b bVar = b.this;
                        if (bVar.abm != null) {
                            bVar.ms = true;
                            bVar.bv();
                            b.this.getTimerHelper().startTiming();
                        }
                    }
                    b bVar2 = b.this;
                    if (!bVar2.ms) {
                        bVar2.getTimerHelper().startTiming();
                    }
                    b.this.ms = true;
                }
            });
            aVar.ti();
            return;
        }
        c b4 = b(viewGroup);
        if (b4 == null) {
            b4 = new c(viewGroup.getContext(), viewGroup);
            viewGroup.addView(b4);
        }
        b4.setViewCallback(new c.a() { // from class: com.kwad.components.core.widget.b.2
            @Override // com.kwad.components.core.widget.c.a
            public final void eq() {
                b.this.bv();
            }
        });
        b4.setNeedCheckingShow(true);
    }

    private static c b(ViewGroup viewGroup) {
        for (int i10 = 0; i10 < viewGroup.getChildCount(); i10++) {
            View childAt = viewGroup.getChildAt(i10);
            if (childAt instanceof c) {
                return (c) childAt;
            }
        }
        return null;
    }

    public final void c(@NonNull com.kwad.sdk.core.adlog.c.b bVar) {
        bVar.f(getTouchCoords());
        com.kwad.sdk.core.adlog.c.a(this.mAdTemplate, bVar, (JSONObject) null);
        a aVar = this.abm;
        if (aVar != null) {
            aVar.onAdClicked();
        }
    }
}

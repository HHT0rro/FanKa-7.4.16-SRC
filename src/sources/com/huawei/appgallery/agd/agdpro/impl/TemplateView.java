package com.huawei.appgallery.agd.agdpro.impl;

import android.content.Context;
import android.util.DisplayMetrics;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.huawei.appgallery.agd.agdpro.api.InteractionListener;
import com.huawei.appgallery.agd.core.api.AdSlot;
import com.huawei.appgallery.agd.core.impl.report.MaintBi;
import e9.a;
import e9.e;
import e9.l;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class TemplateView extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    public int f27231b;

    /* renamed from: c, reason: collision with root package name */
    public int f27232c;

    /* renamed from: d, reason: collision with root package name */
    public l f27233d;

    public TemplateView(@NonNull Context context, AdSlot adSlot, l lVar) {
        super(context);
        this.f27231b = 0;
        this.f27232c = 0;
        int acceptedSizeWidth = adSlot.getAcceptedSizeWidth();
        int acceptedSizeHeight = adSlot.getAcceptedSizeHeight();
        this.f27231b = acceptedSizeWidth;
        this.f27232c = acceptedSizeHeight;
        int b4 = b(context, acceptedSizeWidth);
        int b10 = b(context, acceptedSizeHeight);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int i10 = displayMetrics.widthPixels;
        int i11 = displayMetrics.heightPixels;
        if (b4 > i10) {
            e.f48945d.i("TemplateView", "mWidth > screenWidth");
            this.f27231b = a(context, i10);
            b4 = -1;
        }
        if (b10 > i11) {
            e.f48945d.i("TemplateView", "mHeight > screenHeight");
            this.f27232c = a(context, i11);
            b10 = -1;
        }
        setLayoutParams(new FrameLayout.LayoutParams(b4, b10));
        this.f27233d = lVar;
    }

    public static int a(Context context, float f10) {
        return (int) ((f10 / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public final int b(Context context, int i10) {
        if (i10 <= 0) {
            return -1;
        }
        return (int) ((i10 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public float getTemplateViewHeight() {
        return this.f27232c;
    }

    public float getTemplateViewWidth() {
        return this.f27231b;
    }

    @Override // android.view.View
    public boolean isAttachedToWindow() {
        return super.isAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        e eVar = e.f48945d;
        a.d(a.b("onAttachedToWindow "), this.f27233d.f48971e, eVar, "TemplateView");
        this.f27233d.f48980n = System.currentTimeMillis();
        MaintBi.reportAdShow(0, 0L, this.f27233d.f48970d.getSlotId());
        super.onAttachedToWindow();
        InteractionListener interactionListener = this.f27233d.f48978l;
        if (interactionListener == null) {
            eVar.e("TemplateView", "interactionListener is null.");
        } else {
            interactionListener.onAdShow(this);
        }
    }
}

package com.cupidapp.live.liveshow.view.giftpicker.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.cupidapp.live.liveshow.model.GiftItemModel;
import com.cupidapp.live.liveshow.model.GiftRushType;
import com.google.android.material.badge.BadgeDrawable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;

/* compiled from: ContinuousSendGiftLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ContinuousSendGiftLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public String f15489b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f15490c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContinuousSendGiftLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f15490c = new LinkedHashMap();
        b();
    }

    public final void a() {
        View childAt = getChildAt(0);
        BaseContinuousSendButton baseContinuousSendButton = childAt instanceof BaseContinuousSendButton ? (BaseContinuousSendButton) childAt : null;
        if (baseContinuousSendButton != null) {
            baseContinuousSendButton.a();
            removeAllViews();
            setVisibility(8);
        }
    }

    public final void b() {
        setVisibility(8);
    }

    public final void c(@NotNull GiftItemModel gift, int i10, @Nullable String str, @NotNull c listener) {
        BaseContinuousSendButton fKLiveSendGiftContinuousClickButton;
        FrameLayout.LayoutParams layoutParams;
        BaseContinuousSendButton carGiftComboButton;
        int c4;
        s.i(gift, "gift");
        s.i(listener, "listener");
        if (!s.d(gift.getRushType(), this.f15489b)) {
            a();
        }
        int i11 = 0;
        setVisibility(0);
        View childAt = getChildAt(0);
        BaseContinuousSendButton baseContinuousSendButton = childAt instanceof BaseContinuousSendButton ? (BaseContinuousSendButton) childAt : null;
        if (baseContinuousSendButton == null) {
            String rushType = gift.getRushType();
            if (s.d(rushType, GiftRushType.Lucky.getType())) {
                Context context = getContext();
                s.h(context, "context");
                carGiftComboButton = new SendGiftCriticalButton(context);
                layoutParams = new FrameLayout.LayoutParams(-2, -2, BadgeDrawable.BOTTOM_END);
                c4 = z0.h.c(this, 50.0f);
            } else if (s.d(rushType, GiftRushType.Rocket.getType())) {
                Context context2 = getContext();
                s.h(context2, "context");
                carGiftComboButton = new RocketGiftComboButton(context2);
                layoutParams = new FrameLayout.LayoutParams(-2, -2, BadgeDrawable.BOTTOM_END);
                c4 = z0.h.c(this, 50.0f);
            } else if (s.d(rushType, GiftRushType.Car.getType())) {
                Context context3 = getContext();
                s.h(context3, "context");
                carGiftComboButton = new CarGiftComboButton(context3);
                layoutParams = new FrameLayout.LayoutParams(-2, -2, BadgeDrawable.BOTTOM_END);
                c4 = z0.h.c(this, 50.0f);
            } else {
                Context context4 = getContext();
                s.h(context4, "context");
                fKLiveSendGiftContinuousClickButton = new FKLiveSendGiftContinuousClickButton(context4);
                layoutParams = new FrameLayout.LayoutParams(-1, -2, 80);
                addView(fKLiveSendGiftContinuousClickButton, new FrameLayout.LayoutParams(layoutParams));
                baseContinuousSendButton = fKLiveSendGiftContinuousClickButton;
                y.m(baseContinuousSendButton, null, null, null, Integer.valueOf(i11), 7, null);
                fKLiveSendGiftContinuousClickButton.setContinuousSendListener(listener);
            }
            fKLiveSendGiftContinuousClickButton = carGiftComboButton;
            i11 = c4;
            addView(fKLiveSendGiftContinuousClickButton, new FrameLayout.LayoutParams(layoutParams));
            baseContinuousSendButton = fKLiveSendGiftContinuousClickButton;
            y.m(baseContinuousSendButton, null, null, null, Integer.valueOf(i11), 7, null);
            fKLiveSendGiftContinuousClickButton.setContinuousSendListener(listener);
        }
        this.f15489b = gift.getRushType();
        baseContinuousSendButton.b(gift, i10, str);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContinuousSendGiftLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f15490c = new LinkedHashMap();
        b();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContinuousSendGiftLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f15490c = new LinkedHashMap();
        b();
    }
}

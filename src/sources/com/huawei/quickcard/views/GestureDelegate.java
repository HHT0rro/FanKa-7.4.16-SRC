package com.huawei.quickcard.views;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.huawei.quickcard.CardContext;
import com.huawei.quickcard.base.Attributes;
import com.huawei.quickcard.base.annotation.DoNotShrink;
import com.huawei.quickcard.core.R;

@DoNotShrink
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class GestureDelegate {

    /* renamed from: a, reason: collision with root package name */
    private static final long f34511a = ViewConfiguration.getPressedStateDuration() + ViewConfiguration.getTapTimeout();

    private static boolean a(CardContext cardContext, View view, boolean z10) {
        if (cardContext == null) {
            return false;
        }
        return cardContext.onViewStateChanged(view, Attributes.Style.ACTIVE, z10, z10 ? f34511a : 0L);
    }

    public static boolean onTouchEvent(View view, MotionEvent motionEvent) {
        if (view == null || !view.isEnabled()) {
            return false;
        }
        Object tag = view.getTag(R.id.quick_card_context);
        if (!(tag instanceof CardContext)) {
            return false;
        }
        CardContext cardContext = (CardContext) tag;
        if (motionEvent.getAction() == 0) {
            return a(cardContext, view, true);
        }
        if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            return a(cardContext, view, false);
        }
        return false;
    }
}

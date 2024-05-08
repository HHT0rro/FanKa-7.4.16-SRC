package com.huawei.quickcard.action;

import android.content.Context;
import android.view.View;
import com.huawei.quickcard.CardContext;
import com.huawei.quickcard.base.annotation.DoNotShrink;
import com.huawei.quickcard.utils.AsyncFunctionUtils;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

@DoNotShrink
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public abstract class AbsQuickCardAction {
    public WeakReference<CardContext> cardContextRef;
    public Map<String, Object> nativeApiMap = new HashMap();
    public WeakReference<View> targetViewRef;

    public final void bindTargetContext(CardContext cardContext, View view) {
        this.cardContextRef = new WeakReference<>(cardContext);
        this.targetViewRef = new WeakReference<>(view);
    }

    public Context getAndroidContext() {
        WeakReference<CardContext> weakReference = this.cardContextRef;
        if (weakReference != null) {
            return AsyncFunctionUtils.getAndroidContext(weakReference.get());
        }
        return null;
    }

    public CardContext getCardContext() {
        WeakReference<CardContext> weakReference = this.cardContextRef;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public Map<String, Object> getNativeApi() {
        return this.nativeApiMap;
    }

    public boolean shouldTriggerListener() {
        return false;
    }
}

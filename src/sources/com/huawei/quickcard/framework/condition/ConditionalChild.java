package com.huawei.quickcard.framework.condition;

import android.view.ViewGroup;
import com.huawei.quickcard.CardContext;
import com.huawei.quickcard.base.annotation.DoNotShrink;
import com.huawei.quickcard.d2;
import com.huawei.quickcard.framework.bean.CardElement;
import com.huawei.quickcard.j0;
import com.huawei.quickcard.p0;
import com.huawei.quickcard.utils.ViewUtils;
import com.huawei.quickcard.watcher.Expression;
import com.huawei.quickcard.watcher.ForWatcher;
import com.huawei.quickcard.watcher.IWatcherManager;
import com.huawei.quickcard.watcher.Watcher;

@DoNotShrink
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class ConditionalChild {

    /* renamed from: a, reason: collision with root package name */
    private final j0 f33835a;

    /* renamed from: b, reason: collision with root package name */
    private final p0 f33836b;

    /* renamed from: c, reason: collision with root package name */
    private final CardElement f33837c;

    /* renamed from: d, reason: collision with root package name */
    private int f33838d;

    public ConditionalChild(j0 j0Var, p0 p0Var, CardElement cardElement, int i10) {
        this.f33835a = j0Var;
        this.f33836b = p0Var;
        this.f33837c = cardElement;
        this.f33838d = i10;
    }

    public static ConditionalChild createConditionalChild(ViewGroup viewGroup, int i10, String str, String str2, CardElement cardElement) {
        Watcher watcher;
        p0 p0Var;
        CardContext cardContext = ViewUtils.getCardContext(viewGroup);
        j0 j0Var = null;
        if (cardContext == null) {
            return null;
        }
        IWatcherManager watcherManager = cardContext.getWatcherManager();
        if (str2 != null) {
            watcher = watcherManager.watchIfCondition(cardElement.getRef(), Expression.create(str2), new d2(viewGroup));
            p0Var = new p0(str2, watcher);
        } else {
            watcher = null;
            p0Var = null;
        }
        if (str != null) {
            j0Var = new j0(str);
            ForWatcher watcherForCondition = watcherManager.watcherForCondition(cardElement.getRef(), Expression.create(j0Var.a()), new d2(viewGroup));
            watcherForCondition.setIfWatcher(watcher);
            j0Var.a(watcherForCondition);
        }
        return new ConditionalChild(j0Var, p0Var, cardElement, i10);
    }

    public CardElement getCardElement() {
        return this.f33837c;
    }

    public j0 getForCondition() {
        return this.f33835a;
    }

    public p0 getIfCondition() {
        return this.f33836b;
    }

    public int getInsertIndex() {
        return this.f33838d;
    }

    public void updateInsertIndex(int i10) {
        this.f33838d += i10;
    }
}

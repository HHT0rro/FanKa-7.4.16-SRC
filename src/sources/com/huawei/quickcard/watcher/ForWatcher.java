package com.huawei.quickcard.watcher;

import com.huawei.quickcard.CardContext;
import com.huawei.quickcard.utils.ExpressionUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class ForWatcher extends Watcher {

    /* renamed from: i, reason: collision with root package name */
    private Watcher f34721i;

    public ForWatcher(CardContext cardContext, Expression expression, IWatcherCallback iWatcherCallback) {
        super(cardContext, expression, iWatcherCallback);
    }

    public void setIfWatcher(Watcher watcher) {
        this.f34721i = watcher;
    }

    @Override // com.huawei.quickcard.watcher.Watcher
    public void update() {
        Watcher watcher = this.f34721i;
        if (watcher == null || ExpressionUtils.isTrue(watcher.get())) {
            super.update();
        }
    }

    public ForWatcher(CardContext cardContext, String str, IWatcherCallback iWatcherCallback) {
        super(cardContext, str, iWatcherCallback);
    }
}

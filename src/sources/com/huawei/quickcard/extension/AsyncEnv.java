package com.huawei.quickcard.extension;

import com.huawei.quickcard.CardContext;
import com.huawei.quickcard.base.annotation.DoNotShrink;
import java.lang.ref.WeakReference;

@DoNotShrink
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class AsyncEnv {

    /* renamed from: a, reason: collision with root package name */
    private final WeakReference<CardContext> f33634a;

    public AsyncEnv(CardContext cardContext) {
        this.f33634a = new WeakReference<>(cardContext);
    }

    public CardContext getCardContext() {
        return this.f33634a.get();
    }
}

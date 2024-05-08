package com.huawei.flexiblelayout.services.exposure.impl;

import androidx.annotation.NonNull;
import com.huawei.flexiblelayout.adapter.Visit;
import com.huawei.flexiblelayout.services.exposure.CardAttachStateListener;
import com.huawei.flexiblelayout.services.exposure.CardAttachStateOwner;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class CardAttachStateOwnerImpl implements CardAttachStateOwner {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final List<CardAttachStateListener> f28528a = new ArrayList();

    @Override // com.huawei.flexiblelayout.services.exposure.CardAttachStateOwner
    public void addListener(@NonNull CardAttachStateListener cardAttachStateListener) {
        this.f28528a.add(cardAttachStateListener);
    }

    public void notifyAttachStateChanged(boolean z10, Visit visit) {
        for (int size = this.f28528a.size() - 1; size >= 0; size--) {
            if (z10) {
                this.f28528a.get(size).onViewAttachedToWindow(visit);
            } else {
                this.f28528a.get(size).onViewDetachedFromWindow(visit);
            }
        }
    }

    @Override // com.huawei.flexiblelayout.services.exposure.CardAttachStateOwner
    public void removeListener(@NonNull CardAttachStateListener cardAttachStateListener) {
        this.f28528a.remove(cardAttachStateListener);
    }
}

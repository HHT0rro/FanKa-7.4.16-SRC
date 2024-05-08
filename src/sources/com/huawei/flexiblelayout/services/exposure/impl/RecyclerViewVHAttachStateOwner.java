package com.huawei.flexiblelayout.services.exposure.impl;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.flexiblelayout.adapter.ViewHolder;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class RecyclerViewVHAttachStateOwner extends CardAttachStateOwnerImpl implements RecyclerView.OnChildAttachStateChangeListener {

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    private final RecyclerView f28579b;

    public RecyclerViewVHAttachStateOwner(@NonNull RecyclerView recyclerView) {
        this.f28579b = recyclerView;
        recyclerView.addOnChildAttachStateChangeListener(this);
    }

    @Nullable
    private ViewHolder a(@NonNull View view) {
        RecyclerView.ViewHolder childViewHolder = this.f28579b.getChildViewHolder(view);
        if (childViewHolder instanceof ViewHolder) {
            return (ViewHolder) childViewHolder;
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
    public void onChildViewAttachedToWindow(@NonNull View view) {
        ViewHolder a10 = a(view);
        if (a10 == null) {
            return;
        }
        notifyAttachStateChanged(true, a10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
    public void onChildViewDetachedFromWindow(@NonNull View view) {
        ViewHolder a10 = a(view);
        if (a10 == null) {
            return;
        }
        notifyAttachStateChanged(false, a10);
    }
}

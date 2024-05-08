package com.yuyakaido.android.cardstackview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.yuyakaido.android.cardstackview.internal.CardStackDataObserver;
import com.yuyakaido.android.cardstackview.internal.CardStackSnapHelper;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class CardStackView extends RecyclerView {

    /* renamed from: b, reason: collision with root package name */
    public final CardStackDataObserver f48552b;

    public CardStackView(Context context) {
        this(context, null);
    }

    public final void m() {
        new CardStackSnapHelper().attachToRecyclerView(this);
        setOverScrollMode(2);
    }

    public void n() {
        if (getLayoutManager() instanceof CardStackLayoutManager) {
            smoothScrollToPosition(((CardStackLayoutManager) getLayoutManager()).f() - 1);
        }
    }

    public void o() {
        if (getLayoutManager() instanceof CardStackLayoutManager) {
            smoothScrollToPosition(((CardStackLayoutManager) getLayoutManager()).f() + 1);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        CardStackLayoutManager cardStackLayoutManager;
        if (motionEvent.getAction() == 0 && (cardStackLayoutManager = (CardStackLayoutManager) getLayoutManager()) != null) {
            cardStackLayoutManager.E(motionEvent.getX(), motionEvent.getY());
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setAdapter(RecyclerView.Adapter adapter) {
        if (getLayoutManager() == null) {
            setLayoutManager(new CardStackLayoutManager(getContext()));
        }
        if (getAdapter() != null) {
            getAdapter().unregisterAdapterDataObserver(this.f48552b);
            getAdapter().onDetachedFromRecyclerView(this);
        }
        adapter.registerAdapterDataObserver(this.f48552b);
        super.setAdapter(adapter);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setLayoutManager(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager instanceof CardStackLayoutManager) {
            super.setLayoutManager(layoutManager);
            return;
        }
        throw new IllegalArgumentException("CardStackView must be set CardStackLayoutManager.");
    }

    public CardStackView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CardStackView(Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f48552b = new CardStackDataObserver(this);
        m();
    }
}

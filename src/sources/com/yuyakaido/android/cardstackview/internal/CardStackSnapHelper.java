package com.yuyakaido.android.cardstackview.internal;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;
import com.yuyakaido.android.cardstackview.CardStackLayoutManager;
import com.yuyakaido.android.cardstackview.Duration;
import com.yuyakaido.android.cardstackview.internal.CardStackSmoothScroller;
import mc.c;
import nc.b;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class CardStackSnapHelper extends SnapHelper {

    /* renamed from: a, reason: collision with root package name */
    public int f48558a = 0;

    /* renamed from: b, reason: collision with root package name */
    public int f48559b = 0;

    @Override // androidx.recyclerview.widget.SnapHelper
    @Nullable
    public int[] calculateDistanceToFinalSnap(@NonNull RecyclerView.LayoutManager layoutManager, @NonNull View view) {
        if (layoutManager instanceof CardStackLayoutManager) {
            CardStackLayoutManager cardStackLayoutManager = (CardStackLayoutManager) layoutManager;
            if (cardStackLayoutManager.findViewByPosition(cardStackLayoutManager.f()) != null) {
                int translationX = (int) view.getTranslationX();
                int translationY = (int) view.getTranslationY();
                if (translationX != 0 || translationY != 0) {
                    b d10 = cardStackLayoutManager.d();
                    float abs = Math.abs(translationX) / view.getWidth();
                    float abs2 = Math.abs(translationY) / view.getHeight();
                    int i10 = this.f48559b;
                    int i11 = this.f48558a;
                    if (i10 < i11) {
                        i10 = i11;
                    }
                    Duration fromVelocity = Duration.fromVelocity(i10);
                    if (fromVelocity != Duration.Fast) {
                        float f10 = d10.f52201e;
                        if (f10 >= abs && f10 >= abs2) {
                            CardStackSmoothScroller cardStackSmoothScroller = new CardStackSmoothScroller(CardStackSmoothScroller.ScrollType.ManualCancel, cardStackLayoutManager);
                            cardStackSmoothScroller.setTargetPosition(cardStackLayoutManager.f());
                            cardStackLayoutManager.startSmoothScroll(cardStackSmoothScroller);
                        }
                    }
                    CardStackState e2 = cardStackLayoutManager.e();
                    if (d10.f52203g.contains(e2.b())) {
                        e2.f48566g = e2.f48565f + 1;
                        cardStackLayoutManager.t(new c.b().b(d10.f52207k.a()).c(fromVelocity.duration).d(d10.f52207k.b()).a());
                        this.f48558a = 0;
                        this.f48559b = 0;
                        CardStackSmoothScroller cardStackSmoothScroller2 = new CardStackSmoothScroller(CardStackSmoothScroller.ScrollType.ManualSwipe, cardStackLayoutManager);
                        cardStackSmoothScroller2.setTargetPosition(cardStackLayoutManager.f());
                        cardStackLayoutManager.startSmoothScroll(cardStackSmoothScroller2);
                    } else {
                        CardStackSmoothScroller cardStackSmoothScroller3 = new CardStackSmoothScroller(CardStackSmoothScroller.ScrollType.ManualCancel, cardStackLayoutManager);
                        cardStackSmoothScroller3.setTargetPosition(cardStackLayoutManager.f());
                        cardStackLayoutManager.startSmoothScroll(cardStackSmoothScroller3);
                    }
                }
            }
        }
        return new int[2];
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    @Nullable
    public View findSnapView(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager instanceof CardStackLayoutManager) {
            CardStackLayoutManager cardStackLayoutManager = (CardStackLayoutManager) layoutManager;
            View findViewByPosition = cardStackLayoutManager.findViewByPosition(cardStackLayoutManager.f());
            if (findViewByPosition != null) {
                int translationX = (int) findViewByPosition.getTranslationX();
                int translationY = (int) findViewByPosition.getTranslationY();
                if (translationX == 0 && translationY == 0) {
                    return null;
                }
                return findViewByPosition;
            }
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public int findTargetSnapPosition(RecyclerView.LayoutManager layoutManager, int i10, int i11) {
        this.f48558a = Math.abs(i10);
        this.f48559b = Math.abs(i11);
        if (layoutManager instanceof CardStackLayoutManager) {
            return ((CardStackLayoutManager) layoutManager).f();
        }
        return -1;
    }
}

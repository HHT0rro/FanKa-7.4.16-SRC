package com.cupidapp.live.match.adapter;

import android.view.ViewGroup;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewAdapter;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.liveshow.model.LiveShowModel;
import com.cupidapp.live.match.holder.SwipeCardMarketingPositionViewHolder;
import com.cupidapp.live.match.model.MatchGroupCampaignModel;
import com.cupidapp.live.match.model.MatchMarketingModel;
import com.cupidapp.live.match.model.MatchRecommendUserModel;
import com.cupidapp.live.match.view.FKSwipeCardFakeAvatarTipLayout;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: FKSwipeCardAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FKSwipeCardAdapter extends FKBaseRecyclerViewAdapter {

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public final FKSwipeCardFakeAvatarTipLayout.a f16622f;

    public FKSwipeCardAdapter(@NotNull FKSwipeCardFakeAvatarTipLayout.a callback) {
        s.i(callback, "callback");
        this.f16622f = callback;
        k().add(MatchRecommendUserModel.class);
        k().add(LiveShowModel.class);
        k().add(MatchGroupCampaignModel.class);
        k().add(MatchMarketingModel.class);
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: p */
    public void onViewAttachedToWindow(@NotNull FKBaseRecyclerViewHolder holder) {
        s.i(holder, "holder");
        super.onViewAttachedToWindow(holder);
        if (holder instanceof FKSwipeCardViewHolder) {
            ((FKSwipeCardViewHolder) holder).H();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public FKBaseRecyclerViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i10) {
        FKBaseRecyclerViewHolder a10;
        s.i(parent, "parent");
        if (i10 == 0) {
            a10 = FKSwipeCardViewHolder.f16626i.a(parent, this.f16622f);
        } else if (i10 == 1) {
            a10 = FKSwipeCardLiveViewHolder.f16623c.a(parent);
        } else if (i10 == 2) {
            a10 = SwipeCardCampaignViewHolder.f16639c.a(parent);
        } else if (i10 != 3) {
            a10 = FKSwipeCardViewHolder.f16626i.a(parent, this.f16622f);
        } else {
            a10 = SwipeCardMarketingPositionViewHolder.f16824c.a(parent);
        }
        a10.k(l());
        return a10;
    }
}

package com.cupidapp.live.notify.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.base.recyclerview.FKBlankSpaceViewHolder;
import com.cupidapp.live.base.recyclerview.FKEmptyListViewHolder;
import com.cupidapp.live.base.recyclerview.FKFooterViewHolder;
import com.cupidapp.live.base.recyclerview.MutableColumnRecyclerAdapter;
import com.cupidapp.live.base.recyclerview.helper.ExposureScene;
import com.cupidapp.live.base.recyclerview.helper.RecyclerExposureHelper;
import com.cupidapp.live.base.recyclerview.model.FKBlankSpaceModel;
import com.cupidapp.live.base.recyclerview.model.FKEmptyViewModel;
import com.cupidapp.live.base.recyclerview.model.FKFooterViewModel;
import com.cupidapp.live.base.sensorslog.SensorScene;
import com.cupidapp.live.notify.viewholder.FollowYouNeedPurchaseViewHolder;
import com.cupidapp.live.notify.viewholder.NotifyTopTitleUiModel;
import com.cupidapp.live.notify.viewholder.NotifyTopTitleViewHolder;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.track.group.GroupSocialLog;
import h1.a;
import java.util.Iterator;
import java.util.List;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;

/* compiled from: FollowYouPurchaseAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FollowYouPurchaseAdapter extends MutableColumnRecyclerAdapter {
    public FollowYouPurchaseAdapter() {
        List<Class<? extends Object>> k10 = k();
        k10.add(User.class);
        k10.add(FKFooterViewModel.class);
        k10.add(NotifyTopTitleUiModel.class);
        k10.add(FKBlankSpaceModel.class);
        k10.add(FKEmptyViewModel.class);
    }

    @Override // com.cupidapp.live.base.recyclerview.MutableColumnRecyclerAdapter
    public int u(int i10) {
        if (i10 >= 0 && !(j().get(i10) instanceof User)) {
            return v();
        }
        return 1;
    }

    @Override // com.cupidapp.live.base.recyclerview.MutableColumnRecyclerAdapter
    public int v() {
        return 2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public FKBaseRecyclerViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i10) {
        FKBaseRecyclerViewHolder a10;
        s.i(parent, "parent");
        if (i10 == 0) {
            a10 = FollowYouNeedPurchaseViewHolder.f17575c.a(parent);
        } else if (i10 == 1) {
            a10 = FKFooterViewHolder.f12036c.a(parent);
        } else if (i10 == 2) {
            a10 = NotifyTopTitleViewHolder.f17577c.a(parent);
        } else if (i10 != 3) {
            a10 = FKEmptyListViewHolder.f12034c.a(parent);
        } else {
            a10 = FKBlankSpaceViewHolder.f12032c.a(parent);
        }
        a10.k(l());
        return a10;
    }

    public final void y(@NotNull User model) {
        s.i(model, "model");
        int indexOf = j().indexOf(model);
        if (f(indexOf)) {
            notifyItemChanged(indexOf);
        }
    }

    public final void z(@NotNull RecyclerView recyclerView) {
        s.i(recyclerView, "recyclerView");
        t(new RecyclerExposureHelper(ExposureScene.FollowerList, recyclerView, 0.0f, 0L, null, new Function1<List<? extends a>, p>() { // from class: com.cupidapp.live.notify.adapter.FollowYouPurchaseAdapter$setExposureHelper$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(List<? extends a> list) {
                invoke2((List<a>) list);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull List<a> itemList) {
                s.i(itemList, "itemList");
                Iterator<a> iterator2 = itemList.iterator2();
                while (iterator2.hasNext()) {
                    Object a10 = iterator2.next().a();
                    if (a10 instanceof User) {
                        GroupSocialLog.f18708a.w(SensorScene.FollowerList.getValue(), ((User) a10).userId(), (r29 & 4) != 0 ? null : null, (r29 & 8) != 0 ? false : false, (r29 & 16) != 0 ? null : null, (r29 & 32) != 0 ? 0 : 0, (r29 & 64) != 0 ? null : null, (r29 & 128) != 0 ? null : null, (r29 & 256) != 0 ? false : false, (r29 & 512) != 0 ? false : false, (r29 & 1024) != 0 ? false : false, (r29 & 2048) != 0 ? false : false);
                    }
                }
            }
        }, 28, null));
    }
}

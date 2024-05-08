package com.cupidapp.live.profile.adapter;

import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.base.recyclerview.FKFooterViewHolder;
import com.cupidapp.live.base.recyclerview.MutableColumnRecyclerAdapter;
import com.cupidapp.live.base.recyclerview.model.FKFooterViewModel;
import com.cupidapp.live.feed.model.FeedModel;
import com.cupidapp.live.profile.holder.FKProfileStoryLabelModel;
import com.cupidapp.live.profile.holder.FKProfileStoryLabelViewHolder;
import com.cupidapp.live.profile.holder.MedalListModel;
import com.cupidapp.live.profile.holder.ProfileAbNormalPromptViewHolder;
import com.cupidapp.live.profile.holder.ProfileAbNormalPromptViewModel;
import com.cupidapp.live.profile.holder.ProfileBlackListTipsViewHolder;
import com.cupidapp.live.profile.holder.ProfileBlackListTipsViewModel;
import com.cupidapp.live.profile.holder.ProfileFriendPraiseModel;
import com.cupidapp.live.profile.holder.ProfileFriendPraiseViewHolder;
import com.cupidapp.live.profile.holder.ProfileHeaderViewHolder;
import com.cupidapp.live.profile.holder.ProfileHeaderViewModel;
import com.cupidapp.live.profile.holder.ProfileHighRiskUserViewHolder;
import com.cupidapp.live.profile.holder.ProfileHighRiskUserViewModel;
import com.cupidapp.live.profile.holder.ProfileLiveStatusViewHolder;
import com.cupidapp.live.profile.holder.ProfileLiveStatusViewModel;
import com.cupidapp.live.profile.holder.ProfilePostCountTitleViewHolder;
import com.cupidapp.live.profile.holder.ProfilePostCountTitleViewModel;
import com.cupidapp.live.profile.holder.ProfilePostMediaViewHolder;
import com.cupidapp.live.profile.holder.ProfileSummaryViewHolder;
import com.cupidapp.live.profile.holder.ProfileSummaryViewModel;
import com.cupidapp.live.profile.holder.UserClubMedalViewHolder;
import com.cupidapp.live.profile.model.User;
import java.util.Iterator;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: UserProfileAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class UserProfileAdapter extends MutableColumnRecyclerAdapter {

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public final Lifecycle f17720g;

    public UserProfileAdapter(@NotNull Lifecycle lifecycle) {
        s.i(lifecycle, "lifecycle");
        this.f17720g = lifecycle;
        List<Class<? extends Object>> k10 = k();
        k10.add(ProfileAbNormalPromptViewModel.class);
        k10.add(ProfileBlackListTipsViewModel.class);
        k10.add(ProfileLiveStatusViewModel.class);
        k10.add(ProfileHighRiskUserViewModel.class);
        k10.add(ProfileHeaderViewModel.class);
        k10.add(ProfileSummaryViewModel.class);
        k10.add(ProfilePostCountTitleViewModel.class);
        k10.add(FeedModel.class);
        k10.add(FKProfileStoryLabelModel.class);
        k10.add(ProfileFriendPraiseModel.class);
        k10.add(MedalListModel.class);
        k10.add(FKFooterViewModel.class);
    }

    @Override // com.cupidapp.live.base.recyclerview.MutableColumnRecyclerAdapter
    public int u(int i10) {
        if (i10 >= 0 && !(j().get(i10) instanceof FeedModel)) {
            return v();
        }
        return 1;
    }

    @Override // com.cupidapp.live.base.recyclerview.MutableColumnRecyclerAdapter
    public int v() {
        return 2;
    }

    public final void x(@NotNull User user) {
        int i10;
        s.i(user, "user");
        Iterator<Object> iterator2 = j().iterator2();
        int i11 = 0;
        int i12 = 0;
        while (true) {
            i10 = -1;
            if (!iterator2.hasNext()) {
                i12 = -1;
                break;
            } else if (iterator2.next() instanceof ProfileFriendPraiseModel) {
                break;
            } else {
                i12++;
            }
        }
        boolean f10 = f(i12);
        boolean y10 = y(user);
        if (f10 && !y10) {
            j().remove(i12);
            notifyDataSetChanged();
            return;
        }
        if (f10 && y10 && user.getPraise() != null) {
            j().set(i12, user.getPraise());
            notifyItemChanged(i12);
            return;
        }
        if (f10 || !y10) {
            return;
        }
        Iterator<Object> iterator22 = j().iterator2();
        int i13 = 0;
        while (true) {
            if (!iterator22.hasNext()) {
                i13 = -1;
                break;
            } else if (iterator22.next() instanceof FKProfileStoryLabelModel) {
                break;
            } else {
                i13++;
            }
        }
        if (f(i13)) {
            i10 = i13 + 1;
        } else {
            Iterator<Object> iterator23 = j().iterator2();
            while (true) {
                if (!iterator23.hasNext()) {
                    i11 = -1;
                    break;
                } else if (iterator23.next() instanceof ProfileSummaryViewModel) {
                    break;
                } else {
                    i11++;
                }
            }
            if (f(i11)) {
                i10 = i11 + 1;
            }
        }
        if (i10 < 0 || i10 > j().size() || user.getPraise() == null) {
            return;
        }
        c(i10, user.getPraise());
        notifyItemInserted(i10);
    }

    public final boolean y(User user) {
        return user.getPraise() != null && (user.getPraise().getCount() > 0 || !user.getMe());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public FKBaseRecyclerViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i10) {
        FKBaseRecyclerViewHolder a10;
        s.i(parent, "parent");
        switch (i10) {
            case 0:
                a10 = ProfileAbNormalPromptViewHolder.f17818c.a(parent);
                break;
            case 1:
                a10 = ProfileBlackListTipsViewHolder.f17819c.a(parent);
                break;
            case 2:
                a10 = ProfileLiveStatusViewHolder.f17826c.a(parent);
                break;
            case 3:
                a10 = ProfileHighRiskUserViewHolder.f17825c.a(parent);
                break;
            case 4:
                a10 = ProfileHeaderViewHolder.f17822e.a(parent, this.f17720g);
                break;
            case 5:
                a10 = ProfileSummaryViewHolder.f17829c.a(parent);
                break;
            case 6:
                a10 = ProfilePostCountTitleViewHolder.f17827c.a(parent);
                break;
            case 7:
                a10 = ProfilePostMediaViewHolder.f17828c.a(parent);
                break;
            case 8:
                a10 = FKProfileStoryLabelViewHolder.f17805c.a(parent);
                break;
            case 9:
                a10 = ProfileFriendPraiseViewHolder.f17821c.a(parent);
                break;
            case 10:
                a10 = UserClubMedalViewHolder.f17832d.a(parent);
                break;
            default:
                a10 = FKFooterViewHolder.f12036c.a(parent);
                break;
        }
        a10.k(l());
        return a10;
    }
}

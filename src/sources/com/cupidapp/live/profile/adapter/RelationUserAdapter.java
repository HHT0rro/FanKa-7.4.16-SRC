package com.cupidapp.live.profile.adapter;

import android.view.ViewGroup;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewAdapter;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.base.recyclerview.FKEmptyListViewHolder;
import com.cupidapp.live.base.recyclerview.FKFooterViewHolder;
import com.cupidapp.live.base.recyclerview.model.FKEmptyViewModel;
import com.cupidapp.live.base.recyclerview.model.FKFooterViewModel;
import com.cupidapp.live.match.helper.FloatAvatarHelper;
import com.cupidapp.live.profile.holder.NearByGuideViewHolder;
import com.cupidapp.live.profile.holder.NonexistentUserEnterViewHolder;
import com.cupidapp.live.profile.holder.NonexistentUserEnterViewModel;
import com.cupidapp.live.profile.holder.RelationUserUiModel;
import com.cupidapp.live.profile.holder.RelationUserViewHolder;
import com.cupidapp.live.profile.model.NearByGuideModel;
import com.cupidapp.live.profile.model.NearByGuideUserModel;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: RelationUserAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class RelationUserAdapter extends FKBaseRecyclerViewAdapter {

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public final FloatAvatarHelper<NearByGuideUserModel> f17719f;

    public RelationUserAdapter(@NotNull FloatAvatarHelper<NearByGuideUserModel> animHelper) {
        s.i(animHelper, "animHelper");
        this.f17719f = animHelper;
        List<Class<? extends Object>> k10 = k();
        k10.add(RelationUserUiModel.class);
        k10.add(NonexistentUserEnterViewModel.class);
        k10.add(NearByGuideModel.class);
        k10.add(FKEmptyViewModel.class);
        k10.add(FKFooterViewModel.class);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public FKBaseRecyclerViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i10) {
        FKBaseRecyclerViewHolder a10;
        s.i(parent, "parent");
        if (i10 == 0) {
            a10 = RelationUserViewHolder.f17830c.a(parent);
        } else if (i10 == 1) {
            a10 = NonexistentUserEnterViewHolder.f17814c.a(parent);
        } else if (i10 == 2) {
            a10 = NearByGuideViewHolder.f17812d.a(parent, this.f17719f);
        } else if (i10 != 3) {
            a10 = FKFooterViewHolder.f12036c.a(parent);
        } else {
            a10 = FKEmptyListViewHolder.f12034c.a(parent);
        }
        a10.k(l());
        return a10;
    }
}

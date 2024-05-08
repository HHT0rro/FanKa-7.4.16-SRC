package com.cupidapp.live.liveshow.fanclub.adapter;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.liveshow.fanclub.model.FKFanClubMemberDataModel;
import com.cupidapp.live.liveshow.view.miniprofile.ShowLiveMiniProfileViewModel;
import com.cupidapp.live.liveshow.view.music.view.FKConflictListRecyclerView;
import kotlin.Lazy;
import kotlin.c;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: FKFanClubForAnchorAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKClubMemberViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final a f14954d = new a(null);

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public final Lazy f14955c;

    /* compiled from: FKFanClubForAnchorAdapter.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FKClubMemberViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new FKClubMemberViewHolder(z.b(parent, R$layout.view_holder_club_member, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKClubMemberViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
        this.f14955c = c.b(new Function0<FKFanClubMemberAdapter>() { // from class: com.cupidapp.live.liveshow.fanclub.adapter.FKClubMemberViewHolder$memberAdapter$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final FKFanClubMemberAdapter invoke() {
                FKFanClubMemberAdapter fKFanClubMemberAdapter = new FKFanClubMemberAdapter();
                fKFanClubMemberAdapter.l().g(new Function1<Object, p>() { // from class: com.cupidapp.live.liveshow.fanclub.adapter.FKClubMemberViewHolder$memberAdapter$2$1$1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ p invoke(Object obj) {
                        invoke2(obj);
                        return p.f51048a;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@Nullable Object obj) {
                        if (obj instanceof FKFanClubMemberDataModel) {
                            EventBus.c().l(new ShowLiveMiniProfileViewModel(((FKFanClubMemberDataModel) obj).getUser().userId(), null, null, false, false, false, 62, null));
                        }
                    }
                });
                return fKFanClubMemberAdapter;
            }
        });
        FKConflictListRecyclerView fKConflictListRecyclerView = (FKConflictListRecyclerView) itemView.findViewById(R$id.clubMemberRecyclerView);
        fKConflictListRecyclerView.setAdapter(r());
        fKConflictListRecyclerView.setLayoutManager(new LinearLayoutManager(itemView.getContext(), 1, false));
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof FKClubMemberModel) {
            r().e(((FKClubMemberModel) obj).getList());
            r().notifyItemRangeChanged(0, r().getItemCount());
        }
    }

    public final FKFanClubMemberAdapter r() {
        return (FKFanClubMemberAdapter) this.f14955c.getValue();
    }
}

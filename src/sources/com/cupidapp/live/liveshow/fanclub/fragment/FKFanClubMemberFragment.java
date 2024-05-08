package com.cupidapp.live.liveshow.fanclub.fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.fragment.BaseBottomSheetDialogFragment;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.e;
import com.cupidapp.live.base.network.i;
import com.cupidapp.live.liveshow.constants.FKLiveConstantsData;
import com.cupidapp.live.liveshow.fanclub.adapter.FKFanClubMemberAdapter;
import com.cupidapp.live.liveshow.fanclub.model.FKFanClubDataModel;
import com.cupidapp.live.liveshow.fanclub.model.FKFanClubMemberDataModel;
import com.cupidapp.live.liveshow.fanclub.model.FKFanClubResult;
import com.cupidapp.live.liveshow.model.LiveShowModel;
import com.cupidapp.live.liveshow.view.miniprofile.ShowLiveMiniProfileViewModel;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.LinkedHashMap;
import java.util.Map;
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
import z0.h;
import z0.m;
import z0.y;

/* compiled from: FKFanClubMemberFragment.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKFanClubMemberFragment extends BaseBottomSheetDialogFragment {

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public static final a f14970g = new a(null);

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f14972f = new LinkedHashMap();

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public final Lazy f14971e = c.b(new Function0<FKFanClubMemberAdapter>() { // from class: com.cupidapp.live.liveshow.fanclub.fragment.FKFanClubMemberFragment$fanClubMemberAdapter$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final FKFanClubMemberAdapter invoke() {
            FKFanClubMemberAdapter fKFanClubMemberAdapter = new FKFanClubMemberAdapter();
            fKFanClubMemberAdapter.l().g(new Function1<Object, p>() { // from class: com.cupidapp.live.liveshow.fanclub.fragment.FKFanClubMemberFragment$fanClubMemberAdapter$2$1$1
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

    /* compiled from: FKFanClubMemberFragment.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@Nullable FragmentManager fragmentManager) {
            if (fragmentManager == null) {
                return;
            }
            new FKFanClubMemberFragment().show(fragmentManager, FKFanClubMemberFragment.class.getSimpleName());
        }
    }

    @Override // com.cupidapp.live.base.fragment.BaseBottomSheetDialogFragment
    public void O0() {
        this.f14972f.clear();
    }

    @Nullable
    public View V0(int i10) {
        View findViewById;
        Map<Integer, View> map = this.f14972f;
        View view = map.get(Integer.valueOf(i10));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null || (findViewById = view2.findViewById(i10)) == null) {
            return null;
        }
        map.put(Integer.valueOf(i10), findViewById);
        return findViewById;
    }

    public final void X0() {
        ImageView fanClubMemberBackView = (ImageView) V0(R$id.fanClubMemberBackView);
        s.h(fanClubMemberBackView, "fanClubMemberBackView");
        y.d(fanClubMemberBackView, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.fanclub.fragment.FKFanClubMemberFragment$bindClickEvent$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(View view) {
                invoke2(view);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
                FKFanClubMemberFragment.this.dismiss();
            }
        });
    }

    public final FKFanClubMemberAdapter Y0() {
        return (FKFanClubMemberAdapter) this.f14971e.getValue();
    }

    public final void Z0() {
        LiveShowModel liveShowModel = FKLiveConstantsData.INSTANCE.getLiveShowModel();
        if (liveShowModel != null) {
            Disposable disposed = NetworkClient.f11868a.r().h(liveShowModel.getUser().userId()).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<FKFanClubResult, p>() { // from class: com.cupidapp.live.liveshow.fanclub.fragment.FKFanClubMemberFragment$getFanClubMemberData$lambda$3$$inlined$handle$default$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(FKFanClubResult fKFanClubResult) {
                    m2610invoke(fKFanClubResult);
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m2610invoke(FKFanClubResult fKFanClubResult) {
                    FKFanClubMemberAdapter Y0;
                    FKFanClubMemberAdapter Y02;
                    FKFanClubMemberAdapter Y03;
                    FKFanClubResult fKFanClubResult2 = fKFanClubResult;
                    FKFanClubDataModel club = fKFanClubResult2.getClub();
                    if (club != null) {
                        ((TextView) FKFanClubMemberFragment.this.V0(R$id.fanClubMemberTitleTextView)).setText(club.getTitle());
                        ((TextView) FKFanClubMemberFragment.this.V0(R$id.fanClubMemberTextView)).setText(FKFanClubMemberFragment.this.getString(R$string.fan_club_member, m.a(club.getMemberCount())));
                    }
                    Y0 = FKFanClubMemberFragment.this.Y0();
                    Y0.e(fKFanClubResult2.getMembers());
                    Y02 = FKFanClubMemberFragment.this.Y0();
                    Y03 = FKFanClubMemberFragment.this.Y0();
                    Y02.notifyItemRangeChanged(0, Y03.getItemCount());
                }
            }), new e(new ObservableExtensionKt$handle$disposed$2(null, this)));
            if (disposed != null) {
                s.h(disposed, "disposed");
                H(disposed);
            }
            s.h(disposed, "disposed");
        }
    }

    public final void a1() {
        ConstraintLayout fanClubMemberContainerLayout = (ConstraintLayout) V0(R$id.fanClubMemberContainerLayout);
        s.h(fanClubMemberContainerLayout, "fanClubMemberContainerLayout");
        y.o(fanClubMemberContainerLayout, null, Integer.valueOf((h.k(this) / 3) * 2), 1, null);
        int i10 = R$id.fanClubMemberRecyclerView;
        RecyclerView recyclerView = (RecyclerView) V0(i10);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 1, false));
        recyclerView.setAdapter(Y0());
        RecyclerView fanClubMemberRecyclerView = (RecyclerView) V0(i10);
        s.h(fanClubMemberRecyclerView, "fanClubMemberRecyclerView");
        U0(fanClubMemberRecyclerView);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        s.i(inflater, "inflater");
        return inflater.inflate(R$layout.fragment_fan_club_member, viewGroup, false);
    }

    @Override // com.cupidapp.live.base.fragment.BaseBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        O0();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        R0(3, true);
    }

    @Override // com.cupidapp.live.base.fragment.BaseBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        s.i(view, "view");
        super.onViewCreated(view, bundle);
        Dialog dialog = getDialog();
        if (dialog != null) {
            z0.d.g(dialog, 0.0f);
        }
        a1();
        X0();
        Z0();
    }
}

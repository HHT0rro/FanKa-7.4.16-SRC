package com.cupidapp.live.liveshow.fanclub.fragment;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.fragment.BaseBottomSheetDialogFragment;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.e;
import com.cupidapp.live.base.network.i;
import com.cupidapp.live.base.recyclerview.model.FKEmptyViewModel;
import com.cupidapp.live.liveshow.activity.FKLiveOpenWebFragmentEvent;
import com.cupidapp.live.liveshow.fanclub.adapter.FKClubMemberModel;
import com.cupidapp.live.liveshow.fanclub.adapter.FKFanClubForAnchorAdapter;
import com.cupidapp.live.liveshow.fanclub.adapter.FKTaskProgressModel;
import com.cupidapp.live.liveshow.fanclub.model.FKFanClubDataModel;
import com.cupidapp.live.liveshow.fanclub.model.FKFanClubMemberDataModel;
import com.cupidapp.live.liveshow.fanclub.model.FKFanClubResult;
import com.cupidapp.live.liveshow.fanclub.model.FKFanClubTaskSummaryDataModel;
import com.cupidapp.live.liveshow.fanclub.view.FKEditFanClubNameLayout;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.LinkedHashMap;
import java.util.List;
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

/* compiled from: FKFanClubForAnchorFragment.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKFanClubForAnchorFragment extends BaseBottomSheetDialogFragment {

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public static final a f14965h = new a(null);

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public String f14967f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f14968g = new LinkedHashMap();

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public final Lazy f14966e = c.b(new Function0<FKFanClubForAnchorAdapter>() { // from class: com.cupidapp.live.liveshow.fanclub.fragment.FKFanClubForAnchorFragment$fanClubForAnchorAdapter$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final FKFanClubForAnchorAdapter invoke() {
            return new FKFanClubForAnchorAdapter();
        }
    });

    /* compiled from: FKFanClubForAnchorFragment.kt */
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
            new FKFanClubForAnchorFragment().show(fragmentManager, FKFanClubForAnchorFragment.class.getSimpleName());
        }
    }

    @Override // com.cupidapp.live.base.fragment.BaseBottomSheetDialogFragment
    public void O0() {
        this.f14968g.clear();
    }

    @Nullable
    public View V0(int i10) {
        View findViewById;
        Map<Integer, View> map = this.f14968g;
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

    public final void Z0() {
        ImageView editFanClubNameImageView = (ImageView) V0(R$id.editFanClubNameImageView);
        s.h(editFanClubNameImageView, "editFanClubNameImageView");
        y.d(editFanClubNameImageView, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.fanclub.fragment.FKFanClubForAnchorFragment$bindClickEvent$1
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
                Context context = FKFanClubForAnchorFragment.this.getContext();
                if (context != null) {
                    new FKEditFanClubNameLayout(context).m();
                }
            }
        });
        ImageView anchorFanClubForRuleImageView = (ImageView) V0(R$id.anchorFanClubForRuleImageView);
        s.h(anchorFanClubForRuleImageView, "anchorFanClubForRuleImageView");
        y.d(anchorFanClubForRuleImageView, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.fanclub.fragment.FKFanClubForAnchorFragment$bindClickEvent$2
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
                String str;
                EventBus c4 = EventBus.c();
                str = FKFanClubForAnchorFragment.this.f14967f;
                c4.l(new FKLiveOpenWebFragmentEvent(str, true));
            }
        });
        TextView taskProgressTextView = (TextView) V0(R$id.taskProgressTextView);
        s.h(taskProgressTextView, "taskProgressTextView");
        y.d(taskProgressTextView, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.fanclub.fragment.FKFanClubForAnchorFragment$bindClickEvent$3
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
                ((ViewPager2) FKFanClubForAnchorFragment.this.V0(R$id.fanClubForAnchorViewPager)).setCurrentItem(0);
            }
        });
        TextView fanClubMembersTextView = (TextView) V0(R$id.fanClubMembersTextView);
        s.h(fanClubMembersTextView, "fanClubMembersTextView");
        y.d(fanClubMembersTextView, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.fanclub.fragment.FKFanClubForAnchorFragment$bindClickEvent$4
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
                ((ViewPager2) FKFanClubForAnchorFragment.this.V0(R$id.fanClubForAnchorViewPager)).setCurrentItem(1);
            }
        });
    }

    public final FKFanClubForAnchorAdapter a1() {
        return (FKFanClubForAnchorAdapter) this.f14966e.getValue();
    }

    public final void b1() {
        Disposable disposed = NetworkClient.f11868a.r().Z().flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<FKFanClubResult, p>() { // from class: com.cupidapp.live.liveshow.fanclub.fragment.FKFanClubForAnchorFragment$getTaskAndMemberData$$inlined$handle$default$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(FKFanClubResult fKFanClubResult) {
                m2609invoke(fKFanClubResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2609invoke(FKFanClubResult fKFanClubResult) {
                FKFanClubForAnchorAdapter a12;
                FKFanClubForAnchorAdapter a13;
                FKFanClubForAnchorAdapter a14;
                FKFanClubForAnchorAdapter a15;
                FKFanClubForAnchorAdapter a16;
                FKFanClubResult fKFanClubResult2 = fKFanClubResult;
                FKFanClubDataModel club = fKFanClubResult2.getClub();
                if (club != null) {
                    FKFanClubForAnchorFragment.this.f14967f = club.getDescRuleUrl();
                    ImageLoaderView anchorFanClubAvatarImageView = (ImageLoaderView) FKFanClubForAnchorFragment.this.V0(R$id.anchorFanClubAvatarImageView);
                    s.h(anchorFanClubAvatarImageView, "anchorFanClubAvatarImageView");
                    ImageLoaderView.g(anchorFanClubAvatarImageView, club.getIconImage(), null, null, 6, null);
                    ((TextView) FKFanClubForAnchorFragment.this.V0(R$id.anchorFanClubNameTexView)).setText(club.getTitle());
                    if (club.getMemberCount() == 0) {
                        ((RelativeLayout) FKFanClubForAnchorFragment.this.V0(R$id.taskAndMemberTitleLayout)).setVisibility(8);
                        a16 = FKFanClubForAnchorFragment.this.a1();
                        a16.d(new FKEmptyViewModel(Integer.valueOf(R$mipmap.icon_empty_member_in_club), Integer.valueOf(R$string.empty_member_in_club), null, null, null, null, null, false, null, null, 1020, null));
                    } else {
                        ((RelativeLayout) FKFanClubForAnchorFragment.this.V0(R$id.taskAndMemberTitleLayout)).setVisibility(0);
                        ((TextView) FKFanClubForAnchorFragment.this.V0(R$id.fanClubMembersTextView)).setText(FKFanClubForAnchorFragment.this.getString(R$string.fan_club_members, m.c(club.getMemberCount())));
                        List<FKFanClubTaskSummaryDataModel> missionSummary = fKFanClubResult2.getMissionSummary();
                        if (missionSummary != null) {
                            a13 = FKFanClubForAnchorFragment.this.a1();
                            a13.d(new FKTaskProgressModel(missionSummary));
                        }
                        List<FKFanClubMemberDataModel> members = fKFanClubResult2.getMembers();
                        if (members != null) {
                            a12 = FKFanClubForAnchorFragment.this.a1();
                            a12.d(new FKClubMemberModel(members));
                        }
                    }
                    a14 = FKFanClubForAnchorFragment.this.a1();
                    a15 = FKFanClubForAnchorFragment.this.a1();
                    a14.notifyItemRangeChanged(0, a15.getItemCount());
                }
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(null, this)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            H(disposed);
        }
        s.h(disposed, "disposed");
    }

    public final void c1() {
        ViewPager2 viewPager2 = (ViewPager2) V0(R$id.fanClubForAnchorViewPager);
        viewPager2.setAdapter(a1());
        viewPager2.setUserInputEnabled(false);
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() { // from class: com.cupidapp.live.liveshow.fanclub.fragment.FKFanClubForAnchorFragment$initView$1$1
            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageSelected(int i10) {
                if (i10 == 0) {
                    FKFanClubForAnchorFragment.this.V0(R$id.taskProgressDynamicLineView).setVisibility(0);
                    FKFanClubForAnchorFragment.this.V0(R$id.clubMemberDynamicLineView).setVisibility(8);
                } else {
                    if (i10 != 1) {
                        return;
                    }
                    FKFanClubForAnchorFragment.this.V0(R$id.taskProgressDynamicLineView).setVisibility(8);
                    FKFanClubForAnchorFragment.this.V0(R$id.clubMemberDynamicLineView).setVisibility(0);
                }
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        s.i(inflater, "inflater");
        return inflater.inflate(R$layout.fragment_fan_club_for_anchor, viewGroup, false);
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
        ConstraintLayout fanClubForAnchorLayout = (ConstraintLayout) V0(R$id.fanClubForAnchorLayout);
        s.h(fanClubForAnchorLayout, "fanClubForAnchorLayout");
        y.o(fanClubForAnchorLayout, null, Integer.valueOf((h.k(this) / 3) * 2), 1, null);
        c1();
        Z0();
        b1();
    }
}

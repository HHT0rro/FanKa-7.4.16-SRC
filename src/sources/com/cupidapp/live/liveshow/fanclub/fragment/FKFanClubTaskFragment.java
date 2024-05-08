package com.cupidapp.live.liveshow.fanclub.fragment;

import android.app.Dialog;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.fragment.BaseBottomSheetDialogFragment;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.e;
import com.cupidapp.live.base.network.g;
import com.cupidapp.live.base.network.model.Result;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.base.router.jumper.ClosePopupsEvent;
import com.cupidapp.live.base.router.jumper.ShareLiveShowEvent;
import com.cupidapp.live.base.sensorslog.PopupButtonName;
import com.cupidapp.live.base.sensorslog.PopupName;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.utils.h;
import com.cupidapp.live.liveshow.activity.FKLiveForViewerActivity;
import com.cupidapp.live.liveshow.activity.FKLiveOpenWebFragmentEvent;
import com.cupidapp.live.liveshow.constants.FKLiveConstantsData;
import com.cupidapp.live.liveshow.fanclub.adapter.FKFanClubTaskAdapter;
import com.cupidapp.live.liveshow.fanclub.adapter.FKFanClubTaskModel;
import com.cupidapp.live.liveshow.fanclub.fragment.FKFanClubTaskFragment;
import com.cupidapp.live.liveshow.fanclub.model.FKFanClubDataModel;
import com.cupidapp.live.liveshow.fanclub.model.FKFanClubMemberDataModel;
import com.cupidapp.live.liveshow.fanclub.model.FKFanClubResult;
import com.cupidapp.live.liveshow.fanclub.model.FKFanClubTaskDataModel;
import com.cupidapp.live.liveshow.fanclub.model.FanClubStatus;
import com.cupidapp.live.liveshow.fanclub.model.TaskStatus;
import com.cupidapp.live.liveshow.fanclub.view.FKFanClubMedalLayout;
import com.cupidapp.live.liveshow.fanclub.view.FKFanClubMedalModel;
import com.cupidapp.live.liveshow.model.LiveShowModel;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import j1.i;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.c;
import kotlin.collections.i0;
import kotlin.collections.r;
import kotlin.d;
import kotlin.f;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.o;
import z0.y;

/* compiled from: FKFanClubTaskFragment.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKFanClubTaskFragment extends BaseBottomSheetDialogFragment {

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    public static final a f14973i = new a(null);

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public b f14974e;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    public FKFanClubResult f14976g;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f14977h = new LinkedHashMap();

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public final Lazy f14975f = c.b(new Function0<FKFanClubTaskAdapter>() { // from class: com.cupidapp.live.liveshow.fanclub.fragment.FKFanClubTaskFragment$taskAdapter$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final FKFanClubTaskAdapter invoke() {
            FKFanClubTaskAdapter fKFanClubTaskAdapter = new FKFanClubTaskAdapter();
            final FKFanClubTaskFragment fKFanClubTaskFragment = FKFanClubTaskFragment.this;
            fKFanClubTaskAdapter.l().j(i0.h(f.a(Integer.valueOf(R$id.fanClubTaskButtonTextView), new Function1<Object, p>() { // from class: com.cupidapp.live.liveshow.fanclub.fragment.FKFanClubTaskFragment$taskAdapter$2$1$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(Object obj) {
                    invoke2(obj);
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable Object obj) {
                    FKFanClubTaskFragment.b bVar;
                    if (obj instanceof FKFanClubTaskModel) {
                        FKFanClubTaskModel fKFanClubTaskModel = (FKFanClubTaskModel) obj;
                        if (fKFanClubTaskModel.getExpired() || fKFanClubTaskModel.getTaskModel().getStatus() == TaskStatus.Completed.getStatus()) {
                            return;
                        }
                        String specificGiftId = fKFanClubTaskModel.getTaskModel().getSpecificGiftId();
                        if (!(specificGiftId == null || specificGiftId.length() == 0)) {
                            bVar = FKFanClubTaskFragment.this.f14974e;
                            if (bVar != null) {
                                bVar.c(specificGiftId);
                                return;
                            }
                            return;
                        }
                        j.a.b(j.f12156c, FKFanClubTaskFragment.this.getContext(), fKFanClubTaskModel.getTaskModel().getJumpUrl(), null, 4, null);
                    }
                }
            })));
            return fKFanClubTaskAdapter;
        }
    });

    /* compiled from: FKFanClubTaskFragment.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final FKFanClubTaskFragment a(@Nullable FragmentManager fragmentManager, @NotNull b listener) {
            s.i(listener, "listener");
            if (fragmentManager == null) {
                return null;
            }
            FKFanClubTaskFragment fKFanClubTaskFragment = new FKFanClubTaskFragment();
            fKFanClubTaskFragment.f14974e = listener;
            fKFanClubTaskFragment.show(fragmentManager, FKFanClubTaskFragment.class.getSimpleName());
            return fKFanClubTaskFragment;
        }
    }

    /* compiled from: FKFanClubTaskFragment.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface b {
        void a(boolean z10);

        void b();

        void c(@NotNull String str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void f1(FKFanClubTaskFragment fKFanClubTaskFragment, Function1 function1, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            function1 = null;
        }
        fKFanClubTaskFragment.e1(function1);
    }

    @Override // com.cupidapp.live.base.fragment.BaseBottomSheetDialogFragment
    public void O0() {
        this.f14977h.clear();
    }

    @Nullable
    public View V0(int i10) {
        View findViewById;
        Map<Integer, View> map = this.f14977h;
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
        ImageView taskFanClubRuleImageView = (ImageView) V0(R$id.taskFanClubRuleImageView);
        s.h(taskFanClubRuleImageView, "taskFanClubRuleImageView");
        y.d(taskFanClubRuleImageView, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.fanclub.fragment.FKFanClubTaskFragment$bindClickEvent$1
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
                FKFanClubDataModel club;
                EventBus c4 = EventBus.c();
                FKFanClubResult d12 = FKFanClubTaskFragment.this.d1();
                c4.l(new FKLiveOpenWebFragmentEvent((d12 == null || (club = d12.getClub()) == null) ? null : club.getDescRuleUrl(), true));
            }
        });
        LinearLayout taskFanClubMemberLayout = (LinearLayout) V0(R$id.taskFanClubMemberLayout);
        s.h(taskFanClubMemberLayout, "taskFanClubMemberLayout");
        y.d(taskFanClubMemberLayout, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.fanclub.fragment.FKFanClubTaskFragment$bindClickEvent$2
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
                FKFanClubTaskFragment.b bVar;
                bVar = FKFanClubTaskFragment.this.f14974e;
                if (bVar != null) {
                    bVar.b();
                }
            }
        });
        TextView taskFanClubLightUpTextView = (TextView) V0(R$id.taskFanClubLightUpTextView);
        s.h(taskFanClubLightUpTextView, "taskFanClubLightUpTextView");
        y.d(taskFanClubLightUpTextView, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.fanclub.fragment.FKFanClubTaskFragment$bindClickEvent$3
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
                FKFanClubTaskFragment.b bVar;
                FKFanClubMemberDataModel profile;
                bVar = FKFanClubTaskFragment.this.f14974e;
                if (bVar != null) {
                    FKFanClubResult d12 = FKFanClubTaskFragment.this.d1();
                    bVar.a((d12 == null || (profile = d12.getProfile()) == null) ? false : profile.getAutoLightUp());
                }
                i.f50236a.a(PopupName.FANS_GROUP, PopupButtonName.AutoLightUp, SensorPosition.LiveShowRoom);
            }
        });
        LinearLayout taskFanClubSeePrivilegeLayout = (LinearLayout) V0(R$id.taskFanClubSeePrivilegeLayout);
        s.h(taskFanClubSeePrivilegeLayout, "taskFanClubSeePrivilegeLayout");
        y.d(taskFanClubSeePrivilegeLayout, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.fanclub.fragment.FKFanClubTaskFragment$bindClickEvent$4
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
                FKFanClubDataModel club;
                if (FKLiveConstantsData.INSTANCE.getLiveShowModel() != null) {
                    FKFanClubTaskFragment fKFanClubTaskFragment = FKFanClubTaskFragment.this;
                    EventBus c4 = EventBus.c();
                    FKFanClubResult d12 = fKFanClubTaskFragment.d1();
                    c4.l(new FKLiveOpenWebFragmentEvent((d12 == null || (club = d12.getClub()) == null) ? null : club.getPrivilegeUrl(), true));
                }
            }
        });
    }

    public final void a1(boolean z10) {
        if (z10) {
            ((TextView) V0(R$id.taskFanClubNameTextView)).setTextColor(-15066598);
            ((TextView) V0(R$id.taskFanClubMemberTextView)).setTextColor(-5658199);
            ImageView rightArrowImageView = (ImageView) V0(R$id.rightArrowImageView);
            s.h(rightArrowImageView, "rightArrowImageView");
            o.b(rightArrowImageView, -5658199);
            ImageView taskFanClubRuleImageView = (ImageView) V0(R$id.taskFanClubRuleImageView);
            s.h(taskFanClubRuleImageView, "taskFanClubRuleImageView");
            o.b(taskFanClubRuleImageView, h.a(-15066598, 0.4f));
            LinearLayout taskFanClubInfoLayout = (LinearLayout) V0(R$id.taskFanClubInfoLayout);
            s.h(taskFanClubInfoLayout, "taskFanClubInfoLayout");
            y.i(taskFanClubInfoLayout, (r18 & 1) != 0 ? 0.0f : z0.h.c(this, 12.0f), r.e(-1973791), (r18 & 4) != 0 ? GradientDrawable.Orientation.LEFT_RIGHT : null, (r18 & 8) != 0 ? null : null, (r18 & 16) != 0 ? null : null, (r18 & 32) != 0 ? 0.0f : 0.0f, (r18 & 64) != 0 ? 0.0f : 0.0f);
            return;
        }
        ((TextView) V0(R$id.taskFanClubNameTextView)).setTextColor(-1);
        ((TextView) V0(R$id.taskFanClubMemberTextView)).setTextColor(-14648);
        ImageView rightArrowImageView2 = (ImageView) V0(R$id.rightArrowImageView);
        s.h(rightArrowImageView2, "rightArrowImageView");
        o.b(rightArrowImageView2, -14648);
        ImageView taskFanClubRuleImageView2 = (ImageView) V0(R$id.taskFanClubRuleImageView);
        s.h(taskFanClubRuleImageView2, "taskFanClubRuleImageView");
        o.b(taskFanClubRuleImageView2, h.a(-1, 0.6f));
        LinearLayout taskFanClubInfoLayout2 = (LinearLayout) V0(R$id.taskFanClubInfoLayout);
        s.h(taskFanClubInfoLayout2, "taskFanClubInfoLayout");
        y.i(taskFanClubInfoLayout2, (r18 & 1) != 0 ? 0.0f : z0.h.c(this, 12.0f), kotlin.collections.s.m(-50851, -23207), (r18 & 4) != 0 ? GradientDrawable.Orientation.LEFT_RIGHT : null, (r18 & 8) != 0 ? null : null, (r18 & 16) != 0 ? null : null, (r18 & 32) != 0 ? 0.0f : 0.0f, (r18 & 64) != 0 ? 0.0f : 0.0f);
    }

    public final void b1(FKFanClubResult fKFanClubResult) {
        if (fKFanClubResult == null) {
            return;
        }
        this.f14976g = fKFanClubResult;
        FKFanClubDataModel club = fKFanClubResult.getClub();
        if (club != null) {
            ImageLoaderView taskFanClubAnchorAvatarImageView = (ImageLoaderView) V0(R$id.taskFanClubAnchorAvatarImageView);
            s.h(taskFanClubAnchorAvatarImageView, "taskFanClubAnchorAvatarImageView");
            ImageLoaderView.g(taskFanClubAnchorAvatarImageView, club.getIconImage(), null, null, 6, null);
            ((TextView) V0(R$id.taskFanClubNameTextView)).setText(club.getTitle());
            ((TextView) V0(R$id.taskFanClubMemberTextView)).setText(getString(R$string.club_member, club.getMemberCountFormatted()));
        }
        FKFanClubMemberDataModel profile = fKFanClubResult.getProfile();
        if (profile != null) {
            ImageLoaderView taskFanClubMemberAvatarImageView = (ImageLoaderView) V0(R$id.taskFanClubMemberAvatarImageView);
            s.h(taskFanClubMemberAvatarImageView, "taskFanClubMemberAvatarImageView");
            ImageLoaderView.g(taskFanClubMemberAvatarImageView, profile.getUser().getAvatarImage(), null, null, 6, null);
            ((FKFanClubMedalLayout) V0(R$id.taskFanClubMedalLayout)).b(new FKFanClubMedalModel(profile.getLevel(), profile.getBadgeName(), profile.getBadgeIcon(), profile.getBadgeBgColor()));
            ((TextView) V0(R$id.taskFanCLubIntimacyTextView)).setText(profile.getScoreToNextLevel());
        }
        FKFanClubMemberDataModel profile2 = fKFanClubResult.getProfile();
        a1(profile2 != null && profile2.getStatus() == FanClubStatus.Expired.getStatus());
        List<FKFanClubTaskDataModel> missions = fKFanClubResult.getMissions();
        FKFanClubMemberDataModel profile3 = fKFanClubResult.getProfile();
        c1(missions, profile3 != null && profile3.getStatus() == FanClubStatus.Expired.getStatus());
    }

    public final void c1(List<FKFanClubTaskDataModel> list, boolean z10) {
        FKFanClubTaskDataModel fKFanClubTaskDataModel;
        if (list == null) {
            return;
        }
        List<Object> j10 = g1().j();
        if (!(j10 == null || j10.isEmpty())) {
            for (Object obj : g1().j()) {
                if (obj instanceof FKFanClubTaskModel) {
                    Iterator<FKFanClubTaskDataModel> iterator2 = list.iterator2();
                    while (true) {
                        if (iterator2.hasNext()) {
                            fKFanClubTaskDataModel = iterator2.next();
                            if (s.d(fKFanClubTaskDataModel.getMissionId(), ((FKFanClubTaskModel) obj).getTaskModel().getMissionId())) {
                                break;
                            }
                        } else {
                            fKFanClubTaskDataModel = null;
                            break;
                        }
                    }
                    FKFanClubTaskDataModel fKFanClubTaskDataModel2 = fKFanClubTaskDataModel;
                    if (fKFanClubTaskDataModel2 != null) {
                        FKFanClubTaskModel fKFanClubTaskModel = (FKFanClubTaskModel) obj;
                        fKFanClubTaskModel.getTaskModel().setAmount(fKFanClubTaskDataModel2.getAmount());
                        fKFanClubTaskModel.getTaskModel().setStatus(fKFanClubTaskDataModel2.getStatus());
                        String specificGiftId = fKFanClubTaskDataModel2.getSpecificGiftId();
                        fKFanClubTaskModel.setExpired(specificGiftId == null || specificGiftId.length() == 0 ? z10 : false);
                    }
                }
            }
        } else {
            for (FKFanClubTaskDataModel fKFanClubTaskDataModel3 : list) {
                FKFanClubTaskAdapter g12 = g1();
                String specificGiftId2 = fKFanClubTaskDataModel3.getSpecificGiftId();
                g12.d(new FKFanClubTaskModel(fKFanClubTaskDataModel3, specificGiftId2 == null || specificGiftId2.length() == 0 ? z10 : false));
            }
        }
        g1().notifyItemRangeChanged(0, g1().getItemCount());
    }

    @Nullable
    public final FKFanClubResult d1() {
        return this.f14976g;
    }

    public final void e1(@Nullable final Function1<? super FKFanClubResult, p> function1) {
        LiveShowModel liveShowModel = FKLiveConstantsData.INSTANCE.getLiveShowModel();
        if (liveShowModel != null) {
            Observable<Result<FKFanClubResult>> N = NetworkClient.f11868a.r().N(liveShowModel.getUser().userId());
            Object context = getContext();
            g gVar = context instanceof g ? (g) context : null;
            Disposable disposed = N.flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<FKFanClubResult, p>() { // from class: com.cupidapp.live.liveshow.fanclub.fragment.FKFanClubTaskFragment$getFanClubTaskData$lambda$4$$inlined$handleByContext$default$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(FKFanClubResult fKFanClubResult) {
                    m2611invoke(fKFanClubResult);
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m2611invoke(FKFanClubResult fKFanClubResult) {
                    FKFanClubResult fKFanClubResult2 = fKFanClubResult;
                    Function1 function12 = Function1.this;
                    if (function12 != null) {
                        function12.invoke(fKFanClubResult2);
                    }
                    if (this.isResumed()) {
                        this.b1(fKFanClubResult2);
                    }
                }
            }), new e(new ObservableExtensionKt$handle$disposed$2(null, gVar)));
            if (disposed != null) {
                s.h(disposed, "disposed");
                if (gVar != null) {
                    gVar.H(disposed);
                }
            }
            s.h(disposed, "disposed");
        }
    }

    public final FKFanClubTaskAdapter g1() {
        return (FKFanClubTaskAdapter) this.f14975f.getValue();
    }

    public final void h1() {
        ConstraintLayout fanClubTaskContainerLayout = (ConstraintLayout) V0(R$id.fanClubTaskContainerLayout);
        s.h(fanClubTaskContainerLayout, "fanClubTaskContainerLayout");
        y.o(fanClubTaskContainerLayout, null, Integer.valueOf((z0.h.k(this) / 3) * 2), 1, null);
        int i10 = R$id.fanClubTaskRecyclerView;
        RecyclerView recyclerView = (RecyclerView) V0(i10);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 1, false));
        recyclerView.setAdapter(g1());
        RecyclerView.ItemAnimator itemAnimator = recyclerView.getItemAnimator();
        SimpleItemAnimator simpleItemAnimator = itemAnimator instanceof SimpleItemAnimator ? (SimpleItemAnimator) itemAnimator : null;
        if (simpleItemAnimator != null) {
            simpleItemAnimator.setSupportsChangeAnimations(false);
        }
        RecyclerView fanClubTaskRecyclerView = (RecyclerView) V0(i10);
        s.h(fanClubTaskRecyclerView, "fanClubTaskRecyclerView");
        U0(fanClubTaskRecyclerView);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        s.i(inflater, "inflater");
        return inflater.inflate(R$layout.fragment_fan_club_task, viewGroup, false);
    }

    @Override // com.cupidapp.live.base.fragment.BaseBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        O0();
    }

    @he.j(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull ShareLiveShowEvent event) {
        s.i(event, "event");
        dismiss();
        FragmentActivity activity = getActivity();
        FKLiveForViewerActivity fKLiveForViewerActivity = activity instanceof FKLiveForViewerActivity ? (FKLiveForViewerActivity) activity : null;
        if (fKLiveForViewerActivity != null) {
            fKLiveForViewerActivity.A1();
        }
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
        h1();
        Z0();
        f1(this, null, 1, null);
    }

    @he.j(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull ClosePopupsEvent event) {
        s.i(event, "event");
        dismiss();
    }
}

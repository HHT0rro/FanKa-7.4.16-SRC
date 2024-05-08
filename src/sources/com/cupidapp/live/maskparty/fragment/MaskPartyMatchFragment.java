package com.cupidapp.live.maskparty.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.base.fragment.FKBaseFragment;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.livedata.EventObserver;
import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.base.network.model.StateResult;
import com.cupidapp.live.base.permission.FKRxPermissionAlertDialog;
import com.cupidapp.live.base.sensorslog.MiniWindowCloseMethod;
import com.cupidapp.live.base.sensorslog.PopupName;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.utils.p0;
import com.cupidapp.live.chat.event.CloseTwoLevelFloorEvent;
import com.cupidapp.live.chat.event.EnableSecondPullCloseEvent;
import com.cupidapp.live.consult.helper.ConsultFloatWindowHelper;
import com.cupidapp.live.liveshow.miniwindow.FKLiveMiniWindow;
import com.cupidapp.live.maskparty.activity.MaskPartyChatActivity;
import com.cupidapp.live.maskparty.helper.MaskPartyPromptHelper;
import com.cupidapp.live.maskparty.model.CompleteInfoGuideModel;
import com.cupidapp.live.maskparty.model.ItemCardFeaturesItemModel;
import com.cupidapp.live.maskparty.model.MaskPartyConfigModel;
import com.cupidapp.live.maskparty.model.MaskPartyItemCardConfigModel;
import com.cupidapp.live.maskparty.model.MaskPartyMatchBtnType;
import com.cupidapp.live.maskparty.model.MaskPartyMatchConfigResult;
import com.cupidapp.live.maskparty.model.MaskPartyMatchStatusModel;
import com.cupidapp.live.maskparty.model.MaskPartyMatchSuccessModel;
import com.cupidapp.live.maskparty.model.MaskPartyModel;
import com.cupidapp.live.maskparty.model.MaskPartyType;
import com.cupidapp.live.maskparty.view.MaskPartyCompleteInfoLayout;
import com.cupidapp.live.maskparty.view.MaskPartyItemCardEntranceView;
import com.cupidapp.live.maskparty.view.MaskPartyItemCardGuideView;
import com.cupidapp.live.maskparty.view.MaskPartyMatchBottomTabLayout;
import com.cupidapp.live.maskparty.view.MaskPartyMatchLayout;
import com.cupidapp.live.maskparty.view.MaskPartyMatchTitleLayout;
import com.cupidapp.live.maskparty.view.MaskPartyMatchingLayout;
import com.cupidapp.live.maskparty.viewmodel.MaskPartyMatchViewModel;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.track.group.GroupSocialLog;
import com.cupidapp.live.vip.PurchaseDialogManager;
import com.cupidapp.live.vip.wrapper.VipPurchaseEntranceType;
import com.cupidapp.live.voiceparty.activity.VoicePartyActivity;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: MaskPartyMatchFragment.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MaskPartyMatchFragment extends FKBaseFragment {

    /* renamed from: o, reason: collision with root package name */
    @NotNull
    public static final a f16296o = new a(null);

    /* renamed from: e, reason: collision with root package name */
    public boolean f16297e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f16298f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f16299g;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public final Lazy f16300h;

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    public final ActivityResultLauncher<Intent> f16301i;

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    public final Lazy f16302j;

    /* renamed from: k, reason: collision with root package name */
    @NotNull
    public final Lazy f16303k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f16304l;

    /* renamed from: m, reason: collision with root package name */
    @Nullable
    public MaskPartyItemCardFragment f16305m;

    /* renamed from: n, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f16306n = new LinkedHashMap();

    /* compiled from: MaskPartyMatchFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ MaskPartyMatchFragment b(a aVar, boolean z10, boolean z11, boolean z12, int i10, Object obj) {
            if ((i10 & 4) != 0) {
                z12 = false;
            }
            return aVar.a(z10, z11, z12);
        }

        @NotNull
        public final MaskPartyMatchFragment a(boolean z10, boolean z11, boolean z12) {
            MaskPartyMatchFragment maskPartyMatchFragment = new MaskPartyMatchFragment();
            Bundle bundle = new Bundle();
            bundle.putBoolean("MASK_PARTY_START_MATCH", z10);
            bundle.putBoolean("MASK_PARTY_REMATCH", z11);
            bundle.putBoolean("FROM_SECOND_FLOOR", z12);
            maskPartyMatchFragment.setArguments(bundle);
            return maskPartyMatchFragment;
        }
    }

    /* compiled from: MaskPartyMatchFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b implements com.cupidapp.live.maskparty.view.j {
        public b() {
        }

        @Override // com.cupidapp.live.maskparty.view.j
        public void a() {
            MaskPartyMatchFragment.this.onBackPressed();
        }

        @Override // com.cupidapp.live.maskparty.view.j
        public void b(@NotNull CompleteInfoGuideModel guide) {
            kotlin.jvm.internal.s.i(guide, "guide");
            MaskPartyMatchFragment.this.D1(guide);
        }
    }

    /* compiled from: MaskPartyMatchFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class c implements com.cupidapp.live.maskparty.view.i {
        public c() {
        }

        @Override // com.cupidapp.live.maskparty.view.i
        public void a() {
            ConsultFloatWindowHelper.f13810b.i();
            FKLiveMiniWindow.G(FKLiveMiniWindow.f15074m.a(), MiniWindowCloseMethod.CloseMethodOther, false, true, 2, null);
            MaskPartyMatchFragment.this.H1();
        }

        @Override // com.cupidapp.live.maskparty.view.i
        public void b(@NotNull List<MaskPartyModel> partyList) {
            kotlin.jvm.internal.s.i(partyList, "partyList");
            MaskPartyMatchFragment.this.p1().setSelectParty(partyList);
        }
    }

    /* compiled from: MaskPartyMatchFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class d implements com.cupidapp.live.maskparty.view.k {
        public d() {
        }

        @Override // com.cupidapp.live.maskparty.view.k
        public void a() {
            ((MaskPartyItemCardEntranceView) MaskPartyMatchFragment.this.X0(R$id.item_card_entrance_view)).g(MaskPartyMatchFragment.this.O0());
        }

        @Override // com.cupidapp.live.maskparty.view.k
        public void b() {
            MaskPartyMatchFragment.this.p1().setMatchAvatar();
        }

        @Override // com.cupidapp.live.maskparty.view.k
        public void c() {
            MaskPartyMatchFragment.this.p1().stopMatch();
        }
    }

    /* compiled from: MaskPartyMatchFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class e implements m {
        public e() {
        }

        @Override // com.cupidapp.live.maskparty.fragment.m
        public void a() {
            MaskPartyMatchFragment.this.y1();
        }

        @Override // com.cupidapp.live.maskparty.fragment.m
        public void b() {
            MaskPartyMatchFragment.this.y1();
        }

        @Override // com.cupidapp.live.maskparty.fragment.m
        public void c(@Nullable ItemCardFeaturesItemModel itemCardFeaturesItemModel) {
            ((MaskPartyMatchLayout) MaskPartyMatchFragment.this.X0(R$id.match_layout)).f(itemCardFeaturesItemModel);
        }
    }

    /* compiled from: MaskPartyMatchFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class f implements MaskPartyCompleteInfoLayout.a {
        public f() {
        }

        @Override // com.cupidapp.live.maskparty.view.MaskPartyCompleteInfoLayout.a
        public void dismiss() {
            ((MaskPartyCompleteInfoLayout) MaskPartyMatchFragment.this.X0(R$id.mask_info_layout)).setVisibility(8);
        }
    }

    public MaskPartyMatchFragment() {
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.cupidapp.live.maskparty.fragment.MaskPartyMatchFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        this.f16300h = FragmentViewModelLazyKt.createViewModelLazy(this, kotlin.jvm.internal.v.b(MaskPartyMatchViewModel.class), new Function0<ViewModelStore>() { // from class: com.cupidapp.live.maskparty.fragment.MaskPartyMatchFragment$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = ((ViewModelStoreOwner) Function0.this.invoke()).getViewModelStore();
                kotlin.jvm.internal.s.h(viewModelStore, "ownerProducer().viewModelStore");
                return viewModelStore;
            }
        }, null);
        ActivityResultLauncher<Intent> registerForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.cupidapp.live.maskparty.fragment.n
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                MaskPartyMatchFragment.A1(MaskPartyMatchFragment.this, (ActivityResult) obj);
            }
        });
        kotlin.jvm.internal.s.h(registerForActivityResult, "registerForActivityResul…}\n            }\n        }");
        this.f16301i = registerForActivityResult;
        this.f16302j = kotlin.c.b(new Function0<PurchaseDialogManager>() { // from class: com.cupidapp.live.maskparty.fragment.MaskPartyMatchFragment$purchaseDialogManager$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final PurchaseDialogManager invoke() {
                Context context = MaskPartyMatchFragment.this.getContext();
                Lifecycle lifecycle = MaskPartyMatchFragment.this.getLifecycle();
                kotlin.jvm.internal.s.h(lifecycle, "lifecycle");
                return new PurchaseDialogManager(context, lifecycle);
            }
        });
        this.f16303k = kotlin.c.b(new Function0<xb.b>() { // from class: com.cupidapp.live.maskparty.fragment.MaskPartyMatchFragment$mRxPermissions$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final xb.b invoke() {
                return new xb.b(MaskPartyMatchFragment.this);
            }
        });
    }

    public static final void A1(MaskPartyMatchFragment this$0, ActivityResult activityResult) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        if (activityResult.getResultCode() == -1) {
            Intent data = activityResult.getData();
            this$0.f16298f = data != null ? data.getBooleanExtra("MASK_PARTY_REMATCH", false) : false;
            this$0.f16299g = data != null ? data.getBooleanExtra("MASK_PARTY_SHOW_ITEM_CARD_PROMPT", false) : false;
        }
    }

    public static final void s1(MaskPartyMatchFragment this$0, Pair pair) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        MaskPartyMatchConfigResult maskPartyMatchConfigResult = (MaskPartyMatchConfigResult) pair.getFirst();
        this$0.j1(maskPartyMatchConfigResult, (List) pair.getSecond());
        if (maskPartyMatchConfigResult.getGuide() != null) {
            p1.g gVar = p1.g.f52734a;
            Integer u10 = gVar.u();
            int intValue = u10 != null ? u10.intValue() : 0;
            if (intValue < 2) {
                gVar.f2(Integer.valueOf(intValue + 1));
            }
        }
        if (this$0.f16297e) {
            this$0.H1();
            this$0.f16297e = false;
            return;
        }
        if (this$0.f16298f) {
            this$0.H1();
            this$0.f16298f = false;
        } else {
            if (this$0.f16299g) {
                this$0.F1();
                this$0.f16299g = false;
                return;
            }
            ((MaskPartyItemCardGuideView) this$0.X0(R$id.item_card_guide_view)).b(maskPartyMatchConfigResult.getEnterRemind());
            CompleteInfoGuideModel guide = maskPartyMatchConfigResult.getGuide();
            if (guide != null) {
                this$0.B1(guide);
            }
        }
    }

    public static final void t1(MaskPartyMatchFragment this$0, MaskPartyMatchStatusModel it) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        if (this$0.f16304l) {
            EventBus.c().l(new EnableSecondPullCloseEvent(!it.getMatching()));
        }
        kotlin.jvm.internal.s.h(it, "it");
        this$0.k1(it);
    }

    public static final void u1(MaskPartyMatchFragment this$0, ImageModel imageModel) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        ((MaskPartyMatchingLayout) this$0.X0(R$id.matching_layout)).e(imageModel);
        if (imageModel != null) {
            this$0.p1().changeAvatar(imageModel.getImageId());
        }
    }

    public static final void v1(MaskPartyMatchFragment this$0, Pair pair) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        if (((Boolean) pair.getSecond()).booleanValue()) {
            ItemCardFeaturesItemModel N = p1.g.f52734a.N();
            if (N != null) {
                ((MaskPartyItemCardEntranceView) this$0.X0(R$id.item_card_entrance_view)).c(N);
                return;
            } else {
                ((MaskPartyItemCardEntranceView) this$0.X0(R$id.item_card_entrance_view)).d((String) pair.getFirst());
                return;
            }
        }
        ((MaskPartyItemCardEntranceView) this$0.X0(R$id.item_card_entrance_view)).d((String) pair.getFirst());
    }

    public final void B1(CompleteInfoGuideModel completeInfoGuideModel) {
        Integer u10;
        p1.g gVar = p1.g.f52734a;
        if (kotlin.jvm.internal.s.d(gVar.U0(), Boolean.TRUE) && (u10 = gVar.u()) != null && u10.intValue() == 2) {
            gVar.l3(Boolean.FALSE);
            D1(completeInfoGuideModel);
        }
    }

    public final void C1(MaskPartyItemCardConfigModel maskPartyItemCardConfigModel) {
        MaskPartyItemCardFragment a10 = MaskPartyItemCardFragment.f16285m.a(maskPartyItemCardConfigModel, O0(), new e());
        this.f16305m = a10;
        if (a10 != null) {
            FragmentManager parentFragmentManager = getParentFragmentManager();
            kotlin.jvm.internal.s.h(parentFragmentManager, "parentFragmentManager");
            a10.s1(parentFragmentManager);
        }
    }

    public final void D1(CompleteInfoGuideModel completeInfoGuideModel) {
        j1.i.g(j1.i.f50236a, PopupName.MASK_PARTY_COMPLETE_PROFILE, O0(), null, 4, null);
        int i10 = R$id.mask_info_layout;
        ((MaskPartyCompleteInfoLayout) X0(i10)).c(completeInfoGuideModel, O0());
        ((MaskPartyCompleteInfoLayout) X0(i10)).d(new f());
        ((MaskPartyCompleteInfoLayout) X0(i10)).setVisibility(0);
    }

    public final void E1() {
        User X = p1.g.f52734a.X();
        boolean z10 = false;
        if (X != null && X.isSVip()) {
            p1().showItemCardDialog(1);
            return;
        }
        if (X != null && X.isVip()) {
            z10 = true;
        }
        if (z10) {
            PurchaseDialogManager.q(n1(), VipPurchaseEntranceType.MaskPartyPrivilege, null, null, false, false, 30, null);
        } else {
            PurchaseDialogManager.j(n1(), VipPurchaseEntranceType.MaskPartyPrivilege, null, null, false, 14, null);
        }
    }

    public final void F1() {
        MaskPartyPromptHelper.f16347a.i(getContext(), O0(), new Function0<kotlin.p>() { // from class: com.cupidapp.live.maskparty.fragment.MaskPartyMatchFragment$showUseItemCardPrompt$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ kotlin.p invoke() {
                invoke2();
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                MaskPartyMatchViewModel.showItemCardDialog$default(MaskPartyMatchFragment.this.p1(), 0, 1, null);
            }
        });
        p1().maskMatchPropCardTipWindow();
    }

    public final void G1(final int i10) {
        MaskPartyPromptHelper.f16347a.k(getContext(), O0(), new Function0<kotlin.p>() { // from class: com.cupidapp.live.maskparty.fragment.MaskPartyMatchFragment$showUseItemCardPrompt$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ kotlin.p invoke() {
                invoke2();
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                MaskPartyMatchFragment.this.p1().useItemCardMatchNumber();
                MaskPartyMatchFragment.this.f16297e = i10 > 1;
            }
        });
    }

    public final void H1() {
        if (p1().isVoiceChatType()) {
            FKRxPermissionAlertDialog.f12016a.i(getContext(), m1(), new Function0<kotlin.p>() { // from class: com.cupidapp.live.maskparty.fragment.MaskPartyMatchFragment$startMaskPartyMatch$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ kotlin.p invoke() {
                    invoke2();
                    return kotlin.p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    MaskPartyMatchFragment.this.p1().startMatch();
                }
            });
        } else {
            p1().startMatch();
        }
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment
    public void N0() {
        this.f16306n.clear();
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment
    @NotNull
    public SensorPosition O0() {
        return p1().isVoiceChatType() ? SensorPosition.VoiceParty : SensorPosition.MaskParty;
    }

    @Nullable
    public View X0(int i10) {
        View findViewById;
        Map<Integer, View> map = this.f16306n;
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

    public final void h1() {
        ((MaskPartyMatchTitleLayout) X0(R$id.match_title_layout)).setListener(new b());
        ((MaskPartyMatchLayout) X0(R$id.match_layout)).setListener(new c());
        ((MaskPartyMatchingLayout) X0(R$id.matching_layout)).setListener(new d());
        ((MaskPartyMatchBottomTabLayout) X0(R$id.match_bottom_tab_layout)).setChangeTab(new Function1<Boolean, kotlin.p>() { // from class: com.cupidapp.live.maskparty.fragment.MaskPartyMatchFragment$bindClickEvent$4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return kotlin.p.f51048a;
            }

            public final void invoke(boolean z10) {
                MaskPartyMatchFragment maskPartyMatchFragment = MaskPartyMatchFragment.this;
                int i10 = R$id.match_layout;
                MaskPartyMatchFragment.this.p1().setSelectParty(((MaskPartyMatchLayout) maskPartyMatchFragment.X0(i10)).j(z10));
                ((MaskPartyMatchLayout) MaskPartyMatchFragment.this.X0(i10)).l(z10);
                j1.c.b(j1.c.f50228a, MaskPartyMatchFragment.this.O0(), null, null, 6, null);
            }
        });
        FrameLayout return_to_second_floor = (FrameLayout) X0(R$id.return_to_second_floor);
        kotlin.jvm.internal.s.h(return_to_second_floor, "return_to_second_floor");
        z0.y.d(return_to_second_floor, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.maskparty.fragment.MaskPartyMatchFragment$bindClickEvent$5
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(View view) {
                invoke2(view);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
                MaskPartyMatchFragment.this.onBackPressed();
            }
        });
        ((MaskPartyItemCardEntranceView) X0(R$id.item_card_entrance_view)).setClickCallback(new Function0<kotlin.p>() { // from class: com.cupidapp.live.maskparty.fragment.MaskPartyMatchFragment$bindClickEvent$6
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ kotlin.p invoke() {
                invoke2();
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                MaskPartyMatchFragment.this.p1().itemCardEntranceClick(MaskPartyMatchFragment.this.O0());
            }
        });
    }

    public final void i1() {
        if (this.f16304l) {
            EventBus.c().l(new CloseTwoLevelFloorEvent());
            return;
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    public final void j1(MaskPartyMatchConfigResult maskPartyMatchConfigResult, List<Integer> list) {
        ((MaskPartyMatchTitleLayout) X0(R$id.match_title_layout)).d(maskPartyMatchConfigResult.getGuide());
        ((MaskPartyMatchLayout) X0(R$id.match_layout)).h(maskPartyMatchConfigResult.getGameEntrance(), list);
        ((MaskPartyMatchBottomTabLayout) X0(R$id.match_bottom_tab_layout)).f(maskPartyMatchConfigResult.getGameEntrance(), list);
        z1(maskPartyMatchConfigResult, p1().isVoiceChatType());
    }

    public final void k1(MaskPartyMatchStatusModel maskPartyMatchStatusModel) {
        if (maskPartyMatchStatusModel.getConfineMatchSeconds() != null) {
            ((MaskPartyMatchLayout) X0(R$id.match_layout)).m(maskPartyMatchStatusModel.getConfineMatchSeconds().intValue());
            return;
        }
        if (maskPartyMatchStatusModel.getMatching()) {
            ((MaskPartyMatchTitleLayout) X0(R$id.match_title_layout)).setProgressVisible(false);
            MaskPartyMatchLayout match_layout = (MaskPartyMatchLayout) X0(R$id.match_layout);
            kotlin.jvm.internal.s.h(match_layout, "match_layout");
            match_layout.setVisibility(8);
            ((MaskPartyMatchBottomTabLayout) X0(R$id.match_bottom_tab_layout)).setChatTabVisible(false);
            ((FrameLayout) X0(R$id.return_to_second_floor)).setVisibility(4);
            int i10 = R$id.matching_layout;
            ((MaskPartyMatchingLayout) X0(i10)).i(true);
            ((MaskPartyMatchingLayout) X0(i10)).g(maskPartyMatchStatusModel.isVoiceChat());
            return;
        }
        ((MaskPartyMatchTitleLayout) X0(R$id.match_title_layout)).setProgressVisible(true);
        ((MaskPartyMatchingLayout) X0(R$id.matching_layout)).h();
        int i11 = R$id.match_layout;
        ((MaskPartyMatchLayout) X0(i11)).n(true);
        MaskPartyMatchLayout match_layout2 = (MaskPartyMatchLayout) X0(i11);
        kotlin.jvm.internal.s.h(match_layout2, "match_layout");
        match_layout2.setVisibility(0);
        ((MaskPartyMatchBottomTabLayout) X0(R$id.match_bottom_tab_layout)).setChatTabVisible(true);
        if (this.f16304l) {
            ((FrameLayout) X0(R$id.return_to_second_floor)).setVisibility(0);
        }
        if (maskPartyMatchStatusModel.getQuit()) {
            i1();
        }
    }

    @NotNull
    public final View l1() {
        MaskPartyMatchLayout match_layout = (MaskPartyMatchLayout) X0(R$id.match_layout);
        kotlin.jvm.internal.s.h(match_layout, "match_layout");
        return match_layout;
    }

    public final xb.b m1() {
        return (xb.b) this.f16303k.getValue();
    }

    public final PurchaseDialogManager n1() {
        return (PurchaseDialogManager) this.f16302j.getValue();
    }

    @NotNull
    public final View o1() {
        MaskPartyMatchTitleLayout match_title_layout = (MaskPartyMatchTitleLayout) X0(R$id.match_title_layout);
        kotlin.jvm.internal.s.h(match_title_layout, "match_title_layout");
        return match_title_layout;
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment
    public boolean onBackPressed() {
        try {
            if (!p1().setQuitMatchEvent()) {
                i1();
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        kotlin.jvm.internal.s.i(inflater, "inflater");
        if (viewGroup != null) {
            return z.b(viewGroup, R$layout.fragment_mask_party_match, false, 2, null);
        }
        return null;
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Window window;
        super.onDestroyView();
        FragmentActivity activity = getActivity();
        if (activity != null && (window = activity.getWindow()) != null) {
            window.clearFlags(128);
        }
        MaskPartyMatchLayout maskPartyMatchLayout = (MaskPartyMatchLayout) X0(R$id.match_layout);
        if (maskPartyMatchLayout != null) {
            maskPartyMatchLayout.o();
        }
        MaskPartyMatchingLayout maskPartyMatchingLayout = (MaskPartyMatchingLayout) X0(R$id.matching_layout);
        if (maskPartyMatchingLayout != null) {
            maskPartyMatchingLayout.h();
        }
        q1();
        N0();
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        com.cupidapp.live.push.d.f17892a.j(false);
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        y1();
        com.cupidapp.live.push.d.f17892a.j(true);
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Window window;
        kotlin.jvm.internal.s.i(view, "view");
        super.onViewCreated(view, bundle);
        FragmentActivity activity = getActivity();
        if (activity != null && (window = activity.getWindow()) != null) {
            window.addFlags(128);
        }
        Bundle arguments = getArguments();
        boolean z10 = arguments != null ? arguments.getBoolean("FROM_SECOND_FLOOR") : false;
        this.f16304l = z10;
        if (z10) {
            ((FrameLayout) X0(R$id.return_to_second_floor)).setVisibility(0);
            ((MaskPartyMatchTitleLayout) X0(R$id.match_title_layout)).f(false);
        } else {
            FragmentActivity activity2 = getActivity();
            if (activity2 != null) {
                p0.c(activity2, true, 0, 2, null);
            }
            ((FrameLayout) X0(R$id.return_to_second_floor)).setVisibility(8);
            ((MaskPartyMatchTitleLayout) X0(R$id.match_title_layout)).f(true);
        }
        w1();
        h1();
        r1();
        Bundle arguments2 = getArguments();
        this.f16297e = arguments2 != null ? arguments2.getBoolean("MASK_PARTY_START_MATCH") : false;
        Bundle arguments3 = getArguments();
        this.f16298f = arguments3 != null ? arguments3.getBoolean("MASK_PARTY_REMATCH") : false;
    }

    public final MaskPartyMatchViewModel p1() {
        return (MaskPartyMatchViewModel) this.f16300h.getValue();
    }

    public final void q1() {
        MaskPartyItemCardFragment maskPartyItemCardFragment;
        MaskPartyItemCardFragment maskPartyItemCardFragment2 = this.f16305m;
        if (!(maskPartyItemCardFragment2 != null && maskPartyItemCardFragment2.isAdded()) || (maskPartyItemCardFragment = this.f16305m) == null) {
            return;
        }
        maskPartyItemCardFragment.dismiss();
    }

    public final void r1() {
        p1().getMaskPartyMatchLiveData().observe(getViewLifecycleOwner(), new Observer() { // from class: com.cupidapp.live.maskparty.fragment.r
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MaskPartyMatchFragment.s1(MaskPartyMatchFragment.this, (Pair) obj);
            }
        });
        p1().getShowNoTimesEventLiveData().observe(getViewLifecycleOwner(), new EventObserver(new Function1<Integer, kotlin.p>() { // from class: com.cupidapp.live.maskparty.fragment.MaskPartyMatchFragment$initObserve$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Integer num) {
                invoke(num.intValue());
                return kotlin.p.f51048a;
            }

            public final void invoke(int i10) {
                if (i10 > 0) {
                    MaskPartyMatchFragment.this.G1(i10);
                } else {
                    MaskPartyMatchFragment.this.E1();
                }
            }
        }));
        p1().getMatchStatus().observe(getViewLifecycleOwner(), new Observer() { // from class: com.cupidapp.live.maskparty.fragment.p
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MaskPartyMatchFragment.t1(MaskPartyMatchFragment.this, (MaskPartyMatchStatusModel) obj);
            }
        });
        p1().getMatchAvatarLiveData().observe(getViewLifecycleOwner(), new Observer() { // from class: com.cupidapp.live.maskparty.fragment.o
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MaskPartyMatchFragment.u1(MaskPartyMatchFragment.this, (ImageModel) obj);
            }
        });
        p1().getQuitMatchEventLiveData().observe(getViewLifecycleOwner(), new EventObserver(new Function1<Boolean, kotlin.p>() { // from class: com.cupidapp.live.maskparty.fragment.MaskPartyMatchFragment$initObserve$5
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return kotlin.p.f51048a;
            }

            public final void invoke(boolean z10) {
                MaskPartyMatchFragment.this.x1(z10);
            }
        }));
        p1().getMatchSuccessEventLiveData().observe(getViewLifecycleOwner(), new EventObserver(new Function1<MaskPartyMatchSuccessModel, kotlin.p>() { // from class: com.cupidapp.live.maskparty.fragment.MaskPartyMatchFragment$initObserve$6
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(MaskPartyMatchSuccessModel maskPartyMatchSuccessModel) {
                invoke2(maskPartyMatchSuccessModel);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull MaskPartyMatchSuccessModel model) {
                ActivityResultLauncher activityResultLauncher;
                ActivityResultLauncher activityResultLauncher2;
                kotlin.jvm.internal.s.i(model, "model");
                int type = model.getType();
                if (type == MaskPartyType.MessageChat.getType() || type == MaskPartyType.ScriptKill.getType()) {
                    activityResultLauncher2 = MaskPartyMatchFragment.this.f16301i;
                    activityResultLauncher2.launch(MaskPartyChatActivity.a.b(MaskPartyChatActivity.f16230s, MaskPartyMatchFragment.this.getContext(), model.getRoomId(), model.getType(), false, 8, null));
                } else {
                    if (type != MaskPartyType.VoiceChat.getType() || model.getSdkAppID() == null) {
                        return;
                    }
                    String userSig = model.getUserSig();
                    if (userSig == null || userSig.length() == 0) {
                        return;
                    }
                    VoicePartyActivity.Config config = new VoicePartyActivity.Config(model.getRoomId(), model.getSdkAppID().intValue(), model.getUserSig());
                    activityResultLauncher = MaskPartyMatchFragment.this.f16301i;
                    activityResultLauncher.launch(VoicePartyActivity.f18981y.a(MaskPartyMatchFragment.this.getContext(), config));
                }
            }
        }));
        p1().getStopMatchEventLiveData().observe(getViewLifecycleOwner(), new EventObserver(new Function1<Boolean, kotlin.p>() { // from class: com.cupidapp.live.maskparty.fragment.MaskPartyMatchFragment$initObserve$7
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return kotlin.p.f51048a;
            }

            public final void invoke(final boolean z10) {
                MaskPartyPromptHelper maskPartyPromptHelper = MaskPartyPromptHelper.f16347a;
                Context context = MaskPartyMatchFragment.this.getContext();
                SensorPosition O0 = MaskPartyMatchFragment.this.O0();
                final MaskPartyMatchFragment maskPartyMatchFragment = MaskPartyMatchFragment.this;
                maskPartyPromptHelper.j(context, O0, new Function0<kotlin.p>() { // from class: com.cupidapp.live.maskparty.fragment.MaskPartyMatchFragment$initObserve$7.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ kotlin.p invoke() {
                        invoke2();
                        return kotlin.p.f51048a;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        MaskPartyMatchFragment.this.p1().stopMatch(false);
                        if (z10) {
                            MaskPartyMatchViewModel.showItemCardDialog$default(MaskPartyMatchFragment.this.p1(), 0, 1, null);
                        }
                    }
                });
            }
        }));
        p1().getBtnClickState().observe(getViewLifecycleOwner(), new EventObserver(new Function1<StateResult<MaskPartyMatchBtnType>, kotlin.p>() { // from class: com.cupidapp.live.maskparty.fragment.MaskPartyMatchFragment$initObserve$8

            /* compiled from: MaskPartyMatchFragment.kt */
            @kotlin.d
            /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
            public /* synthetic */ class a {

                /* renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f16312a;

                static {
                    int[] iArr = new int[MaskPartyMatchBtnType.values().length];
                    try {
                        iArr[MaskPartyMatchBtnType.START_MATCH_BTN.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[MaskPartyMatchBtnType.STOP_MATCH_BTN.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    f16312a = iArr;
                }
            }

            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(StateResult<MaskPartyMatchBtnType> stateResult) {
                invoke2(stateResult);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull StateResult<MaskPartyMatchBtnType> result) {
                boolean z10;
                kotlin.jvm.internal.s.i(result, "result");
                if (result instanceof StateResult.b ? true : result instanceof StateResult.c) {
                    z10 = false;
                } else {
                    if (!(result instanceof StateResult.a)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    z10 = true;
                }
                MaskPartyMatchBtnType data = result.getData();
                int i10 = data == null ? -1 : a.f16312a[data.ordinal()];
                if (i10 == 1) {
                    ((MaskPartyMatchLayout) MaskPartyMatchFragment.this.X0(R$id.match_layout)).n(z10);
                } else {
                    if (i10 != 2) {
                        return;
                    }
                    ((MaskPartyMatchingLayout) MaskPartyMatchFragment.this.X0(R$id.matching_layout)).i(z10);
                }
            }
        }));
        p1().getItemCardEntranceLiveData().observe(getViewLifecycleOwner(), new Observer() { // from class: com.cupidapp.live.maskparty.fragment.q
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MaskPartyMatchFragment.v1(MaskPartyMatchFragment.this, (Pair) obj);
            }
        });
        p1().getShowItemCardDialogEventLiveData().observe(getViewLifecycleOwner(), new EventObserver(new Function1<MaskPartyItemCardConfigModel, kotlin.p>() { // from class: com.cupidapp.live.maskparty.fragment.MaskPartyMatchFragment$initObserve$10
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(MaskPartyItemCardConfigModel maskPartyItemCardConfigModel) {
                invoke2(maskPartyItemCardConfigModel);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull MaskPartyItemCardConfigModel it) {
                kotlin.jvm.internal.s.i(it, "it");
                MaskPartyMatchFragment.this.C1(it);
            }
        }));
    }

    public final void w1() {
        MaskPartyMatchTitleLayout match_title_layout = (MaskPartyMatchTitleLayout) X0(R$id.match_title_layout);
        kotlin.jvm.internal.s.h(match_title_layout, "match_title_layout");
        z0.y.m(match_title_layout, null, Integer.valueOf(z0.h.m(getContext())), null, null, 13, null);
        ImageLoaderView mask_party_bg_image = (ImageLoaderView) X0(R$id.mask_party_bg_image);
        kotlin.jvm.internal.s.h(mask_party_bg_image, "mask_party_bg_image");
        ImageLoaderView.f(mask_party_bg_image, new com.cupidapp.live.base.imageloader.b(false, null, null, null, Integer.valueOf(R$mipmap.icon_mask_party_bg), null, null, 0, 0, null, null, null, null, false, 0, 0, false, null, null, 524271, null), null, 2, null);
        TextView return_to_second_txt = (TextView) X0(R$id.return_to_second_txt);
        kotlin.jvm.internal.s.h(return_to_second_txt, "return_to_second_txt");
        z0.u.a(return_to_second_txt);
    }

    public final void x1(boolean z10) {
        if (z10) {
            MaskPartyPromptHelper.f16347a.g(getContext(), new Function0<kotlin.p>() { // from class: com.cupidapp.live.maskparty.fragment.MaskPartyMatchFragment$quiteMatch$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ kotlin.p invoke() {
                    invoke2();
                    return kotlin.p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    MaskPartyMatchFragment.this.p1().stopMatch(true);
                }
            });
        }
    }

    public final void y1() {
        p1().getMaskPartyMatchInfo(this.f16298f);
    }

    public final void z1(MaskPartyMatchConfigResult maskPartyMatchConfigResult, boolean z10) {
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        for (MaskPartyConfigModel maskPartyConfigModel : maskPartyMatchConfigResult.getGameEntrance()) {
            int i13 = i12 + 1;
            if (i12 < 0) {
                kotlin.collections.s.s();
            }
            MaskPartyConfigModel maskPartyConfigModel2 = maskPartyConfigModel;
            if (i12 != 0) {
                if (i12 == 1) {
                    if (z10 && this.f16298f) {
                        i11 = maskPartyConfigModel2.getPlusRemains();
                    } else {
                        i11 = maskPartyConfigModel2.getRemains();
                    }
                }
            } else if (!z10 && this.f16298f) {
                i10 = maskPartyConfigModel2.getPlusRemains();
            } else {
                i10 = maskPartyConfigModel2.getRemains();
            }
            i12 = i13;
        }
        GroupSocialLog.f18708a.o(i10, i11, maskPartyMatchConfigResult.getItemCardRemains());
    }
}

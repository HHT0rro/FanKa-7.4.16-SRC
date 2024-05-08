package com.cupidapp.live.club.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.internal.logging.nano.MetricsProto;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.fragment.FKBaseFragment;
import com.cupidapp.live.base.livedata.EventObserver;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.base.network.model.StateResult;
import com.cupidapp.live.base.permission.FKRxPermissionAlertDialog;
import com.cupidapp.live.base.recyclerview.helper.FKDropDownLoadMoreListener;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorScene;
import com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick;
import com.cupidapp.live.base.utils.c0;
import com.cupidapp.live.base.view.animation.FKSVGAImageView;
import com.cupidapp.live.chat2.helper.KeyboardStatePopupWindow;
import com.cupidapp.live.chat2.model.ChatClickReEditBtnEvent;
import com.cupidapp.live.chat2.model.ChatTouchMessageListCloseAllPanelEvent;
import com.cupidapp.live.chat2.model.LongClickActionType;
import com.cupidapp.live.chat2.view.ChatEmojiPagerLayout;
import com.cupidapp.live.club.adapter.ClubChatAdapter;
import com.cupidapp.live.club.fragment.SendRedPacketFragment;
import com.cupidapp.live.club.model.ClubCancelMsgData;
import com.cupidapp.live.club.model.ClubChatAtUserEvent;
import com.cupidapp.live.club.model.ClubChatGoToNearByMiniProfilePageEvent;
import com.cupidapp.live.club.model.ClubChatMessageSendFailResendEvent;
import com.cupidapp.live.club.model.ClubChatMessageType;
import com.cupidapp.live.club.model.ClubChatMsgModel;
import com.cupidapp.live.club.model.ClubChatPanelType;
import com.cupidapp.live.club.model.ClubInfoDetailModel;
import com.cupidapp.live.club.model.ClubInfoModel;
import com.cupidapp.live.club.model.ClubRedEnvelopeModel;
import com.cupidapp.live.club.model.ClubSendRedPacketEvent;
import com.cupidapp.live.club.model.ClubUserRoleType;
import com.cupidapp.live.club.model.ClubWelcomeConfirmModel;
import com.cupidapp.live.club.model.RedPacketStatus;
import com.cupidapp.live.club.view.ClubChatInputPanelLayout;
import com.cupidapp.live.club.view.ClubChatTopMsgLayout;
import com.cupidapp.live.club.view.ClubWelcomeTipBarLayout;
import com.cupidapp.live.club.view.RedEnvelopeLayout;
import com.cupidapp.live.club.viewholder.OpenRedEnvelopeEvent;
import com.cupidapp.live.club.viewmodel.ClubChatRoomViewModel;
import com.cupidapp.live.maskparty.activity.ChatPhoneAlbumActivity;
import com.cupidapp.live.match.activity.NearByMiniProfileActivity;
import com.cupidapp.live.match.model.NearbyUserModel;
import com.cupidapp.live.mediapicker.model.CameraStartPosition;
import com.cupidapp.live.mediapicker.newmediapicker.fragment.MediaPickerFragment;
import com.cupidapp.live.mediapicker.newmediapicker.model.MediaType;
import com.cupidapp.live.profile.model.User;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.v;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;

/* compiled from: ClubChatRoomFragment.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ClubChatRoomFragment extends FKBaseFragment {

    /* renamed from: n, reason: collision with root package name */
    @NotNull
    public static final a f13553n = new a(null);

    /* renamed from: e, reason: collision with root package name */
    public String f13554e;

    /* renamed from: j, reason: collision with root package name */
    @Nullable
    public KeyboardStatePopupWindow f13559j;

    /* renamed from: l, reason: collision with root package name */
    @Nullable
    public ActivityResultLauncher<Intent> f13561l;

    /* renamed from: m, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f13562m = new LinkedHashMap();

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public final Lazy f13555f = FragmentViewModelLazyKt.createViewModelLazy(this, v.b(ClubChatRoomViewModel.class), new Function0<ViewModelStore>() { // from class: com.cupidapp.live.club.fragment.ClubChatRoomFragment$special$$inlined$activityViewModels$default$1
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final ViewModelStore invoke() {
            FragmentActivity requireActivity = Fragment.this.requireActivity();
            kotlin.jvm.internal.s.h(requireActivity, "requireActivity()");
            ViewModelStore viewModelStore = requireActivity.getViewModelStore();
            kotlin.jvm.internal.s.h(viewModelStore, "requireActivity().viewModelStore");
            return viewModelStore;
        }
    }, new Function0<ViewModelProvider.Factory>() { // from class: com.cupidapp.live.club.fragment.ClubChatRoomFragment$special$$inlined$activityViewModels$default$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final ViewModelProvider.Factory invoke() {
            FragmentActivity requireActivity = Fragment.this.requireActivity();
            kotlin.jvm.internal.s.h(requireActivity, "requireActivity()");
            return requireActivity.getDefaultViewModelProviderFactory();
        }
    });

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public final ClubChatAdapter f13556g = new ClubChatAdapter();

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public final LinearLayoutManager f13557h = new LinearLayoutManager(getContext());

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    public final Lazy f13558i = kotlin.c.b(new Function0<FKDropDownLoadMoreListener>() { // from class: com.cupidapp.live.club.fragment.ClubChatRoomFragment$mLoadMoreListener$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final FKDropDownLoadMoreListener invoke() {
            final ClubChatRoomFragment clubChatRoomFragment = ClubChatRoomFragment.this;
            return new FKDropDownLoadMoreListener(new Function1<Boolean, kotlin.p>() { // from class: com.cupidapp.live.club.fragment.ClubChatRoomFragment$mLoadMoreListener$2.1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ kotlin.p invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return kotlin.p.f51048a;
                }

                public final void invoke(boolean z10) {
                    if (z10) {
                        ClubChatRoomFragment.this.u1().loadMoreUnreadMessage();
                    } else {
                        ClubChatRoomFragment.this.u1().loadMoreHistoryMessage();
                    }
                }
            });
        }
    });

    /* renamed from: k, reason: collision with root package name */
    @NotNull
    public final Lazy f13560k = kotlin.c.b(new Function0<xb.b>() { // from class: com.cupidapp.live.club.fragment.ClubChatRoomFragment$mRxPermissions$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final xb.b invoke() {
            return new xb.b(ClubChatRoomFragment.this);
        }
    });

    /* compiled from: ClubChatRoomFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ClubChatRoomFragment a(@NotNull String clubId) {
            kotlin.jvm.internal.s.i(clubId, "clubId");
            ClubChatRoomFragment clubChatRoomFragment = new ClubChatRoomFragment();
            Bundle bundle = new Bundle();
            bundle.putString("CLUB_ID", clubId);
            clubChatRoomFragment.setArguments(bundle);
            clubChatRoomFragment.f13554e = clubId;
            return clubChatRoomFragment;
        }
    }

    /* compiled from: ClubChatRoomFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f13563a;

        static {
            int[] iArr = new int[LongClickActionType.values().length];
            try {
                iArr[LongClickActionType.Copy.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LongClickActionType.Quote.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LongClickActionType.Cancel.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[LongClickActionType.Delete.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[LongClickActionType.Report.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f13563a = iArr;
        }
    }

    /* compiled from: ClubChatRoomFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class c implements com.cupidapp.live.club.view.h {
        public c() {
        }

        @Override // com.cupidapp.live.club.view.h
        public void a() {
            ClubChatRoomFragment clubChatRoomFragment = ClubChatRoomFragment.this;
            clubChatRoomFragment.J1(clubChatRoomFragment.getContext());
        }

        @Override // com.cupidapp.live.club.view.h
        public void b() {
            ClubChatRoomFragment.this.G1();
        }

        @Override // com.cupidapp.live.club.view.h
        public void c() {
            SendRedPacketFragment.a aVar = SendRedPacketFragment.f13583i;
            FragmentManager parentFragmentManager = ClubChatRoomFragment.this.getParentFragmentManager();
            String str = ClubChatRoomFragment.this.f13554e;
            if (str == null) {
                kotlin.jvm.internal.s.A("mClubId");
                str = null;
            }
            aVar.a(parentFragmentManager, str);
        }

        @Override // com.cupidapp.live.club.view.h
        public void d(@NotNull String textMessage, @Nullable String str, @Nullable ClubChatMsgModel clubChatMsgModel) {
            kotlin.jvm.internal.s.i(textMessage, "textMessage");
            ClubChatRoomViewModel.sendTextMessage$default(ClubChatRoomFragment.this.u1(), textMessage, null, str, clubChatMsgModel, 2, null);
        }

        @Override // com.cupidapp.live.club.view.h
        public void e() {
            ClubChatRoomFragment.this.K1();
        }
    }

    /* compiled from: ClubChatRoomFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class d implements com.cupidapp.live.chat2.helper.i {
        public d() {
        }

        @Override // com.cupidapp.live.chat2.helper.i
        public void a() {
            ((ClubChatInputPanelLayout) ClubChatRoomFragment.this.d1(R$id.club_chat_input_panel_layout)).L();
        }

        @Override // com.cupidapp.live.chat2.helper.i
        public void b(int i10, int i11) {
            ((ClubChatInputPanelLayout) ClubChatRoomFragment.this.d1(R$id.club_chat_input_panel_layout)).K(i10, i11);
        }

        @Override // com.cupidapp.live.chat2.helper.i
        public void c(int i10) {
            ((ClubChatInputPanelLayout) ClubChatRoomFragment.this.d1(R$id.club_chat_input_panel_layout)).M();
        }
    }

    public static final void A1(ClubChatRoomFragment this$0, ClubCancelMsgData data) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        this$0.f13556g.z(data.getMessageId(), data.getMsgModel());
        ClubChatInputPanelLayout clubChatInputPanelLayout = (ClubChatInputPanelLayout) this$0.d1(R$id.club_chat_input_panel_layout);
        kotlin.jvm.internal.s.h(data, "data");
        clubChatInputPanelLayout.r(data);
    }

    public static final void B1(ClubChatRoomFragment this$0, ClubChatMsgModel model) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        ClubChatAdapter clubChatAdapter = this$0.f13556g;
        kotlin.jvm.internal.s.h(model, "model");
        clubChatAdapter.C(model);
    }

    public static final void C1(ClubChatRoomFragment this$0, StateResult stateResult) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        if (stateResult instanceof StateResult.b) {
            ((ConstraintLayout) this$0.d1(R$id.more_message_tips_layout)).setEnabled(false);
            return;
        }
        boolean z10 = true;
        if (stateResult instanceof StateResult.c) {
            ConstraintLayout more_message_tips_layout = (ConstraintLayout) this$0.d1(R$id.more_message_tips_layout);
            kotlin.jvm.internal.s.h(more_message_tips_layout, "more_message_tips_layout");
            more_message_tips_layout.setVisibility(8);
            Collection collection = (Collection) stateResult.getData();
            if (collection != null && !collection.isEmpty()) {
                z10 = false;
            }
            if (z10) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            com.cupidapp.live.club.helper.a aVar = com.cupidapp.live.club.helper.a.f13611a;
            String string = this$0.getString(R$string.the_following_is_new_message);
            kotlin.jvm.internal.s.h(string, "getString(R.string.the_following_is_new_message)");
            arrayList.add(com.cupidapp.live.club.helper.a.c(aVar, string, null, null, 6, null));
            arrayList.addAll((Collection) stateResult.getData());
            this$0.f13556g.y(arrayList);
            ((RecyclerView) this$0.d1(R$id.club_chat_recycler_view)).smoothScrollToPosition(0);
            return;
        }
        if (stateResult instanceof StateResult.a) {
            ((ConstraintLayout) this$0.d1(R$id.more_message_tips_layout)).setEnabled(true);
        }
    }

    public static final void D1(ClubChatRoomFragment this$0, StateResult stateResult) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        if (stateResult instanceof StateResult.b) {
            this$0.f13556g.A(true, false);
            return;
        }
        if (stateResult instanceof StateResult.c) {
            this$0.f13556g.A(false, false);
            ClubChatAdapter clubChatAdapter = this$0.f13556g;
            List list = (List) stateResult.getData();
            clubChatAdapter.w(list != null ? CollectionsKt___CollectionsKt.z0(list) : null);
            this$0.s1().c(false);
            return;
        }
        if (stateResult instanceof StateResult.a) {
            this$0.f13556g.A(false, false);
            this$0.s1().c(false);
        }
    }

    public static final void E1(ClubChatRoomFragment this$0, List list) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        ConstraintLayout new_message_tips_layout = (ConstraintLayout) this$0.d1(R$id.new_message_tips_layout);
        kotlin.jvm.internal.s.h(new_message_tips_layout, "new_message_tips_layout");
        new_message_tips_layout.setVisibility(8);
        this$0.f13556g.u(list != null ? CollectionsKt___CollectionsKt.z0(list) : null, true);
        this$0.K1();
    }

    public static final void H1(ClubChatRoomFragment this$0, ActivityResult activityResult) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        if (activityResult.getResultCode() == -1) {
            Intent data = activityResult.getData();
            ClubChatRoomViewModel.sendImageMessage$default(this$0.u1(), data != null ? data.getStringExtra("CHAT_PREVIEW_SEND_IMAGE_PATH") : null, null, 2, null);
        }
    }

    public static final void I1(ClubChatRoomFragment this$0) {
        ClubChatInputPanelLayout clubChatInputPanelLayout;
        kotlin.jvm.internal.s.i(this$0, "this$0");
        int i10 = R$id.club_chat_input_panel_layout;
        ClubChatInputPanelLayout clubChatInputPanelLayout2 = (ClubChatInputPanelLayout) this$0.d1(i10);
        if ((clubChatInputPanelLayout2 != null && clubChatInputPanelLayout2.P()) || (clubChatInputPanelLayout = (ClubChatInputPanelLayout) this$0.d1(i10)) == null) {
            return;
        }
        clubChatInputPanelLayout.O(ClubChatPanelType.SOFT_KEYBOARD);
    }

    public static final boolean q1(ClubChatRoomFragment this$0, View view, MotionEvent motionEvent) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        view.performClick();
        if (motionEvent.getAction() != 0 || motionEvent.getY() <= ((ClubChatTopMsgLayout) this$0.d1(R$id.club_chat_top_msg_layout)).getBottom()) {
            return false;
        }
        float y10 = motionEvent.getY();
        int i10 = R$id.club_chat_input_panel_layout;
        if (y10 >= ((ClubChatInputPanelLayout) this$0.d1(i10)).getY()) {
            return false;
        }
        ((ClubChatInputPanelLayout) this$0.d1(i10)).N();
        return false;
    }

    public static final void x1(ClubChatRoomFragment this$0, ClubInfoDetailModel clubInfoDetailModel) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        ((ClubChatInputPanelLayout) this$0.d1(R$id.club_chat_input_panel_layout)).setVisibility(0);
        ClubWelcomeConfirmModel confirmTip = clubInfoDetailModel.getConfirmTip();
        String str = null;
        if ((confirmTip != null ? confirmTip.getConciseInfo() : null) == null) {
            ((ClubWelcomeTipBarLayout) this$0.d1(R$id.club_welcome_tip_bar)).setVisibility(8);
            return;
        }
        int i10 = R$id.club_welcome_tip_bar;
        ((ClubWelcomeTipBarLayout) this$0.d1(i10)).setVisibility(0);
        ClubWelcomeTipBarLayout clubWelcomeTipBarLayout = (ClubWelcomeTipBarLayout) this$0.d1(i10);
        String str2 = this$0.f13554e;
        if (str2 == null) {
            kotlin.jvm.internal.s.A("mClubId");
        } else {
            str = str2;
        }
        clubWelcomeTipBarLayout.b(str, clubInfoDetailModel.getConfirmTip(), this$0.O0());
    }

    public static final void y1(final ClubChatRoomFragment this$0, List list) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        ClubChatAdapter clubChatAdapter = this$0.f13556g;
        kotlin.jvm.internal.s.h(list, "list");
        clubChatAdapter.x(CollectionsKt___CollectionsKt.z0(list), new Function0<kotlin.p>() { // from class: com.cupidapp.live.club.fragment.ClubChatRoomFragment$initObserve$3$1
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
                ((ClubChatInputPanelLayout) ClubChatRoomFragment.this.d1(R$id.club_chat_input_panel_layout)).Q();
            }
        });
        ClubChatMsgModel clubChatMsgModel = (ClubChatMsgModel) CollectionsKt___CollectionsKt.f0(list);
        if (kotlin.jvm.internal.s.d(clubChatMsgModel != null ? clubChatMsgModel.getType() : null, ClubChatMessageType.InboxMessageText.getValue())) {
            this$0.L1(clubChatMsgModel.getText());
        }
        boolean z10 = true;
        if (!(clubChatMsgModel != null && clubChatMsgModel.getMine()) && this$0.f13557h.getItemCount() - 5 > this$0.f13557h.findLastVisibleItemPosition()) {
            z10 = false;
        }
        if (z10) {
            ConstraintLayout new_message_tips_layout = (ConstraintLayout) this$0.d1(R$id.new_message_tips_layout);
            kotlin.jvm.internal.s.h(new_message_tips_layout, "new_message_tips_layout");
            new_message_tips_layout.setVisibility(8);
            this$0.K1();
        }
    }

    public static final void z1(ClubChatRoomFragment this$0, Pair pair) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        this$0.f13556g.K(((Number) pair.getFirst()).longValue(), (ClubChatMsgModel) pair.getSecond());
    }

    public final void F1() {
        String str;
        ClubChatRoomViewModel u12 = u1();
        String str2 = this.f13554e;
        if (str2 == null) {
            kotlin.jvm.internal.s.A("mClubId");
            str2 = null;
        }
        u12.initClubInfo(str2);
        ClubChatInputPanelLayout clubChatInputPanelLayout = (ClubChatInputPanelLayout) d1(R$id.club_chat_input_panel_layout);
        ClubChatTopMsgLayout club_chat_top_msg_layout = (ClubChatTopMsgLayout) d1(R$id.club_chat_top_msg_layout);
        kotlin.jvm.internal.s.h(club_chat_top_msg_layout, "club_chat_top_msg_layout");
        int i10 = R$id.club_chat_recycler_view;
        RecyclerView club_chat_recycler_view = (RecyclerView) d1(i10);
        kotlin.jvm.internal.s.h(club_chat_recycler_view, "club_chat_recycler_view");
        ChatEmojiPagerLayout club_chat_emoji_pager_layout = (ChatEmojiPagerLayout) d1(R$id.club_chat_emoji_pager_layout);
        kotlin.jvm.internal.s.h(club_chat_emoji_pager_layout, "club_chat_emoji_pager_layout");
        FKSVGAImageView club_chat_emoji_svga = (FKSVGAImageView) d1(R$id.club_chat_emoji_svga);
        kotlin.jvm.internal.s.h(club_chat_emoji_svga, "club_chat_emoji_svga");
        String str3 = this.f13554e;
        if (str3 == null) {
            kotlin.jvm.internal.s.A("mClubId");
            str = null;
        } else {
            str = str3;
        }
        clubChatInputPanelLayout.H(club_chat_top_msg_layout, club_chat_recycler_view, club_chat_emoji_pager_layout, club_chat_emoji_svga, str);
        u1().loadFirstScreenHistoryMsg();
        RecyclerView recyclerView = (RecyclerView) d1(i10);
        recyclerView.setItemAnimator(null);
        recyclerView.setAdapter(this.f13556g);
        recyclerView.setLayoutManager(this.f13557h);
        recyclerView.addOnScrollListener(s1());
        s1().d(new RecyclerView.OnScrollListener() { // from class: com.cupidapp.live.club.fragment.ClubChatRoomFragment$initView$1$1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(@NotNull RecyclerView recyclerView2, int i11, int i12) {
                LinearLayoutManager linearLayoutManager;
                LinearLayoutManager linearLayoutManager2;
                LinearLayoutManager linearLayoutManager3;
                ClubChatAdapter clubChatAdapter;
                ClubChatAdapter clubChatAdapter2;
                kotlin.jvm.internal.s.i(recyclerView2, "recyclerView");
                String firstUnreadMsgId = ClubChatRoomFragment.this.u1().getFirstUnreadMsgId();
                ClubChatRoomFragment clubChatRoomFragment = ClubChatRoomFragment.this;
                int i13 = R$id.more_message_tips_layout;
                ConstraintLayout more_message_tips_layout = (ConstraintLayout) clubChatRoomFragment.d1(i13);
                kotlin.jvm.internal.s.h(more_message_tips_layout, "more_message_tips_layout");
                if ((more_message_tips_layout.getVisibility() == 0) && i12 < 0) {
                    if (!(firstUnreadMsgId == null || firstUnreadMsgId.length() == 0)) {
                        linearLayoutManager3 = ClubChatRoomFragment.this.f13557h;
                        int findFirstVisibleItemPosition = linearLayoutManager3.findFirstVisibleItemPosition();
                        if (findFirstVisibleItemPosition >= 0) {
                            clubChatAdapter = ClubChatRoomFragment.this.f13556g;
                            if (findFirstVisibleItemPosition < clubChatAdapter.j().size()) {
                                clubChatAdapter2 = ClubChatRoomFragment.this.f13556g;
                                Object obj = clubChatAdapter2.j().get(findFirstVisibleItemPosition);
                                ClubChatMsgModel clubChatMsgModel = obj instanceof ClubChatMsgModel ? (ClubChatMsgModel) obj : null;
                                if (kotlin.jvm.internal.s.d(clubChatMsgModel != null ? clubChatMsgModel.getMessageId() : null, firstUnreadMsgId)) {
                                    ConstraintLayout more_message_tips_layout2 = (ConstraintLayout) ClubChatRoomFragment.this.d1(i13);
                                    kotlin.jvm.internal.s.h(more_message_tips_layout2, "more_message_tips_layout");
                                    more_message_tips_layout2.setVisibility(8);
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    }
                }
                ClubChatRoomFragment clubChatRoomFragment2 = ClubChatRoomFragment.this;
                int i14 = R$id.new_message_tips_layout;
                ConstraintLayout new_message_tips_layout = (ConstraintLayout) clubChatRoomFragment2.d1(i14);
                kotlin.jvm.internal.s.h(new_message_tips_layout, "new_message_tips_layout");
                if (!(new_message_tips_layout.getVisibility() == 0) || i12 <= 0) {
                    return;
                }
                linearLayoutManager = ClubChatRoomFragment.this.f13557h;
                int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
                linearLayoutManager2 = ClubChatRoomFragment.this.f13557h;
                if (findLastVisibleItemPosition == linearLayoutManager2.getItemCount() - 1) {
                    ConstraintLayout new_message_tips_layout2 = (ConstraintLayout) ClubChatRoomFragment.this.d1(i14);
                    kotlin.jvm.internal.s.h(new_message_tips_layout2, "new_message_tips_layout");
                    new_message_tips_layout2.setVisibility(8);
                }
            }
        });
    }

    public final void G1() {
        if (u1().canLoadMoreUnread()) {
            u1().loadLatestNewMessage();
            return;
        }
        ConstraintLayout new_message_tips_layout = (ConstraintLayout) d1(R$id.new_message_tips_layout);
        kotlin.jvm.internal.s.h(new_message_tips_layout, "new_message_tips_layout");
        new_message_tips_layout.setVisibility(8);
        K1();
    }

    public final void J1(final Context context) {
        if (context == null) {
            return;
        }
        z0.h.q(context, null, 1, null);
        FKRxPermissionAlertDialog.Companion.n(FKRxPermissionAlertDialog.f12016a, context, t1(), new Function0<kotlin.p>() { // from class: com.cupidapp.live.club.fragment.ClubChatRoomFragment$openAlbum$1
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
                ActivityResultLauncher<Intent> activityResultLauncher;
                activityResultLauncher = ClubChatRoomFragment.this.f13561l;
                if (activityResultLauncher != null) {
                    ClubChatRoomFragment clubChatRoomFragment = ClubChatRoomFragment.this;
                    ChatPhoneAlbumActivity.f16226v.a(context, activityResultLauncher, new MediaPickerFragment.Config(MediaType.IMAGE, true, false, false, false, CameraStartPosition.Chat, clubChatRoomFragment.O0(), null, 152, null), null, false);
                }
            }
        }, null, null, 0, 56, null);
    }

    public final void K1() {
        Integer G = this.f13556g.G();
        if (G != null) {
            ((RecyclerView) d1(R$id.club_chat_recycler_view)).scrollToPosition(G.intValue());
        }
    }

    public final void L1(String str) {
        boolean z10 = true;
        if (str == null || str.length() == 0) {
            return;
        }
        String b4 = w1.a.f54094a.b(str);
        if (b4 != null && b4.length() != 0) {
            z10 = false;
        }
        if (z10) {
            return;
        }
        int i10 = R$id.club_chat_emoji_svga;
        if (((FKSVGAImageView) d1(i10)) != null) {
            ((FKSVGAImageView) d1(i10)).K();
            ((FKSVGAImageView) d1(i10)).setVisibility(0);
            FKSVGAImageView club_chat_emoji_svga = (FKSVGAImageView) d1(i10);
            kotlin.jvm.internal.s.h(club_chat_emoji_svga, "club_chat_emoji_svga");
            FKSVGAImageView.F(club_chat_emoji_svga, b4, null, new Function0<kotlin.p>() { // from class: com.cupidapp.live.club.fragment.ClubChatRoomFragment$showEmojiSVGAAnimation$1
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
                    FKSVGAImageView fKSVGAImageView = (FKSVGAImageView) ClubChatRoomFragment.this.d1(R$id.club_chat_emoji_svga);
                    if (fKSVGAImageView == null) {
                        return;
                    }
                    fKSVGAImageView.setVisibility(8);
                }
            }, 2, null);
        }
    }

    public final void M1(String str) {
        Object obj;
        Pair<Integer, Integer> b4 = c0.b(this.f13557h);
        if (b4 == null) {
            return;
        }
        String firstUnreadMsgId = u1().getFirstUnreadMsgId();
        boolean z10 = true;
        if (firstUnreadMsgId == null || firstUnreadMsgId.length() == 0) {
            return;
        }
        List<Object> subList = this.f13556g.j().subList(b4.getFirst().intValue(), b4.getSecond().intValue());
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : subList) {
            if (obj2 instanceof ClubChatMsgModel) {
                arrayList.add(obj2);
            }
        }
        Iterator<E> iterator2 = arrayList.iterator2();
        while (true) {
            if (iterator2.hasNext()) {
                obj = iterator2.next();
                if (kotlin.jvm.internal.s.d(((ClubChatMsgModel) obj).getMessageId(), firstUnreadMsgId)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        if (((ClubChatMsgModel) obj) == null) {
            if (str != null && str.length() != 0) {
                z10 = false;
            }
            if (!z10) {
                ConstraintLayout more_message_tips_layout = (ConstraintLayout) d1(R$id.more_message_tips_layout);
                kotlin.jvm.internal.s.h(more_message_tips_layout, "more_message_tips_layout");
                more_message_tips_layout.setVisibility(0);
                ((TextView) d1(R$id.more_message_tips_textview)).setText(str);
                SensorsLogKeyButtonClick.ClubGroupChat.UnreadMessage.show();
                return;
            }
        }
        ConstraintLayout more_message_tips_layout2 = (ConstraintLayout) d1(R$id.more_message_tips_layout);
        kotlin.jvm.internal.s.h(more_message_tips_layout2, "more_message_tips_layout");
        more_message_tips_layout2.setVisibility(8);
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment
    public void N0() {
        this.f13562m.clear();
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment
    @NotNull
    public SensorPosition O0() {
        return SensorPosition.ClubGroupChat;
    }

    @Nullable
    public View d1(int i10) {
        View findViewById;
        Map<Integer, View> map = this.f13562m;
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

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment
    public boolean onBackPressed() {
        ClubChatInputPanelLayout clubChatInputPanelLayout = (ClubChatInputPanelLayout) d1(R$id.club_chat_input_panel_layout);
        boolean q10 = clubChatInputPanelLayout != null ? clubChatInputPanelLayout.q() : false;
        if (!q10) {
            a2.a u10 = NetworkClient.f11868a.u();
            String str = this.f13554e;
            if (str == null) {
                kotlin.jvm.internal.s.A("mClubId");
                str = null;
            }
            Disposable disposed = u10.h(str).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.club.fragment.ClubChatRoomFragment$onBackPressed$$inlined$handle$default$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ kotlin.p invoke(Object obj) {
                    invoke2(obj);
                    return kotlin.p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object obj) {
                }
            }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, this)));
            if (disposed != null) {
                kotlin.jvm.internal.s.h(disposed, "disposed");
                H(disposed);
            }
            kotlin.jvm.internal.s.h(disposed, "disposed");
        }
        return q10;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.f13561l = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.cupidapp.live.club.fragment.g
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                ClubChatRoomFragment.H1(ClubChatRoomFragment.this, (ActivityResult) obj);
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        kotlin.jvm.internal.s.i(inflater, "inflater");
        return inflater.inflate(R$layout.fragment_club_chat_room, viewGroup, false);
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        N0();
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0093 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0021 A[SYNTHETIC] */
    @he.j(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onEvent(@org.jetbrains.annotations.NotNull com.cupidapp.live.club.model.ClubChatMsgBindLongClickEvent r6) {
        /*
            r5 = this;
            java.lang.String r0 = "event"
            kotlin.jvm.internal.s.i(r6, r0)
            com.cupidapp.live.club.model.ClubChatMsgModel r0 = r6.getModel()
            java.util.ArrayList r1 = r6.getActions()
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L14
            return
        L14:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.ArrayList r6 = r6.getActions()
            java.util.Iterator r6 = r6.iterator2()
        L21:
            boolean r2 = r6.hasNext()
            if (r2 == 0) goto L97
            java.lang.Object r2 = r6.next()
            com.cupidapp.live.chat2.model.LongClickActionType r2 = (com.cupidapp.live.chat2.model.LongClickActionType) r2
            int[] r3 = com.cupidapp.live.club.fragment.ClubChatRoomFragment.b.f13563a
            int r4 = r2.ordinal()
            r3 = r3[r4]
            r4 = 1
            if (r3 == r4) goto L82
            r4 = 2
            if (r3 == r4) goto L73
            r4 = 3
            if (r3 == r4) goto L64
            r4 = 4
            if (r3 == r4) goto L55
            r4 = 5
            if (r3 == r4) goto L46
            r2 = 0
            goto L91
        L46:
            com.cupidapp.live.base.view.dialog.FKActionItemModel r3 = new com.cupidapp.live.base.view.dialog.FKActionItemModel
            int r2 = r2.getResId()
            com.cupidapp.live.club.fragment.ClubChatRoomFragment$onEvent$1$item$5 r4 = new com.cupidapp.live.club.fragment.ClubChatRoomFragment$onEvent$1$item$5
            r4.<init>()
            r3.<init>(r2, r4)
            goto L90
        L55:
            com.cupidapp.live.base.view.dialog.FKActionItemModel r3 = new com.cupidapp.live.base.view.dialog.FKActionItemModel
            int r2 = r2.getResId()
            com.cupidapp.live.club.fragment.ClubChatRoomFragment$onEvent$1$item$4 r4 = new com.cupidapp.live.club.fragment.ClubChatRoomFragment$onEvent$1$item$4
            r4.<init>()
            r3.<init>(r2, r4)
            goto L90
        L64:
            com.cupidapp.live.base.view.dialog.FKActionItemModel r3 = new com.cupidapp.live.base.view.dialog.FKActionItemModel
            int r2 = r2.getResId()
            com.cupidapp.live.club.fragment.ClubChatRoomFragment$onEvent$1$item$3 r4 = new com.cupidapp.live.club.fragment.ClubChatRoomFragment$onEvent$1$item$3
            r4.<init>()
            r3.<init>(r2, r4)
            goto L90
        L73:
            com.cupidapp.live.base.view.dialog.FKActionItemModel r3 = new com.cupidapp.live.base.view.dialog.FKActionItemModel
            int r2 = r2.getResId()
            com.cupidapp.live.club.fragment.ClubChatRoomFragment$onEvent$1$item$2 r4 = new com.cupidapp.live.club.fragment.ClubChatRoomFragment$onEvent$1$item$2
            r4.<init>()
            r3.<init>(r2, r4)
            goto L90
        L82:
            com.cupidapp.live.base.view.dialog.FKActionItemModel r3 = new com.cupidapp.live.base.view.dialog.FKActionItemModel
            int r2 = r2.getResId()
            com.cupidapp.live.club.fragment.ClubChatRoomFragment$onEvent$1$item$1 r4 = new com.cupidapp.live.club.fragment.ClubChatRoomFragment$onEvent$1$item$1
            r4.<init>()
            r3.<init>(r2, r4)
        L90:
            r2 = r3
        L91:
            if (r2 == 0) goto L21
            r1.add(r2)
            goto L21
        L97:
            com.cupidapp.live.base.view.dialog.FKActionItemDialog$a r6 = com.cupidapp.live.base.view.dialog.FKActionItemDialog.f12688e
            android.content.Context r0 = r5.getContext()
            com.cupidapp.live.base.view.dialog.FKActionItemDialog r6 = r6.a(r0)
            com.cupidapp.live.base.view.dialog.FKActionItemDialog r6 = r6.d(r1)
            r6.e()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.club.fragment.ClubChatRoomFragment.onEvent(com.cupidapp.live.club.model.ClubChatMsgBindLongClickEvent):void");
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        com.cupidapp.live.push.d.f17892a.i(false);
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        com.cupidapp.live.push.d.f17892a.i(true);
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        kotlin.jvm.internal.s.i(view, "view");
        super.onViewCreated(view, bundle);
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString("CLUB_ID") : null;
        if (!(string == null || string.length() == 0)) {
            this.f13554e = string;
        }
        if (this.f13554e == null) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
                return;
            }
            return;
        }
        F1();
        w1();
        p1();
        v1();
    }

    public final void p1() {
        ((ClubChatInputPanelLayout) d1(R$id.club_chat_input_panel_layout)).setListener(new c());
        ((ConstraintLayout) d1(R$id.club_chat_room_root_layout)).setOnTouchListener(new View.OnTouchListener() { // from class: com.cupidapp.live.club.fragment.e
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean q12;
                q12 = ClubChatRoomFragment.q1(ClubChatRoomFragment.this, view, motionEvent);
                return q12;
            }
        });
        ConstraintLayout more_message_tips_layout = (ConstraintLayout) d1(R$id.more_message_tips_layout);
        kotlin.jvm.internal.s.h(more_message_tips_layout, "more_message_tips_layout");
        y.d(more_message_tips_layout, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.club.fragment.ClubChatRoomFragment$bindClickEvent$3
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
                ClubChatAdapter clubChatAdapter;
                Object obj;
                ClubChatAdapter clubChatAdapter2;
                ClubChatAdapter clubChatAdapter3;
                SensorsLogKeyButtonClick.ClubGroupChat.UnreadMessage.click();
                String firstUnreadMsgId = ClubChatRoomFragment.this.u1().getFirstUnreadMsgId();
                if (!(firstUnreadMsgId == null || firstUnreadMsgId.length() == 0)) {
                    clubChatAdapter = ClubChatRoomFragment.this.f13556g;
                    List<Object> j10 = clubChatAdapter.j();
                    ArrayList arrayList = new ArrayList();
                    for (Object obj2 : j10) {
                        if (obj2 instanceof ClubChatMsgModel) {
                            arrayList.add(obj2);
                        }
                    }
                    Iterator<E> iterator2 = arrayList.iterator2();
                    while (true) {
                        if (iterator2.hasNext()) {
                            obj = iterator2.next();
                            if (kotlin.jvm.internal.s.d(((ClubChatMsgModel) obj).getMessageId(), firstUnreadMsgId)) {
                                break;
                            }
                        } else {
                            obj = null;
                            break;
                        }
                    }
                    ClubChatMsgModel clubChatMsgModel = (ClubChatMsgModel) obj;
                    if (clubChatMsgModel != null) {
                        clubChatAdapter2 = ClubChatRoomFragment.this.f13556g;
                        int indexOf = clubChatAdapter2.j().indexOf(clubChatMsgModel);
                        clubChatAdapter3 = ClubChatRoomFragment.this.f13556g;
                        com.cupidapp.live.club.helper.a aVar = com.cupidapp.live.club.helper.a.f13611a;
                        String string = ClubChatRoomFragment.this.getString(R$string.the_following_is_new_message);
                        kotlin.jvm.internal.s.h(string, "getString(R.string.the_following_is_new_message)");
                        clubChatAdapter3.H(com.cupidapp.live.club.helper.a.c(aVar, string, null, null, 6, null), indexOf);
                        ((RecyclerView) ClubChatRoomFragment.this.d1(R$id.club_chat_recycler_view)).smoothScrollToPosition(indexOf);
                        ConstraintLayout more_message_tips_layout2 = (ConstraintLayout) ClubChatRoomFragment.this.d1(R$id.more_message_tips_layout);
                        kotlin.jvm.internal.s.h(more_message_tips_layout2, "more_message_tips_layout");
                        more_message_tips_layout2.setVisibility(8);
                        return;
                    }
                }
                ClubChatRoomFragment.this.u1().loadFirstPageUnreadMessage();
            }
        });
        ConstraintLayout new_message_tips_layout = (ConstraintLayout) d1(R$id.new_message_tips_layout);
        kotlin.jvm.internal.s.h(new_message_tips_layout, "new_message_tips_layout");
        y.d(new_message_tips_layout, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.club.fragment.ClubChatRoomFragment$bindClickEvent$4
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
                SensorsLogKeyButtonClick.ClubGroupChat.NewMessage.click();
                ClubChatRoomFragment.this.G1();
            }
        });
    }

    public final void r1() {
        ClubChatInputPanelLayout clubChatInputPanelLayout = (ClubChatInputPanelLayout) d1(R$id.club_chat_input_panel_layout);
        if (clubChatInputPanelLayout != null) {
            clubChatInputPanelLayout.q();
        }
    }

    public final FKDropDownLoadMoreListener s1() {
        return (FKDropDownLoadMoreListener) this.f13558i.getValue();
    }

    public final xb.b t1() {
        return (xb.b) this.f13560k.getValue();
    }

    public final ClubChatRoomViewModel u1() {
        return (ClubChatRoomViewModel) this.f13555f.getValue();
    }

    public final void v1() {
        Context context = getContext();
        ConstraintLayout club_chat_room_root_layout = (ConstraintLayout) d1(R$id.club_chat_room_root_layout);
        kotlin.jvm.internal.s.h(club_chat_room_root_layout, "club_chat_room_root_layout");
        KeyboardStatePopupWindow keyboardStatePopupWindow = new KeyboardStatePopupWindow(context, this, club_chat_room_root_layout);
        this.f13559j = keyboardStatePopupWindow;
        keyboardStatePopupWindow.c(new d());
    }

    public final void w1() {
        u1().getFirstScreenHistoryMsg().observe(getViewLifecycleOwner(), new EventObserver(new ClubChatRoomFragment$initObserve$1(this)));
        u1().getMoreHistoryMsg().observe(getViewLifecycleOwner(), new EventObserver(new Function1<StateResult<List<? extends ClubChatMsgModel>>, kotlin.p>() { // from class: com.cupidapp.live.club.fragment.ClubChatRoomFragment$initObserve$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(StateResult<List<? extends ClubChatMsgModel>> stateResult) {
                invoke2((StateResult<List<ClubChatMsgModel>>) stateResult);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull StateResult<List<ClubChatMsgModel>> result) {
                ClubChatAdapter clubChatAdapter;
                FKDropDownLoadMoreListener s12;
                ClubChatAdapter clubChatAdapter2;
                ClubChatAdapter clubChatAdapter3;
                FKDropDownLoadMoreListener s13;
                ClubChatAdapter clubChatAdapter4;
                kotlin.jvm.internal.s.i(result, "result");
                if (result instanceof StateResult.b) {
                    clubChatAdapter4 = ClubChatRoomFragment.this.f13556g;
                    ClubChatAdapter.B(clubChatAdapter4, true, false, 2, null);
                    return;
                }
                if (result instanceof StateResult.c) {
                    clubChatAdapter2 = ClubChatRoomFragment.this.f13556g;
                    ClubChatAdapter.B(clubChatAdapter2, false, false, 2, null);
                    clubChatAdapter3 = ClubChatRoomFragment.this.f13556g;
                    List<ClubChatMsgModel> data = result.getData();
                    ClubChatAdapter.v(clubChatAdapter3, data != null ? CollectionsKt___CollectionsKt.z0(data) : null, false, 2, null);
                    s13 = ClubChatRoomFragment.this.s1();
                    s13.c(false);
                    return;
                }
                if (result instanceof StateResult.a) {
                    clubChatAdapter = ClubChatRoomFragment.this.f13556g;
                    ClubChatAdapter.B(clubChatAdapter, false, false, 2, null);
                    s12 = ClubChatRoomFragment.this.s1();
                    s12.c(false);
                }
            }
        }));
        u1().getNewMessage().observe(getViewLifecycleOwner(), new Observer() { // from class: com.cupidapp.live.club.fragment.n
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ClubChatRoomFragment.y1(ClubChatRoomFragment.this, (List) obj);
            }
        });
        u1().getReplaceMessage().observe(getViewLifecycleOwner(), new Observer() { // from class: com.cupidapp.live.club.fragment.o
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ClubChatRoomFragment.z1(ClubChatRoomFragment.this, (Pair) obj);
            }
        });
        u1().getCancelMessage().observe(getViewLifecycleOwner(), new Observer() { // from class: com.cupidapp.live.club.fragment.j
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ClubChatRoomFragment.A1(ClubChatRoomFragment.this, (ClubCancelMsgData) obj);
            }
        });
        u1().getDeleteMessage().observe(getViewLifecycleOwner(), new Observer() { // from class: com.cupidapp.live.club.fragment.k
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ClubChatRoomFragment.B1(ClubChatRoomFragment.this, (ClubChatMsgModel) obj);
            }
        });
        u1().getNotifyGetNewMessage().observe(getViewLifecycleOwner(), new EventObserver(new Function1<Boolean, kotlin.p>() { // from class: com.cupidapp.live.club.fragment.ClubChatRoomFragment$initObserve$7
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return kotlin.p.f51048a;
            }

            public final void invoke(boolean z10) {
                LinearLayoutManager linearLayoutManager;
                LinearLayoutManager linearLayoutManager2;
                ClubChatAdapter clubChatAdapter;
                if (z10) {
                    clubChatAdapter = ClubChatRoomFragment.this.f13556g;
                    ClubChatRoomFragment.this.u1().loadNewestMessage(clubChatAdapter.F());
                }
                linearLayoutManager = ClubChatRoomFragment.this.f13557h;
                int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
                linearLayoutManager2 = ClubChatRoomFragment.this.f13557h;
                int itemCount = linearLayoutManager2.getItemCount();
                if (z10 && findLastVisibleItemPosition >= itemCount - 4) {
                    ConstraintLayout new_message_tips_layout = (ConstraintLayout) ClubChatRoomFragment.this.d1(R$id.new_message_tips_layout);
                    kotlin.jvm.internal.s.h(new_message_tips_layout, "new_message_tips_layout");
                    new_message_tips_layout.setVisibility(8);
                    return;
                }
                ClubChatRoomFragment clubChatRoomFragment = ClubChatRoomFragment.this;
                int i10 = R$id.new_message_tips_layout;
                ConstraintLayout new_message_tips_layout2 = (ConstraintLayout) clubChatRoomFragment.d1(i10);
                kotlin.jvm.internal.s.h(new_message_tips_layout2, "new_message_tips_layout");
                if (!(new_message_tips_layout2.getVisibility() == 0)) {
                    SensorsLogKeyButtonClick.ClubGroupChat.NewMessage.show();
                }
                ConstraintLayout new_message_tips_layout3 = (ConstraintLayout) ClubChatRoomFragment.this.d1(i10);
                kotlin.jvm.internal.s.h(new_message_tips_layout3, "new_message_tips_layout");
                new_message_tips_layout3.setVisibility(0);
            }
        }));
        u1().getTopMessage().observe(getViewLifecycleOwner(), new EventObserver(new Function1<String, kotlin.p>() { // from class: com.cupidapp.live.club.fragment.ClubChatRoomFragment$initObserve$8
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(String str) {
                invoke2(str);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable String str) {
                ClubChatTopMsgLayout clubChatTopMsgLayout = (ClubChatTopMsgLayout) ClubChatRoomFragment.this.d1(R$id.club_chat_top_msg_layout);
                String str2 = ClubChatRoomFragment.this.f13554e;
                if (str2 == null) {
                    kotlin.jvm.internal.s.A("mClubId");
                    str2 = null;
                }
                clubChatTopMsgLayout.setTopMsg(str, str2, null);
            }
        }));
        u1().getFirstPageUnreadMessageLiveData().observe(getViewLifecycleOwner(), new Observer() { // from class: com.cupidapp.live.club.fragment.i
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ClubChatRoomFragment.C1(ClubChatRoomFragment.this, (StateResult) obj);
            }
        });
        u1().getMoreUnreadMessageEventLiveData().observe(getViewLifecycleOwner(), new Observer() { // from class: com.cupidapp.live.club.fragment.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ClubChatRoomFragment.D1(ClubChatRoomFragment.this, (StateResult) obj);
            }
        });
        u1().getLatestNewMessageLiveData().observe(getViewLifecycleOwner(), new Observer() { // from class: com.cupidapp.live.club.fragment.m
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ClubChatRoomFragment.E1(ClubChatRoomFragment.this, (List) obj);
            }
        });
        u1().getClubInfo().observe(getViewLifecycleOwner(), new Observer() { // from class: com.cupidapp.live.club.fragment.l
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ClubChatRoomFragment.x1(ClubChatRoomFragment.this, (ClubInfoDetailModel) obj);
            }
        });
    }

    @he.j(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull ChatTouchMessageListCloseAllPanelEvent event) {
        kotlin.jvm.internal.s.i(event, "event");
        ((ClubChatInputPanelLayout) d1(R$id.club_chat_input_panel_layout)).N();
    }

    @he.j(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull OpenRedEnvelopeEvent event) {
        String str;
        kotlin.jvm.internal.s.i(event, "event");
        final ClubChatMsgModel message = event.getMessage();
        if (message.getRedPacketId() != null) {
            String str2 = this.f13554e;
            if (str2 == null) {
                kotlin.jvm.internal.s.A("mClubId");
                str = null;
            } else {
                str = str2;
            }
            String redPacketId = message.getRedPacketId();
            User sender = message.getSender();
            ImageModel avatarImage = sender != null ? sender.getAvatarImage() : null;
            User sender2 = message.getSender();
            String name = sender2 != null ? sender2.getName() : null;
            ImageModel giftIcon = message.getGiftIcon();
            String title = message.getTitle();
            Integer status = message.getStatus();
            RedEnvelopeLayout.f13664f.a(getContext(), new ClubRedEnvelopeModel(str, redPacketId, avatarImage, name, giftIcon, title, status == null || status.intValue() != RedPacketStatus.UnOpened.getStatus()), new Function1<Integer, kotlin.p>() { // from class: com.cupidapp.live.club.fragment.ClubChatRoomFragment$onEvent$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ kotlin.p invoke(Integer num) {
                    invoke(num.intValue());
                    return kotlin.p.f51048a;
                }

                public final void invoke(int i10) {
                    ClubChatAdapter clubChatAdapter;
                    clubChatAdapter = ClubChatRoomFragment.this.f13556g;
                    clubChatAdapter.J(message, i10);
                }
            });
        }
    }

    @he.j(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull ChatClickReEditBtnEvent event) {
        kotlin.jvm.internal.s.i(event, "event");
        ((ClubChatInputPanelLayout) d1(R$id.club_chat_input_panel_layout)).n(event.getCancelMessage(), true);
    }

    @he.j(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull ClubSendRedPacketEvent event) {
        kotlin.jvm.internal.s.i(event, "event");
        u1().loadNewestMessage(this.f13556g.F());
    }

    @he.j(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull ClubChatMessageSendFailResendEvent event) {
        kotlin.jvm.internal.s.i(event, "event");
        u1().resendMessage(event.getFailModel());
    }

    @he.j(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull ClubChatGoToNearByMiniProfilePageEvent event) {
        ClubInfoDetailModel m2515getClubInfo;
        kotlin.jvm.internal.s.i(event, "event");
        User user = event.getUser();
        if (user == null || (m2515getClubInfo = u1().m2515getClubInfo()) == null) {
            return;
        }
        NearByMiniProfileActivity.a.b(NearByMiniProfileActivity.f16517r, getContext(), new NearbyUserModel(user.userId(), false, false, false, false, false, user.getAvatarImage(), user.getName(), null, null, false, false, false, null, null, null, null, false, false, false, null, 2096958, null), SensorScene.GroupChat, false, null, false, null, null, null, new ClubInfoModel(ClubUserRoleType.Companion.b(m2515getClubInfo.getUserRole()), m2515getClubInfo.getId(), m2515getClubInfo.getName()), false, MetricsProto.MetricsEvent.FIELD_INTENT_ACTION, null);
    }

    @he.j(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull ClubChatAtUserEvent event) {
        kotlin.jvm.internal.s.i(event, "event");
        User user = event.getUser();
        if (user == null) {
            return;
        }
        if (((ClubWelcomeTipBarLayout) d1(R$id.club_welcome_tip_bar)).getVisibility() == 0) {
            com.cupidapp.live.base.view.h.f12779a.l(getContext(), R$string.confirm_tip_before_at);
            return;
        }
        int i10 = R$id.club_chat_input_panel_layout;
        ClubChatInputPanelLayout clubChatInputPanelLayout = (ClubChatInputPanelLayout) d1(i10);
        if (clubChatInputPanelLayout != null) {
            clubChatInputPanelLayout.m(user, false);
        }
        ClubChatInputPanelLayout clubChatInputPanelLayout2 = (ClubChatInputPanelLayout) d1(i10);
        if (clubChatInputPanelLayout2 != null) {
            clubChatInputPanelLayout2.postDelayed(new Runnable() { // from class: com.cupidapp.live.club.fragment.f
                @Override // java.lang.Runnable
                public final void run() {
                    ClubChatRoomFragment.I1(ClubChatRoomFragment.this);
                }
            }, 300L);
        }
    }
}

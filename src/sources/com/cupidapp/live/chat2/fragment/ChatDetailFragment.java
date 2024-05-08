package com.cupidapp.live.chat2.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.fragment.FKBaseFragment;
import com.cupidapp.live.base.livedata.EventObserver;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.RequestErrorCode;
import com.cupidapp.live.base.network.model.ConstantsResult;
import com.cupidapp.live.base.network.model.ConstantsUrlModel;
import com.cupidapp.live.base.network.model.LinkDictModel;
import com.cupidapp.live.base.network.model.ListResult;
import com.cupidapp.live.base.network.model.StateResult;
import com.cupidapp.live.base.network.model.ViewProfilePrefer;
import com.cupidapp.live.base.permission.FKRxPermissionAlertDialog;
import com.cupidapp.live.base.recyclerview.helper.ExposureScene;
import com.cupidapp.live.base.recyclerview.helper.FKDropDownLoadMoreListener;
import com.cupidapp.live.base.recyclerview.helper.RecyclerExposureHelper;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.base.sensorslog.FKSensorContext;
import com.cupidapp.live.base.sensorslog.FeedSensorContext;
import com.cupidapp.live.base.sensorslog.PopupName;
import com.cupidapp.live.base.sensorslog.ProfileSensorContext;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorScene;
import com.cupidapp.live.base.sensorslog.SensorsLogFeed;
import com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick;
import com.cupidapp.live.base.utils.n0;
import com.cupidapp.live.base.utils.o;
import com.cupidapp.live.base.view.animation.FKSVGAImageView;
import com.cupidapp.live.base.view.dialog.ActionSheetItemType;
import com.cupidapp.live.base.view.dialog.FKActionItemDialog;
import com.cupidapp.live.base.view.dialog.FKActionItemModel;
import com.cupidapp.live.base.view.dialog.FKActionSheetDialog;
import com.cupidapp.live.base.view.dialog.FKActionSheetItemModel;
import com.cupidapp.live.base.view.dialog.FKAlertDialog;
import com.cupidapp.live.chat2.activity.ChatLookSnapImageActivity;
import com.cupidapp.live.chat2.adapter.ChatDetailAdapter;
import com.cupidapp.live.chat2.helper.ChatDetailAnimationHelper;
import com.cupidapp.live.chat2.helper.KeyboardStatePopupWindow;
import com.cupidapp.live.chat2.holder.ChatOtherStoryLabelUiModel;
import com.cupidapp.live.chat2.model.ChatBundleData;
import com.cupidapp.live.chat2.model.ChatClickReEditBtnEvent;
import com.cupidapp.live.chat2.model.ChatFocusStateData;
import com.cupidapp.live.chat2.model.ChatGoToFeedDetailPageEvent;
import com.cupidapp.live.chat2.model.ChatGoToPostLimitDetailPageEvent;
import com.cupidapp.live.chat2.model.ChatGoToProfilePageEvent;
import com.cupidapp.live.chat2.model.ChatGuideGrpcModel;
import com.cupidapp.live.chat2.model.ChatGuideType;
import com.cupidapp.live.chat2.model.ChatLookSnapImgInsertScreenShotNoticeEvent;
import com.cupidapp.live.chat2.model.ChatMeReadOtherMessageEvent;
import com.cupidapp.live.chat2.model.ChatMessageBindLongClickEvent;
import com.cupidapp.live.chat2.model.ChatMessageModel;
import com.cupidapp.live.chat2.model.ChatMessageSendFailResendEvent;
import com.cupidapp.live.chat2.model.ChatMessageType;
import com.cupidapp.live.chat2.model.ChatSnapImgMessageDestroyEvent;
import com.cupidapp.live.chat2.model.ChatTextType;
import com.cupidapp.live.chat2.model.ChatTouchMessageListCloseAllPanelEvent;
import com.cupidapp.live.chat2.model.LongClickActionType;
import com.cupidapp.live.chat2.model.MessageBubbleModel;
import com.cupidapp.live.chat2.view.ChatDetailInputPanelLayout;
import com.cupidapp.live.chat2.view.ChatDetailTipsLayout;
import com.cupidapp.live.chat2.view.ChatDetailTitleLayout;
import com.cupidapp.live.chat2.view.ChatEmojiPagerLayout;
import com.cupidapp.live.chat2.view.ChatTopicLayout;
import com.cupidapp.live.chat2.viewmodel.ChatDetailViewModel;
import com.cupidapp.live.feed.activity.FeedDetailActivity;
import com.cupidapp.live.feed.activity.PostLimitDetailActivity;
import com.cupidapp.live.feed.model.FeedModel;
import com.cupidapp.live.maskparty.activity.ChatPhoneAlbumActivity;
import com.cupidapp.live.mediapicker.model.CameraStartPosition;
import com.cupidapp.live.mediapicker.newmediapicker.fragment.MediaPickerFragment;
import com.cupidapp.live.mediapicker.newmediapicker.model.MediaType;
import com.cupidapp.live.profile.activity.FocusUserManageActivity;
import com.cupidapp.live.profile.activity.UserProfileActivity;
import com.cupidapp.live.profile.event.UserProfileDataChangeEvent;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.profile.view.UserAlertDialogHelper;
import com.cupidapp.live.track.group.GroupSocialLog;
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
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.s;
import kotlin.jvm.internal.v;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ChatDetailFragment.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ChatDetailFragment extends FKBaseFragment {

    /* renamed from: o, reason: collision with root package name */
    @NotNull
    public static final a f13305o = new a(null);

    /* renamed from: p, reason: collision with root package name */
    public static boolean f13306p;

    /* renamed from: q, reason: collision with root package name */
    @Nullable
    public static MessageBubbleModel f13307q;

    /* renamed from: r, reason: collision with root package name */
    @Nullable
    public static MessageBubbleModel f13308r;

    /* renamed from: e, reason: collision with root package name */
    public ChatBundleData f13309e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public final Lazy f13310f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public final ChatDetailAdapter f13311g;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public final Lazy f13312h;

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    public KeyboardStatePopupWindow f13313i;

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    public final Lazy f13314j;

    /* renamed from: k, reason: collision with root package name */
    @Nullable
    public ActivityResultLauncher<Intent> f13315k;

    /* renamed from: l, reason: collision with root package name */
    @Nullable
    public o f13316l;

    /* renamed from: m, reason: collision with root package name */
    @NotNull
    public final Lazy f13317m;

    /* renamed from: n, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f13318n = new LinkedHashMap();

    /* compiled from: ChatDetailFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final MessageBubbleModel a() {
            return ChatDetailFragment.f13307q;
        }

        @Nullable
        public final MessageBubbleModel b() {
            return ChatDetailFragment.f13308r;
        }

        @NotNull
        public final ChatDetailFragment c(@NotNull ChatBundleData data) {
            s.i(data, "data");
            ChatDetailFragment chatDetailFragment = new ChatDetailFragment();
            chatDetailFragment.f13309e = data;
            return chatDetailFragment;
        }

        public final void d(boolean z10) {
            ChatDetailFragment.f13306p = z10;
        }

        public final void e(@Nullable MessageBubbleModel messageBubbleModel) {
            ChatDetailFragment.f13307q = messageBubbleModel;
        }

        public final void f(@Nullable MessageBubbleModel messageBubbleModel) {
            ChatDetailFragment.f13308r = messageBubbleModel;
        }
    }

    /* compiled from: ChatDetailFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f13319a;

        static {
            int[] iArr = new int[LongClickActionType.values().length];
            try {
                iArr[LongClickActionType.Copy.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LongClickActionType.Cancel.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LongClickActionType.Destroy.ordinal()] = 3;
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
            try {
                iArr[LongClickActionType.Personal.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            f13319a = iArr;
        }
    }

    /* compiled from: ChatDetailFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class c implements com.cupidapp.live.chat2.view.h {
        public c() {
        }

        @Override // com.cupidapp.live.chat2.view.h
        public void a() {
            FragmentActivity activity = ChatDetailFragment.this.getActivity();
            if (activity != null) {
                activity.finish();
            }
        }

        @Override // com.cupidapp.live.chat2.view.h
        public void b() {
            ChatDetailFragment.this.X1();
        }

        @Override // com.cupidapp.live.chat2.view.h
        public void c() {
            ChatDetailFragment.this.S1();
        }
    }

    /* compiled from: ChatDetailFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class d implements com.cupidapp.live.chat2.view.f {
        public d() {
        }

        @Override // com.cupidapp.live.chat2.view.f
        public void b() {
            ChatDetailFragment.this.T1();
        }

        @Override // com.cupidapp.live.chat2.view.f
        public void c(boolean z10, @NotNull String textMessage, @Nullable ChatTextType chatTextType) {
            s.i(textMessage, "textMessage");
            if (z10) {
                ChatDetailFragment chatDetailFragment = ChatDetailFragment.this;
                chatDetailFragment.R1(chatDetailFragment.getContext());
            } else {
                ChatDetailViewModel.sendTextMessage$default(ChatDetailFragment.this.C1(), Boolean.FALSE, textMessage, chatTextType, null, 8, null);
            }
        }
    }

    /* compiled from: ChatDetailFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class e implements com.cupidapp.live.chat2.view.g {
        public e() {
        }

        @Override // com.cupidapp.live.chat2.view.g
        public void a(@NotNull String textMessage) {
            s.i(textMessage, "textMessage");
            ChatDetailViewModel.sendTextMessage$default(ChatDetailFragment.this.C1(), Boolean.FALSE, textMessage, null, null, 12, null);
        }
    }

    /* compiled from: ChatDetailFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class f implements com.cupidapp.live.chat2.helper.i {
        public f() {
        }

        @Override // com.cupidapp.live.chat2.helper.i
        public void a() {
            ((ChatDetailInputPanelLayout) ChatDetailFragment.this.d1(R$id.chat_detail_input_panel_layout)).J();
        }

        @Override // com.cupidapp.live.chat2.helper.i
        public void b(int i10, int i11) {
            ((ChatDetailInputPanelLayout) ChatDetailFragment.this.d1(R$id.chat_detail_input_panel_layout)).I(i10, i11);
        }

        @Override // com.cupidapp.live.chat2.helper.i
        public void c(int i10) {
            ((ChatDetailInputPanelLayout) ChatDetailFragment.this.d1(R$id.chat_detail_input_panel_layout)).K();
        }
    }

    /* compiled from: ChatDetailFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class g implements Observer, p {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f13324a;

        public g(Function1 function) {
            s.i(function, "function");
            this.f13324a = function;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof p)) {
                return s.d(getFunctionDelegate(), ((p) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.p
        @NotNull
        public final kotlin.b<?> getFunctionDelegate() {
            return this.f13324a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f13324a.invoke(obj);
        }
    }

    /* compiled from: ChatDetailFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class h implements o.c {
        public h() {
        }

        @Override // com.cupidapp.live.base.utils.o.c
        public void a(long j10) {
            j1.k kVar = j1.k.f50238a;
            SensorPosition position = ChatDetailFragment.this.B1().getPosition();
            ChatBundleData chatBundleData = ChatDetailFragment.this.f13309e;
            if (chatBundleData == null) {
                s.A("mBundleData");
                chatBundleData = null;
            }
            kVar.a(position, null, chatBundleData.getOtherUser().userId(), j10);
        }

        @Override // com.cupidapp.live.base.utils.o.c
        public void b(@NotNull String imageUriString, boolean z10) {
            s.i(imageUriString, "imageUriString");
            ChatDetailFragment chatDetailFragment = ChatDetailFragment.this;
            int i10 = R$id.chat_detail_recycler_view;
            if (((RecyclerView) chatDetailFragment.d1(i10)) == null) {
                return;
            }
            ChatDetailAdapter chatDetailAdapter = ChatDetailFragment.this.f13311g;
            RecyclerView chat_detail_recycler_view = (RecyclerView) ChatDetailFragment.this.d1(i10);
            s.h(chat_detail_recycler_view, "chat_detail_recycler_view");
            if (chatDetailAdapter.G(chat_detail_recycler_view)) {
                j1.k.f50238a.c(SensorPosition.SnapImage, "BURN_AFTER_READING", null, z10);
                ChatDetailFragment.this.C1().youScreenCaptureOfSnapMessage(null);
            } else {
                j1.k.f50238a.d(ChatDetailFragment.this.B1().getPosition(), z10);
            }
        }
    }

    public ChatDetailFragment() {
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.cupidapp.live.chat2.fragment.ChatDetailFragment$special$$inlined$viewModels$default$1
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
        this.f13310f = FragmentViewModelLazyKt.createViewModelLazy(this, v.b(ChatDetailViewModel.class), new Function0<ViewModelStore>() { // from class: com.cupidapp.live.chat2.fragment.ChatDetailFragment$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = ((ViewModelStoreOwner) Function0.this.invoke()).getViewModelStore();
                s.h(viewModelStore, "ownerProducer().viewModelStore");
                return viewModelStore;
            }
        }, null);
        this.f13311g = new ChatDetailAdapter();
        this.f13312h = kotlin.c.b(new Function0<FKDropDownLoadMoreListener>() { // from class: com.cupidapp.live.chat2.fragment.ChatDetailFragment$mLoadMoreListener$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final FKDropDownLoadMoreListener invoke() {
                final ChatDetailFragment chatDetailFragment = ChatDetailFragment.this;
                return new FKDropDownLoadMoreListener(new Function1<Boolean, kotlin.p>() { // from class: com.cupidapp.live.chat2.fragment.ChatDetailFragment$mLoadMoreListener$2.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ kotlin.p invoke(Boolean bool) {
                        invoke(bool.booleanValue());
                        return kotlin.p.f51048a;
                    }

                    public final void invoke(boolean z10) {
                        ChatDetailFragment.this.C1().loadMoreHistoryMessage();
                    }
                });
            }
        });
        this.f13314j = kotlin.c.b(new Function0<xb.b>() { // from class: com.cupidapp.live.chat2.fragment.ChatDetailFragment$mRxPermissions$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final xb.b invoke() {
                return new xb.b(ChatDetailFragment.this);
            }
        });
        this.f13317m = kotlin.c.b(new Function0<FKSensorContext>() { // from class: com.cupidapp.live.chat2.fragment.ChatDetailFragment$mSensorContext$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final FKSensorContext invoke() {
                ChatBundleData chatBundleData = ChatDetailFragment.this.f13309e;
                if (chatBundleData == null) {
                    s.A("mBundleData");
                    chatBundleData = null;
                }
                FKSensorContext sensorContext = chatBundleData.getSensorContext();
                return new FKSensorContext(ChatDetailFragment.this.O0(), sensorContext.getPosition(), sensorContext.getSource(), sensorContext.getScene());
            }
        });
    }

    public static final void G1(ChatDetailFragment this$0, String msgId) {
        s.i(this$0, "this$0");
        ChatDetailAdapter chatDetailAdapter = this$0.f13311g;
        s.h(msgId, "msgId");
        chatDetailAdapter.B(msgId);
    }

    public static final void H1(ChatDetailFragment this$0, Boolean show) {
        s.i(this$0, "this$0");
        ChatDetailTipsLayout chatDetailTipsLayout = (ChatDetailTipsLayout) this$0.d1(R$id.chat_detail_tips_layout);
        s.h(show, "show");
        chatDetailTipsLayout.g(show.booleanValue());
    }

    public static final void I1(ChatDetailFragment this$0, User user) {
        s.i(this$0, "this$0");
        ChatBundleData chatBundleData = this$0.f13309e;
        if (chatBundleData == null) {
            s.A("mBundleData");
            chatBundleData = null;
        }
        s.h(user, "user");
        chatBundleData.setOtherUser(user);
        ((ChatDetailTitleLayout) this$0.d1(R$id.chat_detail_title_layout)).f(user);
        ((ChatDetailInputPanelLayout) this$0.d1(R$id.chat_detail_input_panel_layout)).N(user);
    }

    public static final void J1(ChatDetailFragment this$0, Boolean bool) {
        s.i(this$0, "this$0");
        ChatDetailTipsLayout chatDetailTipsLayout = (ChatDetailTipsLayout) this$0.d1(R$id.chat_detail_tips_layout);
        ChatBundleData chatBundleData = this$0.f13309e;
        ChatBundleData chatBundleData2 = null;
        if (chatBundleData == null) {
            s.A("mBundleData");
            chatBundleData = null;
        }
        String userId = chatBundleData.getOtherUser().userId();
        ChatBundleData chatBundleData3 = this$0.f13309e;
        if (chatBundleData3 == null) {
            s.A("mBundleData");
        } else {
            chatBundleData2 = chatBundleData3;
        }
        chatDetailTipsLayout.i(userId, chatBundleData2.getFeedModel(), bool);
        this$0.T1();
    }

    public static final void K1(ChatDetailFragment this$0, Boolean it) {
        s.i(this$0, "this$0");
        ChatDetailTitleLayout chatDetailTitleLayout = (ChatDetailTitleLayout) this$0.d1(R$id.chat_detail_title_layout);
        s.h(it, "it");
        chatDetailTitleLayout.d(it.booleanValue());
    }

    public static final void L1(final ChatDetailFragment this$0, List list) {
        s.i(this$0, "this$0");
        ChatDetailAdapter chatDetailAdapter = this$0.f13311g;
        s.h(list, "list");
        chatDetailAdapter.v(CollectionsKt___CollectionsKt.z0(list), new Function0<kotlin.p>() { // from class: com.cupidapp.live.chat2.fragment.ChatDetailFragment$initObserve$6$1
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
                ((ChatDetailInputPanelLayout) ChatDetailFragment.this.d1(R$id.chat_detail_input_panel_layout)).Q();
            }
        });
        ChatMessageModel chatMessageModel = (ChatMessageModel) CollectionsKt___CollectionsKt.f0(list);
        if (s.d(chatMessageModel != null ? chatMessageModel.getType() : null, ChatMessageType.InboxMessageText.getValue())) {
            this$0.W1(chatMessageModel.getText());
        }
        ((ChatDetailTipsLayout) this$0.d1(R$id.chat_detail_tips_layout)).j();
        this$0.T1();
    }

    public static final void M1(ChatDetailFragment this$0, Pair pair) {
        s.i(this$0, "this$0");
        this$0.f13311g.K(((Number) pair.getFirst()).longValue(), (ChatMessageModel) pair.getSecond());
    }

    public static final void N1(ChatDetailFragment this$0, Pair pair) {
        s.i(this$0, "this$0");
        this$0.f13311g.y((String) pair.getFirst(), (ChatMessageModel) pair.getSecond());
    }

    public static final void O1(ChatDetailFragment this$0, ChatMessageModel model) {
        s.i(this$0, "this$0");
        ChatDetailAdapter chatDetailAdapter = this$0.f13311g;
        s.h(model, "model");
        chatDetailAdapter.A(model);
    }

    public static final void Q1(ChatDetailFragment this$0, ActivityResult activityResult) {
        s.i(this$0, "this$0");
        if (activityResult.getResultCode() == -1) {
            Intent data = activityResult.getData();
            Boolean valueOf = data != null ? Boolean.valueOf(data.getBooleanExtra("CHAT_PREVIEW_SEND_IMAGE_IS_SNAP", false)) : null;
            Intent data2 = activityResult.getData();
            ChatDetailViewModel.sendImageMessage$default(this$0.C1(), this$0.getContext(), valueOf, data2 != null ? data2.getStringExtra("CHAT_PREVIEW_SEND_IMAGE_PATH") : null, null, 8, null);
        }
    }

    public static final boolean y1(ChatDetailFragment this$0, View view, MotionEvent motionEvent) {
        s.i(this$0, "this$0");
        view.performClick();
        if (motionEvent.getAction() != 0 || motionEvent.getY() <= ((ChatDetailTitleLayout) this$0.d1(R$id.chat_detail_title_layout)).getBottom() || motionEvent.getY() >= ((ChatDetailTipsLayout) this$0.d1(R$id.chat_detail_tips_layout)).getY()) {
            return false;
        }
        ((ChatDetailInputPanelLayout) this$0.d1(R$id.chat_detail_input_panel_layout)).L();
        return false;
    }

    public final xb.b A1() {
        return (xb.b) this.f13314j.getValue();
    }

    public final FKSensorContext B1() {
        return (FKSensorContext) this.f13317m.getValue();
    }

    public final ChatDetailViewModel C1() {
        return (ChatDetailViewModel) this.f13310f.getValue();
    }

    public final void D1(ChatFocusStateData chatFocusStateData) {
        if (chatFocusStateData.getSuccess()) {
            com.cupidapp.live.base.view.h.f12779a.l(getContext(), chatFocusStateData.getFocus() ? R$string.focus_success : R$string.unfocus_success);
            GroupSocialLog.f18708a.Z(chatFocusStateData.getUserId(), B1().getPosition(), B1().getSource(), chatFocusStateData.getFocus());
            return;
        }
        Integer errorCode = chatFocusStateData.getErrorCode();
        int value = RequestErrorCode.FocusNoRemains.getValue();
        if (errorCode != null && errorCode.intValue() == value) {
            UserAlertDialogHelper.f17874a.a(getContext(), B1().getPosition(), chatFocusStateData.getErrorMsg(), PopupName.SPECIAL_ATTENTION_LIMIT, new Function0<kotlin.p>() { // from class: com.cupidapp.live.chat2.fragment.ChatDetailFragment$handleFocusApiResult$1
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
                    FocusUserManageActivity.f17618r.a(ChatDetailFragment.this.getContext(), ChatDetailFragment.this.B1());
                }
            });
        }
    }

    public final void E1() {
        Context context = getContext();
        ConstraintLayout chat_detail_fragment_root_layout = (ConstraintLayout) d1(R$id.chat_detail_fragment_root_layout);
        s.h(chat_detail_fragment_root_layout, "chat_detail_fragment_root_layout");
        KeyboardStatePopupWindow keyboardStatePopupWindow = new KeyboardStatePopupWindow(context, this, chat_detail_fragment_root_layout);
        this.f13313i = keyboardStatePopupWindow;
        keyboardStatePopupWindow.c(new f());
    }

    public final void F1() {
        C1().getOtherUser().observe(getViewLifecycleOwner(), new Observer() { // from class: com.cupidapp.live.chat2.fragment.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ChatDetailFragment.I1(ChatDetailFragment.this, (User) obj);
            }
        });
        C1().getFirstScreenHistoryMsg().observe(getViewLifecycleOwner(), new EventObserver(new ChatDetailFragment$initObserve$2(this)));
        C1().getMoreHistoryMsg().observe(getViewLifecycleOwner(), new EventObserver(new Function1<StateResult<List<? extends ChatMessageModel>>, kotlin.p>() { // from class: com.cupidapp.live.chat2.fragment.ChatDetailFragment$initObserve$3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(StateResult<List<? extends ChatMessageModel>> stateResult) {
                invoke2((StateResult<List<ChatMessageModel>>) stateResult);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull StateResult<List<ChatMessageModel>> result) {
                FKDropDownLoadMoreListener z1;
                FKDropDownLoadMoreListener z12;
                s.i(result, "result");
                if (result instanceof StateResult.b) {
                    ChatDetailFragment.this.f13311g.z(true);
                    return;
                }
                if (result instanceof StateResult.c) {
                    ChatDetailFragment.this.f13311g.z(false);
                    ChatDetailFragment.this.f13311g.u(result.getData());
                    z12 = ChatDetailFragment.this.z1();
                    z12.c(false);
                    return;
                }
                if (result instanceof StateResult.a) {
                    ChatDetailFragment.this.f13311g.z(false);
                    z1 = ChatDetailFragment.this.z1();
                    z1.c(false);
                }
            }
        }));
        C1().getHasPrivilege().observe(getViewLifecycleOwner(), new Observer() { // from class: com.cupidapp.live.chat2.fragment.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ChatDetailFragment.J1(ChatDetailFragment.this, (Boolean) obj);
            }
        });
        C1().getInLiveShow().observe(getViewLifecycleOwner(), new Observer() { // from class: com.cupidapp.live.chat2.fragment.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ChatDetailFragment.K1(ChatDetailFragment.this, (Boolean) obj);
            }
        });
        C1().getNewMessage().observe(getViewLifecycleOwner(), new Observer() { // from class: com.cupidapp.live.chat2.fragment.j
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ChatDetailFragment.L1(ChatDetailFragment.this, (List) obj);
            }
        });
        C1().getReplaceMessage().observe(getViewLifecycleOwner(), new Observer() { // from class: com.cupidapp.live.chat2.fragment.k
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ChatDetailFragment.M1(ChatDetailFragment.this, (Pair) obj);
            }
        });
        C1().getCancelMessage().observe(getViewLifecycleOwner(), new Observer() { // from class: com.cupidapp.live.chat2.fragment.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ChatDetailFragment.N1(ChatDetailFragment.this, (Pair) obj);
            }
        });
        C1().getDeleteMessageByModel().observe(getViewLifecycleOwner(), new Observer() { // from class: com.cupidapp.live.chat2.fragment.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ChatDetailFragment.O1(ChatDetailFragment.this, (ChatMessageModel) obj);
            }
        });
        C1().getDeleteMessageByMsgId().observe(getViewLifecycleOwner(), new Observer() { // from class: com.cupidapp.live.chat2.fragment.i
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ChatDetailFragment.G1(ChatDetailFragment.this, (String) obj);
            }
        });
        C1().getOtherReadMeMessage().observe(getViewLifecycleOwner(), new EventObserver(new Function1<List<? extends String>, kotlin.p>() { // from class: com.cupidapp.live.chat2.fragment.ChatDetailFragment$initObserve$11
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(List<? extends String> list) {
                invoke2((List<String>) list);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull List<String> msgIds) {
                s.i(msgIds, "msgIds");
                ChatDetailFragment.this.f13311g.N(CollectionsKt___CollectionsKt.z0(msgIds));
            }
        }));
        C1().getFocusState().observe(getViewLifecycleOwner(), new EventObserver(new Function1<ChatFocusStateData, kotlin.p>() { // from class: com.cupidapp.live.chat2.fragment.ChatDetailFragment$initObserve$12
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(ChatFocusStateData chatFocusStateData) {
                invoke2(chatFocusStateData);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull ChatFocusStateData data) {
                s.i(data, "data");
                ChatDetailFragment.this.D1(data);
            }
        }));
        C1().getNotifyGetNewMessage().observe(getViewLifecycleOwner(), new EventObserver(new Function1<Boolean, kotlin.p>() { // from class: com.cupidapp.live.chat2.fragment.ChatDetailFragment$initObserve$13
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return kotlin.p.f51048a;
            }

            public final void invoke(boolean z10) {
                ChatDetailFragment.this.C1().loadNewestMessage(ChatDetailFragment.this.f13311g.E());
            }
        }));
        C1().isFromStoryLabel().observe(getViewLifecycleOwner(), new Observer() { // from class: com.cupidapp.live.chat2.fragment.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ChatDetailFragment.H1(ChatDetailFragment.this, (Boolean) obj);
            }
        });
        C1().getOtherStoryLabel().observe(getViewLifecycleOwner(), new EventObserver(new Function1<ChatOtherStoryLabelUiModel, kotlin.p>() { // from class: com.cupidapp.live.chat2.fragment.ChatDetailFragment$initObserve$15
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(ChatOtherStoryLabelUiModel chatOtherStoryLabelUiModel) {
                invoke2(chatOtherStoryLabelUiModel);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull ChatOtherStoryLabelUiModel model) {
                s.i(model, "model");
                ChatDetailFragment.this.f13311g.w(model);
                ChatDetailFragment.this.T1();
            }
        }));
        C1().getZodiacQuestionList().observe(getViewLifecycleOwner(), new EventObserver(new ChatDetailFragment$initObserve$16(this)));
        C1().getChatGuide().observe(getViewLifecycleOwner(), new EventObserver(new Function1<ChatGuideGrpcModel, kotlin.p>() { // from class: com.cupidapp.live.chat2.fragment.ChatDetailFragment$initObserve$17
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(ChatGuideGrpcModel chatGuideGrpcModel) {
                invoke2(chatGuideGrpcModel);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull ChatGuideGrpcModel model) {
                s.i(model, "model");
                Integer type = model.getType();
                int value = ChatGuideType.CONSTELLATION_MATCHING_DEGREE.getValue();
                if (type != null && type.intValue() == value) {
                    ChatDetailAnimationHelper.f13343a.b(ChatDetailFragment.this.getContext(), model.getJumpUrl(), ChatDetailFragment.this.O0());
                }
            }
        }));
        C1().getSourceDesc().observe(getViewLifecycleOwner(), new g(new Function1<String, kotlin.p>() { // from class: com.cupidapp.live.chat2.fragment.ChatDetailFragment$initObserve$18
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
                ((ChatDetailTitleLayout) ChatDetailFragment.this.d1(R$id.chat_detail_title_layout)).e(str);
            }
        }));
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment
    public void N0() {
        this.f13318n.clear();
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment
    @NotNull
    public SensorPosition O0() {
        return SensorPosition.MessageDetail;
    }

    public final void P1() {
        ChatDetailViewModel C1 = C1();
        ChatBundleData chatBundleData = this.f13309e;
        if (chatBundleData == null) {
            s.A("mBundleData");
            chatBundleData = null;
        }
        C1.initTargetUserAndOtherInfo(chatBundleData, B1());
        C1().loadInboxSessionData();
        int i10 = R$id.chat_detail_tips_layout;
        ((ChatDetailTipsLayout) d1(i10)).h(this);
        ChatDetailInputPanelLayout chatDetailInputPanelLayout = (ChatDetailInputPanelLayout) d1(R$id.chat_detail_input_panel_layout);
        ChatBundleData chatBundleData2 = this.f13309e;
        if (chatBundleData2 == null) {
            s.A("mBundleData");
            chatBundleData2 = null;
        }
        User otherUser = chatBundleData2.getOtherUser();
        ChatDetailTitleLayout chat_detail_title_layout = (ChatDetailTitleLayout) d1(R$id.chat_detail_title_layout);
        s.h(chat_detail_title_layout, "chat_detail_title_layout");
        int i11 = R$id.chat_detail_recycler_view;
        RecyclerView chat_detail_recycler_view = (RecyclerView) d1(i11);
        s.h(chat_detail_recycler_view, "chat_detail_recycler_view");
        ChatDetailTipsLayout chat_detail_tips_layout = (ChatDetailTipsLayout) d1(i10);
        s.h(chat_detail_tips_layout, "chat_detail_tips_layout");
        ChatEmojiPagerLayout chat_detail_emoji_pager_layout = (ChatEmojiPagerLayout) d1(R$id.chat_detail_emoji_pager_layout);
        s.h(chat_detail_emoji_pager_layout, "chat_detail_emoji_pager_layout");
        FrameLayout chat_detail_topic_parent_layout = (FrameLayout) d1(R$id.chat_detail_topic_parent_layout);
        s.h(chat_detail_topic_parent_layout, "chat_detail_topic_parent_layout");
        ChatTopicLayout chat_detail_topic_layout = (ChatTopicLayout) d1(R$id.chat_detail_topic_layout);
        s.h(chat_detail_topic_layout, "chat_detail_topic_layout");
        FKSVGAImageView chat_detail_emoji_svga = (FKSVGAImageView) d1(R$id.chat_detail_emoji_svga);
        s.h(chat_detail_emoji_svga, "chat_detail_emoji_svga");
        chatDetailInputPanelLayout.E(otherUser, chat_detail_title_layout, chat_detail_recycler_view, chat_detail_tips_layout, chat_detail_emoji_pager_layout, chat_detail_topic_parent_layout, chat_detail_topic_layout, chat_detail_emoji_svga);
        ChatDetailViewModel C12 = C1();
        ChatBundleData chatBundleData3 = this.f13309e;
        if (chatBundleData3 == null) {
            s.A("mBundleData");
            chatBundleData3 = null;
        }
        C12.loadFirstScreenHistoryMessage(chatBundleData3.isFromStoryLabel());
        RecyclerView recyclerView = (RecyclerView) d1(i11);
        recyclerView.setItemAnimator(null);
        recyclerView.setAdapter(this.f13311g);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.addOnScrollListener(z1());
        ChatDetailAdapter chatDetailAdapter = this.f13311g;
        ExposureScene exposureScene = ExposureScene.ChatDetail;
        RecyclerView chat_detail_recycler_view2 = (RecyclerView) d1(i11);
        s.h(chat_detail_recycler_view2, "chat_detail_recycler_view");
        chatDetailAdapter.t(new RecyclerExposureHelper(exposureScene, chat_detail_recycler_view2, 0.0f, 0L, null, new Function1<List<? extends h1.a>, kotlin.p>() { // from class: com.cupidapp.live.chat2.fragment.ChatDetailFragment$initView$2$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(List<? extends h1.a> list) {
                invoke2((List<h1.a>) list);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull List<h1.a> list) {
                Map<String, String> linkDict;
                Collection<String> values;
                s.i(list, "list");
                Iterator<h1.a> iterator2 = list.iterator2();
                while (iterator2.hasNext()) {
                    Object a10 = iterator2.next().a();
                    if (a10 instanceof ChatMessageModel) {
                        ChatMessageModel chatMessageModel = (ChatMessageModel) a10;
                        if (s.d(chatMessageModel.getType(), ChatMessageType.InboxMessageMarket.getValue())) {
                            LinkDictModel marketingLinkDict = chatMessageModel.getMarketingLinkDict();
                            z3.b bVar = z3.b.f54828a;
                            User sender = chatMessageModel.getSender();
                            String str = null;
                            String userId = sender != null ? sender.userId() : null;
                            String itemId = chatMessageModel.getItemId();
                            String content = marketingLinkDict != null ? marketingLinkDict.getContent() : null;
                            if (marketingLinkDict != null && (linkDict = marketingLinkDict.getLinkDict()) != null && (values = linkDict.values()) != null) {
                                str = (String) CollectionsKt___CollectionsKt.U(values);
                            }
                            bVar.j(userId, itemId, content, str);
                        }
                    }
                }
            }
        }, 28, null));
    }

    public final void R1(final Context context) {
        if (context == null) {
            return;
        }
        z0.h.q(context, null, 1, null);
        FKRxPermissionAlertDialog.f12016a.m(context, A1(), (r16 & 4) != 0 ? null : new Function0<kotlin.p>() { // from class: com.cupidapp.live.chat2.fragment.ChatDetailFragment$openAlbum$1
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
                ActivityResultLauncher activityResultLauncher;
                activityResultLauncher = ChatDetailFragment.this.f13315k;
                if (activityResultLauncher != null) {
                    ChatDetailFragment chatDetailFragment = ChatDetailFragment.this;
                    Context context2 = context;
                    MediaPickerFragment.Config config = new MediaPickerFragment.Config(MediaType.IMAGE, true, false, false, false, CameraStartPosition.Chat, chatDetailFragment.B1().getPosition(), null, 152, null);
                    ChatPhoneAlbumActivity.a aVar = ChatPhoneAlbumActivity.f16226v;
                    ChatBundleData chatBundleData = chatDetailFragment.f13309e;
                    if (chatBundleData == null) {
                        s.A("mBundleData");
                        chatBundleData = null;
                    }
                    aVar.a(context2, activityResultLauncher, config, chatBundleData.getOtherUser().userId(), (r12 & 16) != 0);
                }
            }
        }, (r16 & 8) != 0 ? null : null, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? R$string.need_access_media_upload_better : 0);
    }

    public final void S1() {
        ChatBundleData chatBundleData = this.f13309e;
        if (chatBundleData == null) {
            s.A("mBundleData");
            chatBundleData = null;
        }
        User otherUser = chatBundleData.getOtherUser();
        UserProfileActivity.G.a(getContext(), otherUser, new ProfileSensorContext(ViewProfilePrefer.ChatToProfile.getValue(), null, otherUser.getMe(), B1().getPosition(), B1().getSource(), B1().getScene()), (r21 & 8) != 0 ? false : true, (r21 & 16) != 0 ? null : null, (r21 & 32) != 0 ? null : null, (r21 & 64) != 0 ? null : null, (r21 & 128) != 0 ? false : false);
    }

    public final void T1() {
        Integer F = this.f13311g.F();
        if (F != null) {
            ((RecyclerView) d1(R$id.chat_detail_recycler_view)).scrollToPosition(F.intValue());
        }
    }

    public final void U1() {
        ChatBundleData chatBundleData = this.f13309e;
        ChatBundleData chatBundleData2 = null;
        if (chatBundleData == null) {
            s.A("mBundleData");
            chatBundleData = null;
        }
        User otherUser = chatBundleData.getOtherUser();
        boolean isFollowed = B1().getScene() == SensorScene.NewMatchList ? true : otherUser.isFollowed();
        GroupSocialLog groupSocialLog = GroupSocialLog.f18708a;
        SensorScene scene = B1().getScene();
        String value = scene != null ? scene.getValue() : null;
        String value2 = B1().getPosition().getValue();
        String value3 = B1().getSource().getValue();
        String userId = otherUser.userId();
        ChatBundleData chatBundleData3 = this.f13309e;
        if (chatBundleData3 == null) {
            s.A("mBundleData");
            chatBundleData3 = null;
        }
        boolean isFromStoryLabel = chatBundleData3.isFromStoryLabel();
        ChatBundleData chatBundleData4 = this.f13309e;
        if (chatBundleData4 == null) {
            s.A("mBundleData");
        } else {
            chatBundleData2 = chatBundleData4;
        }
        groupSocialLog.D(value, value2, value3, isFollowed, userId, isFromStoryLabel, chatBundleData2.getInLiveShow());
    }

    public final void V1() {
        Context context = getContext();
        if (context == null) {
            return;
        }
        o c4 = o.f12354i.c(context);
        this.f13316l = c4;
        if (c4 != null) {
            c4.l(new h());
        }
    }

    public final void W1(String str) {
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
        int i10 = R$id.chat_detail_emoji_svga;
        if (((FKSVGAImageView) d1(i10)) != null) {
            ((FKSVGAImageView) d1(i10)).K();
            ((FKSVGAImageView) d1(i10)).setVisibility(0);
            FKSVGAImageView chat_detail_emoji_svga = (FKSVGAImageView) d1(i10);
            s.h(chat_detail_emoji_svga, "chat_detail_emoji_svga");
            FKSVGAImageView.F(chat_detail_emoji_svga, b4, null, new Function0<kotlin.p>() { // from class: com.cupidapp.live.chat2.fragment.ChatDetailFragment$showEmojiSVGAAnimation$1
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
                    FKSVGAImageView fKSVGAImageView = (FKSVGAImageView) ChatDetailFragment.this.d1(R$id.chat_detail_emoji_svga);
                    if (fKSVGAImageView == null) {
                        return;
                    }
                    fKSVGAImageView.setVisibility(8);
                }
            }, 2, null);
        }
    }

    public final void X1() {
        FKActionSheetItemModel fKActionSheetItemModel;
        ArrayList arrayList = new ArrayList();
        arrayList.add(new FKActionSheetItemModel(R$string.goto_profile, null, null, null, null, new Function0<kotlin.p>() { // from class: com.cupidapp.live.chat2.fragment.ChatDetailFragment$showMoreActionSheetDialog$1
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
                ChatDetailFragment.this.S1();
            }
        }, 30, null));
        ChatBundleData chatBundleData = this.f13309e;
        if (chatBundleData == null) {
            s.A("mBundleData");
            chatBundleData = null;
        }
        if (chatBundleData.getOtherUser().getFocus()) {
            fKActionSheetItemModel = new FKActionSheetItemModel(R$string.set_unfocus, ActionSheetItemType.Warning, null, null, null, new Function0<kotlin.p>() { // from class: com.cupidapp.live.chat2.fragment.ChatDetailFragment$showMoreActionSheetDialog$focus$1
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
                    ChatDetailFragment.this.Y1();
                }
            }, 28, null);
        } else {
            fKActionSheetItemModel = new FKActionSheetItemModel(R$string.set_focus_chat_top, ActionSheetItemType.Recommend, null, null, null, new Function0<kotlin.p>() { // from class: com.cupidapp.live.chat2.fragment.ChatDetailFragment$showMoreActionSheetDialog$focus$2
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
                    ChatDetailFragment.this.C1().changeFocusRelation(true);
                }
            }, 28, null);
        }
        arrayList.add(new FKActionSheetItemModel(R$string.report, null, null, null, null, new Function0<kotlin.p>() { // from class: com.cupidapp.live.chat2.fragment.ChatDetailFragment$showMoreActionSheetDialog$2
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
                j.a.b(com.cupidapp.live.base.router.j.f12156c, ChatDetailFragment.this.getContext(), n0.f12353a.a(ChatDetailFragment.this.O0()), null, 4, null);
            }
        }, 30, null));
        arrayList.add(fKActionSheetItemModel);
        FKActionSheetDialog.f12692f.a(getContext()).f(arrayList).h();
    }

    public final void Y1() {
        FKAlertDialog.G(FKAlertDialog.r(FKAlertDialog.w(FKAlertDialog.o(FKAlertDialog.a.c(FKAlertDialog.f12698l, getContext(), false, 2, null).D(R$string.confirm_cancel_focus), R$string.confirm_cancel_focus_content, 0, 2, null), 0, null, new Function0<kotlin.p>() { // from class: com.cupidapp.live.chat2.fragment.ChatDetailFragment$showUnFocusAlertDialog$1
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
                ChatDetailFragment.this.C1().changeFocusRelation(false);
            }
        }, 3, null), 0, null, 3, null).j(false), null, 1, null);
    }

    @Nullable
    public View d1(int i10) {
        View findViewById;
        Map<Integer, View> map = this.f13318n;
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
        return ((ChatDetailInputPanelLayout) d1(R$id.chat_detail_input_panel_layout)).H();
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.f13315k = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.cupidapp.live.chat2.fragment.c
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                ChatDetailFragment.Q1(ChatDetailFragment.this, (ActivityResult) obj);
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        s.i(inflater, "inflater");
        return inflater.inflate(R$layout.fragment_chat_detail, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        ChatLookSnapImageActivity.f13280x.a();
        super.onDestroy();
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f13311g.M();
        N0();
    }

    @he.j(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull ChatMessageBindLongClickEvent event) {
        FKActionItemModel fKActionItemModel;
        s.i(event, "event");
        final ChatMessageModel model = event.getModel();
        ChatBundleData chatBundleData = this.f13309e;
        if (chatBundleData == null) {
            s.A("mBundleData");
            chatBundleData = null;
        }
        if ((chatBundleData.isCardStyle() && model.getMine()) || event.getActions().isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (LongClickActionType longClickActionType : event.getActions()) {
            switch (b.f13319a[longClickActionType.ordinal()]) {
                case 1:
                    fKActionItemModel = new FKActionItemModel(longClickActionType.getResId(), new Function0<kotlin.p>() { // from class: com.cupidapp.live.chat2.fragment.ChatDetailFragment$onEvent$1$item$1
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
                            String text = ChatMessageModel.this.getText();
                            if (text != null) {
                                q1.c.f53005a.b(this.getContext(), text);
                            }
                        }
                    });
                    break;
                case 2:
                    fKActionItemModel = new FKActionItemModel(longClickActionType.getResId(), new Function0<kotlin.p>() { // from class: com.cupidapp.live.chat2.fragment.ChatDetailFragment$onEvent$1$item$2
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
                            ChatDetailFragment.this.C1().cancelMessage(model);
                        }
                    });
                    break;
                case 3:
                    fKActionItemModel = new FKActionItemModel(longClickActionType.getResId(), new Function0<kotlin.p>() { // from class: com.cupidapp.live.chat2.fragment.ChatDetailFragment$onEvent$1$item$3
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
                            ChatDetailFragment.this.C1().destroyMessage(model);
                        }
                    });
                    break;
                case 4:
                    fKActionItemModel = new FKActionItemModel(longClickActionType.getResId(), new Function0<kotlin.p>() { // from class: com.cupidapp.live.chat2.fragment.ChatDetailFragment$onEvent$1$item$4
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
                            ChatDetailFragment.this.C1().deleteMessage(model);
                        }
                    });
                    break;
                case 5:
                    fKActionItemModel = new FKActionItemModel(longClickActionType.getResId(), new Function0<kotlin.p>() { // from class: com.cupidapp.live.chat2.fragment.ChatDetailFragment$onEvent$1$item$5
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
                            n0 n0Var = n0.f12353a;
                            String reportData = ChatMessageModel.this.getReportData();
                            SensorPosition position = this.B1().getPosition();
                            User sender = ChatMessageModel.this.getSender();
                            j.a.b(com.cupidapp.live.base.router.j.f12156c, this.getContext(), n0Var.b(reportData, position, sender != null ? sender.userId() : null), null, 4, null);
                        }
                    });
                    break;
                case 6:
                    fKActionItemModel = new FKActionItemModel(longClickActionType.getResId(), new Function0<kotlin.p>() { // from class: com.cupidapp.live.chat2.fragment.ChatDetailFragment$onEvent$1$item$6
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
                            ConstantsUrlModel urlModel;
                            SensorsLogKeyButtonClick.MessageDetail.MESSAGE_DETAIL_BUBBLE_PERSONAL.click();
                            j.a aVar = com.cupidapp.live.base.router.j.f12156c;
                            Context context = ChatDetailFragment.this.getContext();
                            ConstantsResult q10 = p1.g.f52734a.q();
                            j.a.b(aVar, context, (q10 == null || (urlModel = q10.getUrlModel()) == null) ? null : urlModel.getIndividuationInboxBubbleConfigJumpUrl(), null, 4, null);
                        }
                    });
                    break;
                default:
                    fKActionItemModel = null;
                    break;
            }
            if (fKActionItemModel != null) {
                arrayList.add(fKActionItemModel);
            }
        }
        FKActionItemDialog.f12688e.a(getContext()).d(arrayList).e();
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        com.cupidapp.live.push.d.f17892a.i(false);
        o oVar = this.f13316l;
        if (oVar != null) {
            oVar.n();
        }
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        com.cupidapp.live.push.d.f17892a.i(true);
        o oVar = this.f13316l;
        if (oVar != null) {
            oVar.m();
        }
        if (f13306p) {
            this.f13311g.H();
        }
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        s.i(view, "view");
        super.onViewCreated(view, bundle);
        if (this.f13309e == null) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
                return;
            }
            return;
        }
        f13306p = false;
        P1();
        F1();
        x1();
        E1();
        V1();
        U1();
    }

    public final void x1() {
        ((ChatDetailTitleLayout) d1(R$id.chat_detail_title_layout)).setListener(new c());
        ((ChatDetailInputPanelLayout) d1(R$id.chat_detail_input_panel_layout)).setListener(new d());
        ((ChatDetailTipsLayout) d1(R$id.chat_detail_tips_layout)).setListener(new e());
        ((ConstraintLayout) d1(R$id.chat_detail_fragment_root_layout)).setOnTouchListener(new View.OnTouchListener() { // from class: com.cupidapp.live.chat2.fragment.a
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean y1;
                y1 = ChatDetailFragment.y1(ChatDetailFragment.this, view, motionEvent);
                return y1;
            }
        });
    }

    public final FKDropDownLoadMoreListener z1() {
        return (FKDropDownLoadMoreListener) this.f13312h.getValue();
    }

    @he.j(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull ChatGoToFeedDetailPageEvent event) {
        s.i(event, "event");
        String postId = event.getPostId();
        if (postId == null || postId.length() == 0) {
            return;
        }
        Disposable disposed = NetworkClient.f11868a.l().J(event.getPostId()).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<ListResult<FeedModel>, kotlin.p>() { // from class: com.cupidapp.live.chat2.fragment.ChatDetailFragment$onEvent$$inlined$handle$default$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(ListResult<FeedModel> listResult) {
                m2492invoke(listResult);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2492invoke(ListResult<FeedModel> listResult) {
                FeedModel feedModel;
                List<FeedModel> list = listResult.getList();
                if (list == null || (feedModel = (FeedModel) CollectionsKt___CollectionsKt.V(list)) == null) {
                    return;
                }
                FeedDetailActivity.Q.a(ChatDetailFragment.this.getContext(), feedModel, false, new FeedSensorContext(SensorPosition.FeedDetail, ChatDetailFragment.this.B1().getPosition(), ChatDetailFragment.this.B1().getSource(), ChatDetailFragment.this.B1().getScene()), (r25 & 16) != 0 ? false : false, (r25 & 32) != 0 ? false : false, (r25 & 64) != 0 ? null : null, (r25 & 128) != 0 ? null : null, (r25 & 256) != 0 ? null : null, (r25 & 512) != 0 ? null : null);
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, this)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            H(disposed);
        }
        s.h(disposed, "disposed");
    }

    @he.j(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull ChatMessageSendFailResendEvent event) {
        s.i(event, "event");
        C1().resendMessage(getContext(), event.getFailModel());
    }

    @he.j(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull ChatGoToPostLimitDetailPageEvent event) {
        s.i(event, "event");
        String postId = event.getPostId();
        if (postId == null || postId.length() == 0) {
            return;
        }
        PostLimitDetailActivity.a aVar = PostLimitDetailActivity.f14091t;
        String postId2 = event.getPostId();
        String msgId = event.getMsgId();
        FKSensorContext B1 = B1();
        ChatBundleData chatBundleData = this.f13309e;
        if (chatBundleData == null) {
            s.A("mBundleData");
            chatBundleData = null;
        }
        aVar.b(this, postId2, msgId, B1, chatBundleData.getOtherUser());
        SensorsLogFeed.f12208a.t(B1().getPosition(), event.getPostLimitUserId(), (r16 & 4) != 0 ? null : null, (r16 & 8) != 0 ? null : null, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? null : event.getPostId());
    }

    @he.j(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull ChatGoToProfilePageEvent event) {
        s.i(event, "event");
        S1();
    }

    @he.j(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull ChatMeReadOtherMessageEvent event) {
        s.i(event, "event");
        C1().meReadOtherMessage(event.getMessage());
    }

    @he.j(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull ChatClickReEditBtnEvent event) {
        s.i(event, "event");
        ((ChatDetailInputPanelLayout) d1(R$id.chat_detail_input_panel_layout)).m(event.getCancelMessage(), true);
        SensorsLogKeyButtonClick.MessageDetail.Reedit.click();
    }

    @he.j(sticky = true, threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull ChatSnapImgMessageDestroyEvent event) {
        s.i(event, "event");
        EventBus.c().r(event);
        this.f13311g.J();
    }

    @he.j(sticky = true, threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull ChatLookSnapImgInsertScreenShotNoticeEvent event) {
        s.i(event, "event");
        EventBus.c().r(event);
        String otherUserId = event.getOtherUserId();
        ChatBundleData chatBundleData = this.f13309e;
        if (chatBundleData == null) {
            s.A("mBundleData");
            chatBundleData = null;
        }
        if (s.d(otherUserId, chatBundleData.getOtherUser().userId())) {
            C1().youScreenCaptureOfSnapMessage(event.getMessage());
        }
    }

    @he.j(sticky = true, threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull UserProfileDataChangeEvent event) {
        s.i(event, "event");
        EventBus.c().r(event);
        C1().updateOtherUserInfo(event.getUser());
    }

    @he.j(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull ChatTouchMessageListCloseAllPanelEvent event) {
        s.i(event, "event");
        ((ChatDetailInputPanelLayout) d1(R$id.chat_detail_input_panel_layout)).L();
    }
}

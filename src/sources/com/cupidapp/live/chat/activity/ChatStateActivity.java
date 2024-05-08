package com.cupidapp.live.chat.activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.k;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.android.internal.logging.nano.MetricsProto;
import com.cupidapp.live.R$color;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.livedata.EventObserver;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.i;
import com.cupidapp.live.base.network.model.ProfileResult;
import com.cupidapp.live.base.network.model.StateResult;
import com.cupidapp.live.base.sensorslog.FKSensorContext;
import com.cupidapp.live.base.sensorslog.FeedSensorContext;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorsLogFeed;
import com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick;
import com.cupidapp.live.base.view.animation.FKSVGAImageView;
import com.cupidapp.live.base.view.dialog.FKActionSheetDialog;
import com.cupidapp.live.base.view.dialog.FKActionSheetItemModel;
import com.cupidapp.live.chat.fragment.ConfigChatStateFragment;
import com.cupidapp.live.chat.model.ChatStatusItemModel;
import com.cupidapp.live.chat.model.CustomEmojiCode;
import com.cupidapp.live.chat.view.CellularParentLayout;
import com.cupidapp.live.chat.view.FaceLayout;
import com.cupidapp.live.chat2.activity.ChatDetailActivity;
import com.cupidapp.live.chat2.model.ChatBundleData;
import com.cupidapp.live.feed.activity.PostLimitDetailListActivity;
import com.cupidapp.live.feed.activity.PostLimitEditActivity;
import com.cupidapp.live.feed.event.PostLimitUploadSucEvent;
import com.cupidapp.live.feed.event.UserPostLimitReadChangeEvent;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.track.group.GroupOthersLog;
import com.cupidapp.live.track.group.GroupSocialLog;
import he.j;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.jvm.internal.v;
import kotlin.p;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p1.g;
import x2.a;
import z0.h;
import z0.y;

/* compiled from: ChatStateActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ChatStateActivity extends FKBaseActivity {

    /* renamed from: t, reason: collision with root package name */
    @NotNull
    public static final a f13122t = new a(null);

    /* renamed from: r, reason: collision with root package name */
    @NotNull
    public final Lazy f13124r;

    /* renamed from: s, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f13125s = new LinkedHashMap();

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    public final Lazy f13123q = kotlin.c.b(new Function0<FKSensorContext>() { // from class: com.cupidapp.live.chat.activity.ChatStateActivity$currentSensorContext$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final FKSensorContext invoke() {
            SensorPosition sensorPosition;
            Serializable serializableExtra = ChatStateActivity.this.getIntent().getSerializableExtra("sensorContext");
            FKSensorContext fKSensorContext = serializableExtra instanceof FKSensorContext ? (FKSensorContext) serializableExtra : null;
            SensorPosition Q0 = ChatStateActivity.this.Q0();
            if (fKSensorContext == null || (sensorPosition = fKSensorContext.getPosition()) == null) {
                sensorPosition = SensorPosition.Unknown;
            }
            return new FKSensorContext(Q0, sensorPosition, null, fKSensorContext != null ? fKSensorContext.getScene() : null);
        }
    });

    /* compiled from: ChatStateActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context, @NotNull FKSensorContext sensorContext) {
            s.i(context, "context");
            s.i(sensorContext, "sensorContext");
            Intent intent = new Intent(context, (Class<?>) ChatStateActivity.class);
            intent.putExtra("sensorContext", sensorContext);
            context.startActivity(intent);
            FKBaseActivity.a.c(FKBaseActivity.f11750o, context, 0, 0, 6, null);
        }
    }

    /* compiled from: ChatStateActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class b implements CellularParentLayout.a {
        public b() {
        }

        @Override // com.cupidapp.live.chat.view.CellularParentLayout.a
        public void a(@NotNull User user) {
            s.i(user, "user");
            ChatStateActivity.this.x1().userIsSelected(user);
        }

        @Override // com.cupidapp.live.chat.view.CellularParentLayout.a
        public void b(@NotNull User user) {
            s.i(user, "user");
            if (user.getReadStatus() == null) {
                if (com.cupidapp.live.profile.logic.c.f17839a.a(user.userId())) {
                    return;
                }
                ChatStateActivity.this.E1(user);
            } else if (user.getReadStatus() != null) {
                ChatStateActivity.this.D1(user.userId(), null);
            }
        }
    }

    /* compiled from: ChatStateActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class c implements ConfigChatStateFragment.a {
        public c() {
        }

        @Override // com.cupidapp.live.chat.fragment.ConfigChatStateFragment.a
        public void a(@NotNull ChatStatusItemModel model) {
            s.i(model, "model");
            PostLimitEditActivity.a aVar = PostLimitEditActivity.E;
            ChatStateActivity chatStateActivity = ChatStateActivity.this;
            aVar.a(chatStateActivity, chatStateActivity.w1(), model);
        }

        @Override // com.cupidapp.live.chat.fragment.ConfigChatStateFragment.a
        public void dismiss() {
            ChatStateActivity.this.K1();
        }
    }

    public ChatStateActivity() {
        final Function0 function0 = null;
        this.f13124r = new ViewModelLazy(v.b(ChatStateViewModel.class), new Function0<ViewModelStore>() { // from class: com.cupidapp.live.chat.activity.ChatStateActivity$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = ComponentActivity.this.getViewModelStore();
                s.h(viewModelStore, "viewModelStore");
                return viewModelStore;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.cupidapp.live.chat.activity.ChatStateActivity$viewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ViewModelProvider.Factory invoke() {
                final ChatStateActivity chatStateActivity = ChatStateActivity.this;
                return new ViewModelProvider.Factory() { // from class: com.cupidapp.live.chat.activity.ChatStateActivity$viewModel$2.1
                    @Override // androidx.lifecycle.ViewModelProvider.Factory
                    @NotNull
                    public <T extends ViewModel> T create(@NotNull Class<T> p02) {
                        s.i(p02, "p0");
                        return new ChatStateViewModel(ChatStateActivity.this.w1());
                    }

                    @Override // androidx.lifecycle.ViewModelProvider.Factory
                    public /* synthetic */ ViewModel create(Class cls, CreationExtras creationExtras) {
                        return k.b(this, cls, creationExtras);
                    }
                };
            }
        }, new Function0<CreationExtras>() { // from class: com.cupidapp.live.chat.activity.ChatStateActivity$special$$inlined$viewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function02 = Function0.this;
                if (function02 != null && (creationExtras = (CreationExtras) function02.invoke()) != null) {
                    return creationExtras;
                }
                CreationExtras defaultViewModelCreationExtras = this.getDefaultViewModelCreationExtras();
                s.h(defaultViewModelCreationExtras, "this.defaultViewModelCreationExtras");
                return defaultViewModelCreationExtras;
            }
        });
    }

    public static final void A1(ChatStateActivity this$0, StateResult stateResult) {
        Pair pair;
        s.i(this$0, "this$0");
        if (!(stateResult instanceof StateResult.c) || (pair = (Pair) stateResult.getData()) == null) {
            return;
        }
        if (((Boolean) pair.getSecond()).booleanValue()) {
            ((CellularParentLayout) this$0.n1(R$id.cellular_parent_layout)).j((List) pair.getFirst());
        } else {
            ((CellularParentLayout) this$0.n1(R$id.cellular_parent_layout)).i((List) pair.getFirst());
        }
    }

    public static final void B1(ChatStateActivity this$0, User user) {
        s.i(this$0, "this$0");
        if (com.cupidapp.live.profile.logic.c.f17839a.a(user.userId())) {
            ((RelativeLayout) this$0.n1(R$id.chat_mine_state_ll)).setVisibility(0);
            if (user.getChatStatus() == null) {
                ((ImageLoaderView) this$0.n1(R$id.chat_state_img)).setVisibility(8);
                ((TextView) this$0.n1(R$id.chat_state_txt)).setText(this$0.getString(R$string.set_state));
            } else {
                int i10 = R$id.chat_state_img;
                ImageLoaderView chat_state_img = (ImageLoaderView) this$0.n1(i10);
                s.h(chat_state_img, "chat_state_img");
                ChatStatusItemModel chatStatus = user.getChatStatus();
                ImageLoaderView.g(chat_state_img, chatStatus != null ? chatStatus.getIcon() : null, new com.cupidapp.live.base.imageloader.b(false, null, null, null, null, null, null, ContextCompat.getColor(this$0, R$color.app_transparent), 0, null, null, null, null, false, 0, 0, false, null, null, 524159, null), null, 4, null);
                ((ImageLoaderView) this$0.n1(i10)).setVisibility(0);
                ((TextView) this$0.n1(R$id.chat_state_txt)).setText(this$0.getString(R$string.change_state));
            }
            ((RelativeLayout) this$0.n1(R$id.chat_other_menu_rl)).setVisibility(8);
            ((TextView) this$0.n1(R$id.title_txt)).setText(R$string.my_state);
            if (user.getChatStatus() == null) {
                int i11 = R$id.sub_title_txt;
                ((TextView) this$0.n1(i11)).setVisibility(0);
                ((TextView) this$0.n1(i11)).setText(this$0.x1().getDefaultSubTitle());
                return;
            }
            ((TextView) this$0.n1(R$id.sub_title_txt)).setVisibility(8);
            return;
        }
        ((RelativeLayout) this$0.n1(R$id.chat_mine_state_ll)).setVisibility(8);
        ((RelativeLayout) this$0.n1(R$id.chat_other_menu_rl)).setVisibility(0);
        ((TextView) this$0.n1(R$id.title_txt)).setText(user.getName());
        ((TextView) this$0.n1(R$id.sub_title_txt)).setVisibility(8);
    }

    public static final void I1(ChatStateActivity this$0, DialogInterface dialogInterface) {
        s.i(this$0, "this$0");
        ((RelativeLayout) this$0.n1(R$id.chat_other_menu_rl)).setVisibility(8);
    }

    public static final void J1(ChatStateActivity this$0, DialogInterface dialogInterface) {
        s.i(this$0, "this$0");
        ((RelativeLayout) this$0.n1(R$id.chat_other_menu_rl)).setVisibility(0);
    }

    public final void C1(String str) {
        if (str.length() == 0) {
            return;
        }
        Disposable disposed = a.C0836a.z(NetworkClient.f11868a.N(), str, null, null, false, null, 30, null).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<ProfileResult, p>() { // from class: com.cupidapp.live.chat.activity.ChatStateActivity$openChatDetail$$inlined$handle$default$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(ProfileResult profileResult) {
                m2480invoke(profileResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2480invoke(ProfileResult profileResult) {
                ProfileResult profileResult2 = profileResult;
                ChatDetailActivity.f13276r.a(ChatStateActivity.this, new ChatBundleData(profileResult2.getUser(), profileResult2.getUser().userId(), ChatStateActivity.this.w1(), null, false, true, false, false, false, MetricsProto.MetricsEvent.ACTION_DELETION_HELPER_DOWNLOADS_DELETION_FAIL, null));
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, this)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            H(disposed);
        }
        s.h(disposed, "disposed");
    }

    public final void D1(String str, String str2) {
        Pair<List<User>, Boolean> data;
        StateResult<Pair<List<User>, Boolean>> value = x1().getListLiveData().getValue();
        List<User> first = (value == null || (data = value.getData()) == null) ? null : data.getFirst();
        ArrayList<String> arrayList = new ArrayList<>();
        int i10 = 0;
        if (first != null) {
            int i11 = 0;
            for (User user : first) {
                int i12 = i11 + 1;
                if (i11 < 0) {
                    kotlin.collections.s.s();
                }
                User user2 = user;
                arrayList.add(user2.userId());
                if (s.d(user2.userId(), str)) {
                    i10 = i11;
                }
                i11 = i12;
            }
        }
        PostLimitDetailListActivity.f14096x.a(this, arrayList, i10, w1());
        SensorsLogFeed.f12208a.t(w1().getPosition(), str, (r16 & 4) != 0 ? null : null, (r16 & 8) != 0 ? null : Integer.valueOf(i10 + 1), (r16 & 16) != 0 ? null : str2, (r16 & 32) != 0 ? null : null);
    }

    public final void E1(User user) {
        com.cupidapp.live.feed.helper.k.f14350a.b(this, user, (r16 & 4) != 0 ? null : null, new FeedSensorContext(w1().getPosition(), w1().getSource(), null, w1().getScene()), (r16 & 16) != 0 ? false : false, (r16 & 32) != 0 ? null : null);
    }

    public final void F1() {
        ConfigChatStateFragment.f13140j.a(getSupportFragmentManager(), w1().getPosition(), new c());
    }

    public final void G1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new FKActionSheetItemModel(R$string.modify_state, null, null, null, null, new Function0<p>() { // from class: com.cupidapp.live.chat.activity.ChatStateActivity$showChatStateActionSheetDialog$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ p invoke() {
                invoke2();
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ChatStateActivity.this.F1();
                SensorsLogKeyButtonClick.ChatState.CHANGE_STATUS.click();
            }
        }, 30, null));
        arrayList.add(new FKActionSheetItemModel(R$string.end_state, null, null, null, null, new Function0<p>() { // from class: com.cupidapp.live.chat.activity.ChatStateActivity$showChatStateActionSheetDialog$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ p invoke() {
                invoke2();
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ChatStateActivity.this.x1().clearState();
                SensorsLogKeyButtonClick.ChatState.CLOSE_STATUS.click();
            }
        }, 30, null));
        FKActionSheetDialog.f12692f.a(this).f(arrayList).h();
    }

    public final void H1() {
        final AlertDialog g3;
        View layout = View.inflate(this, R$layout.dialog_state_face_list, null);
        z0.b bVar = z0.b.f54812a;
        s.h(layout, "layout");
        g3 = bVar.g(this, layout, 0, 0, -1, h.c(this, 150.0f), (r32 & 64) != 0 ? 17 : 80, (r32 & 128) != 0 ? null : null, (r32 & 256) != 0 ? null : null, (r32 & 512) != 0 ? null : 0, (r32 & 1024) != 0 ? null : null, (r32 & 2048) != 0 ? null : null, (r32 & 4096) != 0 ? null : new DialogInterface.OnShowListener() { // from class: com.cupidapp.live.chat.activity.c
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                ChatStateActivity.I1(ChatStateActivity.this, dialogInterface);
            }
        }, (r32 & 8192) != 0 ? null : new DialogInterface.OnDismissListener() { // from class: com.cupidapp.live.chat.activity.b
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                ChatStateActivity.J1(ChatStateActivity.this, dialogInterface);
            }
        });
        View findViewById = layout.findViewById(R$id.face_layout_container);
        s.h(findViewById, "layout.findViewById<View…id.face_layout_container)");
        y.d(findViewById, new Function1<View, p>() { // from class: com.cupidapp.live.chat.activity.ChatStateActivity$showFaceListDialog$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                g3.dismiss();
            }
        });
        FaceLayout faceLayout = (FaceLayout) layout.findViewById(R$id.face_layout);
        int l10 = (int) ((h.l(this) - ((faceLayout.getItemSpacing() * 4) * 2)) / 4.88d);
        faceLayout.e(l10, l10);
        faceLayout.setItemClickListener(new Function1<CustomEmojiCode, p>() { // from class: com.cupidapp.live.chat.activity.ChatStateActivity$showFaceListDialog$2$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(CustomEmojiCode customEmojiCode) {
                invoke2(customEmojiCode);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull CustomEmojiCode it) {
                s.i(it, "it");
                ChatStateActivity.this.x1().sendGreet(it.getEmojiCNCode());
                GroupSocialLog groupSocialLog = GroupSocialLog.f18708a;
                User value = ChatStateActivity.this.x1().getSelectUserLiveData().getValue();
                groupSocialLog.T(value != null ? value.userId() : null, ChatStateActivity.this.Q0(), it.getEmojiEnCode());
                g3.dismiss();
            }
        });
    }

    public final void K1() {
        final AlertDialog g3;
        Pair<List<User>, Boolean> data;
        List<User> first;
        StateResult<Pair<List<User>, Boolean>> value = x1().getListLiveData().getValue();
        int size = (value == null || (data = value.getData()) == null || (first = data.getFirst()) == null) ? 0 : first.size();
        g gVar = g.f52734a;
        if (!s.d(gVar.w1(), Boolean.TRUE) || size <= 1) {
            return;
        }
        gVar.F3(Boolean.FALSE);
        View layout = View.inflate(this, R$layout.state_swipe_guide, null);
        ((TextView) layout.findViewById(R$id.state_swipe_content)).setText(getString(R$string.swipe_to_see_more_post));
        z0.b bVar = z0.b.f54812a;
        s.h(layout, "layout");
        g3 = bVar.g(this, layout, 0, 0, -1, h.c(this, 300.0f), (r32 & 64) != 0 ? 17 : 17, (r32 & 128) != 0 ? null : Float.valueOf(0.3f), (r32 & 256) != 0 ? null : null, (r32 & 512) != 0 ? null : null, (r32 & 1024) != 0 ? null : null, (r32 & 2048) != 0 ? null : null, (r32 & 4096) != 0 ? null : null, (r32 & 8192) != 0 ? null : null);
        g3.setCanceledOnTouchOutside(false);
        View findViewById = layout.findViewById(R$id.state_swipe_svga);
        s.h(findViewById, "layout.findViewById<FKSV…w>(R.id.state_swipe_svga)");
        FKSVGAImageView.F((FKSVGAImageView) findViewById, "hand_swipe.svga", null, new Function0<p>() { // from class: com.cupidapp.live.chat.activity.ChatStateActivity$showSwipeGuide$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ p invoke() {
                invoke2();
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                if (ChatStateActivity.this.isDestroyed()) {
                    return;
                }
                g3.dismiss();
            }
        }, 2, null);
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity
    @NotNull
    public SensorPosition Q0() {
        return SensorPosition.ChatStatus;
    }

    @Nullable
    public View n1(int i10) {
        Map<Integer, View> map = this.f13125s;
        View view = map.get(Integer.valueOf(i10));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i10);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i10), findViewById);
        return findViewById;
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_chat_state);
        z1();
        y1();
        if (s.d(g.f52734a.v1(), Boolean.TRUE)) {
            ((TextView) n1(R$id.chat_hi_long_tip)).setVisibility(0);
        }
        GroupOthersLog.d(GroupOthersLog.f18702a, Q0().getValue(), null, w1().getSource().getValue(), 2, null);
    }

    @j(priority = 1, sticky = true, threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull UserPostLimitReadChangeEvent event) {
        s.i(event, "event");
        EventBus.c().r(event);
        if (!event.isUploadedPostLimit() && !event.isDelAllMyPostLimit()) {
            x1().refreshReadStatus(event.getReadUserIds());
        } else {
            x1().loadData(false);
        }
    }

    public final FKSensorContext w1() {
        return (FKSensorContext) this.f13123q.getValue();
    }

    public final ChatStateViewModel x1() {
        return (ChatStateViewModel) this.f13124r.getValue();
    }

    public final void y1() {
        ImageView title_left_img = (ImageView) n1(R$id.title_left_img);
        s.h(title_left_img, "title_left_img");
        y.d(title_left_img, new Function1<View, p>() { // from class: com.cupidapp.live.chat.activity.ChatStateActivity$initClick$1
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
                ChatStateActivity.this.onBackPressed();
            }
        });
        ImageView chat_open_post_img = (ImageView) n1(R$id.chat_open_post_img);
        s.h(chat_open_post_img, "chat_open_post_img");
        y.d(chat_open_post_img, new Function1<View, p>() { // from class: com.cupidapp.live.chat.activity.ChatStateActivity$initClick$2
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
                User value = ChatStateActivity.this.x1().getSelectUserLiveData().getValue();
                if (value != null) {
                    ChatStateActivity.this.D1(value.userId(), SensorsLogFeed.BtnName.TIME_LIMIT.getValue());
                }
            }
        });
        int i10 = R$id.chat_hi_img;
        ImageView chat_hi_img = (ImageView) n1(i10);
        s.h(chat_hi_img, "chat_hi_img");
        y.d(chat_hi_img, new Function1<View, p>() { // from class: com.cupidapp.live.chat.activity.ChatStateActivity$initClick$3
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
                ChatStateActivity.this.x1().sendGreet(CustomEmojiCode.Greet.getEmojiCNCode());
                SensorsLogKeyButtonClick.ChatState chatState = SensorsLogKeyButtonClick.ChatState.GREET;
                User value = ChatStateActivity.this.x1().getSelectUserLiveData().getValue();
                chatState.clickWithUserId(value != null ? value.userId() : null);
            }
        });
        ImageView chat_hi_img2 = (ImageView) n1(i10);
        s.h(chat_hi_img2, "chat_hi_img");
        y.c(chat_hi_img2, new Function1<View, p>() { // from class: com.cupidapp.live.chat.activity.ChatStateActivity$initClick$4
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
                g.f52734a.E3(Boolean.FALSE);
                ChatStateActivity.this.H1();
                ((TextView) ChatStateActivity.this.n1(R$id.chat_hi_long_tip)).setVisibility(8);
            }
        });
        RelativeLayout chat_mine_state_ll = (RelativeLayout) n1(R$id.chat_mine_state_ll);
        s.h(chat_mine_state_ll, "chat_mine_state_ll");
        y.d(chat_mine_state_ll, new Function1<View, p>() { // from class: com.cupidapp.live.chat.activity.ChatStateActivity$initClick$5
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
                User value = ChatStateActivity.this.x1().getSelectUserLiveData().getValue();
                if ((value != null ? value.getChatStatus() : null) == null) {
                    ChatStateActivity.this.F1();
                    SensorsLogKeyButtonClick.ChatState.SET_STATUS.click();
                } else {
                    ChatStateActivity.this.G1();
                }
            }
        });
    }

    public final void z1() {
        ((CellularParentLayout) n1(R$id.cellular_parent_layout)).setCellularParentListener(new b());
        x1().getListLiveData().observe(this, new Observer() { // from class: com.cupidapp.live.chat.activity.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ChatStateActivity.A1(ChatStateActivity.this, (StateResult) obj);
            }
        });
        x1().getSelectUserLiveData().observe(this, new Observer() { // from class: com.cupidapp.live.chat.activity.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ChatStateActivity.B1(ChatStateActivity.this, (User) obj);
            }
        });
        x1().getOpenUserChatEvent().observe(this, new EventObserver(new Function1<User, p>() { // from class: com.cupidapp.live.chat.activity.ChatStateActivity$initObserve$4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(User user) {
                invoke2(user);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull User it) {
                s.i(it, "it");
                ChatStateActivity.this.C1(it.userId());
            }
        }));
        x1().getShowChangeStateEvent().observe(this, new EventObserver(new Function1<Boolean, p>() { // from class: com.cupidapp.live.chat.activity.ChatStateActivity$initObserve$5
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return p.f51048a;
            }

            public final void invoke(boolean z10) {
                if (z10) {
                    ChatStateActivity.this.F1();
                } else {
                    ChatStateActivity.this.K1();
                }
            }
        }));
    }

    @j(sticky = true, threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull PostLimitUploadSucEvent event) {
        s.i(event, "event");
        EventBus.c().r(event);
        x1().loadData(false);
    }
}

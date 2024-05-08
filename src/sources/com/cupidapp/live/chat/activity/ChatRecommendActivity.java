package com.cupidapp.live.chat.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;
import com.android.internal.logging.nano.MetricsProto;
import com.cupidapp.live.R$color;
import com.cupidapp.live.R$drawable;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.i;
import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.base.network.model.ListResult;
import com.cupidapp.live.base.network.model.Result;
import com.cupidapp.live.base.sensorslog.FKSensorContext;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorScene;
import com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick;
import com.cupidapp.live.base.view.FKTitleBarLayout;
import com.cupidapp.live.base.view.UserIconViewLayout;
import com.cupidapp.live.base.view.animation.FKSVGAImageView;
import com.cupidapp.live.base.view.button.FKUniversalButton;
import com.cupidapp.live.chat.adapter.ChatRecommendAdapter;
import com.cupidapp.live.chat.fragment.BottomFaceDialog;
import com.cupidapp.live.chat.model.CustomEmojiCode;
import com.cupidapp.live.chat.transformer.ChatRecommendPageTransformer;
import com.cupidapp.live.chat.viewholder.ChatRecommendImageUiModel;
import com.cupidapp.live.chat2.activity.ChatDetailActivity;
import com.cupidapp.live.chat2.model.ChatBundleData;
import com.cupidapp.live.match.view.FKClickAnimationLayout;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.track.group.GroupOthersLog;
import com.cupidapp.live.track.group.GroupSocialLog;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p1.g;
import z0.u;
import z0.y;

/* compiled from: ChatRecommendActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ChatRecommendActivity extends FKBaseActivity {

    /* renamed from: w, reason: collision with root package name */
    @NotNull
    public static final a f13113w = new a(null);

    /* renamed from: r, reason: collision with root package name */
    public int f13115r;

    /* renamed from: t, reason: collision with root package name */
    public boolean f13117t;

    /* renamed from: v, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f13119v = new LinkedHashMap();

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    public final Lazy f13114q = kotlin.c.b(new Function0<ChatRecommendAdapter>() { // from class: com.cupidapp.live.chat.activity.ChatRecommendActivity$mAdapter$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final ChatRecommendAdapter invoke() {
            return new ChatRecommendAdapter();
        }
    });

    /* renamed from: s, reason: collision with root package name */
    @NotNull
    public final List<User> f13116s = new ArrayList();

    /* renamed from: u, reason: collision with root package name */
    @NotNull
    public final Lazy f13118u = kotlin.c.b(new Function0<FKSensorContext>() { // from class: com.cupidapp.live.chat.activity.ChatRecommendActivity$mSensorContext$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final FKSensorContext invoke() {
            return new FKSensorContext(ChatRecommendActivity.this.Q0(), SensorPosition.Message, null, SensorScene.Chat);
        }
    });

    /* compiled from: ChatRecommendActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@Nullable Context context) {
            if (context == null) {
                return;
            }
            context.startActivity(new Intent(context, (Class<?>) ChatRecommendActivity.class));
            FKBaseActivity.a.c(FKBaseActivity.f11750o, context, 0, 0, 6, null);
        }
    }

    public static final void w1(ChatRecommendActivity this$0) {
        s.i(this$0, "this$0");
        int i10 = R$id.chat_rcmd_user_des_txt;
        if (((TextView) this$0.k1(i10)).getLineCount() > 3) {
            ((TextView) this$0.k1(i10)).setMaxLines(3);
            ((ImageView) this$0.k1(R$id.chat_rcmd_arrow)).setVisibility(0);
        } else {
            ((ImageView) this$0.k1(R$id.chat_rcmd_arrow)).setVisibility(8);
        }
        ((TextView) this$0.k1(i10)).setVisibility(0);
    }

    public final void A1() {
        ChatStateActivity.f13122t.a(this, new FKSensorContext(Q0(), SensorPosition.Message, null, SensorScene.Chat));
    }

    public final void B1() {
        int i10 = R$id.chat_recommend_view_pager;
        ((ViewPager2) k1(i10)).setAdapter(x1());
        ((ViewPager2) k1(i10)).setPageTransformer(new ChatRecommendPageTransformer());
        ((ViewPager2) k1(i10)).setUserInputEnabled(false);
        ((TextView) k1(R$id.long_click_tip)).setVisibility(s.d(g.f52734a.K(), Boolean.TRUE) ? 0 : 8);
    }

    public final void C1(User user) {
        if (user.userId().length() == 0) {
            return;
        }
        this.f13117t = true;
        ChatDetailActivity.f13276r.a(this, new ChatBundleData(user, user.userId(), y1(), null, false, true, false, false, false, MetricsProto.MetricsEvent.ACTION_DELETION_HELPER_DOWNLOADS_DELETION_FAIL, null));
    }

    public final void D1() {
        g gVar = g.f52734a;
        Boolean S0 = gVar.S0();
        Boolean bool = Boolean.FALSE;
        if (s.d(S0, bool)) {
            return;
        }
        gVar.j3(bool);
        k1(R$id.chat_recommend_guide_svga_bg).setVisibility(0);
        int i10 = R$id.chat_recommend_guide_svga;
        ((FKSVGAImageView) k1(i10)).setVisibility(0);
        FKSVGAImageView chat_recommend_guide_svga = (FKSVGAImageView) k1(i10);
        s.h(chat_recommend_guide_svga, "chat_recommend_guide_svga");
        FKSVGAImageView.F(chat_recommend_guide_svga, "chat_recommend_guide.svga", null, new Function0<p>() { // from class: com.cupidapp.live.chat.activity.ChatRecommendActivity$startGuideAnimation$1
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
                ChatRecommendActivity.this.k1(R$id.chat_recommend_guide_svga_bg).setVisibility(8);
                ((FKSVGAImageView) ChatRecommendActivity.this.k1(R$id.chat_recommend_guide_svga)).setVisibility(8);
            }
        }, 2, null);
    }

    public final void E1() {
        if (this.f13115r == kotlin.collections.s.l(this.f13116s)) {
            finish();
            A1();
        } else {
            this.f13115r++;
            ((ViewPager2) k1(R$id.chat_recommend_view_pager)).setCurrentItem(this.f13115r);
            v1();
        }
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity
    @NotNull
    public SensorPosition Q0() {
        return SensorPosition.RecommendedChat;
    }

    @Nullable
    public View k1(int i10) {
        Map<Integer, View> map = this.f13119v;
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
        setContentView(R$layout.activity_chat_recommend);
        B1();
        z1();
        s1();
        j1.c.b(j1.c.f50228a, SensorPosition.RecommendedChat, null, null, 6, null);
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.f13117t) {
            this.f13117t = false;
            E1();
        }
    }

    public final void s1() {
        ((FKTitleBarLayout) k1(R$id.chat_recommend_title_bar)).setLeftImageClickEvent(new Function1<View, p>() { // from class: com.cupidapp.live.chat.activity.ChatRecommendActivity$bindClickEvent$1
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
                ChatRecommendActivity.this.onBackPressed();
            }
        });
        FKClickAnimationLayout chat_recommend_next_btn = (FKClickAnimationLayout) k1(R$id.chat_recommend_next_btn);
        s.h(chat_recommend_next_btn, "chat_recommend_next_btn");
        y.d(chat_recommend_next_btn, new Function1<View, p>() { // from class: com.cupidapp.live.chat.activity.ChatRecommendActivity$bindClickEvent$2
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
                List list;
                int i10;
                list = ChatRecommendActivity.this.f13116s;
                i10 = ChatRecommendActivity.this.f13115r;
                User user = (User) CollectionsKt___CollectionsKt.W(list, i10);
                if (user == null) {
                    return;
                }
                SensorsLogKeyButtonClick.ChatRecommend.NEXT.clickWithUserId(user.userId());
                Observable<Result<Object>> n10 = NetworkClient.f11868a.h().n(user.userId());
                final ChatRecommendActivity chatRecommendActivity = ChatRecommendActivity.this;
                Disposable disposed = n10.flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<Object, p>() { // from class: com.cupidapp.live.chat.activity.ChatRecommendActivity$bindClickEvent$2$invoke$$inlined$handle$default$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ p invoke(Object obj) {
                        invoke2(obj);
                        return p.f51048a;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object obj) {
                        ChatRecommendActivity.this.E1();
                    }
                }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, chatRecommendActivity)));
                if (disposed != null) {
                    s.h(disposed, "disposed");
                    if (chatRecommendActivity != null) {
                        chatRecommendActivity.H(disposed);
                    }
                }
                s.h(disposed, "disposed");
            }
        });
        int i10 = R$id.chat_recommend_greet_btn;
        FKClickAnimationLayout chat_recommend_greet_btn = (FKClickAnimationLayout) k1(i10);
        s.h(chat_recommend_greet_btn, "chat_recommend_greet_btn");
        y.c(chat_recommend_greet_btn, new Function1<View, p>() { // from class: com.cupidapp.live.chat.activity.ChatRecommendActivity$bindClickEvent$3
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
                List list;
                int i11;
                list = ChatRecommendActivity.this.f13116s;
                i11 = ChatRecommendActivity.this.f13115r;
                final User user = (User) CollectionsKt___CollectionsKt.W(list, i11);
                if (user == null) {
                    return;
                }
                ((TextView) ChatRecommendActivity.this.k1(R$id.long_click_tip)).setVisibility(8);
                g.f52734a.u2(Boolean.FALSE);
                BottomFaceDialog a10 = BottomFaceDialog.f13137d.a();
                FragmentManager supportFragmentManager = ChatRecommendActivity.this.getSupportFragmentManager();
                s.h(supportFragmentManager, "supportFragmentManager");
                final ChatRecommendActivity chatRecommendActivity = ChatRecommendActivity.this;
                a10.S0(supportFragmentManager, new BottomFaceDialog.b() { // from class: com.cupidapp.live.chat.activity.ChatRecommendActivity$bindClickEvent$3.1
                    @Override // com.cupidapp.live.chat.fragment.BottomFaceDialog.b
                    public void a(@NotNull CustomEmojiCode face) {
                        s.i(face, "face");
                        GroupSocialLog.f18708a.T(User.this.userId(), chatRecommendActivity.Q0(), face.getEmojiEnCode());
                        Observable<Result<Object>> k10 = NetworkClient.f11868a.h().k(User.this.userId(), face.getEmojiCNCode());
                        final ChatRecommendActivity chatRecommendActivity2 = chatRecommendActivity;
                        final User user2 = User.this;
                        Disposable disposed = k10.flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<Object, p>() { // from class: com.cupidapp.live.chat.activity.ChatRecommendActivity$bindClickEvent$3$1$itemClick$$inlined$handle$default$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ p invoke(Object obj) {
                                invoke2(obj);
                                return p.f51048a;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(Object obj) {
                                ChatRecommendActivity.this.C1(user2);
                            }
                        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, chatRecommendActivity2)));
                        if (disposed != null) {
                            s.h(disposed, "disposed");
                            if (chatRecommendActivity2 != null) {
                                chatRecommendActivity2.H(disposed);
                            }
                        }
                        s.h(disposed, "disposed");
                    }
                });
            }
        });
        FKClickAnimationLayout chat_recommend_greet_btn2 = (FKClickAnimationLayout) k1(i10);
        s.h(chat_recommend_greet_btn2, "chat_recommend_greet_btn");
        y.d(chat_recommend_greet_btn2, new Function1<View, p>() { // from class: com.cupidapp.live.chat.activity.ChatRecommendActivity$bindClickEvent$4
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
                List list;
                int i11;
                list = ChatRecommendActivity.this.f13116s;
                i11 = ChatRecommendActivity.this.f13115r;
                final User user = (User) CollectionsKt___CollectionsKt.W(list, i11);
                if (user == null) {
                    return;
                }
                SensorsLogKeyButtonClick.ChatRecommend.GREET.clickWithUserId(user.userId());
                Observable<Result<Object>> k10 = NetworkClient.f11868a.h().k(user.userId(), CustomEmojiCode.Greet.getEmojiCNCode());
                final ChatRecommendActivity chatRecommendActivity = ChatRecommendActivity.this;
                Disposable disposed = k10.flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<Object, p>() { // from class: com.cupidapp.live.chat.activity.ChatRecommendActivity$bindClickEvent$4$invoke$$inlined$handle$default$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ p invoke(Object obj) {
                        invoke2(obj);
                        return p.f51048a;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object obj) {
                        ChatRecommendActivity.this.C1(user);
                    }
                }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, chatRecommendActivity)));
                if (disposed != null) {
                    s.h(disposed, "disposed");
                    if (chatRecommendActivity != null) {
                        chatRecommendActivity.H(disposed);
                    }
                }
                s.h(disposed, "disposed");
            }
        });
        ImageView chat_rcmd_arrow = (ImageView) k1(R$id.chat_rcmd_arrow);
        s.h(chat_rcmd_arrow, "chat_rcmd_arrow");
        y.d(chat_rcmd_arrow, new Function1<View, p>() { // from class: com.cupidapp.live.chat.activity.ChatRecommendActivity$bindClickEvent$5
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
                ChatRecommendActivity chatRecommendActivity = ChatRecommendActivity.this;
                int i11 = R$id.chat_rcmd_arrow;
                if (((ImageView) chatRecommendActivity.k1(i11)).getRotation() == 0.0f) {
                    ((ImageView) ChatRecommendActivity.this.k1(i11)).setRotation(180.0f);
                    ((TextView) ChatRecommendActivity.this.k1(R$id.chat_rcmd_user_des_txt)).setMaxLines(12);
                    ChatRecommendActivity.this.k1(R$id.user_shadow).setBackgroundColor(ContextCompat.getColor(ChatRecommendActivity.this, R$color.app_black_45_alpha));
                } else {
                    ((ImageView) ChatRecommendActivity.this.k1(i11)).setRotation(0.0f);
                    ((TextView) ChatRecommendActivity.this.k1(R$id.chat_rcmd_user_des_txt)).setMaxLines(3);
                    ChatRecommendActivity.this.k1(R$id.user_shadow).setBackgroundColor(ContextCompat.getColor(ChatRecommendActivity.this, 17170445));
                }
            }
        });
    }

    public final void t1(List<User> list) {
        ((ConstraintLayout) k1(R$id.have_chat_recommend_layout)).setVisibility(0);
        ((ConstraintLayout) k1(R$id.no_chat_recommend_layout)).setVisibility(8);
        this.f13116s.addAll(list);
        for (User user : list) {
            List<Object> j10 = x1().j();
            List<ImageModel> avatarFeeds = user.getAvatarFeeds();
            if (avatarFeeds == null) {
                avatarFeeds = new ArrayList<>();
            }
            j10.add(new ChatRecommendImageUiModel(avatarFeeds));
        }
        v1();
        x1().notifyDataSetChanged();
        D1();
    }

    public final void u1() {
        GroupOthersLog.W(GroupOthersLog.f18702a, Q0(), null, 2, null);
        ((ConstraintLayout) k1(R$id.have_chat_recommend_layout)).setVisibility(8);
        ((ConstraintLayout) k1(R$id.no_chat_recommend_layout)).setVisibility(0);
        ImageLoaderView no_chat_recommend_bg = (ImageLoaderView) k1(R$id.no_chat_recommend_bg);
        s.h(no_chat_recommend_bg, "no_chat_recommend_bg");
        ImageLoaderView.f(no_chat_recommend_bg, new com.cupidapp.live.base.imageloader.b(false, null, null, null, Integer.valueOf(R$drawable.chat_recommend_bg), null, null, 0, 0, null, null, null, null, false, 0, 0, false, null, null, 524271, null), null, 2, null);
        FKUniversalButton no_chat_recommend_btn = (FKUniversalButton) k1(R$id.no_chat_recommend_btn);
        s.h(no_chat_recommend_btn, "no_chat_recommend_btn");
        y.d(no_chat_recommend_btn, new Function1<View, p>() { // from class: com.cupidapp.live.chat.activity.ChatRecommendActivity$configNoChatRecommendUi$1
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
                ChatRecommendActivity.this.onBackPressed();
            }
        });
        FKUniversalButton no_rcmd_see_more = (FKUniversalButton) k1(R$id.no_rcmd_see_more);
        s.h(no_rcmd_see_more, "no_rcmd_see_more");
        y.d(no_rcmd_see_more, new Function1<View, p>() { // from class: com.cupidapp.live.chat.activity.ChatRecommendActivity$configNoChatRecommendUi$2
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
                SensorsLogKeyButtonClick.ChatRecommend.LOOK_UP_FRIEND_STATUS.click();
                ChatRecommendActivity.this.finish();
                ChatRecommendActivity.this.A1();
            }
        });
    }

    public final void v1() {
        User user = (User) CollectionsKt___CollectionsKt.W(this.f13116s, this.f13115r);
        if (user == null) {
            return;
        }
        TextView chat_recommend_greet_txt = (TextView) k1(R$id.chat_recommend_greet_txt);
        s.h(chat_recommend_greet_txt, "chat_recommend_greet_txt");
        u.e(chat_recommend_greet_txt, R$mipmap.icon_chat_greet, 0, 0, 0, 14, null);
        ((TextView) k1(R$id.chat_recommend_user_summary)).setText(user.getBasicInfo());
        ((TextView) k1(R$id.chat_recommend_user_name)).setText(user.getName());
        ((UserIconViewLayout) k1(R$id.chat_recommend_user_vip)).c(user.getUserVipModel(), SensorPosition.RecommendedChat, UserIconViewLayout.VipIconPositionRef.Other, false);
        String activeDesc = user.getActiveDesc();
        boolean z10 = true;
        if (activeDesc == null || activeDesc.length() == 0) {
            ((TextView) k1(R$id.chat_recommend_user_active_time)).setVisibility(8);
        } else {
            int i10 = R$id.chat_recommend_user_active_time;
            ((TextView) k1(i10)).setVisibility(0);
            ((TextView) k1(i10)).setText(user.getActiveDesc());
        }
        ((LinearLayout) k1(R$id.chat_recommend_want_chat_tip)).setVisibility(0);
        ImageLoaderView chat_recommend_tip_avatar_img = (ImageLoaderView) k1(R$id.chat_recommend_tip_avatar_img);
        s.h(chat_recommend_tip_avatar_img, "chat_recommend_tip_avatar_img");
        List<ImageModel> avatarFeeds = user.getAvatarFeeds();
        ImageLoaderView.g(chat_recommend_tip_avatar_img, avatarFeeds != null ? (ImageModel) CollectionsKt___CollectionsKt.V(avatarFeeds) : null, null, null, 6, null);
        if (user.getChatStatus() != null) {
            ((TextView) k1(R$id.chat_recommend_tip_text)).setText(R$string.want_to_chat_say_hi);
        } else {
            ((TextView) k1(R$id.chat_recommend_tip_text)).setText(R$string.recently_active_chat_now);
        }
        String summary = user.getSummary();
        if (summary != null && summary.length() != 0) {
            z10 = false;
        }
        if (z10) {
            ((RelativeLayout) k1(R$id.chat_rcmd_user_des)).setVisibility(8);
            return;
        }
        int i11 = R$id.chat_rcmd_user_des_txt;
        ((TextView) k1(i11)).setText(user.getSummary());
        ((TextView) k1(i11)).post(new Runnable() { // from class: com.cupidapp.live.chat.activity.a
            @Override // java.lang.Runnable
            public final void run() {
                ChatRecommendActivity.w1(ChatRecommendActivity.this);
            }
        });
        ((RelativeLayout) k1(R$id.chat_rcmd_user_des)).setVisibility(0);
    }

    public final ChatRecommendAdapter x1() {
        return (ChatRecommendAdapter) this.f13114q.getValue();
    }

    public final FKSensorContext y1() {
        return (FKSensorContext) this.f13118u.getValue();
    }

    public final void z1() {
        Disposable disposed = NetworkClient.f11868a.h().j().flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<ListResult<User>, p>() { // from class: com.cupidapp.live.chat.activity.ChatRecommendActivity$getUserData$$inlined$handle$default$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(ListResult<User> listResult) {
                m2479invoke(listResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2479invoke(ListResult<User> listResult) {
                List<User> list = listResult.getList();
                if (list == null || list.isEmpty()) {
                    ChatRecommendActivity.this.u1();
                } else {
                    ChatRecommendActivity.this.t1(list);
                }
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, this)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            H(disposed);
        }
        s.h(disposed, "disposed");
    }
}

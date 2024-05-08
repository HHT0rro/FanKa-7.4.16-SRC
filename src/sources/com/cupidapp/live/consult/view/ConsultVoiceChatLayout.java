package com.cupidapp.live.consult.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.grpc.GrpcIM;
import com.cupidapp.live.base.imageloader.BlurModel;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.imageloader.RoundCornerModel;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.i;
import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.base.network.model.SwipeCardUserLikeResult;
import com.cupidapp.live.base.network.model.ViewProfilePrefer;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorScene;
import com.cupidapp.live.base.utils.j;
import com.cupidapp.live.base.utils.n0;
import com.cupidapp.live.base.view.BaseLayout;
import com.cupidapp.live.base.view.animation.FKLottieAnimationView;
import com.cupidapp.live.base.view.dialog.FKActionSheetDialog;
import com.cupidapp.live.base.view.dialog.FKActionSheetItemModel;
import com.cupidapp.live.consult.model.ConsultConnectSuccessGrpcModel;
import com.cupidapp.live.consult.model.ConsultConnectType;
import com.cupidapp.live.consult.model.ConsultConnectUserModel;
import com.cupidapp.live.consult.model.ConsultLiveModel;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.track.group.GroupSocialLog;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import x2.a;
import z0.h;
import z0.v;
import z0.y;
import z0.z;

/* compiled from: ConsultVoiceChatLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ConsultVoiceChatLayout extends BaseLayout {

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public Function0<p> f13874d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public Disposable f13875e;

    /* renamed from: f, reason: collision with root package name */
    public final int f13876f;

    /* renamed from: g, reason: collision with root package name */
    public int f13877g;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public SensorPosition f13878h;

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    public User f13879i;

    /* renamed from: j, reason: collision with root package name */
    @Nullable
    public User f13880j;

    /* renamed from: k, reason: collision with root package name */
    @Nullable
    public String f13881k;

    /* renamed from: l, reason: collision with root package name */
    @Nullable
    public String f13882l;

    /* renamed from: m, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f13883m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConsultVoiceChatLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f13883m = new LinkedHashMap();
        this.f13876f = 60;
        this.f13878h = SensorPosition.Unknown;
        A();
    }

    public static final void D(Function1 tmp0, Object obj) {
        s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final RoundCornerModel getRoundCornerModel() {
        return new RoundCornerModel(true, 0, h.c(this, 1.0f), -1, false, false, false, false, 242, null);
    }

    public final void A() {
        z.a(this, R$layout.layout_consult_voice_chat, true);
    }

    public final void B(@NotNull Map<String, Integer> volumes) {
        s.i(volumes, "volumes");
        Iterator<Map.Entry<String, Integer>> iterator2 = volumes.entrySet().iterator2();
        while (iterator2.hasNext()) {
            String key = iterator2.next().getKey();
            User user = this.f13879i;
            if (s.d(key, user != null ? user.userId() : null)) {
                int i10 = R$id.consult_voice_chat_left_animation;
                if (!((FKLottieAnimationView) f(i10)).q()) {
                    ((FKLottieAnimationView) f(i10)).setVisibility(0);
                    ((FKLottieAnimationView) f(i10)).L();
                }
            } else {
                User user2 = this.f13880j;
                if (s.d(key, user2 != null ? user2.userId() : null)) {
                    int i11 = R$id.consult_voice_chat_right_animation;
                    if (!((FKLottieAnimationView) f(i11)).q()) {
                        ((FKLottieAnimationView) f(i11)).setVisibility(0);
                        ((FKLottieAnimationView) f(i11)).L();
                    }
                }
            }
        }
    }

    public final void C() {
        ((TextView) f(R$id.consult_voice_chat_time_text)).setText(v.b(this.f13877g));
        Disposable disposable = this.f13875e;
        if (disposable != null) {
            disposable.dispose();
        }
        Observable<Long> observeOn = Observable.interval(1L, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread());
        final Function1<Long, p> function1 = new Function1<Long, p>() { // from class: com.cupidapp.live.consult.view.ConsultVoiceChatLayout$startCountDown$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Long l10) {
                invoke2(l10);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Long l10) {
                int i10;
                int i11;
                int i12;
                int i13;
                int i14;
                User user;
                Function0<p> chargeCallback;
                ConsultVoiceChatLayout consultVoiceChatLayout = ConsultVoiceChatLayout.this;
                i10 = consultVoiceChatLayout.f13877g;
                consultVoiceChatLayout.f13877g = i10 + 1;
                TextView textView = (TextView) ConsultVoiceChatLayout.this.f(R$id.consult_voice_chat_time_text);
                i11 = ConsultVoiceChatLayout.this.f13877g;
                textView.setText(v.b(i11));
                j.a aVar = j.f12332a;
                i12 = ConsultVoiceChatLayout.this.f13877g;
                aVar.a("ConsultVoiceChatLayout", "connectTime: " + i12);
                i13 = ConsultVoiceChatLayout.this.f13877g;
                i14 = ConsultVoiceChatLayout.this.f13876f;
                if (i13 % i14 == 0) {
                    user = ConsultVoiceChatLayout.this.f13880j;
                    if (!(user != null && user.isMyself()) || (chargeCallback = ConsultVoiceChatLayout.this.getChargeCallback()) == null) {
                        return;
                    }
                    chargeCallback.invoke();
                }
            }
        };
        this.f13875e = observeOn.subscribe(new Consumer() { // from class: com.cupidapp.live.consult.view.d
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ConsultVoiceChatLayout.D(Function1.this, obj);
            }
        });
    }

    public final void E() {
        ((TextView) f(R$id.consult_voice_chat_time_text)).setText("");
        Disposable disposable = this.f13875e;
        if (disposable != null) {
            disposable.dispose();
        }
        this.f13875e = null;
        this.f13877g = 0;
    }

    public final void F() {
        int i10 = R$id.consult_voice_chat_left_animation;
        ((FKLottieAnimationView) f(i10)).M();
        ((FKLottieAnimationView) f(i10)).setVisibility(4);
        int i11 = R$id.consult_voice_chat_right_animation;
        ((FKLottieAnimationView) f(i11)).M();
        ((FKLottieAnimationView) f(i11)).setVisibility(4);
    }

    @Nullable
    public View f(int i10) {
        Map<Integer, View> map = this.f13883m;
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

    @Nullable
    public final Function0<p> getChargeCallback() {
        return this.f13874d;
    }

    @Override // com.cupidapp.live.base.view.BaseLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        E();
        F();
    }

    public final void p() {
        final User user = this.f13880j;
        if (user == null || user.isMyself()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new FKActionSheetItemModel(R$string.report, null, null, null, null, new Function0<p>() { // from class: com.cupidapp.live.consult.view.ConsultVoiceChatLayout$clickRightAvatarShowActionSheet$report$1
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
                String str;
                SensorPosition sensorPosition;
                n0 n0Var = n0.f12353a;
                str = ConsultVoiceChatLayout.this.f13881k;
                sensorPosition = ConsultVoiceChatLayout.this.f13878h;
                j.a.b(com.cupidapp.live.base.router.j.f12156c, ConsultVoiceChatLayout.this.getContext(), n0Var.b(str, sensorPosition, user.userId()), null, 4, null);
            }
        }, 30, null));
        FKActionSheetDialog.f12692f.a(getContext()).g(true).f(arrayList).h();
    }

    public final void q(@Nullable ImageModel imageModel) {
        ImageLoaderView consult_voice_chat_left_level = (ImageLoaderView) f(R$id.consult_voice_chat_left_level);
        s.h(consult_voice_chat_left_level, "consult_voice_chat_left_level");
        ImageLoaderView.g(consult_voice_chat_left_level, imageModel, null, null, 6, null);
    }

    public final void r(@NotNull User user) {
        s.i(user, "user");
        User user2 = this.f13879i;
        if (user2 != null) {
            user2.setAloha(user.getAloha());
        }
        User user3 = this.f13879i;
        if (user3 == null) {
            return;
        }
        if (!user3.getAloha() && !user3.isMyself()) {
            ((ImageView) f(R$id.consult_voice_chat_left_aloha_btn)).setVisibility(0);
        } else {
            ((ImageView) f(R$id.consult_voice_chat_left_aloha_btn)).setVisibility(8);
        }
    }

    public final void s() {
        ImageLoaderView consult_voice_chat_right_avatar = (ImageLoaderView) f(R$id.consult_voice_chat_right_avatar);
        s.h(consult_voice_chat_right_avatar, "consult_voice_chat_right_avatar");
        ImageLoaderView.f(consult_voice_chat_right_avatar, new com.cupidapp.live.base.imageloader.b(false, null, null, null, Integer.valueOf(R$mipmap.ic_consult_add_connect), null, null, 0, 0, null, null, null, null, false, 0, 0, false, null, null, 524271, null), null, 2, null);
        ((TextView) f(R$id.consult_voice_chat_right_name)).setText(R$string.leave_a_seat_vacant);
        int i10 = R$id.consult_voice_chat_current_state;
        ((TextView) f(i10)).setText(R$string.no_connect);
        ((TextView) f(i10)).setTextColor(com.cupidapp.live.base.utils.h.a(-1, 0.3f));
        ((TextView) f(R$id.consult_voice_chat_time_text)).setVisibility(8);
        this.f13882l = getContext().getString(R$string.no_connect_tip);
        ((TextView) f(R$id.consult_voice_chat_tip_text)).setText(this.f13882l);
        v(GrpcIM.INSTANCE.getGrpcIsConnecting());
    }

    public final void setChargeCallback(@Nullable Function0<p> function0) {
        this.f13874d = function0;
    }

    public final void setCurrentPagePosition(@NotNull SensorPosition position) {
        s.i(position, "position");
        this.f13878h = position;
    }

    public final void t(User user) {
        String string;
        ImageLoaderView consult_voice_chat_right_avatar = (ImageLoaderView) f(R$id.consult_voice_chat_right_avatar);
        s.h(consult_voice_chat_right_avatar, "consult_voice_chat_right_avatar");
        ImageLoaderView.g(consult_voice_chat_right_avatar, user != null ? user.getAvatarImage() : null, new com.cupidapp.live.base.imageloader.b(false, null, null, null, null, null, null, 0, 0, null, null, getRoundCornerModel(), new BlurModel(9.0f, 0, 2, null), false, 0, 0, false, null, null, 518143, null), null, 4, null);
        ((TextView) f(R$id.consult_voice_chat_right_name)).setText(user != null ? user.getName() : null);
        int i10 = R$id.consult_voice_chat_current_state;
        ((TextView) f(i10)).setText(R$string.normal_connect);
        ((TextView) f(i10)).setTextColor(-7017148);
        ((TextView) f(R$id.consult_voice_chat_time_text)).setVisibility(0);
        if (user != null && user.isMyself()) {
            string = getContext().getString(R$string.you_connect_tip);
        } else {
            string = getContext().getString(R$string.normal_connect_tip);
        }
        this.f13882l = string;
        ((TextView) f(R$id.consult_voice_chat_tip_text)).setText(this.f13882l);
    }

    public final void u(boolean z10) {
        String string;
        ImageLoaderView consult_voice_chat_right_avatar = (ImageLoaderView) f(R$id.consult_voice_chat_right_avatar);
        s.h(consult_voice_chat_right_avatar, "consult_voice_chat_right_avatar");
        ImageLoaderView.f(consult_voice_chat_right_avatar, new com.cupidapp.live.base.imageloader.b(false, null, null, null, Integer.valueOf(R$mipmap.ic_consult_connect_anonymous_avatar), null, null, 0, 0, null, null, getRoundCornerModel(), null, false, 0, 0, false, null, null, 522223, null), null, 2, null);
        ((TextView) f(R$id.consult_voice_chat_right_name)).setText(R$string.anonymous_user);
        int i10 = R$id.consult_voice_chat_current_state;
        ((TextView) f(i10)).setText(R$string.one_on_one_connect);
        ((TextView) f(i10)).setTextColor(-7017148);
        ((TextView) f(R$id.consult_voice_chat_time_text)).setVisibility(0);
        if (z10) {
            string = getContext().getString(R$string.you_connect_tip);
        } else {
            string = getContext().getString(R$string.one_on_one_connect_tip);
        }
        this.f13882l = string;
        ((TextView) f(R$id.consult_voice_chat_tip_text)).setText(this.f13882l);
    }

    public final void v(boolean z10) {
        String string;
        TextView textView = (TextView) f(R$id.consult_voice_chat_tip_text);
        if (z10) {
            string = this.f13882l;
        } else {
            string = getContext().getString(R$string.grpc_disconnection_prompt);
        }
        textView.setText(string);
    }

    public final void w(@NotNull final ConsultLiveModel model) {
        s.i(model, "model");
        ((ConstraintLayout) f(R$id.consult_voice_chat_root_layout)).setVisibility(0);
        this.f13879i = model.getUser();
        int i10 = R$id.consult_voice_chat_left_avatar;
        ImageLoaderView consult_voice_chat_left_avatar = (ImageLoaderView) f(i10);
        s.h(consult_voice_chat_left_avatar, "consult_voice_chat_left_avatar");
        ImageLoaderView.g(consult_voice_chat_left_avatar, model.getUser().getAvatarImage(), null, null, 6, null);
        ImageLoaderView consult_voice_chat_left_avatar2 = (ImageLoaderView) f(i10);
        s.h(consult_voice_chat_left_avatar2, "consult_voice_chat_left_avatar");
        y.d(consult_voice_chat_left_avatar2, new Function1<View, p>() { // from class: com.cupidapp.live.consult.view.ConsultVoiceChatLayout$configVoiceChatData$1
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
                if (ConsultLiveModel.this.getUser().isMyself()) {
                    return;
                }
                EventBus.c().l(ConsultLiveModel.this.createMiniProfileModel());
            }
        });
        if (!model.getUser().getAloha() && !model.getUser().isMyself()) {
            ((ImageView) f(R$id.consult_voice_chat_left_aloha_btn)).setVisibility(0);
        } else {
            ((ImageView) f(R$id.consult_voice_chat_left_aloha_btn)).setVisibility(8);
        }
        ((TextView) f(R$id.consult_voice_chat_left_name)).setText(model.getUser().getName());
        ImageLoaderView consult_voice_chat_left_level = (ImageLoaderView) f(R$id.consult_voice_chat_left_level);
        s.h(consult_voice_chat_left_level, "consult_voice_chat_left_level");
        ImageLoaderView.g(consult_voice_chat_left_level, model.getLevelIcon(), null, null, 6, null);
        if (model.getUser().isMyself()) {
            ((TextView) f(R$id.consult_voice_chat_tip_text)).setVisibility(8);
        } else {
            ((TextView) f(R$id.consult_voice_chat_tip_text)).setVisibility(0);
        }
        ConsultConnectUserModel connectingUserInfo = model.getConnectingUserInfo();
        if (connectingUserInfo == null) {
            s();
            this.f13880j = null;
        } else {
            String userId = connectingUserInfo.getUser().userId();
            User user = this.f13880j;
            if (s.d(userId, user != null ? user.userId() : null)) {
                return;
            }
            String voiceConnectType = model.getVoiceConnectType();
            if (s.d(voiceConnectType, ConsultConnectType.NORMAL.getValue())) {
                t(connectingUserInfo.getUser());
            } else if (s.d(voiceConnectType, ConsultConnectType.ONE_ON_ONE.getValue())) {
                u(connectingUserInfo.getUser().isMyself());
            }
            this.f13880j = connectingUserInfo.getUser();
            this.f13877g = (int) (connectingUserInfo.getStartDurationMills() / 1000);
            C();
        }
        this.f13881k = connectingUserInfo != null ? connectingUserInfo.getConnectedUserReportData() : null;
        ImageView consult_voice_chat_left_aloha_btn = (ImageView) f(R$id.consult_voice_chat_left_aloha_btn);
        s.h(consult_voice_chat_left_aloha_btn, "consult_voice_chat_left_aloha_btn");
        y.d(consult_voice_chat_left_aloha_btn, new Function1<View, p>() { // from class: com.cupidapp.live.consult.view.ConsultVoiceChatLayout$configVoiceChatData$2
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
                ConsultVoiceChatLayout.this.y(model);
            }
        });
        ImageLoaderView consult_voice_chat_right_avatar = (ImageLoaderView) f(R$id.consult_voice_chat_right_avatar);
        s.h(consult_voice_chat_right_avatar, "consult_voice_chat_right_avatar");
        y.d(consult_voice_chat_right_avatar, new Function1<View, p>() { // from class: com.cupidapp.live.consult.view.ConsultVoiceChatLayout$configVoiceChatData$3
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
                ConsultVoiceChatLayout.this.p();
            }
        });
    }

    public final void x(@NotNull ConsultConnectSuccessGrpcModel successModel) {
        s.i(successModel, "successModel");
        this.f13880j = successModel.getUser();
        this.f13881k = successModel.getConnectedUserReportData();
        String voiceConnectType = successModel.getVoiceConnectType();
        if (s.d(voiceConnectType, ConsultConnectType.NORMAL.getValue())) {
            t(successModel.getUser());
        } else if (s.d(voiceConnectType, ConsultConnectType.ONE_ON_ONE.getValue())) {
            u(successModel.getUser().isMyself());
        }
        this.f13877g = 0;
        C();
    }

    public final void y(final ConsultLiveModel consultLiveModel) {
        Disposable disposed = a.C0836a.o(NetworkClient.f11868a.N(), consultLiveModel.getUser().userId(), null, null, ViewProfilePrefer.VoiceRoom.getValue(), 0, null, null, consultLiveModel.getId(), 118, null).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<SwipeCardUserLikeResult, p>() { // from class: com.cupidapp.live.consult.view.ConsultVoiceChatLayout$followUser$$inlined$handle$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(SwipeCardUserLikeResult swipeCardUserLikeResult) {
                m2542invoke(swipeCardUserLikeResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2542invoke(SwipeCardUserLikeResult swipeCardUserLikeResult) {
                ConsultLiveModel.this.getUser().setAloha(true);
                ((ImageView) this.f(R$id.consult_voice_chat_left_aloha_btn)).setVisibility(8);
                GroupSocialLog.f18708a.B(true, SensorScene.CONSULT_LIVE.getValue(), ConsultLiveModel.this.getUser().userId(), (r52 & 8) != 0 ? 1 : 0, (r52 & 16) != 0 ? null : null, (r52 & 32) != 0 ? null : null, (r52 & 64) != 0 ? false : false, (r52 & 128) != 0 ? null : null, (r52 & 256) != 0 ? null : null, (r52 & 512) != 0 ? false : false, (r52 & 1024) != 0 ? null : null, (r52 & 2048) != 0 ? null : null, (r52 & 4096) != 0 ? 0 : 0, (r52 & 8192) != 0 ? null : null, (r52 & 16384) != 0 ? false : false, (32768 & r52) != 0 ? null : null, (65536 & r52) != 0 ? null : null, (131072 & r52) != 0 ? null : null, (262144 & r52) != 0 ? null : null, (524288 & r52) != 0 ? null : null, (1048576 & r52) != 0 ? null : null, (2097152 & r52) != 0 ? null : null, (4194304 & r52) != 0 ? null : null, (r52 & 8388608) != 0 ? null : null);
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, this)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            H(disposed);
        }
        s.h(disposed, "disposed");
    }

    public final void z() {
        this.f13880j = null;
        this.f13881k = null;
        s();
        E();
        F();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConsultVoiceChatLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f13883m = new LinkedHashMap();
        this.f13876f = 60;
        this.f13878h = SensorPosition.Unknown;
        A();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConsultVoiceChatLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f13883m = new LinkedHashMap();
        this.f13876f = 60;
        this.f13878h = SensorPosition.Unknown;
        A();
    }
}

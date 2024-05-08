package com.cupidapp.live.voiceparty.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$raw;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.livedata.EventObserver;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.model.ProfileResult;
import com.cupidapp.live.base.network.model.StateResult;
import com.cupidapp.live.base.network.model.ViewProfilePrefer;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.base.sensorslog.PopupButtonName;
import com.cupidapp.live.base.sensorslog.PopupName;
import com.cupidapp.live.base.sensorslog.ProfileSensorContext;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick;
import com.cupidapp.live.base.utils.i;
import com.cupidapp.live.base.utils.n0;
import com.cupidapp.live.base.view.FKTitleBarLayout;
import com.cupidapp.live.base.view.button.FKWithImageButton;
import com.cupidapp.live.maskparty.model.MaskPartyChatDiceModel;
import com.cupidapp.live.profile.activity.UserProfileActivity;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.track.group.GroupSocialLog;
import com.cupidapp.live.voiceparty.engine.IVoiceEngine;
import com.cupidapp.live.voiceparty.helper.VoicePartyPromptHelper;
import com.cupidapp.live.voiceparty.layout.VoiceAvatarLayout;
import com.cupidapp.live.voiceparty.layout.VoiceAvatarMarkType;
import com.cupidapp.live.voiceparty.layout.VoiceGameSessionLayout;
import com.cupidapp.live.voiceparty.layout.VoiceQuestionLayout;
import com.cupidapp.live.voiceparty.layout.VoiceUserInfoLayout;
import com.cupidapp.live.voiceparty.model.PublicProfileStatus;
import com.cupidapp.live.voiceparty.model.VoicePartyBtnType;
import com.cupidapp.live.voiceparty.model.VoicePartyDurationModel;
import com.cupidapp.live.voiceparty.model.VoicePartyGameSessionModel;
import com.cupidapp.live.voiceparty.model.VoicePartyGameSessionType;
import com.cupidapp.live.voiceparty.model.VoicePartyQuestionItemModel;
import com.cupidapp.live.voiceparty.model.VoicePartyRelationStatus;
import com.cupidapp.live.voiceparty.model.VoicePartyRightBtnType;
import com.cupidapp.live.voiceparty.model.VoicePartyRoomDissolveModel;
import com.cupidapp.live.voiceparty.model.VoicePartyRoomModel;
import com.cupidapp.live.voiceparty.viewmodel.VoicePartyViewModel;
import com.irisdt.client.post.PostAndSocialProtos;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p1.g;
import x2.a;
import z0.h;
import z0.u;
import z0.v;
import z0.y;

/* compiled from: VoicePartyActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class VoicePartyActivity extends FKBaseActivity {

    /* renamed from: y, reason: collision with root package name */
    @NotNull
    public static final a f18981y = new a(null);

    /* renamed from: z, reason: collision with root package name */
    public static boolean f18982z;

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    public final Lazy f18983q;

    /* renamed from: t, reason: collision with root package name */
    @Nullable
    public FrameLayout f18986t;

    /* renamed from: v, reason: collision with root package name */
    public boolean f18988v;

    /* renamed from: x, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f18990x = new LinkedHashMap();

    /* renamed from: r, reason: collision with root package name */
    @NotNull
    public final Lazy f18984r = kotlin.c.b(new Function0<i>() { // from class: com.cupidapp.live.voiceparty.activity.VoicePartyActivity$mVoiceRoomCountDownTimer$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final i invoke() {
            return new i();
        }
    });

    /* renamed from: s, reason: collision with root package name */
    @NotNull
    public final Lazy f18985s = kotlin.c.b(new Function0<i>() { // from class: com.cupidapp.live.voiceparty.activity.VoicePartyActivity$mInviteOtherCountDownTimer$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final i invoke() {
            return new i();
        }
    });

    /* renamed from: u, reason: collision with root package name */
    @NotNull
    public final Lazy f18987u = kotlin.c.b(new Function0<com.cupidapp.live.voiceparty.helper.b>() { // from class: com.cupidapp.live.voiceparty.activity.VoicePartyActivity$mSoundPlayHelper$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final com.cupidapp.live.voiceparty.helper.b invoke() {
            return new com.cupidapp.live.voiceparty.helper.b();
        }
    });

    /* renamed from: w, reason: collision with root package name */
    public boolean f18989w = true;

    /* compiled from: VoicePartyActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class Config implements Serializable {

        @NotNull
        private final String roomId;
        private final int sdkAppID;

        @NotNull
        private final String userSig;

        public Config(@NotNull String roomId, int i10, @NotNull String userSig) {
            s.i(roomId, "roomId");
            s.i(userSig, "userSig");
            this.roomId = roomId;
            this.sdkAppID = i10;
            this.userSig = userSig;
        }

        public static /* synthetic */ Config copy$default(Config config, String str, int i10, String str2, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = config.roomId;
            }
            if ((i11 & 2) != 0) {
                i10 = config.sdkAppID;
            }
            if ((i11 & 4) != 0) {
                str2 = config.userSig;
            }
            return config.copy(str, i10, str2);
        }

        @NotNull
        public final String component1() {
            return this.roomId;
        }

        public final int component2() {
            return this.sdkAppID;
        }

        @NotNull
        public final String component3() {
            return this.userSig;
        }

        @NotNull
        public final Config copy(@NotNull String roomId, int i10, @NotNull String userSig) {
            s.i(roomId, "roomId");
            s.i(userSig, "userSig");
            return new Config(roomId, i10, userSig);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Config)) {
                return false;
            }
            Config config = (Config) obj;
            return s.d(this.roomId, config.roomId) && this.sdkAppID == config.sdkAppID && s.d(this.userSig, config.userSig);
        }

        @NotNull
        public final String getRoomId() {
            return this.roomId;
        }

        public final int getSdkAppID() {
            return this.sdkAppID;
        }

        @NotNull
        public final String getUserSig() {
            return this.userSig;
        }

        public int hashCode() {
            return (((this.roomId.hashCode() * 31) + this.sdkAppID) * 31) + this.userSig.hashCode();
        }

        @NotNull
        public String toString() {
            return "Config(roomId=" + this.roomId + ", sdkAppID=" + this.sdkAppID + ", userSig=" + this.userSig + ")";
        }
    }

    /* compiled from: VoicePartyActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Intent a(@Nullable Context context, @NotNull Config config) {
            s.i(config, "config");
            Intent intent = new Intent(context, (Class<?>) VoicePartyActivity.class);
            z0.g.c(intent, config);
            return intent;
        }

        public final boolean b() {
            return VoicePartyActivity.f18982z;
        }
    }

    /* compiled from: VoicePartyActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f18991a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f18992b;

        static {
            int[] iArr = new int[VoicePartyRightBtnType.values().length];
            try {
                iArr[VoicePartyRightBtnType.PUBLIC_PROFILE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[VoicePartyRightBtnType.PROFILE_ALREADY_PUBLIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[VoicePartyRightBtnType.FOLLOW_HIM.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[VoicePartyRightBtnType.INVITE_FOLLOW_ME.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[VoicePartyRightBtnType.BOTH_GONE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f18991a = iArr;
            int[] iArr2 = new int[PublicProfileStatus.values().length];
            try {
                iArr2[PublicProfileStatus.BOTH_NONE_PUBLIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[PublicProfileStatus.ONLY_OTHER_PUBLIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[PublicProfileStatus.ONLY_MY_PUBLIC.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr2[PublicProfileStatus.BOTH_PUBLIC.ordinal()] = 4;
            } catch (NoSuchFieldError unused9) {
            }
            f18992b = iArr2;
        }
    }

    /* compiled from: VoicePartyActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class c implements VoiceGameSessionLayout.a {
        public c() {
        }

        @Override // com.cupidapp.live.voiceparty.layout.VoiceGameSessionLayout.a
        public void a() {
            VoicePartyActivity voicePartyActivity = VoicePartyActivity.this;
            VoiceUserInfoLayout voice_user_info_layout = (VoiceUserInfoLayout) voicePartyActivity.p1(R$id.voice_user_info_layout);
            s.h(voice_user_info_layout, "voice_user_info_layout");
            voicePartyActivity.N1(voice_user_info_layout);
        }

        @Override // com.cupidapp.live.voiceparty.layout.VoiceGameSessionLayout.a
        public void b(@NotNull VoicePartyGameSessionType type) {
            s.i(type, "type");
            if (type == VoicePartyGameSessionType.OTHER_INVITE_ME) {
                j1.i.f50236a.a(PopupName.INVITE_VOICE_GAME, PopupButtonName.Agree, VoicePartyActivity.this.Q0());
                VoicePartyActivity.this.Q1().callAgreeGameInviteApi();
            }
        }

        @Override // com.cupidapp.live.voiceparty.layout.VoiceGameSessionLayout.a
        public void c(boolean z10) {
            j1.i.f50236a.a(PopupName.DARK_MODEL_CONFIRM, z10 ? PopupButtonName.Agree : PopupButtonName.DisAgree, VoicePartyActivity.this.Q0());
            VoicePartyActivity.this.Q1().callAcceptOrRefuseLateNightInviteApi(z10);
        }

        @Override // com.cupidapp.live.voiceparty.layout.VoiceGameSessionLayout.a
        public void d(@NotNull MaskPartyChatDiceModel model) {
            s.i(model, "model");
            if (model.isWin()) {
                VoicePartyActivity.this.Q1().callQuestionListApi();
                ((VoiceAvatarLayout) VoicePartyActivity.this.p1(R$id.voice_party_my_avatar_layout)).c(true);
                ((VoiceAvatarLayout) VoicePartyActivity.this.p1(R$id.voice_party_other_avatar_layout)).c(false);
            } else {
                VoicePartyActivity.this.Q1().sendRollDiceLoseLiveData();
                ((VoiceAvatarLayout) VoicePartyActivity.this.p1(R$id.voice_party_other_avatar_layout)).c(true);
                ((VoiceAvatarLayout) VoicePartyActivity.this.p1(R$id.voice_party_my_avatar_layout)).c(false);
            }
        }

        @Override // com.cupidapp.live.voiceparty.layout.VoiceGameSessionLayout.a
        public void e() {
            VoicePartyActivity voicePartyActivity = VoicePartyActivity.this;
            VoiceUserInfoLayout voice_user_info_layout = (VoiceUserInfoLayout) voicePartyActivity.p1(R$id.voice_user_info_layout);
            s.h(voice_user_info_layout, "voice_user_info_layout");
            voicePartyActivity.N1(voice_user_info_layout);
        }
    }

    /* compiled from: VoicePartyActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class d implements VoiceQuestionLayout.b {
        public d() {
        }

        @Override // com.cupidapp.live.voiceparty.layout.VoiceQuestionLayout.b
        public void a(int i10) {
            VoicePartyActivity.this.Q1().selectQuestionType(i10);
        }

        @Override // com.cupidapp.live.voiceparty.layout.VoiceQuestionLayout.b
        public void b(@NotNull VoicePartyQuestionItemModel question) {
            s.i(question, "question");
            VoicePartyActivity.this.Q1().selectQuestionContent(question);
        }
    }

    /* compiled from: VoicePartyActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class e implements VoiceUserInfoLayout.a {
        public e() {
        }

        @Override // com.cupidapp.live.voiceparty.layout.VoiceUserInfoLayout.a
        public void a() {
            VoicePartyActivity.this.J1();
        }
    }

    /* compiled from: VoicePartyActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class f implements VoiceGameSessionLayout.a {
        public f() {
        }

        @Override // com.cupidapp.live.voiceparty.layout.VoiceGameSessionLayout.a
        public void a() {
            VoiceGameSessionLayout.a.C0176a.c(this);
        }

        @Override // com.cupidapp.live.voiceparty.layout.VoiceGameSessionLayout.a
        public void b(@NotNull VoicePartyGameSessionType type) {
            s.i(type, "type");
            if (type == VoicePartyGameSessionType.INVITED_FOLLOW_OTHER) {
                VoicePartyActivity.this.f2();
                VoicePartyActivity.this.Q1().callFollowHimApi(VoicePartyActivity.this.Q0());
            }
        }

        @Override // com.cupidapp.live.voiceparty.layout.VoiceGameSessionLayout.a
        public void c(boolean z10) {
            VoiceGameSessionLayout.a.C0176a.a(this, z10);
        }

        @Override // com.cupidapp.live.voiceparty.layout.VoiceGameSessionLayout.a
        public void d(@NotNull MaskPartyChatDiceModel maskPartyChatDiceModel) {
            VoiceGameSessionLayout.a.C0176a.b(this, maskPartyChatDiceModel);
        }

        @Override // com.cupidapp.live.voiceparty.layout.VoiceGameSessionLayout.a
        public void e() {
            VoicePartyActivity.this.f2();
        }
    }

    /* compiled from: VoicePartyActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class g implements IVoiceEngine.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Config f18997a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ VoicePartyActivity f18998b;

        public g(Config config, VoicePartyActivity voicePartyActivity) {
            this.f18997a = config;
            this.f18998b = voicePartyActivity;
        }

        @Override // com.cupidapp.live.voiceparty.engine.IVoiceEngine.a
        public void a(@NotNull IVoiceEngine.NetworkStateLevel networkStateLevel, @NotNull IVoiceEngine.NetworkStateLevel networkStateLevel2) {
            IVoiceEngine.a.C0175a.b(this, networkStateLevel, networkStateLevel2);
        }

        @Override // com.cupidapp.live.voiceparty.engine.IVoiceEngine.a
        public void b() {
            IVoiceEngine.a.C0175a.c(this);
        }

        @Override // com.cupidapp.live.voiceparty.engine.IVoiceEngine.a
        public void c(long j10) {
            GroupSocialLog groupSocialLog = GroupSocialLog.f18708a;
            PostAndSocialProtos.Type type = PostAndSocialProtos.Type.ENTER_VOICE_ROOM_SDK;
            String roomId = this.f18997a.getRoomId();
            User otherUserInfo = this.f18998b.Q1().getOtherUserInfo();
            groupSocialLog.a0(type, (r13 & 2) != 0 ? null : roomId, (r13 & 4) != 0 ? null : otherUserInfo != null ? otherUserInfo.userId() : null, (r13 & 8) != 0 ? null : null, (r13 & 16) != 0 ? null : Long.valueOf(v.p(j10)));
        }

        @Override // com.cupidapp.live.voiceparty.engine.IVoiceEngine.a
        public void d() {
            IVoiceEngine.a.C0175a.a(this);
        }

        @Override // com.cupidapp.live.voiceparty.engine.IVoiceEngine.a
        public void e(@NotNull Map<String, Integer> map) {
            IVoiceEngine.a.C0175a.d(this, map);
        }

        @Override // com.cupidapp.live.voiceparty.engine.IVoiceEngine.a
        public void f(int i10) {
            this.f18998b.d2("enterAudioRoom", Integer.valueOf(i10), null);
        }

        @Override // com.cupidapp.live.voiceparty.engine.IVoiceEngine.a
        public void onError(int i10, @Nullable String str) {
            this.f18998b.d2("TRTCErrorCallback", Integer.valueOf(i10), str);
        }
    }

    public VoicePartyActivity() {
        final Function0 function0 = null;
        this.f18983q = new ViewModelLazy(kotlin.jvm.internal.v.b(VoicePartyViewModel.class), new Function0<ViewModelStore>() { // from class: com.cupidapp.live.voiceparty.activity.VoicePartyActivity$special$$inlined$viewModels$default$2
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.cupidapp.live.voiceparty.activity.VoicePartyActivity$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ViewModelProvider.Factory invoke() {
                ViewModelProvider.Factory defaultViewModelProviderFactory = ComponentActivity.this.getDefaultViewModelProviderFactory();
                s.h(defaultViewModelProviderFactory, "defaultViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        }, new Function0<CreationExtras>() { // from class: com.cupidapp.live.voiceparty.activity.VoicePartyActivity$special$$inlined$viewModels$default$3
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

    public static final void V1(VoicePartyActivity this$0, VoicePartyRoomModel voicePartyRoomModel) {
        s.i(this$0, "this$0");
        ((VoiceAvatarLayout) this$0.p1(R$id.voice_party_other_avatar_layout)).b(voicePartyRoomModel.getTargetUserInfo().getMaskAvatar(), voicePartyRoomModel.getTargetUserInfo().getMaskName());
        ((VoiceAvatarLayout) this$0.p1(R$id.voice_party_my_avatar_layout)).b(voicePartyRoomModel.getMaskAvatar(), "我");
        ((VoiceUserInfoLayout) this$0.p1(R$id.voice_user_info_layout)).d(voicePartyRoomModel.getTargetUserInfo());
        this$0.I1(voicePartyRoomModel.getTargetUserInfo());
        this$0.h2(Integer.valueOf(voicePartyRoomModel.getAudioGameInfo().getMaskDurationSec()), Integer.valueOf(voicePartyRoomModel.getAudioGameInfo().getProfileUnableDurationSec()), 60);
    }

    public static final void W1(final VoicePartyActivity this$0, VoicePartyGameSessionModel model) {
        s.i(this$0, "this$0");
        ((ImageView) this$0.p1(R$id.voice_party_game_btn_guide)).setVisibility(8);
        if (model.isShowVoiceGameBtn()) {
            int i10 = R$id.voice_party_voice_game_btn;
            ((TextView) this$0.p1(i10)).setVisibility(0);
            ((TextView) this$0.p1(i10)).setText(this$0.getString(R$string.one_more_game));
        } else {
            ((TextView) this$0.p1(R$id.voice_party_voice_game_btn)).setVisibility(8);
        }
        int i11 = R$id.voice_game_session_layout;
        VoiceGameSessionLayout voice_game_session_layout = (VoiceGameSessionLayout) this$0.p1(i11);
        s.h(voice_game_session_layout, "voice_game_session_layout");
        this$0.N1(voice_game_session_layout);
        VoiceGameSessionLayout voiceGameSessionLayout = (VoiceGameSessionLayout) this$0.p1(i11);
        s.h(model, "model");
        voiceGameSessionLayout.e(model);
        VoicePartyDurationModel durationModel = this$0.Q1().getDurationModel();
        Integer valueOf = durationModel != null ? Integer.valueOf(durationModel.getInviteCountdownSec()) : null;
        if (model.getType() == VoicePartyGameSessionType.INVITE_OTHER && valueOf != null && valueOf.intValue() > 0) {
            this$0.O1().g();
            i.d(this$0.O1(), valueOf, 1, new Function0<p>() { // from class: com.cupidapp.live.voiceparty.activity.VoicePartyActivity$initObserve$4$1
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
                    VoicePartyActivity voicePartyActivity = VoicePartyActivity.this;
                    VoiceUserInfoLayout voice_user_info_layout = (VoiceUserInfoLayout) voicePartyActivity.p1(R$id.voice_user_info_layout);
                    s.h(voice_user_info_layout, "voice_user_info_layout");
                    voicePartyActivity.N1(voice_user_info_layout);
                }
            }, null, 8, null);
        }
        SensorPosition Q0 = this$0.Q0();
        if (model.getType() == VoicePartyGameSessionType.OTHER_INVITE_ME) {
            j1.i.g(j1.i.f50236a, PopupName.INVITE_VOICE_GAME, Q0, null, 4, null);
        } else if (model.getType() == VoicePartyGameSessionType.OTHER_INVITE_ME_FOR_LATE_NIGHT) {
            j1.i.g(j1.i.f50236a, PopupName.DARK_MODEL_CONFIRM, Q0, null, 4, null);
        }
    }

    public static final void X1(VoicePartyActivity this$0, List list) {
        s.i(this$0, "this$0");
        int i10 = R$id.voice_party_question_layout;
        VoiceQuestionLayout voice_party_question_layout = (VoiceQuestionLayout) this$0.p1(i10);
        s.h(voice_party_question_layout, "voice_party_question_layout");
        this$0.N1(voice_party_question_layout);
        VoiceQuestionLayout voiceQuestionLayout = (VoiceQuestionLayout) this$0.p1(i10);
        s.h(list, "list");
        voiceQuestionLayout.j(list);
    }

    public static final void Y1(VoicePartyActivity this$0, VoicePartyGameSessionModel model) {
        s.i(this$0, "this$0");
        int i10 = R$id.voice_invited_follow_other_layout;
        VoiceGameSessionLayout voice_invited_follow_other_layout = (VoiceGameSessionLayout) this$0.p1(i10);
        s.h(voice_invited_follow_other_layout, "voice_invited_follow_other_layout");
        this$0.N1(voice_invited_follow_other_layout);
        VoiceGameSessionLayout voiceGameSessionLayout = (VoiceGameSessionLayout) this$0.p1(i10);
        s.h(model, "model");
        voiceGameSessionLayout.e(model);
    }

    public static final void a2(VoicePartyActivity this$0) {
        s.i(this$0, "this$0");
        int width = (((ImageView) this$0.p1(R$id.voice_party_game_area)).getWidth() - h.c(this$0, 10.0f)) / 2;
        TextView voice_party_voice_game_btn = (TextView) this$0.p1(R$id.voice_party_voice_game_btn);
        s.h(voice_party_voice_game_btn, "voice_party_voice_game_btn");
        y.o(voice_party_voice_game_btn, Integer.valueOf(width), null, 2, null);
        FrameLayout voice_party_right_btn_layout = (FrameLayout) this$0.p1(R$id.voice_party_right_btn_layout);
        s.h(voice_party_right_btn_layout, "voice_party_right_btn_layout");
        y.o(voice_party_right_btn_layout, Integer.valueOf(width), null, 2, null);
    }

    public static final void b2(VoicePartyActivity this$0) {
        s.i(this$0, "this$0");
        ((ImageView) this$0.p1(R$id.voice_party_game_btn_guide)).setVisibility(8);
    }

    public static /* synthetic */ void i2(VoicePartyActivity voicePartyActivity, Integer num, Integer num2, Integer num3, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            num2 = null;
        }
        if ((i10 & 4) != 0) {
            num3 = null;
        }
        voicePartyActivity.h2(num, num2, num3);
    }

    public final void H1() {
        ImageView voice_party_microphone_btn = (ImageView) p1(R$id.voice_party_microphone_btn);
        s.h(voice_party_microphone_btn, "voice_party_microphone_btn");
        y.d(voice_party_microphone_btn, new Function1<View, p>() { // from class: com.cupidapp.live.voiceparty.activity.VoicePartyActivity$bindClickEvent$1
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
                VoicePartyActivity.this.K1();
            }
        });
        ImageView voice_party_speaker_btn = (ImageView) p1(R$id.voice_party_speaker_btn);
        s.h(voice_party_speaker_btn, "voice_party_speaker_btn");
        y.d(voice_party_speaker_btn, new Function1<View, p>() { // from class: com.cupidapp.live.voiceparty.activity.VoicePartyActivity$bindClickEvent$2
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
                VoicePartyActivity.this.L1();
            }
        });
        ImageView voice_party_hang_up_btn = (ImageView) p1(R$id.voice_party_hang_up_btn);
        s.h(voice_party_hang_up_btn, "voice_party_hang_up_btn");
        y.d(voice_party_hang_up_btn, new Function1<View, p>() { // from class: com.cupidapp.live.voiceparty.activity.VoicePartyActivity$bindClickEvent$3
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
                VoicePartyActivity.this.e2();
            }
        });
        TextView voice_party_voice_game_btn = (TextView) p1(R$id.voice_party_voice_game_btn);
        s.h(voice_party_voice_game_btn, "voice_party_voice_game_btn");
        y.d(voice_party_voice_game_btn, new Function1<View, p>() { // from class: com.cupidapp.live.voiceparty.activity.VoicePartyActivity$bindClickEvent$4
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
                VoicePartyActivity.this.Q1().callGameInviteApi();
            }
        });
        TextView voice_party_publish_profile_btn = (TextView) p1(R$id.voice_party_publish_profile_btn);
        s.h(voice_party_publish_profile_btn, "voice_party_publish_profile_btn");
        y.d(voice_party_publish_profile_btn, new Function1<View, p>() { // from class: com.cupidapp.live.voiceparty.activity.VoicePartyActivity$bindClickEvent$5
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
                boolean z10;
                SensorsLogKeyButtonClick.VoiceRoom.SHARE_PROFILE.click();
                z10 = VoicePartyActivity.this.f18988v;
                if (z10) {
                    VoicePartyActivity.this.Q1().callPublicProfileApi();
                } else {
                    com.cupidapp.live.base.view.h.f12779a.l(VoicePartyActivity.this, R$string.chat_and_get_to_know_each_other);
                }
            }
        });
        FKWithImageButton voice_party_follow_him_btn = (FKWithImageButton) p1(R$id.voice_party_follow_him_btn);
        s.h(voice_party_follow_him_btn, "voice_party_follow_him_btn");
        y.d(voice_party_follow_him_btn, new Function1<View, p>() { // from class: com.cupidapp.live.voiceparty.activity.VoicePartyActivity$bindClickEvent$6
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
                SensorsLogKeyButtonClick.VoiceRoom.LIKE.click();
                VoicePartyActivity.this.Q1().callFollowHimApi(VoicePartyActivity.this.Q0());
            }
        });
        TextView voice_party_invite_follow_me_btn = (TextView) p1(R$id.voice_party_invite_follow_me_btn);
        s.h(voice_party_invite_follow_me_btn, "voice_party_invite_follow_me_btn");
        y.d(voice_party_invite_follow_me_btn, new Function1<View, p>() { // from class: com.cupidapp.live.voiceparty.activity.VoicePartyActivity$bindClickEvent$7
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
                SensorsLogKeyButtonClick.VoiceRoom.INVITE_LIKE.click();
                VoicePartyActivity.this.Q1().callInviteFollowMeApi();
                VoicePartyActivity.this.g2(VoicePartyRightBtnType.BOTH_GONE);
                com.cupidapp.live.base.view.h.f12779a.l(VoicePartyActivity.this, R$string.follow_me_invite_already_send);
            }
        });
        VoiceAvatarLayout voice_party_other_avatar_layout = (VoiceAvatarLayout) p1(R$id.voice_party_other_avatar_layout);
        s.h(voice_party_other_avatar_layout, "voice_party_other_avatar_layout");
        y.d(voice_party_other_avatar_layout, new Function1<View, p>() { // from class: com.cupidapp.live.voiceparty.activity.VoicePartyActivity$bindClickEvent$8
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
                VoicePartyActivity.this.J1();
            }
        });
    }

    public final void I1(final User user) {
        ((FKTitleBarLayout) p1(R$id.voice_party_title_layout)).setLeftImageEndTextClickEvent(new Function1<View, p>() { // from class: com.cupidapp.live.voiceparty.activity.VoicePartyActivity$bindReportBtnClickEvent$1
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
                SensorsLogKeyButtonClick.VoiceRoom.REPORT.click();
                j.a.b(j.f12156c, this, n0.f12353a.b(User.this.getReportData(), this.Q0(), User.this.userId()), null, 4, null);
            }
        });
    }

    public final void J1() {
        int i10 = b.f18992b[Q1().getPublicProfileStatus().ordinal()];
        if (i10 == 2) {
            VoicePartyPromptHelper.f19013a.b(this, new Function0<p>() { // from class: com.cupidapp.live.voiceparty.activity.VoicePartyActivity$checkCanGotoOtherProfile$1
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
                    VoicePartyActivity.this.Q1().callPublicProfileApi();
                }
            });
        } else if (i10 == 3) {
            com.cupidapp.live.base.view.h.f12779a.l(this, R$string.other_not_public_profile_and_remind_him);
        } else {
            if (i10 != 4) {
                return;
            }
            S1();
        }
    }

    public final void K1() {
        String string;
        SensorsLogKeyButtonClick.VoiceRoom.SWITCH_MIKE.click();
        n1.a.b(n1.a.f52091a, this, 0L, 2, null);
        int i10 = R$id.voice_party_microphone_btn;
        boolean z10 = !((ImageView) p1(i10)).isSelected();
        IVoiceEngine a10 = d4.b.f48611a.a();
        if (a10 != null) {
            a10.j(!z10);
        }
        ((ImageView) p1(i10)).setSelected(z10);
        TextView textView = (TextView) p1(R$id.voice_party_microphone_text);
        if (z10) {
            string = getString(R$string.microphone_open);
        } else {
            string = getString(R$string.microphone_close);
        }
        textView.setText(string);
    }

    public final void L1() {
        IVoiceEngine.AudioOutputPosition audioOutputPosition;
        String string;
        SensorsLogKeyButtonClick.VoiceRoom.SWITCH_LOUDSPEAKER.click();
        n1.a.b(n1.a.f52091a, this, 0L, 2, null);
        int i10 = R$id.voice_party_speaker_btn;
        boolean z10 = !((ImageView) p1(i10)).isSelected();
        if (z10) {
            audioOutputPosition = IVoiceEngine.AudioOutputPosition.SPEAKER;
        } else {
            audioOutputPosition = IVoiceEngine.AudioOutputPosition.EARPIECE;
        }
        IVoiceEngine a10 = d4.b.f48611a.a();
        if (a10 != null) {
            a10.k(audioOutputPosition);
        }
        ((ImageView) p1(i10)).setSelected(z10);
        TextView textView = (TextView) p1(R$id.voice_party_speaker_text);
        if (z10) {
            string = getString(R$string.speaker_open);
        } else {
            string = getString(R$string.speaker_close);
        }
        textView.setText(string);
    }

    public final void M1() {
        IVoiceEngine a10 = d4.b.f48611a.a();
        if (a10 != null) {
            a10.e();
        }
        R1().g();
        O1().g();
        P1().h();
        f18982z = false;
    }

    public final void N1(FrameLayout frameLayout) {
        for (FrameLayout frameLayout2 : kotlin.collections.s.m((VoiceUserInfoLayout) p1(R$id.voice_user_info_layout), (VoiceGameSessionLayout) p1(R$id.voice_game_session_layout), (VoiceQuestionLayout) p1(R$id.voice_party_question_layout), (VoiceGameSessionLayout) p1(R$id.voice_invited_follow_other_layout))) {
            if (s.d(frameLayout, (VoiceGameSessionLayout) p1(R$id.voice_invited_follow_other_layout)) && frameLayout2.getVisibility() == 0) {
                this.f18986t = frameLayout2;
            }
            frameLayout2.setVisibility(frameLayout2.getId() == frameLayout.getId() ? 0 : 8);
        }
        if (((VoiceUserInfoLayout) p1(R$id.voice_user_info_layout)).getVisibility() == 0) {
            int i10 = R$id.voice_party_voice_game_btn;
            ((TextView) p1(i10)).setVisibility(0);
            ((TextView) p1(i10)).setText(getString(R$string.voice_game));
            ((VoiceAvatarLayout) p1(R$id.voice_party_other_avatar_layout)).c(false);
            ((VoiceAvatarLayout) p1(R$id.voice_party_my_avatar_layout)).c(false);
        }
    }

    public final i O1() {
        return (i) this.f18985s.getValue();
    }

    public final com.cupidapp.live.voiceparty.helper.b P1() {
        return (com.cupidapp.live.voiceparty.helper.b) this.f18987u.getValue();
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity
    @NotNull
    public SensorPosition Q0() {
        return SensorPosition.VoiceRoom;
    }

    public final VoicePartyViewModel Q1() {
        return (VoicePartyViewModel) this.f18983q.getValue();
    }

    public final i R1() {
        return (i) this.f18984r.getValue();
    }

    public final void S1() {
        User otherUserInfo = Q1().getOtherUserInfo();
        String userId = otherUserInfo != null ? otherUserInfo.userId() : null;
        if (userId == null || userId.length() == 0) {
            return;
        }
        Disposable disposed = a.C0836a.z(NetworkClient.f11868a.N(), userId, null, null, false, null, 30, null).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<ProfileResult, p>() { // from class: com.cupidapp.live.voiceparty.activity.VoicePartyActivity$gotoOtherProfile$$inlined$handle$default$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(ProfileResult profileResult) {
                m2843invoke(profileResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2843invoke(ProfileResult profileResult) {
                ProfileResult profileResult2 = profileResult;
                UserProfileActivity.G.a(VoicePartyActivity.this, profileResult2.getUser(), new ProfileSensorContext(ViewProfilePrefer.MaskAudioRoom.getValue(), null, profileResult2.getUser().getMe(), VoicePartyActivity.this.Q0(), null, null), (r21 & 8) != 0 ? false : false, (r21 & 16) != 0 ? null : null, (r21 & 32) != 0 ? null : null, (r21 & 64) != 0 ? null : null, (r21 & 128) != 0 ? false : false);
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, this)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            H(disposed);
        }
        s.h(disposed, "disposed");
    }

    public final void T1() {
        ((VoiceGameSessionLayout) p1(R$id.voice_game_session_layout)).setVoiceGameSessionListener(new c());
        ((VoiceQuestionLayout) p1(R$id.voice_party_question_layout)).setVoiceQuestionListener(new d());
        ((VoiceUserInfoLayout) p1(R$id.voice_user_info_layout)).setVoiceUserInfoListener(new e());
        ((VoiceGameSessionLayout) p1(R$id.voice_invited_follow_other_layout)).setVoiceGameSessionListener(new f());
    }

    public final void U1() {
        Q1().getRoomModelLiveData().observe(this, new Observer() { // from class: com.cupidapp.live.voiceparty.activity.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                VoicePartyActivity.V1(VoicePartyActivity.this, (VoicePartyRoomModel) obj);
            }
        });
        Q1().getHangUpLiveData().observe(this, new EventObserver(new Function1<Boolean, p>() { // from class: com.cupidapp.live.voiceparty.activity.VoicePartyActivity$initObserve$2
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
                    Intent intent = new Intent();
                    intent.putExtra("MASK_PARTY_SHOW_ITEM_CARD_PROMPT", true);
                    VoicePartyActivity.this.setResult(-1, intent);
                }
                VoicePartyActivity.this.finish();
            }
        }));
        Q1().getOtherLeaveRoomLiveData().observe(this, new EventObserver(new Function1<Boolean, p>() { // from class: com.cupidapp.live.voiceparty.activity.VoicePartyActivity$initObserve$3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return p.f51048a;
            }

            public final void invoke(boolean z10) {
                boolean z11;
                VoicePartyActivity.this.M1();
                VoicePartyPromptHelper voicePartyPromptHelper = VoicePartyPromptHelper.f19013a;
                VoicePartyActivity voicePartyActivity = VoicePartyActivity.this;
                z11 = voicePartyActivity.f18989w;
                SensorPosition Q0 = VoicePartyActivity.this.Q0();
                final VoicePartyActivity voicePartyActivity2 = VoicePartyActivity.this;
                Function0<p> function0 = new Function0<p>() { // from class: com.cupidapp.live.voiceparty.activity.VoicePartyActivity$initObserve$3.1
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
                        Intent intent = new Intent();
                        intent.putExtra("MASK_PARTY_REMATCH", true);
                        VoicePartyActivity.this.setResult(-1, intent);
                        VoicePartyActivity.this.finish();
                    }
                };
                final VoicePartyActivity voicePartyActivity3 = VoicePartyActivity.this;
                voicePartyPromptHelper.c(voicePartyActivity, z11, Q0, function0, new Function0<p>() { // from class: com.cupidapp.live.voiceparty.activity.VoicePartyActivity$initObserve$3.2
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
                        VoicePartyActivity.this.finish();
                    }
                });
            }
        }));
        Q1().getGameSessionLiveData().observe(this, new Observer() { // from class: com.cupidapp.live.voiceparty.activity.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                VoicePartyActivity.W1(VoicePartyActivity.this, (VoicePartyGameSessionModel) obj);
            }
        });
        Q1().getRollDiceLiveData().observe(this, new EventObserver(new Function1<MaskPartyChatDiceModel, p>() { // from class: com.cupidapp.live.voiceparty.activity.VoicePartyActivity$initObserve$5
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(MaskPartyChatDiceModel maskPartyChatDiceModel) {
                invoke2(maskPartyChatDiceModel);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull MaskPartyChatDiceModel model) {
                i O1;
                s.i(model, "model");
                GroupSocialLog groupSocialLog = GroupSocialLog.f18708a;
                PostAndSocialProtos.Type type = PostAndSocialProtos.Type.ENTER_VOICE_GAME;
                String roomId = model.getRoomId();
                User otherUserInfo = VoicePartyActivity.this.Q1().getOtherUserInfo();
                groupSocialLog.a0(type, (r13 & 2) != 0 ? null : roomId, (r13 & 4) != 0 ? null : otherUserInfo != null ? otherUserInfo.userId() : null, (r13 & 8) != 0 ? null : null, (r13 & 16) != 0 ? null : null);
                O1 = VoicePartyActivity.this.O1();
                O1.g();
                VoicePartyActivity voicePartyActivity = VoicePartyActivity.this;
                int i10 = R$id.voice_game_session_layout;
                VoiceGameSessionLayout voice_game_session_layout = (VoiceGameSessionLayout) voicePartyActivity.p1(i10);
                s.h(voice_game_session_layout, "voice_game_session_layout");
                voicePartyActivity.N1(voice_game_session_layout);
                ((VoiceGameSessionLayout) VoicePartyActivity.this.p1(i10)).h(model, ((VoiceAvatarLayout) VoicePartyActivity.this.p1(R$id.voice_party_other_avatar_layout)).getUserName());
            }
        }));
        Q1().getQuestionListLiveData().observe(this, new Observer() { // from class: com.cupidapp.live.voiceparty.activity.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                VoicePartyActivity.X1(VoicePartyActivity.this, (List) obj);
            }
        });
        Q1().isAcceptLateNight().observe(this, new EventObserver(new Function1<Boolean, p>() { // from class: com.cupidapp.live.voiceparty.activity.VoicePartyActivity$initObserve$7
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
                    VoicePartyActivity voicePartyActivity = VoicePartyActivity.this;
                    int i10 = R$id.voice_party_question_layout;
                    VoiceQuestionLayout voice_party_question_layout = (VoiceQuestionLayout) voicePartyActivity.p1(i10);
                    s.h(voice_party_question_layout, "voice_party_question_layout");
                    voicePartyActivity.N1(voice_party_question_layout);
                    ((VoiceQuestionLayout) VoicePartyActivity.this.p1(i10)).g();
                    return;
                }
                VoicePartyActivity.this.Q1().callQuestionListApi();
                com.cupidapp.live.base.view.h.f12779a.l(VoicePartyActivity.this, R$string.other_refuse_late_night_try_another_mode);
            }
        }));
        Q1().getPublicProfileForMe().observe(this, new EventObserver(new Function1<PublicProfileStatus, p>() { // from class: com.cupidapp.live.voiceparty.activity.VoicePartyActivity$initObserve$8
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(PublicProfileStatus publicProfileStatus) {
                invoke2(publicProfileStatus);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull PublicProfileStatus status) {
                s.i(status, "status");
                VoicePartyActivity voicePartyActivity = VoicePartyActivity.this;
                int i10 = R$id.voice_party_my_avatar_layout;
                VoiceAvatarLayout voiceAvatarLayout = (VoiceAvatarLayout) voicePartyActivity.p1(i10);
                User X = g.f52734a.X();
                voiceAvatarLayout.b(X != null ? X.getAvatarImage() : null, "我");
                ((VoiceAvatarLayout) VoicePartyActivity.this.p1(i10)).e(VoiceAvatarMarkType.PUBLIC_PROFILE_MARK);
                if (status == PublicProfileStatus.BOTH_PUBLIC) {
                    VoicePartyActivity voicePartyActivity2 = VoicePartyActivity.this;
                    VoicePartyDurationModel durationModel = voicePartyActivity2.Q1().getDurationModel();
                    VoicePartyActivity.i2(voicePartyActivity2, durationModel != null ? Integer.valueOf(durationModel.getMatchDurationSec()) : null, null, null, 6, null);
                    VoicePartyActivity.this.Q1().m2844getMatchStatus();
                    return;
                }
                VoicePartyActivity.this.g2(VoicePartyRightBtnType.PROFILE_ALREADY_PUBLIC);
            }
        }));
        Q1().getPublicProfileForOther().observe(this, new EventObserver(new Function1<PublicProfileStatus, p>() { // from class: com.cupidapp.live.voiceparty.activity.VoicePartyActivity$initObserve$9
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(PublicProfileStatus publicProfileStatus) {
                invoke2(publicProfileStatus);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull PublicProfileStatus status) {
                s.i(status, "status");
                User otherUserInfo = VoicePartyActivity.this.Q1().getOtherUserInfo();
                VoicePartyActivity voicePartyActivity = VoicePartyActivity.this;
                int i10 = R$id.voice_party_other_avatar_layout;
                ((VoiceAvatarLayout) voicePartyActivity.p1(i10)).b(otherUserInfo != null ? otherUserInfo.getAvatarImage() : null, otherUserInfo != null ? otherUserInfo.getName() : null);
                ((VoiceAvatarLayout) VoicePartyActivity.this.p1(i10)).e(VoiceAvatarMarkType.PUBLIC_PROFILE_MARK);
                ((VoiceUserInfoLayout) VoicePartyActivity.this.p1(R$id.voice_user_info_layout)).i();
                if (status == PublicProfileStatus.BOTH_PUBLIC) {
                    VoicePartyActivity voicePartyActivity2 = VoicePartyActivity.this;
                    VoicePartyDurationModel durationModel = voicePartyActivity2.Q1().getDurationModel();
                    VoicePartyActivity.i2(voicePartyActivity2, durationModel != null ? Integer.valueOf(durationModel.getMatchDurationSec()) : null, null, null, 6, null);
                    VoicePartyActivity.this.Q1().m2844getMatchStatus();
                }
            }
        }));
        Q1().getMatchStatus().observe(this, new EventObserver(new Function1<VoicePartyRelationStatus, p>() { // from class: com.cupidapp.live.voiceparty.activity.VoicePartyActivity$initObserve$10

            /* compiled from: VoicePartyActivity.kt */
            @kotlin.d
            /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
            public /* synthetic */ class a {

                /* renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f18999a;

                static {
                    int[] iArr = new int[VoicePartyRelationStatus.values().length];
                    try {
                        iArr[VoicePartyRelationStatus.NO_RELATIONSHIP.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[VoicePartyRelationStatus.ME_FOLLOW_OTHER.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[VoicePartyRelationStatus.OTHER_FOLLOW_ME.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        iArr[VoicePartyRelationStatus.MATCH.ordinal()] = 4;
                    } catch (NoSuchFieldError unused4) {
                    }
                    f18999a = iArr;
                }
            }

            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(VoicePartyRelationStatus voicePartyRelationStatus) {
                invoke2(voicePartyRelationStatus);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull VoicePartyRelationStatus status) {
                s.i(status, "status");
                int i10 = a.f18999a[status.ordinal()];
                if (i10 == 1) {
                    VoicePartyActivity.this.g2(VoicePartyRightBtnType.FOLLOW_HIM);
                    return;
                }
                if (i10 == 2) {
                    ((ImageView) VoicePartyActivity.this.p1(R$id.voice_party_follow_him_btn_guide)).setVisibility(8);
                    VoicePartyActivity.this.f2();
                    ((VoiceAvatarLayout) VoicePartyActivity.this.p1(R$id.voice_party_other_avatar_layout)).e(VoiceAvatarMarkType.ME_FOLLOW_OTHER_MARK);
                    VoicePartyActivity.this.g2(VoicePartyRightBtnType.INVITE_FOLLOW_ME);
                    return;
                }
                if (i10 == 3) {
                    ((VoiceAvatarLayout) VoicePartyActivity.this.p1(R$id.voice_party_other_avatar_layout)).e(VoiceAvatarMarkType.OTHER_FOLLOW_ME_MARK);
                    VoicePartyActivity.this.g2(VoicePartyRightBtnType.FOLLOW_HIM);
                    return;
                }
                if (i10 != 4) {
                    return;
                }
                ((ImageView) VoicePartyActivity.this.p1(R$id.voice_party_follow_him_btn_guide)).setVisibility(8);
                VoicePartyActivity.this.f2();
                ((ImageView) VoicePartyActivity.this.p1(R$id.voice_party_match_img)).setVisibility(0);
                VoiceAvatarLayout voiceAvatarLayout = (VoiceAvatarLayout) VoicePartyActivity.this.p1(R$id.voice_party_my_avatar_layout);
                VoiceAvatarMarkType voiceAvatarMarkType = VoiceAvatarMarkType.BOTH_GONE;
                voiceAvatarLayout.e(voiceAvatarMarkType);
                ((VoiceAvatarLayout) VoicePartyActivity.this.p1(R$id.voice_party_other_avatar_layout)).e(voiceAvatarMarkType);
                VoicePartyActivity.this.g2(VoicePartyRightBtnType.BOTH_GONE);
                VoicePartyActivity voicePartyActivity = VoicePartyActivity.this;
                VoicePartyDurationModel durationModel = voicePartyActivity.Q1().getDurationModel();
                VoicePartyActivity.i2(voicePartyActivity, durationModel != null ? Integer.valueOf(durationModel.getMaxDurationSec()) : null, null, null, 6, null);
            }
        }));
        Q1().getRoomDissolve().observe(this, new EventObserver(new Function1<VoicePartyRoomDissolveModel, p>() { // from class: com.cupidapp.live.voiceparty.activity.VoicePartyActivity$initObserve$11
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(VoicePartyRoomDissolveModel voicePartyRoomDissolveModel) {
                invoke2(voicePartyRoomDissolveModel);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull VoicePartyRoomDissolveModel model) {
                s.i(model, "model");
                VoicePartyPromptHelper voicePartyPromptHelper = VoicePartyPromptHelper.f19013a;
                VoicePartyActivity voicePartyActivity = VoicePartyActivity.this;
                String title = model.getTitle();
                String reason = model.getReason();
                final VoicePartyActivity voicePartyActivity2 = VoicePartyActivity.this;
                voicePartyPromptHelper.d(voicePartyActivity, title, reason, new Function0<p>() { // from class: com.cupidapp.live.voiceparty.activity.VoicePartyActivity$initObserve$11.1
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
                        VoicePartyActivity.this.finish();
                    }
                });
            }
        }));
        Q1().getInvitedFollowOther().observe(this, new Observer() { // from class: com.cupidapp.live.voiceparty.activity.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                VoicePartyActivity.Y1(VoicePartyActivity.this, (VoicePartyGameSessionModel) obj);
            }
        });
        Q1().getBtnClickState().observe(this, new EventObserver(new Function1<StateResult<VoicePartyBtnType>, p>() { // from class: com.cupidapp.live.voiceparty.activity.VoicePartyActivity$initObserve$13
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(StateResult<VoicePartyBtnType> stateResult) {
                invoke2(stateResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull StateResult<VoicePartyBtnType> result) {
                s.i(result, "result");
                boolean z10 = true;
                if (result instanceof StateResult.b ? true : result instanceof StateResult.c) {
                    z10 = false;
                } else if (!(result instanceof StateResult.a)) {
                    throw new NoWhenBranchMatchedException();
                }
                if (result.getData() == VoicePartyBtnType.INVITED_FOLLOW_OTHER_AGREE_BTN) {
                    ((VoiceGameSessionLayout) VoicePartyActivity.this.p1(R$id.voice_invited_follow_other_layout)).d(result.getData(), z10);
                } else if (result.getData() != null) {
                    ((VoiceGameSessionLayout) VoicePartyActivity.this.p1(R$id.voice_game_session_layout)).d(result.getData(), z10);
                }
            }
        }));
    }

    public final void Z1(String str) {
        TextView voice_party_countdown_text = (TextView) p1(R$id.voice_party_countdown_text);
        s.h(voice_party_countdown_text, "voice_party_countdown_text");
        u.a(voice_party_countdown_text);
        ((ImageView) p1(R$id.voice_party_microphone_btn)).setSelected(true);
        ((TextView) p1(R$id.voice_party_microphone_text)).setText(getString(R$string.microphone_open));
        ((ImageView) p1(R$id.voice_party_speaker_btn)).setSelected(true);
        ((TextView) p1(R$id.voice_party_speaker_text)).setText(getString(R$string.speaker_open));
        Q1().callRoomInfoApi(str);
        FKTitleBarLayout voice_party_title_layout = (FKTitleBarLayout) p1(R$id.voice_party_title_layout);
        s.h(voice_party_title_layout, "voice_party_title_layout");
        String string = getString(R$string.report);
        s.h(string, "getString(R.string.report)");
        voice_party_title_layout.setLeftImageEndText(string, (r12 & 2) != 0 ? -15066598 : com.cupidapp.live.base.utils.h.a(-1, 0.5f), (r12 & 4) != 0 ? false : false, (r12 & 8) != 0 ? 16.0f : 12.0f, (r12 & 16) != 0 ? 0 : h.c(this, 10.0f));
        ((ImageView) p1(R$id.voice_party_game_area)).post(new Runnable() { // from class: com.cupidapp.live.voiceparty.activity.f
            @Override // java.lang.Runnable
            public final void run() {
                VoicePartyActivity.a2(VoicePartyActivity.this);
            }
        });
        ((ImageView) p1(R$id.voice_party_game_btn_guide)).postDelayed(new Runnable() { // from class: com.cupidapp.live.voiceparty.activity.e
            @Override // java.lang.Runnable
            public final void run() {
                VoicePartyActivity.b2(VoicePartyActivity.this);
            }
        }, 10000L);
        com.cupidapp.live.voiceparty.helper.b.f(P1(), this, R$raw.voice_party_timer_sound, null, 4, null);
    }

    public final void c2(Config config) {
        IVoiceEngine a10 = d4.b.f48611a.a();
        if (a10 != null) {
            f18982z = true;
            a10.n(new IVoiceEngine.VoiceEngineOption(config.getRoomId(), config.getSdkAppID(), config.getUserSig(), "", true));
            a10.m(new g(config, this));
            a10.c();
        }
    }

    public final void d2(String str, Integer num, String str2) {
        Disposable disposed = NetworkClient.f11868a.i().v(str, num, str2).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<Object, p>() { // from class: com.cupidapp.live.voiceparty.activity.VoicePartyActivity$reportEventLogToService$$inlined$handle$default$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Object obj) {
                invoke2(obj);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object obj) {
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, this)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            H(disposed);
        }
        s.h(disposed, "disposed");
    }

    public final void e2() {
        VoicePartyPromptHelper.f19013a.a(this, Q0(), new Function0<p>() { // from class: com.cupidapp.live.voiceparty.activity.VoicePartyActivity$showHangUpPrompt$1
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
                VoicePartyActivity.this.M1();
                VoicePartyActivity.this.Q1().callHangUpApi();
            }
        });
    }

    public final void f2() {
        FrameLayout frameLayout = this.f18986t;
        if (frameLayout != null) {
            N1(frameLayout);
            this.f18986t = null;
        }
    }

    public final void g2(VoicePartyRightBtnType voicePartyRightBtnType) {
        View view;
        if (voicePartyRightBtnType == VoicePartyRightBtnType.BOTH_GONE) {
            ((FrameLayout) p1(R$id.voice_party_right_btn_layout)).setVisibility(8);
            return;
        }
        ((FrameLayout) p1(R$id.voice_party_right_btn_layout)).setVisibility(0);
        int i10 = R$id.voice_party_publish_profile_btn;
        int i11 = R$id.voice_party_already_publish_btn;
        int i12 = R$id.voice_party_follow_him_btn;
        int i13 = R$id.voice_party_invite_follow_me_btn;
        List<View> m10 = kotlin.collections.s.m((TextView) p1(i10), (FKWithImageButton) p1(i11), (FKWithImageButton) p1(i12), (TextView) p1(i13));
        int i14 = b.f18991a[voicePartyRightBtnType.ordinal()];
        if (i14 == 1) {
            view = (TextView) p1(i10);
        } else if (i14 == 2) {
            view = (FKWithImageButton) p1(i11);
        } else if (i14 == 3) {
            view = (FKWithImageButton) p1(i12);
        } else if (i14 == 4) {
            view = (TextView) p1(i13);
        } else {
            if (i14 != 5) {
                throw new NoWhenBranchMatchedException();
            }
            view = null;
        }
        for (View view2 : m10) {
            view2.setVisibility(view != null && view2.getId() == view.getId() ? 0 : 8);
        }
    }

    public final void h2(final Integer num, final Integer num2, final Integer num3) {
        if (num == null || num.intValue() < 0) {
            return;
        }
        R1().g();
        R1().c(num, 1, new Function0<p>() { // from class: com.cupidapp.live.voiceparty.activity.VoicePartyActivity$startVoiceRoomCountDown$1
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
                VoicePartyActivity.this.M1();
                VoicePartyActivity.this.Q1().callVoiceRoomDissolveApi();
            }
        }, new Function1<Integer, p>() { // from class: com.cupidapp.live.voiceparty.activity.VoicePartyActivity$startVoiceRoomCountDown$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Integer num4) {
                invoke(num4.intValue());
                return p.f51048a;
            }

            public final void invoke(int i10) {
                com.cupidapp.live.voiceparty.helper.b P1;
                boolean z10;
                Integer num4;
                com.cupidapp.live.voiceparty.helper.b P12;
                PublicProfileStatus publicProfileStatus = VoicePartyActivity.this.Q1().getPublicProfileStatus();
                PublicProfileStatus publicProfileStatus2 = PublicProfileStatus.BOTH_PUBLIC;
                boolean z11 = false;
                if (publicProfileStatus == publicProfileStatus2) {
                    ((ImageView) VoicePartyActivity.this.p1(R$id.voice_party_countdown_guide)).setVisibility(8);
                } else if (i10 < 60 && publicProfileStatus != publicProfileStatus2) {
                    ((ImageView) VoicePartyActivity.this.p1(R$id.voice_party_countdown_guide)).setVisibility(0);
                }
                VoicePartyRelationStatus relationStatus = VoicePartyActivity.this.Q1().getRelationStatus();
                if (publicProfileStatus == publicProfileStatus2 && ((relationStatus == VoicePartyRelationStatus.NO_RELATIONSHIP || relationStatus == VoicePartyRelationStatus.OTHER_FOLLOW_ME) && i10 < 60)) {
                    ((ImageView) VoicePartyActivity.this.p1(R$id.voice_party_follow_him_btn_guide)).setVisibility(0);
                } else {
                    ((ImageView) VoicePartyActivity.this.p1(R$id.voice_party_follow_him_btn_guide)).setVisibility(8);
                }
                if (i10 < 60) {
                    VoicePartyActivity voicePartyActivity = VoicePartyActivity.this;
                    int i11 = R$id.voice_party_countdown_text;
                    ((TextView) voicePartyActivity.p1(i11)).setTextColor(-49088);
                    ((TextView) VoicePartyActivity.this.p1(i11)).setTextSize(30.0f);
                } else {
                    VoicePartyActivity voicePartyActivity2 = VoicePartyActivity.this;
                    int i12 = R$id.voice_party_countdown_text;
                    ((TextView) voicePartyActivity2.p1(i12)).setTextColor(-1);
                    ((TextView) VoicePartyActivity.this.p1(i12)).setTextSize(24.0f);
                }
                ((TextView) VoicePartyActivity.this.p1(R$id.voice_party_countdown_text)).setText(v.j(i10));
                if (i10 < 60) {
                    P12 = VoicePartyActivity.this.P1();
                    com.cupidapp.live.voiceparty.helper.b.d(P12, 0, 1, null);
                } else {
                    P1 = VoicePartyActivity.this.P1();
                    P1.b();
                }
                z10 = VoicePartyActivity.this.f18988v;
                if (!z10 && (num4 = num2) != null && num4.intValue() > 0 && i10 < num.intValue() - num2.intValue()) {
                    VoicePartyActivity.this.f18988v = true;
                    TextView textView = (TextView) VoicePartyActivity.this.p1(R$id.voice_party_publish_profile_btn);
                    textView.setTextColor(-15066598);
                    textView.setBackgroundTintList(ColorStateList.valueOf(-13703535));
                }
                VoicePartyActivity voicePartyActivity3 = VoicePartyActivity.this;
                Integer num5 = num3;
                if (num5 != null && num5.intValue() > 0 && i10 > num.intValue() - num3.intValue()) {
                    z11 = true;
                }
                voicePartyActivity3.f18989w = z11;
            }
        });
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        e2();
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_voice_party);
        Intent intent = getIntent();
        s.h(intent, "intent");
        Config config = (Config) z0.g.a(intent, Config.class);
        if (config == null) {
            com.cupidapp.live.base.view.h.f12779a.s(this, "获取Config信息出错");
            finish();
            return;
        }
        c2(config);
        Z1(config.getRoomId());
        T1();
        U1();
        H1();
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        M1();
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        com.cupidapp.live.push.d.f17892a.j(false);
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        com.cupidapp.live.push.d.f17892a.j(true);
    }

    @Nullable
    public View p1(int i10) {
        Map<Integer, View> map = this.f18990x;
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
}

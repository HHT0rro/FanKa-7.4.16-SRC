package com.cupidapp.live.voiceparty.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.cupidapp.live.base.grpc.CuConnectorOuterClass;
import com.cupidapp.live.base.grpc.GrpcMessageRouter;
import com.cupidapp.live.base.grpc.IGrpcMessageListener;
import com.cupidapp.live.base.livedata.Event;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.e;
import com.cupidapp.live.base.network.i;
import com.cupidapp.live.base.network.model.ListResult;
import com.cupidapp.live.base.network.model.StateResult;
import com.cupidapp.live.base.network.model.SwipeCardUserLikeResult;
import com.cupidapp.live.base.network.model.ViewProfilePrefer;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.maskparty.model.MaskPartyChatConnectorMessageModel;
import com.cupidapp.live.maskparty.model.MaskPartyChatDiceModel;
import com.cupidapp.live.maskparty.model.MaskPartyChatLeaveRoom;
import com.cupidapp.live.maskparty.model.MaskPartyType;
import com.cupidapp.live.maskparty.model.QuitRoomModel;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.push.FKPushModel;
import com.cupidapp.live.push.FKPushType;
import com.cupidapp.live.push.util.PushExtraData;
import com.cupidapp.live.push.util.b;
import com.cupidapp.live.track.group.GroupSocialLog;
import com.cupidapp.live.voiceparty.layout.VoiceQuestionType;
import com.cupidapp.live.voiceparty.model.MaskPartyShowProfileModel;
import com.cupidapp.live.voiceparty.model.PublicProfileStatus;
import com.cupidapp.live.voiceparty.model.VoicePartyBtnType;
import com.cupidapp.live.voiceparty.model.VoicePartyDurationModel;
import com.cupidapp.live.voiceparty.model.VoicePartyGameNewSysTipModel;
import com.cupidapp.live.voiceparty.model.VoicePartyGameRequestModel;
import com.cupidapp.live.voiceparty.model.VoicePartyGameRequestType;
import com.cupidapp.live.voiceparty.model.VoicePartyGameSessionModel;
import com.cupidapp.live.voiceparty.model.VoicePartyGameSessionType;
import com.cupidapp.live.voiceparty.model.VoicePartyLateNightModel;
import com.cupidapp.live.voiceparty.model.VoicePartyQuestionItemModel;
import com.cupidapp.live.voiceparty.model.VoicePartyQuestionModel;
import com.cupidapp.live.voiceparty.model.VoicePartyRelationStatus;
import com.cupidapp.live.voiceparty.model.VoicePartyRoomDissolveModel;
import com.cupidapp.live.voiceparty.model.VoicePartyRoomDissolveReasonType;
import com.cupidapp.live.voiceparty.model.VoicePartyRoomModel;
import com.cupidapp.live.voiceparty.model.VoicePublicProfileModel;
import com.irisdt.client.post.PostAndSocialProtos;
import e4.a;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.List;
import kotlin.Lazy;
import kotlin.c;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import x2.a;
import z0.v;

/* compiled from: VoicePartyViewModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class VoicePartyViewModel extends ViewModel implements IGrpcMessageListener {

    @NotNull
    private final MutableLiveData<Event<StateResult<VoicePartyBtnType>>> _btnClickState;

    @NotNull
    private final MutableLiveData<VoicePartyGameSessionModel> _gameSessionLiveData;

    @NotNull
    private final MutableLiveData<Event<Boolean>> _hangUpLiveData;

    @NotNull
    private final MutableLiveData<VoicePartyGameSessionModel> _invitedFollowOther;

    @NotNull
    private final MutableLiveData<Event<Boolean>> _isAcceptLateNight;

    @NotNull
    private final MutableLiveData<Event<VoicePartyRelationStatus>> _matchStatus;

    @NotNull
    private final MutableLiveData<Event<Boolean>> _otherLeaveRoomLiveData;

    @NotNull
    private final MutableLiveData<Event<PublicProfileStatus>> _publicProfileForMe;

    @NotNull
    private final MutableLiveData<Event<PublicProfileStatus>> _publicProfileForOther;

    @NotNull
    private final MutableLiveData<List<VoicePartyQuestionModel>> _questionListLiveData;

    @NotNull
    private final MutableLiveData<Event<MaskPartyChatDiceModel>> _rollDiceLiveData;

    @NotNull
    private final MutableLiveData<Event<VoicePartyRoomDissolveModel>> _roomDissolve;

    @NotNull
    private final MutableLiveData<VoicePartyRoomModel> _roomModelLiveData;

    @NotNull
    private final LiveData<Event<StateResult<VoicePartyBtnType>>> btnClickState;

    @NotNull
    private final LiveData<VoicePartyGameSessionModel> gameSessionLiveData;

    @NotNull
    private final LiveData<Event<Boolean>> hangUpLiveData;

    @NotNull
    private final LiveData<VoicePartyGameSessionModel> invitedFollowOther;

    @NotNull
    private final LiveData<Event<Boolean>> isAcceptLateNight;
    private long mFirstTimeToEnterRoom;

    @NotNull
    private final Lazy mPublicProfileModel$delegate;

    @NotNull
    private VoicePartyRelationStatus mRelationStatus;
    private String mRoomId;

    @Nullable
    private VoicePartyRoomModel mRoomModel;

    @NotNull
    private final LiveData<Event<VoicePartyRelationStatus>> matchStatus;

    @NotNull
    private final LiveData<Event<Boolean>> otherLeaveRoomLiveData;

    @NotNull
    private final LiveData<Event<PublicProfileStatus>> publicProfileForMe;

    @NotNull
    private final LiveData<Event<PublicProfileStatus>> publicProfileForOther;

    @NotNull
    private final LiveData<List<VoicePartyQuestionModel>> questionListLiveData;

    @NotNull
    private final LiveData<Event<MaskPartyChatDiceModel>> rollDiceLiveData;

    @NotNull
    private final LiveData<Event<VoicePartyRoomDissolveModel>> roomDissolve;

    @NotNull
    private final LiveData<VoicePartyRoomModel> roomModelLiveData;

    public VoicePartyViewModel() {
        GrpcMessageRouter.INSTANCE.addIGrpcMessageListener(this);
        this.mPublicProfileModel$delegate = c.b(new Function0<VoicePublicProfileModel>() { // from class: com.cupidapp.live.voiceparty.viewmodel.VoicePartyViewModel$mPublicProfileModel$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final VoicePublicProfileModel invoke() {
                return new VoicePublicProfileModel(false, false);
            }
        });
        this.mRelationStatus = VoicePartyRelationStatus.NO_RELATIONSHIP;
        MutableLiveData<VoicePartyRoomModel> mutableLiveData = new MutableLiveData<>();
        this._roomModelLiveData = mutableLiveData;
        this.roomModelLiveData = mutableLiveData;
        MutableLiveData<Event<Boolean>> mutableLiveData2 = new MutableLiveData<>();
        this._hangUpLiveData = mutableLiveData2;
        this.hangUpLiveData = mutableLiveData2;
        MutableLiveData<Event<Boolean>> mutableLiveData3 = new MutableLiveData<>();
        this._otherLeaveRoomLiveData = mutableLiveData3;
        this.otherLeaveRoomLiveData = mutableLiveData3;
        MutableLiveData<VoicePartyGameSessionModel> mutableLiveData4 = new MutableLiveData<>();
        this._gameSessionLiveData = mutableLiveData4;
        this.gameSessionLiveData = mutableLiveData4;
        MutableLiveData<Event<MaskPartyChatDiceModel>> mutableLiveData5 = new MutableLiveData<>();
        this._rollDiceLiveData = mutableLiveData5;
        this.rollDiceLiveData = mutableLiveData5;
        MutableLiveData<List<VoicePartyQuestionModel>> mutableLiveData6 = new MutableLiveData<>();
        this._questionListLiveData = mutableLiveData6;
        this.questionListLiveData = mutableLiveData6;
        MutableLiveData<Event<Boolean>> mutableLiveData7 = new MutableLiveData<>();
        this._isAcceptLateNight = mutableLiveData7;
        this.isAcceptLateNight = mutableLiveData7;
        MutableLiveData<Event<PublicProfileStatus>> mutableLiveData8 = new MutableLiveData<>();
        this._publicProfileForMe = mutableLiveData8;
        this.publicProfileForMe = mutableLiveData8;
        MutableLiveData<Event<PublicProfileStatus>> mutableLiveData9 = new MutableLiveData<>();
        this._publicProfileForOther = mutableLiveData9;
        this.publicProfileForOther = mutableLiveData9;
        MutableLiveData<Event<VoicePartyRelationStatus>> mutableLiveData10 = new MutableLiveData<>();
        this._matchStatus = mutableLiveData10;
        this.matchStatus = mutableLiveData10;
        MutableLiveData<Event<VoicePartyRoomDissolveModel>> mutableLiveData11 = new MutableLiveData<>();
        this._roomDissolve = mutableLiveData11;
        this.roomDissolve = mutableLiveData11;
        MutableLiveData<VoicePartyGameSessionModel> mutableLiveData12 = new MutableLiveData<>();
        this._invitedFollowOther = mutableLiveData12;
        this.invitedFollowOther = mutableLiveData12;
        MutableLiveData<Event<StateResult<VoicePartyBtnType>>> mutableLiveData13 = new MutableLiveData<>();
        this._btnClickState = mutableLiveData13;
        this.btnClickState = mutableLiveData13;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final VoicePublicProfileModel getMPublicProfileModel() {
        return (VoicePublicProfileModel) this.mPublicProfileModel$delegate.getValue();
    }

    private final Long getVoiceCallDuration() {
        if (this.mFirstTimeToEnterRoom <= 0) {
            return null;
        }
        return Long.valueOf(v.p(System.currentTimeMillis() - this.mFirstTimeToEnterRoom));
    }

    public final void callAcceptOrRefuseLateNightInviteApi(boolean z10) {
        final VoicePartyBtnType voicePartyBtnType;
        if (z10) {
            voicePartyBtnType = VoicePartyBtnType.OTHER_INVITE_ME_FOR_LATE_NIGHT_ACCEPT_BTN;
        } else {
            voicePartyBtnType = VoicePartyBtnType.OTHER_INVITE_ME_FOR_LATE_NIGHT_REFUSE_BTN;
        }
        this._btnClickState.setValue(new Event<>(new StateResult.b(voicePartyBtnType, null, 2, null)));
        a y10 = NetworkClient.f11868a.y();
        String str = this.mRoomId;
        if (str == null) {
            s.A("mRoomId");
            str = null;
        }
        Disposable disposed = y10.j(str, z10).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<Object, p>() { // from class: com.cupidapp.live.voiceparty.viewmodel.VoicePartyViewModel$callAcceptOrRefuseLateNightInviteApi$$inlined$handle$1
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
                MutableLiveData mutableLiveData;
                mutableLiveData = VoicePartyViewModel.this._btnClickState;
                mutableLiveData.setValue(new Event(new StateResult.c(voicePartyBtnType, null, 2, null)));
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.voiceparty.viewmodel.VoicePartyViewModel$callAcceptOrRefuseLateNightInviteApi$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                MutableLiveData mutableLiveData;
                s.i(it, "it");
                mutableLiveData = VoicePartyViewModel.this._btnClickState;
                mutableLiveData.setValue(new Event(new StateResult.a(null, voicePartyBtnType, null, 5, null)));
                return Boolean.FALSE;
            }
        }, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    public final void callAgreeGameInviteApi() {
        final VoicePartyBtnType voicePartyBtnType = VoicePartyBtnType.OTHER_INVITE_ME_AGREE_BTN;
        this._btnClickState.setValue(new Event<>(new StateResult.b(voicePartyBtnType, null, 2, null)));
        a y10 = NetworkClient.f11868a.y();
        String str = this.mRoomId;
        if (str == null) {
            s.A("mRoomId");
            str = null;
        }
        Disposable disposed = y10.g(str).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<Object, p>() { // from class: com.cupidapp.live.voiceparty.viewmodel.VoicePartyViewModel$callAgreeGameInviteApi$$inlined$handle$1
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
                MutableLiveData mutableLiveData;
                mutableLiveData = VoicePartyViewModel.this._btnClickState;
                mutableLiveData.setValue(new Event(new StateResult.c(voicePartyBtnType, null, 2, null)));
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.voiceparty.viewmodel.VoicePartyViewModel$callAgreeGameInviteApi$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                MutableLiveData mutableLiveData;
                s.i(it, "it");
                mutableLiveData = VoicePartyViewModel.this._btnClickState;
                mutableLiveData.setValue(new Event(new StateResult.a(null, voicePartyBtnType, null, 5, null)));
                return Boolean.FALSE;
            }
        }, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    public final void callFollowHimApi(@NotNull final SensorPosition position) {
        User targetUserInfo;
        s.i(position, "position");
        final VoicePartyBtnType voicePartyBtnType = VoicePartyBtnType.INVITED_FOLLOW_OTHER_AGREE_BTN;
        this._btnClickState.setValue(new Event<>(new StateResult.b(voicePartyBtnType, null, 2, null)));
        VoicePartyRoomModel voicePartyRoomModel = this.mRoomModel;
        String userId = (voicePartyRoomModel == null || (targetUserInfo = voicePartyRoomModel.getTargetUserInfo()) == null) ? null : targetUserInfo.userId();
        if (userId == null || userId.length() == 0) {
            this._btnClickState.setValue(new Event<>(new StateResult.a(null, voicePartyBtnType, null, 5, null)));
            return;
        }
        Disposable disposed = a.C0836a.o(NetworkClient.f11868a.N(), userId, null, null, ViewProfilePrefer.MaskAudioRoom.getValue(), 0, null, null, null, 246, null).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<SwipeCardUserLikeResult, p>() { // from class: com.cupidapp.live.voiceparty.viewmodel.VoicePartyViewModel$callFollowHimApi$$inlined$handle$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(SwipeCardUserLikeResult swipeCardUserLikeResult) {
                m2845invoke(swipeCardUserLikeResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2845invoke(SwipeCardUserLikeResult swipeCardUserLikeResult) {
                MutableLiveData mutableLiveData;
                SwipeCardUserLikeResult swipeCardUserLikeResult2 = swipeCardUserLikeResult;
                mutableLiveData = VoicePartyViewModel.this._btnClickState;
                mutableLiveData.setValue(new Event(new StateResult.c(voicePartyBtnType, null, 2, null)));
                if (swipeCardUserLikeResult2.getUser().getMatch()) {
                    VoicePartyViewModel.this.mRelationStatus = VoicePartyRelationStatus.MATCH;
                } else if (swipeCardUserLikeResult2.getUser().getAloha() && !swipeCardUserLikeResult2.getUser().getAlohaGet()) {
                    VoicePartyViewModel.this.mRelationStatus = VoicePartyRelationStatus.ME_FOLLOW_OTHER;
                } else if (!swipeCardUserLikeResult2.getUser().getAloha() && swipeCardUserLikeResult2.getUser().getAlohaGet()) {
                    VoicePartyViewModel.this.mRelationStatus = VoicePartyRelationStatus.OTHER_FOLLOW_ME;
                }
                VoicePartyViewModel.this.m2844getMatchStatus();
                GroupSocialLog.f18708a.B(true, null, swipeCardUserLikeResult2.getUser().userId(), (r52 & 8) != 0 ? 1 : 0, (r52 & 16) != 0 ? null : null, (r52 & 32) != 0 ? null : null, (r52 & 64) != 0 ? false : false, (r52 & 128) != 0 ? null : null, (r52 & 256) != 0 ? null : position, (r52 & 512) != 0 ? false : false, (r52 & 1024) != 0 ? null : null, (r52 & 2048) != 0 ? null : null, (r52 & 4096) != 0 ? 0 : 0, (r52 & 8192) != 0 ? null : null, (r52 & 16384) != 0 ? false : false, (32768 & r52) != 0 ? null : null, (65536 & r52) != 0 ? null : null, (131072 & r52) != 0 ? null : null, (262144 & r52) != 0 ? null : null, (524288 & r52) != 0 ? null : null, (1048576 & r52) != 0 ? null : null, (2097152 & r52) != 0 ? null : null, (4194304 & r52) != 0 ? null : null, (r52 & 8388608) != 0 ? null : null);
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.voiceparty.viewmodel.VoicePartyViewModel$callFollowHimApi$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                MutableLiveData mutableLiveData;
                s.i(it, "it");
                mutableLiveData = VoicePartyViewModel.this._btnClickState;
                mutableLiveData.setValue(new Event(new StateResult.a(null, voicePartyBtnType, null, 5, null)));
                return Boolean.FALSE;
            }
        }, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    public final void callGameInviteApi() {
        e4.a y10 = NetworkClient.f11868a.y();
        String str = this.mRoomId;
        if (str == null) {
            s.A("mRoomId");
            str = null;
        }
        Disposable disposed = y10.c(str).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<Object, p>() { // from class: com.cupidapp.live.voiceparty.viewmodel.VoicePartyViewModel$callGameInviteApi$$inlined$handle$default$1
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
                MutableLiveData mutableLiveData;
                mutableLiveData = VoicePartyViewModel.this._gameSessionLiveData;
                mutableLiveData.setValue(new VoicePartyGameSessionModel(VoicePartyGameSessionType.INVITE_OTHER, "游戏邀请已发送", "语音游戏需要对方同意后才能开始，请稍候...", 0, 0, null, 56, null));
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(null, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    public final void callHangUpApi() {
        User targetUserInfo;
        Long voiceCallDuration = getVoiceCallDuration();
        GroupSocialLog groupSocialLog = GroupSocialLog.f18708a;
        PostAndSocialProtos.Type type = PostAndSocialProtos.Type.RING_OFF;
        String str = this.mRoomId;
        if (str == null) {
            s.A("mRoomId");
            str = null;
        }
        VoicePartyRoomModel voicePartyRoomModel = this.mRoomModel;
        groupSocialLog.a0(type, (r13 & 2) != 0 ? null : str, (r13 & 4) != 0 ? null : (voicePartyRoomModel == null || (targetUserInfo = voicePartyRoomModel.getTargetUserInfo()) == null) ? null : targetUserInfo.userId(), (r13 & 8) != 0 ? null : null, (r13 & 16) != 0 ? null : voiceCallDuration);
        e4.a y10 = NetworkClient.f11868a.y();
        String str2 = this.mRoomId;
        if (str2 == null) {
            s.A("mRoomId");
            str2 = null;
        }
        Disposable disposed = y10.f(str2, voiceCallDuration != null ? Integer.valueOf((int) voiceCallDuration.longValue()) : null).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<QuitRoomModel, p>() { // from class: com.cupidapp.live.voiceparty.viewmodel.VoicePartyViewModel$callHangUpApi$$inlined$handle$default$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(QuitRoomModel quitRoomModel) {
                m2846invoke(quitRoomModel);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2846invoke(QuitRoomModel quitRoomModel) {
                MutableLiveData mutableLiveData;
                mutableLiveData = VoicePartyViewModel.this._hangUpLiveData;
                mutableLiveData.setValue(new Event(Boolean.valueOf(quitRoomModel.getPropCardTipWindow())));
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(null, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    public final void callInviteFollowMeApi() {
        User targetUserInfo;
        VoicePartyRoomModel voicePartyRoomModel = this.mRoomModel;
        String userId = (voicePartyRoomModel == null || (targetUserInfo = voicePartyRoomModel.getTargetUserInfo()) == null) ? null : targetUserInfo.userId();
        if (userId == null || userId.length() == 0) {
            return;
        }
        e4.a y10 = NetworkClient.f11868a.y();
        String str = this.mRoomId;
        if (str == null) {
            s.A("mRoomId");
            str = null;
        }
        Disposable disposed = y10.d(str, userId).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<Object, p>() { // from class: com.cupidapp.live.voiceparty.viewmodel.VoicePartyViewModel$callInviteFollowMeApi$$inlined$handle$default$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Object obj) {
                invoke2(obj);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object obj) {
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(null, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    public final void callPublicProfileApi() {
        e4.a y10 = NetworkClient.f11868a.y();
        String str = this.mRoomId;
        if (str == null) {
            s.A("mRoomId");
            str = null;
        }
        Disposable disposed = y10.h(str).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<Object, p>() { // from class: com.cupidapp.live.voiceparty.viewmodel.VoicePartyViewModel$callPublicProfileApi$$inlined$handle$default$1
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
                VoicePublicProfileModel mPublicProfileModel;
                MutableLiveData mutableLiveData;
                String str2;
                VoicePartyRoomModel voicePartyRoomModel;
                User targetUserInfo;
                mPublicProfileModel = VoicePartyViewModel.this.getMPublicProfileModel();
                mPublicProfileModel.setMyPublic(true);
                PublicProfileStatus publicProfileStatus = VoicePartyViewModel.this.getPublicProfileStatus();
                if (publicProfileStatus == PublicProfileStatus.BOTH_PUBLIC) {
                    GroupSocialLog groupSocialLog = GroupSocialLog.f18708a;
                    PostAndSocialProtos.Type type = PostAndSocialProtos.Type.SHOW_PROFILE;
                    str2 = VoicePartyViewModel.this.mRoomId;
                    String str3 = null;
                    if (str2 == null) {
                        s.A("mRoomId");
                        str2 = null;
                    }
                    voicePartyRoomModel = VoicePartyViewModel.this.mRoomModel;
                    if (voicePartyRoomModel != null && (targetUserInfo = voicePartyRoomModel.getTargetUserInfo()) != null) {
                        str3 = targetUserInfo.userId();
                    }
                    groupSocialLog.a0(type, (r13 & 2) != 0 ? null : str2, (r13 & 4) != 0 ? null : str3, (r13 & 8) != 0 ? null : null, (r13 & 16) != 0 ? null : null);
                }
                mutableLiveData = VoicePartyViewModel.this._publicProfileForMe;
                mutableLiveData.setValue(new Event(publicProfileStatus));
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(null, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    public final void callQuestionListApi() {
        e4.a y10 = NetworkClient.f11868a.y();
        String str = this.mRoomId;
        if (str == null) {
            s.A("mRoomId");
            str = null;
        }
        Disposable disposed = y10.i(str, MaskPartyType.VoiceChat.getType()).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<ListResult<VoicePartyQuestionModel>, p>() { // from class: com.cupidapp.live.voiceparty.viewmodel.VoicePartyViewModel$callQuestionListApi$$inlined$handle$default$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(ListResult<VoicePartyQuestionModel> listResult) {
                m2847invoke(listResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2847invoke(ListResult<VoicePartyQuestionModel> listResult) {
                MutableLiveData mutableLiveData;
                List<VoicePartyQuestionModel> list = listResult.getList();
                if (list != null) {
                    mutableLiveData = VoicePartyViewModel.this._questionListLiveData;
                    mutableLiveData.setValue(list);
                }
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(null, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    public final void callRoomInfoApi(@NotNull String roomId) {
        s.i(roomId, "roomId");
        this.mRoomId = roomId;
        Disposable disposed = NetworkClient.f11868a.y().k(roomId).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<VoicePartyRoomModel, p>() { // from class: com.cupidapp.live.voiceparty.viewmodel.VoicePartyViewModel$callRoomInfoApi$$inlined$handle$default$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(VoicePartyRoomModel voicePartyRoomModel) {
                m2848invoke(voicePartyRoomModel);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2848invoke(VoicePartyRoomModel voicePartyRoomModel) {
                MutableLiveData mutableLiveData;
                VoicePartyRoomModel voicePartyRoomModel2 = voicePartyRoomModel;
                VoicePartyViewModel.this.mRoomModel = voicePartyRoomModel2;
                VoicePartyViewModel.this.mRelationStatus = voicePartyRoomModel2.getRelationStatus();
                VoicePartyViewModel.this.mFirstTimeToEnterRoom = System.currentTimeMillis();
                mutableLiveData = VoicePartyViewModel.this._roomModelLiveData;
                mutableLiveData.setValue(voicePartyRoomModel2);
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(null, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    public final void callVoiceRoomDissolveApi() {
        VoicePartyRoomDissolveReasonType voicePartyRoomDissolveReasonType;
        String str;
        User targetUserInfo;
        PublicProfileStatus publicProfileStatus = getPublicProfileStatus();
        VoicePartyRelationStatus relationStatus = getRelationStatus();
        PublicProfileStatus publicProfileStatus2 = PublicProfileStatus.BOTH_PUBLIC;
        if (publicProfileStatus != publicProfileStatus2) {
            voicePartyRoomDissolveReasonType = VoicePartyRoomDissolveReasonType.NOT_PUBLIC_PROFILE;
        } else if (publicProfileStatus == publicProfileStatus2 && relationStatus != VoicePartyRelationStatus.MATCH) {
            voicePartyRoomDissolveReasonType = VoicePartyRoomDissolveReasonType.PUBLIC_PROFILE_BUT_NOT_MATCH;
        } else {
            voicePartyRoomDissolveReasonType = (publicProfileStatus == publicProfileStatus2 && relationStatus == VoicePartyRelationStatus.MATCH) ? VoicePartyRoomDissolveReasonType.PUBLIC_PROFILE_AND_MATCH_BUT_TIMEOUT : null;
        }
        if (voicePartyRoomDissolveReasonType == null) {
            return;
        }
        GroupSocialLog groupSocialLog = GroupSocialLog.f18708a;
        PostAndSocialProtos.Type type = PostAndSocialProtos.Type.CALL_END;
        String str2 = this.mRoomId;
        if (str2 == null) {
            s.A("mRoomId");
            str = null;
        } else {
            str = str2;
        }
        Long voiceCallDuration = getVoiceCallDuration();
        VoicePartyRoomModel voicePartyRoomModel = this.mRoomModel;
        groupSocialLog.a0(type, (r13 & 2) != 0 ? null : str, (r13 & 4) != 0 ? null : (voicePartyRoomModel == null || (targetUserInfo = voicePartyRoomModel.getTargetUserInfo()) == null) ? null : targetUserInfo.userId(), (r13 & 8) != 0 ? null : null, (r13 & 16) != 0 ? null : voiceCallDuration);
        e4.a y10 = NetworkClient.f11868a.y();
        String str3 = this.mRoomId;
        if (str3 == null) {
            s.A("mRoomId");
            str3 = null;
        }
        Disposable disposed = y10.e(str3, voicePartyRoomDissolveReasonType.getValue()).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<VoicePartyRoomDissolveModel, p>() { // from class: com.cupidapp.live.voiceparty.viewmodel.VoicePartyViewModel$callVoiceRoomDissolveApi$$inlined$handle$default$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(VoicePartyRoomDissolveModel voicePartyRoomDissolveModel) {
                m2849invoke(voicePartyRoomDissolveModel);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2849invoke(VoicePartyRoomDissolveModel voicePartyRoomDissolveModel) {
                MutableLiveData mutableLiveData;
                mutableLiveData = VoicePartyViewModel.this._roomDissolve;
                mutableLiveData.setValue(new Event(voicePartyRoomDissolveModel));
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(null, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    @NotNull
    public final LiveData<Event<StateResult<VoicePartyBtnType>>> getBtnClickState() {
        return this.btnClickState;
    }

    @Nullable
    public final VoicePartyDurationModel getDurationModel() {
        VoicePartyRoomModel voicePartyRoomModel = this.mRoomModel;
        if (voicePartyRoomModel != null) {
            return voicePartyRoomModel.getAudioGameInfo();
        }
        return null;
    }

    @NotNull
    public final LiveData<VoicePartyGameSessionModel> getGameSessionLiveData() {
        return this.gameSessionLiveData;
    }

    @NotNull
    public final LiveData<Event<Boolean>> getHangUpLiveData() {
        return this.hangUpLiveData;
    }

    @NotNull
    public final LiveData<VoicePartyGameSessionModel> getInvitedFollowOther() {
        return this.invitedFollowOther;
    }

    @NotNull
    public final LiveData<Event<VoicePartyRelationStatus>> getMatchStatus() {
        return this.matchStatus;
    }

    @NotNull
    public final LiveData<Event<Boolean>> getOtherLeaveRoomLiveData() {
        return this.otherLeaveRoomLiveData;
    }

    @Nullable
    public final User getOtherUserInfo() {
        VoicePartyRoomModel voicePartyRoomModel = this.mRoomModel;
        if (voicePartyRoomModel != null) {
            return voicePartyRoomModel.getTargetUserInfo();
        }
        return null;
    }

    @NotNull
    public final LiveData<Event<PublicProfileStatus>> getPublicProfileForMe() {
        return this.publicProfileForMe;
    }

    @NotNull
    public final LiveData<Event<PublicProfileStatus>> getPublicProfileForOther() {
        return this.publicProfileForOther;
    }

    @NotNull
    public final PublicProfileStatus getPublicProfileStatus() {
        return getMPublicProfileModel().getPublicProfileStatus();
    }

    @NotNull
    public final LiveData<List<VoicePartyQuestionModel>> getQuestionListLiveData() {
        return this.questionListLiveData;
    }

    @NotNull
    public final VoicePartyRelationStatus getRelationStatus() {
        return this.mRelationStatus;
    }

    @NotNull
    public final LiveData<Event<MaskPartyChatDiceModel>> getRollDiceLiveData() {
        return this.rollDiceLiveData;
    }

    @NotNull
    public final LiveData<Event<VoicePartyRoomDissolveModel>> getRoomDissolve() {
        return this.roomDissolve;
    }

    @NotNull
    public final LiveData<VoicePartyRoomModel> getRoomModelLiveData() {
        return this.roomModelLiveData;
    }

    @NotNull
    public final LiveData<Event<Boolean>> isAcceptLateNight() {
        return this.isAcceptLateNight;
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        GrpcMessageRouter.INSTANCE.removeIGrpcMessageListener(this);
    }

    @Override // com.cupidapp.live.base.grpc.IGrpcMessageListener
    public void onReceiveGrpcMessage(@NotNull CuConnectorOuterClass.MessageType type, @NotNull Object model) {
        VoicePartyRelationStatus voicePartyRelationStatus;
        User targetUserInfo;
        String str;
        User targetUserInfo2;
        VoicePartyGameSessionType voicePartyGameSessionType;
        s.i(type, "type");
        s.i(model, "model");
        String str2 = null;
        if (model instanceof MaskPartyChatConnectorMessageModel) {
            String roomId = ((MaskPartyChatConnectorMessageModel) model).getRoomId();
            String str3 = this.mRoomId;
            if (str3 == null) {
                s.A("mRoomId");
                str3 = null;
            }
            if (!s.d(roomId, str3)) {
                return;
            }
        }
        if (model instanceof MaskPartyChatLeaveRoom) {
            this._otherLeaveRoomLiveData.setValue(new Event<>(Boolean.TRUE));
            return;
        }
        if (model instanceof VoicePartyGameRequestModel) {
            VoicePartyGameRequestModel voicePartyGameRequestModel = (VoicePartyGameRequestModel) model;
            int type2 = voicePartyGameRequestModel.getType();
            if (type2 == VoicePartyGameRequestType.COMMON_GAME_INVITE.getType()) {
                this._gameSessionLiveData.setValue(new VoicePartyGameSessionModel(VoicePartyGameSessionType.OTHER_INVITE_ME, voicePartyGameRequestModel.getTitle(), voicePartyGameRequestModel.getContent(), voicePartyGameRequestModel.getCountdownSec(), 0, null, 48, null));
                return;
            } else if (type2 == VoicePartyGameRequestType.LATE_NIGHT_INVITE.getType()) {
                this._gameSessionLiveData.setValue(new VoicePartyGameSessionModel(VoicePartyGameSessionType.OTHER_INVITE_ME_FOR_LATE_NIGHT, null, voicePartyGameRequestModel.getContent(), 0, 0, voicePartyGameRequestModel.getTip(), 24, null));
                return;
            } else {
                if (type2 == VoicePartyGameRequestType.FOLLOW_INVITE.getType()) {
                    this._invitedFollowOther.setValue(new VoicePartyGameSessionModel(VoicePartyGameSessionType.INVITED_FOLLOW_OTHER, null, voicePartyGameRequestModel.getContent(), voicePartyGameRequestModel.getCountdownSec(), 0, null, 48, null));
                    return;
                }
                return;
            }
        }
        if (model instanceof MaskPartyChatDiceModel) {
            this._rollDiceLiveData.setValue(new Event<>(model));
            return;
        }
        if (model instanceof VoicePartyGameNewSysTipModel) {
            VoicePartyGameNewSysTipModel voicePartyGameNewSysTipModel = (VoicePartyGameNewSysTipModel) model;
            if (s.d(voicePartyGameNewSysTipModel.isQuestion(), Boolean.TRUE)) {
                voicePartyGameSessionType = VoicePartyGameSessionType.LOSE_SHOW_QUESTION_CONTENT;
            } else {
                voicePartyGameSessionType = VoicePartyGameSessionType.OTHER_SELECT_QUESTION_TYPE;
            }
            this._gameSessionLiveData.setValue(new VoicePartyGameSessionModel(voicePartyGameSessionType, voicePartyGameNewSysTipModel.getTitle(), voicePartyGameNewSysTipModel.getContent(), 0, voicePartyGameNewSysTipModel.getCountdownSec(), null, 40, null));
            return;
        }
        if (model instanceof VoicePartyLateNightModel) {
            this._isAcceptLateNight.setValue(new Event<>(Boolean.valueOf(((VoicePartyLateNightModel) model).isAcceptLateNight())));
            return;
        }
        boolean z10 = true;
        if (model instanceof MaskPartyShowProfileModel) {
            getMPublicProfileModel().setOtherPublic(true);
            PublicProfileStatus publicProfileStatus = getPublicProfileStatus();
            if (publicProfileStatus == PublicProfileStatus.BOTH_PUBLIC) {
                GroupSocialLog groupSocialLog = GroupSocialLog.f18708a;
                PostAndSocialProtos.Type type3 = PostAndSocialProtos.Type.SHOW_PROFILE;
                String str4 = this.mRoomId;
                if (str4 == null) {
                    s.A("mRoomId");
                    str = null;
                } else {
                    str = str4;
                }
                VoicePartyRoomModel voicePartyRoomModel = this.mRoomModel;
                if (voicePartyRoomModel != null && (targetUserInfo2 = voicePartyRoomModel.getTargetUserInfo()) != null) {
                    str2 = targetUserInfo2.userId();
                }
                groupSocialLog.a0(type3, (r13 & 2) != 0 ? null : str, (r13 & 4) != 0 ? null : str2, (r13 & 8) != 0 ? null : null, (r13 & 16) != 0 ? null : null);
            }
            this._publicProfileForOther.setValue(new Event<>(publicProfileStatus));
            return;
        }
        if (model instanceof FKPushModel) {
            FKPushModel fKPushModel = (FKPushModel) model;
            FKPushType pushType = fKPushModel.getPushMessageModel().getPushType();
            FKPushType fKPushType = FKPushType.Aloha;
            if (pushType == fKPushType || pushType == FKPushType.NewMatch) {
                PushExtraData a10 = b.a(fKPushModel.getPushMessageModel().getData());
                String userId = a10 != null ? a10.getUserId() : null;
                VoicePartyRoomModel voicePartyRoomModel2 = this.mRoomModel;
                if (voicePartyRoomModel2 != null && (targetUserInfo = voicePartyRoomModel2.getTargetUserInfo()) != null) {
                    str2 = targetUserInfo.userId();
                }
                if (userId == null || userId.length() == 0) {
                    return;
                }
                if (str2 != null && str2.length() != 0) {
                    z10 = false;
                }
                if (z10 || !s.d(userId, str2)) {
                    return;
                }
                if (pushType == fKPushType) {
                    voicePartyRelationStatus = VoicePartyRelationStatus.OTHER_FOLLOW_ME;
                } else {
                    voicePartyRelationStatus = VoicePartyRelationStatus.MATCH;
                }
                this.mRelationStatus = voicePartyRelationStatus;
                m2844getMatchStatus();
            }
        }
    }

    public final void selectQuestionContent(@NotNull final VoicePartyQuestionItemModel model) {
        String str;
        User targetUserInfo;
        s.i(model, "model");
        GroupSocialLog groupSocialLog = GroupSocialLog.f18708a;
        PostAndSocialProtos.Type type = PostAndSocialProtos.Type.ASK_QUESTION;
        String str2 = this.mRoomId;
        if (str2 == null) {
            s.A("mRoomId");
            str = null;
        } else {
            str = str2;
        }
        int index = model.getIndex();
        VoicePartyRoomModel voicePartyRoomModel = this.mRoomModel;
        groupSocialLog.a0(type, (r13 & 2) != 0 ? null : str, (r13 & 4) != 0 ? null : (voicePartyRoomModel == null || (targetUserInfo = voicePartyRoomModel.getTargetUserInfo()) == null) ? null : targetUserInfo.userId(), (r13 & 8) != 0 ? null : Integer.valueOf(index), (r13 & 16) != 0 ? null : null);
        e4.a y10 = NetworkClient.f11868a.y();
        String str3 = this.mRoomId;
        if (str3 == null) {
            s.A("mRoomId");
            str3 = null;
        }
        Disposable disposed = y10.a(str3, model.getIndex()).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<Object, p>() { // from class: com.cupidapp.live.voiceparty.viewmodel.VoicePartyViewModel$selectQuestionContent$$inlined$handle$default$1
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
                MutableLiveData mutableLiveData;
                VoicePartyDurationModel durationModel = VoicePartyViewModel.this.getDurationModel();
                int audioGameSysTipCountdownSec = durationModel != null ? durationModel.getAudioGameSysTipCountdownSec() : 60;
                mutableLiveData = VoicePartyViewModel.this._gameSessionLiveData;
                mutableLiveData.setValue(new VoicePartyGameSessionModel(VoicePartyGameSessionType.ASK_QUESTION, "你已发出提问", model.getContent(), 0, audioGameSysTipCountdownSec, null, 40, null));
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(null, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    public final void selectQuestionType(final int i10) {
        e4.a y10 = NetworkClient.f11868a.y();
        String str = this.mRoomId;
        if (str == null) {
            s.A("mRoomId");
            str = null;
        }
        Disposable disposed = y10.b(str, i10).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<Object, p>() { // from class: com.cupidapp.live.voiceparty.viewmodel.VoicePartyViewModel$selectQuestionType$$inlined$handle$default$1
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
                MutableLiveData mutableLiveData;
                if (i10 == VoiceQuestionType.LateNight.getType()) {
                    mutableLiveData = this._gameSessionLiveData;
                    mutableLiveData.setValue(new VoicePartyGameSessionModel(VoicePartyGameSessionType.SELECT_LATE_NIGHT_QUESTION_TYPE, "你选择了 [深夜模式]", "该模式需对方接受后开启 请稍等…", 0, 0, null, 56, null));
                }
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(null, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    public final void sendRollDiceLoseLiveData() {
        this._gameSessionLiveData.setValue(new VoicePartyGameSessionModel(VoicePartyGameSessionType.ROLL_DICE_LOSE, "小输一局，等待对方提问吧", "对方正在选择问题类型 请稍等...", 0, 0, null, 56, null));
    }

    /* renamed from: getMatchStatus, reason: collision with other method in class */
    public final void m2844getMatchStatus() {
        String str;
        User targetUserInfo;
        if (this.mRelationStatus == VoicePartyRelationStatus.MATCH) {
            GroupSocialLog groupSocialLog = GroupSocialLog.f18708a;
            PostAndSocialProtos.Type type = PostAndSocialProtos.Type.REACH_MATCH;
            String str2 = this.mRoomId;
            if (str2 == null) {
                s.A("mRoomId");
                str = null;
            } else {
                str = str2;
            }
            VoicePartyRoomModel voicePartyRoomModel = this.mRoomModel;
            groupSocialLog.a0(type, (r13 & 2) != 0 ? null : str, (r13 & 4) != 0 ? null : (voicePartyRoomModel == null || (targetUserInfo = voicePartyRoomModel.getTargetUserInfo()) == null) ? null : targetUserInfo.userId(), (r13 & 8) != 0 ? null : null, (r13 & 16) != 0 ? null : null);
        }
        this._matchStatus.setValue(new Event<>(this.mRelationStatus));
    }
}

package com.cupidapp.live.consult.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import c2.a;
import com.cupidapp.live.base.grpc.CuConnectorOuterClass;
import com.cupidapp.live.base.grpc.GrpcMessageRouter;
import com.cupidapp.live.base.grpc.IGrpcMessageListener;
import com.cupidapp.live.base.livedata.Event;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.RequestErrorCode;
import com.cupidapp.live.base.network.e;
import com.cupidapp.live.base.network.i;
import com.cupidapp.live.base.network.j;
import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.consult.activity.ConsultViewerActivity;
import com.cupidapp.live.consult.helper.ConsultLiveHelper;
import com.cupidapp.live.consult.model.BaseConsultLiveGrpcModel;
import com.cupidapp.live.consult.model.ConnectFinishedModel;
import com.cupidapp.live.consult.model.ConsultAnchorInfoChangeGrpcModel;
import com.cupidapp.live.consult.model.ConsultApplyConnectGrpcModel;
import com.cupidapp.live.consult.model.ConsultCommentGrpcModel;
import com.cupidapp.live.consult.model.ConsultCommentModel;
import com.cupidapp.live.consult.model.ConsultConnectChargeResult;
import com.cupidapp.live.consult.model.ConsultConnectState;
import com.cupidapp.live.consult.model.ConsultConnectSuccessGrpcModel;
import com.cupidapp.live.consult.model.ConsultConnectType;
import com.cupidapp.live.consult.model.ConsultConnectUserModel;
import com.cupidapp.live.consult.model.ConsultConnectUserResult;
import com.cupidapp.live.consult.model.ConsultHangUpConnectGrpcModel;
import com.cupidapp.live.consult.model.ConsultLiveModel;
import com.cupidapp.live.consult.model.ConsultOnlineInfoGrpcModel;
import com.cupidapp.live.consult.model.ConsultOnlineInfoModel;
import com.cupidapp.live.consult.model.ConsultRequestConnectGrpcModel;
import com.cupidapp.live.consult.model.ConsultRoomEndGrpcModel;
import com.cupidapp.live.consult.model.HangUpConnectModel;
import com.cupidapp.live.consult.model.RequestConnectCountGrpcModel;
import com.cupidapp.live.consult.model.RequestConnectResult;
import com.cupidapp.live.consult.model.ShowDiamondBalanceModel;
import com.cupidapp.live.consult.view.ViewerConsultConnectLayout;
import com.cupidapp.live.consult.viewmodel.ConsultViewerViewModel;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.voiceparty.engine.IVoiceEngine;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.List;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.collections.r;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.t;

/* compiled from: ConsultViewerViewModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ConsultViewerViewModel extends ViewModel implements IGrpcMessageListener {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @Nullable
    private static Long mEnterRoomTime;

    @Nullable
    private static String mNewRoomId;

    @Nullable
    private static String mRequestId;

    @Nullable
    private static String mVoiceConnectType;

    @NotNull
    private final MutableLiveData<Event<Pair<Boolean, List<ConsultCommentModel>>>> _addCommentData;

    @NotNull
    private final MutableLiveData<Event<Pair<String, IVoiceEngine.VoiceEngineOption>>> _agreeConnectLiveData;

    @NotNull
    private final MutableLiveData<Event<ImageModel>> _anchorLevel;

    @NotNull
    private final MutableLiveData<Event<ConsultApplyConnectGrpcModel>> _applyConnectPromptLiveData;

    @NotNull
    private final MutableLiveData<Event<Boolean>> _cancelRequestLiveData;

    @NotNull
    private final MutableLiveData<Event<Boolean>> _cannotWatchLive;

    @NotNull
    private final MutableLiveData<Event<Integer>> _connectCountChangeLiveData;

    @NotNull
    private final MutableLiveData<Event<Pair<Boolean, ConsultConnectSuccessGrpcModel>>> _connectSuccessLiveData;

    @NotNull
    private final MutableLiveData<Event<Pair<Boolean, ConsultLiveModel>>> _enterRoomLog;

    @NotNull
    private final MutableLiveData<Event<HangUpConnectModel>> _hangUpConnectLiveData;

    @NotNull
    private final MutableLiveData<Event<ConsultLiveModel>> _liveEnd;

    @NotNull
    private final MutableLiveData<Event<ConsultLiveModel>> _liveInfoData;

    @NotNull
    private final MutableLiveData<Event<ConsultOnlineInfoModel>> _onlineInfoData;

    @NotNull
    private final MutableLiveData<Event<Triple<Boolean, ConsultLiveModel, HangUpConnectModel>>> _refreshRoomInfoLiveData;

    @NotNull
    private final MutableLiveData<Event<Boolean>> _requestConnectChangeLiveData;

    @NotNull
    private final MutableLiveData<Event<RequestConnectResult>> _requestConnectLiveData;

    @NotNull
    private final MutableLiveData<Event<Pair<String, ConsultConnectState>>> _showConnectOrderLiveData;

    @NotNull
    private final MutableLiveData<Event<ShowDiamondBalanceModel>> _showRechargeLiveData;

    @NotNull
    private final MutableLiveData<Event<String>> _showRequestConnectLiveData;

    @NotNull
    private final MutableLiveData<Event<IVoiceEngine.VoiceEngineOption>> _voiceEngineOption;

    @NotNull
    private final LiveData<Event<Pair<Boolean, List<ConsultCommentModel>>>> addCommentData;

    @NotNull
    private final LiveData<Event<Pair<String, IVoiceEngine.VoiceEngineOption>>> agreeConnectLiveData;

    @NotNull
    private final LiveData<Event<ImageModel>> anchorLevel;

    @NotNull
    private final LiveData<Event<ConsultApplyConnectGrpcModel>> applyConnectPromptLiveData;

    @NotNull
    private final LiveData<Event<Boolean>> cancelRequestLiveData;

    @NotNull
    private final LiveData<Event<Boolean>> cannotWatchLive;

    @NotNull
    private final LiveData<Event<Integer>> connectCountChangeLiveData;

    @NotNull
    private final LiveData<Event<Pair<Boolean, ConsultConnectSuccessGrpcModel>>> connectSuccessLiveData;

    @NotNull
    private final LiveData<Event<Pair<Boolean, ConsultLiveModel>>> enterRoomLog;

    @NotNull
    private final LiveData<Event<HangUpConnectModel>> hangUpConnectLiveData;

    @NotNull
    private final LiveData<Event<ConsultLiveModel>> liveEnd;

    @NotNull
    private final LiveData<Event<ConsultLiveModel>> liveInfoData;

    @Nullable
    private Long mConnectStartTime;

    @Nullable
    private ConsultLiveModel mConsultLiveModel;

    @Nullable
    private String mRoomId;

    @NotNull
    private final LiveData<Event<ConsultOnlineInfoModel>> onlineInfoData;

    @NotNull
    private final LiveData<Event<Triple<Boolean, ConsultLiveModel, HangUpConnectModel>>> refreshRoomInfoLiveData;

    @NotNull
    private final LiveData<Event<Boolean>> requestConnectChangeLiveData;

    @NotNull
    private final LiveData<Event<RequestConnectResult>> requestConnectLiveData;

    @NotNull
    private final LiveData<Event<Pair<String, ConsultConnectState>>> showConnectOrderLiveData;

    @NotNull
    private final LiveData<Event<ShowDiamondBalanceModel>> showRechargeLiveData;

    @NotNull
    private final LiveData<Event<String>> showRequestConnectLiveData;

    @NotNull
    private final LiveData<Event<IVoiceEngine.VoiceEngineOption>> voiceEngineOption;

    /* compiled from: ConsultViewerViewModel.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final Long a() {
            return ConsultViewerViewModel.mEnterRoomTime;
        }

        @Nullable
        public final String b() {
            return ConsultViewerViewModel.mRequestId;
        }

        @Nullable
        public final String c() {
            return ConsultViewerViewModel.mVoiceConnectType;
        }

        public final void d() {
            f(null);
            g(null);
            ConsultViewerViewModel.mNewRoomId = null;
        }

        public final void e(@Nullable Long l10) {
            ConsultViewerViewModel.mEnterRoomTime = l10;
        }

        public final void f(@Nullable String str) {
            ConsultViewerViewModel.mRequestId = str;
        }

        public final void g(@Nullable String str) {
            ConsultViewerViewModel.mVoiceConnectType = str;
        }
    }

    /* compiled from: ConsultViewerViewModel.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public /* synthetic */ class a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f13897a;

        static {
            int[] iArr = new int[CuConnectorOuterClass.MessageType.values().length];
            try {
                iArr[CuConnectorOuterClass.MessageType.NewVoiceRoomEnded.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CuConnectorOuterClass.MessageType.NewVoiceRoomComment.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CuConnectorOuterClass.MessageType.VoiceConnectApplyChange.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[CuConnectorOuterClass.MessageType.VoiceConnectAnchorAgree.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[CuConnectorOuterClass.MessageType.VoiceConnectSuccess.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[CuConnectorOuterClass.MessageType.VoiceConnectHangUp.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[CuConnectorOuterClass.MessageType.VoiceConnectWait.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[CuConnectorOuterClass.MessageType.VoiceRoomOnlineInfo.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[CuConnectorOuterClass.MessageType.VoiceRoomAnchorInfoChange.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            f13897a = iArr;
        }
    }

    public ConsultViewerViewModel() {
        GrpcMessageRouter.INSTANCE.addIGrpcMessageListener(this);
        MutableLiveData<Event<Pair<Boolean, ConsultLiveModel>>> mutableLiveData = new MutableLiveData<>();
        this._enterRoomLog = mutableLiveData;
        this.enterRoomLog = mutableLiveData;
        MutableLiveData<Event<ConsultLiveModel>> mutableLiveData2 = new MutableLiveData<>();
        this._liveInfoData = mutableLiveData2;
        this.liveInfoData = mutableLiveData2;
        MutableLiveData<Event<IVoiceEngine.VoiceEngineOption>> mutableLiveData3 = new MutableLiveData<>();
        this._voiceEngineOption = mutableLiveData3;
        this.voiceEngineOption = mutableLiveData3;
        MutableLiveData<Event<String>> mutableLiveData4 = new MutableLiveData<>();
        this._showRequestConnectLiveData = mutableLiveData4;
        this.showRequestConnectLiveData = mutableLiveData4;
        MutableLiveData<Event<RequestConnectResult>> mutableLiveData5 = new MutableLiveData<>();
        this._requestConnectLiveData = mutableLiveData5;
        this.requestConnectLiveData = mutableLiveData5;
        MutableLiveData<Event<Boolean>> mutableLiveData6 = new MutableLiveData<>();
        this._cancelRequestLiveData = mutableLiveData6;
        this.cancelRequestLiveData = mutableLiveData6;
        MutableLiveData<Event<Boolean>> mutableLiveData7 = new MutableLiveData<>();
        this._requestConnectChangeLiveData = mutableLiveData7;
        this.requestConnectChangeLiveData = mutableLiveData7;
        MutableLiveData<Event<ConsultApplyConnectGrpcModel>> mutableLiveData8 = new MutableLiveData<>();
        this._applyConnectPromptLiveData = mutableLiveData8;
        this.applyConnectPromptLiveData = mutableLiveData8;
        MutableLiveData<Event<Pair<String, IVoiceEngine.VoiceEngineOption>>> mutableLiveData9 = new MutableLiveData<>();
        this._agreeConnectLiveData = mutableLiveData9;
        this.agreeConnectLiveData = mutableLiveData9;
        MutableLiveData<Event<Pair<Boolean, ConsultConnectSuccessGrpcModel>>> mutableLiveData10 = new MutableLiveData<>();
        this._connectSuccessLiveData = mutableLiveData10;
        this.connectSuccessLiveData = mutableLiveData10;
        MutableLiveData<Event<HangUpConnectModel>> mutableLiveData11 = new MutableLiveData<>();
        this._hangUpConnectLiveData = mutableLiveData11;
        this.hangUpConnectLiveData = mutableLiveData11;
        MutableLiveData<Event<Integer>> mutableLiveData12 = new MutableLiveData<>();
        this._connectCountChangeLiveData = mutableLiveData12;
        this.connectCountChangeLiveData = mutableLiveData12;
        MutableLiveData<Event<ConsultLiveModel>> mutableLiveData13 = new MutableLiveData<>();
        this._liveEnd = mutableLiveData13;
        this.liveEnd = mutableLiveData13;
        MutableLiveData<Event<Boolean>> mutableLiveData14 = new MutableLiveData<>();
        this._cannotWatchLive = mutableLiveData14;
        this.cannotWatchLive = mutableLiveData14;
        MutableLiveData<Event<Pair<Boolean, List<ConsultCommentModel>>>> mutableLiveData15 = new MutableLiveData<>();
        this._addCommentData = mutableLiveData15;
        this.addCommentData = mutableLiveData15;
        MutableLiveData<Event<ConsultOnlineInfoModel>> mutableLiveData16 = new MutableLiveData<>();
        this._onlineInfoData = mutableLiveData16;
        this.onlineInfoData = mutableLiveData16;
        MutableLiveData<Event<ImageModel>> mutableLiveData17 = new MutableLiveData<>();
        this._anchorLevel = mutableLiveData17;
        this.anchorLevel = mutableLiveData17;
        MutableLiveData<Event<Pair<String, ConsultConnectState>>> mutableLiveData18 = new MutableLiveData<>();
        this._showConnectOrderLiveData = mutableLiveData18;
        this.showConnectOrderLiveData = mutableLiveData18;
        MutableLiveData<Event<ShowDiamondBalanceModel>> mutableLiveData19 = new MutableLiveData<>();
        this._showRechargeLiveData = mutableLiveData19;
        this.showRechargeLiveData = mutableLiveData19;
        MutableLiveData<Event<Triple<Boolean, ConsultLiveModel, HangUpConnectModel>>> mutableLiveData20 = new MutableLiveData<>();
        this._refreshRoomInfoLiveData = mutableLiveData20;
        this.refreshRoomInfoLiveData = mutableLiveData20;
    }

    public final void hangUpConnect(boolean z10, boolean z11, String str, String str2) {
        ConsultLiveModel consultLiveModel;
        String str3 = this.mRoomId;
        if (str3 == null || (consultLiveModel = this.mConsultLiveModel) == null) {
            return;
        }
        this._hangUpConnectLiveData.setValue(new Event<>(new HangUpConnectModel(z10, z11, str, str2, getVoiceEngineOption(str3, consultLiveModel.getPrivateMapKey(), false))));
        reportConnectEnd(str2, str);
    }

    public final void reportCharge(String str) {
        User user;
        z3.a aVar = z3.a.f54827a;
        String str2 = this.mRoomId;
        ConsultLiveModel consultLiveModel = this.mConsultLiveModel;
        aVar.e(str2, (consultLiveModel == null || (user = consultLiveModel.getUser()) == null) ? null : user.userId(), mRequestId, str);
    }

    public static /* synthetic */ void reportCharge$default(ConsultViewerViewModel consultViewerViewModel, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = null;
        }
        consultViewerViewModel.reportCharge(str);
    }

    private final void reportConnectEnd(String str, String str2) {
        Long l10;
        ConsultLiveModel consultLiveModel = this.mConsultLiveModel;
        if (consultLiveModel != null) {
            if (this.mConnectStartTime != null) {
                long currentTimeMillis = System.currentTimeMillis();
                Long l11 = this.mConnectStartTime;
                s.f(l11);
                l10 = Long.valueOf((currentTimeMillis - l11.longValue()) / 1000);
            } else {
                l10 = null;
            }
            z3.a aVar = z3.a.f54827a;
            String id2 = consultLiveModel.getId();
            String userId = consultLiveModel.getUser().userId();
            ConsultConnectType a10 = ConsultConnectType.Companion.a(str);
            String typeName = a10 != null ? a10.getTypeName() : null;
            String category = consultLiveModel.getCategory();
            Integer anchorLevel = consultLiveModel.getAnchorLevel();
            aVar.b(id2, userId, typeName, category, anchorLevel != null ? anchorLevel.toString() : null, l10 != null ? Integer.valueOf((int) l10.longValue()) : null, str2);
            this.mConnectStartTime = null;
        }
    }

    private final void reportConnectSuccess(String str) {
        ConsultLiveModel consultLiveModel = this.mConsultLiveModel;
        if (consultLiveModel != null) {
            z3.a aVar = z3.a.f54827a;
            String id2 = consultLiveModel.getId();
            String userId = consultLiveModel.getUser().userId();
            ConsultConnectType a10 = ConsultConnectType.Companion.a(str);
            String typeName = a10 != null ? a10.getTypeName() : null;
            String category = consultLiveModel.getCategory();
            Integer anchorLevel = consultLiveModel.getAnchorLevel();
            aVar.d(id2, userId, typeName, category, anchorLevel != null ? anchorLevel.toString() : null);
        }
    }

    private final void reportExitRoom() {
        Long l10;
        ConsultLiveModel consultLiveModel = this.mConsultLiveModel;
        if (consultLiveModel != null) {
            if (mEnterRoomTime != null) {
                long currentTimeMillis = System.currentTimeMillis();
                Long l11 = mEnterRoomTime;
                s.f(l11);
                l10 = Long.valueOf((currentTimeMillis - l11.longValue()) / 1000);
            } else {
                l10 = null;
            }
            z3.a.f54827a.h(consultLiveModel.getId(), consultLiveModel.getUser().userId(), l10 != null ? Integer.valueOf((int) l10.longValue()) : null, Boolean.valueOf(consultLiveModel.getUser().getAloha()));
            mEnterRoomTime = null;
        }
    }

    public final void reportHeartBeat() {
        String str;
        Integer heartbeatSeconds;
        String str2 = this.mRoomId;
        if (str2 == null || (str = mRequestId) == null) {
            return;
        }
        ConsultLiveHelper consultLiveHelper = ConsultLiveHelper.f13820a;
        ConsultLiveModel consultLiveModel = this.mConsultLiveModel;
        consultLiveHelper.j((consultLiveModel == null || (heartbeatSeconds = consultLiveModel.getHeartbeatSeconds()) == null) ? 5 : heartbeatSeconds.intValue(), str2, str, new Function1<ConsultConnectUserResult, p>() { // from class: com.cupidapp.live.consult.viewmodel.ConsultViewerViewModel$reportHeartBeat$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(ConsultConnectUserResult consultConnectUserResult) {
                invoke2(consultConnectUserResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull ConsultConnectUserResult result) {
                User user;
                s.i(result, "result");
                if (ViewerConsultConnectLayout.f13884d.a() == ConsultConnectState.Connecting) {
                    ConsultConnectUserModel connectingUserInfo = result.getConnectingUserInfo();
                    boolean z10 = false;
                    if (connectingUserInfo != null && (user = connectingUserInfo.getUser()) != null && user.isMyself()) {
                        z10 = true;
                    }
                    if (z10) {
                        return;
                    }
                    ConsultViewerViewModel.this.hangUpConnect(true, true, null, ConsultViewerViewModel.Companion.c());
                }
            }
        });
    }

    public final void reportRequestConnect(String str, boolean z10) {
        ConsultLiveModel consultLiveModel = this.mConsultLiveModel;
        if (consultLiveModel != null) {
            z3.a aVar = z3.a.f54827a;
            String id2 = consultLiveModel.getId();
            String userId = consultLiveModel.getUser().userId();
            ConsultConnectType a10 = ConsultConnectType.Companion.a(str);
            String typeName = a10 != null ? a10.getTypeName() : null;
            String category = consultLiveModel.getCategory();
            Integer anchorLevel = consultLiveModel.getAnchorLevel();
            aVar.c(id2, userId, typeName, category, anchorLevel != null ? anchorLevel.toString() : null, z10);
        }
    }

    public static /* synthetic */ void showRecharge$default(ConsultViewerViewModel consultViewerViewModel, String str, String str2, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = null;
        }
        if ((i10 & 2) != 0) {
            str2 = null;
        }
        consultViewerViewModel.showRecharge(str, str2, z10);
    }

    public final void applyConnect(@NotNull String connectType, @Nullable String str, @NotNull String privateMapKey) {
        s.i(connectType, "connectType");
        s.i(privateMapKey, "privateMapKey");
        if (s.d(connectType, ConsultConnectType.NORMAL.getValue())) {
            this._agreeConnectLiveData.setValue(new Event<>(new Pair(connectType, getVoiceEngineOption(this.mRoomId, privateMapKey, true))));
        } else if (s.d(connectType, ConsultConnectType.ONE_ON_ONE.getValue())) {
            mNewRoomId = str;
            this._agreeConnectLiveData.setValue(new Event<>(new Pair(connectType, getVoiceEngineOption(str, privateMapKey, true))));
        }
    }

    public final void callVoiceRoomLeaveApi() {
        String str = this.mRoomId;
        if (str == null) {
            return;
        }
        Disposable disposed = NetworkClient.f11868a.v().g(str).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<Object, p>() { // from class: com.cupidapp.live.consult.viewmodel.ConsultViewerViewModel$callVoiceRoomLeaveApi$$inlined$handle$default$1
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
        reportExitRoom();
        GrpcMessageRouter.notifyGrpc$default(GrpcMessageRouter.INSTANCE, false, null, null, 6, null);
        Companion.d();
        ConsultLiveHelper.f13820a.m();
    }

    public final void callVoiceRoomViewerApi() {
        String str = this.mRoomId;
        if (str == null) {
            return;
        }
        Disposable disposed = a.C0025a.c(NetworkClient.f11868a.v(), str, false, 2, null).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<ConsultLiveModel, p>() { // from class: com.cupidapp.live.consult.viewmodel.ConsultViewerViewModel$callVoiceRoomViewerApi$$inlined$handle$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(ConsultLiveModel consultLiveModel) {
                m2546invoke(consultLiveModel);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2546invoke(ConsultLiveModel consultLiveModel) {
                MutableLiveData mutableLiveData;
                MutableLiveData mutableLiveData2;
                IVoiceEngine.VoiceEngineOption voiceEngineOption;
                MutableLiveData mutableLiveData3;
                MutableLiveData mutableLiveData4;
                MutableLiveData mutableLiveData5;
                ConsultLiveModel consultLiveModel2 = consultLiveModel;
                ConsultViewerViewModel.this.mConsultLiveModel = consultLiveModel2;
                mutableLiveData = ConsultViewerViewModel.this._enterRoomLog;
                mutableLiveData.setValue(new Event(new Pair(Boolean.FALSE, consultLiveModel2)));
                Boolean ended = consultLiveModel2.getEnded();
                Boolean bool = Boolean.TRUE;
                if (s.d(ended, bool)) {
                    mutableLiveData5 = ConsultViewerViewModel.this._liveEnd;
                    mutableLiveData5.setValue(new Event(consultLiveModel2));
                    return;
                }
                mutableLiveData2 = ConsultViewerViewModel.this._liveInfoData;
                mutableLiveData2.setValue(new Event(consultLiveModel2));
                voiceEngineOption = ConsultViewerViewModel.this.getVoiceEngineOption(consultLiveModel2.getId(), consultLiveModel2.getPrivateMapKey(), false);
                if (voiceEngineOption != null) {
                    mutableLiveData4 = ConsultViewerViewModel.this._voiceEngineOption;
                    mutableLiveData4.setValue(new Event(voiceEngineOption));
                }
                List<ConsultCommentModel> recentComments = consultLiveModel2.getRecentComments();
                if (recentComments != null) {
                    mutableLiveData3 = ConsultViewerViewModel.this._addCommentData;
                    mutableLiveData3.setValue(new Event(new Pair(bool, recentComments)));
                }
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.consult.viewmodel.ConsultViewerViewModel$callVoiceRoomViewerApi$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                MutableLiveData mutableLiveData;
                MutableLiveData mutableLiveData2;
                s.i(it, "it");
                String a10 = j.f12008a.a(it);
                boolean z10 = false;
                if (a10 != null && t.q(a10) == RequestErrorCode.CannotWatchThisLiveShow.getValue()) {
                    z10 = true;
                }
                if (z10) {
                    mutableLiveData = ConsultViewerViewModel.this._enterRoomLog;
                    Boolean bool = Boolean.TRUE;
                    mutableLiveData.setValue(new Event(new Pair(bool, null)));
                    mutableLiveData2 = ConsultViewerViewModel.this._cannotWatchLive;
                    mutableLiveData2.setValue(new Event(bool));
                }
                return Boolean.FALSE;
            }
        }, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    public final void cancelRequest() {
        String str;
        String str2 = this.mRoomId;
        if (str2 == null || (str = mRequestId) == null) {
            return;
        }
        Disposable disposed = NetworkClient.f11868a.v().p(str2, str).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<Object, p>() { // from class: com.cupidapp.live.consult.viewmodel.ConsultViewerViewModel$cancelRequest$$inlined$handle$default$1
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
                mutableLiveData = ConsultViewerViewModel.this._cancelRequestLiveData;
                mutableLiveData.setValue(new Event(Boolean.TRUE));
                ConsultViewerViewModel.Companion.d();
                ConsultLiveHelper.f13820a.m();
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(null, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    public final void changeRoomSuccess() {
        String str;
        String str2;
        if (!s.d(mVoiceConnectType, ConsultConnectType.ONE_ON_ONE.getValue()) || (str = this.mRoomId) == null || (str2 = mNewRoomId) == null) {
            return;
        }
        Disposable disposed = NetworkClient.f11868a.v().t(str, str2).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<Object, p>() { // from class: com.cupidapp.live.consult.viewmodel.ConsultViewerViewModel$changeRoomSuccess$$inlined$handle$default$1
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

    public final void connectCharge() {
        String str;
        String str2 = this.mRoomId;
        if (str2 == null || (str = mRequestId) == null) {
            return;
        }
        Disposable disposed = NetworkClient.f11868a.v().n(str2, str).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<ConsultConnectChargeResult, p>() { // from class: com.cupidapp.live.consult.viewmodel.ConsultViewerViewModel$connectCharge$$inlined$handle$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(ConsultConnectChargeResult consultConnectChargeResult) {
                m2547invoke(consultConnectChargeResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2547invoke(ConsultConnectChargeResult consultConnectChargeResult) {
                ConsultConnectChargeResult consultConnectChargeResult2 = consultConnectChargeResult;
                String tips = consultConnectChargeResult2.getTips();
                if (!(tips == null || tips.length() == 0)) {
                    ConsultViewerViewModel.this.showRecharge(String.valueOf(consultConnectChargeResult2.getBalance()), consultConnectChargeResult2.getTips(), false);
                }
                ConsultViewerViewModel.reportCharge$default(ConsultViewerViewModel.this, null, 1, null);
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.consult.viewmodel.ConsultViewerViewModel$connectCharge$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                s.i(it, "it");
                ConsultViewerViewModel.this.reportCharge(j.c(j.f12008a, it, false, 2, null));
                return Boolean.FALSE;
            }
        }, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    @NotNull
    public final LiveData<Event<Pair<Boolean, List<ConsultCommentModel>>>> getAddCommentData() {
        return this.addCommentData;
    }

    @NotNull
    public final LiveData<Event<Pair<String, IVoiceEngine.VoiceEngineOption>>> getAgreeConnectLiveData() {
        return this.agreeConnectLiveData;
    }

    @NotNull
    public final LiveData<Event<ImageModel>> getAnchorLevel() {
        return this.anchorLevel;
    }

    @NotNull
    public final LiveData<Event<ConsultApplyConnectGrpcModel>> getApplyConnectPromptLiveData() {
        return this.applyConnectPromptLiveData;
    }

    @NotNull
    public final LiveData<Event<Boolean>> getCancelRequestLiveData() {
        return this.cancelRequestLiveData;
    }

    @NotNull
    public final LiveData<Event<Boolean>> getCannotWatchLive() {
        return this.cannotWatchLive;
    }

    @NotNull
    public final LiveData<Event<Integer>> getConnectCountChangeLiveData() {
        return this.connectCountChangeLiveData;
    }

    @NotNull
    public final LiveData<Event<Pair<Boolean, ConsultConnectSuccessGrpcModel>>> getConnectSuccessLiveData() {
        return this.connectSuccessLiveData;
    }

    @Nullable
    public final ConsultLiveModel getConsultLiveModel() {
        return this.mConsultLiveModel;
    }

    @NotNull
    public final LiveData<Event<Pair<Boolean, ConsultLiveModel>>> getEnterRoomLog() {
        return this.enterRoomLog;
    }

    @NotNull
    public final LiveData<Event<HangUpConnectModel>> getHangUpConnectLiveData() {
        return this.hangUpConnectLiveData;
    }

    @NotNull
    public final LiveData<Event<ConsultLiveModel>> getLiveEnd() {
        return this.liveEnd;
    }

    @NotNull
    public final LiveData<Event<ConsultLiveModel>> getLiveInfoData() {
        return this.liveInfoData;
    }

    @NotNull
    public final LiveData<Event<ConsultOnlineInfoModel>> getOnlineInfoData() {
        return this.onlineInfoData;
    }

    @NotNull
    public final LiveData<Event<Triple<Boolean, ConsultLiveModel, HangUpConnectModel>>> getRefreshRoomInfoLiveData() {
        return this.refreshRoomInfoLiveData;
    }

    @NotNull
    public final LiveData<Event<Boolean>> getRequestConnectChangeLiveData() {
        return this.requestConnectChangeLiveData;
    }

    @NotNull
    public final LiveData<Event<RequestConnectResult>> getRequestConnectLiveData() {
        return this.requestConnectLiveData;
    }

    @NotNull
    public final LiveData<Event<Pair<String, ConsultConnectState>>> getShowConnectOrderLiveData() {
        return this.showConnectOrderLiveData;
    }

    @NotNull
    public final LiveData<Event<ShowDiamondBalanceModel>> getShowRechargeLiveData() {
        return this.showRechargeLiveData;
    }

    @NotNull
    public final LiveData<Event<String>> getShowRequestConnectLiveData() {
        return this.showRequestConnectLiveData;
    }

    @NotNull
    public final LiveData<Event<IVoiceEngine.VoiceEngineOption>> getVoiceEngineOption() {
        return this.voiceEngineOption;
    }

    public final void hangUp() {
        String str;
        String str2 = this.mRoomId;
        if (str2 == null || (str = mRequestId) == null) {
            return;
        }
        Disposable disposed = NetworkClient.f11868a.v().v(str2, str).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<ConnectFinishedModel, p>() { // from class: com.cupidapp.live.consult.viewmodel.ConsultViewerViewModel$hangUp$$inlined$handle$default$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(ConnectFinishedModel connectFinishedModel) {
                m2548invoke(connectFinishedModel);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2548invoke(ConnectFinishedModel connectFinishedModel) {
                ConsultViewerViewModel.this.hangUpConnect(true, true, null, ConsultViewerViewModel.mVoiceConnectType);
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(null, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    public final void initLiveInfoData(@NotNull ConsultViewerActivity.Config config) {
        s.i(config, "config");
        this.mRoomId = config.getRoomId();
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        GrpcMessageRouter.INSTANCE.removeIGrpcMessageListener(this);
    }

    @Override // com.cupidapp.live.base.grpc.IGrpcMessageListener
    public void onReceiveGrpcMessage(@NotNull CuConnectorOuterClass.MessageType type, @NotNull Object model) {
        ConsultCommentModel comment;
        s.i(type, "type");
        s.i(model, "model");
        if ((model instanceof BaseConsultLiveGrpcModel) && s.d(((BaseConsultLiveGrpcModel) model).getRoomId(), this.mRoomId)) {
            switch (a.f13897a[type.ordinal()]) {
                case 1:
                    if (model instanceof ConsultRoomEndGrpcModel) {
                        ConsultLiveModel consultLiveModel = this.mConsultLiveModel;
                        if (consultLiveModel != null) {
                            this._liveEnd.setValue(new Event<>(consultLiveModel));
                        }
                        Companion.d();
                        ConsultLiveHelper.f13820a.m();
                        return;
                    }
                    return;
                case 2:
                    if (!(model instanceof ConsultCommentGrpcModel) || (comment = ((ConsultCommentGrpcModel) model).getComment()) == null) {
                        return;
                    }
                    this._addCommentData.setValue(new Event<>(new Pair(Boolean.FALSE, r.e(comment))));
                    return;
                case 3:
                    if (model instanceof ConsultRequestConnectGrpcModel) {
                        ConsultRequestConnectGrpcModel consultRequestConnectGrpcModel = (ConsultRequestConnectGrpcModel) model;
                        if (s.d(mRequestId, consultRequestConnectGrpcModel.getRequestId()) && consultRequestConnectGrpcModel.getCancel()) {
                            this._requestConnectChangeLiveData.setValue(new Event<>(Boolean.TRUE));
                            Companion.d();
                            ConsultLiveHelper.f13820a.m();
                            return;
                        }
                        return;
                    }
                    return;
                case 4:
                    if ((model instanceof ConsultApplyConnectGrpcModel) && s.d(mRequestId, ((ConsultApplyConnectGrpcModel) model).getRequestId())) {
                        this._applyConnectPromptLiveData.setValue(new Event<>(model));
                        return;
                    }
                    return;
                case 5:
                    if (model instanceof ConsultConnectSuccessGrpcModel) {
                        ConsultConnectSuccessGrpcModel consultConnectSuccessGrpcModel = (ConsultConnectSuccessGrpcModel) model;
                        this._connectSuccessLiveData.setValue(new Event<>(new Pair(Boolean.valueOf(s.d(mRequestId, consultConnectSuccessGrpcModel.getRequestId())), model)));
                        this.mConnectStartTime = Long.valueOf(System.currentTimeMillis());
                        reportConnectSuccess(consultConnectSuccessGrpcModel.getVoiceConnectType());
                        return;
                    }
                    return;
                case 6:
                    if (model instanceof ConsultHangUpConnectGrpcModel) {
                        ConsultHangUpConnectGrpcModel consultHangUpConnectGrpcModel = (ConsultHangUpConnectGrpcModel) model;
                        hangUpConnect(s.d(mRequestId, consultHangUpConnectGrpcModel.getRequestId()), false, consultHangUpConnectGrpcModel.getTips(), consultHangUpConnectGrpcModel.getVoiceConnectType());
                        return;
                    }
                    return;
                case 7:
                    if (model instanceof RequestConnectCountGrpcModel) {
                        this._connectCountChangeLiveData.setValue(new Event<>(Integer.valueOf(((RequestConnectCountGrpcModel) model).getCount())));
                        return;
                    }
                    return;
                case 8:
                    if (model instanceof ConsultOnlineInfoGrpcModel) {
                        this._onlineInfoData.setValue(new Event<>(new ConsultOnlineInfoModel(((ConsultOnlineInfoGrpcModel) model).getViewerCount())));
                        return;
                    }
                    return;
                case 9:
                    if (model instanceof ConsultAnchorInfoChangeGrpcModel) {
                        ConsultLiveModel consultLiveModel2 = this.mConsultLiveModel;
                        if (consultLiveModel2 != null) {
                            consultLiveModel2.setLevelIcon(((ConsultAnchorInfoChangeGrpcModel) model).getLevelIcon());
                        }
                        ConsultLiveModel consultLiveModel3 = this.mConsultLiveModel;
                        if (consultLiveModel3 != null) {
                            consultLiveModel3.setAnchorLevel(((ConsultAnchorInfoChangeGrpcModel) model).getAnchorLevel());
                        }
                        this._anchorLevel.setValue(new Event<>(((ConsultAnchorInfoChangeGrpcModel) model).getLevelIcon()));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public final void refreshConsultRoomInfo(final boolean z10) {
        String str = this.mRoomId;
        if (str == null) {
            return;
        }
        Disposable disposed = NetworkClient.f11868a.v().c(str, true).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<ConsultLiveModel, p>() { // from class: com.cupidapp.live.consult.viewmodel.ConsultViewerViewModel$refreshConsultRoomInfo$$inlined$handle$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(ConsultLiveModel consultLiveModel) {
                m2549invoke(consultLiveModel);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2549invoke(ConsultLiveModel consultLiveModel) {
                String str2;
                ConsultLiveModel consultLiveModel2;
                IVoiceEngine.VoiceEngineOption voiceEngineOption;
                MutableLiveData mutableLiveData;
                MutableLiveData mutableLiveData2;
                MutableLiveData mutableLiveData3;
                ConsultLiveModel consultLiveModel3 = consultLiveModel;
                ConsultViewerViewModel.this.mConsultLiveModel = consultLiveModel3;
                Boolean ended = consultLiveModel3.getEnded();
                Boolean bool = Boolean.TRUE;
                if (s.d(ended, bool)) {
                    mutableLiveData3 = ConsultViewerViewModel.this._liveEnd;
                    mutableLiveData3.setValue(new Event(consultLiveModel3));
                    return;
                }
                String str3 = ConsultViewerViewModel.mVoiceConnectType;
                ConsultViewerViewModel consultViewerViewModel = ConsultViewerViewModel.this;
                str2 = consultViewerViewModel.mRoomId;
                consultLiveModel2 = ConsultViewerViewModel.this.mConsultLiveModel;
                voiceEngineOption = consultViewerViewModel.getVoiceEngineOption(str2, consultLiveModel2 != null ? consultLiveModel2.getPrivateMapKey() : null, false);
                HangUpConnectModel hangUpConnectModel = new HangUpConnectModel(true, true, null, str3, voiceEngineOption);
                mutableLiveData = ConsultViewerViewModel.this._refreshRoomInfoLiveData;
                mutableLiveData.setValue(new Event(new Triple(Boolean.valueOf(z10), consultLiveModel3, hangUpConnectModel)));
                List<ConsultCommentModel> recentComments = consultLiveModel3.getRecentComments();
                if (recentComments != null) {
                    mutableLiveData2 = ConsultViewerViewModel.this._addCommentData;
                    mutableLiveData2.setValue(new Event(new Pair(bool, recentComments)));
                }
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(null, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    public final void requestConnect(@NotNull final String connectType) {
        s.i(connectType, "connectType");
        String str = this.mRoomId;
        if (str == null) {
            return;
        }
        Disposable disposed = NetworkClient.f11868a.v().h(str, connectType).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<RequestConnectResult, p>() { // from class: com.cupidapp.live.consult.viewmodel.ConsultViewerViewModel$requestConnect$$inlined$handle$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(RequestConnectResult requestConnectResult) {
                m2550invoke(requestConnectResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2550invoke(RequestConnectResult requestConnectResult) {
                MutableLiveData mutableLiveData;
                RequestConnectResult requestConnectResult2 = requestConnectResult;
                ConsultViewerViewModel.Companion companion = ConsultViewerViewModel.Companion;
                ConsultViewerViewModel.mRequestId = requestConnectResult2.getRequestId();
                ConsultViewerViewModel.mVoiceConnectType = String.this;
                mutableLiveData = this._requestConnectLiveData;
                mutableLiveData.setValue(new Event(requestConnectResult2));
                this.reportHeartBeat();
                this.reportRequestConnect(String.this, s.d(requestConnectResult2.getSuspend(), Boolean.TRUE));
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.consult.viewmodel.ConsultViewerViewModel$requestConnect$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                s.i(it, "it");
                j jVar = j.f12008a;
                String a10 = jVar.a(it);
                Integer valueOf = a10 != null ? Integer.valueOf(t.q(a10)) : null;
                boolean z10 = false;
                String b4 = jVar.b(it, false);
                int value = RequestErrorCode.InsufficientBalance.getValue();
                if (valueOf != null && valueOf.intValue() == value) {
                    ConsultViewerViewModel.showRecharge$default(ConsultViewerViewModel.this, null, b4, true, 1, null);
                    z10 = true;
                }
                return Boolean.valueOf(z10);
            }
        }, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    public final void showConnectOrder(@NotNull ConsultConnectState connectState) {
        s.i(connectState, "connectState");
        String str = this.mRoomId;
        if (str == null) {
            return;
        }
        this._showConnectOrderLiveData.setValue(new Event<>(new Pair(str, connectState)));
    }

    public final void showRecharge(@Nullable String str, @Nullable String str2, boolean z10) {
        String str3 = this.mRoomId;
        if (str3 == null) {
            return;
        }
        this._showRechargeLiveData.setValue(new Event<>(new ShowDiamondBalanceModel(str, str3, str2, z10)));
    }

    public final void showRequestConnect() {
        String str = this.mRoomId;
        if (str == null) {
            return;
        }
        this._showRequestConnectLiveData.setValue(new Event<>(str));
    }

    public final void switchRoleSuccess() {
        String str;
        String str2 = this.mRoomId;
        if (str2 == null || (str = mRequestId) == null) {
            return;
        }
        Disposable disposed = a.C0025a.a(NetworkClient.f11868a.v(), str2, str, false, 4, null).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<Object, p>() { // from class: com.cupidapp.live.consult.viewmodel.ConsultViewerViewModel$switchRoleSuccess$$inlined$handle$default$1
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

    public final IVoiceEngine.VoiceEngineOption getVoiceEngineOption(String str, String str2, boolean z10) {
        ConsultLiveModel consultLiveModel;
        if (str == null || str2 == null || (consultLiveModel = this.mConsultLiveModel) == null) {
            return null;
        }
        return new IVoiceEngine.VoiceEngineOption(str, consultLiveModel.getAId(), consultLiveModel.getUserSig(), str2, z10);
    }
}

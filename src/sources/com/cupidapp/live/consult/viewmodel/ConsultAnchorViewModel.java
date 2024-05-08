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
import com.cupidapp.live.base.network.e;
import com.cupidapp.live.base.network.i;
import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.base.network.model.ListResult;
import com.cupidapp.live.base.utils.j;
import com.cupidapp.live.consult.helper.ConsultLiveHelper;
import com.cupidapp.live.consult.model.BaseConsultLiveGrpcModel;
import com.cupidapp.live.consult.model.ConnectFinishedModel;
import com.cupidapp.live.consult.model.ConnectOrderModel;
import com.cupidapp.live.consult.model.ConsultAnchorCloseLiveResult;
import com.cupidapp.live.consult.model.ConsultAnchorInfoChangeGrpcModel;
import com.cupidapp.live.consult.model.ConsultAnchorTaskModel;
import com.cupidapp.live.consult.model.ConsultCommentGrpcModel;
import com.cupidapp.live.consult.model.ConsultCommentModel;
import com.cupidapp.live.consult.model.ConsultConnectSuccessGrpcModel;
import com.cupidapp.live.consult.model.ConsultConnectType;
import com.cupidapp.live.consult.model.ConsultHangUpConnectGrpcModel;
import com.cupidapp.live.consult.model.ConsultLiveModel;
import com.cupidapp.live.consult.model.ConsultOnlineInfoGrpcModel;
import com.cupidapp.live.consult.model.ConsultOnlineInfoModel;
import com.cupidapp.live.consult.model.ConsultRequestConnectGrpcModel;
import com.cupidapp.live.consult.model.ConsultRoomEndGrpcModel;
import com.cupidapp.live.consult.model.EnterNewRoomSuccessGrpcModel;
import com.cupidapp.live.consult.model.RequestConnectCountGrpcModel;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.voiceparty.engine.IVoiceEngine;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.List;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.r;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ConsultAnchorViewModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ConsultAnchorViewModel extends ViewModel implements IGrpcMessageListener {

    @NotNull
    private final MutableLiveData<Event<List<ConsultCommentModel>>> _addCommentData;

    @NotNull
    private final MutableLiveData<Event<ImageModel>> _anchorLevel;

    @NotNull
    private final MutableLiveData<Event<ConsultAnchorTaskModel>> _anchorTask;

    @NotNull
    private final MutableLiveData<Event<Boolean>> _applyConnectLiveData;

    @NotNull
    private final MutableLiveData<Event<Integer>> _connectCountChangeLiveData;

    @NotNull
    private final MutableLiveData<Event<ConsultConnectSuccessGrpcModel>> _connectSuccessLiveData;

    @NotNull
    private final MutableLiveData<Event<Triple<String, String, IVoiceEngine.VoiceEngineOption>>> _hangUpConnectLiveData;

    @NotNull
    private final MutableLiveData<Event<ConsultAnchorCloseLiveResult>> _liveEnd;

    @NotNull
    private final MutableLiveData<Event<ConsultOnlineInfoModel>> _onlineInfoData;

    @NotNull
    private final MutableLiveData<Event<String>> _showConnectOrderLiveData;

    @NotNull
    private final MutableLiveData<Event<Pair<String, User>>> _switchConnectLiveData;

    @NotNull
    private final MutableLiveData<Event<IVoiceEngine.VoiceEngineOption>> _switchRoomLiveData;

    @NotNull
    private final LiveData<Event<List<ConsultCommentModel>>> addCommentData;

    @NotNull
    private final LiveData<Event<ImageModel>> anchorLevel;

    @NotNull
    private final LiveData<Event<ConsultAnchorTaskModel>> anchorTask;

    @NotNull
    private final LiveData<Event<Boolean>> applyConnectLiveData;

    @NotNull
    private final LiveData<Event<Integer>> connectCountChangeLiveData;

    @NotNull
    private final LiveData<Event<ConsultConnectSuccessGrpcModel>> connectSuccessLiveData;

    @NotNull
    private final LiveData<Event<Triple<String, String, IVoiceEngine.VoiceEngineOption>>> hangUpConnectLiveData;

    @NotNull
    private final LiveData<Event<ConsultAnchorCloseLiveResult>> liveEnd;
    private boolean mIsOver;

    @Nullable
    private ConsultLiveModel mLiveModel;

    @Nullable
    private String mNewRoomId;

    @Nullable
    private String mRequestId;

    @Nullable
    private String mRoomId;

    @Nullable
    private String mVoiceConnectType;

    @NotNull
    private final LiveData<Event<ConsultOnlineInfoModel>> onlineInfoData;

    @NotNull
    private final LiveData<Event<String>> showConnectOrderLiveData;

    @NotNull
    private final LiveData<Event<Pair<String, User>>> switchConnectLiveData;

    @NotNull
    private final LiveData<Event<IVoiceEngine.VoiceEngineOption>> switchRoomLiveData;

    /* compiled from: ConsultAnchorViewModel.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f13896a;

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
                iArr[CuConnectorOuterClass.MessageType.VoiceConnectUserJoinedRoom.ordinal()] = 4;
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
            f13896a = iArr;
        }
    }

    public ConsultAnchorViewModel() {
        GrpcMessageRouter.INSTANCE.addIGrpcMessageListener(this);
        MutableLiveData<Event<ConsultAnchorTaskModel>> mutableLiveData = new MutableLiveData<>();
        this._anchorTask = mutableLiveData;
        this.anchorTask = mutableLiveData;
        MutableLiveData<Event<ConsultAnchorCloseLiveResult>> mutableLiveData2 = new MutableLiveData<>();
        this._liveEnd = mutableLiveData2;
        this.liveEnd = mutableLiveData2;
        MutableLiveData<Event<Integer>> mutableLiveData3 = new MutableLiveData<>();
        this._connectCountChangeLiveData = mutableLiveData3;
        this.connectCountChangeLiveData = mutableLiveData3;
        MutableLiveData<Event<Pair<String, User>>> mutableLiveData4 = new MutableLiveData<>();
        this._switchConnectLiveData = mutableLiveData4;
        this.switchConnectLiveData = mutableLiveData4;
        MutableLiveData<Event<Boolean>> mutableLiveData5 = new MutableLiveData<>();
        this._applyConnectLiveData = mutableLiveData5;
        this.applyConnectLiveData = mutableLiveData5;
        MutableLiveData<Event<IVoiceEngine.VoiceEngineOption>> mutableLiveData6 = new MutableLiveData<>();
        this._switchRoomLiveData = mutableLiveData6;
        this.switchRoomLiveData = mutableLiveData6;
        MutableLiveData<Event<ConsultConnectSuccessGrpcModel>> mutableLiveData7 = new MutableLiveData<>();
        this._connectSuccessLiveData = mutableLiveData7;
        this.connectSuccessLiveData = mutableLiveData7;
        MutableLiveData<Event<Triple<String, String, IVoiceEngine.VoiceEngineOption>>> mutableLiveData8 = new MutableLiveData<>();
        this._hangUpConnectLiveData = mutableLiveData8;
        this.hangUpConnectLiveData = mutableLiveData8;
        MutableLiveData<Event<List<ConsultCommentModel>>> mutableLiveData9 = new MutableLiveData<>();
        this._addCommentData = mutableLiveData9;
        this.addCommentData = mutableLiveData9;
        MutableLiveData<Event<ConsultOnlineInfoModel>> mutableLiveData10 = new MutableLiveData<>();
        this._onlineInfoData = mutableLiveData10;
        this.onlineInfoData = mutableLiveData10;
        MutableLiveData<Event<ImageModel>> mutableLiveData11 = new MutableLiveData<>();
        this._anchorLevel = mutableLiveData11;
        this.anchorLevel = mutableLiveData11;
        MutableLiveData<Event<String>> mutableLiveData12 = new MutableLiveData<>();
        this._showConnectOrderLiveData = mutableLiveData12;
        this.showConnectOrderLiveData = mutableLiveData12;
    }

    private final void callEnterRoomSuccessApi(boolean z10) {
        String str = this.mRoomId;
        if (str == null) {
            return;
        }
        Disposable disposed = a.C0025a.a(NetworkClient.f11868a.v(), str, null, z10, 2, null).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<Object, p>() { // from class: com.cupidapp.live.consult.viewmodel.ConsultAnchorViewModel$callEnterRoomSuccessApi$$inlined$handle$default$1
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

    private final void changeRoomSuccess() {
        String str;
        String str2 = this.mRoomId;
        if (str2 == null || (str = this.mNewRoomId) == null) {
            return;
        }
        Disposable disposed = NetworkClient.f11868a.v().t(str2, str).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<Object, p>() { // from class: com.cupidapp.live.consult.viewmodel.ConsultAnchorViewModel$changeRoomSuccess$$inlined$handle$default$1
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

    private final IVoiceEngine.VoiceEngineOption getVoiceEngineOption(String str, String str2) {
        ConsultLiveModel consultLiveModel = this.mLiveModel;
        if (consultLiveModel == null) {
            return null;
        }
        s.f(consultLiveModel);
        int aId = consultLiveModel.getAId();
        ConsultLiveModel consultLiveModel2 = this.mLiveModel;
        s.f(consultLiveModel2);
        return new IVoiceEngine.VoiceEngineOption(str, aId, consultLiveModel2.getUserSig(), str2, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hangUpConnect(String str, String str2) {
        ConsultLiveModel consultLiveModel;
        String privateMapKey;
        this.mNewRoomId = null;
        String str3 = this.mRoomId;
        if (str3 == null || (consultLiveModel = this.mLiveModel) == null || (privateMapKey = consultLiveModel.getPrivateMapKey()) == null) {
            return;
        }
        this._hangUpConnectLiveData.setValue(new Event<>(new Triple(str, str2, getVoiceEngineOption(str3, privateMapKey))));
        ConsultLiveHelper.f13820a.m();
    }

    public final void agreeConnect() {
        String str;
        String str2 = this.mRoomId;
        if (str2 == null || (str = this.mRequestId) == null) {
            return;
        }
        Disposable disposed = NetworkClient.f11868a.v().d(str2, str).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<Object, p>() { // from class: com.cupidapp.live.consult.viewmodel.ConsultAnchorViewModel$agreeConnect$$inlined$handle$default$1
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
                mutableLiveData = ConsultAnchorViewModel.this._applyConnectLiveData;
                mutableLiveData.setValue(new Event(Boolean.TRUE));
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(null, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    public final void callVoiceRoomCloseApi() {
        String str = this.mRoomId;
        if (str == null || this.mIsOver) {
            return;
        }
        this.mIsOver = true;
        Disposable disposed = NetworkClient.f11868a.v().l(str).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<ConsultAnchorCloseLiveResult, p>() { // from class: com.cupidapp.live.consult.viewmodel.ConsultAnchorViewModel$callVoiceRoomCloseApi$$inlined$handle$default$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(ConsultAnchorCloseLiveResult consultAnchorCloseLiveResult) {
                m2543invoke(consultAnchorCloseLiveResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2543invoke(ConsultAnchorCloseLiveResult consultAnchorCloseLiveResult) {
                MutableLiveData mutableLiveData;
                mutableLiveData = ConsultAnchorViewModel.this._liveEnd;
                mutableLiveData.setValue(new Event(consultAnchorCloseLiveResult));
                ConsultLiveHelper.f13820a.m();
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(null, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    public final void enterRoomSuccess(boolean z10) {
        String str = this.mVoiceConnectType;
        if (s.d(str, ConsultConnectType.ONE_ON_ONE.getValue())) {
            changeRoomSuccess();
        } else {
            if (s.d(str, ConsultConnectType.NORMAL.getValue())) {
                return;
            }
            callEnterRoomSuccessApi(z10);
        }
    }

    @NotNull
    public final LiveData<Event<List<ConsultCommentModel>>> getAddCommentData() {
        return this.addCommentData;
    }

    @NotNull
    public final LiveData<Event<ImageModel>> getAnchorLevel() {
        return this.anchorLevel;
    }

    @NotNull
    public final LiveData<Event<ConsultAnchorTaskModel>> getAnchorTask() {
        return this.anchorTask;
    }

    @NotNull
    public final LiveData<Event<Boolean>> getApplyConnectLiveData() {
        return this.applyConnectLiveData;
    }

    @NotNull
    public final LiveData<Event<Integer>> getConnectCountChangeLiveData() {
        return this.connectCountChangeLiveData;
    }

    @NotNull
    public final LiveData<Event<ConsultConnectSuccessGrpcModel>> getConnectSuccessLiveData() {
        return this.connectSuccessLiveData;
    }

    @Nullable
    public final ConsultLiveModel getConsultLiveModel() {
        return this.mLiveModel;
    }

    @NotNull
    public final LiveData<Event<Triple<String, String, IVoiceEngine.VoiceEngineOption>>> getHangUpConnectLiveData() {
        return this.hangUpConnectLiveData;
    }

    @NotNull
    public final LiveData<Event<ConsultAnchorCloseLiveResult>> getLiveEnd() {
        return this.liveEnd;
    }

    @NotNull
    public final LiveData<Event<ConsultOnlineInfoModel>> getOnlineInfoData() {
        return this.onlineInfoData;
    }

    @NotNull
    public final LiveData<Event<String>> getShowConnectOrderLiveData() {
        return this.showConnectOrderLiveData;
    }

    @NotNull
    public final LiveData<Event<Pair<String, User>>> getSwitchConnectLiveData() {
        return this.switchConnectLiveData;
    }

    @NotNull
    public final LiveData<Event<IVoiceEngine.VoiceEngineOption>> getSwitchRoomLiveData() {
        return this.switchRoomLiveData;
    }

    public final void hangUp() {
        String str;
        String str2 = this.mRoomId;
        if (str2 == null || (str = this.mRequestId) == null) {
            return;
        }
        Disposable disposed = NetworkClient.f11868a.v().v(str2, str).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<ConnectFinishedModel, p>() { // from class: com.cupidapp.live.consult.viewmodel.ConsultAnchorViewModel$hangUp$$inlined$handle$default$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(ConnectFinishedModel connectFinishedModel) {
                m2544invoke(connectFinishedModel);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2544invoke(ConnectFinishedModel connectFinishedModel) {
                String str3;
                ConnectFinishedModel connectFinishedModel2 = connectFinishedModel;
                str3 = ConsultAnchorViewModel.this.mVoiceConnectType;
                if (str3 != null) {
                    ConsultAnchorViewModel.this.hangUpConnect(str3, connectFinishedModel2.getTips());
                }
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(null, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    public final void initConsultLiveModel(@NotNull ConsultLiveModel model) {
        s.i(model, "model");
        j.f12332a.a("ConsultAnchorViewModel", "咨询主播端 mRoomId:" + model.getId());
        this.mLiveModel = model;
        this.mRoomId = model.getId();
        this._anchorTask.setValue(new Event<>(model.getAnchorTask()));
        List<ConsultCommentModel> recentComments = model.getRecentComments();
        if (recentComments != null) {
            this._addCommentData.setValue(new Event<>(recentComments));
        }
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        GrpcMessageRouter.INSTANCE.removeIGrpcMessageListener(this);
    }

    @Override // com.cupidapp.live.base.grpc.IGrpcMessageListener
    public void onReceiveGrpcMessage(@NotNull CuConnectorOuterClass.MessageType type, @NotNull Object model) {
        ConsultCommentModel comment;
        Integer heartbeatSeconds;
        s.i(type, "type");
        s.i(model, "model");
        if ((model instanceof BaseConsultLiveGrpcModel) && s.d(((BaseConsultLiveGrpcModel) model).getRoomId(), this.mRoomId)) {
            switch (a.f13896a[type.ordinal()]) {
                case 1:
                    if (model instanceof ConsultRoomEndGrpcModel) {
                        callVoiceRoomCloseApi();
                        return;
                    }
                    return;
                case 2:
                    if (!(model instanceof ConsultCommentGrpcModel) || (comment = ((ConsultCommentGrpcModel) model).getComment()) == null) {
                        return;
                    }
                    this._addCommentData.setValue(new Event<>(r.e(comment)));
                    return;
                case 3:
                    if (model instanceof ConsultRequestConnectGrpcModel) {
                        String str = this.mRequestId;
                        if (str == null || s.d(str, ((ConsultRequestConnectGrpcModel) model).getRequestId())) {
                            ConsultRequestConnectGrpcModel consultRequestConnectGrpcModel = (ConsultRequestConnectGrpcModel) model;
                            if (consultRequestConnectGrpcModel.getCancel()) {
                                switchConnect();
                                return;
                            }
                            this.mRequestId = consultRequestConnectGrpcModel.getRequestId();
                            this.mVoiceConnectType = consultRequestConnectGrpcModel.getVoiceConnectType();
                            this._switchConnectLiveData.setValue(new Event<>(new Pair(consultRequestConnectGrpcModel.getVoiceConnectType(), consultRequestConnectGrpcModel.getUser())));
                            return;
                        }
                        return;
                    }
                    return;
                case 4:
                    if (model instanceof EnterNewRoomSuccessGrpcModel) {
                        EnterNewRoomSuccessGrpcModel enterNewRoomSuccessGrpcModel = (EnterNewRoomSuccessGrpcModel) model;
                        if (s.d(enterNewRoomSuccessGrpcModel.getVoiceConnectType(), ConsultConnectType.ONE_ON_ONE.getValue())) {
                            this.mNewRoomId = enterNewRoomSuccessGrpcModel.getNewRoomId();
                            this._switchRoomLiveData.setValue(new Event<>(getVoiceEngineOption(enterNewRoomSuccessGrpcModel.getNewRoomId(), enterNewRoomSuccessGrpcModel.getPrivateMapKey())));
                            return;
                        }
                        return;
                    }
                    return;
                case 5:
                    if (model instanceof ConsultConnectSuccessGrpcModel) {
                        this._connectSuccessLiveData.setValue(new Event<>(model));
                        String str2 = this.mRoomId;
                        if (str2 == null || str2.length() == 0) {
                            return;
                        }
                        String str3 = this.mRequestId;
                        if (str3 == null || str3.length() == 0) {
                            return;
                        }
                        ConsultLiveHelper consultLiveHelper = ConsultLiveHelper.f13820a;
                        ConsultLiveModel consultLiveModel = this.mLiveModel;
                        int intValue = (consultLiveModel == null || (heartbeatSeconds = consultLiveModel.getHeartbeatSeconds()) == null) ? 5 : heartbeatSeconds.intValue();
                        String str4 = this.mRoomId;
                        s.f(str4);
                        String str5 = this.mRequestId;
                        s.f(str5);
                        ConsultLiveHelper.k(consultLiveHelper, intValue, str4, str5, null, 8, null);
                        return;
                    }
                    return;
                case 6:
                    if (model instanceof ConsultHangUpConnectGrpcModel) {
                        ConsultHangUpConnectGrpcModel consultHangUpConnectGrpcModel = (ConsultHangUpConnectGrpcModel) model;
                        hangUpConnect(consultHangUpConnectGrpcModel.getVoiceConnectType(), consultHangUpConnectGrpcModel.getTips());
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
                        ConsultLiveModel consultLiveModel2 = this.mLiveModel;
                        if (consultLiveModel2 != null) {
                            consultLiveModel2.setLevelIcon(((ConsultAnchorInfoChangeGrpcModel) model).getLevelIcon());
                        }
                        ConsultLiveModel consultLiveModel3 = this.mLiveModel;
                        if (consultLiveModel3 != null) {
                            consultLiveModel3.setAnchorLevel(((ConsultAnchorInfoChangeGrpcModel) model).getAnchorLevel());
                        }
                        ConsultAnchorInfoChangeGrpcModel consultAnchorInfoChangeGrpcModel = (ConsultAnchorInfoChangeGrpcModel) model;
                        this._anchorTask.setValue(new Event<>(consultAnchorInfoChangeGrpcModel.getAnchorTask()));
                        this._anchorLevel.setValue(new Event<>(consultAnchorInfoChangeGrpcModel.getLevelIcon()));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public final void refuseConnect() {
        String str;
        String str2 = this.mRoomId;
        if (str2 == null || (str = this.mRequestId) == null) {
            return;
        }
        Disposable disposed = NetworkClient.f11868a.v().p(str2, str).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<Object, p>() { // from class: com.cupidapp.live.consult.viewmodel.ConsultAnchorViewModel$refuseConnect$$inlined$handle$default$1
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
                ConsultAnchorViewModel.this.switchConnect();
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(null, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    public final void showConnectOrder() {
        String str = this.mRoomId;
        if (str == null) {
            return;
        }
        this._showConnectOrderLiveData.setValue(new Event<>(str));
    }

    public final void switchConnect() {
        String str = this.mRoomId;
        if (str == null) {
            return;
        }
        Disposable disposed = NetworkClient.f11868a.v().s(str, 1).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<ListResult<ConnectOrderModel>, p>() { // from class: com.cupidapp.live.consult.viewmodel.ConsultAnchorViewModel$switchConnect$$inlined$handle$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(ListResult<ConnectOrderModel> listResult) {
                m2545invoke(listResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2545invoke(ListResult<ConnectOrderModel> listResult) {
                MutableLiveData mutableLiveData;
                List<ConnectOrderModel> list = listResult.getList();
                ConnectOrderModel connectOrderModel = list != null ? (ConnectOrderModel) CollectionsKt___CollectionsKt.V(list) : null;
                ConsultAnchorViewModel.this.mRequestId = connectOrderModel != null ? connectOrderModel.getRequestId() : null;
                ConsultAnchorViewModel.this.mVoiceConnectType = connectOrderModel != null ? connectOrderModel.getVoiceConnectType() : null;
                mutableLiveData = ConsultAnchorViewModel.this._switchConnectLiveData;
                mutableLiveData.setValue(new Event(new Pair(connectOrderModel != null ? connectOrderModel.getVoiceConnectType() : null, connectOrderModel != null ? connectOrderModel.getUser() : null)));
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.consult.viewmodel.ConsultAnchorViewModel$switchConnect$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                MutableLiveData mutableLiveData;
                s.i(it, "it");
                ConsultAnchorViewModel.this.mRequestId = null;
                ConsultAnchorViewModel.this.mVoiceConnectType = null;
                mutableLiveData = ConsultAnchorViewModel.this._switchConnectLiveData;
                mutableLiveData.setValue(new Event(new Pair(null, null)));
                return Boolean.FALSE;
            }
        }, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }
}

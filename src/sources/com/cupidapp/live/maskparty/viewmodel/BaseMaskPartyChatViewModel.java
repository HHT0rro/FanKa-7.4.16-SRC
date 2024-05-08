package com.cupidapp.live.maskparty.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.cupidapp.live.AppApplication;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.grpc.CuConnectorOuterClass;
import com.cupidapp.live.base.grpc.GrpcMessageRouter;
import com.cupidapp.live.base.grpc.IGrpcMessageListener;
import com.cupidapp.live.base.livedata.Event;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.e;
import com.cupidapp.live.base.network.f;
import com.cupidapp.live.base.network.i;
import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.base.network.model.Result;
import com.cupidapp.live.base.network.model.SwipeCardUserLikeResult;
import com.cupidapp.live.base.network.model.ViewProfilePrefer;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.maskparty.model.MaskPartyChatConnectorMessageModel;
import com.cupidapp.live.maskparty.model.MaskPartyChatDiceModel;
import com.cupidapp.live.maskparty.model.MaskPartyChatLeaveRoom;
import com.cupidapp.live.maskparty.model.MaskPartyChatMessageModel;
import com.cupidapp.live.maskparty.model.MaskPartyChatMessageResult;
import com.cupidapp.live.maskparty.model.MaskPartyChatMessageSendState;
import com.cupidapp.live.maskparty.model.MaskPartyChatMessageType;
import com.cupidapp.live.maskparty.model.MaskPartyChatNotifyMessageModel;
import com.cupidapp.live.maskparty.model.MaskPartyChatRoomModel;
import com.cupidapp.live.maskparty.model.MaskPartyChatTypingModel;
import com.cupidapp.live.maskparty.model.MaskPartyHangUpMessageModel;
import com.cupidapp.live.maskparty.model.MaskPartyMessageModel;
import com.cupidapp.live.maskparty.model.MaskPartyType;
import com.cupidapp.live.maskparty.model.MessageActionType;
import com.cupidapp.live.maskparty.model.QuitRoomModel;
import com.cupidapp.live.maskparty.model.RemoveMessageType;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.push.FKPushModel;
import com.cupidapp.live.push.FKPushType;
import com.cupidapp.live.track.group.GroupSocialLog;
import com.huawei.quickcard.base.Attributes;
import com.irisdt.client.post.PostAndSocialProtos;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import okhttp3.MultipartBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import x2.a;
import z0.v;
import z2.a;

/* compiled from: BaseMaskPartyChatViewModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class BaseMaskPartyChatViewModel extends ViewModel implements IGrpcMessageListener {

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final int SNAP_MESSAGE_COUNT_DOWN_SECOND = 10;

    @NotNull
    private final MutableLiveData<Event<MaskPartyChatMessageModel>> _cancelMessageEventLiveData;

    @NotNull
    private final MutableLiveData<MaskPartyChatRoomModel> _chatRoomModelLiveData;

    @NotNull
    private final MutableLiveData<Event<Pair<String, Boolean>>> _deleteMessageEventLiveData;

    @NotNull
    private final MutableLiveData<Event<MaskPartyHangUpMessageModel>> _hangUpPromptEventLiveData;

    @NotNull
    private final MutableLiveData<Event<Boolean>> _leaveRoomEventLiveData;

    @NotNull
    private final MutableLiveData<MaskPartyChatMessageModel> _newMessageLiveData;

    @NotNull
    private final MutableLiveData<Event<MaskPartyChatDiceModel>> _playDiceEventLiveData;

    @NotNull
    private final MutableLiveData<Boolean> _quitRoomLiveData;

    @NotNull
    private final MutableLiveData<Pair<Long, MaskPartyChatMessageModel>> _replaceMessage;

    @NotNull
    private final MutableLiveData<Event<Boolean>> _showSendImageGuideEventLiveData;

    @NotNull
    private final MutableLiveData<Event<String>> _typingEventLiveData;

    @NotNull
    private final LiveData<Event<MaskPartyChatMessageModel>> cancelMessageEventLiveData;

    @NotNull
    private final LiveData<MaskPartyChatRoomModel> chatRoomModelLiveData;
    private long currentTime;

    @NotNull
    private final LiveData<Event<Pair<String, Boolean>>> deleteMessageEventLiveData;

    @NotNull
    private final LiveData<Event<MaskPartyHangUpMessageModel>> hangUpPromptEventLiveData;

    @NotNull
    private final LiveData<Event<Boolean>> leaveRoomEventLiveData;
    private long matchSuccessTime;

    @NotNull
    private final LiveData<MaskPartyChatMessageModel> newMessageLiveData;
    private boolean othersPublicProfile;

    @NotNull
    private final LiveData<Event<MaskPartyChatDiceModel>> playDiceEventLiveData;
    private boolean publicMyProfile;

    @NotNull
    private final LiveData<Boolean> quitRoomLiveData;

    @NotNull
    private final LiveData<Pair<Long, MaskPartyChatMessageModel>> replaceMessage;

    @NotNull
    private final LiveData<Event<Boolean>> showSendImageGuideEventLiveData;

    @NotNull
    private final LiveData<Event<String>> typingEventLiveData;

    /* compiled from: BaseMaskPartyChatViewModel.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: BaseMaskPartyChatViewModel.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public /* synthetic */ class a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f16477a;

        static {
            int[] iArr = new int[CuConnectorOuterClass.MessageType.values().length];
            try {
                iArr[CuConnectorOuterClass.MessageType.MaskMatchNewMessage.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CuConnectorOuterClass.MessageType.MaskMatchMessageRemove.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CuConnectorOuterClass.MessageType.MaskMatchNewSysTip.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[CuConnectorOuterClass.MessageType.MaskMatchPlayDice.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[CuConnectorOuterClass.MessageType.MaskMatchTyping.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[CuConnectorOuterClass.MessageType.MaskMatchLeaveRoom.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[CuConnectorOuterClass.MessageType.ShowUserCanSendImageGuide.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[CuConnectorOuterClass.MessageType.PushMessage.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[CuConnectorOuterClass.MessageType.MaskMatchOnHookPopup.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            f16477a = iArr;
        }
    }

    public BaseMaskPartyChatViewModel() {
        GrpcMessageRouter.INSTANCE.addIGrpcMessageListener(this);
        MutableLiveData<MaskPartyChatRoomModel> mutableLiveData = new MutableLiveData<>();
        this._chatRoomModelLiveData = mutableLiveData;
        this.chatRoomModelLiveData = mutableLiveData;
        MutableLiveData<MaskPartyChatMessageModel> mutableLiveData2 = new MutableLiveData<>();
        this._newMessageLiveData = mutableLiveData2;
        this.newMessageLiveData = mutableLiveData2;
        MutableLiveData<Pair<Long, MaskPartyChatMessageModel>> mutableLiveData3 = new MutableLiveData<>();
        this._replaceMessage = mutableLiveData3;
        this.replaceMessage = mutableLiveData3;
        MutableLiveData<Event<MaskPartyChatMessageModel>> mutableLiveData4 = new MutableLiveData<>();
        this._cancelMessageEventLiveData = mutableLiveData4;
        this.cancelMessageEventLiveData = mutableLiveData4;
        MutableLiveData<Event<Pair<String, Boolean>>> mutableLiveData5 = new MutableLiveData<>();
        this._deleteMessageEventLiveData = mutableLiveData5;
        this.deleteMessageEventLiveData = mutableLiveData5;
        MutableLiveData<Event<String>> mutableLiveData6 = new MutableLiveData<>();
        this._typingEventLiveData = mutableLiveData6;
        this.typingEventLiveData = mutableLiveData6;
        MutableLiveData<Event<MaskPartyChatDiceModel>> mutableLiveData7 = new MutableLiveData<>();
        this._playDiceEventLiveData = mutableLiveData7;
        this.playDiceEventLiveData = mutableLiveData7;
        MutableLiveData<Event<Boolean>> mutableLiveData8 = new MutableLiveData<>();
        this._leaveRoomEventLiveData = mutableLiveData8;
        this.leaveRoomEventLiveData = mutableLiveData8;
        MutableLiveData<Event<Boolean>> mutableLiveData9 = new MutableLiveData<>();
        this._showSendImageGuideEventLiveData = mutableLiveData9;
        this.showSendImageGuideEventLiveData = mutableLiveData9;
        MutableLiveData<Event<MaskPartyHangUpMessageModel>> mutableLiveData10 = new MutableLiveData<>();
        this._hangUpPromptEventLiveData = mutableLiveData10;
        this.hangUpPromptEventLiveData = mutableLiveData10;
        MutableLiveData<Boolean> mutableLiveData11 = new MutableLiveData<>();
        this._quitRoomLiveData = mutableLiveData11;
        this.quitRoomLiveData = mutableLiveData11;
    }

    private final void getNewMessage() {
        MaskPartyChatRoomModel value = this._chatRoomModelLiveData.getValue();
        if (value != null) {
            Disposable disposed = a.C0844a.a(NetworkClient.f11868a.z(), value.getRoomId(), null, 2, 2, null).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<MaskPartyChatMessageResult, p>() { // from class: com.cupidapp.live.maskparty.viewmodel.BaseMaskPartyChatViewModel$getNewMessage$lambda$12$$inlined$handle$default$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(MaskPartyChatMessageResult maskPartyChatMessageResult) {
                    m2685invoke(maskPartyChatMessageResult);
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m2685invoke(MaskPartyChatMessageResult maskPartyChatMessageResult) {
                    ArrayList arrayList;
                    MutableLiveData mutableLiveData;
                    User targetUserInfo;
                    MaskPartyChatMessageResult maskPartyChatMessageResult2 = maskPartyChatMessageResult;
                    BaseMaskPartyChatViewModel.this.updateCurrentScore(maskPartyChatMessageResult2.getScore());
                    List<MaskPartyChatMessageModel> list = maskPartyChatMessageResult2.getList();
                    ImageModel imageModel = null;
                    if (list != null) {
                        arrayList = new ArrayList();
                        for (MaskPartyChatMessageModel maskPartyChatMessageModel : list) {
                            if (!maskPartyChatMessageModel.getMine()) {
                                arrayList.add(maskPartyChatMessageModel);
                            }
                        }
                    } else {
                        arrayList = null;
                    }
                    if (arrayList == null || arrayList.isEmpty()) {
                        return;
                    }
                    mutableLiveData = BaseMaskPartyChatViewModel.this._newMessageLiveData;
                    Object e02 = CollectionsKt___CollectionsKt.e0(arrayList);
                    MaskPartyChatMessageModel maskPartyChatMessageModel2 = (MaskPartyChatMessageModel) e02;
                    MaskPartyChatRoomModel value2 = BaseMaskPartyChatViewModel.this.get_chatRoomModelLiveData().getValue();
                    maskPartyChatMessageModel2.setRoomId(value2 != null ? value2.getRoomId() : null);
                    User sender = maskPartyChatMessageModel2.getSender();
                    if (sender != null) {
                        MaskPartyChatRoomModel value3 = BaseMaskPartyChatViewModel.this.get_chatRoomModelLiveData().getValue();
                        if (value3 != null && (targetUserInfo = value3.getTargetUserInfo()) != null) {
                            imageModel = targetUserInfo.getMaskAvatar();
                        }
                        sender.setMaskAvatar(imageModel);
                    }
                    maskPartyChatMessageModel2.setMask(true ^ BaseMaskPartyChatViewModel.this.getOthersPublicProfile());
                    mutableLiveData.setValue(e02);
                }
            }), new e(new ObservableExtensionKt$handle$disposed$2(null, null)));
            if (disposed != null) {
                s.h(disposed, "disposed");
            }
            s.h(disposed, "disposed");
        }
    }

    public static /* synthetic */ void sendImageMessage$default(BaseMaskPartyChatViewModel baseMaskPartyChatViewModel, Boolean bool, String str, MaskPartyChatMessageModel maskPartyChatMessageModel, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendImageMessage");
        }
        if ((i10 & 4) != 0) {
            maskPartyChatMessageModel = null;
        }
        baseMaskPartyChatViewModel.sendImageMessage(bool, str, maskPartyChatMessageModel);
    }

    public static /* synthetic */ void sendTextMessage$default(BaseMaskPartyChatViewModel baseMaskPartyChatViewModel, String str, MessageActionType messageActionType, MaskPartyChatMessageModel maskPartyChatMessageModel, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendTextMessage");
        }
        if ((i10 & 4) != 0) {
            maskPartyChatMessageModel = null;
        }
        baseMaskPartyChatViewModel.sendTextMessage(str, messageActionType, maskPartyChatMessageModel);
    }

    public final void alohaUser(@NotNull final MaskPartyChatMessageModel noticeMessage) {
        s.i(noticeMessage, "noticeMessage");
        MaskPartyChatRoomModel value = this._chatRoomModelLiveData.getValue();
        if (value != null) {
            Disposable disposed = a.C0836a.o(NetworkClient.f11868a.N(), value.getTargetUserInfo().userId(), null, null, ViewProfilePrefer.MaskMatch.getValue(), 0, null, null, null, 246, null).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<SwipeCardUserLikeResult, p>() { // from class: com.cupidapp.live.maskparty.viewmodel.BaseMaskPartyChatViewModel$alohaUser$lambda$20$$inlined$handle$default$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(SwipeCardUserLikeResult swipeCardUserLikeResult) {
                    m2683invoke(swipeCardUserLikeResult);
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m2683invoke(SwipeCardUserLikeResult swipeCardUserLikeResult) {
                    BaseMaskPartyChatViewModel.this.updateNoticeMessage(noticeMessage);
                    GroupSocialLog.f18708a.B(true, null, swipeCardUserLikeResult.getUser().userId(), (r52 & 8) != 0 ? 1 : 0, (r52 & 16) != 0 ? null : null, (r52 & 32) != 0 ? null : null, (r52 & 64) != 0 ? false : false, (r52 & 128) != 0 ? null : null, (r52 & 256) != 0 ? null : SensorPosition.ChatRoom, (r52 & 512) != 0 ? false : false, (r52 & 1024) != 0 ? null : null, (r52 & 2048) != 0 ? null : null, (r52 & 4096) != 0 ? 0 : 0, (r52 & 8192) != 0 ? null : null, (r52 & 16384) != 0 ? false : false, (32768 & r52) != 0 ? null : null, (65536 & r52) != 0 ? null : null, (131072 & r52) != 0 ? null : null, (262144 & r52) != 0 ? null : null, (524288 & r52) != 0 ? null : null, (1048576 & r52) != 0 ? null : null, (2097152 & r52) != 0 ? null : null, (4194304 & r52) != 0 ? null : null, (r52 & 8388608) != 0 ? null : null);
                }
            }), new e(new ObservableExtensionKt$handle$disposed$2(null, null)));
            if (disposed != null) {
                s.h(disposed, "disposed");
            }
            s.h(disposed, "disposed");
        }
    }

    public final void cancelMessage(@NotNull final MaskPartyChatMessageModel message) {
        MaskPartyChatRoomModel value;
        s.i(message, "message");
        if (message.getItemId() == null || (value = this._chatRoomModelLiveData.getValue()) == null) {
            return;
        }
        z2.a z10 = NetworkClient.f11868a.z();
        String roomId = value.getRoomId();
        String itemId = message.getItemId();
        s.f(itemId);
        Disposable disposed = z10.z(roomId, itemId).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<Object, p>() { // from class: com.cupidapp.live.maskparty.viewmodel.BaseMaskPartyChatViewModel$cancelMessage$lambda$14$$inlined$handle$default$1
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
                mutableLiveData = BaseMaskPartyChatViewModel.this._cancelMessageEventLiveData;
                mutableLiveData.setValue(new Event(message));
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(null, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    public final void confirmInRoom() {
        MaskPartyChatRoomModel value = this._chatRoomModelLiveData.getValue();
        if (value != null) {
            Disposable disposed = NetworkClient.f11868a.z().y(value.getRoomId()).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<Object, p>() { // from class: com.cupidapp.live.maskparty.viewmodel.BaseMaskPartyChatViewModel$confirmInRoom$lambda$24$$inlined$handle$default$1
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
    }

    public final void deleteMessage(@NotNull final MaskPartyChatMessageModel message) {
        MaskPartyChatRoomModel value;
        s.i(message, "message");
        if (message.getItemId() == null || (value = this._chatRoomModelLiveData.getValue()) == null) {
            return;
        }
        z2.a z10 = NetworkClient.f11868a.z();
        String roomId = value.getRoomId();
        String itemId = message.getItemId();
        s.f(itemId);
        Disposable disposed = z10.k(roomId, itemId).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<Object, p>() { // from class: com.cupidapp.live.maskparty.viewmodel.BaseMaskPartyChatViewModel$deleteMessage$lambda$16$$inlined$handle$default$1
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
                mutableLiveData = BaseMaskPartyChatViewModel.this._deleteMessageEventLiveData;
                String itemId2 = message.getItemId();
                s.f(itemId2);
                mutableLiveData.setValue(new Event(new Pair(itemId2, Boolean.FALSE)));
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(null, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    @NotNull
    public final LiveData<Event<MaskPartyChatMessageModel>> getCancelMessageEventLiveData() {
        return this.cancelMessageEventLiveData;
    }

    public final void getChatRoomData(@NotNull String roomId) {
        s.i(roomId, "roomId");
        Disposable disposed = NetworkClient.f11868a.z().e(roomId).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<MaskPartyChatRoomModel, p>() { // from class: com.cupidapp.live.maskparty.viewmodel.BaseMaskPartyChatViewModel$getChatRoomData$$inlined$handle$default$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(MaskPartyChatRoomModel maskPartyChatRoomModel) {
                m2684invoke(maskPartyChatRoomModel);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2684invoke(MaskPartyChatRoomModel maskPartyChatRoomModel) {
                MaskPartyChatRoomModel maskPartyChatRoomModel2 = maskPartyChatRoomModel;
                BaseMaskPartyChatViewModel.this.matchSuccessTime = System.currentTimeMillis();
                BaseMaskPartyChatViewModel.this.get_chatRoomModelLiveData().setValue(maskPartyChatRoomModel2);
                BaseMaskPartyChatViewModel baseMaskPartyChatViewModel = BaseMaskPartyChatViewModel.this;
                Integer score = maskPartyChatRoomModel2.getScore();
                baseMaskPartyChatViewModel.updateCurrentScore(score != null ? score.intValue() : 0);
                BaseMaskPartyChatViewModel.this.insertNoticeMessage(null, maskPartyChatRoomModel2.getAutoTip());
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(null, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    @NotNull
    public final LiveData<MaskPartyChatRoomModel> getChatRoomModelLiveData() {
        return this.chatRoomModelLiveData;
    }

    @NotNull
    public final LiveData<Event<Pair<String, Boolean>>> getDeleteMessageEventLiveData() {
        return this.deleteMessageEventLiveData;
    }

    @NotNull
    public final LiveData<Event<MaskPartyHangUpMessageModel>> getHangUpPromptEventLiveData() {
        return this.hangUpPromptEventLiveData;
    }

    @NotNull
    public final LiveData<Event<Boolean>> getLeaveRoomEventLiveData() {
        return this.leaveRoomEventLiveData;
    }

    @NotNull
    public final LiveData<MaskPartyChatMessageModel> getNewMessageLiveData() {
        return this.newMessageLiveData;
    }

    public final boolean getOthersPublicProfile() {
        return this.othersPublicProfile;
    }

    @NotNull
    public final LiveData<Event<MaskPartyChatDiceModel>> getPlayDiceEventLiveData() {
        return this.playDiceEventLiveData;
    }

    public final boolean getPublicMyProfile() {
        return this.publicMyProfile;
    }

    @NotNull
    public final LiveData<Boolean> getQuitRoomLiveData() {
        return this.quitRoomLiveData;
    }

    @NotNull
    public final LiveData<Pair<Long, MaskPartyChatMessageModel>> getReplaceMessage() {
        return this.replaceMessage;
    }

    @NotNull
    public final LiveData<Event<Boolean>> getShowSendImageGuideEventLiveData() {
        return this.showSendImageGuideEventLiveData;
    }

    @NotNull
    public final LiveData<Event<String>> getTypingEventLiveData() {
        return this.typingEventLiveData;
    }

    @NotNull
    public final MutableLiveData<MaskPartyChatRoomModel> get_chatRoomModelLiveData() {
        return this._chatRoomModelLiveData;
    }

    public final void insertDiceMessage(@NotNull MaskPartyChatDiceModel dice) {
        s.i(dice, "dice");
        MutableLiveData<MaskPartyChatMessageModel> mutableLiveData = this._newMessageLiveData;
        com.cupidapp.live.maskparty.helper.a aVar = com.cupidapp.live.maskparty.helper.a.f16351a;
        boolean z10 = !this.othersPublicProfile;
        MaskPartyChatRoomModel value = this._chatRoomModelLiveData.getValue();
        mutableLiveData.setValue(aVar.b(dice, z10, value != null ? value.getTargetUserInfo() : null));
        this._newMessageLiveData.setValue(com.cupidapp.live.maskparty.helper.a.c(aVar, dice, !this.publicMyProfile, null, 4, null));
    }

    public final void insertNoticeMessage(@Nullable MaskPartyChatNotifyMessageModel maskPartyChatNotifyMessageModel, @Nullable String str) {
        if (maskPartyChatNotifyMessageModel == null) {
            if (str == null || str.length() == 0) {
                return;
            }
        }
        this._newMessageLiveData.setValue(com.cupidapp.live.maskparty.helper.a.f16351a.f(maskPartyChatNotifyMessageModel, str));
    }

    public final void insertTextMessage(@Nullable String str, @Nullable User user) {
        if ((str == null || str.length() == 0) || user == null) {
            return;
        }
        this._newMessageLiveData.setValue(com.cupidapp.live.maskparty.helper.a.f16351a.e(str, user, true));
    }

    public final boolean isMaskState() {
        return (this.publicMyProfile && this.othersPublicProfile) ? false : true;
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        GrpcMessageRouter.INSTANCE.removeIGrpcMessageListener(this);
    }

    @Override // com.cupidapp.live.base.grpc.IGrpcMessageListener
    public void onReceiveGrpcMessage(@NotNull CuConnectorOuterClass.MessageType type, @NotNull Object model) {
        PostAndSocialProtos.Type type2;
        User targetUserInfo;
        s.i(type, "type");
        s.i(model, "model");
        boolean z10 = model instanceof MaskPartyChatConnectorMessageModel;
        String str = null;
        if (z10) {
            String roomId = ((MaskPartyChatConnectorMessageModel) model).getRoomId();
            MaskPartyChatRoomModel value = this._chatRoomModelLiveData.getValue();
            if (!s.d(roomId, value != null ? value.getRoomId() : null)) {
                return;
            }
        }
        switch (a.f16477a[type.ordinal()]) {
            case 1:
                if (model instanceof MaskPartyMessageModel) {
                    getNewMessage();
                    return;
                }
                return;
            case 2:
                if (model instanceof MaskPartyMessageModel) {
                    MaskPartyMessageModel maskPartyMessageModel = (MaskPartyMessageModel) model;
                    this._deleteMessageEventLiveData.setValue(new Event<>(new Pair(maskPartyMessageModel.getMessageId(), Boolean.valueOf(maskPartyMessageModel.getType() == RemoveMessageType.Cancel.getType()))));
                    return;
                }
                return;
            case 3:
                if (model instanceof MaskPartyChatNotifyMessageModel) {
                    insertNoticeMessage((MaskPartyChatNotifyMessageModel) model, null);
                    return;
                }
                return;
            case 4:
                if (model instanceof MaskPartyChatDiceModel) {
                    MaskPartyChatRoomModel value2 = this._chatRoomModelLiveData.getValue();
                    Integer valueOf = value2 != null ? Integer.valueOf(value2.getPlayType()) : null;
                    int type3 = MaskPartyType.MessageChat.getType();
                    if (valueOf != null && valueOf.intValue() == type3) {
                        type2 = PostAndSocialProtos.Type.SHOT;
                    } else {
                        type2 = PostAndSocialProtos.Type.PLAY_ACTION;
                    }
                    PostAndSocialProtos.Type type4 = type2;
                    MaskPartyChatDiceModel maskPartyChatDiceModel = (MaskPartyChatDiceModel) model;
                    if (maskPartyChatDiceModel.getNeedShowShotAnimation()) {
                        GroupSocialLog groupSocialLog = GroupSocialLog.f18708a;
                        MaskPartyChatRoomModel value3 = this._chatRoomModelLiveData.getValue();
                        String roomId2 = value3 != null ? value3.getRoomId() : null;
                        MaskPartyChatRoomModel value4 = this._chatRoomModelLiveData.getValue();
                        if (value4 != null && (targetUserInfo = value4.getTargetUserInfo()) != null) {
                            str = targetUserInfo.userId();
                        }
                        groupSocialLog.R(type4, (r15 & 2) != 0 ? null : roomId2, (r15 & 4) != 0 ? null : str, (r15 & 8) != 0 ? null : null, (r15 & 16) != 0 ? null : null, (r15 & 32) != 0 ? false : false, (r15 & 64) == 0 ? null : null);
                    }
                    updateCurrentScore(maskPartyChatDiceModel.getScore());
                    this._playDiceEventLiveData.setValue(new Event<>(model));
                    return;
                }
                return;
            case 5:
                if (model instanceof MaskPartyChatTypingModel) {
                    this._typingEventLiveData.setValue(new Event<>(((MaskPartyChatTypingModel) model).getMsg()));
                    return;
                }
                return;
            case 6:
                if (model instanceof MaskPartyChatLeaveRoom) {
                    this._leaveRoomEventLiveData.setValue(new Event<>(Boolean.valueOf(isMaskState())));
                    return;
                }
                return;
            case 7:
                if (z10) {
                    this._showSendImageGuideEventLiveData.setValue(new Event<>(Boolean.TRUE));
                    return;
                }
                return;
            case 8:
                if ((model instanceof FKPushModel) && ((FKPushModel) model).getPushMessageModel().getPushType() == FKPushType.NewMatch) {
                    insertNoticeMessage(null, AppApplication.f11612d.h().getString(R$string.match_success_notice_prompt));
                    return;
                }
                return;
            case 9:
                if (model instanceof MaskPartyHangUpMessageModel) {
                    this._hangUpPromptEventLiveData.setValue(new Event<>(model));
                    return;
                }
                return;
            default:
                receiveGrpcMessage(type, model);
                return;
        }
    }

    public void openAlbum() {
    }

    public void openProfile() {
    }

    public final void quitChatRoom() {
        MaskPartyChatRoomModel value = this._chatRoomModelLiveData.getValue();
        if (value != null) {
            Disposable disposed = NetworkClient.f11868a.z().q(value.getRoomId(), Integer.valueOf((int) v.p(System.currentTimeMillis() - this.matchSuccessTime))).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<QuitRoomModel, p>() { // from class: com.cupidapp.live.maskparty.viewmodel.BaseMaskPartyChatViewModel$quitChatRoom$lambda$22$$inlined$handle$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(QuitRoomModel quitRoomModel) {
                    m2686invoke(quitRoomModel);
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m2686invoke(QuitRoomModel quitRoomModel) {
                    MutableLiveData mutableLiveData;
                    mutableLiveData = BaseMaskPartyChatViewModel.this._quitRoomLiveData;
                    mutableLiveData.setValue(Boolean.valueOf(quitRoomModel.getPropCardTipWindow()));
                }
            }), new e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.maskparty.viewmodel.BaseMaskPartyChatViewModel$quitChatRoom$1$2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Boolean invoke(@NotNull Throwable it) {
                    MutableLiveData mutableLiveData;
                    s.i(it, "it");
                    mutableLiveData = BaseMaskPartyChatViewModel.this._quitRoomLiveData;
                    mutableLiveData.setValue(Boolean.FALSE);
                    return Boolean.TRUE;
                }
            }, null)));
            if (disposed != null) {
                s.h(disposed, "disposed");
            }
            s.h(disposed, "disposed");
        }
    }

    public void receiveGrpcMessage(@NotNull CuConnectorOuterClass.MessageType type, @NotNull Object model) {
        s.i(type, "type");
        s.i(model, "model");
    }

    public final void resendMessage(@NotNull MaskPartyChatMessageModel failModel) {
        s.i(failModel, "failModel");
        String type = failModel.getType();
        if (s.d(type, MaskPartyChatMessageType.InboxMessageText.getValue())) {
            sendTextMessage(failModel.getText(), failModel.getActionType(), failModel);
        } else if (s.d(type, MaskPartyChatMessageType.InboxMessageImage.getValue())) {
            sendImageMessage(Boolean.FALSE, failModel.getImagePath(), failModel);
        } else if (s.d(type, MaskPartyChatMessageType.InboxMessageSnapImage.getValue())) {
            sendImageMessage(Boolean.TRUE, failModel.getImagePath(), failModel);
        }
    }

    public final void sendImageMessage(@Nullable Boolean bool, @Nullable String str, @Nullable final MaskPartyChatMessageModel maskPartyChatMessageModel) {
        Observable<Result<MaskPartyChatMessageResult>> f10;
        if (str == null || str.length() == 0) {
            return;
        }
        if (maskPartyChatMessageModel == null) {
            maskPartyChatMessageModel = com.cupidapp.live.maskparty.helper.a.f16351a.d(bool, str);
            this._newMessageLiveData.setValue(maskPartyChatMessageModel);
        } else {
            maskPartyChatMessageModel.setMessageSendState(MaskPartyChatMessageSendState.Sending);
        }
        MaskPartyChatRoomModel value = this._chatRoomModelLiveData.getValue();
        if (value != null) {
            File file = new File(str);
            MultipartBody.Part createFormData = MultipartBody.Part.Companion.createFormData(Attributes.Component.IMAGE, file.getName(), f.a(file));
            if (s.d(bool, Boolean.TRUE)) {
                f10 = NetworkClient.f11868a.z().n(createFormData, value.getRoomId(), value.getTargetUserInfo().userId(), 10);
            } else {
                f10 = NetworkClient.f11868a.z().f(createFormData, value.getRoomId(), value.getTargetUserInfo().userId());
            }
            Disposable disposed = f10.flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<MaskPartyChatMessageResult, p>() { // from class: com.cupidapp.live.maskparty.viewmodel.BaseMaskPartyChatViewModel$sendImageMessage$lambda$8$$inlined$handle$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(MaskPartyChatMessageResult maskPartyChatMessageResult) {
                    m2687invoke(maskPartyChatMessageResult);
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m2687invoke(MaskPartyChatMessageResult maskPartyChatMessageResult) {
                    MutableLiveData mutableLiveData;
                    MaskPartyChatMessageResult maskPartyChatMessageResult2 = maskPartyChatMessageResult;
                    List<MaskPartyChatMessageModel> list = maskPartyChatMessageResult2.getList();
                    if (list == null || list.isEmpty()) {
                        return;
                    }
                    MaskPartyChatMessageModel maskPartyChatMessageModel2 = MaskPartyChatMessageModel.this;
                    maskPartyChatMessageModel2.setItemId(maskPartyChatMessageResult2.getList().get(0).getItemId());
                    maskPartyChatMessageModel2.setMessageSendState(MaskPartyChatMessageSendState.SendSuccess);
                    mutableLiveData = this._replaceMessage;
                    mutableLiveData.setValue(new Pair(Long.valueOf(MaskPartyChatMessageModel.this.getCreateTimeMillis()), MaskPartyChatMessageModel.this));
                }
            }), new e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.maskparty.viewmodel.BaseMaskPartyChatViewModel$sendImageMessage$1$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Boolean invoke(@NotNull Throwable it) {
                    MutableLiveData mutableLiveData;
                    s.i(it, "it");
                    MaskPartyChatMessageModel.this.setMessageSendState(MaskPartyChatMessageSendState.Resend);
                    mutableLiveData = this._replaceMessage;
                    mutableLiveData.setValue(new Pair(Long.valueOf(MaskPartyChatMessageModel.this.getCreateTimeMillis()), MaskPartyChatMessageModel.this));
                    return Boolean.FALSE;
                }
            }, null)));
            if (disposed != null) {
                s.h(disposed, "disposed");
            }
            s.h(disposed, "disposed");
        }
    }

    public final void sendTextMessage(@Nullable String str, @NotNull MessageActionType type, @Nullable final MaskPartyChatMessageModel maskPartyChatMessageModel) {
        s.i(type, "type");
        if (str == null || str.length() == 0) {
            return;
        }
        if (maskPartyChatMessageModel == null) {
            maskPartyChatMessageModel = com.cupidapp.live.maskparty.helper.a.f16351a.h(str, type);
            this._newMessageLiveData.setValue(maskPartyChatMessageModel);
        } else {
            maskPartyChatMessageModel.setMessageSendState(MaskPartyChatMessageSendState.Sending);
        }
        MaskPartyChatRoomModel value = this._chatRoomModelLiveData.getValue();
        if (value != null) {
            Disposable disposed = NetworkClient.f11868a.z().j(str, value.getRoomId(), value.getTargetUserInfo().userId(), type.getType()).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<MaskPartyChatMessageResult, p>() { // from class: com.cupidapp.live.maskparty.viewmodel.BaseMaskPartyChatViewModel$sendTextMessage$lambda$4$$inlined$handle$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(MaskPartyChatMessageResult maskPartyChatMessageResult) {
                    m2688invoke(maskPartyChatMessageResult);
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m2688invoke(MaskPartyChatMessageResult maskPartyChatMessageResult) {
                    MutableLiveData mutableLiveData;
                    MaskPartyChatMessageResult maskPartyChatMessageResult2 = maskPartyChatMessageResult;
                    List<MaskPartyChatMessageModel> list = maskPartyChatMessageResult2.getList();
                    if (list == null || list.isEmpty()) {
                        return;
                    }
                    BaseMaskPartyChatViewModel.this.updateCurrentScore(maskPartyChatMessageResult2.getScore());
                    MaskPartyChatMessageModel maskPartyChatMessageModel2 = maskPartyChatMessageModel;
                    maskPartyChatMessageModel2.setItemId(maskPartyChatMessageResult2.getList().get(0).getItemId());
                    maskPartyChatMessageModel2.setMessageSendState(MaskPartyChatMessageSendState.SendSuccess);
                    mutableLiveData = BaseMaskPartyChatViewModel.this._replaceMessage;
                    mutableLiveData.setValue(new Pair(Long.valueOf(maskPartyChatMessageModel.getCreateTimeMillis()), maskPartyChatMessageModel));
                }
            }), new e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.maskparty.viewmodel.BaseMaskPartyChatViewModel$sendTextMessage$1$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Boolean invoke(@NotNull Throwable it) {
                    MutableLiveData mutableLiveData;
                    s.i(it, "it");
                    MaskPartyChatMessageModel.this.setMessageSendState(MaskPartyChatMessageSendState.Resend);
                    mutableLiveData = this._replaceMessage;
                    mutableLiveData.setValue(new Pair(Long.valueOf(MaskPartyChatMessageModel.this.getCreateTimeMillis()), MaskPartyChatMessageModel.this));
                    return Boolean.FALSE;
                }
            }, null)));
            if (disposed != null) {
                s.h(disposed, "disposed");
            }
            s.h(disposed, "disposed");
        }
    }

    public final void setOthersPublicProfile(boolean z10) {
        this.othersPublicProfile = z10;
    }

    public final void setPublicMyProfile(boolean z10) {
        this.publicMyProfile = z10;
    }

    public final void typing() {
        MaskPartyChatRoomModel value = this._chatRoomModelLiveData.getValue();
        if (value == null || (System.currentTimeMillis() - this.currentTime) / 1000 < value.getInputTimerSeconds()) {
            return;
        }
        this.currentTime = System.currentTimeMillis();
        Disposable disposed = NetworkClient.f11868a.z().C(value.getRoomId(), value.getTargetUserInfo().userId()).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<Object, p>() { // from class: com.cupidapp.live.maskparty.viewmodel.BaseMaskPartyChatViewModel$typing$lambda$18$$inlined$handle$default$1
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

    public final void updateAlohaStatus(@NotNull User user, @NotNull MaskPartyChatMessageModel noticeMessage) {
        User targetUserInfo;
        s.i(user, "user");
        s.i(noticeMessage, "noticeMessage");
        String userId = user.userId();
        MaskPartyChatRoomModel value = this._chatRoomModelLiveData.getValue();
        if (s.d(userId, (value == null || (targetUserInfo = value.getTargetUserInfo()) == null) ? null : targetUserInfo.userId()) && user.getAloha()) {
            updateNoticeMessage(noticeMessage);
        }
    }

    public void updateCurrentScore(int i10) {
    }

    public final void updateNoticeMessage(@NotNull MaskPartyChatMessageModel noticeMessage) {
        s.i(noticeMessage, "noticeMessage");
        MaskPartyChatNotifyMessageModel notice = noticeMessage.getNotice();
        noticeMessage.setNotice(new MaskPartyChatNotifyMessageModel(null, notice != null ? notice.getActionCompleteContent() : null, null, null, null, null, null, 125, null));
        this._replaceMessage.setValue(new Pair<>(Long.valueOf(noticeMessage.getCreateTimeMillis()), noticeMessage));
    }
}

package com.cupidapp.live.chat2.viewmodel;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.extension.ImageAttributeModel;
import com.cupidapp.live.base.grpc.CuConnectorOuterClass;
import com.cupidapp.live.base.grpc.GrpcMessageRouter;
import com.cupidapp.live.base.grpc.IGrpcMessageListener;
import com.cupidapp.live.base.livedata.Event;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.RequestErrorCode;
import com.cupidapp.live.base.network.ResultShowErrorStyle;
import com.cupidapp.live.base.network.e;
import com.cupidapp.live.base.network.i;
import com.cupidapp.live.base.network.j;
import com.cupidapp.live.base.network.model.Result;
import com.cupidapp.live.base.network.model.StateResult;
import com.cupidapp.live.base.sensorslog.FKSensorContext;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorsLogFeed;
import com.cupidapp.live.base.view.h;
import com.cupidapp.live.chat.model.InboxSessionModel;
import com.cupidapp.live.chat.service.InboxSessionResult;
import com.cupidapp.live.chat2.fragment.ChatDetailFragment;
import com.cupidapp.live.chat2.helper.g;
import com.cupidapp.live.chat2.holder.ChatOtherStoryLabelUiModel;
import com.cupidapp.live.chat2.model.BaseChatGrpcModel;
import com.cupidapp.live.chat2.model.ChatBundleData;
import com.cupidapp.live.chat2.model.ChatFocusStateData;
import com.cupidapp.live.chat2.model.ChatGuideGrpcModel;
import com.cupidapp.live.chat2.model.ChatMessageModel;
import com.cupidapp.live.chat2.model.ChatMessageResult;
import com.cupidapp.live.chat2.model.ChatMessageType;
import com.cupidapp.live.chat2.model.ChatNoticeBtnType;
import com.cupidapp.live.chat2.model.ChatTextType;
import com.cupidapp.live.feed.layout.MsgType;
import com.cupidapp.live.feed.model.FeedModel;
import com.cupidapp.live.profile.model.CompatResult;
import com.cupidapp.live.profile.model.FKStoryLabelItemModel;
import com.cupidapp.live.profile.model.FocusResultModel;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.profile.model.ZodiacElfInfoModel;
import com.cupidapp.live.push.FKPushModel;
import com.cupidapp.live.push.FKPushType;
import com.cupidapp.live.push.util.PushExtraData;
import com.cupidapp.live.track.group.GroupSocialLog;
import com.huawei.quickcard.base.Attributes;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.i0;
import kotlin.collections.r;
import kotlin.d;
import kotlin.f;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import okhttp3.MultipartBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import x1.a;
import x2.a;
import z0.l;

/* compiled from: ChatDetailViewModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ChatDetailViewModel extends ViewModel implements IGrpcMessageListener {

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final int SNAP_MESSAGE_COUNT_DOWN_SECOND = 10;

    @NotNull
    private final MutableLiveData<Pair<String, ChatMessageModel>> _cancelMessage;

    @NotNull
    private final MutableLiveData<Event<ChatGuideGrpcModel>> _chatGuide;

    @NotNull
    private final MutableLiveData<ChatMessageModel> _deleteMessageByModel;

    @NotNull
    private final MutableLiveData<String> _deleteMessageByMsgId;

    @NotNull
    private final MutableLiveData<Event<List<ChatMessageModel>>> _firstScreenHistoryMsg;

    @NotNull
    private final MutableLiveData<Event<ChatFocusStateData>> _focusState;

    @NotNull
    private final MutableLiveData<Boolean> _hasPrivilege;

    @NotNull
    private final MutableLiveData<Boolean> _inLiveShow;

    @NotNull
    private final MutableLiveData<Boolean> _isFromStoryLabel;

    @NotNull
    private final MutableLiveData<Event<StateResult<List<ChatMessageModel>>>> _moreHistoryMsg;

    @NotNull
    private final MutableLiveData<List<ChatMessageModel>> _newMessage;

    @NotNull
    private final MutableLiveData<Event<Boolean>> _notifyGetNewMessage;

    @NotNull
    private final MutableLiveData<Event<List<String>>> _otherReadMeMessage;

    @NotNull
    private final MutableLiveData<Event<ChatOtherStoryLabelUiModel>> _otherStoryLabel;

    @NotNull
    private final MutableLiveData<User> _otherUser;

    @NotNull
    private final MutableLiveData<Pair<Long, ChatMessageModel>> _replaceMessage;

    @NotNull
    private final MutableLiveData<String> _sourceDesc;

    @NotNull
    private final MutableLiveData<Event<List<ZodiacElfInfoModel>>> _zodiacQuestionList;

    @NotNull
    private final LiveData<Pair<String, ChatMessageModel>> cancelMessage;

    @NotNull
    private final LiveData<Event<ChatGuideGrpcModel>> chatGuide;

    @NotNull
    private final LiveData<ChatMessageModel> deleteMessageByModel;

    @NotNull
    private final LiveData<String> deleteMessageByMsgId;

    @NotNull
    private final LiveData<Event<List<ChatMessageModel>>> firstScreenHistoryMsg;

    @NotNull
    private final LiveData<Event<ChatFocusStateData>> focusState;

    @NotNull
    private final LiveData<Boolean> hasPrivilege;

    @NotNull
    private final LiveData<Boolean> inLiveShow;

    @NotNull
    private final LiveData<Boolean> isFromStoryLabel;
    private boolean isLimitTimeSendMsg;

    @Nullable
    private FeedModel mFeedModel;

    @Nullable
    private String mHistoryCursorId;
    private long mOpenChatDetailPopupMillis;
    private String mOtherUserId;

    @Nullable
    private FKSensorContext mSensorContext;
    private String mSessionId;

    @Nullable
    private Integer mStoryLabelId;

    @NotNull
    private final LiveData<Event<StateResult<List<ChatMessageModel>>>> moreHistoryMsg;

    @NotNull
    private final LiveData<List<ChatMessageModel>> newMessage;

    @NotNull
    private final LiveData<Event<Boolean>> notifyGetNewMessage;

    @NotNull
    private final LiveData<Event<List<String>>> otherReadMeMessage;

    @NotNull
    private final LiveData<Event<ChatOtherStoryLabelUiModel>> otherStoryLabel;

    @NotNull
    private final LiveData<User> otherUser;

    @NotNull
    private final LiveData<Pair<Long, ChatMessageModel>> replaceMessage;

    @NotNull
    private final LiveData<String> sourceDesc;
    private long uploadStartTime;

    @NotNull
    private final LiveData<Event<List<ZodiacElfInfoModel>>> zodiacQuestionList;

    /* compiled from: ChatDetailViewModel.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: ChatDetailViewModel.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f13467a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f13468b;

        static {
            int[] iArr = new int[FKPushType.values().length];
            try {
                iArr[FKPushType.InboxMessageNew.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FKPushType.InboxMessageNewFocus.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[FKPushType.InboxMessageNewIntimate.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[FKPushType.MessageNewSnapPhoto.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[FKPushType.MessageNewSnapPhotoFocus.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[FKPushType.MessageNewSnapPhotoIntimate.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[FKPushType.MessageNewSnapText.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[FKPushType.MessageScreenCapture.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[FKPushType.MessageNotice.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[FKPushType.MessageCancel.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[FKPushType.MessageDestory.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[FKPushType.MessageRead.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            f13467a = iArr;
            int[] iArr2 = new int[CuConnectorOuterClass.MessageType.values().length];
            try {
                iArr2[CuConnectorOuterClass.MessageType.ChatGuide.ordinal()] = 1;
            } catch (NoSuchFieldError unused13) {
            }
            f13468b = iArr2;
        }
    }

    public ChatDetailViewModel() {
        GrpcMessageRouter.INSTANCE.addIGrpcMessageListener(this);
        MutableLiveData<User> mutableLiveData = new MutableLiveData<>();
        this._otherUser = mutableLiveData;
        this.otherUser = mutableLiveData;
        MutableLiveData<Event<List<ChatMessageModel>>> mutableLiveData2 = new MutableLiveData<>();
        this._firstScreenHistoryMsg = mutableLiveData2;
        this.firstScreenHistoryMsg = mutableLiveData2;
        MutableLiveData<Event<StateResult<List<ChatMessageModel>>>> mutableLiveData3 = new MutableLiveData<>();
        this._moreHistoryMsg = mutableLiveData3;
        this.moreHistoryMsg = mutableLiveData3;
        MutableLiveData<Boolean> mutableLiveData4 = new MutableLiveData<>();
        this._hasPrivilege = mutableLiveData4;
        this.hasPrivilege = mutableLiveData4;
        MutableLiveData<Boolean> mutableLiveData5 = new MutableLiveData<>();
        this._inLiveShow = mutableLiveData5;
        this.inLiveShow = mutableLiveData5;
        MutableLiveData<List<ChatMessageModel>> mutableLiveData6 = new MutableLiveData<>();
        this._newMessage = mutableLiveData6;
        this.newMessage = mutableLiveData6;
        MutableLiveData<Pair<Long, ChatMessageModel>> mutableLiveData7 = new MutableLiveData<>();
        this._replaceMessage = mutableLiveData7;
        this.replaceMessage = mutableLiveData7;
        MutableLiveData<Pair<String, ChatMessageModel>> mutableLiveData8 = new MutableLiveData<>();
        this._cancelMessage = mutableLiveData8;
        this.cancelMessage = mutableLiveData8;
        MutableLiveData<ChatMessageModel> mutableLiveData9 = new MutableLiveData<>();
        this._deleteMessageByModel = mutableLiveData9;
        this.deleteMessageByModel = mutableLiveData9;
        MutableLiveData<String> mutableLiveData10 = new MutableLiveData<>();
        this._deleteMessageByMsgId = mutableLiveData10;
        this.deleteMessageByMsgId = mutableLiveData10;
        MutableLiveData<Event<List<String>>> mutableLiveData11 = new MutableLiveData<>();
        this._otherReadMeMessage = mutableLiveData11;
        this.otherReadMeMessage = mutableLiveData11;
        MutableLiveData<Event<ChatFocusStateData>> mutableLiveData12 = new MutableLiveData<>();
        this._focusState = mutableLiveData12;
        this.focusState = mutableLiveData12;
        MutableLiveData<Event<Boolean>> mutableLiveData13 = new MutableLiveData<>();
        this._notifyGetNewMessage = mutableLiveData13;
        this.notifyGetNewMessage = mutableLiveData13;
        MutableLiveData<Boolean> mutableLiveData14 = new MutableLiveData<>();
        this._isFromStoryLabel = mutableLiveData14;
        this.isFromStoryLabel = mutableLiveData14;
        MutableLiveData<Event<ChatOtherStoryLabelUiModel>> mutableLiveData15 = new MutableLiveData<>();
        this._otherStoryLabel = mutableLiveData15;
        this.otherStoryLabel = mutableLiveData15;
        MutableLiveData<Event<List<ZodiacElfInfoModel>>> mutableLiveData16 = new MutableLiveData<>();
        this._zodiacQuestionList = mutableLiveData16;
        this.zodiacQuestionList = mutableLiveData16;
        MutableLiveData<Event<ChatGuideGrpcModel>> mutableLiveData17 = new MutableLiveData<>();
        this._chatGuide = mutableLiveData17;
        this.chatGuide = mutableLiveData17;
        MutableLiveData<String> mutableLiveData18 = new MutableLiveData<>();
        this._sourceDesc = mutableLiveData18;
        this.sourceDesc = mutableLiveData18;
    }

    private final long getPopupMillis() {
        FeedModel feedModel = this.mFeedModel;
        String postId = feedModel != null ? feedModel.getPostId() : null;
        if ((postId == null || postId.length() == 0) && this.mStoryLabelId == null) {
            return 0L;
        }
        return this.mOpenChatDetailPopupMillis;
    }

    private final void handleChatMsgGrpc(Object obj) {
        if (obj instanceof FKPushModel) {
            FKPushModel fKPushModel = (FKPushModel) obj;
            PushExtraData a10 = PushExtraData.Companion.a(fKPushModel.getPushMessageModel().getData());
            String str = null;
            String sessionId = a10 != null ? a10.getSessionId() : null;
            if (sessionId == null || sessionId.length() == 0) {
                return;
            }
            String sessionId2 = a10 != null ? a10.getSessionId() : null;
            String str2 = this.mSessionId;
            if (str2 == null) {
                s.A("mSessionId");
            } else {
                str = str2;
            }
            if (s.d(sessionId2, str)) {
                switch (a.f13467a[fKPushModel.getPushMessageModel().getPushType().ordinal()]) {
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                        this._notifyGetNewMessage.setValue(new Event<>(Boolean.TRUE));
                        return;
                    case 10:
                        String messageId = a10.getMessageId();
                        if (messageId == null || messageId.length() == 0) {
                            return;
                        }
                        this._cancelMessage.setValue(new Pair<>(a10.getMessageId(), g.e(g.f13369a, "对方撤回了一条消息", null, null, 6, null)));
                        return;
                    case 11:
                        String messageId2 = a10.getMessageId();
                        if (messageId2 != null) {
                            if (messageId2.length() > 0) {
                                this._deleteMessageByMsgId.setValue(messageId2);
                                return;
                            }
                            return;
                        }
                        return;
                    case 12:
                        List<String> messageIds = a10.getMessageIds();
                        if (messageIds == null || messageIds.isEmpty()) {
                            return;
                        }
                        this._otherReadMeMessage.setValue(new Event<>(messageIds));
                        return;
                    default:
                        return;
                }
            }
        }
    }

    private final void handleChatOtherGrpc(CuConnectorOuterClass.MessageType messageType, Object obj) {
        if (obj instanceof BaseChatGrpcModel) {
            String sessionId = ((BaseChatGrpcModel) obj).getSessionId();
            String str = this.mSessionId;
            if (str == null) {
                s.A("mSessionId");
                str = null;
            }
            if (s.d(sessionId, str) && a.f13468b[messageType.ordinal()] == 1 && (obj instanceof ChatGuideGrpcModel)) {
                this._chatGuide.setValue(new Event<>(obj));
            }
        }
    }

    private final void insertPostRefererTipMessage() {
        FeedModel feedModel;
        if (this._hasPrivilege.getValue() == null || (feedModel = this.mFeedModel) == null) {
            return;
        }
        ChatMessageModel f10 = g.f13369a.f(feedModel);
        if (f10 != null) {
            this._newMessage.setValue(r.e(f10));
        }
        this._hasPrivilege.setValue(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void insertSendMsgFailErrorNotice(Throwable th) {
        String b4 = j.f12008a.b(th, false);
        if (b4 == null || b4.length() == 0) {
            return;
        }
        this._newMessage.setValue(r.e(g.e(g.f13369a, b4, null, null, 6, null)));
    }

    private final void insertStoryLabelTipMessage() {
        if (s.d(this._isFromStoryLabel.getValue(), Boolean.TRUE)) {
            this._newMessage.setValue(r.e(g.f13369a.i()));
            this._isFromStoryLabel.setValue(Boolean.FALSE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isStopDefaultErrorHandler(Throwable th) {
        ResultShowErrorStyle d10 = j.f12008a.d(th);
        return d10 == ResultShowErrorStyle.ALERT || d10 == ResultShowErrorStyle.TOAST;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reportSendMessageLog(MsgType msgType, String str) {
        User value = this._otherUser.getValue();
        SensorsLogFeed sensorsLogFeed = SensorsLogFeed.f12208a;
        FKSensorContext fKSensorContext = this.mSensorContext;
        SensorPosition position = fKSensorContext != null ? fKSensorContext.getPosition() : null;
        FKSensorContext fKSensorContext2 = this.mSensorContext;
        sensorsLogFeed.B(position, fKSensorContext2 != null ? fKSensorContext2.getSource() : null, value != null ? value.getSensorRelationship() : null, value != null ? Boolean.valueOf(value.getSuperLikedByMe()) : null, value != null ? Boolean.valueOf(value.getFocus()) : null, value != null ? Boolean.valueOf(value.getCloseFriend()) : null, str, value != null ? value.userId() : null, msgType.name(), Boolean.valueOf(this.isLimitTimeSendMsg));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reportUploadFilesLog(Boolean bool, long j10, int i10, int i11, Throwable th) {
        SensorsLogFeed.UploadFileType uploadFileType;
        long currentTimeMillis = System.currentTimeMillis() - this.uploadStartTime;
        if (s.d(bool, Boolean.TRUE)) {
            uploadFileType = SensorsLogFeed.UploadFileType.BURN_AFTER_READING;
        } else {
            uploadFileType = SensorsLogFeed.UploadFileType.CHAT_PHOTO;
        }
        SensorsLogFeed.UploadFileType uploadFileType2 = uploadFileType;
        SensorsLogFeed sensorsLogFeed = SensorsLogFeed.f12208a;
        FKSensorContext fKSensorContext = this.mSensorContext;
        SensorPosition position = fKSensorContext != null ? fKSensorContext.getPosition() : null;
        boolean z10 = th == null;
        String a10 = j.f12008a.a(th);
        sensorsLogFeed.O(currentTimeMillis, j10, i10, i11, uploadFileType2, "图片", position, z10, a10 == null ? th != null ? th.getMessage() : null : a10, (r33 & 512) != 0 ? null : null, (r33 & 1024) != 0 ? null : null, (r33 & 2048) != 0 ? null : null);
    }

    public static /* synthetic */ void sendImageMessage$default(ChatDetailViewModel chatDetailViewModel, Context context, Boolean bool, String str, ChatMessageModel chatMessageModel, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            chatMessageModel = null;
        }
        chatDetailViewModel.sendImageMessage(context, bool, str, chatMessageModel);
    }

    public static /* synthetic */ void sendTextMessage$default(ChatDetailViewModel chatDetailViewModel, Boolean bool, String str, ChatTextType chatTextType, ChatMessageModel chatMessageModel, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            chatTextType = null;
        }
        if ((i10 & 8) != 0) {
            chatMessageModel = null;
        }
        chatDetailViewModel.sendTextMessage(bool, str, chatTextType, chatMessageModel);
    }

    public final void cancelMessage(@NotNull final ChatMessageModel model) {
        s.i(model, "model");
        String itemId = model.getItemId();
        if (itemId == null || itemId.length() == 0) {
            return;
        }
        Disposable disposed = NetworkClient.f11868a.h().c(model.getItemId()).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<CompatResult, p>() { // from class: com.cupidapp.live.chat2.viewmodel.ChatDetailViewModel$cancelMessage$$inlined$handle$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(CompatResult compatResult) {
                m2495invoke(compatResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2495invoke(CompatResult compatResult) {
                ChatMessageModel e2;
                MutableLiveData mutableLiveData;
                CompatResult compatResult2 = compatResult;
                if (compatResult2.getError() == null) {
                    if (s.d(ChatMessageModel.this.getType(), ChatMessageType.InboxMessageText.getValue())) {
                        e2 = g.f13369a.d("你撤回了一条消息", ChatNoticeBtnType.RE_EDIT, ChatMessageModel.this.getText());
                    } else {
                        e2 = g.e(g.f13369a, "你撤回了一条消息", null, null, 6, null);
                    }
                    mutableLiveData = this._cancelMessage;
                    mutableLiveData.setValue(new Pair(ChatMessageModel.this.getItemId(), e2));
                    return;
                }
                Integer error = compatResult2.getError();
                int value = RequestErrorCode.MessageSendTimeoutNotCancel.getValue();
                if (error != null && error.intValue() == value) {
                    h.f12779a.k(R$string.message_can_not_cancel);
                }
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(null, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    public final void changeFocusRelation(final boolean z10) {
        String str;
        x2.a N = NetworkClient.f11868a.N();
        String str2 = this.mOtherUserId;
        if (str2 == null) {
            s.A("mOtherUserId");
            str = null;
        } else {
            str = str2;
        }
        Disposable disposed = a.C0836a.a(N, str, z10, null, 4, null).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<FocusResultModel, p>() { // from class: com.cupidapp.live.chat2.viewmodel.ChatDetailViewModel$changeFocusRelation$$inlined$handle$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(FocusResultModel focusResultModel) {
                m2496invoke(focusResultModel);
                return p.f51048a;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2496invoke(FocusResultModel focusResultModel) {
                MutableLiveData mutableLiveData;
                MutableLiveData mutableLiveData2;
                String str3;
                MutableLiveData mutableLiveData3;
                FocusResultModel focusResultModel2 = focusResultModel;
                mutableLiveData = ChatDetailViewModel.this._otherUser;
                User user = (User) mutableLiveData.getValue();
                if (user != null) {
                    user.setFocus(z10);
                    user.setAloha(focusResultModel2.getAloha());
                    user.setMatch(focusResultModel2.getMatch());
                    mutableLiveData3 = ChatDetailViewModel.this._otherUser;
                    mutableLiveData3.setValue(user);
                }
                mutableLiveData2 = ChatDetailViewModel.this._focusState;
                boolean z11 = z10;
                str3 = ChatDetailViewModel.this.mOtherUserId;
                if (str3 == null) {
                    s.A("mOtherUserId");
                    str3 = null;
                }
                mutableLiveData2.setValue(new Event(new ChatFocusStateData(true, z11, str3, null, null, 24, null)));
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.chat2.viewmodel.ChatDetailViewModel$changeFocusRelation$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable t2) {
                s.i(t2, "t");
                final int value = RequestErrorCode.FocusNoRemains.getValue();
                j jVar = j.f12008a;
                Integer valueOf = Integer.valueOf(value);
                final boolean z11 = z10;
                final ChatDetailViewModel chatDetailViewModel = this;
                j.f(jVar, t2, null, i0.h(f.a(valueOf, new Function1<String, p>() { // from class: com.cupidapp.live.chat2.viewmodel.ChatDetailViewModel$changeFocusRelation$2.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ p invoke(String str3) {
                        invoke2(str3);
                        return p.f51048a;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@Nullable String str3) {
                        String str4;
                        MutableLiveData mutableLiveData;
                        boolean z12 = z11;
                        str4 = chatDetailViewModel.mOtherUserId;
                        if (str4 == null) {
                            s.A("mOtherUserId");
                            str4 = null;
                        }
                        ChatFocusStateData chatFocusStateData = new ChatFocusStateData(false, z12, str4, Integer.valueOf(value), str3);
                        mutableLiveData = chatDetailViewModel._focusState;
                        mutableLiveData.setValue(new Event(chatFocusStateData));
                    }
                })), null, 10, null);
                return Boolean.TRUE;
            }
        }, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    public final void deleteMessage(@NotNull final ChatMessageModel model) {
        s.i(model, "model");
        String itemId = model.getItemId();
        if (itemId == null || itemId.length() == 0) {
            return;
        }
        x1.a h10 = NetworkClient.f11868a.h();
        String itemId2 = model.getItemId();
        String str = this.mSessionId;
        if (str == null) {
            s.A("mSessionId");
            str = null;
        }
        Disposable disposed = h10.v(itemId2, str).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<Object, p>() { // from class: com.cupidapp.live.chat2.viewmodel.ChatDetailViewModel$deleteMessage$$inlined$handle$default$1
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
                mutableLiveData = ChatDetailViewModel.this._deleteMessageByModel;
                mutableLiveData.setValue(model);
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(null, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    public final void destroyMessage(@NotNull final ChatMessageModel model) {
        s.i(model, "model");
        String itemId = model.getItemId();
        if (itemId == null || itemId.length() == 0) {
            return;
        }
        Disposable disposed = NetworkClient.f11868a.h().c(model.getItemId()).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<CompatResult, p>() { // from class: com.cupidapp.live.chat2.viewmodel.ChatDetailViewModel$destroyMessage$$inlined$handle$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(CompatResult compatResult) {
                m2497invoke(compatResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2497invoke(CompatResult compatResult) {
                MutableLiveData mutableLiveData;
                mutableLiveData = ChatDetailViewModel.this._deleteMessageByModel;
                mutableLiveData.setValue(model);
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(null, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    @NotNull
    public final LiveData<Pair<String, ChatMessageModel>> getCancelMessage() {
        return this.cancelMessage;
    }

    @NotNull
    public final LiveData<Event<ChatGuideGrpcModel>> getChatGuide() {
        return this.chatGuide;
    }

    @NotNull
    public final LiveData<ChatMessageModel> getDeleteMessageByModel() {
        return this.deleteMessageByModel;
    }

    @NotNull
    public final LiveData<String> getDeleteMessageByMsgId() {
        return this.deleteMessageByMsgId;
    }

    @NotNull
    public final LiveData<Event<List<ChatMessageModel>>> getFirstScreenHistoryMsg() {
        return this.firstScreenHistoryMsg;
    }

    @NotNull
    public final LiveData<Event<ChatFocusStateData>> getFocusState() {
        return this.focusState;
    }

    @NotNull
    public final LiveData<Boolean> getHasPrivilege() {
        return this.hasPrivilege;
    }

    @NotNull
    public final LiveData<Boolean> getInLiveShow() {
        return this.inLiveShow;
    }

    @NotNull
    public final LiveData<Event<StateResult<List<ChatMessageModel>>>> getMoreHistoryMsg() {
        return this.moreHistoryMsg;
    }

    @NotNull
    public final LiveData<List<ChatMessageModel>> getNewMessage() {
        return this.newMessage;
    }

    @NotNull
    public final LiveData<Event<Boolean>> getNotifyGetNewMessage() {
        return this.notifyGetNewMessage;
    }

    @NotNull
    public final LiveData<Event<List<String>>> getOtherReadMeMessage() {
        return this.otherReadMeMessage;
    }

    @NotNull
    public final LiveData<Event<ChatOtherStoryLabelUiModel>> getOtherStoryLabel() {
        return this.otherStoryLabel;
    }

    @NotNull
    public final LiveData<User> getOtherUser() {
        return this.otherUser;
    }

    @NotNull
    public final LiveData<Pair<Long, ChatMessageModel>> getReplaceMessage() {
        return this.replaceMessage;
    }

    @NotNull
    public final LiveData<String> getSourceDesc() {
        return this.sourceDesc;
    }

    @NotNull
    public final LiveData<Event<List<ZodiacElfInfoModel>>> getZodiacQuestionList() {
        return this.zodiacQuestionList;
    }

    public final void initTargetUserAndOtherInfo(@NotNull ChatBundleData data, @NotNull FKSensorContext sensorContext) {
        s.i(data, "data");
        s.i(sensorContext, "sensorContext");
        this._otherUser.setValue(data.getOtherUser());
        this._isFromStoryLabel.setValue(Boolean.valueOf(data.isFromStoryLabel()));
        this.mOtherUserId = data.getOtherUser().userId();
        this.mSessionId = data.getSessionId();
        this.mOpenChatDetailPopupMillis = System.currentTimeMillis();
        this.mFeedModel = data.getFeedModel();
        this.isLimitTimeSendMsg = data.isLimitTimeSendMsg();
        this.mSensorContext = sensorContext;
    }

    @NotNull
    public final LiveData<Boolean> isFromStoryLabel() {
        return this.isFromStoryLabel;
    }

    public final void loadFirstScreenHistoryMessage(final boolean z10) {
        String str;
        x1.a h10 = NetworkClient.f11868a.h();
        String str2 = this.mSessionId;
        if (str2 == null) {
            s.A("mSessionId");
            str = null;
        } else {
            str = str2;
        }
        Disposable disposed = a.C0835a.a(h10, str, null, null, 0, 14, null).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<ChatMessageResult, p>() { // from class: com.cupidapp.live.chat2.viewmodel.ChatDetailViewModel$loadFirstScreenHistoryMessage$$inlined$handle$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(ChatMessageResult chatMessageResult) {
                m2498invoke(chatMessageResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2498invoke(ChatMessageResult chatMessageResult) {
                MutableLiveData mutableLiveData;
                MutableLiveData mutableLiveData2;
                MutableLiveData mutableLiveData3;
                String str3;
                ChatMessageResult chatMessageResult2 = chatMessageResult;
                ChatDetailViewModel.this.mHistoryCursorId = chatMessageResult2.getNextCursorId();
                mutableLiveData = ChatDetailViewModel.this._firstScreenHistoryMsg;
                mutableLiveData.setValue(new Event(chatMessageResult2.getList()));
                FKStoryLabelItemModel storyLabel = chatMessageResult2.getStoryLabel();
                if (storyLabel != null) {
                    ChatOtherStoryLabelUiModel chatOtherStoryLabelUiModel = new ChatOtherStoryLabelUiModel(storyLabel, chatMessageResult2.getCanEdit(), chatMessageResult2.getInsertTop());
                    mutableLiveData3 = ChatDetailViewModel.this._otherStoryLabel;
                    mutableLiveData3.setValue(new Event(chatOtherStoryLabelUiModel));
                    GroupSocialLog groupSocialLog = GroupSocialLog.f18708a;
                    String id2 = storyLabel.getId();
                    String contentId = storyLabel.getContentId();
                    str3 = ChatDetailViewModel.this.mOtherUserId;
                    if (str3 == null) {
                        s.A("mOtherUserId");
                        str3 = null;
                    }
                    groupSocialLog.X(id2, contentId, str3);
                }
                ChatDetailViewModel.this.mStoryLabelId = z10 ? chatMessageResult2.getLabelId() : null;
                ChatDetailFragment.f13305o.f(chatMessageResult2.getBubble());
                List<ZodiacElfInfoModel> zodiacQuestion = chatMessageResult2.getZodiacQuestion();
                if (zodiacQuestion != null) {
                    mutableLiveData2 = ChatDetailViewModel.this._zodiacQuestionList;
                    mutableLiveData2.setValue(new Event(zodiacQuestion));
                }
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(null, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    public final void loadInboxSessionData() {
        x1.a h10 = NetworkClient.f11868a.h();
        String str = this.mSessionId;
        if (str == null) {
            s.A("mSessionId");
            str = null;
        }
        Disposable disposed = h10.b(str).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<InboxSessionResult, p>() { // from class: com.cupidapp.live.chat2.viewmodel.ChatDetailViewModel$loadInboxSessionData$$inlined$handle$default$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(InboxSessionResult inboxSessionResult) {
                m2499invoke(inboxSessionResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2499invoke(InboxSessionResult inboxSessionResult) {
                MutableLiveData mutableLiveData;
                InboxSessionModel inboxSessionModel;
                MutableLiveData mutableLiveData2;
                MutableLiveData mutableLiveData3;
                MutableLiveData mutableLiveData4;
                InboxSessionResult inboxSessionResult2 = inboxSessionResult;
                List<InboxSessionModel> list = inboxSessionResult2.getList();
                if (list != null && (inboxSessionModel = (InboxSessionModel) CollectionsKt___CollectionsKt.V(list)) != null) {
                    User sender = inboxSessionModel.getSender();
                    if (sender != null) {
                        mutableLiveData4 = ChatDetailViewModel.this._otherUser;
                        mutableLiveData4.setValue(sender);
                    }
                    mutableLiveData2 = ChatDetailViewModel.this._sourceDesc;
                    mutableLiveData2.setValue(inboxSessionModel.getSourceDesc());
                    mutableLiveData3 = ChatDetailViewModel.this._inLiveShow;
                    mutableLiveData3.setValue(Boolean.valueOf(inboxSessionModel.inLiveShow()));
                }
                mutableLiveData = ChatDetailViewModel.this._hasPrivilege;
                mutableLiveData.setValue(inboxSessionResult2.getHasPrivilege());
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(null, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    public final void loadMoreHistoryMessage() {
        String str;
        String str2 = this.mHistoryCursorId;
        if (str2 == null || str2.length() == 0) {
            return;
        }
        this._moreHistoryMsg.setValue(new Event<>(new StateResult.b(null, null, 3, null)));
        x1.a h10 = NetworkClient.f11868a.h();
        String str3 = this.mSessionId;
        if (str3 == null) {
            s.A("mSessionId");
            str = null;
        } else {
            str = str3;
        }
        Disposable disposed = a.C0835a.a(h10, str, this.mHistoryCursorId, null, 0, 12, null).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<ChatMessageResult, p>() { // from class: com.cupidapp.live.chat2.viewmodel.ChatDetailViewModel$loadMoreHistoryMessage$$inlined$handle$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(ChatMessageResult chatMessageResult) {
                m2500invoke(chatMessageResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2500invoke(ChatMessageResult chatMessageResult) {
                MutableLiveData mutableLiveData;
                ChatMessageResult chatMessageResult2 = chatMessageResult;
                ChatDetailViewModel.this.mHistoryCursorId = chatMessageResult2.getNextCursorId();
                List<ChatMessageModel> list = chatMessageResult2.getList();
                if (list == null || list.isEmpty()) {
                    return;
                }
                mutableLiveData = ChatDetailViewModel.this._moreHistoryMsg;
                mutableLiveData.setValue(new Event(new StateResult.c(chatMessageResult2.getList(), null, 2, null)));
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.chat2.viewmodel.ChatDetailViewModel$loadMoreHistoryMessage$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                MutableLiveData mutableLiveData;
                s.i(it, "it");
                mutableLiveData = ChatDetailViewModel.this._moreHistoryMsg;
                mutableLiveData.setValue(new Event(new StateResult.a(null, null, null, 7, null)));
                return Boolean.FALSE;
            }
        }, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    public final void loadNewMsg() {
        this._notifyGetNewMessage.setValue(new Event<>(Boolean.TRUE));
    }

    public final void loadNewestMessage(@Nullable String str) {
        String str2;
        x1.a h10 = NetworkClient.f11868a.h();
        String str3 = this.mSessionId;
        if (str3 == null) {
            s.A("mSessionId");
            str2 = null;
        } else {
            str2 = str3;
        }
        Disposable disposed = a.C0835a.a(h10, str2, null, str, 0, 10, null).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<ChatMessageResult, p>() { // from class: com.cupidapp.live.chat2.viewmodel.ChatDetailViewModel$loadNewestMessage$$inlined$handle$default$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(ChatMessageResult chatMessageResult) {
                m2501invoke(chatMessageResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2501invoke(ChatMessageResult chatMessageResult) {
                MutableLiveData mutableLiveData;
                List<ChatMessageModel> list = chatMessageResult.getList();
                if (list != null) {
                    ArrayList arrayList = new ArrayList();
                    for (ChatMessageModel chatMessageModel : list) {
                        if (!chatMessageModel.getMine()) {
                            arrayList.add(chatMessageModel);
                        }
                    }
                    if (!arrayList.isEmpty()) {
                        mutableLiveData = ChatDetailViewModel.this._newMessage;
                        mutableLiveData.setValue(arrayList);
                    }
                }
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(null, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    public final void meReadOtherMessage(@NotNull ChatMessageModel model) {
        s.i(model, "model");
        String itemId = model.getItemId();
        if (itemId == null || itemId.length() == 0) {
            return;
        }
        x1.a h10 = NetworkClient.f11868a.h();
        String str = this.mSessionId;
        if (str == null) {
            s.A("mSessionId");
            str = null;
        }
        Disposable disposed = h10.h(str, new String[]{model.getItemId()}, true).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<Object, p>() { // from class: com.cupidapp.live.chat2.viewmodel.ChatDetailViewModel$meReadOtherMessage$$inlined$handle$default$1
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

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        GrpcMessageRouter.INSTANCE.removeIGrpcMessageListener(this);
    }

    @Override // com.cupidapp.live.base.grpc.IGrpcMessageListener
    public void onReceiveGrpcMessage(@NotNull CuConnectorOuterClass.MessageType type, @NotNull Object model) {
        s.i(type, "type");
        s.i(model, "model");
        if (type == CuConnectorOuterClass.MessageType.PushMessage) {
            handleChatMsgGrpc(model);
        } else {
            handleChatOtherGrpc(type, model);
        }
    }

    public final void resendMessage(@Nullable Context context, @NotNull ChatMessageModel failModel) {
        s.i(failModel, "failModel");
        String type = failModel.getType();
        if (s.d(type, ChatMessageType.InboxMessageText.getValue())) {
            sendTextMessage$default(this, Boolean.FALSE, null, null, failModel, 4, null);
            return;
        }
        if (s.d(type, ChatMessageType.InboxMessageSnapText.getValue())) {
            sendTextMessage$default(this, Boolean.TRUE, null, null, failModel, 4, null);
        } else if (s.d(type, ChatMessageType.InboxMessageImage.getValue())) {
            sendImageMessage(context, Boolean.FALSE, failModel.getImagePath(), failModel);
        } else if (s.d(type, ChatMessageType.InboxMessageSnapImage.getValue())) {
            sendImageMessage(context, Boolean.TRUE, failModel.getImagePath(), failModel);
        }
    }

    public final void sendImageMessage(@Nullable Context context, @Nullable final Boolean bool, @Nullable String str, @Nullable ChatMessageModel chatMessageModel) {
        ChatMessageModel chatMessageModel2;
        MsgType msgType;
        String str2;
        Observable<Result<ChatMessageResult>> e2;
        String str3;
        if (str == null || str.length() == 0) {
            return;
        }
        if (chatMessageModel == null) {
            insertPostRefererTipMessage();
            insertStoryLabelTipMessage();
            ChatMessageModel c4 = g.f13369a.c(bool, str);
            this._newMessage.setValue(r.e(c4));
            chatMessageModel2 = c4;
        } else {
            chatMessageModel2 = chatMessageModel;
        }
        File file = new File(str);
        this.uploadStartTime = System.currentTimeMillis();
        final long a10 = l.a(file);
        ImageAttributeModel l10 = z0.f.l(context, str);
        final int width = l10.getWidth();
        final int height = l10.getHeight();
        MultipartBody.Part createFormData = MultipartBody.Part.Companion.createFormData(Attributes.Component.IMAGE, file.getName(), com.cupidapp.live.base.network.f.a(file));
        if (s.d(bool, Boolean.TRUE)) {
            msgType = MsgType.SNAP_PICTURE;
            x1.a h10 = NetworkClient.f11868a.h();
            String str4 = this.mOtherUserId;
            if (str4 == null) {
                s.A("mOtherUserId");
                str3 = null;
            } else {
                str3 = str4;
            }
            FeedModel feedModel = this.mFeedModel;
            e2 = h10.d(createFormData, str3, 10, feedModel != null ? feedModel.getPostId() : null, Long.valueOf(getPopupMillis()), this.mStoryLabelId);
        } else {
            msgType = MsgType.PICTURE;
            x1.a h11 = NetworkClient.f11868a.h();
            String str5 = this.mOtherUserId;
            if (str5 == null) {
                s.A("mOtherUserId");
                str2 = null;
            } else {
                str2 = str5;
            }
            FeedModel feedModel2 = this.mFeedModel;
            e2 = h11.e(createFormData, str2, feedModel2 != null ? feedModel2.getPostId() : null, Long.valueOf(getPopupMillis()), this.mStoryLabelId);
        }
        final MsgType msgType2 = msgType;
        Observable<Result<ChatMessageResult>> observable = e2;
        final ChatMessageModel chatMessageModel3 = chatMessageModel2;
        final ChatMessageModel chatMessageModel4 = chatMessageModel2;
        Disposable disposed = observable.flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<ChatMessageResult, p>() { // from class: com.cupidapp.live.chat2.viewmodel.ChatDetailViewModel$sendImageMessage$$inlined$handle$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(ChatMessageResult chatMessageResult) {
                m2502invoke(chatMessageResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2502invoke(ChatMessageResult chatMessageResult) {
                MutableLiveData mutableLiveData;
                ChatMessageResult chatMessageResult2 = chatMessageResult;
                List<ChatMessageModel> list = chatMessageResult2.getList();
                if (!(list == null || list.isEmpty())) {
                    mutableLiveData = ChatDetailViewModel.this._replaceMessage;
                    mutableLiveData.setValue(new Pair(Long.valueOf(chatMessageModel4.getCreateTimeMillis()), chatMessageResult2.getList().get(0)));
                }
                ChatDetailViewModel.this.reportUploadFilesLog(bool, a10, width, height, null);
                ChatDetailViewModel.this.reportSendMessageLog(msgType2, null);
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.chat2.viewmodel.ChatDetailViewModel$sendImageMessage$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                MutableLiveData mutableLiveData;
                boolean isStopDefaultErrorHandler;
                s.i(it, "it");
                ChatMessageModel k10 = g.f13369a.k(ChatMessageModel.this);
                mutableLiveData = this._replaceMessage;
                mutableLiveData.setValue(new Pair(Long.valueOf(ChatMessageModel.this.getCreateTimeMillis()), k10));
                this.insertSendMsgFailErrorNotice(it);
                String c10 = j.c(j.f12008a, it, false, 2, null);
                this.reportUploadFilesLog(bool, a10, width, height, it);
                this.reportSendMessageLog(msgType2, c10);
                isStopDefaultErrorHandler = this.isStopDefaultErrorHandler(it);
                return Boolean.valueOf(isStopDefaultErrorHandler);
            }
        }, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x002f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0019  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x000f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void sendTextMessage(@org.jetbrains.annotations.Nullable java.lang.Boolean r9, @org.jetbrains.annotations.Nullable java.lang.String r10, @org.jetbrains.annotations.Nullable com.cupidapp.live.chat2.model.ChatTextType r11, @org.jetbrains.annotations.Nullable final com.cupidapp.live.chat2.model.ChatMessageModel r12) {
        /*
            Method dump skipped, instructions count: 255
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.chat2.viewmodel.ChatDetailViewModel.sendTextMessage(java.lang.Boolean, java.lang.String, com.cupidapp.live.chat2.model.ChatTextType, com.cupidapp.live.chat2.model.ChatMessageModel):void");
    }

    public final void updateOtherUserInfo(@NotNull User user) {
        s.i(user, "user");
        User value = this._otherUser.getValue();
        if (value != null) {
            value.setFocus(user.getFocus());
            value.setSuperLikedByMe(user.getSuperLikedByMe());
            value.setSuperLikedByMeCombos(user.getSuperLikedByMeCombos());
            value.setSuperLikedMe(user.getSuperLikedMe());
            value.setSuperLikedMeCombos(user.getSuperLikedMeCombos());
            value.setAloha(user.getAloha());
            value.setAlohaGet(user.getAlohaGet());
            value.setMatch(user.getMatch());
            value.setBlock(user.getBlock());
            value.setCloseFriend(user.getCloseFriend());
            this._otherUser.setValue(value);
        }
        this._inLiveShow.setValue(Boolean.valueOf(user.getOnlineShowOpen()));
    }

    public final void youScreenCaptureOfSnapMessage(@Nullable ChatMessageModel chatMessageModel) {
        if (chatMessageModel == null) {
            x1.a h10 = NetworkClient.f11868a.h();
            String str = this.mOtherUserId;
            if (str == null) {
                s.A("mOtherUserId");
                str = null;
            }
            Disposable disposed = h10.t(str).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<ChatMessageResult, p>() { // from class: com.cupidapp.live.chat2.viewmodel.ChatDetailViewModel$youScreenCaptureOfSnapMessage$$inlined$handle$default$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(ChatMessageResult chatMessageResult) {
                    m2504invoke(chatMessageResult);
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m2504invoke(ChatMessageResult chatMessageResult) {
                    ChatMessageModel chatMessageModel2;
                    MutableLiveData mutableLiveData;
                    List<ChatMessageModel> list = chatMessageResult.getList();
                    if (list == null || (chatMessageModel2 = (ChatMessageModel) CollectionsKt___CollectionsKt.V(list)) == null) {
                        return;
                    }
                    mutableLiveData = ChatDetailViewModel.this._newMessage;
                    mutableLiveData.setValue(r.e(chatMessageModel2));
                }
            }), new e(new ObservableExtensionKt$handle$disposed$2(null, null)));
            if (disposed != null) {
                s.h(disposed, "disposed");
            }
            s.h(disposed, "disposed");
            return;
        }
        this._newMessage.setValue(r.e(chatMessageModel));
    }
}

package com.cupidapp.live.club.viewmodel;

import a2.a;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.grpc.CuConnectorOuterClass;
import com.cupidapp.live.base.grpc.GrpcMessageRouter;
import com.cupidapp.live.base.grpc.IGrpcMessageListener;
import com.cupidapp.live.base.livedata.Event;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.RequestErrorCode;
import com.cupidapp.live.base.network.ResultShowErrorStyle;
import com.cupidapp.live.base.network.j;
import com.cupidapp.live.base.network.model.Result;
import com.cupidapp.live.base.network.model.StateResult;
import com.cupidapp.live.chat2.model.ChatNoticeBtnType;
import com.cupidapp.live.club.model.BaseClubChatConnectorMessageModel;
import com.cupidapp.live.club.model.ClubCancelMsgData;
import com.cupidapp.live.club.model.ClubChatMessageType;
import com.cupidapp.live.club.model.ClubChatMsgModel;
import com.cupidapp.live.club.model.ClubChatMsgResult;
import com.cupidapp.live.club.model.ClubInfoAndMsgResult;
import com.cupidapp.live.club.model.ClubInfoDetailModel;
import com.cupidapp.live.club.model.ClubMessageCancelConnectorMessageModel;
import com.cupidapp.live.club.model.ClubNewMessageConnectorMessageModel;
import com.cupidapp.live.club.model.ClubTopMsgConnectorMessageModel;
import com.cupidapp.live.club.model.QuoteInfoModel;
import com.cupidapp.live.profile.model.CompatResult;
import com.huawei.quickcard.base.Attributes;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.r;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import okhttp3.MultipartBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ClubChatRoomViewModel.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ClubChatRoomViewModel extends ViewModel implements IGrpcMessageListener {

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final int ONE_PAGE_MESSAGE_COUNT = 21;

    @NotNull
    private final MutableLiveData<ClubCancelMsgData> _cancelMessage;

    @NotNull
    private final MutableLiveData<ClubInfoDetailModel> _clubInfo;

    @NotNull
    private final MutableLiveData<ClubChatMsgModel> _deleteMessage;

    @NotNull
    private final MutableLiveData<StateResult<List<ClubChatMsgModel>>> _firstPageUnreadMessageLiveData;

    @NotNull
    private final MutableLiveData<Event<ClubChatMsgResult>> _firstScreenHistoryMsg;

    @NotNull
    private final MutableLiveData<List<ClubChatMsgModel>> _latestNewMessageLiveData;

    @NotNull
    private final MutableLiveData<Event<StateResult<List<ClubChatMsgModel>>>> _moreHistoryMsg;

    @NotNull
    private final MutableLiveData<StateResult<List<ClubChatMsgModel>>> _moreUnreadMessageLiveData;

    @NotNull
    private final MutableLiveData<Event<Boolean>> _newEnterRequest;

    @NotNull
    private final MutableLiveData<List<ClubChatMsgModel>> _newMessage;

    @NotNull
    private final MutableLiveData<Event<Boolean>> _notifyGetNewMessage;

    @NotNull
    private final MutableLiveData<Pair<Long, ClubChatMsgModel>> _replaceMessage;

    @NotNull
    private final MutableLiveData<Event<String>> _topMessage;

    @NotNull
    private final LiveData<ClubCancelMsgData> cancelMessage;

    @NotNull
    private final LiveData<ClubInfoDetailModel> clubInfo;

    @NotNull
    private final LiveData<ClubChatMsgModel> deleteMessage;

    @NotNull
    private final LiveData<StateResult<List<ClubChatMsgModel>>> firstPageUnreadMessageLiveData;

    @NotNull
    private final LiveData<Event<ClubChatMsgResult>> firstScreenHistoryMsg;

    @NotNull
    private final LiveData<List<ClubChatMsgModel>> latestNewMessageLiveData;
    private String mClubId;

    @Nullable
    private ClubInfoDetailModel mClubInfo;

    @Nullable
    private Disposable mClubInfoAndMsgDispose;

    @Nullable
    private String mFirstUnreadMsgId;

    @Nullable
    private String mHistoryCursorId;

    @Nullable
    private String mUnreadCursorId;

    @NotNull
    private final LiveData<Event<StateResult<List<ClubChatMsgModel>>>> moreHistoryMsg;

    @NotNull
    private final LiveData<StateResult<List<ClubChatMsgModel>>> moreUnreadMessageEventLiveData;

    @NotNull
    private final LiveData<Event<Boolean>> newEnterRequest;

    @NotNull
    private final LiveData<List<ClubChatMsgModel>> newMessage;

    @NotNull
    private final LiveData<Event<Boolean>> notifyGetNewMessage;

    @NotNull
    private final LiveData<Pair<Long, ClubChatMsgModel>> replaceMessage;

    @NotNull
    private final LiveData<Event<String>> topMessage;

    /* compiled from: ClubChatRoomViewModel.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: ClubChatRoomViewModel.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public /* synthetic */ class a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f13704a;

        static {
            int[] iArr = new int[CuConnectorOuterClass.MessageType.values().length];
            try {
                iArr[CuConnectorOuterClass.MessageType.GroupMessageNew.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CuConnectorOuterClass.MessageType.GroupMessageCancel.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CuConnectorOuterClass.MessageType.GroupMessageTop.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[CuConnectorOuterClass.MessageType.GroupApplySubmit.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f13704a = iArr;
        }
    }

    public ClubChatRoomViewModel() {
        GrpcMessageRouter.INSTANCE.addIGrpcMessageListener(this);
        MutableLiveData<Event<ClubChatMsgResult>> mutableLiveData = new MutableLiveData<>();
        this._firstScreenHistoryMsg = mutableLiveData;
        this.firstScreenHistoryMsg = mutableLiveData;
        MutableLiveData<Event<StateResult<List<ClubChatMsgModel>>>> mutableLiveData2 = new MutableLiveData<>();
        this._moreHistoryMsg = mutableLiveData2;
        this.moreHistoryMsg = mutableLiveData2;
        MutableLiveData<List<ClubChatMsgModel>> mutableLiveData3 = new MutableLiveData<>();
        this._newMessage = mutableLiveData3;
        this.newMessage = mutableLiveData3;
        MutableLiveData<Pair<Long, ClubChatMsgModel>> mutableLiveData4 = new MutableLiveData<>();
        this._replaceMessage = mutableLiveData4;
        this.replaceMessage = mutableLiveData4;
        MutableLiveData<ClubCancelMsgData> mutableLiveData5 = new MutableLiveData<>();
        this._cancelMessage = mutableLiveData5;
        this.cancelMessage = mutableLiveData5;
        MutableLiveData<ClubChatMsgModel> mutableLiveData6 = new MutableLiveData<>();
        this._deleteMessage = mutableLiveData6;
        this.deleteMessage = mutableLiveData6;
        MutableLiveData<Event<Boolean>> mutableLiveData7 = new MutableLiveData<>();
        this._notifyGetNewMessage = mutableLiveData7;
        this.notifyGetNewMessage = mutableLiveData7;
        MutableLiveData<Event<String>> mutableLiveData8 = new MutableLiveData<>();
        this._topMessage = mutableLiveData8;
        this.topMessage = mutableLiveData8;
        MutableLiveData<ClubInfoDetailModel> mutableLiveData9 = new MutableLiveData<>();
        this._clubInfo = mutableLiveData9;
        this.clubInfo = mutableLiveData9;
        MutableLiveData<Event<Boolean>> mutableLiveData10 = new MutableLiveData<>();
        this._newEnterRequest = mutableLiveData10;
        this.newEnterRequest = mutableLiveData10;
        MutableLiveData<StateResult<List<ClubChatMsgModel>>> mutableLiveData11 = new MutableLiveData<>();
        this._firstPageUnreadMessageLiveData = mutableLiveData11;
        this.firstPageUnreadMessageLiveData = mutableLiveData11;
        MutableLiveData<StateResult<List<ClubChatMsgModel>>> mutableLiveData12 = new MutableLiveData<>();
        this._moreUnreadMessageLiveData = mutableLiveData12;
        this.moreUnreadMessageEventLiveData = mutableLiveData12;
        MutableLiveData<List<ClubChatMsgModel>> mutableLiveData13 = new MutableLiveData<>();
        this._latestNewMessageLiveData = mutableLiveData13;
        this.latestNewMessageLiveData = mutableLiveData13;
    }

    public final void configClubInfo(ClubInfoDetailModel clubInfoDetailModel) {
        this.mClubInfo = clubInfoDetailModel;
        this._clubInfo.setValue(clubInfoDetailModel);
        this._topMessage.setValue(new Event<>(clubInfoDetailModel.getAnnounce()));
    }

    public final boolean filterInsertNewMessage(ClubChatMsgModel clubChatMsgModel) {
        return !clubChatMsgModel.getMine() || (clubChatMsgModel.getMine() && s.d(clubChatMsgModel.getAddList(), Boolean.TRUE));
    }

    public final String getFirstHistoryMsgId(List<ClubChatMsgModel> list) {
        ClubChatMsgModel clubChatMsgModel;
        if ((list != null ? list.size() : 0) < 21 || list == null || (clubChatMsgModel = (ClubChatMsgModel) CollectionsKt___CollectionsKt.T(list)) == null) {
            return null;
        }
        return clubChatMsgModel.getMessageId();
    }

    public final String getLastUnreadMessageId(List<ClubChatMsgModel> list) {
        ClubChatMsgModel clubChatMsgModel;
        if ((list != null ? list.size() : 0) < 21 || list == null || (clubChatMsgModel = (ClubChatMsgModel) CollectionsKt___CollectionsKt.e0(list)) == null) {
            return null;
        }
        return clubChatMsgModel.getMessageId();
    }

    private final Observable<Result<ClubChatMsgModel>> getSendMsg(String str, String str2, String str3) {
        String str4 = null;
        if (str2 == null || str2.length() == 0) {
            a2.a u10 = NetworkClient.f11868a.u();
            String str5 = this.mClubId;
            if (str5 == null) {
                s.A("mClubId");
            } else {
                str4 = str5;
            }
            return u10.o(str4, str, str3);
        }
        a2.a u11 = NetworkClient.f11868a.u();
        String str6 = this.mClubId;
        if (str6 == null) {
            s.A("mClubId");
        } else {
            str4 = str6;
        }
        return u11.x(str4, str, str2, str3);
    }

    public final void insertSendMsgFailErrorNotice(Throwable th) {
        String b4 = j.f12008a.b(th, false);
        if (b4 == null || b4.length() == 0) {
            return;
        }
        this._newMessage.setValue(r.e(com.cupidapp.live.club.helper.a.c(com.cupidapp.live.club.helper.a.f13611a, b4, null, null, 6, null)));
    }

    public final boolean isStopDefaultErrorHandler(Throwable th) {
        ResultShowErrorStyle d10 = j.f12008a.d(th);
        return d10 == ResultShowErrorStyle.ALERT || d10 == ResultShowErrorStyle.TOAST;
    }

    public static final Result loadFirstScreenHistoryMsg$lambda$1(Function1 tmp0, Object obj) {
        s.i(tmp0, "$tmp0");
        return (Result) tmp0.invoke(obj);
    }

    public static final Result loadFirstScreenHistoryMsg$lambda$2(Function1 tmp0, Object obj) {
        s.i(tmp0, "$tmp0");
        return (Result) tmp0.invoke(obj);
    }

    public static final ClubInfoAndMsgResult loadFirstScreenHistoryMsg$lambda$3(Result detailModel, Result msgResult) {
        s.i(detailModel, "detailModel");
        s.i(msgResult, "msgResult");
        return new ClubInfoAndMsgResult((ClubInfoDetailModel) detailModel.getData(), (ClubChatMsgResult) msgResult.getData());
    }

    public static final void loadFirstScreenHistoryMsg$lambda$4(Function1 tmp0, Object obj) {
        s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void loadFirstScreenHistoryMsg$lambda$5(Function1 tmp0, Object obj) {
        s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static /* synthetic */ void sendImageMessage$default(ClubChatRoomViewModel clubChatRoomViewModel, String str, ClubChatMsgModel clubChatMsgModel, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            clubChatMsgModel = null;
        }
        clubChatRoomViewModel.sendImageMessage(str, clubChatMsgModel);
    }

    public static /* synthetic */ void sendTextMessage$default(ClubChatRoomViewModel clubChatRoomViewModel, String str, ClubChatMsgModel clubChatMsgModel, String str2, ClubChatMsgModel clubChatMsgModel2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            clubChatMsgModel = null;
        }
        if ((i10 & 4) != 0) {
            str2 = null;
        }
        if ((i10 & 8) != 0) {
            clubChatMsgModel2 = null;
        }
        clubChatRoomViewModel.sendTextMessage(str, clubChatMsgModel, str2, clubChatMsgModel2);
    }

    public final boolean canLoadMoreUnread() {
        String str = this.mUnreadCursorId;
        return !(str == null || str.length() == 0);
    }

    public final void cancelMessage(@NotNull final ClubChatMsgModel model) {
        s.i(model, "model");
        final String messageId = model.getMessageId();
        if (messageId == null || messageId.length() == 0) {
            return;
        }
        a2.a u10 = NetworkClient.f11868a.u();
        String str = this.mClubId;
        if (str == null) {
            s.A("mClubId");
            str = null;
        }
        Disposable disposed = u10.t(str, messageId).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<CompatResult, p>() { // from class: com.cupidapp.live.club.viewmodel.ClubChatRoomViewModel$cancelMessage$$inlined$handle$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(CompatResult compatResult) {
                m2516invoke(compatResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2516invoke(CompatResult compatResult) {
                ClubChatMsgModel c4;
                MutableLiveData mutableLiveData;
                CompatResult compatResult2 = compatResult;
                if (compatResult2.getError() == null) {
                    if (s.d(ClubChatMsgModel.this.getType(), ClubChatMessageType.InboxMessageText.getValue())) {
                        c4 = com.cupidapp.live.club.helper.a.f13611a.b("你撤回了一条消息", ChatNoticeBtnType.RE_EDIT, ClubChatMsgModel.this.getText());
                    } else {
                        c4 = com.cupidapp.live.club.helper.a.c(com.cupidapp.live.club.helper.a.f13611a, "你撤回了一条消息", null, null, 6, null);
                    }
                    mutableLiveData = this._cancelMessage;
                    mutableLiveData.setValue(new ClubCancelMsgData(messageId, c4, true));
                    return;
                }
                Integer error = compatResult2.getError();
                int value = RequestErrorCode.MessageSendTimeoutNotCancel.getValue();
                if (error != null && error.intValue() == value) {
                    com.cupidapp.live.base.view.h.f12779a.k(R$string.message_can_not_cancel);
                }
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    public final void deleteMessage(@NotNull final ClubChatMsgModel model) {
        s.i(model, "model");
        String messageId = model.getMessageId();
        if (messageId == null || messageId.length() == 0) {
            return;
        }
        a2.a u10 = NetworkClient.f11868a.u();
        String str = this.mClubId;
        if (str == null) {
            s.A("mClubId");
            str = null;
        }
        Disposable disposed = u10.e(str, model.getMessageId()).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<Object, p>() { // from class: com.cupidapp.live.club.viewmodel.ClubChatRoomViewModel$deleteMessage$$inlined$handle$default$1
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
                mutableLiveData = ClubChatRoomViewModel.this._deleteMessage;
                mutableLiveData.setValue(model);
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    @NotNull
    public final LiveData<ClubCancelMsgData> getCancelMessage() {
        return this.cancelMessage;
    }

    @NotNull
    public final LiveData<ClubInfoDetailModel> getClubInfo() {
        return this.clubInfo;
    }

    @NotNull
    public final LiveData<ClubChatMsgModel> getDeleteMessage() {
        return this.deleteMessage;
    }

    @NotNull
    public final LiveData<StateResult<List<ClubChatMsgModel>>> getFirstPageUnreadMessageLiveData() {
        return this.firstPageUnreadMessageLiveData;
    }

    @NotNull
    public final LiveData<Event<ClubChatMsgResult>> getFirstScreenHistoryMsg() {
        return this.firstScreenHistoryMsg;
    }

    @Nullable
    public final String getFirstUnreadMsgId() {
        return this.mFirstUnreadMsgId;
    }

    @NotNull
    public final LiveData<List<ClubChatMsgModel>> getLatestNewMessageLiveData() {
        return this.latestNewMessageLiveData;
    }

    @NotNull
    public final LiveData<Event<StateResult<List<ClubChatMsgModel>>>> getMoreHistoryMsg() {
        return this.moreHistoryMsg;
    }

    @NotNull
    public final LiveData<StateResult<List<ClubChatMsgModel>>> getMoreUnreadMessageEventLiveData() {
        return this.moreUnreadMessageEventLiveData;
    }

    @NotNull
    public final LiveData<Event<Boolean>> getNewEnterRequest() {
        return this.newEnterRequest;
    }

    @NotNull
    public final LiveData<List<ClubChatMsgModel>> getNewMessage() {
        return this.newMessage;
    }

    @NotNull
    public final LiveData<Event<Boolean>> getNotifyGetNewMessage() {
        return this.notifyGetNewMessage;
    }

    @NotNull
    public final LiveData<Pair<Long, ClubChatMsgModel>> getReplaceMessage() {
        return this.replaceMessage;
    }

    @NotNull
    public final LiveData<Event<String>> getTopMessage() {
        return this.topMessage;
    }

    public final void initClubInfo(@NotNull String clubId) {
        s.i(clubId, "clubId");
        this.mClubId = clubId;
    }

    public final void loadClubInfo() {
        a2.a u10 = NetworkClient.f11868a.u();
        String str = this.mClubId;
        if (str == null) {
            s.A("mClubId");
            str = null;
        }
        Disposable disposed = u10.c(str).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<ClubInfoDetailModel, p>() { // from class: com.cupidapp.live.club.viewmodel.ClubChatRoomViewModel$loadClubInfo$$inlined$handle$default$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(ClubInfoDetailModel clubInfoDetailModel) {
                m2517invoke(clubInfoDetailModel);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2517invoke(ClubInfoDetailModel clubInfoDetailModel) {
                ClubChatRoomViewModel.this.configClubInfo(clubInfoDetailModel);
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    public final void loadFirstPageUnreadMessage() {
        String str;
        String str2 = this.mFirstUnreadMsgId;
        if (str2 == null || str2.length() == 0) {
            this._firstPageUnreadMessageLiveData.setValue(new StateResult.a(null, null, null, 7, null));
            return;
        }
        this._firstPageUnreadMessageLiveData.setValue(new StateResult.b(null, null, 3, null));
        a2.a u10 = NetworkClient.f11868a.u();
        String str3 = this.mClubId;
        if (str3 == null) {
            s.A("mClubId");
            str = null;
        } else {
            str = str3;
        }
        Disposable disposed = a.C0010a.b(u10, str, this.mFirstUnreadMsgId, null, 0, true, 12, null).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<ClubChatMsgResult, p>() { // from class: com.cupidapp.live.club.viewmodel.ClubChatRoomViewModel$loadFirstPageUnreadMessage$$inlined$handle$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(ClubChatMsgResult clubChatMsgResult) {
                m2518invoke(clubChatMsgResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2518invoke(ClubChatMsgResult clubChatMsgResult) {
                String firstHistoryMsgId;
                String lastUnreadMessageId;
                MutableLiveData mutableLiveData;
                ClubChatMsgResult clubChatMsgResult2 = clubChatMsgResult;
                ClubChatRoomViewModel clubChatRoomViewModel = ClubChatRoomViewModel.this;
                firstHistoryMsgId = clubChatRoomViewModel.getFirstHistoryMsgId(clubChatMsgResult2.getList());
                clubChatRoomViewModel.mHistoryCursorId = firstHistoryMsgId;
                ClubChatRoomViewModel clubChatRoomViewModel2 = ClubChatRoomViewModel.this;
                lastUnreadMessageId = clubChatRoomViewModel2.getLastUnreadMessageId(clubChatMsgResult2.getList());
                clubChatRoomViewModel2.mUnreadCursorId = lastUnreadMessageId;
                mutableLiveData = ClubChatRoomViewModel.this._firstPageUnreadMessageLiveData;
                mutableLiveData.setValue(new StateResult.c(clubChatMsgResult2.getList(), null, 2, null));
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.club.viewmodel.ClubChatRoomViewModel$loadFirstPageUnreadMessage$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                MutableLiveData mutableLiveData;
                s.i(it, "it");
                mutableLiveData = ClubChatRoomViewModel.this._firstPageUnreadMessageLiveData;
                mutableLiveData.setValue(new StateResult.a(null, null, null, 7, null));
                return Boolean.FALSE;
            }
        }, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    public final void loadFirstScreenHistoryMsg() {
        String str;
        NetworkClient networkClient = NetworkClient.f11868a;
        a2.a u10 = networkClient.u();
        String str2 = this.mClubId;
        if (str2 == null) {
            s.A("mClubId");
            str2 = null;
        }
        Observable<Result<ClubInfoDetailModel>> c4 = u10.c(str2);
        final ClubChatRoomViewModel$loadFirstScreenHistoryMsg$clubInfoApi$1 clubChatRoomViewModel$loadFirstScreenHistoryMsg$clubInfoApi$1 = new Function1<Throwable, Result<? extends ClubInfoDetailModel>>() { // from class: com.cupidapp.live.club.viewmodel.ClubChatRoomViewModel$loadFirstScreenHistoryMsg$clubInfoApi$1
            @Override // kotlin.jvm.functions.Function1
            public final Result<ClubInfoDetailModel> invoke(@NotNull Throwable it) {
                s.i(it, "it");
                return new Result<>(null, false, null, null, null, null, null, 127, null);
            }
        };
        Observable<Result<ClubInfoDetailModel>> onErrorReturn = c4.onErrorReturn(new Function() { // from class: com.cupidapp.live.club.viewmodel.e
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Result loadFirstScreenHistoryMsg$lambda$1;
                loadFirstScreenHistoryMsg$lambda$1 = ClubChatRoomViewModel.loadFirstScreenHistoryMsg$lambda$1(Function1.this, obj);
                return loadFirstScreenHistoryMsg$lambda$1;
            }
        });
        a2.a u11 = networkClient.u();
        String str3 = this.mClubId;
        if (str3 == null) {
            s.A("mClubId");
            str = null;
        } else {
            str = str3;
        }
        Observable b4 = a.C0010a.b(u11, str, null, null, 0, false, 30, null);
        final ClubChatRoomViewModel$loadFirstScreenHistoryMsg$chatMsgApi$1 clubChatRoomViewModel$loadFirstScreenHistoryMsg$chatMsgApi$1 = new Function1<Throwable, Result<? extends ClubChatMsgResult>>() { // from class: com.cupidapp.live.club.viewmodel.ClubChatRoomViewModel$loadFirstScreenHistoryMsg$chatMsgApi$1
            @Override // kotlin.jvm.functions.Function1
            public final Result<ClubChatMsgResult> invoke(@NotNull Throwable it) {
                s.i(it, "it");
                return new Result<>(null, false, null, null, null, null, null, 127, null);
            }
        };
        Observable observeOn = Observable.zip(onErrorReturn, b4.onErrorReturn(new Function() { // from class: com.cupidapp.live.club.viewmodel.d
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Result loadFirstScreenHistoryMsg$lambda$2;
                loadFirstScreenHistoryMsg$lambda$2 = ClubChatRoomViewModel.loadFirstScreenHistoryMsg$lambda$2(Function1.this, obj);
                return loadFirstScreenHistoryMsg$lambda$2;
            }
        }), new BiFunction() { // from class: com.cupidapp.live.club.viewmodel.a
            @Override // io.reactivex.functions.BiFunction
            public final Object apply(Object obj, Object obj2) {
                ClubInfoAndMsgResult loadFirstScreenHistoryMsg$lambda$3;
                loadFirstScreenHistoryMsg$lambda$3 = ClubChatRoomViewModel.loadFirstScreenHistoryMsg$lambda$3((Result) obj, (Result) obj2);
                return loadFirstScreenHistoryMsg$lambda$3;
            }
        }).observeOn(AndroidSchedulers.mainThread());
        final Function1<ClubInfoAndMsgResult, p> function1 = new Function1<ClubInfoAndMsgResult, p>() { // from class: com.cupidapp.live.club.viewmodel.ClubChatRoomViewModel$loadFirstScreenHistoryMsg$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(ClubInfoAndMsgResult clubInfoAndMsgResult) {
                invoke2(clubInfoAndMsgResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ClubInfoAndMsgResult clubInfoAndMsgResult) {
                String firstHistoryMsgId;
                MutableLiveData mutableLiveData;
                if (clubInfoAndMsgResult.getClubInfo() != null) {
                    ClubChatRoomViewModel.this.configClubInfo(clubInfoAndMsgResult.getClubInfo());
                }
                ClubChatMsgResult chatMsg = clubInfoAndMsgResult.getChatMsg();
                if (chatMsg != null) {
                    ClubChatRoomViewModel clubChatRoomViewModel = ClubChatRoomViewModel.this;
                    firstHistoryMsgId = clubChatRoomViewModel.getFirstHistoryMsgId(chatMsg.getList());
                    clubChatRoomViewModel.mHistoryCursorId = firstHistoryMsgId;
                    ClubChatRoomViewModel.this.mFirstUnreadMsgId = chatMsg.getFirstUnreadMsgId();
                    mutableLiveData = ClubChatRoomViewModel.this._firstScreenHistoryMsg;
                    mutableLiveData.setValue(new Event(chatMsg));
                }
            }
        };
        Consumer consumer = new Consumer() { // from class: com.cupidapp.live.club.viewmodel.c
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ClubChatRoomViewModel.loadFirstScreenHistoryMsg$lambda$4(Function1.this, obj);
            }
        };
        final ClubChatRoomViewModel$loadFirstScreenHistoryMsg$3 clubChatRoomViewModel$loadFirstScreenHistoryMsg$3 = new Function1<Throwable, p>() { // from class: com.cupidapp.live.club.viewmodel.ClubChatRoomViewModel$loadFirstScreenHistoryMsg$3
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Throwable th) {
                invoke2(th);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable it) {
                j jVar = j.f12008a;
                s.h(it, "it");
                j.f(jVar, it, null, null, null, 14, null);
            }
        };
        this.mClubInfoAndMsgDispose = observeOn.subscribe(consumer, new Consumer() { // from class: com.cupidapp.live.club.viewmodel.b
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ClubChatRoomViewModel.loadFirstScreenHistoryMsg$lambda$5(Function1.this, obj);
            }
        });
    }

    public final void loadLatestNewMessage() {
        String str;
        a2.a u10 = NetworkClient.f11868a.u();
        String str2 = this.mClubId;
        if (str2 == null) {
            s.A("mClubId");
            str = null;
        } else {
            str = str2;
        }
        Disposable disposed = a.C0010a.b(u10, str, null, null, 0, false, 30, null).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<ClubChatMsgResult, p>() { // from class: com.cupidapp.live.club.viewmodel.ClubChatRoomViewModel$loadLatestNewMessage$$inlined$handle$default$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(ClubChatMsgResult clubChatMsgResult) {
                m2519invoke(clubChatMsgResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2519invoke(ClubChatMsgResult clubChatMsgResult) {
                String firstHistoryMsgId;
                MutableLiveData mutableLiveData;
                ClubChatMsgResult clubChatMsgResult2 = clubChatMsgResult;
                ClubChatRoomViewModel clubChatRoomViewModel = ClubChatRoomViewModel.this;
                firstHistoryMsgId = clubChatRoomViewModel.getFirstHistoryMsgId(clubChatMsgResult2.getList());
                clubChatRoomViewModel.mHistoryCursorId = firstHistoryMsgId;
                ClubChatRoomViewModel.this.mUnreadCursorId = null;
                mutableLiveData = ClubChatRoomViewModel.this._latestNewMessageLiveData;
                mutableLiveData.setValue(clubChatMsgResult2.getList());
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    public final void loadMoreHistoryMessage() {
        String str;
        String str2 = this.mHistoryCursorId;
        if (str2 == null || str2.length() == 0) {
            this._moreHistoryMsg.setValue(new Event<>(new StateResult.a(null, null, null, 7, null)));
            return;
        }
        this._moreHistoryMsg.setValue(new Event<>(new StateResult.b(null, null, 3, null)));
        a2.a u10 = NetworkClient.f11868a.u();
        String str3 = this.mClubId;
        if (str3 == null) {
            s.A("mClubId");
            str = null;
        } else {
            str = str3;
        }
        Disposable disposed = a.C0010a.b(u10, str, this.mHistoryCursorId, null, 0, false, 28, null).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<ClubChatMsgResult, p>() { // from class: com.cupidapp.live.club.viewmodel.ClubChatRoomViewModel$loadMoreHistoryMessage$$inlined$handle$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(ClubChatMsgResult clubChatMsgResult) {
                m2520invoke(clubChatMsgResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2520invoke(ClubChatMsgResult clubChatMsgResult) {
                String firstHistoryMsgId;
                MutableLiveData mutableLiveData;
                ClubChatMsgResult clubChatMsgResult2 = clubChatMsgResult;
                ClubChatRoomViewModel clubChatRoomViewModel = ClubChatRoomViewModel.this;
                firstHistoryMsgId = clubChatRoomViewModel.getFirstHistoryMsgId(clubChatMsgResult2.getList());
                clubChatRoomViewModel.mHistoryCursorId = firstHistoryMsgId;
                List<ClubChatMsgModel> list = clubChatMsgResult2.getList();
                if (list == null || list.isEmpty()) {
                    return;
                }
                mutableLiveData = ClubChatRoomViewModel.this._moreHistoryMsg;
                mutableLiveData.setValue(new Event(new StateResult.c(clubChatMsgResult2.getList(), null, 2, null)));
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.club.viewmodel.ClubChatRoomViewModel$loadMoreHistoryMessage$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                MutableLiveData mutableLiveData;
                s.i(it, "it");
                mutableLiveData = ClubChatRoomViewModel.this._moreHistoryMsg;
                mutableLiveData.setValue(new Event(new StateResult.a(null, null, null, 7, null)));
                return Boolean.FALSE;
            }
        }, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    public final void loadMoreUnreadMessage() {
        String str;
        String str2 = this.mUnreadCursorId;
        if (str2 == null || str2.length() == 0) {
            this._moreUnreadMessageLiveData.setValue(new StateResult.a(null, null, null, 7, null));
            return;
        }
        this._moreUnreadMessageLiveData.setValue(new StateResult.b(null, null, 3, null));
        a2.a u10 = NetworkClient.f11868a.u();
        String str3 = this.mClubId;
        if (str3 == null) {
            s.A("mClubId");
            str = null;
        } else {
            str = str3;
        }
        Disposable disposed = a.C0010a.b(u10, str, this.mUnreadCursorId, null, 0, true, 12, null).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<ClubChatMsgResult, p>() { // from class: com.cupidapp.live.club.viewmodel.ClubChatRoomViewModel$loadMoreUnreadMessage$$inlined$handle$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(ClubChatMsgResult clubChatMsgResult) {
                m2521invoke(clubChatMsgResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2521invoke(ClubChatMsgResult clubChatMsgResult) {
                String lastUnreadMessageId;
                MutableLiveData mutableLiveData;
                ClubChatMsgResult clubChatMsgResult2 = clubChatMsgResult;
                ClubChatRoomViewModel clubChatRoomViewModel = ClubChatRoomViewModel.this;
                lastUnreadMessageId = clubChatRoomViewModel.getLastUnreadMessageId(clubChatMsgResult2.getList());
                clubChatRoomViewModel.mUnreadCursorId = lastUnreadMessageId;
                mutableLiveData = ClubChatRoomViewModel.this._moreUnreadMessageLiveData;
                mutableLiveData.setValue(new StateResult.c(clubChatMsgResult2.getList(), null, 2, null));
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.club.viewmodel.ClubChatRoomViewModel$loadMoreUnreadMessage$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                MutableLiveData mutableLiveData;
                s.i(it, "it");
                mutableLiveData = ClubChatRoomViewModel.this._moreUnreadMessageLiveData;
                mutableLiveData.setValue(new StateResult.a(null, null, null, 7, null));
                return Boolean.FALSE;
            }
        }, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    public final void loadNewestMessage(@Nullable String str) {
        String str2;
        a2.a u10 = NetworkClient.f11868a.u();
        String str3 = this.mClubId;
        if (str3 == null) {
            s.A("mClubId");
            str2 = null;
        } else {
            str2 = str3;
        }
        Disposable disposed = a.C0010a.b(u10, str2, null, str, 0, false, 26, null).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<ClubChatMsgResult, p>() { // from class: com.cupidapp.live.club.viewmodel.ClubChatRoomViewModel$loadNewestMessage$$inlined$handle$default$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(ClubChatMsgResult clubChatMsgResult) {
                m2522invoke(clubChatMsgResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2522invoke(ClubChatMsgResult clubChatMsgResult) {
                MutableLiveData mutableLiveData;
                boolean filterInsertNewMessage;
                List<ClubChatMsgModel> list = clubChatMsgResult.getList();
                if (list != null) {
                    ArrayList arrayList = new ArrayList();
                    for (ClubChatMsgModel clubChatMsgModel : list) {
                        filterInsertNewMessage = ClubChatRoomViewModel.this.filterInsertNewMessage(clubChatMsgModel);
                        if (filterInsertNewMessage) {
                            arrayList.add(clubChatMsgModel);
                        }
                    }
                    if (!arrayList.isEmpty()) {
                        mutableLiveData = ClubChatRoomViewModel.this._newMessage;
                        mutableLiveData.setValue(arrayList);
                    }
                }
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        GrpcMessageRouter.INSTANCE.removeIGrpcMessageListener(this);
        Disposable disposable = this.mClubInfoAndMsgDispose;
        if (disposable != null) {
            disposable.dispose();
        }
    }

    @Override // com.cupidapp.live.base.grpc.IGrpcMessageListener
    public void onReceiveGrpcMessage(@NotNull CuConnectorOuterClass.MessageType type, @NotNull Object model) {
        s.i(type, "type");
        s.i(model, "model");
        if (model instanceof BaseClubChatConnectorMessageModel) {
            String groupId = ((BaseClubChatConnectorMessageModel) model).getGroupId();
            String str = this.mClubId;
            if (str == null) {
                s.A("mClubId");
                str = null;
            }
            if (s.d(groupId, str)) {
                int i10 = a.f13704a[type.ordinal()];
                boolean z10 = true;
                if (i10 == 1) {
                    if (model instanceof ClubNewMessageConnectorMessageModel) {
                        this._notifyGetNewMessage.setValue(new Event<>(Boolean.valueOf(true ^ canLoadMoreUnread())));
                        return;
                    }
                    return;
                }
                if (i10 != 2) {
                    if (i10 != 3) {
                        if (i10 != 4) {
                            return;
                        }
                        this._newEnterRequest.setValue(new Event<>(Boolean.TRUE));
                        return;
                    } else {
                        if (model instanceof ClubTopMsgConnectorMessageModel) {
                            this._topMessage.setValue(new Event<>(((ClubTopMsgConnectorMessageModel) model).getMsg()));
                            return;
                        }
                        return;
                    }
                }
                if (model instanceof ClubMessageCancelConnectorMessageModel) {
                    ClubMessageCancelConnectorMessageModel clubMessageCancelConnectorMessageModel = (ClubMessageCancelConnectorMessageModel) model;
                    String messageId = clubMessageCancelConnectorMessageModel.getMessageId();
                    if (messageId != null && messageId.length() != 0) {
                        z10 = false;
                    }
                    if (z10) {
                        return;
                    }
                    this._cancelMessage.setValue(new ClubCancelMsgData(clubMessageCancelConnectorMessageModel.getMessageId(), com.cupidapp.live.club.helper.a.c(com.cupidapp.live.club.helper.a.f13611a, clubMessageCancelConnectorMessageModel.getNickname() + "撤回了一条消息", null, null, 6, null), false));
                }
            }
        }
    }

    public final void resendMessage(@NotNull ClubChatMsgModel failModel) {
        s.i(failModel, "failModel");
        String type = failModel.getType();
        if (s.d(type, ClubChatMessageType.InboxMessageText.getValue())) {
            sendTextMessage$default(this, null, failModel, null, null, 12, null);
        } else if (s.d(type, ClubChatMessageType.InboxMessageImage.getValue())) {
            sendImageMessage(failModel.getImagePath(), failModel);
        }
    }

    public final void sendImageMessage(@Nullable String str, @Nullable final ClubChatMsgModel clubChatMsgModel) {
        if (str == null || str.length() == 0) {
            return;
        }
        if (clubChatMsgModel == null) {
            clubChatMsgModel = com.cupidapp.live.club.helper.a.f13611a.a(str);
            this._newMessage.setValue(r.e(clubChatMsgModel));
        }
        File file = new File(str);
        MultipartBody.Part createFormData = MultipartBody.Part.Companion.createFormData(Attributes.Component.IMAGE, file.getName(), com.cupidapp.live.base.network.f.a(file));
        a2.a u10 = NetworkClient.f11868a.u();
        String str2 = this.mClubId;
        if (str2 == null) {
            s.A("mClubId");
            str2 = null;
        }
        Disposable disposed = u10.i(str2, createFormData).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<ClubChatMsgModel, p>() { // from class: com.cupidapp.live.club.viewmodel.ClubChatRoomViewModel$sendImageMessage$$inlined$handle$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(ClubChatMsgModel clubChatMsgModel2) {
                m2523invoke(clubChatMsgModel2);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2523invoke(ClubChatMsgModel clubChatMsgModel2) {
                MutableLiveData mutableLiveData;
                ClubChatMsgModel clubChatMsgModel3 = clubChatMsgModel2;
                ClubChatMsgModel.this.setMessageId(clubChatMsgModel3.getMessageId());
                ClubChatMsgModel.this.setSender(clubChatMsgModel3.getSender());
                ClubChatMsgModel.this.setMessageSendState(null);
                mutableLiveData = this._replaceMessage;
                mutableLiveData.setValue(new Pair(Long.valueOf(ClubChatMsgModel.this.getCreateTimeMillis()), ClubChatMsgModel.this));
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.club.viewmodel.ClubChatRoomViewModel$sendImageMessage$2
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
                ClubChatMsgModel e2 = com.cupidapp.live.club.helper.a.f13611a.e(ClubChatMsgModel.this);
                mutableLiveData = this._replaceMessage;
                mutableLiveData.setValue(new Pair(Long.valueOf(ClubChatMsgModel.this.getCreateTimeMillis()), e2));
                this.insertSendMsgFailErrorNotice(it);
                isStopDefaultErrorHandler = this.isStopDefaultErrorHandler(it);
                return Boolean.valueOf(isStopDefaultErrorHandler);
            }
        }, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    public final void sendTextMessage(@Nullable String str, @Nullable ClubChatMsgModel clubChatMsgModel, @Nullable String str2, @Nullable ClubChatMsgModel clubChatMsgModel2) {
        final ClubChatMsgModel clubChatMsgModel3;
        String messageId;
        QuoteInfoModel quoteInfo;
        if (str == null) {
            str = clubChatMsgModel != null ? clubChatMsgModel.getText() : null;
        }
        if (str == null || str.length() == 0) {
            return;
        }
        if (clubChatMsgModel == null) {
            clubChatMsgModel3 = com.cupidapp.live.club.helper.a.f13611a.d(str, clubChatMsgModel2);
            this._newMessage.setValue(r.e(clubChatMsgModel3));
        } else {
            clubChatMsgModel3 = clubChatMsgModel;
        }
        if (clubChatMsgModel2 == null || (messageId = clubChatMsgModel2.getMessageId()) == null) {
            messageId = (clubChatMsgModel == null || (quoteInfo = clubChatMsgModel.getQuoteInfo()) == null) ? null : quoteInfo.getMessageId();
        }
        Disposable disposed = getSendMsg(str, str2, messageId).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<ClubChatMsgModel, p>() { // from class: com.cupidapp.live.club.viewmodel.ClubChatRoomViewModel$sendTextMessage$$inlined$handle$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(ClubChatMsgModel clubChatMsgModel4) {
                m2524invoke(clubChatMsgModel4);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2524invoke(ClubChatMsgModel clubChatMsgModel4) {
                MutableLiveData mutableLiveData;
                ClubChatMsgModel clubChatMsgModel5 = clubChatMsgModel4;
                ClubChatMsgModel.this.setMessageId(clubChatMsgModel5.getMessageId());
                ClubChatMsgModel.this.setSender(clubChatMsgModel5.getSender());
                ClubChatMsgModel.this.setMessageSendState(null);
                mutableLiveData = this._replaceMessage;
                mutableLiveData.setValue(new Pair(Long.valueOf(ClubChatMsgModel.this.getCreateTimeMillis()), ClubChatMsgModel.this));
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.club.viewmodel.ClubChatRoomViewModel$sendTextMessage$2
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
                ClubChatMsgModel e2 = com.cupidapp.live.club.helper.a.f13611a.e(ClubChatMsgModel.this);
                mutableLiveData = this._replaceMessage;
                mutableLiveData.setValue(new Pair(Long.valueOf(ClubChatMsgModel.this.getCreateTimeMillis()), e2));
                this.insertSendMsgFailErrorNotice(it);
                isStopDefaultErrorHandler = this.isStopDefaultErrorHandler(it);
                return Boolean.valueOf(isStopDefaultErrorHandler);
            }
        }, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    @Nullable
    /* renamed from: getClubInfo */
    public final ClubInfoDetailModel m2515getClubInfo() {
        return this.mClubInfo;
    }
}

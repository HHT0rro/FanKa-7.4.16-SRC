package com.cupidapp.live.chat.viewmodel;

import android.app.Application;
import android.content.ComponentCallbacks2;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import com.android.internal.logging.nano.MetricsProto;
import com.cupidapp.live.MainActivity;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.livedata.CombineLiveData;
import com.cupidapp.live.base.livedata.Event;
import com.cupidapp.live.base.livedata.TripleCombineLiveData;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.model.ConstantsResult;
import com.cupidapp.live.base.network.model.ProfileResult;
import com.cupidapp.live.base.network.model.Result;
import com.cupidapp.live.base.network.model.StateResult;
import com.cupidapp.live.base.recyclerview.helper.ExposureScene;
import com.cupidapp.live.base.recyclerview.helper.RecyclerExposureHelper;
import com.cupidapp.live.base.recyclerview.model.FKEmptyViewModel;
import com.cupidapp.live.base.recyclerview.model.FKFooterWithSpaceModel;
import com.cupidapp.live.base.sensorslog.AppSetting;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.utils.r0;
import com.cupidapp.live.chat.model.ChatMatchUIModel;
import com.cupidapp.live.chat.model.ChatSessionTitleUIModel;
import com.cupidapp.live.chat.model.InboxSessionModel;
import com.cupidapp.live.chat.model.InboxSessionType;
import com.cupidapp.live.chat.model.UserMatchListResult;
import com.cupidapp.live.chat.service.InboxSessionResult;
import com.cupidapp.live.chat.service.NewMatchListResult;
import com.cupidapp.live.chat.service.NewUserGuideItemModel;
import com.cupidapp.live.chat.util.FKDeleteSessionUtil;
import com.cupidapp.live.chat.util.SessionLocalListUtil;
import com.cupidapp.live.chat.viewholder.NewMatchUserModel;
import com.cupidapp.live.chat.viewholder.NewUserGuideModel;
import com.cupidapp.live.main.event.RefreshSpecifyTabUnreadCountEvent;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.track.group.GroupOthersLog;
import com.cupidapp.live.vip.model.VipDiscountPromptModel;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import j1.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.collections.t;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import x1.b;
import x2.a;

/* compiled from: ChatSessionViewModel.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ChatSessionViewModel extends AndroidViewModel {

    @NotNull
    private final MutableLiveData<ChatSessionTitleUIModel> _chatSessionTitleLiveData;

    @NotNull
    private final MutableLiveData<Boolean> _maskTimeEventLiveData;

    @NotNull
    private final MutableLiveData<Event<ProfileResult>> _openUserProfileEvent;

    @NotNull
    private final MutableLiveData<Integer> _pageBgColor;

    @NotNull
    private final MutableLiveData<StateResult<List<InboxSessionModel>>> _sessionListResultLiveData;

    @NotNull
    private final MutableLiveData<Boolean> _sessionTimeEventLiveData;

    @NotNull
    private final MutableLiveData<VipDiscountPromptModel> _showDiscountPrompt;

    @NotNull
    private final MutableLiveData<Boolean> _showScanCodeView;

    @NotNull
    private final MutableLiveData<NewUserGuideModel> _userGuideListResultLiveData;

    @NotNull
    private final LiveData<Integer> bgColor;

    @NotNull
    private final List<Object> chatList;

    @NotNull
    private final Application context;
    private boolean hasTrackVisitorEnable;

    @NotNull
    private final LiveData<Boolean> maskTimeEventLiveData;

    @Nullable
    private String nextCursorId;

    @NotNull
    private final LiveData<Event<ProfileResult>> openUserProfileEvent;

    @NotNull
    private final LiveData<StateResult<List<Object>>> resultListLiveData;

    @NotNull
    private final LiveData<Boolean> sessionTimeEventLiveData;

    @NotNull
    private final LiveData<VipDiscountPromptModel> showDiscountPrompt;

    @NotNull
    private final LiveData<Boolean> showScanCodeView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatSessionViewModel(@NotNull Application context) {
        super(context);
        s.i(context, "context");
        this.context = context;
        MutableLiveData<StateResult<List<InboxSessionModel>>> mutableLiveData = new MutableLiveData<>();
        this._sessionListResultLiveData = mutableLiveData;
        MutableLiveData<NewUserGuideModel> mutableLiveData2 = new MutableLiveData<>();
        this._userGuideListResultLiveData = mutableLiveData2;
        MutableLiveData<ChatSessionTitleUIModel> mutableLiveData3 = new MutableLiveData<>();
        mutableLiveData3.setValue(new ChatSessionTitleUIModel(null, false, false, null, null, 31, null));
        this._chatSessionTitleLiveData = mutableLiveData3;
        MutableLiveData<Integer> mutableLiveData4 = new MutableLiveData<>();
        this._pageBgColor = mutableLiveData4;
        this.bgColor = mutableLiveData4;
        this.chatList = new ArrayList();
        this.resultListLiveData = Transformations.distinctUntilChanged(new TripleCombineLiveData(mutableLiveData, mutableLiveData3, mutableLiveData2, new Function3<StateResult<List<? extends InboxSessionModel>>, ChatSessionTitleUIModel, NewUserGuideModel, StateResult<List<Object>>>() { // from class: com.cupidapp.live.chat.viewmodel.ChatSessionViewModel$resultListLiveData$1
            {
                super(3);
            }

            @Nullable
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final StateResult<List<Object>> invoke2(@Nullable StateResult<List<InboxSessionModel>> stateResult, @Nullable ChatSessionTitleUIModel chatSessionTitleUIModel, @Nullable NewUserGuideModel newUserGuideModel) {
                List list;
                MutableLiveData mutableLiveData5;
                List list2;
                List list3;
                boolean canLoadMoreSession;
                List list4;
                List list5;
                MutableLiveData mutableLiveData6;
                List list6;
                boolean canLoadMoreSession2;
                List list7;
                List list8;
                List list9;
                MutableLiveData mutableLiveData7;
                List list10;
                MutableLiveData mutableLiveData8;
                List<NewUserGuideItemModel> guideList;
                List list11;
                if (stateResult instanceof StateResult.b) {
                    return new StateResult.b(new ArrayList(), null, 2, null);
                }
                list = ChatSessionViewModel.this.chatList;
                list.clear();
                List<InboxSessionModel> data = stateResult != null ? stateResult.getData() : null;
                if (chatSessionTitleUIModel != null) {
                    list11 = ChatSessionViewModel.this.chatList;
                    list11.add(chatSessionTitleUIModel);
                }
                if (data == null || data.isEmpty()) {
                    if (!((newUserGuideModel == null || (guideList = newUserGuideModel.getGuideList()) == null || !(guideList.isEmpty() ^ true)) ? false : true)) {
                        if (stateResult instanceof StateResult.c) {
                            list10 = ChatSessionViewModel.this.chatList;
                            list10.add(new FKEmptyViewModel(Integer.valueOf(R$mipmap.icon_empty_contact_message), Integer.valueOf(R$string.session_empty), null, null, null, Integer.valueOf(z0.h.c(ChatSessionViewModel.this, 360.0f)), null, false, null, -526345, MetricsProto.MetricsEvent.ACTION_SELECT_SUMMARY, null));
                            mutableLiveData8 = ChatSessionViewModel.this._pageBgColor;
                            mutableLiveData8.setValue(-526345);
                        } else if (stateResult instanceof StateResult.a) {
                            list9 = ChatSessionViewModel.this.chatList;
                            list9.add(new FKEmptyViewModel(Integer.valueOf(R$mipmap.icon_nonet), Integer.valueOf(R$string.internet_is_unavailable), null, null, null, Integer.valueOf(z0.h.c(ChatSessionViewModel.this, 450.0f)), null, false, Integer.valueOf(R$string.load_again), -526345, 220, null));
                            mutableLiveData7 = ChatSessionViewModel.this._pageBgColor;
                            mutableLiveData7.setValue(-526345);
                        }
                        list8 = ChatSessionViewModel.this.chatList;
                        return new StateResult.c(list8, null, 2, null);
                    }
                }
                if (data == null || data.isEmpty()) {
                    list5 = ChatSessionViewModel.this.chatList;
                    list5.add(new FKEmptyViewModel(null, Integer.valueOf(R$string.session_empty), null, null, null, Integer.valueOf(z0.h.c(ChatSessionViewModel.this, 30.0f)), null, false, null, -526345, MetricsProto.MetricsEvent.ACTION_SELECT_SUPPORT_FRAGMENT, null));
                    mutableLiveData6 = ChatSessionViewModel.this._pageBgColor;
                    mutableLiveData6.setValue(-1);
                    if (newUserGuideModel != null) {
                        list7 = ChatSessionViewModel.this.chatList;
                        list7.add(newUserGuideModel);
                    }
                    list6 = ChatSessionViewModel.this.chatList;
                    canLoadMoreSession2 = ChatSessionViewModel.this.canLoadMoreSession();
                    list6.add(new FKFooterWithSpaceModel(canLoadMoreSession2, false, null, 0, 0, z0.h.c(ChatSessionViewModel.this, 66.0f), 30, null));
                } else {
                    mutableLiveData5 = ChatSessionViewModel.this._pageBgColor;
                    mutableLiveData5.setValue(-1);
                    list2 = ChatSessionViewModel.this.chatList;
                    list2.addAll(data);
                    if (newUserGuideModel != null) {
                        list4 = ChatSessionViewModel.this.chatList;
                        list4.add(newUserGuideModel);
                    }
                    list3 = ChatSessionViewModel.this.chatList;
                    canLoadMoreSession = ChatSessionViewModel.this.canLoadMoreSession();
                    list3.add(new FKFooterWithSpaceModel(canLoadMoreSession, false, null, 0, 0, z0.h.c(ChatSessionViewModel.this, 56.0f), 30, null));
                }
                list8 = ChatSessionViewModel.this.chatList;
                return new StateResult.c(list8, null, 2, null);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ StateResult<List<Object>> invoke(StateResult<List<? extends InboxSessionModel>> stateResult, ChatSessionTitleUIModel chatSessionTitleUIModel, NewUserGuideModel newUserGuideModel) {
                return invoke2((StateResult<List<InboxSessionModel>>) stateResult, chatSessionTitleUIModel, newUserGuideModel);
            }
        }));
        MutableLiveData<Boolean> mutableLiveData5 = new MutableLiveData<>();
        this._maskTimeEventLiveData = mutableLiveData5;
        this.maskTimeEventLiveData = new CombineLiveData(mutableLiveData5, mutableLiveData, new Function2<Boolean, StateResult<List<? extends InboxSessionModel>>, Boolean>() { // from class: com.cupidapp.live.chat.viewmodel.ChatSessionViewModel$maskTimeEventLiveData$1
            @Override // kotlin.jvm.functions.Function2
            /* renamed from: invoke */
            public /* bridge */ /* synthetic */ Boolean mo1743invoke(Boolean bool, StateResult<List<? extends InboxSessionModel>> stateResult) {
                return invoke2(bool, (StateResult<List<InboxSessionModel>>) stateResult);
            }

            @Nullable
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Boolean invoke2(@Nullable Boolean bool, @Nullable StateResult<List<InboxSessionModel>> stateResult) {
                List<InboxSessionModel> data;
                boolean z10 = false;
                if (stateResult != null && (data = stateResult.getData()) != null && (!data.isEmpty())) {
                    z10 = true;
                }
                return z10 ? bool : Boolean.FALSE;
            }
        });
        MutableLiveData<Boolean> mutableLiveData6 = new MutableLiveData<>();
        this._sessionTimeEventLiveData = mutableLiveData6;
        this.sessionTimeEventLiveData = new CombineLiveData(mutableLiveData6, mutableLiveData, new Function2<Boolean, StateResult<List<? extends InboxSessionModel>>, Boolean>() { // from class: com.cupidapp.live.chat.viewmodel.ChatSessionViewModel$sessionTimeEventLiveData$1
            @Override // kotlin.jvm.functions.Function2
            /* renamed from: invoke */
            public /* bridge */ /* synthetic */ Boolean mo1743invoke(Boolean bool, StateResult<List<? extends InboxSessionModel>> stateResult) {
                return invoke2(bool, (StateResult<List<InboxSessionModel>>) stateResult);
            }

            @Nullable
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Boolean invoke2(@Nullable Boolean bool, @Nullable StateResult<List<InboxSessionModel>> stateResult) {
                List<InboxSessionModel> data;
                boolean z10 = false;
                if (stateResult != null && (data = stateResult.getData()) != null && (!data.isEmpty())) {
                    z10 = true;
                }
                return z10 ? bool : Boolean.FALSE;
            }
        });
        MutableLiveData<Event<ProfileResult>> mutableLiveData7 = new MutableLiveData<>();
        this._openUserProfileEvent = mutableLiveData7;
        this.openUserProfileEvent = mutableLiveData7;
        MutableLiveData<VipDiscountPromptModel> mutableLiveData8 = new MutableLiveData<>();
        this._showDiscountPrompt = mutableLiveData8;
        this.showDiscountPrompt = mutableLiveData8;
        MutableLiveData<Boolean> mutableLiveData9 = new MutableLiveData<>();
        this._showScanCodeView = mutableLiveData9;
        this.showScanCodeView = mutableLiveData9;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean canLoadMoreSession() {
        String str = this.nextCursorId;
        return !(str == null || str.length() == 0);
    }

    private final void checkSessionCountDown(List<InboxSessionModel> list) {
        for (InboxSessionModel inboxSessionModel : list) {
            Integer countdown = inboxSessionModel.getCountdown();
            if (countdown != null && countdown.intValue() > 0) {
                this._sessionTimeEventLiveData.setValue(Boolean.TRUE);
            }
            Integer maskRemainSec = inboxSessionModel.getMaskRemainSec();
            if ((maskRemainSec != null ? maskRemainSec.intValue() : 0) > 0) {
                this._maskTimeEventLiveData.setValue(Boolean.TRUE);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkShowGuideOpenPushTipBar() {
        ChatSessionTitleUIModel value = this._chatSessionTitleLiveData.getValue();
        if (value != null) {
            value.setShowPushStatus(!r0.f12373a.a(this.context));
        }
        this._chatSessionTitleLiveData.setValue(value);
    }

    private final void checkShowPrivateAndUnreadCount() {
        Observable observeOn = b.a.a(NetworkClient.f11868a.j(), null, 0, false, 2, null).observeOn(AndroidSchedulers.mainThread());
        s.h(observeOn, "NetworkClient.contactSer…dSchedulers.mainThread())");
        Disposable disposed = observeOn.flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<InboxSessionResult, p>() { // from class: com.cupidapp.live.chat.viewmodel.ChatSessionViewModel$checkShowPrivateAndUnreadCount$$inlined$handle$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(InboxSessionResult inboxSessionResult) {
                m2485invoke(inboxSessionResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2485invoke(InboxSessionResult inboxSessionResult) {
                InboxSessionResult inboxSessionResult2 = inboxSessionResult;
                ChatSessionViewModel chatSessionViewModel = ChatSessionViewModel.this;
                Boolean stealthMessage = inboxSessionResult2.getStealthMessage();
                chatSessionViewModel.renderShowPrivate(stealthMessage != null ? stealthMessage.booleanValue() : false);
                p1.g.f52734a.X1(inboxSessionResult2.getMessageCount());
                ChatSessionViewModel.this.postChatUnreadCountEvent();
                ChatSessionViewModel.this.compareAndRefreshSessionList(inboxSessionResult2.getList());
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.chat.viewmodel.ChatSessionViewModel$checkShowPrivateAndUnreadCount$2
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                s.i(it, "it");
                return Boolean.TRUE;
            }
        }, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void compareAndRefreshSessionList(List<InboxSessionModel> list) {
        InboxSessionModel inboxSessionModel;
        boolean z10 = true;
        if (list == null || list.isEmpty()) {
            return;
        }
        List<InboxSessionModel> d10 = SessionLocalListUtil.f13179a.d();
        if (d10 != null && !d10.isEmpty()) {
            z10 = false;
        }
        if (z10) {
            return;
        }
        for (InboxSessionModel inboxSessionModel2 : list) {
            Iterator<InboxSessionModel> iterator2 = d10.iterator2();
            while (true) {
                if (iterator2.hasNext()) {
                    inboxSessionModel = iterator2.next();
                    if (s.d(inboxSessionModel.getItemId(), inboxSessionModel2.getItemId())) {
                        break;
                    }
                } else {
                    inboxSessionModel = null;
                    break;
                }
            }
            InboxSessionModel inboxSessionModel3 = inboxSessionModel;
            if (inboxSessionModel3 != null) {
                d10.remove(inboxSessionModel3);
            }
        }
        d10.addAll(0, list);
        checkSessionCountDown(list);
        updateSessionListData();
    }

    private final Observable<Result<NewMatchListResult>> getMatchListData() {
        Observable<Result<NewMatchListResult>> observeOn = NetworkClient.f11868a.N().N0().observeOn(AndroidSchedulers.mainThread());
        final Function1<Result<? extends NewMatchListResult>, p> function1 = new Function1<Result<? extends NewMatchListResult>, p>() { // from class: com.cupidapp.live.chat.viewmodel.ChatSessionViewModel$getMatchListData$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Result<? extends NewMatchListResult> result) {
                invoke2((Result<NewMatchListResult>) result);
                return p.f51048a;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Result<NewMatchListResult> result) {
                MutableLiveData mutableLiveData;
                MutableLiveData mutableLiveData2;
                MutableLiveData mutableLiveData3;
                List<User> list;
                ArrayList arrayList;
                List<User> list2;
                List<User> list3;
                RecyclerExposureHelper.f12092j.d(ExposureScene.NewMatchList);
                NewMatchListResult data = result.getData();
                int i10 = 0;
                int size = (data == null || (list3 = data.getList()) == null) ? 0 : list3.size();
                mutableLiveData = ChatSessionViewModel.this._chatSessionTitleLiveData;
                ChatSessionTitleUIModel chatSessionTitleUIModel = (ChatSessionTitleUIModel) mutableLiveData.getValue();
                if (chatSessionTitleUIModel != null) {
                    if (data == null || (list2 = data.getList()) == null) {
                        arrayList = null;
                    } else {
                        arrayList = new ArrayList(t.t(list2, 10));
                        Iterator<User> iterator2 = list2.iterator2();
                        while (iterator2.hasNext()) {
                            arrayList.add(new NewMatchUserModel(iterator2.next(), size, false, 4, null));
                        }
                    }
                    chatSessionTitleUIModel.setMatchUserModel(new ChatMatchUIModel(arrayList, data != null ? data.getChatStatusEntrance() : null, data != null ? data.getSuperBoostEntrance() : null));
                }
                if (chatSessionTitleUIModel != null) {
                    chatSessionTitleUIModel.setGuide(data != null ? data.getGuide() : null);
                }
                if (chatSessionTitleUIModel != null) {
                    chatSessionTitleUIModel.setClubEntrance(data != null ? data.getGroupInfo() : null);
                }
                mutableLiveData2 = ChatSessionViewModel.this._chatSessionTitleLiveData;
                mutableLiveData2.setValue(chatSessionTitleUIModel);
                mutableLiveData3 = ChatSessionViewModel.this._showScanCodeView;
                mutableLiveData3.setValue(Boolean.valueOf((data != null ? data.getGroupInfo() : null) != null));
                p1.g gVar = p1.g.f52734a;
                NewMatchListResult data2 = result.getData();
                if (data2 != null && (list = data2.getList()) != null) {
                    ArrayList arrayList2 = new ArrayList();
                    for (User user : list) {
                        if (user.getNewMatch()) {
                            arrayList2.add(user);
                        }
                    }
                    i10 = arrayList2.size();
                }
                gVar.v2(i10);
                ChatSessionViewModel.this.postChatUnreadCountEvent();
            }
        };
        Observable<Result<NewMatchListResult>> doOnNext = observeOn.doOnNext(new Consumer() { // from class: com.cupidapp.live.chat.viewmodel.j
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ChatSessionViewModel.getMatchListData$lambda$12(Function1.this, obj);
            }
        });
        final ChatSessionViewModel$getMatchListData$2 chatSessionViewModel$getMatchListData$2 = new Function1<Throwable, Result<? extends NewMatchListResult>>() { // from class: com.cupidapp.live.chat.viewmodel.ChatSessionViewModel$getMatchListData$2
            @Override // kotlin.jvm.functions.Function1
            public final Result<NewMatchListResult> invoke(@NotNull Throwable it) {
                s.i(it, "it");
                return new Result<>(null, false, null, null, null, null, null, 127, null);
            }
        };
        Observable<Result<NewMatchListResult>> onErrorReturn = doOnNext.onErrorReturn(new Function() { // from class: com.cupidapp.live.chat.viewmodel.b
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Result matchListData$lambda$13;
                matchListData$lambda$13 = ChatSessionViewModel.getMatchListData$lambda$13(Function1.this, obj);
                return matchListData$lambda$13;
            }
        });
        s.h(onErrorReturn, "private fun getMatchList…Return { Result() }\n    }");
        return onErrorReturn;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getMatchListData$lambda$12(Function1 tmp0, Object obj) {
        s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Result getMatchListData$lambda$13(Function1 tmp0, Object obj) {
        s.i(tmp0, "$tmp0");
        return (Result) tmp0.invoke(obj);
    }

    private final Observable<Result<InboxSessionResult>> getSessionList(final String str) {
        Observable observeOn = b.a.a(NetworkClient.f11868a.j(), str, 0, false, 2, null).delay(500L, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread());
        final Function1<Result<? extends InboxSessionResult>, p> function1 = new Function1<Result<? extends InboxSessionResult>, p>() { // from class: com.cupidapp.live.chat.viewmodel.ChatSessionViewModel$getSessionList$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Result<? extends InboxSessionResult> result) {
                invoke2((Result<InboxSessionResult>) result);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Result<InboxSessionResult> result) {
                MutableLiveData mutableLiveData;
                MutableLiveData mutableLiveData2;
                boolean z10;
                MutableLiveData mutableLiveData3;
                MutableLiveData mutableLiveData4;
                Boolean stealthMessage;
                ArrayList arrayList = new ArrayList();
                ChatSessionViewModel chatSessionViewModel = ChatSessionViewModel.this;
                InboxSessionResult data = result.getData();
                chatSessionViewModel.nextCursorId = data != null ? data.getNextCursorId() : null;
                String str2 = str;
                if (str2 == null || str2.length() == 0) {
                    arrayList.clear();
                    ChatSessionViewModel chatSessionViewModel2 = ChatSessionViewModel.this;
                    InboxSessionResult data2 = result.getData();
                    chatSessionViewModel2.renderShowPrivate((data2 == null || (stealthMessage = data2.getStealthMessage()) == null) ? false : stealthMessage.booleanValue());
                    p1.g gVar = p1.g.f52734a;
                    InboxSessionResult data3 = result.getData();
                    gVar.X1(data3 != null ? data3.getMessageCount() : 0);
                    ChatSessionViewModel.this.postChatUnreadCountEvent();
                } else {
                    arrayList.addAll(SessionLocalListUtil.f13179a.d());
                }
                InboxSessionResult data4 = result.getData();
                List<InboxSessionModel> list = data4 != null ? data4.getList() : null;
                InboxSessionResult data5 = result.getData();
                List<NewUserGuideItemModel> guideList = data5 != null ? data5.getGuideList() : null;
                if (list != null && (list.isEmpty() ^ true)) {
                    ChatSessionViewModel chatSessionViewModel3 = ChatSessionViewModel.this;
                    ArrayList arrayList2 = new ArrayList();
                    for (InboxSessionModel inboxSessionModel : list) {
                        Integer countdown = inboxSessionModel.getCountdown();
                        if (countdown != null && countdown.intValue() > 0) {
                            mutableLiveData4 = chatSessionViewModel3._sessionTimeEventLiveData;
                            mutableLiveData4.setValue(Boolean.TRUE);
                        }
                        Integer maskRemainSec = inboxSessionModel.getMaskRemainSec();
                        int intValue = maskRemainSec != null ? maskRemainSec.intValue() : 0;
                        if (1 <= intValue && intValue < 4) {
                            inboxSessionModel = null;
                        } else {
                            if (intValue > 0) {
                                mutableLiveData3 = chatSessionViewModel3._maskTimeEventLiveData;
                                mutableLiveData3.setValue(Boolean.TRUE);
                            }
                            z10 = chatSessionViewModel3.hasTrackVisitorEnable;
                            if (!z10 && inboxSessionModel.getVisitorInfo() != null) {
                                chatSessionViewModel3.hasTrackVisitorEnable = true;
                                o.f50242a.c(SensorPosition.Message.getValue(), inboxSessionModel.getLastMessage());
                            }
                        }
                        if (inboxSessionModel != null) {
                            arrayList2.add(inboxSessionModel);
                        }
                    }
                    arrayList.addAll(arrayList2);
                }
                if (guideList != null) {
                    mutableLiveData2 = ChatSessionViewModel.this._userGuideListResultLiveData;
                    mutableLiveData2.setValue(new NewUserGuideModel(guideList));
                }
                SessionLocalListUtil sessionLocalListUtil = SessionLocalListUtil.f13179a;
                sessionLocalListUtil.j(arrayList);
                mutableLiveData = ChatSessionViewModel.this._sessionListResultLiveData;
                mutableLiveData.setValue(new StateResult.c(sessionLocalListUtil.d(), null, 2, null));
            }
        };
        Observable doOnNext = observeOn.doOnNext(new Consumer() { // from class: com.cupidapp.live.chat.viewmodel.k
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ChatSessionViewModel.getSessionList$lambda$14(Function1.this, obj);
            }
        });
        final Function1<Throwable, p> function12 = new Function1<Throwable, p>() { // from class: com.cupidapp.live.chat.viewmodel.ChatSessionViewModel$getSessionList$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Throwable th) {
                invoke2(th);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable it) {
                MutableLiveData mutableLiveData;
                mutableLiveData = ChatSessionViewModel.this._sessionListResultLiveData;
                mutableLiveData.setValue(new StateResult.a(null, SessionLocalListUtil.f13179a.d(), null, 5, null));
                com.cupidapp.live.base.network.j jVar = com.cupidapp.live.base.network.j.f12008a;
                s.h(it, "it");
                com.cupidapp.live.base.network.j.f(jVar, it, null, null, null, 14, null);
            }
        };
        Observable<Result<InboxSessionResult>> doOnError = doOnNext.doOnError(new Consumer() { // from class: com.cupidapp.live.chat.viewmodel.g
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ChatSessionViewModel.getSessionList$lambda$15(Function1.this, obj);
            }
        });
        s.h(doOnError, "private fun getSessionLi…e(it)\n            }\n    }");
        return doOnError;
    }

    public static /* synthetic */ Observable getSessionList$default(ChatSessionViewModel chatSessionViewModel, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = null;
        }
        return chatSessionViewModel.getSessionList(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getSessionList$lambda$14(Function1 tmp0, Object obj) {
        s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getSessionList$lambda$15(Function1 tmp0, Object obj) {
        s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Boolean initData$lambda$1(Result match, Result sessionList) {
        s.i(match, "match");
        s.i(sessionList, "sessionList");
        return Boolean.FALSE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initData$lambda$2(Function1 tmp0, Object obj) {
        s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initData$lambda$3(Function1 tmp0, Object obj) {
        s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void loadMore$lambda$4() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void loadMore$lambda$5(Function1 tmp0, Object obj) {
        s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void postChatUnreadCountEvent() {
        EventBus.c().l(new RefreshSpecifyTabUnreadCountEvent(MainActivity.MainPagerType.Chat));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void realExecuteDeleteSession(InboxSessionModel inboxSessionModel) {
        InboxSessionModel inboxSessionModel2;
        List<InboxSessionModel> d10 = SessionLocalListUtil.f13179a.d();
        if (d10.size() <= 6) {
            initData();
            return;
        }
        Iterator<InboxSessionModel> iterator2 = d10.iterator2();
        while (true) {
            if (!iterator2.hasNext()) {
                inboxSessionModel2 = null;
                break;
            } else {
                inboxSessionModel2 = iterator2.next();
                if (s.d(inboxSessionModel2.getItemId(), inboxSessionModel.getItemId())) {
                    break;
                }
            }
        }
        InboxSessionModel inboxSessionModel3 = inboxSessionModel2;
        if (inboxSessionModel3 != null) {
            d10.remove(inboxSessionModel3);
        }
        updateSessionListData();
        p1.g.f52734a.O3(inboxSessionModel.getUnread());
        postChatUnreadCountEvent();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void refreshMatchListData$lambda$6() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void refreshMatchListData$lambda$7(Function1 tmp0, Object obj) {
        s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderShowPrivate(boolean z10) {
        FKDeleteSessionUtil.f13177a.c(Boolean.valueOf(z10));
        ChatSessionTitleUIModel value = this._chatSessionTitleLiveData.getValue();
        if (value != null) {
            value.setStealthMessage(z10);
        }
        this._chatSessionTitleLiveData.setValue(value);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateSessionListData() {
        StateResult<List<InboxSessionModel>> value = this._sessionListResultLiveData.getValue();
        if (value instanceof StateResult.a) {
            this._sessionListResultLiveData.setValue(new StateResult.a(null, SessionLocalListUtil.f13179a.d(), null, 5, null));
        } else if (value instanceof StateResult.c) {
            this._sessionListResultLiveData.setValue(new StateResult.c(SessionLocalListUtil.f13179a.d(), null, 2, null));
        }
    }

    public final void clearNewMatch(@NotNull String userId) {
        s.i(userId, "userId");
        Disposable disposed = NetworkClient.f11868a.N().d(userId).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<UserMatchListResult, p>() { // from class: com.cupidapp.live.chat.viewmodel.ChatSessionViewModel$clearNewMatch$$inlined$handle$default$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(UserMatchListResult userMatchListResult) {
                m2486invoke(userMatchListResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2486invoke(UserMatchListResult userMatchListResult) {
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    public final void clearUnreadCount(@NotNull final InboxSessionModel inbox) {
        s.i(inbox, "inbox");
        Disposable disposed = NetworkClient.f11868a.j().c(inbox.getItemId()).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<Object, p>() { // from class: com.cupidapp.live.chat.viewmodel.ChatSessionViewModel$clearUnreadCount$$inlined$handle$default$1
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
                InboxSessionModel inboxSessionModel;
                p1.g.f52734a.O3(InboxSessionModel.this.getUnread());
                Iterator<InboxSessionModel> iterator2 = SessionLocalListUtil.f13179a.d().iterator2();
                while (true) {
                    if (!iterator2.hasNext()) {
                        inboxSessionModel = null;
                        break;
                    } else {
                        inboxSessionModel = iterator2.next();
                        if (s.d(InboxSessionModel.this.getItemId(), inboxSessionModel.getItemId())) {
                            break;
                        }
                    }
                }
                InboxSessionModel inboxSessionModel2 = inboxSessionModel;
                if (inboxSessionModel2 != null) {
                    inboxSessionModel2.setUnread(0);
                }
                this.updateSessionListData();
                this.postChatUnreadCountEvent();
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    public final void closeViewMessagePrivately() {
        Disposable disposed = NetworkClient.f11868a.N().y0(false).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<Object, p>() { // from class: com.cupidapp.live.chat.viewmodel.ChatSessionViewModel$closeViewMessagePrivately$$inlined$handleByContext$default$1
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
                ChatSessionViewModel.this.renderShowPrivate(false);
                com.cupidapp.live.base.view.h.f12779a.c(ChatSessionViewModel.this.getContext(), R$string.view_message_privately_closed);
                GroupOthersLog.l0(GroupOthersLog.f18702a, AppSetting.SECRET_VIEW, false, SensorPosition.Message, null, 8, null);
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    public final void deleteSession(@NotNull final InboxSessionModel inbox) {
        Observable<Result<Object>> a10;
        s.i(inbox, "inbox");
        String type = inbox.getType();
        if (s.d(type, InboxSessionType.GroupSession.getType())) {
            a10 = NetworkClient.f11868a.u().l(inbox.getItemId());
        } else if (s.d(type, InboxSessionType.OperationSession.getType())) {
            a10 = NetworkClient.f11868a.j().f(inbox.getTemplateMsgId());
        } else {
            a10 = NetworkClient.f11868a.j().a(inbox.getItemId());
        }
        ComponentCallbacks2 componentCallbacks2 = this.context;
        com.cupidapp.live.base.network.g gVar = componentCallbacks2 instanceof com.cupidapp.live.base.network.g ? (com.cupidapp.live.base.network.g) componentCallbacks2 : null;
        Disposable disposed = a10.flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<Object, p>() { // from class: com.cupidapp.live.chat.viewmodel.ChatSessionViewModel$deleteSession$$inlined$handleByContext$default$1
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
                ChatSessionViewModel.this.realExecuteDeleteSession(inbox);
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, gVar)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            if (gVar != null) {
                gVar.H(disposed);
            }
        }
        s.h(disposed, "disposed");
    }

    public final void deleteSessionByDeleteAndExitClub(@NotNull String clubId) {
        InboxSessionModel inboxSessionModel;
        s.i(clubId, "clubId");
        Iterator<InboxSessionModel> iterator2 = SessionLocalListUtil.f13179a.d().iterator2();
        while (true) {
            if (!iterator2.hasNext()) {
                inboxSessionModel = null;
                break;
            } else {
                inboxSessionModel = iterator2.next();
                if (s.d(inboxSessionModel.getItemId(), clubId)) {
                    break;
                }
            }
        }
        InboxSessionModel inboxSessionModel2 = inboxSessionModel;
        if (inboxSessionModel2 != null) {
            realExecuteDeleteSession(inboxSessionModel2);
        }
    }

    @NotNull
    public final LiveData<Integer> getBgColor() {
        return this.bgColor;
    }

    @NotNull
    public final Application getContext() {
        return this.context;
    }

    @NotNull
    public final LiveData<Boolean> getMaskTimeEventLiveData() {
        return this.maskTimeEventLiveData;
    }

    @NotNull
    public final LiveData<Event<ProfileResult>> getOpenUserProfileEvent() {
        return this.openUserProfileEvent;
    }

    @NotNull
    public final LiveData<StateResult<List<Object>>> getResultListLiveData() {
        return this.resultListLiveData;
    }

    @NotNull
    public final LiveData<Boolean> getSessionTimeEventLiveData() {
        return this.sessionTimeEventLiveData;
    }

    @NotNull
    public final LiveData<VipDiscountPromptModel> getShowDiscountPrompt() {
        return this.showDiscountPrompt;
    }

    @NotNull
    public final LiveData<Boolean> getShowScanCodeView() {
        return this.showScanCodeView;
    }

    public final boolean hasUserGuide() {
        List<NewUserGuideItemModel> guideList;
        NewUserGuideModel value = this._userGuideListResultLiveData.getValue();
        return (value == null || (guideList = value.getGuideList()) == null || !(guideList.isEmpty() ^ true)) ? false : true;
    }

    public final void initData() {
        List<InboxSessionModel> d10 = SessionLocalListUtil.f13179a.d();
        if (this._sessionListResultLiveData.getValue() instanceof StateResult.b) {
            return;
        }
        this._sessionListResultLiveData.setValue(new StateResult.b(d10, null, 2, null));
        RecyclerExposureHelper.f12092j.d(ExposureScene.ChatSessionList);
        Observable zip = Observable.zip(getMatchListData(), getSessionList$default(this, null, 1, null), new BiFunction() { // from class: com.cupidapp.live.chat.viewmodel.d
            @Override // io.reactivex.functions.BiFunction
            public final Object apply(Object obj, Object obj2) {
                Boolean initData$lambda$1;
                initData$lambda$1 = ChatSessionViewModel.initData$lambda$1((Result) obj, (Result) obj2);
                return initData$lambda$1;
            }
        });
        final Function1<Boolean, p> function1 = new Function1<Boolean, p>() { // from class: com.cupidapp.live.chat.viewmodel.ChatSessionViewModel$initData$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Boolean bool) {
                invoke2(bool);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool) {
                ChatSessionViewModel.this.checkShowGuideOpenPushTipBar();
            }
        };
        Consumer consumer = new Consumer() { // from class: com.cupidapp.live.chat.viewmodel.f
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ChatSessionViewModel.initData$lambda$2(Function1.this, obj);
            }
        };
        final ChatSessionViewModel$initData$3 chatSessionViewModel$initData$3 = new Function1<Throwable, p>() { // from class: com.cupidapp.live.chat.viewmodel.ChatSessionViewModel$initData$3
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Throwable th) {
                invoke2(th);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
            }
        };
        zip.subscribe(consumer, new Consumer() { // from class: com.cupidapp.live.chat.viewmodel.h
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ChatSessionViewModel.initData$lambda$3(Function1.this, obj);
            }
        });
    }

    public final void loadMore() {
        if (canLoadMoreSession()) {
            Completable ignoreElements = getSessionList(this.nextCursorId).ignoreElements();
            a aVar = new Action() { // from class: com.cupidapp.live.chat.viewmodel.a
                @Override // io.reactivex.functions.Action
                public final void run() {
                    ChatSessionViewModel.loadMore$lambda$4();
                }
            };
            final ChatSessionViewModel$loadMore$2 chatSessionViewModel$loadMore$2 = new Function1<Throwable, p>() { // from class: com.cupidapp.live.chat.viewmodel.ChatSessionViewModel$loadMore$2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(Throwable th) {
                    invoke2(th);
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Throwable th) {
                }
            };
            ignoreElements.subscribe(aVar, new Consumer() { // from class: com.cupidapp.live.chat.viewmodel.e
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    ChatSessionViewModel.loadMore$lambda$5(Function1.this, obj);
                }
            });
        }
    }

    public final void openUserProfile(@NotNull String userId) {
        s.i(userId, "userId");
        Disposable disposed = a.C0836a.z(NetworkClient.f11868a.N(), userId, null, null, false, null, 30, null).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<ProfileResult, p>() { // from class: com.cupidapp.live.chat.viewmodel.ChatSessionViewModel$openUserProfile$$inlined$handle$default$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(ProfileResult profileResult) {
                m2487invoke(profileResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2487invoke(ProfileResult profileResult) {
                MutableLiveData mutableLiveData;
                mutableLiveData = ChatSessionViewModel.this._openUserProfileEvent;
                mutableLiveData.setValue(new Event(profileResult));
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    public final void refreshImportantData() {
        if (this._sessionListResultLiveData.getValue() instanceof StateResult.b) {
            return;
        }
        refreshMatchListData();
        checkShowGuideOpenPushTipBar();
        checkShowPrivateAndUnreadCount();
    }

    public final void refreshMatchListData() {
        Completable ignoreElements = getMatchListData().ignoreElements();
        c cVar = new Action() { // from class: com.cupidapp.live.chat.viewmodel.c
            @Override // io.reactivex.functions.Action
            public final void run() {
                ChatSessionViewModel.refreshMatchListData$lambda$6();
            }
        };
        final ChatSessionViewModel$refreshMatchListData$2 chatSessionViewModel$refreshMatchListData$2 = new Function1<Throwable, p>() { // from class: com.cupidapp.live.chat.viewmodel.ChatSessionViewModel$refreshMatchListData$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Throwable th) {
                invoke2(th);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
            }
        };
        ignoreElements.subscribe(cVar, new Consumer() { // from class: com.cupidapp.live.chat.viewmodel.i
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ChatSessionViewModel.refreshMatchListData$lambda$7(Function1.this, obj);
            }
        });
    }

    public final void showDiscountPrompt() {
        ConstantsResult q10 = p1.g.f52734a.q();
        if (q10 != null ? s.d(q10.getVasPolling(), Boolean.TRUE) : false) {
            Disposable disposed = NetworkClient.f11868a.p().a().flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<VipDiscountPromptModel, p>() { // from class: com.cupidapp.live.chat.viewmodel.ChatSessionViewModel$showDiscountPrompt$$inlined$handle$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(VipDiscountPromptModel vipDiscountPromptModel) {
                    m2488invoke(vipDiscountPromptModel);
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m2488invoke(VipDiscountPromptModel vipDiscountPromptModel) {
                    MutableLiveData mutableLiveData;
                    mutableLiveData = ChatSessionViewModel.this._showDiscountPrompt;
                    mutableLiveData.setValue(vipDiscountPromptModel);
                }
            }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.chat.viewmodel.ChatSessionViewModel$showDiscountPrompt$2
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Boolean invoke(@NotNull Throwable it) {
                    s.i(it, "it");
                    return Boolean.TRUE;
                }
            }, null)));
            if (disposed != null) {
                s.h(disposed, "disposed");
            }
            s.h(disposed, "disposed");
        }
    }

    public final void updateSessionCountDown() {
        Iterator<InboxSessionModel> iterator2 = SessionLocalListUtil.f13179a.d().iterator2();
        while (iterator2.hasNext()) {
            InboxSessionModel next = iterator2.next();
            Integer countdown = next.getCountdown();
            int intValue = countdown != null ? countdown.intValue() : 0;
            if (intValue > 0) {
                next.setCountdown(Integer.valueOf(intValue - 1));
                Integer countdown2 = next.getCountdown();
                if ((countdown2 != null ? countdown2.intValue() : 0) <= 0) {
                    iterator2.remove();
                }
            }
        }
        updateSessionListData();
    }

    public final void updateSessionList() {
        updateSessionListData();
    }

    public final void updateSessionMaskRemain() {
        Iterator<InboxSessionModel> iterator2 = SessionLocalListUtil.f13179a.d().iterator2();
        while (iterator2.hasNext()) {
            InboxSessionModel next = iterator2.next();
            Integer maskRemainSec = next.getMaskRemainSec();
            int intValue = maskRemainSec != null ? maskRemainSec.intValue() : 0;
            if (intValue > 0) {
                next.setMaskRemainSec(Integer.valueOf(intValue - 60));
                Integer maskRemainSec2 = next.getMaskRemainSec();
                if ((maskRemainSec2 != null ? maskRemainSec2.intValue() : 0) <= 0) {
                    iterator2.remove();
                }
            }
        }
        updateSessionListData();
    }
}

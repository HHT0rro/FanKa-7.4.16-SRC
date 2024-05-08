package com.cupidapp.live.chat.activity;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.livedata.Event;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.i;
import com.cupidapp.live.base.network.model.StateResult;
import com.cupidapp.live.base.sensorslog.FKSensorContext;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.view.h;
import com.cupidapp.live.chat.model.AfterModifyChatStateModel;
import com.cupidapp.live.chat.model.ChatRecommendModel;
import com.cupidapp.live.profile.model.PostLimitReadStatus;
import com.cupidapp.live.profile.model.User;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p1.g;

/* compiled from: ChatStateViewModel.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ChatStateViewModel extends ViewModel {

    @NotNull
    private final MutableLiveData<Event<Boolean>> _defaultShowChangeStateEvent;

    @NotNull
    private final MutableLiveData<StateResult<Pair<List<User>, Boolean>>> _listLiveData;

    @NotNull
    private final MutableLiveData<Event<User>> _openUserChatEvent;

    @NotNull
    private final MutableLiveData<User> _selectUserLiveData;

    @NotNull
    private final FKSensorContext currentSensorContext;

    @Nullable
    private String defaultSubTitle;

    @NotNull
    private final LiveData<StateResult<Pair<List<User>, Boolean>>> listLiveData;

    @NotNull
    private final LiveData<Event<User>> openUserChatEvent;

    @NotNull
    private final LiveData<User> selectUserLiveData;

    @NotNull
    private final LiveData<Event<Boolean>> showChangeStateEvent;

    public ChatStateViewModel(@NotNull FKSensorContext currentSensorContext) {
        s.i(currentSensorContext, "currentSensorContext");
        this.currentSensorContext = currentSensorContext;
        MutableLiveData<StateResult<Pair<List<User>, Boolean>>> mutableLiveData = new MutableLiveData<>();
        this._listLiveData = mutableLiveData;
        this.listLiveData = mutableLiveData;
        MutableLiveData<User> mutableLiveData2 = new MutableLiveData<>();
        mutableLiveData2.setValue(g.f52734a.X());
        this._selectUserLiveData = mutableLiveData2;
        this.selectUserLiveData = mutableLiveData2;
        MutableLiveData<Event<User>> mutableLiveData3 = new MutableLiveData<>();
        this._openUserChatEvent = mutableLiveData3;
        this.openUserChatEvent = mutableLiveData3;
        MutableLiveData<Event<Boolean>> mutableLiveData4 = new MutableLiveData<>();
        this._defaultShowChangeStateEvent = mutableLiveData4;
        this.showChangeStateEvent = mutableLiveData4;
        loadData(true);
    }

    public final void clearState() {
        Disposable disposed = NetworkClient.f11868a.h().r(null).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<AfterModifyChatStateModel, p>() { // from class: com.cupidapp.live.chat.activity.ChatStateViewModel$clearState$$inlined$handle$default$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(AfterModifyChatStateModel afterModifyChatStateModel) {
                m2481invoke(afterModifyChatStateModel);
                return p.f51048a;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2481invoke(AfterModifyChatStateModel afterModifyChatStateModel) {
                MutableLiveData mutableLiveData;
                User user;
                MutableLiveData mutableLiveData2;
                MutableLiveData mutableLiveData3;
                Object obj;
                Pair pair;
                h.f12779a.l(null, R$string.end_state_suc);
                mutableLiveData = ChatStateViewModel.this._listLiveData;
                StateResult stateResult = (StateResult) mutableLiveData.getValue();
                List list = (stateResult == null || (pair = (Pair) stateResult.getData()) == null) ? null : (List) pair.getFirst();
                if (list != null) {
                    Iterator<E> iterator2 = list.iterator2();
                    while (true) {
                        if (!iterator2.hasNext()) {
                            obj = null;
                            break;
                        }
                        obj = iterator2.next();
                        String userId = ((User) obj).userId();
                        User X = g.f52734a.X();
                        if (s.d(userId, X != null ? X.userId() : null)) {
                            break;
                        }
                    }
                    user = (User) obj;
                } else {
                    user = null;
                }
                if (user != null) {
                    user.setChatStatus(null);
                    user.setChatStatusTime(null);
                    mutableLiveData2 = ChatStateViewModel.this._listLiveData;
                    mutableLiveData2.setValue(new StateResult.c(new Pair(list, Boolean.TRUE), null, 2, null));
                    mutableLiveData3 = ChatStateViewModel.this._selectUserLiveData;
                    mutableLiveData3.setValue(user);
                }
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    @NotNull
    public final FKSensorContext getCurrentSensorContext() {
        return this.currentSensorContext;
    }

    @Nullable
    public final String getDefaultSubTitle() {
        return this.defaultSubTitle;
    }

    @NotNull
    public final LiveData<StateResult<Pair<List<User>, Boolean>>> getListLiveData() {
        return this.listLiveData;
    }

    @NotNull
    public final LiveData<Event<User>> getOpenUserChatEvent() {
        return this.openUserChatEvent;
    }

    @NotNull
    public final LiveData<User> getSelectUserLiveData() {
        return this.selectUserLiveData;
    }

    @NotNull
    public final LiveData<Event<Boolean>> getShowChangeStateEvent() {
        return this.showChangeStateEvent;
    }

    public final void loadData(final boolean z10) {
        if (this.listLiveData.getValue() instanceof StateResult.b) {
            return;
        }
        this._listLiveData.setValue(new StateResult.b(null, null, 3, null));
        Disposable disposed = NetworkClient.f11868a.h().o().flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<ChatRecommendModel, p>() { // from class: com.cupidapp.live.chat.activity.ChatStateViewModel$loadData$$inlined$handle$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(ChatRecommendModel chatRecommendModel) {
                m2482invoke(chatRecommendModel);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2482invoke(ChatRecommendModel chatRecommendModel) {
                MutableLiveData mutableLiveData;
                MutableLiveData mutableLiveData2;
                MutableLiveData mutableLiveData3;
                ChatRecommendModel chatRecommendModel2 = chatRecommendModel;
                ChatStateViewModel.this.setDefaultSubTitle(chatRecommendModel2.getMessage());
                if (chatRecommendModel2.getUser() != null) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(chatRecommendModel2.getUser());
                    List<User> list = chatRecommendModel2.getList();
                    if (!(list == null || list.isEmpty())) {
                        arrayList.addAll(chatRecommendModel2.getList());
                    }
                    mutableLiveData2 = ChatStateViewModel.this._selectUserLiveData;
                    mutableLiveData2.setValue(chatRecommendModel2.getUser());
                    mutableLiveData3 = ChatStateViewModel.this._listLiveData;
                    mutableLiveData3.setValue(new StateResult.c(new Pair(arrayList, Boolean.TRUE), null, 2, null));
                }
                mutableLiveData = ChatStateViewModel.this._defaultShowChangeStateEvent;
                mutableLiveData.setValue(new Event(Boolean.valueOf(z10 && chatRecommendModel2.getAlert() && ChatStateViewModel.this.getCurrentSensorContext().getSource() != SensorPosition.RecommendedChat)));
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.chat.activity.ChatStateViewModel$loadData$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                MutableLiveData mutableLiveData;
                s.i(it, "it");
                mutableLiveData = ChatStateViewModel.this._listLiveData;
                mutableLiveData.setValue(new StateResult.a(null, null, null, 7, null));
                return Boolean.FALSE;
            }
        }, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    public final void refreshReadStatus(@NotNull Set<String> userIds) {
        Pair<List<User>, Boolean> data;
        s.i(userIds, "userIds");
        StateResult<Pair<List<User>, Boolean>> value = this._listLiveData.getValue();
        List<User> first = (value == null || (data = value.getData()) == null) ? null : data.getFirst();
        if (first == null || first.isEmpty()) {
            return;
        }
        for (User user : first) {
            if (userIds.contains(user.userId())) {
                user.setReadStatus(PostLimitReadStatus.Read.getValue());
                User value2 = this.selectUserLiveData.getValue();
                if (s.d(value2 != null ? value2.userId() : null, user.userId())) {
                    this._selectUserLiveData.setValue(user);
                }
            }
        }
        this._listLiveData.setValue(new StateResult.c(new Pair(first, Boolean.FALSE), null, 2, null));
    }

    public final void sendGreet(@NotNull String emoJiCode) {
        s.i(emoJiCode, "emoJiCode");
        final User value = this.selectUserLiveData.getValue();
        if (value == null) {
            return;
        }
        Disposable disposed = NetworkClient.f11868a.h().k(value.userId(), emoJiCode).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<Object, p>() { // from class: com.cupidapp.live.chat.activity.ChatStateViewModel$sendGreet$$inlined$handle$default$1
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
                mutableLiveData = ChatStateViewModel.this._openUserChatEvent;
                mutableLiveData.setValue(new Event(value));
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    public final void setDefaultSubTitle(@Nullable String str) {
        this.defaultSubTitle = str;
    }

    public final void userIsSelected(@NotNull User user) {
        s.i(user, "user");
        this._selectUserLiveData.setValue(user);
    }
}

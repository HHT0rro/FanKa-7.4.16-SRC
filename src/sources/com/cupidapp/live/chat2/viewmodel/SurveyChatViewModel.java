package com.cupidapp.live.chat2.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.cupidapp.live.base.livedata.Event;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.e;
import com.cupidapp.live.base.network.i;
import com.cupidapp.live.base.network.model.ListResult;
import com.cupidapp.live.base.sensorslog.PopupName;
import com.cupidapp.live.chat2.model.BaseSurveyChatMessageModel;
import com.cupidapp.live.chat2.model.SurveyChatMessageModel;
import com.cupidapp.live.chat2.model.SurveyChatMessageResult;
import com.cupidapp.live.chat2.model.SurveyChatOptionsMessageModel;
import com.cupidapp.live.chat2.model.SurveyChatUserInfoModel;
import com.cupidapp.live.profile.model.User;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;

/* compiled from: SurveyChatViewModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class SurveyChatViewModel extends ViewModel {

    @NotNull
    private final MutableLiveData<Event<User>> _openProfileEventLiveData;

    @NotNull
    private final MutableLiveData<Pair<String, String>> _refreshMessageStatusLiveData;

    @NotNull
    private final MutableLiveData<List<BaseSurveyChatMessageModel>> _surveyChatMessageListLiveData;

    @NotNull
    private final MutableLiveData<SurveyChatUserInfoModel> _surveyChatUserInfoLiveData;

    @NotNull
    private final LiveData<Event<User>> openProfileEventLiveData;

    @NotNull
    private final LiveData<Pair<String, String>> refreshMessageStatusLiveData;

    @NotNull
    private final LiveData<List<BaseSurveyChatMessageModel>> surveyChatMessageListLiveData;

    @NotNull
    private final LiveData<SurveyChatUserInfoModel> surveyChatUserInfoLiveData;

    public SurveyChatViewModel() {
        MutableLiveData<SurveyChatUserInfoModel> mutableLiveData = new MutableLiveData<>();
        this._surveyChatUserInfoLiveData = mutableLiveData;
        this.surveyChatUserInfoLiveData = mutableLiveData;
        MutableLiveData<List<BaseSurveyChatMessageModel>> mutableLiveData2 = new MutableLiveData<>();
        this._surveyChatMessageListLiveData = mutableLiveData2;
        this.surveyChatMessageListLiveData = mutableLiveData2;
        MutableLiveData<Pair<String, String>> mutableLiveData3 = new MutableLiveData<>();
        this._refreshMessageStatusLiveData = mutableLiveData3;
        this.refreshMessageStatusLiveData = mutableLiveData3;
        MutableLiveData<Event<User>> mutableLiveData4 = new MutableLiveData<>();
        this._openProfileEventLiveData = mutableLiveData4;
        this.openProfileEventLiveData = mutableLiveData4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<BaseSurveyChatMessageModel> getMessageList(User user, List<SurveyChatMessageModel> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<SurveyChatMessageModel> iterator2 = list.iterator2();
        while (iterator2.hasNext()) {
            BaseSurveyChatMessageModel messageModel = iterator2.next().getMessageModel(user);
            if (messageModel != null) {
                arrayList.add(messageModel);
            }
        }
        return arrayList;
    }

    @NotNull
    public final LiveData<Event<User>> getOpenProfileEventLiveData() {
        return this.openProfileEventLiveData;
    }

    public final void getOperationMessageInfo(@NotNull String chatId) {
        s.i(chatId, "chatId");
        Disposable disposed = NetworkClient.f11868a.h().m(chatId).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<SurveyChatMessageResult, p>() { // from class: com.cupidapp.live.chat2.viewmodel.SurveyChatViewModel$getOperationMessageInfo$$inlined$handle$default$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(SurveyChatMessageResult surveyChatMessageResult) {
                m2505invoke(surveyChatMessageResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2505invoke(SurveyChatMessageResult surveyChatMessageResult) {
                MutableLiveData mutableLiveData;
                MutableLiveData mutableLiveData2;
                List messageList;
                SurveyChatMessageResult surveyChatMessageResult2 = surveyChatMessageResult;
                mutableLiveData = SurveyChatViewModel.this._surveyChatUserInfoLiveData;
                mutableLiveData.setValue(new SurveyChatUserInfoModel(surveyChatMessageResult2.getSender(), surveyChatMessageResult2.getTopTips()));
                List<SurveyChatMessageModel> list = surveyChatMessageResult2.getList();
                if (list == null || list.isEmpty()) {
                    return;
                }
                mutableLiveData2 = SurveyChatViewModel.this._surveyChatMessageListLiveData;
                messageList = SurveyChatViewModel.this.getMessageList(surveyChatMessageResult2.getSender(), surveyChatMessageResult2.getList());
                mutableLiveData2.setValue(messageList);
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(null, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    @NotNull
    public final LiveData<Pair<String, String>> getRefreshMessageStatusLiveData() {
        return this.refreshMessageStatusLiveData;
    }

    @NotNull
    public final LiveData<List<BaseSurveyChatMessageModel>> getSurveyChatMessageListLiveData() {
        return this.surveyChatMessageListLiveData;
    }

    @NotNull
    public final LiveData<SurveyChatUserInfoModel> getSurveyChatUserInfoLiveData() {
        return this.surveyChatUserInfoLiveData;
    }

    public final void openProfile() {
        User sender;
        SurveyChatUserInfoModel value = this._surveyChatUserInfoLiveData.getValue();
        if (value == null || (sender = value.getSender()) == null) {
            return;
        }
        this._openProfileEventLiveData.setValue(new Event<>(sender));
    }

    public final void selectOption(@NotNull String chatId, @NotNull final String msgId, @NotNull final String optionId) {
        final User sender;
        s.i(chatId, "chatId");
        s.i(msgId, "msgId");
        s.i(optionId, "optionId");
        SurveyChatUserInfoModel value = this._surveyChatUserInfoLiveData.getValue();
        if (value == null || (sender = value.getSender()) == null) {
            return;
        }
        Disposable disposed = NetworkClient.f11868a.h().f(chatId, msgId, optionId).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<ListResult<SurveyChatMessageModel>, p>() { // from class: com.cupidapp.live.chat2.viewmodel.SurveyChatViewModel$selectOption$$inlined$handle$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(ListResult<SurveyChatMessageModel> listResult) {
                m2506invoke(listResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2506invoke(ListResult<SurveyChatMessageModel> listResult) {
                MutableLiveData mutableLiveData;
                List<BaseSurveyChatMessageModel> messageList;
                MutableLiveData mutableLiveData2;
                ListResult<SurveyChatMessageModel> listResult2 = listResult;
                mutableLiveData = SurveyChatViewModel.this._refreshMessageStatusLiveData;
                mutableLiveData.setValue(new Pair(msgId, optionId));
                List<SurveyChatMessageModel> list = listResult2.getList();
                if (list == null || list.isEmpty()) {
                    return;
                }
                SurveyChatViewModel surveyChatViewModel = SurveyChatViewModel.this;
                User user = sender;
                List<SurveyChatMessageModel> list2 = listResult2.getList();
                s.f(list2);
                messageList = surveyChatViewModel.getMessageList(user, list2);
                mutableLiveData2 = SurveyChatViewModel.this._surveyChatMessageListLiveData;
                mutableLiveData2.setValue(messageList);
                for (BaseSurveyChatMessageModel baseSurveyChatMessageModel : messageList) {
                    if (baseSurveyChatMessageModel instanceof SurveyChatOptionsMessageModel) {
                        j1.i.g(j1.i.f50236a, PopupName.MESSAGE_OPTION_BOX, null, ((SurveyChatOptionsMessageModel) baseSurveyChatMessageModel).getContent(), 2, null);
                    }
                }
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(null, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }
}

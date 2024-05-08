package com.cupidapp.live.chat.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.model.ListResult;
import com.cupidapp.live.chat.model.ChatStatusItemModel;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;

/* compiled from: ChatStatusViewModel.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ChatStatusViewModel extends ViewModel {

    @NotNull
    private final MutableLiveData<List<ChatStatusItemModel>> _chatStatusListLiveData;

    @NotNull
    private final LiveData<List<ChatStatusItemModel>> chatStatusListLiveData;

    public ChatStatusViewModel() {
        MutableLiveData<List<ChatStatusItemModel>> mutableLiveData = new MutableLiveData<>();
        this._chatStatusListLiveData = mutableLiveData;
        this.chatStatusListLiveData = Transformations.distinctUntilChanged(mutableLiveData);
    }

    @NotNull
    public final LiveData<List<ChatStatusItemModel>> getChatStatusListLiveData() {
        return this.chatStatusListLiveData;
    }

    public final void loadChatStatusList() {
        Disposable disposed = NetworkClient.f11868a.h().g().flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<ListResult<ChatStatusItemModel>, p>() { // from class: com.cupidapp.live.chat.viewmodel.ChatStatusViewModel$loadChatStatusList$$inlined$handle$default$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(ListResult<ChatStatusItemModel> listResult) {
                m2489invoke(listResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2489invoke(ListResult<ChatStatusItemModel> listResult) {
                MutableLiveData mutableLiveData;
                mutableLiveData = ChatStatusViewModel.this._chatStatusListLiveData;
                List<ChatStatusItemModel> list = listResult.getList();
                if (list == null) {
                    list = new ArrayList<>();
                }
                mutableLiveData.setValue(list);
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }
}

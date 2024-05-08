package com.cupidapp.live.main.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.cupidapp.live.base.abtest.ABTestGroup;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.e;
import com.cupidapp.live.base.network.i;
import com.cupidapp.live.base.network.model.ABTestKey;
import com.cupidapp.live.base.network.model.ABTestListResult;
import com.cupidapp.live.base.network.model.ABTestModel;
import com.cupidapp.live.base.network.model.ListResult;
import com.cupidapp.live.chat2.fragment.ChatDetailFragment;
import com.cupidapp.live.chat2.model.MessageBubbleModel;
import e1.a;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.List;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import p1.g;

/* compiled from: MainViewModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MainViewModel extends ViewModel {

    @NotNull
    private final MutableLiveData<List<String>> _allBubbleUrlList;

    @NotNull
    private final LiveData<List<String>> allBubbleUrlList;

    public MainViewModel() {
        MutableLiveData<List<String>> mutableLiveData = new MutableLiveData<>();
        this._allBubbleUrlList = mutableLiveData;
        this.allBubbleUrlList = mutableLiveData;
    }

    public final void callAllBubbleUrlApi() {
        Disposable disposed = NetworkClient.f11868a.h().w().flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<ListResult<String>, p>() { // from class: com.cupidapp.live.main.viewmodel.MainViewModel$callAllBubbleUrlApi$$inlined$handle$default$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(ListResult<String> listResult) {
                m2677invoke(listResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2677invoke(ListResult<String> listResult) {
                MutableLiveData mutableLiveData;
                List<String> list = listResult.getList();
                if (list != null) {
                    mutableLiveData = MainViewModel.this._allBubbleUrlList;
                    mutableLiveData.setValue(list);
                }
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(null, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    public final void callMyMessageBubbleApi() {
        Disposable disposed = NetworkClient.f11868a.h().l().flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<MessageBubbleModel, p>() { // from class: com.cupidapp.live.main.viewmodel.MainViewModel$callMyMessageBubbleApi$$inlined$handle$default$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(MessageBubbleModel messageBubbleModel) {
                m2678invoke(messageBubbleModel);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2678invoke(MessageBubbleModel messageBubbleModel) {
                ChatDetailFragment.f13305o.e(messageBubbleModel);
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(null, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    public final void getAbTest() {
        Disposable disposed = a.C0726a.a(NetworkClient.f11868a.i(), null, 1, null).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<ABTestListResult, p>() { // from class: com.cupidapp.live.main.viewmodel.MainViewModel$getAbTest$$inlined$handle$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(ABTestListResult aBTestListResult) {
                m2679invoke(aBTestListResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2679invoke(ABTestListResult aBTestListResult) {
                List<ABTestModel> testResults = aBTestListResult.getTestResults();
                if (testResults != null) {
                    for (ABTestModel aBTestModel : testResults) {
                        String name = aBTestModel.getName();
                        if (s.d(name, ABTestKey.RETRIEVE_ALOHA_NOTIFY.getValue())) {
                            g.f52734a.C3(!s.d(aBTestModel.getResult(), ABTestGroup.A.getValue()));
                        } else if (s.d(name, ABTestKey.VISITOR_NEW_TEST.getValue())) {
                            g.f52734a.H2(aBTestModel.getResult());
                        }
                    }
                }
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.main.viewmodel.MainViewModel$getAbTest$2
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                s.i(it, "it");
                g gVar = g.f52734a;
                gVar.C3(false);
                gVar.H2(ABTestGroup.A.getValue());
                return Boolean.TRUE;
            }
        }, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    @NotNull
    public final LiveData<List<String>> getAllBubbleUrlList() {
        return this.allBubbleUrlList;
    }
}

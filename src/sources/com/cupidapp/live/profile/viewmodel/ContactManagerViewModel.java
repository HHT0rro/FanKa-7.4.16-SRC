package com.cupidapp.live.profile.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.e;
import com.cupidapp.live.base.network.i;
import com.cupidapp.live.profile.model.UnfollowNotifyModel;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;

/* compiled from: ContactManagerViewModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class ContactManagerViewModel extends ViewModel {

    @NotNull
    private final MutableLiveData<Integer> _unFollowRemindLiveData;

    @NotNull
    private final LiveData<Integer> unFollowRemindLiveData;

    public ContactManagerViewModel() {
        MutableLiveData<Integer> mutableLiveData = new MutableLiveData<>();
        this._unFollowRemindLiveData = mutableLiveData;
        this.unFollowRemindLiveData = mutableLiveData;
        loadData();
    }

    public final void changeUnFollowRemind(@NotNull final CancelFollowRemindRange range) {
        s.i(range, "range");
        Disposable disposed = NetworkClient.f11868a.N().g(range.getValue()).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<Object, p>() { // from class: com.cupidapp.live.profile.viewmodel.ContactManagerViewModel$changeUnFollowRemind$$inlined$handle$default$1
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
                mutableLiveData = ContactManagerViewModel.this._unFollowRemindLiveData;
                mutableLiveData.setValue(Integer.valueOf(range.getValue()));
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(null, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    @NotNull
    public final LiveData<Integer> getUnFollowRemindLiveData() {
        return this.unFollowRemindLiveData;
    }

    public final void loadData() {
        Disposable disposed = NetworkClient.f11868a.N().L().flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<UnfollowNotifyModel, p>() { // from class: com.cupidapp.live.profile.viewmodel.ContactManagerViewModel$loadData$$inlined$handle$default$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(UnfollowNotifyModel unfollowNotifyModel) {
                m2769invoke(unfollowNotifyModel);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2769invoke(UnfollowNotifyModel unfollowNotifyModel) {
                MutableLiveData mutableLiveData;
                mutableLiveData = ContactManagerViewModel.this._unFollowRemindLiveData;
                mutableLiveData.setValue(Integer.valueOf(unfollowNotifyModel.getUnfollowNotifyRange()));
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(null, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }
}

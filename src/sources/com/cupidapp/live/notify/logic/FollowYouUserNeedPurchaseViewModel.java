package com.cupidapp.live.notify.logic;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.e;
import com.cupidapp.live.base.network.i;
import com.cupidapp.live.base.network.model.StateResult;
import com.cupidapp.live.base.network.model.SwipeCardUserLikeResult;
import com.cupidapp.live.base.recyclerview.model.FKBlankSpaceModel;
import com.cupidapp.live.base.recyclerview.model.FKEmptyViewModel;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.notify.viewholder.NotifyTopTitleUiModel;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.profile.model.UserListResult;
import com.cupidapp.live.track.group.GroupOthersLog;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.List;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import x2.a;
import z0.h;

/* compiled from: FollowYouUserNeedPurchaseViewModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FollowYouUserNeedPurchaseViewModel extends ViewModel {

    @NotNull
    private final MutableLiveData<StateResult<List<Object>>> _listLiveData;

    @NotNull
    private final MutableLiveData<Boolean> _showBuyBtn;

    @NotNull
    private final MutableLiveData<User> _userFollowedLiveData;

    @NotNull
    private final LiveData<StateResult<List<Object>>> listLiveData;

    @NotNull
    private final LiveData<Boolean> showBuyBtn;

    @NotNull
    private final LiveData<User> userFollowed;

    public FollowYouUserNeedPurchaseViewModel() {
        MutableLiveData<StateResult<List<Object>>> mutableLiveData = new MutableLiveData<>();
        this._listLiveData = mutableLiveData;
        this.listLiveData = Transformations.distinctUntilChanged(mutableLiveData);
        MutableLiveData<Boolean> mutableLiveData2 = new MutableLiveData<>();
        this._showBuyBtn = mutableLiveData2;
        this.showBuyBtn = Transformations.distinctUntilChanged(mutableLiveData2);
        MutableLiveData<User> mutableLiveData3 = new MutableLiveData<>();
        this._userFollowedLiveData = mutableLiveData3;
        this.userFollowed = Transformations.distinctUntilChanged(mutableLiveData3);
    }

    public final void followUser(@Nullable String str) {
        if (str == null) {
            return;
        }
        Disposable disposed = a.C0836a.o(NetworkClient.f11868a.N(), str, null, null, null, 0, null, null, null, 254, null).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<SwipeCardUserLikeResult, p>() { // from class: com.cupidapp.live.notify.logic.FollowYouUserNeedPurchaseViewModel$followUser$$inlined$handle$default$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(SwipeCardUserLikeResult swipeCardUserLikeResult) {
                m2752invoke(swipeCardUserLikeResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2752invoke(SwipeCardUserLikeResult swipeCardUserLikeResult) {
                MutableLiveData mutableLiveData;
                mutableLiveData = FollowYouUserNeedPurchaseViewModel.this._userFollowedLiveData;
                mutableLiveData.setValue(swipeCardUserLikeResult.getUser());
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(null, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    @NotNull
    public final LiveData<StateResult<List<Object>>> getListLiveData() {
        return this.listLiveData;
    }

    @NotNull
    public final LiveData<Boolean> getShowBuyBtn() {
        return this.showBuyBtn;
    }

    @NotNull
    public final LiveData<User> getUserFollowed() {
        return this.userFollowed;
    }

    public final void loadData() {
        if (this.listLiveData.getValue() instanceof StateResult.b) {
            return;
        }
        this._listLiveData.setValue(new StateResult.b(null, null, 3, null));
        Disposable disposed = a.C0836a.v(NetworkClient.f11868a.N(), null, 1, null).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<UserListResult, p>() { // from class: com.cupidapp.live.notify.logic.FollowYouUserNeedPurchaseViewModel$loadData$$inlined$handle$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(UserListResult userListResult) {
                m2753invoke(userListResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2753invoke(UserListResult userListResult) {
                MutableLiveData mutableLiveData;
                MutableLiveData mutableLiveData2;
                UserListResult userListResult2 = userListResult;
                mutableLiveData = FollowYouUserNeedPurchaseViewModel.this._showBuyBtn;
                List<User> list = userListResult2.getList();
                mutableLiveData.setValue(Boolean.valueOf(!(list == null || list.isEmpty()) && userListResult2.getSvipRequired()));
                ArrayList arrayList = new ArrayList();
                List<User> list2 = userListResult2.getList();
                if (list2 == null || list2.isEmpty()) {
                    arrayList.add(new FKEmptyViewModel(null, Integer.valueOf(R$string.empty_list_prompt), null, null, null, null, null, false, null, null, 1021, null));
                } else {
                    String title = userListResult2.getTitle();
                    if (title != null) {
                        arrayList.add(new NotifyTopTitleUiModel(title));
                    }
                    List<User> list3 = userListResult2.getList();
                    if (list3 != null) {
                        arrayList.addAll(list3);
                    }
                    if (userListResult2.getSvipRequired()) {
                        arrayList.add(new FKBlankSpaceModel(Integer.valueOf(h.c(FollowYouUserNeedPurchaseViewModel.this, 85.0f))));
                    } else {
                        arrayList.add(new FKBlankSpaceModel(Integer.valueOf(h.c(FollowYouUserNeedPurchaseViewModel.this, 10.0f))));
                    }
                }
                mutableLiveData2 = FollowYouUserNeedPurchaseViewModel.this._listLiveData;
                mutableLiveData2.setValue(new StateResult.c(arrayList, null, 2, null));
                GroupOthersLog.f18702a.T(SensorPosition.MyAlohaGet, Boolean.valueOf(!userListResult2.getSvipRequired()));
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.notify.logic.FollowYouUserNeedPurchaseViewModel$loadData$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                MutableLiveData mutableLiveData;
                MutableLiveData mutableLiveData2;
                s.i(it, "it");
                StateResult<List<Object>> value = FollowYouUserNeedPurchaseViewModel.this.getListLiveData().getValue();
                List<Object> data = value != null ? value.getData() : null;
                if (data == null || data.isEmpty()) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new FKEmptyViewModel(null, 2131887526, null, null, null, null, null, false, null, null, 1021, null));
                    mutableLiveData = FollowYouUserNeedPurchaseViewModel.this._showBuyBtn;
                    mutableLiveData.setValue(Boolean.FALSE);
                    mutableLiveData2 = FollowYouUserNeedPurchaseViewModel.this._listLiveData;
                    mutableLiveData2.setValue(new StateResult.a(null, arrayList, null, 5, null));
                }
                return Boolean.TRUE;
            }
        }, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    public final void refreshFollowButton(@NotNull User user) {
        s.i(user, "user");
        this._userFollowedLiveData.setValue(user);
    }
}

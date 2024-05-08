package com.cupidapp.live.match.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import b3.a;
import com.cupidapp.live.base.livedata.Event;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.model.ListResult;
import com.cupidapp.live.base.network.model.StateResult;
import com.cupidapp.live.match.model.NearbyUserModel;
import com.cupidapp.live.superboost.model.RemainAssetsResult;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: NearbySuperBoostViewModel.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class NearbySuperBoostViewModel extends ViewModel {

    @NotNull
    private final MutableLiveData<Pair<List<NearbyUserModel>, Boolean>> _moreSuperBoostLiveData;

    @NotNull
    private final MutableLiveData<Event<Boolean>> _openSuperBoostEventLiveData;

    @NotNull
    private final MutableLiveData<Event<Pair<RemainAssetsResult, Boolean>>> _showBoostTimeEventLiveData;

    @NotNull
    private final MutableLiveData<StateResult<ListResult<NearbyUserModel>>> _superBoostUserListLiveData;

    @NotNull
    private final LiveData<Pair<List<NearbyUserModel>, Boolean>> moreSuperBoostLiveData;

    @Nullable
    private String nextCursorId;

    @NotNull
    private final LiveData<Event<Boolean>> openSuperBoostEventLiveData;

    @NotNull
    private final LiveData<Event<Pair<RemainAssetsResult, Boolean>>> showBoostTimeEventLiveData;

    @NotNull
    private final LiveData<StateResult<ListResult<NearbyUserModel>>> superBoostUserListLiveData;

    public NearbySuperBoostViewModel() {
        MutableLiveData<StateResult<ListResult<NearbyUserModel>>> mutableLiveData = new MutableLiveData<>();
        this._superBoostUserListLiveData = mutableLiveData;
        this.superBoostUserListLiveData = mutableLiveData;
        MutableLiveData<Pair<List<NearbyUserModel>, Boolean>> mutableLiveData2 = new MutableLiveData<>();
        this._moreSuperBoostLiveData = mutableLiveData2;
        this.moreSuperBoostLiveData = mutableLiveData2;
        MutableLiveData<Event<Boolean>> mutableLiveData3 = new MutableLiveData<>();
        this._openSuperBoostEventLiveData = mutableLiveData3;
        this.openSuperBoostEventLiveData = mutableLiveData3;
        MutableLiveData<Event<Pair<RemainAssetsResult, Boolean>>> mutableLiveData4 = new MutableLiveData<>();
        this._showBoostTimeEventLiveData = mutableLiveData4;
        this.showBoostTimeEventLiveData = mutableLiveData4;
    }

    public static /* synthetic */ void getNearbySuperBoost$default(NearbySuperBoostViewModel nearbySuperBoostViewModel, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = null;
        }
        nearbySuperBoostViewModel.getNearbySuperBoost(str);
    }

    @NotNull
    public final LiveData<Pair<List<NearbyUserModel>, Boolean>> getMoreSuperBoostLiveData() {
        return this.moreSuperBoostLiveData;
    }

    public final void getNearbySuperBoost(@Nullable final String str) {
        Disposable disposed = a.C0021a.a(NetworkClient.f11868a.A(), str, 0, 2, null).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<ListResult<NearbyUserModel>, kotlin.p>() { // from class: com.cupidapp.live.match.viewmodel.NearbySuperBoostViewModel$getNearbySuperBoost$$inlined$handle$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(ListResult<NearbyUserModel> listResult) {
                m2730invoke(listResult);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2730invoke(ListResult<NearbyUserModel> listResult) {
                MutableLiveData mutableLiveData;
                String str2;
                MutableLiveData mutableLiveData2;
                ListResult<NearbyUserModel> listResult2 = listResult;
                NearbySuperBoostViewModel.this.nextCursorId = listResult2.getNextCursorId();
                if (str == null) {
                    mutableLiveData2 = NearbySuperBoostViewModel.this._superBoostUserListLiveData;
                    mutableLiveData2.setValue(new StateResult.c(listResult2, null, 2, null));
                    return;
                }
                List<NearbyUserModel> list = listResult2.getList();
                if (list != null) {
                    mutableLiveData = NearbySuperBoostViewModel.this._moreSuperBoostLiveData;
                    str2 = NearbySuperBoostViewModel.this.nextCursorId;
                    mutableLiveData.setValue(new Pair(list, Boolean.valueOf(str2 == null || str2.length() == 0)));
                }
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.match.viewmodel.NearbySuperBoostViewModel$getNearbySuperBoost$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                MutableLiveData mutableLiveData;
                kotlin.jvm.internal.s.i(it, "it");
                if (String.this == null) {
                    mutableLiveData = this._superBoostUserListLiveData;
                    mutableLiveData.setValue(new StateResult.a(null, null, null, 7, null));
                }
                return Boolean.FALSE;
            }
        }, null)));
        if (disposed != null) {
            kotlin.jvm.internal.s.h(disposed, "disposed");
        }
        kotlin.jvm.internal.s.h(disposed, "disposed");
    }

    @NotNull
    public final LiveData<Event<Boolean>> getOpenSuperBoostEventLiveData() {
        return this.openSuperBoostEventLiveData;
    }

    @NotNull
    public final LiveData<Event<Pair<RemainAssetsResult, Boolean>>> getShowBoostTimeEventLiveData() {
        return this.showBoostTimeEventLiveData;
    }

    @NotNull
    public final LiveData<StateResult<ListResult<NearbyUserModel>>> getSuperBoostUserListLiveData() {
        return this.superBoostUserListLiveData;
    }

    public final void loadMoreSuperBoost() {
        String str = this.nextCursorId;
        if (str == null || str.length() == 0) {
            return;
        }
        getNearbySuperBoost(this.nextCursorId);
    }
}

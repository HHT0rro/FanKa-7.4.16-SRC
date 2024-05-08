package com.cupidapp.live.profile.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.e;
import com.cupidapp.live.base.network.i;
import com.cupidapp.live.base.network.model.StateResult;
import com.cupidapp.live.profile.model.AlohaCancelListModel;
import com.cupidapp.live.profile.model.AlohaCancelUserModel;
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

/* compiled from: AlohaCancelViewModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class AlohaCancelViewModel extends ViewModel {

    @NotNull
    private final MutableLiveData<StateResult<List<AlohaCancelUserModel>>> _listLiveData;

    @NotNull
    private final MutableLiveData<Boolean> _showBuyBtn;

    @NotNull
    private final LiveData<StateResult<List<AlohaCancelUserModel>>> listLiveData;

    @Nullable
    private String nextCursorId;

    @NotNull
    private final LiveData<Boolean> showBuyBtn;

    public AlohaCancelViewModel() {
        MutableLiveData<StateResult<List<AlohaCancelUserModel>>> mutableLiveData = new MutableLiveData<>();
        this._listLiveData = mutableLiveData;
        this.listLiveData = Transformations.distinctUntilChanged(mutableLiveData);
        MutableLiveData<Boolean> mutableLiveData2 = new MutableLiveData<>();
        this._showBuyBtn = mutableLiveData2;
        this.showBuyBtn = Transformations.distinctUntilChanged(mutableLiveData2);
        getData(false);
    }

    private final void getData(final boolean z10) {
        if (this.listLiveData.getValue() instanceof StateResult.b) {
            StateResult<List<AlohaCancelUserModel>> value = this.listLiveData.getValue();
            if (value != null ? s.d(value.isLoadMore(), Boolean.FALSE) : false) {
                return;
            }
        }
        if (!z10) {
            this.nextCursorId = null;
        }
        this._listLiveData.setValue(new StateResult.b(null, Boolean.valueOf(z10), 1, null));
        Disposable disposed = NetworkClient.f11868a.N().u(this.nextCursorId).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<AlohaCancelListModel, p>() { // from class: com.cupidapp.live.profile.viewmodel.AlohaCancelViewModel$getData$$inlined$handle$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(AlohaCancelListModel alohaCancelListModel) {
                m2765invoke(alohaCancelListModel);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2765invoke(AlohaCancelListModel alohaCancelListModel) {
                MutableLiveData mutableLiveData;
                boolean z11;
                ArrayList arrayList;
                List<AlohaCancelUserModel> list;
                MutableLiveData mutableLiveData2;
                List<AlohaCancelUserModel> list2;
                AlohaCancelListModel alohaCancelListModel2 = alohaCancelListModel;
                mutableLiveData = AlohaCancelViewModel.this._showBuyBtn;
                boolean z12 = true;
                if (alohaCancelListModel2.getSsvipRequired()) {
                    List<AlohaCancelUserModel> list3 = alohaCancelListModel2.getList();
                    if (!(list3 == null || list3.isEmpty())) {
                        z11 = true;
                        mutableLiveData.setValue(Boolean.valueOf(z11));
                        arrayList = new ArrayList();
                        list = alohaCancelListModel2.getList();
                        if (list != null && !list.isEmpty()) {
                            z12 = false;
                        }
                        if (!z12 && (list2 = alohaCancelListModel2.getList()) != null) {
                            arrayList.addAll(list2);
                        }
                        AlohaCancelViewModel.this.nextCursorId = alohaCancelListModel2.getNextCursorId();
                        mutableLiveData2 = AlohaCancelViewModel.this._listLiveData;
                        mutableLiveData2.setValue(new StateResult.c(arrayList, Boolean.valueOf(z10)));
                    }
                }
                z11 = false;
                mutableLiveData.setValue(Boolean.valueOf(z11));
                arrayList = new ArrayList();
                list = alohaCancelListModel2.getList();
                if (list != null) {
                    z12 = false;
                }
                if (!z12) {
                    arrayList.addAll(list2);
                }
                AlohaCancelViewModel.this.nextCursorId = alohaCancelListModel2.getNextCursorId();
                mutableLiveData2 = AlohaCancelViewModel.this._listLiveData;
                mutableLiveData2.setValue(new StateResult.c(arrayList, Boolean.valueOf(z10)));
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.profile.viewmodel.AlohaCancelViewModel$getData$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                MutableLiveData mutableLiveData;
                s.i(it, "it");
                mutableLiveData = AlohaCancelViewModel.this._listLiveData;
                mutableLiveData.setValue(new StateResult.a(null, null, Boolean.valueOf(z10), 3, null));
                return Boolean.FALSE;
            }
        }, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    public final boolean canLoadMore() {
        String str = this.nextCursorId;
        return !(str == null || str.length() == 0);
    }

    @NotNull
    public final LiveData<StateResult<List<AlohaCancelUserModel>>> getListLiveData() {
        return this.listLiveData;
    }

    @NotNull
    public final LiveData<Boolean> getShowBuyBtn() {
        return this.showBuyBtn;
    }

    public final void loadMore() {
        if (canLoadMore()) {
            getData(true);
        }
    }

    public final void refresh() {
        getData(false);
    }
}

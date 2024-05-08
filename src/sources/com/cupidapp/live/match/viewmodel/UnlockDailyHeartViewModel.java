package com.cupidapp.live.match.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import com.android.internal.logging.nano.MetricsProto;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.model.StateResult;
import com.cupidapp.live.base.recyclerview.model.FKEmptyViewModel;
import com.cupidapp.live.match.adapter.DailyUnLockModel;
import com.cupidapp.live.match.adapter.UnlockDailyHeartTitleModel;
import com.cupidapp.live.notify.model.DailyHeartModel;
import com.cupidapp.live.notify.model.DailyHeartType;
import com.cupidapp.live.notify.model.NotifyListResult;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: UnlockDailyHeartViewModel.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class UnlockDailyHeartViewModel extends ViewModel {

    @NotNull
    private final MutableLiveData<StateResult<List<Object>>> _listLiveData;

    @NotNull
    private final LiveData<StateResult<List<Object>>> listLiveData;

    @Nullable
    private DailyHeartModel unlockModel;

    public UnlockDailyHeartViewModel() {
        MutableLiveData<StateResult<List<Object>>> mutableLiveData = new MutableLiveData<>();
        this._listLiveData = mutableLiveData;
        this.listLiveData = Transformations.distinctUntilChanged(mutableLiveData);
        loadData();
    }

    @NotNull
    public final LiveData<StateResult<List<Object>>> getListLiveData() {
        return this.listLiveData;
    }

    @Nullable
    public final DailyHeartModel getUnlockModel() {
        return this.unlockModel;
    }

    public final void loadData() {
        if (this.listLiveData.getValue() instanceof StateResult.b) {
            return;
        }
        this._listLiveData.setValue(new StateResult.b(null, null, 3, null));
        Disposable disposed = NetworkClient.f11868a.C().f(DailyHeartType.Match.getValue()).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<NotifyListResult<DailyHeartModel>, kotlin.p>() { // from class: com.cupidapp.live.match.viewmodel.UnlockDailyHeartViewModel$loadData$$inlined$handle$default$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(NotifyListResult<DailyHeartModel> notifyListResult) {
                m2736invoke(notifyListResult);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2736invoke(NotifyListResult<DailyHeartModel> notifyListResult) {
                DailyHeartModel dailyHeartModel;
                MutableLiveData mutableLiveData;
                MutableLiveData mutableLiveData2;
                NotifyListResult<DailyHeartModel> notifyListResult2 = notifyListResult;
                ArrayList arrayList = new ArrayList();
                UnlockDailyHeartViewModel unlockDailyHeartViewModel = UnlockDailyHeartViewModel.this;
                List<DailyHeartModel> list = notifyListResult2.getList();
                unlockDailyHeartViewModel.unlockModel = list != null ? (DailyHeartModel) CollectionsKt___CollectionsKt.V(list) : null;
                dailyHeartModel = UnlockDailyHeartViewModel.this.unlockModel;
                if (dailyHeartModel == null) {
                    arrayList.add(new FKEmptyViewModel(Integer.valueOf(R$mipmap.heart_beat_empty), Integer.valueOf(R$string.no_unlock_list), null, -15066598, null, null, Float.valueOf(16.0f), true, null, null, MetricsProto.MetricsEvent.ACTION_PICTURE_IN_PICTURE_EXPANDED_TO_FULLSCREEN, null));
                    mutableLiveData2 = UnlockDailyHeartViewModel.this._listLiveData;
                    mutableLiveData2.setValue(new StateResult.c(arrayList, null, 2, null));
                } else {
                    String title = notifyListResult2.getTitle();
                    if (title != null) {
                        arrayList.add(new UnlockDailyHeartTitleModel(title));
                    }
                    arrayList.add(new DailyUnLockModel());
                    arrayList.add(new DailyUnLockModel());
                    arrayList.add(new DailyUnLockModel());
                    arrayList.add(new DailyUnLockModel());
                }
                mutableLiveData = UnlockDailyHeartViewModel.this._listLiveData;
                mutableLiveData.setValue(new StateResult.c(arrayList, null, 2, null));
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, null)));
        if (disposed != null) {
            kotlin.jvm.internal.s.h(disposed, "disposed");
        }
        kotlin.jvm.internal.s.h(disposed, "disposed");
    }
}

package com.cupidapp.live.visitors.activity;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.i;
import com.cupidapp.live.base.network.model.StateResult;
import com.cupidapp.live.visitors.model.VisitorModel;
import com.cupidapp.live.visitors.model.VisitorsResult;
import com.cupidapp.live.visitors.model.VisitorsViewModel;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.t;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: VisitorMarksListViewModel.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class VisitorMarksListViewModel extends ViewModel {

    @NotNull
    private final MutableLiveData<StateResult<List<Object>>> _listLiveData;

    @NotNull
    private final LiveData<StateResult<List<Object>>> listLiveData;

    @Nullable
    private final String type;

    public VisitorMarksListViewModel(@Nullable String str) {
        this.type = str;
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
    public final String getType() {
        return this.type;
    }

    public final void loadData() {
        if (this.listLiveData.getValue() instanceof StateResult.b) {
            return;
        }
        this._listLiveData.setValue(new StateResult.b(null, null, 3, null));
        Disposable disposed = NetworkClient.f11868a.N().v(this.type).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<VisitorsResult, p>() { // from class: com.cupidapp.live.visitors.activity.VisitorMarksListViewModel$loadData$$inlined$handle$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(VisitorsResult visitorsResult) {
                m2838invoke(visitorsResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2838invoke(VisitorsResult visitorsResult) {
                ArrayList arrayList;
                MutableLiveData mutableLiveData;
                VisitorsResult visitorsResult2 = visitorsResult;
                List<VisitorModel> list = visitorsResult2.getList();
                if (list != null) {
                    arrayList = new ArrayList(t.t(list, 10));
                    Iterator<VisitorModel> iterator2 = list.iterator2();
                    while (iterator2.hasNext()) {
                        arrayList.add(new VisitorsViewModel(iterator2.next(), visitorsResult2.getVisitorEnable()));
                    }
                } else {
                    arrayList = null;
                }
                mutableLiveData = VisitorMarksListViewModel.this._listLiveData;
                mutableLiveData.setValue(new StateResult.c(arrayList, null, 2, null));
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.visitors.activity.VisitorMarksListViewModel$loadData$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                MutableLiveData mutableLiveData;
                s.i(it, "it");
                mutableLiveData = VisitorMarksListViewModel.this._listLiveData;
                mutableLiveData.setValue(new StateResult.a(null, null, null, 7, null));
                return Boolean.FALSE;
            }
        }, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }
}

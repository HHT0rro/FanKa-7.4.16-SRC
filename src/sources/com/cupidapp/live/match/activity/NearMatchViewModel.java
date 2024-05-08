package com.cupidapp.live.match.activity;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.model.ListResult;
import com.cupidapp.live.base.network.model.StateResult;
import com.cupidapp.live.match.model.NearMatchModel;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: NearMatchViewModel.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class NearMatchViewModel extends ViewModel {

    @NotNull
    private final MutableLiveData<Pair<StateResult<List<NearMatchModel>>, Boolean>> _nearMatchListLiveData;

    @Nullable
    private final String firstCursor;

    @Nullable
    private final List<NearMatchModel> firstPageData;

    @NotNull
    private final LiveData<Pair<StateResult<List<NearMatchModel>>, Boolean>> nearMatchListLiveData;

    @Nullable
    private String nextCursorId;

    public NearMatchViewModel(@Nullable List<NearMatchModel> list, @Nullable String str) {
        this.firstPageData = list;
        this.firstCursor = str;
        MutableLiveData<Pair<StateResult<List<NearMatchModel>>, Boolean>> mutableLiveData = new MutableLiveData<>();
        this._nearMatchListLiveData = mutableLiveData;
        this.nearMatchListLiveData = Transformations.distinctUntilChanged(mutableLiveData);
    }

    public final void getData(final boolean z10) {
        if (z10) {
            this._nearMatchListLiveData.setValue(new Pair<>(new StateResult.c(this.firstPageData, null, 2, null), Boolean.valueOf(z10)));
            this.nextCursorId = this.firstCursor;
            return;
        }
        String str = this.nextCursorId;
        if (str == null || str.length() == 0) {
            return;
        }
        Disposable disposed = NetworkClient.f11868a.A().f(this.nextCursorId).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<ListResult<NearMatchModel>, kotlin.p>() { // from class: com.cupidapp.live.match.activity.NearMatchViewModel$getData$$inlined$handle$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(ListResult<NearMatchModel> listResult) {
                m2702invoke(listResult);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2702invoke(ListResult<NearMatchModel> listResult) {
                MutableLiveData mutableLiveData;
                ListResult<NearMatchModel> listResult2 = listResult;
                NearMatchViewModel.this.nextCursorId = listResult2.getNextCursorId();
                mutableLiveData = NearMatchViewModel.this._nearMatchListLiveData;
                List<NearMatchModel> list = listResult2.getList();
                mutableLiveData.setValue(new Pair(new StateResult.c(list != null ? CollectionsKt___CollectionsKt.x0(list) : null, null, 2, null), Boolean.valueOf(z10)));
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.match.activity.NearMatchViewModel$getData$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                MutableLiveData mutableLiveData;
                kotlin.jvm.internal.s.i(it, "it");
                mutableLiveData = NearMatchViewModel.this._nearMatchListLiveData;
                mutableLiveData.setValue(new Pair(new StateResult.a(null, null, null, 7, null), Boolean.valueOf(z10)));
                return Boolean.FALSE;
            }
        }, null)));
        if (disposed != null) {
            kotlin.jvm.internal.s.h(disposed, "disposed");
        }
        kotlin.jvm.internal.s.h(disposed, "disposed");
    }

    @Nullable
    public final String getFirstCursor() {
        return this.firstCursor;
    }

    @Nullable
    public final List<NearMatchModel> getFirstPageData() {
        return this.firstPageData;
    }

    @NotNull
    public final LiveData<Pair<StateResult<List<NearMatchModel>>, Boolean>> getNearMatchListLiveData() {
        return this.nearMatchListLiveData;
    }
}

package com.cupidapp.live.visitors.activity;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import com.cupidapp.live.base.livedata.Event;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.i;
import com.cupidapp.live.base.network.model.ListResult;
import com.cupidapp.live.base.network.model.StateResult;
import com.cupidapp.live.setting.model.FootMarkResult;
import com.cupidapp.live.visitors.model.FootmarkModel;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FootmarkViewModel.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FootmarkViewModel extends ViewModel {

    @NotNull
    private final MutableLiveData<Event<String>> _delRecordEventLiveData;

    @NotNull
    private final MutableLiveData<FootMarkResult> _hideRecordMsgLiveData;

    @NotNull
    private final MutableLiveData<Pair<StateResult<List<FootmarkModel>>, Boolean>> _recordListLiveData;

    @NotNull
    private final LiveData<Event<String>> delRecordEvent;

    @NotNull
    private final LiveData<FootMarkResult> hideRecordMsgLiveData;

    @Nullable
    private String nextCursorId;

    @NotNull
    private final LiveData<Pair<StateResult<List<FootmarkModel>>, Boolean>> recordListLiveData;

    public FootmarkViewModel() {
        MutableLiveData<Pair<StateResult<List<FootmarkModel>>, Boolean>> mutableLiveData = new MutableLiveData<>();
        this._recordListLiveData = mutableLiveData;
        this.recordListLiveData = Transformations.distinctUntilChanged(mutableLiveData);
        MutableLiveData<FootMarkResult> mutableLiveData2 = new MutableLiveData<>();
        this._hideRecordMsgLiveData = mutableLiveData2;
        this.hideRecordMsgLiveData = mutableLiveData2;
        MutableLiveData<Event<String>> mutableLiveData3 = new MutableLiveData<>();
        this._delRecordEventLiveData = mutableLiveData3;
        this.delRecordEvent = mutableLiveData3;
    }

    private final void refreshRecordData() {
        Disposable disposed = NetworkClient.f11868a.N().H().flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<FootMarkResult, p>() { // from class: com.cupidapp.live.visitors.activity.FootmarkViewModel$refreshRecordData$$inlined$handle$default$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(FootMarkResult footMarkResult) {
                m2837invoke(footMarkResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2837invoke(FootMarkResult footMarkResult) {
                MutableLiveData mutableLiveData;
                mutableLiveData = FootmarkViewModel.this._hideRecordMsgLiveData;
                mutableLiveData.setValue(footMarkResult);
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    private final void updateHideFootmarkValue(Boolean bool, Integer num) {
        FootMarkResult value = this._hideRecordMsgLiveData.getValue();
        if (value != null) {
            if (bool != null) {
                value.setHiddenFootmark(bool.booleanValue());
            }
            if (num != null) {
                value.setFootmarkDelCount(num.intValue());
            }
            this._hideRecordMsgLiveData.setValue(value);
        }
    }

    public static /* synthetic */ void updateHideFootmarkValue$default(FootmarkViewModel footmarkViewModel, Boolean bool, Integer num, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            bool = null;
        }
        if ((i10 & 2) != 0) {
            num = null;
        }
        footmarkViewModel.updateHideFootmarkValue(bool, num);
    }

    public final void changeHideFootmarkState(final boolean z10) {
        Disposable disposed = NetworkClient.f11868a.N().x0(z10).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<Object, p>() { // from class: com.cupidapp.live.visitors.activity.FootmarkViewModel$changeHideFootmarkState$$inlined$handle$1
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
                FootmarkViewModel.updateHideFootmarkValue$default(FootmarkViewModel.this, Boolean.valueOf(z10), null, 2, null);
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.visitors.activity.FootmarkViewModel$changeHideFootmarkState$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                s.i(it, "it");
                FootmarkViewModel.updateHideFootmarkValue$default(FootmarkViewModel.this, Boolean.valueOf(!z10), null, 2, null);
                return Boolean.FALSE;
            }
        }, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    public final void deleteRecord(@NotNull final String userId) {
        s.i(userId, "userId");
        Disposable disposed = NetworkClient.f11868a.N().E(userId).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<FootMarkResult, p>() { // from class: com.cupidapp.live.visitors.activity.FootmarkViewModel$deleteRecord$$inlined$handle$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(FootMarkResult footMarkResult) {
                m2835invoke(footMarkResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2835invoke(FootMarkResult footMarkResult) {
                MutableLiveData mutableLiveData;
                FootMarkResult footMarkResult2 = footMarkResult;
                mutableLiveData = FootmarkViewModel.this._delRecordEventLiveData;
                mutableLiveData.setValue(new Event(userId));
                FootmarkViewModel.updateHideFootmarkValue$default(FootmarkViewModel.this, null, Integer.valueOf(footMarkResult2.getFootmarkDelCount()), 1, null);
                z3.b.f54828a.d(userId, footMarkResult2.getFootmarkDelCount());
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    public final void getData(final boolean z10) {
        if (!z10) {
            String str = this.nextCursorId;
            if (str == null || str.length() == 0) {
                return;
            }
        }
        if (z10) {
            this.nextCursorId = null;
            refreshRecordData();
        }
        Disposable disposed = NetworkClient.f11868a.N().e(this.nextCursorId).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<ListResult<FootmarkModel>, p>() { // from class: com.cupidapp.live.visitors.activity.FootmarkViewModel$getData$$inlined$handle$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(ListResult<FootmarkModel> listResult) {
                m2836invoke(listResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2836invoke(ListResult<FootmarkModel> listResult) {
                MutableLiveData mutableLiveData;
                ListResult<FootmarkModel> listResult2 = listResult;
                FootmarkViewModel.this.nextCursorId = listResult2.getNextCursorId();
                mutableLiveData = FootmarkViewModel.this._recordListLiveData;
                mutableLiveData.setValue(new Pair(new StateResult.c(listResult2.getList(), null, 2, null), Boolean.valueOf(z10)));
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.visitors.activity.FootmarkViewModel$getData$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                MutableLiveData mutableLiveData;
                s.i(it, "it");
                mutableLiveData = FootmarkViewModel.this._recordListLiveData;
                mutableLiveData.setValue(new Pair(new StateResult.a(null, null, null, 7, null), Boolean.TRUE));
                return Boolean.FALSE;
            }
        }, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    @NotNull
    public final LiveData<Event<String>> getDelRecordEvent() {
        return this.delRecordEvent;
    }

    @NotNull
    public final LiveData<FootMarkResult> getHideRecordMsgLiveData() {
        return this.hideRecordMsgLiveData;
    }

    @NotNull
    public final LiveData<Pair<StateResult<List<FootmarkModel>>, Boolean>> getRecordListLiveData() {
        return this.recordListLiveData;
    }
}

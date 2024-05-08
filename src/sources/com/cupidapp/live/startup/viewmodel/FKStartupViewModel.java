package com.cupidapp.live.startup.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.cupidapp.live.base.livedata.Event;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.e;
import com.cupidapp.live.base.network.i;
import com.cupidapp.live.startup.model.FKAdType;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import kotlin.Pair;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKStartupViewModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FKStartupViewModel extends ViewModel {

    @NotNull
    private final MutableLiveData<Event<Pair<Boolean, Integer>>> _jumpButtonAndClickAreaEvent;

    @NotNull
    private final MutableLiveData<FKAdType> _showAdType;

    @NotNull
    private final MutableLiveData<Event<Boolean>> _showVipRemoveAdEvent;

    @NotNull
    private final LiveData<Event<Pair<Boolean, Integer>>> jumpButtonAndClickAreaEvent;

    @NotNull
    private final LiveData<FKAdType> showAdType;

    @NotNull
    private final LiveData<Event<Boolean>> showVipRemoveAdEvent;

    public FKStartupViewModel() {
        MutableLiveData<Event<Pair<Boolean, Integer>>> mutableLiveData = new MutableLiveData<>();
        this._jumpButtonAndClickAreaEvent = mutableLiveData;
        this.jumpButtonAndClickAreaEvent = mutableLiveData;
        MutableLiveData<Event<Boolean>> mutableLiveData2 = new MutableLiveData<>();
        this._showVipRemoveAdEvent = mutableLiveData2;
        this.showVipRemoveAdEvent = mutableLiveData2;
        MutableLiveData<FKAdType> mutableLiveData3 = new MutableLiveData<>();
        this._showAdType = mutableLiveData3;
        this.showAdType = mutableLiveData3;
    }

    @NotNull
    public final LiveData<Event<Pair<Boolean, Integer>>> getJumpButtonAndClickAreaEvent() {
        return this.jumpButtonAndClickAreaEvent;
    }

    @NotNull
    public final LiveData<FKAdType> getShowAdType() {
        return this.showAdType;
    }

    @NotNull
    public final LiveData<Event<Boolean>> getShowVipRemoveAdEvent() {
        return this.showVipRemoveAdEvent;
    }

    public final void reportStartupAd(@Nullable String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        Disposable disposed = NetworkClient.f11868a.i().y(str).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<Object, p>() { // from class: com.cupidapp.live.startup.viewmodel.FKStartupViewModel$reportStartupAd$$inlined$handle$default$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Object obj) {
                invoke2(obj);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object obj) {
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(null, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    public final void setAdType(@NotNull FKAdType type) {
        s.i(type, "type");
        this._showAdType.setValue(type);
    }

    public final void setJumpButtonAndClickAreaEvent(boolean z10, int i10) {
        this._jumpButtonAndClickAreaEvent.setValue(new Event<>(new Pair(Boolean.valueOf(z10), Integer.valueOf(i10))));
    }

    public final void setVipRemoveAdEvent(boolean z10) {
        this._showVipRemoveAdEvent.setValue(new Event<>(Boolean.valueOf(z10)));
    }
}

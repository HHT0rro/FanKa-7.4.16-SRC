package com.cupidapp.live.setting.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import com.cupidapp.live.base.livedata.CombineLiveData;
import com.cupidapp.live.base.livedata.Event;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.e;
import com.cupidapp.live.base.network.i;
import com.cupidapp.live.base.network.model.StateResult;
import com.cupidapp.live.setting.model.LimitRangeType;
import com.cupidapp.live.setting.model.PostLimitSettingModel;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: PostLimitSettingViewModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class PostLimitSettingViewModel extends ViewModel {

    @NotNull
    private final MutableLiveData<StateResult<LimitRangeType>> _msgLiveData;

    @NotNull
    private final MutableLiveData<StateResult<LimitRangeType>> _readLimitLiveData;

    @NotNull
    private final MutableLiveData<Event<p>> _saveSucLiveDataEvent;

    @NotNull
    private final CombineLiveData<StateResult<LimitRangeType>, StateResult<LimitRangeType>, Boolean> doneBtnLiveData;

    @NotNull
    private final LiveData<StateResult<LimitRangeType>> msgLiveData;

    @NotNull
    private final LiveData<StateResult<LimitRangeType>> readLimitLiveData;

    @NotNull
    private final LiveData<Event<p>> saveSucLiveDataEvent;

    public PostLimitSettingViewModel() {
        MutableLiveData<StateResult<LimitRangeType>> mutableLiveData = new MutableLiveData<>();
        this._readLimitLiveData = mutableLiveData;
        this.readLimitLiveData = Transformations.distinctUntilChanged(mutableLiveData);
        MutableLiveData<StateResult<LimitRangeType>> mutableLiveData2 = new MutableLiveData<>();
        this._msgLiveData = mutableLiveData2;
        this.msgLiveData = Transformations.distinctUntilChanged(mutableLiveData2);
        this.doneBtnLiveData = new CombineLiveData<>(mutableLiveData, mutableLiveData2, new Function2<StateResult<LimitRangeType>, StateResult<LimitRangeType>, Boolean>() { // from class: com.cupidapp.live.setting.viewmodel.PostLimitSettingViewModel$doneBtnLiveData$1
            @Override // kotlin.jvm.functions.Function2
            @Nullable
            /* renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public final Boolean mo1743invoke(@Nullable StateResult<LimitRangeType> stateResult, @Nullable StateResult<LimitRangeType> stateResult2) {
                return Boolean.valueOf((stateResult instanceof StateResult.c) && (stateResult2 instanceof StateResult.c));
            }
        });
        MutableLiveData<Event<p>> mutableLiveData3 = new MutableLiveData<>();
        this._saveSucLiveDataEvent = mutableLiveData3;
        this.saveSucLiveDataEvent = mutableLiveData3;
        loadData();
    }

    @NotNull
    public final CombineLiveData<StateResult<LimitRangeType>, StateResult<LimitRangeType>, Boolean> getDoneBtnLiveData() {
        return this.doneBtnLiveData;
    }

    @NotNull
    public final LiveData<StateResult<LimitRangeType>> getMsgLiveData() {
        return this.msgLiveData;
    }

    @NotNull
    public final LiveData<StateResult<LimitRangeType>> getReadLimitLiveData() {
        return this.readLimitLiveData;
    }

    @NotNull
    public final LiveData<Event<p>> getSaveSucLiveDataEvent() {
        return this.saveSucLiveDataEvent;
    }

    @NotNull
    public final MutableLiveData<Event<p>> get_saveSucLiveDataEvent() {
        return this._saveSucLiveDataEvent;
    }

    public final void loadData() {
        this._msgLiveData.setValue(new StateResult.b(null, null, 3, null));
        this._readLimitLiveData.setValue(new StateResult.b(null, null, 3, null));
        Disposable disposed = NetworkClient.f11868a.i().p().flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<PostLimitSettingModel, p>() { // from class: com.cupidapp.live.setting.viewmodel.PostLimitSettingViewModel$loadData$$inlined$handle$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(PostLimitSettingModel postLimitSettingModel) {
                m2808invoke(postLimitSettingModel);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2808invoke(PostLimitSettingModel postLimitSettingModel) {
                MutableLiveData mutableLiveData;
                MutableLiveData mutableLiveData2;
                PostLimitSettingModel postLimitSettingModel2 = postLimitSettingModel;
                mutableLiveData = PostLimitSettingViewModel.this._readLimitLiveData;
                mutableLiveData.setValue(new StateResult.c(postLimitSettingModel2.getReadLimitType(), null, 2, null));
                mutableLiveData2 = PostLimitSettingViewModel.this._msgLiveData;
                mutableLiveData2.setValue(new StateResult.c(postLimitSettingModel2.getMsgLimitType(), null, 2, null));
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.setting.viewmodel.PostLimitSettingViewModel$loadData$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                MutableLiveData mutableLiveData;
                MutableLiveData mutableLiveData2;
                s.i(it, "it");
                mutableLiveData = PostLimitSettingViewModel.this._readLimitLiveData;
                mutableLiveData.setValue(new StateResult.a(null, null, null, 7, null));
                mutableLiveData2 = PostLimitSettingViewModel.this._msgLiveData;
                mutableLiveData2.setValue(new StateResult.a(null, null, null, 7, null));
                return Boolean.FALSE;
            }
        }, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    public final void msgLimitChange(@NotNull LimitRangeType type) {
        s.i(type, "type");
        if (s.d(this.doneBtnLiveData.getValue(), Boolean.TRUE)) {
            this._msgLiveData.setValue(new StateResult.c(type, null, 2, null));
        }
    }

    public final void readLimitChange(@NotNull LimitRangeType type) {
        s.i(type, "type");
        if (s.d(this.doneBtnLiveData.getValue(), Boolean.TRUE)) {
            this._readLimitLiveData.setValue(new StateResult.c(type, null, 2, null));
        }
    }

    public final void saveSetting() {
        LimitRangeType data;
        LimitRangeType data2;
        StateResult<LimitRangeType> value = this._readLimitLiveData.getValue();
        Integer valueOf = (value == null || (data2 = value.getData()) == null) ? null : Integer.valueOf(data2.getValue());
        StateResult<LimitRangeType> value2 = this._msgLiveData.getValue();
        Integer valueOf2 = (value2 == null || (data = value2.getData()) == null) ? null : Integer.valueOf(data.getValue());
        if (valueOf == null || valueOf2 == null) {
            return;
        }
        Disposable disposed = NetworkClient.f11868a.i().w(valueOf.intValue(), valueOf2.intValue()).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<Object, p>() { // from class: com.cupidapp.live.setting.viewmodel.PostLimitSettingViewModel$saveSetting$$inlined$handle$default$1
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
                PostLimitSettingViewModel.this.get_saveSucLiveDataEvent().setValue(new Event<>(p.f51048a));
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(null, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }
}

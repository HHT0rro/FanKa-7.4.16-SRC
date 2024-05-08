package com.cupidapp.live.liveshow.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import com.cupidapp.live.base.livedata.Event;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.e;
import com.cupidapp.live.base.network.i;
import com.cupidapp.live.base.network.model.StateResult;
import com.cupidapp.live.liveshow.model.LiveFunctionMenuListModel;
import com.cupidapp.live.liveshow.model.LiveFunctionMenuResult;
import com.cupidapp.live.liveshow.model.LiveMenuUnreadModel;
import com.cupidapp.live.liveshow.model.LiveTabConfigModel;
import com.cupidapp.live.liveshow.model.LiveTabConfigResult;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.List;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;

/* compiled from: LiveContainerViewModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class LiveContainerViewModel extends ViewModel {

    @NotNull
    private final MutableLiveData<Event<List<LiveFunctionMenuListModel>>> _anchorLiveMenuEventLiveData;

    @NotNull
    private final MutableLiveData<LiveMenuUnreadModel> _liveMenuUnreadLiveData;

    @NotNull
    private final MutableLiveData<Event<StateResult<List<LiveTabConfigModel>>>> _titleData;

    @NotNull
    private final MutableLiveData<Event<List<LiveFunctionMenuListModel>>> _viewerLiveMenuEventLiveData;

    @NotNull
    private final LiveData<Event<List<LiveFunctionMenuListModel>>> anchorLiveMenuEventLiveData;
    private boolean isShowingMenu;

    @NotNull
    private final LiveData<LiveMenuUnreadModel> liveMenuUnreadLiveData;

    @NotNull
    private final LiveData<Event<StateResult<List<LiveTabConfigModel>>>> titleData;

    @NotNull
    private final LiveData<Event<List<LiveFunctionMenuListModel>>> viewerLiveMenuEventLiveData;

    public LiveContainerViewModel() {
        MutableLiveData<Event<StateResult<List<LiveTabConfigModel>>>> mutableLiveData = new MutableLiveData<>();
        this._titleData = mutableLiveData;
        this.titleData = Transformations.distinctUntilChanged(mutableLiveData);
        MutableLiveData<Event<List<LiveFunctionMenuListModel>>> mutableLiveData2 = new MutableLiveData<>();
        this._anchorLiveMenuEventLiveData = mutableLiveData2;
        this.anchorLiveMenuEventLiveData = mutableLiveData2;
        MutableLiveData<Event<List<LiveFunctionMenuListModel>>> mutableLiveData3 = new MutableLiveData<>();
        this._viewerLiveMenuEventLiveData = mutableLiveData3;
        this.viewerLiveMenuEventLiveData = mutableLiveData3;
        MutableLiveData<LiveMenuUnreadModel> mutableLiveData4 = new MutableLiveData<>();
        this._liveMenuUnreadLiveData = mutableLiveData4;
        this.liveMenuUnreadLiveData = mutableLiveData4;
    }

    public final void anchorLiveMenu() {
        this.isShowingMenu = true;
        Disposable disposed = NetworkClient.f11868a.r().s().flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<LiveFunctionMenuResult, p>() { // from class: com.cupidapp.live.liveshow.viewmodel.LiveContainerViewModel$anchorLiveMenu$$inlined$handle$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(LiveFunctionMenuResult liveFunctionMenuResult) {
                m2662invoke(liveFunctionMenuResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2662invoke(LiveFunctionMenuResult liveFunctionMenuResult) {
                MutableLiveData mutableLiveData;
                LiveContainerViewModel.this.isShowingMenu = false;
                mutableLiveData = LiveContainerViewModel.this._anchorLiveMenuEventLiveData;
                mutableLiveData.setValue(new Event(liveFunctionMenuResult.getSections()));
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.liveshow.viewmodel.LiveContainerViewModel$anchorLiveMenu$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                s.i(it, "it");
                LiveContainerViewModel.this.isShowingMenu = false;
                return Boolean.FALSE;
            }
        }, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    public final void callTitleApi(boolean z10) {
        Disposable disposed = NetworkClient.f11868a.r().A(z10).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<LiveTabConfigResult, p>() { // from class: com.cupidapp.live.liveshow.viewmodel.LiveContainerViewModel$callTitleApi$$inlined$handle$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(LiveTabConfigResult liveTabConfigResult) {
                m2663invoke(liveTabConfigResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2663invoke(LiveTabConfigResult liveTabConfigResult) {
                MutableLiveData mutableLiveData;
                mutableLiveData = LiveContainerViewModel.this._titleData;
                mutableLiveData.setValue(new Event(new StateResult.c(liveTabConfigResult.getTabList(), null, 2, null)));
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.liveshow.viewmodel.LiveContainerViewModel$callTitleApi$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                MutableLiveData mutableLiveData;
                s.i(it, "it");
                mutableLiveData = LiveContainerViewModel.this._titleData;
                mutableLiveData.setValue(new Event(new StateResult.a(null, null, null, 7, null)));
                return Boolean.FALSE;
            }
        }, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    @NotNull
    public final LiveData<Event<List<LiveFunctionMenuListModel>>> getAnchorLiveMenuEventLiveData() {
        return this.anchorLiveMenuEventLiveData;
    }

    @NotNull
    public final LiveData<LiveMenuUnreadModel> getLiveMenuUnreadLiveData() {
        return this.liveMenuUnreadLiveData;
    }

    public final void getMenuRedDot() {
        Disposable disposed = NetworkClient.f11868a.r().i().flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<LiveMenuUnreadModel, p>() { // from class: com.cupidapp.live.liveshow.viewmodel.LiveContainerViewModel$getMenuRedDot$$inlined$handle$default$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(LiveMenuUnreadModel liveMenuUnreadModel) {
                m2664invoke(liveMenuUnreadModel);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2664invoke(LiveMenuUnreadModel liveMenuUnreadModel) {
                MutableLiveData mutableLiveData;
                mutableLiveData = LiveContainerViewModel.this._liveMenuUnreadLiveData;
                mutableLiveData.setValue(liveMenuUnreadModel);
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(null, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    @NotNull
    public final LiveData<Event<StateResult<List<LiveTabConfigModel>>>> getTitleData() {
        return this.titleData;
    }

    @NotNull
    public final LiveData<Event<List<LiveFunctionMenuListModel>>> getViewerLiveMenuEventLiveData() {
        return this.viewerLiveMenuEventLiveData;
    }

    public final void viewerLiveMenu() {
        this.isShowingMenu = true;
        Disposable disposed = NetworkClient.f11868a.r().l().flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<LiveFunctionMenuResult, p>() { // from class: com.cupidapp.live.liveshow.viewmodel.LiveContainerViewModel$viewerLiveMenu$$inlined$handle$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(LiveFunctionMenuResult liveFunctionMenuResult) {
                m2665invoke(liveFunctionMenuResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2665invoke(LiveFunctionMenuResult liveFunctionMenuResult) {
                MutableLiveData mutableLiveData;
                LiveContainerViewModel.this.isShowingMenu = false;
                mutableLiveData = LiveContainerViewModel.this._viewerLiveMenuEventLiveData;
                mutableLiveData.setValue(new Event(liveFunctionMenuResult.getSections()));
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.liveshow.viewmodel.LiveContainerViewModel$viewerLiveMenu$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                s.i(it, "it");
                LiveContainerViewModel.this.isShowingMenu = false;
                return Boolean.FALSE;
            }
        }, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }
}

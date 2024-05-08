package com.cupidapp.live.setting.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import com.cupidapp.live.base.livedata.Event;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.e;
import com.cupidapp.live.base.network.i;
import com.cupidapp.live.base.network.model.ListResult;
import com.cupidapp.live.base.network.model.StateResult;
import com.cupidapp.live.base.network.model.SwipeCardUserLikeResult;
import com.cupidapp.live.profile.holder.FKProfileStoryLabelModel;
import com.cupidapp.live.profile.logic.c;
import com.cupidapp.live.profile.model.FKStoryLabelItemModel;
import com.cupidapp.live.profile.model.FKStoryLabelListModel;
import com.cupidapp.live.profile.model.User;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.List;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import x2.a;

/* compiled from: FKStoryLabelViewModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FKStoryLabelViewModel extends ViewModel {

    @NotNull
    private final MutableLiveData<Event<SwipeCardUserLikeResult>> _alohaOrNopeEvent;

    @NotNull
    private final MutableLiveData<StateResult<FKStoryLabelItemModel>> _saveStoryLabelLiveData;

    @NotNull
    private final MutableLiveData<FKStoryLabelItemModel> _selectedStoryLabelLiveData;

    @NotNull
    private final MutableLiveData<FKProfileStoryLabelModel> _storyLabelDetailLiveData;

    @NotNull
    private final MutableLiveData<StateResult<List<FKStoryLabelListModel>>> _storyLabelLiveData;

    @NotNull
    private final LiveData<Event<SwipeCardUserLikeResult>> alohaOrNopeEvent;
    private final int maxEnterTextCount = 100;

    @NotNull
    private final LiveData<StateResult<FKStoryLabelItemModel>> saveStoryLabelLiveData;

    @NotNull
    private final LiveData<FKStoryLabelItemModel> selectedStoryLabelLiveData;

    @NotNull
    private final LiveData<FKProfileStoryLabelModel> storyLabelDetailLiveData;

    @NotNull
    private final LiveData<StateResult<List<FKStoryLabelListModel>>> storyLabelLiveData;

    public FKStoryLabelViewModel() {
        MutableLiveData<StateResult<List<FKStoryLabelListModel>>> mutableLiveData = new MutableLiveData<>();
        this._storyLabelLiveData = mutableLiveData;
        this.storyLabelLiveData = Transformations.distinctUntilChanged(mutableLiveData);
        MutableLiveData<FKStoryLabelItemModel> mutableLiveData2 = new MutableLiveData<>();
        this._selectedStoryLabelLiveData = mutableLiveData2;
        this.selectedStoryLabelLiveData = mutableLiveData2;
        MutableLiveData<StateResult<FKStoryLabelItemModel>> mutableLiveData3 = new MutableLiveData<>();
        this._saveStoryLabelLiveData = mutableLiveData3;
        this.saveStoryLabelLiveData = Transformations.distinctUntilChanged(mutableLiveData3);
        MutableLiveData<FKProfileStoryLabelModel> mutableLiveData4 = new MutableLiveData<>();
        this._storyLabelDetailLiveData = mutableLiveData4;
        this.storyLabelDetailLiveData = mutableLiveData4;
        MutableLiveData<Event<SwipeCardUserLikeResult>> mutableLiveData5 = new MutableLiveData<>();
        this._alohaOrNopeEvent = mutableLiveData5;
        this.alohaOrNopeEvent = mutableLiveData5;
    }

    public final void cancelFollow() {
        User user;
        String userId;
        FKProfileStoryLabelModel value = this.storyLabelDetailLiveData.getValue();
        if (value == null || (user = value.getUser()) == null || (userId = user.userId()) == null) {
            return;
        }
        Disposable disposed = NetworkClient.f11868a.N().D0(userId, null, null).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<SwipeCardUserLikeResult, p>() { // from class: com.cupidapp.live.setting.viewmodel.FKStoryLabelViewModel$cancelFollow$$inlined$handle$default$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(SwipeCardUserLikeResult swipeCardUserLikeResult) {
                m2803invoke(swipeCardUserLikeResult);
                return p.f51048a;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2803invoke(SwipeCardUserLikeResult swipeCardUserLikeResult) {
                MutableLiveData mutableLiveData;
                MutableLiveData mutableLiveData2;
                SwipeCardUserLikeResult swipeCardUserLikeResult2 = swipeCardUserLikeResult;
                mutableLiveData = FKStoryLabelViewModel.this._storyLabelDetailLiveData;
                FKProfileStoryLabelModel it = (FKProfileStoryLabelModel) mutableLiveData.getValue();
                if (it != null) {
                    it.getUser().setAloha(false);
                    it.getUser().setMatch(false);
                    FKStoryLabelViewModel fKStoryLabelViewModel = FKStoryLabelViewModel.this;
                    s.h(it, "it");
                    fKStoryLabelViewModel.setStoryLabelDetail(it);
                    mutableLiveData2 = FKStoryLabelViewModel.this._alohaOrNopeEvent;
                    mutableLiveData2.setValue(new Event(new SwipeCardUserLikeResult(swipeCardUserLikeResult2.getUser(), swipeCardUserLikeResult2.getWindow(), null, null, false, null, swipeCardUserLikeResult2.getAlohaOrNopeResidueNum(), swipeCardUserLikeResult2.getAlohaOrNopeGuide())));
                }
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(null, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    public final void editStoryLabel(@Nullable FKStoryLabelItemModel fKStoryLabelItemModel) {
        this._selectedStoryLabelLiveData.setValue(fKStoryLabelItemModel);
    }

    public final void followUser() {
        User user;
        String userId;
        FKProfileStoryLabelModel value = this.storyLabelDetailLiveData.getValue();
        if (value == null || (user = value.getUser()) == null || (userId = user.userId()) == null) {
            return;
        }
        Disposable disposed = a.C0836a.o(NetworkClient.f11868a.N(), userId, null, null, null, 0, null, null, null, 254, null).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<SwipeCardUserLikeResult, p>() { // from class: com.cupidapp.live.setting.viewmodel.FKStoryLabelViewModel$followUser$$inlined$handle$default$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(SwipeCardUserLikeResult swipeCardUserLikeResult) {
                m2804invoke(swipeCardUserLikeResult);
                return p.f51048a;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2804invoke(SwipeCardUserLikeResult swipeCardUserLikeResult) {
                MutableLiveData mutableLiveData;
                MutableLiveData mutableLiveData2;
                SwipeCardUserLikeResult swipeCardUserLikeResult2 = swipeCardUserLikeResult;
                mutableLiveData = FKStoryLabelViewModel.this._storyLabelDetailLiveData;
                FKProfileStoryLabelModel it = (FKProfileStoryLabelModel) mutableLiveData.getValue();
                if (it != null) {
                    it.getUser().setAloha(true);
                    it.getUser().setMatch(swipeCardUserLikeResult2.getUser().getMatch());
                    FKStoryLabelViewModel fKStoryLabelViewModel = FKStoryLabelViewModel.this;
                    s.h(it, "it");
                    fKStoryLabelViewModel.setStoryLabelDetail(it);
                    mutableLiveData2 = FKStoryLabelViewModel.this._alohaOrNopeEvent;
                    mutableLiveData2.setValue(new Event(swipeCardUserLikeResult2));
                }
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(null, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    @NotNull
    public final LiveData<Event<SwipeCardUserLikeResult>> getAlohaOrNopeEvent() {
        return this.alohaOrNopeEvent;
    }

    public final void getLabelList() {
        Disposable disposed = NetworkClient.f11868a.N().c().flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<ListResult<FKStoryLabelListModel>, p>() { // from class: com.cupidapp.live.setting.viewmodel.FKStoryLabelViewModel$getLabelList$$inlined$handle$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(ListResult<FKStoryLabelListModel> listResult) {
                m2805invoke(listResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2805invoke(ListResult<FKStoryLabelListModel> listResult) {
                MutableLiveData mutableLiveData;
                mutableLiveData = FKStoryLabelViewModel.this._storyLabelLiveData;
                mutableLiveData.setValue(new StateResult.c(listResult.getList(), null, 2, null));
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.setting.viewmodel.FKStoryLabelViewModel$getLabelList$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                MutableLiveData mutableLiveData;
                s.i(it, "it");
                mutableLiveData = FKStoryLabelViewModel.this._storyLabelLiveData;
                mutableLiveData.setValue(new StateResult.a(null, null, null, 7, null));
                return Boolean.FALSE;
            }
        }, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    public final int getMaxEnterTextCount() {
        return this.maxEnterTextCount;
    }

    @NotNull
    public final LiveData<StateResult<FKStoryLabelItemModel>> getSaveStoryLabelLiveData() {
        return this.saveStoryLabelLiveData;
    }

    @NotNull
    public final LiveData<FKStoryLabelItemModel> getSelectedStoryLabelLiveData() {
        return this.selectedStoryLabelLiveData;
    }

    @NotNull
    public final LiveData<FKProfileStoryLabelModel> getStoryLabelDetailLiveData() {
        return this.storyLabelDetailLiveData;
    }

    @NotNull
    public final LiveData<StateResult<List<FKStoryLabelListModel>>> getStoryLabelLiveData() {
        return this.storyLabelLiveData;
    }

    public final boolean isMe() {
        User user;
        c cVar = c.f17839a;
        FKProfileStoryLabelModel value = this.storyLabelDetailLiveData.getValue();
        return cVar.a((value == null || (user = value.getUser()) == null) ? null : user.userId());
    }

    public final void saveStoryLabel() {
        final FKStoryLabelItemModel value = this.selectedStoryLabelLiveData.getValue();
        if (value != null) {
            String content = value.getContent();
            if (content == null || content.length() == 0) {
                this._saveStoryLabelLiveData.setValue(new StateResult.a(null, null, null, 7, null));
                return;
            }
            x2.a N = NetworkClient.f11868a.N();
            String id2 = value.getId();
            String content2 = value.getContent();
            s.f(content2);
            Disposable disposed = N.l0(id2, content2).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<Object, p>() { // from class: com.cupidapp.live.setting.viewmodel.FKStoryLabelViewModel$saveStoryLabel$lambda$2$$inlined$handle$default$1
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
                    MutableLiveData mutableLiveData;
                    mutableLiveData = FKStoryLabelViewModel.this._saveStoryLabelLiveData;
                    mutableLiveData.setValue(new StateResult.c(value, null, 2, null));
                }
            }), new e(new ObservableExtensionKt$handle$disposed$2(null, null)));
            if (disposed != null) {
                s.h(disposed, "disposed");
            }
            s.h(disposed, "disposed");
        }
    }

    public final void setLabelContent(@NotNull String content) {
        s.i(content, "content");
        FKStoryLabelItemModel value = this._selectedStoryLabelLiveData.getValue();
        if (value != null) {
            value.setContent(content);
        }
        this._selectedStoryLabelLiveData.setValue(value);
    }

    public final void setStoryLabelDetail(@NotNull FKProfileStoryLabelModel profileStoryLabel) {
        s.i(profileStoryLabel, "profileStoryLabel");
        this._storyLabelDetailLiveData.setValue(profileStoryLabel);
    }
}

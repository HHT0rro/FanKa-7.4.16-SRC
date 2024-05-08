package com.cupidapp.live.profile.viewmodel;

import androidx.annotation.ColorInt;
import androidx.annotation.StringRes;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.livedata.Event;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.e;
import com.cupidapp.live.base.network.i;
import com.cupidapp.live.base.network.model.Result;
import com.cupidapp.live.base.network.model.StateResult;
import com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick;
import com.cupidapp.live.base.view.h;
import com.cupidapp.live.profile.logic.ILikedUnMatchLogic;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.profile.model.UserListResult;
import com.cupidapp.live.profile.viewmodel.UnMatchViewModel;
import com.cupidapp.live.track.group.GroupSocialLog;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: UnMatchViewModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class UnMatchViewModel extends ViewModel {

    @NotNull
    private final MutableLiveData<StateResult<List<User>>> _listLiveData;

    @NotNull
    private final MutableLiveData<Boolean> _selectState;

    @NotNull
    private final MutableLiveData<Event<List<String>>> _unFollowSucListLiveData;

    @NotNull
    private final LiveData<StateResult<List<User>>> listLiveData;

    @NotNull
    private final ILikedUnMatchLogic logic;

    @Nullable
    private String nextCursorId;

    @NotNull
    private final LiveData<Pair<Boolean, Boolean>> selectState;
    private boolean showBanUserEntrance;

    @NotNull
    private final LiveData<TitleUiModel> titleLiveData;

    @NotNull
    private final LiveData<Event<List<String>>> unFollowListSucLiveData;

    /* compiled from: UnMatchViewModel.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class TitleUiModel {
        private final int rightColor;
        private final int rightContent;
        private final int titleRes;

        public TitleUiModel(@StringRes int i10, @StringRes int i11, @ColorInt int i12) {
            this.titleRes = i10;
            this.rightContent = i11;
            this.rightColor = i12;
        }

        public static /* synthetic */ TitleUiModel copy$default(TitleUiModel titleUiModel, int i10, int i11, int i12, int i13, Object obj) {
            if ((i13 & 1) != 0) {
                i10 = titleUiModel.titleRes;
            }
            if ((i13 & 2) != 0) {
                i11 = titleUiModel.rightContent;
            }
            if ((i13 & 4) != 0) {
                i12 = titleUiModel.rightColor;
            }
            return titleUiModel.copy(i10, i11, i12);
        }

        public final int component1() {
            return this.titleRes;
        }

        public final int component2() {
            return this.rightContent;
        }

        public final int component3() {
            return this.rightColor;
        }

        @NotNull
        public final TitleUiModel copy(@StringRes int i10, @StringRes int i11, @ColorInt int i12) {
            return new TitleUiModel(i10, i11, i12);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TitleUiModel)) {
                return false;
            }
            TitleUiModel titleUiModel = (TitleUiModel) obj;
            return this.titleRes == titleUiModel.titleRes && this.rightContent == titleUiModel.rightContent && this.rightColor == titleUiModel.rightColor;
        }

        public final int getRightColor() {
            return this.rightColor;
        }

        public final int getRightContent() {
            return this.rightContent;
        }

        public final int getTitleRes() {
            return this.titleRes;
        }

        public int hashCode() {
            return (((this.titleRes * 31) + this.rightContent) * 31) + this.rightColor;
        }

        @NotNull
        public String toString() {
            return "TitleUiModel(titleRes=" + this.titleRes + ", rightContent=" + this.rightContent + ", rightColor=" + this.rightColor + ")";
        }
    }

    public UnMatchViewModel(@NotNull ILikedUnMatchLogic logic) {
        s.i(logic, "logic");
        this.logic = logic;
        MutableLiveData<StateResult<List<User>>> mutableLiveData = new MutableLiveData<>();
        this._listLiveData = mutableLiveData;
        this.listLiveData = Transformations.distinctUntilChanged(mutableLiveData);
        MutableLiveData<Event<List<String>>> mutableLiveData2 = new MutableLiveData<>();
        this._unFollowSucListLiveData = mutableLiveData2;
        this.unFollowListSucLiveData = mutableLiveData2;
        MutableLiveData<Boolean> mutableLiveData3 = new MutableLiveData<>();
        mutableLiveData3.setValue(Boolean.FALSE);
        this._selectState = mutableLiveData3;
        this.selectState = Transformations.map(mutableLiveData3, new Function1<Boolean, Pair<Boolean, Boolean>>() { // from class: com.cupidapp.live.profile.viewmodel.UnMatchViewModel$selectState$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Pair<Boolean, Boolean> invoke(Boolean bool) {
                return new Pair<>(bool, Boolean.valueOf(UnMatchViewModel.this.getLogic().d()));
            }
        });
        this.titleLiveData = Transformations.map(mutableLiveData3, new Function1<Boolean, TitleUiModel>() { // from class: com.cupidapp.live.profile.viewmodel.UnMatchViewModel$titleLiveData$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final UnMatchViewModel.TitleUiModel invoke(Boolean bool) {
                int title = UnMatchViewModel.this.getLogic().getTitle();
                Boolean bool2 = Boolean.TRUE;
                return new UnMatchViewModel.TitleUiModel(title, s.d(bool, bool2) ? 2131886363 : R$string.mul_un_follow, s.d(bool, bool2) ? -49088 : -15066598);
            }
        });
        getData(false);
    }

    public final boolean canLoadMore() {
        String str = this.nextCursorId;
        return !(str == null || str.length() == 0);
    }

    public final void changeSelectState() {
        if (this.listLiveData.getValue() instanceof StateResult.b) {
            return;
        }
        Boolean value = this._selectState.getValue();
        if (value == null) {
            value = Boolean.FALSE;
        }
        this._selectState.setValue(Boolean.valueOf(!value.booleanValue()));
    }

    public final void clearSelectState() {
        this._selectState.setValue(Boolean.FALSE);
    }

    public final int getClearAllContent() {
        return this.logic.b();
    }

    public final void getData(final boolean z10) {
        if (this.listLiveData.getValue() instanceof StateResult.b) {
            StateResult<List<User>> value = this.listLiveData.getValue();
            if (value != null ? s.d(value.isLoadMore(), Boolean.FALSE) : false) {
                return;
            }
        }
        if (!z10) {
            this.nextCursorId = null;
        }
        this._listLiveData.setValue(new StateResult.b(null, Boolean.valueOf(z10), 1, null));
        Disposable disposed = getData().flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<UserListResult, p>() { // from class: com.cupidapp.live.profile.viewmodel.UnMatchViewModel$getData$$inlined$handle$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(UserListResult userListResult) {
                m2776invoke(userListResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2776invoke(UserListResult userListResult) {
                MutableLiveData mutableLiveData;
                List<User> list;
                UserListResult userListResult2 = userListResult;
                boolean z11 = true;
                UnMatchViewModel.this.setShowBanUserEntrance(s.d(userListResult2.getHasBanUser(), Boolean.TRUE) && UnMatchViewModel.this.getLogic().c());
                ArrayList arrayList = new ArrayList();
                List<User> list2 = userListResult2.getList();
                if (list2 != null && !list2.isEmpty()) {
                    z11 = false;
                }
                if (!z11 && (list = userListResult2.getList()) != null) {
                    arrayList.addAll(list);
                }
                UnMatchViewModel.this.nextCursorId = userListResult2.getNextCursorId();
                mutableLiveData = UnMatchViewModel.this._listLiveData;
                mutableLiveData.setValue(new StateResult.c(arrayList, Boolean.valueOf(z10)));
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.profile.viewmodel.UnMatchViewModel$getData$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                MutableLiveData mutableLiveData;
                s.i(it, "it");
                mutableLiveData = UnMatchViewModel.this._listLiveData;
                mutableLiveData.setValue(new StateResult.a(null, null, Boolean.valueOf(z10), 3, null));
                return Boolean.FALSE;
            }
        }, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    @NotNull
    public final LiveData<StateResult<List<User>>> getListLiveData() {
        return this.listLiveData;
    }

    @NotNull
    public final ILikedUnMatchLogic getLogic() {
        return this.logic;
    }

    @NotNull
    public final LiveData<Pair<Boolean, Boolean>> getSelectState() {
        return this.selectState;
    }

    public final boolean getShowBanUserEntrance() {
        return this.showBanUserEntrance;
    }

    @NotNull
    public final LiveData<TitleUiModel> getTitleLiveData() {
        return this.titleLiveData;
    }

    @NotNull
    public final LiveData<Event<List<String>>> getUnFollowListSucLiveData() {
        return this.unFollowListSucLiveData;
    }

    public final void loadMore() {
        if (canLoadMore()) {
            getData(true);
        }
    }

    public final void refresh() {
        getData(false);
    }

    public final void setShowBanUserEntrance(boolean z10) {
        this.showBanUserEntrance = z10;
    }

    public final void unLikeAllUsers() {
        Disposable disposed = this.logic.f().flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<Object, p>() { // from class: com.cupidapp.live.profile.viewmodel.UnMatchViewModel$unLikeAllUsers$$inlined$handleByContext$default$1
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
                MutableLiveData mutableLiveData2;
                UnMatchViewModel.this.nextCursorId = null;
                UnMatchViewModel.this.setShowBanUserEntrance(false);
                mutableLiveData = UnMatchViewModel.this._selectState;
                Boolean bool = Boolean.FALSE;
                mutableLiveData.setValue(bool);
                mutableLiveData2 = UnMatchViewModel.this._listLiveData;
                mutableLiveData2.setValue(new StateResult.c(null, bool));
                GroupSocialLog.f18708a.e(SensorsLogKeyButtonClick.ContactAlohaNotMatchBtn.CLEAN_LIST.getButtonName());
                h.f12779a.k(R$string.clear_done);
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(null, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    public final void unLikedUsers(@NotNull final List<String> selectIds) {
        s.i(selectIds, "selectIds");
        Disposable disposed = this.logic.a(selectIds).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<Object, p>() { // from class: com.cupidapp.live.profile.viewmodel.UnMatchViewModel$unLikedUsers$$inlined$handleByContext$default$1
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
                mutableLiveData = UnMatchViewModel.this._unFollowSucListLiveData;
                mutableLiveData.setValue(new Event(selectIds));
                GroupSocialLog.f18708a.e(SensorsLogKeyButtonClick.ContactAlohaNotMatchBtn.CONFIRM.getButtonName());
                h.f12779a.k(R$string.unselect_done);
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(null, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    private final Observable<Result<UserListResult>> getData() {
        return this.logic.e(this.nextCursorId);
    }
}

package com.cupidapp.live.club.viewmodel;

import a2.a;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.j;
import com.cupidapp.live.base.network.model.ListResult;
import com.cupidapp.live.base.network.model.StateResult;
import com.cupidapp.live.club.model.ActivityListResult;
import com.cupidapp.live.club.model.ActivityModel;
import com.cupidapp.live.club.model.ClubListResult;
import com.cupidapp.live.club.model.ClubModel;
import com.cupidapp.live.club.model.ClubWonderfulActModel;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ClubListViewModel.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ClubListViewModel extends ViewModel {

    @NotNull
    private final MutableLiveData<StateResult<Pair<ClubWonderfulActModel, ActivityListResult>>> _activityListLiveData;

    @NotNull
    private final MutableLiveData<List<ClubModel>> _clubListDialogLiveData;

    @NotNull
    private final MutableLiveData<StateResult<ClubListResult>> _clubListLiveData;

    @NotNull
    private final MutableLiveData<Pair<List<ActivityModel>, Boolean>> _moreActivityListLiveData;

    @NotNull
    private final MutableLiveData<Pair<List<ClubModel>, Boolean>> _moreClubListLiveData;

    @NotNull
    private final MutableLiveData<List<ClubModel>> _muClubLiveData;

    @NotNull
    private final MutableLiveData<Boolean> _newActivityOrder;

    @Nullable
    private String activityListCursor;

    @NotNull
    private final LiveData<StateResult<Pair<ClubWonderfulActModel, ActivityListResult>>> activityListLiveData;

    @Nullable
    private String clubListCursor;

    @NotNull
    private final LiveData<List<ClubModel>> clubListDialogLiveData;

    @NotNull
    private final LiveData<StateResult<ClubListResult>> clubListLiveData;

    @Nullable
    private ClubWonderfulActModel clubWonderfulActModel;
    private boolean endedActivity;

    @NotNull
    private final LiveData<Pair<List<ActivityModel>, Boolean>> moreActivityListLiveData;

    @NotNull
    private final LiveData<Pair<List<ClubModel>, Boolean>> moreClubListLiveData;

    @NotNull
    private final LiveData<List<ClubModel>> muClubLiveData;

    @NotNull
    private final LiveData<Boolean> newActivityOrder;

    public ClubListViewModel() {
        MutableLiveData<StateResult<ClubListResult>> mutableLiveData = new MutableLiveData<>();
        this._clubListLiveData = mutableLiveData;
        this.clubListLiveData = mutableLiveData;
        MutableLiveData<List<ClubModel>> mutableLiveData2 = new MutableLiveData<>();
        this._muClubLiveData = mutableLiveData2;
        this.muClubLiveData = mutableLiveData2;
        MutableLiveData<Pair<List<ClubModel>, Boolean>> mutableLiveData3 = new MutableLiveData<>();
        this._moreClubListLiveData = mutableLiveData3;
        this.moreClubListLiveData = mutableLiveData3;
        MutableLiveData<StateResult<Pair<ClubWonderfulActModel, ActivityListResult>>> mutableLiveData4 = new MutableLiveData<>();
        this._activityListLiveData = mutableLiveData4;
        this.activityListLiveData = mutableLiveData4;
        MutableLiveData<Boolean> mutableLiveData5 = new MutableLiveData<>();
        this._newActivityOrder = mutableLiveData5;
        this.newActivityOrder = mutableLiveData5;
        MutableLiveData<Pair<List<ActivityModel>, Boolean>> mutableLiveData6 = new MutableLiveData<>();
        this._moreActivityListLiveData = mutableLiveData6;
        this.moreActivityListLiveData = mutableLiveData6;
        MutableLiveData<List<ClubModel>> mutableLiveData7 = new MutableLiveData<>();
        this._clubListDialogLiveData = mutableLiveData7;
        this.clubListDialogLiveData = mutableLiveData7;
    }

    public static final Pair getActivityListData$lambda$2(ClubWonderfulActModel bannerModel, ActivityListResult list) {
        s.i(bannerModel, "bannerModel");
        s.i(list, "list");
        return new Pair(bannerModel, list);
    }

    public static final void getActivityListData$lambda$3(Function1 tmp0, Object obj) {
        s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void getActivityListData$lambda$4(Function1 tmp0, Object obj) {
        s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static /* synthetic */ void getClubListData$default(ClubListViewModel clubListViewModel, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = null;
        }
        clubListViewModel.getClubListData(str, str2);
    }

    private final Observable<ClubWonderfulActModel> getWonderfulAct(boolean z10) {
        ClubWonderfulActModel clubWonderfulActModel;
        if (!z10 && (clubWonderfulActModel = this.clubWonderfulActModel) != null) {
            Observable<ClubWonderfulActModel> just = Observable.just(clubWonderfulActModel);
            s.h(just, "{\n            Observable…derfulActModel)\n        }");
            return just;
        }
        Observable onErrorReturnItem = NetworkClient.f11868a.u().n().flatMap(new com.cupidapp.live.base.network.i()).onErrorReturnItem(new ClubWonderfulActModel(null, null));
        final Function1<ClubWonderfulActModel, p> function1 = new Function1<ClubWonderfulActModel, p>() { // from class: com.cupidapp.live.club.viewmodel.ClubListViewModel$getWonderfulAct$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(ClubWonderfulActModel clubWonderfulActModel2) {
                invoke2(clubWonderfulActModel2);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ClubWonderfulActModel clubWonderfulActModel2) {
                ClubListViewModel.this.clubWonderfulActModel = clubWonderfulActModel2;
            }
        };
        Observable<ClubWonderfulActModel> doOnNext = onErrorReturnItem.doOnNext(new Consumer() { // from class: com.cupidapp.live.club.viewmodel.g
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ClubListViewModel.getWonderfulAct$lambda$5(Function1.this, obj);
            }
        });
        s.h(doOnNext, "private fun getWonderful…derfulActModel)\n        }");
        return doOnNext;
    }

    public static final void getWonderfulAct$lambda$5(Function1 tmp0, Object obj) {
        s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final void getActivityListData(@NotNull String orderType, boolean z10) {
        s.i(orderType, "orderType");
        Observable observeOn = Observable.zip(getWonderfulAct(z10), a.C0010a.a(NetworkClient.f11868a.u(), null, false, null, orderType, 7, null).flatMap(new com.cupidapp.live.base.network.i()), new BiFunction() { // from class: com.cupidapp.live.club.viewmodel.f
            @Override // io.reactivex.functions.BiFunction
            public final Object apply(Object obj, Object obj2) {
                Pair activityListData$lambda$2;
                activityListData$lambda$2 = ClubListViewModel.getActivityListData$lambda$2((ClubWonderfulActModel) obj, (ActivityListResult) obj2);
                return activityListData$lambda$2;
            }
        }).observeOn(AndroidSchedulers.mainThread());
        final Function1<Pair<? extends ClubWonderfulActModel, ? extends ActivityListResult>, p> function1 = new Function1<Pair<? extends ClubWonderfulActModel, ? extends ActivityListResult>, p>() { // from class: com.cupidapp.live.club.viewmodel.ClubListViewModel$getActivityListData$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Pair<? extends ClubWonderfulActModel, ? extends ActivityListResult> pair) {
                invoke2((Pair<ClubWonderfulActModel, ActivityListResult>) pair);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Pair<ClubWonderfulActModel, ActivityListResult> pair) {
                MutableLiveData mutableLiveData;
                ClubListViewModel.this.activityListCursor = pair.getSecond().getNextCursorId();
                ClubListViewModel.this.endedActivity = pair.getSecond().getEndedActivity();
                mutableLiveData = ClubListViewModel.this._activityListLiveData;
                mutableLiveData.setValue(new StateResult.c(pair, null, 2, null));
            }
        };
        Consumer consumer = new Consumer() { // from class: com.cupidapp.live.club.viewmodel.i
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ClubListViewModel.getActivityListData$lambda$3(Function1.this, obj);
            }
        };
        final Function1<Throwable, p> function12 = new Function1<Throwable, p>() { // from class: com.cupidapp.live.club.viewmodel.ClubListViewModel$getActivityListData$3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Throwable th) {
                invoke2(th);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable it) {
                MutableLiveData mutableLiveData;
                mutableLiveData = ClubListViewModel.this._activityListLiveData;
                mutableLiveData.setValue(new StateResult.a(null, null, null, 7, null));
                j jVar = j.f12008a;
                s.h(it, "it");
                j.f(jVar, it, null, null, null, 14, null);
            }
        };
        observeOn.subscribe(consumer, new Consumer() { // from class: com.cupidapp.live.club.viewmodel.h
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ClubListViewModel.getActivityListData$lambda$4(Function1.this, obj);
            }
        });
    }

    @NotNull
    public final LiveData<StateResult<Pair<ClubWonderfulActModel, ActivityListResult>>> getActivityListLiveData() {
        return this.activityListLiveData;
    }

    public final void getClubListData(@Nullable final String str, @NotNull String orderType) {
        s.i(orderType, "orderType");
        Disposable disposed = NetworkClient.f11868a.u().s(str, orderType).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<ClubListResult, p>() { // from class: com.cupidapp.live.club.viewmodel.ClubListViewModel$getClubListData$$inlined$handle$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(ClubListResult clubListResult) {
                m2526invoke(clubListResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2526invoke(ClubListResult clubListResult) {
                MutableLiveData mutableLiveData;
                MutableLiveData mutableLiveData2;
                ClubListResult clubListResult2 = clubListResult;
                ClubListViewModel.this.clubListCursor = clubListResult2.getNextCursorId();
                if (str == null) {
                    mutableLiveData2 = ClubListViewModel.this._clubListLiveData;
                    mutableLiveData2.setValue(new StateResult.c(clubListResult2, null, 2, null));
                    return;
                }
                List<ClubModel> sameCityList = clubListResult2.getSameCityList();
                if (sameCityList == null || sameCityList.isEmpty()) {
                    return;
                }
                mutableLiveData = ClubListViewModel.this._moreClubListLiveData;
                List<ClubModel> sameCityList2 = clubListResult2.getSameCityList();
                String nextCursorId = clubListResult2.getNextCursorId();
                mutableLiveData.setValue(new Pair(sameCityList2, Boolean.valueOf(nextCursorId == null || nextCursorId.length() == 0)));
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.club.viewmodel.ClubListViewModel$getClubListData$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                MutableLiveData mutableLiveData;
                s.i(it, "it");
                if (String.this == null) {
                    mutableLiveData = this._clubListLiveData;
                    mutableLiveData.setValue(new StateResult.a(null, null, null, 7, null));
                }
                return Boolean.FALSE;
            }
        }, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    public final void getClubListDialogData(@NotNull String userId) {
        s.i(userId, "userId");
        Disposable disposed = NetworkClient.f11868a.u().w(userId).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<ListResult<ClubModel>, p>() { // from class: com.cupidapp.live.club.viewmodel.ClubListViewModel$getClubListDialogData$$inlined$handle$default$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(ListResult<ClubModel> listResult) {
                m2527invoke(listResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2527invoke(ListResult<ClubModel> listResult) {
                MutableLiveData mutableLiveData;
                ListResult<ClubModel> listResult2 = listResult;
                List<ClubModel> list = listResult2.getList();
                if (list == null || list.isEmpty()) {
                    return;
                }
                mutableLiveData = ClubListViewModel.this._clubListDialogLiveData;
                List<ClubModel> list2 = listResult2.getList();
                s.f(list2);
                mutableLiveData.setValue(list2);
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    @NotNull
    public final LiveData<List<ClubModel>> getClubListDialogLiveData() {
        return this.clubListDialogLiveData;
    }

    @NotNull
    public final LiveData<StateResult<ClubListResult>> getClubListLiveData() {
        return this.clubListLiveData;
    }

    @NotNull
    public final LiveData<Pair<List<ActivityModel>, Boolean>> getMoreActivityListLiveData() {
        return this.moreActivityListLiveData;
    }

    @NotNull
    public final LiveData<Pair<List<ClubModel>, Boolean>> getMoreClubListLiveData() {
        return this.moreClubListLiveData;
    }

    @NotNull
    public final LiveData<List<ClubModel>> getMuClubLiveData() {
        return this.muClubLiveData;
    }

    public final void getMyClub() {
        Disposable disposed = a.C0010a.c(NetworkClient.f11868a.u(), null, null, 3, null).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<ClubListResult, p>() { // from class: com.cupidapp.live.club.viewmodel.ClubListViewModel$getMyClub$$inlined$handle$default$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(ClubListResult clubListResult) {
                m2528invoke(clubListResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2528invoke(ClubListResult clubListResult) {
                MutableLiveData mutableLiveData;
                mutableLiveData = ClubListViewModel.this._muClubLiveData;
                mutableLiveData.setValue(clubListResult.getMineList());
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    @NotNull
    public final LiveData<Boolean> getNewActivityOrder() {
        return this.newActivityOrder;
    }

    public final void loadMoreActivity(@NotNull String orderType) {
        s.i(orderType, "orderType");
        String str = this.activityListCursor;
        if (str == null || str.length() == 0) {
            return;
        }
        Disposable disposed = a.C0010a.a(NetworkClient.f11868a.u(), this.activityListCursor, this.endedActivity, null, orderType, 4, null).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<ActivityListResult, p>() { // from class: com.cupidapp.live.club.viewmodel.ClubListViewModel$loadMoreActivity$$inlined$handle$default$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(ActivityListResult activityListResult) {
                m2530invoke(activityListResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2530invoke(ActivityListResult activityListResult) {
                MutableLiveData mutableLiveData;
                ActivityListResult activityListResult2 = activityListResult;
                ClubListViewModel.this.activityListCursor = activityListResult2.getNextCursorId();
                ClubListViewModel.this.endedActivity = activityListResult2.getEndedActivity();
                List<ActivityModel> recentList = activityListResult2.getRecentList();
                if (recentList == null || recentList.isEmpty()) {
                    return;
                }
                mutableLiveData = ClubListViewModel.this._moreActivityListLiveData;
                List<ActivityModel> recentList2 = activityListResult2.getRecentList();
                String nextCursorId = activityListResult2.getNextCursorId();
                mutableLiveData.setValue(new Pair(recentList2, Boolean.valueOf(nextCursorId == null || nextCursorId.length() == 0)));
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    public final void loadMoreClub(@NotNull String orderType) {
        s.i(orderType, "orderType");
        String str = this.clubListCursor;
        if (str == null || str.length() == 0) {
            return;
        }
        getClubListData(this.clubListCursor, orderType);
    }

    /* renamed from: getNewActivityOrder */
    public final void m2525getNewActivityOrder() {
        Disposable disposed = a.C0010a.a(NetworkClient.f11868a.u(), null, false, null, null, 15, null).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<ActivityListResult, p>() { // from class: com.cupidapp.live.club.viewmodel.ClubListViewModel$getNewActivityOrder$$inlined$handle$default$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(ActivityListResult activityListResult) {
                m2529invoke(activityListResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2529invoke(ActivityListResult activityListResult) {
                MutableLiveData mutableLiveData;
                mutableLiveData = ClubListViewModel.this._newActivityOrder;
                Boolean activityOrderUnread = activityListResult.getActivityOrderUnread();
                if (activityOrderUnread == null) {
                    activityOrderUnread = Boolean.FALSE;
                }
                mutableLiveData.setValue(activityOrderUnread);
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }
}

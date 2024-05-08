package com.cupidapp.live.tourist.model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.e;
import com.cupidapp.live.base.network.i;
import com.cupidapp.live.feed.model.FeedRecommendListResult;
import com.cupidapp.live.feed.model.FeedRecommendResult;
import com.cupidapp.live.match.model.MatchRecommendModel;
import com.cupidapp.live.match.model.MatchRecommendUserModel;
import com.cupidapp.live.match.model.MatchResult;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.List;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;

/* compiled from: FKTouristViewModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FKTouristViewModel extends ViewModel {

    @NotNull
    private final MutableLiveData<MatchRecommendUserModel> _recommendCardLiveData;

    @NotNull
    private final MutableLiveData<List<FeedRecommendResult>> _recommendFeedLiveData;

    @NotNull
    private final LiveData<MatchRecommendUserModel> recommendCardLiveData;

    @NotNull
    private final LiveData<List<FeedRecommendResult>> recommendFeedLiveData;

    public FKTouristViewModel() {
        MutableLiveData<MatchRecommendUserModel> mutableLiveData = new MutableLiveData<>();
        this._recommendCardLiveData = mutableLiveData;
        this.recommendCardLiveData = mutableLiveData;
        MutableLiveData<List<FeedRecommendResult>> mutableLiveData2 = new MutableLiveData<>();
        this._recommendFeedLiveData = mutableLiveData2;
        this.recommendFeedLiveData = mutableLiveData2;
    }

    public final void getRecommendCard() {
        Disposable disposed = NetworkClient.f11868a.L().a().flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<MatchResult, p>() { // from class: com.cupidapp.live.tourist.model.FKTouristViewModel$getRecommendCard$$inlined$handle$default$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(MatchResult matchResult) {
                m2829invoke(matchResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2829invoke(MatchResult matchResult) {
                MutableLiveData mutableLiveData;
                MatchResult matchResult2 = matchResult;
                List<MatchRecommendModel> list = matchResult2.getList();
                if (list == null || list.isEmpty()) {
                    return;
                }
                mutableLiveData = FKTouristViewModel.this._recommendCardLiveData;
                List<MatchRecommendModel> list2 = matchResult2.getList();
                s.f(list2);
                MatchRecommendModel matchRecommendModel = list2.get(0);
                mutableLiveData.setValue(matchRecommendModel instanceof MatchRecommendUserModel ? (MatchRecommendUserModel) matchRecommendModel : null);
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(null, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    @NotNull
    public final LiveData<MatchRecommendUserModel> getRecommendCardLiveData() {
        return this.recommendCardLiveData;
    }

    @NotNull
    public final LiveData<List<FeedRecommendResult>> getRecommendFeedLiveData() {
        return this.recommendFeedLiveData;
    }

    public final void getRecommendPost() {
        Disposable disposed = NetworkClient.f11868a.L().b().flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<FeedRecommendListResult, p>() { // from class: com.cupidapp.live.tourist.model.FKTouristViewModel$getRecommendPost$$inlined$handle$default$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(FeedRecommendListResult feedRecommendListResult) {
                m2830invoke(feedRecommendListResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2830invoke(FeedRecommendListResult feedRecommendListResult) {
                MutableLiveData mutableLiveData;
                List<FeedRecommendResult> list = feedRecommendListResult.getList();
                if (list != null) {
                    mutableLiveData = FKTouristViewModel.this._recommendFeedLiveData;
                    mutableLiveData.setValue(list);
                }
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(null, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }
}

package com.cupidapp.live.feed.viewmodel;

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
import com.cupidapp.live.feed.model.FeedLikeResult;
import com.cupidapp.live.feed.model.FeedModel;
import com.cupidapp.live.feed.model.FeedRecommendResult;
import f2.a;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ClassifyFeedViewModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ClassifyFeedViewModel extends ViewModel {

    @NotNull
    private final MutableLiveData<StateResult<ListResult<FeedRecommendResult>>> _classifyFeedListLiveData;

    @NotNull
    private final MutableLiveData<Event<Integer>> _praiseFeedEventLiveData;

    @NotNull
    private final LiveData<StateResult<ListResult<FeedRecommendResult>>> classifyFeedListLiveData;

    @NotNull
    private final LiveData<Event<Integer>> praiseFeedEventLiveData;

    @Nullable
    private String tab;

    @Nullable
    private String tag;

    public ClassifyFeedViewModel() {
        MutableLiveData<StateResult<ListResult<FeedRecommendResult>>> mutableLiveData = new MutableLiveData<>();
        this._classifyFeedListLiveData = mutableLiveData;
        this.classifyFeedListLiveData = Transformations.distinctUntilChanged(mutableLiveData);
        MutableLiveData<Event<Integer>> mutableLiveData2 = new MutableLiveData<>();
        this._praiseFeedEventLiveData = mutableLiveData2;
        this.praiseFeedEventLiveData = mutableLiveData2;
    }

    public static /* synthetic */ void loadFeedRcmdList$default(ClassifyFeedViewModel classifyFeedViewModel, String str, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = null;
        }
        classifyFeedViewModel.loadFeedRcmdList(str, z10);
    }

    @NotNull
    public final LiveData<StateResult<ListResult<FeedRecommendResult>>> getClassifyFeedListLiveData() {
        return this.classifyFeedListLiveData;
    }

    @NotNull
    public final LiveData<Event<Integer>> getPraiseFeedEventLiveData() {
        return this.praiseFeedEventLiveData;
    }

    @Nullable
    public final String getTab() {
        return this.tab;
    }

    @Nullable
    public final String getTag() {
        return this.tag;
    }

    public final void initData(@Nullable String str, @Nullable String str2) {
        this.tag = str;
        this.tab = str2;
    }

    public final void likeFeed(@Nullable final FeedModel feedModel, final int i10) {
        if (feedModel == null) {
            return;
        }
        if (feedModel.getLiked()) {
            Disposable disposed = NetworkClient.f11868a.l().D(feedModel.getPostId()).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<Object, p>() { // from class: com.cupidapp.live.feed.viewmodel.ClassifyFeedViewModel$likeFeed$$inlined$handle$default$1
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
                    FeedModel.this.cancelPraise();
                    mutableLiveData = this._praiseFeedEventLiveData;
                    mutableLiveData.setValue(new Event(Integer.valueOf(i10)));
                }
            }), new e(new ObservableExtensionKt$handle$disposed$2(null, null)));
            if (disposed != null) {
                s.h(disposed, "disposed");
            }
            s.h(disposed, "disposed");
            return;
        }
        Disposable disposed2 = NetworkClient.f11868a.l().A(feedModel.getPostId()).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<FeedLikeResult, p>() { // from class: com.cupidapp.live.feed.viewmodel.ClassifyFeedViewModel$likeFeed$$inlined$handle$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(FeedLikeResult feedLikeResult) {
                m2579invoke(feedLikeResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2579invoke(FeedLikeResult feedLikeResult) {
                MutableLiveData mutableLiveData;
                FeedModel.this.praise();
                mutableLiveData = this._praiseFeedEventLiveData;
                mutableLiveData.setValue(new Event(Integer.valueOf(i10)));
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(null, null)));
        if (disposed2 != null) {
            s.h(disposed2, "disposed");
        }
        s.h(disposed2, "disposed");
    }

    public final void loadFeedRcmdList(@Nullable String str, final boolean z10) {
        if (this._classifyFeedListLiveData.getValue() instanceof StateResult.b) {
            return;
        }
        this._classifyFeedListLiveData.setValue(new StateResult.b(null, null, 3, null));
        a l10 = NetworkClient.f11868a.l();
        String str2 = this.tag;
        if (str2 == null) {
            str2 = "";
        }
        Disposable disposed = a.C0731a.d(l10, str2, this.tab, str, 0, 8, null).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<ListResult<FeedRecommendResult>, p>() { // from class: com.cupidapp.live.feed.viewmodel.ClassifyFeedViewModel$loadFeedRcmdList$$inlined$handle$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(ListResult<FeedRecommendResult> listResult) {
                m2580invoke(listResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2580invoke(ListResult<FeedRecommendResult> listResult) {
                MutableLiveData mutableLiveData;
                mutableLiveData = ClassifyFeedViewModel.this._classifyFeedListLiveData;
                mutableLiveData.setValue(new StateResult.c(listResult, Boolean.valueOf(z10)));
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.feed.viewmodel.ClassifyFeedViewModel$loadFeedRcmdList$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                MutableLiveData mutableLiveData;
                s.i(it, "it");
                mutableLiveData = ClassifyFeedViewModel.this._classifyFeedListLiveData;
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

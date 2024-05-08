package com.cupidapp.live.feed.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.e;
import com.cupidapp.live.base.network.i;
import com.cupidapp.live.base.view.FKTitleViewModel;
import com.cupidapp.live.base.view.TitleConfigModel;
import com.cupidapp.live.base.view.TitleIndicatorModel;
import com.cupidapp.live.feed.activity.ClassifyTabUiModel;
import com.cupidapp.live.feed.model.FeedRecommendAdTopModel;
import com.cupidapp.live.feed.model.FeedTabModel;
import com.cupidapp.live.feed.model.TopShowGuideModel;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.List;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ClassifyFeedTabViewModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ClassifyFeedTabViewModel extends ViewModel {

    @NotNull
    private final MutableLiveData<ClassifyTabUiModel> _AdTopTabLiveData;

    @NotNull
    private final MutableLiveData<TopShowGuideModel> _adEntranceLiveData;

    @NotNull
    private final LiveData<TopShowGuideModel> adEntranceLiveData;

    @NotNull
    private final LiveData<ClassifyTabUiModel> topAdLiveData;

    public ClassifyFeedTabViewModel() {
        MutableLiveData<ClassifyTabUiModel> mutableLiveData = new MutableLiveData<>();
        this._AdTopTabLiveData = mutableLiveData;
        this.topAdLiveData = mutableLiveData;
        MutableLiveData<TopShowGuideModel> mutableLiveData2 = new MutableLiveData<>();
        this._adEntranceLiveData = mutableLiveData2;
        this.adEntranceLiveData = mutableLiveData2;
    }

    @NotNull
    public final LiveData<TopShowGuideModel> getAdEntranceLiveData() {
        return this.adEntranceLiveData;
    }

    @NotNull
    public final ClassifyTabUiModel getTabUiModel(@Nullable List<FeedTabModel> list) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (list != null) {
            for (FeedTabModel feedTabModel : list) {
                if (feedTabModel.getTabName() != null && feedTabModel.getTab() != null) {
                    arrayList.add(new FKTitleViewModel(feedTabModel.getTabName(), new TitleConfigModel(16.0f, -15066598, true), new TitleConfigModel(16.0f, -15066598, false), new TitleIndicatorModel(-3635954, 28.0f, 0.0f, 4, null), false, 16, null));
                    arrayList2.add(feedTabModel.getTab());
                }
            }
        }
        return new ClassifyTabUiModel(arrayList, arrayList2);
    }

    @NotNull
    public final LiveData<ClassifyTabUiModel> getTopAdLiveData() {
        return this.topAdLiveData;
    }

    public final void loadTab(@NotNull String tag, @Nullable String str) {
        s.i(tag, "tag");
        if (str == null || str.length() == 0) {
            this._AdTopTabLiveData.setValue(getTabUiModel(null));
            this._adEntranceLiveData.setValue(null);
        } else {
            Disposable disposed = NetworkClient.f11868a.l().c(tag).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<FeedRecommendAdTopModel, p>() { // from class: com.cupidapp.live.feed.viewmodel.ClassifyFeedTabViewModel$loadTab$$inlined$handle$default$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(FeedRecommendAdTopModel feedRecommendAdTopModel) {
                    m2578invoke(feedRecommendAdTopModel);
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m2578invoke(FeedRecommendAdTopModel feedRecommendAdTopModel) {
                    MutableLiveData mutableLiveData;
                    MutableLiveData mutableLiveData2;
                    FeedRecommendAdTopModel feedRecommendAdTopModel2 = feedRecommendAdTopModel;
                    mutableLiveData = ClassifyFeedTabViewModel.this._AdTopTabLiveData;
                    mutableLiveData.setValue(ClassifyFeedTabViewModel.this.getTabUiModel(feedRecommendAdTopModel2.getTabList()));
                    mutableLiveData2 = ClassifyFeedTabViewModel.this._adEntranceLiveData;
                    mutableLiveData2.setValue(feedRecommendAdTopModel2.getTopShowGuide());
                }
            }), new e(new ObservableExtensionKt$handle$disposed$2(null, null)));
            if (disposed != null) {
                s.h(disposed, "disposed");
            }
            s.h(disposed, "disposed");
        }
    }
}

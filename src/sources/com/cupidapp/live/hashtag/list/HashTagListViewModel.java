package com.cupidapp.live.hashtag.list;

import androidx.annotation.MainThread;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import com.cupidapp.live.base.livedata.Event;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.model.ListResult;
import com.cupidapp.live.base.network.model.Result;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorsLogFeed;
import com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick;
import com.cupidapp.live.hashtag.model.HashTag;
import com.cupidapp.live.hashtag.model.HashTagAggregationModel;
import com.cupidapp.live.hashtag.model.ui.HashTagClassifyModel;
import io.reactivex.Observable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.t;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: HashTagListViewModel.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class HashTagListViewModel extends ViewModel {

    @NotNull
    private final MutableLiveData<List<HashTagClassifyModel>> _classifiesLiveData;

    @NotNull
    private final MutableLiveData<Event<HashTag>> _openHashTagEvent;

    @NotNull
    private final MutableLiveData<HashTagClassifyModel> _selectClassifyLiveData;

    @NotNull
    private final MutableLiveData<Event<HashTag>> _selectHashTagEvent;

    @NotNull
    private final LiveData<List<HashTagClassifyModel>> classifiesLiveData;

    @NotNull
    private final LiveData<Pair<Boolean, List<HashTag>>> contentsLiveData;
    private final boolean isSelectType;

    @Nullable
    private List<HashTagAggregationModel> list;

    @NotNull
    private final LiveData<Event<HashTag>> openHashTagEvent;

    @NotNull
    private final HashTagListType pageType;

    @NotNull
    private final LiveData<HashTagClassifyModel> selectClassifyLiveData;

    @NotNull
    private final LiveData<Event<HashTag>> selectHashTagEvent;

    public HashTagListViewModel(@NotNull HashTagListType pageType) {
        s.i(pageType, "pageType");
        this.pageType = pageType;
        MutableLiveData<List<HashTagClassifyModel>> mutableLiveData = new MutableLiveData<>();
        this._classifiesLiveData = mutableLiveData;
        this.classifiesLiveData = Transformations.distinctUntilChanged(mutableLiveData);
        MutableLiveData<HashTagClassifyModel> mutableLiveData2 = new MutableLiveData<>();
        this._selectClassifyLiveData = mutableLiveData2;
        this.selectClassifyLiveData = mutableLiveData2;
        this.contentsLiveData = Transformations.distinctUntilChanged(Transformations.map(mutableLiveData2, new Function1<HashTagClassifyModel, Pair<Boolean, List<HashTag>>>() { // from class: com.cupidapp.live.hashtag.list.HashTagListViewModel$contentsLiveData$1
            {
                super(1);
            }

            /* JADX WARN: Code restructure failed: missing block: B:18:0x0053, code lost:
            
                if (r7 != null) goto L21;
             */
            @Override // kotlin.jvm.functions.Function1
            @org.jetbrains.annotations.NotNull
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final kotlin.Pair<java.lang.Boolean, java.util.List<com.cupidapp.live.hashtag.model.HashTag>> invoke(com.cupidapp.live.hashtag.model.ui.HashTagClassifyModel r7) {
                /*
                    r6 = this;
                    java.lang.String r0 = r7.getId()
                    com.cupidapp.live.hashtag.list.HashTagListViewModel r1 = com.cupidapp.live.hashtag.list.HashTagListViewModel.this
                    java.util.List r1 = com.cupidapp.live.hashtag.list.HashTagListViewModel.access$getList$p(r1)
                    r2 = 0
                    if (r1 == 0) goto L1a
                    java.lang.Object r1 = kotlin.collections.CollectionsKt___CollectionsKt.V(r1)
                    com.cupidapp.live.hashtag.model.HashTagAggregationModel r1 = (com.cupidapp.live.hashtag.model.HashTagAggregationModel) r1
                    if (r1 == 0) goto L1a
                    java.lang.String r1 = r1.getItemId()
                    goto L1b
                L1a:
                    r1 = r2
                L1b:
                    boolean r0 = kotlin.jvm.internal.s.d(r0, r1)
                    java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
                    com.cupidapp.live.hashtag.list.HashTagListViewModel r1 = com.cupidapp.live.hashtag.list.HashTagListViewModel.this
                    java.util.List r1 = com.cupidapp.live.hashtag.list.HashTagListViewModel.access$getList$p(r1)
                    if (r1 == 0) goto L55
                    java.util.Iterator r1 = r1.iterator2()
                L2f:
                    boolean r3 = r1.hasNext()
                    if (r3 == 0) goto L4b
                    java.lang.Object r3 = r1.next()
                    r4 = r3
                    com.cupidapp.live.hashtag.model.HashTagAggregationModel r4 = (com.cupidapp.live.hashtag.model.HashTagAggregationModel) r4
                    java.lang.String r4 = r4.getItemId()
                    java.lang.String r5 = r7.getId()
                    boolean r4 = kotlin.jvm.internal.s.d(r4, r5)
                    if (r4 == 0) goto L2f
                    r2 = r3
                L4b:
                    com.cupidapp.live.hashtag.model.HashTagAggregationModel r2 = (com.cupidapp.live.hashtag.model.HashTagAggregationModel) r2
                    if (r2 == 0) goto L55
                    java.util.List r7 = r2.getHashTags()
                    if (r7 != 0) goto L5a
                L55:
                    java.util.ArrayList r7 = new java.util.ArrayList
                    r7.<init>()
                L5a:
                    kotlin.Pair r1 = new kotlin.Pair
                    r1.<init>(r0, r7)
                    return r1
                */
                throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.hashtag.list.HashTagListViewModel$contentsLiveData$1.invoke(com.cupidapp.live.hashtag.model.ui.HashTagClassifyModel):kotlin.Pair");
            }
        }));
        MutableLiveData<Event<HashTag>> mutableLiveData3 = new MutableLiveData<>();
        this._openHashTagEvent = mutableLiveData3;
        this.openHashTagEvent = mutableLiveData3;
        MutableLiveData<Event<HashTag>> mutableLiveData4 = new MutableLiveData<>();
        this._selectHashTagEvent = mutableLiveData4;
        this.selectHashTagEvent = mutableLiveData4;
        this.isSelectType = pageType == HashTagListType.DATA_SELECT_HASHTAG;
    }

    @MainThread
    public final void changeSelectHashTagClassify(@NotNull HashTagClassifyModel classify) {
        s.i(classify, "classify");
        SensorsLogKeyButtonClick.f12211a.c(getCurrentSensorPosition().getValue(), classify.getName());
        this._selectClassifyLiveData.setValue(classify);
    }

    @MainThread
    public final void clickHashTag(@NotNull HashTag hashTag) {
        s.i(hashTag, "hashTag");
        if (this.isSelectType) {
            this._selectHashTagEvent.setValue(new Event<>(hashTag));
        } else {
            this._openHashTagEvent.setValue(new Event<>(hashTag));
        }
        SensorsLogFeed sensorsLogFeed = SensorsLogFeed.f12208a;
        SensorPosition currentSensorPosition = getCurrentSensorPosition();
        HashTagClassifyModel value = this.selectClassifyLiveData.getValue();
        sensorsLogFeed.L(currentSensorPosition, value != null ? value.getName() : null, hashTag.getItemId());
    }

    @NotNull
    public final LiveData<List<HashTagClassifyModel>> getClassifiesLiveData() {
        return this.classifiesLiveData;
    }

    @NotNull
    public final LiveData<Pair<Boolean, List<HashTag>>> getContentsLiveData() {
        return this.contentsLiveData;
    }

    @NotNull
    public final SensorPosition getCurrentSensorPosition() {
        if (this.pageType == HashTagListType.DATA_SELECT_HASHTAG) {
            return SensorPosition.HashtagSelect;
        }
        return SensorPosition.HashtagList;
    }

    @NotNull
    public final Observable<Result<ListResult<HashTagAggregationModel>>> getHashtagClassifies() {
        return NetworkClient.f11868a.l().z();
    }

    @NotNull
    public final LiveData<Event<HashTag>> getOpenHashTagEvent() {
        return this.openHashTagEvent;
    }

    @NotNull
    public final HashTagListType getPageType() {
        return this.pageType;
    }

    @NotNull
    public final LiveData<HashTagClassifyModel> getSelectClassifyLiveData() {
        return this.selectClassifyLiveData;
    }

    @NotNull
    public final LiveData<Event<HashTag>> getSelectHashTagEvent() {
        return this.selectHashTagEvent;
    }

    public final boolean isSelectType() {
        return this.isSelectType;
    }

    @MainThread
    public final void setHashTagClassifies(@Nullable List<HashTagAggregationModel> list) {
        ArrayList arrayList;
        HashTagClassifyModel hashTagClassifyModel;
        this.list = list;
        if (list != null) {
            ArrayList<HashTagAggregationModel> arrayList2 = new ArrayList();
            for (HashTagAggregationModel hashTagAggregationModel : list) {
                HashTagAggregationModel hashTagAggregationModel2 = hashTagAggregationModel;
                if ((hashTagAggregationModel2.getItemId() == null || hashTagAggregationModel2.getTitle() == null) ? false : true) {
                    arrayList2.add(hashTagAggregationModel);
                }
            }
            arrayList = new ArrayList(t.t(arrayList2, 10));
            for (HashTagAggregationModel hashTagAggregationModel3 : arrayList2) {
                String itemId = hashTagAggregationModel3.getItemId();
                s.f(itemId);
                String title = hashTagAggregationModel3.getTitle();
                s.f(title);
                arrayList.add(new HashTagClassifyModel(itemId, title));
            }
        } else {
            arrayList = null;
        }
        this._classifiesLiveData.setValue(arrayList);
        if (this._selectClassifyLiveData.getValue() != null || arrayList == null || (hashTagClassifyModel = (HashTagClassifyModel) CollectionsKt___CollectionsKt.V(arrayList)) == null) {
            return;
        }
        this._selectClassifyLiveData.setValue(hashTagClassifyModel);
    }
}

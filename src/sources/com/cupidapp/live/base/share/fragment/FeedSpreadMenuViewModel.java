package com.cupidapp.live.base.share.fragment;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.model.ConstantsResult;
import com.cupidapp.live.base.network.model.ConstantsUrlModel;
import com.cupidapp.live.base.share.model.BaseShareItemModel;
import com.cupidapp.live.base.share.model.FKShareItemModel;
import com.cupidapp.live.base.share.model.ShareBaseType;
import com.cupidapp.live.base.share.model.ShareItemHandledResult;
import com.cupidapp.live.base.share.model.SpreadMenuType;
import com.cupidapp.live.base.share.model.State;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.i0;
import kotlin.collections.s;
import kotlin.jvm.functions.Function1;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FeedSpreadMenuViewModel.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FeedSpreadMenuViewModel extends ViewModel {
    private final int MIN_WEIGHT_NUM = 5;

    @NotNull
    private final MutableLiveData<ShareItemHandledResult> _handledResult;

    @NotNull
    private final MutableLiveData<Pair<Collection<BaseShareItemModel>, Collection<BaseShareItemModel>>> _models;

    @NotNull
    private final LiveData<ShareItemHandledResult> handledResult;

    @NotNull
    private final LiveData<Pair<Collection<BaseShareItemModel>, Collection<BaseShareItemModel>>> models;

    @Nullable
    private final FeedSpreadMenuModel spreadMenuModel;

    public FeedSpreadMenuViewModel(@Nullable FeedSpreadMenuModel feedSpreadMenuModel) {
        List j10;
        List list;
        List<SpreadMenuType> shareMenus;
        this.spreadMenuModel = feedSpreadMenuModel;
        MutableLiveData<Pair<Collection<BaseShareItemModel>, Collection<BaseShareItemModel>>> mutableLiveData = new MutableLiveData<>();
        this._models = mutableLiveData;
        this.models = mutableLiveData;
        MutableLiveData<ShareItemHandledResult> mutableLiveData2 = new MutableLiveData<>();
        this._handledResult = mutableLiveData2;
        this.handledResult = Transformations.distinctUntilChanged(mutableLiveData2);
        if (feedSpreadMenuModel != null && (shareMenus = feedSpreadMenuModel.getShareMenus()) != null) {
            j10 = new ArrayList();
            Iterator<SpreadMenuType> iterator2 = shareMenus.iterator2();
            while (iterator2.hasNext()) {
                FKShareItemModel fKShareItemModel = getAllMenuList().get(iterator2.next());
                if (fKShareItemModel != null) {
                    j10.add(fKShareItemModel);
                }
            }
        } else {
            j10 = s.j();
        }
        int size = j10.size();
        int i10 = this.MIN_WEIGHT_NUM;
        if (size > i10) {
            List subList = j10.subList(0, i10);
            List subList2 = j10.subList(this.MIN_WEIGHT_NUM, j10.size());
            j10 = subList;
            list = subList2;
        } else {
            list = null;
        }
        this._models.setValue(new Pair<>(j10, list));
    }

    private final void disinterest(String str) {
        FeedSpreadMenuModel feedSpreadMenuModel = this.spreadMenuModel;
        if (feedSpreadMenuModel == null || feedSpreadMenuModel.getFeedId() == null) {
            return;
        }
        Disposable disposed = NetworkClient.f11868a.l().d(this.spreadMenuModel.getFeedId(), str).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<Object, p>() { // from class: com.cupidapp.live.base.share.fragment.FeedSpreadMenuViewModel$disinterest$$inlined$handle$default$1
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
                mutableLiveData = FeedSpreadMenuViewModel.this._handledResult;
                mutableLiveData.setValue(new ShareItemHandledResult(State.SUCCESS, SpreadMenuType.NO_INTEREST, null, 4, null));
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, null)));
        if (disposed != null) {
            kotlin.jvm.internal.s.h(disposed, "disposed");
        }
        kotlin.jvm.internal.s.h(disposed, "disposed");
    }

    public static /* synthetic */ void disinterest$default(FeedSpreadMenuViewModel feedSpreadMenuViewModel, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = null;
        }
        feedSpreadMenuViewModel.disinterest(str);
    }

    private final Map<SpreadMenuType, FKShareItemModel> getAllMenuList() {
        SpreadMenuType spreadMenuType = SpreadMenuType.FEED_SPREAD;
        SpreadMenuType spreadMenuType2 = SpreadMenuType.IGNORE_HIM;
        SpreadMenuType spreadMenuType3 = SpreadMenuType.NO_INTEREST;
        SpreadMenuType spreadMenuType4 = SpreadMenuType.HATE_BMI;
        SpreadMenuType spreadMenuType5 = SpreadMenuType.REPORT;
        SpreadMenuType spreadMenuType6 = SpreadMenuType.NO_FIND_HIM;
        return i0.h(new Pair(spreadMenuType, new FKShareItemModel(spreadMenuType, R$string.want_to_feed_spread, R$mipmap.icon_spread_feed, false, null, 24, null)), new Pair(spreadMenuType2, new FKShareItemModel(spreadMenuType2, R$string.ignore_him, R$mipmap.ic_spread_ignore, false, null, 24, null)), new Pair(spreadMenuType3, new FKShareItemModel(spreadMenuType3, R$string.no_interest, R$mipmap.ic_spread_face, false, null, 24, null)), new Pair(spreadMenuType4, new FKShareItemModel(spreadMenuType4, R$string.hate_bmi, R$mipmap.ic_spread_body, false, null, 24, null)), new Pair(spreadMenuType5, new FKShareItemModel(spreadMenuType5, R$string.report, R$mipmap.icon_report, false, null, 24, null)), new Pair(spreadMenuType6, new FKShareItemModel(spreadMenuType6, R$string.no_see_love, R$mipmap.ic_spread_no_love, false, null, 24, null)));
    }

    private final void hateShape() {
        FeedSpreadMenuModel feedSpreadMenuModel = this.spreadMenuModel;
        if (feedSpreadMenuModel == null || feedSpreadMenuModel.getFeedId() == null) {
            return;
        }
        Disposable disposed = NetworkClient.f11868a.l().Q(this.spreadMenuModel.getFeedId()).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<Object, p>() { // from class: com.cupidapp.live.base.share.fragment.FeedSpreadMenuViewModel$hateShape$$inlined$handle$default$1
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
                mutableLiveData = FeedSpreadMenuViewModel.this._handledResult;
                mutableLiveData.setValue(new ShareItemHandledResult(State.SUCCESS, SpreadMenuType.HATE_BMI, null, 4, null));
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, null)));
        if (disposed != null) {
            kotlin.jvm.internal.s.h(disposed, "disposed");
        }
        kotlin.jvm.internal.s.h(disposed, "disposed");
    }

    private final void ignoreHim() {
        FeedSpreadMenuModel feedSpreadMenuModel = this.spreadMenuModel;
        if (feedSpreadMenuModel == null || feedSpreadMenuModel.getFeedId() == null) {
            return;
        }
        Disposable disposed = NetworkClient.f11868a.l().b0(this.spreadMenuModel.getFeedId()).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<Object, p>() { // from class: com.cupidapp.live.base.share.fragment.FeedSpreadMenuViewModel$ignoreHim$$inlined$handle$default$1
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
                mutableLiveData = FeedSpreadMenuViewModel.this._handledResult;
                mutableLiveData.setValue(new ShareItemHandledResult(State.SUCCESS, SpreadMenuType.IGNORE_HIM, null, 4, null));
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, null)));
        if (disposed != null) {
            kotlin.jvm.internal.s.h(disposed, "disposed");
        }
        kotlin.jvm.internal.s.h(disposed, "disposed");
    }

    private final void report() {
        this._handledResult.setValue(new ShareItemHandledResult(State.OTHER, SpreadMenuType.REPORT, null, 4, null));
    }

    @NotNull
    public final LiveData<ShareItemHandledResult> getHandledResult() {
        return this.handledResult;
    }

    public final int getMIN_WEIGHT_NUM() {
        return this.MIN_WEIGHT_NUM;
    }

    @NotNull
    public final LiveData<Pair<Collection<BaseShareItemModel>, Collection<BaseShareItemModel>>> getModels() {
        return this.models;
    }

    @Nullable
    public final FeedSpreadMenuModel getSpreadMenuModel() {
        return this.spreadMenuModel;
    }

    public final void itemClick(@NotNull ShareBaseType type) {
        ConstantsUrlModel urlModel;
        kotlin.jvm.internal.s.i(type, "type");
        SpreadMenuType spreadMenuType = SpreadMenuType.FEED_SPREAD;
        String str = null;
        if (type == spreadMenuType) {
            MutableLiveData<ShareItemHandledResult> mutableLiveData = this._handledResult;
            State state = State.SUCCESS;
            ConstantsResult q10 = p1.g.f52734a.q();
            if (q10 != null && (urlModel = q10.getUrlModel()) != null) {
                str = urlModel.getDynamicPromotionUrl();
            }
            mutableLiveData.setValue(new ShareItemHandledResult(state, spreadMenuType, str));
            return;
        }
        if (type == SpreadMenuType.IGNORE_HIM) {
            ignoreHim();
            return;
        }
        if (type == SpreadMenuType.NO_INTEREST) {
            disinterest$default(this, null, 1, null);
            return;
        }
        if (type == SpreadMenuType.HATE_BMI) {
            hateShape();
        } else if (type == SpreadMenuType.REPORT) {
            report();
        } else if (type == SpreadMenuType.NO_FIND_HIM) {
            disinterest("findMe");
        }
    }
}

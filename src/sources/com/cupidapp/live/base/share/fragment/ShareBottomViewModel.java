package com.cupidapp.live.base.share.fragment;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.livedata.Event;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.RequestErrorCode;
import com.cupidapp.live.base.network.ResultException;
import com.cupidapp.live.base.network.j;
import com.cupidapp.live.base.network.model.ConstantsResult;
import com.cupidapp.live.base.network.model.ConstantsUrlModel;
import com.cupidapp.live.base.network.model.FollowPrefer;
import com.cupidapp.live.base.network.model.SwipeCardUserLikeResult;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.share.logic.ShareRepository;
import com.cupidapp.live.base.share.model.BaseShareItemModel;
import com.cupidapp.live.base.share.model.FKShareItemModel;
import com.cupidapp.live.base.share.model.ShareBaseType;
import com.cupidapp.live.base.share.model.ShareItemHandledResult;
import com.cupidapp.live.base.share.model.ShareOperateType;
import com.cupidapp.live.base.share.model.SharePlatform;
import com.cupidapp.live.base.share.model.State;
import com.cupidapp.live.base.web.model.ClubActivityInfoModel;
import com.cupidapp.live.feed.logic.FeedRepository;
import com.cupidapp.live.feed.model.FeedTopResultModel;
import com.cupidapp.live.profile.event.UserCloseFriendChangeEvent;
import com.cupidapp.live.profile.logic.UserRepository;
import com.cupidapp.live.profile.model.FocusResultModel;
import com.cupidapp.live.vip.wrapper.VipPurchaseEntranceType;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import z0.t;

/* compiled from: ShareBottomViewModel.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ShareBottomViewModel extends ViewModel {
    public static final int BLACK = 2;

    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int DELETE = 3;
    public static final int DELETE_OR_PRIVATE = 5;
    public static final int DISLIKE = 1;
    public static final int DONT_LOOK = 4;
    public static final int LOADING = -1;
    public static final int SELECT = 0;

    @NotNull
    private final MutableLiveData<Integer> _dialogType;

    @NotNull
    private final MutableLiveData<ShareItemHandledResult> _handledResult;

    @NotNull
    private final MutableLiveData<Pair<Collection<BaseShareItemModel>, Collection<BaseShareItemModel>>> _models;

    @NotNull
    private final MutableLiveData<Event<VipPurchaseEntranceType>> _purchaseEventLiveData;

    @NotNull
    private final LiveData<Integer> dialogType;

    @NotNull
    private final FeedRepository feedRepository;

    @NotNull
    private final LiveData<ShareItemHandledResult> handledResult;

    @NotNull
    private final LiveData<Pair<Collection<BaseShareItemModel>, Collection<BaseShareItemModel>>> models;

    @NotNull
    private final LiveData<Event<VipPurchaseEntranceType>> purchaseEventLiveData;

    @NotNull
    private final ShareModel shareModel;

    @NotNull
    private final ShareRepository shareRepository;

    @NotNull
    private final UserRepository userRepository;

    /* compiled from: ShareBottomViewModel.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ShareBottomViewModel(@NotNull FeedRepository feedRepository, @NotNull UserRepository userRepository, @NotNull ShareRepository shareRepository, @NotNull ShareModel shareModel) {
        LinkedHashMap linkedHashMap;
        List list;
        List k02;
        List k03;
        s.i(feedRepository, "feedRepository");
        s.i(userRepository, "userRepository");
        s.i(shareRepository, "shareRepository");
        s.i(shareModel, "shareModel");
        this.feedRepository = feedRepository;
        this.userRepository = userRepository;
        this.shareRepository = shareRepository;
        this.shareModel = shareModel;
        MutableLiveData<Pair<Collection<BaseShareItemModel>, Collection<BaseShareItemModel>>> mutableLiveData = new MutableLiveData<>();
        this._models = mutableLiveData;
        this.models = mutableLiveData;
        MutableLiveData<ShareItemHandledResult> mutableLiveData2 = new MutableLiveData<>();
        this._handledResult = mutableLiveData2;
        this.handledResult = Transformations.distinctUntilChanged(mutableLiveData2);
        MutableLiveData<Integer> mutableLiveData3 = new MutableLiveData<>();
        this._dialogType = mutableLiveData3;
        this.dialogType = Transformations.distinctUntilChanged(mutableLiveData3);
        MutableLiveData<Event<VipPurchaseEntranceType>> mutableLiveData4 = new MutableLiveData<>();
        this._purchaseEventLiveData = mutableLiveData4;
        this.purchaseEventLiveData = mutableLiveData4;
        if (shareModel.getShareBuilder() == null || !canShareToOthers()) {
            linkedHashMap = null;
        } else {
            Collection<FKShareItemModel> c4 = shareRepository.c(shareModel.getNotShowPlatformTypes());
            linkedHashMap = new LinkedHashMap();
            for (FKShareItemModel fKShareItemModel : c4) {
                Boolean valueOf = Boolean.valueOf(fKShareItemModel.getType() != SharePlatform.Copylink);
                Object obj = linkedHashMap.get(valueOf);
                if (obj == null) {
                    obj = new ArrayList();
                    linkedHashMap.put(valueOf, obj);
                }
                ((List) obj).add(fKShareItemModel);
            }
        }
        List list2 = linkedHashMap != null ? (List) linkedHashMap.get(Boolean.TRUE) : null;
        Collection<FKShareItemModel> b4 = this.shareRepository.b(this.shareModel.getOperateTypes());
        Collection<BaseShareItemModel> a10 = this.shareRepository.a(this.shareModel.getCustomShareTypes());
        if (linkedHashMap != null && (list = (List) linkedHashMap.get(Boolean.FALSE)) != null && (k02 = CollectionsKt___CollectionsKt.k0(list, a10)) != null && (k03 = CollectionsKt___CollectionsKt.k0(k02, b4)) != null) {
            b4 = k03;
        }
        this._models.setValue(new Pair<>(list2, b4));
    }

    private final boolean canPrivateFeed() {
        List<ShareOperateType> operateTypes = this.shareModel.getOperateTypes();
        return operateTypes != null && operateTypes.contains(ShareOperateType.PRIVATE);
    }

    private final boolean canShareToOthers() {
        List<ShareOperateType> operateTypes = this.shareModel.getOperateTypes();
        boolean z10 = false;
        if (operateTypes != null && operateTypes.contains(ShareOperateType.UN_PRIVATE)) {
            z10 = true;
        }
        return !z10;
    }

    private final void cancelBlackUser() {
        if (this.shareModel.getUserId() == null) {
            return;
        }
        Disposable disposed = this.userRepository.j(this.shareModel.getUserId()).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<Object, p>() { // from class: com.cupidapp.live.base.share.fragment.ShareBottomViewModel$cancelBlackUser$$inlined$handle$1
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
                com.cupidapp.live.base.view.h.f12779a.b(R$string.remove_blacklist_success);
                mutableLiveData = ShareBottomViewModel.this._handledResult;
                mutableLiveData.setValue(new ShareItemHandledResult(State.SUCCESS, ShareOperateType.CANCEL_BLACK, null, 4, null));
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.base.share.fragment.ShareBottomViewModel$cancelBlackUser$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                MutableLiveData mutableLiveData;
                s.i(it, "it");
                mutableLiveData = ShareBottomViewModel.this._handledResult;
                mutableLiveData.setValue(new ShareItemHandledResult(State.FAILURE, ShareOperateType.CANCEL_BLACK, null, 4, null));
                return Boolean.FALSE;
            }
        }, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    private final void cancelDontLook() {
        String userId = this.shareModel.getUserId();
        if (userId == null) {
            return;
        }
        Disposable disposed = this.userRepository.i(userId).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<Object, p>() { // from class: com.cupidapp.live.base.share.fragment.ShareBottomViewModel$cancelDontLook$$inlined$handle$1
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
                mutableLiveData = ShareBottomViewModel.this._handledResult;
                mutableLiveData.setValue(new ShareItemHandledResult(State.SUCCESS, ShareOperateType.LOOK_HIM, null, 4, null));
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.base.share.fragment.ShareBottomViewModel$cancelDontLook$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                MutableLiveData mutableLiveData;
                s.i(it, "it");
                mutableLiveData = ShareBottomViewModel.this._handledResult;
                mutableLiveData.setValue(new ShareItemHandledResult(State.FAILURE, ShareOperateType.LOOK_HIM, null, 4, null));
                return Boolean.FALSE;
            }
        }, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    private final void cancelFeedTop() {
        if (this.shareModel.getFeedId() == null) {
            return;
        }
        Disposable disposed = this.feedRepository.b(this.shareModel.getFeedId(), false).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<FeedTopResultModel, p>() { // from class: com.cupidapp.live.base.share.fragment.ShareBottomViewModel$cancelFeedTop$$inlined$handleByContext$default$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(FeedTopResultModel feedTopResultModel) {
                m2472invoke(feedTopResultModel);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2472invoke(FeedTopResultModel feedTopResultModel) {
                MutableLiveData mutableLiveData;
                mutableLiveData = ShareBottomViewModel.this._handledResult;
                mutableLiveData.setValue(new ShareItemHandledResult(State.SUCCESS, ShareOperateType.FEED_CANCEL_TOP, feedTopResultModel.getToastMsg()));
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    private final void closeFriend() {
        if (this.shareModel.getUserId() == null) {
            return;
        }
        Disposable disposed = this.userRepository.b(this.shareModel.getUserId(), true).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<Object, p>() { // from class: com.cupidapp.live.base.share.fragment.ShareBottomViewModel$closeFriend$$inlined$handle$1
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
                ShareModel shareModel;
                mutableLiveData = ShareBottomViewModel.this._handledResult;
                mutableLiveData.setValue(new ShareItemHandledResult(State.SUCCESS, ShareOperateType.CLOSE_FRIEND, obj));
                EventBus c4 = EventBus.c();
                shareModel = ShareBottomViewModel.this.shareModel;
                c4.o(new UserCloseFriendChangeEvent(shareModel.getUserId(), true));
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.base.share.fragment.ShareBottomViewModel$closeFriend$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                MutableLiveData mutableLiveData;
                boolean z10;
                MutableLiveData mutableLiveData2;
                s.i(it, "it");
                String a10 = j.f12008a.a(it);
                Integer valueOf = a10 != null ? Integer.valueOf(t.q(a10)) : null;
                int value = RequestErrorCode.CloseFriendNoRemains.getValue();
                if (valueOf != null && valueOf.intValue() == value) {
                    mutableLiveData2 = ShareBottomViewModel.this._handledResult;
                    mutableLiveData2.setValue(new ShareItemHandledResult(State.FAILURE, ShareOperateType.CLOSE_FRIEND, it.getMessage()));
                    z10 = true;
                } else {
                    mutableLiveData = ShareBottomViewModel.this._handledResult;
                    mutableLiveData.setValue(new ShareItemHandledResult(State.FAILURE, ShareOperateType.CLOSE_FRIEND, null, 4, null));
                    z10 = false;
                }
                return Boolean.valueOf(z10);
            }
        }, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    private final void disInterest() {
        if (this.shareModel.getFeedId() == null) {
            return;
        }
        Disposable disposed = this.feedRepository.d(this.shareModel.getFeedId()).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<Object, p>() { // from class: com.cupidapp.live.base.share.fragment.ShareBottomViewModel$disInterest$$inlined$handle$1
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
                mutableLiveData = ShareBottomViewModel.this._handledResult;
                mutableLiveData.setValue(new ShareItemHandledResult(State.SUCCESS, ShareOperateType.DISINTEREST, null, 4, null));
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.base.share.fragment.ShareBottomViewModel$disInterest$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                MutableLiveData mutableLiveData;
                s.i(it, "it");
                mutableLiveData = ShareBottomViewModel.this._handledResult;
                mutableLiveData.setValue(new ShareItemHandledResult(State.FAILURE, ShareOperateType.DISINTEREST, null, 4, null));
                return Boolean.FALSE;
            }
        }, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    private final void downloadImage() {
        this._handledResult.setValue(new ShareItemHandledResult(State.SUCCESS, ShareOperateType.DOWNLOAD_IMAGE, null, 4, null));
    }

    private final void feedSpread() {
        ConstantsUrlModel urlModel;
        MutableLiveData<ShareItemHandledResult> mutableLiveData = this._handledResult;
        State state = State.SUCCESS;
        ShareOperateType shareOperateType = ShareOperateType.FEED_SPREAD;
        p1.g gVar = p1.g.f52734a;
        ConstantsResult q10 = gVar.q();
        mutableLiveData.setValue(new ShareItemHandledResult(state, shareOperateType, (q10 == null || (urlModel = q10.getUrlModel()) == null) ? null : urlModel.getDynamicPromotionUrl()));
        gVar.y3(Boolean.FALSE);
    }

    private final void feedTop() {
        if (this.shareModel.getFeedId() == null) {
            return;
        }
        if (com.cupidapp.live.profile.logic.c.f17839a.f()) {
            Disposable disposed = this.feedRepository.b(this.shareModel.getFeedId(), true).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<FeedTopResultModel, p>() { // from class: com.cupidapp.live.base.share.fragment.ShareBottomViewModel$feedTop$$inlined$handleByContext$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(FeedTopResultModel feedTopResultModel) {
                    m2474invoke(feedTopResultModel);
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m2474invoke(FeedTopResultModel feedTopResultModel) {
                    MutableLiveData mutableLiveData;
                    mutableLiveData = ShareBottomViewModel.this._handledResult;
                    mutableLiveData.setValue(new ShareItemHandledResult(State.SUCCESS, ShareOperateType.FEED_TOP, feedTopResultModel.getToastMsg()));
                }
            }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.base.share.fragment.ShareBottomViewModel$feedTop$2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Boolean invoke(@NotNull Throwable it) {
                    MutableLiveData mutableLiveData;
                    MutableLiveData mutableLiveData2;
                    s.i(it, "it");
                    if (it instanceof ResultException) {
                        ResultException resultException = (ResultException) it;
                        Integer errorCode = resultException.getErrorCode();
                        int value = RequestErrorCode.FeedTopFail.getValue();
                        if (errorCode != null && errorCode.intValue() == value) {
                            mutableLiveData2 = ShareBottomViewModel.this._handledResult;
                            mutableLiveData2.setValue(new ShareItemHandledResult(State.FAILURE, ShareOperateType.FEED_TOP, resultException.getErrorMessage()));
                            return Boolean.TRUE;
                        }
                    }
                    mutableLiveData = ShareBottomViewModel.this._handledResult;
                    mutableLiveData.setValue(new ShareItemHandledResult(State.FAILURE, ShareOperateType.FEED_TOP, null, 4, null));
                    return Boolean.FALSE;
                }
            }, null)));
            if (disposed != null) {
                s.h(disposed, "disposed");
            }
            s.h(disposed, "disposed");
            return;
        }
        this._purchaseEventLiveData.setValue(new Event<>(VipPurchaseEntranceType.FeedTop));
    }

    private final void focus() {
        if (this.shareModel.getUserId() == null) {
            return;
        }
        Disposable disposed = this.userRepository.e(this.shareModel.getUserId(), true, this.shareModel.getPostStatisticsSource()).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<FocusResultModel, p>() { // from class: com.cupidapp.live.base.share.fragment.ShareBottomViewModel$focus$$inlined$handle$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(FocusResultModel focusResultModel) {
                m2475invoke(focusResultModel);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2475invoke(FocusResultModel focusResultModel) {
                MutableLiveData mutableLiveData;
                mutableLiveData = ShareBottomViewModel.this._handledResult;
                mutableLiveData.setValue(new ShareItemHandledResult(State.SUCCESS, ShareOperateType.FOCUS, focusResultModel));
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.base.share.fragment.ShareBottomViewModel$focus$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                MutableLiveData mutableLiveData;
                boolean z10;
                MutableLiveData mutableLiveData2;
                s.i(it, "it");
                String a10 = j.f12008a.a(it);
                Integer valueOf = a10 != null ? Integer.valueOf(t.q(a10)) : null;
                int value = RequestErrorCode.FocusNoRemains.getValue();
                if (valueOf != null && valueOf.intValue() == value) {
                    mutableLiveData2 = ShareBottomViewModel.this._handledResult;
                    mutableLiveData2.setValue(new ShareItemHandledResult(State.FAILURE, ShareOperateType.FOCUS, it.getMessage()));
                    z10 = true;
                } else {
                    mutableLiveData = ShareBottomViewModel.this._handledResult;
                    mutableLiveData.setValue(new ShareItemHandledResult(State.FAILURE, ShareOperateType.FOCUS, null, 4, null));
                    z10 = false;
                }
                return Boolean.valueOf(z10);
            }
        }, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    private final void reduceRecommend() {
        if (this.shareModel.getFeedId() == null) {
            return;
        }
        Disposable disposed = this.feedRepository.f(this.shareModel.getFeedId()).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<Object, p>() { // from class: com.cupidapp.live.base.share.fragment.ShareBottomViewModel$reduceRecommend$$inlined$handle$default$1
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
                com.cupidapp.live.base.view.h.f12779a.k(R$string.reduce_recommend_to_you);
                mutableLiveData = ShareBottomViewModel.this._handledResult;
                mutableLiveData.setValue(new ShareItemHandledResult(State.SUCCESS, ShareOperateType.REDUCE_RECOMMEND, null, 4, null));
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    private final void report() {
        this._handledResult.setValue(new ShareItemHandledResult(State.OTHER, ShareOperateType.REPORT, null, 4, null));
    }

    private final void shareToClub() {
        Map<ShareOperateType, Object> customShareTypes = this.shareModel.getCustomShareTypes();
        Object obj = customShareTypes != null ? customShareTypes.get(ShareOperateType.CLUB) : null;
        ClubActivityInfoModel clubActivityInfoModel = obj instanceof ClubActivityInfoModel ? (ClubActivityInfoModel) obj : null;
        if (clubActivityInfoModel == null) {
            return;
        }
        String groupId = clubActivityInfoModel.getGroupId();
        if (groupId == null || groupId.length() == 0) {
            return;
        }
        String activityId = clubActivityInfoModel.getActivityId();
        if (activityId == null || activityId.length() == 0) {
            return;
        }
        Disposable disposed = NetworkClient.f11868a.u().f(clubActivityInfoModel.getGroupId(), clubActivityInfoModel.getActivityId()).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<Object, p>() { // from class: com.cupidapp.live.base.share.fragment.ShareBottomViewModel$shareToClub$$inlined$handle$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Object obj2) {
                invoke2(obj2);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object obj2) {
                MutableLiveData mutableLiveData;
                com.cupidapp.live.base.view.h.f12779a.b(R$string.shared_success);
                mutableLiveData = ShareBottomViewModel.this._handledResult;
                mutableLiveData.setValue(new ShareItemHandledResult(State.SUCCESS, ShareOperateType.CLUB, null, 4, null));
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.base.share.fragment.ShareBottomViewModel$shareToClub$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                MutableLiveData mutableLiveData;
                s.i(it, "it");
                mutableLiveData = ShareBottomViewModel.this._handledResult;
                mutableLiveData.setValue(new ShareItemHandledResult(State.FAILURE, ShareOperateType.CLUB, null, 4, null));
                return Boolean.FALSE;
            }
        }, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    private final void showBlackUserConfirm() {
        this._dialogType.setValue(2);
    }

    private final void showDeleteConfirm() {
        if (canPrivateFeed()) {
            this._dialogType.setValue(5);
        } else {
            this._dialogType.setValue(3);
        }
    }

    private final void showDisLikeUserConfirm() {
        this._dialogType.setValue(1);
    }

    private final void showDontLookHimConfirm() {
        this._dialogType.setValue(4);
    }

    private final void unCloseFriend() {
        if (this.shareModel.getUserId() == null) {
            return;
        }
        Disposable disposed = this.userRepository.b(this.shareModel.getUserId(), false).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<Object, p>() { // from class: com.cupidapp.live.base.share.fragment.ShareBottomViewModel$unCloseFriend$$inlined$handle$1
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
                ShareModel shareModel;
                mutableLiveData = ShareBottomViewModel.this._handledResult;
                mutableLiveData.setValue(new ShareItemHandledResult(State.SUCCESS, ShareOperateType.UN_CLOSE_FRIEND, obj));
                EventBus c4 = EventBus.c();
                shareModel = ShareBottomViewModel.this.shareModel;
                c4.o(new UserCloseFriendChangeEvent(shareModel.getUserId(), false));
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.base.share.fragment.ShareBottomViewModel$unCloseFriend$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                MutableLiveData mutableLiveData;
                s.i(it, "it");
                mutableLiveData = ShareBottomViewModel.this._handledResult;
                mutableLiveData.setValue(new ShareItemHandledResult(State.FAILURE, ShareOperateType.UN_CLOSE_FRIEND, null, 4, null));
                return Boolean.FALSE;
            }
        }, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    private final void unPrivateFeed() {
        if (this.shareModel.getFeedId() == null) {
            return;
        }
        Disposable disposed = this.feedRepository.e(this.shareModel.getFeedId(), false).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<Object, p>() { // from class: com.cupidapp.live.base.share.fragment.ShareBottomViewModel$unPrivateFeed$$inlined$handle$1
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
                mutableLiveData = ShareBottomViewModel.this._handledResult;
                mutableLiveData.setValue(new ShareItemHandledResult(State.SUCCESS, ShareOperateType.UN_PRIVATE, null, 4, null));
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.base.share.fragment.ShareBottomViewModel$unPrivateFeed$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                MutableLiveData mutableLiveData;
                s.i(it, "it");
                mutableLiveData = ShareBottomViewModel.this._handledResult;
                mutableLiveData.setValue(new ShareItemHandledResult(State.FAILURE, ShareOperateType.UN_PRIVATE, null, 4, null));
                return Boolean.FALSE;
            }
        }, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    private final void unfocus() {
        if (this.shareModel.getUserId() == null) {
            return;
        }
        Disposable disposed = UserRepository.f(this.userRepository, this.shareModel.getUserId(), false, null, 4, null).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<FocusResultModel, p>() { // from class: com.cupidapp.live.base.share.fragment.ShareBottomViewModel$unfocus$$inlined$handle$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(FocusResultModel focusResultModel) {
                m2476invoke(focusResultModel);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2476invoke(FocusResultModel focusResultModel) {
                MutableLiveData mutableLiveData;
                mutableLiveData = ShareBottomViewModel.this._handledResult;
                mutableLiveData.setValue(new ShareItemHandledResult(State.SUCCESS, ShareOperateType.UN_FOCUS, focusResultModel));
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.base.share.fragment.ShareBottomViewModel$unfocus$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                MutableLiveData mutableLiveData;
                s.i(it, "it");
                mutableLiveData = ShareBottomViewModel.this._handledResult;
                mutableLiveData.setValue(new ShareItemHandledResult(State.FAILURE, ShareOperateType.UN_FOCUS, null, 4, null));
                return Boolean.FALSE;
            }
        }, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    public final void blackUser() {
        if (this.shareModel.getUserId() == null) {
            return;
        }
        Disposable disposed = this.userRepository.a(this.shareModel.getUserId()).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<Object, p>() { // from class: com.cupidapp.live.base.share.fragment.ShareBottomViewModel$blackUser$$inlined$handle$1
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
                ShareModel shareModel;
                com.cupidapp.live.base.view.h.f12779a.b(R$string.add_to_blacklist_success);
                mutableLiveData = ShareBottomViewModel.this._handledResult;
                mutableLiveData.setValue(new ShareItemHandledResult(State.SUCCESS, ShareOperateType.BLACK, null, 4, null));
                EventBus c4 = EventBus.c();
                shareModel = ShareBottomViewModel.this.shareModel;
                c4.o(new UserCloseFriendChangeEvent(shareModel.getUserId(), false));
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.base.share.fragment.ShareBottomViewModel$blackUser$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                MutableLiveData mutableLiveData;
                s.i(it, "it");
                mutableLiveData = ShareBottomViewModel.this._handledResult;
                mutableLiveData.setValue(new ShareItemHandledResult(State.FAILURE, ShareOperateType.BLACK, null, 4, null));
                return Boolean.FALSE;
            }
        }, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    public final void disLikeUser() {
        if (this.shareModel.getUserId() == null) {
            return;
        }
        UserRepository userRepository = this.userRepository;
        String userId = this.shareModel.getUserId();
        FollowPrefer followPrefer = this.shareModel.getFollowPrefer();
        Disposable disposed = userRepository.c(userId, null, followPrefer != null ? followPrefer.getValue() : null).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<SwipeCardUserLikeResult, p>() { // from class: com.cupidapp.live.base.share.fragment.ShareBottomViewModel$disLikeUser$$inlined$handle$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(SwipeCardUserLikeResult swipeCardUserLikeResult) {
                m2473invoke(swipeCardUserLikeResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2473invoke(SwipeCardUserLikeResult swipeCardUserLikeResult) {
                MutableLiveData mutableLiveData;
                ShareModel shareModel;
                mutableLiveData = ShareBottomViewModel.this._handledResult;
                mutableLiveData.setValue(new ShareItemHandledResult(State.SUCCESS, ShareOperateType.DISLIKE_U, null, 4, null));
                EventBus c4 = EventBus.c();
                shareModel = ShareBottomViewModel.this.shareModel;
                c4.o(new UserCloseFriendChangeEvent(shareModel.getUserId(), false));
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.base.share.fragment.ShareBottomViewModel$disLikeUser$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                MutableLiveData mutableLiveData;
                s.i(it, "it");
                mutableLiveData = ShareBottomViewModel.this._handledResult;
                mutableLiveData.setValue(new ShareItemHandledResult(State.FAILURE, ShareOperateType.DISLIKE_U, null, 4, null));
                return Boolean.FALSE;
            }
        }, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    public final void dontLook() {
        String userId = this.shareModel.getUserId();
        if (userId == null) {
            return;
        }
        Disposable disposed = this.userRepository.d(userId).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<Object, p>() { // from class: com.cupidapp.live.base.share.fragment.ShareBottomViewModel$dontLook$$inlined$handle$1
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
                mutableLiveData = ShareBottomViewModel.this._handledResult;
                mutableLiveData.setValue(new ShareItemHandledResult(State.SUCCESS, ShareOperateType.DONT_LOOK_HIM, null, 4, null));
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.base.share.fragment.ShareBottomViewModel$dontLook$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                MutableLiveData mutableLiveData;
                s.i(it, "it");
                mutableLiveData = ShareBottomViewModel.this._handledResult;
                mutableLiveData.setValue(new ShareItemHandledResult(State.FAILURE, ShareOperateType.DONT_LOOK_HIM, null, 4, null));
                return Boolean.FALSE;
            }
        }, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    public final void feedDelete() {
        if (this.shareModel.getFeedId() == null) {
            return;
        }
        this._dialogType.setValue(-1);
        Disposable disposed = this.feedRepository.a(this.shareModel.getFeedId()).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<Object, p>() { // from class: com.cupidapp.live.base.share.fragment.ShareBottomViewModel$feedDelete$$inlined$handle$1
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
                com.cupidapp.live.base.view.h.f12779a.b(R$string.deleted_successfully);
                mutableLiveData = ShareBottomViewModel.this._handledResult;
                mutableLiveData.setValue(new ShareItemHandledResult(State.SUCCESS, ShareOperateType.DELETE, null, 4, null));
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.base.share.fragment.ShareBottomViewModel$feedDelete$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                MutableLiveData mutableLiveData;
                s.i(it, "it");
                mutableLiveData = ShareBottomViewModel.this._handledResult;
                mutableLiveData.setValue(new ShareItemHandledResult(State.FAILURE, ShareOperateType.DELETE, null, 4, null));
                return Boolean.FALSE;
            }
        }, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    @NotNull
    public final LiveData<Integer> getDialogType() {
        return this.dialogType;
    }

    @NotNull
    public final LiveData<ShareItemHandledResult> getHandledResult() {
        return this.handledResult;
    }

    @NotNull
    public final LiveData<Pair<Collection<BaseShareItemModel>, Collection<BaseShareItemModel>>> getModels() {
        return this.models;
    }

    @NotNull
    public final LiveData<Event<VipPurchaseEntranceType>> getPurchaseEventLiveData() {
        return this.purchaseEventLiveData;
    }

    public final void itemClick(@NotNull ShareBaseType type) {
        s.i(type, "type");
        if (type instanceof SharePlatform) {
            if (this.shareModel.getShareBuilder() != null) {
                this.shareRepository.e((SharePlatform) type, this.shareModel.getShareBuilder(), this.shareModel.getSensorPosition());
                this._handledResult.setValue(new ShareItemHandledResult(State.OTHER, type, null, 4, null));
                return;
            }
            return;
        }
        if (type == ShareOperateType.DELETE) {
            showDeleteConfirm();
            return;
        }
        if (type == ShareOperateType.DISLIKE_U) {
            showDisLikeUserConfirm();
            return;
        }
        if (type == ShareOperateType.REPORT) {
            report();
            return;
        }
        if (type == ShareOperateType.DISINTEREST) {
            disInterest();
            return;
        }
        if (type == ShareOperateType.BLACK) {
            showBlackUserConfirm();
            return;
        }
        if (type == ShareOperateType.CANCEL_BLACK) {
            cancelBlackUser();
            return;
        }
        if (type == ShareOperateType.DONT_LOOK_HIM) {
            if (showDontLookConfirm()) {
                showDontLookHimConfirm();
                return;
            } else {
                dontLook();
                return;
            }
        }
        if (type == ShareOperateType.LOOK_HIM) {
            cancelDontLook();
            return;
        }
        if (type == ShareOperateType.PRIVATE) {
            privateFeed();
            return;
        }
        if (type == ShareOperateType.UN_PRIVATE) {
            unPrivateFeed();
            return;
        }
        if (type == ShareOperateType.FOCUS) {
            focus();
            return;
        }
        if (type == ShareOperateType.UN_FOCUS) {
            unfocus();
            return;
        }
        if (type == ShareOperateType.CLOSE_FRIEND) {
            closeFriend();
            return;
        }
        if (type == ShareOperateType.UN_CLOSE_FRIEND) {
            unCloseFriend();
            return;
        }
        if (type == ShareOperateType.DOWNLOAD_IMAGE) {
            downloadImage();
            return;
        }
        if (type == ShareOperateType.REDUCE_RECOMMEND) {
            reduceRecommend();
            return;
        }
        if (type == ShareOperateType.FEED_SPREAD) {
            feedSpread();
            return;
        }
        if (type == ShareOperateType.CLUB) {
            shareToClub();
        } else if (type == ShareOperateType.FEED_TOP) {
            feedTop();
        } else if (type == ShareOperateType.FEED_CANCEL_TOP) {
            cancelFeedTop();
        }
    }

    public final void privateFeed() {
        if (this.shareModel.getFeedId() == null) {
            return;
        }
        Disposable disposed = this.feedRepository.e(this.shareModel.getFeedId(), true).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<Object, p>() { // from class: com.cupidapp.live.base.share.fragment.ShareBottomViewModel$privateFeed$$inlined$handle$1
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
                mutableLiveData = ShareBottomViewModel.this._handledResult;
                mutableLiveData.setValue(new ShareItemHandledResult(State.SUCCESS, ShareOperateType.PRIVATE, null, 4, null));
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.base.share.fragment.ShareBottomViewModel$privateFeed$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                MutableLiveData mutableLiveData;
                s.i(it, "it");
                mutableLiveData = ShareBottomViewModel.this._handledResult;
                mutableLiveData.setValue(new ShareItemHandledResult(State.FAILURE, ShareOperateType.PRIVATE, null, 4, null));
                return Boolean.FALSE;
            }
        }, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    public final void setHandleResult(@NotNull ShareItemHandledResult result) {
        s.i(result, "result");
        this._handledResult.setValue(result);
    }

    public final boolean showDontLookConfirm() {
        return this.shareModel.getSensorPosition() != SensorPosition.Profile;
    }

    public final void showItemNewDot(@NotNull ShareBaseType type) {
        s.i(type, "type");
        if (type == ShareOperateType.FOCUS) {
            p1.g.f52734a.x3(Boolean.FALSE);
        }
    }
}

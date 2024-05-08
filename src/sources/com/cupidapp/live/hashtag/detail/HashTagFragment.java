package com.cupidapp.live.hashtag.detail;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.fragment.FKBaseFragment;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.RequestErrorCode;
import com.cupidapp.live.base.network.i;
import com.cupidapp.live.base.network.j;
import com.cupidapp.live.base.network.model.ListResult;
import com.cupidapp.live.base.network.model.Result;
import com.cupidapp.live.base.recyclerview.FKLoadMoreListener;
import com.cupidapp.live.base.recyclerview.helper.ExposureScene;
import com.cupidapp.live.base.recyclerview.helper.RecyclerExposureHelper;
import com.cupidapp.live.base.recyclerview.model.FKEmptyViewModel;
import com.cupidapp.live.base.recyclerview.model.FKFooterViewModel;
import com.cupidapp.live.base.sensorslog.FKSensorContext;
import com.cupidapp.live.base.sensorslog.FeedSensorContext;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorScene;
import com.cupidapp.live.base.sensorslog.SensorsLogFeed;
import com.cupidapp.live.base.utils.o;
import com.cupidapp.live.base.view.decoration.StaggeredGridDecoration;
import com.cupidapp.live.base.view.dialog.FKAlertDialog;
import com.cupidapp.live.feed.activity.FeedDetailActivity;
import com.cupidapp.live.feed.helper.UserActionType;
import com.cupidapp.live.feed.helper.h;
import com.cupidapp.live.feed.model.FeedLikeResult;
import com.cupidapp.live.feed.model.FeedModel;
import f2.a;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import j1.k;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.collections.i0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: HashTagFragment.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class HashTagFragment extends FKBaseFragment {

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    public static final a f14669q = new a(null);

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public String f14670e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public String f14671f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    public String f14672g;

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    public FKSensorContext f14673h;

    /* renamed from: i, reason: collision with root package name */
    public int f14674i;

    /* renamed from: j, reason: collision with root package name */
    @Nullable
    public FeedModel f14675j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f14676k;

    /* renamed from: n, reason: collision with root package name */
    public long f14679n;

    /* renamed from: o, reason: collision with root package name */
    @Nullable
    public o f14680o;

    /* renamed from: p, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f14681p = new LinkedHashMap();

    /* renamed from: l, reason: collision with root package name */
    @NotNull
    public final Lazy f14677l = kotlin.c.b(new Function0<FKLoadMoreListener>() { // from class: com.cupidapp.live.hashtag.detail.HashTagFragment$loadMoreListener$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final FKLoadMoreListener invoke() {
            final HashTagFragment hashTagFragment = HashTagFragment.this;
            return new FKLoadMoreListener(new Function0<p>() { // from class: com.cupidapp.live.hashtag.detail.HashTagFragment$loadMoreListener$2.1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ p invoke() {
                    invoke2();
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    String str;
                    String str2;
                    str = HashTagFragment.this.f14670e;
                    if (str == null || str.length() == 0) {
                        return;
                    }
                    HashTagFragment hashTagFragment2 = HashTagFragment.this;
                    str2 = hashTagFragment2.f14670e;
                    HashTagFragment.q1(hashTagFragment2, str2, null, 2, null);
                }
            });
        }
    });

    /* renamed from: m, reason: collision with root package name */
    @NotNull
    public final Lazy f14678m = kotlin.c.b(new Function0<HashTagAdapter>() { // from class: com.cupidapp.live.hashtag.detail.HashTagFragment$hashTagAdapter$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final HashTagAdapter invoke() {
            HashTagAdapter hashTagAdapter = new HashTagAdapter();
            HashTagFragment.this.n1(hashTagAdapter);
            return hashTagAdapter;
        }
    });

    /* compiled from: HashTagFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final HashTagFragment a(int i10, @NotNull String hashtagId, @Nullable String str, @NotNull FKSensorContext currentSensorContext) {
            s.i(hashtagId, "hashtagId");
            s.i(currentSensorContext, "currentSensorContext");
            HashTagFragment hashTagFragment = new HashTagFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("date_type", i10);
            z0.g.d(bundle, currentSensorContext);
            bundle.putString("hashtag_id", hashtagId);
            bundle.putString("hashtag_name", str);
            hashTagFragment.setArguments(bundle);
            return hashTagFragment;
        }
    }

    /* compiled from: HashTagFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f14682a;

        static {
            int[] iArr = new int[SensorPosition.values().length];
            try {
                iArr[SensorPosition.HashtagHot.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SensorPosition.HashtagNew.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f14682a = iArr;
        }
    }

    /* compiled from: HashTagFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class c implements o.c {
        public c() {
        }

        @Override // com.cupidapp.live.base.utils.o.c
        public void a(long j10) {
            k.f50238a.a(HashTagFragment.this.O0(), (i10 & 2) != 0 ? null : null, (i10 & 4) != 0 ? null : null, j10);
        }

        @Override // com.cupidapp.live.base.utils.o.c
        public void b(@NotNull String imageUriString, boolean z10) {
            s.i(imageUriString, "imageUriString");
            k.f50238a.d(HashTagFragment.this.O0(), z10);
        }
    }

    public static /* synthetic */ void q1(HashTagFragment hashTagFragment, String str, Boolean bool, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = null;
        }
        if ((i10 & 2) != 0) {
            bool = Boolean.FALSE;
        }
        hashTagFragment.p1(str, bool);
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment
    public void N0() {
        this.f14681p.clear();
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment
    @NotNull
    public SensorPosition O0() {
        Bundle arguments = getArguments();
        if ((arguments != null ? arguments.getInt("date_type") : 0) == 0) {
            return SensorPosition.HashtagHot;
        }
        return SensorPosition.HashtagNew;
    }

    @Nullable
    public View S0(int i10) {
        View findViewById;
        Map<Integer, View> map = this.f14681p;
        View view = map.get(Integer.valueOf(i10));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null || (findViewById = view2.findViewById(i10)) == null) {
            return null;
        }
        map.put(Integer.valueOf(i10), findViewById);
        return findViewById;
    }

    public final void f1(final FeedModel feedModel, final int i10) {
        Observable<Result<Object>> D = NetworkClient.f11868a.l().D(feedModel.getPostId());
        Object context = getContext();
        com.cupidapp.live.base.network.g gVar = context instanceof com.cupidapp.live.base.network.g ? (com.cupidapp.live.base.network.g) context : null;
        Disposable disposed = D.flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<Object, p>() { // from class: com.cupidapp.live.hashtag.detail.HashTagFragment$cancelFeedLike$$inlined$handleByContext$default$1
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
                HashTagAdapter k12;
                FeedModel.this.cancelPraise();
                k12 = this.k1();
                k12.notifyItemChanged(i10);
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, gVar)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            if (gVar != null) {
                gVar.H(disposed);
            }
        }
        s.h(disposed, "disposed");
    }

    public final void g1(final FeedModel feedModel, final int i10) {
        final Map h10 = i0.h(kotlin.f.a(Integer.valueOf(RequestErrorCode.YouBlacklistedTheOtherPerson.getValue()), new Function1<String, p>() { // from class: com.cupidapp.live.hashtag.detail.HashTagFragment$feedLike$errorCodeInterceptor$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(String str) {
                invoke2(str);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable String str) {
                FKAlertDialog.G(FKAlertDialog.w(FKAlertDialog.a.c(FKAlertDialog.f12698l, HashTagFragment.this.getContext(), false, 2, null).n(str), 0, null, null, 7, null), null, 1, null);
            }
        }));
        Observable<Result<FeedLikeResult>> A = NetworkClient.f11868a.l().A(feedModel.getPostId());
        Object context = getContext();
        Function1<Throwable, Boolean> function1 = new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.hashtag.detail.HashTagFragment$feedLike$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                s.i(it, "it");
                j.f(j.f12008a, it, HashTagFragment.this.getContext(), h10, null, 8, null);
                return Boolean.TRUE;
            }
        };
        com.cupidapp.live.base.network.g gVar = context instanceof com.cupidapp.live.base.network.g ? (com.cupidapp.live.base.network.g) context : null;
        Disposable disposed = A.flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<FeedLikeResult, p>() { // from class: com.cupidapp.live.hashtag.detail.HashTagFragment$feedLike$$inlined$handleByContext$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(FeedLikeResult feedLikeResult) {
                m2588invoke(feedLikeResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2588invoke(FeedLikeResult feedLikeResult) {
                HashTagAdapter k12;
                FeedModel.this.praise();
                k12 = this.k1();
                k12.notifyItemChanged(i10);
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(function1, gVar)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            if (gVar != null) {
                gVar.H(disposed);
            }
        }
        s.h(disposed, "disposed");
    }

    public final FKEmptyViewModel h1() {
        return new FKEmptyViewModel(null, Integer.valueOf(R$string.empty_tags_placeholder), null, null, null, null, null, false, null, null, 1021, null);
    }

    public final ExposureScene i1() {
        int i10 = b.f14682a[O0().ordinal()];
        if (i10 == 1) {
            return ExposureScene.HashtagHot;
        }
        if (i10 != 2) {
            return ExposureScene.HashtagHot;
        }
        return ExposureScene.HashtagNew;
    }

    @Nullable
    public final FeedModel j1() {
        return this.f14675j;
    }

    public final HashTagAdapter k1() {
        return (HashTagAdapter) this.f14678m.getValue();
    }

    public final FKLoadMoreListener l1() {
        return (FKLoadMoreListener) this.f14677l.getValue();
    }

    public final void m1(FeedModel feedModel, UserActionType userActionType) {
        SensorPosition sensorPosition;
        SensorPosition sensorPosition2;
        h hVar = h.f14329a;
        String postId = feedModel.getPostId();
        Integer tagId = feedModel.getTagId();
        FKSensorContext fKSensorContext = this.f14673h;
        if (fKSensorContext == null || (sensorPosition = fKSensorContext.getPosition()) == null) {
            sensorPosition = SensorPosition.Unknown;
        }
        SensorPosition sensorPosition3 = sensorPosition;
        FKSensorContext fKSensorContext2 = this.f14673h;
        if (fKSensorContext2 == null || (sensorPosition2 = fKSensorContext2.getSource()) == null) {
            sensorPosition2 = SensorPosition.Unknown;
        }
        hVar.e(postId, tagId, userActionType, sensorPosition3, sensorPosition2, (r18 & 32) != 0 ? null : null, (r18 & 64) != 0 ? null : feedModel.getPostStatisticsCallback());
    }

    public final void n1(HashTagAdapter hashTagAdapter) {
        hashTagAdapter.l().g(new Function1<Object, p>() { // from class: com.cupidapp.live.hashtag.detail.HashTagFragment$initAdapterClickListener$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Object obj) {
                invoke2(obj);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Object obj) {
                if (obj instanceof FeedModel) {
                    FeedModel feedModel = (FeedModel) obj;
                    HashTagFragment.this.t1(feedModel);
                    HashTagFragment.this.m1(feedModel, UserActionType.Click);
                }
            }
        });
        hashTagAdapter.l().k(i0.h(kotlin.f.a(Integer.valueOf(R$id.hashtagCoverImageView), new Function2<Object, Integer, p>() { // from class: com.cupidapp.live.hashtag.detail.HashTagFragment$initAdapterClickListener$2
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: invoke */
            public /* bridge */ /* synthetic */ p mo1743invoke(Object obj, Integer num) {
                invoke(obj, num.intValue());
                return p.f51048a;
            }

            public final void invoke(@Nullable Object obj, int i10) {
                if (obj instanceof FeedModel) {
                    FeedModel feedModel = (FeedModel) obj;
                    HashTagFragment.this.t1(feedModel);
                    HashTagFragment.this.m1(feedModel, UserActionType.Click);
                }
            }
        }), kotlin.f.a(Integer.valueOf(R$id.linkcountTxt), new Function2<Object, Integer, p>() { // from class: com.cupidapp.live.hashtag.detail.HashTagFragment$initAdapterClickListener$3
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: invoke */
            public /* bridge */ /* synthetic */ p mo1743invoke(Object obj, Integer num) {
                invoke(obj, num.intValue());
                return p.f51048a;
            }

            public final void invoke(@Nullable Object obj, int i10) {
                FKSensorContext fKSensorContext;
                FKSensorContext fKSensorContext2;
                FKSensorContext fKSensorContext3;
                FKSensorContext fKSensorContext4;
                if (obj instanceof FeedModel) {
                    FeedModel feedModel = (FeedModel) obj;
                    if (feedModel.getLiked()) {
                        HashTagFragment.this.f1(feedModel, i10);
                        HashTagFragment.this.m1(feedModel, UserActionType.CancelPraise);
                        SensorsLogFeed sensorsLogFeed = SensorsLogFeed.f12208a;
                        fKSensorContext3 = HashTagFragment.this.f14673h;
                        SensorScene scene = fKSensorContext3 != null ? fKSensorContext3.getScene() : null;
                        fKSensorContext4 = HashTagFragment.this.f14673h;
                        sensorsLogFeed.n(scene, fKSensorContext4 != null ? fKSensorContext4.getPosition() : null, feedModel.getPostId(), feedModel.getUser().userId(), feedModel.getUser().getAloha(), feedModel.getStrategyId(), p1.g.f52734a.x());
                        return;
                    }
                    HashTagFragment.this.g1(feedModel, i10);
                    HashTagFragment.this.m1(feedModel, UserActionType.Praise);
                    SensorsLogFeed sensorsLogFeed2 = SensorsLogFeed.f12208a;
                    String userId = feedModel.getUser().userId();
                    String postId = feedModel.getPostId();
                    fKSensorContext = HashTagFragment.this.f14673h;
                    SensorPosition position = fKSensorContext != null ? fKSensorContext.getPosition() : null;
                    fKSensorContext2 = HashTagFragment.this.f14673h;
                    sensorsLogFeed2.m(userId, postId, position, fKSensorContext2 != null ? fKSensorContext2.getScene() : null, SensorsLogFeed.LikeCommentType.Feed, feedModel.getUser().getAloha(), feedModel.getStrategyId(), p1.g.f52734a.x());
                }
            }
        }), kotlin.f.a(Integer.valueOf(R$id.avatarImg), new Function2<Object, Integer, p>() { // from class: com.cupidapp.live.hashtag.detail.HashTagFragment$initAdapterClickListener$4
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: invoke */
            public /* bridge */ /* synthetic */ p mo1743invoke(Object obj, Integer num) {
                invoke(obj, num.intValue());
                return p.f51048a;
            }

            /* JADX WARN: Code restructure failed: missing block: B:3:0x0004, code lost:
            
                r10 = r8.this$0.f14673h;
             */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void invoke(@org.jetbrains.annotations.Nullable java.lang.Object r9, int r10) {
                /*
                    r8 = this;
                    boolean r10 = r9 instanceof com.cupidapp.live.feed.model.FeedModel
                    if (r10 == 0) goto L2b
                    com.cupidapp.live.hashtag.detail.HashTagFragment r10 = com.cupidapp.live.hashtag.detail.HashTagFragment.this
                    com.cupidapp.live.base.sensorslog.FKSensorContext r10 = com.cupidapp.live.hashtag.detail.HashTagFragment.Z0(r10)
                    if (r10 == 0) goto L2b
                    com.cupidapp.live.base.sensorslog.SensorScene r10 = r10.getScene()
                    if (r10 == 0) goto L2b
                    com.cupidapp.live.track.group.GroupSocialLog r0 = com.cupidapp.live.track.group.GroupSocialLog.f18708a
                    java.lang.String r1 = r10.getValue()
                    com.cupidapp.live.feed.model.FeedModel r9 = (com.cupidapp.live.feed.model.FeedModel) r9
                    com.cupidapp.live.profile.model.User r9 = r9.getUser()
                    java.lang.String r2 = r9.userId()
                    r3 = 0
                    r4 = 0
                    r5 = 0
                    r6 = 28
                    r7 = 0
                    com.cupidapp.live.track.group.GroupSocialLog.v(r0, r1, r2, r3, r4, r5, r6, r7)
                L2b:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.hashtag.detail.HashTagFragment$initAdapterClickListener$4.invoke(java.lang.Object, int):void");
            }
        })));
    }

    public final void o1() {
        HashTagAdapter k12 = k1();
        int i10 = R$id.recyclerview;
        RecyclerView recyclerview = (RecyclerView) S0(i10);
        s.h(recyclerview, "recyclerview");
        k12.z(recyclerview, i1(), this.f14673h, this.f14672g);
        RecyclerView initView$lambda$2 = (RecyclerView) S0(i10);
        initView$lambda$2.setAdapter(k1());
        initView$lambda$2.setLayoutManager(new StaggeredGridLayoutManager(k1().v(), 1));
        s.h(initView$lambda$2, "initView$lambda$2");
        int c4 = z0.h.c(initView$lambda$2, 2.0f);
        initView$lambda$2.addItemDecoration(new StaggeredGridDecoration(c4, c4, c4, c4, 0, 16, null));
        RecyclerView.ItemAnimator itemAnimator = initView$lambda$2.getItemAnimator();
        SimpleItemAnimator simpleItemAnimator = itemAnimator instanceof SimpleItemAnimator ? (SimpleItemAnimator) itemAnimator : null;
        if (simpleItemAnimator != null) {
            simpleItemAnimator.setSupportsChangeAnimations(false);
        }
        initView$lambda$2.addOnScrollListener(l1());
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        s.i(inflater, "inflater");
        return inflater.inflate(R$layout.fragment_hashtag, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        this.f14676k = false;
        super.onDestroy();
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        N0();
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        o oVar = this.f14680o;
        if (oVar != null) {
            oVar.n();
        }
        SensorsLogFeed.f12208a.h(O0(), (int) ((System.currentTimeMillis() - this.f14679n) / 1000));
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        SensorPosition sensorPosition;
        super.onResume();
        this.f14679n = System.currentTimeMillis();
        o oVar = this.f14680o;
        if (oVar != null) {
            oVar.m();
        }
        if (this.f14676k) {
            return;
        }
        this.f14676k = true;
        q1(this, null, null, 3, null);
        SensorsLogFeed sensorsLogFeed = SensorsLogFeed.f12208a;
        FKSensorContext fKSensorContext = this.f14673h;
        SensorScene scene = fKSensorContext != null ? fKSensorContext.getScene() : null;
        FKSensorContext fKSensorContext2 = this.f14673h;
        if (fKSensorContext2 == null || (sensorPosition = fKSensorContext2.getPosition()) == null) {
            sensorPosition = SensorPosition.Unknown;
        }
        SensorPosition sensorPosition2 = sensorPosition;
        FKSensorContext fKSensorContext3 = this.f14673h;
        sensorsLogFeed.M(scene, sensorPosition2, fKSensorContext3 != null ? fKSensorContext3.getSource() : null, this.f14671f, this.f14672g);
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        s.i(view, "view");
        super.onViewCreated(view, bundle);
        Bundle arguments = getArguments();
        this.f14671f = arguments != null ? arguments.getString("hashtag_id") : null;
        Bundle arguments2 = getArguments();
        this.f14672g = arguments2 != null ? arguments2.getString("hashtag_name") : null;
        Bundle arguments3 = getArguments();
        this.f14673h = arguments3 != null ? (FKSensorContext) z0.g.b(arguments3, FKSensorContext.class) : null;
        Bundle arguments4 = getArguments();
        this.f14674i = arguments4 != null ? arguments4.getInt("date_type") : 0;
        o1();
        s1();
    }

    public final void p1(@Nullable final String str, @Nullable Boolean bool) {
        Observable m10;
        if (this.f14671f == null) {
            return;
        }
        if (s.d(bool, Boolean.TRUE)) {
            RecyclerExposureHelper.f12092j.d(i1());
        }
        if (this.f14674i == 0) {
            f2.a l10 = NetworkClient.f11868a.l();
            String str2 = this.f14671f;
            s.f(str2);
            m10 = a.C0731a.l(l10, str2, str, 0, 4, null);
        } else {
            f2.a l11 = NetworkClient.f11868a.l();
            String str3 = this.f14671f;
            s.f(str3);
            m10 = a.C0731a.m(l11, str3, str, 0, 4, null);
        }
        Disposable disposed = m10.flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<ListResult<FeedModel>, p>() { // from class: com.cupidapp.live.hashtag.detail.HashTagFragment$loadData$$inlined$handle$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(ListResult<FeedModel> listResult) {
                m2589invoke(listResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2589invoke(ListResult<FeedModel> listResult) {
                FKLoadMoreListener l12;
                HashTagAdapter k12;
                HashTagAdapter k13;
                HashTagAdapter k14;
                HashTagAdapter k15;
                HashTagAdapter k16;
                HashTagAdapter k17;
                FKEmptyViewModel h12;
                HashTagAdapter k18;
                HashTagAdapter k19;
                HashTagAdapter k110;
                ListResult<FeedModel> listResult2 = listResult;
                l12 = HashTagFragment.this.l1();
                l12.c(false);
                HashTagFragment.this.f14670e = listResult2.getNextCursorId();
                k12 = HashTagFragment.this.k1();
                int n10 = k12.n();
                if (str == null) {
                    k19 = HashTagFragment.this.k1();
                    k19.j().clear();
                    k110 = HashTagFragment.this.k1();
                    k110.d(new FKFooterViewModel(false, false, null, 0, 0, 0, 63, null));
                }
                List<FeedModel> list = listResult2.getList();
                if (list == null || list.isEmpty()) {
                    h12 = HashTagFragment.this.h1();
                    k18 = HashTagFragment.this.k1();
                    k18.d(h12);
                } else {
                    if (str == null) {
                        HashTagFragment hashTagFragment = HashTagFragment.this;
                        List<FeedModel> list2 = listResult2.getList();
                        hashTagFragment.f14675j = list2 != null ? list2.get(0) : null;
                    }
                    k13 = HashTagFragment.this.k1();
                    k13.e(listResult2.getList());
                }
                if (listResult2.getNextCursorId() == null) {
                    k17 = HashTagFragment.this.k1();
                    FKFooterViewModel h10 = k17.h();
                    if (h10 != null) {
                        h10.setShowProgress(false);
                    }
                }
                if (str == null) {
                    k16 = HashTagFragment.this.k1();
                    k16.notifyDataSetChanged();
                } else {
                    k14 = HashTagFragment.this.k1();
                    k15 = HashTagFragment.this.k1();
                    k14.notifyItemRangeChanged(n10, k15.j().size() - n10);
                }
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.hashtag.detail.HashTagFragment$loadData$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                FKLoadMoreListener l12;
                s.i(it, "it");
                l12 = HashTagFragment.this.l1();
                l12.c(false);
                return Boolean.FALSE;
            }
        }, this)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            H(disposed);
        }
        s.h(disposed, "disposed");
    }

    public final void r1() {
        k1().y();
    }

    public final void s1() {
        Context context = getContext();
        if (context != null) {
            o c4 = o.f12354i.c(context);
            this.f14680o = c4;
            if (c4 != null) {
                c4.l(new c());
            }
        }
    }

    public final void t1(FeedModel feedModel) {
        SensorPosition sensorPosition;
        SensorPosition sensorPosition2 = SensorPosition.FeedDetail;
        FKSensorContext fKSensorContext = this.f14673h;
        if (fKSensorContext == null || (sensorPosition = fKSensorContext.getPosition()) == null) {
            sensorPosition = SensorPosition.Unknown;
        }
        FKSensorContext fKSensorContext2 = this.f14673h;
        FeedDetailActivity.a.b(FeedDetailActivity.Q, getContext(), feedModel, false, new FeedSensorContext(sensorPosition2, sensorPosition, fKSensorContext2 != null ? fKSensorContext2.getSource() : null, SensorScene.Feed), false, false, null, null, null, null, 960, null);
    }
}

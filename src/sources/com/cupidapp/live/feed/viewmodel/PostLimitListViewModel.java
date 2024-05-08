package com.cupidapp.live.feed.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import com.cupidapp.live.base.livedata.CombineLiveData;
import com.cupidapp.live.base.livedata.Event;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.e;
import com.cupidapp.live.base.network.i;
import com.cupidapp.live.base.network.model.FollowPrefer;
import com.cupidapp.live.base.network.model.ListResult;
import com.cupidapp.live.base.network.model.StateResult;
import com.cupidapp.live.base.network.model.SwipeCardUserLikeResult;
import com.cupidapp.live.base.sensorslog.FKSensorContext;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorScene;
import com.cupidapp.live.feed.model.PostLimitDetailModel;
import com.cupidapp.live.profile.logic.c;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.superlike.model.FollowType;
import com.cupidapp.live.track.group.GroupSocialLog;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.s;
import kotlin.jvm.internal.z;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p1.g;
import x2.a;

/* compiled from: PostLimitListViewModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class PostLimitListViewModel extends ViewModel {

    @NotNull
    private final MutableLiveData<StateResult<Pair<List<List<PostLimitDetailModel>>, Integer>>> _listLiveData;

    @NotNull
    private final MutableLiveData<Event<String>> _openViewerListEvent;

    @NotNull
    private final MutableLiveData<Boolean> _swipeGuideLiveData;

    @NotNull
    private final CombineLiveData<Boolean, StateResult<Pair<List<List<PostLimitDetailModel>>, Integer>>, Boolean> clickGuideLiveData;

    @Nullable
    private String currentSelectUserId;
    private final int defaultLoadSize;
    private boolean isDelAllMyPostLimit;
    private boolean isUploadedPostLimit;
    private int left;

    @NotNull
    private final LiveData<StateResult<Pair<List<List<PostLimitDetailModel>>, Integer>>> listLiveData;

    @NotNull
    private final LiveData<Event<String>> openViewerListEvent;

    @NotNull
    private final Set<String> readList;
    private int right;
    private final int selectIndex;

    @NotNull
    private final FKSensorContext sensorContext;

    @NotNull
    private final LiveData<Boolean> swipeGuideLiveData;

    @NotNull
    private final List<String> userIds;

    public PostLimitListViewModel(@NotNull List<String> userIds, int i10, @NotNull FKSensorContext sensorContext) {
        s.i(userIds, "userIds");
        s.i(sensorContext, "sensorContext");
        this.userIds = userIds;
        this.selectIndex = i10;
        this.sensorContext = sensorContext;
        this.defaultLoadSize = 8;
        MutableLiveData<StateResult<Pair<List<List<PostLimitDetailModel>>, Integer>>> mutableLiveData = new MutableLiveData<>();
        this._listLiveData = mutableLiveData;
        LiveData<StateResult<Pair<List<List<PostLimitDetailModel>>, Integer>>> distinctUntilChanged = Transformations.distinctUntilChanged(mutableLiveData);
        this.listLiveData = distinctUntilChanged;
        this.left = i10 - 1;
        this.right = i10;
        MutableLiveData<Event<String>> mutableLiveData2 = new MutableLiveData<>();
        this._openViewerListEvent = mutableLiveData2;
        this.openViewerListEvent = mutableLiveData2;
        MutableLiveData<Boolean> mutableLiveData3 = new MutableLiveData<>();
        mutableLiveData3.setValue(Boolean.valueOf(s.d(g.f52734a.k1(), Boolean.TRUE)));
        this._swipeGuideLiveData = mutableLiveData3;
        LiveData<Boolean> distinctUntilChanged2 = Transformations.distinctUntilChanged(new CombineLiveData(mutableLiveData3, mutableLiveData, new Function2<Boolean, StateResult<Pair<? extends List<List<? extends PostLimitDetailModel>>, ? extends Integer>>, Boolean>() { // from class: com.cupidapp.live.feed.viewmodel.PostLimitListViewModel$swipeGuideLiveData$1
            @Nullable
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Boolean invoke2(@Nullable Boolean bool, @Nullable StateResult<Pair<List<List<PostLimitDetailModel>>, Integer>> stateResult) {
                Pair<List<List<PostLimitDetailModel>>, Integer> data;
                List<List<PostLimitDetailModel>> first;
                boolean z10 = false;
                if (((stateResult == null || (data = stateResult.getData()) == null || (first = data.getFirst()) == null) ? 0 : first.size()) >= 2 && s.d(bool, Boolean.TRUE)) {
                    z10 = true;
                }
                return Boolean.valueOf(z10);
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: invoke */
            public /* bridge */ /* synthetic */ Boolean mo1743invoke(Boolean bool, StateResult<Pair<? extends List<List<? extends PostLimitDetailModel>>, ? extends Integer>> stateResult) {
                return invoke2(bool, (StateResult<Pair<List<List<PostLimitDetailModel>>, Integer>>) stateResult);
            }
        }));
        this.swipeGuideLiveData = distinctUntilChanged2;
        this.clickGuideLiveData = new CombineLiveData<>(distinctUntilChanged2, distinctUntilChanged, new Function2<Boolean, StateResult<Pair<? extends List<List<? extends PostLimitDetailModel>>, ? extends Integer>>, Boolean>() { // from class: com.cupidapp.live.feed.viewmodel.PostLimitListViewModel$clickGuideLiveData$1
            @Override // kotlin.jvm.functions.Function2
            /* renamed from: invoke */
            public /* bridge */ /* synthetic */ Boolean mo1743invoke(Boolean bool, StateResult<Pair<? extends List<List<? extends PostLimitDetailModel>>, ? extends Integer>> stateResult) {
                return invoke2(bool, (StateResult<Pair<List<List<PostLimitDetailModel>>, Integer>>) stateResult);
            }

            /* JADX WARN: Code restructure failed: missing block: B:19:0x0047, code lost:
            
                if (((r6 == null || (r6 = r6.getData()) == null || (r6 = r6.getFirst()) == null || !(r6.isEmpty() ^ true)) ? false : true) != false) goto L23;
             */
            /* JADX WARN: Code restructure failed: missing block: B:27:0x0053, code lost:
            
                if (kotlin.jvm.internal.s.d(r5.g1(), java.lang.Boolean.TRUE) != false) goto L27;
             */
            @org.jetbrains.annotations.Nullable
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Boolean invoke2(@org.jetbrains.annotations.Nullable java.lang.Boolean r5, @org.jetbrains.annotations.Nullable com.cupidapp.live.base.network.model.StateResult<kotlin.Pair<java.util.List<java.util.List<com.cupidapp.live.feed.model.PostLimitDetailModel>>, java.lang.Integer>> r6) {
                /*
                    r4 = this;
                    p1.g r5 = p1.g.f52734a
                    java.lang.Boolean r0 = r5.k1()
                    java.lang.Boolean r1 = java.lang.Boolean.FALSE
                    boolean r0 = kotlin.jvm.internal.s.d(r0, r1)
                    r1 = 1
                    r2 = 0
                    if (r0 != 0) goto L49
                    if (r6 == 0) goto L27
                    java.lang.Object r0 = r6.getData()
                    kotlin.Pair r0 = (kotlin.Pair) r0
                    if (r0 == 0) goto L27
                    java.lang.Object r0 = r0.getFirst()
                    java.util.List r0 = (java.util.List) r0
                    if (r0 == 0) goto L27
                    int r0 = r0.size()
                    goto L28
                L27:
                    r0 = 0
                L28:
                    r3 = 2
                    if (r0 >= r3) goto L56
                    if (r6 == 0) goto L46
                    java.lang.Object r6 = r6.getData()
                    kotlin.Pair r6 = (kotlin.Pair) r6
                    if (r6 == 0) goto L46
                    java.lang.Object r6 = r6.getFirst()
                    java.util.List r6 = (java.util.List) r6
                    if (r6 == 0) goto L46
                    boolean r6 = r6.isEmpty()
                    r6 = r6 ^ r1
                    if (r6 != r1) goto L46
                    r6 = 1
                    goto L47
                L46:
                    r6 = 0
                L47:
                    if (r6 == 0) goto L56
                L49:
                    java.lang.Boolean r5 = r5.g1()
                    java.lang.Boolean r6 = java.lang.Boolean.TRUE
                    boolean r5 = kotlin.jvm.internal.s.d(r5, r6)
                    if (r5 == 0) goto L56
                    goto L57
                L56:
                    r1 = 0
                L57:
                    java.lang.Boolean r5 = java.lang.Boolean.valueOf(r1)
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.feed.viewmodel.PostLimitListViewModel$clickGuideLiveData$1.invoke2(java.lang.Boolean, com.cupidapp.live.base.network.model.StateResult):java.lang.Boolean");
            }
        });
        this.readList = new LinkedHashSet();
        loadData(true, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<List<PostLimitDetailModel>> addList(List<? extends List<PostLimitDetailModel>> list, boolean z10, boolean z11) {
        List<List<PostLimitDetailModel>> arrayList;
        Pair<List<List<PostLimitDetailModel>>, Integer> data;
        StateResult<Pair<List<List<PostLimitDetailModel>>, Integer>> value = this._listLiveData.getValue();
        if (value == null || (data = value.getData()) == null || (arrayList = data.getFirst()) == null) {
            arrayList = new ArrayList<>();
        }
        if (z10 && !z11) {
            arrayList.addAll(0, list);
        } else {
            arrayList.addAll(list);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void computeDefaultSelectPos(List<? extends List<PostLimitDetailModel>> list) {
        String str;
        int i10;
        PostLimitDetailModel postLimitDetailModel;
        User user;
        User user2;
        User user3;
        if (this.currentSelectUserId != null || list == null) {
            return;
        }
        int i11 = this.selectIndex;
        while (true) {
            str = null;
            if (i11 >= this.userIds.size()) {
                i10 = -1;
                break;
            }
            Iterator<? extends List<PostLimitDetailModel>> iterator2 = list.iterator2();
            i10 = 0;
            while (true) {
                if (!iterator2.hasNext()) {
                    i10 = -1;
                    break;
                }
                PostLimitDetailModel postLimitDetailModel2 = (PostLimitDetailModel) CollectionsKt___CollectionsKt.V(iterator2.next());
                if (s.d((postLimitDetailModel2 == null || (user3 = postLimitDetailModel2.getUser()) == null) ? null : user3.userId(), this.userIds.get(i11))) {
                    break;
                } else {
                    i10++;
                }
            }
            if (i10 >= 0) {
                break;
            } else {
                i11++;
            }
        }
        if (i10 == -1) {
            int i12 = this.selectIndex - 1;
            while (true) {
                if (i12 < 0) {
                    break;
                }
                Iterator<? extends List<PostLimitDetailModel>> iterator22 = list.iterator2();
                int i13 = 0;
                while (true) {
                    if (!iterator22.hasNext()) {
                        i13 = -1;
                        break;
                    }
                    PostLimitDetailModel postLimitDetailModel3 = (PostLimitDetailModel) CollectionsKt___CollectionsKt.V(iterator22.next());
                    if (s.d((postLimitDetailModel3 == null || (user2 = postLimitDetailModel3.getUser()) == null) ? null : user2.userId(), this.userIds.get(i12))) {
                        break;
                    } else {
                        i13++;
                    }
                }
                if (i13 >= 0) {
                    i10 = i13;
                    break;
                }
                i12--;
            }
        }
        List list2 = (List) CollectionsKt___CollectionsKt.W(list, i10);
        if (list2 != null && (postLimitDetailModel = (PostLimitDetailModel) CollectionsKt___CollectionsKt.V(list2)) != null && (user = postLimitDetailModel.getUser()) != null) {
            str = user.userId();
        }
        this.currentSelectUserId = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loadData(final boolean z10, final boolean z11) {
        List<List<PostLimitDetailModel>> arrayList;
        Pair<List<List<PostLimitDetailModel>>, Integer> data;
        List<List<PostLimitDetailModel>> arrayList2;
        Pair<List<List<PostLimitDetailModel>>, Integer> data2;
        if (noDataLoad(z10, z11)) {
            StateResult<Pair<List<List<PostLimitDetailModel>>, Integer>> value = this._listLiveData.getValue();
            if (value == null || (data2 = value.getData()) == null || (arrayList2 = data2.getFirst()) == null) {
                arrayList2 = new ArrayList<>();
            }
            computeDefaultSelectPos(arrayList2);
            this._listLiveData.setValue(new StateResult.c(new Pair(arrayList2, Integer.valueOf(computeSelect(arrayList2))), null, 2, null));
            return;
        }
        final Ref$IntRef ref$IntRef = new Ref$IntRef();
        final Ref$IntRef ref$IntRef2 = new Ref$IntRef();
        if (z10 && z11) {
            int i10 = this.defaultLoadSize;
            ref$IntRef.element = i10 / 2;
            ref$IntRef2.element = (i10 / 2) + 1;
        } else if (z10) {
            ref$IntRef.element = this.defaultLoadSize;
            ref$IntRef2.element = 0;
        } else if (z11) {
            ref$IntRef.element = 0;
            ref$IntRef2.element = this.defaultLoadSize;
        }
        ArrayList arrayList3 = new ArrayList();
        if (z10) {
            while (arrayList3.size() < ref$IntRef.element && checkCanLoadLeft()) {
                arrayList3.add(0, this.userIds.get(this.left));
                this.left--;
            }
        }
        if (z11) {
            while (checkCanLoadNextData() && arrayList3.size() <= ref$IntRef2.element + ref$IntRef.element) {
                arrayList3.add(this.userIds.get(this.right));
                this.right++;
            }
        }
        if (arrayList3.size() == 0) {
            StateResult<Pair<List<List<PostLimitDetailModel>>, Integer>> value2 = this._listLiveData.getValue();
            if (value2 == null || (data = value2.getData()) == null || (arrayList = data.getFirst()) == null) {
                arrayList = new ArrayList<>();
            }
            computeDefaultSelectPos(arrayList);
            this._listLiveData.setValue(new StateResult.c(new Pair(arrayList, Integer.valueOf(computeSelect(arrayList))), null, 2, null));
            return;
        }
        Disposable disposed = NetworkClient.f11868a.l().x(arrayList3).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<ListResult<List<? extends PostLimitDetailModel>>, p>() { // from class: com.cupidapp.live.feed.viewmodel.PostLimitListViewModel$loadData$$inlined$handleByContext$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(ListResult<List<? extends PostLimitDetailModel>> listResult) {
                m2586invoke(listResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2586invoke(ListResult<List<? extends PostLimitDetailModel>> listResult) {
                List<? extends List<PostLimitDetailModel>> addList;
                MutableLiveData mutableLiveData;
                MutableLiveData mutableLiveData2;
                List<List<? extends PostLimitDetailModel>> list = listResult.getList();
                if (list == null) {
                    list = new ArrayList<>();
                }
                addList = PostLimitListViewModel.this.addList(list, z10, z11);
                if (list.size() >= ref$IntRef2.element + ref$IntRef.element) {
                    PostLimitListViewModel.this.computeDefaultSelectPos(addList);
                    mutableLiveData2 = PostLimitListViewModel.this._listLiveData;
                    mutableLiveData2.setValue(new StateResult.c(new Pair(addList, Integer.valueOf(PostLimitListViewModel.this.computeSelect(addList))), null, 2, null));
                } else {
                    mutableLiveData = PostLimitListViewModel.this._listLiveData;
                    mutableLiveData.setValue(new StateResult.b(new Pair(addList, -1), null, 2, null));
                    if (PostLimitListViewModel.this.checkCanLoadNextData()) {
                        PostLimitListViewModel.this.loadData(false, true);
                    } else {
                        PostLimitListViewModel.this.loadData(true, false);
                    }
                }
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.feed.viewmodel.PostLimitListViewModel$loadData$2
            {
                super(1);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                MutableLiveData mutableLiveData;
                MutableLiveData mutableLiveData2;
                Object arrayList4;
                Pair pair;
                s.i(it, "it");
                mutableLiveData = PostLimitListViewModel.this._listLiveData;
                mutableLiveData2 = PostLimitListViewModel.this._listLiveData;
                StateResult stateResult = (StateResult) mutableLiveData2.getValue();
                if (stateResult == null || (pair = (Pair) stateResult.getData()) == null || (arrayList4 = (List) pair.getFirst()) == null) {
                    arrayList4 = new ArrayList();
                }
                mutableLiveData.setValue(new StateResult.a(null, new Pair(arrayList4, -1), null, 5, null));
                return Boolean.FALSE;
            }
        }, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    public final void changeSelect(int i10) {
        PostLimitDetailModel postLimitDetailModel;
        User user;
        Pair<List<List<PostLimitDetailModel>>, Integer> data;
        List<List<PostLimitDetailModel>> first;
        StateResult<Pair<List<List<PostLimitDetailModel>>, Integer>> value = this._listLiveData.getValue();
        String str = null;
        List list = (value == null || (data = value.getData()) == null || (first = data.getFirst()) == null) ? null : (List) CollectionsKt___CollectionsKt.W(first, i10);
        if (list != null && (postLimitDetailModel = (PostLimitDetailModel) CollectionsKt___CollectionsKt.V(list)) != null && (user = postLimitDetailModel.getUser()) != null) {
            str = user.userId();
        }
        this.currentSelectUserId = str;
    }

    public final void changeSwipeGuide(boolean z10) {
        g.f52734a.w3(Boolean.valueOf(z10));
        this._swipeGuideLiveData.setValue(Boolean.valueOf(z10));
    }

    public final boolean checkCanLoadLeft() {
        return this.left >= 0;
    }

    public final boolean checkCanLoadNextData() {
        return this.right < this.userIds.size();
    }

    public final int computeSelect(@Nullable List<? extends List<PostLimitDetailModel>> list) {
        User user;
        String str = this.currentSelectUserId;
        int i10 = 0;
        if ((str == null || str.length() == 0) || list == null) {
            return -1;
        }
        Iterator<? extends List<PostLimitDetailModel>> iterator2 = list.iterator2();
        while (iterator2.hasNext()) {
            PostLimitDetailModel postLimitDetailModel = (PostLimitDetailModel) CollectionsKt___CollectionsKt.V(iterator2.next());
            if (s.d((postLimitDetailModel == null || (user = postLimitDetailModel.getUser()) == null) ? null : user.userId(), this.currentSelectUserId)) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    public final void deleteLimitPost(@NotNull final String postLimitId) {
        s.i(postLimitId, "postLimitId");
        Disposable disposed = NetworkClient.f11868a.l().F(postLimitId).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<Object, p>() { // from class: com.cupidapp.live.feed.viewmodel.PostLimitListViewModel$deleteLimitPost$$inlined$handle$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Object obj) {
                invoke2(obj);
                return p.f51048a;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object obj) {
                MutableLiveData mutableLiveData;
                MutableLiveData mutableLiveData2;
                Object obj2;
                Pair pair;
                mutableLiveData = PostLimitListViewModel.this._listLiveData;
                StateResult stateResult = (StateResult) mutableLiveData.getValue();
                List list = (stateResult == null || (pair = (Pair) stateResult.getData()) == null) ? null : (List) pair.getFirst();
                if (list != null) {
                    Iterator iterator2 = list.iterator2();
                    while (true) {
                        if (!iterator2.hasNext()) {
                            break;
                        }
                        List list2 = (List) iterator2.next();
                        Iterator<E> iterator22 = list2.iterator2();
                        while (true) {
                            if (!iterator22.hasNext()) {
                                obj2 = null;
                                break;
                            } else {
                                obj2 = iterator22.next();
                                if (s.d(((PostLimitDetailModel) obj2).getId(), postLimitId)) {
                                    break;
                                }
                            }
                        }
                        PostLimitDetailModel postLimitDetailModel = (PostLimitDetailModel) obj2;
                        if (postLimitDetailModel != null) {
                            s.g(list2, "null cannot be cast to non-null type kotlin.collections.MutableList<com.cupidapp.live.feed.model.PostLimitDetailModel>");
                            z.c(list2).remove(postLimitDetailModel);
                            if (list2.isEmpty()) {
                                iterator2.remove();
                                c cVar = c.f17839a;
                                User user = postLimitDetailModel.getUser();
                                if (cVar.a(user != null ? user.userId() : null)) {
                                    PostLimitListViewModel.this.setDelAllMyPostLimit(true);
                                    Set<String> readList = PostLimitListViewModel.this.getReadList();
                                    User X = g.f52734a.X();
                                    z.a(readList).remove(X != null ? X.userId() : null);
                                }
                            }
                        }
                    }
                }
                mutableLiveData2 = PostLimitListViewModel.this._listLiveData;
                if (list == null) {
                    list = new ArrayList();
                }
                mutableLiveData2.setValue(new StateResult.c(new Pair(list, -1), null, 2, null));
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(null, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    public final void follow(@Nullable final String str) {
        if (str == null) {
            return;
        }
        Disposable disposed = a.C0836a.o(NetworkClient.f11868a.N(), str, null, null, FollowPrefer.PostLimitRefer.getValue(), FollowType.Default.getValue(), null, null, null, 224, null).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<SwipeCardUserLikeResult, p>() { // from class: com.cupidapp.live.feed.viewmodel.PostLimitListViewModel$follow$$inlined$handle$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(SwipeCardUserLikeResult swipeCardUserLikeResult) {
                m2585invoke(swipeCardUserLikeResult);
                return p.f51048a;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2585invoke(SwipeCardUserLikeResult swipeCardUserLikeResult) {
                MutableLiveData mutableLiveData;
                MutableLiveData mutableLiveData2;
                User user;
                Pair pair;
                SwipeCardUserLikeResult swipeCardUserLikeResult2 = swipeCardUserLikeResult;
                mutableLiveData = PostLimitListViewModel.this._listLiveData;
                StateResult stateResult = (StateResult) mutableLiveData.getValue();
                List list = (stateResult == null || (pair = (Pair) stateResult.getData()) == null) ? null : (List) pair.getFirst();
                if (list != null) {
                    Iterator iterator2 = list.iterator2();
                    while (true) {
                        if (!iterator2.hasNext()) {
                            break;
                        }
                        List<PostLimitDetailModel> list2 = (List) iterator2.next();
                        PostLimitDetailModel postLimitDetailModel = (PostLimitDetailModel) CollectionsKt___CollectionsKt.V(list2);
                        if (s.d((postLimitDetailModel == null || (user = postLimitDetailModel.getUser()) == null) ? null : user.userId(), str)) {
                            for (PostLimitDetailModel postLimitDetailModel2 : list2) {
                                User user2 = postLimitDetailModel2.getUser();
                                if (user2 != null) {
                                    user2.setAloha(swipeCardUserLikeResult2.getUser().getAloha());
                                }
                                User user3 = postLimitDetailModel2.getUser();
                                if (user3 != null) {
                                    user3.setMatch(swipeCardUserLikeResult2.getUser().getMatch());
                                }
                                User user4 = postLimitDetailModel2.getUser();
                                if (user4 != null) {
                                    user4.setCanSendInboxMessage(swipeCardUserLikeResult2.getUser().getCanSendInboxMessage());
                                }
                            }
                        }
                    }
                }
                mutableLiveData2 = PostLimitListViewModel.this._listLiveData;
                if (list == null) {
                    list = new ArrayList();
                }
                mutableLiveData2.setValue(new StateResult.c(new Pair(list, -1), null, 2, null));
                GroupSocialLog groupSocialLog = GroupSocialLog.f18708a;
                SensorScene scene = PostLimitListViewModel.this.getSensorContext().getScene();
                groupSocialLog.B(true, scene != null ? scene.getValue() : null, str, (r52 & 8) != 0 ? 1 : 1, (r52 & 16) != 0 ? null : Boolean.valueOf(swipeCardUserLikeResult2.getUser().isAlohaMatched()), (r52 & 32) != 0 ? null : swipeCardUserLikeResult2.getRecommendContext(), (r52 & 64) != 0 ? false : false, (r52 & 128) != 0 ? null : null, (r52 & 256) != 0 ? null : SensorPosition.PostLimit, (r52 & 512) != 0 ? false : swipeCardUserLikeResult2.getUser().getSuperLikedByMe(), (r52 & 1024) != 0 ? null : null, (r52 & 2048) != 0 ? null : null, (r52 & 4096) != 0 ? 0 : 0, (r52 & 8192) != 0 ? null : null, (r52 & 16384) != 0 ? false : false, (32768 & r52) != 0 ? null : null, (65536 & r52) != 0 ? null : null, (131072 & r52) != 0 ? null : null, (262144 & r52) != 0 ? null : null, (524288 & r52) != 0 ? null : null, (1048576 & r52) != 0 ? null : null, (2097152 & r52) != 0 ? null : null, (4194304 & r52) != 0 ? null : null, (r52 & 8388608) != 0 ? null : null);
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(null, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    @NotNull
    public final CombineLiveData<Boolean, StateResult<Pair<List<List<PostLimitDetailModel>>, Integer>>, Boolean> getClickGuideLiveData() {
        return this.clickGuideLiveData;
    }

    @Nullable
    public final String getCurrentSelectUserId() {
        return this.currentSelectUserId;
    }

    public final int getDefaultLoadSize() {
        return this.defaultLoadSize;
    }

    @NotNull
    public final LiveData<StateResult<Pair<List<List<PostLimitDetailModel>>, Integer>>> getListLiveData() {
        return this.listLiveData;
    }

    @NotNull
    public final LiveData<Event<String>> getOpenViewerListEvent() {
        return this.openViewerListEvent;
    }

    @NotNull
    public final Set<String> getReadList() {
        return this.readList;
    }

    public final int getSelectIndex() {
        return this.selectIndex;
    }

    @NotNull
    public final FKSensorContext getSensorContext() {
        return this.sensorContext;
    }

    @NotNull
    public final LiveData<Boolean> getSwipeGuideLiveData() {
        return this.swipeGuideLiveData;
    }

    @NotNull
    public final List<String> getUserIds() {
        return this.userIds;
    }

    public final boolean isDelAllMyPostLimit() {
        return this.isDelAllMyPostLimit;
    }

    public final boolean isUploadedPostLimit() {
        return this.isUploadedPostLimit;
    }

    public final void loadNextData() {
        loadData(false, true);
    }

    public final void loadPreData() {
        loadData(true, false);
    }

    public final boolean noDataLoad(boolean z10, boolean z11) {
        return ((z10 && checkCanLoadLeft()) || (z11 && checkCanLoadNextData())) ? false : true;
    }

    public final void readPostLimit(@NotNull String postLimitId, @Nullable String str) {
        s.i(postLimitId, "postLimitId");
        if (str != null) {
            Disposable disposed = NetworkClient.f11868a.l().i(postLimitId, str).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<Object, p>() { // from class: com.cupidapp.live.feed.viewmodel.PostLimitListViewModel$readPostLimit$$inlined$handle$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(Object obj) {
                    invoke2(obj);
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object obj) {
                }
            }), new e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.feed.viewmodel.PostLimitListViewModel$readPostLimit$2
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Boolean invoke(@NotNull Throwable it) {
                    s.i(it, "it");
                    return Boolean.TRUE;
                }
            }, null)));
            if (disposed != null) {
                s.h(disposed, "disposed");
            }
            s.h(disposed, "disposed");
            this.readList.add(str);
        }
    }

    public final void setCurrentSelectUserId(@Nullable String str) {
        this.currentSelectUserId = str;
    }

    public final void setDelAllMyPostLimit(boolean z10) {
        this.isDelAllMyPostLimit = z10;
    }

    public final void setUploadedPostLimit(boolean z10) {
        this.isUploadedPostLimit = z10;
    }

    public final void showViewerList(@NotNull String postLimitId) {
        s.i(postLimitId, "postLimitId");
        this._openViewerListEvent.setValue(new Event<>(postLimitId));
    }

    public final void uploadPostLimitSuc() {
        this.isUploadedPostLimit = true;
        Set<String> set = this.readList;
        User X = g.f52734a.X();
        z.a(set).remove(X != null ? X.userId() : null);
    }

    public final void uploadUserFocus(@NotNull User user) {
        User user2;
        Pair<List<List<PostLimitDetailModel>>, Integer> data;
        s.i(user, "user");
        StateResult<Pair<List<List<PostLimitDetailModel>>, Integer>> value = this._listLiveData.getValue();
        List<List<PostLimitDetailModel>> first = (value == null || (data = value.getData()) == null) ? null : data.getFirst();
        if (first != null) {
            Iterator<List<PostLimitDetailModel>> iterator2 = first.iterator2();
            while (true) {
                if (!iterator2.hasNext()) {
                    break;
                }
                List<PostLimitDetailModel> next = iterator2.next();
                PostLimitDetailModel postLimitDetailModel = (PostLimitDetailModel) CollectionsKt___CollectionsKt.V(next);
                if (s.d((postLimitDetailModel == null || (user2 = postLimitDetailModel.getUser()) == null) ? null : user2.userId(), user.userId())) {
                    for (PostLimitDetailModel postLimitDetailModel2 : next) {
                        User user3 = postLimitDetailModel2.getUser();
                        if (user3 != null) {
                            user3.setAloha(user.getAloha());
                        }
                        User user4 = postLimitDetailModel2.getUser();
                        if (user4 != null) {
                            user4.setMatch(user.getMatch());
                        }
                        User user5 = postLimitDetailModel2.getUser();
                        if (user5 != null) {
                            user5.setCanSendInboxMessage(user.getCanSendInboxMessage());
                        }
                    }
                }
            }
        }
        MutableLiveData<StateResult<Pair<List<List<PostLimitDetailModel>>, Integer>>> mutableLiveData = this._listLiveData;
        if (first == null) {
            first = new ArrayList<>();
        }
        mutableLiveData.setValue(new StateResult.c(new Pair(first, -1), null, 2, null));
    }
}

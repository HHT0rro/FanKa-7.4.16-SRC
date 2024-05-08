package com.cupidapp.live.feed.activity;

import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.cupidapp.live.base.fragment.FKBaseListFragment;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.model.ListResult;
import com.cupidapp.live.base.network.model.Result;
import com.cupidapp.live.base.network.model.ViewProfilePrefer;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewAdapter;
import com.cupidapp.live.base.recyclerview.decoration.MutableColumnDecoration;
import com.cupidapp.live.base.sensorslog.ProfileSensorContext;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.profile.activity.UserProfileActivity;
import com.cupidapp.live.profile.adapter.FeedLikedUserListAdapter;
import com.cupidapp.live.profile.holder.FeedLikedUserUiModel;
import com.cupidapp.live.profile.model.User;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import x2.a;

/* compiled from: FeedLikedUserListActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FeedLikedUserListFragment extends FKBaseListFragment<FeedLikedUserUiModel> {

    /* renamed from: k, reason: collision with root package name */
    @NotNull
    public static final a f14071k = new a(null);

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f14073j = new LinkedHashMap();

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    public final Lazy f14072i = kotlin.c.b(new Function0<FeedLikedUserListAdapter>() { // from class: com.cupidapp.live.feed.activity.FeedLikedUserListFragment$userListItemAdapter$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final FeedLikedUserListAdapter invoke() {
            FeedLikedUserListAdapter feedLikedUserListAdapter = new FeedLikedUserListAdapter();
            final FeedLikedUserListFragment feedLikedUserListFragment = FeedLikedUserListFragment.this;
            feedLikedUserListAdapter.l().g(new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.feed.activity.FeedLikedUserListFragment$userListItemAdapter$2$1$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ kotlin.p invoke(Object obj) {
                    invoke2(obj);
                    return kotlin.p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable Object obj) {
                    if (obj instanceof FeedLikedUserUiModel) {
                        FeedLikedUserListFragment.this.s1(((FeedLikedUserUiModel) obj).getUser());
                    }
                }
            });
            return feedLikedUserListAdapter;
        }
    });

    /* compiled from: FeedLikedUserListActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FeedLikedUserListFragment a(@NotNull String postId) {
            kotlin.jvm.internal.s.i(postId, "postId");
            FeedLikedUserListFragment feedLikedUserListFragment = new FeedLikedUserListFragment();
            Bundle bundle = new Bundle();
            bundle.putString("FEED_LIKED_FRAGMENT_POST_ID", postId);
            feedLikedUserListFragment.setArguments(bundle);
            return feedLikedUserListFragment;
        }
    }

    public static final Result r1(Function1 tmp0, Object obj) {
        kotlin.jvm.internal.s.i(tmp0, "$tmp0");
        return (Result) tmp0.invoke(obj);
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseListFragment, com.cupidapp.live.base.fragment.FKBaseFragment
    public void N0() {
        this.f14073j.clear();
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseListFragment
    @Nullable
    public View T0(int i10) {
        View findViewById;
        Map<Integer, View> map = this.f14073j;
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

    @Override // com.cupidapp.live.base.fragment.FKBaseListFragment
    public void Y0(@NotNull RecyclerView recyclerView) {
        kotlin.jvm.internal.s.i(recyclerView, "recyclerView");
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 3);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: com.cupidapp.live.feed.activity.FeedLikedUserListFragment$configRecyclerView$1$1
            @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
            public int getSpanSize(int i10) {
                FeedLikedUserListAdapter p12;
                p12 = FeedLikedUserListFragment.this.p1();
                return p12.u(i10);
            }
        });
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.addItemDecoration(new MutableColumnDecoration(p1(), z0.h.c(this, 10.0f)));
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseListFragment
    @NotNull
    public FKBaseRecyclerViewAdapter d1() {
        return p1();
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseListFragment
    @Nullable
    public Observable<Result<ListResult<FeedLikedUserUiModel>>> e1(@Nullable String str) {
        String string;
        Bundle arguments = getArguments();
        if (arguments == null || (string = arguments.getString("FEED_LIKED_FRAGMENT_POST_ID")) == null) {
            return null;
        }
        return q1(a.C0836a.d(NetworkClient.f11868a.N(), string, str, 0, 4, null));
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseListFragment, com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        N0();
    }

    public final FeedLikedUserListAdapter p1() {
        return (FeedLikedUserListAdapter) this.f14072i.getValue();
    }

    public final Observable<Result<ListResult<FeedLikedUserUiModel>>> q1(Observable<Result<ListResult<User>>> observable) {
        final FeedLikedUserListFragment$userListToFeedLikedUserUiModel$1 feedLikedUserListFragment$userListToFeedLikedUserUiModel$1 = new Function1<Result<? extends ListResult<User>>, Result<? extends ListResult<FeedLikedUserUiModel>>>() { // from class: com.cupidapp.live.feed.activity.FeedLikedUserListFragment$userListToFeedLikedUserUiModel$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Result<? extends ListResult<FeedLikedUserUiModel>> invoke(Result<? extends ListResult<User>> result) {
                return invoke2((Result<ListResult<User>>) result);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Result<ListResult<FeedLikedUserUiModel>> invoke2(@NotNull Result<ListResult<User>> it) {
                List list;
                List<User> list2;
                kotlin.jvm.internal.s.i(it, "it");
                ListResult<User> data = it.getData();
                if (data == null || (list2 = data.getList()) == null) {
                    list = null;
                } else {
                    ArrayList arrayList = new ArrayList(kotlin.collections.t.t(list2, 10));
                    for (User user : list2) {
                        arrayList.add(new FeedLikedUserUiModel(user, user.getAvatarImage(), user.getName(), user.getUserVipModel()));
                    }
                    list = CollectionsKt___CollectionsKt.z0(arrayList);
                }
                ListResult<User> data2 = it.getData();
                return new Result<>(new ListResult(list, data2 != null ? data2.getNextCursorId() : null), it.getSuccess(), it.getStatus(), it.getMessage(), it.getStyle(), it.getJumpUrl(), null, 64, null);
            }
        };
        Observable map = observable.map(new Function() { // from class: com.cupidapp.live.feed.activity.u
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Result r12;
                r12 = FeedLikedUserListFragment.r1(Function1.this, obj);
                return r12;
            }
        });
        kotlin.jvm.internal.s.h(map, "observable.map {\n       …l\n            )\n        }");
        return map;
    }

    public final void s1(User user) {
        UserProfileActivity.G.a(getContext(), user, new ProfileSensorContext(ViewProfilePrefer.FeedLikeToProfile.getValue(), null, user.getMe(), SensorPosition.Unknown, null, null), (r21 & 8) != 0 ? false : true, (r21 & 16) != 0 ? null : null, (r21 & 32) != 0 ? null : null, (r21 & 64) != 0 ? null : null, (r21 & 128) != 0 ? false : false);
    }
}

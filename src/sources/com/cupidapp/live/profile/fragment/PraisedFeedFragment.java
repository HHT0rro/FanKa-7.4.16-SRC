package com.cupidapp.live.profile.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.fragment.FKBaseListFragment;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.model.ListResult;
import com.cupidapp.live.base.network.model.Result;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewAdapter;
import com.cupidapp.live.base.recyclerview.model.FKEmptyViewModel;
import com.cupidapp.live.base.sensorslog.FeedSensorContext;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorScene;
import com.cupidapp.live.base.view.decoration.ProfileGridDecoration;
import com.cupidapp.live.feed.activity.FeedDetailListActivity;
import com.cupidapp.live.feed.model.FeedModel;
import com.cupidapp.live.track.group.GroupSocialLog;
import f2.a;
import io.reactivex.Observable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: PraisedFeedFragment.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class PraisedFeedFragment extends FKBaseListFragment<FeedModel> {

    /* renamed from: k, reason: collision with root package name */
    @NotNull
    public static final a f17766k = new a(null);

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f17768j = new LinkedHashMap();

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    public final Lazy f17767i = kotlin.c.b(new Function0<PraisedFeedAdapter>() { // from class: com.cupidapp.live.profile.fragment.PraisedFeedFragment$praisedFeedAdapter$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final PraisedFeedAdapter invoke() {
            final PraisedFeedAdapter praisedFeedAdapter = new PraisedFeedAdapter();
            final PraisedFeedFragment praisedFeedFragment = PraisedFeedFragment.this;
            praisedFeedAdapter.l().g(new Function1<Object, p>() { // from class: com.cupidapp.live.profile.fragment.PraisedFeedFragment$praisedFeedAdapter$2$1$1
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
                public final void invoke2(@Nullable Object obj) {
                    if (obj instanceof FeedModel) {
                        List<Object> j10 = PraisedFeedAdapter.this.j();
                        ArrayList arrayList = new ArrayList();
                        for (Object obj2 : j10) {
                            if (obj2 instanceof FeedModel) {
                                arrayList.add(obj2);
                            }
                        }
                        com.cupidapp.live.feed.helper.i iVar = new com.cupidapp.live.feed.helper.i(true, null, arrayList, arrayList.indexOf(obj), praisedFeedFragment.b1(), false, new Function1<String, Observable<Result<? extends ListResult<FeedModel>>>>() { // from class: com.cupidapp.live.profile.fragment.PraisedFeedFragment$praisedFeedAdapter$2$1$1$dataSource$1
                            @Override // kotlin.jvm.functions.Function1
                            @Nullable
                            public final Observable<Result<ListResult<FeedModel>>> invoke(@Nullable String str) {
                                return a.C0731a.c(NetworkClient.f11868a.l(), str, 0, 2, null);
                            }
                        });
                        SensorPosition sensorPosition = SensorPosition.PostStream;
                        SensorPosition sensorPosition2 = SensorPosition.PraisedFeed;
                        SensorPosition sensorPosition3 = SensorPosition.Setting;
                        SensorScene sensorScene = SensorScene.LikedPost;
                        FeedSensorContext feedSensorContext = new FeedSensorContext(sensorPosition, sensorPosition2, sensorPosition3, sensorScene);
                        Context context = praisedFeedFragment.getContext();
                        if (context != null) {
                            FeedDetailListActivity.f14060v.a(context, iVar, praisedFeedFragment.getString(R$string.follow_post), feedSensorContext, (r12 & 16) != 0 ? false : false);
                        }
                        GroupSocialLog.f18708a.u(sensorScene.getValue(), ((FeedModel) obj).getUser().userId(), (r13 & 4) != 0 ? null : null, (r13 & 8) != 0 ? false : false, (r13 & 16) != 0 ? null : null);
                    }
                }
            });
            return praisedFeedAdapter;
        }
    });

    /* compiled from: PraisedFeedFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final PraisedFeedFragment a() {
            return new PraisedFeedFragment();
        }
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseListFragment, com.cupidapp.live.base.fragment.FKBaseFragment
    public void N0() {
        this.f17768j.clear();
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseListFragment
    @Nullable
    public View T0(int i10) {
        View findViewById;
        Map<Integer, View> map = this.f17768j;
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
        s.i(recyclerView, "recyclerView");
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(m1().v(), 1));
        recyclerView.addItemDecoration(new ProfileGridDecoration(m1(), z0.h.c(this, 2.0f)));
        RecyclerView.ItemAnimator itemAnimator = recyclerView.getItemAnimator();
        SimpleItemAnimator simpleItemAnimator = itemAnimator instanceof SimpleItemAnimator ? (SimpleItemAnimator) itemAnimator : null;
        if (simpleItemAnimator == null) {
            return;
        }
        simpleItemAnimator.setSupportsChangeAnimations(false);
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseListFragment
    @Nullable
    public FKEmptyViewModel Z0() {
        return new FKEmptyViewModel(null, Integer.valueOf(R$string.empty_list_prompt), null, null, null, null, null, false, null, null, 1021, null);
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseListFragment
    @NotNull
    public FKBaseRecyclerViewAdapter d1() {
        return m1();
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseListFragment
    @Nullable
    public Observable<Result<ListResult<FeedModel>>> e1(@Nullable String str) {
        return a.C0731a.c(NetworkClient.f11868a.l(), str, 0, 2, null);
    }

    public final PraisedFeedAdapter m1() {
        return (PraisedFeedAdapter) this.f17767i.getValue();
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseListFragment, com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        N0();
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseListFragment, com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        s.i(view, "view");
        super.onViewCreated(view, bundle);
        i1(false);
    }
}

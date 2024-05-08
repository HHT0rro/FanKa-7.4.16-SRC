package com.cupidapp.live.profile.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.fragment.FKBaseListFragment;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.model.ListResult;
import com.cupidapp.live.base.network.model.Result;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewAdapter;
import com.cupidapp.live.base.recyclerview.model.FKEmptyViewModel;
import com.cupidapp.live.base.recyclerview.model.FKErrorViewModel;
import com.cupidapp.live.base.recyclerview.model.FKTitleUiModel;
import com.cupidapp.live.base.sensorslog.FKSensorContext;
import com.cupidapp.live.base.sensorslog.FeedSensorContext;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorScene;
import com.cupidapp.live.base.view.decoration.ProfileGridDecoration;
import com.cupidapp.live.feed.activity.FeedDetailListActivity;
import com.cupidapp.live.feed.model.FeedModel;
import com.cupidapp.live.track.group.GroupSocialLog;
import f2.a;
import io.reactivex.Observable;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.collections.i0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: PrivateFeedFragment.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class PrivateFeedFragment extends FKBaseListFragment<FeedModel> {

    /* renamed from: l, reason: collision with root package name */
    @NotNull
    public static final a f17769l = new a(null);

    /* renamed from: k, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f17772k = new LinkedHashMap();

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    public final Lazy f17770i = kotlin.c.b(new Function0<FKSensorContext>() { // from class: com.cupidapp.live.profile.fragment.PrivateFeedFragment$currentSensorContext$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final FKSensorContext invoke() {
            SensorPosition sensorPosition;
            SensorPosition sensorPosition2;
            Bundle arguments = PrivateFeedFragment.this.getArguments();
            Serializable serializable = arguments != null ? arguments.getSerializable("sensorContext") : null;
            FKSensorContext fKSensorContext = serializable instanceof FKSensorContext ? (FKSensorContext) serializable : null;
            SensorPosition sensorPosition3 = SensorPosition.PrivateFeed;
            if (fKSensorContext == null || (sensorPosition = fKSensorContext.getPosition()) == null) {
                sensorPosition = SensorPosition.Unknown;
            }
            if (fKSensorContext == null || (sensorPosition2 = fKSensorContext.getSource()) == null) {
                sensorPosition2 = SensorPosition.Unknown;
            }
            return new FKSensorContext(sensorPosition3, sensorPosition, sensorPosition2, SensorScene.Feed);
        }
    });

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    public final Lazy f17771j = kotlin.c.b(new Function0<PrivateFeedAdapter>() { // from class: com.cupidapp.live.profile.fragment.PrivateFeedFragment$privateFeedAdapter$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final PrivateFeedAdapter invoke() {
            final PrivateFeedAdapter privateFeedAdapter = new PrivateFeedAdapter();
            final PrivateFeedFragment privateFeedFragment = PrivateFeedFragment.this;
            privateFeedAdapter.l().g(new Function1<Object, p>() { // from class: com.cupidapp.live.profile.fragment.PrivateFeedFragment$privateFeedAdapter$2$1$1
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
                    FKSensorContext n12;
                    FKSensorContext n13;
                    if (obj instanceof FeedModel) {
                        List<Object> j10 = PrivateFeedAdapter.this.j();
                        ArrayList arrayList = new ArrayList();
                        for (Object obj2 : j10) {
                            if (obj2 instanceof FeedModel) {
                                arrayList.add(obj2);
                            }
                        }
                        com.cupidapp.live.feed.helper.i iVar = new com.cupidapp.live.feed.helper.i(false, new FKEmptyViewModel(Integer.valueOf(R$mipmap.icon_empty_lock), Integer.valueOf(R$string.empty_private_feed), null, null, null, null, null, false, null, null, 1020, null), arrayList, arrayList.indexOf(obj), privateFeedFragment.b1(), false, new Function1<String, Observable<Result<? extends ListResult<FeedModel>>>>() { // from class: com.cupidapp.live.profile.fragment.PrivateFeedFragment$privateFeedAdapter$2$1$1$dataSource$1
                            @Override // kotlin.jvm.functions.Function1
                            @Nullable
                            public final Observable<Result<ListResult<FeedModel>>> invoke(@Nullable String str) {
                                return a.C0731a.p(NetworkClient.f11868a.l(), str, 0, 2, null);
                            }
                        });
                        SensorPosition sensorPosition = SensorPosition.PostStream;
                        n12 = privateFeedFragment.n1();
                        SensorPosition position = n12.getPosition();
                        n13 = privateFeedFragment.n1();
                        SensorPosition source = n13.getSource();
                        SensorScene sensorScene = SensorScene.Feed;
                        FeedSensorContext feedSensorContext = new FeedSensorContext(sensorPosition, position, source, sensorScene);
                        Context context = privateFeedFragment.getContext();
                        if (context != null) {
                            FeedDetailListActivity.f14060v.a(context, iVar, privateFeedFragment.getString(R$string.my_private_feed), feedSensorContext, (r12 & 16) != 0 ? false : false);
                        }
                        GroupSocialLog.f18708a.u(sensorScene.getValue(), ((FeedModel) obj).getUser().userId(), (r13 & 4) != 0 ? null : null, (r13 & 8) != 0 ? false : false, (r13 & 16) != 0 ? null : null);
                    }
                }
            });
            privateFeedAdapter.l().j(i0.h(kotlin.f.a(Integer.valueOf(R$id.errorImg), new Function1<Object, p>() { // from class: com.cupidapp.live.profile.fragment.PrivateFeedFragment$privateFeedAdapter$2$1$2
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
                    if (obj instanceof FKErrorViewModel) {
                        PrivateFeedFragment.this.l1();
                    }
                }
            })));
            return privateFeedAdapter;
        }
    });

    /* compiled from: PrivateFeedFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final PrivateFeedFragment a(@Nullable FKSensorContext fKSensorContext) {
            PrivateFeedFragment privateFeedFragment = new PrivateFeedFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable("sensorContext", fKSensorContext);
            privateFeedFragment.setArguments(bundle);
            return privateFeedFragment;
        }
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseListFragment, com.cupidapp.live.base.fragment.FKBaseFragment
    public void N0() {
        this.f17772k.clear();
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseListFragment
    @Nullable
    public View T0(int i10) {
        View findViewById;
        Map<Integer, View> map = this.f17772k;
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
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(o1().v(), 1));
        recyclerView.addItemDecoration(new ProfileGridDecoration(o1(), z0.h.c(this, 2.0f)));
        RecyclerView.ItemAnimator itemAnimator = recyclerView.getItemAnimator();
        SimpleItemAnimator simpleItemAnimator = itemAnimator instanceof SimpleItemAnimator ? (SimpleItemAnimator) itemAnimator : null;
        if (simpleItemAnimator == null) {
            return;
        }
        simpleItemAnimator.setSupportsChangeAnimations(false);
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseListFragment
    @NotNull
    public FKEmptyViewModel Z0() {
        return new FKEmptyViewModel(Integer.valueOf(R$mipmap.icon_empty_lock), Integer.valueOf(R$string.empty_private_feed), null, null, null, null, null, false, null, null, 1020, null);
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseListFragment
    @NotNull
    public FKErrorViewModel a1() {
        return new FKErrorViewModel(Integer.valueOf(R$mipmap.ic_error_refresh), 2131887526, null, null, null, 28, null);
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseListFragment
    @NotNull
    public FKBaseRecyclerViewAdapter d1() {
        return o1();
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseListFragment
    @NotNull
    public Observable<Result<ListResult<FeedModel>>> e1(@Nullable String str) {
        return a.C0731a.p(NetworkClient.f11868a.l(), str, 0, 2, null);
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseListFragment
    @NotNull
    public FKTitleUiModel h1() {
        return new FKTitleUiModel(getString(R$string.private_feed_tip));
    }

    public final FKSensorContext n1() {
        return (FKSensorContext) this.f17770i.getValue();
    }

    public final PrivateFeedAdapter o1() {
        return (PrivateFeedAdapter) this.f17771j.getValue();
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
        i1(true);
    }
}

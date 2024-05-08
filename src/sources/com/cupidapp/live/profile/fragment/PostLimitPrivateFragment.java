package com.cupidapp.live.profile.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.fragment.FKBaseListFragment;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.model.ListResult;
import com.cupidapp.live.base.network.model.Result;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewAdapter;
import com.cupidapp.live.base.recyclerview.decoration.MutableColumnDecoration;
import com.cupidapp.live.base.recyclerview.model.FKEmptyViewModel;
import com.cupidapp.live.base.recyclerview.model.FKErrorViewModel;
import com.cupidapp.live.base.recyclerview.model.FKTitleUiModel;
import com.cupidapp.live.base.sensorslog.FKSensorContext;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorsLogFeed;
import com.cupidapp.live.feed.activity.PostLimitDetailActivity;
import com.cupidapp.live.feed.model.PostLimitDetailModel;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.track.group.GroupOthersLog;
import f2.a;
import io.reactivex.Observable;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedHashMap;
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

/* compiled from: PostLimitPrivateFragment.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class PostLimitPrivateFragment extends FKBaseListFragment<PostLimitDetailModel> {

    /* renamed from: m, reason: collision with root package name */
    @NotNull
    public static final a f17760m = new a(null);

    /* renamed from: l, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f17764l = new LinkedHashMap();

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    public final Lazy f17761i = kotlin.c.b(new Function0<FKSensorContext>() { // from class: com.cupidapp.live.profile.fragment.PostLimitPrivateFragment$sensorContext$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final FKSensorContext invoke() {
            SensorPosition sensorPosition;
            Bundle arguments = PostLimitPrivateFragment.this.getArguments();
            Serializable serializable = arguments != null ? arguments.getSerializable("sensorContext") : null;
            FKSensorContext fKSensorContext = serializable instanceof FKSensorContext ? (FKSensorContext) serializable : null;
            SensorPosition sensorPosition2 = SensorPosition.PostLimitPrivate;
            if (fKSensorContext == null || (sensorPosition = fKSensorContext.getPosition()) == null) {
                sensorPosition = SensorPosition.Unknown;
            }
            return new FKSensorContext(sensorPosition2, sensorPosition, fKSensorContext != null ? fKSensorContext.getSource() : null, fKSensorContext != null ? fKSensorContext.getScene() : null);
        }
    });

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    public final Lazy f17762j = kotlin.c.b(new Function0<PostLimitPrivateAdapter>() { // from class: com.cupidapp.live.profile.fragment.PostLimitPrivateFragment$postPrivateAdapter$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final PostLimitPrivateAdapter invoke() {
            PostLimitPrivateAdapter postLimitPrivateAdapter = new PostLimitPrivateAdapter();
            final PostLimitPrivateFragment postLimitPrivateFragment = PostLimitPrivateFragment.this;
            postLimitPrivateAdapter.l().g(new Function1<Object, p>() { // from class: com.cupidapp.live.profile.fragment.PostLimitPrivateFragment$postPrivateAdapter$2$1$1
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
                    FKSensorContext p12;
                    FKSensorContext p13;
                    if (obj instanceof PostLimitDetailModel) {
                        PostLimitDetailActivity.a aVar = PostLimitDetailActivity.f14091t;
                        PostLimitPrivateFragment postLimitPrivateFragment2 = PostLimitPrivateFragment.this;
                        PostLimitDetailModel postLimitDetailModel = (PostLimitDetailModel) obj;
                        p12 = postLimitPrivateFragment2.p1();
                        aVar.a(postLimitPrivateFragment2, postLimitDetailModel, p12);
                        SensorsLogFeed sensorsLogFeed = SensorsLogFeed.f12208a;
                        p13 = PostLimitPrivateFragment.this.p1();
                        SensorPosition position = p13.getPosition();
                        User user = postLimitDetailModel.getUser();
                        sensorsLogFeed.t(position, user != null ? user.userId() : null, (r16 & 4) != 0 ? null : null, (r16 & 8) != 0 ? null : null, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? null : postLimitDetailModel.getId());
                    }
                }
            });
            postLimitPrivateAdapter.l().j(i0.h(kotlin.f.a(Integer.valueOf(R$id.errorImg), new Function1<Object, p>() { // from class: com.cupidapp.live.profile.fragment.PostLimitPrivateFragment$postPrivateAdapter$2$1$2
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
                        PostLimitPrivateFragment.this.l1();
                    }
                }
            })));
            return postLimitPrivateAdapter;
        }
    });

    /* renamed from: k, reason: collision with root package name */
    @NotNull
    public final Lazy f17763k = kotlin.c.b(new Function0<String>() { // from class: com.cupidapp.live.profile.fragment.PostLimitPrivateFragment$userId$2
        @Override // kotlin.jvm.functions.Function0
        @Nullable
        public final String invoke() {
            User X = p1.g.f52734a.X();
            if (X != null) {
                return X.userId();
            }
            return null;
        }
    });

    /* compiled from: PostLimitPrivateFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final PostLimitPrivateFragment a(@Nullable FKSensorContext fKSensorContext) {
            PostLimitPrivateFragment postLimitPrivateFragment = new PostLimitPrivateFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable("sensorContext", fKSensorContext);
            postLimitPrivateFragment.setArguments(bundle);
            return postLimitPrivateFragment;
        }
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseListFragment, com.cupidapp.live.base.fragment.FKBaseFragment
    public void N0() {
        this.f17764l.clear();
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment
    @NotNull
    public SensorPosition O0() {
        return SensorPosition.PostLimitPrivate;
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseListFragment
    @Nullable
    public View T0(int i10) {
        View findViewById;
        Map<Integer, View> map = this.f17764l;
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
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), o1().v());
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: com.cupidapp.live.profile.fragment.PostLimitPrivateFragment$configRecyclerView$1$1
            @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
            public int getSpanSize(int i10) {
                PostLimitPrivateAdapter o12;
                o12 = PostLimitPrivateFragment.this.o1();
                return o12.u(i10);
            }
        });
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.addItemDecoration(new MutableColumnDecoration(o1(), z0.h.c(this, 4.0f)));
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseListFragment
    @NotNull
    public FKEmptyViewModel Z0() {
        return new FKEmptyViewModel(Integer.valueOf(R$mipmap.icon_empty_lock), Integer.valueOf(R$string.empty_private_post), null, null, null, null, null, false, null, null, 1020, null);
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
    public Observable<Result<ListResult<PostLimitDetailModel>>> e1(@Nullable String str) {
        return a.C0731a.n(NetworkClient.f11868a.l(), true, q1(), str, 0, 8, null);
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseListFragment
    @NotNull
    public FKTitleUiModel h1() {
        return new FKTitleUiModel(getString(R$string.private_post_tip));
    }

    public final PostLimitPrivateAdapter o1() {
        return (PostLimitPrivateAdapter) this.f17762j.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i10, int i11, @Nullable Intent intent) {
        super.onActivityResult(i10, i11, intent);
        if (i10 == 522 && i11 == -1) {
            Object obj = null;
            String stringExtra = intent != null ? intent.getStringExtra("postLimitId") : null;
            Iterator<Object> iterator2 = o1().j().iterator2();
            while (true) {
                if (!iterator2.hasNext()) {
                    break;
                }
                Object next = iterator2.next();
                if ((next instanceof PostLimitDetailModel) && s.d(((PostLimitDetailModel) next).getId(), stringExtra)) {
                    obj = next;
                    break;
                }
            }
            if (obj != null) {
                o1().j().remove(obj);
                o1().notifyDataSetChanged();
            }
        }
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
        GroupOthersLog.d(GroupOthersLog.f18702a, O0().getValue(), null, p1().getSource().getValue(), 2, null);
    }

    public final FKSensorContext p1() {
        return (FKSensorContext) this.f17761i.getValue();
    }

    public final String q1() {
        return (String) this.f17763k.getValue();
    }
}

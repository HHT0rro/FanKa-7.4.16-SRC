package com.cupidapp.live.profile.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.utils.RegionNodeModel;
import com.cupidapp.live.base.utils.m0;
import com.cupidapp.live.base.view.FKTitleBarLayout;
import com.cupidapp.live.profile.adapter.PlaceLocationAdapter;
import com.cupidapp.live.profile.model.ProfileSpecListModel;
import com.huawei.appgallery.agd.common.utils.StringUtils;
import com.huawei.hms.mlsdk.common.AgConnectInfo;
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

/* compiled from: ProfileLocationActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class ProfileLocationActivity extends FKBaseProfileSpecActivity {

    /* renamed from: z, reason: collision with root package name */
    @NotNull
    public static final a f17657z = new a(null);

    /* renamed from: w, reason: collision with root package name */
    @Nullable
    public Map<String, RegionNodeModel> f17659w;

    /* renamed from: x, reason: collision with root package name */
    @Nullable
    public List<String> f17660x;

    /* renamed from: y, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f17661y = new LinkedHashMap();

    /* renamed from: v, reason: collision with root package name */
    @NotNull
    public final Lazy f17658v = kotlin.c.b(new Function0<PlaceLocationAdapter>() { // from class: com.cupidapp.live.profile.activity.ProfileLocationActivity$placeLocationAdapter$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final PlaceLocationAdapter invoke() {
            PlaceLocationAdapter placeLocationAdapter = new PlaceLocationAdapter();
            final ProfileLocationActivity profileLocationActivity = ProfileLocationActivity.this;
            placeLocationAdapter.l().g(new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.profile.activity.ProfileLocationActivity$placeLocationAdapter$2$1$1
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
                    if (obj instanceof String) {
                        ProfileLocationActivity.this.t1((String) obj);
                    }
                }
            });
            return placeLocationAdapter;
        }
    });

    /* compiled from: ProfileLocationActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Activity activity, @NotNull String region, @Nullable String str) {
            kotlin.jvm.internal.s.i(activity, "activity");
            kotlin.jvm.internal.s.i(region, "region");
            Intent intent = new Intent(activity, (Class<?>) ProfileLocationActivity.class);
            intent.putExtra(AgConnectInfo.AgConnectKey.REGION, region);
            intent.putExtra("PROFILE_SPEC_ID_BUNDLE_KEY", str);
            activity.startActivityForResult(intent, 1);
            FKBaseActivity.a.c(FKBaseActivity.f11750o, activity, 0, 0, 6, null);
        }
    }

    @Nullable
    public View n1(int i10) {
        Map<Integer, View> map = this.f17661y;
        View view = map.get(Integer.valueOf(i10));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i10);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i10), findViewById);
        return findViewById;
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, @Nullable Intent intent) {
        super.onActivityResult(i10, i11, intent);
        if (i10 == 1) {
            finish();
        }
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_profile_location);
        s1();
        p1();
        r1();
    }

    public final void p1() {
        ((FKTitleBarLayout) n1(R$id.profileLocationTitleLayout)).setLeftImageClickEvent(new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.profile.activity.ProfileLocationActivity$bindClickEvent$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(View view) {
                invoke2(view);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
                ProfileLocationActivity.this.finish();
            }
        });
    }

    public final PlaceLocationAdapter q1() {
        return (PlaceLocationAdapter) this.f17658v.getValue();
    }

    public final void r1() {
        Map<String, RegionNodeModel> regions;
        m0 m0Var = new m0(this);
        String stringExtra = getIntent().getStringExtra(AgConnectInfo.AgConnectKey.REGION);
        if (stringExtra == null) {
            regions = m0Var.c();
        } else {
            RegionNodeModel a10 = m0Var.a(stringExtra);
            if (a10 == null || (regions = a10.getRegions()) == null) {
                return;
            }
        }
        this.f17659w = regions;
        kotlin.jvm.internal.s.f(regions);
        List<String> z02 = CollectionsKt___CollectionsKt.z0(regions.h());
        this.f17660x = z02;
        kotlin.jvm.internal.s.f(z02);
        kotlin.collections.w.v(z02);
        ArrayList arrayList = new ArrayList();
        List<String> list = this.f17660x;
        kotlin.jvm.internal.s.f(list);
        for (String str : list) {
            Map<String, RegionNodeModel> map = this.f17659w;
            kotlin.jvm.internal.s.f(map);
            RegionNodeModel regionNodeModel = map.get(str);
            Map<String, RegionNodeModel> regions2 = regionNodeModel != null ? regionNodeModel.getRegions() : null;
            if (!(regions2 == null || regions2.isEmpty())) {
                kotlin.jvm.internal.s.f(regionNodeModel);
                arrayList.add(regionNodeModel.getName() + StringUtils.NO_PRINT_CODE);
            } else {
                kotlin.jvm.internal.s.f(regionNodeModel);
                arrayList.add(regionNodeModel.getName());
            }
        }
        q1().e(arrayList);
        q1().notifyDataSetChanged();
    }

    public final void s1() {
        FKTitleBarLayout profileLocationTitleLayout = (FKTitleBarLayout) n1(R$id.profileLocationTitleLayout);
        kotlin.jvm.internal.s.h(profileLocationTitleLayout, "profileLocationTitleLayout");
        ProfileSpecListModel k12 = k1();
        FKTitleBarLayout.setSingleTitle$default(profileLocationTitleLayout, k12 != null ? k12.getName() : null, null, 2, null);
        RecyclerView recyclerView = (RecyclerView) n1(R$id.profileLocationRecyclerView);
        recyclerView.setAdapter(q1());
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
    }

    public final void t1(String str) {
        if (q1().j().contains(str)) {
            int indexOf = q1().j().indexOf(str);
            List<String> list = this.f17660x;
            kotlin.jvm.internal.s.f(list);
            String str2 = list.get(indexOf);
            Map<String, RegionNodeModel> map = this.f17659w;
            kotlin.jvm.internal.s.f(map);
            RegionNodeModel regionNodeModel = map.get(str2);
            Map<String, RegionNodeModel> regions = regionNodeModel != null ? regionNodeModel.getRegions() : null;
            if (regions == null || regions.isEmpty()) {
                m1(kotlin.collections.r.e(str2));
                finish();
            } else {
                f17657z.a(this, str2, l1());
            }
        }
    }
}

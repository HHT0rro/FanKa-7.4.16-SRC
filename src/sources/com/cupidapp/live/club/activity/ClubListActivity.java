package com.cupidapp.live.club.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.cupidapp.live.R$color;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.network.model.ConstantsResult;
import com.cupidapp.live.base.network.model.ConstantsUrlModel;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.view.FKRecyclerTitleLayout;
import com.cupidapp.live.base.view.FKTitleViewModel;
import com.cupidapp.live.base.view.TitleConfigModel;
import com.cupidapp.live.base.view.TitleIndicatorModel;
import com.cupidapp.live.base.web.fragment.FKWebViewFragment;
import com.cupidapp.live.club.adapter.ClubListPagerAdapter;
import com.cupidapp.live.club.fragment.ActivityListFragment;
import com.cupidapp.live.club.fragment.ClubListFragment;
import j1.c;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.s;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.g;
import z0.y;

/* compiled from: ClubListActivity.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ClubListActivity extends FKBaseActivity {

    /* renamed from: s, reason: collision with root package name */
    @NotNull
    public static final a f13485s = new a(null);

    /* renamed from: r, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f13487r = new LinkedHashMap();

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    public final List<String> f13486q = s.o(ClubListFragment.class.getSimpleName(), ActivityListFragment.class.getSimpleName());

    /* compiled from: ClubListActivity.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void b(a aVar, Context context, int i10, SensorPosition sensorPosition, int i11, Object obj) {
            if ((i11 & 2) != 0) {
                i10 = 0;
            }
            if ((i11 & 4) != 0) {
                sensorPosition = null;
            }
            aVar.a(context, i10, sensorPosition);
        }

        public final void a(@Nullable Context context, int i10, @Nullable SensorPosition sensorPosition) {
            Intent intent = new Intent(context, (Class<?>) ClubListActivity.class);
            intent.putExtra("PAGE_INDEX", i10);
            if (sensorPosition != null) {
                g.c(intent, sensorPosition);
            }
            if (context != null) {
                context.startActivity(intent);
            }
            FKBaseActivity.a.c(FKBaseActivity.f11750o, context, 0, 0, 6, null);
        }
    }

    public static /* synthetic */ void m1(ClubListActivity clubListActivity, int i10, SensorPosition sensorPosition, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            sensorPosition = null;
        }
        clubListActivity.l1(i10, sensorPosition);
    }

    @Nullable
    public View j1(int i10) {
        Map<Integer, View> map = this.f13487r;
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

    public final void l1(int i10, SensorPosition sensorPosition) {
        SensorPosition sensorPosition2;
        if (i10 == 0) {
            sensorPosition2 = SensorPosition.ClubList;
        } else if (i10 != 1) {
            sensorPosition2 = SensorPosition.ClubRank;
        } else {
            sensorPosition2 = SensorPosition.ClubActivity;
        }
        c.b(c.f50228a, sensorPosition2, null, sensorPosition != null ? sensorPosition.getValue() : null, 2, null);
    }

    public final void n1() {
        ((FKRecyclerTitleLayout) j1(R$id.club_list_title_layout)).setTitleClickListener(new Function2<Integer, FKTitleViewModel, p>() { // from class: com.cupidapp.live.club.activity.ClubListActivity$bindClickEvent$1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: invoke */
            public /* bridge */ /* synthetic */ p mo1743invoke(Integer num, FKTitleViewModel fKTitleViewModel) {
                invoke(num.intValue(), fKTitleViewModel);
                return p.f51048a;
            }

            public final void invoke(int i10, @NotNull FKTitleViewModel fKTitleViewModel) {
                kotlin.jvm.internal.s.i(fKTitleViewModel, "<anonymous parameter 1>");
                ClubListActivity.this.o1(i10);
                ((ViewPager2) ClubListActivity.this.j1(R$id.club_viewpager)).setCurrentItem(i10);
                ClubListActivity.m1(ClubListActivity.this, i10, null, 2, null);
            }
        });
        ImageView back_imageView = (ImageView) j1(R$id.back_imageView);
        kotlin.jvm.internal.s.h(back_imageView, "back_imageView");
        y.d(back_imageView, new Function1<View, p>() { // from class: com.cupidapp.live.club.activity.ClubListActivity$bindClickEvent$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(View view) {
                invoke2(view);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
                ClubListActivity.this.finish();
            }
        });
    }

    public final void o1(int i10) {
        if (i10 == 2) {
            ((ConstraintLayout) j1(R$id.club_root_layout)).setBackgroundResource(R$color.color_FEF9ED);
        } else {
            ((ConstraintLayout) j1(R$id.club_root_layout)).setBackgroundResource(0);
        }
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_club_list);
        RelativeLayout club_title_layout = (RelativeLayout) j1(R$id.club_title_layout);
        kotlin.jvm.internal.s.h(club_title_layout, "club_title_layout");
        com.cupidapp.live.base.view.s.b(this, club_title_layout);
        p1();
        q1();
        n1();
    }

    public final void p1() {
        ConstantsUrlModel urlModel;
        ArrayList arrayList = new ArrayList();
        TitleConfigModel titleConfigModel = new TitleConfigModel(18.0f, -15066598, true);
        TitleConfigModel titleConfigModel2 = new TitleConfigModel(18.0f, -15066598, false);
        TitleIndicatorModel titleIndicatorModel = new TitleIndicatorModel(-15066598, 20.0f, 2.0f);
        String string = getString(R$string.club);
        kotlin.jvm.internal.s.h(string, "getString(R.string.club)");
        FKTitleViewModel fKTitleViewModel = new FKTitleViewModel(string, titleConfigModel, titleConfigModel2, titleIndicatorModel, false, 16, null);
        String string2 = getString(R$string.activity);
        kotlin.jvm.internal.s.h(string2, "getString(R.string.activity)");
        FKTitleViewModel fKTitleViewModel2 = new FKTitleViewModel(string2, titleConfigModel, titleConfigModel2, titleIndicatorModel, false, 16, null);
        arrayList.add(fKTitleViewModel);
        arrayList.add(fKTitleViewModel2);
        ConstantsResult q10 = p1.g.f52734a.q();
        String clubRankListUrl = (q10 == null || (urlModel = q10.getUrlModel()) == null) ? null : urlModel.getClubRankListUrl();
        if (!(clubRankListUrl == null || clubRankListUrl.length() == 0)) {
            String string3 = getString(R$string.ranking_list);
            kotlin.jvm.internal.s.h(string3, "getString(R.string.ranking_list)");
            arrayList.add(new FKTitleViewModel(string3, titleConfigModel, titleConfigModel2, titleIndicatorModel, false, 16, null));
            this.f13486q.add(FKWebViewFragment.class.getSimpleName());
        }
        FKRecyclerTitleLayout club_list_title_layout = (FKRecyclerTitleLayout) j1(R$id.club_list_title_layout);
        kotlin.jvm.internal.s.h(club_list_title_layout, "club_list_title_layout");
        FKRecyclerTitleLayout.d(club_list_title_layout, arrayList, 0, 2, null);
    }

    public final void q1() {
        int i10 = R$id.club_viewpager;
        ViewPager2 viewPager2 = (ViewPager2) j1(i10);
        viewPager2.setAdapter(new ClubListPagerAdapter(this, this.f13486q));
        viewPager2.setUserInputEnabled(false);
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() { // from class: com.cupidapp.live.club.activity.ClubListActivity$initViewPager$1$1
            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageSelected(int i11) {
                ((FKRecyclerTitleLayout) ClubListActivity.this.j1(R$id.club_list_title_layout)).g(i11);
            }
        });
        int intExtra = getIntent().getIntExtra("PAGE_INDEX", 0);
        ((ViewPager2) j1(i10)).setCurrentItem(intExtra, false);
        Intent intent = getIntent();
        kotlin.jvm.internal.s.h(intent, "intent");
        l1(intExtra, (SensorPosition) g.a(intent, SensorPosition.class));
    }
}

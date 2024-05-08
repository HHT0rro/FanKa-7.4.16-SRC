package com.cupidapp.live.liveshow.view.liveinfo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.viewpager2.widget.ViewPager2;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewAdapter;
import com.cupidapp.live.base.recyclerview.FKLoopScrollLayout;
import com.cupidapp.live.base.sensorslog.SensorLogActivity;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.view.RoundedFrameLayout;
import com.cupidapp.live.base.view.indicator.PagerIndicatorLayout;
import com.cupidapp.live.liveshow.activity.FKLiveOpenWebFragmentEvent;
import com.cupidapp.live.liveshow.model.BadgeModel;
import com.huawei.uikit.hwcommon.anim.HwCubicBezierInterpolator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;
import z0.z;

/* compiled from: FKLiveShowAdLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLiveShowAdLayout extends FKLoopScrollLayout {

    /* renamed from: l, reason: collision with root package name */
    public boolean f15717l;

    /* renamed from: m, reason: collision with root package name */
    public final long f15718m;

    /* renamed from: n, reason: collision with root package name */
    @NotNull
    public final FKBaseRecyclerViewAdapter f15719n;

    /* renamed from: o, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f15720o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveShowAdLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f15720o = new LinkedHashMap();
        this.f15718m = HwCubicBezierInterpolator.f34870a;
        FKLiveShowAdAdapter fKLiveShowAdAdapter = new FKLiveShowAdAdapter();
        fKLiveShowAdAdapter.l().g(new Function1<Object, p>() { // from class: com.cupidapp.live.liveshow.view.liveinfo.FKLiveShowAdLayout$adapter$1$1
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
                if (obj instanceof BadgeModel) {
                    BadgeModel badgeModel = (BadgeModel) obj;
                    EventBus.c().l(new FKLiveOpenWebFragmentEvent(badgeModel.getUrl(), false, 2, null));
                    FKLiveShowAdLayout.this.t(badgeModel.getUrl());
                }
            }
        });
        this.f15719n = fKLiveShowAdAdapter;
        k();
    }

    @Override // com.cupidapp.live.base.recyclerview.FKLoopScrollLayout
    @NotNull
    public FKBaseRecyclerViewAdapter getAdapter() {
        return this.f15719n;
    }

    @Override // com.cupidapp.live.base.recyclerview.FKLoopScrollLayout
    public long getPagerLife() {
        return this.f15718m;
    }

    @Override // com.cupidapp.live.base.recyclerview.FKLoopScrollLayout
    public void j() {
        z.a(this, R$layout.layout_live_show_ad, true);
        ViewPager2 live_show_ad_viewpager = (ViewPager2) q(R$id.live_show_ad_viewpager);
        s.h(live_show_ad_viewpager, "live_show_ad_viewpager");
        setViewPager(live_show_ad_viewpager);
        ((RoundedFrameLayout) q(R$id.ad_container_layout)).setCornerRadius(h.c(this, 10.0f));
    }

    @Override // com.cupidapp.live.base.recyclerview.FKLoopScrollLayout
    public void m(int i10) {
        if (getAdapter().n() == 1) {
            u(0);
        } else {
            if (i10 <= 0 || i10 >= getAdapter().n() - 1) {
                return;
            }
            ((PagerIndicatorLayout) q(R$id.live_show_ad_indicator)).setCurrentPager(i10 - 1);
            u(i10);
        }
    }

    @Nullable
    public View q(int i10) {
        Map<Integer, View> map = this.f15720o;
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

    public final void s(@Nullable List<BadgeModel> list, boolean z10) {
        BadgeModel badgeModel;
        this.f15717l = z10;
        int i10 = 0;
        if (list == null || list.isEmpty()) {
            setVisibility(8);
            p();
            return;
        }
        setVisibility(0);
        int size = getAdapter().j().size();
        if (size > 1) {
            size -= 2;
        }
        if (list.size() != size) {
            getAdapter().j().clear();
            if (list.size() > 1) {
                getAdapter().d(CollectionsKt___CollectionsKt.e0(list));
                getAdapter().e(list);
                getAdapter().d(CollectionsKt___CollectionsKt.T(list));
            } else {
                getAdapter().e(list);
            }
            getAdapter().notifyDataSetChanged();
            ((PagerIndicatorLayout) q(R$id.live_show_ad_indicator)).setPagerCount(list.size());
            getViewPager().setCurrentItem(list.size() <= 1 ? 0 : 1, false);
            o();
            return;
        }
        for (Object obj : getAdapter().j()) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                kotlin.collections.s.s();
            }
            if (i10 == 0) {
                badgeModel = (BadgeModel) CollectionsKt___CollectionsKt.e0(list);
            } else {
                badgeModel = i10 == getAdapter().n() - 1 ? (BadgeModel) CollectionsKt___CollectionsKt.T(list) : list.get(i10 - 1);
            }
            if (!s.d(obj, badgeModel)) {
                getAdapter().j().set(i10, badgeModel);
                getAdapter().notifyItemChanged(i10);
            }
            i10 = i11;
        }
    }

    public final void t(String str) {
        SensorLogActivity.f12204a.a((this.f15717l ? SensorPosition.LiveShowRoom : SensorPosition.AnchorLiveShowRoom).getValue(), str, SensorLogActivity.Type.LIVE_SHOW_AD.getType());
    }

    public final void u(int i10) {
        Object obj = getAdapter().j().get(i10);
        BadgeModel badgeModel = obj instanceof BadgeModel ? (BadgeModel) obj : null;
        SensorLogActivity.f12204a.b((this.f15717l ? SensorPosition.LiveShowRoom : SensorPosition.AnchorLiveShowRoom).getValue(), badgeModel != null ? badgeModel.getUrl() : null, SensorLogActivity.Type.LIVE_SHOW_AD.getType());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveShowAdLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f15720o = new LinkedHashMap();
        this.f15718m = HwCubicBezierInterpolator.f34870a;
        FKLiveShowAdAdapter fKLiveShowAdAdapter = new FKLiveShowAdAdapter();
        fKLiveShowAdAdapter.l().g(new Function1<Object, p>() { // from class: com.cupidapp.live.liveshow.view.liveinfo.FKLiveShowAdLayout$adapter$1$1
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
                if (obj instanceof BadgeModel) {
                    BadgeModel badgeModel = (BadgeModel) obj;
                    EventBus.c().l(new FKLiveOpenWebFragmentEvent(badgeModel.getUrl(), false, 2, null));
                    FKLiveShowAdLayout.this.t(badgeModel.getUrl());
                }
            }
        });
        this.f15719n = fKLiveShowAdAdapter;
        k();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveShowAdLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f15720o = new LinkedHashMap();
        this.f15718m = HwCubicBezierInterpolator.f34870a;
        FKLiveShowAdAdapter fKLiveShowAdAdapter = new FKLiveShowAdAdapter();
        fKLiveShowAdAdapter.l().g(new Function1<Object, p>() { // from class: com.cupidapp.live.liveshow.view.liveinfo.FKLiveShowAdLayout$adapter$1$1
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
                if (obj instanceof BadgeModel) {
                    BadgeModel badgeModel = (BadgeModel) obj;
                    EventBus.c().l(new FKLiveOpenWebFragmentEvent(badgeModel.getUrl(), false, 2, null));
                    FKLiveShowAdLayout.this.t(badgeModel.getUrl());
                }
            }
        });
        this.f15719n = fKLiveShowAdAdapter;
        k();
    }
}

package com.cupidapp.live.consult.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.viewpager2.widget.ViewPager2;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewAdapter;
import com.cupidapp.live.base.recyclerview.FKLoopScrollLayout;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.view.indicator.PagerIndicatorLayout;
import com.cupidapp.live.consult.model.ConsultBannerModel;
import com.cupidapp.live.track.group.GroupOthersLog;
import com.huawei.uikit.hwcommon.anim.HwCubicBezierInterpolator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: ConsultBannerLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ConsultBannerLayout extends FKLoopScrollLayout {

    /* renamed from: l, reason: collision with root package name */
    public final long f13840l;

    /* renamed from: m, reason: collision with root package name */
    @NotNull
    public final FKBaseRecyclerViewAdapter f13841m;

    /* renamed from: n, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f13842n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConsultBannerLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f13842n = new LinkedHashMap();
        this.f13840l = HwCubicBezierInterpolator.f34870a;
        ConsultBannerAdapter consultBannerAdapter = new ConsultBannerAdapter();
        consultBannerAdapter.l().g(new Function1<Object, p>() { // from class: com.cupidapp.live.consult.view.ConsultBannerLayout$adapter$1$1
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
                if (obj instanceof ConsultBannerModel) {
                    ConsultBannerModel consultBannerModel = (ConsultBannerModel) obj;
                    j.a.b(j.f12156c, ConsultBannerLayout.this.getContext(), consultBannerModel.getJumpUrl(), null, 4, null);
                    ConsultBannerLayout.this.t(consultBannerModel);
                }
            }
        });
        this.f13841m = consultBannerAdapter;
        k();
    }

    @Override // com.cupidapp.live.base.recyclerview.FKLoopScrollLayout
    @NotNull
    public FKBaseRecyclerViewAdapter getAdapter() {
        return this.f13841m;
    }

    @Override // com.cupidapp.live.base.recyclerview.FKLoopScrollLayout
    public long getPagerLife() {
        return this.f13840l;
    }

    @Override // com.cupidapp.live.base.recyclerview.FKLoopScrollLayout
    public void j() {
        z.a(this, R$layout.layout_consult_banner, true);
        ViewPager2 consult_banner_viewpager = (ViewPager2) q(R$id.consult_banner_viewpager);
        s.h(consult_banner_viewpager, "consult_banner_viewpager");
        setViewPager(consult_banner_viewpager);
    }

    @Override // com.cupidapp.live.base.recyclerview.FKLoopScrollLayout
    public void m(int i10) {
        if (i10 <= 0 || i10 >= getAdapter().n() - 1) {
            return;
        }
        ((PagerIndicatorLayout) q(R$id.consult_banner_indicator)).setCurrentPager(i10 - 1);
        u(i10);
    }

    @Override // com.cupidapp.live.base.view.BaseLayout, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        o();
    }

    @Nullable
    public View q(int i10) {
        Map<Integer, View> map = this.f13842n;
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

    public final void s(@Nullable List<ConsultBannerModel> list) {
        if (list == null || list.isEmpty()) {
            getAdapter().j().clear();
            getAdapter().notifyDataSetChanged();
            p();
            setVisibility(8);
            return;
        }
        setVisibility(0);
        getAdapter().j().clear();
        if (list.size() == 1) {
            getAdapter().e(list);
            u(0);
        } else {
            getAdapter().d(CollectionsKt___CollectionsKt.e0(list));
            getAdapter().e(list);
            getAdapter().d(CollectionsKt___CollectionsKt.T(list));
        }
        getAdapter().notifyDataSetChanged();
        ((PagerIndicatorLayout) q(R$id.consult_banner_indicator)).setPagerCount(list.size());
        if (list.size() > 1) {
            if (getViewPager().getCurrentItem() == 1) {
                u(1);
            }
            getViewPager().setCurrentItem(1, false);
        }
        o();
    }

    public final void t(ConsultBannerModel consultBannerModel) {
        GroupOthersLog.j(GroupOthersLog.f18702a, consultBannerModel.getItemId(), SensorPosition.ConsultList, null, 4, null);
    }

    public final void u(int i10) {
        Object obj = getAdapter().j().get(i10);
        ConsultBannerModel consultBannerModel = obj instanceof ConsultBannerModel ? (ConsultBannerModel) obj : null;
        GroupOthersLog.l(GroupOthersLog.f18702a, SensorPosition.ConsultList, consultBannerModel != null ? consultBannerModel.getItemId() : null, null, 4, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConsultBannerLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f13842n = new LinkedHashMap();
        this.f13840l = HwCubicBezierInterpolator.f34870a;
        ConsultBannerAdapter consultBannerAdapter = new ConsultBannerAdapter();
        consultBannerAdapter.l().g(new Function1<Object, p>() { // from class: com.cupidapp.live.consult.view.ConsultBannerLayout$adapter$1$1
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
                if (obj instanceof ConsultBannerModel) {
                    ConsultBannerModel consultBannerModel = (ConsultBannerModel) obj;
                    j.a.b(j.f12156c, ConsultBannerLayout.this.getContext(), consultBannerModel.getJumpUrl(), null, 4, null);
                    ConsultBannerLayout.this.t(consultBannerModel);
                }
            }
        });
        this.f13841m = consultBannerAdapter;
        k();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConsultBannerLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f13842n = new LinkedHashMap();
        this.f13840l = HwCubicBezierInterpolator.f34870a;
        ConsultBannerAdapter consultBannerAdapter = new ConsultBannerAdapter();
        consultBannerAdapter.l().g(new Function1<Object, p>() { // from class: com.cupidapp.live.consult.view.ConsultBannerLayout$adapter$1$1
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
                if (obj instanceof ConsultBannerModel) {
                    ConsultBannerModel consultBannerModel = (ConsultBannerModel) obj;
                    j.a.b(j.f12156c, ConsultBannerLayout.this.getContext(), consultBannerModel.getJumpUrl(), null, 4, null);
                    ConsultBannerLayout.this.t(consultBannerModel);
                }
            }
        });
        this.f13841m = consultBannerAdapter;
        k();
    }
}

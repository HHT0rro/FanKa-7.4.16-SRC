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
import com.cupidapp.live.base.view.indicator.PagerIndicatorLayout;
import com.cupidapp.live.liveshow.activity.FKLiveOpenWebFragmentEvent;
import com.cupidapp.live.liveshow.model.LiveActivityModel;
import java.util.Iterator;
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
import z0.z;

/* compiled from: FKLiveShowActivityLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLiveShowActivityLayout extends FKLoopScrollLayout {

    /* renamed from: l, reason: collision with root package name */
    public boolean f15713l;

    /* renamed from: m, reason: collision with root package name */
    public final long f15714m;

    /* renamed from: n, reason: collision with root package name */
    @NotNull
    public final FKBaseRecyclerViewAdapter f15715n;

    /* renamed from: o, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f15716o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveShowActivityLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f15716o = new LinkedHashMap();
        this.f15714m = 5000L;
        FKLiveActivityAdapter fKLiveActivityAdapter = new FKLiveActivityAdapter();
        fKLiveActivityAdapter.l().g(new Function1<Object, p>() { // from class: com.cupidapp.live.liveshow.view.liveinfo.FKLiveShowActivityLayout$adapter$1$1
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
                LiveActivityModel liveActivityModel;
                String url;
                if (!(obj instanceof LiveActivityModel) || (url = (liveActivityModel = (LiveActivityModel) obj).getUrl()) == null) {
                    return;
                }
                FKLiveShowActivityLayout fKLiveShowActivityLayout = FKLiveShowActivityLayout.this;
                EventBus.c().l(new FKLiveOpenWebFragmentEvent(url, false, 2, null));
                fKLiveShowActivityLayout.u(liveActivityModel.getUrl());
            }
        });
        this.f15715n = fKLiveActivityAdapter;
        k();
    }

    @Override // com.cupidapp.live.base.recyclerview.FKLoopScrollLayout
    @NotNull
    public FKBaseRecyclerViewAdapter getAdapter() {
        return this.f15715n;
    }

    @Override // com.cupidapp.live.base.recyclerview.FKLoopScrollLayout
    public long getPagerLife() {
        return this.f15714m;
    }

    @Override // com.cupidapp.live.base.recyclerview.FKLoopScrollLayout
    public void j() {
        z.a(this, R$layout.layout_live_show_activity, true);
        ViewPager2 live_activity_viewpager = (ViewPager2) q(R$id.live_activity_viewpager);
        s.h(live_activity_viewpager, "live_activity_viewpager");
        setViewPager(live_activity_viewpager);
    }

    @Override // com.cupidapp.live.base.recyclerview.FKLoopScrollLayout
    public void m(int i10) {
        if (getAdapter().n() == 1) {
            v(0);
        } else {
            if (i10 <= 0 || i10 >= getAdapter().n() - 1) {
                return;
            }
            ((PagerIndicatorLayout) q(R$id.live_activity_indicator)).setCurrentPager(i10 - 1);
            v(i10);
        }
    }

    @Nullable
    public View q(int i10) {
        Map<Integer, View> map = this.f15716o;
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

    public final void s(@Nullable List<LiveActivityModel> list, boolean z10) {
        LiveActivityModel liveActivityModel;
        this.f15713l = z10;
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
                getViewPager().setOffscreenPageLimit(list.size() + 2);
                getAdapter().d(t((LiveActivityModel) CollectionsKt___CollectionsKt.e0(list)));
                Iterator<LiveActivityModel> iterator2 = list.iterator2();
                while (iterator2.hasNext()) {
                    getAdapter().d(t(iterator2.next()));
                }
                getAdapter().d(t((LiveActivityModel) CollectionsKt___CollectionsKt.T(list)));
            } else {
                getViewPager().setOffscreenPageLimit(1);
                getAdapter().d(t((LiveActivityModel) CollectionsKt___CollectionsKt.T(list)));
            }
            getAdapter().notifyDataSetChanged();
            ((PagerIndicatorLayout) q(R$id.live_activity_indicator)).setPagerCount(list.size());
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
                liveActivityModel = (LiveActivityModel) CollectionsKt___CollectionsKt.e0(list);
            } else {
                liveActivityModel = i10 == getAdapter().n() - 1 ? (LiveActivityModel) CollectionsKt___CollectionsKt.T(list) : list.get(i10 - 1);
            }
            if ((obj instanceof LiveActivityModel) && !s.d(obj, liveActivityModel)) {
                getAdapter().j().set(i10, liveActivityModel);
                getAdapter().notifyItemChanged(i10);
            }
            if ((obj instanceof LiveActivityWebModel) && !s.d(((LiveActivityWebModel) obj).getWebUrl(), liveActivityModel.getWebUrl())) {
                getAdapter().j().set(i10, t(liveActivityModel));
                getAdapter().notifyItemChanged(i10);
            }
            i10 = i11;
        }
    }

    public final Object t(LiveActivityModel liveActivityModel) {
        String webUrl = liveActivityModel.getWebUrl();
        return !(webUrl == null || webUrl.length() == 0) ? new LiveActivityWebModel(liveActivityModel.getWebUrl()) : liveActivityModel;
    }

    public final void u(String str) {
        SensorLogActivity.f12204a.a((this.f15713l ? SensorPosition.LiveShowRoom : SensorPosition.AnchorLiveShowRoom).getValue(), str, SensorLogActivity.Type.ACTIVITY.getType());
    }

    public final void v(int i10) {
        String webUrl;
        Object obj = getAdapter().j().get(i10);
        if (obj instanceof LiveActivityModel) {
            webUrl = ((LiveActivityModel) obj).getUrl();
        } else {
            webUrl = obj instanceof LiveActivityWebModel ? ((LiveActivityWebModel) obj).getWebUrl() : null;
        }
        SensorLogActivity.f12204a.b((this.f15713l ? SensorPosition.LiveShowRoom : SensorPosition.AnchorLiveShowRoom).getValue(), webUrl, SensorLogActivity.Type.ACTIVITY.getType());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveShowActivityLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f15716o = new LinkedHashMap();
        this.f15714m = 5000L;
        FKLiveActivityAdapter fKLiveActivityAdapter = new FKLiveActivityAdapter();
        fKLiveActivityAdapter.l().g(new Function1<Object, p>() { // from class: com.cupidapp.live.liveshow.view.liveinfo.FKLiveShowActivityLayout$adapter$1$1
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
                LiveActivityModel liveActivityModel;
                String url;
                if (!(obj instanceof LiveActivityModel) || (url = (liveActivityModel = (LiveActivityModel) obj).getUrl()) == null) {
                    return;
                }
                FKLiveShowActivityLayout fKLiveShowActivityLayout = FKLiveShowActivityLayout.this;
                EventBus.c().l(new FKLiveOpenWebFragmentEvent(url, false, 2, null));
                fKLiveShowActivityLayout.u(liveActivityModel.getUrl());
            }
        });
        this.f15715n = fKLiveActivityAdapter;
        k();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveShowActivityLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f15716o = new LinkedHashMap();
        this.f15714m = 5000L;
        FKLiveActivityAdapter fKLiveActivityAdapter = new FKLiveActivityAdapter();
        fKLiveActivityAdapter.l().g(new Function1<Object, p>() { // from class: com.cupidapp.live.liveshow.view.liveinfo.FKLiveShowActivityLayout$adapter$1$1
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
                LiveActivityModel liveActivityModel;
                String url;
                if (!(obj instanceof LiveActivityModel) || (url = (liveActivityModel = (LiveActivityModel) obj).getUrl()) == null) {
                    return;
                }
                FKLiveShowActivityLayout fKLiveShowActivityLayout = FKLiveShowActivityLayout.this;
                EventBus.c().l(new FKLiveOpenWebFragmentEvent(url, false, 2, null));
                fKLiveShowActivityLayout.u(liveActivityModel.getUrl());
            }
        });
        this.f15715n = fKLiveActivityAdapter;
        k();
    }
}

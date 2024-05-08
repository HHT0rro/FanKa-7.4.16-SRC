package com.cupidapp.live.liveshow.viewholder;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager2.widget.ViewPager2;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.base.recyclerview.helper.RecyclerExposureHelper;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.utils.i;
import com.cupidapp.live.base.view.indicator.PagerIndicatorLayout;
import com.cupidapp.live.liveshow.adapter.FKLiveBannerViwPagerAdapter;
import com.cupidapp.live.liveshow.model.AdModel;
import com.cupidapp.live.liveshow.model.AdViewModel;
import com.cupidapp.live.track.group.GroupOthersLog;
import com.huawei.uikit.hwcommon.anim.HwCubicBezierInterpolator;
import kotlin.Lazy;
import kotlin.c;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: FKLiveBannerViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FKLiveBannerViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public static final a f16034h = new a(null);

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public final Lazy f16035c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public i f16036d;

    /* renamed from: e, reason: collision with root package name */
    public final long f16037e;

    /* renamed from: f, reason: collision with root package name */
    public final long f16038f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public SensorPosition f16039g;

    /* compiled from: FKLiveBannerViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {

        /* compiled from: FKLiveBannerViewHolder.kt */
        @d
        /* renamed from: com.cupidapp.live.liveshow.viewholder.FKLiveBannerViewHolder$a$a, reason: collision with other inner class name */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
        public static final class ViewOnAttachStateChangeListenerC0163a implements View.OnAttachStateChangeListener {

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ FKLiveBannerViewHolder f16042b;

            public ViewOnAttachStateChangeListenerC0163a(FKLiveBannerViewHolder fKLiveBannerViewHolder) {
                this.f16042b = fKLiveBannerViewHolder;
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(@NotNull View v2) {
                s.i(v2, "v");
                this.f16042b.z();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(@NotNull View v2) {
                s.i(v2, "v");
                this.f16042b.A();
            }
        }

        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FKLiveBannerViewHolder a(@NotNull ViewGroup parent, @NotNull SensorPosition sensorPosition) {
            s.i(parent, "parent");
            s.i(sensorPosition, "sensorPosition");
            FKLiveBannerViewHolder fKLiveBannerViewHolder = new FKLiveBannerViewHolder(z.b(parent, R$layout.view_holder_live_banner, false, 2, null));
            fKLiveBannerViewHolder.f16039g = sensorPosition;
            fKLiveBannerViewHolder.itemView.addOnAttachStateChangeListener(new ViewOnAttachStateChangeListenerC0163a(fKLiveBannerViewHolder));
            return fKLiveBannerViewHolder;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveBannerViewHolder(@NotNull final View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
        this.f16035c = c.b(new Function0<FKLiveBannerViwPagerAdapter>() { // from class: com.cupidapp.live.liveshow.viewholder.FKLiveBannerViewHolder$liveBannerAdapter$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final FKLiveBannerViwPagerAdapter invoke() {
                final FKLiveBannerViwPagerAdapter fKLiveBannerViwPagerAdapter = new FKLiveBannerViwPagerAdapter();
                final FKLiveBannerViewHolder fKLiveBannerViewHolder = FKLiveBannerViewHolder.this;
                final View view = itemView;
                fKLiveBannerViwPagerAdapter.l().g(new Function1<Object, p>() { // from class: com.cupidapp.live.liveshow.viewholder.FKLiveBannerViewHolder$liveBannerAdapter$2$1$1
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
                        SensorPosition sensorPosition;
                        if (obj instanceof AdModel) {
                            GroupOthersLog groupOthersLog = GroupOthersLog.f18702a;
                            AdModel adModel = (AdModel) obj;
                            String itemId = adModel.getItemId();
                            sensorPosition = FKLiveBannerViewHolder.this.f16039g;
                            groupOthersLog.i(itemId, sensorPosition, fKLiveBannerViwPagerAdapter.i(obj));
                            j.a.b(j.f12156c, view.getContext(), adModel.getAdUrl(), null, 4, null);
                        }
                    }
                });
                return fKLiveBannerViwPagerAdapter;
            }
        });
        this.f16036d = new i();
        this.f16037e = 360000000L;
        this.f16038f = HwCubicBezierInterpolator.f34870a;
        this.f16039g = SensorPosition.Unknown;
        int i10 = R$id.liveBannerViewPager;
        ViewPager2 viewPager2 = (ViewPager2) itemView.findViewById(i10);
        viewPager2.setAdapter(x());
        viewPager2.setOffscreenPageLimit(6);
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() { // from class: com.cupidapp.live.liveshow.viewholder.FKLiveBannerViewHolder$1$1
            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageSelected(int i11) {
                FKLiveBannerViwPagerAdapter x10;
                x10 = FKLiveBannerViewHolder.this.x();
                int u10 = x10.u(i11);
                ((PagerIndicatorLayout) itemView.findViewById(R$id.liveBannerPageIndicator)).setCurrentPager(u10);
                FKLiveBannerViewHolder.this.y(u10);
            }
        });
        final View childAt = ((ViewPager2) itemView.findViewById(i10)).getChildAt(0);
        childAt.setOnTouchListener(new View.OnTouchListener() { // from class: com.cupidapp.live.liveshow.viewholder.a
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean s2;
                s2 = FKLiveBannerViewHolder.s(View.this, this, view, motionEvent);
                return s2;
            }
        });
    }

    public static final boolean s(View view, FKLiveBannerViewHolder this$0, View view2, MotionEvent motionEvent) {
        s.i(this$0, "this$0");
        view.performClick();
        int action = motionEvent.getAction();
        if (action != 1) {
            if (action == 2) {
                this$0.A();
                return false;
            }
            if (action != 3) {
                return false;
            }
        }
        this$0.z();
        return false;
    }

    public final void A() {
        this.f16036d.g();
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof AdViewModel) {
            x().j().clear();
            AdViewModel adViewModel = (AdViewModel) obj;
            x().e(adViewModel.getList());
            x().notifyDataSetChanged();
            ((ViewPager2) this.itemView.findViewById(R$id.liveBannerViewPager)).setCurrentItem(0, false);
            ((PagerIndicatorLayout) this.itemView.findViewById(R$id.liveBannerPageIndicator)).setPagerCount(adViewModel.getList().size());
        }
    }

    public final FKLiveBannerViwPagerAdapter x() {
        return (FKLiveBannerViwPagerAdapter) this.f16035c.getValue();
    }

    public final void y(int i10) {
        if (x().f(i10)) {
            Object W = CollectionsKt___CollectionsKt.W(x().j(), i10);
            if (W instanceof AdModel) {
                RecyclerExposureHelper.a aVar = RecyclerExposureHelper.f12092j;
                View itemView = this.itemView;
                s.h(itemView, "itemView");
                if (RecyclerExposureHelper.a.b(aVar, itemView, false, 2, null)) {
                    GroupOthersLog.f18702a.k(this.f16039g, ((AdModel) W).getItemId(), Integer.valueOf(i10 + 1));
                }
            }
        }
    }

    public final void z() {
        if (x().j().size() <= 1) {
            return;
        }
        this.f16036d.e(this.f16037e, this.f16038f, (r16 & 4) != 0 ? null : null, (r16 & 8) != 0 ? null : new Function1<Long, p>() { // from class: com.cupidapp.live.liveshow.viewholder.FKLiveBannerViewHolder$startPageTurning$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Long l10) {
                invoke(l10.longValue());
                return p.f51048a;
            }

            public final void invoke(long j10) {
                if (FKLiveBannerViewHolder.this.itemView.isShown()) {
                    ViewPager2 viewPager2 = (ViewPager2) FKLiveBannerViewHolder.this.itemView.findViewById(R$id.liveBannerViewPager);
                    viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1);
                }
            }
        });
    }
}

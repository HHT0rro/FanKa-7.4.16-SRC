package com.cupidapp.live.liveshow.view.praybattle;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.sensorslog.SensorLogActivity;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.utils.i;
import com.cupidapp.live.base.view.indicator.PagerIndicatorLayout;
import com.cupidapp.live.liveshow.activity.FKLiveOpenWebFragmentEvent;
import com.cupidapp.live.liveshow.model.PrayContestModel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.c;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: FKLivePrayBattleView.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLivePrayBattleView extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final Lazy f15827b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f15828c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public final Lazy f15829d;

    /* renamed from: e, reason: collision with root package name */
    public final long f15830e;

    /* renamed from: f, reason: collision with root package name */
    public final long f15831f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f15832g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLivePrayBattleView(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f15832g = new LinkedHashMap();
        this.f15827b = c.b(new Function0<FKLivePrayBattleAdapter>() { // from class: com.cupidapp.live.liveshow.view.praybattle.FKLivePrayBattleView$battleAdapter$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final FKLivePrayBattleAdapter invoke() {
                FKLivePrayBattleAdapter fKLivePrayBattleAdapter = new FKLivePrayBattleAdapter();
                final FKLivePrayBattleView fKLivePrayBattleView = FKLivePrayBattleView.this;
                fKLivePrayBattleAdapter.l().g(new Function1<Object, p>() { // from class: com.cupidapp.live.liveshow.view.praybattle.FKLivePrayBattleView$battleAdapter$2$1$1
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
                        if (obj instanceof PrayContestModel) {
                            PrayContestModel prayContestModel = (PrayContestModel) obj;
                            if (prayContestModel.getUrl() != null) {
                                EventBus.c().l(new FKLiveOpenWebFragmentEvent(prayContestModel.getUrl(), false, 2, null));
                            }
                            FKLivePrayBattleView.this.i(prayContestModel.getUrl(), prayContestModel.getType());
                        }
                    }
                });
                return fKLivePrayBattleAdapter;
            }
        });
        this.f15829d = c.b(FKLivePrayBattleView$countDownTimer$2.INSTANCE);
        this.f15830e = 360000000L;
        this.f15831f = 6000L;
        g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FKLivePrayBattleAdapter getBattleAdapter() {
        return (FKLivePrayBattleAdapter) this.f15827b.getValue();
    }

    private final i getCountDownTimer() {
        return (i) this.f15829d.getValue();
    }

    public static final boolean h(View view, FKLivePrayBattleView this$0, View view2, MotionEvent motionEvent) {
        s.i(this$0, "this$0");
        view.performClick();
        int action = motionEvent.getAction();
        if (action != 1) {
            if (action == 2) {
                this$0.l();
                return false;
            }
            if (action != 3) {
                return false;
            }
        }
        this$0.k();
        return false;
    }

    @Nullable
    public View b(int i10) {
        Map<Integer, View> map = this.f15832g;
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

    public final void f(@Nullable PrayContestModel prayContestModel, @Nullable PrayContestModel prayContestModel2, boolean z10) {
        this.f15828c = z10;
        if (prayContestModel == null && prayContestModel2 == null) {
            setVisibility(8);
            l();
            return;
        }
        setVisibility(0);
        getBattleAdapter().j().clear();
        if (prayContestModel2 != null) {
            String string = getContext().getString(R$string.normal_challenger);
            s.h(string, "context.getString(R.string.normal_challenger)");
            prayContestModel2.setText(string);
            prayContestModel2.setType(SensorLogActivity.Type.COMMON_CONTEST.getType());
            getBattleAdapter().d(prayContestModel2);
        }
        if (prayContestModel != null) {
            String string2 = getContext().getString(R$string.senior_challenger);
            s.h(string2, "context.getString(R.string.senior_challenger)");
            prayContestModel.setText(string2);
            prayContestModel.setType(SensorLogActivity.Type.HIGH_RANK_CONTEST.getType());
            getBattleAdapter().d(prayContestModel);
        }
        getBattleAdapter().notifyDataSetChanged();
        ((PagerIndicatorLayout) b(R$id.pray_battle_indicator_layout)).setPagerCount(getBattleAdapter().n());
        k();
    }

    public final void g() {
        z.a(this, R$layout.pray_battle_view, true);
        setVisibility(8);
        int i10 = R$id.pray_battle_viewpager;
        ((ViewPager2) b(i10)).setAdapter(getBattleAdapter());
        ((ViewPager2) b(i10)).registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() { // from class: com.cupidapp.live.liveshow.view.praybattle.FKLivePrayBattleView$initView$1
            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageSelected(int i11) {
                FKLivePrayBattleAdapter battleAdapter;
                FKLivePrayBattleAdapter battleAdapter2;
                battleAdapter = FKLivePrayBattleView.this.getBattleAdapter();
                int u10 = battleAdapter.u(i11);
                ((PagerIndicatorLayout) FKLivePrayBattleView.this.b(R$id.pray_battle_indicator_layout)).setCurrentPager(u10);
                battleAdapter2 = FKLivePrayBattleView.this.getBattleAdapter();
                Object obj = battleAdapter2.j().get(u10);
                PrayContestModel prayContestModel = obj instanceof PrayContestModel ? (PrayContestModel) obj : null;
                FKLivePrayBattleView.this.j(prayContestModel != null ? prayContestModel.getUrl() : null, prayContestModel != null ? prayContestModel.getType() : null);
            }
        });
        final View childAt = ((ViewPager2) b(i10)).getChildAt(0);
        childAt.setOnTouchListener(new View.OnTouchListener() { // from class: com.cupidapp.live.liveshow.view.praybattle.a
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean h10;
                h10 = FKLivePrayBattleView.h(View.this, this, view, motionEvent);
                return h10;
            }
        });
    }

    public final void i(String str, String str2) {
        SensorLogActivity.f12204a.a((this.f15828c ? SensorPosition.LiveShowRoom : SensorPosition.AnchorLiveShowRoom).getValue(), str, str2);
    }

    public final void j(String str, String str2) {
        SensorLogActivity.f12204a.b((this.f15828c ? SensorPosition.LiveShowRoom : SensorPosition.AnchorLiveShowRoom).getValue(), str, str2);
    }

    public final void k() {
        if (getBattleAdapter().j().size() <= 1) {
            return;
        }
        getCountDownTimer().e(this.f15830e, this.f15831f, (r16 & 4) != 0 ? null : null, (r16 & 8) != 0 ? null : new Function1<Long, p>() { // from class: com.cupidapp.live.liveshow.view.praybattle.FKLivePrayBattleView$startPageTurning$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Long l10) {
                invoke(l10.longValue());
                return p.f51048a;
            }

            public final void invoke(long j10) {
                ViewPager2 viewPager2 = (ViewPager2) FKLivePrayBattleView.this.b(R$id.pray_battle_viewpager);
                viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1);
            }
        });
    }

    public final void l() {
        getCountDownTimer().g();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(@Nullable MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLivePrayBattleView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f15832g = new LinkedHashMap();
        this.f15827b = c.b(new Function0<FKLivePrayBattleAdapter>() { // from class: com.cupidapp.live.liveshow.view.praybattle.FKLivePrayBattleView$battleAdapter$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final FKLivePrayBattleAdapter invoke() {
                FKLivePrayBattleAdapter fKLivePrayBattleAdapter = new FKLivePrayBattleAdapter();
                final FKLivePrayBattleView fKLivePrayBattleView = FKLivePrayBattleView.this;
                fKLivePrayBattleAdapter.l().g(new Function1<Object, p>() { // from class: com.cupidapp.live.liveshow.view.praybattle.FKLivePrayBattleView$battleAdapter$2$1$1
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
                        if (obj instanceof PrayContestModel) {
                            PrayContestModel prayContestModel = (PrayContestModel) obj;
                            if (prayContestModel.getUrl() != null) {
                                EventBus.c().l(new FKLiveOpenWebFragmentEvent(prayContestModel.getUrl(), false, 2, null));
                            }
                            FKLivePrayBattleView.this.i(prayContestModel.getUrl(), prayContestModel.getType());
                        }
                    }
                });
                return fKLivePrayBattleAdapter;
            }
        });
        this.f15829d = c.b(FKLivePrayBattleView$countDownTimer$2.INSTANCE);
        this.f15830e = 360000000L;
        this.f15831f = 6000L;
        g();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLivePrayBattleView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f15832g = new LinkedHashMap();
        this.f15827b = c.b(new Function0<FKLivePrayBattleAdapter>() { // from class: com.cupidapp.live.liveshow.view.praybattle.FKLivePrayBattleView$battleAdapter$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final FKLivePrayBattleAdapter invoke() {
                FKLivePrayBattleAdapter fKLivePrayBattleAdapter = new FKLivePrayBattleAdapter();
                final FKLivePrayBattleView fKLivePrayBattleView = FKLivePrayBattleView.this;
                fKLivePrayBattleAdapter.l().g(new Function1<Object, p>() { // from class: com.cupidapp.live.liveshow.view.praybattle.FKLivePrayBattleView$battleAdapter$2$1$1
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
                        if (obj instanceof PrayContestModel) {
                            PrayContestModel prayContestModel = (PrayContestModel) obj;
                            if (prayContestModel.getUrl() != null) {
                                EventBus.c().l(new FKLiveOpenWebFragmentEvent(prayContestModel.getUrl(), false, 2, null));
                            }
                            FKLivePrayBattleView.this.i(prayContestModel.getUrl(), prayContestModel.getType());
                        }
                    }
                });
                return fKLivePrayBattleAdapter;
            }
        });
        this.f15829d = c.b(FKLivePrayBattleView$countDownTimer$2.INSTANCE);
        this.f15830e = 360000000L;
        this.f15831f = 6000L;
        g();
    }
}

package com.cupidapp.live.match.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.yuyakaido.android.cardstackview.CardStackLayoutManager;
import com.yuyakaido.android.cardstackview.CardStackView;
import com.yuyakaido.android.cardstackview.Direction;
import com.yuyakaido.android.cardstackview.Duration;
import com.yuyakaido.android.cardstackview.StackFrom;
import com.yuyakaido.android.cardstackview.SwipeableMethod;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import mc.b;
import mc.c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKSwipeCardView.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class FKSwipeCardView extends CardStackView implements mc.a {

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public static final a f16903e = new a(null);

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public final Lazy f16904c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f16905d = new LinkedHashMap();

    /* compiled from: FKSwipeCardView.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public FKSwipeCardView(@Nullable Context context) {
        super(context);
        this.f16904c = kotlin.c.b(new Function0<CardStackLayoutManager>() { // from class: com.cupidapp.live.match.view.FKSwipeCardView$manager$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final CardStackLayoutManager invoke() {
                return new CardStackLayoutManager(FKSwipeCardView.this.getContext(), FKSwipeCardView.this);
            }
        });
        s();
    }

    private final CardStackLayoutManager getManager() {
        return (CardStackLayoutManager) this.f16904c.getValue();
    }

    public void a(@Nullable Direction direction, float f10) {
        com.cupidapp.live.base.utils.j.f12332a.a("FKSwipeCardView", "onCardDragging direction: " + ((Object) direction) + " ratio: " + f10);
    }

    public void b(@Nullable View view, int i10) {
        com.cupidapp.live.base.utils.j.f12332a.a("FKSwipeCardView", "onCardDisappeared view: " + ((Object) view) + " position: " + i10);
    }

    public void c(@Nullable Direction direction) {
        com.cupidapp.live.base.utils.j.f12332a.a("FKSwipeCardView", "onCardSwiped direction: " + ((Object) direction));
    }

    public void d(@Nullable View view, int i10) {
        com.cupidapp.live.base.utils.j.f12332a.a("FKSwipeCardView", "onCardAppeared view: " + ((Object) view) + " position: " + i10);
    }

    public void j() {
        com.cupidapp.live.base.utils.j.f12332a.a("FKSwipeCardView", "onCardCanceled");
    }

    public void k() {
        com.cupidapp.live.base.utils.j.f12332a.a("FKSwipeCardView", "onCardRewound");
    }

    public final void p(@NotNull List<? extends Direction> directions) {
        kotlin.jvm.internal.s.i(directions, "directions");
        getManager().n(directions);
    }

    @Nullable
    public final RecyclerView.ViewHolder q(int i10) {
        return findViewHolderForLayoutPosition(i10);
    }

    @Nullable
    public final RecyclerView.ViewHolder r(@NotNull View view) {
        kotlin.jvm.internal.s.i(view, "view");
        return getChildViewHolder(view);
    }

    public final void s() {
        CardStackLayoutManager manager = getManager();
        manager.s(StackFrom.None);
        manager.y(2);
        manager.x(8.0f);
        manager.r(0.95f);
        manager.u(0.1f);
        manager.o(20.0f);
        manager.n(kotlin.collections.s.m(Direction.Left, Direction.Right));
        manager.l(true);
        manager.m(true);
        manager.v(SwipeableMethod.AutomaticAndManual);
        manager.p(new i());
        setLayoutManager(getManager());
        RecyclerView.ItemAnimator itemAnimator = getItemAnimator();
        SimpleItemAnimator simpleItemAnimator = itemAnimator instanceof SimpleItemAnimator ? (SimpleItemAnimator) itemAnimator : null;
        if (simpleItemAnimator == null) {
            return;
        }
        simpleItemAnimator.setSupportsChangeAnimations(false);
    }

    public final void setSwipeAnimationSetting(@NotNull Direction direction) {
        kotlin.jvm.internal.s.i(direction, "direction");
        getManager().t(new c.b().b(direction).c(Duration.Normal.duration).d(new AccelerateInterpolator()).a());
    }

    public final void t() {
        getManager().q(new b.C0791b().b(Direction.Left).c(Duration.Normal.duration).d(new DecelerateInterpolator()).a());
    }

    public FKSwipeCardView(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f16904c = kotlin.c.b(new Function0<CardStackLayoutManager>() { // from class: com.cupidapp.live.match.view.FKSwipeCardView$manager$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final CardStackLayoutManager invoke() {
                return new CardStackLayoutManager(FKSwipeCardView.this.getContext(), FKSwipeCardView.this);
            }
        });
        s();
    }

    public FKSwipeCardView(@Nullable Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f16904c = kotlin.c.b(new Function0<CardStackLayoutManager>() { // from class: com.cupidapp.live.match.view.FKSwipeCardView$manager$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final CardStackLayoutManager invoke() {
                return new CardStackLayoutManager(FKSwipeCardView.this.getContext(), FKSwipeCardView.this);
            }
        });
        s();
    }
}

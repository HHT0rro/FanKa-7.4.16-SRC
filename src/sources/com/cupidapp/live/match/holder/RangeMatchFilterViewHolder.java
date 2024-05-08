package com.cupidapp.live.match.holder;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.base.view.SuperRangerBar;
import com.cupidapp.live.match.event.RangSliderTouchStartEvent;
import com.cupidapp.live.match.event.RangSliserTouchEndEvent;
import com.cupidapp.live.match.event.ShowPurchaseDialogEvent;
import com.cupidapp.live.match.model.MatchFilterKey;
import com.cupidapp.live.match.model.MatchFilterModel;
import com.cupidapp.live.match.model.PurchaseProductType;
import com.cupidapp.live.match.model.RangeMatchFilterViewModel;
import com.cupidapp.live.profile.logic.c;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.vip.wrapper.VipPurchaseEntranceType;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p1.g;
import z0.z;

/* compiled from: RangeMatchFilterViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class RangeMatchFilterViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public static final a f16814e = new a(null);

    /* renamed from: c, reason: collision with root package name */
    public final boolean f16815c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f16816d;

    /* compiled from: RangeMatchFilterViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final RangeMatchFilterViewHolder a(@NotNull ViewGroup parent, boolean z10, boolean z11) {
            s.i(parent, "parent");
            return new RangeMatchFilterViewHolder(z.b(parent, R$layout.view_holder_range_match_filter, false, 2, null), z10, z11);
        }
    }

    /* compiled from: RangeMatchFilterViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b extends SuperRangerBar.b {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ RangeMatchFilterViewModel f16818b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f16819c;

        public b(RangeMatchFilterViewModel rangeMatchFilterViewModel, String str) {
            this.f16818b = rangeMatchFilterViewModel;
            this.f16819c = str;
        }

        @Override // com.cupidapp.live.base.view.SuperRangerBar.b
        public void a(@Nullable Boolean bool, @Nullable MotionEvent motionEvent) {
            if (s.d(bool, Boolean.FALSE)) {
                boolean z10 = false;
                if (motionEvent != null && motionEvent.getAction() == 0) {
                    z10 = true;
                }
                if (z10 && !RangeMatchFilterViewHolder.this.u() && RangeMatchFilterViewHolder.this.v()) {
                    if (s.d(this.f16818b.getMatchFilterModel().getKey(), MatchFilterKey.FilterAge.getKey())) {
                        if (RangeMatchFilterViewHolder.this.w()) {
                            RangeMatchFilterViewHolder.this.x(this.f16818b);
                        }
                    } else {
                        if (c.f17839a.f()) {
                            return;
                        }
                        RangeMatchFilterViewHolder.this.x(this.f16818b);
                    }
                }
            }
        }

        @Override // com.cupidapp.live.base.view.SuperRangerBar.b
        public void c() {
            EventBus.c().o(new RangSliderTouchStartEvent());
            super.c();
        }

        @Override // com.cupidapp.live.base.view.SuperRangerBar.b
        public void d() {
            EventBus.c().o(new RangSliserTouchEndEvent());
            super.d();
        }

        @Override // com.cupidapp.live.base.view.SuperRangerBar.b
        public void e(int i10, int i11, boolean z10, boolean z11) {
            if (z11 && z10) {
                View view = RangeMatchFilterViewHolder.this.itemView;
                int i12 = R$id.range_content_text;
                ((TextView) view.findViewById(i12)).setText(RangeMatchFilterViewHolder.this.itemView.getContext().getString(R$string.infinite));
                ((TextView) RangeMatchFilterViewHolder.this.itemView.findViewById(i12)).setTextColor(-5658199);
                ((TextView) RangeMatchFilterViewHolder.this.itemView.findViewById(i12)).getPaint().setFakeBoldText(false);
            } else if (z11 && !this.f16818b.getSearchHasMax()) {
                View view2 = RangeMatchFilterViewHolder.this.itemView;
                int i13 = R$id.range_content_text;
                ((TextView) view2.findViewById(i13)).setText(RangeMatchFilterViewHolder.this.itemView.getContext().getString(R$string.range_min, Integer.valueOf(i10), this.f16819c));
                ((TextView) RangeMatchFilterViewHolder.this.itemView.findViewById(i13)).setTextColor(-49088);
                ((TextView) RangeMatchFilterViewHolder.this.itemView.findViewById(i13)).getPaint().setFakeBoldText(true);
            } else if (z10 && !this.f16818b.getSearchHasMin()) {
                View view3 = RangeMatchFilterViewHolder.this.itemView;
                int i14 = R$id.range_content_text;
                ((TextView) view3.findViewById(i14)).setText(RangeMatchFilterViewHolder.this.itemView.getContext().getString(R$string.range_max, Integer.valueOf(i11), this.f16819c));
                ((TextView) RangeMatchFilterViewHolder.this.itemView.findViewById(i14)).setTextColor(-49088);
                ((TextView) RangeMatchFilterViewHolder.this.itemView.findViewById(i14)).getPaint().setFakeBoldText(true);
            } else {
                View view4 = RangeMatchFilterViewHolder.this.itemView;
                int i15 = R$id.range_content_text;
                ((TextView) view4.findViewById(i15)).setText(RangeMatchFilterViewHolder.this.itemView.getContext().getString(R$string.range_min_to_max, Integer.valueOf(i10), this.f16819c, Integer.valueOf(i11), this.f16819c));
                ((TextView) RangeMatchFilterViewHolder.this.itemView.findViewById(i15)).setTextColor(-49088);
                ((TextView) RangeMatchFilterViewHolder.this.itemView.findViewById(i15)).getPaint().setFakeBoldText(true);
            }
            this.f16818b.setMin(i10);
            this.f16818b.setMax(i11);
            this.f16818b.getMatchFilterModel().setMinValue(i10);
            this.f16818b.getMatchFilterModel().setMaxValue(i11);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RangeMatchFilterViewHolder(@NotNull View itemView, boolean z10, boolean z11) {
        super(itemView);
        s.i(itemView, "itemView");
        this.f16815c = z10;
        this.f16816d = z11;
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof RangeMatchFilterViewModel) {
            RangeMatchFilterViewModel rangeMatchFilterViewModel = (RangeMatchFilterViewModel) obj;
            if (rangeMatchFilterViewModel.getMatchFilterModel().getType() == MatchFilterModel.MatchFilterType.Range) {
                ((TextView) this.itemView.findViewById(R$id.range_title_text)).setText(rangeMatchFilterViewModel.getMatchFilterModel().getName());
                t(rangeMatchFilterViewModel);
                View view = this.itemView;
                int i10 = R$id.rangeBar;
                SuperRangerBar superRangerBar = (SuperRangerBar) view.findViewById(i10);
                superRangerBar.h(rangeMatchFilterViewModel.getMatchFilterModel().getDefaultMin(), rangeMatchFilterViewModel.getMatchFilterModel().getDefaultMax());
                superRangerBar.setRange(rangeMatchFilterViewModel.getMatchFilterModel().getMinValue(), rangeMatchFilterViewModel.getMatchFilterModel().getMaxValue());
                if (s.d(rangeMatchFilterViewModel.getMatchFilterModel().getKey(), MatchFilterKey.FilterAge.getKey())) {
                    if (w() && !this.f16815c && this.f16816d) {
                        ((SuperRangerBar) this.itemView.findViewById(i10)).f(false);
                        return;
                    } else {
                        ((SuperRangerBar) this.itemView.findViewById(i10)).f(true);
                        return;
                    }
                }
                if (!c.f17839a.f() && !this.f16815c && this.f16816d) {
                    ((SuperRangerBar) this.itemView.findViewById(i10)).f(false);
                } else {
                    ((SuperRangerBar) this.itemView.findViewById(i10)).f(true);
                }
            }
        }
    }

    public final void t(RangeMatchFilterViewModel rangeMatchFilterViewModel) {
        ((SuperRangerBar) this.itemView.findViewById(R$id.rangeBar)).setOnMoveListener(new b(rangeMatchFilterViewModel, rangeMatchFilterViewModel.getMatchFilterModel().getUnit()));
    }

    public final boolean u() {
        return this.f16815c;
    }

    public final boolean v() {
        return this.f16816d;
    }

    public final boolean w() {
        User X = g.f52734a.X();
        return (c.f17839a.f() || (X != null ? X.getPro() : false)) ? false : true;
    }

    public final void x(RangeMatchFilterViewModel rangeMatchFilterViewModel) {
        EventBus.c().l(new a3.a(rangeMatchFilterViewModel.getMatchFilterModel().getName(), false, null, 6, null));
        EventBus.c().l(new ShowPurchaseDialogEvent(VipPurchaseEntranceType.Filter, rangeMatchFilterViewModel.getMatchFilterModel().getName(), PurchaseProductType.VIP));
    }
}

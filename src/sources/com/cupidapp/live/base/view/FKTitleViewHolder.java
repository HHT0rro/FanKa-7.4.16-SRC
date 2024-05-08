package com.cupidapp.live.base.view;

import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;
import z0.z;

/* compiled from: FKRecyclerTitleLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKTitleViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f12529c = new a(null);

    /* compiled from: FKRecyclerTitleLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FKTitleViewHolder a(@NotNull ViewGroup parent) {
            kotlin.jvm.internal.s.i(parent, "parent");
            return new FKTitleViewHolder(z.b(parent, R$layout.view_holder_title, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKTitleViewHolder(@NotNull View itemView) {
        super(itemView);
        kotlin.jvm.internal.s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof FKTitleViewModel) {
            FKTitleViewModel fKTitleViewModel = (FKTitleViewModel) obj;
            ((TextView) this.itemView.findViewById(R$id.singleTitleTextView)).setText(fKTitleViewModel.getText());
            if (fKTitleViewModel.isSelected()) {
                r(fKTitleViewModel.getSelectedTitle());
                TitleIndicatorModel indicator = fKTitleViewModel.getIndicator();
                if (indicator != null) {
                    FrameLayout frameLayout = (FrameLayout) this.itemView.findViewById(R$id.indicator_layout);
                    kotlin.jvm.internal.s.h(frameLayout, "itemView.indicator_layout");
                    frameLayout.setVisibility(0);
                    View view = this.itemView;
                    int i10 = R$id.indicatorView;
                    View findViewById = view.findViewById(i10);
                    kotlin.jvm.internal.s.h(findViewById, "itemView.indicatorView");
                    y.i(findViewById, (r18 & 1) != 0 ? 0.0f : z0.h.c(this, indicator.getHeight() / 2), kotlin.collections.r.e(Integer.valueOf(indicator.getIndicatorColor())), (r18 & 4) != 0 ? GradientDrawable.Orientation.LEFT_RIGHT : null, (r18 & 8) != 0 ? null : null, (r18 & 16) != 0 ? null : null, (r18 & 32) != 0 ? 0.0f : 0.0f, (r18 & 64) != 0 ? 0.0f : 0.0f);
                    View findViewById2 = this.itemView.findViewById(i10);
                    kotlin.jvm.internal.s.h(findViewById2, "itemView.indicatorView");
                    y.n(findViewById2, Integer.valueOf(z0.h.c(this, indicator.getWidth())), Integer.valueOf(z0.h.c(this, indicator.getHeight())));
                    return;
                }
                FrameLayout frameLayout2 = (FrameLayout) this.itemView.findViewById(R$id.indicator_layout);
                kotlin.jvm.internal.s.h(frameLayout2, "itemView.indicator_layout");
                frameLayout2.setVisibility(8);
                return;
            }
            r(fKTitleViewModel.getUnSelectedTitle());
            FrameLayout frameLayout3 = (FrameLayout) this.itemView.findViewById(R$id.indicator_layout);
            kotlin.jvm.internal.s.h(frameLayout3, "itemView.indicator_layout");
            frameLayout3.setVisibility(8);
        }
    }

    public final void r(TitleConfigModel titleConfigModel) {
        View view = this.itemView;
        int i10 = R$id.singleTitleTextView;
        ((TextView) view.findViewById(i10)).getPaint().setFakeBoldText(titleConfigModel.getTextBold());
        ((TextView) this.itemView.findViewById(i10)).setTextColor(titleConfigModel.getTextColor());
        ((TextView) this.itemView.findViewById(i10)).setTextSize(titleConfigModel.getTextSize());
    }
}

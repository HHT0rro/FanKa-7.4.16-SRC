package com.cupidapp.live.liveshow.viewholder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorScene;
import com.cupidapp.live.liveshow.activity.FKLiveForViewerActivity;
import com.cupidapp.live.liveshow.activity.FKLiveForViewerViewModel;
import com.cupidapp.live.liveshow.activity.FKLiveListActivity;
import com.cupidapp.live.liveshow.fragment.LiveInRoomSensorModel;
import com.cupidapp.live.liveshow.model.LiveShowModel;
import com.cupidapp.live.liveshow.view.FKLiveSquareCardItemView;
import java.util.List;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;
import z0.y;
import z0.z;

/* compiled from: FKLiveSquareCardViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FKLiveSquareCardViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final a f16046d = new a(null);

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public final SensorPosition f16047c;

    /* compiled from: FKLiveSquareCardViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FKLiveSquareCardViewHolder a(@NotNull ViewGroup parent, @NotNull SensorPosition position) {
            s.i(parent, "parent");
            s.i(position, "position");
            return new FKLiveSquareCardViewHolder(z.b(parent, R$layout.view_holder_live_square_card, false, 2, null), position);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveSquareCardViewHolder(@NotNull View itemView, @NotNull SensorPosition position) {
        super(itemView);
        s.i(itemView, "itemView");
        s.i(position, "position");
        this.f16047c = position;
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable final Object obj) {
        if (obj instanceof FKLiveSquareCardModel) {
            FKLiveSquareCardModel fKLiveSquareCardModel = (FKLiveSquareCardModel) obj;
            String title = fKLiveSquareCardModel.getTitle();
            if (title == null || title.length() == 0) {
                ((TextView) this.itemView.findViewById(R$id.squareCardTitle)).setVisibility(8);
            } else {
                View view = this.itemView;
                int i10 = R$id.squareCardTitle;
                ((TextView) view.findViewById(i10)).setVisibility(0);
                ((TextView) this.itemView.findViewById(i10)).setText(fKLiveSquareCardModel.getTitle());
            }
            if (fKLiveSquareCardModel.getHaveMore()) {
                View view2 = this.itemView;
                int i11 = R$id.moreSquareCard;
                ((LinearLayout) view2.findViewById(i11)).setVisibility(0);
                LinearLayout linearLayout = (LinearLayout) this.itemView.findViewById(i11);
                s.h(linearLayout, "itemView.moreSquareCard");
                y.d(linearLayout, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.viewholder.FKLiveSquareCardViewHolder$config$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ p invoke(View view3) {
                        invoke2(view3);
                        return p.f51048a;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@Nullable View view3) {
                        FKLiveListActivity.f14776w.a(FKLiveSquareCardViewHolder.this.itemView.getContext(), ((FKLiveSquareCardModel) obj).getTitle(), ((FKLiveSquareCardModel) obj).getId());
                    }
                });
            } else {
                ((LinearLayout) this.itemView.findViewById(R$id.moreSquareCard)).setVisibility(8);
            }
            r(fKLiveSquareCardModel.getSquareCardList());
        }
    }

    public final void r(List<LiveShowModel> list) {
        ((LinearLayout) this.itemView.findViewById(R$id.squareCardContainerLayout)).removeAllViews();
        if (list != null) {
            final int i10 = 0;
            LinearLayout linearLayout = null;
            for (LiveShowModel liveShowModel : list) {
                int i11 = i10 + 1;
                if (i10 < 0) {
                    kotlin.collections.s.s();
                }
                final LiveShowModel liveShowModel2 = liveShowModel;
                if (i10 % 3 == 0) {
                    linearLayout = s();
                    ((LinearLayout) this.itemView.findViewById(R$id.squareCardContainerLayout)).addView(linearLayout);
                }
                Context context = this.itemView.getContext();
                s.h(context, "itemView.context");
                final FKLiveSquareCardItemView fKLiveSquareCardItemView = new FKLiveSquareCardItemView(context);
                fKLiveSquareCardItemView.setSquareCardViewSize((h.l(fKLiveSquareCardItemView) - h.c(fKLiveSquareCardItemView, 4.0f)) / 3);
                fKLiveSquareCardItemView.b(liveShowModel2);
                y.d(fKLiveSquareCardItemView, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.viewholder.FKLiveSquareCardViewHolder$configSquareCardView$1$squareCardView$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                        FKLiveForViewerActivity.a.b(FKLiveForViewerActivity.G, FKLiveSquareCardItemView.this.getContext(), new FKLiveForViewerViewModel(liveShowModel2, null, new LiveInRoomSensorModel("LIVE_COMPONENT", Integer.valueOf(i10 + 1), SensorScene.Live, this.t(), null, null, 48, null), false, 8, null), false, 4, null);
                    }
                });
                if (linearLayout != null) {
                    linearLayout.addView(fKLiveSquareCardItemView);
                }
                i10 = i11;
            }
        }
    }

    public final LinearLayout s() {
        LinearLayout linearLayout = new LinearLayout(this.itemView.getContext());
        linearLayout.setOrientation(0);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        return linearLayout;
    }

    @NotNull
    public final SensorPosition t() {
        return this.f16047c;
    }
}

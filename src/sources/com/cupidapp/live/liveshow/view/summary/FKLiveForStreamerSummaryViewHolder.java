package com.cupidapp.live.liveshow.view.summary;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;
import z0.z;

/* compiled from: FKLiveForStreamerSummaryLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLiveForStreamerSummaryViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f15945c = new a(null);

    /* compiled from: FKLiveForStreamerSummaryLayout.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FKLiveForStreamerSummaryViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            FKLiveForStreamerSummaryViewHolder fKLiveForStreamerSummaryViewHolder = new FKLiveForStreamerSummaryViewHolder(z.b(parent, R$layout.view_holder_live_for_streamer_summary, false, 2, null));
            int l10 = (h.l(fKLiveForStreamerSummaryViewHolder) - h.c(fKLiveForStreamerSummaryViewHolder, 94.0f)) / 2;
            fKLiveForStreamerSummaryViewHolder.itemView.getLayoutParams().width = l10;
            fKLiveForStreamerSummaryViewHolder.itemView.getLayoutParams().height = (l10 * 9) / 16;
            return fKLiveForStreamerSummaryViewHolder;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveForStreamerSummaryViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof FKLiveForStreamerSummaryModel) {
            FKLiveForStreamerSummaryModel fKLiveForStreamerSummaryModel = (FKLiveForStreamerSummaryModel) obj;
            ((TextView) this.itemView.findViewById(R$id.summaryValue)).setText(fKLiveForStreamerSummaryModel.getValue());
            ((TextView) this.itemView.findViewById(R$id.summaryTitle)).setText(fKLiveForStreamerSummaryModel.getTitle());
        }
    }
}

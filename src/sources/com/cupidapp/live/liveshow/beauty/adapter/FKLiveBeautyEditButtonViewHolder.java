package com.cupidapp.live.liveshow.beauty.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.cupidapp.live.R$drawable;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.liveshow.beauty.model.FKLiveBeautyItemModel;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;
import z0.z;

/* compiled from: FKLiveBeautyEditButtonListAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLiveBeautyEditButtonViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f14830c = new a(null);

    /* compiled from: FKLiveBeautyEditButtonListAdapter.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FKLiveBeautyEditButtonViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new FKLiveBeautyEditButtonViewHolder(z.b(parent, R$layout.view_holder_live_beauty_edit_button, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveBeautyEditButtonViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof FKLiveBeautyItemModel) {
            int l10 = ((h.l(this) - h.c(this, 75.0f)) / 9) * 2;
            ((ConstraintLayout) this.itemView.findViewById(R$id.rootLayout)).getLayoutParams().width = l10;
            View view = this.itemView;
            int i10 = R$id.buttonIconImageView;
            ((ImageView) view.findViewById(i10)).getLayoutParams().width = l10;
            ((ImageView) this.itemView.findViewById(i10)).getLayoutParams().height = l10;
            View view2 = this.itemView;
            int i11 = R$id.buttonNameTextView;
            ((TextView) view2.findViewById(i11)).getPaint().setFakeBoldText(true);
            ((TextView) this.itemView.findViewById(i11)).setTextColor(-15066598);
            FKLiveBeautyItemModel fKLiveBeautyItemModel = (FKLiveBeautyItemModel) obj;
            ((TextView) this.itemView.findViewById(i11)).setText(this.itemView.getContext().getString(fKLiveBeautyItemModel.getButtonType().typeName()));
            ((ImageView) this.itemView.findViewById(i10)).setImageResource(fKLiveBeautyItemModel.getButtonType().typeIcon());
            ((ImageView) this.itemView.findViewById(i10)).setBackgroundResource(R$drawable.shape_white_bg_two_hundred_corners);
        }
    }
}

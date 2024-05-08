package com.cupidapp.live.mediapicker.holder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.cupidapp.live.R$drawable;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.mediapicker.model.FrameViewModel;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: ImageEditFrameViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class ImageEditFrameViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f17251c = new a(null);

    /* compiled from: ImageEditFrameViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ImageEditFrameViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new ImageEditFrameViewHolder(z.b(parent, R$layout.view_holder_media_edit_button, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageEditFrameViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof FrameViewModel) {
            View view = this.itemView;
            int i10 = R$id.buttonNameTextView;
            ((TextView) view.findViewById(i10)).getPaint().setFakeBoldText(true);
            FrameViewModel frameViewModel = (FrameViewModel) obj;
            ((TextView) this.itemView.findViewById(i10)).setTextColor(frameViewModel.getItemSelected() ? -15066598 : -3750202);
            ((TextView) this.itemView.findViewById(i10)).setText(this.itemView.getContext().getString(frameViewModel.getFrameNameRes()));
            View view2 = this.itemView;
            int i11 = R$id.buttonIconImageView;
            ((ImageView) view2.findViewById(i11)).setImageResource(frameViewModel.getFrameIconRes());
            ((ImageView) this.itemView.findViewById(i11)).setBackgroundResource(R$drawable.shape_white_bg_gray_stroke_thirty_six_corners);
        }
    }
}

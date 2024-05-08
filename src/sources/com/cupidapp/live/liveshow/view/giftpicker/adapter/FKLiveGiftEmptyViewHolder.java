package com.cupidapp.live.liveshow.view.giftpicker.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: FKLiveGiftPickerPageAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLiveGiftEmptyViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f15424c = new a(null);

    /* compiled from: FKLiveGiftPickerPageAdapter.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FKLiveGiftEmptyViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new FKLiveGiftEmptyViewHolder(z.b(parent, R$layout.view_holder_live_gift_empty, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveGiftEmptyViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof FKLiveGiftPickerEmptyUiModel) {
            FKLiveGiftPickerEmptyUiModel fKLiveGiftPickerEmptyUiModel = (FKLiveGiftPickerEmptyUiModel) obj;
            Integer emptyImage = fKLiveGiftPickerEmptyUiModel.getEmptyImage();
            if (emptyImage != null) {
                ((ImageView) this.itemView.findViewById(R$id.emptyGiftImageView)).setImageResource(emptyImage.intValue());
            }
            Integer emptyTextRes = fKLiveGiftPickerEmptyUiModel.getEmptyTextRes();
            if (emptyTextRes != null) {
                ((TextView) this.itemView.findViewById(R$id.emptyGiftTextView)).setText(this.itemView.getContext().getString(emptyTextRes.intValue()));
            }
        }
    }
}

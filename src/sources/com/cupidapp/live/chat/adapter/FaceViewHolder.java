package com.cupidapp.live.chat.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.cupidapp.live.R$drawable;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;
import z0.z;

/* compiled from: FaceAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FaceViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f13135c = new a(null);

    /* compiled from: FaceAdapter.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FaceViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new FaceViewHolder(z.b(parent, R$layout.item_face, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FaceViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof FaceUiModel) {
            View view = this.itemView;
            int i10 = R$id.face_img;
            ((ImageView) view.findViewById(i10)).setBackgroundResource(R$drawable.shape_circle_white_bg);
            FaceUiModel faceUiModel = (FaceUiModel) obj;
            int a10 = w1.a.f54094a.a(faceUiModel.getCustomEmojiCode().getEmojiCNCode());
            if (a10 != -1) {
                ((ImageView) this.itemView.findViewById(i10)).setImageResource(a10);
            }
            ImageView imageView = (ImageView) this.itemView.findViewById(i10);
            s.h(imageView, "itemView.face_img");
            y.n(imageView, Integer.valueOf(faceUiModel.getWidth()), Integer.valueOf(faceUiModel.getHeight()));
            ImageView imageView2 = (ImageView) this.itemView.findViewById(i10);
            s.h(imageView2, "itemView.face_img");
            int itemPaddingWithIcon = faceUiModel.getItemPaddingWithIcon();
            imageView2.setPadding(itemPaddingWithIcon, itemPaddingWithIcon, itemPaddingWithIcon, itemPaddingWithIcon);
            ((ImageView) this.itemView.findViewById(i10)).setBackgroundResource(faceUiModel.getItemBgRes());
        }
    }
}

package com.cupidapp.live.liveshow.beauty.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.cupidapp.live.R$drawable;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.liveshow.model.LiveStickerModel;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: FKLiveBeautyStickerListLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLiveStickerViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f14903c = new a(null);

    /* compiled from: FKLiveBeautyStickerListLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FKLiveStickerViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new FKLiveStickerViewHolder(z.b(parent, R$layout.view_holder_live_sticker, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveStickerViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
        ((TextView) itemView.findViewById(R$id.stickerName)).getPaint().setFakeBoldText(true);
        ((TextView) itemView.findViewById(R$id.sticker_subscript_textview)).getPaint().setFakeBoldText(true);
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        int i10;
        if (obj instanceof LiveStickerModel) {
            LiveStickerModel liveStickerModel = (LiveStickerModel) obj;
            if (liveStickerModel.getIcon() != null) {
                ((ImageLoaderView) this.itemView.findViewById(R$id.stickerIcon)).setImageResource(liveStickerModel.getIcon().intValue());
            } else {
                ImageLoaderView imageLoaderView = (ImageLoaderView) this.itemView.findViewById(R$id.stickerIcon);
                s.h(imageLoaderView, "itemView.stickerIcon");
                ImageLoaderView.g(imageLoaderView, liveStickerModel.getImage(), null, null, 6, null);
            }
            View findViewById = this.itemView.findViewById(R$id.sticker_bg_view);
            if (liveStickerModel.isLight() == 0) {
                i10 = R$drawable.rect_cor_100_sd_991a1a1a;
            } else {
                i10 = liveStickerModel.isSelected() ? R$drawable.rect_cor_100_sk_404040 : 0;
            }
            findViewById.setBackgroundResource(i10);
            View view = this.itemView;
            int i11 = R$id.stickerName;
            ((TextView) view.findViewById(i11)).setText(liveStickerModel.getPrivilegesName());
            ((TextView) this.itemView.findViewById(i11)).setTextColor(liveStickerModel.isSelected() ? -15066598 : -3750202);
            String subscript = liveStickerModel.getSubscript();
            boolean z10 = true;
            if (subscript == null || subscript.length() == 0) {
                TextView textView = (TextView) this.itemView.findViewById(R$id.sticker_subscript_textview);
                s.h(textView, "itemView.sticker_subscript_textview");
                textView.setVisibility(8);
            } else {
                View view2 = this.itemView;
                int i12 = R$id.sticker_subscript_textview;
                TextView textView2 = (TextView) view2.findViewById(i12);
                s.h(textView2, "itemView.sticker_subscript_textview");
                textView2.setVisibility(0);
                ((TextView) this.itemView.findViewById(i12)).setText(liveStickerModel.getSubscript());
                ((TextView) this.itemView.findViewById(i12)).setTextColor(liveStickerModel.isLight() == 0 ? -5658199 : -1);
                ((TextView) this.itemView.findViewById(i12)).setBackgroundResource(liveStickerModel.isLight() == 0 ? R$drawable.rect_cor_100_sd_393434 : R$drawable.rect_cor_100_sd_ff4040);
            }
            String expiration = liveStickerModel.getExpiration();
            if (expiration != null && expiration.length() != 0) {
                z10 = false;
            }
            if (z10) {
                TextView textView3 = (TextView) this.itemView.findViewById(R$id.sticker_expiration_textview);
                s.h(textView3, "itemView.sticker_expiration_textview");
                textView3.setVisibility(8);
            } else {
                View view3 = this.itemView;
                int i13 = R$id.sticker_expiration_textview;
                TextView textView4 = (TextView) view3.findViewById(i13);
                s.h(textView4, "itemView.sticker_expiration_textview");
                textView4.setVisibility(0);
                ((TextView) this.itemView.findViewById(i13)).setText(liveStickerModel.getExpiration());
            }
        }
    }
}

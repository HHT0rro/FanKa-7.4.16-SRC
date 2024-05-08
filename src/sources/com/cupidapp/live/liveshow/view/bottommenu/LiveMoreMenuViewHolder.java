package com.cupidapp.live.liveshow.view.bottommenu;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;
import z0.z;

/* compiled from: LiveMoreMenuAdapter.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LiveMoreMenuViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f15333c = new a(null);

    /* compiled from: LiveMoreMenuAdapter.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final LiveMoreMenuViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new LiveMoreMenuViewHolder(z.b(parent, R$layout.live_more_menu_view_holder, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveMoreMenuViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
        y.o(itemView, Integer.valueOf((z0.h.l(this) - z0.h.c(this, 34.0f)) / 5), null, 2, null);
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof LiveMoreMenuModel) {
            LiveMoreMenuModel liveMoreMenuModel = (LiveMoreMenuModel) obj;
            if (liveMoreMenuModel.getIcon() != null) {
                ((ImageLoaderView) this.itemView.findViewById(R$id.button_load_img)).setVisibility(8);
                View view = this.itemView;
                int i10 = R$id.button_img;
                ((ImageView) view.findViewById(i10)).setVisibility(0);
                ImageView imageView = (ImageView) this.itemView.findViewById(i10);
                Integer icon = liveMoreMenuModel.getIcon();
                s.f(icon);
                imageView.setImageResource(icon.intValue());
            } else if (liveMoreMenuModel.getIconImage() != null) {
                ((ImageView) this.itemView.findViewById(R$id.button_img)).setVisibility(8);
                View view2 = this.itemView;
                int i11 = R$id.button_load_img;
                ((ImageLoaderView) view2.findViewById(i11)).setVisibility(0);
                ImageLoaderView imageLoaderView = (ImageLoaderView) this.itemView.findViewById(i11);
                s.h(imageLoaderView, "itemView.button_load_img");
                ImageLoaderView.g(imageLoaderView, liveMoreMenuModel.getIconImage(), null, null, 6, null);
            }
            ((TextView) this.itemView.findViewById(R$id.button_textview)).setText(liveMoreMenuModel.getName());
            String subscript = liveMoreMenuModel.getSubscript();
            if (subscript == null || subscript.length() == 0) {
                TextView textView = (TextView) this.itemView.findViewById(R$id.subscript_textview);
                s.h(textView, "itemView.subscript_textview");
                textView.setVisibility(8);
            } else {
                View view3 = this.itemView;
                int i12 = R$id.subscript_textview;
                TextView textView2 = (TextView) view3.findViewById(i12);
                s.h(textView2, "itemView.subscript_textview");
                textView2.setVisibility(0);
                ((TextView) this.itemView.findViewById(i12)).setText(liveMoreMenuModel.getSubscript());
            }
            View findViewById = this.itemView.findViewById(R$id.btn_red_dot_view);
            s.h(findViewById, "itemView.btn_red_dot_view");
            findViewById.setVisibility(liveMoreMenuModel.getShowRedDot() ? 0 : 8);
        }
    }
}

package com.cupidapp.live.match.holder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.match.model.TitleViewModel;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: SettingStyleTitleViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class SettingStyleTitleViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f16822c = new a(null);

    /* compiled from: SettingStyleTitleViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final SettingStyleTitleViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new SettingStyleTitleViewHolder(z.b(parent, R$layout.view_holder_setting_style_title, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingStyleTitleViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof TitleViewModel) {
            TitleViewModel titleViewModel = (TitleViewModel) obj;
            ((TextView) this.itemView.findViewById(R$id.titleTextView)).setText(titleViewModel.getTitle());
            ((TextView) this.itemView.findViewById(R$id.not_need_set_location_range_tip)).setVisibility(titleViewModel.getFromNearby() ? 0 : 8);
            ((ImageView) this.itemView.findViewById(R$id.titleAfterIconImageView)).setVisibility(titleViewModel.getShowVipIcon() ? 0 : 8);
        }
    }
}

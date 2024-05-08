package com.cupidapp.live.consult.viewholder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.consult.model.ConsultListModel;
import com.cupidapp.live.profile.model.User;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;
import z0.u;
import z0.y;
import z0.z;

/* compiled from: ConsultListViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ConsultListViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f13895c = new a(null);

    /* compiled from: ConsultListViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ConsultListViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new ConsultListViewHolder(z.b(parent, R$layout.view_holder_consult_list, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConsultListViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
        y.o(itemView, Integer.valueOf((h.l(this) - h.c(this, 11.0f)) / 2), null, 2, null);
        TextView textView = (TextView) itemView.findViewById(R$id.consult_live_title_textview);
        s.h(textView, "itemView.consult_live_title_textview");
        u.a(textView);
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof ConsultListModel) {
            ImageLoaderView imageLoaderView = (ImageLoaderView) this.itemView.findViewById(R$id.consult_live_cover_imageview);
            s.h(imageLoaderView, "itemView.consult_live_cover_imageview");
            ConsultListModel consultListModel = (ConsultListModel) obj;
            ImageLoaderView.g(imageLoaderView, consultListModel.getCover(), null, null, 6, null);
            ((TextView) this.itemView.findViewById(R$id.consult_live_title_textview)).setText(consultListModel.getTitle());
            TextView textView = (TextView) this.itemView.findViewById(R$id.consult_user_name_textview);
            User user = consultListModel.getUser();
            textView.setText(user != null ? user.getName() : null);
            ((LinearLayout) this.itemView.findViewById(R$id.consult_connect_layout)).setVisibility(s.d(consultListModel.getChating(), Boolean.TRUE) ? 0 : 8);
            if (consultListModel.getCategoryIcon() == null) {
                ((ImageLoaderView) this.itemView.findViewById(R$id.consult_category_imageview)).setVisibility(8);
                return;
            }
            View view = this.itemView;
            int i10 = R$id.consult_category_imageview;
            ((ImageLoaderView) view.findViewById(i10)).setVisibility(0);
            int scaleWidthByHeight = consultListModel.getCategoryIcon().getScaleWidthByHeight(h.c(this, 22.0f));
            ImageLoaderView imageLoaderView2 = (ImageLoaderView) this.itemView.findViewById(i10);
            s.h(imageLoaderView2, "itemView.consult_category_imageview");
            y.o(imageLoaderView2, Integer.valueOf(scaleWidthByHeight), null, 2, null);
            ImageLoaderView imageLoaderView3 = (ImageLoaderView) this.itemView.findViewById(i10);
            s.h(imageLoaderView3, "itemView.consult_category_imageview");
            ImageLoaderView.g(imageLoaderView3, consultListModel.getCategoryIcon(), null, null, 6, null);
        }
    }
}

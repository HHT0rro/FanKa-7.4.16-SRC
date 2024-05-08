package com.cupidapp.live.visitors.viewholder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.BlurModel;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.imageloader.b;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.view.RoundedFrameLayout;
import com.cupidapp.live.base.view.UserIconViewLayout;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.visitors.model.VisitorModel;
import com.cupidapp.live.visitors.model.VisitorsSquareStyleModel;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;
import z0.u;
import z0.y;
import z0.z;

/* compiled from: VisitorsSquareStyleViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class VisitorsSquareStyleViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f18967c = new a(null);

    /* compiled from: VisitorsSquareStyleViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final VisitorsSquareStyleViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new VisitorsSquareStyleViewHolder(z.b(parent, R$layout.view_holder_visitors_square_style, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VisitorsSquareStyleViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
        ((RoundedFrameLayout) itemView.findViewById(R$id.visitor_root_rounded_layout)).setCornerRadius(h.c(this, 12.0f));
        int l10 = (h.l(this) - (h.c(this, 8.0f) * 3)) / 2;
        ImageLoaderView imageLoaderView = (ImageLoaderView) itemView.findViewById(R$id.visitor_avatar_img);
        s.h(imageLoaderView, "itemView.visitor_avatar_img");
        y.n(imageLoaderView, Integer.valueOf(l10), Integer.valueOf((int) ((l10 * 4) / 3.0f)));
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof VisitorsSquareStyleModel) {
            View view = this.itemView;
            int i10 = R$id.visitor_user_name_text;
            TextView textView = (TextView) view.findViewById(i10);
            s.h(textView, "itemView.visitor_user_name_text");
            u.a(textView);
            View view2 = this.itemView;
            int i11 = R$id.visitor_marketing_info_text;
            TextView textView2 = (TextView) view2.findViewById(i11);
            s.h(textView2, "itemView.visitor_marketing_info_text");
            u.a(textView2);
            VisitorsSquareStyleModel visitorsSquareStyleModel = (VisitorsSquareStyleModel) obj;
            VisitorModel visitorModel = visitorsSquareStyleModel.getVisitorModel();
            User user = visitorModel.getUser();
            this.itemView.findViewById(R$id.visitor_on_line_tag_view).setVisibility(user != null && user.getOnline() ? 0 : 8);
            ((TextView) this.itemView.findViewById(R$id.visitor_user_info_text)).setText(visitorModel.getSummaryInfo());
            if (visitorsSquareStyleModel.getVisitorEnable()) {
                ImageLoaderView imageLoaderView = (ImageLoaderView) this.itemView.findViewById(R$id.visitor_avatar_img);
                s.h(imageLoaderView, "itemView.visitor_avatar_img");
                ImageLoaderView.g(imageLoaderView, user != null ? user.getAvatarImage() : null, new b(false, null, null, null, null, null, null, 0, 0, null, null, null, null, false, 0, 0, false, null, null, 520191, null), null, 4, null);
                ((TextView) this.itemView.findViewById(i10)).setVisibility(0);
                ((TextView) this.itemView.findViewById(i10)).setText(user != null ? user.getName() : null);
                UserIconViewLayout userIconViewLayout = (UserIconViewLayout) this.itemView.findViewById(R$id.visitor_user_vip_img);
                s.h(userIconViewLayout, "itemView.visitor_user_vip_img");
                UserIconViewLayout.d(userIconViewLayout, user != null ? user.getUserVipModel() : null, SensorPosition.Unknown, UserIconViewLayout.VipIconPositionRef.Other, false, 8, null);
                ((TextView) this.itemView.findViewById(i11)).setVisibility(8);
                return;
            }
            ImageLoaderView imageLoaderView2 = (ImageLoaderView) this.itemView.findViewById(R$id.visitor_avatar_img);
            s.h(imageLoaderView2, "itemView.visitor_avatar_img");
            ImageLoaderView.g(imageLoaderView2, user != null ? user.getAvatarImage() : null, new b(false, null, null, null, null, null, null, 0, 0, null, null, null, new BlurModel(20.0f, 0, 2, null), false, 0, 0, false, null, null, 520191, null), null, 4, null);
            ((TextView) this.itemView.findViewById(i10)).setVisibility(8);
            ((UserIconViewLayout) this.itemView.findViewById(R$id.visitor_user_vip_img)).setVisibility(8);
            String marketingName = visitorModel.getMarketingName();
            if (marketingName == null || marketingName.length() == 0) {
                ((TextView) this.itemView.findViewById(i11)).setVisibility(8);
            } else {
                ((TextView) this.itemView.findViewById(i11)).setVisibility(0);
                ((TextView) this.itemView.findViewById(i11)).setText(visitorModel.getMarketingName());
            }
        }
    }
}

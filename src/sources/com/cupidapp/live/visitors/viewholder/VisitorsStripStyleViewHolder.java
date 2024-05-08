package com.cupidapp.live.visitors.viewholder;

import android.graphics.BlurMaskFilter;
import android.text.SpannableStringBuilder;
import android.text.style.MaskFilterSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.cupidapp.live.R$drawable;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.imageloader.BlurModel;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.imageloader.b;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.utils.h;
import com.cupidapp.live.base.view.UserIconViewLayout;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.visitors.model.VisitorModel;
import com.cupidapp.live.visitors.model.VisitorsStripStyleModel;
import com.huawei.appgallery.agd.common.utils.StringUtils;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.u;
import z0.z;

/* compiled from: VisitorsStripStyleViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class VisitorsStripStyleViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f18968c = new a(null);

    /* compiled from: VisitorsStripStyleViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final VisitorsStripStyleViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new VisitorsStripStyleViewHolder(z.b(parent, R$layout.view_holder_visitors_strip_style, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VisitorsStripStyleViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        String str;
        if (obj instanceof VisitorsStripStyleModel) {
            View view = this.itemView;
            int i10 = R$id.visitor_name_text;
            TextView textView = (TextView) view.findViewById(i10);
            s.h(textView, "itemView.visitor_name_text");
            u.a(textView);
            TextView textView2 = (TextView) this.itemView.findViewById(R$id.visitor_marketing_btn);
            s.h(textView2, "itemView.visitor_marketing_btn");
            u.a(textView2);
            VisitorsStripStyleModel visitorsStripStyleModel = (VisitorsStripStyleModel) obj;
            VisitorModel visitorModel = visitorsStripStyleModel.getVisitorModel();
            User user = visitorModel.getUser();
            if (visitorsStripStyleModel.getVisitorEnable()) {
                ImageLoaderView imageLoaderView = (ImageLoaderView) this.itemView.findViewById(R$id.visitor_avatar_img);
                s.h(imageLoaderView, "itemView.visitor_avatar_img");
                ImageLoaderView.g(imageLoaderView, user != null ? user.getAvatarImage() : null, new b(false, null, null, null, null, null, null, 0, 0, null, null, null, null, false, 0, 0, false, null, null, 520191, null), null, 4, null);
                ((TextView) this.itemView.findViewById(i10)).setText(user != null ? user.getName() : null);
                UserIconViewLayout userIconViewLayout = (UserIconViewLayout) this.itemView.findViewById(R$id.visitor_user_vip_img);
                s.h(userIconViewLayout, "itemView.visitor_user_vip_img");
                UserIconViewLayout.d(userIconViewLayout, user != null ? user.getUserVipModel() : null, SensorPosition.Unknown, UserIconViewLayout.VipIconPositionRef.Other, false, 8, null);
            } else {
                ImageLoaderView imageLoaderView2 = (ImageLoaderView) this.itemView.findViewById(R$id.visitor_avatar_img);
                s.h(imageLoaderView2, "itemView.visitor_avatar_img");
                ImageLoaderView.g(imageLoaderView2, user != null ? user.getAvatarImage() : null, new b(false, null, null, null, null, null, null, 0, 0, null, null, null, new BlurModel(0.0f, 0, 3, null), false, 0, 0, false, null, null, 520191, null), null, 4, null);
                String marketingName = visitorModel.getMarketingName();
                if (marketingName == null || marketingName.length() == 0) {
                    if (user == null || (str = user.getName()) == null) {
                        str = "";
                    }
                    t(str, Boolean.TRUE);
                } else {
                    t(marketingName, Boolean.FALSE);
                }
                ((UserIconViewLayout) this.itemView.findViewById(R$id.visitor_user_vip_img)).setVisibility(8);
            }
            this.itemView.findViewById(R$id.visitor_on_line_view).setVisibility(user != null && user.getOnline() ? 0 : 8);
            u(visitorModel);
            ((TextView) this.itemView.findViewById(R$id.visitor_summary_info_text)).setText(visitorModel.getSummaryInfo());
            r(visitorModel, visitorsStripStyleModel.getVisitorEnable());
        }
    }

    public final void r(VisitorModel visitorModel, boolean z10) {
        if (!z10) {
            String marketingBtnName = visitorModel.getMarketingBtnName();
            if (!(marketingBtnName == null || marketingBtnName.length() == 0)) {
                View view = this.itemView;
                int i10 = R$id.visitor_marketing_btn;
                ((TextView) view.findViewById(i10)).setVisibility(0);
                ((TextView) this.itemView.findViewById(i10)).setText(visitorModel.getMarketingBtnName());
                if (s.d(visitorModel.getMarketingBtnBold(), Boolean.TRUE)) {
                    ((TextView) this.itemView.findViewById(i10)).setBackgroundResource(R$drawable.rect_cor_100_sd_ff4040);
                    ((TextView) this.itemView.findViewById(i10)).setTextColor(-1);
                    return;
                } else {
                    ((TextView) this.itemView.findViewById(i10)).setBackgroundResource(R$drawable.rect_cor_100_sd_ffeded);
                    ((TextView) this.itemView.findViewById(i10)).setTextColor(-49088);
                    return;
                }
            }
        }
        ((TextView) this.itemView.findViewById(R$id.visitor_marketing_btn)).setVisibility(8);
    }

    public final void s(int i10, int i11) {
        ((LinearLayout) this.itemView.findViewById(R$id.visitor_tag_list_layout)).setVisibility(0);
        View view = this.itemView;
        int i12 = R$id.visitor_relation_ship_text;
        ((TextView) view.findViewById(i12)).setVisibility(0);
        TextView textView = (TextView) this.itemView.findViewById(i12);
        s.h(textView, "itemView.visitor_relation_ship_text");
        u.e(textView, i10, 0, 0, 0, 14, null);
        ((TextView) this.itemView.findViewById(i12)).setText(this.itemView.getContext().getString(i11));
    }

    public final void t(String str, Boolean bool) {
        SpannableStringBuilder j10 = q1.d.f53006a.j(str, StringUtils.NO_PRINT_CODE, -49088);
        if (s.d(bool, Boolean.TRUE)) {
            ((TextView) this.itemView.findViewById(R$id.visitor_name_text)).setTextColor(h.a(-15066598, 0.2f));
            j10.setSpan(new MaskFilterSpan(new BlurMaskFilter(15.0f, BlurMaskFilter.Blur.NORMAL)), 0, j10.length(), 33);
        } else {
            ((TextView) this.itemView.findViewById(R$id.visitor_name_text)).setTextColor(-15066598);
        }
        ((TextView) this.itemView.findViewById(R$id.visitor_name_text)).setText(j10);
    }

    public final void u(VisitorModel visitorModel) {
        User user = visitorModel.getUser();
        if (user != null && user.getMatch()) {
            s(R$mipmap.icon_relation_match, R$string.already_matched);
        } else {
            if (user != null && user.getAloha()) {
                s(R$mipmap.icon_relation_aloha, R$string.i_followed_him);
            } else {
                if ((user != null && user.getAlohaGet()) && user.getAlohaGetShow()) {
                    s(R$mipmap.icon_relation_aloha_get, R$string.he_followed_me);
                } else {
                    ((TextView) this.itemView.findViewById(R$id.visitor_relation_ship_text)).setVisibility(8);
                }
            }
        }
        if (s.d(visitorModel.getVisitMeOften(), Boolean.TRUE)) {
            ((LinearLayout) this.itemView.findViewById(R$id.visitor_tag_list_layout)).setVisibility(0);
            ((ImageView) this.itemView.findViewById(R$id.visitor_often_visit_prompt)).setVisibility(0);
        } else {
            ((ImageView) this.itemView.findViewById(R$id.visitor_often_visit_prompt)).setVisibility(8);
        }
        if (((TextView) this.itemView.findViewById(R$id.visitor_relation_ship_text)).getVisibility() != 0 && ((ImageView) this.itemView.findViewById(R$id.visitor_often_visit_prompt)).getVisibility() != 0) {
            ((LinearLayout) this.itemView.findViewById(R$id.visitor_tag_list_layout)).setVisibility(8);
        } else {
            ((LinearLayout) this.itemView.findViewById(R$id.visitor_tag_list_layout)).setVisibility(0);
        }
    }
}

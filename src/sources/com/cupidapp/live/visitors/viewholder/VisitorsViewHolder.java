package com.cupidapp.live.visitors.viewholder;

import android.graphics.BlurMaskFilter;
import android.text.SpannableStringBuilder;
import android.text.style.MaskFilterSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
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
import com.cupidapp.live.visitors.model.VisitorsViewModel;
import com.huawei.appgallery.agd.common.utils.StringUtils;
import java.util.Arrays;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.jvm.internal.y;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.u;
import z0.v;
import z0.z;

/* compiled from: VisitorsViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class VisitorsViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f18970c = new a(null);

    /* compiled from: VisitorsViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final VisitorsViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new VisitorsViewHolder(z.b(parent, R$layout.view_holder_visitors, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VisitorsViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        SpannableStringBuilder spannableStringBuilder;
        String name;
        if (obj instanceof VisitorsViewModel) {
            View view = this.itemView;
            int i10 = R$id.visitorName;
            ((TextView) view.findViewById(i10)).getPaint().setFakeBoldText(true);
            VisitorsViewModel visitorsViewModel = (VisitorsViewModel) obj;
            VisitorModel visitorModel = visitorsViewModel.getVisitorModel();
            User user = visitorModel.getUser();
            String str = null;
            if (visitorsViewModel.getVisitorEnable()) {
                ImageLoaderView imageLoaderView = (ImageLoaderView) this.itemView.findViewById(R$id.visitorAvatar);
                s.h(imageLoaderView, "itemView.visitorAvatar");
                ImageLoaderView.g(imageLoaderView, user != null ? user.getAvatarImage() : null, new b(false, null, null, null, null, null, null, 0, 0, null, null, null, null, false, 0, 0, false, null, null, 520191, null), null, 4, null);
                View view2 = this.itemView;
                int i11 = R$id.visitorVipImage;
                ((UserIconViewLayout) view2.findViewById(i11)).setClickable(true);
                ((UserIconViewLayout) this.itemView.findViewById(i11)).setEnabled(true);
                ((TextView) this.itemView.findViewById(i10)).setText(user != null ? user.getName() : null);
                ((TextView) this.itemView.findViewById(i10)).setTextColor(-15066598);
            } else {
                ImageLoaderView imageLoaderView2 = (ImageLoaderView) this.itemView.findViewById(R$id.visitorAvatar);
                s.h(imageLoaderView2, "itemView.visitorAvatar");
                ImageLoaderView.g(imageLoaderView2, user != null ? user.getAvatarImage() : null, new b(false, null, null, null, null, null, null, 0, 0, null, null, null, new BlurModel(0.0f, 0, 3, null), false, 0, 0, false, null, null, 520191, null), null, 4, null);
                View view3 = this.itemView;
                int i12 = R$id.visitorVipImage;
                ((UserIconViewLayout) view3.findViewById(i12)).setClickable(false);
                ((UserIconViewLayout) this.itemView.findViewById(i12)).setEnabled(false);
                TextView textView = (TextView) this.itemView.findViewById(i10);
                if (user == null || (name = user.getName()) == null) {
                    spannableStringBuilder = null;
                } else {
                    spannableStringBuilder = q1.d.f53006a.j(name, StringUtils.NO_PRINT_CODE, -49088);
                    if (user.getNameMask()) {
                        ((TextView) this.itemView.findViewById(i10)).setTextColor(h.a(-15066598, 0.2f));
                        spannableStringBuilder.setSpan(new MaskFilterSpan(new BlurMaskFilter(15.0f, BlurMaskFilter.Blur.NORMAL)), 0, spannableStringBuilder.length(), 33);
                    } else {
                        ((TextView) this.itemView.findViewById(i10)).setTextColor(-15066598);
                    }
                }
                textView.setText(spannableStringBuilder);
            }
            if (user != null) {
                UserIconViewLayout userIconViewLayout = (UserIconViewLayout) this.itemView.findViewById(R$id.visitorVipImage);
                s.h(userIconViewLayout, "itemView.visitorVipImage");
                UserIconViewLayout.d(userIconViewLayout, user.getUserVipModel(), SensorPosition.Unknown, UserIconViewLayout.VipIconPositionRef.Other, false, 8, null);
                Boolean useLocalTime = visitorModel.getUseLocalTime();
                Boolean bool = Boolean.TRUE;
                if (s.d(useLocalTime, bool) && visitorModel.getVisitorTimeMillis() != null) {
                    str = v.a(visitorModel.getVisitorTimeMillis().longValue(), this.itemView.getContext());
                } else if (visitorModel.getVisitorTimeStr() != null) {
                    str = visitorModel.getVisitorTimeStr();
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                if (user.getRole() != null) {
                    y yVar = y.f51038a;
                    String string = this.itemView.getContext().getString(R$string.center_of_the_dot);
                    s.h(string, "itemView.context.getStri…string.center_of_the_dot)");
                    String format = String.format(string, Arrays.copyOf(new Object[]{user.getRole()}, 1));
                    s.h(format, "format(format, *args)");
                    sb2.append(format);
                }
                if (user.getAge() != null) {
                    y yVar2 = y.f51038a;
                    String string2 = this.itemView.getContext().getString(R$string.center_of_the_dot);
                    s.h(string2, "itemView.context.getStri…string.center_of_the_dot)");
                    String format2 = String.format(string2, Arrays.copyOf(new Object[]{this.itemView.getContext().getString(R$string.comma_and_user_age, user.getAge())}, 1));
                    s.h(format2, "format(format, *args)");
                    sb2.append(format2);
                }
                if (user.getLocationInfo() != null) {
                    y yVar3 = y.f51038a;
                    String string3 = this.itemView.getContext().getString(R$string.center_of_the_dot);
                    s.h(string3, "itemView.context.getStri…string.center_of_the_dot)");
                    String format3 = String.format(string3, Arrays.copyOf(new Object[]{user.getLocationInfo()}, 1));
                    s.h(format3, "format(format, *args)");
                    sb2.append(format3);
                }
                ((TextView) this.itemView.findViewById(R$id.visitTimeAndLocation)).setText(sb2);
                ((TextView) this.itemView.findViewById(R$id.oftenVisitPrompt)).setVisibility(s.d(visitorModel.getVisitMeOften(), bool) ? 0 : 8);
                this.itemView.findViewById(R$id.visitor_on_line_tag).setVisibility(user.getOnline() ? 0 : 8);
                if (user.getMatch()) {
                    r(R$mipmap.icon_relation_match, R$string.already_matched);
                    return;
                }
                if (user.getAloha()) {
                    r(R$mipmap.icon_relation_aloha, R$string.i_followed_him);
                } else if (user.getAlohaGet() && user.getAlohaGetShow()) {
                    r(R$mipmap.icon_relation_aloha_get, R$string.he_followed_me);
                } else {
                    ((TextView) this.itemView.findViewById(R$id.relationshipTextView)).setVisibility(4);
                }
            }
        }
    }

    public final void r(int i10, int i11) {
        View view = this.itemView;
        int i12 = R$id.relationshipTextView;
        ((TextView) view.findViewById(i12)).getPaint().setFakeBoldText(true);
        ((TextView) this.itemView.findViewById(i12)).setVisibility(0);
        TextView textView = (TextView) this.itemView.findViewById(i12);
        s.h(textView, "itemView.relationshipTextView");
        u.e(textView, i10, 0, 0, 0, 14, null);
        ((TextView) this.itemView.findViewById(i12)).setText(this.itemView.getContext().getString(i11));
    }
}

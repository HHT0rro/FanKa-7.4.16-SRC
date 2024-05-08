package com.cupidapp.live.notify.viewholder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.imageloader.BlurModel;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.imageloader.b;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.base.view.RoundedFrameLayout;
import com.cupidapp.live.notify.model.AttentionNotifyModel;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.superlike.view.SuperLikeTagView;
import java.util.Arrays;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;
import z0.u;
import z0.y;
import z0.z;

/* compiled from: AttentionViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class AttentionViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f17573c = new a(null);

    /* compiled from: AttentionViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final AttentionViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new AttentionViewHolder(z.b(parent, R$layout.view_holder_attention_list, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AttentionViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
        ((RoundedFrameLayout) itemView.findViewById(R$id.attentionRootLayout)).setCornerRadius(h.c(this, 8.0f));
        TextView textView = (TextView) itemView.findViewById(R$id.attentionUserName);
        s.h(textView, "itemView.attentionUserName");
        u.a(textView);
        TextView textView2 = (TextView) itemView.findViewById(R$id.attentionDistance);
        s.h(textView2, "itemView.attentionDistance");
        u.a(textView2);
        TextView textView3 = (TextView) itemView.findViewById(R$id.attentionUserAge);
        s.h(textView3, "itemView.attentionUserAge");
        u.a(textView3);
        TextView textView4 = (TextView) itemView.findViewById(R$id.rainbow_recommend_tag_view);
        s.h(textView4, "itemView.rainbow_recommend_tag_view");
        u.a(textView4);
        int l10 = (h.l(this) - (h.c(this, 8.0f) * 3)) / 2;
        ImageLoaderView imageLoaderView = (ImageLoaderView) itemView.findViewById(R$id.attentionUserAvatarImageView);
        s.h(imageLoaderView, "itemView.attentionUserAvatarImageView");
        y.n(imageLoaderView, Integer.valueOf(l10), Integer.valueOf((l10 * 4) / 3));
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        String str;
        int i10;
        if (obj instanceof AttentionNotifyModel) {
            AttentionNotifyModel attentionNotifyModel = (AttentionNotifyModel) obj;
            User fromUser = attentionNotifyModel.getFromUser();
            if (attentionNotifyModel.getShowMosaic()) {
                ImageLoaderView imageLoaderView = (ImageLoaderView) this.itemView.findViewById(R$id.attentionUserAvatarImageView);
                s.h(imageLoaderView, "itemView.attentionUserAvatarImageView");
                ImageLoaderView.g(imageLoaderView, fromUser.getAvatarImage(), new b(false, null, null, null, null, null, null, 0, 0, null, null, null, new BlurModel(9.0f, 0, 2, null), false, 0, 0, false, null, null, 520191, null), null, 4, null);
                View view = this.itemView;
                int i11 = R$id.attentionDistance;
                TextView textView = (TextView) view.findViewById(i11);
                if (fromUser.getLocationInfo() != null) {
                    ((TextView) this.itemView.findViewById(i11)).setText(fromUser.getLocationInfo());
                    i10 = 0;
                } else {
                    i10 = 8;
                }
                textView.setVisibility(i10);
                ((TextView) this.itemView.findViewById(R$id.attentionUserName)).setVisibility(8);
                ((RelativeLayout) this.itemView.findViewById(R$id.relationLayout)).setVisibility(8);
                if (fromUser.getAge() != null) {
                    View view2 = this.itemView;
                    int i12 = R$id.attentionUserAge;
                    ((TextView) view2.findViewById(i12)).setVisibility(0);
                    TextView textView2 = (TextView) this.itemView.findViewById(i12);
                    kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f51038a;
                    String string = this.itemView.getContext().getString(R$string.user_age);
                    s.h(string, "itemView.context.getString(R.string.user_age)");
                    String format = String.format(string, Arrays.copyOf(new Object[]{fromUser.getAge().toString()}, 1));
                    s.h(format, "format(format, *args)");
                    textView2.setText(format);
                } else {
                    ((TextView) this.itemView.findViewById(R$id.attentionUserAge)).setVisibility(8);
                }
            } else {
                ImageLoaderView imageLoaderView2 = (ImageLoaderView) this.itemView.findViewById(R$id.attentionUserAvatarImageView);
                s.h(imageLoaderView2, "itemView.attentionUserAvatarImageView");
                ImageLoaderView.g(imageLoaderView2, fromUser.getAvatarImage(), new b(false, null, null, null, null, null, null, 0, 0, null, null, null, null, false, 0, 0, false, null, null, 520191, null), null, 4, null);
                ((TextView) this.itemView.findViewById(R$id.attentionDistance)).setVisibility(8);
                View view3 = this.itemView;
                int i13 = R$id.attentionUserName;
                ((TextView) view3.findViewById(i13)).setText(fromUser.getName());
                ((TextView) this.itemView.findViewById(i13)).setVisibility(0);
                ((RelativeLayout) this.itemView.findViewById(R$id.relationLayout)).setVisibility(0);
                r(fromUser);
                TextView textView3 = (TextView) this.itemView.findViewById(R$id.attentionUserAge);
                if (fromUser.getAge() != null) {
                    kotlin.jvm.internal.y yVar2 = kotlin.jvm.internal.y.f51038a;
                    String string2 = this.itemView.getContext().getString(R$string.user_age);
                    s.h(string2, "itemView.context.getString(R.string.user_age)");
                    String format2 = String.format(string2, Arrays.copyOf(new Object[]{fromUser.getAge().toString()}, 1));
                    s.h(format2, "format(format, *args)");
                    str = ", " + format2;
                } else {
                    str = "";
                }
                textView3.setText(str);
            }
            ((SuperLikeTagView) this.itemView.findViewById(R$id.attention_super_like_me_img)).c(fromUser.getSuperLikedMeCombos());
            this.itemView.findViewById(R$id.notify_attention_unread_red_dot).setVisibility(attentionNotifyModel.getUnread() ? 0 : 8);
            Integer specialLabelType = attentionNotifyModel.getSpecialLabelType();
            if (specialLabelType != null && specialLabelType.intValue() == 1) {
                ((ImageView) this.itemView.findViewById(R$id.travel_tag_view)).setVisibility(0);
                return;
            }
            String userSpecialLabel = attentionNotifyModel.getUserSpecialLabel();
            if (userSpecialLabel == null || userSpecialLabel.length() == 0) {
                TextView textView4 = (TextView) this.itemView.findViewById(R$id.rainbow_recommend_tag_view);
                s.h(textView4, "itemView.rainbow_recommend_tag_view");
                textView4.setVisibility(8);
            } else {
                View view4 = this.itemView;
                int i14 = R$id.rainbow_recommend_tag_view;
                TextView textView5 = (TextView) view4.findViewById(i14);
                s.h(textView5, "itemView.rainbow_recommend_tag_view");
                textView5.setVisibility(0);
                ((TextView) this.itemView.findViewById(i14)).setText(attentionNotifyModel.getUserSpecialLabel());
            }
            ((ImageView) this.itemView.findViewById(R$id.travel_tag_view)).setVisibility(8);
        }
    }

    public final void r(User user) {
        if (user.getMatch()) {
            ((ImageView) this.itemView.findViewById(R$id.followImageButton)).setVisibility(8);
            ((ImageView) this.itemView.findViewById(R$id.chatImageButton)).setVisibility(0);
            ((ImageView) this.itemView.findViewById(R$id.followedImageButton)).setVisibility(8);
        } else if (user.getAloha()) {
            ((ImageView) this.itemView.findViewById(R$id.followImageButton)).setVisibility(8);
            ((ImageView) this.itemView.findViewById(R$id.chatImageButton)).setVisibility(8);
            ((ImageView) this.itemView.findViewById(R$id.followedImageButton)).setVisibility(0);
        } else {
            ((ImageView) this.itemView.findViewById(R$id.followImageButton)).setVisibility(0);
            ((ImageView) this.itemView.findViewById(R$id.chatImageButton)).setVisibility(8);
            ((ImageView) this.itemView.findViewById(R$id.followedImageButton)).setVisibility(8);
        }
    }
}

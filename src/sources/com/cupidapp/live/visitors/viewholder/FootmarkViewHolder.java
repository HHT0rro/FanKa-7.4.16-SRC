package com.cupidapp.live.visitors.viewholder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorScene;
import com.cupidapp.live.base.view.UserIconViewLayout;
import com.cupidapp.live.track.group.GroupOthersLog;
import com.cupidapp.live.visitors.model.FootmarkModel;
import java.util.Arrays;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.jvm.internal.y;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.u;
import z0.z;

/* compiled from: FootmarkViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FootmarkViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f18963c = new a(null);

    /* compiled from: FootmarkViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FootmarkViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new FootmarkViewHolder(z.b(parent, R$layout.item_footmark, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FootmarkViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        int i10;
        if (obj instanceof FootmarkModel) {
            ImageLoaderView imageLoaderView = (ImageLoaderView) this.itemView.findViewById(R$id.item_footmark_avatar_img);
            s.h(imageLoaderView, "itemView.item_footmark_avatar_img");
            FootmarkModel footmarkModel = (FootmarkModel) obj;
            ImageLoaderView.g(imageLoaderView, footmarkModel.getUser().getAvatarImage(), null, null, 6, null);
            View view = this.itemView;
            int i11 = R$id.item_footmark_name_txt;
            ((TextView) view.findViewById(i11)).getPaint().setFakeBoldText(true);
            ((TextView) this.itemView.findViewById(i11)).setText(footmarkModel.getUser().getName());
            UserIconViewLayout userIconViewLayout = (UserIconViewLayout) this.itemView.findViewById(R$id.footmarkVipImage);
            s.h(userIconViewLayout, "itemView.footmarkVipImage");
            UserIconViewLayout.d(userIconViewLayout, footmarkModel.getUser().getUserVipModel(), SensorPosition.Unknown, UserIconViewLayout.VipIconPositionRef.Other, false, 8, null);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(footmarkModel.getTimeStr());
            if (footmarkModel.getUser().getAge() != null) {
                y yVar = y.f51038a;
                String string = this.itemView.getContext().getString(R$string.center_of_the_dot);
                s.h(string, "itemView.context.getStri…string.center_of_the_dot)");
                String format = String.format(string, Arrays.copyOf(new Object[]{this.itemView.getContext().getString(R$string.comma_and_user_age, footmarkModel.getUser().getAge())}, 1));
                s.h(format, "format(format, *args)");
                sb2.append(format);
            }
            y yVar2 = y.f51038a;
            String string2 = this.itemView.getContext().getString(R$string.center_of_the_dot);
            s.h(string2, "itemView.context.getStri…string.center_of_the_dot)");
            String format2 = String.format(string2, Arrays.copyOf(new Object[]{footmarkModel.getUser().getLocationInfo()}, 1));
            s.h(format2, "format(format, *args)");
            sb2.append(format2);
            ((TextView) this.itemView.findViewById(R$id.item_footmark_distance)).setText(sb2);
            ImageView imageView = (ImageView) this.itemView.findViewById(R$id.ic_footmark_del_img);
            if (s.d(footmarkModel.isFootmarkHidden(), Boolean.FALSE) && getAdapterPosition() == 2) {
                GroupOthersLog.M(GroupOthersLog.f18702a, GroupOthersLog.GuideType.DELETE_VISIT_RECORD, SensorPosition.HideFootmark, SensorScene.Footmark, null, 8, null);
                i10 = 0;
            } else {
                i10 = 8;
            }
            imageView.setVisibility(i10);
            ((TextView) this.itemView.findViewById(R$id.item_footmark_foot_txt)).setVisibility(s.d(footmarkModel.isFootmarkHidden(), Boolean.TRUE) ? 0 : 4);
            ((TextView) this.itemView.findViewById(R$id.item_footmark_relation_txt)).setVisibility(4);
            if (footmarkModel.getUser().getMatch()) {
                r(R$mipmap.icon_relation_match, R$string.already_matched);
                return;
            }
            if (footmarkModel.getUser().getAloha()) {
                r(R$mipmap.icon_relation_aloha, R$string.i_followed_him);
            } else if (footmarkModel.getUser().getAlohaGet() && footmarkModel.getUser().getAlohaGetShow()) {
                r(R$mipmap.icon_relation_aloha_get, R$string.he_followed_me);
            }
        }
    }

    public final void r(@DrawableRes int i10, int i11) {
        View view = this.itemView;
        int i12 = R$id.item_footmark_relation_txt;
        ((TextView) view.findViewById(i12)).setText(this.itemView.getContext().getString(i11));
        TextView textView = (TextView) this.itemView.findViewById(i12);
        s.h(textView, "itemView.item_footmark_relation_txt");
        u.e(textView, i10, 0, 0, 0, 14, null);
        ((TextView) this.itemView.findViewById(i12)).setVisibility(0);
    }
}

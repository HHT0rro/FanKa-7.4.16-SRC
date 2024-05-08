package com.cupidapp.live.chat.viewholder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.profile.model.User;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;
import z0.y;
import z0.z;

/* compiled from: FKNewMatchUserItemViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKNewMatchUserItemViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f13253c = new a(null);

    /* renamed from: d, reason: collision with root package name */
    public static int f13254d;

    /* renamed from: e, reason: collision with root package name */
    public static int f13255e;

    /* compiled from: FKNewMatchUserItemViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FKNewMatchUserItemViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new FKNewMatchUserItemViewHolder(z.b(parent, R$layout.view_holder_new_match_user_item, false, 2, null));
        }

        public final int b() {
            return FKNewMatchUserItemViewHolder.f13255e;
        }
    }

    static {
        int l10 = (int) ((h.l(r0) - (h.c(r0, 8.0f) * 4)) / 3.5f);
        f13254d = l10;
        f13255e = (int) (l10 * 1.3f);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKNewMatchUserItemViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
        View findViewById = itemView.findViewById(R$id.new_match_bg);
        s.h(findViewById, "itemView.new_match_bg");
        y.n(findViewById, Integer.valueOf(f13254d + h.c(this, 8.0f)), Integer.valueOf(f13255e + h.c(this, 8.0f)));
        ImageLoaderView imageLoaderView = (ImageLoaderView) itemView.findViewById(R$id.new_match_user_avatar_image);
        s.h(imageLoaderView, "itemView.new_match_user_avatar_image");
        y.n(imageLoaderView, Integer.valueOf(f13254d), Integer.valueOf(f13255e));
        ((TextView) itemView.findViewById(R$id.new_match_user_name)).getPaint().setFakeBoldText(true);
        ((TextView) itemView.findViewById(R$id.new_match_tag)).getPaint().setFakeBoldText(true);
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof NewMatchUserModel) {
            NewMatchUserModel newMatchUserModel = (NewMatchUserModel) obj;
            User user = newMatchUserModel.getUser();
            ImageLoaderView imageLoaderView = (ImageLoaderView) this.itemView.findViewById(R$id.new_match_user_avatar_image);
            s.h(imageLoaderView, "itemView.new_match_user_avatar_image");
            ImageLoaderView.g(imageLoaderView, user.getAvatarImage(), null, null, 6, null);
            View view = this.itemView;
            int i10 = R$id.new_match_user_name;
            ((TextView) view.findViewById(i10)).setText(user.getName());
            View view2 = this.itemView;
            int i11 = R$id.new_match_tag;
            ((TextView) view2.findViewById(i11)).setText(user.getTag());
            this.itemView.findViewById(R$id.new_match_unread_dot).setVisibility(user.getNewMatch() ? 0 : 8);
            int userCount = newMatchUserModel.getUserCount() - 1;
            int absoluteAdapterPosition = getAbsoluteAdapterPosition();
            if (absoluteAdapterPosition == 0) {
                View findViewById = this.itemView.findViewById(R$id.new_match_bg);
                String tag = user.getTag();
                findViewById.setVisibility(!(tag == null || tag.length() == 0) ? 0 : 4);
                View itemView = this.itemView;
                s.h(itemView, "itemView");
                y.m(itemView, Integer.valueOf(h.c(this, 4.0f)), null, 0, null, 10, null);
            } else if (absoluteAdapterPosition == userCount) {
                this.itemView.findViewById(R$id.new_match_bg).setVisibility(4);
                View itemView2 = this.itemView;
                s.h(itemView2, "itemView");
                y.m(itemView2, 0, null, Integer.valueOf(h.c(this, 4.0f)), null, 10, null);
            } else {
                this.itemView.findViewById(R$id.new_match_bg).setVisibility(4);
                View itemView3 = this.itemView;
                s.h(itemView3, "itemView");
                y.m(itemView3, 0, null, 0, null, 10, null);
            }
            if (s.d(user.getShake(), Boolean.TRUE) && !newMatchUserModel.getShaked()) {
                newMatchUserModel.setShaked(true);
                com.cupidapp.live.chat.viewholder.a aVar = com.cupidapp.live.chat.viewholder.a.f13260a;
                View itemView4 = this.itemView;
                s.h(itemView4, "itemView");
                aVar.a(itemView4);
                return;
            }
            ((TextView) this.itemView.findViewById(i10)).setVisibility(0);
            ((TextView) this.itemView.findViewById(i11)).setVisibility(0);
            ((ImageView) this.itemView.findViewById(R$id.new_match_gradient_strip)).setVisibility(4);
            ((ImageView) this.itemView.findViewById(R$id.new_match_mark)).setVisibility(4);
            this.itemView.findViewById(R$id.new_match_gradient_mask).setVisibility(0);
        }
    }
}

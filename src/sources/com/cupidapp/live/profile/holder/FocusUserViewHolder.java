package com.cupidapp.live.profile.holder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
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
import z0.z;

/* compiled from: FocusUserViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FocusUserViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f17807c = new a(null);

    /* compiled from: FocusUserViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FocusUserViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new FocusUserViewHolder(z.b(parent, R$layout.item_focus_user_manage, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FocusUserViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof User) {
            ImageLoaderView imageLoaderView = (ImageLoaderView) this.itemView.findViewById(R$id.item_focus_avatar_img);
            s.h(imageLoaderView, "itemView.item_focus_avatar_img");
            User user = (User) obj;
            ImageLoaderView.g(imageLoaderView, user.getAvatarImage(), null, null, 6, null);
            View view = this.itemView;
            int i10 = R$id.item_focus_name_txt;
            ((TextView) view.findViewById(i10)).setText(user.getName());
            ((TextView) this.itemView.findViewById(i10)).getPaint().setFakeBoldText(true);
            ((CheckBox) this.itemView.findViewById(R$id.item_focus_state_cb)).setChecked(user.getFocus());
        }
    }
}

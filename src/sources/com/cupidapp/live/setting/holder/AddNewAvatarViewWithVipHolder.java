package com.cupidapp.live.setting.holder;

import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.setting.adapter.EditUserAvatarAdapter;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: AddNewAvatarViewWithVipHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class AddNewAvatarViewWithVipHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f18186c = new a(null);

    /* compiled from: AddNewAvatarViewWithVipHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final AddNewAvatarViewWithVipHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new AddNewAvatarViewWithVipHolder(z.b(parent, R$layout.view_holder_add_new_avatar, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AddNewAvatarViewWithVipHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof AddNewAvatarViewVipModel) {
            EditUserAvatarAdapter.a aVar = EditUserAvatarAdapter.f18085f;
            View itemView = this.itemView;
            s.h(itemView, "itemView");
            Size a10 = aVar.a(itemView);
            ((RelativeLayout) this.itemView.findViewById(R$id.add_new_avatar_root)).setLayoutParams(new RelativeLayout.LayoutParams(a10.getWidth(), a10.getHeight()));
        }
    }
}

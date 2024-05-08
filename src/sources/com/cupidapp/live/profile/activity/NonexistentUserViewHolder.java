package com.cupidapp.live.profile.activity;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.profile.model.User;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: NonexistentUserActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class NonexistentUserViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f17647c = new a(null);

    /* compiled from: NonexistentUserActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final NonexistentUserViewHolder a(@NotNull ViewGroup parent) {
            kotlin.jvm.internal.s.i(parent, "parent");
            return new NonexistentUserViewHolder(z.b(parent, R$layout.view_holder_nonexistent_user, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NonexistentUserViewHolder(@NotNull View itemView) {
        super(itemView);
        kotlin.jvm.internal.s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof User) {
            ImageLoaderView imageLoaderView = (ImageLoaderView) this.itemView.findViewById(R$id.nonexistentUserAvatar);
            kotlin.jvm.internal.s.h(imageLoaderView, "itemView.nonexistentUserAvatar");
            User user = (User) obj;
            ImageLoaderView.g(imageLoaderView, user.getAvatarImage(), null, null, 6, null);
            View view = this.itemView;
            int i10 = R$id.nonexistentUserName;
            ((TextView) view.findViewById(i10)).getPaint().setFakeBoldText(true);
            ((TextView) this.itemView.findViewById(i10)).setText(user.getName());
            View view2 = this.itemView;
            int i11 = R$id.nonexistentUserMatchedView;
            ((TextView) view2.findViewById(i11)).getPaint().setFakeBoldText(true);
            ((TextView) this.itemView.findViewById(i11)).setVisibility(user.getMatch() ? 0 : 8);
        }
    }
}

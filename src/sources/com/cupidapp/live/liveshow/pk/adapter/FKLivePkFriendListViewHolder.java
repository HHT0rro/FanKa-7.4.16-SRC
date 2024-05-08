package com.cupidapp.live.liveshow.pk.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.liveshow.model.LivePkUserModel;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: FKLivePkFriendListAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLivePkFriendListViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f15107c = new a(null);

    /* compiled from: FKLivePkFriendListAdapter.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FKLivePkFriendListViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new FKLivePkFriendListViewHolder(z.b(parent, R$layout.view_holder_live_pk_friend_list, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLivePkFriendListViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof LivePkUserModel) {
            ImageLoaderView imageLoaderView = (ImageLoaderView) this.itemView.findViewById(R$id.friendAvatarImageView);
            s.h(imageLoaderView, "itemView.friendAvatarImageView");
            LivePkUserModel livePkUserModel = (LivePkUserModel) obj;
            ImageLoaderView.g(imageLoaderView, livePkUserModel.getUser().getAvatarImage(), null, null, 6, null);
            ((TextView) this.itemView.findViewById(R$id.friendNameTextView)).setText(livePkUserModel.getUser().getName());
        }
    }
}

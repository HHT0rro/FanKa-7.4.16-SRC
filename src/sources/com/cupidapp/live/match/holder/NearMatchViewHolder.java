package com.cupidapp.live.match.holder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.match.model.NearMatchModel;
import com.cupidapp.live.profile.model.User;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: NearMatchViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class NearMatchViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f16808c = new a(null);

    /* compiled from: NearMatchViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final NearMatchViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new NearMatchViewHolder(z.b(parent, R$layout.item_near_match, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NearMatchViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof NearMatchModel) {
            ImageLoaderView imageLoaderView = (ImageLoaderView) this.itemView.findViewById(R$id.near_avatar_img);
            s.h(imageLoaderView, "itemView.near_avatar_img");
            NearMatchModel nearMatchModel = (NearMatchModel) obj;
            User user = nearMatchModel.getUser();
            ImageLoaderView.g(imageLoaderView, user != null ? user.getAvatarImage() : null, null, null, 6, null);
            TextView textView = (TextView) this.itemView.findViewById(R$id.near_name_txt);
            User user2 = nearMatchModel.getUser();
            textView.setText(user2 != null ? user2.getName() : null);
            ((TextView) this.itemView.findViewById(R$id.near_user_active_txt)).setText(nearMatchModel.getLastOnline());
            ((TextView) this.itemView.findViewById(R$id.near_location_txt)).setText(nearMatchModel.getLocationInfo());
        }
    }
}

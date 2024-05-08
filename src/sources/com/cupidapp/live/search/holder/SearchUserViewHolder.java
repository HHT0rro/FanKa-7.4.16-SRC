package com.cupidapp.live.search.holder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.view.UserIconViewLayout;
import com.cupidapp.live.search.model.SearchModel;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.t;
import z0.z;

/* compiled from: SearchUserViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class SearchUserViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f17919c = new a(null);

    /* compiled from: SearchUserViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final SearchUserViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new SearchUserViewHolder(z.b(parent, R$layout.view_holder_search_user, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchUserViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof SearchModel) {
            ImageLoaderView imageLoaderView = (ImageLoaderView) this.itemView.findViewById(R$id.userAvatarImageView);
            s.h(imageLoaderView, "itemView.userAvatarImageView");
            SearchModel searchModel = (SearchModel) obj;
            ImageLoaderView.g(imageLoaderView, searchModel.getUser().getAvatarImage(), null, null, 6, null);
            TextView textView = (TextView) this.itemView.findViewById(R$id.userNameTextView);
            String name = searchModel.getUser().getName();
            textView.setText(name != null ? t.k(name, -49088, new String[]{searchModel.getKeyword()}, false, 4, null) : null);
            UserIconViewLayout userIconViewLayout = (UserIconViewLayout) this.itemView.findViewById(R$id.vipIconImageView);
            s.h(userIconViewLayout, "itemView.vipIconImageView");
            UserIconViewLayout.d(userIconViewLayout, searchModel.getUser().getUserVipModel(), SensorPosition.Unknown, UserIconViewLayout.VipIconPositionRef.Other, false, 8, null);
            if (searchModel.getUser().getOnlineShowOpen()) {
                ((TextView) this.itemView.findViewById(R$id.matchSignView)).setVisibility(4);
                ((ImageView) this.itemView.findViewById(R$id.liveShowSignView)).setVisibility(0);
            } else if (searchModel.getUser().getMatch()) {
                ((TextView) this.itemView.findViewById(R$id.matchSignView)).setVisibility(0);
                ((ImageView) this.itemView.findViewById(R$id.liveShowSignView)).setVisibility(4);
            } else {
                ((TextView) this.itemView.findViewById(R$id.matchSignView)).setVisibility(4);
                ((ImageView) this.itemView.findViewById(R$id.liveShowSignView)).setVisibility(4);
            }
        }
    }
}

package com.cupidapp.live.match.holder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.setting.model.AvatarProfileModel;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;
import z0.y;
import z0.z;

/* compiled from: MatchSuccessViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MatchSuccessViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f16806c = new a(null);

    /* compiled from: MatchSuccessViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final MatchSuccessViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new MatchSuccessViewHolder(z.b(parent, R$layout.item_match_success, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MatchSuccessViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof AvatarProfileModel) {
            AvatarProfileModel avatarProfileModel = (AvatarProfileModel) obj;
            if (avatarProfileModel.getAvatarImage() != null) {
                Context context = this.itemView.getContext();
                s.h(context, "itemView.context");
                int l10 = h.l(context);
                View view = this.itemView;
                int i10 = R$id.matchPictureImg;
                ImageLoaderView imageLoaderView = (ImageLoaderView) view.findViewById(i10);
                s.h(imageLoaderView, "itemView.matchPictureImg");
                y.n(imageLoaderView, Integer.valueOf(l10), Integer.valueOf((l10 * 4) / 3));
                ImageLoaderView imageLoaderView2 = (ImageLoaderView) this.itemView.findViewById(i10);
                s.h(imageLoaderView2, "itemView.matchPictureImg");
                ImageLoaderView.g(imageLoaderView2, avatarProfileModel.getAvatarImage(), null, null, 6, null);
            }
        }
    }
}

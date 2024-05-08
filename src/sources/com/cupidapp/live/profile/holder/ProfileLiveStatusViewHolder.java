package com.cupidapp.live.profile.holder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.base.view.animation.FKSVGAImageView;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: ProfileLiveStatusViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class ProfileLiveStatusViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f17826c = new a(null);

    /* compiled from: ProfileLiveStatusViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ProfileLiveStatusViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            ProfileLiveStatusViewHolder profileLiveStatusViewHolder = new ProfileLiveStatusViewHolder(z.b(parent, R$layout.view_holder_profile_live_status, false, 2, null));
            profileLiveStatusViewHolder.q();
            return profileLiveStatusViewHolder;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProfileLiveStatusViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
        ((TextView) itemView.findViewById(R$id.living_textview)).getPaint().setFakeBoldText(true);
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof ProfileLiveStatusViewModel) {
            s();
        }
    }

    public final void r() {
        ((FKSVGAImageView) this.itemView.findViewById(R$id.living_status_imageview)).K();
    }

    public final void s() {
        FKSVGAImageView fKSVGAImageView = (FKSVGAImageView) this.itemView.findViewById(R$id.living_status_imageview);
        s.h(fKSVGAImageView, "itemView.living_status_imageview");
        FKSVGAImageView.F(fKSVGAImageView, "profile_living_status.svga", null, null, 6, null);
    }
}

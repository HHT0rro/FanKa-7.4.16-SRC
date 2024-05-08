package com.cupidapp.live.profile.holder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: ProfileHighRiskUserViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class ProfileHighRiskUserViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f17825c = new a(null);

    /* compiled from: ProfileHighRiskUserViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ProfileHighRiskUserViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            ProfileHighRiskUserViewHolder profileHighRiskUserViewHolder = new ProfileHighRiskUserViewHolder(z.b(parent, R$layout.view_holder_profile_high_risk_user, false, 2, null));
            profileHighRiskUserViewHolder.q();
            return profileHighRiskUserViewHolder;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProfileHighRiskUserViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        super.n(obj);
        if (obj instanceof ProfileHighRiskUserViewModel) {
            ProfileHighRiskUserViewModel profileHighRiskUserViewModel = (ProfileHighRiskUserViewModel) obj;
            this.itemView.setVisibility(profileHighRiskUserViewModel.getHighRisk() ? 0 : 8);
            ((TextView) this.itemView.findViewById(R$id.highRiskContentTextView)).setText(profileHighRiskUserViewModel.getHighRiskNotice());
        }
    }
}

package com.cupidapp.live.profile.holder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: ProfilePostCountTitleViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class ProfilePostCountTitleViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f17827c = new a(null);

    /* compiled from: ProfilePostCountTitleViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ProfilePostCountTitleViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            ProfilePostCountTitleViewHolder profilePostCountTitleViewHolder = new ProfilePostCountTitleViewHolder(z.b(parent, R$layout.view_holder_profile_post_count_title, false, 2, null));
            profilePostCountTitleViewHolder.q();
            return profilePostCountTitleViewHolder;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProfilePostCountTitleViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof ProfilePostCountTitleViewModel) {
            if (((ProfilePostCountTitleViewModel) obj).isEmpty()) {
                ((TextView) this.itemView.findViewById(R$id.postCountTitleTextView)).setText(this.itemView.getContext().getString(R$string.no_new_post));
            } else {
                ((TextView) this.itemView.findViewById(R$id.postCountTitleTextView)).setText(this.itemView.getContext().getString(R$string.latest_new_post));
            }
            ((TextView) this.itemView.findViewById(R$id.postCountTitleTextView)).getPaint().setFakeBoldText(true);
        }
    }
}

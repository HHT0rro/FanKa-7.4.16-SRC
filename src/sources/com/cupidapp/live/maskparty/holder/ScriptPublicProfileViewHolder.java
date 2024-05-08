package com.cupidapp.live.maskparty.holder;

import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import kotlin.collections.r;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;
import z0.y;
import z0.z;

/* compiled from: ScriptPublicProfileViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class ScriptPublicProfileViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f16362c = new a(null);

    /* compiled from: ScriptPublicProfileViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ScriptPublicProfileViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new ScriptPublicProfileViewHolder(z.b(parent, R$layout.view_holder_script_public_profile, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScriptPublicProfileViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        String string;
        if (obj instanceof PublicProfileModel) {
            PublicProfileModel publicProfileModel = (PublicProfileModel) obj;
            ((TextView) this.itemView.findViewById(R$id.public_content_textview)).setText(publicProfileModel.getContent());
            TextView config$lambda$0 = (TextView) this.itemView.findViewById(R$id.public_profile_button);
            s.h(config$lambda$0, "config$lambda$0");
            y.i(config$lambda$0, (r18 & 1) != 0 ? 0.0f : h.c(config$lambda$0, 100.0f), r.e(Integer.valueOf(publicProfileModel.getPublic() ? com.cupidapp.live.base.utils.h.a(-1, 0.2f) : -1)), (r18 & 4) != 0 ? GradientDrawable.Orientation.LEFT_RIGHT : null, (r18 & 8) != 0 ? null : null, (r18 & 16) != 0 ? null : null, (r18 & 32) != 0 ? 0.0f : 0.0f, (r18 & 64) != 0 ? 0.0f : 0.0f);
            config$lambda$0.setTextColor(publicProfileModel.getPublic() ? com.cupidapp.live.base.utils.h.a(-1, 0.5f) : -15066598);
            if (publicProfileModel.getPublic()) {
                string = this.itemView.getContext().getString(R$string.published);
            } else {
                string = this.itemView.getContext().getString(R$string.publish_profile);
            }
            config$lambda$0.setText(string);
        }
    }
}

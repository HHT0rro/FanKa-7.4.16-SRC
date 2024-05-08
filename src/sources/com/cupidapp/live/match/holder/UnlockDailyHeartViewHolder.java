package com.cupidapp.live.match.holder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.match.adapter.DailyUnLockModel;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;
import z0.u;
import z0.z;

/* compiled from: UnlockDailyHeartViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class UnlockDailyHeartViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f16827c = new a(null);

    /* compiled from: UnlockDailyHeartViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final UnlockDailyHeartViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new UnlockDailyHeartViewHolder(z.b(parent, R$layout.item_unlock_heart, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UnlockDailyHeartViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof DailyUnLockModel) {
            int l10 = (h.l(this) - h.c(this, 40.0f)) / 2;
            this.itemView.setLayoutParams(new RelativeLayout.LayoutParams(l10, (l10 * 4) / 3));
            TextView textView = (TextView) this.itemView.findViewById(R$id.unlock_txt);
            s.h(textView, "itemView.unlock_txt");
            u.a(textView);
        }
    }
}

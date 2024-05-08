package com.cupidapp.live.match.holder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.cupidapp.live.R$color;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.match.adapter.UnlockDailyHeartTitleModel;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.t;
import z0.u;
import z0.z;

/* compiled from: UnlockDailyHeartTitleViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class UnlockDailyHeartTitleViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f16826c = new a(null);

    /* compiled from: UnlockDailyHeartTitleViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final UnlockDailyHeartTitleViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new UnlockDailyHeartTitleViewHolder(z.b(parent, R$layout.item_unlock_heart_title, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UnlockDailyHeartTitleViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        View view = this.itemView;
        int i10 = R$id.unlock_heart_des;
        TextView textView = (TextView) view.findViewById(i10);
        s.h(textView, "itemView.unlock_heart_des");
        u.a(textView);
        if (obj instanceof UnlockDailyHeartTitleModel) {
            ((TextView) this.itemView.findViewById(i10)).setText(t.a(((UnlockDailyHeartTitleModel) obj).getTitle(), ContextCompat.getColor(this.itemView.getContext(), R$color.prime_red)));
        }
    }
}

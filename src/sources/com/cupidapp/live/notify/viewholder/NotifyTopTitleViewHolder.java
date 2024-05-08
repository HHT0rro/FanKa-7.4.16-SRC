package com.cupidapp.live.notify.viewholder;

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
import z0.t;
import z0.u;
import z0.z;

/* compiled from: NotifyTopTitleViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class NotifyTopTitleViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f17577c = new a(null);

    /* compiled from: NotifyTopTitleViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final NotifyTopTitleViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new NotifyTopTitleViewHolder(z.b(parent, R$layout.item_heart_beat_title, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NotifyTopTitleViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof NotifyTopTitleUiModel) {
            View view = this.itemView;
            int i10 = R$id.heart_beat_title_tip;
            ((TextView) view.findViewById(i10)).setText(t.a(((NotifyTopTitleUiModel) obj).getValue(), -49088));
            TextView textView = (TextView) this.itemView.findViewById(i10);
            s.h(textView, "itemView.heart_beat_title_tip");
            u.a(textView);
        }
    }
}
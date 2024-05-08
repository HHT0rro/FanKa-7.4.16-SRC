package com.cupidapp.live.chat.adapter;

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

/* compiled from: QuickExpressionAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class QuickExpressionViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f13136c = new a(null);

    /* compiled from: QuickExpressionAdapter.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final QuickExpressionViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new QuickExpressionViewHolder(z.b(parent, R$layout.view_holder_quick_expression, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QuickExpressionViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof String) {
            View view = this.itemView;
            int i10 = R$id.quickExpressionTextView;
            ((TextView) view.findViewById(i10)).getPaint().setFakeBoldText(true);
            ((TextView) this.itemView.findViewById(i10)).setText((CharSequence) obj);
        }
    }
}

package com.cupidapp.live.liveshow.view.menu;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;

/* compiled from: LiveFunctionMenuAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class MenuTitleViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f15743c = new a(null);

    /* compiled from: LiveFunctionMenuAdapter.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final MenuTitleViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new MenuTitleViewHolder(new TextView(parent.getContext()));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MenuTitleViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
        TextView textView = itemView instanceof TextView ? (TextView) itemView : null;
        if (textView != null) {
            textView.setTextSize(12.0f);
            textView.setTextColor(-15066598);
            textView.setPadding(h.c(textView, 16.0f), h.c(textView, 10.0f), 0, h.c(textView, 2.0f));
        }
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof MenuTitleModel) {
            View view = this.itemView;
            TextView textView = view instanceof TextView ? (TextView) view : null;
            if (textView == null) {
                return;
            }
            textView.setText(((MenuTitleModel) obj).getTitle());
        }
    }
}

package com.cupidapp.live.feed.holder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.feed.model.TopFocusEntranceModel;
import java.util.Arrays;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.jvm.internal.y;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: TopFocusEntranceViewHolder.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class TopFocusEntranceViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f14416c = new a(null);

    /* compiled from: TopFocusEntranceViewHolder.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final TopFocusEntranceViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new TopFocusEntranceViewHolder(z.b(parent, R$layout.item_special_focus_manage, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TopFocusEntranceViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof TopFocusEntranceModel) {
            TextView textView = (TextView) this.itemView.findViewById(R$id.focus_count);
            y yVar = y.f51038a;
            String string = this.itemView.getContext().getString(R$string.people_count);
            s.h(string, "itemView.context.getString(R.string.people_count)");
            Object[] objArr = new Object[1];
            Integer focusCount = ((TopFocusEntranceModel) obj).getFocusCount();
            objArr[0] = Integer.valueOf(focusCount != null ? focusCount.intValue() : 0);
            String format = String.format(string, Arrays.copyOf(objArr, 1));
            s.h(format, "format(format, *args)");
            textView.setText(format);
        }
    }
}

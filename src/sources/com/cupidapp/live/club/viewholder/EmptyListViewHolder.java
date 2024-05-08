package com.cupidapp.live.club.viewholder;

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
import z0.u;
import z0.y;
import z0.z;

/* compiled from: EmptyListViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class EmptyListViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f13694c = new a(null);

    /* compiled from: EmptyListViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final EmptyListViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new EmptyListViewHolder(z.b(parent, R$layout.view_holder_empty_activity_list, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmptyListViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof EmptyListModel) {
            View view = this.itemView;
            int i10 = R$id.empty_list_textview;
            TextView textView = (TextView) view.findViewById(i10);
            s.h(textView, "itemView.empty_list_textview");
            EmptyListModel emptyListModel = (EmptyListModel) obj;
            u.e(textView, 0, emptyListModel.getIcon(), 0, 0, 13, null);
            ((TextView) this.itemView.findViewById(i10)).setText(this.itemView.getContext().getString(emptyListModel.getText()));
            View itemView = this.itemView;
            s.h(itemView, "itemView");
            y.o(itemView, null, Integer.valueOf(emptyListModel.getViewHeight()), 1, null);
        }
    }
}

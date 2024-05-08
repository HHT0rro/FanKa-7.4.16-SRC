package com.cupidapp.live.visitors.viewholder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.base.view.button.FKUniversalButton;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: FootMarkEmptyViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FootMarkEmptyViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f18962c = new a(null);

    /* compiled from: FootMarkEmptyViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FootMarkEmptyViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            FootMarkEmptyViewHolder footMarkEmptyViewHolder = new FootMarkEmptyViewHolder(z.b(parent, R$layout.item_with_btn_empty_list, false, 2, null));
            footMarkEmptyViewHolder.q();
            return footMarkEmptyViewHolder;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FootMarkEmptyViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        String str;
        String str2;
        if (obj instanceof FootMarkEmptyModel) {
            FootMarkEmptyModel footMarkEmptyModel = (FootMarkEmptyModel) obj;
            if (footMarkEmptyModel.getEmptyImage() != null) {
                ((ImageView) this.itemView.findViewById(R$id.empty_img)).setImageResource(footMarkEmptyModel.getEmptyImage().intValue());
            }
            TextView textView = (TextView) this.itemView.findViewById(R$id.empty_title);
            Integer emptyTitleRes = footMarkEmptyModel.getEmptyTitleRes();
            String str3 = null;
            if (emptyTitleRes != null) {
                str = this.itemView.getContext().getString(emptyTitleRes.intValue());
            } else {
                str = null;
            }
            textView.setText(str);
            TextView textView2 = (TextView) this.itemView.findViewById(R$id.empty_des);
            Integer emptyDesRes = footMarkEmptyModel.getEmptyDesRes();
            if (emptyDesRes != null) {
                str2 = this.itemView.getContext().getString(emptyDesRes.intValue());
            } else {
                str2 = null;
            }
            textView2.setText(str2);
            FKUniversalButton fKUniversalButton = (FKUniversalButton) this.itemView.findViewById(R$id.empty_btn);
            Integer btnRes = footMarkEmptyModel.getBtnRes();
            if (btnRes != null) {
                str3 = this.itemView.getContext().getString(btnRes.intValue());
            }
            fKUniversalButton.setText(str3);
        }
    }
}

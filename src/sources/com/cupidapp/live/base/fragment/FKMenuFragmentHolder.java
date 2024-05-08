package com.cupidapp.live.base.fragment;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: FKMenuFragment.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKMenuFragmentHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f11803c = new a(null);

    /* compiled from: FKMenuFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FKMenuFragmentHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new FKMenuFragmentHolder(z.b(parent, R$layout.holder_fragment_menu_item_layout, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKMenuFragmentHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof FKMenuFragmentItemModel) {
            FKMenuFragmentItemModel fKMenuFragmentItemModel = (FKMenuFragmentItemModel) obj;
            ((TextView) this.itemView.findViewById(R$id.contentTextView)).setText(fKMenuFragmentItemModel.getContent());
            ((ImageView) this.itemView.findViewById(R$id.selectItemMarkImageView)).setVisibility(fKMenuFragmentItemModel.isSelectItem() ? 0 : 8);
        }
    }
}

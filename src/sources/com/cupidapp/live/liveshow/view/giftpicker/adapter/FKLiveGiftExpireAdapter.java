package com.cupidapp.live.liveshow.view.giftpicker.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewAdapter;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.liveshow.model.GiftExpireModel;
import java.util.Arrays;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.jvm.internal.y;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.t;
import z0.z;

/* compiled from: FKLiveGiftExpireAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLiveGiftExpireAdapter extends FKBaseRecyclerViewAdapter {

    /* compiled from: FKLiveGiftExpireAdapter.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class FKLiveGiftExpireViewHolder extends FKBaseRecyclerViewHolder {

        /* renamed from: c, reason: collision with root package name */
        @NotNull
        public static final a f15425c = new a(null);

        /* compiled from: FKLiveGiftExpireAdapter.kt */
        @d
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
        public static final class a {
            public a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @NotNull
            public final FKLiveGiftExpireViewHolder a(@NotNull ViewGroup parent) {
                s.i(parent, "parent");
                return new FKLiveGiftExpireViewHolder(z.b(parent, R$layout.item_live_gift_expired, false, 2, null));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FKLiveGiftExpireViewHolder(@NotNull View itemView) {
            super(itemView);
            s.i(itemView, "itemView");
        }

        @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
        public void n(@Nullable Object obj) {
            if (obj instanceof GiftExpireModel) {
                TextView textView = (TextView) this.itemView.findViewById(R$id.item_gift_count);
                y yVar = y.f51038a;
                String string = this.itemView.getContext().getString(R$string.count);
                s.h(string, "itemView.context.getString(R.string.count)");
                GiftExpireModel giftExpireModel = (GiftExpireModel) obj;
                String format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(giftExpireModel.getCount())}, 1));
                s.h(format, "format(format, *args)");
                textView.setText(t.k(format, -49088, new String[]{String.valueOf(giftExpireModel.getCount())}, false, 4, null));
                TextView textView2 = (TextView) this.itemView.findViewById(R$id.item_gift_time);
                String string2 = this.itemView.getContext().getString(R$string.expire_time);
                s.h(string2, "itemView.context.getString(R.string.expire_time)");
                String format2 = String.format(string2, Arrays.copyOf(new Object[]{giftExpireModel.getExpireTime()}, 1));
                s.h(format2, "format(format, *args)");
                textView2.setText(format2);
            }
        }
    }

    public FKLiveGiftExpireAdapter() {
        k().add(GiftExpireModel.class);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public FKBaseRecyclerViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i10) {
        s.i(parent, "parent");
        return FKLiveGiftExpireViewHolder.f15425c.a(parent);
    }
}

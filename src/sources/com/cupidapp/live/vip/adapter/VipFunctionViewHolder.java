package com.cupidapp.live.vip.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.cupidapp.live.R$drawable;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.vip.model.VipFunctionUiModel;
import com.cupidapp.live.vip.model.VipType;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.o;
import z0.u;
import z0.z;

/* compiled from: VipFunctionViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class VipFunctionViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f18734c = new a(null);

    /* compiled from: VipFunctionViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final VipFunctionViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new VipFunctionViewHolder(z.b(parent, R$layout.item_vip_function, false, 2, null));
        }
    }

    /* compiled from: VipFunctionViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f18735a;

        static {
            int[] iArr = new int[VipType.values().length];
            try {
                iArr[VipType.SUPER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[VipType.RAINBOW.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f18735a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VipFunctionViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof VipFunctionUiModel) {
            VipFunctionUiModel vipFunctionUiModel = (VipFunctionUiModel) obj;
            ((ImageView) this.itemView.findViewById(R$id.function_img)).setImageResource(vipFunctionUiModel.getImage());
            View view = this.itemView;
            int i10 = R$id.function_title;
            ((TextView) view.findViewById(i10)).setText(vipFunctionUiModel.getName());
            TextView textView = (TextView) this.itemView.findViewById(i10);
            s.h(textView, "itemView.function_title");
            u.a(textView);
            if (vipFunctionUiModel.isSwitch()) {
                ((ImageView) this.itemView.findViewById(R$id.function_switch)).setVisibility(0);
                ((ImageView) this.itemView.findViewById(R$id.function_arrow)).setVisibility(8);
            } else {
                ((ImageView) this.itemView.findViewById(R$id.function_switch)).setVisibility(8);
                ((ImageView) this.itemView.findViewById(R$id.function_arrow)).setVisibility(0);
            }
            int i11 = b.f18735a[vipFunctionUiModel.getVipType().ordinal()];
            if (i11 == 1) {
                ((TextView) this.itemView.findViewById(i10)).setTextColor(-1);
                ((ConstraintLayout) this.itemView.findViewById(R$id.item_function_cl)).setBackgroundResource(R$drawable.rect_cor_8_sk_26ffffff);
                ImageView imageView = (ImageView) this.itemView.findViewById(R$id.function_arrow);
                s.h(imageView, "itemView.function_arrow");
                o.b(imageView, -1);
                ((ImageView) this.itemView.findViewById(R$id.function_switch)).setImageResource(R$mipmap.ic_switch_gray_in_black);
                return;
            }
            if (i11 != 2) {
                ((TextView) this.itemView.findViewById(i10)).setTextColor(-15066598);
                ((ConstraintLayout) this.itemView.findViewById(R$id.item_function_cl)).setBackgroundResource(R$drawable.rect_cor_8_sk_e9e9eb);
                ImageView imageView2 = (ImageView) this.itemView.findViewById(R$id.function_arrow);
                s.h(imageView2, "itemView.function_arrow");
                o.b(imageView2, -15066598);
                ((ImageView) this.itemView.findViewById(R$id.function_switch)).setImageResource(R$mipmap.ic_switch_gray);
                return;
            }
            ((TextView) this.itemView.findViewById(i10)).setTextColor(-1);
            ((ConstraintLayout) this.itemView.findViewById(R$id.item_function_cl)).setBackgroundResource(R$drawable.rect_cor_8_sk_26ffffff);
            ImageView imageView3 = (ImageView) this.itemView.findViewById(R$id.function_arrow);
            s.h(imageView3, "itemView.function_arrow");
            o.b(imageView3, -1);
            ((ImageView) this.itemView.findViewById(R$id.function_switch)).setImageResource(R$mipmap.ic_switch_gray_in_black);
        }
    }
}

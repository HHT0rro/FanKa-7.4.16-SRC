package com.cupidapp.live.notify.viewholder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.ai.model.AiRcmdModel;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: AiRcmdViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class AiRcmdViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f17568c = new a(null);

    /* compiled from: AiRcmdViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final AiRcmdViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new AiRcmdViewHolder(z.b(parent, R$layout.item_ai_rcmd, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AiRcmdViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof AiRcmdModel) {
            AiRcmdModel aiRcmdModel = (AiRcmdModel) obj;
            if (aiRcmdModel.isChecked()) {
                this.itemView.findViewById(R$id.ai_rcmg_img_border).setVisibility(0);
                ((ImageView) this.itemView.findViewById(R$id.ai_rcmd_checked)).setImageResource(R$mipmap.ai_ic_selected);
                ((TextView) this.itemView.findViewById(R$id.ai_rcmd_title)).setTextColor(-15066598);
            } else {
                this.itemView.findViewById(R$id.ai_rcmg_img_border).setVisibility(4);
                ((ImageView) this.itemView.findViewById(R$id.ai_rcmd_checked)).setImageResource(R$mipmap.ai_ic_select);
                ((TextView) this.itemView.findViewById(R$id.ai_rcmd_title)).setTextColor(-7434610);
            }
            ImageLoaderView imageLoaderView = (ImageLoaderView) this.itemView.findViewById(R$id.ai_rcmd_item_img);
            s.h(imageLoaderView, "itemView.ai_rcmd_item_img");
            ImageLoaderView.g(imageLoaderView, aiRcmdModel.getImage(), null, null, 6, null);
            ((TextView) this.itemView.findViewById(R$id.ai_rcmd_title)).setText(aiRcmdModel.getName());
        }
    }
}

package com.cupidapp.live.setting.viewholder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.setting.model.NewPushLiveShowItemModel;
import com.cupidapp.live.setting.model.NewPushLiveShowModel;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: NewPushHeaderHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class NewPushHeaderHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f18245c = new a(null);

    /* compiled from: NewPushHeaderHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final NewPushHeaderHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new NewPushHeaderHolder(z.b(parent, R$layout.view_holder_new_push_header, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewPushHeaderHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof NewPushLiveShowModel) {
            boolean z10 = true;
            ((TextView) this.itemView.findViewById(R$id.pushItemContent)).getPaint().setFakeBoldText(true);
            View view = this.itemView;
            int i10 = R$id.pushHeaderTips;
            ((TextView) view.findViewById(i10)).getPaint().setFakeBoldText(true);
            NewPushLiveShowModel newPushLiveShowModel = (NewPushLiveShowModel) obj;
            ((CheckBox) this.itemView.findViewById(R$id.pushItemHeaderSwitch)).setChecked(newPushLiveShowModel.getPushLiveShow());
            if (newPushLiveShowModel.getPushLiveShow()) {
                List<NewPushLiveShowItemModel> anchorList = newPushLiveShowModel.getAnchorList();
                if (anchorList != null && !anchorList.isEmpty()) {
                    z10 = false;
                }
                if (!z10) {
                    ((TextView) this.itemView.findViewById(i10)).setVisibility(0);
                    return;
                }
            }
            ((TextView) this.itemView.findViewById(i10)).setVisibility(8);
        }
    }
}

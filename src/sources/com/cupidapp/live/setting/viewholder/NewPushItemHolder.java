package com.cupidapp.live.setting.viewholder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.setting.model.NewPushLiveShowItemModel;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: NewPushItemHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class NewPushItemHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f18246c = new a(null);

    /* compiled from: NewPushItemHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final NewPushItemHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new NewPushItemHolder(z.b(parent, R$layout.view_holder_new_push_item, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewPushItemHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof NewPushLiveShowItemModel) {
            ImageLoaderView imageLoaderView = (ImageLoaderView) this.itemView.findViewById(R$id.pushItemAvatar);
            s.h(imageLoaderView, "itemView.pushItemAvatar");
            NewPushLiveShowItemModel newPushLiveShowItemModel = (NewPushLiveShowItemModel) obj;
            ImageLoaderView.g(imageLoaderView, newPushLiveShowItemModel.getUser().getAvatarImage(), null, null, 6, null);
            View view = this.itemView;
            int i10 = R$id.pushItemName;
            ((TextView) view.findViewById(i10)).getPaint().setFakeBoldText(true);
            ((TextView) this.itemView.findViewById(i10)).setText(newPushLiveShowItemModel.getUser().getNickname());
            ((CheckBox) this.itemView.findViewById(R$id.pushItemSwitch)).setChecked(newPushLiveShowItemModel.getSendPush());
        }
    }
}

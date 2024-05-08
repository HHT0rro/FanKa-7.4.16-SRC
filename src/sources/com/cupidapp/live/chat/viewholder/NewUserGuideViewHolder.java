package com.cupidapp.live.chat.viewholder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.base.sensorslog.SensorLogActivity;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.chat.service.NewUserGuideItemModel;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;
import z0.z;

/* compiled from: NewUserGuideViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class NewUserGuideViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f13257c = new a(null);

    /* compiled from: NewUserGuideViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final NewUserGuideViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new NewUserGuideViewHolder(z.b(parent, R$layout.view_holder_new_user_guide, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewUserGuideViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
        ((TextView) itemView.findViewById(R$id.new_user_guide_textview)).getPaint().setFakeBoldText(true);
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof NewUserGuideModel) {
            ((LinearLayout) this.itemView.findViewById(R$id.new_user_guide_layout)).removeAllViews();
            NewUserGuideModel newUserGuideModel = (NewUserGuideModel) obj;
            int i10 = 0;
            for (NewUserGuideItemModel newUserGuideItemModel : newUserGuideModel.getGuideList()) {
                int i11 = i10 + 1;
                if (i10 < 0) {
                    kotlin.collections.s.s();
                }
                final NewUserGuideItemModel newUserGuideItemModel2 = newUserGuideItemModel;
                Context context = this.itemView.getContext();
                s.h(context, "itemView.context");
                NewUserGuideItemLayout newUserGuideItemLayout = new NewUserGuideItemLayout(context);
                boolean z10 = true;
                if (i10 >= newUserGuideModel.getGuideList().size() - 1) {
                    z10 = false;
                }
                newUserGuideItemLayout.b(newUserGuideItemModel2, z10);
                y.d(newUserGuideItemLayout, new Function1<View, p>() { // from class: com.cupidapp.live.chat.viewholder.NewUserGuideViewHolder$config$1$itemLayout$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ p invoke(View view) {
                        invoke2(view);
                        return p.f51048a;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@Nullable View view) {
                        j.a.b(j.f12156c, NewUserGuideViewHolder.this.itemView.getContext(), newUserGuideItemModel2.getJumpUrl(), null, 4, null);
                        SensorLogActivity.f12204a.a(SensorPosition.Message.getValue(), newUserGuideItemModel2.getJumpUrl(), SensorLogActivity.Type.CHAT_ACTIVITY.getType());
                    }
                });
                ((LinearLayout) this.itemView.findViewById(R$id.new_user_guide_layout)).addView(newUserGuideItemLayout);
                SensorLogActivity.f12204a.b(SensorPosition.Message.getValue(), newUserGuideItemModel2.getJumpUrl(), SensorLogActivity.Type.CHAT_ACTIVITY.getType());
                i10 = i11;
            }
        }
    }
}

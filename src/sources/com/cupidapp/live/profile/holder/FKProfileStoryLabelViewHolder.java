package com.cupidapp.live.profile.holder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.profile.logic.c;
import com.cupidapp.live.profile.model.FKStoryLabelItemModel;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;
import z0.u;
import z0.z;

/* compiled from: FKProfileStoryLabelViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FKProfileStoryLabelViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f17805c = new a(null);

    /* compiled from: FKProfileStoryLabelViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FKProfileStoryLabelViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            FKProfileStoryLabelViewHolder fKProfileStoryLabelViewHolder = new FKProfileStoryLabelViewHolder(z.b(parent, R$layout.view_holder_profile_story_label, false, 2, null));
            fKProfileStoryLabelViewHolder.q();
            return fKProfileStoryLabelViewHolder;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKProfileStoryLabelViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof FKProfileStoryLabelModel) {
            ((LinearLayout) this.itemView.findViewById(R$id.profile_story_label_container)).removeAllViews();
            FKProfileStoryLabelModel fKProfileStoryLabelModel = (FKProfileStoryLabelModel) obj;
            List<FKStoryLabelItemModel> storyLabelList = fKProfileStoryLabelModel.getUser().getStoryLabelList();
            View view = this.itemView;
            int i10 = R$id.profile_story_label_count_text;
            TextView textView = (TextView) view.findViewById(i10);
            s.h(textView, "itemView.profile_story_label_count_text");
            u.a(textView);
            TextView textView2 = (TextView) this.itemView.findViewById(i10);
            Context context = this.itemView.getContext();
            Object[] objArr = new Object[1];
            objArr[0] = storyLabelList != null ? Integer.valueOf(storyLabelList.size()) : null;
            textView2.setText(context.getString(R$string.story_label_has_count, objArr));
            s.f(storyLabelList);
            for (FKStoryLabelItemModel fKStoryLabelItemModel : storyLabelList) {
                Context context2 = this.itemView.getContext();
                s.h(context2, "itemView.context");
                FKProfileStoryLabelItemLayout fKProfileStoryLabelItemLayout = new FKProfileStoryLabelItemLayout(context2);
                fKProfileStoryLabelItemLayout.b(fKStoryLabelItemModel, storyLabelList.size() > 1);
                ((LinearLayout) this.itemView.findViewById(R$id.profile_story_label_container)).addView(fKProfileStoryLabelItemLayout);
            }
            View view2 = this.itemView;
            int i11 = R$id.profile_story_label_detail_image;
            int i12 = 8;
            ((ImageView) view2.findViewById(i11)).setVisibility(storyLabelList.size() > 1 ? 0 : 8);
            View view3 = this.itemView;
            int i13 = R$id.profile_label_chat_image;
            ImageView imageView = (ImageView) view3.findViewById(i13);
            if (fKProfileStoryLabelModel.getUser().getMatch() && !c.f17839a.a(fKProfileStoryLabelModel.getUser().userId())) {
                i12 = 0;
            }
            imageView.setVisibility(i12);
            if (((ImageView) this.itemView.findViewById(i11)).getVisibility() != 0 && ((ImageView) this.itemView.findViewById(i13)).getVisibility() != 0) {
                ((LinearLayout) this.itemView.findViewById(R$id.profile_story_label_container)).setPadding(h.c(this, 7.0f), h.c(this, 6.0f), h.c(this, 12.0f), h.c(this, 6.0f));
            } else {
                ((LinearLayout) this.itemView.findViewById(R$id.profile_story_label_container)).setPadding(h.c(this, 7.0f), h.c(this, 6.0f), 0, h.c(this, 6.0f));
            }
        }
    }
}

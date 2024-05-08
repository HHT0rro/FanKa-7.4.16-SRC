package com.cupidapp.live.maskparty.holder;

import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.cupidapp.live.R$drawable;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.maskparty.model.MaskPartyScriptTaskItemModel;
import com.cupidapp.live.maskparty.model.ScriptTaskScoreModel;
import kotlin.collections.r;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;
import z0.q;
import z0.y;
import z0.z;

/* compiled from: ScriptCompleteTaskViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class ScriptCompleteTaskViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f16360c = new a(null);

    /* compiled from: ScriptCompleteTaskViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ScriptCompleteTaskViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new ScriptCompleteTaskViewHolder(z.b(parent, R$layout.view_holder_script_complete_task, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScriptCompleteTaskViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        String string;
        String string2;
        if (obj instanceof ScriptTaskScoreModel) {
            TextView textView = (TextView) this.itemView.findViewById(R$id.complete_task_title_textview);
            ScriptTaskScoreModel scriptTaskScoreModel = (ScriptTaskScoreModel) obj;
            if (scriptTaskScoreModel.getMyself()) {
                string = this.itemView.getContext().getString(R$string.you_complete_script_task);
            } else {
                string = this.itemView.getContext().getString(R$string.others_complete_script_task);
            }
            textView.setText(string);
            ((TextView) this.itemView.findViewById(R$id.score_textview)).setText(this.itemView.getContext().getString(R$string.script_task_score, Integer.valueOf(scriptTaskScoreModel.getScore())));
            ((LinearLayout) this.itemView.findViewById(R$id.task_layout)).removeAllViews();
            int i10 = 0;
            for (MaskPartyScriptTaskItemModel maskPartyScriptTaskItemModel : scriptTaskScoreModel.getTask()) {
                int i11 = i10 + 1;
                if (i10 < 0) {
                    kotlin.collections.s.s();
                }
                MaskPartyScriptTaskItemModel maskPartyScriptTaskItemModel2 = maskPartyScriptTaskItemModel;
                View view = this.itemView;
                int i12 = R$id.task_layout;
                LinearLayout linearLayout = (LinearLayout) view.findViewById(i12);
                s.h(linearLayout, "itemView.task_layout");
                View b4 = z.b(linearLayout, R$layout.layout_script_task_item, false, 2, null);
                View findViewById = b4.findViewById(R$id.task_container_layout);
                TextView textView2 = (TextView) b4.findViewById(R$id.task_textview);
                TextView textView3 = (TextView) b4.findViewById(R$id.task_content_textview);
                ImageView completeView = (ImageView) b4.findViewById(R$id.complete_imageview);
                findViewById.setBackgroundResource(R$drawable.shape_alpha_10_white_bg_8_corners);
                textView2.getPaint().setFakeBoldText(true);
                textView2.setTextColor(-1);
                textView2.setText(this.itemView.getContext().getString(R$string.tasks, q.a(i11)));
                textView2.setBackgroundResource(R$drawable.shape_white_alpha_20_bg_4_corners);
                textView3.setTextColor(-1);
                textView3.setTextSize(12.0f);
                textView3.setText(maskPartyScriptTaskItemModel2.getDesc());
                s.h(completeView, "completeView");
                completeView.setVisibility(maskPartyScriptTaskItemModel2.getStatus() == 1 ? 0 : 8);
                ((LinearLayout) this.itemView.findViewById(i12)).addView(b4);
                i10 = i11;
            }
            TextView config$lambda$3 = (TextView) this.itemView.findViewById(R$id.public_profile_button);
            s.h(config$lambda$3, "config$lambda$3");
            y.i(config$lambda$3, (r18 & 1) != 0 ? 0.0f : h.c(config$lambda$3, 100.0f), r.e(Integer.valueOf(scriptTaskScoreModel.getPublic() ? com.cupidapp.live.base.utils.h.a(-1, 0.2f) : -1)), (r18 & 4) != 0 ? GradientDrawable.Orientation.LEFT_RIGHT : null, (r18 & 8) != 0 ? null : null, (r18 & 16) != 0 ? null : null, (r18 & 32) != 0 ? 0.0f : 0.0f, (r18 & 64) != 0 ? 0.0f : 0.0f);
            config$lambda$3.setTextColor(scriptTaskScoreModel.getPublic() ? com.cupidapp.live.base.utils.h.a(-1, 0.5f) : -15066598);
            if (scriptTaskScoreModel.getPublic()) {
                string2 = this.itemView.getContext().getString(R$string.published);
            } else {
                string2 = this.itemView.getContext().getString(R$string.publish_profile);
            }
            config$lambda$3.setText(string2);
        }
    }
}

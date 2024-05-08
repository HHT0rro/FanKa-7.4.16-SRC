package com.cupidapp.live.liveshow.fanclub.adapter;

import android.graphics.drawable.GradientDrawable;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.liveshow.fanclub.model.FKFanClubTaskDataModel;
import com.cupidapp.live.liveshow.fanclub.model.TaskStatus;
import com.google.android.material.badge.BadgeDrawable;
import kotlin.collections.r;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;
import z0.y;
import z0.z;

/* compiled from: FKFanClubTaskAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKFanClubTaskViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f14960c = new a(null);

    /* compiled from: FKFanClubTaskAdapter.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FKFanClubTaskViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new FKFanClubTaskViewHolder(z.b(parent, R$layout.view_holder_fan_club_task, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKFanClubTaskViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof FKFanClubTaskModel) {
            FKFanClubTaskModel fKFanClubTaskModel = (FKFanClubTaskModel) obj;
            FKFanClubTaskDataModel taskModel = fKFanClubTaskModel.getTaskModel();
            ImageLoaderView imageLoaderView = (ImageLoaderView) this.itemView.findViewById(R$id.fanClubTaskImageView);
            s.h(imageLoaderView, "itemView.fanClubTaskImageView");
            ImageLoaderView.g(imageLoaderView, taskModel.getIconImage(), null, null, 6, null);
            ((TextView) this.itemView.findViewById(R$id.fanClubTaskTitleTextView)).setText(taskModel.getName());
            ((TextView) this.itemView.findViewById(R$id.fanClubTaskIntimacyTextView)).setText(taskModel.getRewardTitle());
            r(fKFanClubTaskModel);
        }
    }

    public final void r(FKFanClubTaskModel fKFanClubTaskModel) {
        FKFanClubTaskDataModel taskModel = fKFanClubTaskModel.getTaskModel();
        if (fKFanClubTaskModel.getExpired()) {
            s(taskModel.getJumpDesc(), -5658199, -1973791, true, true);
            return;
        }
        if (taskModel.getStatus() == TaskStatus.Completed.getStatus()) {
            q1.d dVar = q1.d.f53006a;
            String string = this.itemView.getContext().getString(R$string.intimacy_value, Integer.valueOf(taskModel.getAmount()), taskModel.getRewardName());
            s.h(string, "itemView.context.getStri…nt, taskModel.rewardName)");
            s(dVar.g(string, BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX + taskModel.getAmount(), new ForegroundColorSpan(-49088)), -15066598, null, false, false);
            return;
        }
        s(taskModel.getJumpDesc(), -1, -49088, true, true);
    }

    public final void s(CharSequence charSequence, int i10, Integer num, boolean z10, boolean z11) {
        TextView configTaskButton$lambda$0 = (TextView) this.itemView.findViewById(R$id.fanClubTaskButtonTextView);
        configTaskButton$lambda$0.setText(charSequence);
        configTaskButton$lambda$0.setTextColor(i10);
        if (num != null) {
            s.h(configTaskButton$lambda$0, "configTaskButton$lambda$0");
            y.i(configTaskButton$lambda$0, (r18 & 1) != 0 ? 0.0f : h.c(configTaskButton$lambda$0, 100.0f), r.e(num), (r18 & 4) != 0 ? GradientDrawable.Orientation.LEFT_RIGHT : null, (r18 & 8) != 0 ? null : null, (r18 & 16) != 0 ? null : null, (r18 & 32) != 0 ? 0.0f : 0.0f, (r18 & 64) != 0 ? 0.0f : 0.0f);
        } else {
            configTaskButton$lambda$0.setBackground(null);
        }
        if (z10) {
            s.h(configTaskButton$lambda$0, "configTaskButton$lambda$0");
            configTaskButton$lambda$0.setPadding(h.c(configTaskButton$lambda$0, 20.0f), h.c(configTaskButton$lambda$0, 8.0f), h.c(configTaskButton$lambda$0, 20.0f), h.c(configTaskButton$lambda$0, 8.0f));
        } else {
            configTaskButton$lambda$0.setPadding(0, 0, 0, 0);
        }
        configTaskButton$lambda$0.getPaint().setFakeBoldText(z11);
    }
}

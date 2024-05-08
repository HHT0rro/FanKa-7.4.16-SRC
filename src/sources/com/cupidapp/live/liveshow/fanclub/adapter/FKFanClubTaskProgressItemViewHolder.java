package com.cupidapp.live.liveshow.fanclub.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.liveshow.fanclub.model.FKFanClubTaskSummaryDataModel;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.m;
import z0.z;

/* compiled from: FKFanClubTaskProgressAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKFanClubTaskProgressItemViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f14957c = new a(null);

    /* compiled from: FKFanClubTaskProgressAdapter.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FKFanClubTaskProgressItemViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new FKFanClubTaskProgressItemViewHolder(z.b(parent, R$layout.view_holder_fan_club_task_progress_item, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKFanClubTaskProgressItemViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof FKFanClubTaskSummaryDataModel) {
            ImageLoaderView imageLoaderView = (ImageLoaderView) this.itemView.findViewById(R$id.taskIconImageView);
            s.h(imageLoaderView, "itemView.taskIconImageView");
            FKFanClubTaskSummaryDataModel fKFanClubTaskSummaryDataModel = (FKFanClubTaskSummaryDataModel) obj;
            ImageLoaderView.g(imageLoaderView, fKFanClubTaskSummaryDataModel.getIcon(), null, null, 6, null);
            ((TextView) this.itemView.findViewById(R$id.taskNameTextView)).setText(fKFanClubTaskSummaryDataModel.getTitle());
            TextView textView = (TextView) this.itemView.findViewById(R$id.completeTaskNumberTextView);
            Context context = this.itemView.getContext();
            int completedNums = fKFanClubTaskSummaryDataModel.getCompletedNums();
            Context context2 = this.itemView.getContext();
            s.h(context2, "itemView.context");
            textView.setText(context.getString(R$string.complete_task_count, m.e(completedNums, context2)));
        }
    }
}

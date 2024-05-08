package com.cupidapp.live.setting.holder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.cupidapp.live.R$drawable;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.network.model.NewUserTaskModel;
import com.cupidapp.live.base.network.model.TaskBtnStatus;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: UserTasksViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class UserTasksViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f18198c = new a(null);

    /* compiled from: UserTasksViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final UserTasksViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new UserTasksViewHolder(z.b(parent, R$layout.item_task, false, 2, null));
        }
    }

    /* compiled from: UserTasksViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f18199a;

        static {
            int[] iArr = new int[TaskBtnStatus.values().length];
            try {
                iArr[TaskBtnStatus.UnDone.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TaskBtnStatus.Auditing.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[TaskBtnStatus.ReWard.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f18199a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserTasksViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof NewUserTaskModel) {
            NewUserTaskModel newUserTaskModel = (NewUserTaskModel) obj;
            String tips = newUserTaskModel.getTips();
            if (tips == null || tips.length() == 0) {
                ((TextView) this.itemView.findViewById(R$id.item_task_tip)).setVisibility(8);
            } else {
                View view = this.itemView;
                int i10 = R$id.item_task_tip;
                ((TextView) view.findViewById(i10)).setVisibility(0);
                ((TextView) this.itemView.findViewById(i10)).setText(newUserTaskModel.getTips());
            }
            ImageLoaderView imageLoaderView = (ImageLoaderView) this.itemView.findViewById(R$id.item_task_icon);
            s.h(imageLoaderView, "itemView.item_task_icon");
            ImageLoaderView.g(imageLoaderView, newUserTaskModel.getIcon(), null, null, 6, null);
            View view2 = this.itemView;
            int i11 = R$id.item_task_title;
            ((TextView) view2.findViewById(i11)).getPaint().setFakeBoldText(true);
            View view3 = this.itemView;
            int i12 = R$id.item_task_btn;
            ((TextView) view3.findViewById(i12)).getPaint().setFakeBoldText(true);
            View view4 = this.itemView;
            int i13 = R$id.item_task_reward_txt;
            ((TextView) view4.findViewById(i13)).getPaint().setFakeBoldText(true);
            ((TextView) this.itemView.findViewById(i11)).setText(newUserTaskModel.getTitle());
            ((TextView) this.itemView.findViewById(i12)).setText(newUserTaskModel.getActionName());
            int flowStep = newUserTaskModel.getFlowStep();
            TaskBtnStatus taskBtnStatus = TaskBtnStatus.ReWard;
            if (flowStep == taskBtnStatus.getValue()) {
                ((TextView) this.itemView.findViewById(R$id.item_task_des)).setVisibility(8);
                ((LinearLayout) this.itemView.findViewById(R$id.item_task_reward_ll)).setVisibility(0);
                ImageLoaderView imageLoaderView2 = (ImageLoaderView) this.itemView.findViewById(R$id.item_task_reward_img);
                s.h(imageLoaderView2, "itemView.item_task_reward_img");
                ImageLoaderView.g(imageLoaderView2, newUserTaskModel.getRewardIcon(), null, null, 6, null);
                ((TextView) this.itemView.findViewById(i13)).setText(newUserTaskModel.getRewardDesc());
            } else {
                ((LinearLayout) this.itemView.findViewById(R$id.item_task_reward_ll)).setVisibility(8);
                View view5 = this.itemView;
                int i14 = R$id.item_task_des;
                ((TextView) view5.findViewById(i14)).setVisibility(0);
                ((TextView) this.itemView.findViewById(i14)).setText(newUserTaskModel.getDesc());
            }
            if (newUserTaskModel.getFlowStep() != TaskBtnStatus.Done.getValue() && newUserTaskModel.getFlowStep() != taskBtnStatus.getValue()) {
                ((ImageView) this.itemView.findViewById(R$id.item_task_done_img)).setVisibility(8);
            } else {
                ((ImageView) this.itemView.findViewById(R$id.item_task_done_img)).setVisibility(0);
            }
            r(newUserTaskModel.getFlowStep());
        }
    }

    public final void r(int i10) {
        TaskBtnStatus a10 = TaskBtnStatus.Companion.a(i10);
        int i11 = a10 == null ? -1 : b.f18199a[a10.ordinal()];
        if (i11 == 1) {
            View view = this.itemView;
            int i12 = R$id.item_task_btn;
            ((TextView) view.findViewById(i12)).setBackgroundResource(R$drawable.bg_red_eight_solid);
            ((TextView) this.itemView.findViewById(i12)).setTextColor(-1);
            return;
        }
        if (i11 == 2) {
            View view2 = this.itemView;
            int i13 = R$id.item_task_btn;
            ((TextView) view2.findViewById(i13)).setBackgroundResource(R$drawable.bg_gray_eight_solid);
            ((TextView) this.itemView.findViewById(i13)).setTextColor(-5658199);
            return;
        }
        if (i11 != 3) {
            View view3 = this.itemView;
            int i14 = R$id.item_task_btn;
            ((TextView) view3.findViewById(i14)).setBackgroundResource(17170445);
            ((TextView) this.itemView.findViewById(i14)).setTextColor(-5658199);
            return;
        }
        View view4 = this.itemView;
        int i15 = R$id.item_task_btn;
        ((TextView) view4.findViewById(i15)).setBackgroundResource(R$drawable.bg_blue_eight_solid);
        ((TextView) this.itemView.findViewById(i15)).setTextColor(-1);
    }
}

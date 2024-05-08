package com.cupidapp.live.liveshow.view.summary;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.view.button.FKUniversalButton;
import com.cupidapp.live.base.view.decoration.FKSingleColumnDecoration;
import com.cupidapp.live.liveshow.model.ExperienceInfoModel;
import com.cupidapp.live.liveshow.model.SummaryModel;
import com.cupidapp.live.profile.model.User;
import com.kwad.sdk.core.response.model.SdkConfigData;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.r;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;
import z0.y;
import z0.z;

/* compiled from: FKLiveForStreamerSummaryLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLiveForStreamerSummaryLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f15944b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveForStreamerSummaryLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f15944b = new LinkedHashMap();
        h();
    }

    public static final void f(FKLiveForStreamerSummaryLayout this$0, ExperienceInfoModel experience) {
        s.i(this$0, "this$0");
        s.i(experience, "$experience");
        int i10 = R$id.liveLevelProgress;
        this$0.b(i10).getLayoutParams().width = (int) (this$0.b(R$id.liveLevelBackground).getWidth() * experience.getExpPercent());
        this$0.b(i10).requestLayout();
    }

    @Nullable
    public View b(int i10) {
        Map<Integer, View> map = this.f15944b;
        View view = map.get(Integer.valueOf(i10));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i10);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i10), findViewById);
        return findViewById;
    }

    public final void c(@NotNull final Function0<p> callback) {
        s.i(callback, "callback");
        FKUniversalButton closeSummaryButton = (FKUniversalButton) b(R$id.closeSummaryButton);
        s.h(closeSummaryButton, "closeSummaryButton");
        y.d(closeSummaryButton, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.view.summary.FKLiveForStreamerSummaryLayout$configCloseSummaryButtonClickEvent$1
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
                callback.invoke();
            }
        });
    }

    public final void d(@Nullable User user) {
        if (user == null) {
            return;
        }
        ImageLoaderView summaryUserAvatarImageView = (ImageLoaderView) b(R$id.summaryUserAvatarImageView);
        s.h(summaryUserAvatarImageView, "summaryUserAvatarImageView");
        ImageLoaderView.g(summaryUserAvatarImageView, user.getAvatarImage(), null, null, 6, null);
        ((TextView) b(R$id.summaryUserNameTextView)).setText(user.getName());
    }

    public final void e(@Nullable SummaryModel summaryModel) {
        if (summaryModel == null) {
            ((LinearLayout) b(R$id.liveExperienceLayout)).setVisibility(8);
            ((RecyclerView) b(R$id.summaryRecyclerView)).setVisibility(8);
            return;
        }
        String auditWarning = summaryModel.getAuditWarning();
        if (!(auditWarning == null || auditWarning.length() == 0)) {
            ((LinearLayout) b(R$id.liveExperienceLayout)).setVisibility(8);
            ((RecyclerView) b(R$id.summaryRecyclerView)).setVisibility(8);
            ((TextView) b(R$id.liveShowIsOverTextView)).setText(getContext().getString(R$string.live_closed));
            int i10 = R$id.liveClosedMessageTextView;
            ((TextView) b(i10)).setVisibility(0);
            ((TextView) b(i10)).setText(summaryModel.getAuditWarning());
            return;
        }
        ((LinearLayout) b(R$id.liveExperienceLayout)).setVisibility(0);
        final ExperienceInfoModel endExperienceInfo = summaryModel.getEndExperienceInfo();
        TextView textView = (TextView) b(R$id.liveExperience);
        q1.d dVar = q1.d.f53006a;
        String string = getContext().getString(R$string.live_experience, endExperienceInfo.getLiveIncome());
        s.h(string, "context.getString(R.stri…e, experience.liveIncome)");
        textView.setText(dVar.h(string, r.e(endExperienceInfo.getLiveIncome()), -49088, null, true));
        if (endExperienceInfo.getFullLevel()) {
            ((TextView) b(R$id.upgradeReminder)).setText(getContext().getString(R$string.has_reached_the_highest_level));
        } else {
            ((TextView) b(R$id.upgradeReminder)).setText(getContext().getString(R$string.not_far_from_upgrading, String.valueOf(endExperienceInfo.getDiffExperience())));
        }
        ((TextView) b(R$id.liveLevelText)).setText(getContext().getString(R$string.live_level, Integer.valueOf(endExperienceInfo.getCurrentLevel())));
        b(R$id.liveLevelBackground).post(new Runnable() { // from class: com.cupidapp.live.liveshow.view.summary.a
            @Override // java.lang.Runnable
            public final void run() {
                FKLiveForStreamerSummaryLayout.f(FKLiveForStreamerSummaryLayout.this, endExperienceInfo);
            }
        });
        int i11 = R$id.summaryRecyclerView;
        ((RecyclerView) b(i11)).setVisibility(0);
        FKLiveForStreamerSummaryAdapter fKLiveForStreamerSummaryAdapter = new FKLiveForStreamerSummaryAdapter();
        RecyclerView configStreamerSummaryLayout$lambda$1 = (RecyclerView) b(i11);
        configStreamerSummaryLayout$lambda$1.setAdapter(fKLiveForStreamerSummaryAdapter);
        configStreamerSummaryLayout$lambda$1.setLayoutManager(new GridLayoutManager(configStreamerSummaryLayout$lambda$1.getContext(), 2));
        s.h(configStreamerSummaryLayout$lambda$1, "configStreamerSummaryLayout$lambda$1");
        int c4 = h.c(configStreamerSummaryLayout$lambda$1, 4.0f);
        configStreamerSummaryLayout$lambda$1.addItemDecoration(new FKSingleColumnDecoration(c4, c4, c4, c4));
        String string2 = getContext().getString(R$string.viewers);
        s.h(string2, "context.getString(R.string.viewers)");
        fKLiveForStreamerSummaryAdapter.d(new FKLiveForStreamerSummaryModel(string2, String.valueOf(summaryModel.getViewers())));
        String string3 = getContext().getString(R$string.new_revenue);
        s.h(string3, "context.getString(R.string.new_revenue)");
        fKLiveForStreamerSummaryAdapter.d(new FKLiveForStreamerSummaryModel(string3, summaryModel.getNewCommission()));
        String string4 = getContext().getString(R$string.new_fans_count);
        s.h(string4, "context.getString(R.string.new_fans_count)");
        fKLiveForStreamerSummaryAdapter.d(new FKLiveForStreamerSummaryModel(string4, String.valueOf(summaryModel.getNewFans())));
        String string5 = getContext().getString(R$string.live_duration);
        s.h(string5, "context.getString(R.string.live_duration)");
        fKLiveForStreamerSummaryAdapter.d(new FKLiveForStreamerSummaryModel(string5, g(summaryModel.getLiveDurationMillis())));
        String string6 = getContext().getString(R$string.live_pk_times);
        s.h(string6, "context.getString(R.string.live_pk_times)");
        fKLiveForStreamerSummaryAdapter.d(new FKLiveForStreamerSummaryModel(string6, String.valueOf(summaryModel.getPkCount())));
        String string7 = getContext().getString(R$string.live_pk_win_times);
        s.h(string7, "context.getString(R.string.live_pk_win_times)");
        fKLiveForStreamerSummaryAdapter.d(new FKLiveForStreamerSummaryModel(string7, String.valueOf(summaryModel.getPkWinCount())));
        fKLiveForStreamerSummaryAdapter.notifyDataSetChanged();
    }

    public final String g(Long l10) {
        if (l10 == null) {
            return "00:00:00";
        }
        long longValue = l10.longValue() / 1000;
        kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f51038a;
        long j10 = 60;
        String format = String.format("%02d:%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf((int) (longValue / SdkConfigData.DEFAULT_REQUEST_INTERVAL)), Integer.valueOf((int) ((longValue / j10) % j10)), Integer.valueOf((int) (longValue % j10))}, 3));
        s.h(format, "format(format, *args)");
        return format;
    }

    public final void h() {
        z.a(this, R$layout.layout_live_for_streamer_summary, true);
        ConstraintLayout summaryRootForStreamerLayout = (ConstraintLayout) b(R$id.summaryRootForStreamerLayout);
        s.h(summaryRootForStreamerLayout, "summaryRootForStreamerLayout");
        y.d(summaryRootForStreamerLayout, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveForStreamerSummaryLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f15944b = new LinkedHashMap();
        h();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveForStreamerSummaryLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f15944b = new LinkedHashMap();
        h();
    }
}

package com.cupidapp.live.consult.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
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
import com.cupidapp.live.consult.model.ConsultAnchorCloseLiveModel;
import com.cupidapp.live.liveshow.view.summary.FKLiveForStreamerSummaryAdapter;
import com.cupidapp.live.liveshow.view.summary.FKLiveForStreamerSummaryModel;
import com.cupidapp.live.profile.model.User;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p1.g;
import z0.h;
import z0.y;
import z0.z;

/* compiled from: ConsultAnchorLiveEndLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ConsultAnchorLiveEndLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final FKLiveForStreamerSummaryAdapter f13834b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f13835c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConsultAnchorLiveEndLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f13835c = new LinkedHashMap();
        this.f13834b = new FKLiveForStreamerSummaryAdapter();
        e();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f13835c;
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

    public final void b(@NotNull final Function0<p> callback) {
        s.i(callback, "callback");
        FKUniversalButton consult_anchor_live_end_close_btn = (FKUniversalButton) a(R$id.consult_anchor_live_end_close_btn);
        s.h(consult_anchor_live_end_close_btn, "consult_anchor_live_end_close_btn");
        y.d(consult_anchor_live_end_close_btn, new Function1<View, p>() { // from class: com.cupidapp.live.consult.view.ConsultAnchorLiveEndLayout$bindLiveEndClickEvent$1
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

    public final void c(@Nullable ConsultAnchorCloseLiveModel consultAnchorCloseLiveModel) {
        com.cupidapp.live.base.fragment.b.f11807a.b();
        setVisibility(0);
        User X = g.f52734a.X();
        ImageLoaderView consult_anchor_live_end_avatar = (ImageLoaderView) a(R$id.consult_anchor_live_end_avatar);
        s.h(consult_anchor_live_end_avatar, "consult_anchor_live_end_avatar");
        ImageLoaderView.g(consult_anchor_live_end_avatar, X != null ? X.getAvatarImage() : null, null, null, 6, null);
        ((TextView) a(R$id.consult_anchor_live_end_name)).setText(X != null ? X.getName() : null);
        d(consultAnchorCloseLiveModel);
    }

    public final void d(ConsultAnchorCloseLiveModel consultAnchorCloseLiveModel) {
        if (consultAnchorCloseLiveModel == null) {
            ((RecyclerView) a(R$id.consult_anchor_live_end_info_recycler_view)).setVisibility(8);
            return;
        }
        RecyclerView configLiveInfoRecyclerView$lambda$0 = (RecyclerView) a(R$id.consult_anchor_live_end_info_recycler_view);
        configLiveInfoRecyclerView$lambda$0.setAdapter(this.f13834b);
        configLiveInfoRecyclerView$lambda$0.setLayoutManager(new GridLayoutManager(configLiveInfoRecyclerView$lambda$0.getContext(), 2));
        s.h(configLiveInfoRecyclerView$lambda$0, "configLiveInfoRecyclerView$lambda$0");
        int c4 = h.c(configLiveInfoRecyclerView$lambda$0, 4.0f);
        configLiveInfoRecyclerView$lambda$0.addItemDecoration(new FKSingleColumnDecoration(c4, c4, c4, c4));
        this.f13834b.j().clear();
        String viewers = consultAnchorCloseLiveModel.getViewers();
        boolean z10 = true;
        if (!(viewers == null || viewers.length() == 0)) {
            FKLiveForStreamerSummaryAdapter fKLiveForStreamerSummaryAdapter = this.f13834b;
            String string = getContext().getString(R$string.viewers);
            s.h(string, "context.getString(R.string.viewers)");
            fKLiveForStreamerSummaryAdapter.d(new FKLiveForStreamerSummaryModel(string, consultAnchorCloseLiveModel.getViewers()));
        }
        String newCommission = consultAnchorCloseLiveModel.getNewCommission();
        if (!(newCommission == null || newCommission.length() == 0)) {
            FKLiveForStreamerSummaryAdapter fKLiveForStreamerSummaryAdapter2 = this.f13834b;
            String string2 = getContext().getString(R$string.new_revenue);
            s.h(string2, "context.getString(R.string.new_revenue)");
            fKLiveForStreamerSummaryAdapter2.d(new FKLiveForStreamerSummaryModel(string2, consultAnchorCloseLiveModel.getNewCommission()));
        }
        String liveDurationSec = consultAnchorCloseLiveModel.getLiveDurationSec();
        if (!(liveDurationSec == null || liveDurationSec.length() == 0)) {
            FKLiveForStreamerSummaryAdapter fKLiveForStreamerSummaryAdapter3 = this.f13834b;
            String string3 = getContext().getString(R$string.live_duration);
            s.h(string3, "context.getString(R.string.live_duration)");
            fKLiveForStreamerSummaryAdapter3.d(new FKLiveForStreamerSummaryModel(string3, consultAnchorCloseLiveModel.getLiveDurationSec()));
        }
        String voiceConnectCount = consultAnchorCloseLiveModel.getVoiceConnectCount();
        if (!(voiceConnectCount == null || voiceConnectCount.length() == 0)) {
            FKLiveForStreamerSummaryAdapter fKLiveForStreamerSummaryAdapter4 = this.f13834b;
            String string4 = getContext().getString(R$string.normal_consult);
            s.h(string4, "context.getString(R.string.normal_consult)");
            fKLiveForStreamerSummaryAdapter4.d(new FKLiveForStreamerSummaryModel(string4, consultAnchorCloseLiveModel.getVoiceConnectCount()));
        }
        String oneToOneVoiceConnectCount = consultAnchorCloseLiveModel.getOneToOneVoiceConnectCount();
        if (oneToOneVoiceConnectCount != null && oneToOneVoiceConnectCount.length() != 0) {
            z10 = false;
        }
        if (!z10) {
            FKLiveForStreamerSummaryAdapter fKLiveForStreamerSummaryAdapter5 = this.f13834b;
            String string5 = getContext().getString(R$string.one_vs_one_consult);
            s.h(string5, "context.getString(R.string.one_vs_one_consult)");
            fKLiveForStreamerSummaryAdapter5.d(new FKLiveForStreamerSummaryModel(string5, consultAnchorCloseLiveModel.getOneToOneVoiceConnectCount()));
        }
        FKLiveForStreamerSummaryAdapter fKLiveForStreamerSummaryAdapter6 = this.f13834b;
        fKLiveForStreamerSummaryAdapter6.notifyItemRangeInserted(0, fKLiveForStreamerSummaryAdapter6.j().size());
    }

    public final void e() {
        z.a(this, R$layout.layout_consult_anchor_live_end, true);
        ConstraintLayout consult_anchor_live_end_root_layout = (ConstraintLayout) a(R$id.consult_anchor_live_end_root_layout);
        s.h(consult_anchor_live_end_root_layout, "consult_anchor_live_end_root_layout");
        y.d(consult_anchor_live_end_root_layout, new Function1<View, p>() { // from class: com.cupidapp.live.consult.view.ConsultAnchorLiveEndLayout$initView$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(View view) {
                invoke2(view);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
            }
        });
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConsultAnchorLiveEndLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f13835c = new LinkedHashMap();
        this.f13834b = new FKLiveForStreamerSummaryAdapter();
        e();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConsultAnchorLiveEndLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f13835c = new LinkedHashMap();
        this.f13834b = new FKLiveForStreamerSummaryAdapter();
        e();
    }
}

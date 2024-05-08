package com.cupidapp.live.liveshow.view.giftpicker.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.liveshow.view.giftpicker.model.RechargeRewardModel;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.u;
import z0.z;

/* compiled from: FirstRechargeRewardLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FirstRechargeRewardLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final Lazy f15550b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f15551c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FirstRechargeRewardLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f15551c = new LinkedHashMap();
        this.f15550b = kotlin.c.b(FirstRechargeRewardLayout$rewardAdapter$2.INSTANCE);
        d();
    }

    private final FirstRechargeRewardAdapter getRewardAdapter() {
        return (FirstRechargeRewardAdapter) this.f15550b.getValue();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f15551c;
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

    public final void b(@NotNull String title, @Nullable List<RechargeRewardModel> list) {
        s.i(title, "title");
        if (list == null || list.isEmpty()) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        ((TextView) a(R$id.reward_textview)).setText(title);
        getRewardAdapter().j().clear();
        getRewardAdapter().e(list);
        getRewardAdapter().notifyItemRangeInserted(0, list.size());
    }

    public final void c(@NotNull String title) {
        s.i(title, "title");
        ((TextView) a(R$id.reward_textview)).setText(title);
    }

    public final void d() {
        z.a(this, R$layout.layout_first_recharge_reward, true);
        setVisibility(8);
        TextView reward_textview = (TextView) a(R$id.reward_textview);
        s.h(reward_textview, "reward_textview");
        u.a(reward_textview);
        RecyclerView recyclerView = (RecyclerView) a(R$id.reward_recyclerview);
        recyclerView.setAdapter(getRewardAdapter());
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 0, false));
        recyclerView.setNestedScrollingEnabled(false);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FirstRechargeRewardLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f15551c = new LinkedHashMap();
        this.f15550b = kotlin.c.b(FirstRechargeRewardLayout$rewardAdapter$2.INSTANCE);
        d();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FirstRechargeRewardLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f15551c = new LinkedHashMap();
        this.f15550b = kotlin.c.b(FirstRechargeRewardLayout$rewardAdapter$2.INSTANCE);
        d();
    }
}

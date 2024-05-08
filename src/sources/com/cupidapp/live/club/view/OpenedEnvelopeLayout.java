package com.cupidapp.live.club.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.club.adapter.WinLotteryListAdapter;
import com.cupidapp.live.club.model.OpenRedEnvelopeResult;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.u;
import z0.y;
import z0.z;

/* compiled from: OpenedEnvelopeLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class OpenedEnvelopeLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final Lazy f13662b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f13663c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OpenedEnvelopeLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f13663c = new LinkedHashMap();
        this.f13662b = kotlin.c.b(OpenedEnvelopeLayout$winLotteryAdapter$2.INSTANCE);
        c();
    }

    private final WinLotteryListAdapter getWinLotteryAdapter() {
        return (WinLotteryListAdapter) this.f13662b.getValue();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f13663c;
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

    public final void b(@NotNull final OpenRedEnvelopeResult result) {
        s.i(result, "result");
        String ticket = result.getTicket();
        if (ticket == null || ticket.length() == 0) {
            Group win_lottery_group = (Group) a(R$id.win_lottery_group);
            s.h(win_lottery_group, "win_lottery_group");
            win_lottery_group.setVisibility(8);
            ((TextView) a(R$id.opened_title_textview)).setText(result.getTipMessage());
        } else {
            Group win_lottery_group2 = (Group) a(R$id.win_lottery_group);
            s.h(win_lottery_group2, "win_lottery_group");
            win_lottery_group2.setVisibility(0);
            ((TextView) a(R$id.opened_title_textview)).setText(getContext().getString(R$string.congratulations_on_obtaining));
            ((TextView) a(R$id.meal_ticket_count_textview)).setText(result.getTicket());
            TextView view_benefits_textview = (TextView) a(R$id.view_benefits_textview);
            s.h(view_benefits_textview, "view_benefits_textview");
            y.d(view_benefits_textview, new Function1<View, p>() { // from class: com.cupidapp.live.club.view.OpenedEnvelopeLayout$configLayout$1
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
                    j.a.b(com.cupidapp.live.base.router.j.f12156c, OpenedEnvelopeLayout.this.getContext(), result.getEarningJumpUrl(), null, 4, null);
                }
            });
        }
        getWinLotteryAdapter().j().clear();
        getWinLotteryAdapter().e(result.getList());
        getWinLotteryAdapter().notifyDataSetChanged();
    }

    public final void c() {
        z.a(this, R$layout.layout_opened_envelope, true);
        TextView meal_ticket_count_textview = (TextView) a(R$id.meal_ticket_count_textview);
        s.h(meal_ticket_count_textview, "meal_ticket_count_textview");
        u.a(meal_ticket_count_textview);
        TextView meal_ticket_textview = (TextView) a(R$id.meal_ticket_textview);
        s.h(meal_ticket_textview, "meal_ticket_textview");
        u.a(meal_ticket_textview);
        TextView fight_for_luck_textview = (TextView) a(R$id.fight_for_luck_textview);
        s.h(fight_for_luck_textview, "fight_for_luck_textview");
        u.a(fight_for_luck_textview);
        RecyclerView recyclerView = (RecyclerView) a(R$id.win_lottery_recyclerview);
        recyclerView.setAdapter(getWinLotteryAdapter());
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 1, false));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OpenedEnvelopeLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f13663c = new LinkedHashMap();
        this.f13662b = kotlin.c.b(OpenedEnvelopeLayout$winLotteryAdapter$2.INSTANCE);
        c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OpenedEnvelopeLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f13663c = new LinkedHashMap();
        this.f13662b = kotlin.c.b(OpenedEnvelopeLayout$winLotteryAdapter$2.INSTANCE);
        c();
    }
}

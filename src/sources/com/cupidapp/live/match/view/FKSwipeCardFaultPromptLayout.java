package com.cupidapp.live.match.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.network.model.ConstantsResult;
import com.cupidapp.live.base.sensorslog.SensorsLogMatch;
import com.cupidapp.live.base.view.BaseLayout;
import com.cupidapp.live.base.view.button.FKUniversalButton;
import com.cupidapp.live.match.model.MatchFilterSettingType;
import com.cupidapp.live.match.model.MatchSettingResult;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKSwipeCardFaultPromptLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FKSwipeCardFaultPromptLayout extends BaseLayout {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f16874d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKSwipeCardFaultPromptLayout(@NotNull Context context) {
        super(context);
        kotlin.jvm.internal.s.i(context, "context");
        this.f16874d = new LinkedHashMap();
        i();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void g(FKSwipeCardFaultPromptLayout fKSwipeCardFaultPromptLayout, FKSwipeCardFaultType fKSwipeCardFaultType, String str, String str2, Function1 function1, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            str2 = null;
        }
        if ((i10 & 8) != 0) {
            function1 = null;
        }
        fKSwipeCardFaultPromptLayout.f(fKSwipeCardFaultType, str, str2, function1);
    }

    @Nullable
    public View e(int i10) {
        Map<Integer, View> map = this.f16874d;
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

    public final void f(final FKSwipeCardFaultType fKSwipeCardFaultType, String str, String str2, final Function1<? super FKSwipeCardFaultType, kotlin.p> function1) {
        if (getVisibility() != 0) {
            SensorsLogMatch.f12215a.a(fKSwipeCardFaultType.getReason(), fKSwipeCardFaultType != FKSwipeCardFaultType.NoEligibleUsers ? str : "");
        }
        setVisibility(0);
        ((TextView) e(R$id.prompt_title)).setText(getContext().getString(fKSwipeCardFaultType.getTitle()));
        boolean z10 = true;
        if (str == null || str.length() == 0) {
            ((TextView) e(R$id.prompt_message)).setVisibility(8);
        } else {
            int i10 = R$id.prompt_message;
            ((TextView) e(i10)).setVisibility(0);
            ((TextView) e(i10)).setText(str);
        }
        if (str2 != null && str2.length() != 0) {
            z10 = false;
        }
        if (z10) {
            ((FKUniversalButton) e(R$id.prompt_action_button)).setVisibility(8);
            return;
        }
        int i11 = R$id.prompt_action_button;
        ((FKUniversalButton) e(i11)).setVisibility(0);
        ((FKUniversalButton) e(i11)).setText(str2);
        FKUniversalButton prompt_action_button = (FKUniversalButton) e(i11);
        kotlin.jvm.internal.s.h(prompt_action_button, "prompt_action_button");
        z0.y.d(prompt_action_button, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.match.view.FKSwipeCardFaultPromptLayout$configFaultPrompt$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(View view) {
                invoke2(view);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
                Function1<FKSwipeCardFaultType, kotlin.p> function12 = function1;
                if (function12 != null) {
                    function12.invoke(fKSwipeCardFaultType);
                }
            }
        });
    }

    public final void h(MatchSettingResult matchSettingResult, Function1<? super FKSwipeCardFaultType, kotlin.p> function1) {
        MatchFilterSettingType.a aVar = MatchFilterSettingType.Companion;
        ConstantsResult q10 = p1.g.f52734a.q();
        if (!aVar.a(q10 != null ? q10.getMatchFilterSettingType() : null)) {
            if (!(matchSettingResult != null && matchSettingResult.getUseRecommend())) {
                g(this, FKSwipeCardFaultType.BrowsedAllUsers, getContext().getString(R$string.renew_matching_new_users), null, null, 12, null);
                return;
            }
        }
        f(FKSwipeCardFaultType.NoEligibleUsers, null, getContext().getString(R$string.modify_filter_condition), function1);
    }

    public final void i() {
        z0.z.a(this, R$layout.layout_swipe_card_fault_prompt, true);
        setVisibility(8);
        ((TextView) e(R$id.prompt_title)).getPaint().setFakeBoldText(true);
        ((TextView) e(R$id.prompt_message)).getPaint().setFakeBoldText(true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x0066, code lost:
    
        if (r1.intValue() != r2) goto L36;
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void j(@org.jetbrains.annotations.NotNull com.cupidapp.live.match.view.FKFaultModel r11, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.cupidapp.live.match.view.FKSwipeCardFaultType, kotlin.p> r12) {
        /*
            Method dump skipped, instructions count: 252
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.match.view.FKSwipeCardFaultPromptLayout.j(com.cupidapp.live.match.view.FKFaultModel, kotlin.jvm.functions.Function1):void");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKSwipeCardFaultPromptLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.s.i(context, "context");
        this.f16874d = new LinkedHashMap();
        i();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKSwipeCardFaultPromptLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.s.i(context, "context");
        this.f16874d = new LinkedHashMap();
        i();
    }
}

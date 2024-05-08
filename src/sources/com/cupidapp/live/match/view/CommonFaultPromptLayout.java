package com.cupidapp.live.match.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.view.button.FKUniversalButton;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: CommonFaultPromptLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class CommonFaultPromptLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f16849b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommonFaultPromptLayout(@NotNull Context context) {
        super(context);
        kotlin.jvm.internal.s.i(context, "context");
        this.f16849b = new LinkedHashMap();
        c();
    }

    private final void setPromptActionButton(String str) {
        if (str == null) {
            ((FKUniversalButton) a(R$id.fault_prompt_action_button)).setVisibility(8);
            return;
        }
        int i10 = R$id.fault_prompt_action_button;
        ((FKUniversalButton) a(i10)).setVisibility(0);
        ((FKUniversalButton) a(i10)).setText(str);
    }

    private final void setPromptMessage(String str) {
        ((TextView) a(R$id.fault_prompt_message)).setText(str);
    }

    private final void setPromptTitle(String str) {
        ((TextView) a(R$id.fault_prompt_title)).setText(str);
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f16849b;
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

    public final void b(@NotNull String title, @Nullable String str, @Nullable String str2, @Nullable final Function0<kotlin.p> function0) {
        kotlin.jvm.internal.s.i(title, "title");
        setPromptTitle(title);
        setPromptMessage(str);
        setPromptActionButton(str2);
        FKUniversalButton fault_prompt_action_button = (FKUniversalButton) a(R$id.fault_prompt_action_button);
        kotlin.jvm.internal.s.h(fault_prompt_action_button, "fault_prompt_action_button");
        z0.y.d(fault_prompt_action_button, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.match.view.CommonFaultPromptLayout$fillMatchFaultPrompt$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                Function0<kotlin.p> function02 = function0;
                if (function02 != null) {
                    function02.invoke();
                }
            }
        });
    }

    public final void c() {
        z0.z.a(this, R$layout.layout_common_fault_prompt, true);
        ((TextView) a(R$id.fault_prompt_title)).getPaint().setFakeBoldText(true);
        ((TextView) a(R$id.fault_prompt_message)).getPaint().setFakeBoldText(true);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommonFaultPromptLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.s.i(context, "context");
        this.f16849b = new LinkedHashMap();
        c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommonFaultPromptLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.s.i(context, "context");
        this.f16849b = new LinkedHashMap();
        c();
    }
}

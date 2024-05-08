package com.cupidapp.live.maskparty.view.script;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.ViewGroupKt;
import com.cupidapp.live.R$drawable;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.utils.i;
import com.cupidapp.live.base.view.button.FKUniversalButton;
import com.cupidapp.live.maskparty.model.ScriptRoleModel;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.c;
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

/* compiled from: ScriptSelectRoleLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class ScriptSelectRoleLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public Function1<? super ScriptRoleModel, p> f16469b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public List<ScriptRoleModel> f16470c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public final Lazy f16471d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f16472e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f16473f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScriptSelectRoleLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f16473f = new LinkedHashMap();
        this.f16471d = c.b(ScriptSelectRoleLayout$countDownTimer$2.INSTANCE);
        g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final i getCountDownTimer() {
        return (i) this.f16471d.getValue();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f16473f;
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

    public final void e(@NotNull List<ScriptRoleModel> roleList) {
        s.i(roleList, "roleList");
        this.f16470c = roleList;
        ((LinearLayout) a(R$id.role_layout)).removeAllViews();
        final int i10 = 0;
        for (ScriptRoleModel scriptRoleModel : roleList) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                kotlin.collections.s.s();
            }
            final TextView textView = new TextView(getContext());
            textView.setBackgroundResource(R$drawable.script_options_selector);
            textView.setText(scriptRoleModel.getCharacterName());
            textView.setTextSize(16.0f);
            textView.setTextColor(-49088);
            textView.setGravity(17);
            textView.setPadding(0, h.c(textView, 20.0f), 0, h.c(textView, 20.0f));
            y.d(textView, new Function1<View, p>() { // from class: com.cupidapp.live.maskparty.view.script.ScriptSelectRoleLayout$configRoleLayout$1$roleTextView$1$1
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
                    if (TextView.this.isSelected()) {
                        return;
                    }
                    this.f(i10);
                }
            });
            ((LinearLayout) a(R$id.role_layout)).addView(textView, new LinearLayout.LayoutParams(0, -2, 1.0f));
            if (i10 == 0) {
                y.l(textView, 0, 0, Integer.valueOf(h.c(this, 8.0f)), 0);
            } else if (i10 == roleList.size() - 1) {
                y.l(textView, Integer.valueOf(h.c(this, 8.0f)), 0, 0, 0);
            }
            i10 = i11;
        }
        f(0);
        getCountDownTimer().c(15, 1, new Function0<p>() { // from class: com.cupidapp.live.maskparty.view.script.ScriptSelectRoleLayout$configRoleLayout$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ p invoke() {
                invoke2();
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ScriptSelectRoleLayout.this.h();
            }
        }, new Function1<Integer, p>() { // from class: com.cupidapp.live.maskparty.view.script.ScriptSelectRoleLayout$configRoleLayout$3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Integer num) {
                invoke(num.intValue());
                return p.f51048a;
            }

            public final void invoke(int i12) {
                ((FKUniversalButton) ScriptSelectRoleLayout.this.a(R$id.confirm_select_button)).setText(ScriptSelectRoleLayout.this.getContext().getString(R$string.confirm_countdown, Integer.valueOf(i12)));
            }
        });
    }

    public final void f(int i10) {
        LinearLayout role_layout = (LinearLayout) a(R$id.role_layout);
        s.h(role_layout, "role_layout");
        int i11 = 0;
        for (View view : ViewGroupKt.getChildren(role_layout)) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                kotlin.collections.s.s();
            }
            View view2 = view;
            TextView textView = view2 instanceof TextView ? (TextView) view2 : null;
            if (textView != null) {
                boolean z10 = i11 == i10;
                List<ScriptRoleModel> list = this.f16470c;
                ScriptRoleModel scriptRoleModel = list != null ? list.get(i11) : null;
                if (scriptRoleModel != null) {
                    scriptRoleModel.setSelected(z10);
                }
                textView.setSelected(z10);
                textView.getPaint().setFakeBoldText(z10);
                textView.setTextColor(z10 ? -49088 : -16777216);
            }
            i11 = i12;
        }
    }

    public final void g() {
        z.a(this, R$layout.layout_script_select_role, true);
        ((TextView) a(R$id.you_win_textview)).getPaint().setFakeBoldText(true);
        FKUniversalButton confirm_select_button = (FKUniversalButton) a(R$id.confirm_select_button);
        s.h(confirm_select_button, "confirm_select_button");
        y.d(confirm_select_button, new Function1<View, p>() { // from class: com.cupidapp.live.maskparty.view.script.ScriptSelectRoleLayout$initView$1
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
                i countDownTimer;
                ScriptSelectRoleLayout.this.h();
                countDownTimer = ScriptSelectRoleLayout.this.getCountDownTimer();
                countDownTimer.g();
            }
        });
    }

    @Nullable
    public final Function1<ScriptRoleModel, p> getSelectRoleCallback() {
        return this.f16469b;
    }

    public final void h() {
        Function1<? super ScriptRoleModel, p> function1;
        this.f16472e = true;
        List<ScriptRoleModel> list = this.f16470c;
        ScriptRoleModel scriptRoleModel = null;
        if (list != null) {
            Iterator<ScriptRoleModel> iterator2 = list.iterator2();
            while (true) {
                if (!iterator2.hasNext()) {
                    break;
                }
                ScriptRoleModel next = iterator2.next();
                if (next.getSelected()) {
                    scriptRoleModel = next;
                    break;
                }
            }
            scriptRoleModel = scriptRoleModel;
        }
        if (scriptRoleModel == null || (function1 = this.f16469b) == null) {
            return;
        }
        function1.invoke(scriptRoleModel);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (!this.f16472e) {
            h();
        }
        getCountDownTimer().g();
    }

    public final void setSelectRoleCallback(@Nullable Function1<? super ScriptRoleModel, p> function1) {
        this.f16469b = function1;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScriptSelectRoleLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f16473f = new LinkedHashMap();
        this.f16471d = c.b(ScriptSelectRoleLayout$countDownTimer$2.INSTANCE);
        g();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScriptSelectRoleLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f16473f = new LinkedHashMap();
        this.f16471d = c.b(ScriptSelectRoleLayout$countDownTimer$2.INSTANCE);
        g();
    }
}

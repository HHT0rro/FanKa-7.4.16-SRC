package com.cupidapp.live.maskparty.view.script;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.view.button.FKUniversalButton;
import com.cupidapp.live.maskparty.model.MaskPartyScriptTaskItemModel;
import com.cupidapp.live.maskparty.model.MaskPartyScriptTaskModel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.q;
import z0.y;
import z0.z;

/* compiled from: ScriptTaskLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class ScriptTaskLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public Function0<p> f16474b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f16475c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f16476d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScriptTaskLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f16476d = new LinkedHashMap();
        d();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f16476d;
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

    public final void c(@NotNull MaskPartyScriptTaskModel task, boolean z10) {
        s.i(task, "task");
        ((TextView) a(R$id.script_role_textview)).setText(task.getCharacterName());
        ((TextView) a(R$id.script_content_textview)).setText(task.getStory());
        ((LinearLayout) a(R$id.script_task_layout)).removeAllViews();
        int i10 = 0;
        for (MaskPartyScriptTaskItemModel maskPartyScriptTaskItemModel : task.getTask()) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                kotlin.collections.s.s();
            }
            MaskPartyScriptTaskItemModel maskPartyScriptTaskItemModel2 = maskPartyScriptTaskItemModel;
            int i12 = R$id.script_task_layout;
            LinearLayout script_task_layout = (LinearLayout) a(i12);
            s.h(script_task_layout, "script_task_layout");
            View b4 = z.b(script_task_layout, R$layout.layout_script_task_item, false, 2, null);
            TextView textView = (TextView) b4.findViewById(R$id.task_textview);
            TextView textView2 = (TextView) b4.findViewById(R$id.task_content_textview);
            ImageView completeView = (ImageView) b4.findViewById(R$id.complete_imageview);
            textView.setText(getContext().getString(R$string.tasks, q.a(i11)));
            textView2.setText(maskPartyScriptTaskItemModel2.getDesc());
            s.h(completeView, "completeView");
            completeView.setVisibility(maskPartyScriptTaskItemModel2.getStatus() == 1 ? 0 : 8);
            ((LinearLayout) a(i12)).addView(b4);
            i10 = i11;
        }
        ((FKUniversalButton) a(R$id.play_script_button)).setText(z10 ? getContext().getString(R$string.i_know) : getContext().getString(R$string.start_play_script));
    }

    public final void d() {
        z.a(this, R$layout.layout_script_task, true);
        ((TextView) a(R$id.script_task_title_textview)).getPaint().setFakeBoldText(true);
        ((TextView) a(R$id.your_role_textview)).getPaint().setFakeBoldText(true);
        ((TextView) a(R$id.script_role_textview)).getPaint().setFakeBoldText(true);
        ((TextView) a(R$id.your_task_textview)).getPaint().setFakeBoldText(true);
        FKUniversalButton play_script_button = (FKUniversalButton) a(R$id.play_script_button);
        s.h(play_script_button, "play_script_button");
        y.d(play_script_button, new Function1<View, p>() { // from class: com.cupidapp.live.maskparty.view.script.ScriptTaskLayout$initView$1
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
                ScriptTaskLayout.this.f16475c = true;
                Function0<p> playScriptCallback = ScriptTaskLayout.this.getPlayScriptCallback();
                if (playScriptCallback != null) {
                    playScriptCallback.invoke();
                }
            }
        });
    }

    @Nullable
    public final Function0<p> getPlayScriptCallback() {
        return this.f16474b;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Function0<p> function0;
        super.onDetachedFromWindow();
        if (this.f16475c || (function0 = this.f16474b) == null) {
            return;
        }
        function0.invoke();
    }

    public final void setPlayScriptCallback(@Nullable Function0<p> function0) {
        this.f16474b = function0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScriptTaskLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f16476d = new LinkedHashMap();
        d();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScriptTaskLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f16476d = new LinkedHashMap();
        d();
    }
}

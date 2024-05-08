package com.cupidapp.live.maskparty.view.script;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.view.button.FKUniversalButton;
import com.cupidapp.live.maskparty.model.MaskPartyScriptModel;
import com.cupidapp.live.maskparty.model.ScriptRoleModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.t;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;
import z0.z;

/* compiled from: MaskPartyScriptLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MaskPartyScriptLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public Function0<p> f16465b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f16466c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaskPartyScriptLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f16466c = new LinkedHashMap();
        c();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f16466c;
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

    public final void b(@NotNull MaskPartyScriptModel script) {
        s.i(script, "script");
        ((TextView) a(R$id.script_title_textview)).setText(script.getTitle());
        ((TextView) a(R$id.script_content_textview)).setText(script.getStory());
        TextView textView = (TextView) a(R$id.script_role_textview);
        List<ScriptRoleModel> role = script.getRole();
        ArrayList arrayList = new ArrayList(t.t(role, 10));
        Iterator<ScriptRoleModel> iterator2 = role.iterator2();
        while (iterator2.hasNext()) {
            arrayList.add(iterator2.next().getCharacterName());
        }
        Iterator<E> iterator22 = arrayList.iterator2();
        if (iterator22.hasNext()) {
            Object next = iterator22.next();
            while (iterator22.hasNext()) {
                next = ((String) next) + "、" + ((String) iterator22.next());
            }
            textView.setText((CharSequence) next);
            return;
        }
        throw new UnsupportedOperationException("Empty collection can't be reduced.");
    }

    public final void c() {
        z.a(this, R$layout.layout_mask_party_script, true);
        ((TextView) a(R$id.script_title_textview)).getPaint().setFakeBoldText(true);
        ((TextView) a(R$id.story_background_textview)).getPaint().setFakeBoldText(true);
        ((TextView) a(R$id.role_textview)).getPaint().setFakeBoldText(true);
        FKUniversalButton play_script_button = (FKUniversalButton) a(R$id.play_script_button);
        s.h(play_script_button, "play_script_button");
        y.d(play_script_button, new Function1<View, p>() { // from class: com.cupidapp.live.maskparty.view.script.MaskPartyScriptLayout$initView$1
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
                Function0<p> startPlayCallback = MaskPartyScriptLayout.this.getStartPlayCallback();
                if (startPlayCallback != null) {
                    startPlayCallback.invoke();
                }
            }
        });
    }

    @Nullable
    public final Function0<p> getStartPlayCallback() {
        return this.f16465b;
    }

    public final void setStartPlayCallback(@Nullable Function0<p> function0) {
        this.f16465b = function0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaskPartyScriptLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f16466c = new LinkedHashMap();
        c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaskPartyScriptLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f16466c = new LinkedHashMap();
        c();
    }
}

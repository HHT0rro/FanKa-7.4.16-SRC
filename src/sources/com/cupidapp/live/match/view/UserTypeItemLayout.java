package com.cupidapp.live.match.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.view.BaseLayout;
import com.cupidapp.live.match.model.FilterOption;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: UserTypeItemLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class UserTypeItemLayout extends BaseLayout {

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public g0 f17016d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f17017e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserTypeItemLayout(@NotNull Context context) {
        super(context);
        kotlin.jvm.internal.s.i(context, "context");
        this.f17017e = new LinkedHashMap();
        h();
    }

    public static final void i(UserTypeItemLayout this$0, CompoundButton compoundButton, boolean z10) {
        g0 g0Var;
        kotlin.jvm.internal.s.i(this$0, "this$0");
        if (!compoundButton.isPressed() || (g0Var = this$0.f17016d) == null) {
            return;
        }
        g0Var.a(z10);
    }

    @Nullable
    public View f(int i10) {
        Map<Integer, View> map = this.f17017e;
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

    public final void g(@NotNull FilterOption model, @NotNull g0 changedListener) {
        kotlin.jvm.internal.s.i(model, "model");
        kotlin.jvm.internal.s.i(changedListener, "changedListener");
        ((TextView) f(R$id.user_type_title)).setText(model.getLabel());
        ((CheckBox) f(R$id.user_type_checked)).setChecked(model.getChecked());
        this.f17016d = changedListener;
    }

    public final void h() {
        z0.z.a(this, R$layout.layout_user_type_item, true);
        TextView user_type_title = (TextView) f(R$id.user_type_title);
        kotlin.jvm.internal.s.h(user_type_title, "user_type_title");
        z0.u.a(user_type_title);
        ((CheckBox) f(R$id.user_type_checked)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.cupidapp.live.match.view.h0
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                UserTypeItemLayout.i(UserTypeItemLayout.this, compoundButton, z10);
            }
        });
    }

    public final void setChecked(boolean z10) {
        ((CheckBox) f(R$id.user_type_checked)).setChecked(z10);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserTypeItemLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.s.i(context, "context");
        this.f17017e = new LinkedHashMap();
        h();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserTypeItemLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.s.i(context, "context");
        this.f17017e = new LinkedHashMap();
        h();
    }
}

package com.cupidapp.live.setting.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.cupidapp.live.R$layout;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: UserFunctionEntranceLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class UserFunctionEntranceLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f18240b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserFunctionEntranceLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f18240b = new LinkedHashMap();
        a();
    }

    public final void a() {
        z.a(this, R$layout.layout_user_entrance, true);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserFunctionEntranceLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f18240b = new LinkedHashMap();
        a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserFunctionEntranceLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f18240b = new LinkedHashMap();
        a();
    }
}

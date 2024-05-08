package com.cupidapp.live.liveshow.view.guide;

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

/* compiled from: FKLiveNetworkErrorLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLiveNetworkErrorLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f15666b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveNetworkErrorLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f15666b = new LinkedHashMap();
        a();
    }

    public final void a() {
        z.a(this, R$layout.layout_live_network_error, true);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveNetworkErrorLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f15666b = new LinkedHashMap();
        a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveNetworkErrorLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f15666b = new LinkedHashMap();
        a();
    }
}

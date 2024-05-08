package com.cupidapp.live.vip.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.view.BaseLayout;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: VipPurchaseGuideIntroLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class VipPurchaseGuideIntroLayout extends BaseLayout {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f18788d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VipPurchaseGuideIntroLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f18788d = new LinkedHashMap();
        e();
    }

    public final void e() {
        z.a(this, R$layout.layout_vip_purchase_guide_intro, true);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VipPurchaseGuideIntroLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f18788d = new LinkedHashMap();
        e();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VipPurchaseGuideIntroLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f18788d = new LinkedHashMap();
        e();
    }
}

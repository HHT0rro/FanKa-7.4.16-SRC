package com.cupidapp.live.base.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.match.model.PurchaseProductType;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: FKSVipImgLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKSVipImgLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f12521b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKSVipImgLayout(@NotNull Context context) {
        super(context);
        kotlin.jvm.internal.s.i(context, "context");
        this.f12521b = new LinkedHashMap();
        e();
    }

    public static /* synthetic */ void g(FKSVipImgLayout fKSVipImgLayout, int i10, String str, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str = null;
        }
        fKSVipImgLayout.f(i10, str);
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f12521b;
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

    public final void b() {
        ((TextView) a(R$id.item_super_des)).setVisibility(8);
        ((ImageView) a(R$id.a_plus_img)).setImageResource(R$mipmap.rainbow_aplus_logo);
    }

    public final void c(@Nullable String str) {
        if (str == null || str.length() == 0) {
            ((TextView) a(R$id.item_super_des)).setVisibility(8);
            ((ImageView) a(R$id.a_plus_img)).setImageResource(R$mipmap.super_aplus_logo);
        } else {
            int i10 = R$id.item_super_des;
            ((TextView) a(i10)).setVisibility(0);
            ((TextView) a(i10)).setText(str);
            ((ImageView) a(R$id.a_plus_img)).setImageResource(R$mipmap.ic_svip_with_discount);
        }
    }

    public final void d() {
        ((TextView) a(R$id.item_super_des)).setVisibility(8);
        ((ImageView) a(R$id.a_plus_img)).setImageResource(R$mipmap.aplus_logo);
    }

    public final void e() {
        z.a(this, R$layout.view_svip, true);
    }

    public final void f(int i10, @Nullable String str) {
        PurchaseProductType.a aVar = PurchaseProductType.Companion;
        if (aVar.d(i10)) {
            d();
            setVisibility(0);
        } else if (aVar.c(i10)) {
            c(str);
            setVisibility(0);
        } else if (aVar.b(i10)) {
            b();
            setVisibility(0);
        } else {
            setVisibility(8);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKSVipImgLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.s.i(context, "context");
        this.f12521b = new LinkedHashMap();
        e();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKSVipImgLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.s.i(context, "context");
        this.f12521b = new LinkedHashMap();
        e();
    }
}

package com.cupidapp.live.maskparty.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: MaskPartyItemCardGuideView.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MaskPartyItemCardGuideView extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public com.cupidapp.live.base.utils.i f16407b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f16408c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaskPartyItemCardGuideView(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f16408c = new LinkedHashMap();
        c();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f16408c;
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

    public final void b(@Nullable String str) {
        if (str == null || str.length() == 0) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        ((TextView) a(R$id.guide_message_textview)).setText(str);
        d();
    }

    public final void c() {
        z.a(this, R$layout.mask_party_item_card_guide_view, true);
        setVisibility(8);
    }

    public final void d() {
        com.cupidapp.live.base.utils.i iVar = new com.cupidapp.live.base.utils.i();
        this.f16407b = iVar;
        s.f(iVar);
        com.cupidapp.live.base.utils.i.d(iVar, 5, 1, new Function0<p>() { // from class: com.cupidapp.live.maskparty.view.MaskPartyItemCardGuideView$startCountDown$1
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
                MaskPartyItemCardGuideView.this.setVisibility(8);
            }
        }, null, 8, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.cupidapp.live.base.utils.i iVar = this.f16407b;
        if (iVar != null) {
            iVar.g();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaskPartyItemCardGuideView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f16408c = new LinkedHashMap();
        c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaskPartyItemCardGuideView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f16408c = new LinkedHashMap();
        c();
    }
}

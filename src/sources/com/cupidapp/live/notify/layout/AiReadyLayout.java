package com.cupidapp.live.notify.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.view.BaseLayout;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;
import z0.z;

/* compiled from: AiReadyLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class AiReadyLayout extends BaseLayout {

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public a f17564d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f17565e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AiReadyLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f17565e = new LinkedHashMap();
        h();
    }

    @Nullable
    public View e(int i10) {
        Map<Integer, View> map = this.f17565e;
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

    public final void g(@NotNull a callback) {
        s.i(callback, "callback");
        this.f17564d = callback;
    }

    public final void h() {
        z.a(this, R$layout.layout_ai_ready, true);
        ImageLoaderView ai_identify_img = (ImageLoaderView) e(R$id.ai_identify_img);
        s.h(ai_identify_img, "ai_identify_img");
        y.d(ai_identify_img, new Function1<View, p>() { // from class: com.cupidapp.live.notify.layout.AiReadyLayout$initView$1
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
                a aVar;
                aVar = AiReadyLayout.this.f17564d;
                if (aVar != null) {
                    aVar.z0();
                }
            }
        });
    }

    public final void i(@NotNull String url) {
        s.i(url, "url");
        ImageLoaderView ai_identify_img = (ImageLoaderView) e(R$id.ai_identify_img);
        s.h(ai_identify_img, "ai_identify_img");
        ImageLoaderView.f(ai_identify_img, new com.cupidapp.live.base.imageloader.b(false, url, null, null, null, null, null, 0, 0, null, null, null, null, false, 0, 0, false, null, null, 524285, null), null, 2, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AiReadyLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f17565e = new LinkedHashMap();
        h();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AiReadyLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f17565e = new LinkedHashMap();
        h();
    }
}
package com.cupidapp.live.setting.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.view.timepicker.c;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: PushCustomTimeSettingLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class PushCustomTimeSettingLayout extends RelativeLayout {

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public c f18219b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public c f18220c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public Function2<? super Long, ? super Long, p> f18221d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public Long f18222e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public Long f18223f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f18224g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PushCustomTimeSettingLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f18224g = new LinkedHashMap();
        e();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f18224g;
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

    public final void e() {
        z.a(this, R$layout.layout_custom_time_setting, true);
    }

    public final void f() {
        c cVar = this.f18219b;
        if (cVar != null) {
            cVar.c();
        }
        c cVar2 = this.f18220c;
        if (cVar2 != null) {
            cVar2.c();
        }
    }

    public final void g() {
        Long l10;
        Long l11 = this.f18222e;
        if (l11 == null || (l10 = this.f18223f) == null) {
            return;
        }
        Function2<? super Long, ? super Long, p> function2 = this.f18221d;
        if (function2 != null) {
            function2.mo1743invoke(l11, l10);
        }
        this.f18222e = null;
        this.f18223f = null;
    }

    @Nullable
    public final Function2<Long, Long, p> getResultData() {
        return this.f18221d;
    }

    public final void setResultData(@Nullable Function2<? super Long, ? super Long, p> function2) {
        this.f18221d = function2;
    }

    public final void setTime(@Nullable Long l10, @Nullable Long l11) {
        Context context = getContext();
        s.h(context, "context");
        c cVar = new c(context, l10, new Function1<Date, p>() { // from class: com.cupidapp.live.setting.view.PushCustomTimeSettingLayout$setTime$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Date date) {
                invoke2(date);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Date date) {
                if (date != null) {
                    PushCustomTimeSettingLayout pushCustomTimeSettingLayout = PushCustomTimeSettingLayout.this;
                    pushCustomTimeSettingLayout.f18222e = Long.valueOf(date.getTime());
                    pushCustomTimeSettingLayout.g();
                }
            }
        });
        this.f18219b = cVar;
        c d10 = cVar.d(15);
        if (d10 != null) {
            int i10 = R$id.customTimeStartFrameLayout;
            FrameLayout customTimeStartFrameLayout = (FrameLayout) a(i10);
            s.h(customTimeStartFrameLayout, "customTimeStartFrameLayout");
            c f10 = d10.f(customTimeStartFrameLayout);
            if (f10 != null) {
                f10.h((FrameLayout) a(i10), false);
            }
        }
        Context context2 = getContext();
        s.h(context2, "context");
        c cVar2 = new c(context2, l11, new Function1<Date, p>() { // from class: com.cupidapp.live.setting.view.PushCustomTimeSettingLayout$setTime$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Date date) {
                invoke2(date);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Date date) {
                if (date != null) {
                    PushCustomTimeSettingLayout pushCustomTimeSettingLayout = PushCustomTimeSettingLayout.this;
                    pushCustomTimeSettingLayout.f18223f = Long.valueOf(date.getTime());
                    pushCustomTimeSettingLayout.g();
                }
            }
        });
        this.f18220c = cVar2;
        c d11 = cVar2.d(15);
        if (d11 != null) {
            int i11 = R$id.customTimeEndFrameLayout;
            FrameLayout customTimeEndFrameLayout = (FrameLayout) a(i11);
            s.h(customTimeEndFrameLayout, "customTimeEndFrameLayout");
            c f11 = d11.f(customTimeEndFrameLayout);
            if (f11 != null) {
                f11.h((FrameLayout) a(i11), false);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PushCustomTimeSettingLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f18224g = new LinkedHashMap();
        e();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PushCustomTimeSettingLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f18224g = new LinkedHashMap();
        e();
    }
}

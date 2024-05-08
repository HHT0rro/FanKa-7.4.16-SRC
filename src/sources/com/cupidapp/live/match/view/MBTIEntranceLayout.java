package com.cupidapp.live.match.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.view.BaseLayout;
import com.cupidapp.live.match.view.MBTIEntranceLayout;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MBTIEntranceLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MBTIEntranceLayout extends BaseLayout {

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public a f16949d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public SensorPosition f16950e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f16951f;

    /* compiled from: MBTIEntranceLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface a {
        void a(boolean z10);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MBTIEntranceLayout(@NotNull Context context) {
        super(context);
        kotlin.jvm.internal.s.i(context, "context");
        this.f16951f = new LinkedHashMap();
        i();
    }

    @Nullable
    public View e(int i10) {
        Map<Integer, View> map = this.f16951f;
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

    public final void h(boolean z10) {
        if (z10 && kotlin.jvm.internal.s.d(p1.g.f52734a.m0(), Boolean.TRUE)) {
            setVisibility(0);
            a aVar = this.f16949d;
            if (aVar != null) {
                aVar.a(true);
                return;
            }
            return;
        }
        setVisibility(8);
        a aVar2 = this.f16949d;
        if (aVar2 != null) {
            aVar2.a(false);
        }
    }

    public final void i() {
        setVisibility(8);
        z0.z.a(this, R$layout.layout_mbti_entrance, true);
        TextView mbti_entrance_txt = (TextView) e(R$id.mbti_entrance_txt);
        kotlin.jvm.internal.s.h(mbti_entrance_txt, "mbti_entrance_txt");
        z0.u.a(mbti_entrance_txt);
        ImageView mbti_close = (ImageView) e(R$id.mbti_close);
        kotlin.jvm.internal.s.h(mbti_close, "mbti_close");
        z0.y.d(mbti_close, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.match.view.MBTIEntranceLayout$initView$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(View view) {
                invoke2(view);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
                MBTIEntranceLayout.a aVar;
                p1.g.f52734a.O2(Boolean.FALSE);
                MBTIEntranceLayout.this.setVisibility(8);
                aVar = MBTIEntranceLayout.this.f16949d;
                if (aVar != null) {
                    aVar.a(false);
                }
            }
        });
        TextView mbti_try_text = (TextView) e(R$id.mbti_try_text);
        kotlin.jvm.internal.s.h(mbti_try_text, "mbti_try_text");
        z0.y.d(mbti_try_text, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.match.view.MBTIEntranceLayout$initView$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(View view) {
                invoke2(view);
                return kotlin.p.f51048a;
            }

            /* JADX WARN: Code restructure failed: missing block: B:8:0x0019, code lost:
            
                if ((r9.length() > 0) == true) goto L13;
             */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void invoke2(@org.jetbrains.annotations.Nullable android.view.View r9) {
                /*
                    r8 = this;
                    com.cupidapp.live.match.view.MBTIEntranceLayout r9 = com.cupidapp.live.match.view.MBTIEntranceLayout.this
                    com.cupidapp.live.base.sensorslog.SensorPosition r9 = com.cupidapp.live.match.view.MBTIEntranceLayout.g(r9)
                    r0 = 1
                    r1 = 0
                    if (r9 == 0) goto L1c
                    java.lang.String r9 = r9.getValue()
                    if (r9 == 0) goto L1c
                    int r9 = r9.length()
                    if (r9 <= 0) goto L18
                    r9 = 1
                    goto L19
                L18:
                    r9 = 0
                L19:
                    if (r9 != r0) goto L1c
                    goto L1d
                L1c:
                    r0 = 0
                L1d:
                    r9 = 0
                    if (r0 == 0) goto L4b
                    p1.g r0 = p1.g.f52734a
                    com.cupidapp.live.base.network.model.ConstantsResult r0 = r0.q()
                    if (r0 == 0) goto L5d
                    com.cupidapp.live.base.network.model.ConstantsUrlModel r0 = r0.getUrlModel()
                    if (r0 == 0) goto L5d
                    java.lang.String r0 = r0.getMbtiTestUrl()
                    if (r0 == 0) goto L5d
                    com.cupidapp.live.match.view.MBTIEntranceLayout r9 = com.cupidapp.live.match.view.MBTIEntranceLayout.this
                    com.cupidapp.live.base.sensorslog.SensorPosition r9 = com.cupidapp.live.match.view.MBTIEntranceLayout.g(r9)
                    if (r9 == 0) goto L42
                    java.lang.String r9 = r9.getValue()
                    if (r9 != 0) goto L44
                L42:
                    java.lang.String r9 = ""
                L44:
                    java.lang.String r2 = "from"
                    java.lang.String r9 = z0.x.a(r0, r2, r9)
                    goto L5d
                L4b:
                    p1.g r0 = p1.g.f52734a
                    com.cupidapp.live.base.network.model.ConstantsResult r0 = r0.q()
                    if (r0 == 0) goto L5d
                    com.cupidapp.live.base.network.model.ConstantsUrlModel r0 = r0.getUrlModel()
                    if (r0 == 0) goto L5d
                    java.lang.String r9 = r0.getMbtiTestUrl()
                L5d:
                    r4 = r9
                    com.cupidapp.live.base.router.j$a r2 = com.cupidapp.live.base.router.j.f12156c
                    com.cupidapp.live.match.view.MBTIEntranceLayout r9 = com.cupidapp.live.match.view.MBTIEntranceLayout.this
                    android.content.Context r3 = r9.getContext()
                    r5 = 0
                    r6 = 4
                    r7 = 0
                    com.cupidapp.live.base.router.j.a.b(r2, r3, r4, r5, r6, r7)
                    p1.g r9 = p1.g.f52734a
                    java.lang.Boolean r0 = java.lang.Boolean.FALSE
                    r9.O2(r0)
                    com.cupidapp.live.match.view.MBTIEntranceLayout r9 = com.cupidapp.live.match.view.MBTIEntranceLayout.this
                    r0 = 8
                    r9.setVisibility(r0)
                    com.cupidapp.live.match.view.MBTIEntranceLayout r9 = com.cupidapp.live.match.view.MBTIEntranceLayout.this
                    com.cupidapp.live.match.view.MBTIEntranceLayout$a r9 = com.cupidapp.live.match.view.MBTIEntranceLayout.f(r9)
                    if (r9 == 0) goto L85
                    r9.a(r1)
                L85:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.match.view.MBTIEntranceLayout$initView$2.invoke2(android.view.View):void");
            }
        });
    }

    public final void setPosition(@NotNull SensorPosition position) {
        kotlin.jvm.internal.s.i(position, "position");
        this.f16950e = position;
    }

    public final void setVisibilityListener(@NotNull a listener) {
        kotlin.jvm.internal.s.i(listener, "listener");
        this.f16949d = listener;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MBTIEntranceLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.s.i(context, "context");
        this.f16951f = new LinkedHashMap();
        i();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MBTIEntranceLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.s.i(context, "context");
        this.f16951f = new LinkedHashMap();
        i();
    }
}

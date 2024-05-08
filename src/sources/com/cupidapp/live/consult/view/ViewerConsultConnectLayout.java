package com.cupidapp.live.consult.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.cupidapp.live.R$drawable;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.view.h;
import com.cupidapp.live.consult.model.ConsultConnectState;
import com.cupidapp.live.consult.view.ViewerConsultConnectLayout;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.u;
import z0.y;
import z0.z;

/* compiled from: ViewerConsultConnectLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ViewerConsultConnectLayout extends FrameLayout {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final a f13884d = new a(null);

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public static ConsultConnectState f13885e = ConsultConnectState.FreeState;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public e f13886b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f13887c;

    /* compiled from: ViewerConsultConnectLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ConsultConnectState a() {
            return ViewerConsultConnectLayout.f13885e;
        }

        public final boolean b() {
            return a() == ConsultConnectState.Answering || a() == ConsultConnectState.Connecting;
        }
    }

    /* compiled from: ViewerConsultConnectLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f13888a;

        static {
            int[] iArr = new int[ConsultConnectState.values().length];
            try {
                iArr[ConsultConnectState.FreeState.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ConsultConnectState.WaitConnect.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ConsultConnectState.Answering.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ConsultConnectState.Connecting.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f13888a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewerConsultConnectLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f13887c = new LinkedHashMap();
        f();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f13887c;
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

    public final void d(@NotNull ConsultConnectState connectState) {
        s.i(connectState, "connectState");
        f13885e = connectState;
        int i10 = b.f13888a[connectState.ordinal()];
        if (i10 == 1) {
            ((ImageView) a(R$id.connect_mic_img)).setImageResource(R$mipmap.icon_consult_connect_mic);
            ((TextView) a(R$id.request_connect_txt)).setVisibility(0);
            ((TextView) a(R$id.hangup_txt)).setVisibility(8);
            ((TextView) a(R$id.wait_connect_txt)).setVisibility(8);
            return;
        }
        if (i10 == 2 || i10 == 3) {
            ((ImageView) a(R$id.connect_mic_img)).setImageResource(R$mipmap.icon_consult_wait_connect);
            ((TextView) a(R$id.request_connect_txt)).setVisibility(8);
            ((TextView) a(R$id.hangup_txt)).setVisibility(8);
            ((TextView) a(R$id.wait_connect_txt)).setVisibility(0);
            return;
        }
        if (i10 != 4) {
            return;
        }
        ((ImageView) a(R$id.connect_mic_img)).setImageResource(R$mipmap.icon_consult_connecting);
        ((TextView) a(R$id.request_connect_txt)).setVisibility(8);
        ((TextView) a(R$id.hangup_txt)).setVisibility(0);
        ((TextView) a(R$id.wait_connect_txt)).setVisibility(8);
    }

    public final void e(int i10) {
        if (i10 > 0) {
            ((LinearLayout) a(R$id.lining_layout)).setVisibility(0);
            ((TextView) a(R$id.lining_txt)).setText(getContext().getString(R$string.lining_count, Integer.valueOf(i10)));
            ((ConstraintLayout) a(R$id.connect_layout)).setBackgroundResource(R$drawable.rect_btm_cor_12_sd_40000000);
        } else {
            ((LinearLayout) a(R$id.lining_layout)).setVisibility(8);
            ((ConstraintLayout) a(R$id.connect_layout)).setBackgroundResource(R$drawable.rect_cor_12_sd_40000000);
        }
    }

    public final void f() {
        z.a(this, R$layout.layout_viewer_consult_connect, true);
        f13885e = ConsultConnectState.FreeState;
        int i10 = R$id.request_connect_txt;
        TextView request_connect_txt = (TextView) a(i10);
        s.h(request_connect_txt, "request_connect_txt");
        u.a(request_connect_txt);
        int i11 = R$id.hangup_txt;
        TextView hangup_txt = (TextView) a(i11);
        s.h(hangup_txt, "hangup_txt");
        u.a(hangup_txt);
        LinearLayout lining_layout = (LinearLayout) a(R$id.lining_layout);
        s.h(lining_layout, "lining_layout");
        y.d(lining_layout, new Function1<View, p>() { // from class: com.cupidapp.live.consult.view.ViewerConsultConnectLayout$initView$1
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
                e eVar;
                ViewerConsultConnectLayout.a aVar = ViewerConsultConnectLayout.f13884d;
                if (aVar.a() == ConsultConnectState.Connecting) {
                    h.f12779a.k(R$string.connecting_wheat);
                    return;
                }
                eVar = ViewerConsultConnectLayout.this.f13886b;
                if (eVar != null) {
                    eVar.c(aVar.a());
                }
            }
        });
        TextView request_connect_txt2 = (TextView) a(i10);
        s.h(request_connect_txt2, "request_connect_txt");
        y.d(request_connect_txt2, new Function1<View, p>() { // from class: com.cupidapp.live.consult.view.ViewerConsultConnectLayout$initView$2
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
                e eVar;
                eVar = ViewerConsultConnectLayout.this.f13886b;
                if (eVar != null) {
                    eVar.a();
                }
            }
        });
        TextView hangup_txt2 = (TextView) a(i11);
        s.h(hangup_txt2, "hangup_txt");
        y.d(hangup_txt2, new Function1<View, p>() { // from class: com.cupidapp.live.consult.view.ViewerConsultConnectLayout$initView$3
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
                e eVar;
                eVar = ViewerConsultConnectLayout.this.f13886b;
                if (eVar != null) {
                    eVar.b();
                }
            }
        });
    }

    public final void setListener(@NotNull e listener) {
        s.i(listener, "listener");
        this.f13886b = listener;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewerConsultConnectLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f13887c = new LinkedHashMap();
        f();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewerConsultConnectLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f13887c = new LinkedHashMap();
        f();
    }
}

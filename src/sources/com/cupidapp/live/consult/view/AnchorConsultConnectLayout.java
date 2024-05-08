package com.cupidapp.live.consult.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.cupidapp.live.R$drawable;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.imageloader.BlurModel;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.utils.h;
import com.cupidapp.live.consult.model.ConsultConnectState;
import com.cupidapp.live.consult.model.ConsultConnectType;
import com.cupidapp.live.profile.model.User;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.u;
import z0.y;
import z0.z;

/* compiled from: AnchorConsultConnectLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class AnchorConsultConnectLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public com.cupidapp.live.consult.view.a f13829b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public ConsultConnectState f13830c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f13831d;

    /* compiled from: AnchorConsultConnectLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f13832a;

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
            f13832a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnchorConsultConnectLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f13831d = new LinkedHashMap();
        this.f13830c = ConsultConnectState.FreeState;
        h();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f13831d;
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
        this.f13830c = connectState;
        int i10 = a.f13832a[connectState.ordinal()];
        if (i10 == 1) {
            ((LinearLayout) a(R$id.free_layout)).setVisibility(0);
            ((LinearLayout) a(R$id.connect_state_layout)).setVisibility(8);
            return;
        }
        if (i10 == 2) {
            ((LinearLayout) a(R$id.free_layout)).setVisibility(8);
            ((LinearLayout) a(R$id.connect_state_layout)).setVisibility(0);
            ((TextView) a(R$id.answer_txt)).setVisibility(0);
            f(connectState);
            return;
        }
        if (i10 == 3) {
            ((LinearLayout) a(R$id.free_layout)).setVisibility(8);
            ((LinearLayout) a(R$id.connect_state_layout)).setVisibility(0);
            ((TextView) a(R$id.answer_txt)).setVisibility(8);
            f(connectState);
            return;
        }
        if (i10 != 4) {
            return;
        }
        ((LinearLayout) a(R$id.free_layout)).setVisibility(8);
        ((LinearLayout) a(R$id.connect_state_layout)).setVisibility(0);
        ((TextView) a(R$id.answer_txt)).setVisibility(8);
        f(connectState);
    }

    public final void e(@NotNull User user, @NotNull String connectType) {
        s.i(user, "user");
        s.i(connectType, "connectType");
        if (s.d(connectType, ConsultConnectType.NORMAL.getValue())) {
            ImageLoaderView connect_user_avatar_img = (ImageLoaderView) a(R$id.connect_user_avatar_img);
            s.h(connect_user_avatar_img, "connect_user_avatar_img");
            ImageLoaderView.g(connect_user_avatar_img, user.getAvatarImage(), new com.cupidapp.live.base.imageloader.b(false, null, null, null, null, null, null, 0, 0, null, null, null, new BlurModel(9.0f, 0, 2, null), false, 0, 0, false, null, null, 520191, null), null, 4, null);
        } else if (s.d(connectType, ConsultConnectType.ONE_ON_ONE.getValue())) {
            ImageLoaderView connect_user_avatar_img2 = (ImageLoaderView) a(R$id.connect_user_avatar_img);
            s.h(connect_user_avatar_img2, "connect_user_avatar_img");
            ImageLoaderView.f(connect_user_avatar_img2, new com.cupidapp.live.base.imageloader.b(false, null, null, null, Integer.valueOf(R$mipmap.ic_consult_connect_anonymous_avatar), null, null, 0, 0, null, null, null, null, false, 0, 0, false, null, null, 524271, null), null, 2, null);
        }
    }

    public final void f(ConsultConnectState consultConnectState) {
        if (consultConnectState == ConsultConnectState.Answering) {
            int i10 = R$id.hangup_txt;
            ((TextView) a(i10)).setTextColor(h.a(-1, 0.5f));
            ((TextView) a(i10)).setText(getContext().getString(R$string.answering));
        } else {
            int i11 = R$id.hangup_txt;
            ((TextView) a(i11)).setTextColor(-44205);
            ((TextView) a(i11)).setText(getContext().getString(R$string.hang_up));
        }
    }

    public final void g(int i10) {
        if (i10 > 0) {
            ((LinearLayout) a(R$id.lining_layout)).setVisibility(0);
            ((TextView) a(R$id.lining_txt)).setText(getContext().getString(R$string.lining_count, Integer.valueOf(i10)));
            ((ConstraintLayout) a(R$id.connect_layout)).setBackgroundResource(R$drawable.rect_btm_cor_12_sd_40000000);
        } else {
            ((LinearLayout) a(R$id.lining_layout)).setVisibility(8);
            ((ConstraintLayout) a(R$id.connect_layout)).setBackgroundResource(R$drawable.rect_cor_12_sd_40000000);
        }
    }

    public final void h() {
        z.a(this, R$layout.layout_anchor_consult_connect, true);
        int i10 = R$id.answer_txt;
        TextView answer_txt = (TextView) a(i10);
        s.h(answer_txt, "answer_txt");
        u.a(answer_txt);
        int i11 = R$id.hangup_txt;
        TextView hangup_txt = (TextView) a(i11);
        s.h(hangup_txt, "hangup_txt");
        u.a(hangup_txt);
        LinearLayout lining_layout = (LinearLayout) a(R$id.lining_layout);
        s.h(lining_layout, "lining_layout");
        y.d(lining_layout, new Function1<View, p>() { // from class: com.cupidapp.live.consult.view.AnchorConsultConnectLayout$initView$1
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
                aVar = AnchorConsultConnectLayout.this.f13829b;
                if (aVar != null) {
                    aVar.c();
                }
            }
        });
        TextView answer_txt2 = (TextView) a(i10);
        s.h(answer_txt2, "answer_txt");
        y.d(answer_txt2, new Function1<View, p>() { // from class: com.cupidapp.live.consult.view.AnchorConsultConnectLayout$initView$2
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
                aVar = AnchorConsultConnectLayout.this.f13829b;
                if (aVar != null) {
                    aVar.d();
                }
            }
        });
        TextView hangup_txt2 = (TextView) a(i11);
        s.h(hangup_txt2, "hangup_txt");
        y.d(hangup_txt2, new Function1<View, p>() { // from class: com.cupidapp.live.consult.view.AnchorConsultConnectLayout$initView$3

            /* compiled from: AnchorConsultConnectLayout.kt */
            @kotlin.d
            /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
            public /* synthetic */ class a {

                /* renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f13833a;

                static {
                    int[] iArr = new int[ConsultConnectState.values().length];
                    try {
                        iArr[ConsultConnectState.WaitConnect.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[ConsultConnectState.Connecting.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    f13833a = iArr;
                }
            }

            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(View view) {
                invoke2(view);
                return p.f51048a;
            }

            /* JADX WARN: Code restructure failed: missing block: B:5:0x0015, code lost:
            
                r2 = r1.this$0.f13829b;
             */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void invoke2(@org.jetbrains.annotations.Nullable android.view.View r2) {
                /*
                    r1 = this;
                    com.cupidapp.live.consult.view.AnchorConsultConnectLayout r2 = com.cupidapp.live.consult.view.AnchorConsultConnectLayout.this
                    com.cupidapp.live.consult.model.ConsultConnectState r2 = com.cupidapp.live.consult.view.AnchorConsultConnectLayout.b(r2)
                    int[] r0 = com.cupidapp.live.consult.view.AnchorConsultConnectLayout$initView$3.a.f13833a
                    int r2 = r2.ordinal()
                    r2 = r0[r2]
                    r0 = 1
                    if (r2 == r0) goto L21
                    r0 = 2
                    if (r2 == r0) goto L15
                    goto L2c
                L15:
                    com.cupidapp.live.consult.view.AnchorConsultConnectLayout r2 = com.cupidapp.live.consult.view.AnchorConsultConnectLayout.this
                    com.cupidapp.live.consult.view.a r2 = com.cupidapp.live.consult.view.AnchorConsultConnectLayout.c(r2)
                    if (r2 == 0) goto L2c
                    r2.b()
                    goto L2c
                L21:
                    com.cupidapp.live.consult.view.AnchorConsultConnectLayout r2 = com.cupidapp.live.consult.view.AnchorConsultConnectLayout.this
                    com.cupidapp.live.consult.view.a r2 = com.cupidapp.live.consult.view.AnchorConsultConnectLayout.c(r2)
                    if (r2 == 0) goto L2c
                    r2.e()
                L2c:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.consult.view.AnchorConsultConnectLayout$initView$3.invoke2(android.view.View):void");
            }
        });
    }

    public final void setListener(@NotNull com.cupidapp.live.consult.view.a listener) {
        s.i(listener, "listener");
        this.f13829b = listener;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnchorConsultConnectLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f13831d = new LinkedHashMap();
        this.f13830c = ConsultConnectState.FreeState;
        h();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnchorConsultConnectLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f13831d = new LinkedHashMap();
        this.f13830c = ConsultConnectState.FreeState;
        h();
    }
}

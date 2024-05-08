package com.cupidapp.live.base.view.dialog;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.os.CountDownTimer;
import android.util.Property;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import com.cupidapp.live.R$drawable;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.view.bubble.GradientBubbleView;
import com.cupidapp.live.base.view.bubble.GuideBubbleArrowPos;
import com.cupidapp.live.track.group.GroupOthersLog;
import com.irisdt.client.others.OthersProtos;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;

/* compiled from: FKPointerDialog.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKPointerDialog {

    /* renamed from: p */
    @NotNull
    public static final a f12718p = new a(null);

    /* renamed from: a */
    @NotNull
    public final Context f12719a;

    /* renamed from: b */
    @Nullable
    public CountDownTimer f12720b;

    /* renamed from: c */
    @NotNull
    public PointerPos f12721c;

    /* renamed from: d */
    @NotNull
    public BgColor f12722d;

    /* renamed from: e */
    @Nullable
    public View f12723e;

    /* renamed from: f */
    @Nullable
    public Float f12724f;

    /* renamed from: g */
    public boolean f12725g;

    /* renamed from: h */
    @Nullable
    public TextView f12726h;

    /* renamed from: i */
    @Nullable
    public AlertDialog f12727i;

    /* renamed from: j */
    @Nullable
    public AnimatorSet f12728j;

    /* renamed from: k */
    @Nullable
    public String f12729k;

    /* renamed from: l */
    @Nullable
    public OthersProtos.Enum_type f12730l;

    /* renamed from: m */
    public boolean f12731m;

    /* renamed from: n */
    @NotNull
    public BgType f12732n;

    /* renamed from: o */
    @ColorInt
    @NotNull
    public final List<Integer> f12733o;

    /* compiled from: FKPointerDialog.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FKPointerDialog a(@NotNull Context context) {
            s.i(context, "context");
            return new FKPointerDialog(context);
        }
    }

    /* compiled from: FKPointerDialog.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public /* synthetic */ class b {

        /* renamed from: a */
        public static final /* synthetic */ int[] f12734a;

        static {
            int[] iArr = new int[PointerPos.values().length];
            try {
                iArr[PointerPos.TOP_CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PointerPos.BOTTOM_CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PointerPos.TOP_LEFT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[PointerPos.TOP_RIGHT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[PointerPos.BOTTOM_LEFT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[PointerPos.BOTTOM_RIGHT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            f12734a = iArr;
        }
    }

    /* compiled from: FKPointerDialog.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class c extends CountDownTimer {
        public c(long j10, long j11) {
            super(j10, j11);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            FKPointerDialog.this.g(false);
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j10) {
        }
    }

    public FKPointerDialog(@NotNull Context context) {
        s.i(context, "context");
        this.f12719a = context;
        i();
        this.f12721c = PointerPos.BOTTOM_CENTER;
        this.f12722d = BgColor.DEFAULT;
        this.f12732n = BgType.NORMAL;
        this.f12733o = kotlin.collections.s.o(-33244, -49088);
    }

    public static /* synthetic */ void B(FKPointerDialog fKPointerDialog, View view, int i10, int i11, int i12, Integer num, int i13, Object obj) {
        int i14 = (i13 & 2) != 0 ? 0 : i10;
        int i15 = (i13 & 4) != 0 ? 0 : i11;
        int i16 = (i13 & 8) != 0 ? 5 : i12;
        if ((i13 & 16) != 0) {
            num = null;
        }
        fKPointerDialog.A(view, i14, i15, i16, num);
    }

    public static final void C(View view, FKPointerDialog this$0, int i10, int i11, int i12, Integer num) {
        s.i(this$0, "this$0");
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        int[] h10 = this$0.h();
        this$0.s(((iArr[0] + (view.getWidth() / 2)) - (z0.h.l(this$0) / 2)) + i10, view.getTop() + view.getHeight() + i11, Integer.valueOf((h10 != null ? h10[0] : z0.h.c(this$0, 70.0f)) + z0.h.c(this$0, 30.0f)), 49, i12, num);
    }

    public static /* synthetic */ void E(FKPointerDialog fKPointerDialog, View view, int i10, int i11, int i12, Integer num, int i13, Object obj) {
        int i14 = (i13 & 2) != 0 ? 0 : i10;
        int i15 = (i13 & 4) != 0 ? 0 : i11;
        int i16 = (i13 & 8) != 0 ? 5 : i12;
        if ((i13 & 16) != 0) {
            num = null;
        }
        fKPointerDialog.D(view, i14, i15, i16, num);
    }

    public static final void F(View view, FKPointerDialog this$0, int i10, int i11, int i12, Integer num) {
        s.i(this$0, "this$0");
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        int[] h10 = this$0.h();
        this$0.s(((iArr[0] + (view.getWidth() / 2)) - (z0.h.l(this$0) / 2)) + i10, view.getHeight() + i11, Integer.valueOf((h10 != null ? h10[0] : z0.h.c(this$0, 70.0f)) + z0.h.c(this$0, 30.0f)), 81, i12, num);
    }

    public static /* synthetic */ void t(FKPointerDialog fKPointerDialog, int i10, int i11, Integer num, int i12, int i13, Integer num2, int i14, Object obj) {
        fKPointerDialog.s(i10, i11, (i14 & 4) != 0 ? null : num, (i14 & 8) != 0 ? 8388611 : i12, (i14 & 16) != 0 ? 5 : i13, (i14 & 32) != 0 ? null : num2);
    }

    public static final void u(FKPointerDialog this$0, int i10, DialogInterface dialogInterface) {
        s.i(this$0, "this$0");
        if (this$0.f12731m) {
            this$0.w();
        } else {
            TextView textView = this$0.f12726h;
            if (textView != null) {
                textView.setVisibility(0);
            }
        }
        if (i10 > 0) {
            if (this$0.f12720b == null) {
                long j10 = i10 * 1000;
                this$0.f12720b = new c(j10, j10);
            }
            CountDownTimer countDownTimer = this$0.f12720b;
            if (countDownTimer != null) {
                countDownTimer.start();
            }
        }
    }

    public static final boolean v(FKPointerDialog this$0, View view, MotionEvent motionEvent) {
        s.i(this$0, "this$0");
        view.performClick();
        AlertDialog alertDialog = this$0.f12727i;
        if (alertDialog == null) {
            return false;
        }
        alertDialog.dismiss();
        return false;
    }

    public static /* synthetic */ void y(FKPointerDialog fKPointerDialog, View view, int i10, int i11, int i12, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            i10 = 0;
        }
        if ((i13 & 4) != 0) {
            i11 = 0;
        }
        if ((i13 & 8) != 0) {
            i12 = 5;
        }
        fKPointerDialog.x(view, i10, i11, i12);
    }

    public static final void z(View view, FKPointerDialog this$0, int i10, int i11, int i12) {
        s.i(this$0, "this$0");
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int width = ((iArr[0] + (view.getWidth() / 2)) - (z0.h.l(this$0) / 2)) + i10;
        int height = ((iArr[1] + view.getHeight()) - z0.h.m(this$0.f12719a)) + i11;
        int[] h10 = this$0.h();
        t(this$0, width, height, Integer.valueOf((h10 != null ? h10[0] : z0.h.c(this$0, 70.0f)) + z0.h.c(this$0, 30.0f)), 49, i12, null, 32, null);
    }

    public final void A(@Nullable final View view, final int i10, final int i11, final int i12, @Nullable final Integer num) {
        if (view != null) {
            view.post(new Runnable() { // from class: com.cupidapp.live.base.view.dialog.m
                @Override // java.lang.Runnable
                public final void run() {
                    FKPointerDialog.C(View.this, this, i10, i11, i12, num);
                }
            });
        }
    }

    public final void D(@Nullable final View view, final int i10, final int i11, final int i12, @Nullable final Integer num) {
        if (view != null) {
            view.post(new Runnable() { // from class: com.cupidapp.live.base.view.dialog.n
                @Override // java.lang.Runnable
                public final void run() {
                    FKPointerDialog.F(View.this, this, i10, i11, i12, num);
                }
            });
        }
    }

    @NotNull
    public final FKPointerDialog f(boolean z10) {
        this.f12731m = z10;
        return this;
    }

    public final void g(boolean z10) {
        OthersProtos.Enum_type enum_type;
        try {
            if (this.f12727i != null) {
                if (z10 && this.f12729k != null && (enum_type = this.f12730l) != null) {
                    GroupOthersLog groupOthersLog = GroupOthersLog.f18702a;
                    s.f(enum_type);
                    GroupOthersLog.p(groupOthersLog, enum_type, this.f12729k, null, 4, null);
                }
                CountDownTimer countDownTimer = this.f12720b;
                if (countDownTimer != null) {
                    countDownTimer.cancel();
                }
                AnimatorSet animatorSet = this.f12728j;
                if (animatorSet != null) {
                    animatorSet.cancel();
                }
                AlertDialog alertDialog = this.f12727i;
                boolean z11 = true;
                if (alertDialog == null || !alertDialog.isShowing()) {
                    z11 = false;
                }
                if (z11) {
                    AlertDialog alertDialog2 = this.f12727i;
                    if (alertDialog2 != null) {
                        alertDialog2.dismiss();
                    }
                    this.f12727i = null;
                }
                this.f12727i = null;
            }
        } catch (Exception unused) {
        } catch (Throwable th) {
            this.f12727i = null;
            throw th;
        }
        this.f12727i = null;
    }

    @Nullable
    public final int[] h() {
        TextView textView = this.f12726h;
        if (textView != null) {
            return y.b(textView);
        }
        return null;
    }

    public final void i() {
        View inflate = LayoutInflater.from(this.f12719a).inflate(R$layout.dialog_guide_pointer, (ViewGroup) null, false);
        this.f12723e = inflate;
        this.f12726h = inflate != null ? (TextView) inflate.findViewById(R$id.guide_txt) : null;
    }

    @NotNull
    public final FKPointerDialog j(@Nullable Float f10) {
        this.f12724f = f10;
        return this;
    }

    @NotNull
    public final FKPointerDialog k(@ColorInt @NotNull List<Integer> colors) {
        s.i(colors, "colors");
        this.f12733o.clear();
        this.f12733o.addAll(colors);
        return this;
    }

    @NotNull
    public final FKPointerDialog l(@NotNull BgType bgType) {
        s.i(bgType, "bgType");
        this.f12732n = bgType;
        return this;
    }

    @NotNull
    public final FKPointerDialog m(boolean z10) {
        this.f12725g = z10;
        return this;
    }

    @NotNull
    public final FKPointerDialog n(@NotNull CharSequence content) {
        s.i(content, "content");
        TextView textView = this.f12726h;
        if (textView != null) {
            textView.setText(content);
        }
        return this;
    }

    @NotNull
    public final FKPointerDialog o(int i10) {
        TextView textView = this.f12726h;
        if (textView != null) {
            textView.setGravity(i10);
        }
        return this;
    }

    @NotNull
    public final FKPointerDialog p(@Nullable final Function0<p> function0, final boolean z10) {
        View view = this.f12723e;
        if (view != null) {
            y.d(view, new Function1<View, p>() { // from class: com.cupidapp.live.base.view.dialog.FKPointerDialog$setContentViewClick$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(View view2) {
                    invoke2(view2);
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable View view2) {
                    Function0<p> function02 = function0;
                    if (function02 != null) {
                        function02.invoke();
                    }
                    if (z10) {
                        this.g(true);
                    }
                }
            });
        }
        return this;
    }

    @NotNull
    public final FKPointerDialog q(@NotNull PointerPos pos, @NotNull BgColor color) {
        s.i(pos, "pos");
        s.i(color, "color");
        this.f12721c = pos;
        this.f12722d = color;
        return this;
    }

    @NotNull
    public final FKPointerDialog r(@NotNull OthersProtos.Enum_type enumType, @Nullable String str) {
        s.i(enumType, "enumType");
        this.f12730l = enumType;
        this.f12729k = str;
        return this;
    }

    public final void s(int i10, int i11, @Nullable Integer num, int i12, final int i13, @Nullable Integer num2) {
        GuideBubbleArrowPos guideBubbleArrowPos;
        int i14;
        int c4;
        AlertDialog g3;
        AlertDialog alertDialog;
        Window window;
        View decorView;
        OthersProtos.Enum_type enum_type;
        View view = this.f12723e;
        GradientBubbleView gradientBubbleView = view != null ? (GradientBubbleView) view.findViewById(R$id.gradient_bubble_view) : null;
        PointerPos pointerPos = this.f12721c;
        int[] iArr = b.f12734a;
        int i15 = iArr[pointerPos.ordinal()];
        if (i15 != 1) {
            guideBubbleArrowPos = i15 != 2 ? null : GuideBubbleArrowPos.BOTTOM_CENTER;
        } else {
            guideBubbleArrowPos = GuideBubbleArrowPos.TOP_CENTER;
        }
        if (this.f12732n == BgType.GRADIENT && guideBubbleArrowPos != null) {
            this.f12722d = BgColor.TRANSPARENT;
            if (gradientBubbleView != null) {
                gradientBubbleView.setVisibility(0);
            }
            if (gradientBubbleView != null) {
                gradientBubbleView.a(guideBubbleArrowPos, z0.h.c(this, 6.0f), this.f12733o);
            }
        } else if (gradientBubbleView != null) {
            gradientBubbleView.setVisibility(8);
        }
        switch (iArr[this.f12721c.ordinal()]) {
            case 1:
                i14 = R$drawable.bg_black_up;
                break;
            case 2:
                i14 = R$drawable.bg_black_down;
                break;
            case 3:
                i14 = R$drawable.bg_black_left_up;
                break;
            case 4:
                i14 = R$drawable.bg_black_right_up;
                break;
            case 5:
                i14 = R$drawable.bg_black_left_down;
                break;
            case 6:
                i14 = R$drawable.bg_black_right_down;
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        TextView textView = this.f12726h;
        if (textView != null) {
            textView.setBackgroundResource(i14);
        }
        TextView textView2 = this.f12726h;
        if (textView2 != null) {
            textView2.setBackgroundTintMode(PorterDuff.Mode.SRC_IN);
        }
        TextView textView3 = this.f12726h;
        if (textView3 != null) {
            ColorStateList valueOf = ColorStateList.valueOf(ContextCompat.getColor(this.f12719a, this.f12722d.getValue()));
            s.h(valueOf, "valueOf(\n               …olor.value)\n            )");
            ViewCompat.setBackgroundTintList(textView3, valueOf);
        }
        Integer num3 = this.f12725g ? 40 : null;
        if (num != null) {
            c4 = num.intValue();
        } else {
            int[] h10 = h();
            c4 = h10 != null ? h10[0] : z0.h.c(this, 100.0f);
        }
        int i16 = c4;
        View view2 = this.f12723e;
        if (view2 != null) {
            g3 = z0.b.f54812a.g(this.f12719a, view2, i10, i11, i16, -2, (r32 & 64) != 0 ? 17 : i12, (r32 & 128) != 0 ? null : this.f12724f, (r32 & 256) != 0 ? null : null, (r32 & 512) != 0 ? null : 0, (r32 & 1024) != 0 ? null : num3, (r32 & 2048) != 0 ? null : num2, (r32 & 4096) != 0 ? null : new DialogInterface.OnShowListener() { // from class: com.cupidapp.live.base.view.dialog.j
                @Override // android.content.DialogInterface.OnShowListener
                public final void onShow(DialogInterface dialogInterface) {
                    FKPointerDialog.u(FKPointerDialog.this, i13, dialogInterface);
                }
            }, (r32 & 8192) != 0 ? null : null);
            this.f12727i = g3;
            if (this.f12729k != null && (enum_type = this.f12730l) != null) {
                GroupOthersLog groupOthersLog = GroupOthersLog.f18702a;
                s.f(enum_type);
                groupOthersLog.q(enum_type, this.f12729k);
            }
            if (this.f12725g || (alertDialog = this.f12727i) == null || (window = alertDialog.getWindow()) == null || (decorView = window.getDecorView()) == null) {
                return;
            }
            decorView.setOnTouchListener(new View.OnTouchListener() { // from class: com.cupidapp.live.base.view.dialog.k
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view3, MotionEvent motionEvent) {
                    boolean v2;
                    v2 = FKPointerDialog.v(FKPointerDialog.this, view3, motionEvent);
                    return v2;
                }
            });
        }
    }

    public final void w() {
        TextView textView = this.f12726h;
        if (textView != null) {
            textView.setPivotY(textView != null ? textView.getHeight() : 0.0f);
        }
        TextView textView2 = this.f12726h;
        if (textView2 != null) {
            textView2.setPivotX((textView2 != null ? textView2.getWidth() : 0.0f) / 2.0f);
        }
        TextView textView3 = this.f12726h;
        if (textView3 != null) {
            textView3.setAlpha(0.0f);
        }
        TextView textView4 = this.f12726h;
        if (textView4 != null) {
            textView4.setVisibility(0);
        }
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f12726h, (Property<TextView, Float>) View.ALPHA, 0.0f, 1.0f);
        ofFloat.setInterpolator(new AccelerateInterpolator());
        ofFloat.setDuration(200L);
        AnimatorSet.Builder play = animatorSet.play(ofFloat);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f12726h, (Property<TextView, Float>) View.SCALE_X, 0.0f, 0.9f, 1.0f);
        ofFloat2.setInterpolator(new BounceInterpolator());
        ofFloat2.setDuration(1000L);
        play.with(ofFloat2);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.f12726h, (Property<TextView, Float>) View.SCALE_Y, 0.0f, 0.9f, 1.0f);
        ofFloat3.setInterpolator(new BounceInterpolator());
        ofFloat3.setDuration(1000L);
        play.with(ofFloat3);
        animatorSet.start();
        this.f12728j = animatorSet;
    }

    public final void x(@Nullable final View view, final int i10, final int i11, final int i12) {
        if (view != null) {
            view.post(new Runnable() { // from class: com.cupidapp.live.base.view.dialog.l
                @Override // java.lang.Runnable
                public final void run() {
                    FKPointerDialog.z(View.this, this, i10, i11, i12);
                }
            });
        }
    }
}

package com.cupidapp.live.push.util;

import android.app.Activity;
import android.os.CountDownTimer;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import com.cupidapp.live.AppApplication;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$style;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.base.view.button.FKUniversalButton;
import com.cupidapp.live.liveshow.model.GuideInfoModel;
import com.cupidapp.live.track.group.GroupOthersLog;
import java.lang.ref.WeakReference;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$LongRef;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;
import z0.y;

/* compiled from: AppTopTipPopup.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class AppTopTipPopup {

    /* renamed from: b, reason: collision with root package name */
    public static float f17897b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public static WindowManager f17898c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public static GuideInfoModel f17899d;

    /* renamed from: e, reason: collision with root package name */
    public static boolean f17900e;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    public static CountDownTimer f17902g;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final AppTopTipPopup f17896a = new AppTopTipPopup();

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public static final Lazy f17901f = kotlin.c.b(new Function0<View>() { // from class: com.cupidapp.live.push.util.AppTopTipPopup$cardView$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final View invoke() {
            return View.inflate(AppApplication.f11612d.c(), R$layout.pop_top_tip, null);
        }
    });

    /* compiled from: AppTopTipPopup.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a extends CountDownTimer {
        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public a(kotlin.jvm.internal.Ref$LongRef r3) {
            /*
                r2 = this;
                long r0 = r3.element
                r2.<init>(r0, r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.push.util.AppTopTipPopup.a.<init>(kotlin.jvm.internal.Ref$LongRef):void");
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            AppTopTipPopup.f17896a.c();
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j10) {
        }
    }

    public static final boolean e(View view, MotionEvent motionEvent) {
        view.performClick();
        int action = motionEvent.getAction();
        if (action == 0) {
            f17897b = motionEvent.getRawY();
            return true;
        }
        if (action != 2) {
            return true;
        }
        float rawY = f17897b - motionEvent.getRawY();
        AppTopTipPopup appTopTipPopup = f17896a;
        if (rawY <= h.c(appTopTipPopup, 20.0f)) {
            return true;
        }
        appTopTipPopup.c();
        return true;
    }

    public final boolean b(Activity activity) {
        return (activity instanceof FKBaseActivity) && ((FKBaseActivity) activity).H0();
    }

    public final void c() {
        f17899d = null;
        f17900e = true;
        CountDownTimer countDownTimer = f17902g;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        f17902g = null;
        try {
            WindowManager windowManager = f17898c;
            if (windowManager != null) {
                windowManager.removeViewImmediate(f());
            }
        } catch (Exception unused) {
        }
    }

    public final void d(final GuideInfoModel guideInfoModel, View view) {
        ImageLoaderView imageLoaderView = (ImageLoaderView) view.findViewById(R$id.top_tip_icon);
        if (imageLoaderView != null) {
            ImageLoaderView.g(imageLoaderView, guideInfoModel.getIconImage(), null, null, 6, null);
        }
        TextView textView = (TextView) view.findViewById(R$id.top_tip_title);
        if (textView != null) {
            textView.setText(guideInfoModel.getTitle());
        }
        TextView textView2 = (TextView) view.findViewById(R$id.top_tip_msg);
        boolean z10 = true;
        if (textView2 != null) {
            String message = guideInfoModel.getMessage();
            if (message == null || message.length() == 0) {
                textView2.setVisibility(8);
            } else {
                textView2.setText(guideInfoModel.getMessage());
                textView2.setVisibility(0);
            }
        }
        FKUniversalButton fKUniversalButton = (FKUniversalButton) view.findViewById(R$id.top_tip_btn);
        if (fKUniversalButton != null) {
            String buttonName = guideInfoModel.getButtonName();
            if (buttonName != null && buttonName.length() != 0) {
                z10 = false;
            }
            if (z10) {
                fKUniversalButton.setVisibility(8);
            } else {
                fKUniversalButton.setText(guideInfoModel.getButtonName());
                fKUniversalButton.setVisibility(0);
                y.d(fKUniversalButton, new Function1<View, p>() { // from class: com.cupidapp.live.push.util.AppTopTipPopup$configData$2$1
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
                        AppTopTipPopup.f17896a.c();
                        WeakReference<Activity> a10 = com.cupidapp.live.base.activity.a.f11763c.a();
                        j.a.b(j.f12156c, a10 != null ? a10.get() : null, GuideInfoModel.this.getUrl(), null, 4, null);
                        GroupOthersLog.f18702a.m(GuideInfoModel.this.getMessage(), GuideInfoModel.this.getType());
                    }
                });
            }
        }
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.cupidapp.live.push.util.a
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                boolean e2;
                e2 = AppTopTipPopup.e(view2, motionEvent);
                return e2;
            }
        });
    }

    public final View f() {
        return (View) f17901f.getValue();
    }

    public final void g() {
        if (f17900e) {
            return;
        }
        h(f17899d);
    }

    public final void h(@Nullable GuideInfoModel guideInfoModel) {
        WeakReference<Activity> a10;
        Activity activity;
        if (guideInfoModel == null || (a10 = com.cupidapp.live.base.activity.a.f11763c.a()) == null || (activity = a10.get()) == null) {
            return;
        }
        if (b(activity)) {
            c();
            return;
        }
        WindowManager windowManager = (WindowManager) activity.getSystemService("window");
        f17898c = windowManager;
        if (windowManager != null) {
            try {
                windowManager.removeViewImmediate(f());
            } catch (Exception unused) {
            }
        }
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -2;
        layoutParams.gravity = 49;
        layoutParams.format = 1;
        layoutParams.flags = 40;
        layoutParams.windowAnimations = R$style.dialog_top_enter_top_exit_anim;
        View cardView = f();
        s.h(cardView, "cardView");
        d(guideInfoModel, cardView);
        if (!s.d(f17899d, guideInfoModel)) {
            f17900e = false;
            f17899d = guideInfoModel;
            Ref$LongRef ref$LongRef = new Ref$LongRef();
            ref$LongRef.element = 6000L;
            Integer showSec = guideInfoModel.getShowSec();
            if ((showSec != null ? showSec.intValue() : 0) > 0) {
                ref$LongRef.element = (guideInfoModel.getShowSec() != null ? r3.intValue() : 0) * 1000;
            }
            a aVar = new a(ref$LongRef);
            f17902g = aVar;
            aVar.start();
            GroupOthersLog.f18702a.n(guideInfoModel.getTitle() + guideInfoModel.getMessage(), guideInfoModel.getType());
        }
        try {
            WindowManager windowManager2 = f17898c;
            if (windowManager2 != null) {
                windowManager2.addView(f(), layoutParams);
            }
        } catch (Exception unused2) {
        }
    }
}

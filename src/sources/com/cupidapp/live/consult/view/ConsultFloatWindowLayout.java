package com.cupidapp.live.consult.view;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Property;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.view.BaseLayout;
import com.cupidapp.live.consult.helper.ConsultLiveHelper;
import com.cupidapp.live.consult.model.ConsultLiveModel;
import com.cupidapp.live.consult.view.ConsultFloatWindowLayout;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import x0.a;
import z0.h;
import z0.y;
import z0.z;

/* compiled from: ConsultFloatWindowLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ConsultFloatWindowLayout extends BaseLayout {

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public a f13859d;

    /* renamed from: e, reason: collision with root package name */
    public int f13860e;

    /* renamed from: f, reason: collision with root package name */
    public int f13861f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f13862g;

    /* compiled from: ConsultFloatWindowLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface a {
        void a();

        void b();

        void c(int i10, int i11);

        void d();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConsultFloatWindowLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f13862g = new LinkedHashMap();
        k();
    }

    @Nullable
    public View e(int i10) {
        Map<Integer, View> map = this.f13862g;
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

    public final void g() {
        ImageView consult_float_window_close_btn = (ImageView) e(R$id.consult_float_window_close_btn);
        s.h(consult_float_window_close_btn, "consult_float_window_close_btn");
        y.d(consult_float_window_close_btn, new Function1<View, p>() { // from class: com.cupidapp.live.consult.view.ConsultFloatWindowLayout$bindClickEvent$1
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
                ConsultFloatWindowLayout.a aVar;
                aVar = ConsultFloatWindowLayout.this.f13859d;
                if (aVar != null) {
                    aVar.b();
                }
            }
        });
        View consult_float_window_bg = e(R$id.consult_float_window_bg);
        s.h(consult_float_window_bg, "consult_float_window_bg");
        y.d(consult_float_window_bg, new Function1<View, p>() { // from class: com.cupidapp.live.consult.view.ConsultFloatWindowLayout$bindClickEvent$2
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
                ConsultFloatWindowLayout.a aVar;
                aVar = ConsultFloatWindowLayout.this.f13859d;
                if (aVar != null) {
                    aVar.a();
                }
            }
        });
    }

    public final void h(@NotNull ConsultLiveModel model) {
        s.i(model, "model");
        ImageLoaderView consult_float_window_cover_img = (ImageLoaderView) e(R$id.consult_float_window_cover_img);
        s.h(consult_float_window_cover_img, "consult_float_window_cover_img");
        ImageLoaderView.g(consult_float_window_cover_img, model.getCover(), null, null, 6, null);
        ((ImageView) e(R$id.consult_float_window_category_img)).setImageResource(ConsultLiveHelper.f13820a.f(model.getCategory()));
        ((TextView) e(R$id.consult_float_window_title_text)).setText(model.getTitle());
    }

    public final void i() {
        ImageLoaderView consult_float_window_cover_img = (ImageLoaderView) e(R$id.consult_float_window_cover_img);
        s.h(consult_float_window_cover_img, "consult_float_window_cover_img");
        ImageLoaderView.f(consult_float_window_cover_img, new com.cupidapp.live.base.imageloader.b(false, null, null, null, Integer.valueOf(R$mipmap.ic_consult_float_window_live_end), null, null, 0, 0, null, null, null, null, false, 0, 0, false, null, null, 524271, null), null, 2, null);
    }

    public final void j() {
        n1.a.f52091a.a(getContext(), 500L);
    }

    public final void k() {
        z.a(this, R$layout.layout_consult_float_window, true);
        g();
        a.C0834a c0834a = x0.a.f54353h;
        View consult_float_window_bg = e(R$id.consult_float_window_bg);
        s.h(consult_float_window_bg, "consult_float_window_bg");
        c0834a.a(consult_float_window_bg, -1, h.c(this, 8.0f), com.cupidapp.live.base.utils.h.a(-16777216, 0.2f), h.c(this, 5.0f), 0.0f, 0.0f);
    }

    public final void l() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, (Property<ConsultFloatWindowLayout, Float>) View.SCALE_X, 1.0f, 0.95f, 1.0f, 0.96f, 1.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, (Property<ConsultFloatWindowLayout, Float>) View.SCALE_Y, 1.0f, 0.95f, 1.0f, 0.96f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat).with(ofFloat2);
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet.setDuration(1000L);
        animatorSet.start();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(@Nullable MotionEvent motionEvent) {
        if (motionEvent == null) {
            return super.onInterceptTouchEvent(null);
        }
        int rawX = (int) motionEvent.getRawX();
        int rawY = (int) motionEvent.getRawY();
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f13860e = rawX;
            this.f13861f = rawY;
        } else if (action == 2) {
            int abs = Math.abs(rawX - this.f13860e);
            int abs2 = Math.abs(rawY - this.f13861f);
            int scaledTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
            if (abs > scaledTouchSlop || abs2 > scaledTouchSlop) {
                this.f13860e = rawX;
                this.f13861f = rawY;
                return true;
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(@Nullable MotionEvent motionEvent) {
        a aVar;
        if (motionEvent == null) {
            return true;
        }
        int rawX = (int) motionEvent.getRawX();
        int rawY = (int) motionEvent.getRawY();
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f13860e = rawX;
            this.f13861f = rawY;
        } else if (action == 1) {
            a aVar2 = this.f13859d;
            if (aVar2 != null) {
                aVar2.d();
            }
        } else if (action == 2) {
            int i10 = rawX - this.f13860e;
            int i11 = rawY - this.f13861f;
            if ((i10 != 0 || i11 != 0) && (aVar = this.f13859d) != null) {
                aVar.c(i10, i11);
            }
            this.f13860e = rawX;
            this.f13861f = rawY;
        }
        return true;
    }

    public final void setOnFloatWindowClickListener(@NotNull a listener) {
        s.i(listener, "listener");
        this.f13859d = listener;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConsultFloatWindowLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f13862g = new LinkedHashMap();
        k();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConsultFloatWindowLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f13862g = new LinkedHashMap();
        k();
    }
}

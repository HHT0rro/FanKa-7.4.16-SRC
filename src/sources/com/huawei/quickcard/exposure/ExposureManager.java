package com.huawei.quickcard.exposure;

import android.graphics.Rect;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import com.huawei.quickcard.base.annotation.DoNotShrink;
import com.huawei.quickcard.d0;
import com.huawei.quickcard.utils.EventFilter;
import java.util.Map;
import java.util.WeakHashMap;

@DoNotShrink
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class ExposureManager {

    /* renamed from: f, reason: collision with root package name */
    private static final int f33614f = 200;

    /* renamed from: a, reason: collision with root package name */
    private View f33615a;

    /* renamed from: b, reason: collision with root package name */
    private Map<View, d0> f33616b = new WeakHashMap();

    /* renamed from: c, reason: collision with root package name */
    private ViewTreeObserver.OnGlobalLayoutListener f33617c = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.huawei.quickcard.exposure.a
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            ExposureManager.this.b();
        }
    };

    /* renamed from: d, reason: collision with root package name */
    private ViewTreeObserver.OnScrollChangedListener f33618d = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.huawei.quickcard.exposure.b
        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public final void onScrollChanged() {
            ExposureManager.this.c();
        }
    };

    /* renamed from: e, reason: collision with root package name */
    private boolean f33619e = false;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class a implements EventFilter.IEventCallback {
        public a() {
        }

        @Override // com.huawei.quickcard.utils.EventFilter.IEventCallback
        public void onDo() {
            for (Map.Entry entry : ExposureManager.this.f33616b.entrySet()) {
                View view = (View) entry.getKey();
                d0 d0Var = (d0) entry.getValue();
                boolean z10 = ExposureManager.b(view) > d0Var.e();
                if (z10 != d0Var.j()) {
                    ExposureManager.this.a(view, d0Var, z10);
                }
            }
        }
    }

    public ExposureManager(View view) {
        this.f33615a = view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public void c() {
        if (this.f33616b.h().isEmpty()) {
            return;
        }
        EventFilter.start(this, false, 200L, new a());
    }

    public void onAttachedToWindow(View view) {
        d0 d0Var = this.f33616b.get(view);
        if (d0Var == null || d0Var.h()) {
            return;
        }
        d0Var.a(true);
        a(view, d0Var);
    }

    public void onDetachedFromWindow(View view) {
        d0 d0Var = this.f33616b.get(view);
        if (d0Var != null && d0Var.h()) {
            d0Var.a(false);
            a(view, d0Var);
        }
    }

    public void onScreenSateChange(View view, int i10) {
        d0 d0Var = this.f33616b.get(view);
        if (d0Var == null || d0Var.f() == i10) {
            return;
        }
        d0Var.c(i10);
        a(view, d0Var);
    }

    public void onVisibilityChanged(View view, @NonNull View view2, int i10) {
        d0 d0Var = this.f33616b.get(view);
        if (d0Var == null || d0Var.g() == i10) {
            return;
        }
        d0Var.d(i10);
        a(view, d0Var);
    }

    public void registerExposureEvent(View view, int i10, int i11, IExposureCallback iExposureCallback) {
        a();
        d0 d0Var = new d0();
        d0Var.a(iExposureCallback);
        d0Var.a(i10);
        d0Var.b(i11);
        d0Var.c(1);
        d0Var.d(view.getVisibility());
        d0Var.c(b(view) > i11);
        d0Var.a(view.isAttachedToWindow());
        boolean a10 = d0Var.a();
        d0Var.b(a10);
        if (a10) {
            d0Var.a(SystemClock.elapsedRealtime());
        }
        this.f33616b.put(view, d0Var);
    }

    public void release() {
        this.f33616b.clear();
        this.f33615a.getViewTreeObserver().removeOnGlobalLayoutListener(this.f33617c);
        this.f33615a.getViewTreeObserver().removeOnScrollChangedListener(this.f33618d);
        this.f33619e = false;
    }

    public void unRegisterExposureEvent(View view) {
        this.f33616b.remove(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(View view) {
        Rect rect = new Rect();
        if (!view.getGlobalVisibleRect(rect)) {
            return 0;
        }
        if (rect.right <= 0 && rect.bottom <= 0) {
            return 0;
        }
        int width = view.getWidth();
        int height = view.getHeight();
        if (width == 0 || height == 0) {
            return 0;
        }
        return ((rect.height() * rect.width()) * 100) / (height * width);
    }

    private void a() {
        if (this.f33619e) {
            return;
        }
        this.f33615a.getViewTreeObserver().addOnGlobalLayoutListener(this.f33617c);
        this.f33615a.getViewTreeObserver().addOnScrollChangedListener(this.f33618d);
        this.f33619e = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, d0 d0Var, boolean z10) {
        d0Var.c(z10);
        boolean a10 = d0Var.a();
        if (d0Var.i() != a10) {
            if (a10) {
                d0Var.a(SystemClock.elapsedRealtime());
            } else {
                IExposureCallback c4 = d0Var.c();
                long elapsedRealtime = SystemClock.elapsedRealtime() - d0Var.b();
                if (c4 != null && elapsedRealtime >= d0Var.d()) {
                    c4.onExposure(view, elapsedRealtime);
                }
            }
            d0Var.b(a10);
        }
    }

    private void a(View view, d0 d0Var) {
        a(view, d0Var, b(view) > d0Var.e());
    }
}

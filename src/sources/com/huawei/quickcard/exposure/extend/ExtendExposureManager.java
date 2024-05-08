package com.huawei.quickcard.exposure.extend;

import android.os.SystemClock;
import android.view.View;
import android.view.ViewTreeObserver;
import com.huawei.quickcard.base.Attributes;
import com.huawei.quickcard.e0;
import com.huawei.quickcard.utils.EventFilter;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class ExtendExposureManager {

    /* renamed from: g, reason: collision with root package name */
    private static final String f33623g = "ExtendExposureManager";

    /* renamed from: h, reason: collision with root package name */
    private static final int f33624h = 200;

    /* renamed from: a, reason: collision with root package name */
    private final Map<View, e0> f33625a = new WeakHashMap();

    /* renamed from: b, reason: collision with root package name */
    private final ViewTreeObserver.OnGlobalLayoutListener f33626b = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.huawei.quickcard.exposure.extend.a
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            ExtendExposureManager.this.c();
        }
    };

    /* renamed from: c, reason: collision with root package name */
    private final ViewTreeObserver.OnScrollChangedListener f33627c = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.huawei.quickcard.exposure.extend.b
        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public final void onScrollChanged() {
            ExtendExposureManager.this.c();
        }
    };

    /* renamed from: d, reason: collision with root package name */
    private boolean f33628d = false;

    /* renamed from: e, reason: collision with root package name */
    private View f33629e;

    /* renamed from: f, reason: collision with root package name */
    private IQuickCardAreaCalculator f33630f;

    public ExtendExposureManager(View view, IQuickCardAreaCalculator iQuickCardAreaCalculator) {
        this.f33629e = view;
        this.f33630f = iQuickCardAreaCalculator;
    }

    private void a() {
        if (this.f33628d) {
            return;
        }
        this.f33629e.getViewTreeObserver().addOnGlobalLayoutListener(this.f33626b);
        this.f33629e.getViewTreeObserver().addOnScrollChangedListener(this.f33627c);
        this.f33628d = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b() {
        int a10;
        for (Map.Entry<View, e0> entry : this.f33625a.entrySet()) {
            View key = entry.getKey();
            e0 value = entry.getValue();
            if (key != null && value != null) {
                if (value.g()) {
                    int a11 = a(key);
                    if (a11 <= 0) {
                        value.b(false);
                        value.a(0);
                        a(key, value);
                    } else {
                        int c4 = value.c();
                        if (c4 > 0 && Math.abs(a11 - value.b()) >= c4) {
                            value.a(a11);
                            a(key, value);
                        }
                    }
                } else if (value.d() == 1 && value.h() && value.e() == 0 && value.f() && (a10 = a(key)) > 0) {
                    value.b(true);
                    value.a(a10);
                    a(key, value);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (this.f33625a.isEmpty()) {
            return;
        }
        EventFilter.start(this, false, 200L, new EventFilter.IEventCallback() { // from class: com.huawei.quickcard.exposure.extend.c
            @Override // com.huawei.quickcard.utils.EventFilter.IEventCallback
            public final void onDo() {
                ExtendExposureManager.this.b();
            }
        });
    }

    public void onAttachedToWindow(View view) {
        e0 e0Var = this.f33625a.get(view);
        if (e0Var == null) {
            return;
        }
        e0Var.a(true);
        a(view, e0Var, true);
    }

    public void onDetachedFromWindow(View view) {
        e0 e0Var = this.f33625a.get(view);
        if (e0Var == null) {
            return;
        }
        e0Var.a(false);
        a(view, e0Var, false);
    }

    public void onPause() {
        for (Map.Entry<View, e0> entry : this.f33625a.entrySet()) {
            View key = entry.getKey();
            e0 value = entry.getValue();
            if (key != null && value != null) {
                value.c(false);
                a(key, value, false);
            }
        }
    }

    public void onResume() {
        for (Map.Entry<View, e0> entry : this.f33625a.entrySet()) {
            View key = entry.getKey();
            e0 value = entry.getValue();
            if (key != null && value != null) {
                value.c(true);
                a(key, value, true);
            }
        }
    }

    public void onScreenSateChange(int i10) {
        for (Map.Entry<View, e0> entry : this.f33625a.entrySet()) {
            View key = entry.getKey();
            e0 value = entry.getValue();
            if (key != null && value != null) {
                value.c(i10);
                a(key, value, i10 == 1);
            }
        }
    }

    public void onVisibilityChanged(View view, int i10) {
        e0 e0Var = this.f33625a.get(view);
        if (e0Var == null) {
            return;
        }
        e0Var.d(i10);
        a(view, e0Var, i10 == 0);
    }

    public void registerExtendExposureEvent(View view, int i10, boolean z10, IExtendExposureCallback iExtendExposureCallback) {
        a();
        e0 e0Var = new e0();
        e0Var.a(iExtendExposureCallback);
        e0Var.b(i10);
        e0Var.c(1);
        e0Var.c(z10);
        e0Var.d(view.getVisibility());
        e0Var.a(view.isAttachedToWindow());
        e0Var.a(a(view));
        e0Var.b((e0Var.d() == 1 && e0Var.h() && e0Var.e() == 0 && e0Var.f()) && e0Var.b() > 0);
        if (e0Var.g()) {
            a(view, e0Var);
        }
        this.f33625a.put(view, e0Var);
    }

    public void release() {
        this.f33625a.clear();
        this.f33629e.getViewTreeObserver().removeOnGlobalLayoutListener(this.f33626b);
        this.f33629e.getViewTreeObserver().removeOnScrollChangedListener(this.f33627c);
        this.f33628d = false;
    }

    public void setQuickCardAreaCalculator(IQuickCardAreaCalculator iQuickCardAreaCalculator) {
        this.f33630f = iQuickCardAreaCalculator;
    }

    public void unRegisterExtendExposureEvent(View view) {
        this.f33625a.remove(view);
    }

    private void a(View view, e0 e0Var, boolean z10) {
        int a10;
        if (z10) {
            if (e0Var.g()) {
                int c4 = e0Var.c();
                if (c4 > 0) {
                    int a11 = a(view);
                    if (Math.abs(a11 - e0Var.b()) >= c4) {
                        e0Var.a(a11);
                        a(view, e0Var);
                        return;
                    }
                    return;
                }
                return;
            }
            if (e0Var.d() == 1 && e0Var.h() && e0Var.e() == 0 && e0Var.f() && (a10 = a(view)) > 0) {
                e0Var.b(true);
                e0Var.a(a10);
                a(view, e0Var);
                return;
            }
            return;
        }
        if (e0Var.g()) {
            e0Var.b(false);
            a(view, e0Var);
        }
    }

    private int a(View view) {
        IQuickCardAreaCalculator iQuickCardAreaCalculator = this.f33630f;
        if (iQuickCardAreaCalculator == null) {
            return 0;
        }
        return iQuickCardAreaCalculator.getVisiblePercents(view);
    }

    private void a(View view, e0 e0Var) {
        IExtendExposureCallback a10 = e0Var.a();
        if (a10 != null) {
            HashMap hashMap = new HashMap();
            if (e0Var.g()) {
                hashMap.put("visibility", Attributes.Visibility.VISIBLE);
            } else {
                hashMap.put("visibility", "invisible");
            }
            if (e0Var.c() > 0) {
                hashMap.put(Attributes.Style.PERCENT, Integer.valueOf(e0Var.b()));
            }
            hashMap.put("timeStamp", Long.valueOf(SystemClock.elapsedRealtime()));
            a10.onExposure(view, hashMap);
        }
    }
}

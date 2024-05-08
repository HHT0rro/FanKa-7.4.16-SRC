package com.huawei.uikit.hwunifiedinteract.widget;

import android.content.Context;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.uikit.hwresources.utils.HwWidgetInstantiator;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class HwRotaryEventTracker {

    /* renamed from: a, reason: collision with root package name */
    public static final String f35270a = "HwRotaryEventTracker";

    /* renamed from: b, reason: collision with root package name */
    public static final int f35271b = 8;

    /* renamed from: c, reason: collision with root package name */
    public static final long f35272c = 50;

    /* renamed from: d, reason: collision with root package name */
    public static final int f35273d = 2;

    /* renamed from: e, reason: collision with root package name */
    public static final long f35274e = -1;

    /* renamed from: f, reason: collision with root package name */
    public static final int f35275f = 1000;

    /* renamed from: i, reason: collision with root package name */
    public OnRotaryListener f35278i;

    /* renamed from: j, reason: collision with root package name */
    public View f35279j;

    /* renamed from: k, reason: collision with root package name */
    public MotionEvent f35280k;

    /* renamed from: l, reason: collision with root package name */
    public MotionEvent f35281l;

    /* renamed from: g, reason: collision with root package name */
    public long f35276g = -1;

    /* renamed from: h, reason: collision with root package name */
    public a f35277h = new a();

    /* renamed from: m, reason: collision with root package name */
    public float f35282m = 0.0f;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface OnRotaryListener {
        boolean onBeginScroll(@NonNull MotionEvent motionEvent);

        boolean onEndScroll(@NonNull MotionEvent motionEvent);

        boolean onMiddleScroll(@NonNull MotionEvent motionEvent);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public OnRotaryListener f35283a;

        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            HwRotaryEventTracker.this.b(null, this.f35283a);
        }
    }

    public HwRotaryEventTracker(@NonNull Context context) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0067  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean b(@androidx.annotation.Nullable android.view.MotionEvent r7, com.huawei.uikit.hwunifiedinteract.widget.HwRotaryEventTracker.OnRotaryListener r8) {
        /*
            Method dump skipped, instructions count: 223
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.uikit.hwunifiedinteract.widget.HwRotaryEventTracker.b(android.view.MotionEvent, com.huawei.uikit.hwunifiedinteract.widget.HwRotaryEventTracker$OnRotaryListener):boolean");
    }

    private boolean c(@NonNull MotionEvent motionEvent, OnRotaryListener onRotaryListener) {
        a(false, motionEvent, onRotaryListener);
        return onRotaryListener.onMiddleScroll(motionEvent);
    }

    @Nullable
    public static HwRotaryEventTracker instantiate(@NonNull Context context) {
        Object instantiate = HwWidgetInstantiator.instantiate(context, HwWidgetInstantiator.getDeviceClassName(context, HwRotaryEventTracker.class, HwWidgetInstantiator.getCurrentType(context, 8, 8)), HwRotaryEventTracker.class);
        if (instantiate instanceof HwRotaryEventTracker) {
            return (HwRotaryEventTracker) instantiate;
        }
        return null;
    }

    public void computeCurrentVelocity() {
        MotionEvent motionEvent = this.f35280k;
        if (motionEvent != null && this.f35281l != null) {
            float axisValue = motionEvent.getAxisValue(26);
            float axisValue2 = this.f35281l.getAxisValue(26);
            float eventTime = (float) this.f35280k.getEventTime();
            float eventTime2 = (float) this.f35281l.getEventTime();
            if (Float.compare(eventTime, eventTime2) >= 0) {
                this.f35282m = 0.0f;
                return;
            }
            if (Float.compare(axisValue * axisValue2, 0.0f) > 0) {
                axisValue2 = (axisValue + axisValue2) / 2.0f;
            }
            this.f35282m = ((-axisValue2) / (eventTime2 - eventTime)) * 1000.0f;
            return;
        }
        this.f35282m = 0.0f;
    }

    public OnRotaryListener getOnRotaryListener() {
        return this.f35278i;
    }

    public float getVelocity() {
        return this.f35282m;
    }

    public boolean onGenericMotionEvent(@NonNull MotionEvent motionEvent) {
        if (!motionEvent.isFromSource(4194304) || motionEvent.getAction() != 8 || this.f35278i == null) {
            return false;
        }
        long eventTime = motionEvent.getEventTime();
        long j10 = this.f35276g;
        if (j10 < 0) {
            boolean a10 = a(motionEvent, this.f35278i);
            this.f35276g = eventTime;
            return a10;
        }
        if (eventTime - j10 >= 50) {
            b(motionEvent, this.f35278i);
            boolean a11 = a(motionEvent, this.f35278i);
            this.f35276g = eventTime;
            return a11;
        }
        boolean c4 = c(motionEvent, this.f35278i);
        this.f35276g = eventTime;
        return c4;
    }

    public void setOnRotaryListener(@NonNull View view, @NonNull OnRotaryListener onRotaryListener) {
        this.f35278i = onRotaryListener;
        this.f35279j = view;
    }

    private boolean a(@NonNull MotionEvent motionEvent, OnRotaryListener onRotaryListener) {
        a(true, motionEvent, onRotaryListener);
        return onRotaryListener.onBeginScroll(motionEvent);
    }

    private void a(boolean z10, MotionEvent motionEvent, OnRotaryListener onRotaryListener) {
        if (z10) {
            MotionEvent motionEvent2 = this.f35280k;
            if (motionEvent2 != null) {
                motionEvent2.recycle();
                this.f35280k = null;
            }
            MotionEvent motionEvent3 = this.f35281l;
            if (motionEvent3 != null) {
                motionEvent3.recycle();
            }
            this.f35281l = MotionEvent.obtain(motionEvent);
        } else {
            MotionEvent motionEvent4 = this.f35280k;
            if (motionEvent4 != null) {
                motionEvent4.recycle();
            }
            this.f35280k = this.f35281l;
            this.f35281l = MotionEvent.obtain(motionEvent);
        }
        this.f35279j.removeCallbacks(this.f35277h);
        this.f35277h.f35283a = onRotaryListener;
        this.f35279j.postDelayed(this.f35277h, 50L);
    }

    private MotionEvent a(float f10) {
        MotionEvent.PointerCoords pointerCoords = new MotionEvent.PointerCoords();
        pointerCoords.f810x = 0.0f;
        pointerCoords.f811y = 0.0f;
        pointerCoords.setAxisValue(26, f10);
        MotionEvent.PointerCoords[] pointerCoordsArr = {pointerCoords};
        MotionEvent.PointerProperties pointerProperties = new MotionEvent.PointerProperties();
        pointerProperties.f812id = 0;
        MotionEvent.PointerProperties[] pointerPropertiesArr = {pointerProperties};
        long uptimeMillis = SystemClock.uptimeMillis();
        return MotionEvent.obtain(uptimeMillis, uptimeMillis, 8, 1, pointerPropertiesArr, pointerCoordsArr, 0, 0, 1.0f, 1.0f, 0, 0, 4194304, 0);
    }
}

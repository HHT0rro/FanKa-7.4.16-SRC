package s0;

import android.view.GestureDetector;
import android.view.MotionEvent;
import com.contrarywind.view.WheelView;

/* compiled from: LoopViewGestureListener.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class a extends GestureDetector.SimpleOnGestureListener {

    /* renamed from: b, reason: collision with root package name */
    public final WheelView f53575b;

    public a(WheelView wheelView) {
        this.f53575b = wheelView;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f10, float f11) {
        this.f53575b.r(f11);
        return true;
    }
}

package t0;

import com.contrarywind.view.WheelView;
import java.util.TimerTask;

/* compiled from: InertiaTimerTask.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class a extends TimerTask {

    /* renamed from: b, reason: collision with root package name */
    public float f53752b = 2.14748365E9f;

    /* renamed from: c, reason: collision with root package name */
    public final float f53753c;

    /* renamed from: d, reason: collision with root package name */
    public final WheelView f53754d;

    public a(WheelView wheelView, float f10) {
        this.f53754d = wheelView;
        this.f53753c = f10;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.f53752b == 2.14748365E9f) {
            if (Math.abs(this.f53753c) > 2000.0f) {
                this.f53752b = this.f53753c <= 0.0f ? -2000.0f : 2000.0f;
            } else {
                this.f53752b = this.f53753c;
            }
        }
        if (Math.abs(this.f53752b) >= 0.0f && Math.abs(this.f53752b) <= 20.0f) {
            this.f53754d.b();
            this.f53754d.getHandler().sendEmptyMessage(2000);
            return;
        }
        int i10 = (int) (this.f53752b / 100.0f);
        WheelView wheelView = this.f53754d;
        float f10 = i10;
        wheelView.setTotalScrollY(wheelView.getTotalScrollY() - f10);
        if (!this.f53754d.j()) {
            float itemHeight = this.f53754d.getItemHeight();
            float f11 = (-this.f53754d.getInitPosition()) * itemHeight;
            float itemsCount = ((this.f53754d.getItemsCount() - 1) - this.f53754d.getInitPosition()) * itemHeight;
            double d10 = itemHeight * 0.25d;
            if (this.f53754d.getTotalScrollY() - d10 < f11) {
                f11 = this.f53754d.getTotalScrollY() + f10;
            } else if (this.f53754d.getTotalScrollY() + d10 > itemsCount) {
                itemsCount = this.f53754d.getTotalScrollY() + f10;
            }
            if (this.f53754d.getTotalScrollY() <= f11) {
                this.f53752b = 40.0f;
                this.f53754d.setTotalScrollY((int) f11);
            } else if (this.f53754d.getTotalScrollY() >= itemsCount) {
                this.f53754d.setTotalScrollY((int) itemsCount);
                this.f53752b = -40.0f;
            }
        }
        float f12 = this.f53752b;
        if (f12 < 0.0f) {
            this.f53752b = f12 + 20.0f;
        } else {
            this.f53752b = f12 - 20.0f;
        }
        this.f53754d.getHandler().sendEmptyMessage(1000);
    }
}

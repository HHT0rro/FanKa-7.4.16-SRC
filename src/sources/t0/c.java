package t0;

import com.contrarywind.view.WheelView;
import java.util.TimerTask;

/* compiled from: SmoothScrollTimerTask.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class c extends TimerTask {

    /* renamed from: b, reason: collision with root package name */
    public int f53756b = Integer.MAX_VALUE;

    /* renamed from: c, reason: collision with root package name */
    public int f53757c = 0;

    /* renamed from: d, reason: collision with root package name */
    public int f53758d;

    /* renamed from: e, reason: collision with root package name */
    public final WheelView f53759e;

    public c(WheelView wheelView, int i10) {
        this.f53759e = wheelView;
        this.f53758d = i10;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.f53756b == Integer.MAX_VALUE) {
            this.f53756b = this.f53758d;
        }
        int i10 = this.f53756b;
        int i11 = (int) (i10 * 0.1f);
        this.f53757c = i11;
        if (i11 == 0) {
            if (i10 < 0) {
                this.f53757c = -1;
            } else {
                this.f53757c = 1;
            }
        }
        if (Math.abs(i10) <= 1) {
            this.f53759e.b();
            this.f53759e.getHandler().sendEmptyMessage(3000);
            return;
        }
        WheelView wheelView = this.f53759e;
        wheelView.setTotalScrollY(wheelView.getTotalScrollY() + this.f53757c);
        if (!this.f53759e.j()) {
            float itemHeight = this.f53759e.getItemHeight();
            float itemsCount = ((this.f53759e.getItemsCount() - 1) - this.f53759e.getInitPosition()) * itemHeight;
            if (this.f53759e.getTotalScrollY() <= (-this.f53759e.getInitPosition()) * itemHeight || this.f53759e.getTotalScrollY() >= itemsCount) {
                WheelView wheelView2 = this.f53759e;
                wheelView2.setTotalScrollY(wheelView2.getTotalScrollY() - this.f53757c);
                this.f53759e.b();
                this.f53759e.getHandler().sendEmptyMessage(3000);
                return;
            }
        }
        this.f53759e.getHandler().sendEmptyMessage(1000);
        this.f53756b -= this.f53757c;
    }
}

package t0;

import android.os.Handler;
import android.os.Message;
import com.contrarywind.view.WheelView;

/* compiled from: MessageHandler.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class b extends Handler {

    /* renamed from: a, reason: collision with root package name */
    public final WheelView f53755a;

    public b(WheelView wheelView) {
        this.f53755a = wheelView;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i10 = message.what;
        if (i10 == 1000) {
            this.f53755a.invalidate();
        } else if (i10 == 2000) {
            this.f53755a.t(WheelView.ACTION.FLING);
        } else {
            if (i10 != 3000) {
                return;
            }
            this.f53755a.o();
        }
    }
}

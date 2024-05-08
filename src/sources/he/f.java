package he;

import android.os.Looper;
import org.greenrobot.eventbus.EventBus;

/* compiled from: MainThreadSupport.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public interface f {

    /* compiled from: MainThreadSupport.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class a implements f {

        /* renamed from: a, reason: collision with root package name */
        public final Looper f49627a;

        public a(Looper looper) {
            this.f49627a = looper;
        }

        @Override // he.f
        public boolean a() {
            return this.f49627a == Looper.myLooper();
        }

        @Override // he.f
        public i b(EventBus eventBus) {
            return new d(eventBus, this.f49627a, 10);
        }
    }

    boolean a();

    i b(EventBus eventBus);
}

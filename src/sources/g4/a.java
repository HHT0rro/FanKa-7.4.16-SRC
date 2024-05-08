package g4;

import android.os.HandlerThread;
import android.os.Looper;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: FrameDecoderExecutor.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class a {

    /* renamed from: c, reason: collision with root package name */
    public static int f49364c = 4;

    /* renamed from: a, reason: collision with root package name */
    public ArrayList<HandlerThread> f49365a;

    /* renamed from: b, reason: collision with root package name */
    public AtomicInteger f49366b;

    /* compiled from: FrameDecoderExecutor.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public static final a f49367a = new a();
    }

    public static a b() {
        return b.f49367a;
    }

    public int a() {
        return this.f49366b.getAndIncrement();
    }

    public Looper c(int i10) {
        int i11 = i10 % f49364c;
        if (i11 >= this.f49365a.size()) {
            HandlerThread handlerThread = new HandlerThread("FrameDecoderExecutor-" + i11);
            handlerThread.start();
            this.f49365a.add(handlerThread);
            Looper looper = handlerThread.getLooper();
            return looper != null ? looper : Looper.getMainLooper();
        }
        if (this.f49365a.get(i11) != null) {
            Looper looper2 = this.f49365a.get(i11).getLooper();
            return looper2 != null ? looper2 : Looper.getMainLooper();
        }
        return Looper.getMainLooper();
    }

    public a() {
        this.f49365a = new ArrayList<>();
        this.f49366b = new AtomicInteger(0);
    }
}

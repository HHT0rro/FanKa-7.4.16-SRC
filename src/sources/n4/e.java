package n4;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import javax.inject.Singleton;

/* compiled from: ExecutionModule.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public abstract class e {
    @Singleton
    public static Executor a() {
        return new g(Executors.newSingleThreadExecutor());
    }
}

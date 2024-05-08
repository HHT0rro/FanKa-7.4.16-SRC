package g7;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.concurrent.Callable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class k implements Callable<SharedPreferences> {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f49416b;

    public k(Context context) {
        this.f49416b = context;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ SharedPreferences call() throws Exception {
        return this.f49416b.getSharedPreferences("google_sdk_flags", 0);
    }
}

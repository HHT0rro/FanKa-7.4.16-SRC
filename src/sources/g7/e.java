package g7;

import android.content.SharedPreferences;
import java.util.concurrent.Callable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class e implements Callable<Integer> {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SharedPreferences f49406b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f49407c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Integer f49408d;

    public e(SharedPreferences sharedPreferences, String str, Integer num) {
        this.f49406b = sharedPreferences;
        this.f49407c = str;
        this.f49408d = num;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ Integer call() throws Exception {
        return Integer.valueOf(this.f49406b.getInt(this.f49407c, this.f49408d.intValue()));
    }
}

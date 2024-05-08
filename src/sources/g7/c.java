package g7;

import android.content.SharedPreferences;
import java.util.concurrent.Callable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class c implements Callable<Boolean> {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SharedPreferences f49403b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f49404c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Boolean f49405d;

    public c(SharedPreferences sharedPreferences, String str, Boolean bool) {
        this.f49403b = sharedPreferences;
        this.f49404c = str;
        this.f49405d = bool;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ Boolean call() throws Exception {
        return Boolean.valueOf(this.f49403b.getBoolean(this.f49404c, this.f49405d.booleanValue()));
    }
}

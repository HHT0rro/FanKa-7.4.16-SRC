package g7;

import android.content.SharedPreferences;
import java.util.concurrent.Callable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class i implements Callable<String> {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SharedPreferences f49412b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f49413c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f49414d;

    public i(SharedPreferences sharedPreferences, String str, String str2) {
        this.f49412b = sharedPreferences;
        this.f49413c = str;
        this.f49414d = str2;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ String call() throws Exception {
        return this.f49412b.getString(this.f49413c, this.f49414d);
    }
}

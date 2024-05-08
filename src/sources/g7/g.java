package g7;

import android.content.SharedPreferences;
import java.util.concurrent.Callable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class g implements Callable<Long> {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SharedPreferences f49409b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f49410c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Long f49411d;

    public g(SharedPreferences sharedPreferences, String str, Long l10) {
        this.f49409b = sharedPreferences;
        this.f49410c = str;
        this.f49411d = l10;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ Long call() throws Exception {
        return Long.valueOf(this.f49409b.getLong(this.f49410c, this.f49411d.longValue()));
    }
}

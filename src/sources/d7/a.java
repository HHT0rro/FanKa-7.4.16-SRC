package d7;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import androidx.annotation.RecentlyNonNull;

/* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public final Context f48651a;

    public a(@RecentlyNonNull Context context) {
        this.f48651a = context;
    }

    @RecentlyNonNull
    public int a(@RecentlyNonNull String str) {
        return this.f48651a.checkCallingOrSelfPermission(str);
    }

    @RecentlyNonNull
    public ApplicationInfo b(@RecentlyNonNull String str, @RecentlyNonNull int i10) throws PackageManager.NameNotFoundException {
        return this.f48651a.getPackageManager().getApplicationInfo(str, i10);
    }

    @RecentlyNonNull
    public CharSequence c(@RecentlyNonNull String str) throws PackageManager.NameNotFoundException {
        return this.f48651a.getPackageManager().getApplicationLabel(this.f48651a.getPackageManager().getApplicationInfo(str, 0));
    }

    @RecentlyNonNull
    public PackageInfo d(@RecentlyNonNull String str, @RecentlyNonNull int i10) throws PackageManager.NameNotFoundException {
        return this.f48651a.getPackageManager().getPackageInfo(str, i10);
    }
}

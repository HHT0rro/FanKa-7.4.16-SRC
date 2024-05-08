package i2;

import android.content.Context;
import android.content.pm.PackageManager;
import com.cupidapp.live.AppApplication;
import com.cupidapp.live.liveshow.beauty.databeauty.UserData;
import i2.c;

/* compiled from: WelcomePresenter.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class f extends e implements c.a {

    /* renamed from: b, reason: collision with root package name */
    public UserData f49712b = UserData.getInstance(AppApplication.f11612d.c());

    @Override // i2.c.a
    public void a() {
        if (d()) {
            c().a();
        }
    }

    @Override // i2.c.a
    public void b(boolean z10) {
        if (c() == null) {
            return;
        }
        if (z10) {
            this.f49712b.setResourceReady(true);
            this.f49712b.setVersion(e());
        }
        if (d()) {
            c().b(z10);
        }
    }

    public int e() {
        Context c4 = AppApplication.f11612d.c();
        try {
            return c4.getPackageManager().getPackageInfo(c4.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    public boolean f() {
        return this.f49712b.isResourceReady() && this.f49712b.getVersion() == e();
    }

    public void g() {
        new c(this).execute(UserData.RESOURCE_READY);
    }

    @Override // i2.c.a
    public Context getContext() {
        return AppApplication.f11612d.c();
    }
}

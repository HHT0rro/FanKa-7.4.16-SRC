package ka;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import androidx.annotation.NonNull;
import com.huawei.appgallery.marketinstallerservice.api.Constant;
import com.huawei.appgallery.marketinstallerservice.api.FailResultParam;
import com.huawei.appgallery.marketinstallerservice.api.InstallCallback;
import com.huawei.appgallery.marketinstallerservice.api.InstallParamSpec;
import com.huawei.appgallery.marketinstallerservice.api.MarketInfo;
import ia.a;
import ia.b;
import java.io.File;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class c implements a, a.InterfaceC0750a, b.a {

    /* renamed from: a, reason: collision with root package name */
    public Activity f50744a;

    /* renamed from: b, reason: collision with root package name */
    public b f50745b;

    /* renamed from: e, reason: collision with root package name */
    public ia.a f50748e;

    /* renamed from: c, reason: collision with root package name */
    public InstallParamSpec f50746c = null;

    /* renamed from: d, reason: collision with root package name */
    public String f50747d = null;

    /* renamed from: f, reason: collision with root package name */
    public FailResultParam f50749f = new FailResultParam();

    public c(Activity activity, b bVar) {
        this.f50744a = activity;
        this.f50745b = bVar;
    }

    @Override // ka.a
    public void a() {
        this.f50746c.setMarketInfo(null);
        a(this.f50746c, this.f50747d);
    }

    @Override // ia.a.InterfaceC0750a
    public void a(int i10, int i11) {
        if (i10 == 1) {
            this.f50745b.a(i10, i11);
            return;
        }
        if (i10 != 2) {
            if (i10 == 3) {
                this.f50745b.a(i10, i11);
                f();
                return;
            } else if (i10 != 4) {
                if (i10 != 5) {
                    return;
                }
                b(-3, 0, 0, Constant.INSTALL_FAILED_SHA256_EEROR);
                this.f50745b.a(-3);
            }
        }
        a(-3, 0, 0);
        this.f50745b.a(-3);
    }

    @Override // ka.a
    public void a(int i10, int i11, int i12) {
        b(i10, i11, i12, 0);
    }

    @Override // ka.a
    public void a(InstallParamSpec installParamSpec, String str) {
        this.f50746c = installParamSpec;
        this.f50747d = str;
        if (!ga.c.e(this.f50744a)) {
            this.f50745b.c();
            return;
        }
        ia.a aVar = new ia.a(this, this.f50746c);
        this.f50748e = aVar;
        aVar.execute(new Void[0]);
        this.f50745b.d();
    }

    @Override // ia.b.a
    public void a(boolean z10) {
        if (z10) {
            return;
        }
        b(-2, 0, 0, Constant.INSTALL_FAILED_FILE_NOT_FOUND);
        this.f50745b.a(-2);
    }

    @Override // ia.a.InterfaceC0750a, ia.b.a
    @NonNull
    public Context b() {
        return this.f50744a;
    }

    @Override // ka.a
    public void b(int i10, int i11, int i12, int i13) {
        fa.a.d("MarketDownloadPresenter", "notifyResult errorCode" + i10 + ", responseCode=" + i11 + ", rtnCode=" + i12);
        this.f50749f.setResult(i10);
        this.f50749f.setResponseCode(i11);
        this.f50749f.setRtnCode(i12);
        this.f50749f.setReason(i13);
        InstallParamSpec installParamSpec = this.f50746c;
        MarketInfo marketInfo = installParamSpec != null ? installParamSpec.getMarketInfo() : null;
        this.f50749f.setMarketInfo(marketInfo);
        InstallParamSpec installParamSpec2 = this.f50746c;
        if (installParamSpec2 != null && installParamSpec2.getFailResultPromptType() == 2 && (-3 == i10 || -2 == i10)) {
            fa.a.d("MarketDownloadPresenter", "need show retry dialog!");
        } else {
            InstallCallback a10 = y9.a.a(this.f50747d);
            if (a10 != null) {
                if (i10 == 0) {
                    a10.onSuccess(marketInfo);
                } else {
                    a10.onFailed(this.f50749f);
                }
                y9.a.e(this.f50747d);
            }
        }
        File file = new File(y9.b.a(this.f50744a));
        if (!file.exists() || file.delete()) {
            return;
        }
        fa.a.d("MarketDownloadPresenter", "delete DownloadFile failed");
    }

    @Override // ka.a
    public void c() {
        ia.a aVar = this.f50748e;
        if (aVar != null) {
            aVar.cancel(true);
        }
    }

    @Override // ia.a.InterfaceC0750a
    public void c(MarketInfo marketInfo, int i10, int i11) {
        InstallParamSpec installParamSpec;
        if (marketInfo == null || (installParamSpec = this.f50746c) == null) {
            a(-4, i10, i11);
            this.f50745b.a(-4);
        } else {
            installParamSpec.setMarketInfo(marketInfo);
            this.f50745b.a(marketInfo);
        }
    }

    @Override // ka.a
    @NonNull
    public MarketInfo d() {
        InstallParamSpec installParamSpec = this.f50746c;
        return (installParamSpec == null || installParamSpec.getMarketInfo() == null) ? new MarketInfo() : this.f50746c.getMarketInfo();
    }

    @Override // ka.a
    public void e() {
        InstallCallback a10 = y9.a.a(this.f50747d);
        if (a10 != null) {
            a10.onFailed(this.f50749f);
            y9.a.e(this.f50747d);
        }
    }

    public final void f() {
        if (ia.b.f(this.f50744a)) {
            new ia.b(this).execute(new Void[0]);
            return;
        }
        try {
            Activity activity = this.f50744a;
            activity.startActivityForResult(ia.b.a(activity), 1000);
        } catch (ActivityNotFoundException unused) {
            fa.a.c("MarketDownloadPresenter", "startActivityForResult ActivityNotFoundException");
            a(-2, 0, 0);
            this.f50745b.a(-2);
        }
    }
}

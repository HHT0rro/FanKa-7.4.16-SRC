package ia;

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
public class c implements a.InterfaceC0750a, b.a {

    /* renamed from: a, reason: collision with root package name */
    public Context f49862a;

    /* renamed from: b, reason: collision with root package name */
    public InstallParamSpec f49863b;

    /* renamed from: c, reason: collision with root package name */
    public InstallCallback f49864c;

    /* renamed from: d, reason: collision with root package name */
    public String f49865d = "";

    /* renamed from: e, reason: collision with root package name */
    public FailResultParam f49866e = new FailResultParam();

    /* renamed from: f, reason: collision with root package name */
    public a f49867f;

    public c(@NonNull Context context, @NonNull InstallParamSpec installParamSpec, InstallCallback installCallback) {
        this.f49862a = context;
        this.f49863b = installParamSpec;
        this.f49864c = installCallback;
    }

    public void a() {
        if (!ga.c.e(this.f49862a)) {
            this.f49866e.setResult(-1);
            d();
        } else {
            a aVar = new a(this, this.f49863b);
            this.f49867f = aVar;
            aVar.execute(new Void[0]);
        }
    }

    @Override // ia.a.InterfaceC0750a
    public void a(int i10, int i11) {
        if (i10 != 2) {
            if (i10 == 3) {
                e();
                return;
            } else if (i10 != 4) {
                if (i10 != 5) {
                    return;
                }
                this.f49866e.setReason(Constant.INSTALL_FAILED_SHA256_EEROR);
                this.f49866e.setResult(-3);
                return;
            }
        }
        this.f49866e.setResult(-3);
        d();
    }

    @Override // ia.b.a
    public void a(boolean z10) {
        if (z10) {
            return;
        }
        this.f49866e.setResult(-2);
        this.f49866e.setReason(Constant.INSTALL_FAILED_FILE_NOT_FOUND);
        d();
        y9.a.f(this.f49865d);
        y9.a.e(this.f49865d);
    }

    @Override // ia.a.InterfaceC0750a, ia.b.a
    @NonNull
    public Context b() {
        return this.f49862a;
    }

    @Override // ia.a.InterfaceC0750a
    public void c(MarketInfo marketInfo, int i10, int i11) {
        this.f49866e.setResponseCode(i10);
        this.f49866e.setRtnCode(i11);
        this.f49863b.setMarketInfo(marketInfo);
        if (marketInfo == null) {
            this.f49866e.setResult(-4);
            d();
        }
    }

    public final void d() {
        this.f49866e.setMarketInfo(this.f49863b.getMarketInfo());
        InstallCallback installCallback = this.f49864c;
        if (installCallback != null) {
            installCallback.onFailed(this.f49866e);
        }
        File file = new File(y9.b.a(this.f49862a));
        if (!file.exists() || file.delete()) {
            return;
        }
        fa.a.d("SilentDownloadManager", "delete DownloadFile failed");
    }

    public final void e() {
        if (!b.f(this.f49862a)) {
            this.f49866e.setResult(-2);
            d();
        } else {
            String b4 = y9.a.b(this.f49864c);
            this.f49865d = b4;
            y9.a.c(b4, this.f49863b.getMarketInfo());
            new b(this, this.f49863b, this.f49865d).execute(new Void[0]);
        }
    }
}

package z9;

import android.content.Context;
import ca.d;
import com.huawei.appgallery.marketinstallerservice.internal.framework.storekit.bean.InstallerNetTransmission;
import com.huawei.appgallery.marketinstallerservice.internal.framework.storekit.bean.RequestBean;
import com.huawei.appgallery.marketinstallerservice.internal.framework.storekit.bean.ResponseBean;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class a extends RequestBean {
    public static final String METHOD = "client.getMarketInfo";

    @InstallerNetTransmission
    private String marketPkg;

    @InstallerNetTransmission
    private String resolution;

    @InstallerNetTransmission
    private String version;

    public a() {
    }

    public a(Context context) {
        super(context);
    }

    public static a newInstance(Context context) {
        a aVar = new a(context);
        aVar.setMethod(METHOD);
        aVar.version = d.a(context);
        aVar.resolution = ca.a.f(context);
        return aVar;
    }

    public String getMarketPkg() {
        return this.marketPkg;
    }

    public String getResolution() {
        return this.resolution;
    }

    @Override // com.huawei.appgallery.marketinstallerservice.internal.framework.storekit.bean.RequestBean
    public ResponseBean getResponseBean() {
        return new b();
    }

    public String getVersion() {
        return this.version;
    }

    public void setMarketPkg(String str) {
        this.marketPkg = str;
    }

    public void setResolution(String str) {
        this.resolution = str;
    }

    public void setVersion(String str) {
        this.version = str;
    }
}

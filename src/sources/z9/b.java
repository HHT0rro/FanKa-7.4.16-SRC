package z9;

import com.huawei.appgallery.marketinstallerservice.api.MarketInfo;
import com.huawei.appgallery.marketinstallerservice.internal.framework.storekit.bean.InstallerNetTransmission;
import com.huawei.appgallery.marketinstallerservice.internal.framework.storekit.bean.ResponseBean;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class b extends ResponseBean {

    @InstallerNetTransmission
    private MarketInfo hiAppInfo = null;

    public MarketInfo getHiAppInfo() {
        return this.hiAppInfo;
    }

    public void setHiAppInfo(MarketInfo marketInfo) {
        this.hiAppInfo = marketInfo;
    }
}

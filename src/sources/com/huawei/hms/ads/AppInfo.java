package com.huawei.hms.ads;

import com.huawei.hms.ads.annotation.GlobalApi;
import com.huawei.openalliance.ad.annotations.DataKeep;
import com.huawei.openalliance.ad.inter.data.PermissionEntity;
import com.huawei.openalliance.ad.utils.aa;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@GlobalApi
@DataKeep
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class AppInfo {
    private String appDesc;
    private String appIconUrl;
    private String appName;
    private boolean checkSha256;
    private String downloadText;
    private String downloadUrl;
    private long fileSize;
    private String intentUri;
    private String openText;
    private boolean permPromptForCard;
    private boolean permPromptForLanding;
    private List<AppPermision> permisions;
    private String pkgName;
    private String realPkgName;
    private String safeDownloadUrl;
    private String sha256;
    private String uniqueId;

    public AppInfo(com.huawei.openalliance.ad.inter.data.AppInfo appInfo) {
        this.permPromptForCard = true;
        this.permPromptForLanding = false;
        if (appInfo != null) {
            this.pkgName = appInfo.Code();
            this.realPkgName = appInfo.H();
            this.appName = appInfo.L();
            this.appIconUrl = appInfo.I();
            this.downloadUrl = appInfo.Z();
            this.safeDownloadUrl = appInfo.F();
            this.fileSize = appInfo.B();
            this.sha256 = appInfo.C();
            this.checkSha256 = appInfo.S();
            this.intentUri = appInfo.D();
            this.permPromptForCard = appInfo.c();
            this.permPromptForLanding = appInfo.d();
            this.uniqueId = appInfo.e();
            this.appDesc = appInfo.a();
            this.downloadText = appInfo.j();
            this.openText = appInfo.k();
            if (aa.Code(appInfo.b())) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            Iterator<PermissionEntity> iterator2 = appInfo.b().iterator2();
            while (iterator2.hasNext()) {
                arrayList.add(new AppPermision(iterator2.next()));
            }
            this.permisions = arrayList;
        }
    }

    @GlobalApi
    public String getAppDesc() {
        return this.appDesc;
    }

    @GlobalApi
    public String getAppIconUrl() {
        return this.appIconUrl;
    }

    @GlobalApi
    public String getAppName() {
        return this.appName;
    }

    @GlobalApi
    public List<AppPermision> getAppPermissions() {
        return this.permisions;
    }

    @GlobalApi
    public String getCta(boolean z10) {
        return z10 ? this.openText : this.downloadText;
    }

    @GlobalApi
    public String getDownloadUrl() {
        return this.downloadUrl;
    }

    @GlobalApi
    public long getFileSize() {
        return this.fileSize;
    }

    @GlobalApi
    public String getIntentUri() {
        return this.intentUri;
    }

    @GlobalApi
    public String getPkgName() {
        return this.pkgName;
    }

    @GlobalApi
    public String getRealPkgName() {
        return this.realPkgName;
    }

    @GlobalApi
    public String getSafeDownloadUrl() {
        return this.safeDownloadUrl;
    }

    @GlobalApi
    public String getSha256() {
        return this.sha256;
    }

    @GlobalApi
    public String getUniqueId() {
        return this.uniqueId;
    }

    @GlobalApi
    public boolean isCheckSha256() {
        return this.checkSha256;
    }

    @GlobalApi
    public boolean isPermPromptForCard() {
        return this.permPromptForCard;
    }

    @GlobalApi
    public boolean isPermPromptForLanding() {
        return this.permPromptForLanding;
    }
}

package com.alibaba.security.realidentity.business.start;

import android.text.TextUtils;
import com.alibaba.security.common.utils.JsonUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class StepsExtras implements Serializable {
    private String actionCount;
    private String actionDetail;
    private String livenessConfig;
    private boolean needActionImage = true;
    private boolean needGaze;
    private boolean showNav;

    public String getActionCount() {
        return this.actionCount;
    }

    public List<ActionInfo> getActionDetailList() {
        if (TextUtils.isEmpty(this.actionDetail)) {
            return new ArrayList();
        }
        return JsonUtils.parseArray(this.actionDetail, ActionInfo.class);
    }

    public String getLivenessConfig() {
        return this.livenessConfig;
    }

    public boolean isNeedActionImage() {
        return this.needActionImage;
    }

    public boolean isNeedGaze() {
        return this.needGaze;
    }

    public boolean isShowNav() {
        return this.showNav;
    }

    public void setActionCount(String str) {
        this.actionCount = str;
    }

    public void setActionDetail(String str) {
        this.actionDetail = str;
    }

    public void setLivenessConfig(String str) {
        this.livenessConfig = str;
    }

    public void setNeedActionImage(boolean z10) {
        this.needActionImage = z10;
    }

    public void setNeedGaze(boolean z10) {
        this.needGaze = z10;
    }

    public void setShowNav(boolean z10) {
        this.showNav = z10;
    }
}

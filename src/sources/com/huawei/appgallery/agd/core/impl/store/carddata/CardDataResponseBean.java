package com.huawei.appgallery.agd.core.impl.store.carddata;

import androidx.annotation.VisibleForTesting;
import com.huawei.appgallery.agd.serverreq.bean.BaseResponseBean;
import com.huawei.appgallery.agd.serverreq.json.annotation.NetworkTransmission;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class CardDataResponseBean extends BaseResponseBean implements ICommonInfo {
    public static final int CREATIVE_TYPE_NATIVE = 7;
    public static final int CREATIVE_TYPE_REWARD = 6;
    public static final int SWITCH_PREF_AG = 0;
    public static final int SWITCH_PREF_PPS = 1;

    @NetworkTransmission
    private int actionBarStyle;

    @NetworkTransmission
    private List<MaterialMeta> adMaterials;

    @NetworkTransmission
    private String engineerVersion;

    @NetworkTransmission
    private String ppsSlotId;

    @NetworkTransmission
    private int styleType;

    @NetworkTransmission
    private String tabName;

    @NetworkTransmission
    private int adSwitch = 0;

    @NetworkTransmission
    private long expire = 108000;
    private long responseCreateTime = System.currentTimeMillis();

    public int getActionBarStyle() {
        return this.actionBarStyle;
    }

    public List<MaterialMeta> getAdMaterials() {
        return this.adMaterials;
    }

    @Override // com.huawei.appgallery.agd.core.impl.store.carddata.ICommonInfo
    public int getAdSwitch() {
        return this.adSwitch;
    }

    public String getEngineerVersion() {
        return this.engineerVersion;
    }

    @Override // com.huawei.appgallery.agd.core.impl.store.carddata.ICommonInfo
    public long getExpireTimeStamp() {
        return this.responseCreateTime + (this.expire * 1000);
    }

    @Override // com.huawei.appgallery.agd.core.impl.store.carddata.ICommonInfo
    public String getPpsSlotId() {
        return this.ppsSlotId;
    }

    public int getStyleType() {
        return this.styleType;
    }

    public String getTabName() {
        return this.tabName;
    }

    @VisibleForTesting
    public void setAdMaterials(List<MaterialMeta> list) {
        this.adMaterials = list;
    }

    @VisibleForTesting
    public void setAdSwitch(int i10) {
        this.adSwitch = i10;
    }

    @VisibleForTesting
    public void setPpsSlotId(String str) {
        this.ppsSlotId = str;
    }
}

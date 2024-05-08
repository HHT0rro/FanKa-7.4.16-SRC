package com.wangmai.ad.dex.allmodules.bean;

import com.irisdt.StatConfig;
import com.wangmai.common.utils.PrivateInfoHelper;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
@Deprecated
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
public class SDKAdslotConfig {
    private int ackflowType;
    private PrivateInfoHelper.BeanInfo appPermissionConfig;
    private int fSdkAdPrompt;
    private int fSdkDownloadPopup;
    private int sdkInvokeFailRetry;
    private int sdkStrategyCacheTime;

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public enum DowLoadType {
        None(0, "不需要展示"),
        All(1, "需要展示");

        String desc;
        int type;

        DowLoadType(int i10, String str) {
            this.type = i10;
            this.desc = str;
        }

        public static DowLoadType valueOf(int i10) {
            for (int i11 = 0; i11 < values().length; i11++) {
                if (values()[i11].type == i10) {
                    return values()[i11];
                }
            }
            return null;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public enum Prompt {
        None(0, "不需要展示"),
        All(1, "全部区域点击"),
        CompatibleMode(2, "外部落地页,内部deeplink"),
        OnlyRegion(3, "只有区域点击才触发");

        String desc;
        int type;

        Prompt(int i10, String str) {
            this.type = i10;
            this.desc = str;
        }

        public static Prompt valueOf(int i10) {
            for (int i11 = 0; i11 < values().length; i11++) {
                if (values()[i11].type == i10) {
                    return values()[i11];
                }
            }
            return null;
        }
    }

    public int getAckflowType() {
        return this.ackflowType;
    }

    public PrivateInfoHelper.BeanInfo getAppPermissionConfig() {
        return this.appPermissionConfig;
    }

    public int getSdkInvokeFailRetry() {
        return this.sdkInvokeFailRetry;
    }

    public int getSdkStrategyCacheTime() {
        return this.sdkStrategyCacheTime;
    }

    public int getStrategyCacheTime() {
        int i10 = this.sdkStrategyCacheTime;
        if (i10 != -1) {
            return i10 != 0 ? i10 * 60 * 1000 : StatConfig.STAT_DAU_PERIOD;
        }
        return 0;
    }

    public int getfSdkAdPrompt() {
        return this.fSdkAdPrompt;
    }

    public Prompt getfSdkAdPromptEnum() {
        return Prompt.valueOf(this.fSdkAdPrompt);
    }

    public int getfSdkDownloadPopup() {
        return this.fSdkDownloadPopup;
    }

    public DowLoadType getfSdkDownloadPopupEnum() {
        return DowLoadType.valueOf(this.fSdkDownloadPopup);
    }

    public void setAckflowType(int i10) {
        this.ackflowType = i10;
    }

    public SDKAdslotConfig setAppPermissionConfig(PrivateInfoHelper.BeanInfo beanInfo) {
        this.appPermissionConfig = beanInfo;
        return this;
    }

    public void setSdkInvokeFailRetry(int i10) {
        this.sdkInvokeFailRetry = i10;
    }

    public void setSdkStrategyCacheTime(int i10) {
        this.sdkStrategyCacheTime = i10;
    }

    public void setfSdkAdPrompt(int i10) {
        this.fSdkAdPrompt = i10;
    }

    public void setfSdkDownloadPopup(int i10) {
        this.fSdkDownloadPopup = i10;
    }

    public String toString() {
        return "SDKAdslotConfig{ fSdkDownloadPopup=" + this.fSdkDownloadPopup + ", fSdkAdPrompt=" + this.fSdkAdPrompt + ", sdkStrategyCacheTime = " + this.sdkStrategyCacheTime + ", ackflowType=" + this.ackflowType + ", sdkInvokeFailRetry=" + this.sdkInvokeFailRetry + '}';
    }
}

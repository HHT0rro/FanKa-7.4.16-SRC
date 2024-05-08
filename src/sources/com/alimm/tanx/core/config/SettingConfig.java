package com.alimm.tanx.core.config;

import com.alibaba.fastjson.annotation.JSONField;
import java.io.Serializable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class SettingConfig implements Serializable {

    @JSONField(serialize = false)
    public static final int MAX_TITLE_SIZE = 16;

    @JSONField(serialize = false)
    public static final int MIN_TITLE_SIZE = 5;
    public boolean nightSwitch = false;
    public boolean customTitleSizeSwitch = false;
    public boolean customTitleSizeDpSwitch = true;
    public int customTitleSize = -1;

    @JSONField(serialize = false)
    public void clearTitleSize() {
        this.customTitleSizeSwitch = false;
        this.customTitleSizeDpSwitch = true;
        this.customTitleSize = -1;
    }

    public int getCustomTitleSize() {
        return this.customTitleSize;
    }

    @JSONField(serialize = false)
    @Deprecated
    public SettingConfig getNightConfig() {
        return this;
    }

    public boolean isCustomTitleSizeDpSwitch() {
        return this.customTitleSizeDpSwitch;
    }

    public boolean isCustomTitleSizeSwitch() {
        return this.customTitleSizeSwitch;
    }

    public boolean isNightSwitch() {
        return this.nightSwitch;
    }

    public void setCustomTitleSize(int i10) {
        this.customTitleSize = i10;
    }

    public void setCustomTitleSizeDpSwitch(boolean z10) {
        this.customTitleSizeDpSwitch = z10;
    }

    public void setCustomTitleSizeSwitch(boolean z10) {
        this.customTitleSizeSwitch = z10;
    }

    @JSONField(serialize = false)
    @Deprecated
    public SettingConfig setDefaultConfig() {
        return setDefaultConfig("", "");
    }

    @JSONField(serialize = false)
    @Deprecated
    public SettingConfig setDefaultConfig(String str, String str2) {
        return this;
    }

    @JSONField(serialize = false)
    @Deprecated
    public SettingConfig setNightConfig() {
        return setNightConfig("", "");
    }

    @JSONField(serialize = false)
    @Deprecated
    public SettingConfig setNightConfig(String str, String str2) {
        return this;
    }

    public void setNightSwitch(boolean z10) {
        this.nightSwitch = z10;
    }

    @JSONField(serialize = false)
    public void setTitleSize(int i10) {
        this.customTitleSizeSwitch = true;
        this.customTitleSizeDpSwitch = false;
        this.customTitleSize = i10;
        if (i10 < 5) {
            this.customTitleSize = 5;
        } else if (i10 > 16) {
            this.customTitleSize = 16;
        }
    }

    @JSONField(serialize = false)
    public void setTitleSizeDp(int i10) {
        this.customTitleSizeSwitch = true;
        this.customTitleSizeDpSwitch = true;
        this.customTitleSize = i10;
        if (i10 < 5) {
            this.customTitleSize = 5;
        } else if (i10 > 16) {
            this.customTitleSize = 16;
        }
    }
}

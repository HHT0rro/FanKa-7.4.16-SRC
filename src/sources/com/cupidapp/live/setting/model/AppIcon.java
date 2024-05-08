package com.cupidapp.live.setting.model;

import kotlin.d;
import org.jetbrains.annotations.NotNull;

/* compiled from: AppIcon.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public enum AppIcon {
    SystemIcon("FKStartupAliasActivity", "SystemIcon"),
    ClassicDiamond("FKStartupDiamondAliasActivity", "ClassicDiamond"),
    CardiacSignal("FKStartupCardiacAliasActivity", "CardiacSignal"),
    EnglishEdition("FKStartupEditionAliasActivity", "EnglishEdition"),
    LoveLaunch("FKStartupLoveLaunchAliasActivity", "LoveLaunch"),
    LoveIsLove("FKStartupLoveAliasActivity", "LoveIsLove");


    @NotNull
    private final String activityAliasName;

    @NotNull
    private final String value;

    AppIcon(String str, String str2) {
        this.activityAliasName = str;
        this.value = str2;
    }

    @NotNull
    public final String getActivityAliasName() {
        return this.activityAliasName;
    }

    @NotNull
    public final String getValue() {
        return this.value;
    }
}

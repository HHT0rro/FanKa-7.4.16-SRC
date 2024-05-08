package com.huawei.quickcard.cardmanager.bean;

import com.huawei.appgallery.agd.common.constant.SymbolValues;
import com.huawei.appgallery.agd.pageframe.api.CardConstants;
import com.huawei.quickcard.cardmanager.util.CardUriUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class CardMeta {

    /* renamed from: a, reason: collision with root package name */
    private String f33514a;

    /* renamed from: b, reason: collision with root package name */
    private int f33515b;

    /* renamed from: c, reason: collision with root package name */
    private int f33516c;

    /* renamed from: d, reason: collision with root package name */
    private String f33517d;

    /* renamed from: e, reason: collision with root package name */
    private String f33518e;

    public CardMeta(String str, int i10, int i11, String str2, String str3) {
        this.f33514a = str;
        this.f33515b = i10;
        this.f33516c = i11;
        this.f33517d = str2;
        this.f33518e = str3;
    }

    public String getCardId() {
        return this.f33514a;
    }

    public int getMinPlatformVersion() {
        return this.f33515b;
    }

    public String getSign() {
        return this.f33518e;
    }

    public String getType() {
        return this.f33517d;
    }

    public String getUri() {
        if ("combo".equals(this.f33517d)) {
            return "flayout://" + this.f33514a + SymbolValues.QUESTION_EN_SYMBOL + "ver=" + this.f33516c + "&" + CardUriUtils.PARAM_MIN_SDK_VER + "=" + this.f33515b;
        }
        return CardConstants.KEY_FAST_VIEW + this.f33514a + SymbolValues.QUESTION_EN_SYMBOL + "ver=" + this.f33516c + "&minPlatformVer=" + this.f33515b;
    }

    public int getVer() {
        return this.f33516c;
    }

    public void setCardId(String str) {
        this.f33514a = str;
    }

    public void setMinPlatformVersion(int i10) {
        this.f33515b = i10;
    }

    public void setSign(String str) {
        this.f33518e = str;
    }

    public void setType(String str) {
        this.f33517d = str;
    }

    public void setVer(int i10) {
        this.f33516c = i10;
    }
}

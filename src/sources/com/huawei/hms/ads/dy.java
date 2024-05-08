package com.huawei.hms.ads;

import android.text.TextUtils;
import com.huawei.hms.ads.RequestOptions;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class dy {
    public static RequestOptions Code(RequestOptions requestOptions) {
        RequestOptions I = j.Code().I();
        if (requestOptions == null) {
            return I;
        }
        RequestOptions.Builder builder = requestOptions.toBuilder();
        if (requestOptions.Z() == null) {
            builder.setAdContentClassification(I.getAdContentClassification());
        }
        if (requestOptions.getTagForUnderAgeOfPromise() == null) {
            builder.setTagForUnderAgeOfPromise(I.getTagForUnderAgeOfPromise());
        }
        if (requestOptions.getTagForChildProtection() == null) {
            builder.setTagForChildProtection(I.getTagForChildProtection());
        }
        if (requestOptions.getNonPersonalizedAd() == null) {
            builder.setNonPersonalizedAd(I.getNonPersonalizedAd());
        }
        if (requestOptions.Code() == null) {
            builder.setHwNonPersonalizedAd(I.Code());
        }
        if (requestOptions.V() == null) {
            builder.setThirdNonPersonalizedAd(I.V());
        }
        if (requestOptions.getAppLang() == null) {
            builder.setAppLang(I.getAppLang());
        }
        if (requestOptions.getAppCountry() == null) {
            builder.setAppCountry(I.getAppCountry());
        }
        if (requestOptions.getApp() == null) {
            builder.setApp(I.getApp());
        }
        if (TextUtils.isEmpty(requestOptions.getConsent())) {
            builder.setConsent(I.getConsent());
        }
        if (requestOptions.I() == null) {
            builder.setRequestLocation(I.I());
        }
        if (requestOptions.C() == null) {
            builder.setSearchInfo(I.C());
        }
        if (requestOptions.D() == null) {
            builder.setSupportFa(I.D());
        }
        return builder.build();
    }
}

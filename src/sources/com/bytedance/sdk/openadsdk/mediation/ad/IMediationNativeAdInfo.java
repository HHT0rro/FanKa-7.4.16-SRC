package com.bytedance.sdk.openadsdk.mediation.ad;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public interface IMediationNativeAdInfo {
    String getActionText();

    int getAdImageMode();

    String getDescription();

    MediationAdDislike getDislikeDialog(Activity activity);

    MediationAdDislike getDislikeDialog(Activity activity, Map<String, Object> map);

    String getIconUrl();

    List<String> getImageList();

    String getImageUrl();

    int getInteractionType();

    MediationNativeAdAppInfo getNativeAdAppInfo();

    String getSource();

    double getStarRating();

    String getTitle();

    boolean hasDislike();

    void registerView(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, IMediationViewBinder iMediationViewBinder);
}

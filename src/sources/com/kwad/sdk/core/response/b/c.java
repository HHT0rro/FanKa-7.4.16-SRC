package com.kwad.sdk.core.response.b;

import android.text.TextUtils;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class c {
    public static <R extends AdResultData, T extends AdTemplate> T a(R r10, String str) {
        if (r10 == null) {
            return null;
        }
        if (TextUtils.isEmpty(str)) {
            Iterator<AdTemplate> iterator2 = r10.getAdTemplateList().iterator2();
            while (iterator2.hasNext()) {
                T t2 = (T) iterator2.next();
                if (String.valueOf(e.dQ(t2).adBaseInfo.creativeId).equals(str)) {
                    return t2;
                }
            }
        }
        return (T) r10.getFirstAdTemplate();
    }

    public static AdResultData dB(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return null;
        }
        return adTemplate.createAdResultData();
    }

    public static <R extends AdResultData, T extends AdTemplate> T n(R r10) {
        if (r10 == null) {
            return null;
        }
        return (T) r10.getFirstAdTemplate();
    }

    public static <T extends AdResultData> AdResultData a(AdResultData adResultData, AdTemplate adTemplate) {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(adTemplate);
        AdResultData m2866clone = adResultData.m2866clone();
        m2866clone.setAdTemplateList(arrayList);
        return m2866clone;
    }
}

package com.huawei.appgallery.agd.core.impl;

import android.text.TextUtils;
import com.huawei.appgallery.agd.core.api.AdSlot;
import com.huawei.appgallery.agd.core.api.AgdAdConfig;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import n9.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class AgdAdManager {

    /* renamed from: a, reason: collision with root package name */
    public static final Map<String, IAgdAd> f27423a = new ConcurrentHashMap();

    /* renamed from: b, reason: collision with root package name */
    public static final Map<String, Set<String>> f27424b = new ConcurrentHashMap();

    /* renamed from: c, reason: collision with root package name */
    public static final Map<String, Set<String>> f27425c = new ConcurrentHashMap();

    /* renamed from: d, reason: collision with root package name */
    public static AgdAdConfig f27426d;

    /* renamed from: e, reason: collision with root package name */
    public static AdSlot f27427e;

    public static void addAd(IAgdAd iAgdAd) {
        if (iAgdAd == null || TextUtils.isEmpty(iAgdAd.getUniqueId())) {
            return;
        }
        f27423a.put(iAgdAd.getUniqueId(), iAgdAd);
    }

    public static AdSlot getActiveAdSlot() {
        return f27427e;
    }

    public static IAgdAd getAd(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return f27423a.get(str);
    }

    public static List<String> getAdIdList(String str) {
        if (TextUtils.isEmpty(str)) {
            return new ArrayList();
        }
        Set<String> set = f27425c.get(str);
        if (set != null && set.size() != 0) {
            ArrayList arrayList = new ArrayList(set);
            Collections.reverse(arrayList);
            return arrayList;
        }
        return new ArrayList();
    }

    public static List<IAgdAd> getAdListByPackage(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Set<String> set = f27424b.get(str);
        if (set == null || set.size() == 0) {
            return null;
        }
        Iterator<String> iterator2 = set.iterator2();
        while (iterator2.hasNext()) {
            IAgdAd ad2 = getAd(iterator2.next());
            if (ad2 != null) {
                arrayList.add(ad2);
            }
        }
        return arrayList;
    }

    public static AgdAdConfig getConfig() {
        return f27426d;
    }

    public static void init(AgdAdConfig agdAdConfig) {
        f27426d = agdAdConfig;
    }

    public static void putPackNameAndAdId(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        Map<String, Set<String>> map = f27424b;
        Set<String> set = map.get(str);
        if (set == null) {
            set = Collections.synchronizedSet(new HashSet());
        }
        set.add(str2);
        map.put(str, set);
    }

    public static void putSlotIdAndAdId(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        Map<String, Set<String>> map = f27425c;
        Set<String> set = map.get(str);
        if (set == null) {
            set = Collections.synchronizedSet(new LinkedHashSet());
        }
        set.add(str2);
        map.put(str, set);
    }

    public static void removeAd(String str) {
        a.f52175d.d("AgdAdManager", "remove ad id: " + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        f27423a.remove(str);
    }

    public static void removePackageAndUniqueIdMap(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        f27424b.remove(str);
    }

    public static void setActiveAdSlot(AdSlot adSlot) {
        f27427e = adSlot;
    }

    public void clear() {
    }
}

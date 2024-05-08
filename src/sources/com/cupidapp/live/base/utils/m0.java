package com.cupidapp.live.base.utils;

import android.content.Context;
import android.os.Build;
import com.cupidapp.live.base.network.gson.GsonUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.huawei.appgallery.agd.common.support.global.HomeCountryUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: RegionNodeUtils.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class m0 {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    public Map<String, RegionNodeModel> f12349a;

    /* compiled from: RegionNodeUtils.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a extends TypeToken<Map<String, ? extends RegionNodeModel>> {
    }

    public m0(@NotNull Context context) {
        Locale locale;
        kotlin.jvm.internal.s.i(context, "context");
        try {
            Gson b4 = GsonUtil.f12000a.b();
            if (Build.VERSION.SDK_INT >= 24) {
                locale = context.getResources().getConfiguration().getLocales().get(0);
            } else {
                locale = context.getResources().getConfiguration().locale;
            }
            this.f12349a = (Map) b4.fromJson(q0.g(context.getAssets().open(kotlin.jvm.internal.s.d(locale, Locale.TRADITIONAL_CHINESE) ? "regionCode/region_zh_TW.json" : "regionCode/region_zh_CN.json")), new a().getType());
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }

    @Nullable
    public final RegionNodeModel a(@Nullable String str) {
        RegionNodeModel regionNodeModel;
        Map<String, RegionNodeModel> regions;
        Map<String, RegionNodeModel> regions2;
        if (str == null) {
            return null;
        }
        List<String> z02 = StringsKt__StringsKt.z0(str, new String[]{"_"}, false, 0, 6, null);
        Map<String, RegionNodeModel> map = this.f12349a;
        RegionNodeModel regionNodeModel2 = map != null ? map.get(z02.get(0)) : null;
        if (kotlin.jvm.internal.s.d(z02.get(0), HomeCountryUtils.HomeCountry.CHINA_TAIWAN) || kotlin.jvm.internal.s.d(z02.get(0), "HK") || kotlin.jvm.internal.s.d(z02.get(0), "MO")) {
            Map<String, RegionNodeModel> map2 = this.f12349a;
            regionNodeModel2 = (map2 == null || (regionNodeModel = map2.get("CN")) == null || (regions = regionNodeModel.getRegions()) == null) ? null : regions.get(z02.get(0));
        }
        if (z02.size() == 1) {
            return regionNodeModel2;
        }
        int size = z02.size();
        int i10 = 1;
        while (i10 < size) {
            i10++;
            String c4 = q0.c("_", d(z02, i10));
            Map<String, RegionNodeModel> regions3 = regionNodeModel2 != null ? regionNodeModel2.getRegions() : null;
            if (!(regions3 == null || regions3.isEmpty())) {
                regionNodeModel2 = (regionNodeModel2 == null || (regions2 = regionNodeModel2.getRegions()) == null) ? null : regions2.get(c4);
            }
        }
        return regionNodeModel2;
    }

    @Nullable
    public final List<String> b(@NotNull String code, int i10) {
        kotlin.jvm.internal.s.i(code, "code");
        ArrayList arrayList = new ArrayList();
        RegionNodeModel a10 = a(code);
        if (a10 != null) {
            String abbr = a10.getAbbr();
            if (!(abbr == null || abbr.length() == 0)) {
                String abbr2 = a10.getAbbr();
                kotlin.jvm.internal.s.f(abbr2);
                arrayList.add(abbr2);
            } else {
                arrayList.add(a10.getName());
            }
            String[] codes = q0.h(code, "_");
            int min = Math.min(i10, codes.length - 1);
            for (int i11 = 0; i11 < min; i11++) {
                kotlin.jvm.internal.s.h(codes, "codes");
                String c4 = q0.c("_", d(kotlin.collections.m.M(codes), min - i11));
                kotlin.jvm.internal.s.h(c4, "join(\"_\", subArray(codes.toList(), max - i))");
                RegionNodeModel a11 = a(c4);
                if (a11 != null) {
                    String abbr3 = a11.getAbbr();
                    if (!(abbr3 == null || abbr3.length() == 0)) {
                        String abbr4 = a11.getAbbr();
                        kotlin.jvm.internal.s.f(abbr4);
                        arrayList.add(abbr4);
                    } else {
                        arrayList.add(a11.getName());
                    }
                }
            }
        }
        return arrayList;
    }

    @Nullable
    public final Map<String, RegionNodeModel> c() {
        return this.f12349a;
    }

    public final List<String> d(List<String> list, int i10) {
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < i10; i11++) {
            arrayList.add(list.get(i11));
        }
        return arrayList;
    }
}

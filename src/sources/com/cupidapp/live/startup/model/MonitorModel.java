package com.cupidapp.live.startup.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.collections.t;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ApiAdModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MonitorModel {

    @Nullable
    private final List<String> click_urls;

    @Nullable
    private final List<String> impress_urls;

    @Nullable
    private final List<String> start_urls;

    @Nullable
    private final String win_notice_url;

    public MonitorModel(@Nullable List<String> list, @Nullable List<String> list2, @Nullable List<String> list3, @Nullable String str) {
        this.click_urls = list;
        this.impress_urls = list2;
        this.start_urls = list3;
        this.win_notice_url = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MonitorModel copy$default(MonitorModel monitorModel, List list, List list2, List list3, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = monitorModel.click_urls;
        }
        if ((i10 & 2) != 0) {
            list2 = monitorModel.impress_urls;
        }
        if ((i10 & 4) != 0) {
            list3 = monitorModel.start_urls;
        }
        if ((i10 & 8) != 0) {
            str = monitorModel.win_notice_url;
        }
        return monitorModel.copy(list, list2, list3, str);
    }

    @Nullable
    public final List<String> component1() {
        return this.click_urls;
    }

    @Nullable
    public final List<String> component2() {
        return this.impress_urls;
    }

    @Nullable
    public final List<String> component3() {
        return this.start_urls;
    }

    @Nullable
    public final String component4() {
        return this.win_notice_url;
    }

    @NotNull
    public final MonitorModel copy(@Nullable List<String> list, @Nullable List<String> list2, @Nullable List<String> list3, @Nullable String str) {
        return new MonitorModel(list, list2, list3, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MonitorModel)) {
            return false;
        }
        MonitorModel monitorModel = (MonitorModel) obj;
        return s.d(this.click_urls, monitorModel.click_urls) && s.d(this.impress_urls, monitorModel.impress_urls) && s.d(this.start_urls, monitorModel.start_urls) && s.d(this.win_notice_url, monitorModel.win_notice_url);
    }

    @Nullable
    public final List<String> getClick_urls() {
        return this.click_urls;
    }

    @Nullable
    public final List<String> getImpress_urls() {
        return this.impress_urls;
    }

    @Nullable
    public final List<String> getRealClickUrl(int i10, int i11, @Nullable Integer num, @Nullable Integer num2, @Nullable Integer num3, @Nullable Integer num4) {
        long currentTimeMillis = System.currentTimeMillis();
        List<String> list = this.click_urls;
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(t.t(list, 10));
        for (String str : list) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("__WIDTH__", String.valueOf(i10));
            linkedHashMap.put("__HEIGHT__", String.valueOf(i11));
            linkedHashMap.put("__DOWN_X__", String.valueOf(num));
            linkedHashMap.put("__DOWN_Y__", String.valueOf(num2));
            linkedHashMap.put("__UP_X__", String.valueOf(num3));
            linkedHashMap.put("__UP_Y__", String.valueOf(num4));
            linkedHashMap.put("__TS__", String.valueOf(currentTimeMillis));
            linkedHashMap.put("__TIMESTAMP__", String.valueOf(currentTimeMillis / 1000));
            arrayList.add(z0.t.i(str, linkedHashMap));
        }
        return arrayList;
    }

    @Nullable
    public final List<String> getRealImpressUrl(int i10, int i11) {
        long currentTimeMillis = System.currentTimeMillis();
        List<String> list = this.impress_urls;
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(t.t(list, 10));
        for (String str : list) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("__WIDTH__", String.valueOf(i10));
            linkedHashMap.put("__HEIGHT__", String.valueOf(i11));
            linkedHashMap.put("__TS__", String.valueOf(currentTimeMillis));
            linkedHashMap.put("__TIMESTAMP__", String.valueOf(currentTimeMillis / 1000));
            arrayList.add(z0.t.i(str, linkedHashMap));
        }
        return arrayList;
    }

    @Nullable
    public final List<String> getStart_urls() {
        return this.start_urls;
    }

    @Nullable
    public final String getWin_notice_url() {
        return this.win_notice_url;
    }

    public int hashCode() {
        List<String> list = this.click_urls;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        List<String> list2 = this.impress_urls;
        int hashCode2 = (hashCode + (list2 == null ? 0 : list2.hashCode())) * 31;
        List<String> list3 = this.start_urls;
        int hashCode3 = (hashCode2 + (list3 == null ? 0 : list3.hashCode())) * 31;
        String str = this.win_notice_url;
        return hashCode3 + (str != null ? str.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        List<String> list = this.click_urls;
        List<String> list2 = this.impress_urls;
        List<String> list3 = this.start_urls;
        return "MonitorModel(click_urls=" + ((Object) list) + ", impress_urls=" + ((Object) list2) + ", start_urls=" + ((Object) list3) + ", win_notice_url=" + this.win_notice_url + ")";
    }
}

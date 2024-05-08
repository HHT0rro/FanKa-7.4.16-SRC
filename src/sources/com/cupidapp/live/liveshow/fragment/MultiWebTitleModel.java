package com.cupidapp.live.liveshow.fragment;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: FKLiveShowRankWebFragment.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class MultiWebTitleModel implements Serializable {

    @NotNull
    private final Map<String, String> titleMap;
    private final boolean viewpagerCanScroll;

    public MultiWebTitleModel() {
        this(null, false, 3, 0 == true ? 1 : 0);
    }

    public MultiWebTitleModel(@NotNull Map<String, String> titleMap, boolean z10) {
        s.i(titleMap, "titleMap");
        this.titleMap = titleMap;
        this.viewpagerCanScroll = z10;
    }

    public final boolean getViewpagerCanScroll() {
        return this.viewpagerCanScroll;
    }

    @NotNull
    public final List<String> getWebTitles() {
        Map<String, String> map = this.titleMap;
        ArrayList arrayList = new ArrayList(map.size());
        Iterator<Map.Entry<String, String>> iterator2 = map.entrySet().iterator2();
        while (iterator2.hasNext()) {
            arrayList.add(iterator2.next().getKey());
        }
        return CollectionsKt___CollectionsKt.z0(arrayList);
    }

    @NotNull
    public final List<String> getWebUrls() {
        Map<String, String> map = this.titleMap;
        ArrayList arrayList = new ArrayList(map.size());
        Iterator<Map.Entry<String, String>> iterator2 = map.entrySet().iterator2();
        while (iterator2.hasNext()) {
            arrayList.add(iterator2.next().getValue());
        }
        return CollectionsKt___CollectionsKt.z0(arrayList);
    }

    public /* synthetic */ MultiWebTitleModel(Map map, boolean z10, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? new LinkedHashMap() : map, (i10 & 2) != 0 ? true : z10);
    }
}

package com.bytedance.sdk.openadsdk.ej.m.m;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.DislikeInfo;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.PersonalizationPrompt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import o0.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class l implements DislikeInfo {

    /* renamed from: m, reason: collision with root package name */
    private final Bridge f11188m;

    public l(Bridge bridge) {
        this.f11188m = bridge == null ? a.f52239c : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.DislikeInfo
    public List<FilterWord> getFilterWords() {
        Iterable iterable = (List) this.f11188m.values().objectValue(243001, List.class);
        if (iterable == null) {
            iterable = new ArrayList(0);
        }
        ArrayList arrayList = new ArrayList();
        Iterator iterator2 = iterable.iterator2();
        while (iterator2.hasNext()) {
            arrayList.add(new n((Bridge) iterator2.next()));
        }
        return arrayList;
    }

    @Override // com.bytedance.sdk.openadsdk.DislikeInfo
    public PersonalizationPrompt getPersonalizationPrompt() {
        return new hc((Bridge) this.f11188m.values().objectValue(243002, Bridge.class));
    }
}

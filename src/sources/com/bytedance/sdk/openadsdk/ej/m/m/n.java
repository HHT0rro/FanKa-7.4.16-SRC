package com.bytedance.sdk.openadsdk.ej.m.m;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.FilterWord;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import o0.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class n implements Bridge, FilterWord {
    private FilterWord dk;

    /* renamed from: m, reason: collision with root package name */
    private final Bridge f11197m;

    public n(FilterWord filterWord) {
        this.dk = filterWord;
        this.f11197m = a.f52239c;
    }

    @Override // com.bytedance.sdk.openadsdk.FilterWord
    public void addOption(FilterWord filterWord) {
        a c4 = a.c(1);
        c4.h(0, new n(filterWord));
        this.f11197m.call(241101, c4.a(), Void.class);
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i10, ValueSet valueSet, Class<T> cls) {
        FilterWord filterWord = this.dk;
        if (filterWord == null) {
            return null;
        }
        switch (i10) {
            case 241101:
                this.dk.addOption(new n((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
            case 241102:
                this.dk.setIsSelected(valueSet.booleanValue(0));
                break;
            case 241103:
                return (T) filterWord.getId();
            case 241104:
                return (T) filterWord.getName();
            case 241105:
                return (T) Boolean.class.cast(Boolean.valueOf(filterWord.getIsSelected()));
            case 241106:
                return (T) Boolean.class.cast(Boolean.valueOf(filterWord.hasSecondOptions()));
            case 241107:
                return (T) Boolean.class.cast(Boolean.valueOf(filterWord.isValid()));
            case 241108:
                return (T) filterWord.getOptions();
        }
        m(i10, valueSet, cls);
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.FilterWord
    public String getId() {
        return (String) this.f11197m.call(241103, a.c(0).a(), String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.FilterWord
    public boolean getIsSelected() {
        return ((Boolean) this.f11197m.call(241105, a.c(0).a(), Boolean.TYPE)).booleanValue();
    }

    @Override // com.bytedance.sdk.openadsdk.FilterWord
    public String getName() {
        return (String) this.f11197m.call(241104, a.c(0).a(), String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.FilterWord
    public List<FilterWord> getOptions() {
        Iterable iterable = (List) this.f11197m.call(241108, a.c(0).a(), List.class);
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

    @Override // com.bytedance.sdk.openadsdk.FilterWord
    public boolean hasSecondOptions() {
        return ((Boolean) this.f11197m.call(241106, a.c(0).a(), Boolean.TYPE)).booleanValue();
    }

    @Override // com.bytedance.sdk.openadsdk.FilterWord
    public boolean isValid() {
        return ((Boolean) this.f11197m.call(241107, a.c(0).a(), Boolean.TYPE)).booleanValue();
    }

    public void m(int i10, ValueSet valueSet, Class cls) {
    }

    @Override // com.bytedance.sdk.openadsdk.FilterWord
    public void setIsSelected(boolean z10) {
        a c4 = a.c(1);
        c4.j(0, z10);
        this.f11197m.call(241102, c4.a(), Void.class);
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return a.f52238b;
    }

    public n(Bridge bridge) {
        this.f11197m = bridge == null ? a.f52239c : bridge;
    }
}

package com.tencent.bugly.idasc.proguard;

import com.huawei.appgallery.agd.common.constant.SymbolValues;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
class c {

    /* renamed from: a, reason: collision with root package name */
    public HashMap<String, HashMap<String, byte[]>> f39868a = new HashMap<>();

    /* renamed from: b, reason: collision with root package name */
    public HashMap<String, Object> f39869b = new HashMap<>();

    /* renamed from: e, reason: collision with root package name */
    private HashMap<String, Object> f39872e = new HashMap<>();

    /* renamed from: c, reason: collision with root package name */
    public String f39870c = "GBK";

    /* renamed from: d, reason: collision with root package name */
    public k f39871d = new k();

    private static void a(ArrayList<String> arrayList, Object obj) {
        while (true) {
            if (obj.getClass().isArray()) {
                if (!obj.getClass().getComponentType().toString().equals("byte")) {
                    throw new IllegalArgumentException("only byte[] is supported");
                }
                if (Array.getLength(obj) <= 0) {
                    arrayList.add("Array");
                    arrayList.add(SymbolValues.QUESTION_EN_SYMBOL);
                    return;
                } else {
                    arrayList.add("java.util.List");
                    obj = Array.get(obj, 0);
                }
            } else {
                if (obj instanceof Array) {
                    throw new IllegalArgumentException("can not support Array, please use List");
                }
                if (obj instanceof List) {
                    arrayList.add("java.util.List");
                    List list = (List) obj;
                    if (list.size() <= 0) {
                        arrayList.add(SymbolValues.QUESTION_EN_SYMBOL);
                        return;
                    }
                    obj = list.get(0);
                } else {
                    if (!(obj instanceof Map)) {
                        arrayList.add(obj.getClass().getName());
                        return;
                    }
                    arrayList.add("java.util.Map");
                    Map map = (Map) obj;
                    if (map.size() <= 0) {
                        arrayList.add(SymbolValues.QUESTION_EN_SYMBOL);
                        arrayList.add(SymbolValues.QUESTION_EN_SYMBOL);
                        return;
                    } else {
                        Object next = map.h().iterator2().next();
                        obj = map.get(next);
                        arrayList.add(next.getClass().getName());
                    }
                }
            }
        }
    }

    public void a(String str) {
        this.f39870c = str;
    }

    public <T> void a(String str, T t2) {
        if (str == null) {
            throw new IllegalArgumentException("put key can not is null");
        }
        if (t2 == null) {
            throw new IllegalArgumentException("put value can not is null");
        }
        if (t2 instanceof Set) {
            throw new IllegalArgumentException("can not support Set");
        }
        l lVar = new l();
        lVar.a(this.f39870c);
        lVar.a(t2, 0);
        byte[] a10 = n.a(lVar.f39901a);
        HashMap<String, byte[]> hashMap = new HashMap<>(1);
        ArrayList arrayList = new ArrayList(1);
        a((ArrayList<String>) arrayList, t2);
        hashMap.put(a.a(arrayList), a10);
        this.f39872e.remove(str);
        this.f39868a.put(str, hashMap);
    }

    public void a(byte[] bArr) {
        this.f39871d.a(bArr);
        this.f39871d.a(this.f39870c);
        HashMap hashMap = new HashMap(1);
        HashMap hashMap2 = new HashMap(1);
        hashMap2.put("", new byte[0]);
        hashMap.put("", hashMap2);
        this.f39868a = this.f39871d.a((Map) hashMap, 0, false);
    }

    public byte[] a() {
        l lVar = new l(0);
        lVar.a(this.f39870c);
        lVar.a((Map) this.f39868a, 0);
        return n.a(lVar.f39901a);
    }
}

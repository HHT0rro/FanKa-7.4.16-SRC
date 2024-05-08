package com.tencent.turingcam;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class wmqhz extends SkEpO {

    /* renamed from: a, reason: collision with root package name */
    public static ArrayList<Bi3eT> f45471a;

    /* renamed from: b, reason: collision with root package name */
    public static Map<String, String> f45472b;

    /* renamed from: c, reason: collision with root package name */
    public ArrayList<Bi3eT> f45473c = null;

    /* renamed from: d, reason: collision with root package name */
    public Map<String, String> f45474d = null;

    static {
        ArrayList<Bi3eT> arrayList = new ArrayList<>();
        f45471a = arrayList;
        arrayList.add(new Bi3eT());
        HashMap hashMap = new HashMap();
        f45472b = hashMap;
        hashMap.put("", "");
    }

    @Override // com.tencent.turingcam.SkEpO
    public void a(ShGzN shGzN) {
        shGzN.a("", 0);
        shGzN.a((Collection) this.f45473c, 1);
        Map<String, String> map = this.f45474d;
        if (map != null) {
            shGzN.a((Map) map, 2);
        }
    }
}

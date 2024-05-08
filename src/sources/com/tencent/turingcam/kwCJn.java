package com.tencent.turingcam;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class kwCJn extends SkEpO {

    /* renamed from: a, reason: collision with root package name */
    public static ArrayList<Bi3eT> f45439a;

    /* renamed from: b, reason: collision with root package name */
    public static byte[] f45440b;

    /* renamed from: c, reason: collision with root package name */
    public static Map<String, String> f45441c;

    /* renamed from: d, reason: collision with root package name */
    public String f45442d = "";

    /* renamed from: e, reason: collision with root package name */
    public ArrayList<Bi3eT> f45443e = null;

    /* renamed from: f, reason: collision with root package name */
    public byte[] f45444f = null;

    /* renamed from: g, reason: collision with root package name */
    public Map<String, String> f45445g = null;

    /* renamed from: h, reason: collision with root package name */
    public SWw7W f45446h = null;

    /* renamed from: i, reason: collision with root package name */
    public String f45447i = "";

    static {
        ArrayList<Bi3eT> arrayList = new ArrayList<>();
        f45439a = arrayList;
        arrayList.add(new Bi3eT());
        f45440b = r0;
        byte[] bArr = {0};
        HashMap hashMap = new HashMap();
        f45441c = hashMap;
        hashMap.put("", "");
    }

    @Override // com.tencent.turingcam.SkEpO
    public void a(ShGzN shGzN) {
        shGzN.a(this.f45442d, 0);
        shGzN.a((Collection) this.f45443e, 1);
        shGzN.a(this.f45444f, 2);
        Map<String, String> map = this.f45445g;
        if (map != null) {
            shGzN.a((Map) map, 3);
        }
        SWw7W sWw7W = this.f45446h;
        if (sWw7W != null) {
            shGzN.a((SkEpO) sWw7W, 4);
        }
        String str = this.f45447i;
        if (str != null) {
            shGzN.a(str, 5);
        }
        shGzN.a(0, 6);
    }
}

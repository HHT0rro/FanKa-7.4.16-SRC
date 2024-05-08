package com.tencent.turingcam;

import java.util.ArrayList;
import java.util.Collection;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class B9LVG extends SkEpO {

    /* renamed from: a, reason: collision with root package name */
    public static ArrayList<Bi3eT> f45382a;

    /* renamed from: b, reason: collision with root package name */
    public static byte[] f45383b;

    /* renamed from: c, reason: collision with root package name */
    public String f45384c = "";

    /* renamed from: d, reason: collision with root package name */
    public ArrayList<Bi3eT> f45385d = null;

    /* renamed from: e, reason: collision with root package name */
    public byte[] f45386e = null;

    /* renamed from: f, reason: collision with root package name */
    public SWw7W f45387f = null;

    static {
        ArrayList<Bi3eT> arrayList = new ArrayList<>();
        f45382a = arrayList;
        arrayList.add(new Bi3eT());
        f45383b = r0;
        byte[] bArr = {0};
    }

    @Override // com.tencent.turingcam.SkEpO
    public void a(ShGzN shGzN) {
        shGzN.a(this.f45384c, 0);
        shGzN.a((Collection) this.f45385d, 1);
        byte[] bArr = this.f45386e;
        if (bArr != null) {
            shGzN.a(bArr, 2);
        }
        SWw7W sWw7W = this.f45387f;
        if (sWw7W != null) {
            shGzN.a((SkEpO) sWw7W, 3);
        }
    }
}

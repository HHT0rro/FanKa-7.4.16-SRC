package com.tencent.cloud.huiyansdkface.a.b;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static a f40317a = new a() { // from class: com.tencent.cloud.huiyansdkface.a.b.b.1
        @Override // com.tencent.cloud.huiyansdkface.a.b.a
        public void a(c cVar) {
            String.format("camera exception: type=%s,msg=%s", cVar.c(), cVar.getMessage());
            cVar.printStackTrace();
        }
    };

    /* renamed from: b, reason: collision with root package name */
    private static a f40318b;

    public static void a(a aVar) {
        f40318b = aVar;
    }

    public static void a(c cVar) {
        a aVar = f40318b;
        if (aVar != null) {
            aVar.a(cVar);
        } else if (cVar != null) {
            cVar.printStackTrace();
        }
    }
}

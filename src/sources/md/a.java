package md;

import java.util.Map;

/* compiled from: UserTracker.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class a implements uc.a {

    /* renamed from: a, reason: collision with root package name */
    public static uc.a f51990a;

    public a(uc.a aVar) {
        f51990a = aVar;
    }

    @Override // uc.a
    public void a(String str, int i10, Object obj, Object obj2, Object obj3, Map<String, Object> map) {
        try {
            uc.a aVar = f51990a;
            if (aVar != null) {
                aVar.a(str, i10, obj, obj2, obj3, map);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}

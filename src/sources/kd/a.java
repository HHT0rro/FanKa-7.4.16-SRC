package kd;

import rc.b;

/* compiled from: AlarmMonitor.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class a implements tc.a {

    /* renamed from: a, reason: collision with root package name */
    public tc.a f50878a;

    /* compiled from: AlarmMonitor.java */
    /* renamed from: kd.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class C0773a {

        /* renamed from: a, reason: collision with root package name */
        public static a f50879a = new a();
    }

    @Override // tc.a
    public void a(String str, String str2, String str3, String str4, String str5) {
        b.d(str, str2, str3, str4, str5);
        tc.a aVar = this.f50878a;
        if (aVar != null) {
            aVar.a(str, str2, str3, str4, str5);
        }
    }

    @Override // tc.a
    public void b(String str, String str2, String str3) {
        b.d("KeyMonitor", str, str2, str3);
        tc.a aVar = this.f50878a;
        if (aVar != null) {
            aVar.b(str, str2, str3);
        }
    }
}

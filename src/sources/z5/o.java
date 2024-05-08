package z5;

/* compiled from: UtcTimingElement.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    public final String f54975a;

    /* renamed from: b, reason: collision with root package name */
    public final String f54976b;

    public o(String str, String str2) {
        this.f54975a = str;
        this.f54976b = str2;
    }

    public String toString() {
        String str = this.f54975a;
        String str2 = this.f54976b;
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 2 + String.valueOf(str2).length());
        sb2.append(str);
        sb2.append(", ");
        sb2.append(str2);
        return sb2.toString();
    }
}

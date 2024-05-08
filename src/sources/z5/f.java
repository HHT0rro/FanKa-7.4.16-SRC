package z5;

import com.google.android.exoplayer2.metadata.emsg.EventMessage;

/* compiled from: EventStream.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final EventMessage[] f54917a;

    /* renamed from: b, reason: collision with root package name */
    public final long[] f54918b;

    /* renamed from: c, reason: collision with root package name */
    public final String f54919c;

    /* renamed from: d, reason: collision with root package name */
    public final String f54920d;

    /* renamed from: e, reason: collision with root package name */
    public final long f54921e;

    public f(String str, String str2, long j10, long[] jArr, EventMessage[] eventMessageArr) {
        this.f54919c = str;
        this.f54920d = str2;
        this.f54921e = j10;
        this.f54918b = jArr;
        this.f54917a = eventMessageArr;
    }

    public String a() {
        String str = this.f54919c;
        String str2 = this.f54920d;
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 1 + String.valueOf(str2).length());
        sb2.append(str);
        sb2.append("/");
        sb2.append(str2);
        return sb2.toString();
    }
}

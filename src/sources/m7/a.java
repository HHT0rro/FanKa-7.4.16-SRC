package m7;

import android.net.Uri;
import com.google.android.gms.common.api.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a.g<k7.b> f51935a;

    /* renamed from: b, reason: collision with root package name */
    public static final a.AbstractC0213a<k7.b, Object> f51936b;

    /* renamed from: c, reason: collision with root package name */
    @Deprecated
    public static final com.google.android.gms.common.api.a<Object> f51937c;

    /* renamed from: d, reason: collision with root package name */
    @Deprecated
    public static final g f51938d;

    /* JADX WARN: Type inference failed for: r0v1, types: [m7.g, k7.a] */
    static {
        a.g<k7.b> gVar = new a.g<>();
        f51935a = gVar;
        f fVar = new f();
        f51936b = fVar;
        f51937c = new com.google.android.gms.common.api.a<>("Phenotype.API", fVar, gVar);
        f51938d = new k7.a();
    }

    public static Uri a(String str) {
        String valueOf = String.valueOf(Uri.encode(str));
        return Uri.parse(valueOf.length() != 0 ? "content://com.google.android.gms.phenotype/".concat(valueOf) : new String("content://com.google.android.gms.phenotype/"));
    }
}

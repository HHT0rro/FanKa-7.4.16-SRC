package z8;

import android.content.Context;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public String f55033a;

    /* renamed from: c, reason: collision with root package name */
    public InputStream f55035c;

    /* renamed from: b, reason: collision with root package name */
    public b f55034b = b.f55027b;

    /* renamed from: d, reason: collision with root package name */
    public final Map<String, String> f55036d = new HashMap();

    /* renamed from: e, reason: collision with root package name */
    public final List<c9.a> f55037e = new ArrayList();

    public d a(Context context) {
        return new b9.c(context, this.f55033a, this.f55034b, this.f55035c, this.f55036d, this.f55037e, null);
    }

    public e b(InputStream inputStream) {
        this.f55035c = inputStream;
        return this;
    }
}

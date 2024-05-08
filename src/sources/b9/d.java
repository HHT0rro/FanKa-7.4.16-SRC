package b9;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.apache.commons.io.IOUtils;
import z8.f;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class d extends a9.a {

    /* renamed from: c, reason: collision with root package name */
    public final Context f1425c;

    /* renamed from: d, reason: collision with root package name */
    public final String f1426d;

    /* renamed from: e, reason: collision with root package name */
    public volatile a9.c f1427e;

    /* renamed from: f, reason: collision with root package name */
    public final Object f1428f = new Object();

    /* renamed from: g, reason: collision with root package name */
    public z8.b f1429g = z8.b.f55027b;

    /* renamed from: h, reason: collision with root package name */
    public final Map<String, String> f1430h = new HashMap();

    /* renamed from: i, reason: collision with root package name */
    public volatile f f1431i;

    public d(Context context, String str) {
        this.f1425c = context;
        this.f1426d = str;
    }

    public static String d(String str) {
        int i10 = 0;
        if (str.length() > 0) {
            while (str.charAt(i10) == '/') {
                i10++;
            }
        }
        return IOUtils.DIR_SEPARATOR_UNIX + str.substring(i10);
    }

    @Override // z8.d
    public z8.b a() {
        if (this.f1429g == null) {
            this.f1429g = z8.b.f55027b;
        }
        z8.b bVar = this.f1429g;
        z8.b bVar2 = z8.b.f55027b;
        if (bVar == bVar2 && this.f1427e == null) {
            e();
        }
        z8.b bVar3 = this.f1429g;
        return bVar3 == null ? bVar2 : bVar3;
    }

    public final void e() {
        if (this.f1427e == null) {
            synchronized (this.f1428f) {
                if (this.f1427e == null) {
                    this.f1427e = new n(this.f1425c, this.f1426d);
                    this.f1431i = new f(this.f1427e);
                }
                g();
            }
        }
    }

    public final String f(String str) {
        f.a aVar;
        Map<String, f.a> a10 = z8.f.a();
        if (a10.containsKey(str) && (aVar = a10.get(str)) != null) {
            return aVar.a(this);
        }
        return null;
    }

    public final void g() {
        if (this.f1429g != z8.b.f55027b || this.f1427e == null) {
            return;
        }
        this.f1429g = b.f(this.f1427e.getString("/region", null), this.f1427e.getString("/agcgw/url", null));
    }

    @Override // z8.d
    public Context getContext() {
        return this.f1425c;
    }

    @Override // z8.d
    public String getIdentifier() {
        return "DEFAULT_INSTANCE";
    }

    @Override // z8.d
    public String getString(String str) {
        return h(str, null);
    }

    public String h(String str, String str2) {
        Objects.requireNonNull(str, "path must not be null.");
        if (this.f1427e == null) {
            e();
        }
        String d10 = d(str);
        String str3 = this.f1430h.get(d10);
        if (str3 != null) {
            return str3;
        }
        String f10 = f(d10);
        if (f10 != null) {
            return f10;
        }
        String string = this.f1427e.getString(d10, str2);
        return f.b(string) ? this.f1431i.decrypt(string, str2) : string;
    }
}

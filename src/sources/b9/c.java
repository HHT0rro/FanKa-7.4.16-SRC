package b9;

import android.content.Context;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
import z8.f;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class c implements z8.d {

    /* renamed from: a, reason: collision with root package name */
    public final String f1416a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f1417b;

    /* renamed from: c, reason: collision with root package name */
    public final String f1418c;

    /* renamed from: d, reason: collision with root package name */
    public final z8.b f1419d;

    /* renamed from: e, reason: collision with root package name */
    public final a9.c f1420e;

    /* renamed from: f, reason: collision with root package name */
    public final f f1421f;

    /* renamed from: g, reason: collision with root package name */
    public final Map<String, String> f1422g;

    /* renamed from: h, reason: collision with root package name */
    public final List<c9.a> f1423h;

    /* renamed from: i, reason: collision with root package name */
    public final Map<String, String> f1424i = new HashMap();

    public c(Context context, String str, z8.b bVar, InputStream inputStream, Map<String, String> map, List<c9.a> list, String str2) {
        context = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        this.f1417b = context;
        str = str == null ? context.getPackageName() : str;
        this.f1418c = str;
        if (inputStream != null) {
            this.f1420e = new j(inputStream, str);
            b.a(inputStream);
        } else {
            this.f1420e = new n(context, str);
        }
        this.f1421f = new f(this.f1420e);
        z8.b bVar2 = z8.b.f55027b;
        if (bVar != bVar2 && "1.0".equals(this.f1420e.getString("/configuration_version", null))) {
            throw new RuntimeException("The file version does not match,please download the latest agconnect-services.json from the AGC website.");
        }
        this.f1419d = (bVar == null || bVar == bVar2) ? b.f(this.f1420e.getString("/region", null), this.f1420e.getString("/agcgw/url", null)) : bVar;
        this.f1422g = b.d(map);
        this.f1423h = list;
        this.f1416a = str2 == null ? d() : str2;
    }

    @Override // z8.d
    public z8.b a() {
        z8.b bVar = this.f1419d;
        return bVar == null ? z8.b.f55027b : bVar;
    }

    public final String b(String str) {
        Map<String, f.a> a10 = z8.f.a();
        if (!a10.containsKey(str)) {
            return null;
        }
        if (this.f1424i.containsKey(str)) {
            return this.f1424i.get(str);
        }
        f.a aVar = a10.get(str);
        if (aVar == null) {
            return null;
        }
        String a11 = aVar.a(this);
        this.f1424i.put(str, a11);
        return a11;
    }

    public List<c9.a> c() {
        return this.f1423h;
    }

    public final String d() {
        return String.valueOf(("{packageName='" + this.f1418c + "', routePolicy=" + ((Object) this.f1419d) + ", reader=" + this.f1420e.toString().hashCode() + ", customConfigMap=" + new JSONObject(this.f1422g).toString().hashCode() + '}').hashCode());
    }

    public String e(String str, String str2) {
        if (str == null) {
            return str2;
        }
        String e2 = b.e(str);
        String str3 = this.f1422g.get(e2);
        if (str3 != null) {
            return str3;
        }
        String b4 = b(e2);
        if (b4 != null) {
            return b4;
        }
        String string = this.f1420e.getString(e2, str2);
        return f.b(string) ? this.f1421f.decrypt(string, str2) : string;
    }

    @Override // z8.d
    public Context getContext() {
        return this.f1417b;
    }

    @Override // z8.d
    public String getIdentifier() {
        return this.f1416a;
    }

    @Override // z8.d
    public String getString(String str) {
        return e(str, null);
    }
}

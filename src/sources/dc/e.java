package dc;

import android.content.Context;
import com.inno.innosdk.pb.InnoMain;
import java.lang.reflect.Method;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public Context f48681a;

    /* renamed from: b, reason: collision with root package name */
    public Class f48682b;

    /* renamed from: c, reason: collision with root package name */
    public Object f48683c;

    /* renamed from: d, reason: collision with root package name */
    public Method f48684d;

    /* renamed from: e, reason: collision with root package name */
    public Method f48685e;

    /* renamed from: f, reason: collision with root package name */
    public Method f48686f;

    /* renamed from: g, reason: collision with root package name */
    public Method f48687g;

    public e(Context context) {
        this.f48681a = context;
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            this.f48682b = cls;
            this.f48683c = cls.newInstance();
        } catch (Exception unused) {
        }
        try {
            this.f48684d = this.f48682b.getMethod("getDefaultUDID", Context.class);
        } catch (Exception unused2) {
        }
        try {
            this.f48685e = this.f48682b.getMethod("getOAID", Context.class);
        } catch (Exception unused3) {
        }
        try {
            this.f48686f = this.f48682b.getMethod("getVAID", Context.class);
        } catch (Exception unused4) {
        }
        try {
            this.f48687g = this.f48682b.getMethod("getAAID", Context.class);
        } catch (Exception unused5) {
        }
    }

    public String a() {
        try {
            String b4 = b(this.f48681a, this.f48685e);
            bc.a.b(this.f48681a, "XIAOMI", InnoMain.INNO_KEY_OAID, b4);
            return b4;
        } catch (Exception unused) {
            return "";
        }
    }

    public final String b(Context context, Method method) {
        Object obj = this.f48683c;
        if (obj == null || method == null) {
            return "";
        }
        try {
            String str = (String) method.invoke(obj, context);
            return str == null ? "" : str;
        } catch (Exception unused) {
            return "";
        }
    }
}

package xc;

import android.content.Context;
import com.tanx.onlyid.api.OAIDException;
import java.lang.reflect.InvocationTargetException;

/* compiled from: XiaomiImpl.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class q implements wc.d {

    /* renamed from: a, reason: collision with root package name */
    public final Context f54655a;

    /* renamed from: b, reason: collision with root package name */
    public Class<?> f54656b;

    /* renamed from: c, reason: collision with root package name */
    public Object f54657c;

    public q(Context context) {
        this.f54655a = context;
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            this.f54656b = cls;
            this.f54657c = cls.newInstance();
        } catch (Exception e2) {
            wc.f.a(e2);
        }
    }

    @Override // wc.d
    public void a(wc.c cVar) {
        if (this.f54655a == null || cVar == null) {
            return;
        }
        if (this.f54656b != null && this.f54657c != null) {
            try {
                String b4 = b();
                if (b4 != null && b4.length() != 0) {
                    wc.f.a("OAID query success: " + b4);
                    cVar.oaidSucc(b4);
                    return;
                }
                throw new OAIDException("OAID query failed");
            } catch (Exception e2) {
                wc.f.a(e2);
                cVar.oaidError(e2);
                return;
            }
        }
        cVar.oaidError(new OAIDException("Xiaomi IdProvider not exists"));
    }

    public final String b() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        return (String) this.f54656b.getMethod("getOAID", Context.class).invoke(this.f54657c, this.f54655a);
    }

    @Override // wc.d
    public boolean supported() {
        return this.f54657c != null;
    }
}

package ec;

import android.content.Context;
import com.weibo.ssosdk.oaid.OAIDException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class k implements cc.c {

    /* renamed from: a, reason: collision with root package name */
    public final Context f49018a;

    /* renamed from: b, reason: collision with root package name */
    public Class<?> f49019b;

    /* renamed from: c, reason: collision with root package name */
    public Object f49020c;

    public k(Context context) {
        this.f49018a = context;
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            this.f49019b = cls;
            this.f49020c = cls.newInstance();
        } catch (Exception unused) {
        }
    }

    @Override // cc.c
    public void a(cc.b bVar) {
        if (this.f49019b != null && this.f49020c != null) {
            try {
                String b4 = b();
                if (b4 != null && b4.length() != 0) {
                    bVar.onOAIDGetComplete(b4);
                    return;
                }
                throw new OAIDException("OAID query failed");
            } catch (Exception e2) {
                bVar.onOAIDGetError(e2);
                return;
            }
        }
        bVar.onOAIDGetError(new OAIDException("Xiaomi IdProvider not exists"));
    }

    public final String b() {
        return (String) this.f49019b.getMethod("getOAID", Context.class).invoke(this.f49020c, this.f49018a);
    }

    @Override // cc.c
    public boolean supported() {
        return this.f49020c != null;
    }
}

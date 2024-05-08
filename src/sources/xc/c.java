package xc;

import android.app.KeyguardManager;
import android.content.Context;
import com.tanx.onlyid.api.OAIDException;
import java.util.Objects;

/* compiled from: CooseaImpl.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class c implements wc.d {

    /* renamed from: a, reason: collision with root package name */
    public final Context f54630a;

    /* renamed from: b, reason: collision with root package name */
    public final KeyguardManager f54631b;

    public c(Context context) {
        this.f54630a = context;
        this.f54631b = (KeyguardManager) context.getSystemService("keyguard");
    }

    @Override // wc.d
    public void a(wc.c cVar) {
        if (this.f54630a == null || cVar == null) {
            return;
        }
        KeyguardManager keyguardManager = this.f54631b;
        if (keyguardManager == null) {
            cVar.oaidError(new OAIDException("KeyguardManager not found"));
            return;
        }
        try {
            Object invoke = keyguardManager.getClass().getDeclaredMethod("obtainOaid", new Class[0]).invoke(this.f54631b, new Object[0]);
            if (invoke != null) {
                String obj = invoke.toString();
                wc.f.a("OAID obtain success: " + obj);
                cVar.oaidSucc(obj);
                return;
            }
            throw new OAIDException("OAID obtain failed");
        } catch (Exception e2) {
            wc.f.a(e2);
        }
    }

    @Override // wc.d
    public boolean supported() {
        KeyguardManager keyguardManager;
        if (this.f54630a == null || (keyguardManager = this.f54631b) == null) {
            return false;
        }
        try {
            Object invoke = keyguardManager.getClass().getDeclaredMethod("isSupported", new Class[0]).invoke(this.f54631b, new Object[0]);
            Objects.requireNonNull(invoke);
            return ((Boolean) invoke).booleanValue();
        } catch (Exception e2) {
            wc.f.a(e2);
            return false;
        }
    }
}

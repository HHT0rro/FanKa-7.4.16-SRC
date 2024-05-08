package xc;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import com.tanx.onlyid.api.OAIDException;

/* compiled from: NubiaImpl.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class k implements wc.d {

    /* renamed from: a, reason: collision with root package name */
    public final Context f54644a;

    public k(Context context) {
        this.f54644a = context;
    }

    @Override // wc.d
    public void a(wc.c cVar) {
        if (this.f54644a == null || cVar == null) {
            return;
        }
        if (!supported()) {
            wc.f.a("Only supports Android 10.0 and above for Nubia");
            cVar.oaidError(new OAIDException("Only supports Android 10.0 and above for Nubia"));
            return;
        }
        try {
            ContentProviderClient acquireContentProviderClient = this.f54644a.getContentResolver().acquireContentProviderClient(Uri.parse("content://cn.nubia.identity/identity"));
            if (acquireContentProviderClient == null) {
                return;
            }
            Bundle call = acquireContentProviderClient.call("getOAID", null, null);
            if (Build.VERSION.SDK_INT >= 24) {
                acquireContentProviderClient.close();
            } else {
                acquireContentProviderClient.release();
            }
            if (call != null) {
                String string = call.getInt("code", -1) == 0 ? call.getString("id") : null;
                if (string != null && string.length() != 0) {
                    wc.f.a("OAID query success: " + string);
                    cVar.oaidSucc(string);
                    return;
                }
                throw new OAIDException("OAID query failed: " + call.getString("message"));
            }
            throw new OAIDException("OAID query failed: bundle is null");
        } catch (Exception e2) {
            wc.f.a(e2);
            cVar.oaidError(e2);
        }
    }

    @Override // wc.d
    public boolean supported() {
        return Build.VERSION.SDK_INT >= 29;
    }
}

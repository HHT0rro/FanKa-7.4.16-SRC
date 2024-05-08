package ec;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import com.weibo.ssosdk.oaid.OAIDException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class e implements cc.c {

    /* renamed from: a, reason: collision with root package name */
    public final Context f49007a;

    public e(Context context) {
        this.f49007a = context;
    }

    @Override // cc.c
    public void a(cc.b bVar) {
        if (!supported()) {
            bVar.onOAIDGetError(new OAIDException("Only supports Android 10.0 and above for Nubia"));
            return;
        }
        try {
            ContentProviderClient acquireContentProviderClient = this.f49007a.getContentResolver().acquireContentProviderClient(Uri.parse("content://cn.nubia.identity/identity"));
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
                    bVar.onOAIDGetComplete(string);
                    return;
                } else {
                    throw new OAIDException("OAID query failed: " + call.getString("message"));
                }
            }
            throw new OAIDException("OAID query failed: bundle is null");
        } catch (Exception e2) {
            bVar.onOAIDGetError(e2);
        }
    }

    @Override // cc.c
    public boolean supported() {
        return Build.VERSION.SDK_INT >= 28;
    }
}

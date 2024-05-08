package xc;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import com.tanx.onlyid.api.OAIDException;
import java.util.Objects;

/* compiled from: VivoImpl.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class p implements wc.d {

    /* renamed from: a, reason: collision with root package name */
    public final Context f54654a;

    public p(Context context) {
        this.f54654a = context;
    }

    @Override // wc.d
    public void a(wc.c cVar) {
        if (this.f54654a == null || cVar == null) {
            return;
        }
        try {
            Cursor query = this.f54654a.getContentResolver().query(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), null, null, null, null);
            try {
                Objects.requireNonNull(query);
                query.moveToFirst();
                String string = query.getString(query.getColumnIndex("value"));
                if (string != null && string.length() != 0) {
                    wc.f.a("OAID query success: " + string);
                    cVar.oaidSucc(string);
                    query.close();
                    return;
                }
                throw new OAIDException("OAID query failed");
            } finally {
            }
        } catch (Exception e2) {
            wc.f.a(e2);
            cVar.oaidError(e2);
        }
    }

    @Override // wc.d
    public boolean supported() {
        if (Build.VERSION.SDK_INT < 28) {
            return false;
        }
        return wc.g.a("persist.sys.identifierid.supported", "0").equals("1");
    }
}

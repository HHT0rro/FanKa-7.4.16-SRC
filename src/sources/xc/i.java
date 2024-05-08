package xc;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.inno.innosdk.pb.InnoMain;
import com.tanx.onlyid.api.OAIDException;
import java.util.Objects;

/* compiled from: MeizuImpl.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class i implements wc.d {

    /* renamed from: a, reason: collision with root package name */
    public final Context f54641a;

    public i(Context context) {
        this.f54641a = context;
    }

    @Override // wc.d
    public void a(wc.c cVar) {
        if (this.f54641a == null || cVar == null) {
            return;
        }
        try {
            Cursor query = this.f54641a.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{InnoMain.INNO_KEY_OAID}, null);
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
        Context context = this.f54641a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().resolveContentProvider("com.meizu.flyme.openidsdk", 0) != null;
        } catch (Exception e2) {
            wc.f.a(e2);
            return false;
        }
    }
}

package ec;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.weibo.ssosdk.oaid.OAIDException;
import java.util.Objects;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class j implements cc.c {

    /* renamed from: a, reason: collision with root package name */
    public final Context f49017a;

    public j(Context context) {
        this.f49017a = context;
    }

    @Override // cc.c
    public void a(cc.b bVar) {
        try {
            Cursor query = this.f49017a.getContentResolver().query(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), null, null, null, null);
            Objects.requireNonNull(query);
            query.moveToFirst();
            String string = query.getString(query.getColumnIndex("value"));
            if (string != null && string.length() != 0) {
                bVar.onOAIDGetComplete(string);
                return;
            }
            throw new OAIDException("OAID query failed");
        } catch (Exception e2) {
            bVar.onOAIDGetError(e2);
        }
    }

    @Override // cc.c
    public boolean supported() {
        return cc.d.o("persist.sys.identifierid.supported", "0").equals("1");
    }
}

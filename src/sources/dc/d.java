package dc;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.inno.innosdk.pb.InnoMain;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public Context f48678a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f48679b = false;

    /* renamed from: c, reason: collision with root package name */
    public String f48680c = null;

    public d(Context context) {
        this.f48678a = context;
    }

    public String a() {
        Cursor query = this.f48678a.getContentResolver().query(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), null, null, null, null);
        String str = "";
        if (query != null) {
            if (query.moveToNext()) {
                str = query.getString(query.getColumnIndex("value"));
                bc.a.b(this.f48678a, "VIVO", InnoMain.INNO_KEY_OAID, str);
            }
            query.close();
        }
        return str;
    }
}

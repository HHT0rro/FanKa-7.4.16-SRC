package ec;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.inno.innosdk.pb.InnoMain;
import com.weibo.ssosdk.oaid.OAIDException;
import java.util.Objects;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class d implements cc.c {

    /* renamed from: a, reason: collision with root package name */
    public final Context f49006a;

    public d(Context context) {
        this.f49006a = context;
    }

    @Override // cc.c
    public void a(cc.b bVar) {
        try {
            Cursor query = this.f49006a.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{InnoMain.INNO_KEY_OAID}, null);
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
        try {
            return this.f49006a.getPackageManager().resolveContentProvider("com.meizu.flyme.openidsdk", 0) != null;
        } catch (Exception unused) {
            return false;
        }
    }
}

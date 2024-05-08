package com.hailiang.advlib.open.oaid.hla;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.hailiang.advlib.open.oaid.OAIDException;
import com.inno.innosdk.pb.InnoMain;
import java.util.Objects;

/* compiled from: MeizuImpl.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class d implements com.hailiang.advlib.open.oaid.b {

    /* renamed from: a, reason: collision with root package name */
    public final Context f27183a;

    public d(Context context) {
        this.f27183a = context;
    }

    @Override // com.hailiang.advlib.open.oaid.b
    public boolean a() {
        Context context = this.f27183a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().resolveContentProvider("com.meizu.flyme.openidsdk", 0) != null;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.hailiang.advlib.open.oaid.b
    public void a(com.hailiang.advlib.open.oaid.a aVar) {
        if (this.f27183a == null || aVar == null) {
            return;
        }
        try {
            Cursor query = this.f27183a.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{InnoMain.INNO_KEY_OAID}, null);
            try {
                Objects.requireNonNull(query);
                query.moveToFirst();
                String string = query.getString(query.getColumnIndex("value"));
                if (string != null && string.length() != 0) {
                    aVar.a(string);
                    query.close();
                    return;
                }
                throw new OAIDException("OAID query failed");
            } finally {
            }
        } catch (Exception e2) {
            aVar.a(e2);
        }
    }
}

package com.hailiang.advlib.open.oaid.hla;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import com.hailiang.advlib.open.oaid.OAIDException;
import java.util.Objects;

/* compiled from: VivoImpl.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class j implements com.hailiang.advlib.open.oaid.b {

    /* renamed from: a, reason: collision with root package name */
    public final Context f27195a;

    public j(Context context) {
        this.f27195a = context;
    }

    @Override // com.hailiang.advlib.open.oaid.b
    public boolean a() {
        if (Build.VERSION.SDK_INT < 28) {
            return false;
        }
        return com.hailiang.advlib.open.oaid.c.a("persist.sys.identifierid.supported", "0").equals("1");
    }

    @Override // com.hailiang.advlib.open.oaid.b
    public void a(com.hailiang.advlib.open.oaid.a aVar) {
        if (this.f27195a == null || aVar == null) {
            return;
        }
        try {
            Cursor query = this.f27195a.getContentResolver().query(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), null, null, null, null);
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

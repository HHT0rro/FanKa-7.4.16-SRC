package com.kwad.sdk.core.report;

import android.content.Context;
import android.database.Cursor;
import androidx.annotation.NonNull;
import com.kwad.sdk.service.ServiceProvider;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class q extends d {
    private static volatile q ayU;
    private o ayV;

    private q(Context context) {
        super(new p(context, p.IP));
        this.ayV = new i();
    }

    public static q bf(Context context) {
        if (ayU == null) {
            synchronized (q.class) {
                if (ayU == null) {
                    ayU = new q(context);
                }
            }
        }
        return ayU;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.report.d
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public synchronized n g(@NonNull Cursor cursor) {
        String string = cursor.getString(0);
        String string2 = cursor.getString(1);
        if (((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).yS()) {
            return this.ayV.Z(string2, string);
        }
        return this.ayV.Z(string2, string);
    }

    @Override // com.kwad.sdk.core.report.d
    public final String EG() {
        return "ksad_actions";
    }

    @Override // com.kwad.sdk.core.report.d
    public final String EH() {
        return "select aLog, actionId from " + EG();
    }

    @Override // com.kwad.sdk.core.report.d
    public final String getTag() {
        return "ReportActionDBManager";
    }
}

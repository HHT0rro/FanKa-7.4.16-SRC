package com.kwad.sdk.crash.online.monitor.block.report;

import android.content.Context;
import android.database.Cursor;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.e.c;
import com.kwad.sdk.core.report.d;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class a extends d {
    public static int IP = 1;
    private static volatile a aGN;

    private a(Context context) {
        super(new com.kwad.sdk.crash.online.monitor.block.a.a(context, IP));
    }

    public static a bw(Context context) {
        if (aGN == null) {
            synchronized (a.class) {
                if (aGN == null) {
                    aGN = new a(context);
                }
            }
        }
        return aGN;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.report.d
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public synchronized BlockReportAction g(@NonNull Cursor cursor) {
        try {
        } catch (JSONException e2) {
            c.printStackTrace(e2);
            return new BlockReportAction("");
        }
        return new BlockReportAction(new JSONObject(cursor.getString(0)));
    }

    @Override // com.kwad.sdk.core.report.d
    public final String EG() {
        return "ksad_block_actions";
    }

    @Override // com.kwad.sdk.core.report.d
    public final String EH() {
        return "select aLog from " + EG();
    }

    @Override // com.kwad.sdk.core.report.d
    public final String getTag() {
        return "perfMonitor.BlockReportDBManager";
    }
}

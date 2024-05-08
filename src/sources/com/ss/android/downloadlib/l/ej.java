package com.ss.android.downloadlib.l;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.alimm.tanx.core.ad.event.track.expose.ExposeManager;
import com.ss.android.downloadlib.addownload.c;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class ej {
    private static volatile ej dk;

    /* renamed from: m, reason: collision with root package name */
    private SQLiteDatabase f38786m;

    private ej() {
        try {
            this.f38786m = new dk(c.getContext()).getWritableDatabase();
        } catch (Throwable th) {
            com.ss.android.downloadlib.np.ej.m().m(th, "ClickEventHelper");
        }
    }

    public static ej m() {
        if (dk == null) {
            synchronized (ej.class) {
                if (dk == null) {
                    dk = new ej();
                }
            }
        }
        return dk;
    }

    public boolean dk() {
        return DownloadSetting.obtainGlobal().optInt("click_event_switch", 0) == 1;
    }

    public boolean ej() {
        return DownloadSetting.obtainGlobal().optInt("click_event_switch", 0) == 2;
    }

    private void ej(long j10, String str) {
        SQLiteDatabase sQLiteDatabase = this.f38786m;
        if (sQLiteDatabase == null || !sQLiteDatabase.isOpen() || j10 <= 0 || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            String optString = new JSONObject(str).optString(ExposeManager.UtArgsNames.reqId);
            if (TextUtils.isEmpty(optString)) {
                return;
            }
            this.f38786m.delete("click_event", "time < ? AND ad_id = ? AND req_id = ?", new String[]{String.valueOf(System.currentTimeMillis() - 1209600000), String.valueOf(j10), optString});
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public boolean dk(long j10, String str) {
        SQLiteDatabase sQLiteDatabase = this.f38786m;
        if (sQLiteDatabase == null || !sQLiteDatabase.isOpen() || j10 <= 0 || TextUtils.isEmpty(str)) {
            return false;
        }
        Cursor cursor = null;
        try {
            try {
                String optString = new JSONObject(str).optString(ExposeManager.UtArgsNames.reqId);
                if (TextUtils.isEmpty(optString)) {
                    return false;
                }
                cursor = this.f38786m.query("click_event", dk.f38785m, "time > ? AND ad_id = ? AND req_id = ?", new String[]{String.valueOf(System.currentTimeMillis() - 1209600000), String.valueOf(j10), optString}, null, null, null, null);
                boolean z10 = cursor.getCount() > 0;
                cursor.close();
                return z10;
            } catch (Exception e2) {
                e2.printStackTrace();
                if (cursor != null) {
                    cursor.close();
                }
                return false;
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public void m(long j10, String str) {
        String optString;
        SQLiteDatabase sQLiteDatabase = this.f38786m;
        if (sQLiteDatabase == null || !sQLiteDatabase.isOpen() || j10 <= 0 || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            optString = new JSONObject(str).optString(ExposeManager.UtArgsNames.reqId);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (TextUtils.isEmpty(optString)) {
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("ad_id", Long.valueOf(j10));
        contentValues.put(ExposeManager.UtArgsNames.reqId, optString);
        contentValues.put("time", Long.valueOf(System.currentTimeMillis()));
        this.f38786m.insert("click_event", null, contentValues);
        ej(j10, str);
    }
}

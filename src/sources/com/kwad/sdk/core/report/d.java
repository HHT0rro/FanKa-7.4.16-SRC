package com.kwad.sdk.core.report;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public abstract class d implements l<e> {
    private static boolean axx;
    public c axy;

    public d(c cVar) {
        a(cVar);
    }

    private void a(c cVar) {
        this.axy = cVar;
    }

    private synchronized void c(e eVar) {
        if (axx) {
            getTag();
            new StringBuilder("deleteAction action = ").append((Object) eVar);
        }
        try {
            this.axy.getReadableDatabase().delete(EG(), "actionId=?", new String[]{eVar.actionId});
        } catch (Exception e2) {
            com.kwad.sdk.core.e.c.printStackTrace(e2);
        }
    }

    public abstract String EG();

    public abstract String EH();

    @Override // com.kwad.sdk.core.report.l
    public final synchronized List<e> EI() {
        try {
            try {
                String EH = EH();
                r0 = TextUtils.isEmpty(EH) ? null : this.axy.getReadableDatabase().rawQuery(EH, null);
                if (r0 != null) {
                    ArrayList<e> arrayList = new ArrayList();
                    while (r0.moveToNext()) {
                        try {
                            arrayList.add(g(r0));
                        } catch (Exception e2) {
                            com.kwad.sdk.core.e.c.printStackTrace(e2);
                        }
                    }
                    if (axx) {
                        getTag();
                        new StringBuilder("read size= ").append(arrayList.size());
                        for (e eVar : arrayList) {
                            getTag();
                            new StringBuilder("read action=").append((Object) eVar);
                        }
                    }
                    return arrayList;
                }
            } finally {
                com.kwad.sdk.crash.utils.b.closeQuietly(r0);
            }
        } catch (Exception e10) {
            com.kwad.sdk.core.e.c.printStackTrace(e10);
        }
        return new ArrayList();
    }

    @Override // com.kwad.sdk.core.report.l
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final synchronized void j(e eVar) {
        if (axx) {
            getTag();
            new StringBuilder("write = ").append((Object) eVar);
        }
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("actionId", eVar.actionId);
            contentValues.put("aLog", eVar.toJson().toString());
            try {
                this.axy.getReadableDatabase().insert(EG(), null, contentValues);
            } catch (Exception e2) {
                com.kwad.sdk.core.e.c.printStackTrace(e2);
            }
        } catch (Exception e10) {
            com.kwad.sdk.core.e.c.printStackTrace(e10);
        }
    }

    public abstract e g(@NonNull Cursor cursor);

    public abstract String getTag();

    @Override // com.kwad.sdk.core.report.l
    public final synchronized long size() {
        long j10;
        Cursor cursor = null;
        try {
            cursor = this.axy.getReadableDatabase().rawQuery("select count(*) from " + EG(), null);
            cursor.moveToFirst();
            j10 = cursor.getLong(0);
        } catch (Exception e2) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(e2);
            j10 = 0;
        } finally {
            com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
        }
        return j10;
    }

    @Override // com.kwad.sdk.core.report.l
    public final synchronized void x(List<e> list) {
        if (axx) {
            getTag();
            new StringBuilder("delete size= ").append(list.size());
        }
        SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                sQLiteDatabase = this.axy.getReadableDatabase();
                sQLiteDatabase.beginTransaction();
                Iterator<e> iterator2 = list.iterator2();
                while (iterator2.hasNext()) {
                    c(iterator2.next());
                }
                sQLiteDatabase.setTransactionSuccessful();
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Exception e2) {
                    com.kwad.sdk.core.e.c.printStackTrace(e2);
                }
            } catch (Exception e10) {
                com.kwad.sdk.core.e.c.printStackTrace(e10);
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (Exception e11) {
                        com.kwad.sdk.core.e.c.printStackTrace(e11);
                    }
                }
            }
        } finally {
        }
    }
}

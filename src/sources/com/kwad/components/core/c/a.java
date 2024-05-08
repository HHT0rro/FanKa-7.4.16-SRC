package com.kwad.components.core.c;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.service.ServiceProvider;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class a {
    private static volatile a IO;
    private final SQLiteDatabase IN;

    /* renamed from: com.kwad.components.core.c.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class C0451a extends SQLiteOpenHelper {
        private static int IP = 1;
        private String IQ;
        private String IR;

        public C0451a(@Nullable Context context) {
            super(context, "ksadcache.db", (SQLiteDatabase.CursorFactory) null, IP);
            this.IQ = "CREATE TABLE IF NOT EXISTS ksad_ad_cache (creativeId VARCHAR PRIMARY KEY NOT NULL, posId TEXT, adJson TEXT, ecpm INTEGER, playAgainJson TEXT, adSenseJson TEXT, createTime INTEGER, expireTime INTEGER)";
            this.IR = "CREATE TABLE IF NOT EXISTS ksad_ad_cache_strategy(posId VARCHAR PRIMARY KEY NOT NULL, cacheSize INTEGER, cacheSecond INTEGER, strategyCode INTEGER, enable INTEGER)";
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onCreate(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL(this.IQ);
            sQLiteDatabase.execSQL(this.IR);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        }
    }

    private a(Context context) {
        this.IN = new C0451a(context).getWritableDatabase();
    }

    private <T extends i> void b(List<T> list, String str) {
        try {
            try {
                this.IN.beginTransaction();
                Iterator<T> iterator2 = list.iterator2();
                while (iterator2.hasNext()) {
                    try {
                        com.kwad.sdk.core.e.c.d("AdCacheDBManager", "insertData: " + str + ", rowId: " + this.IN.insertWithOnConflict(str, null, iterator2.next().mD(), 5));
                    } catch (Exception e2) {
                        com.kwad.sdk.core.e.c.printStackTrace(e2);
                    }
                }
                this.IN.setTransactionSuccessful();
                SQLiteDatabase sQLiteDatabase = this.IN;
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (Exception e10) {
                        com.kwad.sdk.core.e.c.printStackTrace(e10);
                    }
                }
            } catch (Exception e11) {
                com.kwad.sdk.core.e.c.printStackTrace(e11);
                SQLiteDatabase sQLiteDatabase2 = this.IN;
                if (sQLiteDatabase2 != null) {
                    try {
                        sQLiteDatabase2.endTransaction();
                    } catch (Exception e12) {
                        com.kwad.sdk.core.e.c.printStackTrace(e12);
                    }
                }
            }
        } catch (Throwable th) {
            SQLiteDatabase sQLiteDatabase3 = this.IN;
            if (sQLiteDatabase3 != null) {
                try {
                    sQLiteDatabase3.endTransaction();
                } catch (Exception e13) {
                    com.kwad.sdk.core.e.c.printStackTrace(e13);
                }
            }
            throw th;
        }
    }

    @Nullable
    public static a mu() {
        if (IO == null) {
            synchronized (a.class) {
                if (IO == null) {
                    try {
                        IO = new a(ServiceProvider.KO());
                    } catch (SQLiteException e2) {
                        com.kwad.sdk.core.e.c.printStackTraceOnly(e2);
                        IO = null;
                    }
                }
            }
        }
        return IO;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v4, types: [java.io.Closeable] */
    @WorkerThread
    public final e X(String str) {
        Throwable th;
        Cursor cursor;
        try {
            try {
                cursor = this.IN.rawQuery("select  * from ksad_ad_cache_strategy where posId=?", new String[]{str});
            } catch (Exception e2) {
                e = e2;
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
                str = 0;
                com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) str);
                throw th;
            }
            try {
                List<e> a10 = e.a(cursor);
                if (a10 != null && a10.size() > 0) {
                    e eVar = a10.get(0);
                    com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
                    return eVar;
                }
            } catch (Exception e10) {
                e = e10;
                com.kwad.sdk.core.e.c.printStackTraceOnly(e);
                com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
                return null;
            }
            com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
            return null;
        } catch (Throwable th3) {
            th = th3;
            com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) str);
            throw th;
        }
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0096: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:44:0x0096 */
    @Nullable
    @WorkerThread
    public final List<h> a(String str, long j10, int i10) {
        Cursor cursor;
        Closeable closeable;
        Closeable closeable2 = null;
        try {
            try {
                cursor = this.IN.rawQuery("select  * from ksad_ad_cache where posId=? order by createTime desc", new String[]{str});
            } catch (Exception e2) {
                e = e2;
                cursor = null;
            } catch (Throwable th) {
                th = th;
                com.kwad.sdk.crash.utils.b.closeQuietly(closeable2);
                throw th;
            }
            try {
                List<h> a10 = h.a(cursor);
                if (a10 == null) {
                    com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
                    return null;
                }
                StringBuilder sb2 = new StringBuilder("(posId = " + str + ") AND (");
                ArrayList arrayList = new ArrayList();
                int i11 = 0;
                for (h hVar : a10) {
                    i11++;
                    if (i11 > i10) {
                        sb2.append(" creativeId = ");
                        sb2.append(hVar.mM());
                        if (i11 == a10.size()) {
                            sb2.append(")");
                        } else {
                            sb2.append(" OR");
                        }
                    } else if (hVar.mK() >= j10) {
                        arrayList.add(hVar);
                    }
                }
                if (i11 > i10) {
                    this.IN.delete("ksad_ad_cache", sb2.toString(), new String[0]);
                }
                com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
                return arrayList;
            } catch (Exception e10) {
                e = e10;
                com.kwad.sdk.core.e.c.printStackTraceOnly(e);
                com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
                return null;
            }
        } catch (Throwable th2) {
            th = th2;
            closeable2 = closeable;
            com.kwad.sdk.crash.utils.b.closeQuietly(closeable2);
            throw th;
        }
    }

    @WorkerThread
    public final void i(List<h> list) {
        b(list, "ksad_ad_cache");
    }

    @WorkerThread
    public final void mv() {
        try {
            this.IN.delete("ksad_ad_cache", "expireTime<?", new String[]{String.valueOf(System.currentTimeMillis() / 1000)});
        } catch (Exception e2) {
            com.kwad.sdk.core.e.c.printStackTrace(e2);
        }
    }

    @WorkerThread
    public final void r(long j10) {
        try {
            com.kwad.sdk.core.e.c.d("AdCacheDBManager", "deleteCachedAdByCreativeId result: " + this.IN.delete("ksad_ad_cache", "creativeId=?", new String[]{String.valueOf(j10)}));
        } catch (Exception e2) {
            com.kwad.sdk.core.e.c.printStackTrace(e2);
        }
    }

    public final void a(e eVar) {
        b(Collections.singletonList(eVar), "ksad_ad_cache_strategy");
    }
}

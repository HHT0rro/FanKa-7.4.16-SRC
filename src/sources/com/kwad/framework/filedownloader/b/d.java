package com.kwad.framework.filedownloader.b;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.kwad.framework.filedownloader.b.a;
import com.kwad.framework.filedownloader.f.f;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import wseemann.media.FFmpegMediaMetadataRetriever;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class d implements com.kwad.framework.filedownloader.b.a {
    private static boolean afx;
    private final e afy = new e(com.kwad.framework.filedownloader.f.c.wL());
    private SQLiteDatabase afz;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class a implements a.InterfaceC0495a {
        private final SparseArray<com.kwad.framework.filedownloader.d.c> afA = new SparseArray<>();
        private b afB;
        private final SparseArray<com.kwad.framework.filedownloader.d.c> afn;
        private final SparseArray<List<com.kwad.framework.filedownloader.d.a>> afo;

        public a(SparseArray<com.kwad.framework.filedownloader.d.c> sparseArray, SparseArray<List<com.kwad.framework.filedownloader.d.a>> sparseArray2) {
            this.afn = sparseArray;
            this.afo = sparseArray2;
        }

        @Override // com.kwad.framework.filedownloader.b.a.InterfaceC0495a
        public final void a(int i10, com.kwad.framework.filedownloader.d.c cVar) {
            this.afA.put(i10, cVar);
        }

        @Override // com.kwad.framework.filedownloader.b.a.InterfaceC0495a
        public final void c(com.kwad.framework.filedownloader.d.c cVar) {
            SparseArray<com.kwad.framework.filedownloader.d.c> sparseArray = this.afn;
            if (sparseArray != null) {
                synchronized (sparseArray) {
                    this.afn.put(cVar.getId(), cVar);
                }
            }
        }

        @Override // java.lang.Iterable
        /* renamed from: iterator */
        public final Iterator<com.kwad.framework.filedownloader.d.c> iterator2() {
            b bVar = new b();
            this.afB = bVar;
            return bVar;
        }

        @Override // com.kwad.framework.filedownloader.b.a.InterfaceC0495a
        public final void vg() {
            b bVar = this.afB;
            if (bVar != null) {
                bVar.vg();
            }
            try {
                SQLiteDatabase vh = d.this.vh();
                if (vh == null) {
                    return;
                }
                int size = this.afA.size();
                try {
                    if (size < 0) {
                        return;
                    }
                    try {
                        vh.beginTransaction();
                        for (int i10 = 0; i10 < size; i10++) {
                            int keyAt = this.afA.keyAt(i10);
                            com.kwad.framework.filedownloader.d.c cVar = this.afA.get(keyAt);
                            vh.delete("ksad_file_download", "_id = ?", new String[]{String.valueOf(keyAt)});
                            vh.insert("ksad_file_download", null, cVar.wj());
                            if (cVar.wo() > 1) {
                                List<com.kwad.framework.filedownloader.d.a> bl = d.this.bl(keyAt);
                                if (bl.size() > 0) {
                                    vh.delete("ksad_file_download_connection", "id = ?", new String[]{String.valueOf(keyAt)});
                                    for (com.kwad.framework.filedownloader.d.a aVar : bl) {
                                        aVar.setId(cVar.getId());
                                        vh.insert("ksad_file_download_connection", null, aVar.wj());
                                    }
                                }
                            }
                        }
                        SparseArray<com.kwad.framework.filedownloader.d.c> sparseArray = this.afn;
                        if (sparseArray != null && this.afo != null) {
                            synchronized (sparseArray) {
                                int size2 = this.afn.size();
                                for (int i11 = 0; i11 < size2; i11++) {
                                    int id2 = this.afn.valueAt(i11).getId();
                                    List<com.kwad.framework.filedownloader.d.a> bl2 = d.this.bl(id2);
                                    if (bl2 != null && bl2.size() > 0) {
                                        synchronized (this.afo) {
                                            this.afo.put(id2, bl2);
                                        }
                                    }
                                }
                            }
                        }
                        vh.setTransactionSuccessful();
                        try {
                            vh.endTransaction();
                        } catch (Exception e2) {
                            d.printStackTrace(e2);
                        }
                    } catch (SQLiteException e10) {
                        d.this.a(e10);
                        try {
                            vh.endTransaction();
                        } catch (Exception e11) {
                            d.printStackTrace(e11);
                        }
                    } catch (Exception e12) {
                        d.printStackTrace(e12);
                        try {
                            vh.endTransaction();
                        } catch (Exception e13) {
                            d.printStackTrace(e13);
                        }
                    }
                } catch (Throwable th) {
                    try {
                        vh.endTransaction();
                    } catch (Exception e14) {
                        d.printStackTrace(e14);
                    }
                    throw th;
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class b implements Iterator<com.kwad.framework.filedownloader.d.c> {
        private Cursor afD;
        private final List<Integer> afE = new ArrayList();
        private int afF;

        public b() {
            try {
                this.afD = d.this.vh().rawQuery("SELECT * FROM ksad_file_download", null);
            } catch (SQLiteException e2) {
                d.this.a(e2);
            } catch (Exception e10) {
                d.printStackTrace(e10);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // java.util.Iterator
        /* renamed from: vi, reason: merged with bridge method [inline-methods] */
        public com.kwad.framework.filedownloader.d.c next() {
            com.kwad.framework.filedownloader.d.c d10 = d.d(this.afD);
            this.afF = d10.getId();
            return d10;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            try {
                Cursor cursor = this.afD;
                if (cursor != null) {
                    return cursor.moveToNext();
                }
                return false;
            } catch (Throwable th) {
                d.printStackTrace(th);
                return false;
            }
        }

        @Override // java.util.Iterator
        public final void remove() {
            this.afE.add(Integer.valueOf(this.afF));
        }

        public final void vg() {
            Cursor cursor = this.afD;
            if (cursor == null) {
                return;
            }
            cursor.close();
            if (this.afE.isEmpty()) {
                return;
            }
            String join = TextUtils.join(", ", this.afE);
            if (com.kwad.framework.filedownloader.f.d.ail) {
                com.kwad.framework.filedownloader.f.d.c(this, "delete %s", join);
            }
            try {
                SQLiteDatabase vh = d.this.vh();
                vh.execSQL(f.b("DELETE FROM %s WHERE %s IN (%s);", "ksad_file_download", "_id", join));
                vh.execSQL(f.b("DELETE FROM %s WHERE %s IN (%s);", "ksad_file_download_connection", "id", join));
            } catch (SQLiteException e2) {
                d.this.a(e2);
            } catch (Exception e10) {
                d.printStackTrace(e10);
            }
        }
    }

    private void d(com.kwad.framework.filedownloader.d.c cVar) {
        try {
            vh().insert("ksad_file_download", null, cVar.wj());
        } catch (SQLiteException e2) {
            cVar.bo(e2.toString());
            cVar.d((byte) -1);
            a(cVar.getId(), e2);
        } catch (Exception e10) {
            printStackTrace(e10);
        }
    }

    private static void h(Throwable th) {
        if (th != null) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void printStackTrace(Throwable th) {
        h(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SQLiteDatabase vh() {
        if (this.afz == null) {
            this.afz = this.afy.getWritableDatabase();
        }
        return this.afz;
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void b(com.kwad.framework.filedownloader.d.c cVar) {
        if (cVar == null) {
            com.kwad.framework.filedownloader.f.d.d(this, "update but model == null!", new Object[0]);
            return;
        }
        if (bk(cVar.getId()) != null) {
            try {
                vh().update("ksad_file_download", cVar.wj(), "_id = ? ", new String[]{String.valueOf(cVar.getId())});
                return;
            } catch (SQLiteException e2) {
                cVar.bo(e2.toString());
                cVar.d((byte) -1);
                a(cVar.getId(), e2);
                return;
            } catch (Exception e10) {
                printStackTrace(e10);
                return;
            }
        }
        d(cVar);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void bj(int i10) {
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0048: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:20:0x0048 */
    @Override // com.kwad.framework.filedownloader.b.a
    public final com.kwad.framework.filedownloader.d.c bk(int i10) {
        Cursor cursor;
        Closeable closeable;
        Closeable closeable2 = null;
        try {
            try {
                cursor = vh().rawQuery(f.b("SELECT * FROM %s WHERE %s = ?", "ksad_file_download", "_id"), new String[]{Integer.toString(i10)});
            } catch (SQLiteException e2) {
                e = e2;
                cursor = null;
            } catch (Exception e10) {
                e = e10;
                cursor = null;
            } catch (Throwable th) {
                th = th;
                com.kwad.sdk.crash.utils.b.closeQuietly(closeable2);
                throw th;
            }
            try {
                if (cursor.moveToNext()) {
                    com.kwad.framework.filedownloader.d.c d10 = d(cursor);
                    com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
                    return d10;
                }
            } catch (SQLiteException e11) {
                e = e11;
                a(i10, e);
                com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
                return null;
            } catch (Exception e12) {
                e = e12;
                printStackTrace(e);
                com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
                return null;
            }
            com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
            return null;
        } catch (Throwable th2) {
            th = th2;
            closeable2 = closeable;
            com.kwad.sdk.crash.utils.b.closeQuietly(closeable2);
            throw th;
        }
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final List<com.kwad.framework.filedownloader.d.a> bl(int i10) {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            try {
                cursor = vh().rawQuery(f.b("SELECT * FROM %s WHERE %s = ?", "ksad_file_download_connection", "id"), new String[]{Integer.toString(i10)});
                while (cursor.moveToNext()) {
                    com.kwad.framework.filedownloader.d.a aVar = new com.kwad.framework.filedownloader.d.a();
                    aVar.setId(i10);
                    aVar.setIndex(cursor.getInt(cursor.getColumnIndex("connectionIndex")));
                    aVar.setStartOffset(cursor.getLong(cursor.getColumnIndex(DBDefinition.START_OFFSET)));
                    aVar.Q(cursor.getLong(cursor.getColumnIndex("currentOffset")));
                    aVar.R(cursor.getLong(cursor.getColumnIndex(DBDefinition.END_OFFSET)));
                    arrayList.add(aVar);
                }
            } catch (SQLiteException e2) {
                a(i10, e2);
            } catch (Exception e10) {
                printStackTrace(e10);
            }
            return arrayList;
        } finally {
            com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
        }
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void bm(int i10) {
        try {
            vh().execSQL("DELETE FROM ksad_file_download_connection WHERE id = " + i10);
        } catch (SQLiteException e2) {
            printStackTrace(e2);
        } catch (Exception e10) {
            printStackTrace(e10);
        }
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final boolean bn(int i10) {
        try {
            return vh().delete("ksad_file_download", "_id = ?", new String[]{String.valueOf(i10)}) != 0;
        } catch (SQLiteException e2) {
            printStackTrace(e2);
            return false;
        } catch (Exception e10) {
            printStackTrace(e10);
            return false;
        }
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void bo(int i10) {
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void c(int i10, long j10) {
        bn(i10);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void clear() {
        try {
            vh().delete("ksad_file_download", null, null);
        } catch (SQLiteException e2) {
            a(e2);
        }
        try {
            vh().delete("ksad_file_download_connection", null, null);
        } catch (SQLiteException e10) {
            a(e10);
        }
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void s(int i10, int i11) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("connectionCount", Integer.valueOf(i11));
        try {
            vh().update("ksad_file_download", contentValues, "_id = ? ", new String[]{Integer.toString(i10)});
        } catch (SQLiteException e2) {
            a(i10, e2);
        } catch (Exception e10) {
            printStackTrace(e10);
        }
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final a.InterfaceC0495a vf() {
        return new a(null, null);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(com.kwad.framework.filedownloader.d.a aVar) {
        if (aVar != null) {
            try {
                vh().insert("ksad_file_download_connection", null, aVar.wj());
            } catch (SQLiteException e2) {
                a(aVar.getId(), e2);
            } catch (Exception e10) {
                printStackTrace(e10);
            }
        }
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i10, int i11, long j10) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("currentOffset", Long.valueOf(j10));
        try {
            vh().update("ksad_file_download_connection", contentValues, "id = ? AND connectionIndex = ?", new String[]{Integer.toString(i10), Integer.toString(i11)});
        } catch (SQLiteException e2) {
            a(i10, e2);
        } catch (Exception e10) {
            printStackTrace(e10);
        }
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void d(int i10, long j10) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Byte) (byte) -2);
        contentValues.put("sofar", Long.valueOf(j10));
        a(i10, contentValues);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.kwad.framework.filedownloader.d.c d(Cursor cursor) {
        com.kwad.framework.filedownloader.d.c cVar = new com.kwad.framework.filedownloader.d.c();
        if (cursor == null) {
            return cVar;
        }
        cVar.setId(cursor.getInt(cursor.getColumnIndex("_id")));
        cVar.setUrl(cursor.getString(cursor.getColumnIndex("url")));
        cVar.d(cursor.getString(cursor.getColumnIndex("path")), cursor.getShort(cursor.getColumnIndex("pathAsDirectory")) == 1);
        cVar.d((byte) cursor.getShort(cursor.getColumnIndex("status")));
        cVar.S(cursor.getLong(cursor.getColumnIndex("sofar")));
        cVar.U(cursor.getLong(cursor.getColumnIndex("total")));
        cVar.bo(cursor.getString(cursor.getColumnIndex("errMsg")));
        cVar.bn(cursor.getString(cursor.getColumnIndex("etag")));
        cVar.bp(cursor.getString(cursor.getColumnIndex(FFmpegMediaMetadataRetriever.METADATA_KEY_FILENAME)));
        cVar.bD(cursor.getInt(cursor.getColumnIndex("connectionCount")));
        return cVar;
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void b(int i10, long j10) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Byte) (byte) 3);
        contentValues.put("sofar", Long.valueOf(j10));
        a(i10, contentValues);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i10, String str, long j10, long j11, int i11) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("sofar", Long.valueOf(j10));
        contentValues.put("total", Long.valueOf(j11));
        contentValues.put("etag", str);
        contentValues.put("connectionCount", Integer.valueOf(i11));
        a(i10, contentValues);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i10, long j10, String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Byte) (byte) 2);
        contentValues.put("total", Long.valueOf(j10));
        contentValues.put("etag", str);
        contentValues.put(FFmpegMediaMetadataRetriever.METADATA_KEY_FILENAME, str2);
        a(i10, contentValues);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i10, Throwable th, long j10) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("errMsg", th.toString());
        contentValues.put("status", (Byte) (byte) -1);
        contentValues.put("sofar", Long.valueOf(j10));
        a(i10, contentValues);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i10, Throwable th) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("errMsg", th.toString());
        contentValues.put("status", (Byte) (byte) 5);
        a(i10, contentValues);
    }

    public final a.InterfaceC0495a a(SparseArray<com.kwad.framework.filedownloader.d.c> sparseArray, SparseArray<List<com.kwad.framework.filedownloader.d.a>> sparseArray2) {
        return new a(sparseArray, sparseArray2);
    }

    private void a(int i10, ContentValues contentValues) {
        try {
            vh().update("ksad_file_download", contentValues, "_id = ? ", new String[]{String.valueOf(i10)});
        } catch (SQLiteException e2) {
            a(i10, e2);
        } catch (Exception e10) {
            printStackTrace(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SQLiteException sQLiteException) {
        a(-1, sQLiteException);
    }

    private void a(int i10, @Nullable SQLiteException sQLiteException) {
        if (sQLiteException instanceof SQLiteFullException) {
            if (i10 != -1) {
                bn(i10);
                bm(i10);
            }
            h(sQLiteException);
            afx = true;
            return;
        }
        printStackTrace(sQLiteException);
    }
}

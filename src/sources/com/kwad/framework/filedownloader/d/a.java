package com.kwad.framework.filedownloader.d;

import android.content.ContentValues;
import com.kwad.framework.filedownloader.f.f;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class a {
    private long afO;
    private long afP;
    private long afQ;

    /* renamed from: id, reason: collision with root package name */
    private int f36637id;
    private int index;

    public static long r(List<a> list) {
        long j10 = 0;
        for (a aVar : list) {
            j10 += aVar.wh() - aVar.getStartOffset();
        }
        return j10;
    }

    public final void Q(long j10) {
        this.afP = j10;
    }

    public final void R(long j10) {
        this.afQ = j10;
    }

    public final int getId() {
        return this.f36637id;
    }

    public final int getIndex() {
        return this.index;
    }

    public final long getStartOffset() {
        return this.afO;
    }

    public final void setId(int i10) {
        this.f36637id = i10;
    }

    public final void setIndex(int i10) {
        this.index = i10;
    }

    public final void setStartOffset(long j10) {
        this.afO = j10;
    }

    public final String toString() {
        return f.b("id[%d] index[%d] range[%d, %d) current offset(%d)", Integer.valueOf(this.f36637id), Integer.valueOf(this.index), Long.valueOf(this.afO), Long.valueOf(this.afQ), Long.valueOf(this.afP));
    }

    public final long wh() {
        return this.afP;
    }

    public final long wi() {
        return this.afQ;
    }

    public final ContentValues wj() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", Integer.valueOf(this.f36637id));
        contentValues.put("connectionIndex", Integer.valueOf(this.index));
        contentValues.put(DBDefinition.START_OFFSET, Long.valueOf(this.afO));
        contentValues.put("currentOffset", Long.valueOf(this.afP));
        contentValues.put(DBDefinition.END_OFFSET, Long.valueOf(this.afQ));
        return contentValues;
    }
}

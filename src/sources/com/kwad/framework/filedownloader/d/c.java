package com.kwad.framework.filedownloader.d;

import android.content.ContentValues;
import android.os.Parcel;
import android.os.Parcelable;
import com.kwad.framework.filedownloader.f.f;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.zip.ZipUtils;
import wseemann.media.FFmpegMediaMetadataRetriever;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class c implements Parcelable {
    public static final Parcelable.Creator<c> CREATOR = new Parcelable.Creator<c>() { // from class: com.kwad.framework.filedownloader.d.c.1
        private static c[] bE(int i10) {
            return new c[i10];
        }

        private static c c(Parcel parcel) {
            return new c(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ c createFromParcel(Parcel parcel) {
            return c(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ c[] newArray(int i10) {
            return bE(i10);
        }
    };
    private String VM;
    private boolean ahE;
    private final AtomicInteger ahF;
    private final AtomicLong ahG;
    private long ahH;
    private String ahI;
    private String ahJ;
    private int ahK;
    private boolean ahr;
    private String filename;

    /* renamed from: id, reason: collision with root package name */
    private int f36638id;
    private String url;

    public c() {
        this.ahG = new AtomicLong();
        this.ahF = new AtomicInteger();
    }

    private String wn() {
        return this.ahI;
    }

    public final void S(long j10) {
        this.ahG.set(j10);
    }

    public final void T(long j10) {
        this.ahG.addAndGet(j10);
    }

    public final void U(long j10) {
        this.ahr = j10 > ZipUtils.UPPER_UNIXTIME_BOUND;
        this.ahH = j10;
    }

    public final void bD(int i10) {
        this.ahK = i10;
    }

    public final void bn(String str) {
        this.ahJ = str;
    }

    public final void bo(String str) {
        this.ahI = str;
    }

    public final void bp(String str) {
        this.filename = str;
    }

    public final void d(String str, boolean z10) {
        this.VM = str;
        this.ahE = z10;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String getFilename() {
        return this.filename;
    }

    public final int getId() {
        return this.f36638id;
    }

    public final String getPath() {
        return this.VM;
    }

    public final String getTargetFilePath() {
        return f.a(getPath(), tR(), getFilename());
    }

    public final long getTotal() {
        return this.ahH;
    }

    public final String getUrl() {
        return this.url;
    }

    public final boolean isChunked() {
        return this.ahH == -1;
    }

    public final void setId(int i10) {
        this.f36638id = i10;
    }

    public final void setUrl(String str) {
        this.url = str;
    }

    public final boolean tR() {
        return this.ahE;
    }

    public final byte tV() {
        return (byte) this.ahF.get();
    }

    public final String toString() {
        return f.b("id[%d], url[%s], path[%s], status[%d], sofar[%s], total[%d], etag[%s], %s", Integer.valueOf(this.f36638id), this.url, this.VM, Integer.valueOf(this.ahF.get()), this.ahG, Long.valueOf(this.ahH), this.ahJ, super.toString());
    }

    public final boolean ub() {
        return this.ahr;
    }

    public final String vD() {
        if (getTargetFilePath() == null) {
            return null;
        }
        return f.bt(getTargetFilePath());
    }

    public final ContentValues wj() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id", Integer.valueOf(getId()));
        contentValues.put("url", getUrl());
        contentValues.put("path", getPath());
        contentValues.put("status", Byte.valueOf(tV()));
        contentValues.put("sofar", Long.valueOf(wl()));
        contentValues.put("total", Long.valueOf(getTotal()));
        contentValues.put("errMsg", wn());
        contentValues.put("etag", wm());
        contentValues.put("connectionCount", Integer.valueOf(wo()));
        contentValues.put("pathAsDirectory", Boolean.valueOf(tR()));
        if (tR() && getFilename() != null) {
            contentValues.put(FFmpegMediaMetadataRetriever.METADATA_KEY_FILENAME, getFilename());
        }
        return contentValues;
    }

    public final long wl() {
        return this.ahG.get();
    }

    public final String wm() {
        return this.ahJ;
    }

    public final int wo() {
        return this.ahK;
    }

    public final void wp() {
        this.ahK = 1;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f36638id);
        parcel.writeString(this.url);
        parcel.writeString(this.VM);
        parcel.writeByte(this.ahE ? (byte) 1 : (byte) 0);
        parcel.writeString(this.filename);
        parcel.writeByte((byte) this.ahF.get());
        parcel.writeLong(this.ahG.get());
        parcel.writeLong(this.ahH);
        parcel.writeString(this.ahI);
        parcel.writeString(this.ahJ);
        parcel.writeInt(this.ahK);
        parcel.writeByte(this.ahr ? (byte) 1 : (byte) 0);
    }

    public final void d(byte b4) {
        this.ahF.set(b4);
    }

    public c(Parcel parcel) {
        this.f36638id = parcel.readInt();
        this.url = parcel.readString();
        this.VM = parcel.readString();
        this.ahE = parcel.readByte() != 0;
        this.filename = parcel.readString();
        this.ahF = new AtomicInteger(parcel.readByte());
        this.ahG = new AtomicLong(parcel.readLong());
        this.ahH = parcel.readLong();
        this.ahI = parcel.readString();
        this.ahJ = parcel.readString();
        this.ahK = parcel.readInt();
        this.ahr = parcel.readByte() != 0;
    }
}

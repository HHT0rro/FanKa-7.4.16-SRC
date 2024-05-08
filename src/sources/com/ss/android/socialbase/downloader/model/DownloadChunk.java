package com.ss.android.socialbase.downloader.model;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.thread.DownloadChunkRunnable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class DownloadChunk implements Parcelable {
    private int bindValueCount;
    private int chunkIndex;
    private DownloadChunkRunnable chunkRunnable;
    private long contentLength;
    private AtomicLong currentOffset;
    private long endOffset;
    private DownloadChunk hostChunk;
    private AtomicInteger hostChunkIndex;

    /* renamed from: id, reason: collision with root package name */
    private int f38975id;
    private AtomicBoolean isDownloading;
    private long oldOffset;
    private boolean reuseingFirstConnection;
    private long startOffset;
    private List<DownloadChunk> subChunkList;
    private static final String TAG = DownloadChunk.class.getSimpleName();
    public static final Parcelable.Creator<DownloadChunk> CREATOR = new Parcelable.Creator<DownloadChunk>() { // from class: com.ss.android.socialbase.downloader.model.DownloadChunk.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DownloadChunk createFromParcel(Parcel parcel) {
            return new DownloadChunk(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DownloadChunk[] newArray(int i10) {
            return new DownloadChunk[i10];
        }
    };

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class Builder {
        private int chunkIndex;
        private long contentLength;
        private long currentOffset;
        private long endOffset;
        private DownloadChunk hostChunk;

        /* renamed from: id, reason: collision with root package name */
        private int f38976id;
        private long oldOffset;
        private long startOffset;

        public Builder(int i10) {
            this.f38976id = i10;
        }

        public DownloadChunk build() {
            return new DownloadChunk(this);
        }

        public Builder chunkIndex(int i10) {
            this.chunkIndex = i10;
            return this;
        }

        public Builder contentLength(long j10) {
            this.contentLength = j10;
            return this;
        }

        public Builder currentOffset(long j10) {
            this.currentOffset = j10;
            return this;
        }

        public Builder endOffset(long j10) {
            this.endOffset = j10;
            return this;
        }

        public Builder hostChunk(DownloadChunk downloadChunk) {
            this.hostChunk = downloadChunk;
            return this;
        }

        public Builder id(int i10) {
            this.f38976id = i10;
            return this;
        }

        public Builder oldOffset(long j10) {
            this.oldOffset = j10;
            return this;
        }

        public Builder startOffset(long j10) {
            this.startOffset = j10;
            return this;
        }
    }

    public void bindValue(SQLiteStatement sQLiteStatement) {
        if (sQLiteStatement == null) {
            return;
        }
        this.bindValueCount = 0;
        sQLiteStatement.clearBindings();
        int i10 = this.bindValueCount + 1;
        this.bindValueCount = i10;
        sQLiteStatement.bindLong(i10, this.f38975id);
        int i11 = this.bindValueCount + 1;
        this.bindValueCount = i11;
        sQLiteStatement.bindLong(i11, this.chunkIndex);
        int i12 = this.bindValueCount + 1;
        this.bindValueCount = i12;
        sQLiteStatement.bindLong(i12, this.startOffset);
        int i13 = this.bindValueCount + 1;
        this.bindValueCount = i13;
        sQLiteStatement.bindLong(i13, getCurrentOffset());
        int i14 = this.bindValueCount + 1;
        this.bindValueCount = i14;
        sQLiteStatement.bindLong(i14, this.endOffset);
        int i15 = this.bindValueCount + 1;
        this.bindValueCount = i15;
        sQLiteStatement.bindLong(i15, this.contentLength);
        int i16 = this.bindValueCount + 1;
        this.bindValueCount = i16;
        sQLiteStatement.bindLong(i16, getHostChunkIndex());
    }

    public boolean canRefreshCurOffsetForReuseChunk() {
        DownloadChunk downloadChunk = this.hostChunk;
        if (downloadChunk == null) {
            return true;
        }
        if (!downloadChunk.hasChunkDivided()) {
            return false;
        }
        for (int i10 = 0; i10 < this.hostChunk.getSubChunkList().size(); i10++) {
            DownloadChunk downloadChunk2 = this.hostChunk.getSubChunkList().get(i10);
            if (downloadChunk2 != null) {
                int indexOf = this.hostChunk.getSubChunkList().indexOf(this);
                if (indexOf > i10 && !downloadChunk2.hasNoBytesDownload()) {
                    return false;
                }
                if (indexOf == i10) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<DownloadChunk> divideChunkForReuse(int i10, long j10) {
        DownloadChunk downloadChunk;
        long endOffset;
        long j11;
        long j12;
        long j13;
        long j14;
        DownloadChunk downloadChunk2 = this;
        int i11 = i10;
        if (!isHostChunk() || hasChunkDivided()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        long curOffset = getCurOffset();
        long retainLength = downloadChunk2.getRetainLength(true);
        long j15 = retainLength / i11;
        Logger.d(TAG, "retainLen:" + retainLength + " divideChunkForReuse chunkSize:" + j15 + " current host downloadChunk index:" + downloadChunk2.chunkIndex);
        int i12 = 0;
        while (i12 < i11) {
            if (i12 == 0) {
                j12 = getStartOffset();
                j11 = (curOffset + j15) - 1;
            } else {
                int i13 = i11 - 1;
                if (i12 == i13) {
                    long endOffset2 = getEndOffset();
                    j13 = endOffset2 > curOffset ? (endOffset2 - curOffset) + 1 : retainLength - (i13 * j15);
                    j14 = endOffset2;
                    j12 = curOffset;
                    long j16 = retainLength;
                    long j17 = j14;
                    DownloadChunk build = new Builder(downloadChunk2.f38975id).chunkIndex((-i12) - 1).startOffset(j12).currentOffset(curOffset).oldOffset(curOffset).endOffset(j17).contentLength(j13).hostChunk(downloadChunk2).build();
                    Logger.d(TAG, "divide sub chunk : " + i12 + " startOffset:" + j12 + " curOffset:" + curOffset + " endOffset:" + j17 + " contentLen:" + j13);
                    arrayList.add(build);
                    curOffset += j15;
                    i12++;
                    downloadChunk2 = this;
                    i11 = i10;
                    retainLength = j16;
                } else {
                    j11 = (curOffset + j15) - 1;
                    j12 = curOffset;
                }
            }
            j13 = j15;
            j14 = j11;
            long j162 = retainLength;
            long j172 = j14;
            DownloadChunk build2 = new Builder(downloadChunk2.f38975id).chunkIndex((-i12) - 1).startOffset(j12).currentOffset(curOffset).oldOffset(curOffset).endOffset(j172).contentLength(j13).hostChunk(downloadChunk2).build();
            Logger.d(TAG, "divide sub chunk : " + i12 + " startOffset:" + j12 + " curOffset:" + curOffset + " endOffset:" + j172 + " contentLen:" + j13);
            arrayList.add(build2);
            curOffset += j15;
            i12++;
            downloadChunk2 = this;
            i11 = i10;
            retainLength = j162;
        }
        long j18 = 0;
        for (int size = arrayList.size() - 1; size > 0; size--) {
            DownloadChunk downloadChunk3 = arrayList.get(size);
            if (downloadChunk3 != null) {
                j18 += downloadChunk3.getContentLength();
            }
        }
        Logger.d(TAG, "reuseChunkContentLen:" + j18);
        DownloadChunk downloadChunk4 = arrayList.get(0);
        if (downloadChunk4 != null) {
            if (getEndOffset() == 0) {
                endOffset = j10 - getStartOffset();
            } else {
                endOffset = (getEndOffset() - getStartOffset()) + 1;
            }
            downloadChunk4.setContentLength(endOffset - j18);
            downloadChunk = this;
            downloadChunk4.setChunkIndex(downloadChunk.chunkIndex);
            DownloadChunkRunnable downloadChunkRunnable = downloadChunk.chunkRunnable;
            if (downloadChunkRunnable != null) {
                downloadChunkRunnable.refreshResponseHandleOffset(downloadChunk4.getEndOffset(), getContentLength() - j18);
            }
        } else {
            downloadChunk = this;
        }
        downloadChunk.setSubChunkList(arrayList);
        return arrayList;
    }

    public int getBindValueCount() {
        return this.bindValueCount;
    }

    public int getChunkIndex() {
        return this.chunkIndex;
    }

    public long getContentLength() {
        return this.contentLength;
    }

    public long getCurOffset() {
        AtomicLong atomicLong = this.currentOffset;
        if (atomicLong != null) {
            return atomicLong.get();
        }
        return 0L;
    }

    public long getCurrentOffset() {
        if (isHostChunk() && hasChunkDivided()) {
            long j10 = 0;
            for (int i10 = 0; i10 < this.subChunkList.size(); i10++) {
                DownloadChunk downloadChunk = this.subChunkList.get(i10);
                if (downloadChunk != null) {
                    if (!downloadChunk.hasNoBytesDownload()) {
                        return downloadChunk.getCurOffset();
                    }
                    if (j10 < downloadChunk.getCurOffset()) {
                        j10 = downloadChunk.getCurOffset();
                    }
                }
            }
            return j10;
        }
        return getCurOffset();
    }

    public long getDownloadChunkBytes() {
        long currentOffset = getCurrentOffset() - this.startOffset;
        if (hasChunkDivided()) {
            currentOffset = 0;
            for (int i10 = 0; i10 < this.subChunkList.size(); i10++) {
                DownloadChunk downloadChunk = this.subChunkList.get(i10);
                if (downloadChunk != null) {
                    currentOffset += downloadChunk.getCurrentOffset() - downloadChunk.getStartOffset();
                }
            }
        }
        return currentOffset;
    }

    public long getEndOffset() {
        return this.endOffset;
    }

    public DownloadChunk getFirstReuseChunk() {
        DownloadChunk downloadChunk = !isHostChunk() ? this.hostChunk : this;
        if (downloadChunk == null || !downloadChunk.hasChunkDivided()) {
            return null;
        }
        return downloadChunk.getSubChunkList().get(0);
    }

    public DownloadChunk getHostChunk() {
        return this.hostChunk;
    }

    public int getHostChunkIndex() {
        AtomicInteger atomicInteger = this.hostChunkIndex;
        if (atomicInteger == null) {
            return -1;
        }
        return atomicInteger.get();
    }

    public int getId() {
        return this.f38975id;
    }

    public long getNextChunkCurOffset() {
        DownloadChunk downloadChunk = this.hostChunk;
        if (downloadChunk != null && downloadChunk.getSubChunkList() != null) {
            int indexOf = this.hostChunk.getSubChunkList().indexOf(this);
            boolean z10 = false;
            for (int i10 = 0; i10 < this.hostChunk.getSubChunkList().size(); i10++) {
                DownloadChunk downloadChunk2 = this.hostChunk.getSubChunkList().get(i10);
                if (downloadChunk2 != null) {
                    if (z10) {
                        return downloadChunk2.getCurrentOffset();
                    }
                    if (indexOf == i10) {
                        z10 = true;
                    }
                }
            }
        }
        return -1L;
    }

    public long getOldOffset() {
        return this.oldOffset;
    }

    public long getRetainLength(boolean z10) {
        long currentOffset = getCurrentOffset();
        long j10 = this.contentLength;
        long j11 = this.oldOffset;
        long j12 = j10 - (currentOffset - j11);
        if (!z10 && currentOffset == j11) {
            j12 = j10 - (currentOffset - this.startOffset);
        }
        Logger.d("DownloadChunk", "contentLength:" + this.contentLength + " curOffset:" + getCurrentOffset() + " oldOffset:" + this.oldOffset + " retainLen:" + j12);
        if (j12 < 0) {
            return 0L;
        }
        return j12;
    }

    public long getStartOffset() {
        return this.startOffset;
    }

    public List<DownloadChunk> getSubChunkList() {
        return this.subChunkList;
    }

    public boolean hasChunkDivided() {
        List<DownloadChunk> list = this.subChunkList;
        return list != null && list.size() > 0;
    }

    public boolean hasNoBytesDownload() {
        long j10 = this.startOffset;
        if (isHostChunk()) {
            long j11 = this.oldOffset;
            if (j11 > this.startOffset) {
                j10 = j11;
            }
        }
        return getCurrentOffset() - j10 >= this.contentLength;
    }

    public boolean isDownloading() {
        AtomicBoolean atomicBoolean = this.isDownloading;
        if (atomicBoolean == null) {
            return false;
        }
        return atomicBoolean.get();
    }

    public boolean isHostChunk() {
        return getHostChunkIndex() == -1;
    }

    public boolean isReuseingFirstConnection() {
        return this.chunkIndex == 0 && this.reuseingFirstConnection;
    }

    public void setChunkIndex(int i10) {
        this.chunkIndex = i10;
    }

    public void setChunkRunnable(DownloadChunkRunnable downloadChunkRunnable) {
        this.chunkRunnable = downloadChunkRunnable;
        setOldOffset();
    }

    public void setContentLength(long j10) {
        this.contentLength = j10;
    }

    public void setCurrentOffset(long j10) {
        AtomicLong atomicLong = this.currentOffset;
        if (atomicLong != null) {
            atomicLong.set(j10);
        } else {
            this.currentOffset = new AtomicLong(j10);
        }
    }

    public void setDownloading(boolean z10) {
        AtomicBoolean atomicBoolean = this.isDownloading;
        if (atomicBoolean == null) {
            this.isDownloading = new AtomicBoolean(z10);
        } else {
            atomicBoolean.set(z10);
        }
        this.chunkRunnable = null;
    }

    public void setHostChunk(DownloadChunk downloadChunk) {
        this.hostChunk = downloadChunk;
        if (downloadChunk != null) {
            setHostChunkIndex(downloadChunk.getChunkIndex());
        }
    }

    public void setHostChunkIndex(int i10) {
        AtomicInteger atomicInteger = this.hostChunkIndex;
        if (atomicInteger == null) {
            this.hostChunkIndex = new AtomicInteger(i10);
        } else {
            atomicInteger.set(i10);
        }
    }

    public void setId(int i10) {
        this.f38975id = i10;
    }

    public void setOldOffset(long j10) {
        this.oldOffset = j10;
    }

    public void setReuseingFirstConnection(boolean z10) {
        this.reuseingFirstConnection = z10;
    }

    public void setSubChunkList(List<DownloadChunk> list) {
        this.subChunkList = list;
    }

    public ContentValues toContentValues() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id", Integer.valueOf(this.f38975id));
        contentValues.put(DBDefinition.CHUNK_INDEX, Integer.valueOf(this.chunkIndex));
        contentValues.put(DBDefinition.START_OFFSET, Long.valueOf(this.startOffset));
        contentValues.put(DBDefinition.CUR_OFFSET, Long.valueOf(getCurrentOffset()));
        contentValues.put(DBDefinition.END_OFFSET, Long.valueOf(this.endOffset));
        contentValues.put(DBDefinition.CHUNK_CONTENT_LEN, Long.valueOf(this.contentLength));
        contentValues.put(DBDefinition.HOST_CHUNK_INDEX, Integer.valueOf(getHostChunkIndex()));
        return contentValues;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f38975id);
        parcel.writeLong(this.startOffset);
        AtomicLong atomicLong = this.currentOffset;
        parcel.writeLong(atomicLong != null ? atomicLong.get() : 0L);
        parcel.writeLong(this.endOffset);
        parcel.writeLong(this.contentLength);
        parcel.writeInt(this.chunkIndex);
        AtomicInteger atomicInteger = this.hostChunkIndex;
        parcel.writeInt(atomicInteger != null ? atomicInteger.get() : -1);
    }

    private DownloadChunk(Builder builder) {
        if (builder == null) {
            return;
        }
        this.f38975id = builder.f38976id;
        this.startOffset = builder.startOffset;
        this.currentOffset = new AtomicLong(builder.currentOffset);
        this.endOffset = builder.endOffset;
        this.contentLength = builder.contentLength;
        this.chunkIndex = builder.chunkIndex;
        this.oldOffset = builder.oldOffset;
        this.hostChunkIndex = new AtomicInteger(-1);
        setHostChunk(builder.hostChunk);
        this.isDownloading = new AtomicBoolean(false);
    }

    public void setOldOffset() {
        this.oldOffset = getCurrentOffset();
    }

    public DownloadChunk(Cursor cursor) {
        if (cursor == null) {
            return;
        }
        this.f38975id = cursor.getInt(cursor.getColumnIndex("_id"));
        this.chunkIndex = cursor.getInt(cursor.getColumnIndex(DBDefinition.CHUNK_INDEX));
        this.startOffset = cursor.getLong(cursor.getColumnIndex(DBDefinition.START_OFFSET));
        int columnIndex = cursor.getColumnIndex(DBDefinition.CUR_OFFSET);
        if (columnIndex != -1) {
            this.currentOffset = new AtomicLong(cursor.getLong(columnIndex));
        } else {
            this.currentOffset = new AtomicLong(0L);
        }
        this.endOffset = cursor.getLong(cursor.getColumnIndex(DBDefinition.END_OFFSET));
        int columnIndex2 = cursor.getColumnIndex(DBDefinition.HOST_CHUNK_INDEX);
        if (columnIndex2 != -1) {
            this.hostChunkIndex = new AtomicInteger(cursor.getInt(columnIndex2));
        } else {
            this.hostChunkIndex = new AtomicInteger(-1);
        }
        int columnIndex3 = cursor.getColumnIndex(DBDefinition.CHUNK_CONTENT_LEN);
        if (columnIndex3 != -1) {
            this.contentLength = cursor.getLong(columnIndex3);
        }
        this.isDownloading = new AtomicBoolean(false);
    }

    public DownloadChunk(Parcel parcel) {
        this.f38975id = parcel.readInt();
        this.startOffset = parcel.readLong();
        this.currentOffset = new AtomicLong(parcel.readLong());
        this.endOffset = parcel.readLong();
        this.contentLength = parcel.readLong();
        this.chunkIndex = parcel.readInt();
        this.hostChunkIndex = new AtomicInteger(parcel.readInt());
    }
}

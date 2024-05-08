package com.wangmai.okhttp.model;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.SystemClock;
import com.wangmai.okhttp.OkHttp;
import com.wangmai.okhttp.request.base.Request;
import com.wangmai.okhttp.utils.IOUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class Progress implements Serializable {
    public static final String CURRENT_SIZE = "currentSize";
    public static final String DATE = "date";
    public static final int ERROR = 4;
    public static final String EXTRA1 = "extra1";
    public static final String EXTRA2 = "extra2";
    public static final String EXTRA3 = "extra3";
    public static final String FILE_NAME = "fileName";
    public static final String FILE_PATH = "filePath";
    public static final int FINISH = 5;
    public static final String FOLDER = "folder";
    public static final String FRACTION = "fraction";
    public static final int LOADING = 2;
    public static final int NONE = 0;
    public static final int PAUSE = 3;
    public static final String PRIORITY = "priority";
    public static final String REQUEST = "request";
    public static final String STATUS = "status";
    public static final String TAG = "tag";
    public static final String TOTAL_SIZE = "totalSize";
    public static final String URL = "url";
    public static final int WAITING = 1;
    public static final long serialVersionUID = 6353658567594109891L;
    public long currentSize;
    public Throwable exception;
    public Serializable extra1;
    public Serializable extra2;
    public Serializable extra3;
    public String fileName;
    public String filePath;
    public String folder;
    public float fraction;
    public Request<?, ? extends Request> request;
    public transient long speed;
    public int status;
    public String tag;
    public transient long tempSize;
    public String url;
    public transient long lastRefreshTime = SystemClock.elapsedRealtime();
    public long totalSize = -1;
    public int priority = 0;
    public long date = System.currentTimeMillis();
    public transient List<Long> speedBuffer = new ArrayList();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface Action {
        void call(Progress progress);
    }

    private long bufferSpeed(long j10) {
        this.speedBuffer.add(Long.valueOf(j10));
        if (this.speedBuffer.size() > 10) {
            this.speedBuffer.remove(0);
        }
        long j11 = 0;
        Iterator<Long> iterator2 = this.speedBuffer.iterator2();
        while (iterator2.hasNext()) {
            j11 = ((float) j11) + ((float) iterator2.next().longValue());
        }
        return j11 / this.speedBuffer.size();
    }

    public static ContentValues buildContentValues(Progress progress) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("tag", progress.tag);
        contentValues.put("url", progress.url);
        contentValues.put(FOLDER, progress.folder);
        contentValues.put("filePath", progress.filePath);
        contentValues.put("fileName", progress.fileName);
        contentValues.put(FRACTION, Float.valueOf(progress.fraction));
        contentValues.put(TOTAL_SIZE, Long.valueOf(progress.totalSize));
        contentValues.put(CURRENT_SIZE, Long.valueOf(progress.currentSize));
        contentValues.put("status", Integer.valueOf(progress.status));
        contentValues.put("priority", Integer.valueOf(progress.priority));
        contentValues.put("date", Long.valueOf(progress.date));
        contentValues.put("request", IOUtils.toByteArray(progress.request));
        contentValues.put(EXTRA1, IOUtils.toByteArray(progress.extra1));
        contentValues.put(EXTRA2, IOUtils.toByteArray(progress.extra2));
        contentValues.put(EXTRA3, IOUtils.toByteArray(progress.extra3));
        return contentValues;
    }

    public static ContentValues buildUpdateContentValues(Progress progress) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(FRACTION, Float.valueOf(progress.fraction));
        contentValues.put(TOTAL_SIZE, Long.valueOf(progress.totalSize));
        contentValues.put(CURRENT_SIZE, Long.valueOf(progress.currentSize));
        contentValues.put("status", Integer.valueOf(progress.status));
        contentValues.put("priority", Integer.valueOf(progress.priority));
        contentValues.put("date", Long.valueOf(progress.date));
        return contentValues;
    }

    public static Progress changeProgress(Progress progress, long j10, Action action) {
        return changeProgress(progress, j10, progress.totalSize, action);
    }

    public static Progress parseCursorToBean(Cursor cursor) {
        Progress progress = new Progress();
        progress.tag = cursor.getString(cursor.getColumnIndex("tag"));
        progress.url = cursor.getString(cursor.getColumnIndex("url"));
        progress.folder = cursor.getString(cursor.getColumnIndex(FOLDER));
        progress.filePath = cursor.getString(cursor.getColumnIndex("filePath"));
        progress.fileName = cursor.getString(cursor.getColumnIndex("fileName"));
        progress.fraction = cursor.getFloat(cursor.getColumnIndex(FRACTION));
        progress.totalSize = cursor.getLong(cursor.getColumnIndex(TOTAL_SIZE));
        progress.currentSize = cursor.getLong(cursor.getColumnIndex(CURRENT_SIZE));
        progress.status = cursor.getInt(cursor.getColumnIndex("status"));
        progress.priority = cursor.getInt(cursor.getColumnIndex("priority"));
        progress.date = cursor.getLong(cursor.getColumnIndex("date"));
        progress.request = (Request) IOUtils.toObject(cursor.getBlob(cursor.getColumnIndex("request")));
        progress.extra1 = (Serializable) IOUtils.toObject(cursor.getBlob(cursor.getColumnIndex(EXTRA1)));
        progress.extra2 = (Serializable) IOUtils.toObject(cursor.getBlob(cursor.getColumnIndex(EXTRA2)));
        progress.extra3 = (Serializable) IOUtils.toObject(cursor.getBlob(cursor.getColumnIndex(EXTRA3)));
        return progress;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Progress.class != obj.getClass()) {
            return false;
        }
        String str = this.tag;
        String str2 = ((Progress) obj).tag;
        return str != null ? str.equals(str2) : str2 == null;
    }

    public void from(Progress progress) {
        this.totalSize = progress.totalSize;
        this.currentSize = progress.currentSize;
        this.fraction = progress.fraction;
        this.speed = progress.speed;
        this.lastRefreshTime = progress.lastRefreshTime;
        this.tempSize = progress.tempSize;
    }

    public int hashCode() {
        String str = this.tag;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "Progress{fraction=" + this.fraction + ", totalSize=" + this.totalSize + ", currentSize=" + this.currentSize + ", speed=" + this.speed + ", status=" + this.status + ", priority=" + this.priority + ", folder=" + this.folder + ", filePath=" + this.filePath + ", fileName=" + this.fileName + ", tag=" + this.tag + ", url=" + this.url + '}';
    }

    public static Progress changeProgress(Progress progress, long j10, long j11, Action action) {
        progress.totalSize = j11;
        progress.currentSize += j10;
        progress.tempSize += j10;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j12 = progress.lastRefreshTime;
        if ((elapsedRealtime - j12 >= OkHttp.REFRESH_TIME) || progress.currentSize == j11) {
            long j13 = elapsedRealtime - j12;
            if (j13 == 0) {
                j13 = 1;
            }
            progress.fraction = (((float) progress.currentSize) * 1.0f) / ((float) j11);
            progress.speed = progress.bufferSpeed((progress.tempSize * 1000) / j13);
            progress.lastRefreshTime = elapsedRealtime;
            progress.tempSize = 0L;
            if (action != null) {
                action.call(progress);
            }
        }
        return progress;
    }
}

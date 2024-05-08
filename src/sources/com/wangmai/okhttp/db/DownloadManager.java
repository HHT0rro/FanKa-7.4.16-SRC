package com.wangmai.okhttp.db;

import android.content.ContentValues;
import android.database.Cursor;
import com.wangmai.okhttp.model.Progress;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class DownloadManager extends BaseDao<Progress> {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class DownloadManagerHolder {
        public static final DownloadManager instance = new DownloadManager();
    }

    public static DownloadManager getInstance() {
        return DownloadManagerHolder.instance;
    }

    public boolean clear() {
        return deleteAll();
    }

    public void delete(String str) {
        delete("tag=?", new String[]{str});
    }

    public Progress get(String str) {
        return queryOne("tag=?", new String[]{str});
    }

    public List<Progress> getAll() {
        return query(null, null, null, null, null, "date ASC", null);
    }

    public List<Progress> getDownloading() {
        return query(null, "status not in(?)", new String[]{"5"}, null, null, "date ASC", null);
    }

    public List<Progress> getFinished() {
        return query(null, "status=?", new String[]{"5"}, null, null, "date ASC", null);
    }

    @Override // com.wangmai.okhttp.db.BaseDao
    public String getTableName() {
        return "download";
    }

    @Override // com.wangmai.okhttp.db.BaseDao
    public void unInit() {
    }

    public boolean update(Progress progress) {
        return update((DownloadManager) progress, "tag=?", new String[]{progress.tag});
    }

    public DownloadManager() {
        super(new DBHelper());
    }

    @Override // com.wangmai.okhttp.db.BaseDao
    public ContentValues getContentValues(Progress progress) {
        return Progress.buildContentValues(progress);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.wangmai.okhttp.db.BaseDao
    public Progress parseCursorToBean(Cursor cursor) {
        return Progress.parseCursorToBean(cursor);
    }

    public boolean update(ContentValues contentValues, String str) {
        return update(contentValues, "tag=?", new String[]{str});
    }
}

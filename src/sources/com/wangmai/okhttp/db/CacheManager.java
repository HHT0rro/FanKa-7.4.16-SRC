package com.wangmai.okhttp.db;

import android.content.ContentValues;
import android.database.Cursor;
import com.wangmai.okhttp.cache.CacheEntity;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class CacheManager extends BaseDao<CacheEntity<?>> {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class CacheManagerHolder {
        public static final CacheManager instance = new CacheManager();
    }

    public static CacheManager getInstance() {
        return CacheManagerHolder.instance;
    }

    public boolean clear() {
        return deleteAll();
    }

    public CacheEntity<?> get(String str) {
        if (str == null) {
            return null;
        }
        List<CacheEntity<?>> query = query("key=?", new String[]{str});
        if (query.size() > 0) {
            return query.get(0);
        }
        return null;
    }

    public List<CacheEntity<?>> getAll() {
        return queryAll();
    }

    @Override // com.wangmai.okhttp.db.BaseDao
    public String getTableName() {
        return DBHelper.TABLE_CACHE;
    }

    public boolean remove(String str) {
        if (str == null) {
            return false;
        }
        return delete("key=?", new String[]{str});
    }

    public <T> CacheEntity<T> replace(String str, CacheEntity<T> cacheEntity) {
        cacheEntity.setKey(str);
        replace((CacheManager) cacheEntity);
        return cacheEntity;
    }

    @Override // com.wangmai.okhttp.db.BaseDao
    public void unInit() {
    }

    public CacheManager() {
        super(new DBHelper());
    }

    @Override // com.wangmai.okhttp.db.BaseDao
    public ContentValues getContentValues(CacheEntity<?> cacheEntity) {
        return CacheEntity.getContentValues(cacheEntity);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.wangmai.okhttp.db.BaseDao
    public CacheEntity<?> parseCursorToBean(Cursor cursor) {
        return CacheEntity.parseCursorToBean(cursor);
    }

    public <T> CacheEntity<T> get(String str, Class<T> cls) {
        return (CacheEntity<T>) get(str);
    }
}

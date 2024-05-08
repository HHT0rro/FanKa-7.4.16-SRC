package org.greenrobot.greendao.query;

import java.util.Date;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.database.Database;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class DeleteQuery<T> extends AbstractQuery<T> {
    private final QueryData<T> queryData;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class QueryData<T2> extends AbstractQueryData<T2, DeleteQuery<T2>> {
        private QueryData(AbstractDao<T2, ?> abstractDao, String str, String[] strArr) {
            super(abstractDao, str, strArr);
        }

        @Override // org.greenrobot.greendao.query.AbstractQueryData
        public DeleteQuery<T2> createQuery() {
            return new DeleteQuery<>(this, this.dao, this.sql, (String[]) this.initialValues.clone());
        }
    }

    public static <T2> DeleteQuery<T2> create(AbstractDao<T2, ?> abstractDao, String str, Object[] objArr) {
        return new QueryData(abstractDao, str, AbstractQuery.toStringArray(objArr)).forCurrentThread();
    }

    public void executeDeleteWithoutDetachingEntities() {
        checkThread();
        Database database = this.dao.getDatabase();
        if (database.isDbLockedByCurrentThread()) {
            this.dao.getDatabase().execSQL(this.sql, this.parameters);
            return;
        }
        database.beginTransaction();
        try {
            this.dao.getDatabase().execSQL(this.sql, this.parameters);
            database.setTransactionSuccessful();
        } finally {
            database.endTransaction();
        }
    }

    public DeleteQuery<T> forCurrentThread() {
        return (DeleteQuery) this.queryData.forCurrentThread(this);
    }

    private DeleteQuery(QueryData<T> queryData, AbstractDao<T, ?> abstractDao, String str, String[] strArr) {
        super(abstractDao, str, strArr);
        this.queryData = queryData;
    }

    @Override // org.greenrobot.greendao.query.AbstractQuery
    public DeleteQuery<T> setParameter(int i10, Object obj) {
        return (DeleteQuery) super.setParameter(i10, obj);
    }

    @Override // org.greenrobot.greendao.query.AbstractQuery
    public DeleteQuery<T> setParameter(int i10, Date date) {
        return (DeleteQuery) super.setParameter(i10, date);
    }

    @Override // org.greenrobot.greendao.query.AbstractQuery
    public DeleteQuery<T> setParameter(int i10, Boolean bool) {
        return (DeleteQuery) super.setParameter(i10, bool);
    }
}

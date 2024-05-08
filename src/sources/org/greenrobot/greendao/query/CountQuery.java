package org.greenrobot.greendao.query;

import android.database.Cursor;
import java.util.Date;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.DaoException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class CountQuery<T> extends AbstractQuery<T> {
    private final QueryData<T> queryData;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class QueryData<T2> extends AbstractQueryData<T2, CountQuery<T2>> {
        private QueryData(AbstractDao<T2, ?> abstractDao, String str, String[] strArr) {
            super(abstractDao, str, strArr);
        }

        @Override // org.greenrobot.greendao.query.AbstractQueryData
        public CountQuery<T2> createQuery() {
            return new CountQuery<>(this, this.dao, this.sql, (String[]) this.initialValues.clone());
        }
    }

    public static <T2> CountQuery<T2> create(AbstractDao<T2, ?> abstractDao, String str, Object[] objArr) {
        return new QueryData(abstractDao, str, AbstractQuery.toStringArray(objArr)).forCurrentThread();
    }

    public long count() {
        checkThread();
        Cursor rawQuery = this.dao.getDatabase().rawQuery(this.sql, this.parameters);
        try {
            if (rawQuery.moveToNext()) {
                if (rawQuery.isLast()) {
                    if (rawQuery.getColumnCount() == 1) {
                        return rawQuery.getLong(0);
                    }
                    throw new DaoException("Unexpected column count: " + rawQuery.getColumnCount());
                }
                throw new DaoException("Unexpected row count: " + rawQuery.getCount());
            }
            throw new DaoException("No result for count");
        } finally {
            rawQuery.close();
        }
    }

    public CountQuery<T> forCurrentThread() {
        return (CountQuery) this.queryData.forCurrentThread(this);
    }

    private CountQuery(QueryData<T> queryData, AbstractDao<T, ?> abstractDao, String str, String[] strArr) {
        super(abstractDao, str, strArr);
        this.queryData = queryData;
    }

    @Override // org.greenrobot.greendao.query.AbstractQuery
    public CountQuery<T> setParameter(int i10, Object obj) {
        return (CountQuery) super.setParameter(i10, obj);
    }

    @Override // org.greenrobot.greendao.query.AbstractQuery
    public CountQuery<T> setParameter(int i10, Date date) {
        return (CountQuery) super.setParameter(i10, date);
    }

    @Override // org.greenrobot.greendao.query.AbstractQuery
    public CountQuery<T> setParameter(int i10, Boolean bool) {
        return (CountQuery) super.setParameter(i10, bool);
    }
}

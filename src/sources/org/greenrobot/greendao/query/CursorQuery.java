package org.greenrobot.greendao.query;

import android.database.Cursor;
import java.util.Date;
import org.greenrobot.greendao.AbstractDao;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class CursorQuery<T> extends AbstractQueryWithLimit<T> {
    private final QueryData<T> queryData;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class QueryData<T2> extends AbstractQueryData<T2, CursorQuery<T2>> {
        private final int limitPosition;
        private final int offsetPosition;

        public QueryData(AbstractDao abstractDao, String str, String[] strArr, int i10, int i11) {
            super(abstractDao, str, strArr);
            this.limitPosition = i10;
            this.offsetPosition = i11;
        }

        @Override // org.greenrobot.greendao.query.AbstractQueryData
        public CursorQuery<T2> createQuery() {
            return new CursorQuery<>(this, this.dao, this.sql, (String[]) this.initialValues.clone(), this.limitPosition, this.offsetPosition);
        }
    }

    public static <T2> CursorQuery<T2> create(AbstractDao<T2, ?> abstractDao, String str, Object[] objArr, int i10, int i11) {
        return new QueryData(abstractDao, str, AbstractQuery.toStringArray(objArr), i10, i11).forCurrentThread();
    }

    public static <T2> CursorQuery<T2> internalCreate(AbstractDao<T2, ?> abstractDao, String str, Object[] objArr) {
        return create(abstractDao, str, objArr, -1, -1);
    }

    public CursorQuery forCurrentThread() {
        return this.queryData.forCurrentThread(this);
    }

    public Cursor query() {
        checkThread();
        return this.dao.getDatabase().rawQuery(this.sql, this.parameters);
    }

    @Override // org.greenrobot.greendao.query.AbstractQueryWithLimit
    public /* bridge */ /* synthetic */ void setLimit(int i10) {
        super.setLimit(i10);
    }

    @Override // org.greenrobot.greendao.query.AbstractQueryWithLimit
    public /* bridge */ /* synthetic */ void setOffset(int i10) {
        super.setOffset(i10);
    }

    private CursorQuery(QueryData<T> queryData, AbstractDao<T, ?> abstractDao, String str, String[] strArr, int i10, int i11) {
        super(abstractDao, str, strArr, i10, i11);
        this.queryData = queryData;
    }

    @Override // org.greenrobot.greendao.query.AbstractQueryWithLimit, org.greenrobot.greendao.query.AbstractQuery
    public CursorQuery<T> setParameter(int i10, Object obj) {
        return (CursorQuery) super.setParameter(i10, obj);
    }

    @Override // org.greenrobot.greendao.query.AbstractQuery
    public CursorQuery<T> setParameter(int i10, Date date) {
        return (CursorQuery) super.setParameter(i10, date);
    }

    @Override // org.greenrobot.greendao.query.AbstractQuery
    public CursorQuery<T> setParameter(int i10, Boolean bool) {
        return (CursorQuery) super.setParameter(i10, bool);
    }
}

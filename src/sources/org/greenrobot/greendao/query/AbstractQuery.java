package org.greenrobot.greendao.query;

import java.util.Date;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.InternalQueryDaoAccess;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class AbstractQuery<T> {
    public final AbstractDao<T, ?> dao;
    public final InternalQueryDaoAccess<T> daoAccess;
    public final Thread ownerThread = Thread.currentThread();
    public final String[] parameters;
    public final String sql;

    public AbstractQuery(AbstractDao<T, ?> abstractDao, String str, String[] strArr) {
        this.dao = abstractDao;
        this.daoAccess = new InternalQueryDaoAccess<>(abstractDao);
        this.sql = str;
        this.parameters = strArr;
    }

    public static String[] toStringArray(Object[] objArr) {
        int length = objArr.length;
        String[] strArr = new String[length];
        for (int i10 = 0; i10 < length; i10++) {
            Object obj = objArr[i10];
            if (obj != null) {
                strArr[i10] = obj.toString();
            } else {
                strArr[i10] = null;
            }
        }
        return strArr;
    }

    public void checkThread() {
        if (Thread.currentThread() != this.ownerThread) {
            throw new DaoException("Method may be called only in owner thread, use forCurrentThread to get an instance for this thread");
        }
    }

    public AbstractQuery<T> setParameter(int i10, Object obj) {
        checkThread();
        if (obj != null) {
            this.parameters[i10] = obj.toString();
        } else {
            this.parameters[i10] = null;
        }
        return this;
    }

    public AbstractQuery<T> setParameter(int i10, Date date) {
        return setParameter(i10, date != null ? Long.valueOf(date.getTime()) : null);
    }

    public AbstractQuery<T> setParameter(int i10, Boolean bool) {
        return setParameter(i10, bool != null ? Integer.valueOf(bool.booleanValue() ? 1 : 0) : null);
    }
}

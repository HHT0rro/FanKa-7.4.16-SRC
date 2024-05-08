package org.greenrobot.greendao.query;

import org.greenrobot.greendao.AbstractDao;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class AbstractQueryWithLimit<T> extends AbstractQuery<T> {
    public final int limitPosition;
    public final int offsetPosition;

    public AbstractQueryWithLimit(AbstractDao<T, ?> abstractDao, String str, String[] strArr, int i10, int i11) {
        super(abstractDao, str, strArr);
        this.limitPosition = i10;
        this.offsetPosition = i11;
    }

    public void setLimit(int i10) {
        checkThread();
        int i11 = this.limitPosition;
        if (i11 != -1) {
            this.parameters[i11] = Integer.toString(i10);
            return;
        }
        throw new IllegalStateException("Limit must be set with QueryBuilder before it can be used here");
    }

    public void setOffset(int i10) {
        checkThread();
        int i11 = this.offsetPosition;
        if (i11 != -1) {
            this.parameters[i11] = Integer.toString(i10);
            return;
        }
        throw new IllegalStateException("Offset must be set with QueryBuilder before it can be used here");
    }

    @Override // org.greenrobot.greendao.query.AbstractQuery
    public AbstractQueryWithLimit<T> setParameter(int i10, Object obj) {
        if (i10 >= 0 && (i10 == this.limitPosition || i10 == this.offsetPosition)) {
            throw new IllegalArgumentException("Illegal parameter index: " + i10);
        }
        return (AbstractQueryWithLimit) super.setParameter(i10, obj);
    }
}

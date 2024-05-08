package org.greenrobot.greendao.test;

import android.test.AndroidTestCase;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.DaoLog;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class AbstractDaoTestLongPk<D extends AbstractDao<T, Long>, T> extends AbstractDaoTestSinglePk<D, T, Long> {
    public AbstractDaoTestLongPk(Class<D> cls) {
        super(cls);
    }

    public void testAssignPk() {
        if (this.daoAccess.isEntityUpdateable()) {
            T createEntity = createEntity(null);
            if (createEntity != null) {
                T createEntity2 = createEntity(null);
                this.dao.insert(createEntity);
                this.dao.insert(createEntity2);
                Long l10 = (Long) this.daoAccess.getKey(createEntity);
                AndroidTestCase.assertNotNull(l10);
                Long l11 = (Long) this.daoAccess.getKey(createEntity2);
                AndroidTestCase.assertNotNull(l11);
                AndroidTestCase.assertFalse(l10.equals(l11));
                AndroidTestCase.assertNotNull(this.dao.load(l10));
                AndroidTestCase.assertNotNull(this.dao.load(l11));
                return;
            }
            DaoLog.d("Skipping testAssignPk for " + this.daoClass + " (createEntity returned null for null key)");
            return;
        }
        DaoLog.d("Skipping testAssignPk for not updateable " + this.daoClass);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.greenrobot.greendao.test.AbstractDaoTestSinglePk
    public Long createRandomPk() {
        return Long.valueOf(this.random.nextLong());
    }
}

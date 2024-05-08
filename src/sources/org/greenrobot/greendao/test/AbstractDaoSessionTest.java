package org.greenrobot.greendao.test;

import org.greenrobot.greendao.AbstractDaoMaster;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class AbstractDaoSessionTest<T extends AbstractDaoMaster, S extends AbstractDaoSession> extends DbTest {
    public T daoMaster;
    private final Class<T> daoMasterClass;
    public S daoSession;

    public AbstractDaoSessionTest(Class<T> cls) {
        this(cls, true);
    }

    @Override // org.greenrobot.greendao.test.DbTest
    public void setUp() throws Exception {
        super.setUp();
        try {
            this.daoMaster = this.daoMasterClass.getConstructor(Database.class).newInstance(this.f52443db);
            this.daoMasterClass.getMethod("createAllTables", Database.class, Boolean.TYPE).invoke(null, this.f52443db, Boolean.FALSE);
            this.daoSession = (S) this.daoMaster.newSession();
        } catch (Exception e2) {
            throw new RuntimeException("Could not prepare DAO session test", e2);
        }
    }

    public AbstractDaoSessionTest(Class<T> cls, boolean z10) {
        super(z10);
        this.daoMasterClass = cls;
    }
}

package org.greenrobot.greendao.test;

import org.greenrobot.greendao.AbstractDao;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class AbstractDaoTestStringPk<D extends AbstractDao<T, String>, T> extends AbstractDaoTestSinglePk<D, T, String> {
    public AbstractDaoTestStringPk(Class<D> cls) {
        super(cls);
    }

    @Override // org.greenrobot.greendao.test.AbstractDaoTestSinglePk
    public String createRandomPk() {
        int nextInt = this.random.nextInt(30) + 1;
        StringBuilder sb2 = new StringBuilder();
        for (int i10 = 0; i10 < nextInt; i10++) {
            sb2.append((char) (this.random.nextInt(25) + 97));
        }
        return sb2.toString();
    }
}

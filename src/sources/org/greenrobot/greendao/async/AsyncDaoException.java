package org.greenrobot.greendao.async;

import org.greenrobot.greendao.DaoException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class AsyncDaoException extends DaoException {
    private static final long serialVersionUID = 5872157552005102382L;
    private final AsyncOperation failedOperation;

    public AsyncDaoException(AsyncOperation asyncOperation, Throwable th) {
        super(th);
        this.failedOperation = asyncOperation;
    }

    public AsyncOperation getFailedOperation() {
        return this.failedOperation;
    }
}

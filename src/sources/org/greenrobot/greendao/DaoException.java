package org.greenrobot.greendao;

import android.database.SQLException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class DaoException extends SQLException {
    private static final long serialVersionUID = -5877937327907457779L;

    public DaoException() {
    }

    public void safeInitCause(Throwable th) {
        try {
            initCause(th);
        } catch (Throwable th2) {
            DaoLog.e("Could not set initial cause", th2);
            DaoLog.e("Initial cause is:", th);
        }
    }

    public DaoException(String str) {
        super(str);
    }

    public DaoException(String str, Throwable th) {
        super(str);
        safeInitCause(th);
    }

    public DaoException(Throwable th) {
        safeInitCause(th);
    }
}

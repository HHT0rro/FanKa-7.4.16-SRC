package org.greenrobot.greendao.test;

import android.app.Application;
import android.app.Instrumentation;
import android.database.sqlite.SQLiteDatabase;
import android.test.AndroidTestCase;
import java.util.Random;
import org.greenrobot.greendao.DaoLog;
import org.greenrobot.greendao.DbUtils;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.StandardDatabase;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class DbTest extends AndroidTestCase {
    public static final String DB_NAME = "greendao-unittest-db.temp";
    private Application application;

    /* renamed from: db, reason: collision with root package name */
    public Database f52443db;
    public final boolean inMemory;
    public final Random random;

    public DbTest() {
        this(true);
    }

    public <T extends Application> T createApplication(Class<T> cls) {
        AndroidTestCase.assertNull("Application already created", this.application);
        try {
            T t2 = (T) Instrumentation.newApplication(cls, getContext());
            t2.onCreate();
            this.application = t2;
            return t2;
        } catch (Exception e2) {
            throw new RuntimeException("Could not create application " + ((Object) cls), e2);
        }
    }

    public Database createDatabase() {
        SQLiteDatabase openOrCreateDatabase;
        if (this.inMemory) {
            openOrCreateDatabase = SQLiteDatabase.create(null);
        } else {
            getContext().deleteDatabase(DB_NAME);
            openOrCreateDatabase = getContext().openOrCreateDatabase(DB_NAME, 0, null);
        }
        return new StandardDatabase(openOrCreateDatabase);
    }

    public <T extends Application> T getApplication() {
        AndroidTestCase.assertNotNull("Application not yet created", this.application);
        return (T) this.application;
    }

    public void logTableDump(String str) {
        Database database = this.f52443db;
        if (database instanceof StandardDatabase) {
            DbUtils.logTableDump(((StandardDatabase) database).getSQLiteDatabase(), str);
            return;
        }
        DaoLog.w("Table dump unsupported for " + ((Object) this.f52443db));
    }

    public void setUp() throws Exception {
        super.setUp();
        this.f52443db = createDatabase();
    }

    public void tearDown() throws Exception {
        if (this.application != null) {
            terminateApplication();
        }
        this.f52443db.close();
        if (!this.inMemory) {
            getContext().deleteDatabase(DB_NAME);
        }
        super.tearDown();
    }

    public void terminateApplication() {
        AndroidTestCase.assertNotNull("Application not yet created", this.application);
        this.application.onTerminate();
        this.application = null;
    }

    public DbTest(boolean z10) {
        this.inMemory = z10;
        this.random = new Random();
    }
}

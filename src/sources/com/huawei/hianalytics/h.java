package com.huawei.hianalytics;

import com.huawei.hianalytics.core.log.HiLog;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.database.Database;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class h {
    public static List<String> lmn = new ArrayList();

    /* JADX WARN: Code restructure failed: missing block: B:91:0x004d, code lost:
    
        if (r8 == null) goto L17;
     */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0297  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void lmn(org.greenrobot.greendao.database.Database r19, java.lang.Class<? extends org.greenrobot.greendao.AbstractDao<?, ?>>... r20) {
        /*
            Method dump skipped, instructions count: 667
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hianalytics.h.lmn(org.greenrobot.greendao.database.Database, java.lang.Class[]):void");
    }

    public static void lmn(Database database, String str, boolean z10, Class<? extends AbstractDao<?, ?>>... clsArr) {
        if (clsArr.length < 1) {
            return;
        }
        try {
            for (Class<? extends AbstractDao<?, ?>> cls : clsArr) {
                cls.getDeclaredMethod(str, Database.class, Boolean.TYPE).invoke(null, database, Boolean.valueOf(z10));
            }
        } catch (IllegalAccessException unused) {
            HiLog.e("MigrationHelper", "MigrationHelper reflectMethod IllegalAccessException");
        } catch (NoSuchMethodException unused2) {
            HiLog.e("MigrationHelper", "MigrationHelper reflectMethod NoSuchMethodException");
        } catch (InvocationTargetException unused3) {
            HiLog.e("MigrationHelper", "MigrationHelper reflectMethod InvocationTargetException");
        }
    }

    public static String lmn(Class cls) {
        if (cls == null) {
            return null;
        }
        if (cls.equals(String.class)) {
            return "TEXT";
        }
        if (cls.equals(Long.class) || cls.equals(Integer.class) || cls.equals(Long.TYPE) || cls.equals(Integer.TYPE)) {
            return "INTEGER";
        }
        if (cls.equals(Boolean.class) || cls.equals(Boolean.TYPE)) {
            return "BOOLEAN";
        }
        return null;
    }
}

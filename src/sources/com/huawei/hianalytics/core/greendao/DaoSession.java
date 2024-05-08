package com.huawei.hianalytics.core.greendao;

import com.huawei.hianalytics.core.storage.CommonHeaderEx;
import com.huawei.hianalytics.core.storage.Event;
import java.util.Map;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class DaoSession extends AbstractDaoSession {
    public final CommonHeaderExDao commonHeaderExDao;
    public final DaoConfig commonHeaderExDaoConfig;
    public final EventDao eventDao;
    public final DaoConfig eventDaoConfig;

    public DaoSession(Database database, IdentityScopeType identityScopeType, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig> map) {
        super(database);
        DaoConfig clone = map.get(CommonHeaderExDao.class).clone();
        this.commonHeaderExDaoConfig = clone;
        clone.initIdentityScope(identityScopeType);
        DaoConfig clone2 = map.get(EventDao.class).clone();
        this.eventDaoConfig = clone2;
        clone2.initIdentityScope(identityScopeType);
        CommonHeaderExDao commonHeaderExDao = new CommonHeaderExDao(clone, this);
        this.commonHeaderExDao = commonHeaderExDao;
        EventDao eventDao = new EventDao(clone2, this);
        this.eventDao = eventDao;
        registerDao(CommonHeaderEx.class, commonHeaderExDao);
        registerDao(Event.class, eventDao);
    }

    public void clear() {
        this.commonHeaderExDaoConfig.clearIdentityScope();
        this.eventDaoConfig.clearIdentityScope();
    }

    public CommonHeaderExDao getCommonHeaderExDao() {
        return this.commonHeaderExDao;
    }

    public EventDao getEventDao() {
        return this.eventDao;
    }
}

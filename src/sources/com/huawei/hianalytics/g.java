package com.huawei.hianalytics;

import android.content.Context;
import com.huawei.hianalytics.core.greendao.CommonHeaderExDao;
import com.huawei.hianalytics.core.greendao.EventDao;
import com.huawei.hianalytics.core.storage.CommonHeaderEx;
import com.huawei.hianalytics.core.storage.Event;
import com.huawei.hianalytics.core.storage.IStorageHandler;
import java.util.List;
import java.util.Objects;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.query.Query;
import org.greenrobot.greendao.query.QueryBuilder;
import org.greenrobot.greendao.query.WhereCondition;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class g implements IStorageHandler {
    public static IStorageHandler klm;
    public f lmn;

    public g(Context context) {
        this.lmn = f.lmn(context);
    }

    public static IStorageHandler lmn(Context context) {
        if (klm == null) {
            synchronized (g.class) {
                if (klm == null) {
                    klm = new g(context);
                }
            }
        }
        return klm;
    }

    @Override // com.huawei.hianalytics.core.storage.IStorageHandler
    public void deleteAll() {
        this.lmn.lmn.getEventDao().deleteAll();
    }

    @Override // com.huawei.hianalytics.core.storage.IStorageHandler
    public void deleteByTag(String str) {
        this.lmn.lmn.getEventDao().queryBuilder().where(EventDao.Properties.Servicetag.eq(str), new WhereCondition[0]).buildDelete().executeDeleteWithoutDetachingEntities();
    }

    @Override // com.huawei.hianalytics.core.storage.IStorageHandler
    public void deleteByTagType(String str, String str2) {
        this.lmn.lmn.getEventDao().queryBuilder().where(EventDao.Properties.Servicetag.eq(str), new WhereCondition[0]).where(EventDao.Properties.Evttype.eq(str2), new WhereCondition[0]).buildDelete().executeDeleteWithoutDetachingEntities();
    }

    @Override // com.huawei.hianalytics.core.storage.IStorageHandler
    public void deleteCommonHeaderEx(String str) {
        this.lmn.lmn.getCommonHeaderExDao().queryBuilder().where(CommonHeaderExDao.Properties.EvtExHashCode.eq(str), new WhereCondition[0]).buildDelete().executeDeleteWithoutDetachingEntities();
    }

    @Override // com.huawei.hianalytics.core.storage.IStorageHandler
    public void deleteCommonHeaderExAll() {
        this.lmn.lmn.getCommonHeaderExDao().deleteAll();
    }

    @Override // com.huawei.hianalytics.core.storage.IStorageHandler
    public void deleteEvents(List<Event> list) {
        this.lmn.lmn.getEventDao().deleteInTx(list);
    }

    @Override // com.huawei.hianalytics.core.storage.IStorageHandler
    public long insert(Event event) {
        return this.lmn.lmn.getEventDao().insert(event);
    }

    @Override // com.huawei.hianalytics.core.storage.IStorageHandler
    public void insertEx(List<Event> list) {
        this.lmn.lmn.getEventDao().insertInTx(list);
    }

    @Override // com.huawei.hianalytics.core.storage.IStorageHandler
    public List<Event> readBySql(String str) {
        return this.lmn.lmn.getEventDao().queryBuilder().where(new WhereCondition.StringCondition(str), new WhereCondition[0]).build().forCurrentThread().list();
    }

    @Override // com.huawei.hianalytics.core.storage.IStorageHandler
    public CommonHeaderEx readCommonHeaderEx(String str) {
        Query<CommonHeaderEx> build = this.lmn.lmn.getCommonHeaderExDao().queryBuilder().where(CommonHeaderExDao.Properties.EvtExHashCode.eq(str), new WhereCondition[0]).build();
        if (build != null && build.forCurrentThread() != null && build.forCurrentThread().list() != null && build.forCurrentThread().list().size() > 0) {
            return build.forCurrentThread().list().get(0);
        }
        return new CommonHeaderEx();
    }

    @Override // com.huawei.hianalytics.core.storage.IStorageHandler
    public long readEventSize(String str) {
        return this.lmn.lmn.getEventDao().queryBuilder().where(EventDao.Properties.Servicetag.eq(str), new WhereCondition[0]).buildCount().forCurrentThread().count();
    }

    @Override // com.huawei.hianalytics.core.storage.IStorageHandler
    public List<Event> readEvents(String str, String str2) {
        return this.lmn.lmn.getEventDao().queryBuilder().where(EventDao.Properties.Servicetag.eq(str), new WhereCondition[0]).where(EventDao.Properties.Evttype.eq(str2), new WhereCondition[0]).build().forCurrentThread().list();
    }

    @Override // com.huawei.hianalytics.core.storage.IStorageHandler
    public List<Event> readEventsAll() {
        return this.lmn.lmn.getEventDao().loadAll();
    }

    @Override // com.huawei.hianalytics.core.storage.IStorageHandler
    public List<Event> readEventsDefault(String str, String str2) {
        QueryBuilder<Event> where = this.lmn.lmn.getEventDao().queryBuilder().where(EventDao.Properties.Servicetag.eq(str), new WhereCondition[0]);
        Property property = EventDao.Properties.Processname;
        return where.whereOr(property.eq(str2), property.eq(""), new WhereCondition[0]).build().forCurrentThread().list();
    }

    @Override // com.huawei.hianalytics.core.storage.IStorageHandler
    public List<Event> readOldEvents(String str, String str2, String str3) {
        f fVar = this.lmn;
        Objects.requireNonNull(fVar);
        long j10 = c.klm().lmn.f28750g;
        if (j10 == 0) {
            j10 = System.currentTimeMillis();
        }
        QueryBuilder<Event> where = fVar.lmn.getEventDao().queryBuilder().where(EventDao.Properties.Servicetag.eq(str), new WhereCondition[0]).where(EventDao.Properties.Evttype.eq(str2), new WhereCondition[0]);
        Property property = EventDao.Properties.Processname;
        return where.whereOr(property.eq(str3), property.eq(""), new WhereCondition[0]).where(EventDao.Properties.Evttime.lt(Long.valueOf(j10)), new WhereCondition[0]).build().forCurrentThread().list();
    }

    @Override // com.huawei.hianalytics.core.storage.IStorageHandler
    public long insert(CommonHeaderEx commonHeaderEx) {
        return this.lmn.lmn.getCommonHeaderExDao().insertOrReplace(commonHeaderEx);
    }

    @Override // com.huawei.hianalytics.core.storage.IStorageHandler
    public long readEventSize(String str, String str2) {
        return this.lmn.lmn.getEventDao().queryBuilder().where(EventDao.Properties.Servicetag.eq(str), new WhereCondition[0]).where(EventDao.Properties.Evttype.eq(str2), new WhereCondition[0]).buildCount().forCurrentThread().count();
    }

    @Override // com.huawei.hianalytics.core.storage.IStorageHandler
    public List<Event> readEvents(String str, String str2, String str3) {
        QueryBuilder<Event> where = this.lmn.lmn.getEventDao().queryBuilder().where(EventDao.Properties.Servicetag.eq(str), new WhereCondition[0]).where(EventDao.Properties.Evttype.eq(str2), new WhereCondition[0]);
        Property property = EventDao.Properties.Processname;
        return where.whereOr(property.eq(str3), property.eq(""), new WhereCondition[0]).build().forCurrentThread().list();
    }
}

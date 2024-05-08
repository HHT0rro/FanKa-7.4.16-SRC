package com.huawei.hianalytics.core.greendao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import com.huawei.hianalytics.core.storage.Event;
import e9.a;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class EventDao extends AbstractDao<Event, Long> {
    public static final String TABLENAME = "EVENT";

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class Properties {
        public static final Property Id = new Property(0, Long.class, "id", true, "_id");
        public static final Property Evtid = new Property(1, String.class, "evtid", false, "EVTID");
        public static final Property Evttype = new Property(2, String.class, "evttype", false, "EVTTYPE");
        public static final Property Content = new Property(3, String.class, "content", false, "CONTENT");
        public static final Property Evttime = new Property(4, String.class, "evttime", false, "EVTTIME");
        public static final Property Servicetag = new Property(5, String.class, "servicetag", false, "SERVICETAG");
        public static final Property Sessionid = new Property(6, String.class, "sessionid", false, "SESSIONID");
        public static final Property Sessionname = new Property(7, String.class, "sessionname", false, "SESSIONNAME");
        public static final Property EvtExHashCode = new Property(8, String.class, "evtExHashCode", false, "EVT_EX_HASH_CODE");
        public static final Property Processname = new Property(9, String.class, "processname", false, "PROCESSNAME");
    }

    public EventDao(DaoConfig daoConfig) {
        super(daoConfig);
    }

    public static void createTable(Database database, boolean z10) {
        database.execSQL("CREATE TABLE " + (z10 ? "IF NOT EXISTS " : "") + "\"EVENT\" (\"_id\" INTEGER PRIMARY KEY ,\"EVTID\" TEXT,\"EVTTYPE\" TEXT,\"CONTENT\" TEXT,\"EVTTIME\" TEXT,\"SERVICETAG\" TEXT,\"SESSIONID\" TEXT,\"SESSIONNAME\" TEXT,\"EVT_EX_HASH_CODE\" TEXT,\"PROCESSNAME\" TEXT);");
    }

    public static void dropTable(Database database, boolean z10) {
        StringBuilder b4 = a.b("DROP TABLE ");
        b4.append(z10 ? "IF EXISTS " : "");
        b4.append("\"EVENT\"");
        database.execSQL(b4.toString());
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public final boolean isEntityUpdateable() {
        return true;
    }

    public EventDao(DaoConfig daoConfig, DaoSession daoSession) {
        super(daoConfig, daoSession);
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public Long getKey(Event event) {
        if (event != null) {
            return event.getId();
        }
        return null;
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public boolean hasKey(Event event) {
        return event.getId() != null;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.greenrobot.greendao.AbstractDao
    public Long readKey(Cursor cursor, int i10) {
        int i11 = i10 + 0;
        if (cursor.isNull(i11)) {
            return null;
        }
        return Long.valueOf(cursor.getLong(i11));
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public final Long updateKeyAfterInsert(Event event, long j10) {
        event.setId(Long.valueOf(j10));
        return Long.valueOf(j10);
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public final void bindValues(DatabaseStatement databaseStatement, Event event) {
        databaseStatement.clearBindings();
        Long id2 = event.getId();
        if (id2 != null) {
            databaseStatement.bindLong(1, id2.longValue());
        }
        String evtid = event.getEvtid();
        if (evtid != null) {
            databaseStatement.bindString(2, evtid);
        }
        String evttype = event.getEvttype();
        if (evttype != null) {
            databaseStatement.bindString(3, evttype);
        }
        String content = event.getContent();
        if (content != null) {
            databaseStatement.bindString(4, content);
        }
        String evttime = event.getEvttime();
        if (evttime != null) {
            databaseStatement.bindString(5, evttime);
        }
        String servicetag = event.getServicetag();
        if (servicetag != null) {
            databaseStatement.bindString(6, servicetag);
        }
        String sessionid = event.getSessionid();
        if (sessionid != null) {
            databaseStatement.bindString(7, sessionid);
        }
        String sessionname = event.getSessionname();
        if (sessionname != null) {
            databaseStatement.bindString(8, sessionname);
        }
        String evtExHashCode = event.getEvtExHashCode();
        if (evtExHashCode != null) {
            databaseStatement.bindString(9, evtExHashCode);
        }
        String processname = event.getProcessname();
        if (processname != null) {
            databaseStatement.bindString(10, processname);
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.greenrobot.greendao.AbstractDao
    public Event readEntity(Cursor cursor, int i10) {
        int i11 = i10 + 0;
        Long valueOf = cursor.isNull(i11) ? null : Long.valueOf(cursor.getLong(i11));
        int i12 = i10 + 1;
        String string = cursor.isNull(i12) ? null : cursor.getString(i12);
        int i13 = i10 + 2;
        String string2 = cursor.isNull(i13) ? null : cursor.getString(i13);
        int i14 = i10 + 3;
        String string3 = cursor.isNull(i14) ? null : cursor.getString(i14);
        int i15 = i10 + 4;
        String string4 = cursor.isNull(i15) ? null : cursor.getString(i15);
        int i16 = i10 + 5;
        String string5 = cursor.isNull(i16) ? null : cursor.getString(i16);
        int i17 = i10 + 6;
        String string6 = cursor.isNull(i17) ? null : cursor.getString(i17);
        int i18 = i10 + 7;
        String string7 = cursor.isNull(i18) ? null : cursor.getString(i18);
        int i19 = i10 + 8;
        int i20 = i10 + 9;
        return new Event(valueOf, string, string2, string3, string4, string5, string6, string7, cursor.isNull(i19) ? null : cursor.getString(i19), cursor.isNull(i20) ? null : cursor.getString(i20));
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public void readEntity(Cursor cursor, Event event, int i10) {
        int i11 = i10 + 0;
        event.setId(cursor.isNull(i11) ? null : Long.valueOf(cursor.getLong(i11)));
        int i12 = i10 + 1;
        event.setEvtid(cursor.isNull(i12) ? null : cursor.getString(i12));
        int i13 = i10 + 2;
        event.setEvttype(cursor.isNull(i13) ? null : cursor.getString(i13));
        int i14 = i10 + 3;
        event.setContent(cursor.isNull(i14) ? null : cursor.getString(i14));
        int i15 = i10 + 4;
        event.setEvttime(cursor.isNull(i15) ? null : cursor.getString(i15));
        int i16 = i10 + 5;
        event.setServicetag(cursor.isNull(i16) ? null : cursor.getString(i16));
        int i17 = i10 + 6;
        event.setSessionid(cursor.isNull(i17) ? null : cursor.getString(i17));
        int i18 = i10 + 7;
        event.setSessionname(cursor.isNull(i18) ? null : cursor.getString(i18));
        int i19 = i10 + 8;
        event.setEvtExHashCode(cursor.isNull(i19) ? null : cursor.getString(i19));
        int i20 = i10 + 9;
        event.setProcessname(cursor.isNull(i20) ? null : cursor.getString(i20));
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public final void bindValues(SQLiteStatement sQLiteStatement, Event event) {
        sQLiteStatement.clearBindings();
        Long id2 = event.getId();
        if (id2 != null) {
            sQLiteStatement.bindLong(1, id2.longValue());
        }
        String evtid = event.getEvtid();
        if (evtid != null) {
            sQLiteStatement.bindString(2, evtid);
        }
        String evttype = event.getEvttype();
        if (evttype != null) {
            sQLiteStatement.bindString(3, evttype);
        }
        String content = event.getContent();
        if (content != null) {
            sQLiteStatement.bindString(4, content);
        }
        String evttime = event.getEvttime();
        if (evttime != null) {
            sQLiteStatement.bindString(5, evttime);
        }
        String servicetag = event.getServicetag();
        if (servicetag != null) {
            sQLiteStatement.bindString(6, servicetag);
        }
        String sessionid = event.getSessionid();
        if (sessionid != null) {
            sQLiteStatement.bindString(7, sessionid);
        }
        String sessionname = event.getSessionname();
        if (sessionname != null) {
            sQLiteStatement.bindString(8, sessionname);
        }
        String evtExHashCode = event.getEvtExHashCode();
        if (evtExHashCode != null) {
            sQLiteStatement.bindString(9, evtExHashCode);
        }
        String processname = event.getProcessname();
        if (processname != null) {
            sQLiteStatement.bindString(10, processname);
        }
    }
}

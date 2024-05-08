package com.google.android.datatransport.runtime.scheduling.persistence;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.Arrays;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;

/* compiled from: SchemaManager.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class f0 extends SQLiteOpenHelper {

    /* renamed from: d, reason: collision with root package name */
    public static int f19443d = 4;

    /* renamed from: e, reason: collision with root package name */
    public static final a f19444e;

    /* renamed from: f, reason: collision with root package name */
    public static final a f19445f;

    /* renamed from: g, reason: collision with root package name */
    public static final a f19446g;

    /* renamed from: h, reason: collision with root package name */
    public static final a f19447h;

    /* renamed from: i, reason: collision with root package name */
    public static final List<a> f19448i;

    /* renamed from: b, reason: collision with root package name */
    public final int f19449b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f19450c;

    /* compiled from: SchemaManager.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface a {
        void a(SQLiteDatabase sQLiteDatabase);
    }

    static {
        a b4 = b0.b();
        f19444e = b4;
        a b10 = c0.b();
        f19445f = b10;
        a b11 = d0.b();
        f19446g = b11;
        a b12 = e0.b();
        f19447h = b12;
        f19448i = Arrays.asList(b4, b10, b11, b12);
    }

    @Inject
    public f0(Context context, @Named("SQLITE_DB_NAME") String str, @Named("SCHEMA_VERSION") int i10) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, i10);
        this.f19450c = false;
        this.f19449b = i10;
    }

    public static /* synthetic */ void b(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE events (_id INTEGER PRIMARY KEY, context_id INTEGER NOT NULL, transport_name TEXT NOT NULL, timestamp_ms INTEGER NOT NULL, uptime_ms INTEGER NOT NULL, payload BLOB NOT NULL, code INTEGER, num_attempts INTEGER NOT NULL,FOREIGN KEY (context_id) REFERENCES transport_contexts(_id) ON DELETE CASCADE)");
        sQLiteDatabase.execSQL("CREATE TABLE event_metadata (_id INTEGER PRIMARY KEY, event_id INTEGER NOT NULL, name TEXT NOT NULL, value TEXT NOT NULL,FOREIGN KEY (event_id) REFERENCES events(_id) ON DELETE CASCADE)");
        sQLiteDatabase.execSQL("CREATE TABLE transport_contexts (_id INTEGER PRIMARY KEY, backend_name TEXT NOT NULL, priority INTEGER NOT NULL, next_request_ms INTEGER NOT NULL)");
        sQLiteDatabase.execSQL("CREATE INDEX events_backend_id on events(context_id)");
        sQLiteDatabase.execSQL("CREATE UNIQUE INDEX contexts_backend_priority on transport_contexts(backend_name, priority)");
    }

    public static /* synthetic */ void d(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("ALTER TABLE transport_contexts ADD COLUMN extras BLOB");
        sQLiteDatabase.execSQL("CREATE UNIQUE INDEX contexts_backend_priority_extras on transport_contexts(backend_name, priority, extras)");
        sQLiteDatabase.execSQL("DROP INDEX contexts_backend_priority");
    }

    public static /* synthetic */ void f(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("ALTER TABLE events ADD COLUMN inline BOOLEAN NOT NULL DEFAULT 1");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS event_payloads");
        sQLiteDatabase.execSQL("CREATE TABLE event_payloads (sequence_num INTEGER NOT NULL, event_id INTEGER NOT NULL, bytes BLOB NOT NULL,FOREIGN KEY (event_id) REFERENCES events(_id) ON DELETE CASCADE,PRIMARY KEY (sequence_num, event_id))");
    }

    public final void a(SQLiteDatabase sQLiteDatabase) {
        if (this.f19450c) {
            return;
        }
        onConfigure(sQLiteDatabase);
    }

    public final void g(SQLiteDatabase sQLiteDatabase, int i10) {
        a(sQLiteDatabase);
        i(sQLiteDatabase, 0, i10);
    }

    public final void i(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        List<a> list = f19448i;
        if (i11 <= list.size()) {
            while (i10 < i11) {
                f19448i.get(i10).a(sQLiteDatabase);
                i10++;
            }
            return;
        }
        throw new IllegalArgumentException("Migration from " + i10 + " to " + i11 + " was requested, but cannot be performed. Only " + list.size() + " migrations are provided");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onConfigure(SQLiteDatabase sQLiteDatabase) {
        this.f19450c = true;
        sQLiteDatabase.rawQuery("PRAGMA busy_timeout=0;", new String[0]).close();
        sQLiteDatabase.setForeignKeyConstraintsEnabled(true);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        g(sQLiteDatabase, this.f19449b);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        sQLiteDatabase.execSQL("DROP TABLE events");
        sQLiteDatabase.execSQL("DROP TABLE event_metadata");
        sQLiteDatabase.execSQL("DROP TABLE transport_contexts");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS event_payloads");
        g(sQLiteDatabase, i11);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        a(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        a(sQLiteDatabase);
        i(sQLiteDatabase, i10, i11);
    }
}

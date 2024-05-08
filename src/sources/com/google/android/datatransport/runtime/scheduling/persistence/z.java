package com.google.android.datatransport.runtime.scheduling.persistence;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.os.SystemClock;
import android.util.Base64;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.synchronization.SynchronizationException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;
import t4.a;

/* compiled from: SQLiteEventStore.java */
@Singleton
@WorkerThread
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class z implements com.google.android.datatransport.runtime.scheduling.persistence.b, t4.a {

    /* renamed from: f, reason: collision with root package name */
    public static final com.google.android.datatransport.a f19480f = com.google.android.datatransport.a.b("proto");

    /* renamed from: b, reason: collision with root package name */
    public final f0 f19481b;

    /* renamed from: c, reason: collision with root package name */
    public final u4.a f19482c;

    /* renamed from: d, reason: collision with root package name */
    public final u4.a f19483d;

    /* renamed from: e, reason: collision with root package name */
    public final com.google.android.datatransport.runtime.scheduling.persistence.c f19484e;

    /* compiled from: SQLiteEventStore.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface b<T, U> {
        U apply(T t2);
    }

    /* compiled from: SQLiteEventStore.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public final String f19485a;

        /* renamed from: b, reason: collision with root package name */
        public final String f19486b;

        public c(String str, String str2) {
            this.f19485a = str;
            this.f19486b = str2;
        }
    }

    /* compiled from: SQLiteEventStore.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface d<T> {
        T a();
    }

    @Inject
    public z(u4.a aVar, u4.a aVar2, com.google.android.datatransport.runtime.scheduling.persistence.c cVar, f0 f0Var) {
        this.f19481b = f0Var;
        this.f19482c = aVar;
        this.f19483d = aVar2;
        this.f19484e = cVar;
    }

    public static /* synthetic */ List A(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        while (cursor.moveToNext()) {
            arrayList.add(TransportContext.a().b(cursor.getString(1)).d(v4.a.b(cursor.getInt(2))).c(L(cursor.getString(3))).a());
        }
        return arrayList;
    }

    public static /* synthetic */ List B(SQLiteDatabase sQLiteDatabase) {
        return (List) Q(sQLiteDatabase.rawQuery("SELECT distinct t._id, t.backend_name, t.priority, t.extras FROM transport_contexts AS t, events AS e WHERE e.context_id = t._id", new String[0]), r.a());
    }

    public static /* synthetic */ List C(z zVar, TransportContext transportContext, SQLiteDatabase sQLiteDatabase) {
        List<PersistedEvent> J = zVar.J(sQLiteDatabase, transportContext);
        return zVar.l(J, zVar.K(sQLiteDatabase, J));
    }

    public static /* synthetic */ Object D(z zVar, List list, TransportContext transportContext, Cursor cursor) {
        while (cursor.moveToNext()) {
            long j10 = cursor.getLong(0);
            boolean z10 = cursor.getInt(7) != 0;
            EventInternal.a k10 = EventInternal.a().j(cursor.getString(1)).i(cursor.getLong(2)).k(cursor.getLong(3));
            if (z10) {
                k10.h(new n4.d(O(cursor.getString(4)), cursor.getBlob(5)));
            } else {
                k10.h(new n4.d(O(cursor.getString(4)), zVar.M(j10)));
            }
            if (!cursor.isNull(6)) {
                k10.g(Integer.valueOf(cursor.getInt(6)));
            }
            list.add(PersistedEvent.create(j10, transportContext, k10.d()));
        }
        return null;
    }

    public static /* synthetic */ Object E(Map map, Cursor cursor) {
        while (true) {
            if (!cursor.moveToNext()) {
                return null;
            }
            long j10 = cursor.getLong(0);
            Set set = (Set) map.get(Long.valueOf(j10));
            if (set == null) {
                set = new HashSet();
                map.put(Long.valueOf(j10), set);
            }
            set.add(new c(cursor.getString(1), cursor.getString(2)));
        }
    }

    public static /* synthetic */ Long F(z zVar, TransportContext transportContext, EventInternal eventInternal, SQLiteDatabase sQLiteDatabase) {
        if (zVar.k()) {
            return -1L;
        }
        long d10 = zVar.d(sQLiteDatabase, transportContext);
        int e2 = zVar.f19484e.e();
        byte[] a10 = eventInternal.e().a();
        boolean z10 = a10.length <= e2;
        ContentValues contentValues = new ContentValues();
        contentValues.put("context_id", Long.valueOf(d10));
        contentValues.put("transport_name", eventInternal.j());
        contentValues.put("timestamp_ms", Long.valueOf(eventInternal.f()));
        contentValues.put("uptime_ms", Long.valueOf(eventInternal.k()));
        contentValues.put("payload_encoding", eventInternal.e().b().a());
        contentValues.put("code", eventInternal.d());
        contentValues.put("num_attempts", (Integer) 0);
        contentValues.put("inline", Boolean.valueOf(z10));
        contentValues.put("payload", z10 ? a10 : new byte[0]);
        long insert = sQLiteDatabase.insert("events", null, contentValues);
        if (!z10) {
            int ceil = (int) Math.ceil(a10.length / e2);
            for (int i10 = 1; i10 <= ceil; i10++) {
                byte[] copyOfRange = Arrays.copyOfRange(a10, (i10 - 1) * e2, Math.min(i10 * e2, a10.length));
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("event_id", Long.valueOf(insert));
                contentValues2.put("sequence_num", Integer.valueOf(i10));
                contentValues2.put("bytes", copyOfRange);
                sQLiteDatabase.insert("event_payloads", null, contentValues2);
            }
        }
        for (Map.Entry<String, String> entry : eventInternal.i().entrySet()) {
            ContentValues contentValues3 = new ContentValues();
            contentValues3.put("event_id", Long.valueOf(insert));
            contentValues3.put("name", entry.getKey());
            contentValues3.put("value", entry.getValue());
            sQLiteDatabase.insert("event_metadata", null, contentValues3);
        }
        return Long.valueOf(insert);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ byte[] G(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        int i10 = 0;
        while (cursor.moveToNext()) {
            byte[] blob = cursor.getBlob(0);
            arrayList.add(blob);
            i10 += blob.length;
        }
        byte[] bArr = new byte[i10];
        int i11 = 0;
        for (int i12 = 0; i12 < arrayList.size(); i12++) {
            byte[] bArr2 = (byte[]) arrayList.get(i12);
            System.arraycopy((Object) bArr2, 0, (Object) bArr, i11, bArr2.length);
            i11 += bArr2.length;
        }
        return bArr;
    }

    public static /* synthetic */ Object H(String str, SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.compileStatement(str).execute();
        sQLiteDatabase.compileStatement("DELETE FROM events WHERE num_attempts >= 16").execute();
        return null;
    }

    public static /* synthetic */ Object I(long j10, TransportContext transportContext, SQLiteDatabase sQLiteDatabase) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("next_request_ms", Long.valueOf(j10));
        if (sQLiteDatabase.update("transport_contexts", contentValues, "backend_name = ? and priority = ?", new String[]{transportContext.b(), String.valueOf(v4.a.a(transportContext.d()))}) < 1) {
            contentValues.put("backend_name", transportContext.b());
            contentValues.put("priority", Integer.valueOf(v4.a.a(transportContext.d())));
            sQLiteDatabase.insert("transport_contexts", null, contentValues);
        }
        return null;
    }

    public static byte[] L(@Nullable String str) {
        if (str == null) {
            return null;
        }
        return Base64.decode(str, 0);
    }

    public static com.google.android.datatransport.a O(@Nullable String str) {
        if (str == null) {
            return f19480f;
        }
        return com.google.android.datatransport.a.b(str);
    }

    public static String P(Iterable<PersistedEvent> iterable) {
        StringBuilder sb2 = new StringBuilder("(");
        Iterator<PersistedEvent> iterator2 = iterable.iterator2();
        while (iterator2.hasNext()) {
            sb2.append(iterator2.next().getId());
            if (iterator2.hasNext()) {
                sb2.append(',');
            }
        }
        sb2.append(')');
        return sb2.toString();
    }

    public static <T> T Q(Cursor cursor, b<Cursor, T> bVar) {
        try {
            return bVar.apply(cursor);
        } finally {
            cursor.close();
        }
    }

    public static /* synthetic */ Object r(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.beginTransaction();
        return null;
    }

    public static /* synthetic */ Object u(Throwable th) {
        throw new SynchronizationException("Timed out while trying to acquire the lock.", th);
    }

    public static /* synthetic */ SQLiteDatabase w(Throwable th) {
        throw new SynchronizationException("Timed out while trying to open db.", th);
    }

    public static /* synthetic */ Long x(Cursor cursor) {
        if (cursor.moveToNext()) {
            return Long.valueOf(cursor.getLong(0));
        }
        return 0L;
    }

    public static /* synthetic */ Long y(Cursor cursor) {
        if (cursor.moveToNext()) {
            return Long.valueOf(cursor.getLong(0));
        }
        return null;
    }

    public static /* synthetic */ Boolean z(z zVar, TransportContext transportContext, SQLiteDatabase sQLiteDatabase) {
        Long i10 = zVar.i(sQLiteDatabase, transportContext);
        if (i10 == null) {
            return Boolean.FALSE;
        }
        return (Boolean) Q(zVar.e().rawQuery("SELECT 1 FROM events WHERE context_id = ? LIMIT 1", new String[]{i10.toString()}), s.a());
    }

    public final List<PersistedEvent> J(SQLiteDatabase sQLiteDatabase, TransportContext transportContext) {
        ArrayList arrayList = new ArrayList();
        Long i10 = i(sQLiteDatabase, transportContext);
        if (i10 == null) {
            return arrayList;
        }
        Q(sQLiteDatabase.query("events", new String[]{"_id", "transport_name", "timestamp_ms", "uptime_ms", "payload_encoding", "payload", "code", "inline"}, "context_id = ?", new String[]{i10.toString()}, null, null, null, String.valueOf(this.f19484e.d())), l.a(this, arrayList, transportContext));
        return arrayList;
    }

    public final Map<Long, Set<c>> K(SQLiteDatabase sQLiteDatabase, List<PersistedEvent> list) {
        HashMap hashMap = new HashMap();
        StringBuilder sb2 = new StringBuilder("event_id IN (");
        for (int i10 = 0; i10 < list.size(); i10++) {
            sb2.append(list.get(i10).getId());
            if (i10 < list.size() - 1) {
                sb2.append(',');
            }
        }
        sb2.append(')');
        Q(sQLiteDatabase.query("event_metadata", new String[]{"event_id", "name", "value"}, sb2.toString(), null, null, null, null), n.a(hashMap));
        return hashMap;
    }

    public final byte[] M(long j10) {
        return (byte[]) Q(e().query("event_payloads", new String[]{"bytes"}, "event_id = ?", new String[]{String.valueOf(j10)}, null, null, "sequence_num"), m.a());
    }

    public final <T> T N(d<T> dVar, b<Throwable, T> bVar) {
        long time = this.f19483d.getTime();
        while (true) {
            try {
                return dVar.a();
            } catch (SQLiteDatabaseLockedException e2) {
                if (this.f19483d.getTime() >= this.f19484e.b() + time) {
                    return bVar.apply(e2);
                }
                SystemClock.sleep(50L);
            }
        }
    }

    @Override // t4.a
    public <T> T a(a.InterfaceC0823a<T> interfaceC0823a) {
        SQLiteDatabase e2 = e();
        b(e2);
        try {
            T execute = interfaceC0823a.execute();
            e2.setTransactionSuccessful();
            return execute;
        } finally {
            e2.endTransaction();
        }
    }

    public final void b(SQLiteDatabase sQLiteDatabase) {
        N(o.b(sQLiteDatabase), p.a());
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.b
    public void c(TransportContext transportContext, long j10) {
        j(h.a(j10, transportContext));
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.b
    public int cleanUp() {
        return ((Integer) j(k.a(this.f19482c.getTime() - this.f19484e.c()))).intValue();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f19481b.close();
    }

    public final long d(SQLiteDatabase sQLiteDatabase, TransportContext transportContext) {
        Long i10 = i(sQLiteDatabase, transportContext);
        if (i10 != null) {
            return i10.longValue();
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("backend_name", transportContext.b());
        contentValues.put("priority", Integer.valueOf(v4.a.a(transportContext.d())));
        contentValues.put("next_request_ms", (Integer) 0);
        if (transportContext.c() != null) {
            contentValues.put("extras", Base64.encodeToString(transportContext.c(), 0));
        }
        return sQLiteDatabase.insert("transport_contexts", null, contentValues);
    }

    @VisibleForTesting
    public SQLiteDatabase e() {
        f0 f0Var = this.f19481b;
        f0Var.getClass();
        return (SQLiteDatabase) N(q.b(f0Var), t.a());
    }

    public final long f() {
        return e().compileStatement("PRAGMA page_count").simpleQueryForLong();
    }

    public final long g() {
        return e().compileStatement("PRAGMA page_size").simpleQueryForLong();
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.b
    public void h(Iterable<PersistedEvent> iterable) {
        if (iterable.iterator2().hasNext()) {
            e().compileStatement("DELETE FROM events WHERE _id in " + P(iterable)).execute();
        }
    }

    @Nullable
    public final Long i(SQLiteDatabase sQLiteDatabase, TransportContext transportContext) {
        StringBuilder sb2 = new StringBuilder("backend_name = ? and priority = ?");
        ArrayList arrayList = new ArrayList(Arrays.asList(transportContext.b(), String.valueOf(v4.a.a(transportContext.d()))));
        if (transportContext.c() != null) {
            sb2.append(" and extras = ?");
            arrayList.add(Base64.encodeToString(transportContext.c(), 0));
        }
        return (Long) Q(sQLiteDatabase.query("transport_contexts", new String[]{"_id"}, sb2.toString(), (String[]) arrayList.toArray(new String[0]), null, null, null), v.a());
    }

    public final <T> T j(b<SQLiteDatabase, T> bVar) {
        SQLiteDatabase e2 = e();
        e2.beginTransaction();
        try {
            T apply = bVar.apply(e2);
            e2.setTransactionSuccessful();
            return apply;
        } finally {
            e2.endTransaction();
        }
    }

    public final boolean k() {
        return f() * g() >= this.f19484e.f();
    }

    public final List<PersistedEvent> l(List<PersistedEvent> list, Map<Long, Set<c>> map) {
        ListIterator<PersistedEvent> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            PersistedEvent next = listIterator.next();
            if (map.containsKey(Long.valueOf(next.getId()))) {
                EventInternal.a l10 = next.getEvent().l();
                for (c cVar : map.get(Long.valueOf(next.getId()))) {
                    l10.c(cVar.f19485a, cVar.f19486b);
                }
                listIterator.set(PersistedEvent.create(next.getId(), next.getTransportContext(), l10.d()));
            }
        }
        return list;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.b
    public Iterable<TransportContext> o() {
        return (Iterable) j(j.a());
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.b
    public long p(TransportContext transportContext) {
        return ((Long) Q(e().rawQuery("SELECT next_request_ms FROM transport_contexts WHERE backend_name = ? and priority = ?", new String[]{transportContext.b(), String.valueOf(v4.a.a(transportContext.d()))}), x.a())).longValue();
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.b
    public boolean q(TransportContext transportContext) {
        return ((Boolean) j(y.a(this, transportContext))).booleanValue();
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.b
    public void s(Iterable<PersistedEvent> iterable) {
        if (iterable.iterator2().hasNext()) {
            j(w.a("UPDATE events SET num_attempts = num_attempts + 1 WHERE _id in " + P(iterable)));
        }
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.b
    public Iterable<PersistedEvent> t(TransportContext transportContext) {
        return (Iterable) j(i.a(this, transportContext));
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.b
    @Nullable
    public PersistedEvent v(TransportContext transportContext, EventInternal eventInternal) {
        p4.a.b("SQLiteEventStore", "Storing event with priority=%s, name=%s for destination %s", transportContext.d(), eventInternal.j(), transportContext.b());
        long longValue = ((Long) j(u.a(this, transportContext, eventInternal))).longValue();
        if (longValue < 1) {
            return null;
        }
        return PersistedEvent.create(longValue, transportContext, eventInternal);
    }
}

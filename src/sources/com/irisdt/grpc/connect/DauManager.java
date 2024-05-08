package com.irisdt.grpc.connect;

import com.google.protobuf.InvalidProtocolBufferException;
import com.irisdt.CommonProtos;
import com.irisdt.Irisdt;
import com.irisdt.StatConfig;
import com.irisdt.biz.Dau;
import com.irisdt.dau.DayActiveUserProtos;
import com.irisdt.db.DBHelper;
import com.irisdt.db.DBManager;
import com.irisdt.db.Entity;
import com.irisdt.grpc.ConnectManager;
import com.irisdt.util.NamedRunnable;
import com.irisdt.util.ThreadManager;
import com.irisdt.util.Utils;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class DauManager {
    public static final String CREATE_TABLE_SQL = "create table if not exists irisdt_dau (id integer primary key autoincrement, log blob)";
    public static final String TABLE = "irisdt_dau";
    private static final String TAG = "DauManager";
    private Dau.OnDauListener mDauListener;
    private Runnable regularRunnable;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class InstanceHolder {
        private static final DauManager INSTANCE = new DauManager();

        private InstanceHolder() {
        }
    }

    public static DauManager getInstance() {
        return InstanceHolder.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$recordByDB$0(DayActiveUserProtos.Request request) {
        DBManager.getInstance().insert(TABLE, new Entity(serialize(request)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void recordByDB(final DayActiveUserProtos.Request request) {
        ThreadManager.startThread(new Runnable() { // from class: com.irisdt.grpc.connect.b
            @Override // java.lang.Runnable
            public final void run() {
                DauManager.this.lambda$recordByDB$0(request);
            }
        });
    }

    private byte[] serialize(DayActiveUserProtos.Request request) {
        return request.toByteArray();
    }

    public boolean isLocalCacheEnable() {
        return Dau.getInstance().isLocalCacheEnable() && DBHelper.getInstance().dbIsAvailable();
    }

    public void record(DayActiveUserProtos.Request.Builder builder, Long l10, String str) {
        record(builder, false, l10, str);
    }

    public void recordAndDelay(DayActiveUserProtos.Request.Builder builder) {
        record(builder, true, null, null);
    }

    public void setOnDauListener(Dau.OnDauListener onDauListener) {
        this.mDauListener = onDauListener;
    }

    public void uploadByDB(int i10) throws InvalidProtocolBufferException, ExecutionException, InterruptedException, TimeoutException {
        Map<Long, Entity> query = DBManager.getInstance().query(TABLE, i10);
        if (StatConfig.isDauLogEnable()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(">>> before uploadByDB,table size: ");
            sb2.append(DBManager.getInstance().count(TABLE));
        }
        while (query != null && query.size() > 0) {
            for (Entity entity : query.values()) {
                ThreadManager.startThreadSync(new DauRunnable(DayActiveUserProtos.Request.parseFrom(entity.getBlob()), entity.getId()), 10);
            }
            query = DBManager.getInstance().query(TABLE, i10);
        }
        if (StatConfig.isDauLogEnable()) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(">>> after uploadByDB,table size: ");
            sb3.append(DBManager.getInstance().count(TABLE));
        }
    }

    private DauManager() {
        this.regularRunnable = new Runnable() { // from class: com.irisdt.grpc.connect.DauManager.1
            @Override // java.lang.Runnable
            public void run() {
                if (DauManager.this.isLocalCacheEnable()) {
                    DauManager.this.recordByDB(DayActiveUserProtos.Request.newBuilder().setCommon(Irisdt.getCommon().getProtoData()).setName(DayActiveUserProtos.NAME.REGULAR).setClientTime(System.currentTimeMillis()).build());
                } else {
                    ThreadManager.startThread(new DauRunnable(DayActiveUserProtos.Request.newBuilder().setCommon(Irisdt.getCommon().getProtoData()).setName(DayActiveUserProtos.NAME.REGULAR).setClientTime(System.currentTimeMillis()).build()));
                }
                if (DauManager.this.mDauListener != null) {
                    DauManager.this.mDauListener.onDau(DayActiveUserProtos.NAME.REGULAR);
                }
                if (StatConfig.isDauEnable()) {
                    Utils.postUIRunnable(DauManager.this.regularRunnable, Dau.getInstance().getHeartbeatSeconds());
                }
            }
        };
    }

    private void record(DayActiveUserProtos.Request.Builder builder, boolean z10, Long l10, String str) {
        if (StatConfig.isDauEnable() && ConnectManager.isInit()) {
            builder.setCommon(Irisdt.getCommon().getProtoData());
            if (l10 != null || str != null) {
                CommonProtos.Common.Builder builder2 = Irisdt.getCommon().getProtoData().toBuilder();
                builder2.setUid(l10 == null ? 0L : l10.longValue());
                builder2.setUidStr(Utils.getStringValue(str));
                builder.setCommon(builder2.build());
            }
            if (isLocalCacheEnable()) {
                recordByDB(builder.build());
            } else {
                ThreadManager.startThread(new DauRunnable(builder.build()));
            }
            Dau.OnDauListener onDauListener = this.mDauListener;
            if (onDauListener != null) {
                onDauListener.onDau(builder.getName());
            }
            Utils.removeUIRunnable(this.regularRunnable);
            if (z10) {
                Utils.postUIRunnable(this.regularRunnable, Dau.getInstance().getHeartbeatSeconds());
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class DauRunnable extends NamedRunnable {
        private long databaseId;
        private DayActiveUserProtos.Request request;

        public DauRunnable(DayActiveUserProtos.Request request) {
            super(StatConfig.getThreadName("dau"));
            this.request = request;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:16:0x007e  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x00a9  */
        /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
        @Override // com.irisdt.util.NamedRunnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void execute() {
            /*
                r13 = this;
                boolean r0 = com.irisdt.StatConfig.isDauLogEnable()
                r1 = 1
                r2 = 2
                r3 = 0
                if (r0 == 0) goto L1a
                com.irisdt.util.Logger r0 = com.irisdt.StatConfig.log()
                java.lang.Object[] r4 = new java.lang.Object[r2]
                java.lang.String r5 = "DAU start-request \n"
                r4[r3] = r5
                com.irisdt.dau.DayActiveUserProtos$Request r5 = r13.request
                r4[r1] = r5
                r0.i(r4)
            L1a:
                io.grpc.Channel r0 = com.irisdt.grpc.ConnectManager.getChannel()
                com.irisdt.dau.ReportServiceGrpc$ReportServiceBlockingStub r0 = com.irisdt.dau.ReportServiceGrpc.newBlockingStub(r0)
                io.grpc.stub.AbstractStub r0 = com.irisdt.grpc.ConnectManager.attachHeaders(r0)
                com.irisdt.dau.ReportServiceGrpc$ReportServiceBlockingStub r0 = (com.irisdt.dau.ReportServiceGrpc.ReportServiceBlockingStub) r0
                java.lang.String r4 = "gzip"
                io.grpc.stub.AbstractStub r0 = r0.withCompression(r4)
                com.irisdt.dau.ReportServiceGrpc$ReportServiceBlockingStub r0 = (com.irisdt.dau.ReportServiceGrpc.ReportServiceBlockingStub) r0
                r4 = 30
                java.util.concurrent.TimeUnit r6 = java.util.concurrent.TimeUnit.SECONDS
                io.grpc.stub.AbstractStub r0 = r0.withDeadlineAfter(r4, r6)
                com.irisdt.dau.ReportServiceGrpc$ReportServiceBlockingStub r0 = (com.irisdt.dau.ReportServiceGrpc.ReportServiceBlockingStub) r0
                long r4 = android.os.SystemClock.uptimeMillis()
                r6 = 0
                com.irisdt.dau.DayActiveUserProtos$Request r7 = r13.request     // Catch: java.lang.Throwable -> L52
                com.irisdt.dau.DayActiveUserProtos$Response r0 = r0.report(r7)     // Catch: java.lang.Throwable -> L52
                if (r0 == 0) goto L4e
                int r7 = r0.getCode()     // Catch: java.lang.Throwable -> L4c
                goto L4f
            L4c:
                r6 = move-exception
                goto L56
            L4e:
                r7 = 0
            L4f:
                r11 = r6
                r10 = r7
                goto L61
            L52:
                r0 = move-exception
                r12 = r6
                r6 = r0
                r0 = r12
            L56:
                boolean r7 = com.irisdt.StatConfig.isDauLogEnable()
                if (r7 == 0) goto L5f
                r6.printStackTrace()
            L5f:
                r11 = r6
                r10 = 0
            L61:
                r6 = 200(0xc8, float:2.8E-43)
                if (r10 != r6) goto L93
                com.irisdt.grpc.connect.DauManager r6 = com.irisdt.grpc.connect.DauManager.this
                boolean r6 = r6.isLocalCacheEnable()
                if (r6 == 0) goto L93
                com.irisdt.db.DBManager r6 = com.irisdt.db.DBManager.getInstance()
                long r7 = r13.databaseId
                java.lang.String r9 = "irisdt_dau"
                r6.deleteById(r9, r7)
                boolean r6 = com.irisdt.StatConfig.isDauLogEnable()
                if (r6 == 0) goto L93
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                r6.<init>()
                java.lang.String r7 = "    >>> delete success after startThreadSync,table size: "
                r6.append(r7)
                com.irisdt.db.DBManager r7 = com.irisdt.db.DBManager.getInstance()
                long r7 = r7.count(r9)
                r6.append(r7)
            L93:
                long r6 = android.os.SystemClock.uptimeMillis()
                long r4 = r6 - r4
                com.irisdt.grpc.connect.PerfManager r6 = com.irisdt.grpc.connect.PerfManager.getInstance()
                com.irisdt.perf.PerfProtos$Type r7 = com.irisdt.perf.PerfProtos.Type.DAY_ACTIVE_USER
                r8 = r4
                r6.addPref(r7, r8, r10, r11)
                boolean r6 = com.irisdt.StatConfig.isDauLogEnable()
                if (r6 == 0) goto Lc4
                com.irisdt.util.Logger r6 = com.irisdt.StatConfig.log()
                r7 = 4
                java.lang.Object[] r7 = new java.lang.Object[r7]
                java.lang.String r8 = "DAU "
                r7[r3] = r8
                java.lang.Long r3 = java.lang.Long.valueOf(r4)
                r7[r1] = r3
                java.lang.String r1 = ", "
                r7[r2] = r1
                r1 = 3
                r7[r1] = r0
                r6.i(r7)
            Lc4:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.irisdt.grpc.connect.DauManager.DauRunnable.execute():void");
        }

        public DauRunnable(DayActiveUserProtos.Request request, long j10) {
            super(StatConfig.getThreadName("dau"));
            this.request = request;
            this.databaseId = j10;
        }
    }
}

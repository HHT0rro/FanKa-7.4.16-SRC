package com.irisdt.grpc.connect;

import com.google.protobuf.InvalidProtocolBufferException;
import com.irisdt.Irisdt;
import com.irisdt.StatConfig;
import com.irisdt.biz.Client;
import com.irisdt.client.ClientProtos;
import com.irisdt.db.DBHelper;
import com.irisdt.db.DBManager;
import com.irisdt.db.Entity;
import com.irisdt.util.NamedRunnable;
import com.irisdt.util.ThreadManager;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class ClientManager extends BaseManager<ClientProtos.Request> {
    public static final String CREATE_TABLE_SQL = "create table if not exists irisdt_client (id integer primary key autoincrement, log blob)";
    public static final String TABLE = "irisdt_client";
    private static final String TAG = "ClientManager";

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class InstanceHolder {
        private static final ClientManager INSTANCE = new ClientManager();

        private InstanceHolder() {
        }
    }

    public static ClientManager getInstance() {
        return InstanceHolder.INSTANCE;
    }

    @Override // com.irisdt.grpc.connect.BaseManager
    public int getBatchSize() {
        return Client.getInstance().getBatchSize();
    }

    @Override // com.irisdt.grpc.connect.BaseManager
    public long getMinUploadIntervals() {
        return Client.getInstance().getMinUploadInterval();
    }

    @Override // com.irisdt.grpc.connect.BaseManager
    public String getTable() {
        return TABLE;
    }

    @Override // com.irisdt.grpc.connect.BaseManager
    public boolean isEnable() {
        return StatConfig.isClientEnable();
    }

    @Override // com.irisdt.grpc.connect.BaseManager
    public boolean isLocalCacheEnable() {
        return Client.getInstance().isLocalCacheEnable() && DBHelper.getInstance().dbIsAvailable();
    }

    @Override // com.irisdt.grpc.connect.BaseManager
    public boolean isLogEnable() {
        return StatConfig.isClientLogEnable();
    }

    @Override // com.irisdt.grpc.connect.BaseManager
    public void upload(Object[] objArr) {
        ClientProtos.Requests.Builder newBuilder = ClientProtos.Requests.newBuilder();
        newBuilder.setCommon(Irisdt.getCommon().getProtoData());
        for (Object obj : objArr) {
            newBuilder.addRequest((ClientProtos.Request) obj);
        }
        ThreadManager.startThread(new ClientRunnable(newBuilder.build()));
    }

    public void uploadByDB(int i10) throws InvalidProtocolBufferException, ExecutionException, InterruptedException, TimeoutException {
        Map<Long, Entity> query = DBManager.getInstance().query(getTable(), i10);
        if (StatConfig.isClientLogEnable()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(">>> before uploadByDB,table size: ");
            sb2.append(DBManager.getInstance().count(getTable()));
        }
        while (query != null && query.size() > 0) {
            ClientProtos.Requests.Builder newBuilder = ClientProtos.Requests.newBuilder();
            newBuilder.setCommon(Irisdt.getCommon().getProtoData());
            Iterator<Entity> iterator2 = query.values().iterator2();
            while (iterator2.hasNext()) {
                newBuilder.addRequest(ClientProtos.Request.parseFrom(iterator2.next().getBlob()));
            }
            if (StatConfig.isClientLogEnable()) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("    >>> before startThreadSync,table size: ");
                sb3.append(DBManager.getInstance().count(getTable()));
            }
            ThreadManager.startThreadSync(new ClientRunnable(newBuilder.build(), query), 10);
            query = DBManager.getInstance().query(getTable(), i10);
        }
        if (StatConfig.isClientLogEnable()) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append(">>> after uploadByDB,table size: ");
            sb4.append(DBManager.getInstance().count(getTable()));
        }
    }

    private ClientManager() {
    }

    @Override // com.irisdt.grpc.connect.BaseManager
    public byte[] serialize(ClientProtos.Request request) {
        return request.toByteArray();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class ClientRunnable extends NamedRunnable {
        private Map<Long, Entity> dataMap;
        private ClientProtos.Requests requests;

        public ClientRunnable(ClientProtos.Requests requests) {
            super(StatConfig.getThreadName("client"));
            this.requests = requests;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:16:0x0086  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x00b3  */
        /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
        @Override // com.irisdt.util.NamedRunnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void execute() {
            /*
                r13 = this;
                boolean r0 = com.irisdt.StatConfig.isClientLogEnable()
                r1 = 1
                r2 = 2
                r3 = 0
                if (r0 == 0) goto L1a
                com.irisdt.util.Logger r0 = com.irisdt.StatConfig.log()
                java.lang.Object[] r4 = new java.lang.Object[r2]
                java.lang.String r5 = "CLIENT start-request \n"
                r4[r3] = r5
                com.irisdt.client.ClientProtos$Requests r5 = r13.requests
                r4[r1] = r5
                r0.i(r4)
            L1a:
                io.grpc.Channel r0 = com.irisdt.grpc.ConnectManager.getChannel()
                com.irisdt.client.ReportServiceGrpc$ReportServiceBlockingStub r0 = com.irisdt.client.ReportServiceGrpc.newBlockingStub(r0)
                io.grpc.stub.AbstractStub r0 = com.irisdt.grpc.ConnectManager.attachHeaders(r0)
                com.irisdt.client.ReportServiceGrpc$ReportServiceBlockingStub r0 = (com.irisdt.client.ReportServiceGrpc.ReportServiceBlockingStub) r0
                java.lang.String r4 = "gzip"
                io.grpc.stub.AbstractStub r0 = r0.withCompression(r4)
                com.irisdt.client.ReportServiceGrpc$ReportServiceBlockingStub r0 = (com.irisdt.client.ReportServiceGrpc.ReportServiceBlockingStub) r0
                r4 = 30
                java.util.concurrent.TimeUnit r6 = java.util.concurrent.TimeUnit.SECONDS
                io.grpc.stub.AbstractStub r0 = r0.withDeadlineAfter(r4, r6)
                com.irisdt.client.ReportServiceGrpc$ReportServiceBlockingStub r0 = (com.irisdt.client.ReportServiceGrpc.ReportServiceBlockingStub) r0
                long r4 = android.os.SystemClock.uptimeMillis()
                r6 = 0
                com.irisdt.client.ClientProtos$Requests r7 = r13.requests     // Catch: java.lang.Throwable -> L52
                com.irisdt.client.ClientProtos$Response r0 = r0.batchReport(r7)     // Catch: java.lang.Throwable -> L52
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
                boolean r7 = com.irisdt.StatConfig.isClientLogEnable()
                if (r7 == 0) goto L5f
                r6.printStackTrace()
            L5f:
                r11 = r6
                r10 = 0
            L61:
                r6 = 200(0xc8, float:2.8E-43)
                if (r10 != r6) goto L9d
                com.irisdt.grpc.connect.ClientManager r6 = com.irisdt.grpc.connect.ClientManager.this
                boolean r6 = r6.isLocalCacheEnable()
                if (r6 == 0) goto L9d
                com.irisdt.db.DBManager r6 = com.irisdt.db.DBManager.getInstance()
                com.irisdt.grpc.connect.ClientManager r7 = com.irisdt.grpc.connect.ClientManager.this
                java.lang.String r7 = r7.getTable()
                java.util.Map<java.lang.Long, com.irisdt.db.Entity> r8 = r13.dataMap
                java.util.Set r8 = r8.h()
                r6.delete(r7, r8)
                boolean r6 = com.irisdt.StatConfig.isClientLogEnable()
                if (r6 == 0) goto L9d
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                r6.<init>()
                java.lang.String r7 = "    >>> delete success after startThreadSync,table size: "
                r6.append(r7)
                com.irisdt.db.DBManager r7 = com.irisdt.db.DBManager.getInstance()
                java.lang.String r8 = "irisdt_client"
                long r7 = r7.count(r8)
                r6.append(r7)
            L9d:
                long r6 = android.os.SystemClock.uptimeMillis()
                long r4 = r6 - r4
                com.irisdt.grpc.connect.PerfManager r6 = com.irisdt.grpc.connect.PerfManager.getInstance()
                com.irisdt.perf.PerfProtos$Type r7 = com.irisdt.perf.PerfProtos.Type.CLIENT
                r8 = r4
                r6.addPref(r7, r8, r10, r11)
                boolean r6 = com.irisdt.StatConfig.isClientLogEnable()
                if (r6 == 0) goto Lce
                com.irisdt.util.Logger r6 = com.irisdt.StatConfig.log()
                r7 = 4
                java.lang.Object[] r7 = new java.lang.Object[r7]
                java.lang.String r8 = "CLIENT "
                r7[r3] = r8
                java.lang.Long r3 = java.lang.Long.valueOf(r4)
                r7[r1] = r3
                java.lang.String r1 = ", "
                r7[r2] = r1
                r1 = 3
                r7[r1] = r0
                r6.i(r7)
            Lce:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.irisdt.grpc.connect.ClientManager.ClientRunnable.execute():void");
        }

        public ClientRunnable(ClientProtos.Requests requests, Map<Long, Entity> map) {
            super(StatConfig.getThreadName("client"));
            this.requests = requests;
            this.dataMap = map;
        }
    }
}

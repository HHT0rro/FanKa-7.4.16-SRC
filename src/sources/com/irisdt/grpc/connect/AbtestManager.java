package com.irisdt.grpc.connect;

import android.os.SystemClock;
import android.text.TextUtils;
import com.google.protobuf.Any;
import com.irisdt.Irisdt;
import com.irisdt.StatConfig;
import com.irisdt.client.ClientProtos;
import com.irisdt.client.abtest.AbClientProtos;
import com.irisdt.client.abtest.AbClientServiceGrpc;
import com.irisdt.client.abtest.AbTestProtos;
import com.irisdt.grpc.ConnectManager;
import com.irisdt.util.FileUtils;
import com.irisdt.util.NamedRunnable;
import com.irisdt.util.ThreadManager;
import com.irisdt.util.Utils;
import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class AbtestManager {
    private static final int INTERVAL = 60000;
    private volatile String decisionId;
    private volatile ConcurrentHashMap<String, AbClientProtos.AbResult> expMap;
    private volatile ConcurrentHashMap<String, LocalFreezeResult> freezeExpMap;
    private final AtomicBoolean readLocalFreezeExpFile;
    private final Runnable syncRunnable;
    private volatile String token;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class AbtestSyncRunnable extends NamedRunnable {
        private final String did;

        public AbtestSyncRunnable(String str) {
            super(StatConfig.getThreadName("abtest"));
            this.did = str;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.irisdt.util.NamedRunnable
        public void execute() {
            if (AbtestManager.this.readLocalFreezeExpFile.get()) {
                AbtestManager.this.readFreezeExpFile(this.did);
                AbtestManager.this.readLocalFreezeExpFile.set(false);
            }
            AbClientProtos.Request build = AbClientProtos.Request.newBuilder().setDecisionId(this.did).setToken(AbtestManager.this.token).setCommon(Irisdt.getCommon().getProtoData()).build();
            if (StatConfig.isAbtestLogEnable()) {
                StatConfig.log().i("ABTEST start-request \n", build);
            }
            AbClientServiceGrpc.AbClientServiceBlockingStub abClientServiceBlockingStub = (AbClientServiceGrpc.AbClientServiceBlockingStub) ((AbClientServiceGrpc.AbClientServiceBlockingStub) ((AbClientServiceGrpc.AbClientServiceBlockingStub) ConnectManager.attachHeaders(AbClientServiceGrpc.newBlockingStub(ConnectManager.getChannel()))).withCompression("gzip")).withDeadlineAfter(30L, TimeUnit.SECONDS);
            AbClientProtos.Response response = null;
            long uptimeMillis = SystemClock.uptimeMillis();
            try {
                response = abClientServiceBlockingStub.getAbResult(build);
                if (response != null) {
                    int code = response.getCode();
                    response.getMessage();
                    if (code == 200 && AbtestManager.this.decisionId.equals(this.did)) {
                        AbtestManager.this.unionResult(this.did, response.getResultsMap());
                    }
                }
            } catch (Throwable th) {
                if (StatConfig.isAbtestLogEnable()) {
                    th.printStackTrace();
                }
            }
            long uptimeMillis2 = SystemClock.uptimeMillis() - uptimeMillis;
            if (StatConfig.isAbtestLogEnable()) {
                StatConfig.log().i("ABTEST ", Long.valueOf(uptimeMillis2), ", ", response);
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class InstanceHolder {
        private static final AbtestManager INSTANCE = new AbtestManager();

        private InstanceHolder() {
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class LocalFreezeResult {
        public long gid;
        public String key;
        public int type;
        public String value;

        private LocalFreezeResult() {
        }
    }

    private void addFreezeResult(String str, AbClientProtos.AbResult abResult) {
        LocalFreezeResult localFreezeResult = new LocalFreezeResult();
        localFreezeResult.key = str;
        localFreezeResult.gid = abResult.getGid();
        localFreezeResult.type = abResult.getParamType();
        localFreezeResult.value = abResult.getParamValue();
        this.freezeExpMap.put(str, localFreezeResult);
    }

    private File getFreezeExpFile(String str) {
        return new File(StatConfig.getAppContext().getFilesDir(), "abtest_freeze_exp_" + FileUtils.md5(str));
    }

    public static AbtestManager getInstance() {
        return InstanceHolder.INSTANCE;
    }

    private String getResultParamValue(String str, int i10) {
        LocalFreezeResult localFreezeResult;
        AbClientProtos.AbResult abResult = this.expMap.get(str);
        String str2 = null;
        if (abResult != null) {
            long gid = abResult.getGid();
            int paramType = abResult.getParamType();
            String paramValue = abResult.getParamValue();
            if (abResult.getIsFreeze()) {
                localFreezeResult = this.freezeExpMap.get(str);
            } else {
                localFreezeResult = abResult.getIsGroupFreeze() ? this.freezeExpMap.get(str) : null;
            }
            if (localFreezeResult != null) {
                gid = localFreezeResult.gid;
                paramType = localFreezeResult.type;
                paramValue = localFreezeResult.value;
                if (StatConfig.isAbtestLogEnable()) {
                    StatConfig.log().i("ABTEST freeze \n", abResult, " -> { gid=", Long.valueOf(gid), ", paramType=", Integer.valueOf(paramType), ", paramValue=", paramValue, " }");
                }
            }
            if (abResult.getIsFreeze() || paramType == i10) {
                str2 = paramValue;
            } else if (StatConfig.isAbtestLogEnable()) {
                StatConfig.log().e("ABTEST type is error!!");
            }
            if (abResult.getIsTrack() && gid > 0) {
                if (StatConfig.isAbtestLogEnable()) {
                    StatConfig.log().d("ABTEST send track");
                }
                uploadTrack(gid);
            }
        }
        return str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void readFreezeExpFile(String str) {
        String readFile = FileUtils.readFile(getFreezeExpFile(str));
        if (TextUtils.isEmpty(readFile)) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(readFile);
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                LocalFreezeResult localFreezeResult = new LocalFreezeResult();
                JSONObject optJSONObject = jSONArray.optJSONObject(i10);
                localFreezeResult.key = optJSONObject.optString("key");
                localFreezeResult.gid = optJSONObject.optLong("gid");
                localFreezeResult.type = optJSONObject.optInt("type");
                localFreezeResult.value = optJSONObject.optString("value");
                this.freezeExpMap.put(localFreezeResult.key, localFreezeResult);
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void unionResult(String str, Map<String, AbClientProtos.AbResult> map) {
        this.expMap = new ConcurrentHashMap<>(map);
        HashSet hashSet = new HashSet();
        boolean z10 = false;
        for (Map.Entry<String, AbClientProtos.AbResult> entry : this.expMap.entrySet()) {
            String key = entry.getKey();
            AbClientProtos.AbResult value = entry.getValue();
            if (StatConfig.isAbtestLogEnable()) {
                StatConfig.log().v("ABTEST ", key, " -> ", value.getParamValue());
            }
            if (value.getIsFreeze()) {
                if (this.freezeExpMap.containsKey(key)) {
                    hashSet.add(key);
                }
            } else if (value.getIsGroupFreeze()) {
                if (!this.freezeExpMap.containsKey(key)) {
                    addFreezeResult(key, value);
                    z10 = true;
                }
                hashSet.add(key);
            }
        }
        HashSet hashSet2 = new HashSet(this.freezeExpMap.h());
        hashSet2.removeAll(hashSet);
        if (hashSet2.size() > 0) {
            Iterator iterator2 = hashSet2.iterator2();
            while (iterator2.hasNext()) {
                this.freezeExpMap.remove((String) iterator2.next());
            }
            z10 = true;
        }
        if (z10) {
            writeFreezeExpFile(str);
        }
    }

    private void uploadTrack(long j10) {
        if (j10 > 0) {
            ClientManager.getInstance().record(ClientProtos.Request.newBuilder().setClientTime(System.currentTimeMillis()).setExtra(Any.pack(AbTestProtos.AbTestProto.newBuilder().setEvent(AbTestProtos.Event.ABTEST_EXPOSURE).setGid(j10).build())).setUidStr(Utils.getStringValue(this.decisionId)).build());
        }
    }

    private void writeFreezeExpFile(String str) {
        try {
            JSONArray jSONArray = new JSONArray();
            Iterator<Map.Entry<String, LocalFreezeResult>> iterator2 = this.freezeExpMap.entrySet().iterator2();
            while (iterator2.hasNext()) {
                LocalFreezeResult value = iterator2.next().getValue();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("key", value.key);
                jSONObject.put("gid", value.gid);
                jSONObject.put("type", value.type);
                jSONObject.put("value", value.value);
                jSONArray.put(jSONObject);
            }
            if (StatConfig.isAbtestLogEnable()) {
                StatConfig.log().v("ABTEST writeFreezeExpFile \n", jSONArray.toString());
            }
            FileUtils.writeFile(getFreezeExpFile(str), jSONArray.toString());
        } catch (Exception unused) {
        }
    }

    public boolean getExpResult(String str, boolean z10) {
        String resultParamValue = getResultParamValue(str, 3);
        if (!TextUtils.isEmpty(resultParamValue)) {
            try {
                return Boolean.parseBoolean(resultParamValue);
            } catch (Exception unused) {
            }
        }
        return z10;
    }

    public void init(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.token = str;
        setDecisionId(str2);
    }

    public void setDecisionId(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.decisionId = str;
        this.readLocalFreezeExpFile.set(true);
        this.freezeExpMap = new ConcurrentHashMap<>();
        this.expMap = new ConcurrentHashMap<>();
        Utils.removeUIRunnable(this.syncRunnable);
        Utils.postUIRunnable(this.syncRunnable);
    }

    private AbtestManager() {
        this.readLocalFreezeExpFile = new AtomicBoolean(true);
        this.expMap = new ConcurrentHashMap<>();
        this.freezeExpMap = new ConcurrentHashMap<>();
        this.syncRunnable = new Runnable() { // from class: com.irisdt.grpc.connect.AbtestManager.1
            @Override // java.lang.Runnable
            public void run() {
                if (StatConfig.isAbtestEnable()) {
                    AbtestManager abtestManager = AbtestManager.this;
                    ThreadManager.startThread(new AbtestSyncRunnable(abtestManager.decisionId));
                }
                Utils.postUIRunnable(this, 60000L);
            }
        };
    }

    public int getExpResult(String str, int i10) {
        String resultParamValue = getResultParamValue(str, 2);
        if (!TextUtils.isEmpty(resultParamValue)) {
            try {
                return Integer.parseInt(resultParamValue);
            } catch (Exception unused) {
            }
        }
        return i10;
    }

    public String getExpResult(String str, String str2) {
        String resultParamValue = getResultParamValue(str, 1);
        return TextUtils.isEmpty(resultParamValue) ? str2 : resultParamValue;
    }
}

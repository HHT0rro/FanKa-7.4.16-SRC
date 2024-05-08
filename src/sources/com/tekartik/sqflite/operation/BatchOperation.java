package com.tekartik.sqflite.operation;

import io.flutter.plugin.common.MethodChannel;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class BatchOperation extends a {

    /* renamed from: a, reason: collision with root package name */
    public final Map<String, Object> f38992a;

    /* renamed from: b, reason: collision with root package name */
    public final BatchOperationResult f38993b = new BatchOperationResult();

    /* renamed from: c, reason: collision with root package name */
    public final boolean f38994c;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class BatchOperationResult implements OperationResult {
        public String errorCode;
        public Object errorData;
        public String errorMessage;
        public Object result;

        public BatchOperationResult() {
        }

        @Override // com.tekartik.sqflite.operation.OperationResult
        public void error(String str, String str2, Object obj) {
            this.errorCode = str;
            this.errorMessage = str2;
            this.errorData = obj;
        }

        @Override // com.tekartik.sqflite.operation.OperationResult
        public void success(Object obj) {
            this.result = obj;
        }
    }

    public BatchOperation(Map<String, Object> map, boolean z10) {
        this.f38992a = map;
        this.f38994c = z10;
    }

    @Override // com.tekartik.sqflite.operation.c
    public <T> T a(String str) {
        return (T) this.f38992a.get(str);
    }

    @Override // com.tekartik.sqflite.operation.c
    public boolean b(String str) {
        return this.f38992a.containsKey(str);
    }

    @Override // com.tekartik.sqflite.operation.b, com.tekartik.sqflite.operation.c
    public boolean f() {
        return this.f38994c;
    }

    @Override // com.tekartik.sqflite.operation.c
    public String getMethod() {
        return (String) this.f38992a.get("method");
    }

    @Override // com.tekartik.sqflite.operation.a
    public OperationResult k() {
        return this.f38993b;
    }

    public Map<String, Object> l() {
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        hashMap2.put("code", this.f38993b.errorCode);
        hashMap2.put("message", this.f38993b.errorMessage);
        hashMap2.put("data", this.f38993b.errorData);
        hashMap.put("error", hashMap2);
        return hashMap;
    }

    public Map<String, Object> m() {
        HashMap hashMap = new HashMap();
        hashMap.put("result", this.f38993b.result);
        return hashMap;
    }

    public void n(MethodChannel.Result result) {
        BatchOperationResult batchOperationResult = this.f38993b;
        result.error(batchOperationResult.errorCode, batchOperationResult.errorMessage, batchOperationResult.errorData);
    }

    public void o(List<Map<String, Object>> list) {
        if (f()) {
            return;
        }
        list.add(l());
    }

    public void p(List<Map<String, Object>> list) {
        if (f()) {
            return;
        }
        list.add(m());
    }
}

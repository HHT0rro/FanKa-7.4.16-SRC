package com.tekartik.sqflite.operation;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class MethodCallOperation extends a {

    /* renamed from: a, reason: collision with root package name */
    public final Result f38995a;

    /* renamed from: b, reason: collision with root package name */
    public final MethodCall f38996b;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class Result implements OperationResult {
        public final MethodChannel.Result result;

        public Result(MethodChannel.Result result) {
            this.result = result;
        }

        @Override // com.tekartik.sqflite.operation.OperationResult
        public void error(String str, String str2, Object obj) {
            this.result.error(str, str2, obj);
        }

        @Override // com.tekartik.sqflite.operation.OperationResult
        public void success(Object obj) {
            this.result.success(obj);
        }
    }

    public MethodCallOperation(MethodCall methodCall, MethodChannel.Result result) {
        this.f38996b = methodCall;
        this.f38995a = new Result(result);
    }

    @Override // com.tekartik.sqflite.operation.c
    public <T> T a(String str) {
        return (T) this.f38996b.argument(str);
    }

    @Override // com.tekartik.sqflite.operation.c
    public boolean b(String str) {
        return this.f38996b.hasArgument(str);
    }

    @Override // com.tekartik.sqflite.operation.c
    public String getMethod() {
        return this.f38996b.method;
    }

    @Override // com.tekartik.sqflite.operation.a
    public OperationResult k() {
        return this.f38995a;
    }
}

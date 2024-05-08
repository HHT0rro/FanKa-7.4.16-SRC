package com.huawei.flexiblelayout.parser.directive;

import android.os.Looper;
import androidx.annotation.NonNull;
import com.huawei.flexiblelayout.data.FLDataSource;
import com.huawei.flexiblelayout.data.b;
import com.huawei.flexiblelayout.data.primitive.FLArray;
import com.huawei.flexiblelayout.data.primitive.FLMap;
import com.huawei.flexiblelayout.data.primitive.ListModel;
import com.huawei.flexiblelayout.data.primitive.MapModel;
import com.huawei.flexiblelayout.k0;
import com.huawei.flexiblelayout.log.Log;
import com.huawei.flexiblelayout.m0;
import com.huawei.flexiblelayout.parser.FLDataParser;
import com.huawei.flexiblelayout.parser.FLDataStream;
import com.huawei.hmf.tasks.OnCompleteListener;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.Tasks;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import org.json.JSONArray;
import org.json.JSONException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class DataParserExtend {

    /* renamed from: a, reason: collision with root package name */
    private static final String f28351a = "DataParserExtend";

    /* renamed from: b, reason: collision with root package name */
    private static final String f28352b = "parser";

    /* renamed from: c, reason: collision with root package name */
    private static final Object f28353c = new DataParserExtend();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class ThreadPool {

        /* renamed from: a, reason: collision with root package name */
        private static final Executor f28354a = Executors.newFixedThreadPool(2);

        private ThreadPool() {
        }
    }

    public static void register() {
        m0.a(f28352b, f28353c);
    }

    public boolean a(Object obj, JSONArray jSONArray) throws JSONException {
        if (obj instanceof FLMap) {
            jSONArray.put(com.huawei.flexiblelayout.json.a.a((MapModel) obj));
            return true;
        }
        if (!(obj instanceof FLArray)) {
            return false;
        }
        JSONArray a10 = com.huawei.flexiblelayout.json.a.a((ListModel) obj);
        int length = a10.length();
        for (int i10 = 0; i10 < length; i10++) {
            jSONArray.put(a10.getJSONObject(i10));
        }
        return true;
    }

    @k0(alias = "dataSource", phase = 1)
    public Object dataSource(b bVar, @NonNull Object... objArr) {
        FLDataParser d10 = bVar.d();
        if (d10 == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (int i10 = 0; i10 < objArr.length; i10++) {
            try {
                if (!a(objArr[i10], jSONArray)) {
                    Log.w(f28351a, "Unsupported data type of args[" + i10 + "].");
                }
            } catch (JSONException unused) {
                Log.w(f28351a, "JSONException when converting args[" + i10 + "] to JSONArray.");
            }
        }
        return a(d10, jSONArray);
    }

    public FLDataSource a(FLDataParser fLDataParser, JSONArray jSONArray) {
        FLDataSource fLDataSource = new FLDataSource();
        try {
            FLDataStream fLDataStream = (FLDataStream) a(fLDataParser.parse(jSONArray));
            if (fLDataStream.getResult() != 0) {
                Log.w(f28351a, "EData parsing is not completely OK, result: " + fLDataStream.getResult());
            }
            fLDataStream.apply(fLDataSource, false);
        } catch (Exception e2) {
            Log.e(f28351a, "Exception when parsing layoutData, " + e2.getMessage());
        }
        return fLDataSource;
    }

    private static <TResult> TResult a(Task<TResult> task) throws Exception {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            return (TResult) Tasks.await(task);
        }
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        task.addOnCompleteListener(ThreadPool.f28354a, new OnCompleteListener() { // from class: com.huawei.flexiblelayout.parser.directive.a
            @Override // com.huawei.hmf.tasks.OnCompleteListener
            public final void onComplete(Task task2) {
                CountDownLatch.this.countDown();
            }
        });
        countDownLatch.await();
        if (task.isSuccessful()) {
            return task.getResult();
        }
        throw task.getException();
    }
}

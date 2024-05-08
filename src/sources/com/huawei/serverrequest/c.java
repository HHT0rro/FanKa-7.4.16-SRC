package com.huawei.serverrequest;

import android.content.Context;
import androidx.annotation.NonNull;
import com.huawei.flexiblelayout.FLEngine;
import com.huawei.flexiblelayout.log.Log;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.serverrequest.api.FileRequest;
import com.huawei.serverrequest.api.ServerRequest;
import com.huawei.serverrequest.api.ServerResponse;
import com.huawei.serverrequest.api.service.HttpException;
import com.huawei.serverrequest.api.service.HttpService;
import com.huawei.serverrequest.f;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/* compiled from: ExecutorImpl.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class c {

    /* renamed from: d, reason: collision with root package name */
    private static final String f34797d = "ServerRequest";

    /* renamed from: e, reason: collision with root package name */
    private static final int f34798e = 4;

    /* renamed from: f, reason: collision with root package name */
    private static final Executor f34799f = Executors.newFixedThreadPool(4);

    /* renamed from: a, reason: collision with root package name */
    private volatile Map<ServerRequest.RequestType, d> f34800a;

    /* renamed from: b, reason: collision with root package name */
    private final Context f34801b;

    /* renamed from: c, reason: collision with root package name */
    private HttpService f34802c;

    /* compiled from: ExecutorImpl.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ServerRequest f34803a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ TaskCompletionSource f34804b;

        public a(ServerRequest serverRequest, TaskCompletionSource taskCompletionSource) {
            this.f34803a = serverRequest;
            this.f34804b = taskCompletionSource;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.a(this.f34803a, (TaskCompletionSource<ServerResponse>) this.f34804b);
        }
    }

    /* compiled from: ExecutorImpl.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class b extends d {
        public b(@NonNull Context context) {
            super(context);
        }

        @Override // com.huawei.serverrequest.c.d
        public void a(@NonNull TaskCompletionSource<ServerResponse> taskCompletionSource, @NonNull com.huawei.serverrequest.d dVar) {
            long nanoTime = System.nanoTime();
            String a10 = this.f34809a.a(dVar);
            if (a10 == null) {
                String str = "cache required but not found:" + ((Object) dVar);
                Log.e("ServerRequest", str);
                taskCompletionSource.setException(new HttpException(2, str));
                return;
            }
            f fVar = new f(new f.a(a10), ServerResponse.ResponseType.FROM_CACHE);
            com.huawei.serverrequest.e.a(dVar, fVar, TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - nanoTime));
            taskCompletionSource.setResult(fVar);
        }
    }

    /* compiled from: ExecutorImpl.java */
    /* renamed from: com.huawei.serverrequest.c$c, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class C0345c extends d {

        /* renamed from: c, reason: collision with root package name */
        @NonNull
        private final e f34807c;

        public C0345c(@NonNull Context context) {
            super(context);
            this.f34807c = new e(context);
        }

        @Override // com.huawei.serverrequest.c.d
        public void a(@NonNull TaskCompletionSource<ServerResponse> taskCompletionSource, @NonNull com.huawei.serverrequest.d dVar) {
            long nanoTime = System.nanoTime();
            String a10 = this.f34809a.a(dVar);
            if (a10 != null) {
                f fVar = new f(new f.a(a10), ServerResponse.ResponseType.FROM_CACHE);
                com.huawei.serverrequest.e.a(dVar, fVar, TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - nanoTime));
                taskCompletionSource.setResult(fVar);
                return;
            }
            this.f34807c.a(taskCompletionSource, dVar);
        }
    }

    /* compiled from: ExecutorImpl.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public abstract class d {

        /* renamed from: a, reason: collision with root package name */
        @NonNull
        public final com.huawei.serverrequest.b f34809a;

        public d(@NonNull Context context) {
            this.f34809a = new com.huawei.serverrequest.b(context);
            if (c.this.f34802c == null) {
                try {
                    c.this.f34802c = (HttpService) FLEngine.getInstance(context).getService(HttpService.class);
                } catch (NoClassDefFoundError unused) {
                }
            }
            if (c.this.f34802c == null) {
                throw new RuntimeException("you must either integrate FLayout or call setHttpService");
            }
        }

        public abstract void a(@NonNull TaskCompletionSource<ServerResponse> taskCompletionSource, @NonNull com.huawei.serverrequest.d dVar);
    }

    /* compiled from: ExecutorImpl.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class e extends d {
        public e(@NonNull Context context) {
            super(context);
        }

        @Override // com.huawei.serverrequest.c.d
        public void a(@NonNull TaskCompletionSource<ServerResponse> taskCompletionSource, @NonNull com.huawei.serverrequest.d dVar) {
            try {
                long nanoTime = System.nanoTime();
                f fVar = new f(new f.a(c.this.f34802c.execute(dVar)), ServerResponse.ResponseType.FROM_SERVER);
                if (!(dVar.a() instanceof FileRequest)) {
                    this.f34809a.a(dVar, fVar.getResponse().string());
                }
                com.huawei.serverrequest.e.a(dVar, fVar, TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - nanoTime));
                taskCompletionSource.setResult(fVar);
            } catch (HttpException e2) {
                taskCompletionSource.setException(e2);
            }
        }
    }

    public c(@NonNull Context context) {
        this.f34801b = context.getApplicationContext();
    }

    private void a(@NonNull Context context) {
        if (this.f34800a != null) {
            return;
        }
        synchronized (this) {
            if (this.f34800a != null) {
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put(ServerRequest.RequestType.REQUEST_CACHE, new b(context));
            hashMap.put(ServerRequest.RequestType.REQUEST_CACHE_OTHERWISE_SERVER, new C0345c(context));
            hashMap.put(ServerRequest.RequestType.REQUEST_SERVER, new e(context));
            this.f34800a = hashMap;
        }
    }

    public void a(HttpService httpService) {
        this.f34802c = httpService;
    }

    @NonNull
    public Task<ServerResponse> a(@NonNull ServerRequest serverRequest) {
        a(this.f34801b);
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        f34799f.execute(new a(serverRequest, taskCompletionSource));
        return taskCompletionSource.getTask();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull ServerRequest serverRequest, @NonNull TaskCompletionSource<ServerResponse> taskCompletionSource) {
        try {
            com.huawei.serverrequest.d dVar = new com.huawei.serverrequest.d(serverRequest);
            d dVar2 = this.f34800a.get(serverRequest.getRequestType());
            if (dVar2 == null) {
                String str = "invalid request type: " + ((Object) serverRequest.getRequestType());
                Log.e("ServerRequest", str);
                taskCompletionSource.setException(new HttpException(4, str));
                return;
            }
            dVar2.a(taskCompletionSource, dVar);
        } catch (HttpException e2) {
            taskCompletionSource.setException(e2);
        }
    }
}

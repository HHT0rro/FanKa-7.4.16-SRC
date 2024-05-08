package com.nirvana.tools.requestqueue;

import com.nirvana.tools.requestqueue.RequestHandler;
import com.nirvana.tools.requestqueue.strategy.ExecuteStrategy;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class RequestQueue {
    private static volatile RequestQueue mInstance;
    public ConcurrentHashMap<String, RequestHandler> mPendingRequests = new ConcurrentHashMap<>();

    private RequestQueue() {
    }

    public static RequestQueue getInstance() {
        if (mInstance == null) {
            synchronized (RequestQueue.class) {
                if (mInstance == null) {
                    mInstance = new RequestQueue();
                }
            }
        }
        return mInstance;
    }

    public <T extends Response> void pushRequest(Request<T> request) {
        if (request == null) {
            return;
        }
        RequestHandler requestHandler = this.mPendingRequests.get(request.getID());
        if (requestHandler == null) {
            RequestHandler requestHandler2 = new RequestHandler(request, new RequestHandler.DoneAction() { // from class: com.nirvana.tools.requestqueue.RequestQueue.1
                @Override // com.nirvana.tools.requestqueue.RequestHandler.DoneAction
                public final void run(RequestHandler requestHandler3) {
                    RequestQueue.this.mPendingRequests.remove(requestHandler3.f37695c.getID());
                }
            });
            requestHandler2.a(request);
            this.mPendingRequests.put(request.getID(), requestHandler2);
            requestHandler2.a();
            return;
        }
        requestHandler.a(request);
        if (ExecuteStrategy.USE_NEW == request.getExecuteStrategy()) {
            RequestHandler<T>.a aVar = requestHandler.f37694b;
            if (aVar != null) {
                aVar.a();
                requestHandler.f37694b = null;
            }
            requestHandler.f37695c = request;
            requestHandler.a();
        }
    }
}

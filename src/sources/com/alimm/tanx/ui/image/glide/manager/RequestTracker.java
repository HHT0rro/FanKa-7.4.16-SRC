package com.alimm.tanx.ui.image.glide.manager;

import com.alimm.tanx.ui.image.glide.request.Request;
import com.alimm.tanx.ui.image.glide.util.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class RequestTracker {
    public boolean isPaused;
    public final Set<Request> requests = Collections.newSetFromMap(new WeakHashMap());
    public final List<Request> pendingRequests = new ArrayList();

    public void addRequest(Request request) {
        this.requests.add(request);
    }

    public void clearRequests() {
        Iterator iterator2 = Util.getSnapshot(this.requests).iterator2();
        while (iterator2.hasNext()) {
            ((Request) iterator2.next()).clear();
        }
        this.pendingRequests.clear();
    }

    public boolean isPaused() {
        return this.isPaused;
    }

    public void pauseRequests() {
        this.isPaused = true;
        for (Request request : Util.getSnapshot(this.requests)) {
            if (request.isRunning()) {
                request.pause();
                this.pendingRequests.add(request);
            }
        }
    }

    public void removeRequest(Request request) {
        this.requests.remove(request);
        this.pendingRequests.remove(request);
    }

    public void restartRequests() {
        for (Request request : Util.getSnapshot(this.requests)) {
            if (!request.isComplete() && !request.isCancelled()) {
                request.pause();
                if (!this.isPaused) {
                    request.begin();
                } else {
                    this.pendingRequests.add(request);
                }
            }
        }
    }

    public void resumeRequests() {
        this.isPaused = false;
        for (Request request : Util.getSnapshot(this.requests)) {
            if (!request.isComplete() && !request.isCancelled() && !request.isRunning()) {
                request.begin();
            }
        }
        this.pendingRequests.clear();
    }

    public void runRequest(Request request) {
        this.requests.add(request);
        if (!this.isPaused) {
            request.begin();
        } else {
            this.pendingRequests.add(request);
        }
    }
}

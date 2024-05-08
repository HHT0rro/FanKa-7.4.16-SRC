package com.alimm.tanx.ui.image.glide.request;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class ThumbnailRequestCoordinator implements RequestCoordinator, Request {
    public RequestCoordinator coordinator;
    public Request full;
    public Request thumb;

    public ThumbnailRequestCoordinator() {
        this(null);
    }

    private boolean parentCanNotifyStatusChanged() {
        RequestCoordinator requestCoordinator = this.coordinator;
        return requestCoordinator == null || requestCoordinator.canNotifyStatusChanged(this);
    }

    private boolean parentCanSetImage() {
        RequestCoordinator requestCoordinator = this.coordinator;
        return requestCoordinator == null || requestCoordinator.canSetImage(this);
    }

    private boolean parentIsAnyResourceSet() {
        RequestCoordinator requestCoordinator = this.coordinator;
        return requestCoordinator != null && requestCoordinator.isAnyResourceSet();
    }

    @Override // com.alimm.tanx.ui.image.glide.request.Request
    public void begin() {
        if (!this.thumb.isRunning()) {
            this.thumb.begin();
        }
        if (this.full.isRunning()) {
            return;
        }
        this.full.begin();
    }

    @Override // com.alimm.tanx.ui.image.glide.request.RequestCoordinator
    public boolean canNotifyStatusChanged(Request request) {
        return parentCanNotifyStatusChanged() && request.equals(this.full) && !isAnyResourceSet();
    }

    @Override // com.alimm.tanx.ui.image.glide.request.RequestCoordinator
    public boolean canSetImage(Request request) {
        return parentCanSetImage() && (request.equals(this.full) || !this.full.isResourceSet());
    }

    @Override // com.alimm.tanx.ui.image.glide.request.Request
    public void clear() {
        this.thumb.clear();
        this.full.clear();
    }

    @Override // com.alimm.tanx.ui.image.glide.request.RequestCoordinator
    public boolean isAnyResourceSet() {
        return parentIsAnyResourceSet() || isResourceSet();
    }

    @Override // com.alimm.tanx.ui.image.glide.request.Request
    public boolean isCancelled() {
        return this.full.isCancelled();
    }

    @Override // com.alimm.tanx.ui.image.glide.request.Request
    public boolean isComplete() {
        return this.full.isComplete() || this.thumb.isComplete();
    }

    @Override // com.alimm.tanx.ui.image.glide.request.Request
    public boolean isFailed() {
        return this.full.isFailed();
    }

    @Override // com.alimm.tanx.ui.image.glide.request.Request
    public boolean isPaused() {
        return this.full.isPaused();
    }

    @Override // com.alimm.tanx.ui.image.glide.request.Request
    public boolean isResourceSet() {
        return this.full.isResourceSet() || this.thumb.isResourceSet();
    }

    @Override // com.alimm.tanx.ui.image.glide.request.Request
    public boolean isRunning() {
        return this.full.isRunning();
    }

    @Override // com.alimm.tanx.ui.image.glide.request.RequestCoordinator
    public void onRequestSuccess(Request request) {
        if (request.equals(this.thumb)) {
            return;
        }
        RequestCoordinator requestCoordinator = this.coordinator;
        if (requestCoordinator != null) {
            requestCoordinator.onRequestSuccess(this);
        }
        if (this.thumb.isComplete()) {
            return;
        }
        this.thumb.clear();
    }

    @Override // com.alimm.tanx.ui.image.glide.request.Request
    public void pause() {
        this.full.pause();
        this.thumb.pause();
    }

    @Override // com.alimm.tanx.ui.image.glide.request.Request
    public void recycle() {
        this.full.recycle();
        this.thumb.recycle();
    }

    public void setRequests(Request request, Request request2) {
        this.full = request;
        this.thumb = request2;
    }

    public ThumbnailRequestCoordinator(RequestCoordinator requestCoordinator) {
        this.coordinator = requestCoordinator;
    }
}

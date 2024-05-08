package com.bumptech.glide.load.engine;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
class ResourceRecycler {
    private final Handler handler = new Handler(Looper.getMainLooper(), new ResourceRecyclerCallback());
    private boolean isRecycling;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class ResourceRecyclerCallback implements Handler.Callback {
        public static final int RECYCLE_RESOURCE = 1;

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 1) {
                return false;
            }
            ((Resource) message.obj).recycle();
            return true;
        }
    }

    public synchronized void recycle(Resource<?> resource, boolean z10) {
        if (!this.isRecycling && !z10) {
            this.isRecycling = true;
            resource.recycle();
            this.isRecycling = false;
        }
        this.handler.obtainMessage(1, resource).sendToTarget();
    }
}

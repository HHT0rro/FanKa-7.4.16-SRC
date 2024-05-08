package com.huawei.jmessage.api;

import android.os.RemoteException;
import com.huawei.flexiblelayout.common.Debuggable;
import com.huawei.flexiblelayout.data.primitive.FLMap;
import com.huawei.flexiblelayout.log.Log;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class MessageChannelPayload {
    private static final String TAG = "MCPayload";
    private FLMap mArgs;
    private Callback mError;
    private String mMethod;
    private Callback mNotImplemented;
    private Callback mSuccess;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class Builder {
        private FLMap mArgs;
        private Callback mError;
        private String mMethod;
        private Callback mNotImplemented;
        private Callback mSuccess;

        public Builder(String str) {
            this.mMethod = str;
        }

        public Builder args(FLMap fLMap) {
            this.mArgs = fLMap;
            return this;
        }

        public MessageChannelPayload build() {
            MessageChannelPayload messageChannelPayload = new MessageChannelPayload();
            messageChannelPayload.mMethod = this.mMethod;
            messageChannelPayload.mArgs = this.mArgs;
            messageChannelPayload.mSuccess = this.mSuccess;
            messageChannelPayload.mError = this.mError;
            messageChannelPayload.mNotImplemented = this.mNotImplemented;
            return messageChannelPayload;
        }

        public Builder error(Callback callback) {
            this.mError = callback;
            return this;
        }

        public Builder notImplemented(Callback callback) {
            this.mNotImplemented = callback;
            return this;
        }

        public Builder success(Callback callback) {
            this.mSuccess = callback;
            return this;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface Callback {
        Object call(Object... objArr) throws RemoteException;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object a(Object[] objArr) throws RemoteException {
        return new Object();
    }

    private Object onCallback(Callback callback, Object[] objArr) {
        if (callback == null) {
            callback = new Callback() { // from class: com.huawei.jmessage.api.a
                @Override // com.huawei.jmessage.api.MessageChannelPayload.Callback
                public final Object call(Object[] objArr2) {
                    Object a10;
                    a10 = MessageChannelPayload.a(objArr2);
                    return a10;
                }
            };
        }
        try {
            return callback.call(objArr);
        } catch (RemoteException e2) {
            Log.w(TAG, this.mMethod + " callback, RemoteException: " + e2.getMessage());
            return new Object();
        } catch (Exception e10) {
            if (Debuggable.isDebuggable()) {
                Log.e(TAG, this.mMethod + " callback, Exception: ", e10);
            } else {
                Log.e(TAG, this.mMethod + " callback, Exception: " + e10.getMessage());
            }
            return new Object();
        }
    }

    public FLMap getArgs() {
        return this.mArgs;
    }

    public String getMethod() {
        return this.mMethod;
    }

    public Object onError(Object... objArr) {
        return onCallback(this.mError, objArr);
    }

    public Object onNotImplemented() {
        return onCallback(this.mNotImplemented, null);
    }

    public Object onSuccess(Object... objArr) {
        return onCallback(this.mSuccess, objArr);
    }
}

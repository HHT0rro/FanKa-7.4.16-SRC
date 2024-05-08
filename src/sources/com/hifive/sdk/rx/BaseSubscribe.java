package com.hifive.sdk.rx;

import com.amap.api.services.core.AMapException;
import com.google.gson.JsonSyntaxException;
import com.hifive.sdk.common.HFLiveCallback;
import com.hifive.sdk.hInterface.DataResponse;
import com.hifive.sdk.manager.HFLiveApi;
import io.reactivex.subscribers.ResourceSubscriber;
import java.net.SocketException;
import java.util.concurrent.TimeoutException;
import kotlin.d;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import retrofit2.HttpException;

/* compiled from: BaseSubscribe.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class BaseSubscribe<T> extends ResourceSubscriber<T> {
    private final DataResponse<T> dataResponse;

    public BaseSubscribe(@Nullable DataResponse<T> dataResponse) {
        this.dataResponse = dataResponse;
    }

    public abstract void _onNext(T t2);

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(@Nullable Throwable th) {
        String message;
        if (th != null) {
            th.printStackTrace();
        }
        if (th instanceof BaseException) {
            HFLiveCallback callbacks = HFLiveApi.Companion.getCallbacks();
            if (callbacks != null) {
                BaseException baseException = (BaseException) th;
                Integer status = baseException.getStatus();
                String msg = baseException.getMsg();
                if (msg == null) {
                    msg = "";
                }
                callbacks.onError(new BaseException(status, msg));
            }
            DataResponse<T> dataResponse = this.dataResponse;
            if (dataResponse != null) {
                BaseException baseException2 = (BaseException) th;
                String msg2 = baseException2.getMsg();
                dataResponse.errorMsg(msg2 != null ? msg2 : "", baseException2.getStatus());
                return;
            }
            return;
        }
        if (th instanceof TimeoutException) {
            HFLiveCallback callbacks2 = HFLiveApi.Companion.getCallbacks();
            if (callbacks2 != null) {
                callbacks2.onError(new BaseException(10002, "连接超时"));
            }
            DataResponse<T> dataResponse2 = this.dataResponse;
            if (dataResponse2 != null) {
                String message2 = th.getMessage();
                dataResponse2.errorMsg(message2 != null ? message2 : "连接超时", 10002);
                return;
            }
            return;
        }
        if (th instanceof HttpException) {
            HFLiveCallback callbacks3 = HFLiveApi.Companion.getCallbacks();
            if (callbacks3 != null) {
                callbacks3.onError(new BaseException(10003, "http异常"));
            }
            DataResponse<T> dataResponse3 = this.dataResponse;
            if (dataResponse3 != null) {
                String message3 = th.getMessage();
                dataResponse3.errorMsg(message3 != null ? message3 : "http异常", 10003);
                return;
            }
            return;
        }
        if (th instanceof SocketException) {
            HFLiveCallback callbacks4 = HFLiveApi.Companion.getCallbacks();
            if (callbacks4 != null) {
                callbacks4.onError(new BaseException(10004, "链接异常"));
            }
            DataResponse<T> dataResponse4 = this.dataResponse;
            if (dataResponse4 != null) {
                String message4 = th.getMessage();
                dataResponse4.errorMsg(message4 != null ? message4 : "链接异常", 10004);
                return;
            }
            return;
        }
        if (th instanceof JSONException) {
            HFLiveCallback callbacks5 = HFLiveApi.Companion.getCallbacks();
            if (callbacks5 != null) {
                callbacks5.onError(new BaseException(10097, "JSON转换失败"));
            }
            DataResponse<T> dataResponse5 = this.dataResponse;
            if (dataResponse5 != null) {
                String message5 = th.getMessage();
                dataResponse5.errorMsg(message5 != null ? message5 : "JSON转换失败", 10097);
                return;
            }
            return;
        }
        if (th instanceof JsonSyntaxException) {
            HFLiveCallback callbacks6 = HFLiveApi.Companion.getCallbacks();
            if (callbacks6 != null) {
                callbacks6.onError(new BaseException(10098, "JSON格式不匹配"));
            }
            DataResponse<T> dataResponse6 = this.dataResponse;
            if (dataResponse6 != null) {
                String message6 = th.getMessage();
                dataResponse6.errorMsg(message6 != null ? message6 : "JSON格式不匹配", 10098);
                return;
            }
            return;
        }
        HFLiveCallback callbacks7 = HFLiveApi.Companion.getCallbacks();
        String str = AMapException.AMAP_CLIENT_UNKNOWN_ERROR;
        if (callbacks7 != null) {
            callbacks7.onError(new BaseException(10099, AMapException.AMAP_CLIENT_UNKNOWN_ERROR));
        }
        DataResponse<T> dataResponse7 = this.dataResponse;
        if (dataResponse7 != null) {
            if (th != null && (message = th.getMessage()) != null) {
                str = message;
            }
            dataResponse7.errorMsg(str, 10099);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T t2) {
        _onNext(t2);
    }
}

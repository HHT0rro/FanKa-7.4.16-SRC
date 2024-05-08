package com.huawei.jmessage.sources;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.huawei.flexiblelayout.data.primitive.FLMap;
import com.huawei.jmessage.api.EventCallback;
import com.huawei.jmessage.api.EventSource;
import com.huawei.jmessage.api.MessageChannelPayload;
import com.huawei.jmessage.api.Subscriber;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class MessageChannelSource extends EventSource {
    public static final String TOPIC = "MessageChannel";

    /* renamed from: a, reason: collision with root package name */
    private Handler f32075a = new Handler(Looper.getMainLooper());

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Object obj) {
        super.fire(obj);
    }

    @Override // com.huawei.jmessage.api.EventSource
    public void fire(final Object obj) {
        this.f32075a.post(new Runnable() { // from class: com.huawei.jmessage.sources.a
            @Override // java.lang.Runnable
            public final void run() {
                MessageChannelSource.this.a(obj);
            }
        });
    }

    @Override // com.huawei.jmessage.api.EventSource
    public boolean onDispatch(@NonNull Subscriber subscriber, @NonNull EventCallback.Message message) {
        Object obj = message.payload;
        return (obj instanceof Payload) && ((Payload) obj).getTarget() == subscriber.getParam();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class Payload {

        /* renamed from: a, reason: collision with root package name */
        private MessageChannelPayload f32076a;

        /* renamed from: b, reason: collision with root package name */
        private Object f32077b;

        public <T> T getArgument(String str, Class<T> cls) {
            T t2 = (T) getArgument(str);
            if (t2 == null || cls == null || !cls.isAssignableFrom(t2.getClass())) {
                return null;
            }
            return t2;
        }

        public String getMethod() {
            MessageChannelPayload messageChannelPayload = this.f32076a;
            if (messageChannelPayload == null) {
                return null;
            }
            return messageChannelPayload.getMethod();
        }

        public Object getTarget() {
            return this.f32077b;
        }

        public Object onError(Object... objArr) {
            MessageChannelPayload messageChannelPayload = this.f32076a;
            if (messageChannelPayload == null) {
                return null;
            }
            return messageChannelPayload.onError(objArr);
        }

        public Object onNotImplemented() {
            MessageChannelPayload messageChannelPayload = this.f32076a;
            if (messageChannelPayload == null) {
                return null;
            }
            return messageChannelPayload.onNotImplemented();
        }

        public Object onSuccess(Object... objArr) {
            MessageChannelPayload messageChannelPayload = this.f32076a;
            if (messageChannelPayload == null) {
                return null;
            }
            return messageChannelPayload.onSuccess(objArr);
        }

        public void setMessageChannelPayload(MessageChannelPayload messageChannelPayload) {
            this.f32076a = messageChannelPayload;
        }

        public void setTarget(Object obj) {
            this.f32077b = obj;
        }

        public Object getArgument(String str) {
            FLMap args;
            MessageChannelPayload messageChannelPayload = this.f32076a;
            if (messageChannelPayload == null || (args = messageChannelPayload.getArgs()) == null) {
                return null;
            }
            return args.get(str);
        }
    }
}

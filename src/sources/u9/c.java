package u9;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.huawei.appgallery.agd.pageframe.PageFrameLog;
import com.huawei.hmf.md.spec.jmessage;
import com.huawei.hmf.repository.ComponentRepository;
import com.huawei.jmessage.api.EventCallback;
import com.huawei.jmessage.api.EventQueue;
import com.huawei.jmessage.api.EventSource;
import com.huawei.jmessage.api.Subscriber;
import l9.c;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ShakeEventSource.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class c extends EventSource {

    /* renamed from: a, reason: collision with root package name */
    public c.b f54008a = new c.b() { // from class: u9.b
        @Override // l9.c.b
        public final void onShake() {
            c.c();
        }
    };

    public static /* synthetic */ void c() {
        EventQueue eventQueue = (EventQueue) ComponentRepository.getRepository().lookup(jmessage.name).create(EventQueue.class, "mq");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ShakeEvent", "true");
            eventQueue.publish("ShakeEvent", jSONObject);
        } catch (JSONException unused) {
            PageFrameLog.LOG.e("ShakeEventSource", "message error");
        }
    }

    @Override // com.huawei.jmessage.api.EventSource
    public boolean onDispatch(@NonNull Subscriber subscriber, @NonNull EventCallback.Message message) {
        PageFrameLog pageFrameLog = PageFrameLog.LOG;
        pageFrameLog.i("ShakeEventSource", "onDispatch subscriber.getId(): " + subscriber.getId());
        if (TextUtils.isEmpty(subscriber.getConsumer().toString())) {
            pageFrameLog.i("ShakeEventSource", "onDispatch consumer is null, remove " + subscriber.getId());
            ((EventQueue) ComponentRepository.getRepository().lookup(jmessage.name).create(EventQueue.class, "mq")).unsubscribe(subscriber.getId());
            return false;
        }
        return super.onDispatch(subscriber, message);
    }

    @Override // com.huawei.jmessage.api.EventSource
    public void onInitialize(EventSource.Firer firer) {
        PageFrameLog.LOG.i("ShakeEventSource", "onInitialize: ShakeEvent");
        l9.c.a().c(this.f54008a);
        super.onInitialize(firer);
    }

    @Override // com.huawei.jmessage.api.EventSource
    public void onRelease() {
        PageFrameLog.LOG.i("ShakeEventSource", "onRelease, topic: ShakeEvent");
        l9.c.a().d();
        super.onRelease();
    }

    @Override // com.huawei.jmessage.api.EventSource
    public boolean onSubscribe(@NonNull Subscriber subscriber) {
        PageFrameLog.LOG.i("ShakeEventSource", "onSubscribe id: " + subscriber.getId() + ", param: " + subscriber.getParam());
        return true;
    }

    @Override // com.huawei.jmessage.api.EventSource
    public void onUnsubscribe(@NonNull Subscriber subscriber) {
        PageFrameLog.LOG.i("ShakeEventSource", "onUnsubscribe id: " + subscriber.getId() + ", param: " + subscriber.getParam());
        super.onUnsubscribe(subscriber);
    }
}

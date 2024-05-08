package u9;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.huawei.appgallery.agd.base.api.DownloadStatus;
import com.huawei.appgallery.agd.base.api.IAppStatusListener;
import com.huawei.appgallery.agd.pageframe.PageFrameLog;
import com.huawei.appgallery.agd.pageframe.api.PageApi;
import com.huawei.flexiblelayout.json.Jsons;
import com.huawei.hmf.md.spec.jmessage;
import com.huawei.hmf.repository.ComponentRepository;
import com.huawei.jmessage.api.EventCallback;
import com.huawei.jmessage.api.EventQueue;
import com.huawei.jmessage.api.EventSource;
import com.huawei.jmessage.api.Subscriber;

/* compiled from: AppStatusSource.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class a extends EventSource implements IAppStatusListener {
    @Override // com.huawei.jmessage.api.EventSource
    public boolean onDispatch(@NonNull Subscriber subscriber, @NonNull EventCallback.Message message) {
        PageFrameLog pageFrameLog = PageFrameLog.LOG;
        pageFrameLog.i("AppStatusSource", "onDispatch subscriber.getId(): " + subscriber.getId());
        if (subscriber.getConsumer().toString() == null) {
            pageFrameLog.i("AppStatusSource", "onDispatch callback null, remove " + subscriber.getId());
            ((EventQueue) ComponentRepository.getRepository().lookup(jmessage.name).create(EventQueue.class, "mq")).unsubscribe(subscriber.getId());
            return false;
        }
        String optString = Jsons.toImmutableJson(subscriber.getParam()).optString("packageName");
        Object obj = message.payload;
        return !TextUtils.isEmpty(optString) && optString.equals(obj instanceof DownloadStatus ? ((DownloadStatus) obj).packageName : "");
    }

    @Override // com.huawei.jmessage.api.EventSource
    public void onInitialize(EventSource.Firer firer) {
        super.onInitialize(firer);
        PageFrameLog.LOG.i("AppStatusSource", "onInitialize");
        k9.b.d().b(this);
    }

    @Override // com.huawei.jmessage.api.EventSource
    public void onRelease() {
        PageFrameLog.LOG.i("AppStatusSource", "onRelease");
        k9.b.d().h(this);
    }

    @Override // com.huawei.appgallery.agd.base.api.IAppStatusListener
    public void onStatusChange(@NonNull DownloadStatus downloadStatus) {
        fire(downloadStatus);
        PageApi.getCallBack().onStatusChange(downloadStatus);
    }

    @Override // com.huawei.jmessage.api.EventSource
    public boolean onSubscribe(Subscriber subscriber) {
        PageFrameLog.LOG.i("AppStatusSource", "onSubscribe, id is: " + subscriber.getId());
        return true;
    }

    @Override // com.huawei.jmessage.api.EventSource
    public void onUnsubscribe(Subscriber subscriber) {
        PageFrameLog.LOG.i("AppStatusSource", "onUnsubscribe, id is: " + subscriber.getId());
    }
}

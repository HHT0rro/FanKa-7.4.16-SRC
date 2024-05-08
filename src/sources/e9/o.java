package e9;

import androidx.annotation.NonNull;
import com.huawei.jmessage.api.EventSource;
import com.huawei.jmessage.api.Subscriber;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class o extends EventSource {
    @Override // com.huawei.jmessage.api.EventSource
    public boolean onSubscribe(@NonNull Subscriber subscriber) {
        e eVar = e.f48945d;
        StringBuilder b4 = a.b("RewardVerifySource onSubscribe id: ");
        b4.append(subscriber.getId());
        b4.append(", param: ");
        b4.append(subscriber.getParam());
        eVar.i("RewardVerifySource", b4.toString());
        return true;
    }
}

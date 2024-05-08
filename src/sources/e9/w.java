package e9;

import com.huawei.appgallery.agd.agdpro.impl.web.VideoPageActivity;
import com.huawei.jmessage.api.EventCallback;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class w implements EventCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VideoPageActivity f48991a;

    public w(VideoPageActivity videoPageActivity) {
        this.f48991a = videoPageActivity;
    }

    @Override // com.huawei.jmessage.api.EventCallback
    public void call(EventCallback.Message message) {
        try {
            JSONObject jSONObject = new JSONObject(message.payload.toString());
            this.f48991a.f27274g = jSONObject.getLong("videoCurrentTime");
            this.f48991a.f27275h = jSONObject.getLong("videoDuration");
        } catch (JSONException unused) {
            e.f48945d.e("VideoPageActivity", "receive video currentTime error");
        }
        e eVar = e.f48945d;
        StringBuilder b4 = a.b("receive video currentTime: ");
        b4.append(this.f48991a.f27274g);
        b4.append(", mVideoDuration: ");
        b4.append(this.f48991a.f27275h);
        eVar.d("VideoPageActivity", b4.toString());
    }
}

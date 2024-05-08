package android.webkit;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class WebMessage {
    private String mData;
    private WebMessagePort[] mPorts;

    public WebMessage(String data) {
        this.mData = data;
    }

    public WebMessage(String data, WebMessagePort[] ports) {
        this.mData = data;
        this.mPorts = ports;
    }

    public String getData() {
        return this.mData;
    }

    public WebMessagePort[] getPorts() {
        return this.mPorts;
    }
}

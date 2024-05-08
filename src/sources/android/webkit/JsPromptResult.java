package android.webkit;

import android.annotation.SystemApi;
import android.webkit.JsResult;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class JsPromptResult extends JsResult {
    private String mStringResult;

    public void confirm(String result) {
        this.mStringResult = result;
        confirm();
    }

    @SystemApi
    public JsPromptResult(JsResult.ResultReceiver receiver) {
        super(receiver);
    }

    @SystemApi
    public String getStringResult() {
        return this.mStringResult;
    }
}

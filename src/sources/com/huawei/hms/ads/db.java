package com.huawei.hms.ads;

import android.widget.TextView;
import com.huawei.hms.ads.template.DTManager;
import com.huawei.hms.ads.template.util.b;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class db extends cx<TextView> {
    private String I;

    public db(TextView textView) {
        super(textView);
    }

    @Override // com.huawei.hms.ads.cx
    public String Code() {
        return "text";
    }

    @Override // com.huawei.hms.ads.cj
    public void Code(String str, String str2) {
        String str3;
        TextView textView;
        String decode;
        String I = com.huawei.hms.ads.template.util.a.I(str2);
        this.I = I;
        if (I == null) {
            try {
                if (str2.startsWith("@strings/")) {
                    decode = b.V(((TextView) this.Code).getContext(), str2);
                    textView = (TextView) this.Code;
                } else {
                    textView = (TextView) this.Code;
                    decode = URLDecoder.decode(str2, "UTF-8");
                }
                textView.setText(decode);
            } catch (UnsupportedEncodingException unused) {
                str3 = "parse UnsupportedEncodingException";
                gl.I("TextHandler", str3);
            } catch (Exception e2) {
                str3 = "parse " + e2.getClass().getSimpleName();
                gl.I("TextHandler", str3);
            }
        }
    }

    @Override // com.huawei.hms.ads.cx, com.huawei.hms.ads.cf
    public void Code(JSONObject jSONObject) {
        StringBuilder sb2;
        String simpleName;
        String sb3;
        if (this.I == null || jSONObject == null) {
            return;
        }
        try {
            String Code = DTManager.getInstance().Code(this.I, jSONObject);
            ((TextView) this.Code).setText(Code == null ? "" : URLDecoder.decode(Code, "UTF-8"));
        } catch (com.huawei.hms.ads.template.b unused) {
            sb3 = "bindData PlacementParseException";
            gl.I("TextHandler", sb3);
        } catch (JSONException e2) {
            sb2 = new StringBuilder();
            sb2.append("bindData json exception: ");
            simpleName = e2.getMessage();
            sb2.append(simpleName);
            sb3 = sb2.toString();
            gl.I("TextHandler", sb3);
        } catch (Exception e10) {
            sb2 = new StringBuilder();
            sb2.append("bindData ");
            simpleName = e10.getClass().getSimpleName();
            sb2.append(simpleName);
            sb3 = sb2.toString();
            gl.I("TextHandler", sb3);
        }
    }
}

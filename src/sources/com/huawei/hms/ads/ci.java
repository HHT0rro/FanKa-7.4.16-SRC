package com.huawei.hms.ads;

import android.text.TextUtils;
import android.widget.TextView;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class ci extends cx<TextView> {
    public ci(TextView textView) {
        super(textView);
    }

    @Override // com.huawei.hms.ads.cx
    public String Code() {
        return "ellipsize";
    }

    @Override // com.huawei.hms.ads.cj
    public void Code(String str, String str2) {
        TextView textView;
        TextUtils.TruncateAt truncateAt;
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        str2.hashCode();
        char c4 = 65535;
        switch (str2.hashCode()) {
            case -1074341483:
                if (str2.equals("middle")) {
                    c4 = 0;
                    break;
                }
                break;
            case 100571:
                if (str2.equals("end")) {
                    c4 = 1;
                    break;
                }
                break;
            case 109757538:
                if (str2.equals("start")) {
                    c4 = 2;
                    break;
                }
                break;
            case 839444514:
                if (str2.equals("marquee")) {
                    c4 = 3;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                textView = (TextView) this.Code;
                truncateAt = TextUtils.TruncateAt.MIDDLE;
                break;
            case 1:
                textView = (TextView) this.Code;
                truncateAt = TextUtils.TruncateAt.END;
                break;
            case 2:
                textView = (TextView) this.Code;
                truncateAt = TextUtils.TruncateAt.START;
                break;
            case 3:
                textView = (TextView) this.Code;
                truncateAt = TextUtils.TruncateAt.MARQUEE;
                break;
            default:
                return;
        }
        textView.setEllipsize(truncateAt);
    }
}

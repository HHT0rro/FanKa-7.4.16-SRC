package w8;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.heytap.msp.push.mode.BaseMode;
import com.heytap.msp.push.mode.DataMessage;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class b extends c {
    @Override // w8.d
    public BaseMode a(Context context, int i10, Intent intent) {
        if (4103 != i10 && 4098 != i10) {
            return null;
        }
        BaseMode c4 = c(intent);
        t8.b.C().k((DataMessage) c4, "push_transmit", i10);
        return c4;
    }

    public BaseMode c(Intent intent) {
        try {
            DataMessage dataMessage = new DataMessage();
            dataMessage.setMessageID(y8.a.d(intent.getStringExtra("messageID")));
            dataMessage.setTaskID(y8.a.d(intent.getStringExtra("taskID")));
            dataMessage.setAppPackage(y8.a.d(intent.getStringExtra("appPackage")));
            dataMessage.setTitle(y8.a.d(intent.getStringExtra("title")));
            dataMessage.setContent(y8.a.d(intent.getStringExtra("content")));
            dataMessage.setDescription(y8.a.d(intent.getStringExtra("description")));
            String d10 = y8.a.d(intent.getStringExtra("notifyID"));
            dataMessage.setNotifyID(TextUtils.isEmpty(d10) ? 0 : Integer.parseInt(d10));
            return dataMessage;
        } catch (Exception e2) {
            y8.c.a("OnHandleIntent--" + e2.getMessage());
            return null;
        }
    }
}

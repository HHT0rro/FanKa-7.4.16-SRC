package x8;

import android.content.Context;
import com.heytap.msp.push.callback.IDataMessageCallBackService;
import com.heytap.msp.push.mode.BaseMode;
import com.heytap.msp.push.mode.DataMessage;
import y8.f;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class b implements c {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class a implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ IDataMessageCallBackService f54576b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Context f54577c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ DataMessage f54578d;

        public a(IDataMessageCallBackService iDataMessageCallBackService, Context context, DataMessage dataMessage) {
            this.f54576b = iDataMessageCallBackService;
            this.f54577c = context;
            this.f54578d = dataMessage;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f54576b.processMessage(this.f54577c, this.f54578d);
        }
    }

    @Override // x8.c
    public void a(Context context, BaseMode baseMode, IDataMessageCallBackService iDataMessageCallBackService) {
        if (baseMode != null && baseMode.getType() == 4103) {
            DataMessage dataMessage = (DataMessage) baseMode;
            if (iDataMessageCallBackService != null) {
                f.b(new a(iDataMessageCallBackService, context, dataMessage));
            }
        }
    }
}

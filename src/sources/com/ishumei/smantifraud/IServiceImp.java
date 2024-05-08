package com.ishumei.smantifraud;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.ishumei.smantifraud.IService;
import com.ishumei.smantifraud.dfp.SMSDK;
import java.io.File;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class IServiceImp extends Service {
    public boolean l1111l111111Il;
    public boolean l111l11111I1l;
    private final IService.l1111l111111Il l111l11111Il = new IService.l1111l111111Il() { // from class: com.ishumei.smantifraud.IServiceImp.1
        @Override // com.ishumei.smantifraud.IService
        public final boolean hasBI() {
            return IServiceImp.this.l111l11111I1l;
        }

        @Override // com.ishumei.smantifraud.IService
        public final boolean hasF() {
            return IServiceImp.this.l111l11111lIl;
        }

        @Override // com.ishumei.smantifraud.IService
        public final boolean hasMagiskMount() {
            return IServiceImp.this.l1111l111111Il;
        }
    };
    public boolean l111l11111lIl;

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        this.l111l11111lIl = new File("/dev/gmt/files").exists();
        this.l111l11111I1l = new File("/dev/gmt/files/boot_id").exists();
        this.l1111l111111Il = SMSDK.ma();
        return this.l111l11111Il;
    }
}

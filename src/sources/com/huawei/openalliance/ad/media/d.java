package com.huawei.openalliance.ad.media;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.ads.gl;
import com.huawei.hms.ads.gv;
import com.huawei.hms.ads.gy;
import com.huawei.openalliance.ad.utils.ai;
import com.huawei.openalliance.ad.utils.bc;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class d implements IMultiMediaPlayingManager {
    private static final String Code = "d";
    private static final byte[] I = new byte[0];
    private static d V;
    private b B;
    private Context S;
    private final byte[] Z = new byte[0];
    private Queue<a> C = new ConcurrentLinkedQueue();
    private gy F = new gy() { // from class: com.huawei.openalliance.ad.media.d.1
        private void Code() {
            synchronized (d.this.Z) {
                if (gl.Code()) {
                    gl.Code(d.Code, "checkAndPlayNext current player: %s", d.this.B);
                }
                if (d.this.B == null) {
                    d.this.V();
                }
            }
        }

        @Override // com.huawei.hms.ads.gy
        public void Code(int i10, int i11) {
        }

        @Override // com.huawei.hms.ads.gy
        public void Code(b bVar, int i10) {
        }

        @Override // com.huawei.hms.ads.gy
        public void I(b bVar, int i10) {
            if (gl.Code()) {
                gl.Code(d.Code, "onMediaStop: %s", bVar);
            }
            Code();
        }

        @Override // com.huawei.hms.ads.gy
        public void V(b bVar, int i10) {
            if (gl.Code()) {
                gl.Code(d.Code, "onMediaPause: %s", bVar);
            }
            Code();
        }

        @Override // com.huawei.hms.ads.gy
        public void Z(b bVar, int i10) {
            if (gl.Code()) {
                gl.Code(d.Code, "onMediaCompletion: %s", bVar);
            }
            d.this.V();
        }
    };
    private gv D = new gv() { // from class: com.huawei.openalliance.ad.media.d.2
        @Override // com.huawei.hms.ads.gv
        public void Code(b bVar, int i10, int i11, int i12) {
            if (gl.Code()) {
                gl.Code(d.Code, "onError: %s", bVar);
            }
            synchronized (d.this.Z) {
                bVar.V(this);
            }
            d.this.V();
        }
    };

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class a {
        public final String Code;
        public final b V;

        public a(String str, b bVar) {
            this.Code = str;
            this.V = bVar;
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof a)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            a aVar = (a) obj;
            return TextUtils.equals(this.Code, aVar.Code) && this.V == aVar.V;
        }

        public int hashCode() {
            String str = this.Code;
            int hashCode = str != null ? str.hashCode() : -1;
            b bVar = this.V;
            return hashCode & super.hashCode() & (bVar != null ? bVar.hashCode() : -1);
        }

        public String toString() {
            return "Task [" + bc.Code(this.Code) + "]";
        }
    }

    private d(Context context) {
        this.S = context.getApplicationContext();
    }

    public static d Code(Context context) {
        d dVar;
        synchronized (I) {
            if (V == null) {
                V = new d(context);
            }
            dVar = V;
        }
        return dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V() {
        if (ai.I(this.S)) {
            synchronized (this.Z) {
                a poll = this.C.poll();
                if (gl.Code()) {
                    gl.Code(Code, "playNextTask - task: %s currentPlayer: %s", poll, this.B);
                }
                if (poll != null) {
                    if (gl.Code()) {
                        gl.Code(Code, "playNextTask - play: %s", poll.V);
                    }
                    poll.V.Code(this.F);
                    poll.V.Code(this.D);
                    poll.V.Code(poll.Code);
                    this.B = poll.V;
                } else {
                    this.B = null;
                }
            }
        }
    }

    @Override // com.huawei.openalliance.ad.media.IMultiMediaPlayingManager
    public void Code(b bVar) {
        if (bVar == null) {
            return;
        }
        synchronized (this.Z) {
            b bVar2 = this.B;
            if (bVar == bVar2) {
                V(bVar2);
                this.B = null;
            }
            Iterator<a> it = this.C.iterator2();
            while (it.hasNext()) {
                b bVar3 = it.next().V;
                if (bVar3 == bVar) {
                    V(bVar3);
                    it.remove();
                }
            }
        }
    }

    @Override // com.huawei.openalliance.ad.media.IMultiMediaPlayingManager
    public void Code(String str, b bVar) {
        String str2;
        String str3;
        if (TextUtils.isEmpty(str) || bVar == null) {
            return;
        }
        synchronized (this.Z) {
            if (gl.Code()) {
                gl.Code(Code, "autoPlay - url: %s player: %s", bc.Code(str), bVar);
            }
            b bVar2 = this.B;
            if (bVar != bVar2 && bVar2 != null) {
                a aVar = new a(str, bVar);
                this.C.remove(aVar);
                this.C.add(aVar);
                str2 = Code;
                str3 = "autoPlay - add to queue";
                gl.V(str2, str3);
            }
            bVar.Code(this.F);
            bVar.Code(this.D);
            bVar.Code(str);
            this.B = bVar;
            str2 = Code;
            str3 = "autoPlay - play directly";
            gl.V(str2, str3);
        }
    }

    @Override // com.huawei.openalliance.ad.media.IMultiMediaPlayingManager
    public void I(String str, b bVar) {
        if (TextUtils.isEmpty(str) || bVar == null) {
            return;
        }
        synchronized (this.Z) {
            if (gl.Code()) {
                gl.Code(Code, "stop - url: %s player: %s", bc.Code(str), bVar);
            }
            if (bVar == this.B) {
                gl.V(Code, "stop current");
                this.B = null;
                bVar.V(str);
            } else {
                gl.V(Code, "stop - remove from queue");
                this.C.remove(new a(str, bVar));
                V(bVar);
            }
        }
    }

    @Override // com.huawei.openalliance.ad.media.IMultiMediaPlayingManager
    public void V(b bVar) {
        synchronized (this.Z) {
            if (bVar != null) {
                bVar.V(this.F);
                bVar.V(this.D);
            }
        }
    }

    @Override // com.huawei.openalliance.ad.media.IMultiMediaPlayingManager
    public void V(String str, b bVar) {
        if (TextUtils.isEmpty(str) || bVar == null) {
            return;
        }
        synchronized (this.Z) {
            if (gl.Code()) {
                gl.Code(Code, "manualPlay - url: %s player: %s", bc.Code(str), bVar);
            }
            b bVar2 = this.B;
            if (bVar2 != null && bVar != bVar2) {
                bVar2.Code();
                gl.V(Code, "manualPlay - stop other");
            }
            gl.V(Code, "manualPlay - play new");
            bVar.Code(this.F);
            bVar.Code(this.D);
            bVar.Code(str);
            this.B = bVar;
            this.C.remove(new a(str, bVar));
        }
    }

    @Override // com.huawei.openalliance.ad.media.IMultiMediaPlayingManager
    public void Z(String str, b bVar) {
        if (TextUtils.isEmpty(str) || bVar == null) {
            return;
        }
        synchronized (this.Z) {
            if (gl.Code()) {
                gl.Code(Code, "pause - url: %s player: %s", bc.Code(str), bVar);
            }
            if (bVar == this.B) {
                gl.V(Code, "pause current");
                bVar.I(str);
            } else {
                gl.V(Code, "pause - remove from queue");
                this.C.remove(new a(str, bVar));
                V(bVar);
            }
        }
    }
}

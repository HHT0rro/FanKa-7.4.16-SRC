package com.ishumei.smantifraud.l1111l111111Il;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.ishumei.smantifraud.AbsDetector;
import com.ishumei.smantifraud.SmAntiFraud;
import com.ishumei.smantifraud.VDataListener;
import com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il.l11l1111lIIl;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class l111l11IlIlIl {
    private static final String l1111l111111Il = "eventId";
    private static final String l111l11111I1l = "screenrecord";
    private static final String l111l11111Il = "screenshot";
    private static final String l111l11111lIl = "wevent";
    private static final String l111l1111l1Il = "gpsevent";
    private static final String l111l1111lI1l = "mem";
    private static final int l111l1111lIl = 0;
    private static final String l111l1111llIl = "textinput";
    private static final int l11l1111I11l = 2;
    private static final int l11l1111I1l = 0;
    private static final int l11l1111I1ll = 1;
    private static final int l11l1111Il = 2;
    private static final int l11l1111Il1l = 3;
    private static final int l11l1111Ill = 10;
    private static final int l11l1111lIIl = 1;
    private static l111l11IlIlIl l11l111l11Il = null;
    private static final int l11l11IlIIll = 50;
    private Handler l111l111lIlll;
    private final int l111l111llIl;
    private final HandlerThread l111l11IlIlIl;
    private HandlerThread l11l111I111l;
    private int l11l111I11l;
    private final com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il<JSONObject> l11l111l1I1l;
    private final com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il<JSONObject> l11l111l1Il;
    private final Handler l11l111l1lll;
    private final int l11l111lI1l;
    private final com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il<JSONObject> l11l111ll11l;
    private final com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il<JSONObject> l11l111ll1Il;
    private final List<AbsDetector> l11l111llI1l;
    private final com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il<JSONObject> l11l111lll;
    private final com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il<JSONObject> l11l111lllIl;
    private final l11l1111I1l l11l11l1lIl;
    private final VDataListener l11l111lIll = new VDataListener() { // from class: com.ishumei.smantifraud.l1111l111111Il.l111l11IlIlIl.1
        @Override // com.ishumei.smantifraud.VDataListener
        public final void onResult(JSONObject jSONObject, boolean z10) {
            synchronized (l111l11IlIlIl.class) {
                l111l11IlIlIl.l1111l111111Il(l111l11IlIlIl.this, jSONObject, z10);
            }
        }
    };
    private final Runnable l111l111I1l = new Runnable() { // from class: com.ishumei.smantifraud.l1111l111111Il.l111l11IlIlIl.6
        @Override // java.lang.Runnable
        public final void run() {
            try {
                l111l11IlIlIl.this.l111l111lIlll.postDelayed(l111l11IlIlIl.this.l111l111I1l, l111l11IlIlIl.this.l111l111llIl);
                l111l11IlIlIl.this.l111l11111I1l();
            } catch (Exception unused) {
            }
        }
    };

    private l111l11IlIlIl() {
        HandlerThread handlerThread = new HandlerThread("sm-vd-work");
        this.l111l11IlIlIl = handlerThread;
        handlerThread.start();
        this.l11l111l1lll = new Handler(handlerThread.getLooper()) { // from class: com.ishumei.smantifraud.l1111l111111Il.l111l11IlIlIl.2
            @Override // android.os.Handler
            public final void handleMessage(Message message) {
                try {
                    int i10 = message.what;
                    boolean z10 = true;
                    if (i10 == 0) {
                        l111l11IlIlIl l111l11ililil = l111l11IlIlIl.this;
                        JSONObject jSONObject = (JSONObject) message.obj;
                        if (message.arg1 != 1) {
                            z10 = false;
                        }
                        l111l11IlIlIl.l111l11111lIl(l111l11ililil, jSONObject, z10);
                        return;
                    }
                    if (i10 == 1) {
                        l111l11IlIlIl.l1111l111111Il(l111l11IlIlIl.this, (Set) message.obj);
                        return;
                    }
                    if (i10 == 2) {
                        l111l11IlIlIl.l111l11111lIl(l111l11IlIlIl.this, (Set) message.obj);
                    } else {
                        if (i10 != 3) {
                            return;
                        }
                        l111l11IlIlIl l111l11ililil2 = l111l11IlIlIl.this;
                        l111l11ililil2.l111l11111I1l((Set<JSONObject>) l111l11ililil2.l111l1111l1Il());
                    }
                } catch (Exception unused) {
                }
            }
        };
        this.l11l111llI1l = new LinkedList();
        l111l11111Il l111l11111lIl2 = l111l1111l1Il.l1111l111111Il().l111l11111lIl();
        this.l11l111lI1l = l111l11111lIl2.l11l1111I11l();
        this.l111l111llIl = l111l11111lIl2.l11l1111lIIl() * 1000;
        this.l11l11l1lIl = new l11l1111I1l();
        this.l11l111l1I1l = new com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il<>(50);
        this.l11l111l1Il = new com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il<>(10);
        this.l11l111ll11l = new com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il<>(10);
        this.l11l111ll1Il = new com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il<>(10);
        this.l11l111lll = new com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il<>(10);
        this.l11l111lllIl = new com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il<>(10);
    }

    public static synchronized l111l11IlIlIl l1111l111111Il() {
        l111l11IlIlIl l111l11ililil;
        synchronized (l111l11IlIlIl.class) {
            if (l11l111l11Il == null) {
                l11l111l11Il = new l111l11IlIlIl();
            }
            l111l11ililil = l11l111l11Il;
        }
        return l111l11ililil;
    }

    public static /* synthetic */ void l1111l111111Il(l111l11IlIlIl l111l11ililil, Set set) {
        if (set.isEmpty()) {
            return;
        }
        l111l11ililil.l11l111l1I1l.l1111l111111Il((Set<JSONObject>) set, 2);
        l111l11ililil.l11l111l1Il.l1111l111111Il((Set<JSONObject>) set, 2);
        l111l11ililil.l11l111ll11l.l1111l111111Il((Set<JSONObject>) set, 2);
        l111l11ililil.l11l111ll1Il.l1111l111111Il((Set<JSONObject>) set, 2);
        l111l11ililil.l11l111lll.l1111l111111Il((Set<JSONObject>) set, 2);
        l111l11ililil.l11l111lllIl.l1111l111111Il((Set<JSONObject>) set, 2);
    }

    public static /* synthetic */ void l1111l111111Il(l111l11IlIlIl l111l11ililil, JSONObject jSONObject, boolean z10) {
        Message obtain = Message.obtain();
        obtain.what = 0;
        obtain.obj = jSONObject;
        obtain.arg1 = z10 ? 1 : 0;
        l111l11ililil.l11l111l1lll.sendMessage(obtain);
    }

    private void l1111l111111Il(Set<JSONObject> set) {
        Message obtain = Message.obtain();
        obtain.what = 2;
        obtain.obj = set;
        this.l11l111l1lll.sendMessage(obtain);
    }

    private void l1111l111111Il(JSONObject jSONObject, boolean z10) {
        Message obtain = Message.obtain();
        obtain.what = 0;
        obtain.obj = jSONObject;
        obtain.arg1 = z10 ? 1 : 0;
        this.l11l111l1lll.sendMessage(obtain);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l111l11111I1l() {
        Message obtain = Message.obtain();
        obtain.what = 3;
        this.l11l111l1lll.sendMessage(obtain);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l111l11111I1l(final Set<JSONObject> set) {
        if (set.isEmpty()) {
            return;
        }
        try {
            String l1111l111111Il2 = l11l111l11Il.l1111l111111Il(set, null, true);
            if (!set.isEmpty()) {
                this.l11l111l1I1l.l1111l111111Il(set, 1);
                this.l11l111l1Il.l1111l111111Il(set, 1);
                this.l11l111ll11l.l1111l111111Il(set, 1);
                this.l11l111ll1Il.l1111l111111Il(set, 1);
                this.l11l111lll.l1111l111111Il(set, 1);
                this.l11l111lllIl.l1111l111111Il(set, 1);
            }
            this.l11l111I11l++;
            com.ishumei.smantifraud.l111l11111Il.l111l1111llIl<Object> l111l1111llil = new com.ishumei.smantifraud.l111l11111Il.l111l1111llIl<Object>(1, SmAntiFraud.option.l11l1111Il(), SmAntiFraud.option.l11l1111Il1l(), l1111l111111Il2, new l11l1111lIIl.l111l11111lIl<Object>() { // from class: com.ishumei.smantifraud.l1111l111111Il.l111l11IlIlIl.3
                @Override // com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il.l11l1111lIIl.l111l11111lIl
                public final void l1111l111111Il(Object obj) {
                    l111l11IlIlIl.this.l111l111lIlll.removeCallbacksAndMessages(null);
                    l111l11IlIlIl.this.l111l111lIlll.postDelayed(l111l11IlIlIl.this.l111l111I1l, l111l11IlIlIl.this.l111l111llIl);
                    l111l11IlIlIl.l111l11111Il(l111l11IlIlIl.this, set);
                }
            }, new l11l1111lIIl.l1111l111111Il() { // from class: com.ishumei.smantifraud.l1111l111111Il.l111l11IlIlIl.4
                @Override // com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il.l11l1111lIIl.l1111l111111Il
                public final void l1111l111111Il(com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il.l11l1111I1ll l11l1111i1ll) {
                    l111l11IlIlIl.l111l1111l1Il(l111l11IlIlIl.this, set);
                }
            }) { // from class: com.ishumei.smantifraud.l1111l111111Il.l111l11IlIlIl.5
                {
                    super(1, r10, r11, l1111l111111Il2, r13, r14);
                }

                @Override // com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il.l1111l111111Il.l111l1111llIl, com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il.l111l1111lI1l
                public final com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il.l11l1111lIIl<Object> l1111l111111Il(com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il.l111l1111llIl l111l1111llil2) {
                    return com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il.l11l1111lIIl.l1111l111111Il(new Object());
                }
            };
            l111l1111llil.l1111l111111Il((com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il.l11l1111I1l) new com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il.l1111l111111Il(2000, 1, 1.0f));
            com.ishumei.smantifraud.l111l11111Il.l111l1111l1Il.l1111l111111Il().l1111l111111Il(l111l1111llil);
        } catch (Exception unused) {
        }
    }

    private Set<JSONObject> l111l11111Il() {
        HashSet hashSet = new HashSet();
        hashSet.addAll(this.l11l111l1I1l.l1111l111111Il());
        hashSet.addAll(this.l11l111l1Il.l1111l111111Il());
        hashSet.addAll(this.l11l111ll11l.l1111l111111Il());
        hashSet.addAll(this.l11l111ll1Il.l1111l111111Il());
        hashSet.addAll(this.l11l111lll.l1111l111111Il());
        hashSet.addAll(this.l11l111lllIl.l1111l111111Il());
        return hashSet;
    }

    public static /* synthetic */ void l111l11111Il(l111l11IlIlIl l111l11ililil, Set set) {
        Message obtain = Message.obtain();
        obtain.what = 2;
        obtain.obj = set;
        l111l11ililil.l11l111l1lll.sendMessage(obtain);
    }

    private void l111l11111Il(Set<JSONObject> set) {
        if (set.isEmpty()) {
            return;
        }
        this.l11l111l1I1l.l1111l111111Il(set, 1);
        this.l11l111l1Il.l1111l111111Il(set, 1);
        this.l11l111ll11l.l1111l111111Il(set, 1);
        this.l11l111ll1Il.l1111l111111Il(set, 1);
        this.l11l111lll.l1111l111111Il(set, 1);
        this.l11l111lllIl.l1111l111111Il(set, 1);
    }

    public static /* synthetic */ void l111l11111lIl(l111l11IlIlIl l111l11ililil, Set set) {
        if (set.isEmpty()) {
            return;
        }
        l111l11ililil.l11l111l1I1l.l1111l111111Il((Set<JSONObject>) set);
        l111l11ililil.l11l111l1Il.l1111l111111Il((Set<JSONObject>) set);
        l111l11ililil.l11l111ll11l.l1111l111111Il((Set<JSONObject>) set);
        l111l11ililil.l11l111ll1Il.l1111l111111Il((Set<JSONObject>) set);
        l111l11ililil.l11l111lll.l1111l111111Il((Set<JSONObject>) set);
        l111l11ililil.l11l111lllIl.l1111l111111Il((Set<JSONObject>) set);
    }

    public static /* synthetic */ void l111l11111lIl(l111l11IlIlIl l111l11ililil, JSONObject jSONObject, boolean z10) {
        if (jSONObject != null) {
            if (z10 || l111l11ililil.l11l111I11l < l111l11ililil.l11l111lI1l) {
                String optString = jSONObject.optString("eventId", "");
                optString.hashCode();
                char c4 = 65535;
                switch (optString.hashCode()) {
                    case -1168720848:
                        if (optString.equals(l111l1111l1Il)) {
                            c4 = 0;
                            break;
                        }
                        break;
                    case -1028503875:
                        if (optString.equals(l111l1111llIl)) {
                            c4 = 1;
                            break;
                        }
                        break;
                    case -805491779:
                        if (optString.equals(l111l11111I1l)) {
                            c4 = 2;
                            break;
                        }
                        break;
                    case -791206781:
                        if (optString.equals(l111l11111lIl)) {
                            c4 = 3;
                            break;
                        }
                        break;
                    case -416447130:
                        if (optString.equals(l111l11111Il)) {
                            c4 = 4;
                            break;
                        }
                        break;
                    case 107989:
                        if (optString.equals(l111l1111lI1l)) {
                            c4 = 5;
                            break;
                        }
                        break;
                }
                switch (c4) {
                    case 0:
                        l111l11ililil.l11l111ll1Il.l1111l111111Il((com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il<JSONObject>) jSONObject, 0);
                        if (!z10 && l111l11ililil.l11l111ll1Il.l1111l111111Il(0, 2) < 10) {
                            return;
                        }
                        break;
                    case 1:
                        l111l11ililil.l11l111lll.l1111l111111Il((com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il<JSONObject>) jSONObject, 0);
                        if (!z10 && l111l11ililil.l11l111lll.l1111l111111Il(0, 2) < 10) {
                            return;
                        }
                        break;
                    case 2:
                        l111l11ililil.l11l111l1Il.l1111l111111Il((com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il<JSONObject>) jSONObject, 0);
                        if (!z10 && l111l11ililil.l11l111l1Il.l1111l111111Il(0, 2) < 10) {
                            return;
                        }
                        break;
                    case 3:
                        l111l11ililil.l11l111l1I1l.l1111l111111Il((com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il<JSONObject>) jSONObject, 0);
                        if (!z10 && l111l11ililil.l11l111l1I1l.l1111l111111Il(0, 2) < 50) {
                            return;
                        }
                        break;
                    case 4:
                        l111l11ililil.l11l111ll11l.l1111l111111Il((com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il<JSONObject>) jSONObject, 0);
                        if (!z10 && l111l11ililil.l11l111ll11l.l1111l111111Il(0, 2) < 10) {
                            return;
                        }
                        break;
                    case 5:
                        l111l11ililil.l11l111lllIl.l1111l111111Il((com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il<JSONObject>) jSONObject, 0);
                        if (z10 || l111l11ililil.l11l111lllIl.l1111l111111Il(0, 2) >= 10) {
                            l111l11ililil.l111l11111I1l(l111l11ililil.l111l1111l1Il());
                            return;
                        }
                        return;
                    default:
                        return;
                }
                l111l11ililil.l111l11111I1l(l111l11ililil.l111l1111l1Il());
            }
        }
    }

    private void l111l11111lIl(Set<JSONObject> set) {
        Message obtain = Message.obtain();
        obtain.what = 1;
        obtain.obj = set;
        this.l11l111l1lll.sendMessage(obtain);
    }

    private void l111l11111lIl(JSONObject jSONObject, boolean z10) {
        if (jSONObject == null) {
            return;
        }
        if (z10 || this.l11l111I11l < this.l11l111lI1l) {
            String optString = jSONObject.optString("eventId", "");
            optString.hashCode();
            char c4 = 65535;
            switch (optString.hashCode()) {
                case -1168720848:
                    if (optString.equals(l111l1111l1Il)) {
                        c4 = 0;
                        break;
                    }
                    break;
                case -1028503875:
                    if (optString.equals(l111l1111llIl)) {
                        c4 = 1;
                        break;
                    }
                    break;
                case -805491779:
                    if (optString.equals(l111l11111I1l)) {
                        c4 = 2;
                        break;
                    }
                    break;
                case -791206781:
                    if (optString.equals(l111l11111lIl)) {
                        c4 = 3;
                        break;
                    }
                    break;
                case -416447130:
                    if (optString.equals(l111l11111Il)) {
                        c4 = 4;
                        break;
                    }
                    break;
                case 107989:
                    if (optString.equals(l111l1111lI1l)) {
                        c4 = 5;
                        break;
                    }
                    break;
            }
            switch (c4) {
                case 0:
                    this.l11l111ll1Il.l1111l111111Il((com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il<JSONObject>) jSONObject, 0);
                    if (!z10 && this.l11l111ll1Il.l1111l111111Il(0, 2) < 10) {
                        return;
                    }
                    break;
                case 1:
                    this.l11l111lll.l1111l111111Il((com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il<JSONObject>) jSONObject, 0);
                    if (!z10 && this.l11l111lll.l1111l111111Il(0, 2) < 10) {
                        return;
                    }
                    break;
                case 2:
                    this.l11l111l1Il.l1111l111111Il((com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il<JSONObject>) jSONObject, 0);
                    if (!z10 && this.l11l111l1Il.l1111l111111Il(0, 2) < 10) {
                        return;
                    }
                    break;
                case 3:
                    this.l11l111l1I1l.l1111l111111Il((com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il<JSONObject>) jSONObject, 0);
                    if (!z10 && this.l11l111l1I1l.l1111l111111Il(0, 2) < 50) {
                        return;
                    }
                    break;
                case 4:
                    this.l11l111ll11l.l1111l111111Il((com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il<JSONObject>) jSONObject, 0);
                    if (!z10 && this.l11l111ll11l.l1111l111111Il(0, 2) < 10) {
                        return;
                    }
                    break;
                case 5:
                    this.l11l111lllIl.l1111l111111Il((com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il<JSONObject>) jSONObject, 0);
                    if (z10 || this.l11l111lllIl.l1111l111111Il(0, 2) >= 10) {
                        l111l11111I1l(l111l1111l1Il());
                        return;
                    }
                    return;
                default:
                    return;
            }
            l111l11111I1l(l111l1111l1Il());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Set<JSONObject> l111l1111l1Il() {
        HashSet hashSet = new HashSet();
        hashSet.addAll(this.l11l111l1I1l.l111l11111lIl(0, 2));
        hashSet.addAll(this.l11l111l1Il.l111l11111lIl(0, 2));
        hashSet.addAll(this.l11l111ll11l.l111l11111lIl(0, 2));
        hashSet.addAll(this.l11l111ll1Il.l111l11111lIl(0, 2));
        hashSet.addAll(this.l11l111lll.l111l11111lIl(0, 2));
        hashSet.addAll(this.l11l111lllIl.l111l11111lIl(0, 2));
        return hashSet;
    }

    public static /* synthetic */ void l111l1111l1Il(l111l11IlIlIl l111l11ililil, Set set) {
        Message obtain = Message.obtain();
        obtain.what = 1;
        obtain.obj = set;
        l111l11ililil.l11l111l1lll.sendMessage(obtain);
    }

    private void l111l1111l1Il(Set<JSONObject> set) {
        if (set.isEmpty()) {
            return;
        }
        this.l11l111l1I1l.l1111l111111Il(set);
        this.l11l111l1Il.l1111l111111Il(set);
        this.l11l111ll11l.l1111l111111Il(set);
        this.l11l111ll1Il.l1111l111111Il(set);
        this.l11l111lll.l1111l111111Il(set);
        this.l11l111lllIl.l1111l111111Il(set);
    }

    private synchronized void l111l1111lI1l() {
        try {
            if (this.l11l111I111l == null) {
                return;
            }
            Handler handler = this.l111l111lIlll;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            this.l11l111I111l.quitSafely();
            this.l11l111I111l = null;
        } catch (Exception unused) {
        }
    }

    private synchronized void l111l1111llIl() {
        if (this.l11l111I111l != null) {
            return;
        }
        HandlerThread handlerThread = new HandlerThread("sm-vd-thread");
        this.l11l111I111l = handlerThread;
        handlerThread.start();
        Handler handler = new Handler(this.l11l111I111l.getLooper());
        this.l111l111lIlll = handler;
        handler.postDelayed(this.l111l111I1l, this.l111l111llIl);
    }

    private void l111l1111llIl(Set<JSONObject> set) {
        if (set.isEmpty()) {
            return;
        }
        this.l11l111l1I1l.l1111l111111Il(set, 2);
        this.l11l111l1Il.l1111l111111Il(set, 2);
        this.l11l111ll11l.l1111l111111Il(set, 2);
        this.l11l111ll1Il.l1111l111111Il(set, 2);
        this.l11l111lll.l1111l111111Il(set, 2);
        this.l11l111lllIl.l1111l111111Il(set, 2);
    }

    public final void l1111l111111Il(AbsDetector absDetector) {
        if (absDetector == null) {
            return;
        }
        absDetector.register(this.l11l111lIll);
        try {
            Method declaredMethod = AbsDetector.class.getDeclaredMethod("start", new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(absDetector, new Object[0]);
            this.l11l111I11l = 0;
        } catch (Exception unused) {
        }
        l111l1111llIl();
        this.l11l111llI1l.add(absDetector);
    }

    public final String l111l11111lIl() {
        l111l11111I1l();
        HashSet hashSet = new HashSet();
        hashSet.addAll(this.l11l111l1I1l.l1111l111111Il());
        hashSet.addAll(this.l11l111l1Il.l1111l111111Il());
        hashSet.addAll(this.l11l111ll11l.l1111l111111Il());
        hashSet.addAll(this.l11l111ll1Il.l1111l111111Il());
        hashSet.addAll(this.l11l111lll.l1111l111111Il());
        hashSet.addAll(this.l11l111lllIl.l1111l111111Il());
        return l11l111l11Il.l1111l111111Il(hashSet, this.l11l11l1lIl.l1111l111111Il(), false);
    }

    public final void l111l11111lIl(AbsDetector absDetector) {
        if (absDetector == null) {
            return;
        }
        absDetector.unregister();
        try {
            Method declaredMethod = AbsDetector.class.getDeclaredMethod("stop", new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(absDetector, new Object[0]);
        } catch (Exception unused) {
        }
        this.l11l111llI1l.remove(absDetector);
        if (this.l11l111llI1l.isEmpty()) {
            l111l1111lI1l();
        }
    }
}

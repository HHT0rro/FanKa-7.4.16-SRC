package com.vivo.push.f;

/* compiled from: PushClientTaskFactory.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class ah {
    /* JADX WARN: Failed to find 'out' block for switch in B:8:0x0013. Please report as an issue. */
    public static com.vivo.push.s a(com.vivo.push.v vVar) {
        com.vivo.push.s agVar;
        int b4 = vVar.b();
        if (b4 == 20) {
            agVar = new ag(vVar);
        } else if (b4 == 100) {
            agVar = new b(vVar);
        } else if (b4 != 101) {
            switch (b4) {
                case 0:
                    break;
                case 1:
                    agVar = new ab(vVar);
                    break;
                case 2:
                    agVar = new l(vVar);
                    break;
                case 3:
                    agVar = new t(vVar);
                    break;
                case 4:
                    agVar = new u(vVar);
                    break;
                case 5:
                    agVar = new x(vVar);
                    break;
                case 6:
                    agVar = new y(vVar);
                    break;
                case 7:
                    agVar = new r(vVar);
                    break;
                case 8:
                    agVar = new p(vVar);
                    break;
                case 9:
                    agVar = new k(vVar);
                    break;
                case 10:
                    agVar = new h(vVar);
                    break;
                case 11:
                    agVar = new ae(vVar);
                    break;
                case 12:
                    agVar = new j(vVar);
                    break;
                default:
                    switch (b4) {
                        case 2000:
                        case 2001:
                        case 2002:
                        case 2003:
                        case 2004:
                        case 2005:
                        case 2008:
                        case 2009:
                        case 2010:
                        case 2011:
                        case 2012:
                        case 2013:
                        case 2014:
                        case 2015:
                            break;
                        case 2006:
                            agVar = new a(vVar);
                            break;
                        case 2007:
                            agVar = new aj(vVar);
                            break;
                        default:
                            return null;
                    }
            }
            agVar = new ai(vVar);
        } else {
            agVar = new c(vVar);
        }
        return agVar;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x000c. Please report as an issue. */
    public static aa b(com.vivo.push.v vVar) {
        aa agVar;
        int b4 = vVar.b();
        if (b4 == 20) {
            agVar = new ag(vVar);
        } else if (b4 != 2016) {
            switch (b4) {
                case 1:
                    agVar = new ab(vVar);
                    break;
                case 2:
                    agVar = new l(vVar);
                    break;
                case 3:
                    agVar = new t(vVar);
                    break;
                case 4:
                    agVar = new u(vVar);
                    break;
                case 5:
                    agVar = new x(vVar);
                    break;
                case 6:
                    agVar = new y(vVar);
                    break;
                case 7:
                    agVar = new r(vVar);
                    break;
                case 8:
                    agVar = new p(vVar);
                    break;
                case 9:
                    agVar = new k(vVar);
                    break;
                case 10:
                    agVar = new h(vVar);
                    break;
                case 11:
                    agVar = new ae(vVar);
                    break;
                default:
                    return null;
            }
        } else {
            agVar = new o(vVar);
        }
        return agVar;
    }
}

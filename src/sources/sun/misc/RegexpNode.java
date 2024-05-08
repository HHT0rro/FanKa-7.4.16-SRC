package sun.misc;

import java.io.PrintStream;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* compiled from: RegexpPool.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
class RegexpNode {

    /* renamed from: c, reason: collision with root package name */
    char f53711c;
    int depth;
    boolean exact;
    RegexpNode firstchild;
    RegexpNode nextsibling;
    String re;
    Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RegexpNode() {
        this.re = null;
        this.f53711c = '#';
        this.depth = 0;
    }

    RegexpNode(char C, int depth) {
        this.re = null;
        this.f53711c = C;
        this.depth = depth;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RegexpNode add(char C) {
        RegexpNode p10;
        RegexpNode p11 = this.firstchild;
        if (p11 == null) {
            p10 = new RegexpNode(C, this.depth + 1);
        } else {
            while (p11 != null) {
                if (p11.f53711c == C) {
                    return p11;
                }
                p11 = p11.nextsibling;
            }
            p10 = new RegexpNode(C, this.depth + 1);
            p10.nextsibling = this.firstchild;
        }
        this.firstchild = p10;
        return p10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RegexpNode find(char C) {
        for (RegexpNode p10 = this.firstchild; p10 != null; p10 = p10.nextsibling) {
            if (p10.f53711c == C) {
                return p10;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void print(PrintStream out) {
        if (this.nextsibling != null) {
            RegexpNode p10 = this;
            out.print("(");
            while (p10 != null) {
                out.write(p10.f53711c);
                RegexpNode regexpNode = p10.firstchild;
                if (regexpNode != null) {
                    regexpNode.print(out);
                }
                p10 = p10.nextsibling;
                out.write(p10 != null ? 124 : 41);
            }
            return;
        }
        out.write(this.f53711c);
        RegexpNode regexpNode2 = this.firstchild;
        if (regexpNode2 != null) {
            regexpNode2.print(out);
        }
    }
}

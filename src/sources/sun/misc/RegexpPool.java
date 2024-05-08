package sun.misc;

import com.huawei.appgallery.agd.common.utils.StringUtils;
import java.io.PrintStream;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class RegexpPool {
    private static final int BIG = Integer.MAX_VALUE;
    private RegexpNode prefixMachine = new RegexpNode();
    private RegexpNode suffixMachine = new RegexpNode();
    private int lastDepth = Integer.MAX_VALUE;

    public void add(String re, Object ret) throws REException {
        add(re, ret, false);
    }

    public void replace(String re, Object ret) {
        try {
            add(re, ret, true);
        } catch (Exception e2) {
        }
    }

    public Object delete(String re) {
        RegexpNode p10 = this.prefixMachine;
        RegexpNode best = p10;
        int len = re.length() - 1;
        boolean prefix = true;
        if (!re.startsWith(StringUtils.NO_PRINT_CODE) || !re.endsWith(StringUtils.NO_PRINT_CODE)) {
            len++;
        }
        if (len <= 0) {
            return null;
        }
        int i10 = 0;
        while (p10 != null) {
            if (p10.result != null && p10.depth < Integer.MAX_VALUE && (!p10.exact || i10 == len)) {
                best = p10;
            }
            if (i10 >= len) {
                break;
            }
            p10 = p10.find(re.charAt(i10));
            i10++;
        }
        RegexpNode p11 = this.suffixMachine;
        int i11 = len;
        while (true) {
            i11--;
            if (i11 < 0 || p11 == null) {
                break;
            }
            if (p11.result != null && p11.depth < Integer.MAX_VALUE) {
                prefix = false;
                best = p11;
            }
            p11 = p11.find(re.charAt(i11));
        }
        if (prefix) {
            if (!re.equals(best.re)) {
                return null;
            }
            Object o10 = best.result;
            best.result = null;
            return o10;
        }
        if (!re.equals(best.re)) {
            return null;
        }
        Object o11 = best.result;
        best.result = null;
        return o11;
    }

    public Object match(String s2) {
        return matchAfter(s2, Integer.MAX_VALUE);
    }

    public Object matchNext(String s2) {
        return matchAfter(s2, this.lastDepth);
    }

    private void add(String re, Object ret, boolean replace) throws REException {
        RegexpNode p10;
        int len = re.length();
        if (re.charAt(0) == '*') {
            p10 = this.suffixMachine;
            while (len > 1) {
                len--;
                p10 = p10.add(re.charAt(len));
            }
        } else {
            boolean exact = false;
            if (re.charAt(len - 1) == '*') {
                len--;
            } else {
                exact = true;
            }
            RegexpNode p11 = this.prefixMachine;
            for (int i10 = 0; i10 < len; i10++) {
                p11 = p11.add(re.charAt(i10));
            }
            p11.exact = exact;
            p10 = p11;
        }
        if (p10.result != null && !replace) {
            throw new REException(re + " is a duplicate");
        }
        p10.re = re;
        p10.result = ret;
    }

    private Object matchAfter(String s2, int lastMatchDepth) {
        RegexpNode p10 = this.prefixMachine;
        RegexpNode best = p10;
        int bst = 0;
        int bend = 0;
        int len = s2.length();
        if (len <= 0) {
            return null;
        }
        int i10 = 0;
        while (p10 != null) {
            if (p10.result != null && p10.depth < lastMatchDepth && (!p10.exact || i10 == len)) {
                this.lastDepth = p10.depth;
                best = p10;
                bst = i10;
                bend = len;
            }
            if (i10 >= len) {
                break;
            }
            p10 = p10.find(s2.charAt(i10));
            i10++;
        }
        RegexpNode p11 = this.suffixMachine;
        int i11 = len;
        while (true) {
            i11--;
            if (i11 < 0 || p11 == null) {
                break;
            }
            if (p11.result != null && p11.depth < lastMatchDepth) {
                this.lastDepth = p11.depth;
                best = p11;
                bst = 0;
                bend = i11 + 1;
            }
            p11 = p11.find(s2.charAt(i11));
        }
        Object o10 = best.result;
        if (o10 != null && (o10 instanceof RegexpTarget)) {
            return ((RegexpTarget) o10).found(s2.substring(bst, bend));
        }
        return o10;
    }

    public void reset() {
        this.lastDepth = Integer.MAX_VALUE;
    }

    public void print(PrintStream out) {
        out.print("Regexp pool:\n");
        if (this.suffixMachine.firstchild != null) {
            out.print(" Suffix machine: ");
            this.suffixMachine.firstchild.print(out);
            out.print("\n");
        }
        if (this.prefixMachine.firstchild != null) {
            out.print(" Prefix machine: ");
            this.prefixMachine.firstchild.print(out);
            out.print("\n");
        }
    }
}

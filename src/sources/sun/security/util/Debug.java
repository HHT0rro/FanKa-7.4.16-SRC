package sun.security.util;

import com.android.internal.accessibility.common.ShortcutConstants;
import com.huawei.openalliance.ad.constant.u;
import java.io.PrintStream;
import java.math.BigInteger;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class Debug {
    private static String args;
    private static final char[] hexDigits = "0123456789abcdef".toCharArray();
    private String prefix;

    public static void Help() {
        System.err.println();
        System.err.println("all           turn on all debugging");
        System.err.println("access        print all checkPermission results");
        System.err.println("certpath      PKIX CertPathBuilder and");
        System.err.println("              CertPathValidator debugging");
        System.err.println("combiner      SubjectDomainCombiner debugging");
        System.err.println("gssloginconfig");
        System.err.println("              GSS LoginConfigImpl debugging");
        System.err.println("configfile    JAAS ConfigFile loading");
        System.err.println("configparser  JAAS ConfigFile parsing");
        System.err.println("jar           jar verification");
        System.err.println("logincontext  login context results");
        System.err.println("jca           JCA engine class debugging");
        System.err.println("keystore      KeyStore debugging");
        System.err.println("policy        loading and granting");
        System.err.println("provider      security provider debugging");
        System.err.println("pkcs11        PKCS11 session manager debugging");
        System.err.println("pkcs11keystore");
        System.err.println("              PKCS11 KeyStore debugging");
        System.err.println("pkcs12        PKCS12 KeyStore debugging");
        System.err.println("sunpkcs11     SunPKCS11 provider debugging");
        System.err.println("scl           permissions SecureClassLoader assigns");
        System.err.println("securerandom  SecureRandom");
        System.err.println("ts            timestamping");
        System.err.println();
        System.err.println("The following can be used with access:");
        System.err.println();
        System.err.println("stack         include stack trace");
        System.err.println("domain        dump all domains in context");
        System.err.println("failure       before throwing exception, dump stack");
        System.err.println("              and domain that didn't have permission");
        System.err.println();
        System.err.println("The following can be used with stack and domain:");
        System.err.println();
        System.err.println("permission=<classname>");
        System.err.println("              only dump output if specified permission");
        System.err.println("              is being checked");
        System.err.println("codebase=<URL>");
        System.err.println("              only dump output if specified codebase");
        System.err.println("              is being checked");
        System.err.println();
        System.err.println("The following can be used with provider:");
        System.err.println();
        System.err.println("engine=<engines>");
        System.err.println("              only dump output for the specified list");
        System.err.println("              of JCA engines. Supported values:");
        System.err.println("              Cipher, KeyAgreement, KeyGenerator,");
        System.err.println("              KeyPairGenerator, KeyStore, Mac,");
        System.err.println("              MessageDigest, SecureRandom, Signature.");
        System.err.println();
        System.err.println("The following can be used with certpath:");
        System.err.println();
        System.err.println("ocsp          dump the OCSP protocol exchanges");
        System.err.println("verbose       verbose debugging");
        System.err.println();
        System.err.println("Note: Separate multiple options with a comma");
        System.exit(0);
    }

    public static Debug getInstance(String option) {
        return getInstance(option, option);
    }

    public static Debug getInstance(String option, String prefix) {
        if (isOn(option)) {
            Debug d10 = new Debug();
            d10.prefix = prefix;
            return d10;
        }
        return null;
    }

    public static boolean isOn(String option) {
        String str = args;
        if (str == null) {
            return false;
        }
        return (str.indexOf("all") == -1 && args.indexOf(option) == -1) ? false : true;
    }

    public static boolean isVerbose() {
        return isOn("verbose");
    }

    public void println(String message) {
        System.err.println(this.prefix + ": " + message);
    }

    public void println(Object obj, String message) {
        System.err.println(this.prefix + " [" + obj.getClass().getSimpleName() + "@" + System.identityHashCode(obj) + "]: " + message);
    }

    public void println() {
        System.err.println(this.prefix + u.bD);
    }

    public PrintStream getPrintStream() {
        return System.err;
    }

    public static String toHexString(BigInteger b4) {
        String hexValue = b4.toString(16);
        StringBuilder sb2 = new StringBuilder(hexValue.length() * 2);
        if (hexValue.startsWith("-")) {
            sb2.append("   -");
            hexValue = hexValue.substring(1);
        } else {
            sb2.append("    ");
        }
        if (hexValue.length() % 2 != 0) {
            hexValue = "0" + hexValue;
        }
        int i10 = 0;
        while (i10 < hexValue.length()) {
            sb2.append(hexValue.substring(i10, i10 + 2));
            i10 += 2;
            if (i10 != hexValue.length()) {
                if (i10 % 64 == 0) {
                    sb2.append("\n    ");
                } else if (i10 % 8 == 0) {
                    sb2.append(" ");
                }
            }
        }
        return sb2.toString();
    }

    private static String marshal(String args2) {
        if (args2 != null) {
            StringBuilder target = new StringBuilder();
            StringBuffer source = new StringBuffer(args2);
            String reg = "[Pp][Ee][Rr][Mm][Ii][Ss][Ss][Ii][Oo][Nn]=[a-zA-Z_$][a-zA-Z0-9_$]*([.][a-zA-Z_$][a-zA-Z0-9_$]*)*";
            Pattern pattern = Pattern.compile(reg);
            Matcher matcher = pattern.matcher(source);
            StringBuffer left = new StringBuffer();
            while (matcher.find()) {
                String matched = matcher.group();
                target.append(matched.replaceFirst("[Pp][Ee][Rr][Mm][Ii][Ss][Ss][Ii][Oo][Nn]=", "permission="));
                target.append("  ");
                matcher.appendReplacement(left, "");
            }
            matcher.appendTail(left);
            String reg2 = "[Cc][Oo][Dd][Ee][Bb][Aa][Ss][Ee]=[^, ;]*";
            Pattern pattern2 = Pattern.compile(reg2);
            Matcher matcher2 = pattern2.matcher(left);
            StringBuffer left2 = new StringBuffer();
            while (matcher2.find()) {
                String matched2 = matcher2.group();
                target.append(matched2.replaceFirst("[Cc][Oo][Dd][Ee][Bb][Aa][Ss][Ee]=", "codebase="));
                target.append("  ");
                matcher2.appendReplacement(left2, "");
            }
            matcher2.appendTail(left2);
            target.append(left2.toString().toLowerCase(Locale.ENGLISH));
            return target.toString();
        }
        return null;
    }

    public static String toString(byte[] b4) {
        if (b4 == null) {
            return "(null)";
        }
        StringBuilder sb2 = new StringBuilder(b4.length * 3);
        for (int i10 = 0; i10 < b4.length; i10++) {
            int k10 = b4[i10] & 255;
            if (i10 != 0) {
                sb2.append(ShortcutConstants.SERVICES_SEPARATOR);
            }
            char[] cArr = hexDigits;
            sb2.append(cArr[k10 >>> 4]);
            sb2.append(cArr[k10 & 15]);
        }
        return sb2.toString();
    }
}

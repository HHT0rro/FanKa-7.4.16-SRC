package sun.security.util;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class AlgorithmDecomposer {
    private static final Pattern PATTERN = Pattern.compile("with|and|(?<!padd)in", 2);

    private static Set<String> decomposeImpl(String algorithm) {
        Set<String> elements = new HashSet<>();
        String[] transTokens = algorithm.split("/");
        for (String transToken : transTokens) {
            if (transToken != null && !transToken.isEmpty()) {
                String[] tokens = PATTERN.split(transToken);
                for (String token : tokens) {
                    if (token != null && !token.isEmpty()) {
                        elements.add(token);
                    }
                }
            }
        }
        return elements;
    }

    public Set<String> decompose(String algorithm) {
        if (algorithm == null || algorithm.isEmpty()) {
            return new HashSet();
        }
        Set<String> elements = decomposeImpl(algorithm);
        if (elements.contains("SHA1") && !elements.contains("SHA-1")) {
            elements.add("SHA-1");
        }
        if (elements.contains("SHA-1") && !elements.contains("SHA1")) {
            elements.add("SHA1");
        }
        if (elements.contains("SHA224") && !elements.contains("SHA-224")) {
            elements.add("SHA-224");
        }
        if (elements.contains("SHA-224") && !elements.contains("SHA224")) {
            elements.add("SHA224");
        }
        if (elements.contains("SHA256") && !elements.contains("SHA-256")) {
            elements.add("SHA-256");
        }
        if (elements.contains("SHA-256") && !elements.contains("SHA256")) {
            elements.add("SHA256");
        }
        if (elements.contains("SHA384") && !elements.contains("SHA-384")) {
            elements.add("SHA-384");
        }
        if (elements.contains("SHA-384") && !elements.contains("SHA384")) {
            elements.add("SHA384");
        }
        if (elements.contains("SHA512") && !elements.contains("SHA-512")) {
            elements.add("SHA-512");
        }
        if (elements.contains("SHA-512") && !elements.contains("SHA512")) {
            elements.add("SHA512");
        }
        return elements;
    }

    public static Collection<String> getAliases(String algorithm) {
        String[] aliases;
        if (algorithm.equalsIgnoreCase("DH") || algorithm.equalsIgnoreCase("DiffieHellman")) {
            aliases = new String[]{"DH", "DiffieHellman"};
        } else {
            aliases = new String[]{algorithm};
        }
        return Arrays.asList(aliases);
    }

    private static void hasLoop(Set<String> elements, String find, String replace) {
        if (elements.contains(find)) {
            if (!elements.contains(replace)) {
                elements.add(replace);
            }
            elements.remove(find);
        }
    }

    public static Set<String> decomposeOneHash(String algorithm) {
        if (algorithm == null || algorithm.isEmpty()) {
            return new HashSet();
        }
        Set<String> elements = decomposeImpl(algorithm);
        hasLoop(elements, "SHA-1", "SHA1");
        hasLoop(elements, "SHA-224", "SHA224");
        hasLoop(elements, "SHA-256", "SHA256");
        hasLoop(elements, "SHA-384", "SHA384");
        hasLoop(elements, "SHA-512", "SHA512");
        return elements;
    }

    public static String hashName(String algorithm) {
        return algorithm.replace("-", "");
    }
}

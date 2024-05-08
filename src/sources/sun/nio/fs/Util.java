package sun.nio.fs;

import java.nio.charset.Charset;
import java.nio.file.LinkOption;
import java.util.HashSet;
import java.util.Set;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
class Util {
    private static final Charset jnuEncoding = Charset.forName("UTF-8");

    private Util() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Charset jnuEncoding() {
        return jnuEncoding;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] toBytes(String s2) {
        return s2.getBytes(jnuEncoding);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String toString(byte[] bytes) {
        return new String(bytes, jnuEncoding);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String[] split(String s2, char c4) {
        int count = 0;
        for (int i10 = 0; i10 < s2.length(); i10++) {
            if (s2.charAt(i10) == c4) {
                count++;
            }
        }
        int i11 = count + 1;
        String[] result = new String[i11];
        int n10 = 0;
        int last = 0;
        for (int i12 = 0; i12 < s2.length(); i12++) {
            if (s2.charAt(i12) == c4) {
                result[n10] = s2.substring(last, i12);
                last = i12 + 1;
                n10++;
            }
        }
        int i13 = s2.length();
        result[n10] = s2.substring(last, i13);
        return result;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeVarargs
    public static <E> Set<E> newSet(E... elements) {
        HashSet<E> set = new HashSet<>();
        for (E e2 : elements) {
            set.add(e2);
        }
        return set;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeVarargs
    public static <E> Set<E> newSet(Set<E> other, E... elements) {
        HashSet<E> set = new HashSet<>(other);
        for (E e2 : elements) {
            set.add(e2);
        }
        return set;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean followLinks(LinkOption... options) {
        boolean followLinks = true;
        for (LinkOption option : options) {
            if (option == LinkOption.NOFOLLOW_LINKS) {
                followLinks = false;
            } else {
                if (option == null) {
                    throw new NullPointerException();
                }
                throw new AssertionError((Object) "Should not get here");
            }
        }
        return followLinks;
    }
}

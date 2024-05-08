package java.lang.reflect;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public interface Member {
    public static final int DECLARED = 1;
    public static final int PUBLIC = 0;

    Class<?> getDeclaringClass();

    int getModifiers();

    String getName();

    boolean isSynthetic();
}

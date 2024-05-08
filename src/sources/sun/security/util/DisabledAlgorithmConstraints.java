package sun.security.util;

import com.android.internal.logging.nano.MetricsProto;
import java.security.AlgorithmParameters;
import java.security.CryptoPrimitive;
import java.security.Key;
import java.security.cert.CertPathValidatorException;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class DisabledAlgorithmConstraints extends AbstractAlgorithmConstraints {
    public static final String PROPERTY_CERTPATH_DISABLED_ALGS = "jdk.certpath.disabledAlgorithms";
    public static final String PROPERTY_JAR_DISABLED_ALGS = "jdk.jar.disabledAlgorithms";
    public static final String PROPERTY_TLS_DISABLED_ALGS = "jdk.tls.disabledAlgorithms";
    private static final Debug debug = Debug.getInstance("certpath");
    private final Constraints algorithmConstraints;
    private final String[] disabledAlgorithms;

    public DisabledAlgorithmConstraints(String propertyName) {
        this(propertyName, new AlgorithmDecomposer());
    }

    public DisabledAlgorithmConstraints(String propertyName, AlgorithmDecomposer decomposer) {
        super(decomposer);
        String[] algorithms = getAlgorithms(propertyName);
        this.disabledAlgorithms = algorithms;
        this.algorithmConstraints = new Constraints(algorithms);
    }

    @Override // java.security.AlgorithmConstraints
    public final boolean permits(Set<CryptoPrimitive> primitives, String algorithm, AlgorithmParameters parameters) {
        if (primitives == null || primitives.isEmpty()) {
            throw new IllegalArgumentException("No cryptographic primitive specified");
        }
        return checkAlgorithm(this.disabledAlgorithms, algorithm, this.decomposer);
    }

    @Override // java.security.AlgorithmConstraints
    public final boolean permits(Set<CryptoPrimitive> primitives, Key key) {
        return checkConstraints(primitives, "", key, null);
    }

    @Override // java.security.AlgorithmConstraints
    public final boolean permits(Set<CryptoPrimitive> primitives, String algorithm, Key key, AlgorithmParameters parameters) {
        if (algorithm == null || algorithm.length() == 0) {
            throw new IllegalArgumentException("No algorithm name specified");
        }
        return checkConstraints(primitives, algorithm, key, parameters);
    }

    public final void permits(Set<CryptoPrimitive> primitives, CertConstraintParameters cp) throws CertPathValidatorException {
        checkConstraints(primitives, cp);
    }

    public final void permits(Set<CryptoPrimitive> primitives, X509Certificate cert) throws CertPathValidatorException {
        checkConstraints(primitives, new CertConstraintParameters(cert));
    }

    public boolean checkProperty(String param) {
        String param2 = param.toLowerCase(Locale.ENGLISH);
        for (String block : this.disabledAlgorithms) {
            if (block.toLowerCase(Locale.ENGLISH).indexOf(param2) >= 0) {
                return true;
            }
        }
        return false;
    }

    private boolean checkConstraints(Set<CryptoPrimitive> primitives, String algorithm, Key key, AlgorithmParameters parameters) {
        if (key == null) {
            throw new IllegalArgumentException("The key cannot be null");
        }
        if ((algorithm != null && algorithm.length() != 0 && !permits(primitives, algorithm, parameters)) || !permits(primitives, key.getAlgorithm(), null)) {
            return false;
        }
        return this.algorithmConstraints.permits(key);
    }

    private void checkConstraints(Set<CryptoPrimitive> primitives, CertConstraintParameters cp) throws CertPathValidatorException {
        X509Certificate cert = cp.getCertificate();
        String algorithm = cert.getSigAlgName();
        if (!permits(primitives, algorithm, null)) {
            throw new CertPathValidatorException("Algorithm constraints check failed on disabled signature algorithm: " + algorithm, null, null, -1, CertPathValidatorException.BasicReason.ALGORITHM_CONSTRAINED);
        }
        if (!permits(primitives, cert.getPublicKey().getAlgorithm(), null)) {
            throw new CertPathValidatorException("Algorithm constraints check failed on disabled public key algorithm: " + algorithm, null, null, -1, CertPathValidatorException.BasicReason.ALGORITHM_CONSTRAINED);
        }
        this.algorithmConstraints.permits(cp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class Constraints {
        private static final Pattern keySizePattern = Pattern.compile("keySize\\s*(<=|<|==|!=|>|>=)\\s*(\\d+)");
        private Map<String, Set<Constraint>> constraintsMap = new HashMap();

        public Constraints(String[] constraintArray) {
            int i10;
            int i11;
            int space;
            String[] strArr = constraintArray;
            int length = strArr.length;
            int i12 = 0;
            int i13 = 0;
            while (i13 < length) {
                String constraintEntry = strArr[i13];
                if (constraintEntry == null) {
                    i10 = length;
                } else if (constraintEntry.isEmpty()) {
                    i10 = length;
                } else {
                    String constraintEntry2 = constraintEntry.trim();
                    if (DisabledAlgorithmConstraints.debug != null) {
                        DisabledAlgorithmConstraints.debug.println("Constraints: " + constraintEntry2);
                    }
                    int space2 = constraintEntry2.indexOf(32);
                    if (space2 > 0) {
                        String algorithm = AlgorithmDecomposer.hashName(constraintEntry2.substring(i12, space2).toUpperCase(Locale.ENGLISH));
                        String policy = constraintEntry2.substring(space2 + 1);
                        Constraint c4 = null;
                        Constraint lastConstraint = null;
                        boolean jdkCALimit = false;
                        String[] split = policy.split("&");
                        int length2 = split.length;
                        int i14 = i12;
                        while (i14 < length2) {
                            String entry = split[i14].trim();
                            Matcher matcher = keySizePattern.matcher(entry);
                            if (matcher.matches()) {
                                if (DisabledAlgorithmConstraints.debug == null) {
                                    i11 = length;
                                    space = space2;
                                } else {
                                    i11 = length;
                                    space = space2;
                                    DisabledAlgorithmConstraints.debug.println("Constraints set to keySize: " + entry);
                                }
                                c4 = new KeySizeConstraint(algorithm, Constraint.Operator.of(matcher.group(1)), Integer.parseInt(matcher.group(2)));
                            } else {
                                i11 = length;
                                space = space2;
                                if (entry.equalsIgnoreCase("jdkCA")) {
                                    if (DisabledAlgorithmConstraints.debug != null) {
                                        DisabledAlgorithmConstraints.debug.println("Constraints set to jdkCA.");
                                    }
                                    if (jdkCALimit) {
                                        throw new IllegalArgumentException("Only one jdkCA entry allowed in property. Constraint: " + constraintEntry2);
                                    }
                                    Constraint c10 = new jdkCAConstraint(algorithm);
                                    c4 = c10;
                                    jdkCALimit = true;
                                }
                            }
                            if (lastConstraint == null) {
                                if (!this.constraintsMap.containsKey(algorithm)) {
                                    this.constraintsMap.putIfAbsent(algorithm, new HashSet());
                                }
                                if (c4 != null) {
                                    this.constraintsMap.get(algorithm).add(c4);
                                }
                            } else {
                                lastConstraint.nextConstraint = c4;
                            }
                            lastConstraint = c4;
                            i14++;
                            length = i11;
                            space2 = space;
                        }
                        i10 = length;
                    } else {
                        i10 = length;
                        this.constraintsMap.putIfAbsent(constraintEntry2.toUpperCase(Locale.ENGLISH), new HashSet());
                    }
                }
                i13++;
                strArr = constraintArray;
                length = i10;
                i12 = 0;
            }
        }

        private Set<Constraint> getConstraints(String algorithm) {
            return this.constraintsMap.get(algorithm);
        }

        public boolean permits(Key key) {
            Set<Constraint> set = getConstraints(key.getAlgorithm());
            if (set == null) {
                return true;
            }
            for (Constraint constraint : set) {
                if (!constraint.permits(key)) {
                    if (DisabledAlgorithmConstraints.debug != null) {
                        DisabledAlgorithmConstraints.debug.println("keySizeConstraint: failed key constraint check " + KeyUtil.getKeySize(key));
                        return false;
                    }
                    return false;
                }
            }
            return true;
        }

        public void permits(CertConstraintParameters cp) throws CertPathValidatorException {
            X509Certificate cert = cp.getCertificate();
            if (DisabledAlgorithmConstraints.debug != null) {
                DisabledAlgorithmConstraints.debug.println("Constraints.permits(): " + cert.getSigAlgName());
            }
            Set<String> algorithms = AlgorithmDecomposer.decomposeOneHash(cert.getSigAlgName());
            if (algorithms == null || algorithms.isEmpty()) {
                return;
            }
            algorithms.add(cert.getPublicKey().getAlgorithm());
            for (String algorithm : algorithms) {
                Set<Constraint> set = getConstraints(algorithm);
                if (set != null) {
                    for (Constraint constraint : set) {
                        constraint.permits(cp);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static abstract class Constraint {
        String algorithm;
        Constraint nextConstraint;

        public abstract void permits(CertConstraintParameters certConstraintParameters) throws CertPathValidatorException;

        private Constraint() {
            this.nextConstraint = null;
        }

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        enum Operator {
            EQ,
            NE,
            LT,
            LE,
            GT,
            GE;

            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            static Operator of(String s2) {
                char c4;
                switch (s2.hashCode()) {
                    case 60:
                        if (s2.equals("<")) {
                            c4 = 2;
                            break;
                        }
                        c4 = 65535;
                        break;
                    case 62:
                        if (s2.equals(">")) {
                            c4 = 4;
                            break;
                        }
                        c4 = 65535;
                        break;
                    case MetricsProto.MetricsEvent.ACTION_SETTINGS_SMS_MIRRORING /* 1084 */:
                        if (s2.equals("!=")) {
                            c4 = 1;
                            break;
                        }
                        c4 = 65535;
                        break;
                    case 1921:
                        if (s2.equals("<=")) {
                            c4 = 3;
                            break;
                        }
                        c4 = 65535;
                        break;
                    case 1952:
                        if (s2.equals("==")) {
                            c4 = 0;
                            break;
                        }
                        c4 = 65535;
                        break;
                    case 1983:
                        if (s2.equals(">=")) {
                            c4 = 5;
                            break;
                        }
                        c4 = 65535;
                        break;
                    default:
                        c4 = 65535;
                        break;
                }
                switch (c4) {
                    case 0:
                        return EQ;
                    case 1:
                        return NE;
                    case 2:
                        return LT;
                    case 3:
                        return LE;
                    case 4:
                        return GT;
                    case 5:
                        return GE;
                    default:
                        throw new IllegalArgumentException("Error in security property. " + s2 + " is not a legal Operator");
                }
            }
        }

        public boolean permits(Key key) {
            return true;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    private static class jdkCAConstraint extends Constraint {
        jdkCAConstraint(String algo) {
            super();
            this.algorithm = algo;
        }

        @Override // sun.security.util.DisabledAlgorithmConstraints.Constraint
        public void permits(CertConstraintParameters cp) throws CertPathValidatorException {
            if (DisabledAlgorithmConstraints.debug != null) {
                DisabledAlgorithmConstraints.debug.println("jdkCAConstraints.permits(): " + this.algorithm);
            }
            if (cp.isTrustedMatch()) {
                if (this.nextConstraint != null) {
                    this.nextConstraint.permits(cp);
                    return;
                }
                throw new CertPathValidatorException("Algorithm constraints check failed on certificate anchor limits", null, null, -1, CertPathValidatorException.BasicReason.ALGORITHM_CONSTRAINED);
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    private static class KeySizeConstraint extends Constraint {
        private int maxSize;
        private int minSize;
        private int prohibitedSize;

        public KeySizeConstraint(String algo, Constraint.Operator operator, int length) {
            super();
            this.prohibitedSize = -1;
            this.algorithm = algo;
            switch (AnonymousClass1.$SwitchMap$sun$security$util$DisabledAlgorithmConstraints$Constraint$Operator[operator.ordinal()]) {
                case 1:
                    this.minSize = 0;
                    this.maxSize = Integer.MAX_VALUE;
                    this.prohibitedSize = length;
                    return;
                case 2:
                    this.minSize = length;
                    this.maxSize = length;
                    return;
                case 3:
                    this.minSize = length;
                    this.maxSize = Integer.MAX_VALUE;
                    return;
                case 4:
                    this.minSize = length + 1;
                    this.maxSize = Integer.MAX_VALUE;
                    return;
                case 5:
                    this.minSize = 0;
                    this.maxSize = length;
                    return;
                case 6:
                    this.minSize = 0;
                    this.maxSize = length > 1 ? length - 1 : 0;
                    return;
                default:
                    this.minSize = Integer.MAX_VALUE;
                    this.maxSize = -1;
                    return;
            }
        }

        @Override // sun.security.util.DisabledAlgorithmConstraints.Constraint
        public void permits(CertConstraintParameters cp) throws CertPathValidatorException {
            if (!permitsImpl(cp.getCertificate().getPublicKey())) {
                if (this.nextConstraint != null) {
                    this.nextConstraint.permits(cp);
                    return;
                }
                throw new CertPathValidatorException("Algorithm constraints check failed on keysize limits", null, null, -1, CertPathValidatorException.BasicReason.ALGORITHM_CONSTRAINED);
            }
        }

        @Override // sun.security.util.DisabledAlgorithmConstraints.Constraint
        public boolean permits(Key key) {
            if (this.nextConstraint != null && this.nextConstraint.permits(key)) {
                return true;
            }
            if (DisabledAlgorithmConstraints.debug != null) {
                DisabledAlgorithmConstraints.debug.println("KeySizeConstraints.permits(): " + this.algorithm);
            }
            return permitsImpl(key);
        }

        private boolean permitsImpl(Key key) {
            if (this.algorithm.compareToIgnoreCase(key.getAlgorithm()) != 0) {
                return true;
            }
            int size = KeyUtil.getKeySize(key);
            if (size == 0) {
                return false;
            }
            if (size > 0) {
                return size >= this.minSize && size <= this.maxSize && this.prohibitedSize != size;
            }
            return true;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* renamed from: sun.security.util.DisabledAlgorithmConstraints$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$sun$security$util$DisabledAlgorithmConstraints$Constraint$Operator;

        static {
            int[] iArr = new int[Constraint.Operator.values().length];
            $SwitchMap$sun$security$util$DisabledAlgorithmConstraints$Constraint$Operator = iArr;
            try {
                iArr[Constraint.Operator.EQ.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$sun$security$util$DisabledAlgorithmConstraints$Constraint$Operator[Constraint.Operator.NE.ordinal()] = 2;
            } catch (NoSuchFieldError e10) {
            }
            try {
                $SwitchMap$sun$security$util$DisabledAlgorithmConstraints$Constraint$Operator[Constraint.Operator.LT.ordinal()] = 3;
            } catch (NoSuchFieldError e11) {
            }
            try {
                $SwitchMap$sun$security$util$DisabledAlgorithmConstraints$Constraint$Operator[Constraint.Operator.LE.ordinal()] = 4;
            } catch (NoSuchFieldError e12) {
            }
            try {
                $SwitchMap$sun$security$util$DisabledAlgorithmConstraints$Constraint$Operator[Constraint.Operator.GT.ordinal()] = 5;
            } catch (NoSuchFieldError e13) {
            }
            try {
                $SwitchMap$sun$security$util$DisabledAlgorithmConstraints$Constraint$Operator[Constraint.Operator.GE.ordinal()] = 6;
            } catch (NoSuchFieldError e14) {
            }
        }
    }
}

package java.security;

import java.util.Arrays;
import java.util.Locale;
import java.util.Objects;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class DrbgParameters {
    private DrbgParameters() {
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public enum Capability {
        PR_AND_RESEED,
        RESEED_ONLY,
        NONE;

        @Override // java.lang.Enum
        public String toString() {
            return name().toLowerCase(Locale.ROOT);
        }

        public boolean supportsReseeding() {
            return this != NONE;
        }

        public boolean supportsPredictionResistance() {
            return this == PR_AND_RESEED;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class Instantiation implements SecureRandomParameters {
        private final Capability capability;
        private final byte[] personalizationString;
        private final int strength;

        public int getStrength() {
            return this.strength;
        }

        public Capability getCapability() {
            return this.capability;
        }

        public byte[] getPersonalizationString() {
            byte[] bArr = this.personalizationString;
            if (bArr == null) {
                return null;
            }
            return (byte[]) bArr.clone();
        }

        private Instantiation(int strength, Capability capability, byte[] personalizationString) {
            if (strength < -1) {
                throw new IllegalArgumentException("Illegal security strength: " + strength);
            }
            this.strength = strength;
            this.capability = capability;
            this.personalizationString = personalizationString == null ? null : (byte[]) personalizationString.clone();
        }

        public String toString() {
            return this.strength + "," + ((Object) this.capability) + "," + Arrays.toString(this.personalizationString);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class NextBytes implements SecureRandomParameters {
        private final byte[] additionalInput;
        private final boolean predictionResistance;
        private final int strength;

        public int getStrength() {
            return this.strength;
        }

        public boolean getPredictionResistance() {
            return this.predictionResistance;
        }

        public byte[] getAdditionalInput() {
            byte[] bArr = this.additionalInput;
            if (bArr == null) {
                return null;
            }
            return (byte[]) bArr.clone();
        }

        private NextBytes(int strength, boolean predictionResistance, byte[] additionalInput) {
            if (strength < -1) {
                throw new IllegalArgumentException("Illegal security strength: " + strength);
            }
            this.strength = strength;
            this.predictionResistance = predictionResistance;
            this.additionalInput = additionalInput == null ? null : (byte[]) additionalInput.clone();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class Reseed implements SecureRandomParameters {
        private final byte[] additionalInput;
        private final boolean predictionResistance;

        public boolean getPredictionResistance() {
            return this.predictionResistance;
        }

        public byte[] getAdditionalInput() {
            byte[] bArr = this.additionalInput;
            if (bArr == null) {
                return null;
            }
            return (byte[]) bArr.clone();
        }

        private Reseed(boolean predictionResistance, byte[] additionalInput) {
            this.predictionResistance = predictionResistance;
            this.additionalInput = additionalInput == null ? null : (byte[]) additionalInput.clone();
        }
    }

    public static Instantiation instantiation(int strength, Capability capability, byte[] personalizationString) {
        return new Instantiation(strength, (Capability) Objects.requireNonNull(capability), personalizationString);
    }

    public static NextBytes nextBytes(int strength, boolean predictionResistance, byte[] additionalInput) {
        return new NextBytes(strength, predictionResistance, additionalInput);
    }

    public static Reseed reseed(boolean predictionResistance, byte[] additionalInput) {
        return new Reseed(predictionResistance, additionalInput);
    }
}

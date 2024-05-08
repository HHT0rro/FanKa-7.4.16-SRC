package androidx.constraintlayout.solver;

import androidx.exifinterface.media.ExifInterface;
import java.util.Arrays;
import java.util.HashSet;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class SolverVariable {
    private static final boolean INTERNAL_DEBUG = false;
    public static final int MAX_STRENGTH = 9;
    public static final int STRENGTH_BARRIER = 6;
    public static final int STRENGTH_CENTERING = 7;
    public static final int STRENGTH_EQUALITY = 5;
    public static final int STRENGTH_FIXED = 8;
    public static final int STRENGTH_HIGH = 3;
    public static final int STRENGTH_HIGHEST = 4;
    public static final int STRENGTH_LOW = 1;
    public static final int STRENGTH_MEDIUM = 2;
    public static final int STRENGTH_NONE = 0;
    private static final boolean VAR_USE_HASH = false;
    private static int uniqueConstantId = 1;
    private static int uniqueErrorId = 1;
    private static int uniqueId = 1;
    private static int uniqueSlackId = 1;
    private static int uniqueUnrestrictedId = 1;
    public float computedValue;
    public int definitionId;
    public float[] goalStrengthVector;

    /* renamed from: id, reason: collision with root package name */
    public int f860id;
    public boolean inGoal;
    public HashSet<ArrayRow> inRows;
    public boolean isFinalValue;
    public boolean isSynonym;
    public ArrayRow[] mClientEquations;
    public int mClientEquationsCount;
    private String mName;
    public Type mType;
    public int strength;
    public float[] strengthVector;
    public int synonym;
    public float synonymDelta;
    public int usageInRowCount;

    /* renamed from: androidx.constraintlayout.solver.SolverVariable$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$solver$SolverVariable$Type;

        static {
            int[] iArr = new int[Type.values().length];
            $SwitchMap$androidx$constraintlayout$solver$SolverVariable$Type = iArr;
            try {
                iArr[Type.UNRESTRICTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$SolverVariable$Type[Type.CONSTANT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$SolverVariable$Type[Type.SLACK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$SolverVariable$Type[Type.ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$SolverVariable$Type[Type.UNKNOWN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public enum Type {
        UNRESTRICTED,
        CONSTANT,
        SLACK,
        ERROR,
        UNKNOWN
    }

    public SolverVariable(String str, Type type) {
        this.f860id = -1;
        this.definitionId = -1;
        this.strength = 0;
        this.isFinalValue = false;
        this.strengthVector = new float[9];
        this.goalStrengthVector = new float[9];
        this.mClientEquations = new ArrayRow[16];
        this.mClientEquationsCount = 0;
        this.usageInRowCount = 0;
        this.isSynonym = false;
        this.synonym = -1;
        this.synonymDelta = 0.0f;
        this.inRows = null;
        this.mName = str;
        this.mType = type;
    }

    private static String getUniqueName(Type type, String str) {
        if (str != null) {
            return str + uniqueErrorId;
        }
        int i10 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$SolverVariable$Type[type.ordinal()];
        if (i10 == 1) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("U");
            int i11 = uniqueUnrestrictedId + 1;
            uniqueUnrestrictedId = i11;
            sb2.append(i11);
            return sb2.toString();
        }
        if (i10 == 2) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("C");
            int i12 = uniqueConstantId + 1;
            uniqueConstantId = i12;
            sb3.append(i12);
            return sb3.toString();
        }
        if (i10 == 3) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append(ExifInterface.LATITUDE_SOUTH);
            int i13 = uniqueSlackId + 1;
            uniqueSlackId = i13;
            sb4.append(i13);
            return sb4.toString();
        }
        if (i10 == 4) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("e");
            int i14 = uniqueErrorId + 1;
            uniqueErrorId = i14;
            sb5.append(i14);
            return sb5.toString();
        }
        if (i10 == 5) {
            StringBuilder sb6 = new StringBuilder();
            sb6.append(ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
            int i15 = uniqueId + 1;
            uniqueId = i15;
            sb6.append(i15);
            return sb6.toString();
        }
        throw new AssertionError((Object) type.name());
    }

    public static void increaseErrorId() {
        uniqueErrorId++;
    }

    public final void addToRow(ArrayRow arrayRow) {
        int i10 = 0;
        while (true) {
            int i11 = this.mClientEquationsCount;
            if (i10 < i11) {
                if (this.mClientEquations[i10] == arrayRow) {
                    return;
                } else {
                    i10++;
                }
            } else {
                ArrayRow[] arrayRowArr = this.mClientEquations;
                if (i11 >= arrayRowArr.length) {
                    this.mClientEquations = (ArrayRow[]) Arrays.copyOf(arrayRowArr, arrayRowArr.length * 2);
                }
                ArrayRow[] arrayRowArr2 = this.mClientEquations;
                int i12 = this.mClientEquationsCount;
                arrayRowArr2[i12] = arrayRow;
                this.mClientEquationsCount = i12 + 1;
                return;
            }
        }
    }

    public void clearStrengths() {
        for (int i10 = 0; i10 < 9; i10++) {
            this.strengthVector[i10] = 0.0f;
        }
    }

    public String getName() {
        return this.mName;
    }

    public final void removeFromRow(ArrayRow arrayRow) {
        int i10 = this.mClientEquationsCount;
        int i11 = 0;
        while (i11 < i10) {
            if (this.mClientEquations[i11] == arrayRow) {
                while (i11 < i10 - 1) {
                    ArrayRow[] arrayRowArr = this.mClientEquations;
                    int i12 = i11 + 1;
                    arrayRowArr[i11] = arrayRowArr[i12];
                    i11 = i12;
                }
                this.mClientEquationsCount--;
                return;
            }
            i11++;
        }
    }

    public void reset() {
        this.mName = null;
        this.mType = Type.UNKNOWN;
        this.strength = 0;
        this.f860id = -1;
        this.definitionId = -1;
        this.computedValue = 0.0f;
        this.isFinalValue = false;
        this.isSynonym = false;
        this.synonym = -1;
        this.synonymDelta = 0.0f;
        int i10 = this.mClientEquationsCount;
        for (int i11 = 0; i11 < i10; i11++) {
            this.mClientEquations[i11] = null;
        }
        this.mClientEquationsCount = 0;
        this.usageInRowCount = 0;
        this.inGoal = false;
        Arrays.fill(this.goalStrengthVector, 0.0f);
    }

    public void setFinalValue(LinearSystem linearSystem, float f10) {
        this.computedValue = f10;
        this.isFinalValue = true;
        this.isSynonym = false;
        this.synonym = -1;
        this.synonymDelta = 0.0f;
        int i10 = this.mClientEquationsCount;
        this.definitionId = -1;
        for (int i11 = 0; i11 < i10; i11++) {
            this.mClientEquations[i11].updateFromFinalVariable(linearSystem, this, false);
        }
        this.mClientEquationsCount = 0;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public void setSynonym(LinearSystem linearSystem, SolverVariable solverVariable, float f10) {
        this.isSynonym = true;
        this.synonym = solverVariable.f860id;
        this.synonymDelta = f10;
        int i10 = this.mClientEquationsCount;
        this.definitionId = -1;
        for (int i11 = 0; i11 < i10; i11++) {
            this.mClientEquations[i11].updateFromSynonymVariable(linearSystem, this, false);
        }
        this.mClientEquationsCount = 0;
        linearSystem.displayReadableRows();
    }

    public void setType(Type type, String str) {
        this.mType = type;
    }

    public String strengthsToString() {
        String str = ((Object) this) + "[";
        boolean z10 = false;
        boolean z11 = true;
        for (int i10 = 0; i10 < this.strengthVector.length; i10++) {
            String str2 = str + this.strengthVector[i10];
            float[] fArr = this.strengthVector;
            if (fArr[i10] > 0.0f) {
                z10 = false;
            } else if (fArr[i10] < 0.0f) {
                z10 = true;
            }
            if (fArr[i10] != 0.0f) {
                z11 = false;
            }
            str = i10 < fArr.length - 1 ? str2 + ", " : str2 + "] ";
        }
        if (z10) {
            str = str + " (-)";
        }
        if (!z11) {
            return str;
        }
        return str + " (*)";
    }

    public String toString() {
        if (this.mName != null) {
            return "" + this.mName;
        }
        return "" + this.f860id;
    }

    public final void updateReferencesWithNewDefinition(LinearSystem linearSystem, ArrayRow arrayRow) {
        int i10 = this.mClientEquationsCount;
        for (int i11 = 0; i11 < i10; i11++) {
            this.mClientEquations[i11].updateFromRow(linearSystem, arrayRow, false);
        }
        this.mClientEquationsCount = 0;
    }

    public SolverVariable(Type type, String str) {
        this.f860id = -1;
        this.definitionId = -1;
        this.strength = 0;
        this.isFinalValue = false;
        this.strengthVector = new float[9];
        this.goalStrengthVector = new float[9];
        this.mClientEquations = new ArrayRow[16];
        this.mClientEquationsCount = 0;
        this.usageInRowCount = 0;
        this.isSynonym = false;
        this.synonym = -1;
        this.synonymDelta = 0.0f;
        this.inRows = null;
        this.mType = type;
    }
}

package androidx.constraintlayout.solver;

import androidx.constraintlayout.solver.ArrayRow;
import java.util.Arrays;
import java.util.Comparator;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class PriorityGoalRow extends ArrayRow {
    private static final boolean DEBUG = false;
    public static final int NOT_FOUND = -1;
    private static final float epsilon = 1.0E-4f;
    private int TABLE_SIZE;
    public GoalVariableAccessor accessor;
    private SolverVariable[] arrayGoals;
    public Cache mCache;
    private int numGoals;
    private SolverVariable[] sortArray;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class GoalVariableAccessor implements Comparable {
        public PriorityGoalRow row;
        public SolverVariable variable;

        public GoalVariableAccessor(PriorityGoalRow priorityGoalRow) {
            this.row = priorityGoalRow;
        }

        public void add(SolverVariable solverVariable) {
            for (int i10 = 0; i10 < 9; i10++) {
                float[] fArr = this.variable.goalStrengthVector;
                fArr[i10] = fArr[i10] + solverVariable.goalStrengthVector[i10];
                if (Math.abs(fArr[i10]) < 1.0E-4f) {
                    this.variable.goalStrengthVector[i10] = 0.0f;
                }
            }
        }

        public boolean addToGoal(SolverVariable solverVariable, float f10) {
            boolean z10 = true;
            if (!this.variable.inGoal) {
                for (int i10 = 0; i10 < 9; i10++) {
                    float f11 = solverVariable.goalStrengthVector[i10];
                    if (f11 != 0.0f) {
                        float f12 = f11 * f10;
                        if (Math.abs(f12) < 1.0E-4f) {
                            f12 = 0.0f;
                        }
                        this.variable.goalStrengthVector[i10] = f12;
                    } else {
                        this.variable.goalStrengthVector[i10] = 0.0f;
                    }
                }
                return true;
            }
            for (int i11 = 0; i11 < 9; i11++) {
                float[] fArr = this.variable.goalStrengthVector;
                fArr[i11] = fArr[i11] + (solverVariable.goalStrengthVector[i11] * f10);
                if (Math.abs(fArr[i11]) < 1.0E-4f) {
                    this.variable.goalStrengthVector[i11] = 0.0f;
                } else {
                    z10 = false;
                }
            }
            if (z10) {
                PriorityGoalRow.this.removeGoal(this.variable);
            }
            return false;
        }

        @Override // java.lang.Comparable
        public int compareTo(Object obj) {
            return this.variable.f860id - ((SolverVariable) obj).f860id;
        }

        public void init(SolverVariable solverVariable) {
            this.variable = solverVariable;
        }

        public final boolean isNegative() {
            for (int i10 = 8; i10 >= 0; i10--) {
                float f10 = this.variable.goalStrengthVector[i10];
                if (f10 > 0.0f) {
                    return false;
                }
                if (f10 < 0.0f) {
                    return true;
                }
            }
            return false;
        }

        public final boolean isNull() {
            for (int i10 = 0; i10 < 9; i10++) {
                if (this.variable.goalStrengthVector[i10] != 0.0f) {
                    return false;
                }
            }
            return true;
        }

        public final boolean isSmallerThan(SolverVariable solverVariable) {
            int i10 = 8;
            while (true) {
                if (i10 < 0) {
                    break;
                }
                float f10 = solverVariable.goalStrengthVector[i10];
                float f11 = this.variable.goalStrengthVector[i10];
                if (f11 == f10) {
                    i10--;
                } else if (f11 < f10) {
                    return true;
                }
            }
            return false;
        }

        public void reset() {
            Arrays.fill(this.variable.goalStrengthVector, 0.0f);
        }

        public String toString() {
            String str = "[ ";
            if (this.variable != null) {
                for (int i10 = 0; i10 < 9; i10++) {
                    str = str + this.variable.goalStrengthVector[i10] + " ";
                }
            }
            return str + "] " + ((Object) this.variable);
        }
    }

    public PriorityGoalRow(Cache cache) {
        super(cache);
        this.TABLE_SIZE = 128;
        this.arrayGoals = new SolverVariable[128];
        this.sortArray = new SolverVariable[128];
        this.numGoals = 0;
        this.accessor = new GoalVariableAccessor(this);
        this.mCache = cache;
    }

    private final void addToGoal(SolverVariable solverVariable) {
        int i10;
        int i11 = this.numGoals + 1;
        SolverVariable[] solverVariableArr = this.arrayGoals;
        if (i11 > solverVariableArr.length) {
            SolverVariable[] solverVariableArr2 = (SolverVariable[]) Arrays.copyOf(solverVariableArr, solverVariableArr.length * 2);
            this.arrayGoals = solverVariableArr2;
            this.sortArray = (SolverVariable[]) Arrays.copyOf(solverVariableArr2, solverVariableArr2.length * 2);
        }
        SolverVariable[] solverVariableArr3 = this.arrayGoals;
        int i12 = this.numGoals;
        solverVariableArr3[i12] = solverVariable;
        int i13 = i12 + 1;
        this.numGoals = i13;
        if (i13 > 1 && solverVariableArr3[i13 - 1].f860id > solverVariable.f860id) {
            int i14 = 0;
            while (true) {
                i10 = this.numGoals;
                if (i14 >= i10) {
                    break;
                }
                this.sortArray[i14] = this.arrayGoals[i14];
                i14++;
            }
            Arrays.sort(this.sortArray, 0, i10, new Comparator<SolverVariable>() { // from class: androidx.constraintlayout.solver.PriorityGoalRow.1
                @Override // java.util.Comparator
                public int compare(SolverVariable solverVariable2, SolverVariable solverVariable3) {
                    return solverVariable2.f860id - solverVariable3.f860id;
                }
            });
            for (int i15 = 0; i15 < this.numGoals; i15++) {
                this.arrayGoals[i15] = this.sortArray[i15];
            }
        }
        solverVariable.inGoal = true;
        solverVariable.addToRow(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void removeGoal(SolverVariable solverVariable) {
        int i10 = 0;
        while (i10 < this.numGoals) {
            if (this.arrayGoals[i10] == solverVariable) {
                while (true) {
                    int i11 = this.numGoals;
                    if (i10 < i11 - 1) {
                        SolverVariable[] solverVariableArr = this.arrayGoals;
                        int i12 = i10 + 1;
                        solverVariableArr[i10] = solverVariableArr[i12];
                        i10 = i12;
                    } else {
                        this.numGoals = i11 - 1;
                        solverVariable.inGoal = false;
                        return;
                    }
                }
            } else {
                i10++;
            }
        }
    }

    @Override // androidx.constraintlayout.solver.ArrayRow, androidx.constraintlayout.solver.LinearSystem.Row
    public void addError(SolverVariable solverVariable) {
        this.accessor.init(solverVariable);
        this.accessor.reset();
        solverVariable.goalStrengthVector[solverVariable.strength] = 1.0f;
        addToGoal(solverVariable);
    }

    @Override // androidx.constraintlayout.solver.ArrayRow, androidx.constraintlayout.solver.LinearSystem.Row
    public void clear() {
        this.numGoals = 0;
        this.constantValue = 0.0f;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow, androidx.constraintlayout.solver.LinearSystem.Row
    public SolverVariable getPivotCandidate(LinearSystem linearSystem, boolean[] zArr) {
        int i10 = -1;
        for (int i11 = 0; i11 < this.numGoals; i11++) {
            SolverVariable solverVariable = this.arrayGoals[i11];
            if (!zArr[solverVariable.f860id]) {
                this.accessor.init(solverVariable);
                if (i10 == -1) {
                    if (!this.accessor.isNegative()) {
                    }
                    i10 = i11;
                } else {
                    if (!this.accessor.isSmallerThan(this.arrayGoals[i10])) {
                    }
                    i10 = i11;
                }
            }
        }
        if (i10 == -1) {
            return null;
        }
        return this.arrayGoals[i10];
    }

    @Override // androidx.constraintlayout.solver.ArrayRow, androidx.constraintlayout.solver.LinearSystem.Row
    public boolean isEmpty() {
        return this.numGoals == 0;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow
    public String toString() {
        String str = " goal -> (" + this.constantValue + ") : ";
        for (int i10 = 0; i10 < this.numGoals; i10++) {
            this.accessor.init(this.arrayGoals[i10]);
            str = str + ((Object) this.accessor) + " ";
        }
        return str;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow, androidx.constraintlayout.solver.LinearSystem.Row
    public void updateFromRow(LinearSystem linearSystem, ArrayRow arrayRow, boolean z10) {
        SolverVariable solverVariable = arrayRow.variable;
        if (solverVariable == null) {
            return;
        }
        ArrayRow.ArrayRowVariables arrayRowVariables = arrayRow.variables;
        int currentSize = arrayRowVariables.getCurrentSize();
        for (int i10 = 0; i10 < currentSize; i10++) {
            SolverVariable variable = arrayRowVariables.getVariable(i10);
            float variableValue = arrayRowVariables.getVariableValue(i10);
            this.accessor.init(variable);
            if (this.accessor.addToGoal(solverVariable, variableValue)) {
                addToGoal(variable);
            }
            this.constantValue += arrayRow.constantValue * variableValue;
        }
        removeGoal(solverVariable);
    }
}

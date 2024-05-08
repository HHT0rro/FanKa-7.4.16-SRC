package androidx.constraintlayout.solver;

import androidx.constraintlayout.solver.ArrayRow;
import java.util.Arrays;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class SolverVariableValues implements ArrayRow.ArrayRowVariables {
    private static final boolean DEBUG = false;
    private static final boolean HASH = true;
    private static float epsilon = 0.001f;
    public final Cache mCache;
    private final ArrayRow mRow;
    private final int NONE = -1;
    private int SIZE = 16;
    private int HASH_SIZE = 16;
    public int[] keys = new int[16];
    public int[] nextKeys = new int[16];
    public int[] variables = new int[16];
    public float[] values = new float[16];
    public int[] previous = new int[16];
    public int[] next = new int[16];
    public int mCount = 0;
    public int head = -1;

    public SolverVariableValues(ArrayRow arrayRow, Cache cache) {
        this.mRow = arrayRow;
        this.mCache = cache;
        clear();
    }

    private void addToHashMap(SolverVariable solverVariable, int i10) {
        int[] iArr;
        int i11 = solverVariable.f860id % this.HASH_SIZE;
        int[] iArr2 = this.keys;
        int i12 = iArr2[i11];
        if (i12 == -1) {
            iArr2[i11] = i10;
        } else {
            while (true) {
                iArr = this.nextKeys;
                if (iArr[i12] == -1) {
                    break;
                } else {
                    i12 = iArr[i12];
                }
            }
            iArr[i12] = i10;
        }
        this.nextKeys[i10] = -1;
    }

    private void addVariable(int i10, SolverVariable solverVariable, float f10) {
        this.variables[i10] = solverVariable.f860id;
        this.values[i10] = f10;
        this.previous[i10] = -1;
        this.next[i10] = -1;
        solverVariable.addToRow(this.mRow);
        solverVariable.usageInRowCount++;
        this.mCount++;
    }

    private void displayHash() {
        for (int i10 = 0; i10 < this.HASH_SIZE; i10++) {
            if (this.keys[i10] != -1) {
                String str = hashCode() + " hash [" + i10 + "] => ";
                int i11 = this.keys[i10];
                boolean z10 = false;
                while (!z10) {
                    str = str + " " + this.variables[i11];
                    int[] iArr = this.nextKeys;
                    if (iArr[i11] != -1) {
                        i11 = iArr[i11];
                    } else {
                        z10 = true;
                    }
                }
                System.out.println(str);
            }
        }
    }

    private int findEmptySlot() {
        for (int i10 = 0; i10 < this.SIZE; i10++) {
            if (this.variables[i10] == -1) {
                return i10;
            }
        }
        return -1;
    }

    private void increaseSize() {
        int i10 = this.SIZE * 2;
        this.variables = Arrays.copyOf(this.variables, i10);
        this.values = Arrays.copyOf(this.values, i10);
        this.previous = Arrays.copyOf(this.previous, i10);
        this.next = Arrays.copyOf(this.next, i10);
        this.nextKeys = Arrays.copyOf(this.nextKeys, i10);
        for (int i11 = this.SIZE; i11 < i10; i11++) {
            this.variables[i11] = -1;
            this.nextKeys[i11] = -1;
        }
        this.SIZE = i10;
    }

    private void insertVariable(int i10, SolverVariable solverVariable, float f10) {
        int findEmptySlot = findEmptySlot();
        addVariable(findEmptySlot, solverVariable, f10);
        if (i10 != -1) {
            this.previous[findEmptySlot] = i10;
            int[] iArr = this.next;
            iArr[findEmptySlot] = iArr[i10];
            iArr[i10] = findEmptySlot;
        } else {
            this.previous[findEmptySlot] = -1;
            if (this.mCount > 0) {
                this.next[findEmptySlot] = this.head;
                this.head = findEmptySlot;
            } else {
                this.next[findEmptySlot] = -1;
            }
        }
        int[] iArr2 = this.next;
        if (iArr2[findEmptySlot] != -1) {
            this.previous[iArr2[findEmptySlot]] = findEmptySlot;
        }
        addToHashMap(solverVariable, findEmptySlot);
    }

    private void removeFromHashMap(SolverVariable solverVariable) {
        int[] iArr;
        int i10 = solverVariable.f860id;
        int i11 = i10 % this.HASH_SIZE;
        int[] iArr2 = this.keys;
        int i12 = iArr2[i11];
        if (i12 == -1) {
            return;
        }
        if (this.variables[i12] == i10) {
            int[] iArr3 = this.nextKeys;
            iArr2[i11] = iArr3[i12];
            iArr3[i12] = -1;
            return;
        }
        while (true) {
            iArr = this.nextKeys;
            if (iArr[i12] == -1 || this.variables[iArr[i12]] == i10) {
                break;
            } else {
                i12 = iArr[i12];
            }
        }
        int i13 = iArr[i12];
        if (i13 == -1 || this.variables[i13] != i10) {
            return;
        }
        iArr[i12] = iArr[i13];
        iArr[i13] = -1;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public void add(SolverVariable solverVariable, float f10, boolean z10) {
        float f11 = epsilon;
        if (f10 <= (-f11) || f10 >= f11) {
            int indexOf = indexOf(solverVariable);
            if (indexOf == -1) {
                put(solverVariable, f10);
                return;
            }
            float[] fArr = this.values;
            fArr[indexOf] = fArr[indexOf] + f10;
            float f12 = fArr[indexOf];
            float f13 = epsilon;
            if (f12 <= (-f13) || fArr[indexOf] >= f13) {
                return;
            }
            fArr[indexOf] = 0.0f;
            remove(solverVariable, z10);
        }
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public void clear() {
        int i10 = this.mCount;
        for (int i11 = 0; i11 < i10; i11++) {
            SolverVariable variable = getVariable(i11);
            if (variable != null) {
                variable.removeFromRow(this.mRow);
            }
        }
        for (int i12 = 0; i12 < this.SIZE; i12++) {
            this.variables[i12] = -1;
            this.nextKeys[i12] = -1;
        }
        for (int i13 = 0; i13 < this.HASH_SIZE; i13++) {
            this.keys[i13] = -1;
        }
        this.mCount = 0;
        this.head = -1;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public boolean contains(SolverVariable solverVariable) {
        return indexOf(solverVariable) != -1;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public void display() {
        int i10 = this.mCount;
        System.out.print("{ ");
        for (int i11 = 0; i11 < i10; i11++) {
            SolverVariable variable = getVariable(i11);
            if (variable != null) {
                System.out.print(((Object) variable) + " = " + getVariableValue(i11) + " ");
            }
        }
        System.out.println(" }");
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public void divideByAmount(float f10) {
        int i10 = this.mCount;
        int i11 = this.head;
        for (int i12 = 0; i12 < i10; i12++) {
            float[] fArr = this.values;
            fArr[i11] = fArr[i11] / f10;
            i11 = this.next[i11];
            if (i11 == -1) {
                return;
            }
        }
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public float get(SolverVariable solverVariable) {
        int indexOf = indexOf(solverVariable);
        if (indexOf != -1) {
            return this.values[indexOf];
        }
        return 0.0f;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public int getCurrentSize() {
        return this.mCount;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public SolverVariable getVariable(int i10) {
        int i11 = this.mCount;
        if (i11 == 0) {
            return null;
        }
        int i12 = this.head;
        for (int i13 = 0; i13 < i11; i13++) {
            if (i13 == i10 && i12 != -1) {
                return this.mCache.mIndexedVariables[this.variables[i12]];
            }
            i12 = this.next[i12];
            if (i12 == -1) {
                break;
            }
        }
        return null;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public float getVariableValue(int i10) {
        int i11 = this.mCount;
        int i12 = this.head;
        for (int i13 = 0; i13 < i11; i13++) {
            if (i13 == i10) {
                return this.values[i12];
            }
            i12 = this.next[i12];
            if (i12 == -1) {
                return 0.0f;
            }
        }
        return 0.0f;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public int indexOf(SolverVariable solverVariable) {
        int[] iArr;
        if (this.mCount != 0 && solverVariable != null) {
            int i10 = solverVariable.f860id;
            int i11 = this.keys[i10 % this.HASH_SIZE];
            if (i11 == -1) {
                return -1;
            }
            if (this.variables[i11] == i10) {
                return i11;
            }
            while (true) {
                iArr = this.nextKeys;
                if (iArr[i11] == -1 || this.variables[iArr[i11]] == i10) {
                    break;
                }
                i11 = iArr[i11];
            }
            if (iArr[i11] != -1 && this.variables[iArr[i11]] == i10) {
                return iArr[i11];
            }
        }
        return -1;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public void invert() {
        int i10 = this.mCount;
        int i11 = this.head;
        for (int i12 = 0; i12 < i10; i12++) {
            float[] fArr = this.values;
            fArr[i11] = fArr[i11] * (-1.0f);
            i11 = this.next[i11];
            if (i11 == -1) {
                return;
            }
        }
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public void put(SolverVariable solverVariable, float f10) {
        float f11 = epsilon;
        if (f10 > (-f11) && f10 < f11) {
            remove(solverVariable, true);
            return;
        }
        if (this.mCount == 0) {
            addVariable(0, solverVariable, f10);
            addToHashMap(solverVariable, 0);
            this.head = 0;
            return;
        }
        int indexOf = indexOf(solverVariable);
        if (indexOf != -1) {
            this.values[indexOf] = f10;
            return;
        }
        if (this.mCount + 1 >= this.SIZE) {
            increaseSize();
        }
        int i10 = this.mCount;
        int i11 = this.head;
        int i12 = -1;
        for (int i13 = 0; i13 < i10; i13++) {
            int[] iArr = this.variables;
            int i14 = iArr[i11];
            int i15 = solverVariable.f860id;
            if (i14 == i15) {
                this.values[i11] = f10;
                return;
            }
            if (iArr[i11] < i15) {
                i12 = i11;
            }
            i11 = this.next[i11];
            if (i11 == -1) {
                break;
            }
        }
        insertVariable(i12, solverVariable, f10);
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public float remove(SolverVariable solverVariable, boolean z10) {
        int indexOf = indexOf(solverVariable);
        if (indexOf == -1) {
            return 0.0f;
        }
        removeFromHashMap(solverVariable);
        float f10 = this.values[indexOf];
        if (this.head == indexOf) {
            this.head = this.next[indexOf];
        }
        this.variables[indexOf] = -1;
        int[] iArr = this.previous;
        if (iArr[indexOf] != -1) {
            int[] iArr2 = this.next;
            iArr2[iArr[indexOf]] = iArr2[indexOf];
        }
        int[] iArr3 = this.next;
        if (iArr3[indexOf] != -1) {
            iArr[iArr3[indexOf]] = iArr[indexOf];
        }
        this.mCount--;
        solverVariable.usageInRowCount--;
        if (z10) {
            solverVariable.removeFromRow(this.mRow);
        }
        return f10;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public int sizeInBytes() {
        return 0;
    }

    public String toString() {
        String str = hashCode() + " { ";
        int i10 = this.mCount;
        for (int i11 = 0; i11 < i10; i11++) {
            SolverVariable variable = getVariable(i11);
            if (variable != null) {
                String str2 = str + ((Object) variable) + " = " + getVariableValue(i11) + " ";
                int indexOf = indexOf(variable);
                String str3 = str2 + "[p: ";
                String str4 = (this.previous[indexOf] != -1 ? str3 + ((Object) this.mCache.mIndexedVariables[this.variables[this.previous[indexOf]]]) : str3 + "none") + ", n: ";
                str = (this.next[indexOf] != -1 ? str4 + ((Object) this.mCache.mIndexedVariables[this.variables[this.next[indexOf]]]) : str4 + "none") + "]";
            }
        }
        return str + " }";
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public float use(ArrayRow arrayRow, boolean z10) {
        float f10 = get(arrayRow.variable);
        remove(arrayRow.variable, z10);
        SolverVariableValues solverVariableValues = (SolverVariableValues) arrayRow.variables;
        int currentSize = solverVariableValues.getCurrentSize();
        int i10 = 0;
        int i11 = 0;
        while (i10 < currentSize) {
            int[] iArr = solverVariableValues.variables;
            if (iArr[i11] != -1) {
                add(this.mCache.mIndexedVariables[iArr[i11]], solverVariableValues.values[i11] * f10, z10);
                i10++;
            }
            i11++;
        }
        return f10;
    }
}

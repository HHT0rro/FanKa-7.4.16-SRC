package androidx.constraintlayout.solver;

import androidx.constraintlayout.solver.Pools;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class Cache {
    public Pools.Pool<ArrayRow> optimizedArrayRowPool = new Pools.SimplePool(256);
    public Pools.Pool<ArrayRow> arrayRowPool = new Pools.SimplePool(256);
    public Pools.Pool<SolverVariable> solverVariablePool = new Pools.SimplePool(256);
    public SolverVariable[] mIndexedVariables = new SolverVariable[32];
}

package com.google.firebase.components;

import java.util.Arrays;
import java.util.List;
import z7.c;

/* compiled from: com.google.firebase:firebase-components@@16.0.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class DependencyCycleException extends DependencyException {
    private final List<c<?>> componentsInCycle;

    public DependencyCycleException(List<c<?>> list) {
        super("Dependency cycle detected: " + Arrays.toString(list.toArray()));
        this.componentsInCycle = list;
    }

    public List<c<?>> getComponentsInCycle() {
        return this.componentsInCycle;
    }
}

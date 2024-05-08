package com.google.common.graph;

import java.util.Deque;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class Traverser<N> {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public enum InsertionOrder {
        FRONT { // from class: com.google.common.graph.Traverser.InsertionOrder.1
            @Override // com.google.common.graph.Traverser.InsertionOrder
            public <T> void insertInto(Deque<T> deque, T t2) {
                deque.addFirst(t2);
            }
        },
        BACK { // from class: com.google.common.graph.Traverser.InsertionOrder.2
            @Override // com.google.common.graph.Traverser.InsertionOrder
            public <T> void insertInto(Deque<T> deque, T t2) {
                deque.addLast(t2);
            }
        };

        public abstract <T> void insertInto(Deque<T> deque, T t2);

        /* synthetic */ InsertionOrder(a aVar) {
            this();
        }
    }
}

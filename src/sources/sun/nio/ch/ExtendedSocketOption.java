package sun.nio.ch;

import java.net.SocketOption;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class ExtendedSocketOption {
    static final SocketOption<Boolean> SO_OOBINLINE = new SocketOption<Boolean>() { // from class: sun.nio.ch.ExtendedSocketOption.1
        @Override // java.net.SocketOption
        public String name() {
            return "SO_OOBINLINE";
        }

        @Override // java.net.SocketOption
        public Class<Boolean> type() {
            return Boolean.class;
        }

        public String toString() {
            return name();
        }
    };

    private ExtendedSocketOption() {
    }
}

package com.cupidapp.live.base.grpc;

import com.android.internal.logging.nano.MetricsProto;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.ProtocolMessageEnum;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Objects;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class CuConnectorOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0012cu-connector.proto\u0012\tconnector\"\u0097\u0001\n\u0010ConnectorMessage\u0012\u0011\n\tmessageId\u0018\u0001 \u0001(\u0004\u0012$\n\u0004type\u0018\u0002 \u0001(\u000e2\u0016.connector.MessageType\u0012\u0018\n\u0010inReplyMessageId\u0018\u0003 \u0001(\u0004\u0012\u0011\n\treplyCode\u0018\u0004 \u0001(\r\u0012\f\n\u0004body\u0018\u0005 \u0001(\t\u0012\u000f\n\u0007needAck\u0018\u0006 \u0001(\b*Ð\u0014\n\u000bMessageType\u0012\r\n\tHeartbeat\u0010\u0000\u0012\b\n\u0004Auth\u0010\u0001\u0012\r\n\tReconnect\u0010\u0002\u0012\u0007\n\u0003ACK\u0010\u0004\u0012\u0010\n\fRequestReply\u0010\u0003\u0012\u000b\n\u0007NewGift\u00102\u0012\u000e\n\nNewComment\u00103\u0012\r\n\tNewNotify\u00104\u0012\u000f\n\u000bLiveShowEnd\u00106\u0012\u000f\n\u000bViewerEnter\u00107\u0012\u0011\n\rLiveBroadcast\u00108\u0012\u000e\n\nMessageNew\u00109\u0012\u000f\n\u000bMessageRead\u0010:\u0012\u0011\n\rMessageCancel\u0010;\u0012\u0012\n\u000eMessageDestroy\u0010<\u0012\u0019\n\u0015NewLiveConnectRequest\u0010=\u0012\u0015\n\u0011LiveConnectAccept\u0010>\u0012\u0012\n\u000eLiveConnectEnd\u0010?\u0012\u0010\n\fActivity1674\u0010@\u0012\u001e\n\u001aLiveConnectPushStreamStart\u0010A\u0012\r\n\tEnterGame\u0010B\u0012\r\n\tLeaveGame\u0010C\u0012\u0015\n\u0011GameServerConnect\u0010D\u0012\u000f\n\u000bViewerLeave\u0010E\u0012\u0013\n\u000fGroupMessageNew\u0010F\u0012\r\n\tLiveShake\u0010G\u0012\u0014\n\u0010LivePkIconStatus\u0010H\u0012\u000f\n\u000bLivePkMatch\u0010I\u0012\u000f\n\u000bLivePkStart\u0010J\u0012\u0010\n\fLivePkUpdate\u0010K\u0012\u000e\n\nLivePkChat\u0010L\u0012\r\n\tLivePkEnd\u0010M\u0012\u000f\n\u000bPushMessage\u0010N\u0012\f\n\bLiveHorn\u0010O\u0012\u0018\n\u0014LivePkAppointRequest\u0010P\u0012\u0017\n\u0013LivePkAppointReject\u0010Q\u0012\u0014\n\u0010LivePkCloseAudio\u0010R\u0012\u0014\n\u0010LivePkRandPaired\u0010S\u0012\u0014\n\u0010AnchorLvlUpgrade\u0010T\u0012\u001d\n\u0019AnchorLvlUpgradeAnimation\u0010U\u0012\u0016\n\u0012AnchorLvlExpChange\u0010V\u0012\u0017\n\u0013AnchorPrivilegeHint\u0010W\u0012\u0018\n\u0014AnchorPrivilegeInUse\u0010X\u0012\u0019\n\u0015AnchorPrivilegeLineUp\u0010Y\u0012\u001c\n\u0018AnchorPrivilegeLineUnUse\u0010Z\u0012\u0014\n\u0010LivePkFirstBlood\u0010[\u0012\u0012\n\u000eLivePkBackDoor\u0010\\\u0012\u0013\n\u000fLiveLotteryCrit\u0010]\u0012\u0017\n\u0013MaskMatchRecPopover\u0010^\u0012\u0014\n\u0010MaskMatchSuccess\u0010_\u0012\u0017\n\u0013MaskMatchNewMessage\u0010`\u0012\u001a\n\u0016MaskMatchMessageRemove\u0010a\u0012\u0016\n\u0012MaskMatchNewSysTip\u0010b\u0012\u0015\n\u0011MaskMatchPlayDice\u0010c\u0012\u0013\n\u000fMaskMatchTyping\u0010d\u0012\u0013\n\u000fCanPlayNewRound\u0010e\u0012\u0016\n\u0012MaskMatchLeaveRoom\u0010f\u0012\u001d\n\u0019ShowUserCanSendImageGuide\u0010g\u0012\u0019\n\u0015LiveRoomElementChange\u0010h\u0012\u0016\n\u0012LotteryBattleStart\u0010i\u0012\u0014\n\u0010LotteryBattleEnd\u0010j\u0012\u0010\n\fDynamicGuide\u0010k\u0012\u0016\n\u0012UnreadCountsUpdate\u0010l\u0012\u0018\n\u0014MaskMatchOnHookPopup\u0010m\u0012\u0014\n\u0010AudioGameRequest\u0010n\u0012\u0015\n\u0011AudioGameQuestion\u0010o\u0012\u0016\n\u0012AudioGameLightMode\u0010p\u0012\u0016\n\u0012AudioGameNewSysTip\u0010q\u0012\u0013\n\u000fGameShowProfile\u0010r\u0012\u0019\n\u0015ClientUiElementChange\u0010t\u0012\u0011\n\rLiveRedPacket\u0010u\u0012\u001f\n\u001bMaskMatchDoublePlayRoleInfo\u0010v\u0012!\n\u001dMaskMatchScriptTechnicalScore\u0010w\u0012\u0017\n\u0013AnchorProfileBorder\u0010x\u0012\u0018\n\u0014AnchorStarLevelChest\u0010y\u0012\u000f\n\u000bLiveKickOut\u0010z\u0012\u000f\n\u000bLiveRoomTag\u0010{\u0012#\n\u001fAnchorStarLevelUpgradeAnimation\u0010|\u0012\u0012\n\u000eLiveMenuRedDot\u0010}\u0012\u0015\n\u0011LiveRoomAnimation\u0010~\u0012\u0015\n\u0011LiveStickerUpdate\u0010\u007f\u0012\u0018\n\u0013LiveRocketAnimation\u0010\u0080\u0001\u0012\u0014\n\u000fGroupMessageTop\u0010\u0081\u0001\u0012\u0015\n\u0010GroupApplySubmit\u0010\u0082\u0001\u0012\u0017\n\u0012GroupMessageCancel\u0010\u0083\u0001\u0012\u001b\n\u0016StreamFollowProcessPie\u0010\u0084\u0001\u0012\u0016\n\u0011NewVoiceRoomEnded\u0010\u0085\u0001\u0012\u0018\n\u0013NewVoiceRoomComment\u0010\u0086\u0001\u0012\u001c\n\u0017VoiceConnectApplyChange\u0010\u0087\u0001\u0012\u001c\n\u0017VoiceConnectAnchorAgree\u0010\u0088\u0001\u0012\u001f\n\u001aVoiceConnectUserJoinedRoom\u0010\u0089\u0001\u0012\u0018\n\u0013VoiceConnectSuccess\u0010\u008a\u0001\u0012\u0017\n\u0012VoiceConnectHangUp\u0010\u008b\u0001\u0012\u0018\n\u0013VoiceConnectBalance\u0010\u008c\u0001\u0012\u0018\n\u0013VoiceRoomOnlineInfo\u0010\u008d\u0001\u0012\u0015\n\u0010VoiceConnectWait\u0010\u008e\u0001\u0012\u001e\n\u0019VoiceRoomAnchorInfoChange\u0010\u008f\u0001\u0012\u0018\n\u0013LiveHeatValueChange\u0010\u0090\u0001\u0012\u000e\n\tChatGuide\u0010\u0091\u0001\u0012\u0013\n\u000eRefreshSession\u0010\u0092\u0001\u0012\u001b\n\u0016LivePkMultiplayerStart\u0010\u0093\u0001\u0012\u001c\n\u0017LivePkMultiplayerUpdate\u0010\u0094\u0001\u0012\u001d\n\u0018LivePkMultiplayerInvited\u0010\u0095\u0001\u0012!\n\u001cLivePkMultiplayerInviteAgree\u0010\u0096\u0001\u0012$\n\u001fLivePkMultiplayerInviteRejected\u0010\u0097\u0001\u0012\u001a\n\u0015LivePkMultiplayerChat\u0010\u0098\u0001\u0012\u0019\n\u0014LivePkMultiplayerEnd\u0010\u0099\u0001\u0012 \n\u001bLivePkMultiplayerCloseAudio\u0010\u009a\u0001\u0012 \n\u001bLivePkMultiplayerFirstBlood\u0010\u009b\u0001\u0012#\n\u001eLivePkMultiplayerMixStreamDone\u0010\u009c\u0001\u0012#\n\u001eLivePkMultiplayerPrepareCancel\u0010\u009d\u0001\u0012\"\n\u001dLivePkMultiplayerInviteCancel\u0010\u009e\u0001*j\n\tReplyCode\u0012\u000b\n\u0007Success\u0010\u0000\u0012\u0017\n\u0013InternalServerError\u0010\u0001\u0012\u0011\n\rInvalidParams\u0010\u0002\u0012\u0011\n\rInvalidTicket\u0010\n\u0012\u0011\n\rExpiredTicket\u0010\u000b2\\\n\u000bCuConnector\u0012M\n\u000bcommunicate\u0012\u001b.connector.ConnectorMessage\u001a\u001b.connector.ConnectorMessage\"\u0000(\u00010\u0001B\u001d\n\u001bcom.cupidapp.live.base.grpcb\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_connector_ConnectorMessage_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_connector_ConnectorMessage_fieldAccessorTable;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class ConnectorMessage extends GeneratedMessageV3 implements ConnectorMessageOrBuilder {
        public static final int BODY_FIELD_NUMBER = 5;
        public static final int INREPLYMESSAGEID_FIELD_NUMBER = 3;
        public static final int MESSAGEID_FIELD_NUMBER = 1;
        public static final int NEEDACK_FIELD_NUMBER = 6;
        public static final int REPLYCODE_FIELD_NUMBER = 4;
        public static final int TYPE_FIELD_NUMBER = 2;
        private static final long serialVersionUID = 0;
        private volatile Object body_;
        private long inReplyMessageId_;
        private byte memoizedIsInitialized;
        private long messageId_;
        private boolean needAck_;
        private int replyCode_;
        private int type_;
        private static final ConnectorMessage DEFAULT_INSTANCE = new ConnectorMessage();
        private static final Parser<ConnectorMessage> PARSER = new AbstractParser<ConnectorMessage>() { // from class: com.cupidapp.live.base.grpc.CuConnectorOuterClass.ConnectorMessage.1
            @Override // com.google.protobuf.Parser
            public ConnectorMessage parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new ConnectorMessage(codedInputStream, extensionRegistryLite);
            }
        };

        private ConnectorMessage(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static ConnectorMessage getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return CuConnectorOuterClass.internal_static_connector_ConnectorMessage_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static ConnectorMessage parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ConnectorMessage) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static ConnectorMessage parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static Parser<ConnectorMessage> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ConnectorMessage)) {
                return super.equals(obj);
            }
            ConnectorMessage connectorMessage = (ConnectorMessage) obj;
            return getMessageId() == connectorMessage.getMessageId() && this.type_ == connectorMessage.type_ && getInReplyMessageId() == connectorMessage.getInReplyMessageId() && getReplyCode() == connectorMessage.getReplyCode() && getBody().equals(connectorMessage.getBody()) && getNeedAck() == connectorMessage.getNeedAck() && this.unknownFields.equals(connectorMessage.unknownFields);
        }

        @Override // com.cupidapp.live.base.grpc.CuConnectorOuterClass.ConnectorMessageOrBuilder
        public String getBody() {
            Object obj = this.body_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.body_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.cupidapp.live.base.grpc.CuConnectorOuterClass.ConnectorMessageOrBuilder
        public ByteString getBodyBytes() {
            Object obj = this.body_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.body_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.cupidapp.live.base.grpc.CuConnectorOuterClass.ConnectorMessageOrBuilder
        public long getInReplyMessageId() {
            return this.inReplyMessageId_;
        }

        @Override // com.cupidapp.live.base.grpc.CuConnectorOuterClass.ConnectorMessageOrBuilder
        public long getMessageId() {
            return this.messageId_;
        }

        @Override // com.cupidapp.live.base.grpc.CuConnectorOuterClass.ConnectorMessageOrBuilder
        public boolean getNeedAck() {
            return this.needAck_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<ConnectorMessage> getParserForType() {
            return PARSER;
        }

        @Override // com.cupidapp.live.base.grpc.CuConnectorOuterClass.ConnectorMessageOrBuilder
        public int getReplyCode() {
            return this.replyCode_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i10 = this.memoizedSize;
            if (i10 != -1) {
                return i10;
            }
            long j10 = this.messageId_;
            int computeUInt64Size = j10 != 0 ? 0 + CodedOutputStream.computeUInt64Size(1, j10) : 0;
            if (this.type_ != MessageType.Heartbeat.getNumber()) {
                computeUInt64Size += CodedOutputStream.computeEnumSize(2, this.type_);
            }
            long j11 = this.inReplyMessageId_;
            if (j11 != 0) {
                computeUInt64Size += CodedOutputStream.computeUInt64Size(3, j11);
            }
            int i11 = this.replyCode_;
            if (i11 != 0) {
                computeUInt64Size += CodedOutputStream.computeUInt32Size(4, i11);
            }
            if (!getBodyBytes().isEmpty()) {
                computeUInt64Size += GeneratedMessageV3.computeStringSize(5, this.body_);
            }
            boolean z10 = this.needAck_;
            if (z10) {
                computeUInt64Size += CodedOutputStream.computeBoolSize(6, z10);
            }
            int serializedSize = computeUInt64Size + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.cupidapp.live.base.grpc.CuConnectorOuterClass.ConnectorMessageOrBuilder
        public MessageType getType() {
            MessageType valueOf = MessageType.valueOf(this.type_);
            return valueOf == null ? MessageType.UNRECOGNIZED : valueOf;
        }

        @Override // com.cupidapp.live.base.grpc.CuConnectorOuterClass.ConnectorMessageOrBuilder
        public int getTypeValue() {
            return this.type_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            int i10 = this.memoizedHashCode;
            if (i10 != 0) {
                return i10;
            }
            int hashCode = ((((((((((((((((((((((((((MetricsProto.MetricsEvent.APP_SPECIAL_PERMISSION_PREMIUM_SMS_DENY + getDescriptor().hashCode()) * 37) + 1) * 53) + Internal.hashLong(getMessageId())) * 37) + 2) * 53) + this.type_) * 37) + 3) * 53) + Internal.hashLong(getInReplyMessageId())) * 37) + 4) * 53) + getReplyCode()) * 37) + 5) * 53) + getBody().hashCode()) * 37) + 6) * 53) + Internal.hashBoolean(getNeedAck())) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return CuConnectorOuterClass.internal_static_connector_ConnectorMessage_fieldAccessorTable.ensureFieldAccessorsInitialized(ConnectorMessage.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b4 = this.memoizedIsInitialized;
            if (b4 == 1) {
                return true;
            }
            if (b4 == 0) {
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new ConnectorMessage();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            long j10 = this.messageId_;
            if (j10 != 0) {
                codedOutputStream.writeUInt64(1, j10);
            }
            if (this.type_ != MessageType.Heartbeat.getNumber()) {
                codedOutputStream.writeEnum(2, this.type_);
            }
            long j11 = this.inReplyMessageId_;
            if (j11 != 0) {
                codedOutputStream.writeUInt64(3, j11);
            }
            int i10 = this.replyCode_;
            if (i10 != 0) {
                codedOutputStream.writeUInt32(4, i10);
            }
            if (!getBodyBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 5, this.body_);
            }
            boolean z10 = this.needAck_;
            if (z10) {
                codedOutputStream.writeBool(6, z10);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ConnectorMessageOrBuilder {
            private Object body_;
            private long inReplyMessageId_;
            private long messageId_;
            private boolean needAck_;
            private int replyCode_;
            private int type_;

            private Builder() {
                this.type_ = 0;
                this.body_ = "";
                maybeForceBuilderInitialization();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return CuConnectorOuterClass.internal_static_connector_ConnectorMessage_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
            }

            public Builder clearBody() {
                this.body_ = ConnectorMessage.getDefaultInstance().getBody();
                onChanged();
                return this;
            }

            public Builder clearInReplyMessageId() {
                this.inReplyMessageId_ = 0L;
                onChanged();
                return this;
            }

            public Builder clearMessageId() {
                this.messageId_ = 0L;
                onChanged();
                return this;
            }

            public Builder clearNeedAck() {
                this.needAck_ = false;
                onChanged();
                return this;
            }

            public Builder clearReplyCode() {
                this.replyCode_ = 0;
                onChanged();
                return this;
            }

            public Builder clearType() {
                this.type_ = 0;
                onChanged();
                return this;
            }

            @Override // com.cupidapp.live.base.grpc.CuConnectorOuterClass.ConnectorMessageOrBuilder
            public String getBody() {
                Object obj = this.body_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.body_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.cupidapp.live.base.grpc.CuConnectorOuterClass.ConnectorMessageOrBuilder
            public ByteString getBodyBytes() {
                Object obj = this.body_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.body_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return CuConnectorOuterClass.internal_static_connector_ConnectorMessage_descriptor;
            }

            @Override // com.cupidapp.live.base.grpc.CuConnectorOuterClass.ConnectorMessageOrBuilder
            public long getInReplyMessageId() {
                return this.inReplyMessageId_;
            }

            @Override // com.cupidapp.live.base.grpc.CuConnectorOuterClass.ConnectorMessageOrBuilder
            public long getMessageId() {
                return this.messageId_;
            }

            @Override // com.cupidapp.live.base.grpc.CuConnectorOuterClass.ConnectorMessageOrBuilder
            public boolean getNeedAck() {
                return this.needAck_;
            }

            @Override // com.cupidapp.live.base.grpc.CuConnectorOuterClass.ConnectorMessageOrBuilder
            public int getReplyCode() {
                return this.replyCode_;
            }

            @Override // com.cupidapp.live.base.grpc.CuConnectorOuterClass.ConnectorMessageOrBuilder
            public MessageType getType() {
                MessageType valueOf = MessageType.valueOf(this.type_);
                return valueOf == null ? MessageType.UNRECOGNIZED : valueOf;
            }

            @Override // com.cupidapp.live.base.grpc.CuConnectorOuterClass.ConnectorMessageOrBuilder
            public int getTypeValue() {
                return this.type_;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return CuConnectorOuterClass.internal_static_connector_ConnectorMessage_fieldAccessorTable.ensureFieldAccessorsInitialized(ConnectorMessage.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder setBody(String str) {
                Objects.requireNonNull(str);
                this.body_ = str;
                onChanged();
                return this;
            }

            public Builder setBodyBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.body_ = byteString;
                onChanged();
                return this;
            }

            public Builder setInReplyMessageId(long j10) {
                this.inReplyMessageId_ = j10;
                onChanged();
                return this;
            }

            public Builder setMessageId(long j10) {
                this.messageId_ = j10;
                onChanged();
                return this;
            }

            public Builder setNeedAck(boolean z10) {
                this.needAck_ = z10;
                onChanged();
                return this;
            }

            public Builder setReplyCode(int i10) {
                this.replyCode_ = i10;
                onChanged();
                return this;
            }

            public Builder setType(MessageType messageType) {
                Objects.requireNonNull(messageType);
                this.type_ = messageType.getNumber();
                onChanged();
                return this;
            }

            public Builder setTypeValue(int i10) {
                this.type_ = i10;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ConnectorMessage build() {
                ConnectorMessage buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessage.Builder.newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ConnectorMessage buildPartial() {
                ConnectorMessage connectorMessage = new ConnectorMessage(this);
                connectorMessage.messageId_ = this.messageId_;
                connectorMessage.type_ = this.type_;
                connectorMessage.inReplyMessageId_ = this.inReplyMessageId_;
                connectorMessage.replyCode_ = this.replyCode_;
                connectorMessage.body_ = this.body_;
                connectorMessage.needAck_ = this.needAck_;
                onBuilt();
                return connectorMessage;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public ConnectorMessage getDefaultInstanceForType() {
                return ConnectorMessage.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.setField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i10, Object obj) {
                return (Builder) super.setRepeatedField(fieldDescriptor, i10, obj);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.setUnknownFields(unknownFieldSet);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                return (Builder) super.clearOneof(oneofDescriptor);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.type_ = 0;
                this.body_ = "";
                maybeForceBuilderInitialization();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.messageId_ = 0L;
                this.type_ = 0;
                this.inReplyMessageId_ = 0L;
                this.replyCode_ = 0;
                this.body_ = "";
                this.needAck_ = false;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo2458clone() {
                return (Builder) super.mo2458clone();
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message message) {
                if (message instanceof ConnectorMessage) {
                    return mergeFrom((ConnectorMessage) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(ConnectorMessage connectorMessage) {
                if (connectorMessage == ConnectorMessage.getDefaultInstance()) {
                    return this;
                }
                if (connectorMessage.getMessageId() != 0) {
                    setMessageId(connectorMessage.getMessageId());
                }
                if (connectorMessage.type_ != 0) {
                    setTypeValue(connectorMessage.getTypeValue());
                }
                if (connectorMessage.getInReplyMessageId() != 0) {
                    setInReplyMessageId(connectorMessage.getInReplyMessageId());
                }
                if (connectorMessage.getReplyCode() != 0) {
                    setReplyCode(connectorMessage.getReplyCode());
                }
                if (!connectorMessage.getBody().isEmpty()) {
                    this.body_ = connectorMessage.body_;
                    onChanged();
                }
                if (connectorMessage.getNeedAck()) {
                    setNeedAck(connectorMessage.getNeedAck());
                }
                mergeUnknownFields(connectorMessage.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public com.cupidapp.live.base.grpc.CuConnectorOuterClass.ConnectorMessage.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser r1 = com.cupidapp.live.base.grpc.CuConnectorOuterClass.ConnectorMessage.j()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    com.cupidapp.live.base.grpc.CuConnectorOuterClass$ConnectorMessage r3 = (com.cupidapp.live.base.grpc.CuConnectorOuterClass.ConnectorMessage) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    if (r3 == 0) goto L10
                    r2.mergeFrom(r3)
                L10:
                    return r2
                L11:
                    r3 = move-exception
                    goto L21
                L13:
                    r3 = move-exception
                    com.google.protobuf.MessageLite r4 = r3.getUnfinishedMessage()     // Catch: java.lang.Throwable -> L11
                    com.cupidapp.live.base.grpc.CuConnectorOuterClass$ConnectorMessage r4 = (com.cupidapp.live.base.grpc.CuConnectorOuterClass.ConnectorMessage) r4     // Catch: java.lang.Throwable -> L11
                    java.io.IOException r3 = r3.unwrapIOException()     // Catch: java.lang.Throwable -> L1f
                    throw r3     // Catch: java.lang.Throwable -> L1f
                L1f:
                    r3 = move-exception
                    r0 = r4
                L21:
                    if (r0 == 0) goto L26
                    r2.mergeFrom(r0)
                L26:
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.base.grpc.CuConnectorOuterClass.ConnectorMessage.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.cupidapp.live.base.grpc.CuConnectorOuterClass$ConnectorMessage$Builder");
            }
        }

        public static Builder newBuilder(ConnectorMessage connectorMessage) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(connectorMessage);
        }

        public static ConnectorMessage parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        private ConnectorMessage() {
            this.memoizedIsInitialized = (byte) -1;
            this.type_ = 0;
            this.body_ = "";
        }

        public static ConnectorMessage parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ConnectorMessage) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static ConnectorMessage parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ConnectorMessage getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        public static ConnectorMessage parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static ConnectorMessage parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent);
        }

        public static ConnectorMessage parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        private ConnectorMessage(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            Objects.requireNonNull(extensionRegistryLite);
            UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
            boolean z10 = false;
            while (!z10) {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 8) {
                                this.messageId_ = codedInputStream.readUInt64();
                            } else if (readTag == 16) {
                                this.type_ = codedInputStream.readEnum();
                            } else if (readTag == 24) {
                                this.inReplyMessageId_ = codedInputStream.readUInt64();
                            } else if (readTag == 32) {
                                this.replyCode_ = codedInputStream.readUInt32();
                            } else if (readTag == 42) {
                                this.body_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag != 48) {
                                if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                                }
                            } else {
                                this.needAck_ = codedInputStream.readBool();
                            }
                        }
                        z10 = true;
                    } catch (InvalidProtocolBufferException e2) {
                        throw e2.setUnfinishedMessage(this);
                    } catch (IOException e10) {
                        throw new InvalidProtocolBufferException(e10).setUnfinishedMessage(this);
                    }
                } finally {
                    this.unknownFields = newBuilder.build();
                    makeExtensionsImmutable();
                }
            }
        }

        public static ConnectorMessage parseFrom(InputStream inputStream) throws IOException {
            return (ConnectorMessage) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static ConnectorMessage parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ConnectorMessage) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static ConnectorMessage parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (ConnectorMessage) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static ConnectorMessage parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ConnectorMessage) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface ConnectorMessageOrBuilder extends MessageOrBuilder {
        String getBody();

        ByteString getBodyBytes();

        long getInReplyMessageId();

        long getMessageId();

        boolean getNeedAck();

        int getReplyCode();

        MessageType getType();

        int getTypeValue();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public enum MessageType implements ProtocolMessageEnum {
        Heartbeat(0),
        Auth(1),
        Reconnect(2),
        ACK(4),
        RequestReply(3),
        NewGift(50),
        NewComment(51),
        NewNotify(52),
        LiveShowEnd(54),
        ViewerEnter(55),
        LiveBroadcast(56),
        MessageNew(57),
        MessageRead(58),
        MessageCancel(59),
        MessageDestroy(60),
        NewLiveConnectRequest(61),
        LiveConnectAccept(62),
        LiveConnectEnd(63),
        Activity1674(64),
        LiveConnectPushStreamStart(65),
        EnterGame(66),
        LeaveGame(67),
        GameServerConnect(68),
        ViewerLeave(69),
        GroupMessageNew(70),
        LiveShake(71),
        LivePkIconStatus(72),
        LivePkMatch(73),
        LivePkStart(74),
        LivePkUpdate(75),
        LivePkChat(76),
        LivePkEnd(77),
        PushMessage(78),
        LiveHorn(79),
        LivePkAppointRequest(80),
        LivePkAppointReject(81),
        LivePkCloseAudio(82),
        LivePkRandPaired(83),
        AnchorLvlUpgrade(84),
        AnchorLvlUpgradeAnimation(85),
        AnchorLvlExpChange(86),
        AnchorPrivilegeHint(87),
        AnchorPrivilegeInUse(88),
        AnchorPrivilegeLineUp(89),
        AnchorPrivilegeLineUnUse(90),
        LivePkFirstBlood(91),
        LivePkBackDoor(92),
        LiveLotteryCrit(93),
        MaskMatchRecPopover(94),
        MaskMatchSuccess(95),
        MaskMatchNewMessage(96),
        MaskMatchMessageRemove(97),
        MaskMatchNewSysTip(98),
        MaskMatchPlayDice(99),
        MaskMatchTyping(100),
        CanPlayNewRound(101),
        MaskMatchLeaveRoom(102),
        ShowUserCanSendImageGuide(103),
        LiveRoomElementChange(104),
        LotteryBattleStart(105),
        LotteryBattleEnd(106),
        DynamicGuide(107),
        UnreadCountsUpdate(108),
        MaskMatchOnHookPopup(109),
        AudioGameRequest(110),
        AudioGameQuestion(111),
        AudioGameLightMode(112),
        AudioGameNewSysTip(113),
        GameShowProfile(114),
        ClientUiElementChange(116),
        LiveRedPacket(117),
        MaskMatchDoublePlayRoleInfo(118),
        MaskMatchScriptTechnicalScore(119),
        AnchorProfileBorder(120),
        AnchorStarLevelChest(121),
        LiveKickOut(122),
        LiveRoomTag(123),
        AnchorStarLevelUpgradeAnimation(124),
        LiveMenuRedDot(125),
        LiveRoomAnimation(126),
        LiveStickerUpdate(127),
        LiveRocketAnimation(128),
        GroupMessageTop(129),
        GroupApplySubmit(130),
        GroupMessageCancel(131),
        StreamFollowProcessPie(132),
        NewVoiceRoomEnded(133),
        NewVoiceRoomComment(134),
        VoiceConnectApplyChange(135),
        VoiceConnectAnchorAgree(136),
        VoiceConnectUserJoinedRoom(137),
        VoiceConnectSuccess(138),
        VoiceConnectHangUp(139),
        VoiceConnectBalance(140),
        VoiceRoomOnlineInfo(141),
        VoiceConnectWait(142),
        VoiceRoomAnchorInfoChange(143),
        LiveHeatValueChange(144),
        ChatGuide(145),
        RefreshSession(146),
        LivePkMultiplayerStart(147),
        LivePkMultiplayerUpdate(148),
        LivePkMultiplayerInvited(149),
        LivePkMultiplayerInviteAgree(150),
        LivePkMultiplayerInviteRejected(151),
        LivePkMultiplayerChat(152),
        LivePkMultiplayerEnd(153),
        LivePkMultiplayerCloseAudio(154),
        LivePkMultiplayerFirstBlood(155),
        LivePkMultiplayerMixStreamDone(156),
        LivePkMultiplayerPrepareCancel(157),
        LivePkMultiplayerInviteCancel(158),
        UNRECOGNIZED(-1);

        public static final int ACK_VALUE = 4;
        public static final int Activity1674_VALUE = 64;
        public static final int AnchorLvlExpChange_VALUE = 86;
        public static final int AnchorLvlUpgradeAnimation_VALUE = 85;
        public static final int AnchorLvlUpgrade_VALUE = 84;
        public static final int AnchorPrivilegeHint_VALUE = 87;
        public static final int AnchorPrivilegeInUse_VALUE = 88;
        public static final int AnchorPrivilegeLineUnUse_VALUE = 90;
        public static final int AnchorPrivilegeLineUp_VALUE = 89;
        public static final int AnchorProfileBorder_VALUE = 120;
        public static final int AnchorStarLevelChest_VALUE = 121;
        public static final int AnchorStarLevelUpgradeAnimation_VALUE = 124;
        public static final int AudioGameLightMode_VALUE = 112;
        public static final int AudioGameNewSysTip_VALUE = 113;
        public static final int AudioGameQuestion_VALUE = 111;
        public static final int AudioGameRequest_VALUE = 110;
        public static final int Auth_VALUE = 1;
        public static final int CanPlayNewRound_VALUE = 101;
        public static final int ChatGuide_VALUE = 145;
        public static final int ClientUiElementChange_VALUE = 116;
        public static final int DynamicGuide_VALUE = 107;
        public static final int EnterGame_VALUE = 66;
        public static final int GameServerConnect_VALUE = 68;
        public static final int GameShowProfile_VALUE = 114;
        public static final int GroupApplySubmit_VALUE = 130;
        public static final int GroupMessageCancel_VALUE = 131;
        public static final int GroupMessageNew_VALUE = 70;
        public static final int GroupMessageTop_VALUE = 129;
        public static final int Heartbeat_VALUE = 0;
        public static final int LeaveGame_VALUE = 67;
        public static final int LiveBroadcast_VALUE = 56;
        public static final int LiveConnectAccept_VALUE = 62;
        public static final int LiveConnectEnd_VALUE = 63;
        public static final int LiveConnectPushStreamStart_VALUE = 65;
        public static final int LiveHeatValueChange_VALUE = 144;
        public static final int LiveHorn_VALUE = 79;
        public static final int LiveKickOut_VALUE = 122;
        public static final int LiveLotteryCrit_VALUE = 93;
        public static final int LiveMenuRedDot_VALUE = 125;
        public static final int LivePkAppointReject_VALUE = 81;
        public static final int LivePkAppointRequest_VALUE = 80;
        public static final int LivePkBackDoor_VALUE = 92;
        public static final int LivePkChat_VALUE = 76;
        public static final int LivePkCloseAudio_VALUE = 82;
        public static final int LivePkEnd_VALUE = 77;
        public static final int LivePkFirstBlood_VALUE = 91;
        public static final int LivePkIconStatus_VALUE = 72;
        public static final int LivePkMatch_VALUE = 73;
        public static final int LivePkMultiplayerChat_VALUE = 152;
        public static final int LivePkMultiplayerCloseAudio_VALUE = 154;
        public static final int LivePkMultiplayerEnd_VALUE = 153;
        public static final int LivePkMultiplayerFirstBlood_VALUE = 155;
        public static final int LivePkMultiplayerInviteAgree_VALUE = 150;
        public static final int LivePkMultiplayerInviteCancel_VALUE = 158;
        public static final int LivePkMultiplayerInviteRejected_VALUE = 151;
        public static final int LivePkMultiplayerInvited_VALUE = 149;
        public static final int LivePkMultiplayerMixStreamDone_VALUE = 156;
        public static final int LivePkMultiplayerPrepareCancel_VALUE = 157;
        public static final int LivePkMultiplayerStart_VALUE = 147;
        public static final int LivePkMultiplayerUpdate_VALUE = 148;
        public static final int LivePkRandPaired_VALUE = 83;
        public static final int LivePkStart_VALUE = 74;
        public static final int LivePkUpdate_VALUE = 75;
        public static final int LiveRedPacket_VALUE = 117;
        public static final int LiveRocketAnimation_VALUE = 128;
        public static final int LiveRoomAnimation_VALUE = 126;
        public static final int LiveRoomElementChange_VALUE = 104;
        public static final int LiveRoomTag_VALUE = 123;
        public static final int LiveShake_VALUE = 71;
        public static final int LiveShowEnd_VALUE = 54;
        public static final int LiveStickerUpdate_VALUE = 127;
        public static final int LotteryBattleEnd_VALUE = 106;
        public static final int LotteryBattleStart_VALUE = 105;
        public static final int MaskMatchDoublePlayRoleInfo_VALUE = 118;
        public static final int MaskMatchLeaveRoom_VALUE = 102;
        public static final int MaskMatchMessageRemove_VALUE = 97;
        public static final int MaskMatchNewMessage_VALUE = 96;
        public static final int MaskMatchNewSysTip_VALUE = 98;
        public static final int MaskMatchOnHookPopup_VALUE = 109;
        public static final int MaskMatchPlayDice_VALUE = 99;
        public static final int MaskMatchRecPopover_VALUE = 94;
        public static final int MaskMatchScriptTechnicalScore_VALUE = 119;
        public static final int MaskMatchSuccess_VALUE = 95;
        public static final int MaskMatchTyping_VALUE = 100;
        public static final int MessageCancel_VALUE = 59;
        public static final int MessageDestroy_VALUE = 60;
        public static final int MessageNew_VALUE = 57;
        public static final int MessageRead_VALUE = 58;
        public static final int NewComment_VALUE = 51;
        public static final int NewGift_VALUE = 50;
        public static final int NewLiveConnectRequest_VALUE = 61;
        public static final int NewNotify_VALUE = 52;
        public static final int NewVoiceRoomComment_VALUE = 134;
        public static final int NewVoiceRoomEnded_VALUE = 133;
        public static final int PushMessage_VALUE = 78;
        public static final int Reconnect_VALUE = 2;
        public static final int RefreshSession_VALUE = 146;
        public static final int RequestReply_VALUE = 3;
        public static final int ShowUserCanSendImageGuide_VALUE = 103;
        public static final int StreamFollowProcessPie_VALUE = 132;
        public static final int UnreadCountsUpdate_VALUE = 108;
        public static final int ViewerEnter_VALUE = 55;
        public static final int ViewerLeave_VALUE = 69;
        public static final int VoiceConnectAnchorAgree_VALUE = 136;
        public static final int VoiceConnectApplyChange_VALUE = 135;
        public static final int VoiceConnectBalance_VALUE = 140;
        public static final int VoiceConnectHangUp_VALUE = 139;
        public static final int VoiceConnectSuccess_VALUE = 138;
        public static final int VoiceConnectUserJoinedRoom_VALUE = 137;
        public static final int VoiceConnectWait_VALUE = 142;
        public static final int VoiceRoomAnchorInfoChange_VALUE = 143;
        public static final int VoiceRoomOnlineInfo_VALUE = 141;
        private final int value;
        private static final Internal.EnumLiteMap<MessageType> internalValueMap = new Internal.EnumLiteMap<MessageType>() { // from class: com.cupidapp.live.base.grpc.CuConnectorOuterClass.MessageType.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public MessageType findValueByNumber(int i10) {
                return MessageType.forNumber(i10);
            }
        };
        private static final MessageType[] VALUES = values();

        MessageType(int i10) {
            this.value = i10;
        }

        public static MessageType forNumber(int i10) {
            if (i10 == 0) {
                return Heartbeat;
            }
            if (i10 == 1) {
                return Auth;
            }
            if (i10 == 2) {
                return Reconnect;
            }
            if (i10 == 3) {
                return RequestReply;
            }
            if (i10 != 4) {
                switch (i10) {
                    case 50:
                        return NewGift;
                    case 51:
                        return NewComment;
                    case 52:
                        return NewNotify;
                    default:
                        switch (i10) {
                            case 54:
                                return LiveShowEnd;
                            case 55:
                                return ViewerEnter;
                            case 56:
                                return LiveBroadcast;
                            case 57:
                                return MessageNew;
                            case 58:
                                return MessageRead;
                            case 59:
                                return MessageCancel;
                            case 60:
                                return MessageDestroy;
                            case 61:
                                return NewLiveConnectRequest;
                            case 62:
                                return LiveConnectAccept;
                            case 63:
                                return LiveConnectEnd;
                            case 64:
                                return Activity1674;
                            case 65:
                                return LiveConnectPushStreamStart;
                            case 66:
                                return EnterGame;
                            case 67:
                                return LeaveGame;
                            case 68:
                                return GameServerConnect;
                            case 69:
                                return ViewerLeave;
                            case 70:
                                return GroupMessageNew;
                            case 71:
                                return LiveShake;
                            case 72:
                                return LivePkIconStatus;
                            case 73:
                                return LivePkMatch;
                            case 74:
                                return LivePkStart;
                            case 75:
                                return LivePkUpdate;
                            case 76:
                                return LivePkChat;
                            case 77:
                                return LivePkEnd;
                            case 78:
                                return PushMessage;
                            case 79:
                                return LiveHorn;
                            case 80:
                                return LivePkAppointRequest;
                            case 81:
                                return LivePkAppointReject;
                            case 82:
                                return LivePkCloseAudio;
                            case 83:
                                return LivePkRandPaired;
                            case 84:
                                return AnchorLvlUpgrade;
                            case 85:
                                return AnchorLvlUpgradeAnimation;
                            case 86:
                                return AnchorLvlExpChange;
                            case 87:
                                return AnchorPrivilegeHint;
                            case 88:
                                return AnchorPrivilegeInUse;
                            case 89:
                                return AnchorPrivilegeLineUp;
                            case 90:
                                return AnchorPrivilegeLineUnUse;
                            case 91:
                                return LivePkFirstBlood;
                            case 92:
                                return LivePkBackDoor;
                            case 93:
                                return LiveLotteryCrit;
                            case 94:
                                return MaskMatchRecPopover;
                            case 95:
                                return MaskMatchSuccess;
                            case 96:
                                return MaskMatchNewMessage;
                            case 97:
                                return MaskMatchMessageRemove;
                            case 98:
                                return MaskMatchNewSysTip;
                            case 99:
                                return MaskMatchPlayDice;
                            case 100:
                                return MaskMatchTyping;
                            case 101:
                                return CanPlayNewRound;
                            case 102:
                                return MaskMatchLeaveRoom;
                            case 103:
                                return ShowUserCanSendImageGuide;
                            case 104:
                                return LiveRoomElementChange;
                            case 105:
                                return LotteryBattleStart;
                            case 106:
                                return LotteryBattleEnd;
                            case 107:
                                return DynamicGuide;
                            case 108:
                                return UnreadCountsUpdate;
                            case 109:
                                return MaskMatchOnHookPopup;
                            case 110:
                                return AudioGameRequest;
                            case 111:
                                return AudioGameQuestion;
                            case 112:
                                return AudioGameLightMode;
                            case 113:
                                return AudioGameNewSysTip;
                            case 114:
                                return GameShowProfile;
                            default:
                                switch (i10) {
                                    case 116:
                                        return ClientUiElementChange;
                                    case 117:
                                        return LiveRedPacket;
                                    case 118:
                                        return MaskMatchDoublePlayRoleInfo;
                                    case 119:
                                        return MaskMatchScriptTechnicalScore;
                                    case 120:
                                        return AnchorProfileBorder;
                                    case 121:
                                        return AnchorStarLevelChest;
                                    case 122:
                                        return LiveKickOut;
                                    case 123:
                                        return LiveRoomTag;
                                    case 124:
                                        return AnchorStarLevelUpgradeAnimation;
                                    case 125:
                                        return LiveMenuRedDot;
                                    case 126:
                                        return LiveRoomAnimation;
                                    case 127:
                                        return LiveStickerUpdate;
                                    case 128:
                                        return LiveRocketAnimation;
                                    case 129:
                                        return GroupMessageTop;
                                    case 130:
                                        return GroupApplySubmit;
                                    case 131:
                                        return GroupMessageCancel;
                                    case 132:
                                        return StreamFollowProcessPie;
                                    case 133:
                                        return NewVoiceRoomEnded;
                                    case 134:
                                        return NewVoiceRoomComment;
                                    case 135:
                                        return VoiceConnectApplyChange;
                                    case 136:
                                        return VoiceConnectAnchorAgree;
                                    case 137:
                                        return VoiceConnectUserJoinedRoom;
                                    case 138:
                                        return VoiceConnectSuccess;
                                    case 139:
                                        return VoiceConnectHangUp;
                                    case 140:
                                        return VoiceConnectBalance;
                                    case 141:
                                        return VoiceRoomOnlineInfo;
                                    case 142:
                                        return VoiceConnectWait;
                                    case 143:
                                        return VoiceRoomAnchorInfoChange;
                                    case 144:
                                        return LiveHeatValueChange;
                                    case 145:
                                        return ChatGuide;
                                    case 146:
                                        return RefreshSession;
                                    case 147:
                                        return LivePkMultiplayerStart;
                                    case 148:
                                        return LivePkMultiplayerUpdate;
                                    case 149:
                                        return LivePkMultiplayerInvited;
                                    case 150:
                                        return LivePkMultiplayerInviteAgree;
                                    case 151:
                                        return LivePkMultiplayerInviteRejected;
                                    case 152:
                                        return LivePkMultiplayerChat;
                                    case 153:
                                        return LivePkMultiplayerEnd;
                                    case 154:
                                        return LivePkMultiplayerCloseAudio;
                                    case 155:
                                        return LivePkMultiplayerFirstBlood;
                                    case 156:
                                        return LivePkMultiplayerMixStreamDone;
                                    case 157:
                                        return LivePkMultiplayerPrepareCancel;
                                    case 158:
                                        return LivePkMultiplayerInviteCancel;
                                    default:
                                        return null;
                                }
                        }
                }
            }
            return ACK;
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return CuConnectorOuterClass.getDescriptor().getEnumTypes().get(0);
        }

        public static Internal.EnumLiteMap<MessageType> internalGetValueMap() {
            return internalValueMap;
        }

        @Override // com.google.protobuf.ProtocolMessageEnum
        public final Descriptors.EnumDescriptor getDescriptorForType() {
            return getDescriptor();
        }

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Override // com.google.protobuf.ProtocolMessageEnum
        public final Descriptors.EnumValueDescriptor getValueDescriptor() {
            if (this != UNRECOGNIZED) {
                return getDescriptor().getValues().get(ordinal());
            }
            throw new IllegalStateException("Can't get the descriptor of an unrecognized enum value.");
        }

        @Deprecated
        public static MessageType valueOf(int i10) {
            return forNumber(i10);
        }

        public static MessageType valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
            if (enumValueDescriptor.getType() == getDescriptor()) {
                if (enumValueDescriptor.getIndex() == -1) {
                    return UNRECOGNIZED;
                }
                return VALUES[enumValueDescriptor.getIndex()];
            }
            throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public enum ReplyCode implements ProtocolMessageEnum {
        Success(0),
        InternalServerError(1),
        InvalidParams(2),
        InvalidTicket(10),
        ExpiredTicket(11),
        UNRECOGNIZED(-1);

        public static final int ExpiredTicket_VALUE = 11;
        public static final int InternalServerError_VALUE = 1;
        public static final int InvalidParams_VALUE = 2;
        public static final int InvalidTicket_VALUE = 10;
        public static final int Success_VALUE = 0;
        private final int value;
        private static final Internal.EnumLiteMap<ReplyCode> internalValueMap = new Internal.EnumLiteMap<ReplyCode>() { // from class: com.cupidapp.live.base.grpc.CuConnectorOuterClass.ReplyCode.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public ReplyCode findValueByNumber(int i10) {
                return ReplyCode.forNumber(i10);
            }
        };
        private static final ReplyCode[] VALUES = values();

        ReplyCode(int i10) {
            this.value = i10;
        }

        public static ReplyCode forNumber(int i10) {
            if (i10 == 0) {
                return Success;
            }
            if (i10 == 1) {
                return InternalServerError;
            }
            if (i10 == 2) {
                return InvalidParams;
            }
            if (i10 == 10) {
                return InvalidTicket;
            }
            if (i10 != 11) {
                return null;
            }
            return ExpiredTicket;
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return CuConnectorOuterClass.getDescriptor().getEnumTypes().get(1);
        }

        public static Internal.EnumLiteMap<ReplyCode> internalGetValueMap() {
            return internalValueMap;
        }

        @Override // com.google.protobuf.ProtocolMessageEnum
        public final Descriptors.EnumDescriptor getDescriptorForType() {
            return getDescriptor();
        }

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Override // com.google.protobuf.ProtocolMessageEnum
        public final Descriptors.EnumValueDescriptor getValueDescriptor() {
            if (this != UNRECOGNIZED) {
                return getDescriptor().getValues().get(ordinal());
            }
            throw new IllegalStateException("Can't get the descriptor of an unrecognized enum value.");
        }

        @Deprecated
        public static ReplyCode valueOf(int i10) {
            return forNumber(i10);
        }

        public static ReplyCode valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
            if (enumValueDescriptor.getType() == getDescriptor()) {
                if (enumValueDescriptor.getIndex() == -1) {
                    return UNRECOGNIZED;
                }
                return VALUES[enumValueDescriptor.getIndex()];
            }
            throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        }
    }

    static {
        Descriptors.Descriptor descriptor2 = getDescriptor().getMessageTypes().get(0);
        internal_static_connector_ConnectorMessage_descriptor = descriptor2;
        internal_static_connector_ConnectorMessage_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor2, new String[]{"MessageId", "Type", "InReplyMessageId", "ReplyCode", "Body", "NeedAck"});
    }

    private CuConnectorOuterClass() {
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    public static void registerAllExtensions(ExtensionRegistry extensionRegistry) {
        registerAllExtensions((ExtensionRegistryLite) extensionRegistry);
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }
}

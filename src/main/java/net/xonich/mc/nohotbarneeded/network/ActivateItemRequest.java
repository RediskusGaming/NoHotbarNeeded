package net.xonich.mc.nohotbarneeded.network;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import io.netty.buffer.ByteBuf;

public class ActivateItemRequest implements IMessage {
    private int slotIdx = -1;

    /**
     * Ctor.
     * Required by network stack.
     */
    public ActivateItemRequest() {
    }

    /**
     * Ctor for convenience
     * @param slotIdx valid inventory slot index.
     */
    public ActivateItemRequest(int slotIdx) {
        this.slotIdx = slotIdx;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        slotIdx = buf.readInt();
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeInt(slotIdx);
    }

    public int slotIdx() {
        return slotIdx;
    }
}

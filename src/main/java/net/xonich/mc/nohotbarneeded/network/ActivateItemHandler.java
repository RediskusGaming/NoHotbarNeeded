package net.xonich.mc.nohotbarneeded.network;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.xonich.mc.nohotbarneeded.api.ActivatableFromInventoryServerSide;

public class ActivateItemHandler implements IMessageHandler<ActivateItemRequest, IMessage> {
    @Override
    public IMessage onMessage(ActivateItemRequest msg, MessageContext ctx) {
        EntityPlayerMP player = ctx.getServerHandler().playerEntity;

        int slotIdx = msg.slotIdx();
        ItemStack itemInSlot = player.inventory.getStackInSlot(slotIdx);

        if (itemInSlot!= null && itemInSlot.getItem() instanceof ActivatableFromInventoryServerSide item) {
            item.activateFromInventory(player, slotIdx);
        }
        return null;
    }
}

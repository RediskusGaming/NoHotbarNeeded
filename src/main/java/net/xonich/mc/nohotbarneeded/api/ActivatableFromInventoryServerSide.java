package net.xonich.mc.nohotbarneeded.api;

import net.minecraft.entity.player.EntityPlayerMP;

/**
 * Any {@link net.minecraft.item.Item} can implement this interface in order to be able activated
 * by pointing out with mouse and configured keyboard shortcut.
 *
 * Each item will define
 */
public interface ActivatableFromInventoryServerSide {
    /**
     * Trigger item usage
     */
    void activateFromInventory(EntityPlayerMP playerMP, int slotIdx);
}

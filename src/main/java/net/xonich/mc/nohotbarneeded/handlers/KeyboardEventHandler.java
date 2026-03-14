package net.xonich.mc.nohotbarneeded.handlers;

import codechicken.nei.NEIClientConfig;
import codechicken.nei.api.API;
import codechicken.nei.guihook.GuiContainerManager;
import codechicken.nei.guihook.IContainerInputHandler;
import cpw.mods.fml.client.registry.ClientRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.xonich.mc.nohotbarneeded.api.ActivatableFromInventoryServerSide;
import net.xonich.mc.nohotbarneeded.network.ActivateItemRequest;
import net.xonich.mc.nohotbarneeded.network.NetworkMessageService;
import org.lwjgl.input.Keyboard;

public class KeyboardEventHandler implements IContainerInputHandler {

    private static final String ACTIVATE_ITEM_EVENT = "gui.nohotbarneeded.activate_item";
    private final KeyBinding keyBinding;

    public KeyboardEventHandler() {
        GuiContainerManager.addInputHandler(this);

        keyBinding = new KeyBinding("Activate item in inventory", Keyboard.KEY_G, "Miscellaneous");

        ClientRegistry.registerKeyBinding(keyBinding);
    }

    @Override
    public boolean keyTyped(GuiContainer gui, char keyChar, int keyCode) {
        return false;
    }

    @Override
    public void onKeyTyped(GuiContainer gui, char keyChar, int keyID) {

    }

    @Override
    public boolean lastKeyTyped(GuiContainer gui, char keyChar, int keyID) {
        if (keyBinding.getKeyCode() == keyID) {
            Slot slot = GuiContainerManager.getSlotMouseOver(gui);
            int slotIdx = slot.getSlotIndex();

            EntityClientPlayerMP player = Minecraft.getMinecraft().thePlayer;

            // for some reason when player in creative mode slots on hotbar have 36+ indices
            // TODO handle this case
            if (slotIdx < 0 || slotIdx > 35) {
                return false;
            }

            if (slot.inventory == player.inventory) {
                ItemStack stack = slot.getStack();

                if (stack != null && stack.getItem() instanceof ActivatableFromInventoryServerSide) {
                    NetworkMessageService.getInstance().sentActivateItemMessage(new ActivateItemRequest(slot.getSlotIndex()));

                    return true;
                }
            }

        }
        return false;
    }

    @Override
    public boolean mouseClicked(GuiContainer gui, int mousex, int mousey, int button) {
        return false;
    }

    @Override
    public void onMouseClicked(GuiContainer gui, int mousex, int mousey, int button) {

    }

    @Override
    public void onMouseUp(GuiContainer gui, int mousex, int mousey, int button) {

    }

    @Override
    public boolean mouseScrolled(GuiContainer gui, int mousex, int mousey, int scrolled) {
        return false;
    }

    @Override
    public void onMouseScrolled(GuiContainer gui, int mousex, int mousey, int scrolled) {

    }

    @Override
    public void onMouseDragged(GuiContainer gui, int mousex, int mousey, int button, long heldTime) {

    }
}

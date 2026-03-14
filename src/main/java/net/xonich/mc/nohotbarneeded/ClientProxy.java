package net.xonich.mc.nohotbarneeded;

import net.xonich.mc.nohotbarneeded.handlers.KeyboardEventHandler;

import cpw.mods.fml.common.event.FMLInitializationEvent;

public class ClientProxy extends CommonProxy {

    private KeyboardEventHandler keyboardEventHandler;

    @Override
    public void init(FMLInitializationEvent event) {
        super.init(event);
        keyboardEventHandler = new KeyboardEventHandler();
    }
}

package net.xonich.mc.nohotbarneeded.network;

import net.xonich.mc.nohotbarneeded.NoHotbarNeeded;

import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;

/**
 * Service which handles client-server messages.
 */
public class NetworkMessageService {

    private static final NetworkMessageService INSTANCE = new NetworkMessageService();
    private final SimpleNetworkWrapper channel;

    public static NetworkMessageService getInstance() {
        return INSTANCE;
    }

    public NetworkMessageService() {
        channel = NetworkRegistry.INSTANCE.newSimpleChannel(NoHotbarNeeded.MODID);
        channel.registerMessage(ActivateItemHandler.class, ActivateItemRequest.class, 0, Side.SERVER);
    }

    public void sentActivateItemMessage(ActivateItemRequest msg) {
        channel.sendToServer(msg);
    }

}

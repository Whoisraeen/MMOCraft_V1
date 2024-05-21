package net.raeen.mmocraft.network;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.fml.network.NetworkEvent;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;
import net.raeen.mmocraft.MMOCraft;

import java.util.function.Supplier;

public class NetworkHandler {
    private static final String PROTOCOL_VERSION = "1";
    public static final SimpleChannel CHANNEL = NetworkRegistry.newSimpleChannel(
            new ResourceLocation(MMOCraft.MOD_ID, "network"),
            () -> PROTOCOL_VERSION,
            PROTOCOL_VERSION::equals,
            PROTOCOL_VERSION::equals
    );

    public static void registerMessages() {
        int id = 0;
        CHANNEL.registerMessage(id++, CheckModMessage.class, CheckModMessage::encode, CheckModMessage::decode, CheckModMessage::handle);
    }
}

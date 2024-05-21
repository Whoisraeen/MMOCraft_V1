package net.raeen.mmocraft.network;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.function.Supplier;

public class CheckModMessage {
    public CheckModMessage() {}

    public static void encode(CheckModMessage msg, FriendlyByteBuf buf) {
        // No data to encode
    }

    public static CheckModMessage decode(FriendlyByteBuf buf) {
        return new CheckModMessage();
    }

    public static void handle(CheckModMessage msg, Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            // This will be executed on the client side
            MMOCraft.LOGGER.info("Mod is installed on the client.");
        });
        ctx.get().setPacketHandled(true);
    }
}

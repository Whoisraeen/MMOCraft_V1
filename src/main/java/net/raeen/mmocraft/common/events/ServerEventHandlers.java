package net.raeen.mmocraft.events;

import net.minecraft.advancements.critereon.EntitySubPredicate;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.network.PacketDistributor;
import net.raeen.mmocraft.MMOCraft;
import net.raeen.mmocraft.network.CheckModMessage;
import net.raeen.mmocraft.network.NetworkHandler;

@Mod.EventBusSubscriber(modid = MMOCraft.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ServerEventHandlers {
    @SubscribeEvent
    public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
        if (event.getPlayer() instanceof ServerPlayer serverPlayer) {
            EntitySubPredicate.Types PacketDistributor;
            NetworkHandler.CHANNEL.send(PacketDistributor.PLAYER.with(() -> serverPlayer), new CheckModMessage());
        }
    }
}

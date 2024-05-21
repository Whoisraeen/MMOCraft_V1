package net.raeen.mmocraft.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = MMOCraft.MOD_ID, value = Dist.CLIENT)
public class AutoPathingHandler {

    private static Vec3 autoPathTarget = null;

    public static void setAutoPathTarget(Vec3 target) {
        autoPathTarget = target;
    }

    @SubscribeEvent
    public static void onClientTick(TickEvent.ClientTickEvent event) {
        if (autoPathTarget != null) {
            Minecraft mc = Minecraft.getInstance();
            LocalPlayer player = mc.player;
            if (player != null) {
                moveToLocation(player, autoPathTarget);
                if (player.position().distanceTo(autoPathTarget) < 1.0) {
                    autoPathTarget = null; // Reached target
                }
            }
        }
    }

    private static void moveToLocation(LocalPlayer player, Vec3 target) {
        // Implement pathfinding logic here
        Vec3 direction = target.subtract(player.position()).normalize();
        player.setDeltaMovement(direction.scale(0.1)); // Adjust speed as needed
    }
}

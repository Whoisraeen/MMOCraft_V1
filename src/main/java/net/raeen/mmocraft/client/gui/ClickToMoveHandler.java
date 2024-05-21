package net.raeen.mmocraft.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = MMOCraft.MOD_ID, value = Dist.CLIENT)
public class ClickToMoveHandler {

    @SubscribeEvent
    public static void onMouseClick(InputEvent.MouseInputEvent event) {
        if (event.getButton() == 0 && event.getAction() == 1) { // Left-click
            Minecraft mc = Minecraft.getInstance();
            LocalPlayer player = mc.player;
            if (player != null) {
                HitResult hitResult = mc.hitResult;
                if (hitResult != null && hitResult.getType() == HitResult.Type.BLOCK) {
                    Vec3 target = hitResult.getLocation();
                    moveToLocation(player, target);
                }
            }
        }
    }

    private static void moveToLocation(Player player, Vec3 target) {
        // Implement pathfinding logic here
        Vec3 direction = target.subtract(player.position()).normalize();
        player.setDeltaMovement(direction.scale(0.1)); // Adjust speed as needed
    }
}

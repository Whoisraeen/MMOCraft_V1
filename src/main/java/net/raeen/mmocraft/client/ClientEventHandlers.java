package net.raeen.mmocraft.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.raeen.mmocraft.client.gui.WelcomeScreen;
import net.raeen.mmocraft.client.gui.hud.MMOHud;

@Mod.EventBusSubscriber(modid = MMOCraft.MOD_ID, value = Dist.CLIENT)
public class ClientEventHandlers {

    @SubscribeEvent
    public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
        if (Minecraft.getInstance().player != null) {
            Minecraft.getInstance().setScreen(new WelcomeScreen());
        }
    }

    @SubscribeEvent
    public static void onRenderGameOverlay(RenderGameOverlayEvent.Post event) {
        if (event.getType() == RenderGameOverlayEvent.ElementType.ALL) {
            PoseStack poseStack = event.getMatrixStack();
            MMOHud.renderHud(poseStack);
        }
    }
}

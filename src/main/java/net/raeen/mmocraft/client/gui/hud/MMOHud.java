package net.raeen.mmocraft.client.gui.hud;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;

public class MMOHud {
    private static final ResourceLocation HUD_TEXTURE = new ResourceLocation(MMOCraft.MOD_ID, "textures/gui/hud/hud.png");

    public static void renderHud(PoseStack poseStack) {
        Minecraft mc = Minecraft.getInstance();
        int width = mc.getWindow().getGuiScaledWidth();
        int height = mc.getWindow().getGuiScaledHeight();

        RenderSystem.setShaderTexture(0, HUD_TEXTURE);
        // Draw health bar
        mc.gui.blit(poseStack, width / 2 - 91, height - 39, 0, 0, 182, 5);
        // Draw mana bar
        mc.gui.blit(poseStack, width / 2 - 91, height - 29, 0, 5, 182, 5);
        // Draw experience bar
        mc.gui.blit(poseStack, width / 2 - 91, height - 19, 0, 10, 182, 5);
    }
}

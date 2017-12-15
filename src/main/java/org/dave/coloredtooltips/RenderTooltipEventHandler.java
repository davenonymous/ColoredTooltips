package org.dave.coloredtooltips;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraftforge.client.event.RenderTooltipEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.dave.coloredtooltips.config.ConfigurationHandler;

import static net.minecraftforge.fml.client.config.GuiUtils.drawGradientRect;
public class RenderTooltipEventHandler {
    @SubscribeEvent
    public static void onRenderPre(RenderTooltipEvent.Pre event) {
        // Just move the original background render out of the way
        GlStateManager.pushMatrix();
        GlStateManager.translate(-1000.0f, -1000.0f, -1000.0f);
    }

    @SubscribeEvent
    public static void onRenderPost(RenderTooltipEvent.PostBackground event) {
        GlStateManager.popMatrix();

        int tooltipX = event.getX();
        int tooltipY = event.getY();
        int tooltipHeight = event.getHeight();
        int tooltipTextWidth = event.getWidth();

        final int zLevel = 300;
        final int backgroundColor = (int) ConfigurationHandler.Settings.getBackgroundColor();
        drawGradientRect(zLevel, tooltipX - 3, tooltipY - 4, tooltipX + tooltipTextWidth + 3, tooltipY - 3, backgroundColor, backgroundColor);
        drawGradientRect(zLevel, tooltipX - 3, tooltipY + tooltipHeight + 3, tooltipX + tooltipTextWidth + 3, tooltipY + tooltipHeight + 4, backgroundColor, backgroundColor);
        drawGradientRect(zLevel, tooltipX - 3, tooltipY - 3, tooltipX + tooltipTextWidth + 3, tooltipY + tooltipHeight + 3, backgroundColor, backgroundColor);
        drawGradientRect(zLevel, tooltipX - 4, tooltipY - 3, tooltipX - 3, tooltipY + tooltipHeight + 3, backgroundColor, backgroundColor);
        drawGradientRect(zLevel, tooltipX + tooltipTextWidth + 3, tooltipY - 3, tooltipX + tooltipTextWidth + 4, tooltipY + tooltipHeight + 3, backgroundColor, backgroundColor);
        final int borderColorStart = (int)ConfigurationHandler.Settings.getBorderColor();
        final int borderColorEnd = (borderColorStart & 0xFEFEFE) >> 1 | borderColorStart & 0xFF000000;
        drawGradientRect(zLevel, tooltipX - 3, tooltipY - 3 + 1, tooltipX - 3 + 1, tooltipY + tooltipHeight + 3 - 1, borderColorStart, borderColorEnd);
        drawGradientRect(zLevel, tooltipX + tooltipTextWidth + 2, tooltipY - 3 + 1, tooltipX + tooltipTextWidth + 3, tooltipY + tooltipHeight + 3 - 1, borderColorStart, borderColorEnd);
        drawGradientRect(zLevel, tooltipX - 3, tooltipY - 3, tooltipX + tooltipTextWidth + 3, tooltipY - 3 + 1, borderColorStart, borderColorStart);
        drawGradientRect(zLevel, tooltipX - 3, tooltipY + tooltipHeight + 2, tooltipX + tooltipTextWidth + 3, tooltipY + tooltipHeight + 3, borderColorEnd, borderColorEnd);
    }
}

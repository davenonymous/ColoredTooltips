package org.dave.coloredtooltips.config;

import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.fml.client.config.GuiConfig;
import org.dave.coloredtooltips.ColoredTooltips;

public class ConfigScreen extends GuiConfig {
    public ConfigScreen(GuiScreen parentScreen) {
        super(parentScreen, ConfigurationHandler.getConfigElements(), ColoredTooltips.MODID, false, false, "Colored Tooltips");
    }
}

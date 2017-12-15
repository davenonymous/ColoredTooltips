package org.dave.coloredtooltips;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.dave.coloredtooltips.config.ConfigurationHandler;

@Mod(
        modid = ColoredTooltips.MODID, version = ColoredTooltips.VERSION,
        guiFactory = ColoredTooltips.GUI_FACTORY,
        clientSideOnly = true
)
public class ColoredTooltips {
    public static final String MODID = "coloredtooltips";
    public static final String VERSION = "1.0";
    public static final String GUI_FACTORY = "org.dave.coloredtooltips.config.GuiFactory";

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        ConfigurationHandler.init(event.getSuggestedConfigurationFile());
        MinecraftForge.EVENT_BUS.register(new ConfigurationHandler());
        MinecraftForge.EVENT_BUS.register(RenderTooltipEventHandler.class);
    }
}

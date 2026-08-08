package com.fusionfixneo;

import org.slf4j.Logger;
import com.mojang.logging.LogUtils;
import net.neoforged.fml.common.Mod;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(FusionFixNeo.MODID)
public class FusionFixNeo {
    public static final String MODID = "fusionfixneo";
    public static final Logger LOGGER = LogUtils.getLogger();

    public FusionFixNeo() {
        LOGGER.info("FusionFix loaded — Intel Gen7 texture fix active");
    }
}
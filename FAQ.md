# FAQ

### Why is there no separate branch for Quilt?

FusionFix works on Quilt using the **exact same `.jar` file** as the Fabric version — no code changes were needed. Quilt runs Fabric mods directly through its built-in compatibility layer, and since MC 26.1+, Quilt uses the official Fabric API directly (no separate "Quilted Fabric API" fork exists anymore). Since there's no different code to maintain, a separate branch would just be a duplicate of the Fabric one. Just download the Fabric version and use it on Quilt as well.

### Do I need Fusion installed for this to do anything?

Yes. FusionFix does nothing on its own — it's a compatibility patch that only changes how [Fusion](https://modrinth.com/project/p19vrgc2) uploads its textures to the GPU. Without Fusion installed, this mod has nothing to fix.

### Will this fix textures for players who don't have this specific hardware issue?

No, and it shouldn't need to. If your GPU already renders Fusion's textures correctly, this mod changes nothing visible for you — it only replaces the upload method used for Intel Gen7 GPUs (HD Graphics 2500/4000).

### Why isn't this fix included in Fusion itself?

It was discussed directly with Fusion's author. The short version: the fix trades performance for compatibility (it uploads texture frames via CPU instead of letting the GPU handle it), and there's no reliable way for Fusion to detect *which* GPUs need the slower path without either guessing wrong sometimes or slowing down every user's game unnecessarily. Keeping it as a separate, optional addon avoids that trade-off for everyone else.

### I'm on NeoForge and the game crashes/says my mod file is invalid, but I didn't touch anything

As of writing, NeoForge support for Minecraft 26.2 is still in **beta**, and some instability (including mod-scanning crashes unrelated to any specific mod) has been observed independent of FusionFix. Make sure you're on the NeoForge version this mod's page lists as required; if the issue persists, it may be a NeoForge-side issue rather than this mod's.

### My textures are still black/invisible after installing this

A few things to check:
1. Confirm you actually have the Intel Gen7 driver issue — this fix is specific to that. Other black-texture causes exist and aren't related.
2. Confirm your Fusion version matches the range required (see this mod's page).
3. Update your Intel graphics driver — some visual issues on Gen7 GPUs are separate driver bugs unrelated to this fix (see [Sodium's driver compatibility notes](https://github.com/CaffeineMC/sodium/wiki/Driver-Compatibility#windows-intel-gen7) for reference, even if you don't use Sodium — the underlying driver bug is the same).
4. If none of that helps, open an issue with your `latest.log` attached.

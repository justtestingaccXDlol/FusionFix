# FusionFix

Fixes connected and animated textures from the [Fusion](https://modrinth.com/project/p19vrgc2) mod that render as **solid black** on Intel integrated GPUs with the Gen7 graphics architecture (e.g. HD Graphics 2500, HD Graphics 4000 — found in 3rd and 4th generation Intel Core processors).

**Requires [Fusion](https://modrinth.com/project/p19vrgc2) to be installed — this mod does nothing on its own.**

## Downloads by mod loader

This repository uses one branch per mod loader, since each requires a different build setup:

- **Fabric / Quilt** — [`fusionfix-fabric-1.0.0+26.2`](https://github.com/justtestingaccXDlol/FusionFix/tree/fusionfix-fabric-1.0.0+26.2) (same `.jar` works on both — see the FAQ)
- **NeoForge** — [`fusionfix-neoforge-1.0.0+26.2`](https://github.com/justtestingaccXDlol/FusionFix/tree/fusionfix-neoforge-1.0.0+26.2)

Prebuilt downloads are available on [Modrinth](https://modrinth.com/mod/SEU-SLUG-AQUI).

## The problem

On certain older Intel GPUs, Minecraft 26.2 has a known bug (reference: [MC-308593](https://bugs.mojang.com/browse/MC-308593)) where animated textures render black due to a driver incompatibility with the modern texture upload method (`copyBufferToTexture`). Fusion reimplements this same type of upload for its connected and scrolling textures, and suffers from the same problem — independently of the vanilla bug.

## What this mod does

Uses a mixin to redirect Fusion's texture upload to the older, more compatible method (`writeToTexture`), fixing the visual issue with no noticeable performance cost.

## Questions?

See the [FAQ](FAQ.md).

## Credits

Fix developed through investigation and bytecode reverse engineering of Fusion, with authorization from the original author ([SuperMartijn642](https://github.com/SuperMartijn642)) to publish this addon.

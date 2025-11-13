# AOSP SNTP BLOCKER (v1.0.0)

SNTP BLOCKER is a lightweight AOSP patch package that provides:
- OS-level app blocking (minimal Material dialog overlay)
- DNS UI lock (disables editing Private DNS while enabled)
- Settings integration (`Settings -> System -> SNTP BLOCKER`)

This repo contains:
- source skeletons (service, settings, systemui)
- patch placeholders
- CI helper to build AOSP with the patches (GitHub Actions)
- docs and contributor guide

**How to use (quick):**
1. Download or clone this repo.
2. Apply the patches located in `patches/` to a matching AOSP/Lineage source tree (see docs/patch_instructions.md).
3. Run the CI or build locally to create an emulator image including the feature.


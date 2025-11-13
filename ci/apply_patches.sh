#!/usr/bin/env bash
set -euo pipefail

AOSP_ROOT=${1:-"$HOME/aosp"}
WORKSPACE=${GITHUB_WORKSPACE:-$(pwd)}

echo "AOSP_ROOT: $AOSP_ROOT"
echo "Working repo: $WORKSPACE"

apply_patches_into_repo() {
  local patches_dir="$1"
  local target_repo="$2"
  echo "Applying patches in $patches_dir -> $target_repo"
  if [ ! -d "$target_repo" ]; then
    echo "ERROR: target repo not found: $target_repo"
    return 1
  fi
  for p in "$patches_dir"/*.patch; do
    [ -f "$p" ] || continue
    echo "Applying patch: $p"
    (cd "$target_repo" && git am --3way "$p") || {
      echo "git am failed for $p, attempting git apply fallback"
      (cd "$target_repo" && git apply --verbose "$p" && git add -A && git commit -m "Apply patch fallback: $(basename $p)") || {
        echo "Fallback apply failed for $p"; return 2;
      }
    }
  done
}

# Framework patches
apply_patches_into_repo "$WORKSPACE/patches/frameworks_base" "$AOSP_ROOT/frameworks/base"

# Settings patches
apply_patches_into_repo "$WORKSPACE/patches/packages_apps_Settings" "$AOSP_ROOT/packages/apps/Settings"

# SystemUI patches
apply_patches_into_repo "$WORKSPACE/patches/packages_apps_SystemUI" "$AOSP_ROOT/packages/apps/SystemUI"

# SEPolicy
apply_patches_into_repo "$WORKSPACE/patches/sepolicy" "$AOSP_ROOT/system/sepolicy"

echo "All patches applied (attempted)."

#!/bin/bash
# Usage: ./create_patch.sh <commit-ref>
git format-patch -1 "$1"

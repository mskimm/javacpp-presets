#!/bin/bash
# This file is meant to be included by the parent cppbuild.sh script
if [[ -z "$PLATFORM" ]]; then
    pushd ..
    bash cppbuild.sh "$@" annoy
    popd
    exit
fi

if [ ! -d annoy ]; then
   git clone https://github.com/spotify/annoy.git
   mkdir -p $PLATFORM
   cd $PLATFORM
   ln -s ../annoy/src include
fi

case $PLATFORM in
    linux-x86_64)
        ;;
    macosx-x86_64)
        ;;
    *)
        echo "Error: Platform \"$PLATFORM\" is not supported"
        ;;
esac

cd ../..

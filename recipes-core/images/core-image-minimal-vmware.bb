require recipes-core/images/core-image-minimal.bb

LICENSE = "MIT"

IMAGE_INSTALL:append = "vim"

COMPATIBLE_MACHINE = "vmware"


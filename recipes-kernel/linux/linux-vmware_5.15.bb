require recipes-kernel/linux/linux-yocto.inc

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://vmware.cfg"
SRC_URI[md5sum] = "17ac24a7b15df53c4dc9fd83ec034cf4"
SRC_URI[sha256sum] = "9c54ce6fea26c0cf0474190df56c19fed3b4cf0be465ed8004d488bfd95dfb86"

COMPATIBLE_MACHINE = "vmware|virtualbox"

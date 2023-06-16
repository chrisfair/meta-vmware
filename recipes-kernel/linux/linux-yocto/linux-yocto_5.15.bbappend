FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://vmware_defconfig"
SRC_URI[md5sum] = "17ac24a7b15df53c4dc9fd83ec034cf4"
SRC_URI[sha256sum] = "9c54ce6fea26c0cf0474190df56c19fed3b4cf0be465ed8004d488bfd95dfb86"

KERNEL_FEATURES:append = " vmware.scc"

KERNEL_FEATURES:remove = "cfg/x86.cfg"

COMPATIBLE_MACHINE = "vmware|virtualbox"

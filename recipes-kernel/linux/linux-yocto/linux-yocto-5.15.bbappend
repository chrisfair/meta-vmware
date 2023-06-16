FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://vmware_defconfig"

KERNEL_FEATURES:append = " features/vmware/vmware.scc"

KERNEL_FEATURES:remove = "cfg/x86.cfg"

COMPATIBLE_MACHINE = "vmware|virtualbox"

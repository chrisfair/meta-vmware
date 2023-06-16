FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://vmware_defconfig"

KERNEL_FEATURES_append = " features/vmware/vmware.scc"

KERNEL_FEATURES_remove = "cfg/x86.cfg"

COMPATIBLE_MACHINE = "vmware|virtualbox"

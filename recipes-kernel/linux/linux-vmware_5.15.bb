DESCRIPTION = "Custom Kernel for VMWARE Builds"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR};md5=0855555555"

inherit kernel


SRC_URI="git://github.com:torvalds/linux.git;branch=master"
SRCREV=8bb7eca972ad531c9b149c0a51ab43a417385813
FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"


COMPATIBLE_MACHINE = "vmware|virtualbox"
